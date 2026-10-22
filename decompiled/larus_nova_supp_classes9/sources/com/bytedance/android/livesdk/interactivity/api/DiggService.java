package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.interactivity.like.DigAccessibilityWidget;
import com.bytedance.android.livesdk.interactivity.like.DiggApi;
import com.bytedance.android.livesdk.interactivity.like.DiggWidget;
import com.bytedance.android.livesdk.interactivity.like.controller.DiggCountFlipperLayoutControllerImpl;
import com.bytedance.android.livesdk.interactivity.like.controller.DoubleLikeManager;
import com.bytedance.android.livesdk.interactivity.like.f1;
import com.bytedance.android.livesdk.interactivity.like.v0;
import com.bytedance.android.livesdk.interactivity.like.view.FakeDiggView;
import com.bytedance.android.livesdk.interactivity.like.x0;
import com.bytedance.android.livesdkapi.depend.live.IBarrageLauncher;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.view.IFakeDiggView;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010:J\u0012\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002H\u0016J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0012\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0016J \u0010*\u001a\u00020\t2\u0006\u0010&\u001a\u00020%2\u0006\u0010\"\u001a\u00020'2\u0006\u0010)\u001a\u00020(H\u0016J\"\u00101\u001a\u0002002\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010-H\u0016J\u001a\u00103\u001a\u0002022\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010,\u001a\u00020+H\u0016J\u001e\u00105\u001a\u0004\u0018\u0001042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u001c\u00108\u001a\u0004\u0018\u0001072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u000206H\u0016¨\u0006;"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/DiggService;", "Lcom/bytedance/android/livesdk/interactivity/api/IDiggService;", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getDiggWidgetClass", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", BuildConfig.FLAVOR, "count", BuildConfig.FLAVOR, "sendDiggMessage", "Landroid/content/Context;", "context", "Lcom/bytedance/android/livesdkapi/view/IFakeDiggView;", "getFakeDiggView", "Landroid/view/ViewGroup;", "container", "Lcom/bytedance/android/livesdkapi/depend/live/IBarrageLauncher;", "provideDiggBarrageLauncher", "Lu32/a$a;", "initializer", "Lu32/a;", "provideDiggAvatarAnimationController", "Lu32/h$a;", "Lu32/h;", "provideDiggHeartAnimationController", "Lu32/o$a;", "Lu32/o;", "provideDiggThankAnimationController", "Lu32/d$a;", "Lu32/d;", "provideDiggCountFlipperLayoutController", "digAccessibilityWidget", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lu32/l;", "provideDoubleLikeManager", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/l;", "publicScreenContext", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "loadInPublicScreenContext", BuildConfig.FLAVOR, "roomId", BuildConfig.FLAVOR, "diggTargetUid", "diggExtraInfo", "Lu32/j;", "provideDiggHandler", BuildConfig.FLAVOR, "needPerformHapticFeedback", "Lv32/b;", "getLikeView", "Lv32/d;", "Lv32/a;", "getDefaultTapController", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DiggService implements IDiggService {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ int a;

        public a(int r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Response r4 = (Response) r3;
            com.bytedance.android.livesdk.interactivity.api.base.b.a r5 = com.bytedance.android.livesdk.interactivity.api.base.b.m;
            q r0 = q.a;
            int r1 = this.a;
            r5.getClass();
            Intrinsics.checkNotNullParameter(r0, "$this$onDigg");
            h r6 = i.b(null, 3);
            if (r6 == null) goto L10;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.base.b> r7 = r6.getInteractivityStat();
            if (r7 == null) goto L11;
            com.bytedance.android.livesdk.interactivity.api.base.b r8 = (com.bytedance.android.livesdk.interactivity.api.base.b) r7.getValue();
            if (r8 == null) goto L12;
            r8.f += r1;
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public DiggService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public Class<? extends LiveRecyclableWidget> digAccessibilityWidget() {
        return DigAccessibilityWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IDiggService
    public Class<? extends LiveRecyclableWidget> getDiggWidgetClass() {
        return DiggWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IDiggService
    public IFakeDiggView getFakeDiggView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        return new FakeDiggView(r4, null, 0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public u32.a provideDiggAvatarAnimationController(u32.a.InterfaceC0285a r2) {
        Intrinsics.checkNotNullParameter(r2, "initializer");
        return new com.bytedance.android.livesdk.interactivity.like.controller.a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public u32.d provideDiggCountFlipperLayoutController(u32.d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "initializer");
        return new DiggCountFlipperLayoutControllerImpl(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public u32.h provideDiggHeartAnimationController(u32.h.a r2) {
        Intrinsics.checkNotNullParameter(r2, "initializer");
        return new u32.f();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public u32.o provideDiggThankAnimationController(u32.o.a r2) {
        Intrinsics.checkNotNullParameter(r2, "initializer");
        return new u32.g();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public u32.l provideDoubleLikeManager(MiddlewareRoomContext r3) {
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        DoubleLikeManager r0 = new DoubleLikeManager(r3);
        r0.addListener(com.bytedance.android.livesdk.interactivity.like.utils.c.a, false);
        r0.addListener(com.bytedance.android.livesdk.interactivity.like.utils.d.a, false);
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public v32.a getDefaultTapController(Context r2, v32.d r3) {
        Intrinsics.checkNotNullParameter(r3, "initializer");
        if (r2 != null) goto L7;
        return null;
    L7:
        return new f1(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public v32.b getLikeView(Context r2, DataCenter r3) {
        if (r2 == null) goto L7;
        if (r3 != null) goto L6;
        return null;
    L6:
        return new x0(r2, r3);
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public boolean needPerformHapticFeedback(DataCenter r2, long r3) {
        RoomContext.Companion.getClass();
        RoomContext r4 = RoomContext.a.a(r2, r3);
        if (r4 == null) goto L11;
        DiggContext r5 = com.bytedance.android.livesdk.interactivity.api.like.datacontext.a.a(r4);
        if (r5 == null) goto L11;
        com.bytedance.live.datacontext.n<u32.k> r6 = r5.getDiggWidget();
        if (r6 == null) goto L11;
        u32.k r7 = (u32.k) r6.getValue();
        if (r7 == null) goto L11;
        return r7.needPerformHapticFeedback();
    L11:
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IDiggService
    public IBarrageLauncher provideDiggBarrageLauncher(Context r2, ViewGroup r3) {
        return new com.bytedance.android.livesdk.interactivity.like.barrage.b(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IDiggService
    public void sendDiggMessage(Room r11, int r13) {
        if (jc1.k.n(IUserService.class).user().isLogin() == false) goto L21;
        if (r11 == null) goto L10;
        RoomAuthStatus r0 = r11.getRoomAuthStatus();
        if (r0 == null) goto L10;
        if (r0.getEnableDigg() == true) goto L10;
        return;
    L10:
        if (r11 == null) goto L22;
        DiggApi r1 = (DiggApi) com.bytedance.android.live.network.c.b().e(DiggApi.class);
        long r2 = r11.id;
        nm1.m r3 = pm1.f.l();
        long r4 = 0;
        if (r3 == null) goto L19;
        Long r8 = null;
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 == null) goto L18;
        com.bytedance.live.datacontext.m r6 = r5.getCameraId();
        if (r6 == null) goto L18;
        r8 = (Long) r6.getValue();
    L18:
        r4 = r3.k(r11, r8);
    L19:
        DiggApi.a.a(r1, r2, r13, r4, null, null, 56).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r13), RxUtil.getNoOpThrowable());
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IDiggService
    public void loadInPublicScreenContext(com.bytedance.android.livesdk.interactivity.api.publicscreen.l r4, RoomContext r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r4, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r5, "roomContext");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        int r7 = v0.c;
        Intrinsics.checkNotNullParameter(r4, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r5, "roomContext");
        if (r5.isVSRoom() == true) goto L7;
        r4.registerPlugin(new v0(r5));
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public u32.j provideDiggHandler(long r2, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "diggTargetUid");
        return new com.bytedance.android.livesdk.interactivity.like.d(r2, r4, r5);
    }
}
