package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.screenrotation.entrance.EntranceChecker;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.FullVideoButtonWidgetPaidUtil;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.config.lj;
import com.bytedance.android.livesdk.config.m91;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomFullVideoBtn;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPlatformComponentsData;
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
public class NewFullVideoButtonWidget extends LiveWidget implements Observer<KVData>, com.bytedance.android.livesdk.chatroom.vsplayer.model.a, com.bytedance.android.live.room.api.visibilitycontrol.b {
    public EntranceChecker A;
    public boolean B;
    public long a;
    public IRoom b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public HSImageView o;
    public View p;
    public boolean q;
    public h2 r;
    public final CompositeDisposable s;
    public Disposable t;
    public Disposable u;
    public Disposable v;
    public ObjectAnimator w;
    public long x;
    public int y;
    public boolean z;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ NewFullVideoButtonWidget b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            super.onAnimationEnd(r2);
            if (this.a == true) goto L6;
            this.b.o.setVisibility(8);
            return;
        }

        public a(NewFullVideoButtonWidget r1, boolean r2) {
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

    public final boolean Aq() {
        RoomContext.a r0 = RoomContext.Companion;
        DataCenter r1 = ((Widget) this).dataCenter;
        long r2 = this.a;
        r0.getClass();
        RoomContext r3 = RoomContext.a.a(r1, r2);
        if (lj.a.getValue().b() != 2) goto L10;
        if (r3 == null) goto L10;
        if (zq(((Widget) this).dataCenter) == true) goto L10;
        if (r3.isShowFullScreenUIByClickScreen().getValue() == null) goto L10;
        return !((Boolean) r3.isShowFullScreenUIByClickScreen().getValue()).booleanValue();
    L10:
        return false;
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
        Cq(this.d);
    L5:
        this.s.clear();
        yq();
        ((Widget) this).dataCenter.removeObserver(this);
        ObjectAnimator r0 = this.w;
        if (r0 == null) goto L8;
        r0.cancel();
        this.w.removeAllListeners();
        this.w = null;
    L8:
        RoomContext r1 = RoomContext.getShared(((Widget) this).dataCenter);
        if (r1 == null) goto L11;
        ((ig1.b) r1.getCastScreenEntryDismissTimer().getValue()).release();
    L11:
        hd0.c.f().e(this.r);
        super.onDestroy();
        xq(0);
        this.y = Integer.MIN_VALUE;
        WeakReference<View> r2 = FullVideoButtonWidgetPaidUtil.c;
        if (r2 == null) goto L14;
        r2.clear();
    L14:
        Disposable r3 = FullVideoButtonWidgetPaidUtil.b;
        if (r3 == null) goto L17;
        r3.dispose();
    L17:
        EntranceChecker r4 = this.A;
        if (r4 == null) goto L21;
        r4.h();
        return;
    }

    public final void yq() {
        Disposable r0 = this.t;
        if (r0 != null) goto L5;
    L7:
        Disposable r1 = this.u;
        if (r1 != null) goto L10;
    L12:
        Disposable r2 = this.v;
        if (r2 != null) goto L15;
        return;
    L15:
        if (r2.isDisposed() == true) goto L19;
        this.v.dispose();
        return;
    L19:
        return;
    L10:
        if (r1.isDisposed() == true) goto L12;
        this.u.dispose();
        goto L12
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.t.dispose();
        goto L7
    }

    public NewFullVideoButtonWidget() {
        this.c = true;
        this.d = false;
        this.e = false;
        this.f = true;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = true;
        this.m = false;
        this.n = false;
        this.q = false;
        this.s = new CompositeDisposable();
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = 0;
        this.y = Integer.MIN_VALUE;
        this.z = false;
        this.B = true;
    }

    public final void Gq() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        Room r0 = (Room) ((Widget) this).dataCenter.get("data_room", null);
        boolean r1 = Bq(r0);
        int r3 = 0;
        if (r1 == true) goto L8;
    L28:
        boolean r4 = false;
    L29:
        this.f = r4;
        if (this.o.getVisibility() == 0) goto L32;
        boolean r5 = true;
    L33:
        StringBuilder r6 = new StringBuilder("isEnableSwitchLandscape:");
        r6.append(r1);
        r6.append("\tmIsVideoHorizontal:");
        r6.append(this.c);
        r6.append("\t!mIsShowKeyboard:");
        r6.append(!this.e);
        r6.append("\t!mIsInLinkMode:");
        r6.append(!this.g);
        r6.append("\t!mIsInMultiLinkMode:");
        r6.append(!this.h);
        r6.append("\tisShowEntrance:");
        r6.append(this.B);
        r6.append("\tmIsMultiFoldFlatState:");
        r6.append(this.n);
        r6.append("\t!mIsMediaIntroduceShowing:");
        r6.append(!this.k);
        ALogger.i("FullButton", r6.toString());
        HSImageView r2 = this.o;
        if (this.f == true) goto L37;
        r3 = 8;
    L37:
        r2.setVisibility(r3);
        if (Aq() == false) goto L40;
        this.o.setVisibility(8);
    L40:
        if (r5 == true) goto L42;
    L44:
        if (r5 == true) goto L46;
        return;
    L46:
        if (Aq() == false) goto L48;
        return;
    L48:
        if (this.f == false) goto L55;
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L56;
        com.bytedance.android.livesdk.castscreen.utils.f.b("screen_rotate_icon_show", r7, r0, new e2(this));
        return;
    L56:
        return;
    L55:
        return;
    L42:
        if (Aq() == true) goto L44;
        ut1.h.c();
        goto L44
    L32:
        r5 = false;
        goto L33
    L8:
        if (this.c == false) goto L28;
        if (this.e == true) goto L28;
        if (this.g == false) goto L16;
        if (this.z == false) goto L28;
    L16:
        if (this.h == false) goto L22;
        IRoom r8 = this.b;
        if (r8 == null) goto L28;
        if (r8.getStreamType() != LiveMode.SCREEN_RECORD) goto L28;
    L22:
        if (this.B == false) goto L28;
        if (this.n == true) goto L28;
        if (this.k == true) goto L28;
        r4 = true;
        goto L29
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [com.bytedance.android.livesdk.chatroom.viewmodule.h2] */
    public final void onCreate() {
        super.onCreate();
        this.o = ((Widget) this).contentView.findViewById(2131373342);
        this.p = ((Widget) this).contentView.findViewById(2131373344);
        boolean r2 = true;
        com.bytedance.android.livesdk.r3.c(this.o, com.bytedance.android.live.core.utils.s1.B(2131918651), true);
        ((Widget) this).dataCenter.observe("data_keyboard_status", this).observe("cmd_pk_state_change", this, true).observe("multi_anchor_sei_update", this, true).observe("multi_anchor_sei_close", this, true).observe("cmd_video_orientation_changed", this, true).observe("data_media_introduction_showing", this).observe("paid_live_paid_info_update", this).observe("data_feedback_bottombar_height", this).observe("cmd_multi_state_change", this);
        ((Widget) this).dataCenter.observe("data_pc_landscape_linkmic", this);
        this.a = ((Long) ((Widget) this).dataCenter.get("data_room_id")).longValue();
        this.o.setOnClickListener(new f2(this));
        DataCenter r0 = ((Widget) this).dataCenter;
        Boolean r3 = Boolean.TRUE;
        this.l = ((Boolean) r0.get("data_is_portrait", r3)).booleanValue();
        EntranceChecker r1 = this.A;
        if (r1 == null) goto L5;
        r1.d();
        this.B = this.A.a(com.bytedance.android.live.room.api.screenrotation.entrance.c.b);
        this.s.add(((z51.d) this.A.b).b.subscribe(new g2(this)));
    L5:
        zg1.u1 r4 = (zg1.u1) ((Widget) this).dataCenter.get("cmd_multi_state_change");
        if (r4 != null) goto L8;
    L10:
        this.r = new h2(this);
        hd0.c.f().c(this.r);
        RoomContext.a r5 = RoomContext.Companion;
        DataCenter r6 = ((Widget) this).dataCenter;
        long r7 = this.a;
        r5.getClass();
        RoomContext r8 = RoomContext.a.a(r6, r7);
        if (r8 == null) goto L16;
        if (r8.getRoom() == null) goto L16;
        this.b = (IRoom) r8.getRoom().getValue();
    L16:
        if (((Boolean) LiveInfraSettingKeys.LIVE_MULTI_DEVICE_BLOCK_FULL_SCREEN_MODE.getValue()).booleanValue() == false) goto L24;
        boolean r9 = com.bytedance.android.livesdk.chatroom.utils.e1.b();
        this.m = r9;
        if (r9 == true) goto L20;
    L22:
        boolean r10 = false;
    L23:
        this.n = r10;
        goto L24
    L20:
        if (com.bytedance.android.livesdk.chatroom.utils.e1.c() == false) goto L22;
        r10 = true;
    L24:
        Gq();
        if (zq(((Widget) this).dataCenter) == false) goto L27;
    L40:
        this.y = Integer.MIN_VALUE;
        mk1.a r11 = FullVideoButtonWidgetPaidUtil.a;
        FullVideoButtonWidgetPaidUtil.a(((Widget) this).dataCenter, ((Widget) this).containerView);
        if (((m91) LiveInfraSettingKeys.LIVE_XML_AND_DRAWABLE_CACHE_CONFIG.getValue()).a() == false) goto L46;
        int[] r12 = {2131251018, 2131251019};
        JatoOptDrawableCache.preloadDrawableCache(((Widget) this).context.getResources(), r12);     // Catch: Exception -> L45
    L46:
        com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.b.N;
        if (((Boolean) r13.getValue()).booleanValue() == true) goto L54;
        if (((Boolean) ((Widget) this).dataCenter.get("data_longer_video_within_live_type", Boolean.FALSE)).booleanValue() == false) goto L52;
        TimeUnit r14 = TimeUnit.SECONDS;
        this.u = Observable.timer(20, r14).observeOn(AndroidSchedulers.mainThread()).subscribe(new j2(this));
        this.v = Observable.timer(25, r14).observeOn(AndroidSchedulers.mainThread()).subscribe(new k2(this));
        com.bytedance.android.livesdk.sharedpref.f.d(r13, Boolean.TRUE);
        goto L54
    L52:
        this.p.setVisibility(8);
    L54:
        if (((Boolean) LiveInfraSettingKeys.LIVE_ENABLE_LANDSCAPE_LOG_FIX.getValue()).booleanValue() == true) goto L56;
        return;
    L56:
        if (Bq((Room) ((Widget) this).dataCenter.get("data_room", null)) == true) goto L58;
    L60:
        r2 = false;
    L61:
        this.d = r2;
        DataCenter r15 = ((Widget) this).dataCenter;
        if (r15 != null) goto L64;
    L66:
        ALogger.i("LandscapeButtonWidget", "dataCenter || RoomContext is null");
        return;
    L64:
        if (RoomContext.getShared(r15) == null) goto L66;
        RoomContext.getShared(((Widget) this).dataCenter).setLiveEnableSwitchLandscape(r2);
        return;
    L58:
        if (this.c == false) goto L60;
    L27:
        if (com.bytedance.android.livesdk.utils.landscape.d.a() != 1) goto L29;
        boolean r16 = true;
    L30:
        if (r16 == false) goto L40;
        if (this.f == true) goto L34;
    L39:
        ((ObservableSubscribeProxy) r8.isShowFullScreenUIByClickScreen().a().as(autoDispose())).subscribe(new l2(this));
        goto L40
    L34:
        if (r8.isShowFullScreenUIByClickScreen().getValue() == null) goto L36;
        r8.isShowFullScreenUIByClickScreen().setValue(r3);
    L36:
        final RoomContext r17 = RoomContext.getShared(((Widget) this).dataCenter);
        if (r17 == null) goto L39;
        yq();
        this.t = ((ig1.b) r17.getCastScreenEntryDismissTimer().getValue()).a().observeOn(AndroidSchedulers.mainThread()).subscribe(new i2(r17));
        goto L39
    L29:
        r16 = false;
        goto L30
    L8:
        if (this.l == false) goto L10;
        Eq(r4);
        goto L10
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
        Fq(true);
        yq();
        this.t = Observable.timer(r0.getValue().a(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new m2(r4));
        return;
    }

    public static boolean zq(DataCenter r2) {
        Room r3 = (Room) r2.get("data_room", null);
        if (r3 == null) goto L12;
        RoomPlatformComponentsData r0 = r3.roomPlatformComponentsData;
        if (r0 != null) goto L7;
        return true;
    L7:
        if (r0.getFullVideoBtn() != null) goto L9;
        return true;
    L9:
        if (r3.roomPlatformComponentsData.getFullVideoBtn().getShowType() != RoomFullVideoBtn.FullVideoBtnShowType.is_AUTO_DISMISS.getType()) goto L16;
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public final boolean Bq(Room r3) {
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

    public final void Cq(boolean r5) {
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

    public final void Eq(zg1.u1 r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.f != 1) goto L7;
        this.h = true;
    L9:
        if (r4.m == false) goto L11;
        this.z = true;
        this.h = false;
    L12:
        Gq();
        return;
    L11:
        this.z = false;
        goto L12
    L7:
        this.h = false;
        goto L9
    }

    public final void Fq(boolean r4) {
        if (zq(((Widget) this).dataCenter) == false) goto L5;
        return;
    L5:
        ObjectAnimator r0 = this.w;
        if (r0 == null) goto L11;
        if (r0.isRunning() != true) goto L11;
        this.w.cancel();
    L11:
        if (r4 == false) goto L13;
        this.w = ObjectAnimator.ofFloat(this.o, "alpha", new float[]{0.0f, 1.0f});
    L14:
        this.w.setDuration(500);
        this.w.removeAllListeners();
        this.w.addListener(new a(this, r4));
        this.w.start();
        return;
    L13:
        this.w = ObjectAnimator.ofFloat(this.o, "alpha", new float[]{1.0f, 0.0f});
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
        if (isViewValid() == false) goto L88;
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.getData() != null) goto L8;
        return;
    L8:
        if (isViewValid() == false) goto L101;
        String r0 = r7.getKey();
        r0.getClass();
        boolean r2 = true;
        byte r4 = -1;
        switch(r0.hashCode()) {
            case -1540323875: goto L42;
            case -1091008631: goto L38;
            case 192996530: goto L34;
            case 309908432: goto L30;
            case 1060055221: goto L26;
            case 1450672227: goto L22;
            case 1631824572: goto L18;
            case 1992738009: goto L14;
            default: goto L45;
        };
    L45:
        switch(r4) {
            case 0: goto L76;
            case 1: goto L70;
            case 2: goto L68;
            case 3: goto L67;
            case 4: goto L65;
            case 5: goto L63;
            case 6: goto L48;
            case 7: goto L47;
            default: goto L102;
        };
    L47:
        this.q = ((Boolean) r7.getData()).booleanValue();
        return;
    L48:
        this.c = ((zg1.k3) r7.getData()).a;
        Gq();
        if (((Boolean) LiveInfraSettingKeys.LIVE_ENABLE_LANDSCAPE_LOG_FIX.getValue()).booleanValue() == true) goto L51;
        return;
    L51:
        if (Bq((Room) ((Widget) this).dataCenter.get("data_room", null)) == true) goto L53;
    L55:
        r2 = false;
    L56:
        this.d = r2;
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 != null) goto L59;
    L61:
        ALogger.i("LandscapeButtonWidget", "dataCenter || RoomContext is null");
    L62:
        Cq(this.d);
        return;
    L59:
        if (RoomContext.getShared(r8) == null) goto L61;
        RoomContext.getShared(((Widget) this).dataCenter).setLiveEnableSwitchLandscape(r2);
        goto L62
    L53:
        if (this.c == false) goto L55;
    L63:
        xq(((Integer) r7.getData()).intValue());
        return;
    L67:
        this.k = ((Boolean) r7.getData()).booleanValue();
        Gq();
        return;
    L68:
        this.j = ((Boolean) r7.getData()).booleanValue();
        wq(((Integer) ((ge1.a) hd0.c.f()).b).intValue());
        return;
    L102:
        return;
    L65:
        if (this.A != null) goto L95;
        this.e = ((Boolean) r7.getData()).booleanValue();
        Gq();
        return;
    L95:
        return;
    L70:
        if (this.l == true) goto L73;
        return;
    L73:
        if (r7.getData() == null) goto L99;
        Eq((zg1.u1) r7.getData());
        return;
    L99:
        return;
    L76:
        if (this.l == false) goto L104;
        zg1.z0 r9 = (zg1.z0) r7.getData();
        if (r9 == null) goto L105;
        int r1 = r9.a;
        if (r1 != 0) goto L84;
        this.g = true;
        this.z = r9.c;
    L86:
        Gq();
        return;
    L84:
        if (r1 != 1) goto L86;
        this.g = false;
        this.z = false;
        goto L86
    L105:
        return;
    L104:
        return;
    L14:
        if (r0.equals("has_group_purchase_business") == false) goto L45;
        r4 = 7;
        goto L45
    L18:
        if (r0.equals("cmd_video_orientation_changed") == false) goto L45;
        r4 = 6;
        goto L45
    L22:
        if (r0.equals("data_feedback_bottombar_height") == false) goto L45;
        r4 = 5;
        goto L45
    L26:
        if (r0.equals("data_keyboard_status") == false) goto L45;
        r4 = 4;
        goto L45
    L30:
        if (r0.equals("data_media_introduction_showing") == false) goto L45;
        r4 = 3;
        goto L45
    L34:
        if (r0.equals("data_pc_landscape_linkmic") == false) goto L45;
        r4 = 2;
        goto L45
    L38:
        if (r0.equals("cmd_multi_state_change") == false) goto L45;
        r4 = 1;
        goto L45
    L42:
        if (r0.equals("cmd_pk_state_change") == false) goto L45;
        r4 = 0;
        goto L45
    L101:
        return;
    }

    public final void onConfigurationChanged(Configuration r1) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r1);
        if (this.m == false) goto L6;
        this.n = com.bytedance.android.livesdk.chatroom.utils.e1.c();
        Gq();
        return;
    }

    public final void wq(int r6) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L25;
        Room r1 = (Room) r0.get("data_room", null);
        if (r1 == null) goto L23;
        RoomPlatformComponentsData r2 = r1.roomPlatformComponentsData;
        if (r2 == null) goto L23;
        if (r2.getFullVideoBtn() == null) goto L23;
        if (r1.roomPlatformComponentsData.getFullVideoBtn().getShow() == RoomFullVideoBtn.FullVideoBtnShow.is_Close.getType()) goto L23;
        if (r6 != 0) goto L19;
        if (r1.roomPlatformComponentsData.getFullVideoBtn().getIcon() != null) goto L17;
        ImageLoader.bindDrawableResource(this.o, 2131251018);
    L22:
        this.o.setVisibility(0);
        return;
    L17:
        com.bytedance.android.livesdk.chatroom.utils.a1.x(this.o, r1.roomPlatformComponentsData.getFullVideoBtn().getIcon(), (int) t6.a(((Widget) this).context, 36.0f), (int) t6.a(((Widget) this).context, 36.0f), 2131251018);
        goto L22
    L19:
        if (r1.roomPlatformComponentsData.getFullVideoBtn().getIcon() != null) goto L21;
        ImageLoader.bindDrawableResource(this.o, 2131251019);
        goto L22
    L21:
        com.bytedance.android.livesdk.chatroom.utils.a1.x(this.o, r1.roomPlatformComponentsData.getFullVideoBtn().getDisableIcon(), (int) t6.a(((Widget) this).context, 36.0f), (int) t6.a(((Widget) this).context, 36.0f), 2131251019);
    L23:
        this.o.setVisibility(8);
        return;
    }

    public final void xq(int r4) {
        View r0 = ((Widget) this).contentView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() == 0) goto L7;
        return;
    L7:
        if (this.l == true) goto L10;
        return;
    L10:
        if ((((Widget) this).containerView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ((Widget) this).containerView.getLayoutParams();
        if (this.y != Integer.MIN_VALUE) goto L14;
        this.y = r1.bottomMargin;
    L14:
        r1.bottomMargin = this.y + r4;
        ((Widget) this).containerView.setLayoutParams(r1);
        return;
    }
}
