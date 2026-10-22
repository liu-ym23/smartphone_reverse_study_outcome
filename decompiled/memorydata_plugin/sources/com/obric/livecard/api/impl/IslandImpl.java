package com.obric.livecard.api.impl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.livecard.api.IIslandCardCallback;
import com.obric.livecard.api.IIslandService;
import com.obric.livecard.api.IIslandStatusCallback;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.ITopSessionChangedCallback;
import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.IslandTaskHandler;
import com.obric.livecard.api.LiveCard;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.exception.IslandUnsupportedException;
import com.obric.livecard.api.island.IslandApi;
import com.obric.livecard.api.island.IslandHideApi;
import com.obric.livecard.api.utils.LiveCardConstant;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.da;
import kotlinx.coroutines.i;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.sync.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0000\u0018\u0000 ]2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001]B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0014H\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\b\u0010)\u001a\u00020\u001eH\u0016J\b\u0010*\u001a\u00020\u001eH\u0016J\u0018\u0010+\u001a\u00020,2\u0006\u0010'\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0014H\u0016J\b\u00100\u001a\u000201H\u0016J\u001b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010'\u001a\u00020\u0014H\u0096@ø\u0001\u0000¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0004\u0018\u00010\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u00106J\b\u00107\u001a\u000203H\u0002J\b\u00108\u001a\u00020\u001eH\u0016J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020,H\u0016J\b\u0010;\u001a\u00020\u001eH\u0016J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u000203H\u0016J\b\u0010>\u001a\u00020\u001eH\u0016J\u0010\u0010?\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0014H\u0016J\u0010\u0010@\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020\u0011H\u0016J\u0010\u0010B\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010C\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\"H\u0016J*\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010J\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020,H\u0016J\u0018\u0010L\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010M\u001a\u00020NH\u0002J\u0018\u0010O\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u00142\u0006\u0010P\u001a\u000203H\u0016J\u0010\u0010Q\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020,H\u0016J\u001f\u0010R\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u00142\b\u0010S\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0002\u0010TJ!\u0010U\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020GH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010VJ\u0018\u0010W\u001a\u00020\u001e2\u0006\u0010X\u001a\u0002032\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0014H\u0016J\u0018\u0010\\\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020GH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006^"}, d2 = {"Lcom/obric/livecard/api/impl/IslandImpl;", "Lcom/obric/livecard/api/island/IslandApi;", "Lcom/obric/livecard/api/island/IslandHideApi;", "Lcom/obric/livecard/api/impl/OnLiveCardServiceDiedListener;", "()V", "TAG", "", "currBinderDiedListener", "Lkotlin/Pair;", "Landroid/os/IBinder;", "Landroid/os/IBinder$DeathRecipient;", "islandTaskHandler", "Lcom/obric/livecard/api/IslandTaskHandler;", "liveCardServiceDiedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/livecard/api/impl/TopSessionChangedCallbackImpl;", "mService", "Lcom/obric/livecard/api/IIslandService;", "mSessionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/livecard/api/entity/IslandSession;", "Lcom/obric/livecard/api/IIslandCardCallback;", "getMSessionMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "serviceLock", "Lkotlinx/coroutines/sync/Mutex;", "sessionLock", "taskIdGen", "Ljava/util/concurrent/atomic/AtomicLong;", "addIslandStatusCallback", "", "callback", "Lcom/obric/livecard/api/impl/IslandStatusCallback;", "addOnTopCardChangedListener", "Lcom/obric/livecard/api/impl/OnTopCardChangedListener;", "assertAudioAmplitudeFeature", "assertCollapseNotificationFeature", "assertDialogueFeature", "assertIdInvalid", "session", "assertSceneFeature", "collapseIsland", "collapseNotificationPanel", "createSession", "", "context", "Landroid/content/Context;", "destroySession", "getIslandVersion", "", "getPriority", "", "(Lcom/obric/livecard/api/entity/IslandSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getService", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nextSessionId", "onLauncherFocused", "onNotificationVisible", "visible", "onServiceDied", "onSysUIFlagsChanged", "sysuiFlags", "onVolumeButtonClick", "refreshScene", "registerIslandService", "service", "removeIslandStatusCallback", "removeOnTopCardChangedListener", "sendEvent", "targetSession", "targetWidget", "Lcom/obric/livecard/api/entity/IslandWidget;", "eventId", "jsonString", "setKeyguardLocked", "locked", "setLiveCardComponentName", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "setPriority", "priority", "setVisible", "tryExpand", "canFrontShow", "(Lcom/obric/livecard/api/entity/IslandSession;Ljava/lang/Boolean;)V", "updateAnimation", "(Lcom/obric/livecard/api/entity/IslandSession;Lcom/obric/livecard/api/entity/IslandWidget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAudioAmplitude", "taskId", "amplitudes", "", "updateSessionFlags", "updateWidget", "Companion", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IslandImpl implements OnLiveCardServiceDiedListener, IslandApi, IslandHideApi {
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

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$addIslandStatusCallback$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$addIslandStatusCallback$1", f = "IslandImpl.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ IslandStatusCallback $callback;
        int label;
        final /* synthetic */ IslandImpl this$0;

        AnonymousClass1(IslandImpl r3, IslandStatusCallback r4, Continuation<? super AnonymousClass1> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$callback = r4;
            super(1, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$callback, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L15;
            r6.addIIslandStatusCallback((IIslandStatusCallback) ZeusTransformUtils.preCheckCast(this.$callback, IIslandStatusCallback.class, "com.obric.memorydata.plugin"));
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IslandImpl r7 = this.this$0;
            Continuation<? super IIslandService> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$addOnTopCardChangedListener$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$addOnTopCardChangedListener$1", f = "IslandImpl.kt", i = {0}, l = {124}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240"}, s = {"L$2"})
    static final class C10711 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ OnTopCardChangedListener $callback;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10711(OnTopCardChangedListener r3, IslandImpl r4, Continuation<? super C10711> r5) {
            OnTopCardChangedListener r6 = (OnTopCardChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, OnTopCardChangedListener.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$callback = r6;
            this.this$0 = r4;
            super(1, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10711(this.$callback, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10711) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10711.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            TopSessionChangedCallbackImpl r2 = (TopSessionChangedCallbackImpl) ZeusTransformUtils.preCheckCast(this.L$2, TopSessionChangedCallbackImpl.class, "com.obric.memorydata.plugin");
            IslandImpl r3 = (IslandImpl) ZeusTransformUtils.preCheckCast(this.L$1, IslandImpl.class, "com.obric.memorydata.plugin");
            TopSessionChangedCallbackImpl r4 = (TopSessionChangedCallbackImpl) ZeusTransformUtils.preCheckCast(this.L$0, TopSessionChangedCallbackImpl.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r5);
        L12:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L15;
            r6.addOnTopCardChangedListener((ITopSessionChangedCallback) ZeusTransformUtils.preCheckCast(r2, ITopSessionChangedCallback.class, "com.obric.memorydata.plugin"));
        L15:
            IslandImpl.access$getLiveCardServiceDiedListeners$p(r3).add(r2);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            TopSessionChangedCallbackImpl r7 = new TopSessionChangedCallbackImpl(this.$callback);
            r3 = this.this$0;
            this.L$0 = r7;
            this.L$1 = r3;
            this.L$2 = r7;
            this.label = 1;
            Object r8 = r3.getService(this);
            if (r8 != r0) goto L11;
            return r0;
        L11:
            r2 = r7;
            r5 = r8;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$collapseIsland$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$collapseIsland$1", f = "IslandImpl.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    static final class C10721 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10721(IslandImpl r3, Continuation<? super C10721> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(1, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10721(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10721) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10721.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            IIslandService r4 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L15;
            r4.doCollapse();
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IslandImpl r6 = this.this$0;
            Continuation<? super IIslandService> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r6.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$collapseNotificationPanel$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$collapseNotificationPanel$1", f = "IslandImpl.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
    static final class C10731 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10731(IslandImpl r3, Continuation<? super C10731> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(1, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10731(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10731) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10731.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            IIslandService r4 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L15;
            r4.collapseNotificationPanel();
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IslandImpl r6 = this.this$0;
            Continuation<? super IIslandService> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r6.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$createSession$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$createSession$1", f = "IslandImpl.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
    static final class C10741 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $packageName;
        final /* synthetic */ IslandSession $session;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10741(IslandImpl r3, IslandSession r4, String r5, Continuation<? super C10741> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$session = r4;
            this.$packageName = r5;
            super(1, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10741(this.this$0, this.$session, this.$packageName, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10741) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10741.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L11:
            IIslandService r8 = (IIslandService) ZeusTransformUtils.preCheckCast(r7, IIslandService.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L15;
            r8.createSession(this.$session, this.$packageName, (IIslandCardCallback) ZeusTransformUtils.preCheckCast(this.this$0.getMSessionMap().get(this.$session), IIslandCardCallback.class, "com.obric.memorydata.plugin"));
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            ((Map) ZeusTransformUtils.preCheckCast(this.this$0.getMSessionMap(), Map.class, "com.obric.memorydata.plugin")).put(this.$session, new ClientCallback(this.$session));
            IslandImpl r9 = this.this$0;
            Continuation<? super IIslandService> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r7 = r9.getService(r2);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$destroySession$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$destroySession$2", f = "IslandImpl.kt", i = {}, l = {BDVideoUploaderBase.KeyIsEnableLogicalPart}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ IslandSession $session;
        int label;
        final /* synthetic */ IslandImpl this$0;

        AnonymousClass2(IslandImpl r3, IslandSession r4, Continuation<? super AnonymousClass2> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$session = r4;
            super(1, r6);
        }

        private static final boolean invokeSuspend$lambda$0(Function1 r2, Object r3) {
            return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        /* JADX INFO: renamed from: lambda$P5Qb-8EHuSDhP0YDgdn6hjoDF6E, reason: not valid java name */
        public static /* synthetic */ boolean m422lambda$P5Qb8EHuSDhP0YDgdn6hjoDF6E(Function1 r0, Object r1) {
            return invokeSuspend$lambda$0(r0, r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$session, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            IIslandService r7 = (IIslandService) ZeusTransformUtils.preCheckCast(r6, IIslandService.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L15;
            r7.destroySession(this.$session);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            Set<IslandSession> r8 = this.this$0.getMSessionMap().keySet();
            final IslandSession r4 = this.$session;
            final Function1 r2 = (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), Function1.class, "com.obric.memorydata.plugin");
            r8.removeIf(new $$Lambda$IslandImpl$destroySession$2$P5Qb8EHuSDhP0YDgdn6hjoDF6E(r2));
            IslandImpl r9 = this.this$0;
            Continuation<? super IIslandService> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r6 = r9.getService(r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$getPriority$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl", f = "IslandImpl.kt", i = {0}, l = {159}, m = "getPriority", n = {"session"}, s = {"L$0"})
    static final class C10751 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ IslandImpl this$0;

        C10751(IslandImpl r3, Continuation<? super C10751> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getPriority(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$getService$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl", f = "IslandImpl.kt", i = {0, 0, 1, 1, 2, 2}, l = {359, 370, 245}, m = "getService", n = {"this", "$this$withLock$iv", "this", "$this$withLock$iv", "this", "$this$withLock$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    static final class C10761 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ IslandImpl this$0;

        C10761(IslandImpl r3, Continuation<? super C10761> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getService((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$onLauncherFocused$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$onLauncherFocused$1", f = "IslandImpl.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
    static final class C10771 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10771(IslandImpl r3, Continuation<? super C10771> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(1, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10771(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10771) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10771.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L19
        L13:
            IIslandService r3 = (IIslandService) ZeusTransformUtils.preCheckCast(r4, IIslandService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            if (r3 == null) goto L16;
            r3.onLauncherFocused();     // Catch: Throwable -> L19
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L19
        L17:
            Result.m1421constructorimpl(r5);     // Catch: Throwable -> L19
        L22:
            return Unit.INSTANCE;
        L16:
            r5 = null;
            goto L17
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r4);
            IslandImpl r6 = this.this$0;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L19
            this.label = 1;     // Catch: Throwable -> L19
            r4 = r6.getService(this);     // Catch: Throwable -> L19
            if (r4 != r0) goto L13;
            return r0;
        L19:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L22
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$onNotificationVisible$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$onNotificationVisible$1", f = "IslandImpl.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
    static final class C10781 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $visible;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10781(IslandImpl r3, boolean r4, Continuation<? super C10781> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$visible = r4;
            super(1, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10781(this.this$0, this.$visible, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10781) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10781.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L15;
            r6.onNotificationVisible(this.$visible);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IslandImpl r7 = this.this$0;
            Continuation<? super IIslandService> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$onServiceDied$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$onServiceDied$1", f = "IslandImpl.kt", i = {0}, l = {359}, m = "invokeSuspend", n = {"$this$withLock$iv"}, s = {"L$0"})
    static final class C10791 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10791(IslandImpl r3, Continuation<? super C10791> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10791(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10791) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10791.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            IslandImpl r2 = (IslandImpl) ZeusTransformUtils.preCheckCast(this.L$1, IslandImpl.class, "com.obric.memorydata.plugin");
            a r3 = (a) ZeusTransformUtils.preCheckCast(this.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r9);
        L28:
            Iterator r10 = ((Map) ZeusTransformUtils.preCheckCast(r2.getMSessionMap(), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();     // Catch: Throwable -> L25
        L14:
            if (r10.hasNext() == false) goto L18;
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
            IslandCardCallback r6 = ((IslandSession) ZeusTransformUtils.preCheckCast(r5.getKey(), IslandSession.class, "com.obric.memorydata.plugin")).getCallback();     // Catch: Throwable -> L25
            if (r6 == null) goto L14;
            r6.onSessionDestroy((IslandSession) ZeusTransformUtils.preCheckCast(r5.getKey(), IslandSession.class, "com.obric.memorydata.plugin"), Boxing.boxInt(1));     // Catch: Throwable -> L25
            goto L14
        L18:
            r2.getMSessionMap().clear();     // Catch: Throwable -> L25
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L25
            r3.b(null);
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(IslandImpl.access$getLiveCardServiceDiedListeners$p(this.this$0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L21:
            if (r12.hasNext() == false) goto L23;
            ((TopSessionChangedCallbackImpl) ZeusTransformUtils.preCheckCast(r12.next(), TopSessionChangedCallbackImpl.class, "com.obric.memorydata.plugin")).onServiceDied();
            goto L21
        L23:
            IslandImpl.access$getLiveCardServiceDiedListeners$p(this.this$0).clear();
            return Unit.INSTANCE;
        L25:
            th = move-exception;
            r3.b(null);
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            r3 = IslandImpl.access$getSessionLock$p(this.this$0);
            IslandImpl r13 = this.this$0;
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r3;
            this.L$1 = r13;
            this.label = 1;
            if (r3.a(null, r7) != r0) goto L11;
            return r0;
        L11:
            r2 = r13;
            goto L28
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$onSysUIFlagsChanged$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$onSysUIFlagsChanged$1", f = "IslandImpl.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
    static final class C10801 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ long $sysuiFlags;
        long J$0;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10801(IslandImpl r3, long r4, Continuation<? super C10801> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$sysuiFlags = r4;
            super(1, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10801(this.this$0, this.$sysuiFlags, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10801) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10801.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            long r2 = this.J$0;
            ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L21
        L15:
            IIslandService r5 = (IIslandService) ZeusTransformUtils.preCheckCast(r6, IIslandService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
            if (r5 == null) goto L18;
            r5.onSysUIFlagsChanged(r2);     // Catch: Throwable -> L21
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L21
        L19:
            Result.m1421constructorimpl(r7);     // Catch: Throwable -> L21
        L24:
            return Unit.INSTANCE;
        L18:
            r7 = null;
            goto L19
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r6);
            IslandImpl r8 = this.this$0;
            long r3 = this.$sysuiFlags;
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L21
            this.J$0 = r3;     // Catch: Throwable -> L21
            this.label = 1;     // Catch: Throwable -> L21
            r6 = r8.getService(this);     // Catch: Throwable -> L21
            if (r6 != r0) goto L14;
            return r0;
        L14:
            r2 = r3;
        L21:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L24
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$onVolumeButtonClick$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$onVolumeButtonClick$1", f = "IslandImpl.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
    static final class C10811 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10811(IslandImpl r3, Continuation<? super C10811> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(1, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10811(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10811) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10811.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L19
        L13:
            IIslandService r3 = (IIslandService) ZeusTransformUtils.preCheckCast(r4, IIslandService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            if (r3 == null) goto L16;
            r3.onVolumeButtonClick();     // Catch: Throwable -> L19
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L19
        L17:
            Result.m1421constructorimpl(r5);     // Catch: Throwable -> L19
        L22:
            return Unit.INSTANCE;
        L16:
            r5 = null;
            goto L17
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r4);
            IslandImpl r6 = this.this$0;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L19
            this.label = 1;     // Catch: Throwable -> L19
            r4 = r6.getService(this);     // Catch: Throwable -> L19
            if (r4 != r0) goto L13;
            return r0;
        L19:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L22
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$refreshScene$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$refreshScene$1", f = "IslandImpl.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
    static final class C10821 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ IslandSession $session;
        Object L$0;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10821(IslandImpl r3, IslandSession r4, Continuation<? super C10821> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$session = r4;
            super(1, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10821(this.this$0, this.$session, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10821) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10821.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            IslandSession r5 = (IslandSession) ZeusTransformUtils.preCheckCast(this.L$0, IslandSession.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L21
        L15:
            IIslandService r7 = (IIslandService) ZeusTransformUtils.preCheckCast(r6, IIslandService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
            if (r7 == null) goto L18;
            r7.refreshScene(r5);     // Catch: Throwable -> L21
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L21
        L19:
            Result.m1421constructorimpl(r8);     // Catch: Throwable -> L21
        L24:
            return Unit.INSTANCE;
        L18:
            r8 = null;
            goto L19
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r6);
            IslandImpl r9 = this.this$0;
            IslandSession r2 = this.$session;
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L21
            this.L$0 = r2;     // Catch: Throwable -> L21
            this.label = 1;     // Catch: Throwable -> L21
            r6 = r9.getService(this);     // Catch: Throwable -> L21
            if (r6 != r0) goto L14;
            return r0;
        L14:
            r5 = r2;
        L21:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L24
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$removeIslandStatusCallback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$removeIslandStatusCallback$1", f = "IslandImpl.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
    static final class C10831 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ IslandStatusCallback $callback;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10831(IslandImpl r3, IslandStatusCallback r4, Continuation<? super C10831> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$callback = r4;
            super(1, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10831(this.this$0, this.$callback, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10831) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10831.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L15;
            r6.removeIIslandStatusCallback((IIslandStatusCallback) ZeusTransformUtils.preCheckCast(this.$callback, IIslandStatusCallback.class, "com.obric.memorydata.plugin"));
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IslandImpl r7 = this.this$0;
            Continuation<? super IIslandService> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$removeOnTopCardChangedListener$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$removeOnTopCardChangedListener$1", f = "IslandImpl.kt", i = {0}, l = {133}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
    static final class C10841 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ OnTopCardChangedListener $callback;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10841(IslandImpl r3, OnTopCardChangedListener r4, Continuation<? super C10841> r5) {
            OnTopCardChangedListener r6 = (OnTopCardChangedListener) ZeusTransformUtils.wrapperContextForParams(r4, OnTopCardChangedListener.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$callback = r6;
            super(1, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10841(this.this$0, this.$callback, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10841) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10841.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            TopSessionChangedCallbackImpl r2 = (TopSessionChangedCallbackImpl) ZeusTransformUtils.preCheckCast(this.L$1, TopSessionChangedCallbackImpl.class, "com.obric.memorydata.plugin");
            IslandImpl r6 = (IslandImpl) ZeusTransformUtils.preCheckCast(this.L$0, IslandImpl.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r7);
        L21:
            IIslandService r8 = (IIslandService) ZeusTransformUtils.preCheckCast(r7, IIslandService.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L24;
            r8.removeOnTopCardChangedListener((ITopSessionChangedCallback) ZeusTransformUtils.preCheckCast(r2, ITopSessionChangedCallback.class, "com.obric.memorydata.plugin"));
        L24:
            IslandImpl.access$getLiveCardServiceDiedListeners$p(r6).remove(r2);
        L26:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(IslandImpl.access$getLiveCardServiceDiedListeners$p(this.this$0), Iterable.class, "com.obric.memorydata.plugin");
            OnTopCardChangedListener r3 = this.$callback;
            Iterator r10 = r9.iterator();
        L10:
            if (r10.hasNext() == false) goto L14;
            Object r4 = r10.next();
            if (Intrinsics.areEqual(((TopSessionChangedCallbackImpl) ZeusTransformUtils.preCheckCast(r4, TopSessionChangedCallbackImpl.class, "com.obric.memorydata.plugin")).getDelegate(), r3) == false) goto L10;
        L15:
            TopSessionChangedCallbackImpl r11 = (TopSessionChangedCallbackImpl) ZeusTransformUtils.preCheckCast(r4, TopSessionChangedCallbackImpl.class, "com.obric.memorydata.plugin");
            if (r11 == null) goto L26;
            IslandImpl r5 = this.this$0;
            this.L$0 = r5;
            this.L$1 = r11;
            this.label = 1;
            Object r12 = r5.getService(this);
            if (r12 != r0) goto L20;
            return r0;
        L20:
            r2 = r11;
            r7 = r12;
            r6 = r5;
            goto L21
        L14:
            r4 = null;
            goto L15
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$sendEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$sendEvent$1", f = "IslandImpl.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    static final class C10851 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $eventId;
        final /* synthetic */ String $jsonString;
        final /* synthetic */ IslandSession $targetSession;
        final /* synthetic */ IslandWidget $targetWidget;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10851(IslandImpl r3, IslandSession r4, IslandWidget r5, String r6, String r7, Continuation<? super C10851> r8) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$targetSession = r4;
            this.$targetWidget = r5;
            this.$eventId = r6;
            this.$jsonString = r7;
            super(1, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r10) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10851(this.this$0, this.$targetSession, this.$targetWidget, this.$eventId, this.$jsonString, r8), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10851) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10851.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L15;
            r6.sendEvent(this.$targetSession, this.$targetWidget, this.$eventId, this.$jsonString);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IslandImpl r7 = this.this$0;
            Continuation<? super IIslandService> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$setKeyguardLocked$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$setKeyguardLocked$1", f = "IslandImpl.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
    static final class C10861 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $locked;
        boolean Z$0;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10861(IslandImpl r3, boolean r4, Continuation<? super C10861> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$locked = r4;
            super(1, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10861(this.this$0, this.$locked, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10861) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10861.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            boolean r4 = this.Z$0;
            ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L24
        L15:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
            if (r6 == null) goto L21;
            if (r4 == true) goto L20;
            r2 = false;
        L20:
            r6.setKeyguardLocked(r2);     // Catch: Throwable -> L24
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L24
        L22:
            Result.m1421constructorimpl(r7);     // Catch: Throwable -> L24
        L27:
            return Unit.INSTANCE;
        L21:
            r7 = null;
            goto L22
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r5);
            IslandImpl r8 = this.this$0;
            boolean r3 = this.$locked;
            Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L24
            this.Z$0 = r3;     // Catch: Throwable -> L24
            this.label = 1;     // Catch: Throwable -> L24
            r5 = r8.getService(this);     // Catch: Throwable -> L24
            if (r5 != r0) goto L14;
            return r0;
        L14:
            r4 = r3;
        L24:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L27
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$setVisible$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$setVisible$1", f = "IslandImpl.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {})
    static final class C10871 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $visible;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10871(IslandImpl r3, boolean r4, Continuation<? super C10871> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$visible = r4;
            super(1, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10871(this.this$0, this.$visible, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10871) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10871.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L15;
            r6.setVisible(this.$visible);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IslandImpl r7 = this.this$0;
            Continuation<? super IIslandService> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$tryExpand$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$tryExpand$1", f = "IslandImpl.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    static final class C10881 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Boolean $canFrontShow;
        final /* synthetic */ IslandSession $targetSession;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10881(IslandImpl r3, IslandSession r4, Boolean r5, Continuation<? super C10881> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$targetSession = r4;
            this.$canFrontShow = r5;
            super(1, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10881(this.this$0, this.$targetSession, this.$canFrontShow, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10881) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10881.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L22;
            IslandSession r2 = this.$targetSession;
            Boolean r4 = this.$canFrontShow;
            if (r4 == null) goto L16;
        L15:
            boolean r7 = r4.booleanValue();
        L20:
            r6.tryExpand(r2, r7);
            goto L22
        L16:
            r4 = r2.getCanFrontShow();
            if (r4 != null) goto L15;
            r7 = false;
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IslandImpl r8 = this.this$0;
            Continuation<? super IIslandService> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r8.getService(r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$updateAnimation$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$updateAnimation$2", f = "IslandImpl.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
    static final class C10892 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ IslandSession $targetSession;
        final /* synthetic */ IslandWidget $targetWidget;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10892(IslandImpl r3, IslandSession r4, IslandWidget r5, Continuation<? super C10892> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$targetSession = r4;
            this.$targetWidget = r5;
            super(1, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10892(this.this$0, this.$targetSession, this.$targetWidget, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10892) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10892.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L15;
            r6.updateWidgetAnimation(this.$targetSession, this.$targetWidget);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IslandImpl r7 = this.this$0;
            Continuation<? super IIslandService> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$updateAudioAmplitude$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$updateAudioAmplitude$1", f = "IslandImpl.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
    static final class C10901 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ float $amplitudes;
        final /* synthetic */ long $taskId;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10901(IslandImpl r3, long r4, float r6, Continuation<? super C10901> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$taskId = r4;
            this.$amplitudes = r6;
            super(1, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r9) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10901(this.this$0, this.$taskId, this.$amplitudes, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10901) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10901.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L15;
            r6.updateAudioAmplitude(this.$taskId, this.$amplitudes);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IslandImpl r7 = this.this$0;
            Continuation<? super IIslandService> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$updateSessionFlags$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$updateSessionFlags$2", f = "IslandImpl.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
    static final class C10912 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ IslandSession $session;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10912(IslandImpl r3, IslandSession r4, Continuation<? super C10912> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$session = r4;
            super(1, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10912(this.this$0, this.$session, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10912) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10912.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L15;
            r6.updateSessionFlags(this.$session);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IslandImpl r7 = this.this$0;
            Continuation<? super IIslandService> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$updateWidget$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$updateWidget$1", f = "IslandImpl.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    static final class C10921 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ IslandSession $targetSession;
        final /* synthetic */ IslandWidget $targetWidget;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C10921(IslandImpl r3, IslandSession r4, IslandWidget r5, Continuation<? super C10921> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$targetSession = r4;
            this.$targetWidget = r5;
            super(1, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10921(this.this$0, this.$targetSession, this.$targetWidget, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((C10921) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10921.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L15;
            r6.updateWidget(this.$targetSession, this.$targetWidget);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IslandImpl r7 = this.this$0;
            Continuation<? super IIslandService> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public IslandImpl() {
        this.mSessionMap = new ConcurrentHashMap();
        this.sessionLock = c.a(false, 1, null);
        this.serviceLock = c.a(false, 1, null);
        this.taskIdGen = new AtomicLong(0);
        this.islandTaskHandler = new IslandTaskHandler("LiveCard-IslandTaskThread", (Function2) ZeusTransformUtils.preCheckCast(IslandImpl$islandTaskHandler$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin"));
        this.liveCardServiceDiedListeners = new CopyOnWriteArrayList();
        this.TAG = "IslandApi";
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

    public static final /* synthetic */ void access$setLiveCardComponentName(IslandImpl r2, Context r3, Intent r4) {
        r2.setLiveCardComponentName((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void assertAudioAmplitudeFeature() {
        ILiveCard r3 = ILiveCard.Companion.getInst();
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ILiveCard.Companion.getInst().getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r0);
        int r4 = r3.getVersion((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin"));
        if (r4 < 10) goto L6;
        return;
    L6:
        throw new IslandUnsupportedException("This method requires the LiveCard version to be IslandVersionCode.AUDIO_AMPLITUDE_FEATURE, but the current version is " + r4);
    }

    private final void assertCollapseNotificationFeature() {
        ILiveCard r3 = ILiveCard.Companion.getInst();
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ILiveCard.Companion.getInst().getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r0);
        int r4 = r3.getVersion((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin"));
        if (r4 < 4) goto L6;
        return;
    L6:
        throw new IslandUnsupportedException("This method requires the LiveCard version to be IslandVersionCode.COLLAPSE_NOTIFICATION_FEATURE, but the current version is " + r4);
    }

    private final void assertDialogueFeature() {
        ILiveCard r3 = ILiveCard.Companion.getInst();
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ILiveCard.Companion.getInst().getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r0);
        int r4 = r3.getVersion((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin"));
        if (r4 < 3) goto L6;
        return;
    L6:
        throw new IslandUnsupportedException("This method requires the LiveCard version to be IslandVersionCode.DIALOGUE_FEATURE, but the current version is " + r4);
    }

    private final void assertIdInvalid(IslandSession r3) {
        if (r3.getTaskId() <= 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("createSession has not been called");
    }

    private final void assertSceneFeature() {
        ILiveCard r3 = ILiveCard.Companion.getInst();
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ILiveCard.Companion.getInst().getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r0);
        int r4 = r3.getVersion((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin"));
        if (r4 < 5) goto L6;
        return;
    L6:
        throw new IslandUnsupportedException("This method requires the LiveCard version to be IslandVersionCode.SCENE_FEATURE, but the current version is " + r4);
    }

    /* JADX INFO: renamed from: lambda$d-oYqOSFZMrZuitapGz2CRkcdlg, reason: not valid java name */
    public static /* synthetic */ void m421lambda$doYqOSFZMrZuitapGz2CRkcdlg(IslandImpl r0) {
        registerIslandService$lambda$10$lambda$8(r0);
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

    private static final void registerIslandService$lambda$10$lambda$8(IslandImpl r9) {
        Intrinsics.checkNotNullParameter(r9, "this$0");
        a r0 = r9.serviceLock;
        monitor-enter(r0);
        LiveCard.INSTANCE.setIslandVersion$LiveCard_sdk_release(null);     // Catch: Throwable -> L8
        r9.mService = null;     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandImpl$registerIslandService$1$2$2(r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final void setLiveCardComponentName(Context r8, Intent r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L16
        IslandImpl r7 = (IslandImpl) ZeusTransformUtils.preCheckCast(this, IslandImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        ServiceInfo[] r11 = r10.getPackageManager().getPackageInfo(LIVE_CARD_HOST, 4).services;     // Catch: Throwable -> L16
        boolean r12 = false;
        if (r11 == null) goto L14;
        Intrinsics.checkNotNullExpressionValue(r11, "services");     // Catch: Throwable -> L16
        int r5 = r11.length;     // Catch: Throwable -> L16
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L11;
        if (Intrinsics.areEqual(r11[r6].name, LIVE_CARD_SERVICE) == true) goto L9;
        r6 = r6 + 1;     // Catch: Throwable -> L16
        goto L6
    L9:
        boolean r13 = true;
    L12:
        if (r13 != true) goto L14;
        r12 = true;
        goto L14
    L11:
        r13 = false;
    L14:
        Object r14 = Result.m1421constructorimpl(Boolean.valueOf(r12));     // Catch: Throwable -> L16
    L19:
        if (Result.m1427isFailureimpl(r14) == false) goto L21;
        r14 = null;
    L21:
        Boolean r15 = (Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L24;
        r2 = r15.booleanValue();
    L24:
        if (r2 == false) goto L26;
        r9.setClassName(LIVE_CARD_HOST, LIVE_CARD_SERVICE);
        return;
    L26:
        r9.setClassName(LIVE_CARD_HOST_DEPRECATED, "com.obric.livecard.port.IslandService");
        return;
    L16:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void addIslandStatusCallback(IslandStatusCallback r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r9, null), Function1.class, "com.obric.memorydata.plugin"), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void addOnTopCardChangedListener(OnTopCardChangedListener r10) {
        OnTopCardChangedListener r11 = (OnTopCardChangedListener) ZeusTransformUtils.wrapperContextForParams(r10, OnTopCardChangedListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "callback");
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10711(r11, this, null), Function1.class, "com.obric.memorydata.plugin"), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void collapseIsland() {
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10721(this, null), Function1.class, "com.obric.memorydata.plugin"), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void collapseNotificationPanel() {
        assertCollapseNotificationFeature();
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10731(this, null), Function1.class, "com.obric.memorydata.plugin"), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public boolean createSession(IslandSession r12, Context r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "session");
        Intrinsics.checkNotNullParameter(r14, "context");
        String r15 = ILiveCard.Companion.getInst().getPackageName();
        if (r15 != null) goto L6;
        return false;
    L6:
        r12.setTaskId(nextSessionId());
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, Long.valueOf(r12.getTaskId()), true, false, (Function1) ZeusTransformUtils.preCheckCast(new C10741(this, r12, r15, null), Function1.class, "com.obric.memorydata.plugin"), 4, null);
        return true;
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void destroySession(IslandSession r13) {
        Intrinsics.checkNotNullParameter(r13, "session");
        long r0 = r13.getTaskId();
        if (r0 > 0) goto L5;
    L7:
        IslandTaskHandler r5 = this.islandTaskHandler;
        Long r1 = Long.valueOf(r0);
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L10;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        Long r6 = r1;
    L15:
        IslandTaskHandler.enqueue$default(r5, r6, false, true, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r13, null), Function1.class, "com.obric.memorydata.plugin"), 2, null);
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

    @Override // com.obric.livecard.api.island.IslandApi
    public int getIslandVersion() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        IIslandService r3 = this.mService;     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        Bundle r4 = r3.getIslandVersion();     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        int r5 = r4.getInt("version");     // Catch: Throwable -> L11
    L9:
        Object r6 = Result.m1421constructorimpl(Integer.valueOf(r5));     // Catch: Throwable -> L11
    L14:
        if (Result.m1427isFailureimpl(r6) == false) goto L16;
        r6 = null;
    L16:
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L19;
        return 0;
    L19:
        return r7.intValue();
    L8:
        r5 = 0;
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final ConcurrentHashMap<IslandSession, IIslandCardCallback> getMSessionMap() {
        return this.mSessionMap;
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public Object getPriority(IslandSession r6, Continuation<? super Long> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, C10751.class) == false) goto L7;
        C10751 r0 = (C10751) ZeusTransformUtils.preCheckCast(r8, C10751.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (IslandSession) ZeusTransformUtils.preCheckCast(r0.L$0, IslandSession.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L17:
        IIslandService r5 = (IIslandService) ZeusTransformUtils.preCheckCast(r9, IIslandService.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L22;
        Bundle r10 = r5.getPriority(r6);
        if (r10 == null) goto L22;
        return Boxing.boxLong(r10.getLong("priority"));
    L22:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        assertDialogueFeature();
        r0.L$0 = r6;
        r0.label = 1;
        r9 = getService(r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new C10751(this, r8);
        goto L8
    }

    public final Object getService(Continuation<? super IIslandService> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, C10761.class) == false) goto L7;
        C10761 r1 = (C10761) ZeusTransformUtils.preCheckCast(r11, C10761.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r7 = true;
        if (r4 == 0) goto L22;
        if (r4 == 1) goto L21;
        if (r4 == 2) goto L20;
        if (r4 != 3) goto L19;
        IslandImpl this = (IslandImpl) ZeusTransformUtils.preCheckCast(r1.L$2, IslandImpl.class, "com.obric.memorydata.plugin");
        a r5 = (a) ZeusTransformUtils.preCheckCast(r1.L$1, a.class, "com.obric.memorydata.plugin");
        IslandImpl r0 = (IslandImpl) ZeusTransformUtils.preCheckCast(r1.L$0, IslandImpl.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L16
    L47:
        this.mService = (IIslandService) ZeusTransformUtils.preCheckCast(r12, IIslandService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        this = r0;
    L49:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L16
        r5.b(null);
    L56:
        return this.mService;
    L16:
        th = th;
    L53:
        r5.b(null);
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        a r9 = (a) ZeusTransformUtils.preCheckCast(r1.L$1, a.class, "com.obric.memorydata.plugin");
        IslandImpl r2 = (IslandImpl) ZeusTransformUtils.preCheckCast(r1.L$0, IslandImpl.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
        a r14 = r9;
        this = r2;
    L64:
    L51:
        th = th;
        r5 = r14;
        goto L53
    L42:
        if (this.mService != null) goto L48;
        Function2 r6 = (Function2) ZeusTransformUtils.preCheckCast(new IslandImpl$getService$3$1(this, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        r1.L$0 = this;     // Catch: Throwable -> L51
        r1.L$1 = r14;     // Catch: Throwable -> L51
        r1.L$2 = this;     // Catch: Throwable -> L51
        r1.label = 3;     // Catch: Throwable -> L51
        Object r8 = da.b(3000, r6, r1);     // Catch: Throwable -> L51
        if (r8 != r3) goto L46;
        return r3;
    L46:
        r5 = r14;
        r12 = r8;
        r0 = this;
        goto L47
    L48:
        r5 = r14;
        goto L49
    L21:
        a r15 = (a) ZeusTransformUtils.preCheckCast(r1.L$1, a.class, "com.obric.memorydata.plugin");
        IslandImpl r16 = (IslandImpl) ZeusTransformUtils.preCheckCast(r1.L$0, IslandImpl.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
        a r17 = r15;
        this = r16;
    L62:
        IIslandService r18 = this.mService;     // Catch: Throwable -> L57
        if (r18 == null) goto L32;
        IBinder r19 = r18.asBinder();     // Catch: Throwable -> L57
        if (r19 == null) goto L32;
        if (r19.isBinderAlive() == true) goto L32;
    L33:
        if (r7 == false) goto L35;
        LiveCard.INSTANCE.setIslandVersion$LiveCard_sdk_release(null);     // Catch: Throwable -> L57
        this.mService = null;     // Catch: Throwable -> L57
    L35:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L57
        r17.b(null);
        if (this.mService != null) goto L56;
        r14 = this.serviceLock;
        r1.L$0 = this;
        r1.L$1 = r14;
        r1.label = 2;
        if (r14.a(null, r1) != r3) goto L64;
        return r3;
    L32:
        r7 = false;
    L57:
        th = move-exception;
        r17.b(null);
        throw th;
    L22:
        ResultKt.throwOnFailure(r12);
        r17 = this.serviceLock;
        r1.L$0 = this;
        r1.L$1 = r17;
        r1.label = 1;
        if (r17.a(null, r1) != r3) goto L62;
        return r3;
    L7:
        r1 = new C10761(this, r11);
        goto L8
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void onLauncherFocused() {
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10771(this, null), Function1.class, "com.obric.memorydata.plugin"), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void onNotificationVisible(boolean r8) {
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10781(this, r8, null), Function1.class, "com.obric.memorydata.plugin"), 7, null);
    }

    @Override // com.obric.livecard.api.impl.OnLiveCardServiceDiedListener
    public void onServiceDied() {
        Log.d(this.TAG, "-------IslandImpl: onServiceDisconnected");
        LiveCard.INSTANCE.setIslandVersion$LiveCard_sdk_release(null);
        this.mService = null;
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10791(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void onSysUIFlagsChanged(long r8) {
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10801(this, r8, null), Function1.class, "com.obric.memorydata.plugin"), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void onVolumeButtonClick() {
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10811(this, null), Function1.class, "com.obric.memorydata.plugin"), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void refreshScene(IslandSession r9) {
        Intrinsics.checkNotNullParameter(r9, "session");
        assertSceneFeature();
        assertIdInvalid(r9);
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, Long.valueOf(r9.getTaskId()), false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10821(this, r9, null), Function1.class, "com.obric.memorydata.plugin"), 6, null);
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void registerIslandService(IIslandService r7) {
        IIslandService r8 = (IIslandService) ZeusTransformUtils.wrapperContextForParams(r7, IIslandService.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "service");
        a r0 = this.serviceLock;
        monitor-enter(r0);
        Pair<? extends IBinder, ? extends IBinder.DeathRecipient> r1 = this.currBinderDiedListener;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        ((IBinder) ZeusTransformUtils.preCheckCast(r1.getFirst(), IBinder.class, "com.obric.memorydata.plugin")).unlinkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r1.getSecond(), IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"), 0);     // Catch: Throwable -> L10
    L7:
        IBinder r2 = r8.asBinder();     // Catch: Throwable -> L10
        IBinder.DeathRecipient r3 = new $$Lambda$IslandImpl$doYqOSFZMrZuitapGz2CRkcdlg(this);     // Catch: Throwable -> L10
        r8.asBinder().linkToDeath(r3, 0);     // Catch: Throwable -> L10
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L10
        this.currBinderDiedListener = new Pair(r2, r3);     // Catch: Throwable -> L10
        this.mService = r8;     // Catch: Throwable -> L10
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void removeIslandStatusCallback(IslandStatusCallback r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10831(this, r9, null), Function1.class, "com.obric.memorydata.plugin"), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void removeOnTopCardChangedListener(OnTopCardChangedListener r10) {
        OnTopCardChangedListener r11 = (OnTopCardChangedListener) ZeusTransformUtils.wrapperContextForParams(r10, OnTopCardChangedListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "callback");
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10841(this, r11, null), Function1.class, "com.obric.memorydata.plugin"), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void sendEvent(IslandSession r11, IslandWidget r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r11, "targetSession");
        Intrinsics.checkNotNullParameter(r12, "targetWidget");
        Intrinsics.checkNotNullParameter(r13, "eventId");
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, Long.valueOf(r11.getTaskId()), false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10851(this, r11, r12, r13, r14, null), Function1.class, "com.obric.memorydata.plugin"), 6, null);
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void setKeyguardLocked(boolean r8) {
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10861(this, r8, null), Function1.class, "com.obric.memorydata.plugin"), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void setPriority(IslandSession r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "session");
        if (r11 > System.currentTimeMillis()) goto L20;
        assertDialogueFeature();
        JsonObject r0 = r10.getExt();
        if (r0 != null) goto L7;
        r0 = new JsonObject();
    L7:
        r0.addProperty(LiveCardConstant.ISLAND_EXT_KEY_UPDATE_TIMESTAMP, (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r11), Number.class, "com.obric.memorydata.plugin"));
        r10.setExt(r0);
        if (((IIslandCardCallback) ZeusTransformUtils.preCheckCast(this.mSessionMap.get(r10), IIslandCardCallback.class, "com.obric.memorydata.plugin")) == null) goto L21;
        long r12 = r10.getTaskId();
        IslandTaskHandler r2 = this.islandTaskHandler;
        Long r13 = Long.valueOf(r12);
        if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L12;
        boolean r14 = true;
    L14:
        if (Boolean.valueOf(r14).booleanValue() == false) goto L16;
        Long r3 = r13;
    L17:
        IslandTaskHandler.enqueue$default(r2, r3, false, false, (Function1) ZeusTransformUtils.preCheckCast(new IslandImpl$setPriority$2$2(this, r10, null), Function1.class, "com.obric.memorydata.plugin"), 6, null);
        return;
    L16:
        r3 = null;
        goto L17
    L12:
        r14 = false;
        goto L14
    L21:
        return;
    L20:
        throw new IllegalArgumentException("priority > System.currentTimeMillis()");
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void setVisible(boolean r8) {
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10871(this, r8, null), Function1.class, "com.obric.memorydata.plugin"), 7, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void tryExpand(IslandSession r9, Boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "targetSession");
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, Long.valueOf(r9.getTaskId()), false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10881(this, r9, r10, null), Function1.class, "com.obric.memorydata.plugin"), 6, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public Object updateAnimation(IslandSession r11, IslandWidget r12, Continuation<? super Unit> r13) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        Object r10 = IslandTaskHandler.enqueueAndAwait$default(this.islandTaskHandler, Boxing.boxLong(r11.getTaskId()), false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10892(this, r11, r12, null), Function1.class, "com.obric.memorydata.plugin"), r7, 6, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void updateAudioAmplitude(long r10, float r12) {
        assertAudioAmplitudeFeature();
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, Long.valueOf(r10), false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10901(this, r10, r12, null), Function1.class, "com.obric.memorydata.plugin"), 6, null);
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void updateSessionFlags(IslandSession r10) {
        Intrinsics.checkNotNullParameter(r10, "session");
        long r0 = r10.getTaskId();
        IslandTaskHandler r2 = this.islandTaskHandler;
        Long r1 = Long.valueOf(r0);
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L10;
        r1 = null;
    L10:
        IslandTaskHandler.enqueue$default(r2, r1, false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10912(this, r10, null), Function1.class, "com.obric.memorydata.plugin"), 6, null);
        return;
    L5:
        r3 = false;
        goto L7
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void updateWidget(IslandSession r9, IslandWidget r10) {
        Intrinsics.checkNotNullParameter(r9, "targetSession");
        Intrinsics.checkNotNullParameter(r10, "targetWidget");
        IslandTaskHandler.enqueue$default(this.islandTaskHandler, Long.valueOf(r9.getTaskId()), false, false, (Function1) ZeusTransformUtils.preCheckCast(new C10921(this, r9, r10, null), Function1.class, "com.obric.memorydata.plugin"), 6, null);
    }
}
