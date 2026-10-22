package com.bytedance.android.live.openplatform.impl.minigamecommon.context;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.MiniGameDataContext;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.event.BridgeContextService;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.d;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lr0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001'B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0019H\u0014J\b\u0010\u001d\u001a\u00020\u0019H\u0014J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0017J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0017R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigamecommon/context/MiniGameContext;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "context", "Landroid/content/Context;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "containerView", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;Landroid/view/ViewGroup;)V", "appExited", "", "appStopped", "getContainerView", "()Landroid/view/ViewGroup;", "value", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;", "miniGameInstance", "getMiniGameInstance", "()Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;", "setMiniGameInstance", "(Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;)V", "miniGameLifecycleChangeListeners", "", "Lcom/bytedance/android/live/openplatform/impl/minigamecommon/context/OnMiniGameLifecycleChangeListener;", "notifyMiniGameLifecycleChange", "", "lifecycle", "Lcom/bytedance/android/live/openplatform/impl/minigamecommon/context/OnMiniGameLifecycleChangeListener$MiniGameLifecycle;", "onCreate", "onDestroy", "onMiniGameInstanceCreate", "instance", "onMiniGameInstanceDestroy", "registerMiniGameLifecycleChangeListener", "listener", "tryClearMiniGameInstance", "type", "Lcom/bytedance/android/live/openplatform/impl/minigamecommon/context/MiniGameContext$StopType;", "unregisterMiniGameLifecycleChangeListener", "StopType", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MiniGameContext extends OpenPlatformContext {
    private boolean appExited;
    private boolean appStopped;
    private final ViewGroup containerView;
    private MiniAppInstance miniGameInstance;
    private final List<OnMiniGameLifecycleChangeListener> miniGameLifecycleChangeListeners;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigamecommon/context/MiniGameContext$StopType;", "", "ON_GAME_EXIT", "ON_MINI_GAME_STOP", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StopType extends Enum<StopType> {
        public static final StopType ON_GAME_EXIT = null;
        public static final StopType ON_MINI_GAME_STOP = null;
        public static final /* synthetic */ StopType[] a = null;

        static {
            StopType r1 = new StopType("ON_GAME_EXIT", 0);
            ON_GAME_EXIT = r1;
            StopType r2 = new StopType("ON_MINI_GAME_STOP", 1);
            ON_MINI_GAME_STOP = r2;
            a = new StopType[]{r1, r2};
        }

        public static StopType valueOf(String r1) {
            return (StopType) r27.a.a(StopType.class, r1);
        }

        public static StopType[] values() {
            return (StopType[]) a.clone();
        }

        public StopType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public void onMiniGameInstanceDestroy() {
        notifyMiniGameLifecycleChange(OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnDestroy);
        ((BridgeContextService) getService(BridgeContextService.class)).f();
        this.miniGameLifecycleChangeListeners.clear();
        if (isAnchor() == true) goto L13;
        SchemaInfo.b r0 = SchemaInfo.s;
        MiniAppInstance r1 = this.miniGameInstance;
        String r2 = null;
        if (r1 == null) goto L7;
        String r3 = r1.getSchema();
    L8:
        r0.getClass();
        SchemaInfo r4 = SchemaInfo.b.b(r3);
        if (r4 == null) goto L12;
        r2 = r4.d();
    L12:
        if (Intrinsics.areEqual(r2, "smallrocker_exp") == true) goto L13;
        return;
    L7:
        r3 = null;
    L13:
        BridgeContextService r5 = (BridgeContextService) getService(BridgeContextService.class);
        Bundle r6 = new Bundle();
        r6.putString("from", "live_stop");
        Unit r7 = Unit.INSTANCE;
        r5.g("command_kill_minigame", r6);
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onCreate() {
        super.onCreate();
        if (isAnchor() == false) goto L5;
        Pair r0 = d.a(MiniGameContext$onCreate$pair$1.INSTANCE);
    L6:
        ((MiniGameDataContext) r0.getFirst()).share();
        autoDispose((Disposable) r0.getSecond());
        return;
    L5:
        r0 = d.a(MiniGameContext$onCreate$pair$2.INSTANCE);
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onDestroy() {
        super.onDestroy();
        setMiniGameInstance(null);
        this.miniGameLifecycleChangeListeners.clear();
    }

    public final ViewGroup getContainerView() {
        return this.containerView;
    }

    public final MiniAppInstance getMiniGameInstance() {
        return this.miniGameInstance;
    }

    public final void notifyMiniGameLifecycleChange(OnMiniGameLifecycleChangeListener.MiniGameLifecycle r5) {
        Intrinsics.checkNotNullParameter(r5, "lifecycle");
        Iterator<T> r0 = this.miniGameLifecycleChangeListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L21;
        OnMiniGameLifecycleChangeListener r1 = (OnMiniGameLifecycleChangeListener) r0.next();
        int r2 = a.a[r5.ordinal()];
        if (r2 != 1) goto L8;
        r1.a();
        goto L4
    L8:
        if (r2 != 2) goto L10;
        r1.e();
        goto L4
    L10:
        if (r2 != 3) goto L12;
        r1.c();
        goto L4
    L12:
        if (r2 != 4) goto L14;
        r1.d();
        goto L4
    L14:
        if (r2 != 5) goto L4;
        r1.b();
        goto L4
    }

    public void onMiniGameInstanceCreate(MiniAppInstance r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        notifyMiniGameLifecycleChange(OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnCreate);
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_mini_game_interrupt", new lr0.d(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_mini_game_exit", new c(this));
    }

    public final void registerMiniGameLifecycleChangeListener(OnMiniGameLifecycleChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.miniGameLifecycleChangeListeners.add(r2);
    }

    public final void setMiniGameInstance(MiniAppInstance r1) {
        if (r1 == null) goto L4;
        this.miniGameInstance = r1;
        onMiniGameInstanceCreate(r1);
        return;
    L4:
        onMiniGameInstanceDestroy();
        this.miniGameInstance = null;
        this.appExited = false;
        this.appStopped = false;
    }

    public final void tryClearMiniGameInstance(StopType r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        int r4 = a.b[r3.ordinal()];
        if (r4 != 1) goto L5;
        this.appExited = true;
        return;
    L5:
        if (r4 != 2) goto L11;
        this.appStopped = true;
        return;
    }

    public final void unregisterMiniGameLifecycleChangeListener(OnMiniGameLifecycleChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.miniGameLifecycleChangeListeners.remove(r2);
    }

    public MiniGameContext(Context r2, DataCenter r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.containerView = r4;
        this.miniGameLifecycleChangeListeners = new ArrayList();
    }
}
