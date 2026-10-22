package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.activity.BannerFullMonitor;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.l6;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.livesdk.banner.InRoomBannerManager;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.presenter.BottomRightBannerPresenter;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.message.model.ib;
import com.bytedance.android.livesdk.utils.b7;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class BottomRightBannerWidget extends MiddlewareRoomRecyclableWidget implements BottomRightBannerPresenter.IView, Observer<KVData>, q2 {
    public BottomRightBannerPresenter a;
    public vo1.a b;
    public IRoom c;
    public boolean d;
    public BannerInRoomCollection e;
    public boolean f;
    public x0 g;
    public boolean h;
    public String i;
    public final CompositeDisposable j;
    public y k;
    public com.bytedance.android.livesdk.chatroom.monitor.b l;
    public final GestureDetector m;
    public final b7<VisibilitySource, Integer> n;
    public final PropertyOwner<Boolean> o;

    public static final enum VisibilitySource extends Enum<VisibilitySource> {
        public static final VisibilitySource HIDE_BEFORE_LOADED = null;
        public static final VisibilitySource LANDSCAPE_SWITCH_CONTROLLER = null;
        public static final VisibilitySource UNCLASSIFIED = null;
        public static final VisibilitySource URL_PARAMETER = null;
        public static final /* synthetic */ VisibilitySource[] a = null;

        static {
            VisibilitySource r0 = new VisibilitySource("UNCLASSIFIED", 0);
            UNCLASSIFIED = r0;
            VisibilitySource r1 = new VisibilitySource("HIDE_BEFORE_LOADED", 1);
            HIDE_BEFORE_LOADED = r1;
            VisibilitySource r3 = new VisibilitySource("LANDSCAPE_SWITCH_CONTROLLER", 2);
            LANDSCAPE_SWITCH_CONTROLLER = r3;
            VisibilitySource r5 = new VisibilitySource("URL_PARAMETER", 3);
            URL_PARAMETER = r5;
            a = new VisibilitySource[]{r0, r1, r3, r5};
        }

        public static VisibilitySource[] values() {
            return (VisibilitySource[]) a.clone();
        }

        public static VisibilitySource valueOf(String r1) {
            return (VisibilitySource) r27.a.a(VisibilitySource.class, r1);
        }

        public VisibilitySource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ BottomRightBannerWidget a;

        public a(BottomRightBannerWidget r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r8) {
            IRoom r9 = this.a.c;
            if (r9 == null) goto L5;
            String r10 = String.valueOf(r9.getId());
        L6:
            String r2 = r10;
            BottomRightBannerWidget r11 = this.a;
            String r3 = r11.i;
            BannerFullMonitor.BannerType r5 = BannerFullMonitor.BannerType.BOTTOM_RIGHT;
            BannerInRoomCollection r12 = r11.e;
            if (r12 == null) goto L9;
            String r13 = r12.toString();
        L10:
            BannerFullMonitor.a("ttlive_activity_banner_on_click", 0, r2, r3, null, r5, r13);
            return false;
        L9:
            r13 = "";
            goto L10
        L5:
            r10 = "0";
            goto L6
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IBaseUser.Status.values().length];
            a = r0;
            r0[IBaseUser.Status.Login.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[IBaseUser.Status.Logout.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[IBaseUser.Status.Update.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public final int getLayoutId() {
        return 2131568004;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    public final String getSpm() {
        return "a100.a100.a213";
    }

    public final void onInit(Object... r1) {
    }

    public final void Aq() {
        if (this.c.getRoomAuthStatus() != null) goto L5;
    L8:
        UIUtils.setViewVisibility(((Widget) this).containerView, 0);
        return;
    L5:
        if (this.c.getRoomAuthStatus().enableBanner() == true) goto L8;
        UIUtils.setViewVisibility(((Widget) this).containerView, 8);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.android.livesdk.chatroom.viewmodule.k] */
    public BottomRightBannerWidget() {
        this.h = false;
        this.j = new CompositeDisposable();
        this.m = new GestureDetector(getContext(), new a(this));
        this.n = new b7(new k(this));
        this.o = new PropertyOwner(Boolean.TRUE);
    }

    public final void onClear() {
        super.onClear();
        vo1.a r0 = this.b;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.b = null;
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        if (this.b == null) goto L9;
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L6
        r1.put("foreground", false);     // Catch: Exception -> L6
        r0.put("type", "app");     // Catch: Exception -> L6
        r0.put("args", r1);     // Catch: Exception -> L6
        this.b.sendJsEvent("H5_appStateChange", r0);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        if (this.b == null) goto L9;
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L6
        r1.put("foreground", true);     // Catch: Exception -> L6
        r0.put("type", "app");     // Catch: Exception -> L6
        r0.put("args", r1);     // Catch: Exception -> L6
        this.b.sendJsEvent("H5_appStateChange", r0);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public final void onUnload() {
        com.bytedance.android.live.core.utils.i0.c().removeCallbacks(this.k);
        this.a.detachView();
        ((Widget) this).dataCenter.removeObserver(this);
        CompositeDisposable r0 = this.j;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.f = false;
        this.g = null;
        this.k = null;
        this.l = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.q2
    public final PropertyOwner cl() {
        return this.o;
    }

    public final void LU(ib r10) {
        String r1 = "0";
        if (r10 == null) goto L9;
        IRoom r2 = this.c;
        if (r2 == null) goto L7;
        String r3 = String.valueOf(r2.getId());
    L8:
        BannerFullMonitor.b(0, "", r3, BannerFullMonitor.BannerType.BOTTOM_RIGHT, r10.toString());
    L14:
        yq("");
        if (this.f == true) goto L25;
        Aq();
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L19;
        r4.put("data_right_bottom_banner_show", new zg1.m3(0, true));
    L19:
        vo1.a r0 = this.b;
        if (r0 != null) goto L22;
    L24:
        this.f = true;
        goto L25
    L22:
        if (r0.c() == null) goto L24;
        this.b.c().setVisibility(4);
        ((Widget) this).containerView.setVisibility(4);
        this.n.a(VisibilitySource.HIDE_BEFORE_LOADED, 4);
    L25:
        if (r10 != null) goto L27;
        return;
    L27:
        Uri r5 = UriProtector.parse(r10.getMBottomRightUrl());
        if (this.b == null) goto L34;
        if (r5 == null) goto L34;
        u6 r11 = new u6(r5);
        r11.b("request_page", "bottomright");
        r11.b("room_id", String.valueOf(this.c.getId()));
        r11.b("anchor_id", String.valueOf(this.c.getOwner().getIdString()));
        r11.b("user_id", String.valueOf(com.bytedance.android.livesdk.c.a().n()));
        zq(r11);
        this.i = r11.toString();
        IRoom r12 = this.c;
        if (r12 == null) goto L33;
        r1 = String.valueOf(r12.getId());
    L33:
        BannerFullMonitor.a("ttlive_activity_banner_on_load_start", 0, r1, this.i, null, BannerFullMonitor.BannerType.BOTTOM_RIGHT, "url:" + this.i);
        return;
    L34:
        IRoom r6 = this.c;
        if (r6 == null) goto L37;
        String r7 = String.valueOf(r6.getId());
    L38:
        BannerFullMonitor.a("ttlive_activity_banner_on_load_start", -1, r7, r10.getMBottomRightUrl(), null, BannerFullMonitor.BannerType.BOTTOM_RIGHT, "");
        return;
    L37:
        r7 = "0";
        goto L38
    L7:
        r3 = "0";
        goto L8
    L9:
        IRoom r8 = this.c;
        if (r8 == null) goto L12;
        String r9 = String.valueOf(r8.getId());
    L13:
        BannerFullMonitor.b(-1, "ProjectDModifyH5Message message is null", r9, BannerFullMonitor.BannerType.BOTTOM_RIGHT, "");
        goto L14
    L12:
        r9 = "0";
        goto L13
    }

    public final void VW(BannerInRoomCollection r19) {
        com.bytedance.android.livesdk.chatroom.monitor.b r2 = this.l;
        if (r2 == null) goto L6;
        r2.d("PROCESS_BANNER_DATA_START");
    L6:
        if (r19 != null) goto L8;
    L10:
        String r3 = "";
    L11:
        IRoom r4 = this.c;
        if (r4 == null) goto L14;
        String r5 = String.valueOf(r4.getId());
    L15:
        BannerFullMonitor.BannerType r9 = BannerFullMonitor.BannerType.BOTTOM_RIGHT;
        BannerFullMonitor.b(0, "", r5, r9, r3);
        if (isViewValid() == false) goto L94;
        if (r19 == null) goto L94;
        if (r19.getBottomRightBanner() == null) goto L94;
        if (Lists.isEmpty(r19.getBottomRightBanner().getBannerList()) == true) goto L94;
        this.f = true;
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L26;
        r6.put("data_right_bottom_banner_show", new zg1.m3(0, true));
    L26:
        vo1.a r7 = this.b;
        if (r7 != null) goto L29;
    L31:
        this.e = r19;
        BottomRightBannerPresenter r8 = this.a;
        String r1 = r19.getBottomRightBanner().getUrl();
        r8.getClass();
        com.bytedance.android.livesdk.log.filter.t r10 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r10 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L41;
        com.bytedance.android.livesdk.log.filter.t r11 = r10;
        if (r11.getMap().containsKey("enter_from") == false) goto L36;
        String r12 = (String) r11.getMap().get("enter_from");
    L38:
        if (r11.getMap().containsKey("source") == false) goto L40;
        String r13 = (String) r11.getMap().get("source");
    L42:
        com.bytedance.android.livesdk.log.filter.u r14 = com.bytedance.android.livesdk.log.j0.l().c(IRoom.class);
        if ((r14 instanceof com.bytedance.android.livesdk.log.filter.u) == false) goto L68;
        com.bytedance.android.livesdk.log.filter.u r15 = r14;
        if (r15.getMap().containsKey("anchor_id") == false) goto L51;
        Object r16 = r15.getMap().get("anchor_id");
        if (r16 == null) goto L51;
        if ((r16 instanceof String) == false) goto L51;
        String r17 = r16.toString();
    L53:
        if (r15.getMap().containsKey("log_pb") == false) goto L59;
        Object r18 = r15.getMap().get("log_pb");
        if (r18 == null) goto L59;
        if ((r18 instanceof String) == false) goto L59;
        String r20 = r18.toString();
    L61:
        if (r15.getMap().containsKey("request_id") == false) goto L67;
        Object r21 = r15.getMap().get("request_id");
        if (r21 == null) goto L67;
        if ((r21 instanceof String) == false) goto L67;
        String r22 = r21.toString();
    L69:
        u6 r110 = new u6(r1);
        r110.b("room_id", String.valueOf(r8.f.getId()));
        r110.b("mode", "live_room");
        r110.b("anchor_id", String.valueOf(r8.f.getOwner().getIdString()));
        r110.b("is_anchor", String.valueOf(r8.e));
        r110.b("enter_from", r12);
        r110.b("source_v3", r13);
        r110.b("anchor_id", r17);
        r110.b("log_pb", r20);
        r110.b("request_id", r22);
        if (r8.e == false) goto L72;
        String r23 = "live_take_detail";
    L73:
        r110.b("event_page", r23);
        r110.b("event_belong", "live_interact");
        r110.b("request_page", "bottomright");
        r110.b("user_id", String.valueOf(com.bytedance.android.livesdk.c.a().n()));
        this.i = r110.toString();
        com.bytedance.android.livesdk.chatroom.monitor.b r24 = this.l;
        if (r24 == null) goto L76;
        r24.d("PROCESS_BANNER_DATA_END");
    L76:
        com.bytedance.android.livesdk.chatroom.monitor.b r25 = this.l;
        if (r25 == null) goto L79;
        r25.d("CREATE_HYBRID_VIEW_START");
    L79:
        yq(r110.toString());
        com.bytedance.android.livesdk.chatroom.monitor.b r26 = this.l;
        if (r26 == null) goto L82;
        r26.d("CREATE_HYBRID_VIEW_END");
    L82:
        com.bytedance.android.livesdk.chatroom.monitor.b r27 = this.l;
        if (r27 == null) goto L85;
        r27.d("LOAD_URL_START");
    L85:
        zq(r110);
        com.bytedance.android.livesdk.chatroom.monitor.b r28 = this.l;
        if (r28 == null) goto L88;
        r28.d("LOAD_URL_END");
    L88:
        IRoom r29 = this.c;
        if (r29 == null) goto L91;
        String r30 = String.valueOf(r29.getId());
    L92:
        BannerFullMonitor.a("ttlive_activity_banner_on_load_start", 0, r30, this.i, null, r9, "");
        this.n.a(VisibilitySource.HIDE_BEFORE_LOADED, 4);
        Aq();
        return;
    L91:
        r30 = "0";
        goto L92
    L72:
        r23 = "live_detail";
    L67:
        r22 = "";
    L59:
        r20 = "";
    L51:
        r17 = "";
        goto L53
    L68:
        r20 = "";
        r22 = r20;
        r17 = r22;
        goto L69
    L40:
        r13 = "";
        goto L42
    L36:
        r12 = "";
        goto L38
    L41:
        r13 = "";
        r12 = r13;
        goto L42
    L29:
        if (r7.c() == null) goto L31;
        this.b.c().setVisibility(4);
        ((Widget) this).containerView.setVisibility(4);
    L94:
        this.f = false;
        DataCenter r31 = ((Widget) this).dataCenter;
        if (r31 == null) goto L97;
        r31.put("data_right_bottom_banner_show", new zg1.m3(0, false));
    L97:
        UIUtils.setViewVisibility(((Widget) this).containerView, 8);
        return;
    L14:
        r5 = "0";
        goto L15
    L8:
        if (r19.getBottomRightBanner() == null) goto L10;
        r3 = r19.getBottomRightBanner().toString();
        goto L11
    }

    public final void m5(com.bytedance.android.live.base.model.message.h1 r2) {
        if (isViewValid() == false) goto L12;
        if (r2 != null) goto L6;
        return;
    L6:
        if (this.b != null) goto L8;
        return;
    L8:
        if (r2.getExtra() == null) goto L15;
        ((SingleSubscribeProxy) Single.just(r2.getExtra()).observeOn(Schedulers.io()).map(new v()).map(new w(this)).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new x(this));
        return;
    L15:
        return;
    }

    public final void onChanged(Object r8) {
        KVData r9 = (KVData) r8;
        if (r9 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r9.getKey()) == false) goto L7;
        return;
    L7:
        if (r9.getData() == null) goto L73;
        String r0 = r9.getKey();
        r0.getClass();
        switch(r0.hashCode()) {
            case -2104158356: goto L29;
            case -1902389100: goto L25;
            case -1357019912: goto L21;
            case 1060055221: goto L17;
            case 1911516212: goto L13;
            default: goto L32;
        };
    L32:
        byte r1 = -1;
    L34:
        if (r1 == 0) goto L57;
        if (r1 == 1) goto L55;
        if (r1 == 2) goto L50;
        if (r1 == 3) goto L50;
        if (r1 == 4) goto L41;
        return;
    L41:
        if (r9.getData() != null) goto L44;
        return;
    L44:
        if (this.n != null) goto L47;
        return;
    L47:
        if (((Boolean) r9.getData()).booleanValue() == false) goto L49;
        this.n.b(VisibilitySource.LANDSCAPE_SWITCH_CONTROLLER);
        return;
    L49:
        this.n.a(VisibilitySource.LANDSCAPE_SWITCH_CONTROLLER, 8);
        return;
    L50:
        boolean r10 = ((Boolean) r9.getData()).booleanValue();
        vo1.a r2 = this.b;
        if (r2 != null) goto L53;
        return;
    L53:
        if (r2.c() == null) goto L69;
        this.b.c().setFocusable(!r10);
        return;
    L69:
        return;
    L55:
        Aq();
        return;
    L57:
        if (r9.getData() != null) goto L60;
        return;
    L60:
        if (((Integer) r9.getData()).intValue() == 0) goto L62;
        this.n.a(VisibilitySource.UNCLASSIFIED, 8);
        return;
    L62:
        this.n.a(VisibilitySource.UNCLASSIFIED, 0);
        return;
    L13:
        if (r0.equals("data_landscape_left_bottom_banner_visible") == false) goto L32;
        r1 = 4;
        goto L34
    L17:
        if (r0.equals("data_keyboard_status") == false) goto L32;
        r1 = 3;
        goto L34
    L21:
        if (r0.equals("data_pre_show_keyboard") == false) goto L32;
        r1 = 2;
        goto L34
    L25:
        if (r0.equals("cmd_refresh_bottom_right_banner_content") == false) goto L32;
        r1 = 1;
        goto L34
    L29:
        if (r0.equals("data_xt_landscape_tab_change") == false) goto L32;
        r1 = 0;
        goto L34
    }

    public final void onLoad(Object... r5) {
        this.n.a(VisibilitySource.HIDE_BEFORE_LOADED, 8);
        ViewGroup.LayoutParams r6 = ((Widget) this).contentView.getLayoutParams();
        if (this.dataContext == null) goto L6;
        ((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue();
    L6:
        if (this.h == false) goto L8;
        r6.width = -1;
        r6.height = -1;
    L10:
        if (((Boolean) l6.a.getValue()).booleanValue() == false) goto L12;
        r6.width = -1;
        r6.height = UIUtils.getScreenHeight(((Widget) this).context) / 2;
    L12:
        ((Widget) this).contentView.setLayoutParams(r6);
        vo1.a r7 = this.b;
        if (r7 != null) goto L15;
    L17:
        ((Widget) this).containerView.setVisibility(4);
        if (((Widget) this).dataCenter.get("data_is_anchor") == null) goto L21;
        this.d = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor")).booleanValue();
    L21:
        if (((Widget) this).dataCenter.get("data_room") != null) goto L23;
        return;
    L23:
        IRoom r8 = (IRoom) ((Widget) this).dataCenter.get("data_room");
        this.c = r8;
        if (r8 == null) goto L26;
        long r0 = r8.getId();
    L27:
        int r9 = x40.b.a;
        int r10 = com.bytedance.android.livesdk.chatroom.monitor.a.a;
        Intrinsics.checkNotNullParameter("top_right_banner", "activityType");
        if (((Boolean) LiveInfraSettingKeys.LIVE_ACTIVIY_TIME_MONITOR_SWITCH.getValue()).booleanValue() == false) goto L30;
        com.bytedance.android.livesdk.chatroom.monitor.b r11 = new com.bytedance.android.livesdk.chatroom.monitor.b(r0, true);
    L31:
        this.l = r11;
        if (r11 == null) goto L34;
        Intrinsics.checkNotNullParameter("H5", "containerType");
        r11.f = "H5";
        this.l.d("BANNER_WIDGET_ONLOAD");
    L34:
        CompositeDisposable r12 = this.j;
        if (r12 == null) goto L37;
        r12.clear();
    L37:
        BottomRightBannerPresenter r13 = new BottomRightBannerPresenter(this.c, this.d);
        this.a = r13;
        r13.g0(this);
        InRoomBannerManager r14 = (InRoomBannerManager) ((Widget) this).dataCenter.get("data_in_room_banner_manager", null);
        if (r14 == null) goto L43;
        com.bytedance.android.livesdk.chatroom.monitor.b r1 = this.l;
        if (r1 == null) goto L42;
        r1.d("FETCH_BANNER_DATA_START");
    L42:
        ((ObservableSubscribeProxy) r14.d(Long.valueOf(this.c.getId()), 1).as(autoDispose())).subscribe(new p(this), new q(this));
    L43:
        ((Widget) this).dataCenter.observe("data_pre_show_keyboard", this).observe("data_xt_landscape_tab_change", this).observe("cmd_refresh_bottom_right_banner_content", this).observe("data_keyboard_status", this).observe("data_landscape_left_bottom_banner_visible", this);
        this.j.add(xs2.b.a().b(com.bytedance.android.livesdk.event.c.class).subscribe(new r(this)));
        this.j.add(xs2.b.a().b(b30.b.class).subscribe(new s(this)));
        com.bytedance.android.livesdk.user.e r15 = com.bytedance.android.livesdk.c.a();
        if (r15 == null) goto L47;
        ((com.bytedance.android.live.core.utils.rxutils.autodispose.v) r15.m().onBackpressureLatest().filter(new t()).as(AutoDispose.bind(this))).subscribe(new u(this));
        return;
    L47:
        return;
    L30:
        r11 = null;
        goto L31
    L26:
        r0 = 0;
        goto L27
    L15:
        if (r7.c() == null) goto L17;
        this.b.c().setVisibility(4);
        goto L17
    L8:
        r6.width = com.bytedance.android.live.core.utils.s1.j(2131169190);
        r6.height = com.bytedance.android.live.core.utils.s1.j(2131169188);
        goto L10
    }

    public final Unit xq(Map<VisibilitySource, ? extends Integer> r3) {
        if (((Widget) this).contentView == null) goto L5;
        Integer r0 = r3.get(VisibilitySource.LANDSCAPE_SWITCH_CONTROLLER);
        boolean r1 = false;
        if (r0 == null) goto L9;
        ((Widget) this).contentView.setVisibility(r0.intValue());
    L20:
        if (((Widget) this).contentView.getVisibility() == 0) goto L22;
        r1 = true;
    L22:
        this.o.a(Boolean.valueOf(r1));
        if (z51.a.d(this.dataContext) == null) goto L25;
        z51.a.d(this.dataContext).r(r1);
    L25:
        x0 r4 = this.g;
        if (r4 == null) goto L31;
        if (r1 == false) goto L29;
        r4.hide();
        goto L31
    L29:
        r4.show();
    L31:
        return Unit.INSTANCE;
    L9:
        Integer r2 = r3.get(VisibilitySource.URL_PARAMETER);
        if (r2 == null) goto L12;
        ((Widget) this).contentView.setVisibility(r2.intValue());
        goto L20
    L12:
        Integer r5 = r3.get(VisibilitySource.HIDE_BEFORE_LOADED);
        if (r5 == null) goto L15;
        ((Widget) this).contentView.setVisibility(r5.intValue());
        goto L20
    L15:
        Integer r6 = r3.get(VisibilitySource.UNCLASSIFIED);
        if (r6 == null) goto L18;
        ((Widget) this).contentView.setVisibility(r6.intValue());
        goto L20
    L18:
        ((Widget) this).contentView.setVisibility(0);
        goto L20
    L5:
        return Unit.INSTANCE;
    }

    public final void yq(String r8) {
        if (this.b == null) goto L28;
        return;
    L28:
        int r0 = vo1.e.a;     // Catch: Throwable -> L7
        vo1.a r1 = new vo1.a();     // Catch: Throwable -> L7
        this.b = r1;     // Catch: Throwable -> L7
        r1.d((Activity) ((Widget) this).context, r8, new l(this), new m(this), getSpm());     // Catch: Throwable -> L7
    L9:
        vo1.a r9 = this.b;
        if (r9 == null) goto L23;
        int r2 = com.bytedance.android.livesdk.utils.e.a;
        Intrinsics.checkNotNullParameter(r9, "$this$getWebView");
        if (r9.hybridType() != IHybridComponent.HybridType.H5) goto L14;
        WebView r10 = (WebView) r9.g();
    L15:
        if (r10 == null) goto L23;
        if (this.b.c() == null) goto L23;
        this.b.c().setBackgroundColor(0);
        this.b.c().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ((ViewGroup) ((Widget) this).contentView).addView(this.b.c());
        vo1.a r11 = this.b;
        if (r11 == null) goto L23;
        if (r11.c() == null) goto L23;
        this.b.c().setOnTouchListener(new o(this));
        goto L23
    L14:
        r10 = null;
    L23:
        vo1.a r12 = this.b;
        if (r12 == null) goto L30;
        ((Widget) this).contentView.setFocusable(true);
        ((Widget) this).contentView.setClickable(true);
        r12.registerMethod("setContentDescription", new n(this));
        return;
    L30:
        return;
    L7:
        th = move-exception;
        ALogger.e("BottomRightBannerWidget", th);
        goto L9
    }

    public final void zq(u6 r4) {
        if ("1".equals(r4.a("bottom_right_banner_hide")) == false) goto L5;
        this.n.a(VisibilitySource.URL_PARAMETER, 8);
    L6:
        vo1.a r0 = this.b;
        if (r0 == null) goto L10;
        r0.loadUrl(r4.toString());
        return;
    L10:
        return;
    L5:
        this.n.b(VisibilitySource.URL_PARAMETER);
        goto L6
    }

    public static /* synthetic */ JSONObject wq(BottomRightBannerWidget r8, String r9) {
        r8.getClass();
        JSONObject r0 = new JSONObject();
        r0.put("type", "refresh");
        r0.put("data", r9);
        JSONObject r10 = new JSONObject();
        com.bytedance.android.livesdk.log.filter.t r1 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        String r5 = "";
        if ((r1 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L15;
        com.bytedance.android.livesdk.log.filter.t r2 = r1;
        if (r2.getMap().containsKey("enter_from") == false) goto L7;
        String r3 = (String) r2.getMap().get("enter_from");
    L9:
        if (r2.getMap().containsKey("source") == false) goto L11;
        r5 = (String) r2.getMap().get("source");
    L11:
        HashMap r4 = new HashMap();
        com.bytedance.android.livesdk.chatroom.r r6 = z51.a.d(r8.dataContext);
        if (r6 == null) goto L14;
        r6.dataMapping(r3, r5, r4);
    L14:
        r5 = (String) r4.get("enter_from_merge");
        String r7 = (String) r4.get("enter_method");
    L16:
        JSONObject r11 = r10.put("enter_from_merge", r5).put("enter_method", r7);
        if (r8.d == false) goto L19;
        String r12 = "live_take_detail";
    L20:
        r11.put("event_page", r12).put("room_id", String.valueOf(r8.c.getId())).put("anchor_id", String.valueOf(r8.c.getOwnerUserIdString())).put("request_id", r8.c.getRequestId()).put("log_pb", r8.c.getLog_pb());
        r0.put("log", r10);
        return r0;
    L19:
        r12 = "live_detail";
        goto L20
    L7:
        r3 = "";
        goto L9
    L15:
        r7 = "";
        goto L16
    }
}
