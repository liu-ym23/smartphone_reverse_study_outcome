package com.bytedance.android.livesdk.interactivity.enteranim;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.MainPostOptUtils;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.k1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.o0;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.common.i;
import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.config.ou;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.api.comment.data.KeyboardViewModel;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.HighlevelNoMessageMonitorEnum;
import com.bytedance.android.livesdk.interactivity.api.settings.config.u;
import com.bytedance.android.livesdk.interactivity.common.utils.j;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.g;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.h;
import com.bytedance.android.livesdk.interactivity.enteranim.view.EnterAnimationView;
import com.bytedance.android.livesdk.interactivity.service.monitor.EventName;
import com.bytedance.android.livesdk.interactivity.service.monitor.MonitorEvent;
import com.bytedance.android.livesdk.interactivity.service.monitor.UploadMode;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.room.EnterRoomRedirect;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import r52.b4;
import r52.h1;
import r52.i1;
import r52.r0;
import r72.f;
import r72.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class EnterAnimWidget extends MiddlewareRoomRecyclableWidget implements l, Observer<KVData>, vlc.l, i {
    public Boolean a;
    public EnterAnimationView b;
    public s72.d c;
    public final CompositeDisposable d;
    public o e;
    public InteractivityPlatformContext f;
    public InteractionWidgetsPosContext g;
    public final h h;
    public final s72.b i;
    public boolean j;
    public com.bytedance.android.livesdk.interactivity.common.utils.i k;
    public boolean l;
    public final a m;
    public final b n;

    public class a implements com.bytedance.android.livesdk.interactivity.d {
        public final /* synthetic */ EnterAnimWidget a;

        public a(EnterAnimWidget r1) {
            this.a = r1;
        }
    }

    public class b implements vlc.l {
        public final /* synthetic */ EnterAnimWidget a;

        public b(EnterAnimWidget r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r6) {
            if ((r6 instanceof va) == false) goto L14;
            va r7 = (va) r6;
            if (r7.j0() != EnterRoomRedirect.REDIRECT_FROM_COLLABORATE_ENTER_ROOM.getValue()) goto L8;
            return;
        L8:
            if (this.a.isScreenPortrait() == true) goto L10;
            return;
        L10:
            if (this.a.yq(r7) == true) goto L16;
            r7.setFromRtcRoom(true);
            this.a.i.a(r7);
            return;
        L16:
            return;
        }
    }

    public class c implements Function0<Unit> {
        public final /* synthetic */ EnterAnimWidget a;

        public final Object invoke() {
            ALogger.i("EnterAnimWidget", "rtcMessageManager Null Callback");
            if (((u) b4.a.getValue()).d() == false) goto L18;
            EnterAnimationView r0 = this.a.b;
            if (r0 == null) goto L18;
            if (r0.getEntryController() == null) goto L18;
            Iterator<Map.Entry<Long, Deque<k32.a>>> r1 = ((v72.c) this.a.b.getEntryController()).e.c.a.entrySet().iterator();
        L10:
            if (r1.hasNext() == false) goto L18;
            Iterator<k32.a> r2 = r1.next().getValue().iterator();
        L13:
            if (r2.hasNext() == false) goto L10;
            if (r2.next().r == false) goto L13;
            r2.remove();
        L18:
            return Unit.INSTANCE;
        }

        public c(EnterAnimWidget r1) {
            this.a = r1;
        }
    }

    public class d implements t72.a.c {
        public final /* synthetic */ k32.a a;
        public final /* synthetic */ EnterAnimWidget b;

        public d(EnterAnimWidget r1, k32.a r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final int getLayoutId() {
        return 2131568009;
    }

    public final String getSpm() {
        return "a100.a100.a249";
    }

    public final String nc() {
        return "EnterAnimWidget";
    }

    public final /* synthetic */ boolean nq() {
        return com.bytedance.android.livesdk.common.h.a();
    }

    public final int supportClearScene() {
        return 1333;
    }

    public final String Lg() {
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (com.bytedance.android.livesdk.common.h.a() == true) goto L7;
        return null;
    L7:
        if (r0.getVisibility() != 8) goto L9;
        return null;
    L9:
        if (r0.getVisibility() == 4) goto L16;
        this.h.a(r0, 6, true);
        this.a = Boolean.TRUE;
        ALogger.i("CleanScreenManager", "EnterAnimWidget GONE");
        return "EnterAnimWidget";
    L16:
        return null;
    }

    public final String cg() {
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (com.bytedance.android.livesdk.common.h.a() == true) goto L7;
        return null;
    L7:
        if (this.a.booleanValue() == false) goto L13;
        this.h.a(r0, 6, false);
        this.a = Boolean.FALSE;
        ALogger.i("CleanScreenManager", "EnterAnimWidget SHOW");
        return "EnterAnimWidget";
    L13:
        return null;
    }

    public final void onUnload() {
        ALogger.i("EnterAnimWidget", "onUnload");
        if (g.a.booleanValue() == true) goto L5;
    L38:
        ((Widget) this).dataCenter.removeObserver(this);
        EnterAnimationView r0 = this.b;
        if (r0 == null) goto L44;
        if (r0.getEntryController() == null) goto L44;
        ((v72.c) this.b.getEntryController()).u = null;
    L44:
        if (this.k == null) goto L52;
        dmc.a r1 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        com.bytedance.android.livesdk.interactivity.common.utils.i r3 = this.k;
        int r4 = j.a;
        if (r1 != null) goto L49;
    L51:
        this.k = null;
        goto L52
    L49:
        if ((r1 instanceof dmc.a) == false) goto L51;
        r1.o(r3);
        ALogger.i("LiveMessageTracer", "removeReplayMessageListener");
    L52:
        this.a = Boolean.FALSE;
        this.d.clear();
        ViewGroup r2 = ((Widget) this).containerView;
        if (r2 == null) goto L55;
        r2.setVisibility(0);
        ((Widget) this).containerView.setAlpha(1.0f);
    L55:
        UIUtils.setViewVisibility(findViewById(2131371680), 0);
        h r5 = this.h;
        InteractivityPlatformContext r6 = this.f;
        r5.getClass();
        if (r6 == null) goto L68;
        com.bytedance.live.datacontext.i<Map<Integer, Boolean>> r7 = r6.getEnterAnimVisibleStateStore();
        if (r7 == null) goto L68;
        Map r8 = (Map) r7.getValue();
        if (r8 == null) goto L68;
        r8.clear();
        Iterator<Map.Entry<Integer, Boolean>> r9 = r5.b.entrySet().iterator();
    L64:
        if (r9.hasNext() == false) goto L68;
        Map.Entry<Integer, Boolean> r10 = r9.next();
        if (r10.getKey().intValue() != 5) goto L64;
        r8.put(r10.getKey(), r10.getValue());
    L68:
        Iterator<Map.Entry<Integer, Boolean>> r11 = this.h.b.entrySet().iterator();
    L70:
        if (r11.hasNext() == false) goto L72;
        r11.next().setValue(Boolean.TRUE);
        goto L70
    L72:
        return;
    L5:
        if (g.c <= 0) goto L7;
    L9:
        HashMap r13 = new HashMap();
        r13.put("on_change_cnt", String.valueOf(g.c));
        int r14 = g.c;
        String r15 = "0";
        if (r14 <= 0) goto L12;
        String r16 = String.valueOf(g.b / r14);
    L13:
        r13.put("on_change_cost", r16);
        r13.put("play_anim_cnt", String.valueOf(g.e));
        int r17 = g.e;
        if (r17 <= 0) goto L16;
        String r18 = String.valueOf(g.d / r17);
    L17:
        r13.put("play_anim_cost", r18);
        IMiddlewareUserService r19 = k.f(IMiddlewareUserService.class);
        if (r19 == null) goto L23;
        e r20 = r19.user();
        if (r20 == null) goto L23;
        String r21 = r20.n();
        if (r21 == null) goto L23;
    L24:
        r13.put("user_id", r21);
        IRoomContextService r23 = k.f(IRoomContextService.class);
        if (r23 == null) goto L36;
        o r24 = IRoomContextService.a.a(r23, null, 0, 3);
        if (r24 == null) goto L36;
        m r25 = r24.getRoom();
        if (r25 == null) goto L36;
        IRoom r26 = (IRoom) r25.getValue();
        if (r26 == null) goto L36;
        String r27 = String.valueOf(r26.getRoomId());
        if (r27 == null) goto L36;
        r15 = r27;
    L36:
        r13.put("room_id", r15);
        j0.l().sendLog("ttlive_high_level_message_performance", r13, new Object[0]);
    L37:
        g.b = 0;
        g.c = 0;
        g.d = 0;
        g.e = 0;
    L23:
        r21 = "0";
        goto L24
    L16:
        r18 = "0";
        goto L17
    L12:
        r16 = "0";
        goto L13
    L7:
        if (g.e > 0) goto L9;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [r72.j] */
    /* JADX WARN: Type inference failed for: r3v0, types: [r72.k] */
    public EnterAnimWidget() {
        this.a = Boolean.FALSE;
        this.d = new CompositeDisposable();
        this.h = new h();
        this.i = new s72.b(i0.c(), new r72.j(this), new r72.k(this));
        this.j = false;
        this.l = false;
        this.m = new a(this);
        this.n = new b(this);
    }

    public final View getContentView() {
        return ((Widget) this).containerView;
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
    }

    public final Boolean uk() {
        return this.a;
    }

    public final void onChanged(Object r2) {
        final KVData r3 = (KVData) r2;
        if (r3 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3.getKey()) == true) goto L10;
        g.a(new r72.b(this, r3));
        return;
    }

    public final void onEnterClear(int r4) {
        if (r4 != 1) goto L5;
    L14:
        View r5 = findViewById(2131371680);
        if (r5 == null) goto L19;
        this.h.a(r5, 3, true);
        return;
    L19:
        return;
    L5:
        if (r4 == 4) goto L14;
        if (r4 == 16) goto L14;
        if (r4 == 32) goto L14;
        if (r4 == 256) goto L14;
        if (r4 == 1024) goto L14;
    }

    public final void onExitClear(int r4) {
        if (r4 != 1) goto L5;
    L12:
        View r5 = findViewById(2131371680);
        if (r5 == null) goto L17;
        this.h.a(r5, 3, false);
        return;
    L17:
        return;
    L5:
        if (r4 == 4) goto L12;
        if (r4 == 16) goto L12;
        if (r4 == 32) goto L12;
        if (r4 == 256) goto L12;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object, r72.i] */
    public final void onInit(Object... r5) {
        this.c = new s72.d();
        EnterAnimationView r6 = (EnterAnimationView) ((Widget) this).contentView.findViewById(2131371680);
        this.b = r6;
        r6.setUserEventListener(this);
        ?? r7 = new r72.i(this);
        if (((Boolean) ou.a.getValue()).booleanValue() == false) goto L17;
        DataCenter r0 = ((Widget) this).dataCenter;
        Lazy r1 = MainPostOptUtils.a;
        Intrinsics.checkNotNullParameter("checkAndPreloadDrawableRunnable", "methodName");
        Intrinsics.checkNotNullParameter(this, "lifecycle");
        Intrinsics.checkNotNullParameter(r7, "runnable");
        if (r0 == null) goto L19;
        Observable r2 = RxUtilKt.b(r0, "cmd_widget_loaded", true);
        if (r2 == null) goto L20;
        Observable r3 = r2.take(1);
        if (r3 == null) goto L21;
        Observable r4 = r3.delay(200, TimeUnit.MILLISECONDS);
        if (r4 == null) goto L22;
        Observable r8 = r4.observeOn(AndroidSchedulers.mainThread());
        if (r8 == null) goto L23;
        ObservableSubscribeProxy r9 = (ObservableSubscribeProxy) r8.as(AutoDispose.bind(this));
        if (r9 == null) goto L24;
        r9.subscribe(new k1(r7));
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L17:
        r7.run();
    }

    /* JADX WARN: Type inference failed for: r6v33, types: [java.lang.Object, r72.d] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void onLoad(Object... r13) {
        if (((Boolean) PerformanceTestSettings.TEST_DISABLE_ENTER_ANIM.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L8;
        this.h.a = r14;
    L8:
        ALogger.i("EnterAnimWidget", "onLoad");
        if (((Boolean) LiveInfraSettingKeys.LIVE_ENTER_DIRTY_REGION_OPT.getValue()).booleanValue() == false) goto L15;
        ViewGroup r0 = (ViewGroup) this.b.getParent();
        if (r0 == null) goto L15;
        if (r0.getClipChildren() == true) goto L15;
        r0.setClipChildren(true);
        ALogger.i("DirtyRegion", "enter parent=" + r0 + " clipChildren=true");
    L15:
        long r2 = 0;
        boolean r4 = false;
        if (g.a.booleanValue() == false) goto L18;
        g.b = 0;
        g.c = 0;
        g.d = 0;
        g.e = 0;
    L18:
        this.e = ((IRoomContextService) k.f(IRoomContextService.class)).getRoomDataContext(((Widget) this).dataCenter, 0);
        this.g = InteractionWidgetsPosContext.getShared(((Widget) this).dataCenter, 0);
        if (isScreenPortrait() == false) goto L29;
        o r1 = this.e;
        if (r1 == null) goto L29;
        n r3 = r1.getTemplateContext();
        if (r3 == null) goto L29;
        z70.b r5 = (z70.b) r3.getValue();
        if (r5 == null) goto L29;
        if (r5.c("public_screen") == false) goto L29;
        boolean r6 = r5.a();
    L30:
        ALogger.i("EnterAnimWidget", "canLoadPublicScreen is " + r6);
        if (r6 == false) goto L39;
        InteractionWidgetsPosContext r7 = this.g;
        if (r7 == null) goto L40;
        h r8 = this.h;
        ViewGroup r9 = ((Widget) this).containerView;
        if (((Integer) r7.getPublicScreenVisibility().getValue()).intValue() != 0) goto L37;
        boolean r10 = true;
    L38:
        r8.a(r9, 0, r10);
        this.d.add(this.g.getPublicScreenVisibility().a().subscribe(new r72.a(this)));
        goto L40
    L37:
        r10 = false;
    L40:
        o r11 = this.e;
        if (r11 != null) goto L43;
    L51:
        this.f = com.bytedance.android.livesdk.interactivity.j.a(((Widget) this).dataCenter);
        vlc.d r15 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        if (((Boolean) h1.a.getValue()).booleanValue() == false) goto L54;
    L57:
        boolean r16 = true;
    L59:
        if (r16 == true) goto L61;
    L68:
        ((Widget) this).dataCenter.observe("data_member_message", this);
    L69:
        ((Widget) this).dataCenter.observe("data_game_download_message", this);
        ((Widget) this).dataCenter.observe("data_live_ecom_message", this);
        ((Widget) this).dataCenter.observe("mock_open_asset_message", this);
        ((Widget) this).dataCenter.observeForever("cmd_pk_state_change", this);
        ((Widget) this).dataCenter.observe("cmd_enter_widget_layout_change", this, true);
        ((Widget) this).dataCenter.observeForever("cmd_enter_widget_visible_change", this);
        ((Widget) this).dataCenter.observeForever("data_keyboard_status", this);
        ((Widget) this).dataCenter.observeForever("data_keyboard_status_douyin", this);
        ((Widget) this).dataCenter.observe("cmd_hide_enter_anim_until_next_anim", this);
        this.j = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        m r17 = getRoomContextService().getRoomInteractivityService(((MiddlewareRoomRecyclableWidget) this).dataContext).c();
        if (r17 == null) goto L72;
        this.d.add(r17.a().subscribe(new r72.e(this)));
    L73:
        ((Widget) this).dataCenter.observe("data_member_count", this);
        if (this.b != null) goto L76;
    L80:
        EnterAnimationView r18 = this.b;
        if (r18 == null) goto L85;
        r18.setDataCenter(((Widget) this).dataCenter);
        this.b.setInteractivityContext(this.f);
        if (this.b.getEntryController() == null) goto L85;
        ((v72.c) this.b.getEntryController()).u = this.m;
    L85:
        ((Widget) this).dataCenter.observe("cmd_data_interact_public_screen_height_change", this, true);
        o r19 = this.e;
        if (r19 != null) goto L88;
    L92:
        boolean r110 = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor")).booleanValue();
        h r20 = this.h;
        InteractivityPlatformContext r21 = this.f;
        r20.getClass();
        if (r21 == null) goto L106;
        com.bytedance.live.datacontext.i<Map<Integer, Boolean>> r23 = r21.getEnterAnimVisibleStateStore();
        if (r23 == null) goto L106;
        Map r24 = (Map) r23.getValue();
        if (r24 == null) goto L106;
        Iterator r25 = r24.entrySet().iterator();
    L101:
        if (r25.hasNext() == false) goto L105;
        Map.Entry r26 = (Map.Entry) r25.next();
        if (((Number) r26.getKey()).intValue() != 5) goto L101;
        r20.b.put((Integer) r26.getKey(), (Boolean) r26.getValue());
        goto L101
    L105:
        r24.clear();
    L106:
        h r27 = this.h;
        ViewGroup r28 = ((Widget) this).containerView;
        if (r110 == false) goto L109;
    L111:
        r27.a(r28, 4, r4);
        com.bytedance.android.live.profit.player.d r111 = yt0.c.h();
        if (r111 == null) goto L114;
        this.d.add(r111.x1().subscribe(new f(this)));
    L114:
        Widget.WidgetCallback r112 = ((Widget) this).widgetCallback;
        if (r112 == null) goto L118;
        ((KeyboardViewModel) r112.getViewModel(KeyboardViewModel.class)).getKeyboardData().observe(this, new r72.g(this));
    L118:
        if (((com.bytedance.android.livesdk.interactivity.api.settings.config.l) r0.a.getValue()).c() == false) goto L133;
        z32.b r113 = z32.b.c;
        EventName r29 = EventName.HighLevelNoMessageShowEvent;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r29, "eventName");
        Intrinsics.checkNotNullParameter(r29, "eventName");
        r113.a = r29;
        IRoomContextService r114 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r114 == null) goto L128;
        o r115 = IRoomContextService.a.a(r114, null, 0, 3);
        if (r115 == null) goto L128;
        m r116 = r115.getRoom();
        if (r116 == null) goto L128;
        IRoom r117 = (IRoom) r116.getValue();
        if (r117 == null) goto L128;
        r2 = r117.getUserCount();
    L128:
        ALogger.i("HighlevelNoMessageMonitorHelper", "room enter acu: " + r2);
        com.bytedance.android.livesdk.interactivity.api.settings.config.l r118 = z32.b.b;
        if (r2 <= r118.a()) goto L133;
        MonitorEvent.b r30 = new MonitorEvent.b(r29, UploadMode.TIMER, r118.b());
        r30.e(HighlevelNoMessageMonitorEnum.MemberReceiveCount.getValueNodeName(), true);
        r30.e(HighlevelNoMessageMonitorEnum.MemberDropCount.getValueNodeName(), true);
        r30.e(HighlevelNoMessageMonitorEnum.MemberFilterCount.getValueNodeName(), true);
        r30.e(HighlevelNoMessageMonitorEnum.MemberShowCount.getValueNodeName(), true);
        r30.e(HighlevelNoMessageMonitorEnum.NotifyReceiveCount.getValueNodeName(), true);
        r30.e(HighlevelNoMessageMonitorEnum.NotifyDropCount.getValueNodeName(), true);
        r30.e(HighlevelNoMessageMonitorEnum.NotifyFilterCount.getValueNodeName(), true);
        r30.e(HighlevelNoMessageMonitorEnum.NotifyShowCount.getValueNodeName(), true);
        r30.a(new a42.a(r118.d()));
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.g(r30.f());
    L133:
        if (((u) b4.a.getValue()).c() == true) goto L135;
        return;
    L135:
        if (getMiddlewareRoomContext() == null) goto L144;
        this.d.add(o0.b(getMiddlewareRoomContext(), "WebcastMemberMessage", this.n, new c(this)));
        return;
    L144:
        return;
    L109:
        if (isScreenPortrait() == true) goto L111;
        r4 = true;
        goto L111
    L88:
        if (r19.getMessageManager() == null) goto L92;
        if (this.e.getMessageManager().getValue() == null) goto L92;
        ((vlc.d) this.e.getMessageManager().getValue()).addMessageListener("WebcastNotifyEffectMessage", this);
        goto L92
    L76:
        if (isScreenPortrait() == false) goto L78;
        int r119 = s1.j(2131168987);
    L79:
        this.b.setChildMarginBottom(r119);
        goto L80
    L78:
        r119 = 0;
        goto L79
    L72:
        ALogger.e("EnterAnimWidget", "mockOpenAssetMessage#" + getRoomContextService().getRoomInteractivityService(((MiddlewareRoomRecyclableWidget) this).dataContext) + "dataContext:" + ((MiddlewareRoomRecyclableWidget) this).dataContext);
        goto L73
    L61:
        if ((r15 instanceof dmc.a) == false) goto L68;
        ?? r31 = new r72.d(this);
        int r33 = j.a;
        Intrinsics.checkNotNullParameter("WebcastMemberMessage", "messageMethod");
        Intrinsics.checkNotNullParameter(r31, "listener");
        com.bytedance.android.livesdk.interactivity.common.utils.i r34 = new com.bytedance.android.livesdk.interactivity.common.utils.i(r31, SetsKt.emptySet(), SetsKt.linkedSetOf(new String[]{"WebcastMemberMessage"}));
        this.k = r34;
        if (r15 == null) goto L69;
        if ((r15 instanceof dmc.a) == false) goto L69;
        ((dmc.a) r15).C(r34);
        ALogger.i("LiveMessageTracer", "addReplayMessageListener");
        goto L69
    L54:
        if (((Boolean) i1.a.getValue()).booleanValue() == true) goto L57;
        r16 = false;
        goto L59
    L43:
        if (r11.getCleanMode() == null) goto L51;
        if (this.g == null) goto L51;
        h r35 = this.h;
        ViewGroup r36 = ((Widget) this).containerView;
        if (((Integer) this.e.getCleanMode().getValue()).intValue() == 0) goto L49;
        boolean r37 = true;
    L50:
        r35.a(r36, 3, r37);
        this.d.add(this.e.getCleanMode().a().subscribe(new r72.c(this)));
        goto L51
    L49:
        r37 = false;
        goto L50
    L39:
        this.h.a(((Widget) this).containerView, 0, false);
    L29:
        r6 = true;
        goto L30
    }

    public final void onMessage(final tlc.d r2) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (this.b == null) goto L10;
        g.a(new r72.h(this, r2));
        return;
    }

    public final void qo(Boolean r1) {
        this.a = r1;
    }

    public final void wq(int r3) {
        Object r0 = ((Widget) this).containerView.findViewById(2131371680);
        if ((r0 instanceof EnterAnimationView) == true) goto L5;
        return;
    L5:
        ((EnterAnimationView) r0).setChildMarginBottom(r3);
    }

    public final void xq(k32.a r3) {
        int r0 = com.bytedance.android.livesdk.interactivity.enteranim.utils.f.a;
        va.a r1 = r3.k;
        if (r1 == null) goto L5;
        py.k r2 = r1.getTextIcon();
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        int r4 = t72.a.a;
        d r5 = new d(this, r3);
        Intrinsics.checkNotNullParameter(r2, "imageModel");
        Intrinsics.checkNotNullParameter(r5, "callback");
        new t72.a.b(r2, r5).a();
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean yq(va r5) {
        IBaseUser r6 = r5.getUser();
        if (r6 != null) goto L6;
        return true;
    L6:
        if (TextUtils.isEmpty(r6.getIdString()) == false) goto L8;
    L10:
        boolean r7 = false;
    L11:
        if (r7 == true) goto L13;
    L15:
        return false;
    L13:
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_need_to_filter_self_enter_msg", Boolean.FALSE)).booleanValue() == false) goto L15;
        return true;
    L8:
        if (TextUtils.equals(r6.getIdString(), k.f(IMiddlewareUserService.class).user().n()) == false) goto L10;
        r7 = true;
        goto L11
    }

    public final void zq(va r6) {
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberReceiveCount);
        if (isScreenPortrait() == true) goto L6;
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberDropCount);
        return;
    L6:
        if (r6 != null) goto L8;
    L31:
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberDropCount);
        return;
    L8:
        if (isViewValid() == false) goto L31;
        if (this.b == null) goto L31;
        if (r6.getAction() == 1) goto L17;
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberDropCount);
        return;
    L17:
        if (yq(r6) == false) goto L20;
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberDropCount);
        return;
    L20:
        s72.d r0 = this.c;
        boolean r1 = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        r0.getClass();
        k32.a r2 = s72.d.a(r6, r1);
        if (r6.r() != null) goto L27;
        if (r6.e() != 0) goto L27;
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberFilterCount);
        return;
    L27:
        if (com.bytedance.android.livesdk.interactivity.enteranim.utils.f.a(r2) == false) goto L29;
        xq(r2);
        return;
    L29:
        this.b.b(r2);
    }
}
