package com.bytedance.android.livesdk.chatroom.widget;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerTipsContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/PlayerShadowWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerShadowWidget extends LiveRecyclableWidget implements com.bytedance.android.livesdk.chatroom.vsplayer.model.a, Observer<KVData> {
    public static final /* synthetic */ int f = 0;
    public final Lazy a;
    public final Lazy b;
    public IVSPlayerService c;
    public CompositeDisposable d;
    public vr1.u e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PlayerShadowWidget a;

        public b(PlayerShadowWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            PlayerShadowWidget r4 = this.a;
            int r0 = PlayerShadowWidget.f;
            UtilityKotlinExtentionsKt.z(r4.zq(), this.a.Bq());
            UtilityKotlinExtentionsKt.z(this.a.yq(), this.a.Aq());
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PlayerShadowWidget a;

        public c(PlayerShadowWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            sh6.b r2 = (sh6.b) r1;
            ViewGroup r3 = ((Widget) this.a).containerView;
            if (r3 == null) goto L6;
            UtilityKotlinExtentionsKt.w(r3);
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567147;
    }

    public final void onInit(Object[] r1) {
    }

    public final View yq() {
        return (View) this.b.getValue();
    }

    public final View zq() {
        return (View) this.a.getValue();
    }

    public final void onUnload() {
        ((Widget) this).dataCenter.removeObserver(this);
        IVSPlayerService r0 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r1 = r0.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r1 == null) goto L7;
        r1.c(PlayerViewControl.KEY.PlayerShadowTop);
        r1.c(PlayerViewControl.KEY.PlayerShadowBottom);
    L7:
        this.e = null;
        this.d.dispose();
    }

    public final boolean xq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L16;
        IVSPlayerService r2 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r2 == null) goto L17;
        IPlayerProgressService r3 = r2.provideVSProgressService(r0);
        if (r3 == null) goto L18;
        PlayerProgressServiceContext r1 = r3.provideContext(r0);
        if (r1 == null) goto L19;
        com.bytedance.live.datacontext.m r4 = r1.getVsRoomEnableSeek();
        if (r4 != null) goto L13;
        return false;
    L13:
        if (((Boolean) r4.getValue()).booleanValue() != true) goto L21;
        return true;
    L21:
        return false;
    L19:
        return false;
    L18:
        return false;
    L17:
        return false;
    L16:
        return false;
    }

    public PlayerShadowWidget() {
        this.a = LazyKt.lazy(new PlayerShadowWidget$shadowTop$2(this));
        this.b = LazyKt.lazy(new PlayerShadowWidget$shadowBottom$2(this));
        this.d = new CompositeDisposable();
    }

    public final boolean Aq() {
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().d(((Widget) this).dataCenter) == true) goto L5;
    L9:
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L20;
        IRoom r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r0);
        if (r1 == null) goto L20;
        if (ju2.e.a(r1) != true) goto L20;
        if (PadConfigUtils.c() == false) goto L20;
        if (CollectionsKt.listOf(new Integer[]{0, 8}).contains(Integer.valueOf(e5.a())) == false) goto L20;
        return false;
    L20:
        vr1.u r2 = this.e;
        if (r2 == null) goto L28;
        com.bytedance.live.datacontext.m<Boolean> r3 = r2.A();
        if (r3 == null) goto L28;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L28;
        return xq();
    L28:
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L35;
        IRoom r5 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r4);
        if (r5 == null) goto L35;
        if (r5.isMergeFirstShow() != true) goto L35;
    L44:
        return true;
    L35:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().d(((Widget) this).dataCenter) == false) goto L46;
        vr1.u r6 = this.e;
        if (r6 == null) goto L43;
        com.bytedance.live.datacontext.m<Boolean> r7 = r6.A();
        if (r7 == null) goto L43;
        if (((Boolean) r7.getValue()).booleanValue() != true) goto L43;
        return false;
    L43:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this).dataCenter), PaidSceneEnum.PAID_ROOM, 2) == true) goto L44;
        return false;
    L46:
        return false;
    L5:
        if (PadConfigUtils.c() == false) goto L9;
        if (e5.n() == false) goto L9;
        return false;
    }

    public final boolean Bq() {
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().d(((Widget) this).dataCenter) == true) goto L5;
    L9:
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L20;
        IRoom r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r0);
        if (r1 == null) goto L20;
        if (ju2.e.a(r1) != true) goto L20;
        if (PadConfigUtils.c() == false) goto L20;
        if (CollectionsKt.listOf(new Integer[]{0, 8}).contains(Integer.valueOf(e5.a())) == false) goto L20;
        return false;
    L20:
        vr1.u r2 = this.e;
        if (r2 == null) goto L29;
        com.bytedance.live.datacontext.m<Boolean> r3 = r2.A();
        if (r3 == null) goto L29;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L29;
        return xq();
    L29:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this).dataCenter), PaidSceneEnum.PAID_ROOM, 2) == false) goto L59;
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L59;
        IRoom r5 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r4);
        if (r5 == null) goto L59;
        IRoomAuthStatus r6 = r5.getRoomAuthStatus();
        if (r6 == null) goto L59;
        if (r6.getCastScreen() != 1) goto L59;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().isSaas() == false) goto L48;
        yr1.o r7 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.v();
        if (r7 != null) goto L45;
    L47:
        boolean r8 = false;
    L49:
        if (r8 == false) goto L59;
        yr1.b r9 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.b();
        if (r9 == null) goto L58;
        com.bytedance.live.datacontext.m<Boolean> r10 = r9.castScreenMode(((Widget) this).dataCenter);
        if (r10 == null) goto L58;
        if (((Boolean) r10.getValue()).booleanValue() == true) goto L59;
    L58:
        boolean r11 = true;
    L60:
        if (r11 == false) goto L62;
    L63:
        vr1.u r12 = this.e;
        if (r12 == null) goto L69;
        com.bytedance.live.datacontext.m<Boolean> r13 = r12.A();
        if (r13 == null) goto L69;
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L69;
        return false;
    L69:
        return true;
    L62:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(((Widget) this).dataCenter, true) == false) goto L63;
        return false;
    L45:
        if (r7.c() != true) goto L47;
        r8 = true;
        goto L49
    L48:
        r8 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.b().q();
    L59:
        r11 = false;
        goto L60
    L5:
        if (PadConfigUtils.c() == false) goto L9;
        if (e5.n() == false) goto L9;
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r8) {
        Intrinsics.checkNotNullParameter(r8, "key");
        PlayerViewControl.KEY r0 = PlayerViewControl.KEY.PlayerShadowBottom;
        if (r8 != r0) goto L55;
        IVSPlayerService r9 = this.c;
        if (r9 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r10 = r9.provideVSPlayerTipService(((Widget) this).dataCenter);
        if (r10 == null) goto L11;
        PlayerTipsContext r11 = r10.provideVSPlayTipsContext();
        if (r11 == null) goto L11;
        boolean r12 = r11.getPlayerTipShowing();
    L13:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(((Widget) this).dataCenter, true) == false) goto L21;
        View r3 = yq();
        if (Aq() == true) goto L19;
        if (r12 == true) goto L19;
        boolean r4 = false;
    L20:
        UtilityKotlinExtentionsKt.z(r3, r4);
    L19:
        r4 = true;
    L21:
        IVSPlayerService r5 = this.c;
        Integer r6 = null;
        if (r5 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r7 = r5.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r7 == null) goto L26;
        Boolean r13 = Boolean.valueOf(r7.getVisibilityStatus());
    L27:
        IVSPlayerService r14 = this.c;
        if (r14 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r15 = r14.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r15 == null) goto L32;
        NextLiveData<Integer> r1 = r15.g(r0);
    L34:
        if (Intrinsics.areEqual(r13, Boolean.TRUE) == false) goto L45;
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(((Widget) this).dataCenter, true) == false) goto L43;
        com.bytedance.live.datacontext.m<Boolean> r2 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.b().castScreenMode(((Widget) this).dataCenter);
        if (r2 == null) goto L43;
        if (((Boolean) r2.getValue()).booleanValue() != true) goto L43;
        if (r12 == true) goto L43;
        return false;
    L43:
        return true;
    L45:
        if (Intrinsics.areEqual(r13, Boolean.FALSE) == false) goto L59;
        if (r1 == null) goto L48;
        r6 = (Integer) r1.getValue();
    L48:
        if (r6 == null) goto L59;
        if (r6.intValue() != 0) goto L59;
        return !r12;
    L59:
        return true;
    L32:
        r1 = null;
    L26:
        r13 = null;
    L11:
        r12 = false;
        goto L13
    L55:
        if (r8 != PlayerViewControl.KEY.PlayerShadowTop) goto L59;
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(((Widget) this).dataCenter, true) == false) goto L59;
        UtilityKotlinExtentionsKt.z(zq(), Bq());
        goto L59
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L18;
        String r5 = r4.getKey();
        if (r5.hashCode() == (-1836833765)) goto L8;
        return;
    L8:
        if (r5.equals("cmd_widget_loaded") == false) goto L19;
        IVSPlayerService r6 = this.c;
        if (r6 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r7 = r6.provideVSPlayerTipService(((Widget) this).dataCenter);
        if (r7 == null) goto L14;
        PlayerTipsContext r8 = r7.provideVSPlayTipsContext();
    L15:
        if (r8 == null) goto L20;
        RxUtilKt.c(r8.getMShowPlayerTipEvent().onEvent().subscribe(new q1(this)), this.d);
        RxUtilKt.c(r8.getMHidePlayerTipEvent().onEvent().subscribe(new r1(this)), this.d);
        return;
    L20:
        return;
    L14:
        r8 = null;
        goto L15
    L19:
        return;
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r3);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L14;
        IRoom r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r0);
        if (r1 != null) goto L7;
        return;
    L7:
        if (ju2.e.a(r1) == true) goto L9;
        return;
    L9:
        if (PadConfigUtils.c() == true) goto L11;
        return;
    L11:
        if (r3.orientation != 2) goto L18;
        UtilityKotlinExtentionsKt.z(zq(), false);
        UtilityKotlinExtentionsKt.z(yq(), false);
        return;
    L18:
        return;
    }

    public final void onLoad(Object[] r18) {
        this.d = new CompositeDisposable();
        this.e = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(((Widget) this).dataCenter, null, 2);
        DataCenter r0 = ((Widget) this).dataCenter;
        IRoom r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a;
        Intrinsics.checkNotNullParameter(r0, "$this$common");
        IRoom r2 = (IRoom) r0.get("data_room");
        Object r3 = r0.get("data_is_portrait");
        if (r3 != null) goto L5;
        r3 = Boolean.TRUE;
    L5:
        boolean r4 = ((Boolean) r3).booleanValue();
        Object r5 = r0.get("data_is_anchor");
        if (r5 != null) goto L8;
        r5 = Boolean.FALSE;
    L8:
        ((Boolean) r5).booleanValue();
        if (r4 == false) goto L11;
        int r6 = 80;
    L12:
        int r7 = UtilityKotlinExtentionsKt.i(r6);
        com.bytedance.android.live.core.utils.a1.k(yq(), r7);
        com.bytedance.android.live.core.utils.a1.k(zq(), r7);
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().d(((Widget) this).dataCenter) == false) goto L25;
        zq().setBackgroundResource(2131253417);
        yq().setBackgroundResource(2131253417);
        if (PadConfigUtils.c() == false) goto L25;
        vr1.u r8 = this.e;
        if (r8 == null) goto L25;
        com.bytedance.live.datacontext.n<PadOrientation> r9 = r8.w();
        if (r9 == null) goto L25;
        Observable r10 = r9.a();
        if (r10 == null) goto L25;
        Disposable r11 = r10.subscribe(new b(this));
        if (r11 == null) goto L25;
        RxUtilKt.c(r11, this.d);
    L25:
        IVSPlayerService r12 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        this.c = r12;
        if (r12 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r13 = r12.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r13 == null) goto L31;
        PlayerViewControl.KEY r14 = PlayerViewControl.KEY.PlayerShadowTop;
        PlayerViewControl.Type r15 = PlayerViewControl.Type.TOP;
        PlayerViewControl.Style r16 = PlayerViewControl.Style.HIDE;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r13, r14, r15, r16, zq(), 0.0f, true, false, this, 336);
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r13, PlayerViewControl.KEY.PlayerShadowBottom, PlayerViewControl.Type.BOTTOM, r16, yq(), 0.0f, true, false, this, 336);
    L31:
        if (Bq() == true) goto L33;
        UtilityKotlinExtentionsKt.t(zq());
    L35:
        if (Aq() == true) goto L37;
        UtilityKotlinExtentionsKt.t(yq());
    L39:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.A().a(((Widget) this).dataCenter, false) == false) goto L47;
        DataCenter r17 = ((Widget) this).dataCenter;
        if (r17 == null) goto L47;
        IRoom r19 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r17);
        if (r19 == null) goto L47;
        if (r19.isMediaRoom() != true) goto L47;
        UtilityKotlinExtentionsKt.t(zq());
        UtilityKotlinExtentionsKt.t(yq());
    L47:
        ((Widget) this).dataCenter.observe("cmd_widget_loaded", this);
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(((Widget) this).dataCenter, true) == false) goto L71;
        vr1.u r20 = this.e;
        if (r20 == null) goto L59;
        com.bytedance.live.datacontext.j<Unit> r21 = r20.k();
        if (r21 == null) goto L59;
        if (r21.hasValue() != true) goto L59;
        ViewGroup r22 = ((Widget) this).containerView;
        if (r22 == null) goto L75;
        UtilityKotlinExtentionsKt.w(r22);
        return;
    L75:
        return;
    L59:
        ViewGroup r23 = ((Widget) this).containerView;
        if (r23 == null) goto L62;
        UtilityKotlinExtentionsKt.t(r23);
    L62:
        vr1.u r24 = this.e;
        if (r24 == null) goto L77;
        com.bytedance.live.datacontext.j<Unit> r25 = r24.k();
        if (r25 == null) goto L78;
        Maybe r26 = r25.b();
        if (r26 == null) goto L79;
        Disposable r27 = r26.subscribe(new c(this));
        if (r27 == null) goto L80;
        RxUtilKt.c(r27, this.d);
        return;
    L80:
        return;
    L79:
        return;
    L78:
        return;
    L77:
        return;
    L71:
        ViewGroup r28 = ((Widget) this).containerView;
        if (r28 == null) goto L82;
        UtilityKotlinExtentionsKt.w(r28);
        return;
    L82:
        return;
    L37:
        UtilityKotlinExtentionsKt.w(yq());
        goto L39
    L33:
        UtilityKotlinExtentionsKt.w(zq());
        goto L35
    L11:
        r6 = 140;
        goto L12
    }

    public static final void wq(PlayerShadowWidget r4, boolean r5) {
        IVSPlayerService r0 = r4.c;
        Integer r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r2 = r0.provideVSPlayerViewControlService(((Widget) r4).dataCenter);
        if (r2 == null) goto L7;
        Boolean r3 = Boolean.valueOf(r2.getVisibilityStatus());
    L8:
        IVSPlayerService r6 = r4.c;
        if (r6 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r7 = r6.provideVSPlayerViewControlService(((Widget) r4).dataCenter);
        if (r7 == null) goto L13;
        NextLiveData<Integer> r8 = r7.g(PlayerViewControl.KEY.PlayerShadowBottom);
    L14:
        if (r5 == false) goto L16;
    L29:
        if (r5 == true) goto L31;
        return;
    L31:
        if (Intrinsics.areEqual(r3, Boolean.FALSE) == false) goto L48;
        if (r8 == null) goto L34;
        r1 = (Integer) r8.getValue();
    L34:
        if (r1 != null) goto L37;
        return;
    L37:
        if (r1.intValue() != 1) goto L49;
        IVSPlayerService r9 = r4.c;
        if (r9 == null) goto L50;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r10 = r9.provideVSPlayerViewControlService(((Widget) r4).dataCenter);
        if (r10 == null) goto L51;
        r10.d(PlayerViewControl.KEY.PlayerShadowBottom, true);
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L16:
        if (Intrinsics.areEqual(r3, Boolean.FALSE) == false) goto L29;
        if (r8 == null) goto L19;
        Integer r11 = (Integer) r8.getValue();
    L20:
        if (r11 == null) goto L29;
        if (r11.intValue() != 0) goto L29;
        IVSPlayerService r12 = r4.c;
        if (r12 == null) goto L44;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r13 = r12.provideVSPlayerViewControlService(((Widget) r4).dataCenter);
        if (r13 == null) goto L45;
        r13.d(PlayerViewControl.KEY.PlayerShadowBottom, false);
        return;
    L45:
        return;
    L44:
        return;
    L19:
        r11 = null;
    L13:
        r8 = null;
    L7:
        r3 = null;
        goto L8
    }
}
