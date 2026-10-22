package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import am2.x;
import android.content.Context;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.RequestSongSingState;
import com.bytedance.android.live.liveinteract.component.MultiComponentManager;
import com.bytedance.android.live.liveinteract.floatwindow.dialog.LinkmicApplyFloatWindowRetainDialog;
import com.bytedance.android.live.liveinteract.floatwindow.dialog.LinkmicOnlineFloatWindowRetainDialog;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSVoiceWidget;
import com.bytedance.android.live.liveinteract.plantform.multiroom.MultiLinkUIWidget;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.multilink.voicechat.api.service.IMultiLinkVoiceService;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.backupsei.MultiLinkBizBackupSeiExperimentUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.bizlink.impl.platform.manager.MultiLinkGuestManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import hh1.w0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/widgt/voicelink/MultiLinkVoiceGuestContainerWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Lkn0/b;", "", "Lqd0/d;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkVoiceGuestContainerWidget extends PlatformMultiLinkWidget implements kn0.b, qd0.d {
    public volatile boolean a;
    public final CompositeDisposable b;
    public int c;
    public int d;
    public Widget e;
    public Widget f;
    public Widget g;
    public IRoom h;
    public boolean i;
    public final w0 j;
    public final gd0.p k;

    public static final class a implements gd0.p {
        public final /* synthetic */ MultiLinkVoiceGuestContainerWidget a;
        public final /* synthetic */ String b;

        @Override // gd0.p
        public final void a(Widget r3) {
            Intrinsics.checkNotNullParameter(r3, "selfWidget");
            if (MultiLinkLoadWidgetUtils.f() == true) goto L5;
            return;
        L5:
            if ((r3 instanceof com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b) == true) goto L7;
            return;
        L7:
            if (this.a.h != null) goto L9;
            return;
        L9:
            if (MultiLinkOpenSource.FAST_INIT_MODE.equals(this.b) == false) goto L11;
            IRoom r0 = this.a.h;
            Intrinsics.checkNotNull(r0);
            ((com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b) r3).h0(r0);
            return;
        L11:
            IRoom r1 = this.a.h;
            Intrinsics.checkNotNull(r1);
            ((com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b) r3).U0(r1);
        }

        public a(MultiLinkVoiceGuestContainerWidget r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ long a;

        public b(long r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            f2.b(2131919287, 0);
            InteractLinkFullLinkMonitor.x("voice_guest_widget_destroy", System.currentTimeMillis() - this.a, ((com.bytedance.android.live.network.response.e) r5).logId);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ long a;

        public c(long r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            long r0 = System.currentTimeMillis() - this.a;
            InteractLinkFullLinkMonitor.w("voice_guest_widget_destroy", r0, (Throwable) r5);
        }
    }

    public static final class d implements xb6.b {
        public final /* synthetic */ MultiLinkVoiceGuestContainerWidget a;

        public final Pair<Boolean, String> h() {
            this.a.getClass();
            if (jc1.k.n(IMultiLinkServiceExternal.class).getControlServiceExternal().c() == true) goto L5;
            this.a.getClass();
            IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r0 == null) goto L13;
            gd0.i r1 = r0.getInteractFloatWindowService();
            if (r1 == null) goto L13;
            boolean r2 = true;
            if (((com.bytedance.android.live.liveinteract.service.g) r1).b() != true) goto L13;
        L14:
            if (r2 == false) goto L17;
            return new Pair(Boolean.TRUE, "linkmic online float window");
        L17:
            return new Pair(Boolean.FALSE, "check whether in float window");
        L13:
            r2 = false;
            goto L14
        L5:
            return new Pair(Boolean.TRUE, "is pk mode");
        }

        public final Pair<Boolean, String> a() {
            return xb6.b.a.k();
        }

        public final Pair<Boolean, String> b() {
            return xb6.b.a.a();
        }

        public final Pair<Boolean, String> c() {
            return xb6.b.a.b();
        }

        public final Pair<Boolean, String> e() {
            return xb6.b.a.e();
        }

        public final Pair<Boolean, String> g() {
            return xb6.b.a.l();
        }

        public final Pair<Boolean, String> k() {
            return xb6.b.a.i();
        }

        public final Pair<Boolean, String> m() {
            return xb6.b.a.c();
        }

        public d(MultiLinkVoiceGuestContainerWidget r1) {
            this.a = r1;
        }

        public final Pair<Boolean, String> d(z0 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.f(r2);
        }

        public final Pair f(com.bytedance.android.live.liveinteract.multianchor.model.b r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.d(r2);
        }

        public final Pair<Boolean, String> j(z0 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.h(r2);
        }

        public final Pair<Boolean, String> l(h1 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.m(r2);
        }

        public final Pair<Boolean, String> i(long r1, String r3, String r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r3, "secToUserId");
            Intrinsics.checkNotNullParameter(r4, "toUserIdString");
            return xb6.b.a.j(r3, r4);
        }
    }

    public final int getLayoutId() {
        return 2131567950;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return 0;
    }

    @Override // kn0.b
    public final void i2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    public final cg6.a Aq() {
        return getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVoiceGuestContainerWidget#" + hashCode(), "call onCreate, initFastMode=" + MultiLinkLoadWidgetUtils.f() + " hasRealOnCreate=" + this.a);
        super.onCreate();
        Lazy r1 = MultiComponentManager.e;
        MultiComponentManager.a.a().a(this, ((Widget) this).context, ((Widget) this).dataCenter);
        cg6.a r2 = Aq();
        if (r2 == null) goto L5;
        r2.init(((Widget) this).context);
    L5:
        enableSubWidgetManager();
        if (MultiLinkLoadWidgetUtils.f() == true) goto L8;
        Bq();
    L8:
        this.k.a(this);
    }

    public final void Bq() {
        cg6.a r0 = Aq();
        if (r0 == null) goto L5;
        r0.init(((Widget) this).context);
    L5:
        Lazy r1 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVoiceGuestContainerWidget#" + hashCode(), "call realOnCreate, hasRealOnCreate = " + this.a);
        if (this.a == false) goto L9;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.h0();
        return;
    L9:
        this.a = true;
        this.h = (IRoom) ((Widget) this).dataCenter.get("data_room");
        com.bytedance.live.datacontext.j r2 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r2 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r2.getValue();
        if (r3 == null) goto L16;
        this.b.add(r3.a().subscribe(new q(this)));
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVoiceGuestContainerWidget#" + hashCode(), "call onDestroy");
        Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
        boolean r2 = true;
        if (r1 != null) goto L6;
    L7:
        Integer r3 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r3 != null) goto L11;
    L19:
        Widget r4 = this.e;
        if (r4 == null) goto L26;
        boolean r5 = r4 instanceof com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b;
        if (r5 == false) goto L26;
        if (r5 == true) goto L25;
        r4 = null;
    L25:
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r6 = (com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b) r4;
    L27:
        Widget r7 = this.f;
        if (r7 == null) goto L34;
        boolean r8 = r7 instanceof com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b;
        if (r8 == false) goto L34;
        if (r8 == true) goto L33;
        r7 = null;
    L33:
        r6 = (com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b) r7;
    L34:
        Widget r9 = this.g;
        if (r9 != null) goto L37;
    L39:
        if (r6 == null) goto L41;
        com.bytedance.android.live.pushstream.d r10 = r6.Xh();
    L42:
        if (r6 == null) goto L44;
        m00.h r11 = r6.Tj();
    L45:
        IInteractService r12 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r12 == null) goto L52;
        gd0.i r13 = r12.getInteractFloatWindowService();
        if (r13 == null) goto L52;
        if (((com.bytedance.android.live.liveinteract.service.g) r13).b() != true) goto L52;
    L53:
        if (r2 == true) goto L71;
        if (r10 == null) goto L60;
        ((Widget) this).dataCenter.put("cmd_linker_live_core_release", Boolean.TRUE);
        r10.release();
        if (r6 == null) goto L58;
        r6.Nl(null);
    L58:
        if (r11 == null) goto L60;
        r11.c();
    L60:
        cg6.a r14 = Aq();
        if (r14 == null) goto L65;
        hg6.g r15 = r14.getRtcManager();
        if (r15 == null) goto L65;
        r15.onDestroy();
    L65:
        Integer r16 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r16 != null) goto L69;
    L70:
        ((Widget) this).dataCenter.put("cmd_interact_state_change", new a1(4));
        hd0.c.f().k(0);
    L117:
        t r17 = j0.l().c(x.class);
        if ((r17 instanceof t) == false) goto L122;
        t r18 = r17;
        if (r18.getMap() == null) goto L122;
        r18.E("is_link_reserve", "0");
    L122:
        cg6.a r19 = Aq();
        if (r19 == null) goto L127;
        vb6.g r20 = r19.O5();
        if (r20 == null) goto L127;
        r20.h(new d(this));
    L127:
        com.bytedance.live.datacontext.j r21 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r21 == null) goto L132;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r22 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r21.getValue();
        if (r22 == null) goto L132;
        r22.reset();
    L132:
        this.b.dispose();
        com.bytedance.android.live.liveinteract.plantform.utils.i.b();
        Lazy r23 = MultiComponentManager.e;
        MultiComponentManager.a.a().b(((Widget) this).context);
        cg6.a r24 = Aq();
        if (r24 == null) goto L135;
        r24.release();
    L135:
        this.f = null;
        this.e = null;
        this.g = null;
        return;
    L69:
        if (r16.intValue() == 0) goto L117;
    L71:
        String r25 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager r26 = LinkmicOnlineFloatWindowManager.c.a();
        cg6.a r27 = Aq();
        if (r27 == null) goto L74;
        jg6.a r28 = r27.e5();
    L75:
        r26.w = r28;
        LinkmicOnlineFloatWindowManager r29 = LinkmicOnlineFloatWindowManager.c.a();
        cg6.a r30 = Aq();
        if (r30 == null) goto L78;
        hg6.g r31 = r30.getRtcManager();
    L79:
        dn0.c r32 = (dn0.c) getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        r29.x = r31;
        r29.t = r32;
        if (v.a() == false) goto L85;
        if (vm2.c.h().d() == false) goto L85;
    L90:
        if (r31 == null) goto L92;
        r31.W(r29);
    L92:
        hg6.g r33 = r29.s;
        if (r33 == null) goto L95;
        r33.X(2, "LinkMicOnlineFloatWindow, setVoiceRtc");
    L95:
        hg6.g r34 = r29.x;
        if (r34 == null) goto L98;
        r34.X(2, "LinkMicOnlineFloatWindow, setVoiceRtc");
    L98:
        LinkmicOnlineFloatWindowManager.c.a().z = r10;
        LinkmicOnlineFloatWindowManager.c.a().y = r11;
        cg6.a r35 = Aq();
        if (r35 == null) goto L105;
        vb6.g r36 = r35.O5();
        if (r36 == null) goto L105;
        yb6.e r37 = r36.j();
        if (r37 == null) goto L105;
        Map r38 = r37.m();
    L106:
        if (r38 == null) goto L117;
        LinkmicOnlineFloatWindowManager r39 = LinkmicOnlineFloatWindowManager.c.a();
        cg6.a r40 = Aq();
        if (r40 == null) goto L115;
        vb6.g r41 = r40.O5();
        if (r41 == null) goto L115;
        yb6.e r42 = r41.j();
        if (r42 == null) goto L115;
        Map<? extends String, ? extends yb6.j> r43 = r42.m();
        if (r43 == null) goto L115;
    L116:
        r39.getClass();
        Intrinsics.checkNotNullParameter(r43, "remoteViewMap");
        r39.A.putAll(r43);
    L115:
        r43 = new LinkedHashMap();
    L105:
        r38 = null;
    L85:
        if (r29.C != null) goto L87;
        r29.C = new RTSVoiceWidget(r29.x, null, r29, r29.t);
    L87:
        RTSVoiceWidget r44 = r29.C;
        if (r44 == null) goto L90;
        r44.onCreate();
        goto L90
    L78:
        r31 = null;
        goto L79
    L74:
        r28 = null;
    L52:
        r2 = false;
        goto L53
    L44:
        r11 = null;
        goto L45
    L41:
        r10 = null;
        goto L42
    L37:
        if ((r9 instanceof com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b) == false) goto L39;
        r6 = (com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b) r9;
    L26:
        r6 = null;
        goto L27
    L11:
        if (1 != r3.intValue()) goto L19;
    L13:
        if (this.i == true) goto L19;
        InteractLinkFullLinkMonitor.v("voice_guest_widget_destroy");
        long r45 = System.currentTimeMillis();
        LinkApi r46 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r47 = je0.d.e(null);
        if (r47 == null) goto L17;
        long r48 = r47.getId();
    L18:
        r46.leave(r48, "voice_guest_widget_destroy").compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r45), new c(r45));
        goto L19
    L17:
        r48 = 0;
        goto L18
    L6:
        if (2 == r1.intValue()) goto L13;
        goto L7
    }

    public static final void wq(MultiLinkVoiceGuestContainerWidget r2) {
        r2.getClass();
        MultiLinkGuestManager r3 = r2.getScopeServiceInMultiLinkRoom(cg6.a.class).W4();
        if (r3 == null) goto L6;
        r3.f("apply_stash_failed", true);
        return;
    }

    @Override // kn0.b
    public final void E1(ILinkerClientUIInfoChangeContent r2) {
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L6;
        r0.onClientUIInfoChangeMessage(r2);
        return;
    }

    @Override // qd0.d
    public final void U0(IRoom r7) {
        Intrinsics.checkNotNullParameter(r7, PbRequest.SwitchType.ROOM);
        if (MultiLinkLoadWidgetUtils.f() == false) goto L33;
        Widget r0 = this.e;
        int r1 = 0;
        if (r0 == null) goto L7;
        int r2 = r0.hashCode();
    L8:
        Widget r3 = this.f;
        if (r3 == null) goto L11;
        r1 = r3.hashCode();
    L11:
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVoiceGuestContainerWidget#" + hashCode(), "call updateFullMode, voiceChatWidgetHashCode = " + r2 + ", ktvRoomWidgetHashCode = " + r1);
        this.h = r7;
        Bq();
        Widget r4 = this.e;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r5 = null;
        if (r4 != null) goto L14;
    L21:
        Widget r6 = this.f;
        if (r6 != null) goto L24;
        return;
    L24:
        if (r6.hashCode() != r1) goto L35;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r8 = this.f;
        if ((r8 instanceof com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b) == false) goto L29;
        r5 = r8;
    L29:
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r9 = r5;
        if (r9 == null) goto L36;
        r9.U0(r7);
        return;
    L36:
        return;
    L35:
        return;
    L14:
        if (r4.hashCode() != r2) goto L21;
        Widget r10 = this.e;
        if ((r10 instanceof com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b) == true) goto L18;
        r10 = null;
    L18:
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r11 = (com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b) r10;
        if (r11 == null) goto L21;
        r11.U0(r7);
        goto L21
    L7:
        r2 = 0;
        goto L8
    }

    @Override // kn0.b
    public final void Vl(int r2) {
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L5;
        r0.onClickToolbar(r2);
    L5:
        IKtvService r1 = jc1.k.f(IKtvService.class);
        if (r1 == null) goto L9;
        r1.onClickToolbar(r2);
        return;
    }

    @Override // kn0.b
    public final void d1(z0 r4) {
        if (r4 == null) goto L5;
        Number r1 = Long.valueOf(r4.getScene());
    L6:
        int r2 = r1.intValue();
        if (r4 == null) goto L9;
        int r3 = r4.getUiLayout();
    L11:
        if (jc0.a.d(r2, r3) == false) goto L16;
        if (r4 == null) goto L14;
        r4.setScene(9);
    L14:
        if (r4 == null) goto L16;
        r4.setUiLayout(0);
    L16:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L19;
        r0.onSwitchSceneMessage(r4);
    L19:
        jc1.k.n(IKtvService.class).onSwitchSceneMessage(r4);
        return;
    L9:
        r3 = 0;
        goto L11
    L5:
        r1 = 0;
        goto L6
    }

    @Override // qd0.d
    public final void h0(IRoom r5) {
        Intrinsics.checkNotNullParameter(r5, PbRequest.SwitchType.ROOM);
        this.h = r5;
        u r6 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r6 == null) goto L10;
        com.bytedance.live.datacontext.j r7 = r6.s();
        if (r7 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r8 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r7.getValue();
        if (r8 == null) goto L12;
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVoiceGuestContainerWidget#" + hashCode(), "initFastMode, scene = " + r8.t().a + ", uiLayout = " + r8.t().b);
        this.c = r8.t().a;
        this.d = r8.t().b;
        zq(r8.t().a, r8.t().b, MultiLinkOpenSource.FAST_INIT_MODE);
        return;
    L12:
        return;
    L11:
        return;
    }

    public MultiLinkVoiceGuestContainerWidget(w0 r2, gd0.p r3) {
        Intrinsics.checkNotNullParameter(r3, "liveCycleCallback");
        this.j = r2;
        this.k = r3;
        this.b = new CompositeDisposable();
    }

    public static final void xq(MultiLinkVoiceGuestContainerWidget r0, boolean r1) {
        r0.getClass();
        IInteractService r2 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r2 == null) goto L8;
        gd0.i r3 = r2.getInteractFloatWindowService();
        if (r3 == null) goto L9;
        ((com.bytedance.android.live.liveinteract.service.g) r3).e(r1);
        return;
    L9:
        return;
    }

    @Override // kn0.b
    public final boolean interceptCloseRoom(Runnable r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "runnable");
        int r0 = xe0.j.a;
        if (xe0.j.a() == true) goto L6;
    L44:
        boolean r1 = false;
    L45:
        if (r1 == false) goto L48;
        this.i = true;
        return true;
    L48:
        int r2 = com.bytedance.android.live.liveinteract.plantform.widgt.v.a;
        if (com.bytedance.android.live.liveinteract.plantform.widgt.v.a(((Widget) this).context) == false) goto L52;
        return true;
    L52:
        if (xe0.j.c() == true) goto L55;
    L105:
        boolean r3 = false;
    L106:
        if (r3 == false) goto L109;
        this.i = true;
        return true;
    L109:
        IVoiceChatGuestService r4 = this.e;
        if (r4 == null) goto L116;
        if ((r4 instanceof IVoiceChatGuestService) == false) goto L116;
        return r4.interceptCloseRoomV2(r7, r8);
    L116:
        if (this.c != 9) goto L129;
        IKtvService r5 = jc1.k.f(IKtvService.class);
        if (r5 != null) goto L120;
        return false;
    L120:
        if (r5.interceptCloseRoom(r7, r8) != true) goto L131;
        return true;
    L131:
        return false;
    L129:
        return false;
    L55:
        if (jc0.a.a() == true) goto L105;
        if (LinkMicGameContext.Companion.e() == true) goto L105;
        if (jc1.k.f(IKtvService.class) == null) goto L67;
        IKtvService r6 = jc1.k.f(IKtvService.class);
        if (r6 == null) goto L67;
        if (r6.isCurrentUserIsSinger() == true) goto L105;
    L67:
        InteractiveSongContext.a r9 = InteractiveSongContext.Companion;
        if (r9.getContext() == null) goto L72;
        InteractiveSongContext r10 = r9.getContext();
        Intrinsics.checkNotNull(r10);
        if (r10.getSelfSingingState() == RequestSongSingState.STATE_SINGING.getValue()) goto L105;
    L72:
        Integer r11 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r11 == null) goto L105;
        if (r11.intValue() != 2) goto L105;
        if (r8 == true) goto L105;
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 != null) goto L81;
    L86:
        Integer r13 = (Integer) b6.j.getValue();
        if (r13 == null) goto L95;
        if (r13.intValue() != 1) goto L95;
        if (rx1.m.e(((Widget) this).context) == false) goto L95;
        yq(new p(this, r7), LinkApi.ApplyStashType.ONLINE_WINDOW.ordinal());
    L104:
        r3 = true;
    L95:
        if (xe0.j.b() == false) goto L105;
        Context r14 = ((Widget) this).context;
        IRoom r15 = this.h;
        if (r15 != null) goto L99;
        r15 = (IRoom) vh7.f.c(IRoom.class);
    L99:
        AppCompatDialog r16 = new LinkmicOnlineFloatWindowRetainDialog(r14, r15, r7, new MultiLinkVoiceGuestContainerWidget$interceptCloseRoomByLinkmicOnlineFloatWindow$3(this));
        if (DialogLancet.shouldBlockDialogShow(r16) == false) goto L127;
        DialogLancet.handleBlockedDialogShow(r16);
        goto L104
    L127:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L123
    L103:
        DialogLancet.beforeDialogShow(r16);
        r16.show();
        DialogLancet.afterDialogShow(r16);
        goto L104
    L81:
        if (((Boolean) r12.get("data_close_room_from_small_window_play", Boolean.FALSE)).booleanValue() == false) goto L86;
        if (rx1.m.e(((Widget) this).context) == false) goto L85;
        yq(new o(this, r7), LinkApi.ApplyStashType.ONLINE_WINDOW.ordinal());
        goto L104
    L85:
        rx1.m.h(((Widget) this).context);
        goto L104
    L6:
        if (jc0.a.a() == true) goto L44;
        if (LinkMicGameContext.Companion.e() == true) goto L44;
        Integer r17 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r17 == null) goto L44;
        if (r17.intValue() != 1) goto L44;
        if (r8 == true) goto L44;
        DataCenter r18 = ((Widget) this).dataCenter;
        if (r18 != null) goto L20;
    L25:
        Integer r19 = (Integer) b6.j.getValue();
        if (r19 == null) goto L34;
        if (r19.intValue() != 1) goto L34;
        if (rx1.m.e(((Widget) this).context) == false) goto L34;
        yq(new n(this, r7), LinkApi.ApplyStashType.APPLY_WINDOW.ordinal());
    L43:
        r1 = true;
    L34:
        if (xe0.j.b() == false) goto L44;
        Context r20 = ((Widget) this).context;
        IRoom r21 = this.h;
        if (r21 != null) goto L38;
        r21 = (IRoom) vh7.f.c(IRoom.class);
    L38:
        AppCompatDialog r22 = new LinkmicApplyFloatWindowRetainDialog(r20, r21, r7);
        if (DialogLancet.shouldBlockDialogShow(r22) == false) goto L125;
        DialogLancet.handleBlockedDialogShow(r22);
        goto L43
    L125:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L124
    L42:
        DialogLancet.beforeDialogShow(r22);
        r22.show();
        DialogLancet.afterDialogShow(r22);
        goto L43
    L20:
        if (((Boolean) r18.get("data_close_room_from_small_window_play", Boolean.FALSE)).booleanValue() == false) goto L25;
        if (rx1.m.e(((Widget) this).context) == false) goto L24;
        yq(new m(this, r7), LinkApi.ApplyStashType.APPLY_WINDOW.ordinal());
        goto L43
    L24:
        rx1.m.h(((Widget) this).context);
        goto L43
    }

    @Override // kn0.b
    public final void onSei(String r4, ye1.a r5) {
        Intrinsics.checkNotNullParameter(r4, "sei");
        Intrinsics.checkNotNullParameter(r5, "info");
        if (r5.a == true) goto L5;
    L6:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L10;
        r0.onSei(r4, r5);
    L10:
        if (r5.a == true) goto L12;
    L13:
        IKtvService r1 = jc1.k.f(IKtvService.class);
        if (r1 == null) goto L18;
        r1.onSei(r4, r5);
        return;
    L18:
        return;
    L12:
        if (MultiLinkBizBackupSeiExperimentUtils.INSTANCE.isVoiceKtvEnable(this.h, false) == true) goto L13;
        return;
    L5:
        if (MultiLinkBizBackupSeiExperimentUtils.INSTANCE.isVoiceTalkRoomEnable(this.h, false) == false) goto L10;
        goto L6
    }

    public final void yq(ye0.a r7, int r8) {
        long r0 = System.currentTimeMillis();
        LinkApi r2 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r3 = this.h;
        if (r3 == null) goto L5;
        long r4 = r3.getRoomId();
    L6:
        Disposable r9 = r2.applyStash(r4, 0, r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new k(r7, r0), new l(r7, r0));
        this.b.add(r9);
        return;
    L5:
        r4 = 0;
        goto L6
    }

    public final void zq(int r9, int r10, String r11) {
        xs2.b.a().post(new com.bytedance.android.livesdk.event.t(2));
        xs2.b.a().post(new com.bytedance.android.livesdk.event.t(1));
        if (r9 == 5) goto L137;
        if (r9 == 9) goto L10;
        if (r9 == 16) goto L137;
        return;
    L10:
        if (r10 != 61) goto L66;
        if (this.g != null) goto L211;
        Integer r12 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r12 != null) goto L17;
    L19:
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r13 = jc1.k.n(IKtvService.class).createRealTimeChorusRoomGuestWidget(this.j);
        this.g = r13;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r14 = this.e;
        if (r14 == null) goto L41;
        if (r13 == null) goto L40;
        r13.Jc(r14.Tj());
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r15 = this.g;
        if (r15 == null) goto L38;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r16 = r15;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r17 = this.e;
        if (r17 == null) goto L36;
        r16.Nl(r17.Xh());
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r18 = this.g;
        if (r18 == null) goto L34;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r19 = r18;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r110 = this.e;
        if (r110 == null) goto L32;
        r19.n0(r110.s0());
        goto L41
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L34:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L36:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L41:
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r20 = this.f;
        if (r20 == null) goto L64;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r111 = this.g;
        if (r111 == null) goto L63;
        r111.Jc(r20.Tj());
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r21 = this.g;
        if (r21 == null) goto L61;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r22 = r21;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r112 = this.f;
        if (r112 == null) goto L59;
        r22.Nl(r112.Xh());
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r23 = this.g;
        if (r23 == null) goto L57;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r24 = r23;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r113 = this.f;
        if (r113 == null) goto L55;
        r24.n0(r113.s0());
        goto L64
    L55:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L57:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L61:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L63:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L64:
        ((Widget) this).subWidgetManager.unload(this.f);
        ((Widget) this).subWidgetManager.unload(this.e);
        this.e = null;
        this.f = null;
        ((Widget) this).subWidgetManager.load(2131392754, this.g, false);
        return;
    L17:
        if (r12.intValue() != 1) goto L19;
        hd0.c.f().k(0);
        goto L19
    L211:
        return;
    L66:
        if (this.f != null) goto L213;
        Integer r25 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r25 != null) goto L71;
    L73:
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r26 = jc1.k.n(IKtvService.class).createKtvRoomGuestWidget(this.j);
        this.f = r26;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r114 = this.e;
        if (r114 == null) goto L95;
        if (r26 == null) goto L94;
        r26.Jc(r114.Tj());
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r27 = this.f;
        if (r27 == null) goto L92;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r28 = r27;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r115 = this.e;
        if (r115 == null) goto L90;
        r28.Nl(r115.Xh());
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r29 = this.f;
        if (r29 == null) goto L88;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r30 = r29;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r116 = this.e;
        if (r116 == null) goto L86;
        r30.n0(r116.s0());
        goto L95
    L86:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L88:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L90:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L92:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L94:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L95:
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r31 = this.g;
        if (r31 == null) goto L118;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r117 = this.f;
        if (r117 == null) goto L117;
        r117.Jc(r31.Tj());
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r32 = this.f;
        if (r32 == null) goto L115;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r33 = r32;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r118 = this.g;
        if (r118 == null) goto L113;
        r33.Nl(r118.Xh());
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r34 = this.f;
        if (r34 == null) goto L111;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r35 = r34;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r119 = this.g;
        if (r119 == null) goto L109;
        r35.n0(r119.s0());
        goto L118
    L109:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L111:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L113:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L115:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L117:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L118:
        ((Widget) this).subWidgetManager.unload(this.e);
        ((Widget) this).subWidgetManager.unload(this.g);
        this.e = null;
        this.g = null;
        ((Widget) this).subWidgetManager.load(2131392754, this.f, false);
        if (MultiLinkLoadWidgetUtils.f() == true) goto L121;
        return;
    L121:
        if ((this.f instanceof com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b) == true) goto L123;
        return;
    L123:
        if (this.h != null) goto L125;
        return;
    L125:
        if (MultiLinkOpenSource.FAST_INIT_MODE.equals(r11) == false) goto L131;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r36 = this.f;
        if (r36 == null) goto L130;
        IRoom r120 = this.h;
        Intrinsics.checkNotNull(r120);
        r36.h0(r120);
        return;
    L130:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L131:
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r37 = this.f;
        if (r37 == null) goto L135;
        IRoom r121 = this.h;
        Intrinsics.checkNotNull(r121);
        r37.U0(r121);
        return;
    L135:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L71:
        if (r25.intValue() != 1) goto L73;
        hd0.c.f().k(0);
        goto L73
    L213:
        return;
    L137:
        if (this.e == null) goto L139;
        return;
    L139:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L141;
    L148:
        com.bytedance.android.live.liveinteract.plantform.base.g r38 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r38 == null) goto L151;
        r38.Cj("voiceSceneChange");
    L151:
        Integer r39 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r39 != null) goto L155;
    L157:
        int r40 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r41 = ((Widget) this).dataCenter;
        IRoom r122 = this.h;
        if (r122 == null) goto L160;
        long r0 = r122.getRoomId();
    L161:
        MultiSceneEnterRoomStatisticsUtils r42 = MultiSceneEnterRoomStatisticsUtils.a.a(r41, Long.valueOf(r0));
        if (r42 == null) goto L164;
        r42.c();
    L164:
        System.currentTimeMillis();
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r43 = ((IMultiLinkVoiceService) jc1.k.n(IMultiLinkVoiceService.class)).createVoiceChatRoomGuestWidget(this.j, new a(this, r11));
        this.e = r43;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r123 = this.f;
        if (r123 == null) goto L186;
        if (r43 == null) goto L185;
        r43.Jc(r123.Tj());
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r44 = this.e;
        if (r44 == null) goto L183;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r45 = r44;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r124 = this.f;
        if (r124 == null) goto L181;
        r45.Nl(r124.Xh());
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r46 = this.e;
        if (r46 == null) goto L179;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r47 = r46;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r125 = this.f;
        if (r125 == null) goto L177;
        r47.n0(r125.s0());
        goto L186
    L177:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L179:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L181:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L183:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L185:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L186:
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r48 = this.g;
        if (r48 == null) goto L209;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r126 = this.e;
        if (r126 == null) goto L208;
        r126.Jc(r48.Tj());
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r49 = this.e;
        if (r49 == null) goto L206;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r50 = r49;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r127 = this.g;
        if (r127 == null) goto L204;
        r50.Nl(r127.Xh());
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r51 = this.e;
        if (r51 == null) goto L202;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r52 = r51;
        com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b r128 = this.g;
        if (r128 == null) goto L200;
        r52.n0(r128.s0());
        goto L209
    L200:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L202:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L204:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L206:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L208:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceGuestLinkService");
    L209:
        ((Widget) this).subWidgetManager.unload(this.f);
        ((Widget) this).subWidgetManager.unload(this.g);
        this.f = null;
        this.g = null;
        ((Widget) this).subWidgetManager.load(2131392754, this.e, false);
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "loadVoiceChatGuestWidget", "call mWidgetManager.load finish.");
        return;
    L160:
        r0 = 0;
        goto L161
    L155:
        if (r39.intValue() != 1) goto L157;
        hd0.c.f().k(0);
        goto L157
    L141:
        if ((!Intrinsics.areEqual(r11, MultiLinkOpenSource.FAST_INIT_MODE)) == false) goto L148;
        int r53 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r54 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(((Widget) this).dataCenter);
        if ((r54 instanceof MultiLinkUIWidget) == true) goto L145;
        r54 = null;
    L145:
        MultiLinkUIWidget r55 = (MultiLinkUIWidget) r54;
        if (r55 == null) goto L148;
        r55.Fq("voice_chat_switch");
        goto L148
    }
}
