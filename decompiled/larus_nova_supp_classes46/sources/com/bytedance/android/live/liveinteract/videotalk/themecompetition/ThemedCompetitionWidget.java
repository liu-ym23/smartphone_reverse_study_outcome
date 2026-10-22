package com.bytedance.android.live.liveinteract.videotalk.themecompetition;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import com.bytedance.android.livesdk.chatroom.model.interact.SelectionType;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionPerformerUpdateType;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionStatus;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionWinType;
import com.bytedance.android.livesdk.chatroom.model.interact.a2;
import com.bytedance.android.livesdk.chatroom.model.interact.b2;
import com.bytedance.android.livesdk.chatroom.model.interact.n1;
import com.bytedance.android.livesdk.chatroom.model.t1;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.da;
import com.bytedance.android.livesdk.message.model.ea;
import com.bytedance.android.livesdk.message.model.fa;
import com.bytedance.android.livesdk.message.model.ha;
import com.bytedance.android.livesdk.message.model.ia;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.LiveThemedCompetitionSchemaConfig;
import com.bytedance.android.livesdkapi.model.Rank;
import com.bytedance.android.livesdkapi.model.Setting;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rj0.k;
import tf0.o;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/themecompetition/ThemedCompetitionWidget;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/playmode/AbsPlayModeWidget;", "Lpj0/b;", "Lvlc/l;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ThemedCompetitionWidget extends AbsPlayModeWidget implements pj0.b, l {
    public static final /* synthetic */ int f = 0;
    public vlc.d a;
    public final CompositeDisposable b;
    public ThemedCompetitionContext c;
    public ThemedCompetitionViewManager d;
    public i0 e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ThemedCompetitionWidget a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public b(ThemedCompetitionWidget r1, boolean r2, String r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r11) {
            com.bytedance.android.live.network.response.e r12 = (com.bytedance.android.live.network.response.e) r11;
            if (this.b == false) goto L5;
            int r0 = 2131922889;
        L6:
            f2.b(r0, 0);
            if (this.b == true) goto L15;
            long r2 = System.currentTimeMillis();
            t1 r1 = (t1) r12.data;
            if (r1 == null) goto L13;
            Long r3 = r1.getPerformStartTime();
            if (r3 == null) goto L13;
            long r4 = r3.longValue();
        L14:
            long r5 = (r2 - r4) / ((long) 1000);
            com.bytedance.android.live.liveinteract.videotalk.themecompetition.a r6 = com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a;
            ThemedCompetitionWidget r7 = this.a;
            int r8 = ThemedCompetitionWidget.f;
            com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a(r7.isAnchor(), this.b, this.c, Long.valueOf(r5));
        L13:
            r4 = System.currentTimeMillis();
        L15:
            TalkRoomBusinessFullLinkMonitor r9 = TalkRoomBusinessFullLinkMonitor.a;
            boolean r10 = this.b;
            long r13 = this.d;
            r9.getClass();
            Intrinsics.checkNotNullParameter(r12, "response");
            JSONObject r14 = new JSONObject();
            if (r10 == false) goto L18;
            String r15 = "perform";
        L19:
            Long r16 = ((t1) r12.data).getPerformStartTime();
            if (r16 == null) goto L22;
            long r17 = r16.longValue();
        L23:
            r14.put("action_type", r15);
            if (r10 == true) goto L26;
            i97.a r18 = i97.a.a;
            r14.put("perform_duration", (System.currentTimeMillis() - r17) / ((long) 1000));
        L26:
            TalkRoomBusinessFullLinkMonitor.Z(LinkMonitorData.ThemedCompetitionUpdatePerformerApiMonitorData, TalkRoomBusinessFullLinkMonitor.h(r13), r12.logId, r14);
            return;
        L22:
            r17 = 0;
            goto L23
        L18:
            r15 = "cancel";
            goto L19
        L5:
            r0 = 2131922891;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ThemedCompetitionWidget a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;

        public c(ThemedCompetitionWidget r1, boolean r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            if ((r7 instanceof ApiServerException) == false) goto L12;
            String r0 = com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r7);
            if (r0 == null) goto L12;
            if (r0.length() <= 0) goto L9;
            boolean r1 = true;
        L10:
            if (r1 == false) goto L12;
            f2.c(r0, 0);
            goto L12
        L9:
            r1 = false;
        L12:
            TalkRoomBusinessFullLinkMonitor r2 = TalkRoomBusinessFullLinkMonitor.a;
            boolean r3 = this.b;
            long r4 = this.c;
            r2.getClass();
            JSONObject r5 = new JSONObject();
            if (r3 == false) goto L15;
            String r8 = "perform";
        L16:
            r5.put("action_type", r8);
            TalkRoomBusinessFullLinkMonitor.Y(LinkMonitorData.ThemedCompetitionUpdatePerformerApiMonitorData, TalkRoomBusinessFullLinkMonitor.h(r4), r7, r5);
            ExceptionUtils.handleException(((Widget) this.a).context, r7);
            return;
        L15:
            r8 = "cancel";
            goto L16
        }
    }

    static {
    }

    @Override // pj0.b
    public final void m4() {
    }

    @Override // xh0.b
    public final void tryStartPlayMode(HashMap<String, Object> r1) {
    }

    @Override // xh0.b
    public final void tryStopPlayMode(HashMap<String, Object> r1) {
    }

    public static o xq() {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 == null) goto L6;
        o r1 = r0.windowManager();
        if (r1 == null) goto L6;
        return r1;
    L6:
        k.m2.getClass();
        k r2 = k.a.a();
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.windowManager();
    }

    @Override // pj0.b
    public final void Q1() {
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.c.a("ThemedCompetitionWidget", "[onRtcStartSuccess] pre initThemedCompetitionSticker");
    }

    @Override // xh0.b
    public final ArrayList<xh0.f> getIncompatibleSourceList() {
        IncompatibleTag r2 = IncompatibleTag.PLAY_MODE;
        return CollectionsKt.arrayListOf(new xh0.f[]{new xh0.f(r2, 5), new xh0.f(r2, 7, ""), new xh0.f(r2, 16, ""), new xh0.f(r2, 11, ""), new xh0.f(r2, 6, ""), new xh0.f(r2, 17, ""), new xh0.f(r2, 19, ""), new xh0.f(r2, 29, "")});
    }

    @Override // xh0.b
    public final xh0.h getPlayModeInfo() {
        return new xh0.h(22, s1.B(2131922888));
    }

    @Override // pj0.b
    public final c0.b getToolbarBehavior() {
        return new i();
    }

    public final boolean isAnchor() {
        return a0.d(((Widget) this).dataCenter, false);
    }

    @Override // xh0.b
    public final boolean isOpen() {
        return ThemedCompetitionContext.Companion.g();
    }

    public ThemedCompetitionWidget() {
        this.b = new CompositeDisposable();
    }

    @Override // pj0.b
    public final boolean Y8() {
        if (je0.d.O() == false) goto L5;
        return true;
    L5:
        if (je0.d.f() != 5) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        return true;
    L13:
        if (je0.d.y() == true) goto L19;
        return false;
    L19:
        return true;
    L7:
        if (je0.d.s() == true) goto L10;
        r0 = false;
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        boolean r0 = false;
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(0) == true) goto L8;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r1 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, ((Widget) this).dataCenter);
        if (r1 == null) goto L8;
        i0 r2 = new i0();
        this.e = r2;
        Intrinsics.checkNotNull(r2);
        r1.M0(r2);
    L8:
        Pair r3 = com.bytedance.live.datacontext.d.a(ThemedCompetitionWidget$initDataContext$pair$1.INSTANCE);
        ThemedCompetitionContext r4 = (ThemedCompetitionContext) r3.getFirst();
        r4.getService().d(this);
        com.bytedance.live.datacontext.b.a(r4, pj0.a.class);
        this.c = r4;
        this.b.add((Disposable) r3.getSecond());
        DataCenter r5 = ((Widget) this).dataCenter;
        LiveMode r6 = null;
        if (r5 == null) goto L11;
        vlc.d r7 = (vlc.d) r5.get("data_message_manager", null);
    L12:
        this.a = r7;
        if (r7 == null) goto L15;
        r7.addMessageListener(MessageType.THEMED_COMPETITION_MESSAGE.getKey(), this);
    L15:
        ThemedCompetitionViewManager r8 = (ThemedCompetitionViewManager) ((Widget) this).dataCenter.get("data_themed_competition_view_manager", new ThemedCompetitionViewManager(null, null));
        if ((r8 instanceof pj0.c) == true) goto L18;
        r8 = null;
    L18:
        if (r8 == null) goto L20;
        ee(r8);
        ((Widget) this).dataCenter.put("data_themed_competition_view_manager", null);
    L20:
        z5 r9 = a0.n(((Widget) this).dataCenter).getLinkerDetail();
        if (r9 == null) goto L23;
        List r10 = r9.getPlayModes();
    L25:
        if (r10 == null) goto L30;
        if (r10.contains(22L) == false) goto L30;
        r0 = true;
    L30:
        if (r0 == false) goto L47;
        j r11 = m.e(this).J();
        if (r11 == null) goto L36;
        LivePlayModeLogContext r12 = (LivePlayModeLogContext) r11.getValue();
        if (r12 == null) goto L36;
        r12.addPlayMode(22);
    L36:
        z5 r13 = a0.n(((Widget) this).dataCenter).getLinkerDetail();
        if (r13 == null) goto L46;
        Map r14 = r13.getPlayModeDetail();
        if (r14 == null) goto L46;
        String r15 = (String) r14.get(String.valueOf(22));
        if (r15 == null) goto L46;
        a2 r16 = vh7.f.c(a2.class);
        b2 r17 = vh7.f.c(b2.class);
        r17.setSelectionType(CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(new JSONObject(r15), "selection_type")));
        Unit r18 = Unit.INSTANCE;
        r16.setSetting(r17);
        ThemedCompetitionContext r19 = this.c;
        if (r19 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L45:
        r19.getInfo().setValue(r16);
    L46:
        RxUtilKt.c(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).fetchPlayModeInfo(a0.n(((Widget) this).dataCenter).getId(), true).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this), new h(this)), this.b);
    L47:
        n r20 = m.e(this).a();
        if (r20 == null) goto L64;
        ArrayList r21 = (ArrayList) r20.getValue();
        if (r21 != null) goto L52;
        return;
    L52:
        if (r21.contains(22) != true) goto L66;
        ja("theme_convenient");
        com.bytedance.live.datacontext.i r22 = m.j(this).getLiveMode();
        if (r22 == null) goto L57;
        r6 = (LiveMode) r22.getValue();
    L57:
        if (r6 != LiveMode.AUDIO) goto L67;
        n r23 = m.e(this).a();
        if (r23 == null) goto L68;
        ArrayList r24 = (ArrayList) r23.getValue();
        if (r24 == null) goto L69;
        r24.remove(22);
        return;
    L69:
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L64:
        return;
    L23:
        r10 = null;
        goto L25
    L11:
        r7 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        if (ThemedCompetitionContext.Companion.g() == true) goto L5;
    L8:
        vlc.d r0 = this.a;
        if (r0 == null) goto L12;
        r0.removeMessageListener(this);
    L12:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(0) == true) goto L19;
        i0 r1 = this.e;
        if (r1 == null) goto L19;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r2 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, ((Widget) this).dataCenter);
        if (r2 == null) goto L19;
        r2.d1(r1);
    L19:
        this.b.dispose();
        return;
    L5:
        if (isAnchor() == false) goto L7;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.d();
        goto L8
    L7:
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.f();
        goto L8
    }

    public final void wq() {
        o r0 = xq();
        if (r0 == null) goto L5;
        r0.z();
    L5:
        i0 r1 = this.e;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.b == false) goto L25;
        ThemedCompetitionContext r2 = ThemedCompetitionContext.Companion.getContext();
        if (r2 == null) goto L17;
        com.bytedance.live.datacontext.m<ThemedCompetitionStatus> r3 = r2.getStatus();
        if (r3 == null) goto L17;
        ThemedCompetitionStatus r4 = (ThemedCompetitionStatus) r3.getValue();
        if (r4 == null) goto L17;
    L19:
        if (r4.getValue() != ThemedCompetitionStatus.START.getValue()) goto L21;
        r1.a().B0(true);
    L22:
        r1.c = true;
        r1.d = null;
        ((LinkedHashMap) r1.e).clear();
        r1.c();
        return;
    L21:
        r1.a().B0(false);
    L17:
        r4 = ThemedCompetitionStatus.UNKNOWN;
        goto L19
    }

    @Override // pj0.b
    public final void ee(pj0.c r3) {
        if (r3 != null) goto L7;
        this.d = null;
        return;
    L7:
        if ((r3 instanceof ThemedCompetitionViewManager) == true) goto L9;
        r3 = null;
    L9:
        ThemedCompetitionViewManager r4 = (ThemedCompetitionViewManager) r3;
        if (r4 == null) goto L13;
        this.d = r4;
        return;
    }

    @Override // pj0.b
    public final void ja(String r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        IInteractService r1 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r1 == null) goto L10;
        ai0.e r2 = r1.getAdventureService();
        if (r2 == null) goto L10;
        if (((ai0.c) r2).c() != true) goto L10;
        f2.b(2131922883, 0);
        return;
    L10:
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.a r3 = com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.b = r5;
        String r4 = null;
        Setting r6 = ((LiveThemedCompetitionSchemaConfig) vm2.d.v7.getValue(null, vm2.d.a[434(0x1b2, float:6.08E-43)])).getSetting();
        if (r6 == null) goto L13;
        r4 = r6.getFullSchema();
    L13:
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("source", r5);
        r7.put("play_mode", u0.b());
        r7.put("disable_open_track", "true");
        String r8 = y0.b(r4, r7);
        jc1.k.n(IBaseLiveActionHandler.class).handle(((Widget) this).context, r8);
    }

    public final void onMessage(tlc.d r10) {
        if ((r10 instanceof da) == false) goto L200;
        int r0 = nd0.g.a;
        da r11 = (da) r10;
        Intrinsics.checkNotNullParameter(r11, MultiLinkOpenSource.MESSAGE);
        JSONObject r3 = new JSONObject();
        r3.put("msg_id", r11.getMessageId());
        int r1 = r11.getMsgType();
        if (r1 != 1) goto L7;
        String r2 = "start";
    L17:
        r3.put("msg_type", r2);
        nd0.c.o(nd0.c.a, LinkMonitorData.ReceiveThemedCompetitionMsgMonitorData, r3, 0, null, false, 28);
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.c.a("ThemedCompetitionWidget", "ILinkmicThemedCompetitionMessage, msg_id=" + r11.getMessageId() + ", msg_type=" + r11.getMsgType());
        switch(r11.getMsgType()) {
            case 1: goto L168;
            case 2: goto L137;
            case 3: goto L73;
            case 4: goto L50;
            case 5: goto L27;
            case 6: goto L21;
            default: goto L212;
        };
    L27:
        ha r12 = r11.getShowTimeStartContent();
        if (r12 == null) goto L202;
        ThemedCompetitionContext r4 = this.c;
        if (r4 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L32:
        r4.getStatus().setValue(ThemedCompetitionStatus.SHOW_RESULT);
        a2 r13 = r12.getInfo();
        if (r13 == null) goto L48;
        ThemedCompetitionContext r5 = ThemedCompetitionContext.Companion.getContext();
        if (r5 == null) goto L39;
        n<a2> r6 = r5.getInfo();
        if (r6 == null) goto L39;
        r6.setValue(r13);
    L39:
        ThemedCompetitionViewManager r7 = this.d;
        if (r7 == null) goto L48;
        ArrayList r8 = new ArrayList();
        Iterator r14 = r13.getUserIdStrToScore().entrySet().iterator();
    L43:
        if (r14.hasNext() == false) goto L47;
        Map.Entry r9 = (Map.Entry) r14.next();
        String r15 = (String) r9.getKey();
        if (((n1) r9.getValue()).getWinType() != ThemedCompetitionWinType.WIN.getValue()) goto L43;
        r8.add(r15);
        goto L43
    L47:
        r7.a(r8);
    L48:
        wq();
        return;
    L202:
        return;
    L73:
        fa r16 = r11.getScoreChangeContent();
        if (r16 == null) goto L206;
        a2 r17 = r16.getInfo();
        Map r18 = null;
        if (r17 == null) goto L78;
        Long r19 = Long.valueOf(r17.getCompetitionId());
    L79:
        ThemedCompetitionContext r20 = this.c;
        if (r20 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L82:
        a2 r21 = (a2) r20.getInfo().getValue();
        if (r21 == null) goto L85;
        Long r22 = Long.valueOf(r21.getCompetitionId());
    L87:
        if (Intrinsics.areEqual(r19, r22) == false) goto L207;
        a2 r23 = r16.getInfo();
        if (r23 == null) goto L95;
        ThemedCompetitionContext r24 = ThemedCompetitionContext.Companion.getContext();
        if (r24 == null) goto L95;
        n<a2> r25 = r24.getInfo();
        if (r25 == null) goto L95;
        r25.setValue(r23);
    L95:
        o r26 = xq();
        if (r26 == null) goto L98;
        r26.F();
    L98:
        i0 r27 = this.e;
        if (r27 == null) goto L208;
        Intrinsics.checkNotNullParameter(r16, "content");
        if (r27.b == false) goto L213;
        ThemedCompetitionContext.a r28 = ThemedCompetitionContext.Companion;
        fa r29 = r27.d;
        r28.getClass();
        Intrinsics.checkNotNullParameter(r16, "newContent");
        LinkedHashMap r30 = new LinkedHashMap();
        if (r29 == null) goto L108;
        a2 r31 = r29.getInfo();
        if (r31 == null) goto L108;
        Map r32 = r31.getUserIdStrToScore();
    L109:
        a2 r33 = r16.getInfo();
        if (r33 == null) goto L112;
        r18 = r33.getUserIdStrToScore();
    L112:
        if (r29 != null) goto L118;
        if (r18 == null) goto L136;
        ArrayList r34 = new ArrayList(r18.size());
        Iterator r35 = r18.entrySet().iterator();
    L116:
        if (r35.hasNext() == false) goto L136;
        Map.Entry r36 = (Map.Entry) r35.next();
        r30.put(r36.getKey(), r36.getValue());
        r34.add(Unit.INSTANCE);
    L136:
        r27.e = r30;
        r27.d = r16;
        r27.c();
        return;
    L118:
        if (r32 == null) goto L136;
        if (r18 == null) goto L136;
        ArrayList r37 = new ArrayList(r18.size());
        Iterator r38 = r18.entrySet().iterator();
    L122:
        if (r38.hasNext() == false) goto L136;
        Map.Entry r39 = (Map.Entry) r38.next();
        if (r32.containsKey(r39.getKey()) == true) goto L126;
        r30.put(r39.getKey(), r39.getValue());
    L135:
        r37.add(Unit.INSTANCE);
        goto L122
    L126:
        n1 r40 = (n1) r32.get(r39.getKey());
        if (r40 != null) goto L129;
    L134:
        r30.put(r39.getKey(), r39.getValue());
        goto L135
    L129:
        if (r40.getWinType() != ((n1) r39.getValue()).getWinType()) goto L134;
        n1 r41 = (n1) r32.get(r39.getKey());
        if (r41 == null) goto L134;
        if (r41.getShowFaceEffect() == ((n1) r39.getValue()).getShowFaceEffect()) goto L135;
    L108:
        r32 = null;
        goto L109
    L213:
        return;
    L208:
        return;
    L207:
        return;
    L85:
        r22 = null;
        goto L87
    L78:
        r19 = null;
        goto L79
    L206:
        return;
    L137:
        final ThemedCompetitionViewManager r110 = this.d;
        if (r110 == null) goto L146;
        HSImageView r42 = r110.a;
        if (r42 == null) goto L142;
        UtilityKotlinExtentionsKt.w(r42);
    L142:
        r110.b = true;
        HSImageView r43 = r110.a;
        if (r43 == null) goto L146;
        f.a(r43, LiveCommonConstants.assembleTosObjectUrl(d.c), new ThemedCompetitionViewManager$endEffect$1(r110));
    L146:
        if (isAnchor() == false) goto L148;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.d();
    L149:
        ThemedCompetitionContext r111 = this.c;
        if (r111 != null) goto L152;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L152:
        r111.getStatus().setValue(ThemedCompetitionStatus.FINISH);
        ThemedCompetitionContext.a r112 = ThemedCompetitionContext.Companion;
        ThemedCompetitionContext r44 = r112.getContext();
        if (r44 == null) goto L157;
        com.bytedance.live.datacontext.m<ThemedCompetitionStatus> r45 = r44.getStatus();
        if (r45 == null) goto L157;
        r45.setValue(ThemedCompetitionStatus.UNKNOWN);
    L157:
        ThemedCompetitionContext r113 = r112.getContext();
        if (r113 == null) goto L162;
        n<a2> r114 = r113.getInfo();
        if (r114 == null) goto L162;
        r114.setValue(vh7.f.c(a2.class));
    L162:
        j r115 = m.e(this).J();
        if (r115 == null) goto L167;
        LivePlayModeLogContext r116 = (LivePlayModeLogContext) r115.getValue();
        if (r116 == null) goto L167;
        r116.removePlayMode(22);
    L167:
        wq();
        return;
    L148:
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.f();
        goto L149
    L168:
        ThemedCompetitionViewManager r46 = this.d;
        if (r46 == null) goto L171;
        r46.b();
    L171:
        ia r117 = r11.getStartContent();
        if (r117 == null) goto L180;
        a2 r118 = r117.getInfo();
        if (r118 == null) goto L180;
        ThemedCompetitionContext.Companion.f(r118);
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.a r47 = com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a;
        b2 r119 = r118.getSetting();
        if (r119 == null) goto L178;
        r119.getSelectionType();
    L179:
        r47.getClass();
        goto L180
    L178:
        SelectionType.UNKNOWN.getValue();
    L180:
        j r120 = m.e(this).J();
        if (r120 == null) goto L185;
        LivePlayModeLogContext r121 = (LivePlayModeLogContext) r120.getValue();
        if (r121 == null) goto L185;
        r121.addPlayMode(22);
    L185:
        wq();
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a.a = System.currentTimeMillis();
        if (isAnchor() == false) goto L188;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.c();
        return;
    L188:
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.e();
        return;
    L212:
        return;
    L21:
        if (r11.getShowTimeFinishContent() == null) goto L26;
        ThemedCompetitionContext r122 = this.c;
        if (r122 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L25:
        r122.getStatus().setValue(ThemedCompetitionStatus.FINISH);
    L26:
        wq();
        return;
    L50:
        if (isAnchor() == false) goto L52;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.d();
    L52:
        ThemedCompetitionViewManager r48 = this.d;
        if (r48 == null) goto L55;
        r48.b();
    L55:
        ea r123 = r11.getOnceMoreContent();
        if (r123 == null) goto L64;
        a2 r124 = r123.getInfo();
        if (r124 == null) goto L64;
        ThemedCompetitionContext.Companion.f(r124);
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.a r49 = com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a;
        b2 r125 = r124.getSetting();
        if (r125 == null) goto L62;
        r125.getSelectionType();
    L63:
        r49.getClass();
        goto L64
    L62:
        SelectionType.UNKNOWN.getValue();
    L64:
        j r126 = m.e(this).J();
        if (r126 == null) goto L69;
        LivePlayModeLogContext r127 = (LivePlayModeLogContext) r126.getValue();
        if (r127 == null) goto L69;
        r127.addPlayMode(22);
    L69:
        wq();
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a.a = System.currentTimeMillis();
        if (isAnchor() == false) goto L72;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.c();
        return;
    L72:
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.e();
        return;
    L7:
        if (r1 != 2) goto L9;
        r2 = "close";
        goto L17
    L9:
        if (r1 != 3) goto L11;
        r2 = "score_change";
        goto L17
    L11:
        if (r1 == 4) goto L13;
        r2 = "unknown: " + r11.getMsgType();
        goto L17
    L13:
        r2 = "once_more";
        goto L17
    }

    @Override // pj0.b
    public final void Qp(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "uid");
        Intrinsics.checkNotNullParameter(r6, "nickName");
        String r2 = null;
        Rank r0 = ((LiveThemedCompetitionSchemaConfig) vm2.d.v7.getValue(null, vm2.d.a[434(0x1b2, float:6.08E-43)])).getRank();
        if (r0 == null) goto L5;
        r2 = r0.getFullSchema();
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        int r3 = ThemedCompetitionContext.Companion.b();
        if (r3 != SelectionType.NORMAL.getValue()) goto L9;
        int r4 = 1;
    L12:
        r1.put("listtype", String.valueOf(r4));
        r1.put("currentid", r5.toString());
        r1.put("currentname", r6);
        r1.put("play_mode", u0.b());
        String r7 = y0.b(r2, r1);
        jc1.k.n(IBaseLiveActionHandler.class).handle(((Widget) this).context, r7);
        return;
    L9:
        if (r3 != SelectionType.SCORING.getValue()) goto L11;
        r4 = 2;
        goto L12
    L11:
        r4 = 0;
        goto L12
    }

    @Override // pj0.b
    public final void Z6(long r11, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "performerUserId");
        if (r14 == false) goto L5;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.a r0 = com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a(isAnchor(), r14, r13, null);
    L5:
        long r1 = System.currentTimeMillis();
        LinkAudienceApi r3 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        long r6 = d5.c(r13);
        if (r14 == false) goto L8;
        ThemedCompetitionPerformerUpdateType r2 = ThemedCompetitionPerformerUpdateType.SET;
    L9:
        RxUtilKt.c(r3.updatePerformer(r11, r6, r13, r2.getValue()).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r14, r13, r1), new c(this, r14, r1)), this.b);
        return;
    L8:
        r2 = ThemedCompetitionPerformerUpdateType.UNSET;
        goto L9
    }
}
