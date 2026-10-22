package com.obric.livecard.api.impl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import com.google.gson.JsonObject;
import com.obric.livecard.api.IIslandCardCallback;
import com.obric.livecard.api.IIslandService;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.IslandTaskHandler;
import com.obric.livecard.api.LiveCard;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.exception.IslandUnsupportedException;
import com.obric.livecard.api.island.IslandApi;
import com.obric.livecard.api.island.IslandHideApi;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.sync.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001eB\u0007¢\u0006\u0004\bc\u0010dJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J*\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J#\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010!\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b!\u0010\"J\b\u0010#\u001a\u00020\nH\u0016J\b\u0010%\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010*\u001a\u00020\n2\u0006\u0010(\u001a\u00020'H\u0016J\u0018\u0010,\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0004H\u0016J\u001d\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020\nH\u0016J\u0010\u00100\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u00103\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00102\u001a\u000201H\u0016J\u0010\u00105\u001a\u00020\n2\u0006\u00104\u001a\u00020\u0013H\u0016J\u0010\u00106\u001a\u00020\n2\u0006\u00104\u001a\u00020\u0013H\u0016J\u0010\u00108\u001a\u00020\n2\u0006\u0010(\u001a\u000207H\u0016J\u0010\u00109\u001a\u00020\n2\u0006\u0010(\u001a\u000207H\u0016J\u0010\u0010<\u001a\u00020\n2\u0006\u0010;\u001a\u00020:H\u0016J\b\u0010=\u001a\u00020\nH\u0016J\b\u0010>\u001a\u00020\nH\u0016J\u0010\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u0013H\u0016J\u0010\u0010B\u001a\u00020\n2\u0006\u0010A\u001a\u00020\u0004H\u0016J\u0015\u0010C\u001a\u0004\u0018\u00010:H\u0086@ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\b\u0010E\u001a\u00020\nH\u0016R\u0018\u0010F\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR$\u0010K\u001a\u0010\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020J\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR#\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020N0M8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010UR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020^0]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020\u00198\u0002X\u0082D¢\u0006\u0006\n\u0004\ba\u0010b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006f"}, d2 = {"Lcom/obric/livecard/api/impl/IslandImpl;", "Lcom/obric/livecard/api/island/IslandApi;", "Lcom/obric/livecard/api/island/IslandHideApi;", "Lcom/obric/livecard/api/impl/OnLiveCardServiceDiedListener;", "", "nextSessionId", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "setLiveCardComponentName", "assertDialogueFeature", "assertCollapseNotificationFeature", "assertSceneFeature", "assertAudioAmplitudeFeature", "Lcom/obric/livecard/api/entity/IslandSession;", "session", "assertIdInvalid", "", "createSession", "destroySession", "targetSession", "Lcom/obric/livecard/api/entity/IslandWidget;", "targetWidget", "", "eventId", "jsonString", "sendEvent", "updateWidget", "updateAnimation", "(Lcom/obric/livecard/api/entity/IslandSession;Lcom/obric/livecard/api/entity/IslandWidget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canFrontShow", "tryExpand", "(Lcom/obric/livecard/api/entity/IslandSession;Ljava/lang/Boolean;)V", "collapseIsland", "", "getIslandVersion", "updateSessionFlags", "Lcom/obric/livecard/api/impl/OnTopCardChangedListener;", "callback", "addOnTopCardChangedListener", "removeOnTopCardChangedListener", "priority", "setPriority", "getPriority", "(Lcom/obric/livecard/api/entity/IslandSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collapseNotificationPanel", "refreshScene", "", "amplitudes", "updateAudioAmplitude", "visible", "onNotificationVisible", "setVisible", "Lcom/obric/livecard/api/impl/IslandStatusCallback;", "addIslandStatusCallback", "removeIslandStatusCallback", "Lcom/obric/livecard/api/IIslandService;", "service", "registerIslandService", "onVolumeButtonClick", "onLauncherFocused", "locked", "setKeyguardLocked", "sysuiFlags", "onSysUIFlagsChanged", "getService", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onServiceDied", "mService", "Lcom/obric/livecard/api/IIslandService;", "Lkotlin/Pair;", "Landroid/os/IBinder;", "Landroid/os/IBinder$DeathRecipient;", "currBinderDiedListener", "Lkotlin/Pair;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/livecard/api/IIslandCardCallback;", "mSessionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getMSessionMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlinx/coroutines/sync/a;", "sessionLock", "Lkotlinx/coroutines/sync/a;", "serviceLock", "Ljava/util/concurrent/atomic/AtomicLong;", "taskIdGen", "Ljava/util/concurrent/atomic/AtomicLong;", "Lcom/obric/livecard/api/IslandTaskHandler;", "islandTaskHandler", "Lcom/obric/livecard/api/IslandTaskHandler;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/livecard/api/impl/TopSessionChangedCallbackImpl;", "liveCardServiceDiedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "TAG", "Ljava/lang/String;", "<init>", "()V", "Companion", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1})
public final class IslandImpl implements IslandApi, IslandHideApi, OnLiveCardServiceDiedListener {
    public static final Companion Companion = null;
    public static final String LIVE_CARD_HOST = "com.android.systemui";
    public static final String LIVE_CARD_HOST_DEPRECATED = "com.obric.livecard";
    public static final String LIVE_CARD_PLUGIN = "com.obric.livecard.plugin";
    public static final String LIVE_CARD_SERVICE = "com.obric.livecard.port.LiveCardService";
    private final String TAG;
    private Pair<? extends IBinder, ? extends IBinder.DeathRecipient> currBinderDiedListener;
    private final IslandTaskHandler islandTaskHandler;
    private final CopyOnWriteArrayList<TopSessionChangedCallbackImpl> liveCardServiceDiedListeners;
    private volatile IIslandService mService;
    private final ConcurrentHashMap<IslandSession, IIslandCardCallback> mSessionMap;
    private final a serviceLock;
    private final a sessionLock;
    private final AtomicLong taskIdGen;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/livecard/api/impl/IslandImpl$Companion;", "", "()V", "LIVE_CARD_HOST", "", "LIVE_CARD_HOST_DEPRECATED", "LIVE_CARD_PLUGIN", "LIVE_CARD_SERVICE", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$getService$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl", f = "IslandImpl.kt", i = {0, 0, 1, 1, 2, 2}, l = {359, 370, 245}, m = "getService", n = {"this", "$this$withLock$iv", "this", "$this$withLock$iv", "this", "$this$withLock$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ IslandImpl this$0;

        public AnonymousClass1(IslandImpl r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= IntCompanionObject.MIN_VALUE;
            return this.this$0.getService(this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(IslandImpl r0) {
        registerIslandService$lambda$10$lambda$8(r0);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public int getIslandVersion() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        IIslandService r2 = this.mService;     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        Bundle r3 = r2.getIslandVersion();     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        int r4 = r3.getInt(EffectConfiguration.KEY_VERSION);     // Catch: Throwable -> L11
    L9:
        Object r5 = Result.constructor-impl(Integer.valueOf(r4));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == false) goto L16;
        r5 = null;
    L16:
        Integer r6 = (Integer) r5;
        if (r6 != null) goto L19;
        return 0;
    L19:
        return r6.intValue();
    L8:
        r4 = 0;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    private final void assertAudioAmplitudeFeature() throws IslandUnsupportedException {
        ILiveCard.Companion r0 = ILiveCard.Companion;
        ILiveCard r1 = r0.getInst();
        Application r2 = r0.getInst().getContext();
        Intrinsics.checkNotNull(r2);
        int r3 = r1.getVersion(r2);
        if (r3 < 10) goto L6;
        return;
    L6:
        throw new IslandUnsupportedException("This method requires the LiveCard version to be IslandVersionCode.AUDIO_AMPLITUDE_FEATURE, but the current version is " + r3);
    }

    private final void assertCollapseNotificationFeature() throws IslandUnsupportedException {
        ILiveCard.Companion r0 = ILiveCard.Companion;
        ILiveCard r1 = r0.getInst();
        Application r2 = r0.getInst().getContext();
        Intrinsics.checkNotNull(r2);
        int r3 = r1.getVersion(r2);
        if (r3 < 4) goto L6;
        return;
    L6:
        throw new IslandUnsupportedException("This method requires the LiveCard version to be IslandVersionCode.COLLAPSE_NOTIFICATION_FEATURE, but the current version is " + r3);
    }

    private final void assertDialogueFeature() throws IslandUnsupportedException {
        ILiveCard.Companion r0 = ILiveCard.Companion;
        ILiveCard r1 = r0.getInst();
        Application r2 = r0.getInst().getContext();
        Intrinsics.checkNotNull(r2);
        int r3 = r1.getVersion(r2);
        if (r3 < 3) goto L6;
        return;
    L6:
        throw new IslandUnsupportedException("This method requires the LiveCard version to be IslandVersionCode.DIALOGUE_FEATURE, but the current version is " + r3);
    }

    private final void assertSceneFeature() throws IslandUnsupportedException {
        ILiveCard.Companion r0 = ILiveCard.Companion;
        ILiveCard r1 = r0.getInst();
        Application r2 = r0.getInst().getContext();
        Intrinsics.checkNotNull(r2);
        int r3 = r1.getVersion(r2);
        if (r3 < 5) goto L6;
        return;
    L6:
        throw new IslandUnsupportedException("This method requires the LiveCard version to be IslandVersionCode.SCENE_FEATURE, but the current version is " + r3);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void collapseIsland() {
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, new collapseIsland.1(this, null), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void onLauncherFocused() {
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, new onLauncherFocused.1(this, null), 7, null);
    }

    @Override // com.obric.livecard.api.impl.OnLiveCardServiceDiedListener
    public void onServiceDied() {
        LiveCard.INSTANCE.setIslandVersion$LiveCard_sdk_release(null);
        this.mService = null;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new onServiceDied.1(this, null), 3, null);
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void onVolumeButtonClick() {
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, new onVolumeButtonClick.1(this, null), 7, null);
    }

    public IslandImpl() {
        this.mSessionMap = new ConcurrentHashMap();
        this.sessionLock = b.a();
        this.serviceLock = b.a();
        this.taskIdGen = new AtomicLong(0);
        this.islandTaskHandler = new IslandTaskHandler("LiveCard-IslandTaskThread", IslandImpl$islandTaskHandler$1.INSTANCE);
        this.liveCardServiceDiedListeners = new CopyOnWriteArrayList();
        this.TAG = "IslandApi";
    }

    private final long nextSessionId() {
    L2:
        long r0 = System.currentTimeMillis();
        long r2 = this.taskIdGen.get();
        if (r0 > r2) goto L6;
        r0 = 1 + r2;
    L6:
        if (this.taskIdGen.compareAndSet(r2, r0) == false) goto L2;
        return r0;
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void collapseNotificationPanel() {
        assertCollapseNotificationFeature();
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, new collapseNotificationPanel.1(this, null), 7, null);
    }

    public final ConcurrentHashMap<IslandSession, IIslandCardCallback> getMSessionMap() {
        return this.mSessionMap;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getLiveCardServiceDiedListeners$p(IslandImpl r0) {
        return r0.liveCardServiceDiedListeners;
    }

    public static final /* synthetic */ a access$getSessionLock$p(IslandImpl r0) {
        return r0.sessionLock;
    }

    public static final /* synthetic */ String access$getTAG$p(IslandImpl r0) {
        return r0.TAG;
    }

    private final void assertIdInvalid(IslandSession r5) throws IllegalStateException {
        if (r5.getTaskId() <= 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("createSession has not been called");
    }

    private static final void registerIslandService$lambda$10$lambda$8(IslandImpl r9) {
        Intrinsics.checkNotNullParameter(r9, "this$0");
        a r0 = r9.serviceLock;
        monitor-enter(r0);
        LiveCard.INSTANCE.setIslandVersion$LiveCard_sdk_release(null);     // Catch: Throwable -> L8
        r9.mService = null;     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new registerIslandService.1.2.2(r9, null), 3, null);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void addIslandStatusCallback(IslandStatusCallback r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, new addIslandStatusCallback.1(this, r9, null), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void addOnTopCardChangedListener(OnTopCardChangedListener r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, new addOnTopCardChangedListener.1(r9, this, null), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void destroySession(IslandSession r13) {
        Intrinsics.checkNotNullParameter(r13, "session");
        long r0 = r13.getTaskId();
        if (r0 > 0) goto L5;
    L7:
        IslandTaskHandler r5 = this.islandTaskHandler;
        Long r1 = Long.valueOf(r0);
        if (r1.longValue() <= 0) goto L10;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        Long r6 = r1;
    L15:
        IslandTaskHandler.enqueue$default(r5, r6, false, true, new destroySession.2(this, r13, null), 2, null);
        return;
    L14:
        r6 = null;
        goto L15
    L10:
        r2 = false;
        goto L12
    L5:
        if (this.islandTaskHandler.shouldSkipDestroy(r0) == false) goto L7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v7, types: [kotlinx.coroutines.sync.a] */
    public final Object getService(Continuation<? super IIslandService> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        a r3 = r0.label;
        boolean r5 = true;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L20;
        if (r3 != 3) goto L19;
        IslandImpl r4 = (IslandImpl) r0.L$2;
        a r6 = (a) r0.L$1;
        IslandImpl r7 = (IslandImpl) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L16
        a r8 = r6;
    L49:
        r4.mService = (IIslandService) r11;     // Catch: Throwable -> L16
        IslandImpl r9 = r7;
        r3 = r8;
    L51:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L16
        r3.unlock(null);
    L56:
        return r9.mService;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        a r13 = (a) r0.L$1;
        IslandImpl r14 = (IslandImpl) r0.L$0;
        ResultKt.throwOnFailure(r11);
        a r15 = r13;
    L44:
        if (r14.mService != null) goto L50;
        IslandImpl$getService$3$1 r16 = new IslandImpl$getService$3$1(r14, null);     // Catch: Throwable -> L16
        r0.L$0 = r14;     // Catch: Throwable -> L16
        r0.L$1 = r15;     // Catch: Throwable -> L16
        r0.L$2 = r14;     // Catch: Throwable -> L16
        r0.label = 3;     // Catch: Throwable -> L16
        r11 = TimeoutKt.c(3000, r16, r0);     // Catch: Throwable -> L16
        if (r11 != r2) goto L48;
        return r2;
    L48:
        r7 = r14;
        r4 = r7;
        r8 = r15;
        goto L49
    L50:
        r9 = r14;
        r3 = r15;
        goto L51
    L21:
        a r17 = (a) r0.L$1;
        r9 = (IslandImpl) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L60:
        IIslandService r18 = r9.mService;     // Catch: Throwable -> L57
        if (r18 == null) goto L33;
        IBinder r19 = r18.asBinder();     // Catch: Throwable -> L57
        if (r19 == null) goto L33;
        if (r19.isBinderAlive() == true) goto L33;
    L34:
        if (r5 == false) goto L36;
        LiveCard.INSTANCE.setIslandVersion$LiveCard_sdk_release(null);     // Catch: Throwable -> L57
        r9.mService = null;     // Catch: Throwable -> L57
    L36:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L57
        r17.unlock(null);
        if (r9.mService != null) goto L56;
        a r111 = r9.serviceLock;
        r0.L$0 = r9;
        r0.L$1 = r111;
        r0.label = 2;
        if (r111.a(null, r0) != r2) goto L42;
        return r2;
    L42:
        r15 = r111;
        r14 = r9;
    L33:
        r5 = false;
    L57:
        th = move-exception;
        r17.unlock(null);
        throw th;
    L22:
        ResultKt.throwOnFailure(r11);
        r17 = this.serviceLock;
        r0.L$0 = this;
        r0.L$1 = r17;
        r0.label = 1;
        if (r17.a(null, r0) != r2) goto L25;
        return r2;
    L25:
        r9 = this;
    L16:
        th = move-exception;
        r3.unlock(null);
        throw th;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void onNotificationVisible(boolean r8) {
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, new onNotificationVisible.1(this, r8, null), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void onSysUIFlagsChanged(long r8) {
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, new onSysUIFlagsChanged.1(this, r8, null), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void refreshScene(IslandSession r9) {
        Intrinsics.checkNotNullParameter(r9, "session");
        assertSceneFeature();
        assertIdInvalid(r9);
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, Long.valueOf(r9.getTaskId()), false, false, new refreshScene.1(this, r9, null), 6, null);
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void registerIslandService(IIslandService r6) {
        Intrinsics.checkNotNullParameter(r6, "service");
        a r0 = this.serviceLock;
        monitor-enter(r0);
        Pair<? extends IBinder, ? extends IBinder.DeathRecipient> r1 = this.currBinderDiedListener;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        ((IBinder) r1.getFirst()).unlinkToDeath((IBinder.DeathRecipient) r1.getSecond(), 0);     // Catch: Throwable -> L10
    L7:
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L10
        d r3 = new d(this);     // Catch: Throwable -> L10
        r6.asBinder().linkToDeath(r3, 0);     // Catch: Throwable -> L10
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L10
        this.currBinderDiedListener = new Pair(r2, r3);     // Catch: Throwable -> L10
        this.mService = r6;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void removeIslandStatusCallback(IslandStatusCallback r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, new removeIslandStatusCallback.1(this, r9, null), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void removeOnTopCardChangedListener(OnTopCardChangedListener r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, new removeOnTopCardChangedListener.1(this, r9, null), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void setKeyguardLocked(boolean r8) {
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, new setKeyguardLocked.1(this, r8, null), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void setVisible(boolean r8) {
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, new setVisible.1(this, r8, null), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void updateSessionFlags(IslandSession r10) {
        Intrinsics.checkNotNullParameter(r10, "session");
        long r0 = r10.getTaskId();
        IslandTaskHandler r2 = this.islandTaskHandler;
        Long r1 = Long.valueOf(r0);
        if (r1.longValue() <= 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L10;
        r1 = null;
    L10:
        IslandTaskHandler.enqueue$default(r2, r1, false, false, new updateSessionFlags.2(this, r10, null), 6, null);
        return;
    L5:
        r3 = false;
        goto L7
    }

    private final void setLiveCardComponentName(Context r8, Intent r9) {
        boolean r2 = true;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L16
        ServiceInfo[] r10 = r8.getPackageManager().getPackageInfo(LIVE_CARD_HOST, 4).services;     // Catch: Throwable -> L16
        boolean r4 = false;
        if (r10 == null) goto L14;
        int r5 = r10.length;     // Catch: Throwable -> L16
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L11;
        if (Intrinsics.areEqual(r10[r6].name, LIVE_CARD_SERVICE) == true) goto L9;
        r6 = r6 + 1;     // Catch: Throwable -> L16
        goto L6
    L9:
        boolean r11 = true;
    L12:
        if (r11 != true) goto L14;
        r4 = true;
        goto L14
    L11:
        r11 = false;
    L14:
        Object r12 = Result.constructor-impl(Boolean.valueOf(r4));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r12) == false) goto L21;
        r12 = null;
    L21:
        Boolean r13 = (Boolean) r12;
        if (r13 == null) goto L24;
        r2 = r13.booleanValue();
    L24:
        if (r2 == false) goto L26;
        r9.setClassName(LIVE_CARD_HOST, LIVE_CARD_SERVICE);
        return;
    L26:
        r9.setClassName(LIVE_CARD_HOST_DEPRECATED, "com.obric.livecard.port.IslandService");
        return;
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public boolean createSession(IslandSession r10, Context r11) {
        Intrinsics.checkNotNullParameter(r10, "session");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r12 = ILiveCard.Companion.getInst().getPackageName();
        if (r12 != null) goto L6;
        return false;
    L6:
        r10.setTaskId(nextSessionId());
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, Long.valueOf(r10.getTaskId()), true, false, new createSession.1(this, r10, r12, null), 4, null);
        return true;
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public Object getPriority(IslandSession r5, Continuation<? super Long> r6) {
        if ((r6 instanceof getPriority.1) == false) goto L7;
        getPriority.1 r0 = (getPriority.1) r6;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (IslandSession) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L17:
        IIslandService r8 = (IIslandService) r7;
        if (r8 == null) goto L22;
        Bundle r9 = r8.getPriority(r5);
        if (r9 == null) goto L22;
        return Boxing.boxLong(r9.getLong("priority"));
    L22:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        assertDialogueFeature();
        r0.L$0 = r5;
        r0.label = 1;
        r7 = getService(r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new getPriority.1(this, r6);
        goto L8
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void setPriority(IslandSession r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "session");
        if (r9 > System.currentTimeMillis()) goto L20;
        assertDialogueFeature();
        JsonObject r0 = r8.getExt();
        if (r0 != null) goto L7;
        r0 = new JsonObject();
    L7:
        r0.addProperty("updateTimestamp", Long.valueOf(r9));
        r8.setExt(r0);
        if (this.mSessionMap.get(r8) == null) goto L21;
        long r10 = r8.getTaskId();
        IslandTaskHandler r1 = this.islandTaskHandler;
        Long r11 = Long.valueOf(r10);
        if (r11.longValue() <= 0) goto L12;
        boolean r12 = true;
    L14:
        if (Boolean.valueOf(r12).booleanValue() == true) goto L17;
        r11 = null;
    L17:
        IslandTaskHandler.enqueue$default(r1, r11, false, false, new setPriority.2.2(this, r8, null), 6, null);
        return;
    L12:
        r12 = false;
        goto L14
    L21:
        return;
    L20:
        throw new IllegalArgumentException("priority > System.currentTimeMillis()");
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void tryExpand(IslandSession r9, Boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "targetSession");
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, Long.valueOf(r9.getTaskId()), false, false, new tryExpand.1(this, r9, r10, null), 6, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void updateAudioAmplitude(IslandSession r9, float r10) {
        Intrinsics.checkNotNullParameter(r9, "session");
        assertAudioAmplitudeFeature();
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, Long.valueOf(r9.getTaskId()), false, false, new updateAudioAmplitude.1(this, r9, r10, null), 6, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void updateWidget(IslandSession r9, IslandWidget r10) {
        Intrinsics.checkNotNullParameter(r9, "targetSession");
        Intrinsics.checkNotNullParameter(r10, "targetWidget");
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, Long.valueOf(r9.getTaskId()), false, false, new updateWidget.1(this, r9, r10, null), 6, null);
    }

    public static final /* synthetic */ void access$setLiveCardComponentName(IslandImpl r0, Context r1, Intent r2) {
        r0.setLiveCardComponentName(r1, r2);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public Object updateAnimation(IslandSession r9, IslandWidget r10, Continuation<? super Unit> r11) {
        Object r12 = IslandTaskHandler.enqueueAndAwait$default(this.islandTaskHandler, Boxing.boxLong(r9.getTaskId()), false, false, new updateAnimation.2(this, r9, r10, null), r11, 6, null);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void sendEvent(IslandSession r14, IslandWidget r15, String r16, String r17) {
        Intrinsics.checkNotNullParameter(r14, "targetSession");
        Intrinsics.checkNotNullParameter(r15, "targetWidget");
        Intrinsics.checkNotNullParameter(r16, "eventId");
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, Long.valueOf(r14.getTaskId()), false, false, new sendEvent.1(this, r14, r15, r16, r17, null), 6, null);
    }
}
