package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.screenrotation.entrance.EntranceChecker;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.FullVideoButtonWidgetPaidUtil;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.config.lj;
import com.bytedance.android.livesdk.config.m91;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.ListenLiveStatus;
import com.bytedance.common.jato.views.JatoOptDrawableCache;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.LiveOrientationControl, needDynamicControl = true, type = PlayerViewControl.Type.BOTTOM)
public class FullVideoButtonWidget extends LiveWidget implements Observer<KVData>, com.bytedance.android.livesdk.chatroom.vsplayer.model.a, com.bytedance.android.live.room.api.visibilitycontrol.b {
    public long a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public View j;
    public boolean k;
    public View l;
    public boolean m;
    public p0 n;
    public final CompositeDisposable o;
    public Disposable p;
    public Disposable q;
    public Disposable r;
    public ObjectAnimator s;
    public long t;
    public int u;
    public EntranceChecker v;
    public boolean w;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ FullVideoButtonWidget b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            super.onAnimationEnd(r2);
            if (this.a == true) goto L6;
            this.b.j.setVisibility(8);
            return;
        }

        public a(FullVideoButtonWidget r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final int getLayoutId() {
        return 2131566724;
    }

    public final String getSpm() {
        return "a100.a100.a161";
    }

    public final boolean canControlByClearScreenService() {
        if (jc1.k.f(IVisibilityControlBrickService.class) != null) goto L5;
    L10:
        return true;
    L5:
        if (jc1.k.f(IVisibilityControlBrickService.class).provideVisibilityControlService(((Widget) this).dataCenter) == null) goto L10;
        if (jc1.k.f(IVisibilityControlBrickService.class).provideVisibilityControlService(((Widget) this).dataCenter).provideContext() == null) goto L10;
        return !jc1.k.f(IVisibilityControlBrickService.class).provideVisibilityControlService(((Widget) this).dataCenter).provideContext().enablePlayBackAbility();
    }

    public final void onDestroy() {
        if (((Boolean) LiveInfraSettingKeys.LIVE_ENABLE_LANDSCAPE_LOG_FIX.getValue()).booleanValue() == false) goto L5;
        Aq(this.k);
    L5:
        this.o.clear();
        xq();
        ((Widget) this).dataCenter.removeObserver(this);
        ObjectAnimator r0 = this.s;
        if (r0 == null) goto L8;
        r0.cancel();
        this.s.removeAllListeners();
        this.s = null;
    L8:
        RoomContext r1 = RoomContext.getShared(((Widget) this).dataCenter);
        if (r1 == null) goto L11;
        ((ig1.b) r1.getCastScreenEntryDismissTimer().getValue()).release();
    L11:
        hd0.c.f().e(this.n);
        super.onDestroy();
        wq(0);
        this.u = Integer.MIN_VALUE;
        WeakReference<View> r2 = FullVideoButtonWidgetPaidUtil.c;
        if (r2 == null) goto L14;
        r2.clear();
    L14:
        Disposable r3 = FullVideoButtonWidgetPaidUtil.b;
        if (r3 == null) goto L17;
        r3.dispose();
    L17:
        EntranceChecker r4 = this.v;
        if (r4 == null) goto L21;
        r4.h();
        return;
    }

    public final void xq() {
        Disposable r0 = this.p;
        if (r0 != null) goto L5;
    L7:
        Disposable r1 = this.q;
        if (r1 != null) goto L10;
    L12:
        Disposable r2 = this.r;
        if (r2 != null) goto L15;
        return;
    L15:
        if (r2.isDisposed() == true) goto L19;
        this.r.dispose();
        return;
    L19:
        return;
    L10:
        if (r1.isDisposed() == true) goto L12;
        this.q.dispose();
        goto L12
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.p.dispose();
        goto L7
    }

    public final boolean yq() {
        RoomContext.a r0 = RoomContext.Companion;
        DataCenter r1 = ((Widget) this).dataCenter;
        long r2 = this.a;
        r0.getClass();
        RoomContext r3 = RoomContext.a.a(r1, r2);
        if (lj.a.getValue().b() != 2) goto L10;
        if (r3 == null) goto L10;
        if (VSMediaUIConfigHelper.b(((Widget) this).dataCenter) == true) goto L10;
        if (r3.isShowFullScreenUIByClickScreen().getValue() == null) goto L10;
        return !((Boolean) r3.isShowFullScreenUIByClickScreen().getValue()).booleanValue();
    L10:
        return false;
    }

    public FullVideoButtonWidget() {
        this.b = true;
        this.c = false;
        this.d = true;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = true;
        this.k = false;
        this.m = false;
        this.o = new CompositeDisposable();
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = 0;
        this.u = Integer.MIN_VALUE;
        this.w = true;
    }

    public final void Cq() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        Room r0 = (Room) ((Widget) this).dataCenter.get("data_room", null);
        boolean r1 = zq(r0);
        int r4 = 0;
        if (r1 == true) goto L8;
    L27:
        boolean r2 = false;
    L28:
        this.d = r2;
        if (this.j.getVisibility() == 0) goto L31;
        boolean r3 = true;
    L32:
        StringBuilder r5 = new StringBuilder("isEnableSwitchLandscape:");
        r5.append(r1);
        r5.append("\tmIsVideoHorizontal:");
        r5.append(this.b);
        r5.append("\t!mIsShowKeyboard:");
        r5.append(!this.c);
        r5.append("\t!mIsInLinkMode:");
        r5.append(!this.e);
        r5.append("\t!mIsInMultiLinkMode:");
        r5.append(!this.f);
        r5.append("\tisShowEntrance:");
        r5.append(this.w);
        r5.append("\t!mIsMediaIntroduceShowing:");
        r5.append(!this.h);
        ALogger.i("FullButton", r5.toString());
        View r6 = this.j;
        if (this.d == true) goto L36;
        r4 = 8;
    L36:
        r6.setVisibility(r4);
        if (yq() == false) goto L39;
        this.j.setVisibility(8);
    L39:
        if (r3 == true) goto L41;
    L43:
        if (r3 == true) goto L45;
        return;
    L45:
        if (yq() == false) goto L47;
        return;
    L47:
        if (this.d == false) goto L54;
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L55;
        com.bytedance.android.livesdk.castscreen.utils.f.b("screen_rotate_icon_show", r7, r0, new q0(this));
        return;
    L55:
        return;
    L54:
        return;
    L41:
        if (yq() == true) goto L43;
        ut1.h.c();
        goto L43
    L31:
        r3 = false;
        goto L32
    L8:
        if (this.b == false) goto L27;
        if (this.c == true) goto L27;
        if (this.e == true) goto L27;
        if (this.f == true) goto L27;
        if (this.w == false) goto L27;
        if (this.h == true) goto L27;
        ListenLiveStatus r8 = (ListenLiveStatus) ((Widget) this).dataCenter.get("cmd_change_listen_live_status", null);
        if (r8 != null) goto L22;
    L24:
        boolean r9 = false;
    L25:
        if (r9 == true) goto L27;
        r2 = true;
        goto L28
    L22:
        if (r8.isOpen() == false) goto L24;
        r9 = true;
        goto L25
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [com.bytedance.android.livesdk.chatroom.viewmodule.p0] */
    public final void onCreate() {
        super.onCreate();
        this.j = ((Widget) this).contentView.findViewById(2131373342);
        this.l = ((Widget) this).contentView.findViewById(2131373344);
        boolean r2 = true;
        com.bytedance.android.livesdk.r3.c(this.j, com.bytedance.android.live.core.utils.s1.B(2131918651), true);
        ((Widget) this).dataCenter.observe("data_keyboard_status", this).observe("cmd_pk_state_change", this, true).observe("multi_anchor_sei_update", this, true).observe("multi_anchor_sei_close", this, true).observe("cmd_video_orientation_changed", this, true).observe("data_media_introduction_showing", this).observe("paid_live_paid_info_update", this).observe("data_feedback_bottombar_height", this).observe("cmd_change_listen_live_status", this);
        this.a = ((Long) ((Widget) this).dataCenter.get("data_room_id")).longValue();
        this.j.setOnClickListener(new n0(this));
        DataCenter r0 = ((Widget) this).dataCenter;
        Boolean r1 = Boolean.TRUE;
        this.i = ((Boolean) r0.get("data_is_portrait", r1)).booleanValue();
        EntranceChecker r3 = this.v;
        if (r3 == null) goto L5;
        r3.d();
        this.w = this.v.a(com.bytedance.android.live.room.api.screenrotation.entrance.c.b);
        this.o.add(((z51.d) this.v.b).b.subscribe(new o0(this)));
    L5:
        this.n = new p0(this);
        hd0.c.f().c(this.n);
        RoomContext.a r4 = RoomContext.Companion;
        DataCenter r5 = ((Widget) this).dataCenter;
        long r6 = this.a;
        r4.getClass();
        RoomContext r7 = RoomContext.a.a(r5, r6);
        Cq();
        if (VSMediaUIConfigHelper.b(((Widget) this).dataCenter) == false) goto L8;
    L21:
        this.u = Integer.MIN_VALUE;
        mk1.a r8 = FullVideoButtonWidgetPaidUtil.a;
        FullVideoButtonWidgetPaidUtil.a(((Widget) this).dataCenter, ((Widget) this).containerView);
        if (((m91) LiveInfraSettingKeys.LIVE_XML_AND_DRAWABLE_CACHE_CONFIG.getValue()).a() == false) goto L27;
        int[] r9 = {2131251015, 2131251017, 2131251018, 2131251019, 2131251016, 2131251020, 2131251021};
        JatoOptDrawableCache.preloadDrawableCache(((Widget) this).context.getResources(), r9);     // Catch: Exception -> L26
    L27:
        com.bytedance.android.livesdk.sharedpref.e r10 = com.bytedance.android.livesdk.sharedpref.b.N;
        if (((Boolean) r10.getValue()).booleanValue() == true) goto L35;
        if (((Boolean) ((Widget) this).dataCenter.get("data_longer_video_within_live_type", Boolean.FALSE)).booleanValue() == false) goto L33;
        TimeUnit r11 = TimeUnit.SECONDS;
        this.q = Observable.timer(20, r11).observeOn(AndroidSchedulers.mainThread()).subscribe(new s0(this));
        this.r = Observable.timer(25, r11).observeOn(AndroidSchedulers.mainThread()).subscribe(new t0(this));
        com.bytedance.android.livesdk.sharedpref.f.d(r10, Boolean.TRUE);
        goto L35
    L33:
        this.l.setVisibility(8);
    L35:
        if (((Boolean) LiveInfraSettingKeys.LIVE_ENABLE_LANDSCAPE_LOG_FIX.getValue()).booleanValue() == true) goto L37;
        return;
    L37:
        if (zq((Room) ((Widget) this).dataCenter.get("data_room", null)) == true) goto L39;
    L41:
        r2 = false;
    L42:
        this.k = r2;
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 != null) goto L45;
    L47:
        ALogger.i("LandscapeButtonWidget", "dataCenter || RoomContext is null");
        return;
    L45:
        if (RoomContext.getShared(r12) == null) goto L47;
        RoomContext.getShared(((Widget) this).dataCenter).setLiveEnableSwitchLandscape(r2);
        return;
    L39:
        if (this.b == false) goto L41;
    L8:
        if (com.bytedance.android.livesdk.utils.landscape.d.a() != 1) goto L10;
        boolean r13 = true;
    L11:
        if (r13 == false) goto L21;
        if (this.d == true) goto L15;
    L20:
        ((ObservableSubscribeProxy) r7.isShowFullScreenUIByClickScreen().a().as(autoDispose())).subscribe(new u0(this));
        goto L21
    L15:
        if (r7.isShowFullScreenUIByClickScreen().getValue() == null) goto L17;
        r7.isShowFullScreenUIByClickScreen().setValue(r1);
    L17:
        final RoomContext r14 = RoomContext.getShared(((Widget) this).dataCenter);
        if (r14 == null) goto L20;
        xq();
        this.p = ((ig1.b) r14.getCastScreenEntryDismissTimer().getValue()).a().observeOn(AndroidSchedulers.mainThread()).subscribe(new r0(r14));
        goto L20
    L10:
        r13 = false;
        goto L11
    }

    public final void onResume() {
        super.onResume();
        lj r0 = lj.a;
        if (r0.getValue().b() != 2) goto L6;
        RoomContext.a r1 = RoomContext.Companion;
        DataCenter r2 = ((Widget) this).dataCenter;
        long r3 = this.a;
        r1.getClass();
        RoomContext r4 = RoomContext.a.a(r2, r3);
        Bq(true);
        xq();
        this.p = Observable.timer(r0.getValue().a(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new v0(r4));
        return;
    }

    public final void Aq(boolean r5) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L5;
    L12:
        ALogger.i("LandscapeButtonWidget", "dataCenter || RoomContext is null");
        return;
    L5:
        if (RoomContext.getShared(r0) == null) goto L12;
        if (r5 == true) goto L8;
        return;
    L8:
        if (((Boolean) LiveInfraSettingKeys.LIVE_ENABLE_LANDSCAPE_LOG_FIX.getValue()).booleanValue() == true) goto L10;
        return;
    L10:
        if (RoomContext.getShared(((Widget) this).dataCenter).isLiveLoggedEntraceSupport() == true) goto L16;
        com.bytedance.android.livesdk.log.u.l().sendLog("live_landscape_screen_enabled", null, new Object[]{new am2.x(), Room.class});
        RoomContext.getShared(((Widget) this).dataCenter).setLiveLoggedEntraceSupport(true);
        return;
    }

    public final void Bq(boolean r4) {
        if (VSMediaUIConfigHelper.b(((Widget) this).dataCenter) == false) goto L5;
        return;
    L5:
        ObjectAnimator r0 = this.s;
        if (r0 == null) goto L11;
        if (r0.isRunning() != true) goto L11;
        this.s.cancel();
    L11:
        if (r4 == false) goto L13;
        this.s = ObjectAnimator.ofFloat(this.j, "alpha", new float[]{0.0f, 1.0f});
    L14:
        this.s.setDuration(500);
        this.s.removeAllListeners();
        this.s.addListener(new a(this, r4));
        this.s.start();
        return;
    L13:
        this.s = ObjectAnimator.ofFloat(this.j, "alpha", new float[]{1.0f, 0.0f});
        goto L14
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r4) {
        RoomContext.a r5 = RoomContext.Companion;
        DataCenter r0 = ((Widget) this).dataCenter;
        long r1 = this.a;
        r5.getClass();
        RoomContext.a.a(r0, r1);
        return true;
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (isViewValid() == false) goto L94;
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.getData() != null) goto L8;
        return;
    L8:
        if (isViewValid() == false) goto L107;
        String r0 = r7.getKey();
        r0.getClass();
        boolean r2 = false;
        byte r4 = -1;
        switch(r0.hashCode()) {
            case -1540323875: goto L46;
            case 61848565: goto L42;
            case 193203799: goto L38;
            case 262358348: goto L34;
            case 309908432: goto L30;
            case 1060055221: goto L26;
            case 1450672227: goto L22;
            case 1631824572: goto L18;
            case 1992738009: goto L14;
            default: goto L49;
        };
    L49:
        switch(r4) {
            case 0: goto L81;
            case 1: goto L77;
            case 2: goto L75;
            case 3: goto L72;
            case 4: goto L70;
            case 5: goto L68;
            case 6: goto L66;
            case 7: goto L52;
            case 8: goto L51;
            default: goto L108;
        };
    L51:
        this.m = ((Boolean) r7.getData()).booleanValue();
        return;
    L52:
        this.b = ((zg1.k3) r7.getData()).a;
        Cq();
        if (((Boolean) LiveInfraSettingKeys.LIVE_ENABLE_LANDSCAPE_LOG_FIX.getValue()).booleanValue() == true) goto L55;
        return;
    L55:
        if (zq((Room) ((Widget) this).dataCenter.get("data_room", null)) == true) goto L57;
    L59:
        this.k = r2;
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 != null) goto L62;
    L64:
        ALogger.i("LandscapeButtonWidget", "dataCenter || RoomContext is null");
    L65:
        Aq(this.k);
        return;
    L62:
        if (RoomContext.getShared(r8) == null) goto L64;
        RoomContext.getShared(((Widget) this).dataCenter).setLiveEnableSwitchLandscape(r2);
        goto L65
    L57:
        if (this.b == false) goto L59;
        r2 = true;
        goto L59
    L66:
        wq(((Integer) r7.getData()).intValue());
        return;
    L70:
        this.h = ((Boolean) r7.getData()).booleanValue();
        Cq();
        return;
    L75:
        Cq();
        return;
    L108:
        return;
    L68:
        if (this.v != null) goto L101;
        this.c = ((Boolean) r7.getData()).booleanValue();
        Cq();
        return;
    L101:
        return;
    L72:
        if (this.i == false) goto L109;
        this.f = false;
        Cq();
        return;
    L109:
        return;
    L77:
        if (this.i == false) goto L110;
        this.f = true;
        Cq();
        return;
    L110:
        return;
    L81:
        if (this.i == false) goto L111;
        zg1.z0 r9 = (zg1.z0) r7.getData();
        if (r9 == null) goto L112;
        int r10 = r9.a;
        if (r10 != 0) goto L89;
        this.e = true;
    L92:
        Cq();
        return;
    L89:
        if (r10 != 1) goto L91;
        this.e = false;
        goto L92
    L91:
        this.e = jc1.k.f(ILinkServiceExternal.class).getControlServiceExternal().c();
        goto L92
    L112:
        return;
    L111:
        return;
    L14:
        if (r0.equals("has_group_purchase_business") == false) goto L49;
        r4 = 8;
        goto L49
    L18:
        if (r0.equals("cmd_video_orientation_changed") == false) goto L49;
        r4 = 7;
        goto L49
    L22:
        if (r0.equals("data_feedback_bottombar_height") == false) goto L49;
        r4 = 6;
        goto L49
    L26:
        if (r0.equals("data_keyboard_status") == false) goto L49;
        r4 = 5;
        goto L49
    L30:
        if (r0.equals("data_media_introduction_showing") == false) goto L49;
        r4 = 4;
        goto L49
    L34:
        if (r0.equals("multi_anchor_sei_close") == false) goto L49;
        r4 = 3;
        goto L49
    L38:
        if (r0.equals("cmd_change_listen_live_status") == false) goto L49;
        r4 = 2;
        goto L49
    L42:
        if (r0.equals("multi_anchor_sei_update") == false) goto L49;
        r4 = 1;
        goto L49
    L46:
        if (r0.equals("cmd_pk_state_change") == false) goto L49;
        r4 = 0;
        goto L49
    L107:
        return;
    }

    public final void wq(int r4) {
        View r0 = ((Widget) this).contentView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() == 0) goto L7;
        return;
    L7:
        if (this.i == true) goto L10;
        return;
    L10:
        if ((((Widget) this).containerView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ((Widget) this).containerView.getLayoutParams();
        if (this.u != Integer.MIN_VALUE) goto L14;
        this.u = r1.bottomMargin;
    L14:
        r1.bottomMargin = this.u + r4;
        ((Widget) this).containerView.setLayoutParams(r1);
        return;
    }

    public final boolean zq(Room r3) {
        if (r3 != null) goto L5;
    L10:
        boolean r4 = true;
    L12:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this).dataCenter).isPaidLive() == false) goto L15;
        return true;
    L15:
        return r4;
    L5:
        if (r3.getRoomAuthStatus() == null) goto L10;
        if (r3.getRoomAuthStatus().isEnableSwitchLandscape() == true) goto L10;
        r4 = false;
        goto L12
    }
}
