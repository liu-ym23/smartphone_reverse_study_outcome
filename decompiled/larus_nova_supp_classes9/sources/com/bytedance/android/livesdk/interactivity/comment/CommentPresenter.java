package com.bytedance.android.livesdk.interactivity.comment;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.live.ai.api.IAiService;
import com.bytedance.android.live.base.model.message.f4;
import com.bytedance.android.live.base.model.message.j6;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.privilege.model.danmu.PrivilegeBarrageResponse;
import com.bytedance.android.live.profit.privilege.model.danmu.SendPrivilegeBarrageArgs;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.event.ISendCommentEvent;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.comment.CommentApi;
import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomSyncDataModel;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputValueNode;
import com.bytedance.android.livesdk.interactivity.comment.utils.CommentUtils;
import com.bytedance.android.livesdk.interactivity.service.model.ICommunityRoom;
import com.bytedance.android.livesdk.r4;
import com.bytedance.android.livesdk.u4;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;
import com.bytedance.android.livesdkapi.depend.model.live.LowPcuGuideData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class CommentPresenter extends com.bytedance.android.livesdk.chatroom.presenter.n<IView> implements vlc.l {
    public boolean e;
    public boolean f;
    public int g;
    public IRoom h;
    public boolean i;
    public final fc2.c j;
    public final boolean k;
    public long l;
    public CompositeDisposable m;

    public interface IView extends IWidget {
        void A20(com.bytedance.android.livesdk.event.d0 r1, com.bytedance.android.live.base.model.message.k0 r2);

        void Ae(com.bytedance.android.live.base.model.message.v0 r1);

        void EH(String r1, int r2);

        void Ej(long r1, com.bytedance.android.livesdk.event.y r3, com.bytedance.android.livesdk.interactivity.api.comment.data.c r4);

        void M3();

        void Oy(boolean r1);

        void R00(com.bytedance.android.live.base.model.message.r r1);

        void R10(com.bytedance.android.livesdk.event.c0 r1, com.bytedance.android.live.base.model.message.v0 r2);

        void Vh(Exception r1, com.bytedance.android.livesdk.event.y r2);

        void Y30(CommentFlowContext r1, tlc.d r2);

        void cI(CommentFlowContext r1, Exception r2);

        void cT(com.bytedance.android.livesdk.event.x r1, kc2.a r2);

        void f30(Exception r1, kc2.a r2);

        /* synthetic */ Context getContext();

        void h8(Exception r1);

        void rI(Exception r1);

        void vN(long r1, com.bytedance.android.livesdk.event.y r3, PrivilegeBarrageResponse r4);
    }

    public class a implements Runnable {
        public final /* synthetic */ CommentPresenter a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.m.add(xs2.b.a().b(ISendCommentEvent.class).subscribe(new r(this)));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(CommentPresenter r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ CommentPresenter a;

        public final void a() {
            IntercomSyncDataModel r0 = com.bytedance.android.livesdk.interactivity.api.q.h();
            IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
            if (r1 == null) goto L5;
            Boolean r2 = r1.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this.a).c, 0).isAnchor();
        L6:
            if (r2 == null) goto L8;
            boolean r3 = r2.booleanValue();
        L9:
            if (r0 == null) goto L13;
            if (r3 == true) goto L14;
            this.a.m.add(r0.getIntercomStatus().d.subscribe(new s()));
            return;
        L14:
            return;
        L13:
            return;
        L8:
            r3 = false;
            goto L9
        L5:
            r2 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(CommentPresenter r1) {
            this.a = r1;
        }
    }

    public CommentPresenter() {
        this.e = true;
        this.f = true;
        this.g = 0;
        this.i = true;
        this.j = (fc2.c) ec2.s0.a.getValue();
        this.k = ((Boolean) r4.a.getValue()).booleanValue();
        this.l = 0;
    }

    public final void detachView() {
        super.detachView();
        CompositeDisposable r0 = this.m;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.h = null;
        this.m = null;
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IView) r1);
    }

    public final void g0(IView r4) {
        super.c0(r4);
        this.h = (IRoom) ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c.get("data_room");
        this.e = true;
        this.f = true;
        vlc.d r5 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d;
        if (r5 == null) goto L7;
        r5.addMessageListener("WebcastRoomVerifyMessage", this);
        if (((Boolean) u4.a.getValue()).booleanValue() == false) goto L7;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.LOW_PCU_GUIDE.getWsMethod(), this);
    L7:
        CompositeDisposable r6 = this.m;
        if (r6 == null) goto L10;
        r6.dispose();
    L10:
        CompositeDisposable r7 = new CompositeDisposable();
        this.m = r7;
        int r0 = com.bytedance.android.live.room.y.a;
        com.bytedance.android.live.room.y.a(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, r7, "ISendCommentEvent", new a(this));
        com.bytedance.android.live.room.y.a(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, this.m, "CommentPresenter#attach", new b(this));
    }

    public final void k0(final com.bytedance.android.livesdk.event.y r23) {
        if (r23.b <= 0) goto L5;
        com.bytedance.android.livesdk.interactivity.api.monitor.a.c("privilege");
    L6:
        boolean r1 = false;
        if (this.m != null) goto L9;
    L95:
        xs2.b.a().post(new com.bytedance.android.livesdk.event.z(r23, false, null));
        return;
    L9:
        if (TextUtils.isEmpty(r23.a) == true) goto L95;
        if (this.e == false) goto L95;
        if ((r23.d.get("live.intent.extra.ENTER_LIVE_SOURCE") instanceof String) == false) goto L16;
        String r0 = (String) r23.d.get("live.intent.extra.ENTER_LIVE_SOURCE");
    L17:
        Boolean r3 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter("is_from_click_event", "key");
        if (((Boolean) ISendCommentEvent.a.a(r23, "is_from_click_event", r3)).booleanValue() == true) goto L20;
    L23:
        this.e = false;
        final long r5 = System.currentTimeMillis();
        int r4 = r23.b;
        String r9 = BuildConfig.FLAVOR;
        if (r4 <= 0) goto L70;
        final long r10 = SystemClock.uptimeMillis();
        if (yt0.c.i() != null) goto L28;
        return;
    L28:
        com.bytedance.android.livesdk.event.m r2 = r23.e;
        com.bytedance.android.livesdk.event.q r6 = r23.f;
        Object r13 = r23.d.get("money");
        if ((r13 instanceof Long) == false) goto L31;
        long r14 = ((Long) r13).longValue();
    L32:
        long r18 = r14;
        DataCenter r15 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        JSONObject r7 = new JSONObject();
        if (r15 != null) goto L97;
    L58:
        String r20 = r7.toString();
        String r16 = r23.a;
        int r8 = r23.b;
        if (r2 == null) goto L61;
        List r11 = r2.a;
    L62:
        if (r6 == null) goto L64;
        List r17 = r6.a;
    L65:
        if (r11 != null) goto L68;
        if (r17 != null) goto L68;
        String r19 = null;
    L69:
        SendPrivilegeBarrageArgs r21 = new SendPrivilegeBarrageArgs(r16, r8, r19, r18, r20);
        Disposable r24 = yt0.c.i().V3(r21).subscribe(new o(this, r10, r23, r5), new p(this, r23));
        this.m.add(r24);
        return;
    L68:
        r19 = new com.bytedance.android.livesdk.event.a0(r11, r17).a();
        goto L69
    L64:
        r17 = null;
        goto L65
    L61:
        r11 = null;
        goto L62
    L97:
        JSONObject r110 = new JSONObject((String) r15.get("log_enter_params", BuildConfig.FLAVOR));     // Catch: Exception -> L57
        String r25 = r110.optString("enter_from_merge", BuildConfig.FLAVOR);     // Catch: Exception -> L57
        if (r25.length() <= 0) goto L37;
        boolean r26 = true;
    L38:
        if (r26 == false) goto L40;
        r7.put("enter_from_merge", r25);     // Catch: Exception -> L57
    L40:
        String r27 = r110.optString("enter_method", BuildConfig.FLAVOR);     // Catch: Exception -> L57
        if (r27.length() <= 0) goto L43;
        boolean r111 = true;
    L44:
        if (r111 == false) goto L46;
        r7.put("enter_method", r27);     // Catch: Exception -> L57
    L46:
        String r28 = r110.optString("action_type", BuildConfig.FLAVOR);     // Catch: Exception -> L57
        if (r28.length() <= 0) goto L49;
        r1 = true;
    L49:
        if (r1 == false) goto L51;
        r7.put("action_type", r28);     // Catch: Exception -> L57
    L51:
        ILiveService r29 = TTLiveService.getLiveService();     // Catch: Exception -> L57
        if (r29 == null) goto L58;
        ILiveOntologyInfoManager r30 = r29.getLiveOntologyRecord();     // Catch: Exception -> L57
        if (r30 == null) goto L58;
        r7.put("drawer_page", r30.getEnterFromMerge());     // Catch: Exception -> L57
        goto L58
    L43:
        r111 = false;
        goto L44
    L37:
        r26 = false;
    L57:
        Unit r31 = Unit.INSTANCE;
        goto L58
    L31:
        r14 = 0;
        goto L32
    L70:
        IRoom r33 = this.h;
        if (r33 != null) goto L73;
        return;
    L73:
        String r34 = r23.a;
        if (r33.castToOrNull(ICommunityRoom.class) == null) goto L77;
        r9 = ((ICommunityRoom) this.h.castToOrNull(ICommunityRoom.class)).getLabels();
    L77:
        CompositeDisposable r35 = this.m;
        long r112 = this.h.getId();
        String r36 = this.h.getRequestId();
        com.bytedance.android.livesdk.event.m r113 = r23.e;
        com.bytedance.android.livesdk.event.q r114 = r23.f;
        Intrinsics.checkNotNullParameter(r34, "content");
        CommentApi r37 = (CommentApi) com.bytedance.android.live.network.c.b().e(CommentApi.class);
        Pair[] r115 = new Pair[6];
        r115[0] = TuplesKt.to("content", r34);
        r115[1] = TuplesKt.to("room_id", String.valueOf(r112));
        r115[2] = TuplesKt.to("request_id", r36);
        r115[3] = TuplesKt.to("common_label_list", r9);
        r115[4] = TuplesKt.to("enter_source", r0);
        if (r113 == null) goto L80;
        List r38 = r113.a;
    L81:
        if (r114 == null) goto L83;
        List r39 = r114.a;
    L84:
        r115[5] = TuplesKt.to("rtf_content", new com.bytedance.android.livesdk.event.a0(r38, r39).a());
        Map r40 = MapsKt.mapOf(r115);
        LinkedHashMap r41 = new LinkedHashMap();
        Iterator r43 = r40.entrySet().iterator();
    L86:
        if (r43.hasNext() == false) goto L93;
        Map.Entry r44 = (Map.Entry) r43.next();
        if (r44.getValue() == null) goto L90;
        boolean r45 = true;
    L91:
        if (r45 == false) goto L86;
        r41.put(r44.getKey(), r44.getValue());
        goto L86
    L90:
        r45 = false;
        goto L91
    L93:
        r35.add(r37.sendBarrage(new HashMap(r41)).compose(RxUtil.rxSchedulerHelper()).subscribe(new q(this, r23, r5), new com.bytedance.android.livesdk.interactivity.comment.b(this, r23)));
        return;
    L83:
        r39 = null;
        goto L84
    L80:
        r38 = null;
        goto L81
    L20:
        if (r23.b <= 0) goto L22;
        z32.c.b(InputValueNode.SendPrivilegeDanmaku);
        goto L23
    L22:
        z32.c.b(InputValueNode.SendAdminDanmaku);
        goto L23
    L16:
        r0 = null;
        goto L17
    L5:
        com.bytedance.android.livesdk.interactivity.api.monitor.a.c("admin");
        goto L6
    }

    public final void l0(final com.bytedance.android.livesdk.event.d0 r26) {
        ALogger.i("CommentWidget", "receive an SendTextEvent");
        boolean r1 = true;
        if (u22.f.a(r26) == 10) goto L5;
    L25:
        boolean r0 = false;
    L27:
        if (r0 == false) goto L31;
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("comment", "lottery roomid check failed", null);
        return;
    L31:
        if (this.j.b() == true) goto L33;
    L36:
        this.l = System.currentTimeMillis();
        long r6 = System.currentTimeMillis();
        com.bytedance.android.livesdk.interactivity.api.monitor.a.c("comment");
        if (this.m != null) goto L39;
    L152:
        xs2.b.a().post(new com.bytedance.android.livesdk.event.z(r26, false, null));
        String r2 = "content empty: " + TextUtils.isEmpty(r26.a) + ", could send comment: " + this.f;
        com.bytedance.android.livesdk.interactivity.api.monitor.a.d("comment", r2, null);
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("comment", r2, null);
        return;
    L39:
        if (TextUtils.isEmpty(r26.a) == true) goto L152;
        if (this.f == false) goto L152;
        if ((r26.c.get("live.intent.extra.ENTER_LIVE_SOURCE") instanceof String) == false) goto L46;
        String r18 = (String) r26.c.get("live.intent.extra.ENTER_LIVE_SOURCE");
    L47:
        Boolean r3 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter("is_from_click_event", "key");
        if (((Boolean) ISendCommentEvent.a.a(r26, "is_from_click_event", r3)).booleanValue() == false) goto L51;
        z32.c.b(InputValueNode.SendChat);
    L51:
        if ((r26.c.get("intent_recognition") instanceof String) == false) goto L53;
        String r19 = (String) r26.c.get("intent_recognition");
    L54:
        IRoomContextService r15 = jc1.k.f(IRoomContextService.class);
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).dataChannelMonitorLink(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c);
        this.f = false;
        int r14 = u22.f.a(r26);
        if (r14 == 9) goto L60;
        if (r14 == 10) goto L60;
        r1 = false;
    L60:
        if (this.h.castToOrNull(ICommunityRoom.class) != null) goto L62;
        String r17 = BuildConfig.FLAVOR;
    L63:
        g92.a r4 = new g92.a(this.h.getId(), r26.a, r14, this.h.getRequestId(), r17, r18, r19);
        if (r15 != null) goto L66;
    L78:
        long r110 = r6;
    L79:
        if (r15 == null) goto L86;
        if (r15.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0).getCameraId() == null) goto L86;
        long r5 = ((Long) r15.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0).getCameraId().getValue()).longValue();
        if (r5 <= 0) goto L86;
        r4.d = String.valueOf(r5);
    L86:
        if ((r26.c.get("truth_question_id") instanceof Long) == false) goto L88;
        r4.a("truth_question_id", String.valueOf(r26.c.get("truth_question_id")));
    L88:
        Intrinsics.checkNotNullParameter("is_from_click_event", "key");
        if (((Boolean) ISendCommentEvent.a.a(r26, "is_from_click_event", r3)).booleanValue() == true) goto L91;
    L93:
        final long r11 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter("is_self_click_send", "key");
        final boolean r7 = ((Boolean) ISendCommentEvent.a.a(r26, "is_self_click_send", r3)).booleanValue();
        if (r7 == false) goto L102;
        DataCenter r8 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r8 != null) goto L98;
    L101:
        z32.c.b(InputValueNode.PortraitChatApiTriggerCount);
        goto L102
    L98:
        if (((Boolean) r8.get("data_is_portrait", Boolean.TRUE)).booleanValue() == true) goto L101;
        z32.c.b(InputValueNode.LandscapeChatApiTriggerCount);
    L102:
        String r9 = am2.n.f().e;
        if (TextUtils.isEmpty(r9) == true) goto L105;
        r4.a("enter_from_merge", r9);
    L105:
        String r10 = am2.n.f().d;
        if (TextUtils.isEmpty(r10) == true) goto L108;
        r4.a("ad_channel", r10);
    L108:
        String r13 = am2.n.f().c();
        if (TextUtils.isEmpty(r13) == true) goto L111;
        r4.a("creative_id", r13);
    L111:
        int r16 = x22.f.a;
        Map r20 = r26.c;
        if (r20 == null) goto L117;
        Object r21 = r20.get("paste_edit_method");
        if (r21 == null) goto L117;
        String r23 = r21.toString();
        if (r23 == null) goto L117;
    L118:
        r4.a("paste_edit_method", r23);
        if (r1 == false) goto L121;
    L150:
        final long r24 = r110;
        this.m.add(r4.b(r26.d, r26.e, r1).subscribe(new k(this, r26, r7, r24, r11), new l(this, r26)));
        return;
    L121:
        if (this.k == false) goto L150;
        IRoom r25 = this.h;
        if (r25 == null) goto L130;
        if (r25.isMediaRoom() == true) goto L150;
        if (this.h.isMergeVSRoom() == true) goto L150;
    L130:
        if (jc1.k.f(IAiService.class) == null) goto L150;
        Object r27 = jc1.k.f(IAiService.class).getPMFeature("revenue_feature");
        if ((r27 instanceof JSONObject) == false) goto L147;
        JSONObject r28 = (JSONObject) r27;
        int r29 = CommentUtils.a;
        if (r28 != null) goto L154;
        String r30 = null;
    L143:
        String r31 = r30;
    L144:
        if (r31 == null) goto L150;
        r4.a("edge_intelligent_params_map_str_encode", r31);
        com.bytedance.android.livesdk.interactivity.api.monitor.b.f(r31, r30);
        goto L150
    L154:
        String r33 = r28.toString();     // Catch: Exception -> L141
        Charset r34 = StandardCharsets.UTF_8;     // Catch: Exception -> L141
        if (r33 == null) goto L140;
        r31 = Base64.encodeToString(r33.getBytes(r34), 0);     // Catch: Exception -> L141
        r30 = null;
        goto L144
    L140:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L141
    L141:
        e = move-exception;
        r30 = null;
        com.bytedance.android.livesdk.interactivity.api.monitor.b.f(null, e.toString());
        e.printStackTrace();
        goto L143
    L147:
        if (r27 != null) goto L149;
        com.bytedance.android.livesdk.interactivity.api.monitor.b.f(null, "getPMFeature is null");
        goto L150
    L149:
        com.bytedance.android.livesdk.interactivity.api.monitor.b.f(null, r27.toString());
    L117:
        r23 = CardLockInfo.sUNKNOWN;
        goto L118
    L91:
        if ((r26.c.get("default_text_type") instanceof String) == false) goto L93;
        r4.a("default_text_type", String.valueOf(r26.c.get("default_text_type")));
        goto L93
    L66:
        if (Boolean.TRUE.equals(r15.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0).isVSRoom()) == false) goto L78;
        long r111 = com.bytedance.android.livesdk.interactivity.common.utils.f.b(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c);
        if (r15.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0).isVSFirstShow() == false) goto L70;
        int r112 = EpisodeMod.EpisodeStageType.PREMIERE;
    L71:
        IRoom r113 = this.h;
        int r114 = CommentUtils.a;
        if (r113 == null) goto L76;
        IEpisodeExtraInfo r115 = r113.getEpisodeExtra();
        if (r115 == null) goto L76;
        long r35 = r115.getId();
        r110 = r6;
    L77:
        g92.d r116 = new g92.d(r35, r112);
        Intrinsics.checkNotNullParameter(r116, "episodeInfo");
        r4.a = null;
        r4.b = Long.valueOf(r111);
        r4.c = BuildConfig.FLAVOR;
        r4.e = r116;
    L76:
        r110 = r6;
        r35 = 0;
        goto L77
    L70:
        r112 = EpisodeMod.EpisodeStageType.LIVE;
        goto L71
    L62:
        r17 = ((ICommunityRoom) this.h.castToOrNull(ICommunityRoom.class)).getLabels();
        goto L63
    L53:
        r19 = null;
        goto L54
    L46:
        r18 = null;
        goto L47
    L33:
        if ((System.currentTimeMillis() - this.l) > this.j.a()) goto L36;
        int r36 = u22.f.a(r26);
        InteractivityMonitor.Event r37 = com.bytedance.android.livesdk.interactivity.api.monitor.a.a;
        JSONObject r38 = new JSONObject();
        r38.put("send_type", r36);
        InteractivityMonitor.Event r39 = com.bytedance.android.livesdk.interactivity.api.monitor.a.b;
        LiveTracingMonitor.f(r39.getEventName(), r39.getEventModule(), r38, new JSONObject(), new JSONObject());
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("comment", "frequent intercept", null);
        return;
    L5:
        if ((r26.c.get("comment_jsb_version") instanceof String) == false) goto L7;
        String r40 = (String) r26.c.get("comment_jsb_version");
    L9:
        if ((r26.c.get("comment_jsb_room_id") instanceof String) == false) goto L11;
        String r41 = (String) r26.c.get("comment_jsb_room_id");
    L12:
        IRoom r43 = this.h;
        if (r43 == null) goto L15;
        String r44 = String.valueOf(r43.getRoomId());
    L16:
        if (r40 == null) goto L25;
        if (r41 == null) goto L25;
        if (r44 == null) goto L25;
        if (r40.equals("1") == false) goto L25;
        if (r41.equals(r44) == true) goto L25;
        ALogger.e("jsb_check", "check_not_pass,jsbRoomId =" + r41 + ",currentRoomId =" + r44);
        r0 = true;
        goto L27
    L15:
        r44 = null;
        goto L16
    L11:
        r41 = null;
        goto L12
    L7:
        r40 = null;
        goto L9
    }

    public final void m0(int r2) {
        if (r2 != 0) goto L4;
        y3.m(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c).c(ToolbarButton.DIVIDER.extended());
        return;
    L4:
        y3.m(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c).i(ToolbarButton.DIVIDER.extended());
    }

    public final void n0(int r6) {
        if (((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).enableToolbarFastGiftOptimize() == false) goto L5;
        return;
    L5:
        DataCenter r0 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        boolean r1 = true;
        if (r0 == null) goto L11;
        if (r6 != 0) goto L9;
        boolean r3 = true;
    L10:
        r0.put("data_room_gift_status", Boolean.valueOf(r3));
        goto L11
    L9:
        r3 = false;
    L11:
        IRoom r2 = this.h;
        if (r2 == null) goto L31;
        if (r2.getRoomAuthStatus() == null) goto L31;
        if (this.h.getRoomAuthStatus().getEnableGift() == true) goto L31;
        if (this.h.getAnchorAbValue("gift_hide_tip") == null) goto L31;
        if (this.h.getAnchorAbValue("gift_hide_tip").equals("2") == false) goto L31;
        final String r4 = s1.B(2131915839);
        if (this.h.getRoomIMInfo() == null) goto L28;
        if (TextUtils.isEmpty(this.h.getRoomIMInfo().getHideGiftMessage()) == true) goto L28;
        r4 = this.h.getRoomIMInfo().getHideGiftMessage();
    L28:
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.m.a(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c) == null) goto L31;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.m.a(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c).c(new com.bytedance.android.livesdk.interactivity.comment.a(r4));
    L31:
        if (r6 == 0) goto L33;
        boolean r5 = true;
    L34:
        pp1.d r7 = new pp1.d(r5);
        y3.b(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c).b(ToolbarButton.GIFT, r7);
        if (this.h.isMediaRoom() == true) goto L37;
        y3.b(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c).b(ToolbarButton.FAST_GIFT, r7);
        return;
    L37:
        if (r6 == 0) goto L41;
        r1 = false;
    L41:
        if (Boolean.valueOf(r1).booleanValue() == false) goto L43;
        y3.m(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c).c(ToolbarButton.FAST_GIFT.extended());
        return;
    L43:
        y3.b(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c).i(ToolbarButton.FAST_GIFT.extended());
        return;
    L33:
        r5 = false;
        goto L34
    }

    public final void o0(final com.bytedance.android.livesdk.event.b0 r23) {
        com.bytedance.android.livesdk.interactivity.api.monitor.a.c("ogc_fixed");
        if (this.m != null) goto L5;
    L58:
        xs2.b.a().post(new com.bytedance.android.livesdk.event.z(r23, false, null));
        return;
    L5:
        if (this.f == false) goto L58;
        final long r5 = System.currentTimeMillis();
        final long r3 = SystemClock.uptimeMillis();
        CompositeDisposable r9 = this.m;
        DataCenter r0 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        long r10 = r23.a;
        CommentApi r13 = (CommentApi) com.bytedance.android.live.network.c.b().e(CommentApi.class);
        Pair[] r14 = new Pair[4];
        com.bytedance.android.livesdk.chatroom.o r15 = IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), r0, 0, 2);
        if (r15 == null) goto L14;
        com.bytedance.live.datacontext.m r16 = r15.getRoom();
        if (r16 == null) goto L14;
        IRoom r17 = (IRoom) r16.getValue();
        if (r17 == null) goto L14;
        Long r18 = Long.valueOf(r17.getRoomId());
    L15:
        r14[0] = TuplesKt.to("room_id", String.valueOf(r18));
        r14[1] = TuplesKt.to("emoji_id", String.valueOf(r10));
        r14[2] = TuplesKt.to("type", "3");
        r14[3] = TuplesKt.to("scene", "1");
        HashMap r19 = new HashMap(MapsKt.mapOf(r14));
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), r0, 0, 2);
        if (r1 == null) goto L42;
        long r11 = System.currentTimeMillis();
        com.bytedance.live.datacontext.m r2 = r1.getSeiTimePair();
        if (r2 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.z0 r4 = (com.bytedance.android.livesdk.chatroom.z0) r2.getValue();
        if (r4 == null) goto L21;
    L22:
        long r110 = r4.a + (r11 - r4.b);
        com.bytedance.live.datacontext.m r6 = r1.getCameraId();
        if (r6 == null) goto L25;
        Long r7 = (Long) r6.getValue();
    L26:
        com.bytedance.live.datacontext.m r8 = r1.getRoom();
        if (r8 == null) goto L29;
        IRoom r111 = (IRoom) r8.getValue();
    L30:
        int r20 = CommentUtils.a;
        if (r111 == null) goto L35;
        IEpisodeExtraInfo r21 = r111.getEpisodeExtra();
        if (r21 == null) goto L35;
        long r24 = r21.getId();
    L37:
        if (r1.isVSFirstShow() == false) goto L39;
        int r25 = EpisodeMod.EpisodeStageType.PREMIERE;
    L40:
        JSONObject r26 = new JSONObject();
        r26.put("episode_id", r24);
        r26.put("stage", r25);
        r19.put("flow_time", String.valueOf(r110));
        r19.put("camera_id", String.valueOf(r7));
        r19.put("episode_info_str", r26.toString());
        goto L42
    L39:
        r25 = EpisodeMod.EpisodeStageType.LIVE;
    L35:
        r24 = 0;
        goto L37
    L29:
        r111 = null;
        goto L30
    L25:
        r7 = null;
    L21:
        r4 = new com.bytedance.android.livesdk.chatroom.z0(0, 0);
    L42:
        LinkedHashMap r27 = new LinkedHashMap();
        Iterator r28 = r19.entrySet().iterator();
    L44:
        if (r28.hasNext() == false) goto L56;
        Map.Entry r29 = (Map.Entry) r28.next();
        if (r29.getValue() != null) goto L48;
    L53:
        boolean r30 = false;
    L54:
        if (r30 == false) goto L44;
        r27.put(r29.getKey(), r29.getValue());
        goto L44
    L48:
        if (((CharSequence) r29.getValue()).length() <= 0) goto L50;
        boolean r31 = true;
    L51:
        if (r31 == false) goto L53;
        r30 = true;
        goto L54
    L50:
        r31 = false;
        goto L51
    L56:
        r9.add(r13.sendTextMessage(r27).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this, r3, r23, r5), new d(this, r23)));
        return;
    L14:
        r18 = null;
        goto L15
    }

    public final void onMessage(tlc.d r13) {
        if (((q46.b) this).a == null) goto L274;
        if (r13 != null) goto L7;
        return;
    L7:
        if ((r13 instanceof com.bytedance.android.live.base.model.message.t) == false) goto L269;
        if ("WebcastRoomVerifyMessage".equals(((com.bytedance.android.live.base.model.message.t) r13).getMessageMethod()) == false) goto L269;
        if ((r13 instanceof f4) == false) goto L269;
        f4 r0 = (f4) r13;
        int r1 = r0.C();
        if (r1 != 12) goto L15;
        IRoom r2 = this.h;
        if (r2 != null) goto L265;
    L267:
        m0(8);
        goto L269
    L265:
        if (r2.getRoomAuthStatus() == null) goto L267;
        this.h.getRoomAuthStatus().setEnableDigg(false);
        goto L267
    L15:
        if (r1 != 13) goto L17;
        IRoom r3 = this.h;
        if (r3 != null) goto L259;
    L261:
        m0(0);
        goto L269
    L259:
        if (r3.getRoomAuthStatus() == null) goto L261;
        this.h.getRoomAuthStatus().setEnableDigg(true);
        goto L261
    L17:
        if (r1 != 43) goto L19;
        DataCenter r4 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r4 == null) goto L269;
        r4.put("data_top_left_label", r0.getContent());
        goto L269
    L19:
        if (r1 == 46) goto L242;
        IRoom r6 = null;
        switch(r1) {
            case 3: goto L83;
            case 4: goto L71;
            case 5: goto L65;
            case 6: goto L59;
            case 7: goto L44;
            case 8: goto L31;
            default: goto L23;
        };
    L31:
        IRoom r5 = this.h;
        if (r5 != null) goto L34;
    L36:
        IRoomContextService r7 = jc1.k.f(IRoomContextService.class);
        if (r7 != null) goto L39;
    L41:
        if (r6 == null) goto L43;
        r6.getRoomAuthStatus().setEnableGift(true);
    L43:
        boolean r8 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).syncGiftList(4);
        n0(0);
        goto L269
    L39:
        if (r7.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0).getRoom() == null) goto L41;
        r6 = (IRoom) r7.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0).getRoom().getValue();
        goto L41
    L34:
        if (r5.getRoomAuthStatus() == null) goto L36;
        this.h.getRoomAuthStatus().setEnableGift(true);
        goto L36
    L44:
        IRoom r9 = this.h;
        if (r9 != null) goto L47;
    L49:
        IRoomContextService r10 = jc1.k.f(IRoomContextService.class);
        if (r10 != null) goto L52;
    L54:
        if (r6 != null) goto L56;
    L58:
        n0(8);
        goto L269
    L56:
        if (r6.getRoomAuthStatus() == null) goto L58;
        r6.getRoomAuthStatus().setEnableGift(false);
        goto L58
    L52:
        if (r10.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0).getRoom() == null) goto L54;
        r6 = (IRoom) r10.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0).getRoom().getValue();
        goto L54
    L47:
        if (r9.getRoomAuthStatus() == null) goto L49;
        this.h.getRoomAuthStatus().setEnableGift(false);
        goto L49
    L59:
        this.i = true;
        IRoom r11 = this.h;
        if (r11 != null) goto L62;
    L64:
        ((q46.b) this).a.Oy(this.i);
        goto L269
    L62:
        if (r11.getRoomAuthStatus() == null) goto L64;
        this.h.getRoomAuthStatus().setEnableDanmaku(true);
        goto L64
    L65:
        this.i = false;
        IRoom r14 = this.h;
        if (r14 != null) goto L68;
    L70:
        ((q46.b) this).a.Oy(this.i);
        goto L269
    L68:
        if (r14.getRoomAuthStatus() == null) goto L70;
        this.h.getRoomAuthStatus().setEnableDanmaku(false);
        goto L70
    L71:
        IRoom r15 = this.h;
        if (r15 != null) goto L74;
    L82:
        ((q46.b) this).a.M3();
        goto L269
    L74:
        if (r15.getRoomAuthStatus() == null) goto L82;
        this.h.getRoomAuthStatus().setEnableChat(true);
        if (this.h.getRoomAuthStatus().getRoomAuthSpecialStyle() != null) goto L79;
        this.h.getRoomAuthStatus().setRoomAuthSpecialStyle(vh7.f.c(IRoomAuthStatus.IRoomAuthSpecialStyle.class));
    L79:
        if (this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle() != null) goto L81;
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().setChatStyle(vh7.f.c(IRoomAuthStatusStyle.class));
    L81:
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().setSwitchStatusAnchorTipMsg(r0.getSwitchStatusAnchorTipMsg());
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().setSwitchStatusTipMsg(r0.getSwitchStatusTipMsg());
        goto L82
    L83:
        IRoom r16 = this.h;
        if (r16 != null) goto L86;
    L100:
        ((q46.b) this).a.M3();
        goto L269
    L86:
        if (r16.getRoomAuthStatus() == null) goto L100;
        this.h.getRoomAuthStatus().setEnableChat(false);
        if (this.h.getRoomAuthStatus().getRoomAuthSpecialStyle() != null) goto L91;
        this.h.getRoomAuthStatus().setRoomAuthSpecialStyle(vh7.f.c(IRoomAuthStatus.IRoomAuthSpecialStyle.class));
    L91:
        if (this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle() != null) goto L94;
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().setChatStyle(vh7.f.c(IRoomAuthStatusStyle.class));
    L94:
        if (r0.getUnableStyle() == 1) goto L96;
    L98:
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().setUnableStyle(0);
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().setContent(BuildConfig.FLAVOR);
    L99:
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().setSwitchStatusAnchorTipMsg(r0.getSwitchStatusAnchorTipMsg());
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().setSwitchStatusTipMsg(r0.getSwitchStatusTipMsg());
        goto L100
    L96:
        if (TextUtils.isEmpty(r0.p()) == true) goto L98;
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().setUnableStyle(r0.getUnableStyle());
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().setContent(r0.p());
        goto L99
    L23:
        switch(r1) {
            case 21: goto L149;
            case 22: goto L143;
            case 23: goto L137;
            case 24: goto L129;
            case 25: goto L121;
            case 26: goto L111;
            case 27: goto L101;
            default: goto L25;
        };
    L101:
        IRoom r17 = this.h;
        if (r17 == null) goto L108;
        IRoomAuthStatus r18 = r17.getRoomAuthStatus();
        if (r18 == null) goto L108;
        com.bytedance.android.livesdk.interactivity.service.model.c r19 = (com.bytedance.android.livesdk.interactivity.service.model.c) r18.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.c.class);
        if (r19 == null) goto L108;
        r19.setEnableAudioComment(2);
    L108:
        DataCenter r20 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r20 == null) goto L269;
        r20.put("data_room_audio_comment_enable", Boolean.FALSE);
        goto L269
    L111:
        IRoom r21 = this.h;
        if (r21 == null) goto L118;
        IRoomAuthStatus r23 = r21.getRoomAuthStatus();
        if (r23 == null) goto L118;
        com.bytedance.android.livesdk.interactivity.service.model.c r24 = (com.bytedance.android.livesdk.interactivity.service.model.c) r23.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.c.class);
        if (r24 == null) goto L118;
        r24.setEnableAudioComment(1);
    L118:
        DataCenter r25 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r25 == null) goto L269;
        r25.put("data_room_audio_comment_enable", Boolean.TRUE);
        goto L269
    L121:
        IRoom r26 = this.h;
        if (r26 != null) goto L124;
    L126:
        DataCenter r27 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r27 == null) goto L269;
        r27.put("data_room_banner_status", Boolean.TRUE);
        goto L269
    L124:
        if (r26.getRoomAuthStatus() == null) goto L126;
        this.h.getRoomAuthStatus().enableBanner(1);
        goto L126
    L129:
        IRoom r28 = this.h;
        if (r28 != null) goto L132;
    L134:
        DataCenter r29 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r29 == null) goto L269;
        r29.put("data_room_banner_status", Boolean.FALSE);
        goto L269
    L132:
        if (r28.getRoomAuthStatus() == null) goto L134;
        this.h.getRoomAuthStatus().enableBanner(2);
        goto L134
    L137:
        IRoom r30 = this.h;
        if (r30 == null) goto L140;
        r30.setIntroduction(r0.getContent());
    L140:
        DataCenter r31 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r31 == null) goto L269;
        r31.put("data_room_introduction", r0.getContent());
        goto L269
    L143:
        IRoom r33 = this.h;
        if (r33 == null) goto L146;
        r33.setShortTitle(r0.getContent());
    L146:
        DataCenter r34 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r34 == null) goto L269;
        r34.put("data_room_short_title", r0.getContent());
        goto L269
    L149:
        IRoom r35 = this.h;
        if (r35 == null) goto L152;
        r35.setTitle(r0.getContent());
    L152:
        DataCenter r36 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r36 == null) goto L269;
        r36.put("data_room_title", r0.getContent());
        goto L269
    L25:
        switch(r1) {
            case 30: goto L187;
            case 31: goto L184;
            case 32: goto L165;
            case 33: goto L155;
            default: goto L27;
        };
    L155:
        IRoom r37 = this.h;
        if (r37 != null) goto L158;
    L162:
        DataCenter r38 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r38 == null) goto L269;
        r38.put("cmd_media_room_hide_share", Boolean.FALSE);
        goto L269
    L158:
        if (r37.getRoomAuthStatus() == null) goto L162;
        if (this.h.getRoomAuthStatus().getRoomAuthSpecialStyle() == null) goto L162;
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().setShareStyle(null);
        goto L162
    L165:
        IRoom r39 = this.h;
        if (r39 != null) goto L168;
    L181:
        DataCenter r40 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r40 == null) goto L269;
        r40.put("cmd_media_room_hide_share", Boolean.TRUE);
        goto L269
    L168:
        if (r39.getRoomAuthStatus() == null) goto L181;
        if (this.h.getRoomAuthStatus().getRoomAuthSpecialStyle() != null) goto L173;
        IRoomAuthStatus.IRoomAuthSpecialStyle r41 = vh7.f.c(IRoomAuthStatus.IRoomAuthSpecialStyle.class);
        r41.setShareStyle(vh7.f.c(IRoomAuthStatusStyle.class));
        this.h.getRoomAuthStatus().setRoomAuthSpecialStyle(r41);
    L173:
        if (this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getShareStyle() != null) goto L176;
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().setShareStyle(vh7.f.c(IRoomAuthStatusStyle.class));
    L176:
        if (r0.getUnableStyle() == 1) goto L178;
    L180:
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getShareStyle().setUnableStyle(0);
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getShareStyle().setContent(BuildConfig.FLAVOR);
        goto L181
    L178:
        if (TextUtils.isEmpty(r0.p()) == true) goto L180;
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getShareStyle().setUnableStyle(r0.getUnableStyle());
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getShareStyle().setContent(r0.p());
        goto L181
    L184:
        DataCenter r43 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r43 == null) goto L269;
        r43.put("cmd_media_room_comment_hide_on_typing", Boolean.FALSE);
        goto L269
    L187:
        DataCenter r44 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r44 == null) goto L269;
        r44.put("cmd_media_room_comment_hide_on_typing", Boolean.TRUE);
        goto L269
    L27:
        switch(r1) {
            case 35: goto L205;
            case 36: goto L202;
            case 37: goto L199;
            case 38: goto L196;
            case 39: goto L193;
            case 40: goto L190;
            default: goto L29;
        };
    L190:
        DataCenter r45 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r45 == null) goto L269;
        r45.put("cmd_switch_up_right_pv", Boolean.TRUE);
        goto L269
    L193:
        DataCenter r46 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r46 == null) goto L269;
        r46.put("cmd_switch_up_right_pv", Boolean.FALSE);
        goto L269
    L196:
        DataCenter r47 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r47 == null) goto L269;
        r47.put("cmd_enable_room_contributor", Boolean.TRUE);
        goto L269
    L199:
        DataCenter r48 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r48 == null) goto L269;
        r48.put("cmd_enable_room_contributor", Boolean.FALSE);
        goto L269
    L202:
        DataCenter r49 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r49 == null) goto L269;
        r49.put("cmd_enable_click_online", Boolean.TRUE);
        goto L269
    L205:
        DataCenter r50 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r50 == null) goto L269;
        r50.put("cmd_enable_click_online", Boolean.FALSE);
        goto L269
    L29:
        switch(r1) {
            case 51: goto L234;
            case 52: goto L226;
            case 53: goto L217;
            case 54: goto L208;
            default: goto L269;
        };
    L208:
        IRoom r51 = this.h;
        if (r51 == null) goto L269;
        if (r51.getRoomAuthStatus() == null) goto L269;
        if (this.h.getRoomAuthStatus().getRoomAuthSpecialStyle() == null) goto L269;
        if (this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle() == null) goto L269;
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().setAnchorSwitchForPaidLive(2);
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().setContentForPaidLive(r0.p());
        goto L269
    L217:
        IRoom r53 = this.h;
        if (r53 == null) goto L269;
        if (r53.getRoomAuthStatus() == null) goto L269;
        if (this.h.getRoomAuthStatus().getRoomAuthSpecialStyle() == null) goto L269;
        if (this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle() == null) goto L269;
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().setAnchorSwitchForPaidLive(1);
        this.h.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().setContentForPaidLive(r0.p());
        goto L269
    L226:
        IRoom r54 = this.h;
        if (r54 != null) goto L229;
    L231:
        DataCenter r55 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r55 == null) goto L269;
        r55.put("data_room_video_comment_share_enable", Boolean.FALSE);
        goto L269
    L229:
        if (r54.getRoomAuthStatus() == null) goto L231;
        this.h.getRoomAuthStatus().enableVideoShare(2);
        goto L231
    L234:
        IRoom r56 = this.h;
        if (r56 != null) goto L237;
    L239:
        DataCenter r57 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r57 == null) goto L269;
        r57.put("data_room_video_comment_share_enable", Boolean.TRUE);
        goto L269
    L237:
        if (r56.getRoomAuthStatus() == null) goto L239;
        this.h.getRoomAuthStatus().enableVideoShare(1);
        goto L239
    L242:
        IRoom r58 = this.h;
        if (r58 == null) goto L269;
        if (r58.getRoomAuthStatus() == null) goto L269;
        com.bytedance.android.livesdk.log.b0 r59 = com.bytedance.android.livesdk.log.b0.o();
        String r60 = "Receive ACTION_ANCHOR_SET_COMMENT_ENABLE:" + r0.getAnchorSwitch();
        r59.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", r60);
        IRoomAuthStatus r61 = this.h.getRoomAuthStatus();
        IRoomAuthStatus.IRoomAuthSpecialStyle r63 = r61.getRoomAuthSpecialStyle();
        if (r63 != null) goto L249;
        r63 = (IRoomAuthStatus.IRoomAuthSpecialStyle) vh7.f.c(IRoomAuthStatus.IRoomAuthSpecialStyle.class);
        r61.setRoomAuthSpecialStyle(r63);
    L249:
        IRoomAuthStatusStyle r64 = r63.getChatStyle();
        if (r64 != null) goto L252;
        r64 = (IRoomAuthStatusStyle) vh7.f.c(IRoomAuthStatusStyle.class);
        r63.setChatStyle(r64);
    L252:
        r64.setContent(r0.p());
        r64.setAnchorSwitch(r0.getAnchorSwitch());
    L269:
        if ((r13 instanceof j6) == false) goto L275;
        LowPcuGuideData r110 = ((j6) r13).lowPcuGuideData;
        if (r110 == null) goto L276;
        ((q46.b) this).a.EH(r110.guideText, r110.status);
        return;
    L276:
        return;
    L275:
        return;
    }

    public final void p0(final com.bytedance.android.livesdk.event.c0 r11) {
        com.bytedance.android.livesdk.interactivity.api.monitor.a.c("subscribe");
        if (com.bytedance.android.livesdk.interactivity.api.i.a(null, ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c) == null) goto L24;
        if (com.bytedance.android.livesdk.interactivity.api.i.a(null, ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c).getQuickCommentManager().getValue() == null) goto L24;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r0 = (com.bytedance.android.livesdk.interactivity.api.quickcomment.f) com.bytedance.android.livesdk.interactivity.api.i.a(null, ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c).getQuickCommentManager().getValue();
        if (r0 == null) goto L24;
        if (r0.isFixedComment() == false) goto L24;
        if (r11 == null) goto L12;
        Object r3 = r11.g;
    L14:
        if ((r3 instanceof CommentFlowContext) == true) goto L16;
        r3 = null;
    L16:
        CommentFlowContext r4 = (CommentFlowContext) r3;
        if (r4 == null) goto L19;
        boolean r5 = y22.b.a(r4);
    L20:
        if (r5 == true) goto L24;
        IESUIUtils.displayToast(((q46.b) this).a.getContext(), r0.getFixCommentToast());
        return;
    L19:
        r5 = false;
        goto L20
    L12:
        r3 = null;
    L24:
        if (this.m != null) goto L26;
    L32:
        xs2.b.a().post(new com.bytedance.android.livesdk.event.z(r11, false, null));
        return;
    L26:
        if (this.f == false) goto L32;
        if (yt0.c.l() == null) goto L32;
        final long r8 = System.currentTimeMillis();
        final long r6 = SystemClock.uptimeMillis();
        this.m.add(yt0.c.l().Ti(r11.a, r11.getType()).subscribe(new g(this, r6, r11, r8), new h(this, r11)));
    }

    public final void h0(long r10, boolean r13, long r14, Throwable r15) {
        String r2 = jc1.k.f(IMiddlewareUserService.class).user().n();
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        long r3 = 0;
        if (r0 != null) goto L5;
    L9:
        if (r13 == false) goto L12;
        boolean r16 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(yt0.b.class).getPrivilegeSlardarMonitor().d(r2, r3, r10, r14);
        return;
    L12:
        if ((r15 instanceof CustomApiServerException) == false) goto L14;
        CustomApiServerException r17 = (CustomApiServerException) r15;
        int r18 = r17.getErrorCode();
        String r19 = r17.getErrorMsg();
        int r8 = r18;
    L18:
        if (r19 != null) goto L20;
        String r7 = "Unknown";
    L21:
        boolean r110 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(yt0.b.class).getPrivilegeSlardarMonitor().a(r2, r3, r10, r7, r8);
        return;
    L20:
        r7 = r19;
        goto L21
    L14:
        if (r15 != null) goto L16;
        r19 = "Unknown";
    L17:
        r8 = 0;
        goto L18
    L16:
        r19 = r15.getMessage();
        goto L17
    L5:
        if (r0.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0).getRoom() == null) goto L9;
        IRoom r1 = (IRoom) r0.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0).getRoom().getValue();
        if (r1 == null) goto L9;
        r3 = r1.getRoomId();
        goto L9
    }

    public final void i0(int r9, boolean r10, long r11, Throwable r13) {
        String r2 = jc1.k.f(IMiddlewareUserService.class).user().n();
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        long r3 = 0;
        if (r0 != null) goto L5;
    L9:
        if (r10 == false) goto L12;
        boolean r14 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(yt0.b.class).getPrivilegeSlardarMonitor().i(r2, r3, r11, r9);
        return;
    L12:
        if ((r13 instanceof CustomApiServerException) == false) goto L14;
        CustomApiServerException r15 = (CustomApiServerException) r13;
        int r16 = r15.getErrorCode();
        String r17 = r15.getErrorMsg();
        int r7 = r16;
    L18:
        if (r17 != null) goto L20;
        String r6 = "Unknown";
    L21:
        boolean r18 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(yt0.b.class).getPrivilegeSlardarMonitor().f(r2, r3, r9, r6, r7);
        return;
    L20:
        r6 = r17;
        goto L21
    L14:
        if (r13 != null) goto L16;
        r17 = "Unknown";
    L17:
        r7 = 0;
        goto L18
    L16:
        r17 = r13.getMessage();
        goto L17
    L5:
        if (r0.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0).getRoom() == null) goto L9;
        IRoom r1 = (IRoom) r0.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0).getRoom().getValue();
        if (r1 == null) goto L9;
        r3 = r1.getRoomId();
        goto L9
    }

    public final void j0(final String r24, final long r25, final boolean r27, boolean r28) {
        com.bytedance.android.livesdk.interactivity.api.monitor.a.c("audio");
        if (r28 == false) goto L5;
        z32.c.b(InputValueNode.SendAudio);
    L5:
        HashMap r0 = new HashMap();
        r0.put("is_from_click_event", Boolean.valueOf(r28));
        final com.bytedance.android.livesdk.event.x r13 = new com.bytedance.android.livesdk.event.x(r24, ISendCommentEvent.Sender.CommentWidget, r0);
        if (this.m != null) goto L8;
    L60:
        xs2.b.a().post(new com.bytedance.android.livesdk.event.z(r13, false, null));
        return;
    L8:
        if (TextUtils.isEmpty(r24) == true) goto L60;
        int r1 = this.g;
        if (r1 > 2) goto L60;
        this.g = r1 + 1;
        IBaseUser r2 = (IBaseUser) ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c.get("data_user_in_room");
        if (r2 != null) goto L15;
        r2 = jc1.k.f(IMiddlewareUserService.class).user().b();
    L15:
        if (r27 == false) goto L17;
        kc2.a r5 = kc2.d.a(r24);
        r5.setLocalInsertMsg(true);
        r5.updateField = 1;
        final com.bytedance.android.live.base.model.message.r r6 = r5;
    L18:
        r6.setSendStatus(2);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r.d(r6, PSMessageAction.SYSTEM);
        if (com.bytedance.android.livesdk.interactivity.api.utils.a.a(r2) == false) goto L21;
        Map<String, MessageIdentity> r7 = com.bytedance.android.livesdk.interactivity.api.comment.data.b.a;
        HashMap r8 = (HashMap) r7;
        r6.setMessageIdentity((MessageIdentity) r8.get(r2.getIdString()));
    L21:
        ((q46.b) this).a.R00(r6);
        long r9 = this.h.getId();
        IRoomContextService r3 = jc1.k.f(IRoomContextService.class);
        long r10 = 0;
        if (r3 != null) goto L24;
    L35:
        Long r4 = null;
        g92.d r11 = null;
    L36:
        if (r3 == null) goto L40;
        long r15 = ((Long) r3.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0).getCameraId().getValue()).longValue();
        if (r15 <= 0) goto L40;
        String r14 = String.valueOf(r15);
    L41:
        final long r16 = System.currentTimeMillis();
        CompositeDisposable r17 = this.m;
        TypedOutput r18 = new TypedFile("application/octet-stream", new PolarisFileWrapper(r24));
        Intrinsics.checkNotNullParameter(r18, "output");
        CommentApi r19 = (CommentApi) com.bytedance.android.live.network.c.b().e(CommentApi.class);
        Pair[] r110 = new Pair[7];
        r110[0] = TuplesKt.to("room_id", String.valueOf(r9));
        r110[1] = TuplesKt.to("audio_duration", String.valueOf(r25));
        if (r4 == null) goto L44;
        String r20 = String.valueOf(r4.longValue());
    L45:
        r110[2] = TuplesKt.to("flow_time", r20);
        r110[3] = TuplesKt.to("team_id", String.valueOf(0));
        r110[4] = TuplesKt.to("host_channel_id", String.valueOf(0));
        r110[5] = TuplesKt.to("camera_id", r14);
        if (r11 == null) goto L48;
        JSONObject r21 = new JSONObject();
        r21.put("episode_id", r11.a);
        r21.put("stage", r11.b);
        String r23 = r21.toString();
    L49:
        r110[6] = TuplesKt.to("episode_info_str", r23);
        Map r26 = MapsKt.mapOf(r110);
        LinkedHashMap r29 = new LinkedHashMap();
        Iterator r30 = r26.entrySet().iterator();
    L51:
        if (r30.hasNext() == false) goto L58;
        Map.Entry r31 = (Map.Entry) r30.next();
        if (r31.getValue() == null) goto L55;
        boolean r33 = true;
    L56:
        if (r33 == false) goto L51;
        r29.put(r31.getKey(), r31.getValue());
        goto L51
    L55:
        r33 = false;
        goto L56
    L58:
        r17.add(r19.sendAudioMessage(new HashMap(r29), r18).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this, r13, r24, r27, r6, r25, r16), new f(this, r13, r24, r27, r25)));
        return;
    L48:
        r23 = null;
        goto L49
    L44:
        r20 = null;
    L40:
        r14 = null;
        goto L41
    L24:
        if (Boolean.TRUE.equals(r3.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0).isVSRoom()) == false) goto L35;
        long r111 = com.bytedance.android.livesdk.interactivity.common.utils.f.b(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c);
        if (r3.getRoomDataContext(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0).isVSFirstShow() == false) goto L28;
        int r34 = EpisodeMod.EpisodeStageType.PREMIERE;
    L29:
        IRoom r35 = this.h;
        int r112 = CommentUtils.a;
        if (r35 == null) goto L34;
        IEpisodeExtraInfo r36 = r35.getEpisodeExtra();
        if (r36 == null) goto L34;
        r10 = r36.getId();
    L34:
        r11 = new g92.d(r10, r34);
        Intrinsics.checkNotNullParameter(r11, "episodeInfo");
        r4 = Long.valueOf(r111);
        goto L36
    L28:
        r34 = EpisodeMod.EpisodeStageType.LIVE;
        goto L29
    L17:
        long r37 = this.h.getId();
        Intrinsics.checkNotNullParameter(r2, "currentUser");
        com.bytedance.android.live.base.model.message.r r38 = vh7.f.c(com.bytedance.android.live.base.model.message.r.class);
        com.bytedance.android.live.base.model.message.m0 r39 = vh7.f.c(com.bytedance.android.live.base.model.message.m0.class);
        r39.setRoomId(r37);
        r39.setShowMsg(true);
        r39.setMethod("WebcastAudioChatMessage");
        Unit r40 = Unit.INSTANCE;
        r38.setBaseMessage(r39);
        r38.setAudioPath(r24);
        r38.setAudioDuration(r25);
        r38.setUserInfo(r2);
        r38.setMessageMethod("WebcastAudioChatMessage");
        r38.setLocalInsertMsg(true);
        r38.setReadStatus(1);
        r6 = r38;
        goto L18
    }
}
