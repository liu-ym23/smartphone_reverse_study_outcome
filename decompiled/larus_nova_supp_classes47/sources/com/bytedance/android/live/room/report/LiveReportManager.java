package com.bytedance.android.live.room.report;

import am2.l;
import am2.n;
import am2.x;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.browser.webview.fragment.o;
import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.config.af1;
import com.bytedance.android.livesdk.config.ho;
import com.bytedance.android.livesdk.config.j3;
import com.bytedance.android.livesdk.config.nl;
import com.bytedance.android.livesdk.config.oc;
import com.bytedance.android.livesdk.config.pc;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.filter.s0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomState;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.android.livesdkapi.model.VSFoldFixConfig;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rj0.m;
import zg1.r2;
import zg1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LiveReportManager {
    public static final /* synthetic */ int b = 0;
    public Pair<Long, String> a;

    public static final class a {
    }

    public final class b implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.room.report.LiveReportManager$d$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm81/a;", "p1", "", "invoke", "(Lm81/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<m81.a, Unit> {
        public AnonymousClass1(LiveReportManager r8) {
            super(1, r8, LiveReportManager.class, "onReportConfigurationChanged", "onReportConfigurationChanged(Lcom/bytedance/android/live/room/api/userinfo/event/ReportConfigurationChangedEvent;)V", 0);
        }

        public final void invoke(m81.a r8) {
            LiveReportManager r0 = (LiveReportManager) ((CallableReference) this).receiver;
            int r1 = LiveReportManager.b;
            r0.getClass();
            if (r8 != null) goto L5;
            return;
        L5:
            if (r8.a == 0) goto L32;
            Pair<Long, String> r2 = r0.a;
            if (r2 != null) goto L10;
            return;
        L10:
            if (((Number) r2.getFirst()).longValue() != r8.a) goto L24;
            Pair<Long, String> r3 = r0.a;
            if (r3 == null) goto L14;
            String r4 = (String) r3.getSecond();
        L16:
            if (TextUtils.isEmpty(r4) == true) goto L24;
            Map<String, String> r9 = ReportTracer.a;
            ReportTracer.b(ReportTracer.EventName.on_report_configuration_changed);
            Pair<Long, String> r10 = r0.a;
            if (r10 == null) goto L22;
            String r12 = (String) r10.getSecond();
            if (r12 == null) goto L22;
        L23:
            LiveReportManager.f(r12);
        L29:
            r0.a = null;
            return;
        L22:
            r12 = "";
            goto L23
        L14:
            r4 = null;
        L24:
            int r5 = d.a;
            StringBuilder r6 = new StringBuilder("event.roomId isn't equal to saved roomId, or url is null; event: ");
            r6.append(r8.toString());
            r6.append(", reportAnchorPair: ");
            Pair<Long, String> r13 = r0.a;
            if (r13 == null) goto L27;
            String r14 = "roomId: " + ((Number) r13.getFirst()).longValue() + ", url: " + ((String) r13.getSecond());
        L28:
            r6.append(r14);
            d.a(r6.toString());
            goto L29
        L27:
            r14 = null;
            goto L28
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((m81.a) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public LiveReportManager() {
        xs2.b.a().b(m81.a.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(new AnonymousClass1(this)));
    }

    public static void f(String r7) {
        Map<String, String> r0 = ReportTracer.a;
        ReportTracer.b(ReportTracer.EventName.generate_report_anchor_dialog);
        int r1 = (int) UtilityKotlinExtentionsKt.j(s1.y());
        int r2 = (int) UtilityKotlinExtentionsKt.j(s1.w());
        if (r2 >= r1) goto L5;
        r2 = r1;
        r1 = r2;
    L5:
        FragmentActivity r3 = null;
        if (((Boolean) ho.a.getValue()).booleanValue() == true) goto L15;
        o r8 = k.n(IBrowserService.class).buildWebDialog(r7).setWidth(r1);
        r8.b = (int) (r2 * 0.7f);
        r8.i = 80;
        r8.o = true;
        r8.m = true;
        r8.a(0);
        r8.p = false;
        r8.q = true;
        BaseWebDialogFragment r9 = r8.build();
        FragmentActivity r4 = com.bytedance.android.live.core.utils.a.d();
        if ((r4 instanceof FragmentActivity) == false) goto L11;
        r3 = r4;
    L11:
        FragmentActivity r5 = r3;
        if (r5 == null) goto L31;
        ReportTracer.b(ReportTracer.EventName.report_anchor_dialog_show);
        LiveDialogFragment.Companion.getClass();
        LiveDialogFragment.a.a(r5, r9);
        ReportTracer.g();
        return;
    L31:
        return;
    L15:
        Activity r6 = com.bytedance.android.live.core.utils.a.d();
        if (r6 == null) goto L29;
        Uri.Builder r10 = x6.a.a(r7).appendQueryParameter("width", String.valueOf(r1)).appendQueryParameter("height", String.valueOf((int) (r2 * 0.7f))).appendQueryParameter("gravity", "bottom").appendQueryParameter("landscape_custom_gravity", DataType.TRUE).appendQueryParameter("landscape_custom_height", DataType.TRUE).appendQueryParameter("show_dim", DataType.TRUE).appendQueryParameter("type", "popup");
        Map r12 = (Map) pc.a.getValue();
        if (r12 == null) goto L24;
        Iterator r13 = r12.entrySet().iterator();
    L21:
        if (r13.hasNext() == false) goto L24;
        Map.Entry r14 = (Map.Entry) r13.next();
        r10.appendQueryParameter((String) r14.getKey(), (String) r14.getValue());
    L24:
        if (k.n(IBrowserService.class).showHybridDialog(r6, r10.build(), null) == null) goto L30;
        Map<String, String> r15 = ReportTracer.a;
        ReportTracer.b(ReportTracer.EventName.report_anchor_dialog_show);
        ReportTracer.g();
        return;
    L30:
        return;
    }

    public final void c(g r32) {
        Intrinsics.checkNotNullParameter(r32, "reportParams");
        Map<String, String> r2 = ReportTracer.a;
        ReportTracer.b(ReportTracer.EventName.report_full_link);
        switch(com.bytedance.android.live.room.report.a.b[f.a(r32).ordinal()]) {
            case 1: goto L107;
            case 2: goto L106;
            case 3: goto L101;
            case 4: goto L33;
            case 5: goto L141;
            case 6: goto L32;
            case 7: goto L31;
            case 8: goto L27;
            case 9: goto L5;
            default: goto L141;
        };
    L5:
        String r3 = r32.b.getIdStr();
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, r32.c.getRoomId(), 1);
        if (r6 == null) goto L16;
        j r7 = r6.getVoiceTalkRoomSubScene();
        if (r7 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r8 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r7.getValue();
        if (r8 == null) goto L16;
        i r9 = r8.t();
        if (r9 == null) goto L16;
        if (r9.a != 10) goto L16;
        ReportTracer.b(ReportTracer.EventName.set_room_mute);
        ((IRoomService) k.n(IRoomService.class)).setOnNeedMuteAudioFullPage(true);
    L16:
        long r10 = r32.c.getRoomId();
        UrlBuilder r1 = new UrlBuilder("https://aweme.snssdk.com/falcon/fe_app_react/report_lite/index.html");
        r1.addParam("web_bg_color", "%23ffffffff");
        r1.addParam("hide_nav_bar", 1);
        r1.addParam("room_id", r10);
        r1.addParam("user_id", k.n(IUserService.class).user().b().getUserId());
        r1.addParam("__live_platform__", "webcast");
        r1.addParam("is_full_page", 1);
        r1.addParam("report_type", "report_user");
        r1.addParam("anchor_ab_type", 0);
        r1.addParam("reported_user_id", r3);
        Activity r4 = com.bytedance.android.live.core.utils.a.d();
        if (r4 == null) goto L25;
        IBrowserService r5 = k.f(IBrowserService.class);
        if (r5 == null) goto L25;
        u30.b r12 = r5.buildFullScreenWebPage(r4, r1.build());
        if (r12 == null) goto L25;
        u30.a r13 = r12.d(true);
        if (r13 == null) goto L25;
        r13.b();
    L25:
        ReportTracer.g();
        return;
    L31:
        d.a("不再支持西头");
        ReportTracer.f("don't support XT");
        return;
    L32:
        d.a("不再支持Ppx");
        ReportTracer.f("don't support ppx");
        return;
    L33:
        u r14 = r32.g;
        if (r14 == null) goto L142;
        User r15 = r32.b;
        IRoom r16 = r32.c;
        ReportTracer.b(ReportTracer.EventName.generate_report_comment_url);
        String r17 = r32.d;
        String r18 = r32.f;
        String r19 = (String) nl.a.getValue();
        UrlBuilder r110 = new UrlBuilder(r19);
        r110.addParam("comment", Uri.encode(r14.b()));
        if (TextUtils.isEmpty(r14.c()) == true) goto L39;
        r110.addParam("sec_reported_user_id", r14.c());
    L41:
        if (TextUtils.isEmpty(r14.e()) == true) goto L43;
        r110.addParam("sec_reported_webcast_user_id", r14.e());
    L43:
        r110.addParam("msg_id", r14.a());
        r110.addParam("chat_type", r14.getType());
        r110.addParam("room_id", r16.getId());
        r110.addParam("show_type", r18);
        if (TextUtils.equals(NewProfileInfoViewModel.PAGE_NAME, r17) == false) goto L46;
    L49:
        boolean r20 = true;
    L50:
        r110.addParam("report_type", e.a.getType(r17, r18, r20));
        r110.addParam("request_page", e.a.a(r17, r18));
        n0 r22 = com.bytedance.android.livesdk.log.u.l().c(x.class);
        if ((r22 instanceof n0) == false) goto L61;
        n0 r23 = r22;
        if (((com.bytedance.android.livesdk.log.filter.a) r23).b.containsKey("enter_from_merge") == false) goto L56;
        r110.addParam("enter_from_merge", (String) ((com.bytedance.android.livesdk.log.filter.a) r23).b.get("enter_from_merge"));
    L56:
        if (((com.bytedance.android.livesdk.log.filter.a) r23).b.containsKey("enter_method") == false) goto L59;
        r110.addParam("enter_method", (String) ((com.bytedance.android.livesdk.log.filter.a) r23).b.get("enter_method"));
    L59:
        if (((com.bytedance.android.livesdk.log.filter.a) r23).b.containsKey("action_type") == false) goto L61;
        r110.addParam("action_type", (String) ((com.bytedance.android.livesdk.log.filter.a) r23).b.get("action_type"));
    L61:
        s0 r24 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        if ((r24 instanceof s0) == false) goto L72;
        s0 r25 = r24;
        if (((com.bytedance.android.livesdk.log.filter.a) r25).b.containsKey("anchor_id") == false) goto L67;
        r110.addParam("anchor_id", (String) ((com.bytedance.android.livesdk.log.filter.a) r25).b.get("anchor_id"));
    L67:
        if (((com.bytedance.android.livesdk.log.filter.a) r25).b.containsKey("log_pb") == false) goto L69;
        r110.addParam("log_pb", (String) ((com.bytedance.android.livesdk.log.filter.a) r25).b.get("log_pb"));
    L69:
        String r26 = r16.getRequestId();
        if (r26 == null) goto L72;
        r110.addParam("request_id", r26);
    L72:
        boolean r27 = r15.isVcdContentAuthorized();
        String r28 = DataType.TRUE;
        if (r27 == false) goto L75;
        String r29 = DataType.TRUE;
    L76:
        r110.addParam("is_reported_user_authorized", r29);
        if (r16.getLayout() != 1) goto L79;
        String r30 = "media";
    L80:
        r110.addParam("room_layout", r30);
        int r33 = com.bytedance.android.live.room.report.a.a[r16.getStreamType().ordinal()];
        if (r33 == 1) goto L85;
        if (r33 == 2) goto L84;
        String r34 = "video_live";
    L86:
        r110.addParam("live_type", r34);
        r110.addParam("report_type", "report_message");
        if (r16.isHasCommerceGoods() == false) goto L89;
        String r35 = DataType.TRUE;
    L90:
        r110.addParam("is_sale", r35);
        r110.addParam("livesdk_profile_hide_confirm", DataType.FALSE);
        if (r32.b.isAnonymous() == true) goto L94;
        r28 = DataType.FALSE;
    L94:
        r110.addParam("is_target_user_anonymous", r28);
        ReportTracer.b(ReportTracer.EventName.open_report_comment_page);
        if (StringsKt.startsWith$default(r19, "sslocal", false, 2, null) == false) goto L99;
        IBaseLiveActionHandler r36 = k.f(IBaseLiveActionHandler.class);
        if (r36 == null) goto L100;
        r36.handle(com.bytedance.android.live.core.utils.a.d(), r110.build());
    L100:
        ReportTracer.g();
        return;
    L99:
        k.n(IHostAction.class).openLiveBrowser(r110.build(), new Bundle(), com.bytedance.android.live.core.utils.a.d());
        goto L100
    L89:
        r35 = DataType.FALSE;
        goto L90
    L84:
        r34 = "third_party";
        goto L86
    L85:
        r34 = "voice_live";
        goto L86
    L79:
        r30 = DataType.Normal;
        goto L80
    L75:
        r29 = DataType.FALSE;
        goto L76
    L46:
        if (TextUtils.equals("live_barrage", r17) == true) goto L49;
        r20 = false;
        goto L50
    L39:
        r110.addParam("reported_user_id", r14.c());
        goto L41
    L142:
        return;
    L101:
        IBaseUser r37 = r32.c.getOwner();
        if (r37 == null) goto L104;
        Intrinsics.checkNotNullParameter(r37, "$this$secUidExt");
        String r111 = r37.getCastSecUid();
    L105:
        r2 r38 = new r2(r111, r32.c.getId(), com.bytedance.android.live.base.model.user.o.a(k.n(IUserService.class).user().b()));
        r38.k = r32.j;
        a(r32, r38);
        return;
    L104:
        r111 = null;
        goto L105
    L106:
        d.a("不再支持西头");
        ReportTracer.f("don't support XT");
        return;
    L107:
        IBaseUser r39 = r32.c.getOwner();
        if (r39 == null) goto L110;
        Intrinsics.checkNotNullParameter(r39, "$this$secUidExt");
        String r112 = r39.getCastSecUid();
    L111:
        long r40 = r32.c.getId();
        String r42 = com.bytedance.android.live.base.model.user.o.a(k.n(IUserService.class).user().b());
        String r43 = "";
        if (Intrinsics.areEqual("pk", r32.e) == false) goto L114;
    L126:
        ReportTracer.b(ReportTracer.EventName.report_DHXT_pk);
        ReportTracer.d(ReportTracer.EventName.report_pk_liveroomid, String.valueOf(r32.b.getLiveRoomId()));
        if (r32.b.getLiveRoomId() != 0) goto L129;
        d.a("report pk anchor' room id is 0");
        ReportTracer.f("report pk anchor' room id is 0");
        return;
    L129:
        r112 = r32.b.getCastSecUid();
        r42 = r32.b.getCastSecUid();
        r40 = r32.b.getLiveRoomId();
        String r44 = r32.e;
    L130:
        long r113 = r40;
        String r114 = r42;
        String r115 = "";
        String r116 = r115;
    L131:
        a(r32, new r2(r112, r113, r114, r44, r115, r116, r32.f, r32.b.isVcdContentAuthorized()));
        return;
    L114:
        if (Intrinsics.areEqual("anchor_linkmic", r32.e) == true) goto L126;
        if (Intrinsics.areEqual("audience_audio", r32.e) == false) goto L119;
    L122:
        ReportTracer.b(ReportTracer.EventName.report_DHXT_link);
        String r45 = r32.b.getCastSecUid();
        if (TextUtils.isEmpty(r45) == false) goto L125;
        r43 = r32.b.getIdString();
    L125:
        r44 = r32.e;
        r113 = r40;
        r114 = r42;
        r115 = r45;
        r116 = r43;
        goto L131
    L119:
        if (Intrinsics.areEqual("audience_linkmic", r32.e) == true) goto L122;
        r44 = "";
        goto L130
    L110:
        r112 = null;
        goto L111
    L141:
        return;
    L27:
        if (r32.h == false) goto L29;
        String r46 = "live";
    L30:
        String r210 = r46;
        ReportTracer.b(ReportTracer.EventName.open_report_hotsoon_page);
        ((ILiveShareService) k.n(ILiveShareService.class)).share(new i81.a(null, com.bytedance.android.live.core.utils.a.d(), null, ShareParams.buildUponRoom(r32.c).setUserId(r32.b.getIdStr()).build(), null, null, null, null, null, null, r210, Boolean.FALSE, null, null, null, null, false), "LiveReportManager: HotsonOrVigo", LiveShareType.REPORT_DIALOG, null);
        ReportTracer.g();
        return;
    L29:
        r46 = "user";
        goto L30
    }

    public static UrlBuilder b(IRoom r7, r2 r8) {
        Map<String, String> r0 = ReportTracer.a;
        ReportTracer.b(ReportTracer.EventName.generate_report_anchor_url_builder);
        UrlBuilder r1 = new UrlBuilder((String) oc.a.getValue());
        r1.addParam("sec_target_anchor_id", r8.a);
        r1.addParam("room_id", r8.b);
        r1.addParam("user_id", r8.c);
        boolean r2 = false;
        r1.addParam("is_full_page", 0);
        r1.addParam("target_audience_id", r8.f);
        r1.addParam("sec_target_audience_id", r8.e);
        r1.addParam("show_type", r8.g);
        String r3 = r8.g;
        if (TextUtils.isEmpty(r3) == true) goto L5;
    L8:
        r1.addParam("report_type", r3);
        r1.addParam("request_page", r8.i);
        boolean r4 = r8.h;
        String r5 = DataType.TRUE;
        if (r4 == false) goto L11;
        String r6 = DataType.TRUE;
    L12:
        r1.addParam("is_reported_user_authorized", r6);
        r1.addParam("anchor_ab_type", ((Integer) af1.a.getValue()).intValue());
        com.bytedance.android.livesdk.log.filter.o r9 = com.bytedance.android.livesdk.log.u.l().c(x.class);
        if (r9 == null) goto L17;
        r1.addParam("enter_from_merge", (String) r9.getMap().get("enter_from_merge"));
        r1.addParam("enter_method", (String) r9.getMap().get("enter_method"));
        r1.addParam("action_type", (String) r9.getMap().get("action_type"));
        if (r9.getMap().get("video_id") == null) goto L17;
        r1.addParam("video_id", (String) r9.getMap().get("video_id"));
    L17:
        com.bytedance.android.livesdk.log.filter.o r10 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        if (r9 == null) goto L24;
        String r12 = r7.getRequestId();
        if (r12 == null) goto L22;
        r1.addParam("request_id", r12);
    L22:
        r1.addParam("log_pb", (String) r10.getMap().get("log_pb"));
        r1.addParam("anchor_id", (String) r10.getMap().get("anchor_id"));
    L24:
        if (r7.isMediaRoom() == false) goto L26;
        String r13 = "media";
    L27:
        r1.addParam("room_layout", r13);
        if (r7.isHasCommerceGoods() == true) goto L31;
        r5 = DataType.FALSE;
    L31:
        r1.addParam("is_sale", r5);
        r1.addParam("livesdk_profile_hide_confirm", DataType.FALSE);
        IInteractService r14 = k.f(IInteractService.class);
        if (r14 != null) goto L34;
    L36:
        IInteractService r15 = k.f(IInteractService.class);
        if (r15 == null) goto L43;
        m r16 = r15.getVideoTalkService();
        if (r16 == null) goto L43;
        if (r16.z() != true) goto L43;
        r1.addParam("play_type", "video_friend");
    L43:
        l r17 = k.n(ILinkServiceExternal.class).getMultiDataHolderExternal().v();
        r1.addParam("pk_id", r17.e);
        r1.addParam("connection_type", r17.d);
        ILiveService r18 = TTLiveService.getLiveService();
        String r19 = null;
        if (r18 == null) goto L48;
        ILiveOntologyInfoManager r20 = r18.getLiveOntologyRecord();
        if (r20 == null) goto L48;
        String r22 = r20.getEnterFromMerge();
    L49:
        if (r22 != null) goto L51;
    L54:
        boolean r23 = true;
    L55:
        if (r23 == true) goto L57;
        r1.addParam("drawer_page", r22);
    L57:
        com.bytedance.android.livesdk.log.filter.o r24 = com.bytedance.android.livesdk.log.u.l().c(n.class);
        if (r24 == null) goto L62;
        Map r25 = r24.getMap();
        if (r25 == null) goto L62;
        r19 = (String) r25.get("is_other_channel");
    L62:
        if (r19 != null) goto L64;
    L65:
        r2 = true;
    L66:
        if (r2 == true) goto L68;
        r1.addParam("is_other_channel", r19);
    L68:
        Map r26 = r8.k;
        if (r26 == null) goto L74;
        Iterator r27 = r26.entrySet().iterator();
    L72:
        if (r27.hasNext() == false) goto L74;
        Map.Entry r28 = (Map.Entry) r27.next();
        r1.addParam((String) r28.getKey(), (String) r28.getValue());
    L74:
        return r1;
    L64:
        if (r19.length() != 0) goto L66;
    L51:
        if (r22.length() == 0) goto L54;
        r23 = false;
    L48:
        r22 = null;
        goto L49
    L34:
        if (r14.getCurrentScene() != 12) goto L36;
        r1.addParam("function_type", "party");
        goto L36
    L26:
        r13 = DataType.Normal;
        goto L27
    L11:
        r6 = DataType.FALSE;
        goto L12
    L5:
        if (TextUtils.equals(r8.a, r8.c) == false) goto L7;
        r3 = "report_anchor";
        goto L8
    L7:
        r3 = "report_user";
        goto L8
    }

    public final void a(g r7, r2 r8) {
        if (TextUtils.equals(NewProfileInfoViewModel.PAGE_NAME, r7.d) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        r8.g = e.a.getType(r7.d, r7.f, r0);
        r8.i = e.a.a(r7.d, r7.f);
        r8.j = r7.c.getId();
        Map<String, String> r1 = ReportTracer.a;
        ReportTracer.d(ReportTracer.EventName.report_anchor_report_type, r8.g);
        ReportTracer.d(ReportTracer.EventName.report_anchor_request_page, r8.i);
        xs2.b.a().post(new r2("", 0, ""));
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, r7.c.getRoomId(), 1);
        if (r2 == null) goto L16;
        com.bytedance.live.datacontext.i r3 = r2.isAnchor();
        if (r3 == null) goto L16;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L16;
        d(r7.c, r8, r7.b);
        return;
    L16:
        e(r7.c, r8, r7.b);
        return;
    L5:
        if (TextUtils.equals("live_barrage", r7.d) == true) goto L8;
        r0 = false;
        goto L9
    }

    public static void d(IRoom r3, r2 r4, User r5) {
        Map<String, String> r0 = ReportTracer.a;
        ReportTracer.b(ReportTracer.EventName.report_anchor_for_anchor);
        if (Intrinsics.areEqual("anchor_profile", r4.d) == false) goto L5;
    L29:
        d.a("reportScene is anchor_profile, or reportScene can't report anchor");
        ReportTracer.f("reportScene is anchor_profile, or reportScene can't report anchor");
        return;
    L5:
        if (r2.a(r4.d) == false) goto L29;
        if (TextUtils.isEmpty((CharSequence) oc.a.getValue()) == false) goto L11;
        d.a("live_anchor_report_url is null");
        ReportTracer.f("live_anchor_report_url is null");
        return;
    L11:
        UrlBuilder r1 = b(r3, r4);
        r1.addParam("web_bg_color", "%2300000000");
        r1.addParam("report_scene", r4.d);
        ReportTracer.d(ReportTracer.EventName.report_anchor_report_scene, r4.d);
        LiveMode r6 = r3.getStreamType();
        int r7 = com.bytedance.android.live.room.report.a.c[r6.ordinal()];
        if (r7 != 1) goto L14;
        String r8 = "voice_live";
    L21:
        r1.addParam("live_type", r8);
        if (r5 != null) goto L24;
    L26:
        String r9 = DataType.FALSE;
    L27:
        r1.addParam("is_target_user_anonymous", r9);
        f(r1.build());
        return;
    L24:
        if (r5.isAnonymous() != true) goto L26;
        r9 = DataType.TRUE;
        goto L27
    L14:
        if (r7 != 2) goto L16;
        r8 = "third_party";
        goto L21
    L16:
        if (r7 == 3) goto L18;
        r8 = "video_live";
        goto L21
    L18:
        r8 = "game_live";
        goto L21
    }

    public final void e(IRoom r8, r2 r9, User r10) {
        Map<String, String> r0 = ReportTracer.a;
        ReportTracer.b(ReportTracer.EventName.report_anchor_for_audience);
        if (TextUtils.isEmpty((CharSequence) oc.a.getValue()) == false) goto L6;
        d.a("live_anchor_report_url is null");
        ReportTracer.f("live_anchor_report_url is null");
        return;
    L6:
        RoomContext.a r1 = RoomContext.Companion;
        String r3 = null;
        RoomContext r2 = RoomContext.a.c(r1, null, r8.getId(), 1);
        if (r2 == null) goto L11;
        com.bytedance.live.datacontext.m r4 = r2.getAudienceRoomState();
        if (r4 == null) goto L11;
        LiveRoomState r5 = (LiveRoomState) r4.getValue();
    L13:
        if (r5 == LiveRoomState.LIVE_STARTED) goto L17;
        d.a("room state isn't LIVE_STARTED");
        ReportTracer.f("room state isn't LIVE_STARTED");
        return;
    L17:
        if (((Boolean) j3.a.getValue()).booleanValue() == false) goto L23;
        RoomContext r6 = RoomContext.a.c(r1, null, r8.getId(), 1);
        if (r6 == null) goto L23;
        com.bytedance.live.datacontext.m r7 = r6.isReported();
        if (r7 == null) goto L23;
        r7.setValue(Boolean.TRUE);
    L23:
        UrlBuilder r12 = b(r8, r9);
        r12.addParam("current_room_id", r9.j);
        boolean r13 = false;
        if (TextUtils.isEmpty(r9.d) == false) goto L36;
        e.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "room");
        if (r8.isHasCommerceGoods() == false) goto L29;
        String r14 = "ecommerce";
    L35:
        r9.d = r14;
        goto L36
    L29:
        if (k.n(ILinkServiceExternal.class).getPkServiceExternal().getPkState() != 1) goto L31;
        boolean r15 = true;
    L32:
        if (r15 == false) goto L34;
        r14 = "pk";
        goto L35
    L34:
        r14 = "";
        goto L35
    L31:
        r15 = false;
    L36:
        r12.addParam("report_scene", r9.d);
        ReportTracer.d(ReportTracer.EventName.report_anchor_report_scene, r9.d);
        int r16 = com.bytedance.android.live.room.report.a.d[r8.getStreamType().ordinal()];
        if (r16 != 1) goto L39;
        String r17 = "voice_live";
    L43:
        r12.addParam("live_type", r17);
        if (r10 != null) goto L46;
    L48:
        String r18 = DataType.FALSE;
    L49:
        r12.addParam("is_target_user_anonymous", r18);
        n0 r19 = com.bytedance.android.livesdk.log.u.l().c(x.class);
        if ((r19 instanceof n0) == false) goto L57;
        n0 r110 = r19;
        String r20 = r110.h("is_auto_enter");
        if (r20 == null) goto L54;
        r12.addParam("is_auto_enter", r20);
    L54:
        String r111 = r110.h("guide_area_type");
        if (r111 == null) goto L57;
        r12.addParam("guide_area_type", r111);
    L57:
        String r112 = r12.build();
        if (r2 == null) goto L62;
        com.bytedance.live.datacontext.m r22 = r2.getReportScreenOrientation();
        if (r22 == null) goto L62;
        Integer r23 = (Integer) r22.getValue();
    L63:
        int r24 = r23.intValue();
        if (r8.isMergeVSRoom() == true) goto L66;
    L70:
        if (r13 == false) goto L72;
    L84:
        f(r112);
        return;
    L72:
        if (e5.f(r24) == false) goto L84;
        long r25 = r9.j;
        if (this.a == null) goto L83;
        int r26 = d.a;
        StringBuilder r27 = new StringBuilder("save roomId and reportUrl when switch to portrait: old roomID: ");
        Pair<Long, String> r28 = this.a;
        if (r28 == null) goto L78;
        Long r29 = (Long) r28.getFirst();
    L79:
        r27.append(r29);
        r27.append(", old url: ");
        Pair<Long, String> r30 = this.a;
        if (r30 == null) goto L82;
        r3 = (String) r30.getSecond();
    L82:
        r27.append(r3);
        d.a(r27.toString());
        goto L83
    L78:
        r29 = null;
    L83:
        this.a = TuplesKt.to(Long.valueOf(r25), r112);
        ReportTracer.d(ReportTracer.EventName.report_anchor_url, r112);
        b0 r32 = b0.o();
        String r33 = "ReportAnchorEvent cause to hide interaction; id" + r8.getId();
        r32.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_room_exit", r33);
        int r34 = d.a;
        Intrinsics.checkNotNullParameter("switch to portrait", Constants.OperatorKey.MSG);
        ALogger.i("ReportServiceTrack", "switch to portrait");
        ReportTracer.b(ReportTracer.EventName.switch_to_portrait);
        xs2.b.a().post(new HorizontalPlayEvent(1, "report"));
        return;
    L66:
        if (FoldScreenUtils.f() == false) goto L70;
        if (((VSFoldFixConfig) LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue()).getEnable() == false) goto L70;
        r13 = true;
    L62:
        r23 = null;
        goto L63
    L46:
        if (r10.isAnonymous() != true) goto L48;
        r18 = DataType.TRUE;
        goto L49
    L39:
        if (r16 == 2) goto L41;
        r17 = "video_live";
        goto L43
    L41:
        r17 = "third_party";
    L11:
        r5 = null;
        goto L13
    }
}
