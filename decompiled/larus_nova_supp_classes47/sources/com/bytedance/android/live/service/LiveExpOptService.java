package com.bytedance.android.live.service;

import com.bytedance.android.live.LiveExpPushHelper;
import com.bytedance.android.live.context.LiveExpRoomContext;
import com.bytedance.android.live.context.NewExpContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.observer.ExpBizPerfObserver;
import com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.live.room.api.experience.service.ILiveTopSpeedExpService;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.android.live.tetris.c;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import d90.d;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import j70.h;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010;J!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0014\b\b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0082\bJ\u0010\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u001aH\u0016J\u0018\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\u001a\u0010&\u001a\u00020%2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020\u0004H\u0016J\b\u0010+\u001a\u00020\u0004H\u0016R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R#\u00106\u001a\n 1*\u0004\u0018\u00010'0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0016\u00109\u001a\u0004\u0018\u00010\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/bytedance/android/live/service/LiveExpOptService;", "Lcom/bytedance/android/live/room/api/experience/service/ILiveExpOptService;", "Lkotlin/Function1;", "Ld61/b;", "", "action", "", "useExpContext", "Lj70/h;", "Ld90/d;", "getExpPushTetrisDesc", "", "tag", "launch", "stop", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lcom/bytedance/live/datacontext/DataContext;", "initRoomExpContext", "Le61/a;", "dispatcher", "Ln61/c;", "source", "processSource", "Lj61/b;", "result", "handleResult", "Ll61/b;", "scene", "Lg61/a;", "listener", "Lio/reactivex/disposables/Disposable;", "registerExpBizListener", "unregisterExpBizListener", "showExpOptDialog", "Ll61/c;", "getSceneState", "", "reset", "shouldResetPerfBySwitchClose", "checkResetPerfWhenRoomExit", "showWIFISwitch4GPush", "Lcom/bytedance/android/live/context/NewExpContext;", "newExpCtx", "Lcom/bytedance/android/live/context/NewExpContext;", "consumeStatusDp", "Lio/reactivex/disposables/Disposable;", "kotlin.jvm.PlatformType", "enableSampleRoomConfig$delegate", "Lkotlin/Lazy;", "getEnableSampleRoomConfig", "()Ljava/lang/Boolean;", "enableSampleRoomConfig", "getExpCtx", "()Ld61/b;", "expCtx", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveExpOptService implements ILiveExpOptService {
    private Disposable consumeStatusDp;
    private final Lazy enableSampleRoomConfig$delegate;
    private NewExpContext newExpCtx;

    public static final class a implements Action {
        public final /* synthetic */ Ref.ObjectRef a;

        public a(Ref.ObjectRef r1) {
            this.a = r1;
        }

        public final void run() {
            Function0 r0 = (Function0) this.a.element;
            if (r0 == null) goto L6;
            Unit r1 = (Unit) r0.invoke();
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ long a;

        public b(long r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Lazy r0 = LiveExpPushHelper.a;     // Catch: Throwable -> L4
            LiveExpPushHelper.c(String.valueOf(this.a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private final Boolean getEnableSampleRoomConfig() {
        return (Boolean) this.enableSampleRoomConfig$delegate.getValue();
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void checkResetPerfWhenRoomExit() {
        NewExpContext r0 = this.newExpCtx;
        if (r0 == null) goto L6;
        r0.checkResetPerfWhenRoomExit();
        return;
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public h<? extends d> getExpPushTetrisDesc() {
        return new c();
    }

    public LiveExpOptService() {
        k.l(ILiveExpOptService.class, this);
        k.l(ILiveExpMiddlewareService.class, this);
        this.enableSampleRoomConfig$delegate = LazyKt.lazy(LiveExpOptService$enableSampleRoomConfig$2.INSTANCE);
    }

    private final d61.b getExpCtx() {
        if (PlatformExpUtils.b() == true) goto L7;
        LiveExpRoomContext.Companion.getClass();
        return LiveExpRoomContext.Companion.a();
    L7:
        return this.newExpCtx;
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public e61.a dispatcher() {
        d61.b r0 = getExpCtx();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDispatch();
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void showExpOptDialog() {
        xs2.b.a().post(new h61.a());
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void showWIFISwitch4GPush() {
        o r0 = o3.f();
        if (r0 == null) goto L10;
        m r1 = r0.getRoom();
        if (r1 == null) goto L11;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L12;
        i0.h(new b(r2.getRoomId()));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static final /* synthetic */ NewExpContext access$getNewExpCtx$p(LiveExpOptService r0) {
        return r0.newExpCtx;
    }

    private final Object useExpContext(Function1<? super d61.b, Unit> r2) {
        if (PlatformExpUtils.b() == false) goto L8;
        NewExpContext r0 = access$getNewExpCtx$p(this);
        if (r0 == null) goto L7;
        r2.invoke(r0);
        return r0;
    L7:
        return null;
    L8:
        LiveExpRoomContext.Companion.getClass();
        LiveExpRoomContext.Companion.b(r2);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void handleResult(final j61.b<? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Function1<d61.b, Unit> r0 = new AnonymousClass1(r2);
        if (PlatformExpUtils.b() == false) goto L7;
        NewExpContext r3 = access$getNewExpCtx$p(this);
        if (r3 == null) goto L9;
        r0.invoke(r3);
        return;
    L9:
        return;
    L7:
        LiveExpRoomContext.Companion.getClass();
        LiveExpRoomContext.Companion.b(r0);
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void launch(int r3) {
        ALogger.i("LiveExpOptLog", "LiveExpOptService#launch, tag:" + r3);
        Disposable r0 = this.consumeStatusDp;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Lazy r1 = PlatformExpUtils.a;
        if (PlatformExpUtils.c == false) goto L8;
        Disposable r2 = Disposables.empty();
    L9:
        this.consumeStatusDp = r2;
        NewExpContext r4 = this.newExpCtx;
        if (r4 == null) goto L12;
        r4.release();
    L12:
        NewExpContext r5 = new NewExpContext(r3);
        r5.startWork();
        Unit r6 = Unit.INSTANCE;
        this.newExpCtx = r5;
        return;
    L8:
        r2 = RxUtilKt.h(Observable.create(com.bytedance.android.live.room.api.experience.utils.b.a)).subscribe(com.bytedance.android.live.room.api.experience.utils.c.a);
        goto L9
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void processSource(final n61.c r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Function1<d61.b, Unit> r0 = new C03791(r2);
        if (PlatformExpUtils.b() == false) goto L7;
        NewExpContext r3 = access$getNewExpCtx$p(this);
        if (r3 == null) goto L9;
        r0.invoke(r3);
        return;
    L9:
        return;
    L7:
        LiveExpRoomContext.Companion.getClass();
        LiveExpRoomContext.Companion.b(r0);
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void shouldResetPerfBySwitchClose(boolean r2) {
        NewExpContext r0 = this.newExpCtx;
        if (r0 == null) goto L6;
        r0.shouldResetPerfBySwitchClose(r2);
        return;
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void stop(int r3) {
        ALogger.i("LiveExpOptLog", "LiveExpOptService#stop, tag:" + r3);
        Disposable r0 = this.consumeStatusDp;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        NewExpContext r1 = this.newExpCtx;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getRoomFragmentTag() != r3) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L14;
        r1 = null;
    L14:
        if (r1 == null) goto L18;
        r1.release();
        return;
    L18:
        return;
    L10:
        r4 = false;
        goto L11
    }

    public static final /* synthetic */ void access$setNewExpCtx$p(LiveExpOptService r0, NewExpContext r1) {
        r0.newExpCtx = r1;
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public l61.c getSceneState(DataCenter r3, l61.b r4) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        boolean r0 = false;
        if (r3 == null) goto L9;
        if (z.e(r3, false) != true) goto L9;
        l61.c.a.getClass();
        return l61.c.a.a;
    L9:
        if (TopSpeedModeUtils.a() == false) goto L17;
        ILiveTopSpeedExpService r5 = (ILiveTopSpeedExpService) k.f(ILiveTopSpeedExpService.class);
        if (r5 == null) goto L13;
        r0 = r5.isDegradingForScene(r4);
    L13:
        if (r0 == false) goto L15;
        l61.a r6 = new l61.a();
        r6.b = true;
        return r6;
    L15:
        l61.c.a.getClass();
        return l61.c.a.a;
    L17:
        k61.a r7 = o61.a.b;
        if (r7 == null) goto L21;
        ExpBizPerfObserver r1 = new ExpBizPerfObserver(r4, null);
        r1.b(r7);
        l61.a r8 = new l61.a();
        r8.b = r1.a;
        return r8;
    L21:
        l61.c.a.getClass();
        return l61.c.a.a;
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpOptService
    public DataContext initRoomExpContext(DataCenter r2, MiddlewareRoomContext r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        LiveExpRoomContext r0 = new LiveExpRoomContext(r2, r3);
        r0.startWork();
        return r0;
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public Disposable registerExpBizListener(final l61.b r3, final g61.a r4) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "listener");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = null;
        if (TopSpeedModeUtils.a() == false) goto L7;
        ILiveTopSpeedExpService r1 = (ILiveTopSpeedExpService) k.f(ILiveTopSpeedExpService.class);
        if (r1 == null) goto L14;
        r1.registerExpBizListener(r3, r4);
    L14:
        return Disposables.fromAction(new a(r0));
    L7:
        Function1<d61.b, Unit> r2 = new C03801(r3, r4, r0);
        if (PlatformExpUtils.b() == false) goto L12;
        NewExpContext r5 = access$getNewExpCtx$p(this);
        if (r5 == null) goto L14;
        r2.invoke(r5);
        goto L14
    L12:
        LiveExpRoomContext.Companion.getClass();
        LiveExpRoomContext.Companion.b(r2);
        goto L14
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void unregisterExpBizListener(final l61.b r2, final g61.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (TopSpeedModeUtils.a() == false) goto L7;
        ILiveTopSpeedExpService r0 = (ILiveTopSpeedExpService) k.f(ILiveTopSpeedExpService.class);
        if (r0 == null) goto L14;
        r0.unregisterExpBizListener(r2, r3);
        return;
    L14:
        return;
    L7:
        Function1<d61.b, Unit> r1 = new C03811(r2, r3);
        if (PlatformExpUtils.b() == false) goto L12;
        NewExpContext r4 = access$getNewExpCtx$p(this);
        if (r4 == null) goto L16;
        r1.invoke(r4);
        return;
    L16:
        return;
    L12:
        LiveExpRoomContext.Companion.getClass();
        LiveExpRoomContext.Companion.b(r1);
    }
}
