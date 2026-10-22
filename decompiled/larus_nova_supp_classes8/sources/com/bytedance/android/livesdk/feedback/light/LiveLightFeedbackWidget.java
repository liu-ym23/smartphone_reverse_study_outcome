package com.bytedance.android.livesdk.feedback.light;

import am2.x;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.v4;
import com.bytedance.android.livesdk.feedback.light.context.FeedbackPublicScreenContext;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/light/LiveLightFeedbackWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LiveLightFeedbackWidget extends RoomRecyclableWidget implements Observer<KVData> {
    public static final /* synthetic */ int f = 0;
    public com.bytedance.android.livesdk.feedback.light.context.a a;
    public HybridCard b;
    public final CompositeDisposable c;
    public ViewGroup d;
    public long e;

    public static final class a {
    }

    public static final class b<T> implements h80.a {
        public final /* synthetic */ LiveLightFeedbackWidget a;

        public b(LiveLightFeedbackWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Room r2 = (Room) r1;
            com.bytedance.android.livesdk.feedback.light.context.a r3 = this.a.a;
            if (r3 == null) goto L10;
            com.bytedance.live.datacontext.i<ix1.a> r4 = r3.getFeedbackConfigService();
            if (r4 == null) goto L11;
            ix1.a r5 = (ix1.a) r4.getValue();
            if (r5 == null) goto L12;
            r5.d();
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    static {
    }

    public abstract void Cq(HybridCard r1);

    public void onChanged(KVData r1) {
    }

    public void xq(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
    }

    public void yq(Map<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
    }

    public abstract FeedbackPublicScreenContext zq();

    public final void Bq() {
        if (this.b != null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.feedback.light.context.a r0 = this.a;
        if (r0 == null) goto L95;
        n<? extends FeedItem> r1 = r0.getShowRoomFeedback();
        if (r1 == null) goto L96;
        FeedItem r2 = (FeedItem) r1.getValue();
        if (r2 == null) goto L97;
        Room r3 = r2.getRoom();
        if (r3 == null) goto L98;
        FeedbackCard r4 = r3.mFeedbackCard;
        if (r4 == null) goto L100;
        long r5 = this.e;
        long r6 = System.currentTimeMillis();
        if (1 <= r5) goto L20;
        return;
    L20:
        if (r6 <= r5) goto L99;
        LinkedHashMap r7 = new LinkedHashMap();
        o r8 = u.l().c(x.class);
        if ((r8 instanceof n0) == true) goto L24;
        r8 = null;
    L24:
        n0 r9 = (n0) r8;
        String r10 = "";
        if (r9 == null) goto L30;
        Map r11 = ((com.bytedance.android.livesdk.log.filter.a) r9).b;
        if (r11 == null) goto L30;
        String r12 = (String) r11.get("enter_from_merge");
        if (r12 == null) goto L30;
    L31:
        r7.put("enter_from_merge", r12);
        if (r9 == null) goto L37;
        Map r13 = ((com.bytedance.android.livesdk.log.filter.a) r9).b;
        if (r13 == null) goto L37;
        String r14 = (String) r13.get("enter_method");
        if (r14 == null) goto L37;
    L38:
        r7.put("enter_method", r14);
        if (r9 == null) goto L44;
        Map r15 = ((com.bytedance.android.livesdk.log.filter.a) r9).b;
        if (r15 == null) goto L44;
        String r16 = (String) r15.get("action_type");
        if (r16 == null) goto L44;
    L45:
        r7.put("action_type", r16);
        Room r17 = z.o(((Widget) this).dataCenter);
        if (r17 == null) goto L49;
        String r18 = r17.getIdStr();
        if (r18 == null) goto L49;
    L50:
        r7.put("room_id", r18);
        Room r19 = z.o(((Widget) this).dataCenter);
        if (r19 == null) goto L56;
        User r20 = r19.getOwner();
        if (r20 == null) goto L56;
        String r21 = r20.getIdString();
        if (r21 == null) goto L56;
    L57:
        r7.put("anchor_id", r21);
        DataCenter r22 = ((Widget) this).dataCenter;
        if (r22 == null) goto L63;
        Room r23 = z.o(r22);
        if (r23 == null) goto L63;
        String r24 = r23.getRequestId();
        if (r24 == null) goto L63;
    L64:
        r7.put("request_id", r24);
        Long r25 = r4.feedbackId;
        if (r25 == null) goto L68;
        String r26 = String.valueOf(r25.longValue());
        if (r26 == null) goto L68;
    L69:
        r7.put("feedback_id", r26);
        r7.put("duration", String.valueOf(r6 - r5));
        Integer r27 = r4.getIndex();
        if (r27 == null) goto L73;
        String r28 = String.valueOf(r27.intValue());
        if (r28 == null) goto L73;
    L74:
        r7.put("draw_order", r28);
        r7.put("flow_type", "room");
        String r29 = r4.getLogInfo();
        if (r29 != null) goto L77;
        r29 = "";
    L77:
        r7.put("question_text", r29);
        Integer r30 = r4.feedbackType;
        if (r30 != null) goto L81;
    L83:
        if (r30 != null) goto L86;
    L88:
        String r31 = "";
    L89:
        r7.put("card_type", r31);
        r7.put("question_type", "single");
        String r32 = String.valueOf(jc1.k.n(ILinkServiceExternal.class).getMultiDataHolderExternal().getPkId());
        if (r32 == null) goto L93;
        r10 = r32;
    L93:
        r7.put("pk_id", r10);
        xq(r7);
        u.l().sendLog("livesdk_live_feedback_card_duration", r7, new Object[0]);
        this.e = -1;
        return;
    L86:
        if (r30.intValue() != 6) goto L88;
        r31 = "live_banner_horizontal";
        goto L89
    L81:
        if (r30.intValue() != 5) goto L83;
        r31 = "bottom_bar";
    L73:
        r28 = "0";
    L68:
        r26 = "";
    L63:
        r24 = "";
    L56:
        r21 = "";
    L49:
        r18 = "";
    L44:
        r16 = "";
    L37:
        r14 = "";
    L30:
        r12 = "";
        goto L31
    L99:
        return;
    L100:
        return;
    L98:
        return;
    L97:
        return;
    L96:
        return;
    }

    public void onUnload() {
        com.bytedance.android.livesdk.feedback.light.context.a r0 = this.a;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.i<ix1.a> r1 = r0.getFeedbackConfigService();
        if (r1 == null) goto L9;
        ix1.a r2 = (ix1.a) r1.getValue();
        if (r2 == null) goto L9;
        r2.c();
    L9:
        this.c.clear();
        ViewGroup r3 = this.d;
        if (r3 == null) goto L12;
        r3.removeAllViews();
        r3.setVisibility(8);
    L12:
        Bq();
        HybridCard r4 = this.b;
        if (r4 == null) goto L15;
        r4.release();
    L15:
        this.b = null;
        this.e = -1;
        com.bytedance.android.livesdk.feedback.light.context.a r5 = this.a;
        if (r5 == null) goto L18;
        r5.updateFeedbackCardShowingStatus(false);
        ((ix1.a) r5.getFeedbackConfigService().getValue()).f();
    L18:
        this.d = null;
    }

    public LiveLightFeedbackWidget() {
        this.c = new CompositeDisposable();
        this.e = -1;
    }

    public final void Aq(FeedItem r12) {
        int r0 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r1 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveLightFeedbackWidget", "page");
        r1.a = "LiveLightFeedbackWidget";
        r1.c("initLynxAndShowFeedback");
        Pair[] r3 = new Pair[2];
        DataCenter r4 = ((Widget) this).dataCenter;
        HybridCard r5 = null;
        if (r4 == null) goto L7;
        Room r6 = z.o(r4);
        if (r6 == null) goto L7;
        String r7 = r6.getIdStr();
    L8:
        r3[0] = TuplesKt.to("roomId", r7);
        Room r8 = r12.getRoom();
        if (r8 == null) goto L11;
        Long r9 = Long.valueOf(r8.id);
    L12:
        r3[1] = TuplesKt.to("feedbackCard roomId", r9);
        r1.b(r3);
        r1.d();
        if (r12.getRoom().id != z.o(((Widget) this).dataCenter).id) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == true) goto L19;
        r12 = null;
    L19:
        if (r12 == null) goto L109;
        FeedbackMonitor.Monitor r13 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveLightFeedbackWidget", "page");
        r13.a = "LiveLightFeedbackWidget";
        r13.c("initLynxContainer");
        Pair[] r10 = new Pair[1];
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L25;
        Room r14 = z.o(r11);
        if (r14 == null) goto L25;
        String r15 = r14.getIdStr();
    L26:
        r10[0] = TuplesKt.to("roomId", r15);
        r13.b(r10);
        r13.d();
        com.bytedance.android.livesdk.feedback.light.context.a r16 = this.a;
        if (r16 == null) goto L31;
        String r17 = r16.getLynxUrl();
        if (r17 == null) goto L31;
        String r18 = Eq(r17);
    L32:
        com.bytedance.android.livesdk.feedback.light.context.a r19 = this.a;
        if (r19 == null) goto L37;
        String r20 = r19.getWebUrl();
        if (r20 == null) goto L37;
        String r21 = Eq(r20);
    L38:
        Uri r110 = com.bytedance.android.livesdk.feedback.b.a(r18, r21);
        if (r110 == null) goto L107;
        HybridCard r111 = jc1.k.n(IBrowserService.class).getHybridCard(((Widget) this).context, r110, -1, new k(this));
        if (r111 == null) goto L107;
        r111.setJSBridgeListener(new j(this));
        o r22 = u.l().c(x.class);
        if ((r22 instanceof n0) == true) goto L45;
        r22 = null;
    L45:
        n0 r23 = (n0) r22;
        HashMap r24 = new HashMap();
        com.bytedance.android.livesdk.feedback.light.context.a r25 = this.a;
        if (r25 == null) goto L54;
        n<? extends FeedItem> r26 = r25.getShowRoomFeedback();
        if (r26 == null) goto L54;
        FeedItem r27 = (FeedItem) r26.getValue();
        if (r27 == null) goto L54;
        Room r28 = r27.getRoom();
        if (r28 == null) goto L54;
        FeedbackCard r29 = r28.mFeedbackCard;
    L55:
        String r30 = "";
        if (r29 == null) goto L59;
        String r31 = GsonProtectorUtils.toJson(GsonHelper.get(), r29);
        if (r31 == null) goto L59;
    L60:
        r24.put("feedbackData", r31);
        r24.put("room_id", String.valueOf(z.o(((Widget) this).dataCenter).id));
        if (r23 == null) goto L66;
        Map r32 = ((com.bytedance.android.livesdk.log.filter.a) r23).b;
        if (r32 == null) goto L66;
        String r33 = (String) r32.get("enter_from_merge");
        if (r33 == null) goto L66;
    L67:
        r24.put("enter_from_merge", r33);
        if (r23 == null) goto L73;
        Map r34 = ((com.bytedance.android.livesdk.log.filter.a) r23).b;
        if (r34 == null) goto L73;
        String r35 = (String) r34.get("enter_method");
        if (r35 == null) goto L73;
    L74:
        r24.put("enter_method", r35);
        if (r23 == null) goto L80;
        Map r36 = ((com.bytedance.android.livesdk.log.filter.a) r23).b;
        if (r36 == null) goto L80;
        String r37 = (String) r36.get("action_type");
        if (r37 == null) goto L80;
    L81:
        r24.put("action_type", r37);
        String r38 = z.o(((Widget) this).dataCenter).getRequestId();
        if (r38 != null) goto L84;
        r38 = "";
    L84:
        r24.put("request_id", r38);
        User r39 = z.o(((Widget) this).dataCenter).getOwner();
        if (r39 == null) goto L87;
        String r40 = r39.getIdStr();
    L88:
        r24.put("anchor_id", String.valueOf(r40));
        r24.put("flow_type", "room");
        if (r29 == null) goto L92;
        String r41 = r29.getLogInfo();
        if (r41 == null) goto L92;
    L93:
        r24.put("question_text", r41);
        r24.put("question_type", "single");
        if (r29 == null) goto L99;
        Integer r42 = r29.getIndex();
        if (r42 == null) goto L99;
        String r43 = String.valueOf(r42.intValue());
        if (r43 == null) goto L99;
    L100:
        r24.put("draw_order", r43);
        ILiveFeedbackService r44 = jc1.k.f(ILiveFeedbackService.class);
        if (r44 == null) goto L106;
        String r45 = r44.getRecentRoomIds();
        if (r45 == null) goto L106;
        r30 = r45;
    L106:
        r24.put("recent_room_ids", r30);
        r24.put("pk_id", Long.valueOf(jc1.k.n(ILinkServiceExternal.class).getMultiDataHolderExternal().getPkId()));
        yq(r24);
        r111.load(null, r24);
        Unit r46 = Unit.INSTANCE;
        r5 = r111;
    L99:
        r43 = "0";
    L92:
        r41 = "";
        goto L93
    L87:
        r40 = null;
    L80:
        r37 = "";
    L73:
        r35 = "";
    L66:
        r33 = "";
    L59:
        r31 = "";
    L54:
        r29 = null;
    L107:
        this.b = r5;
        return;
    L37:
        r21 = null;
    L31:
        r18 = null;
    L25:
        r15 = null;
        goto L26
    L109:
        return;
    L15:
        r2 = false;
        goto L16
    L11:
        r9 = null;
    L7:
        r7 = null;
        goto L8
    }

    public final String Eq(String r4) {
        Uri.Builder r5 = UriProtector.parse(r4).buildUpon();     // Catch: Exception -> L4
        Context r1 = ((Widget) this).context;     // Catch: Exception -> L4
        int r2 = com.bytedance.android.livesdk.feedback.utils.a.a;     // Catch: Exception -> L4
        Intrinsics.checkNotNullParameter(r1, "context");     // Catch: Exception -> L4
        return r5.appendQueryParameter("fullscreen", String.valueOf(true)).toString();
    L4:
        e = move-exception;
        ALogger.e("LiveLightFeedbackWidget", "url append params faild.", e);
        return null;
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }

    public final void onInit(Object[] r2) {
        View r3 = ((Widget) this).contentView;
        if ((r3 instanceof ViewGroup) == true) goto L5;
        r3 = null;
    L5:
        this.d = (ViewGroup) r3;
    }

    public void onLoad(Object[] r4) {
        this.e = -1;
        ViewGroup r5 = this.d;
        if (r5 == null) goto L5;
        r5.removeAllViews();
        r5.setVisibility(8);
    L5:
        FeedbackPublicScreenContext r6 = zq();
        this.a = r6;
        if (r6 == null) goto L8;
        r6.initFeedbackConfig(((Widget) this).dataCenter);
    L8:
        com.bytedance.android.livesdk.feedback.light.context.a r7 = this.a;
        if (r7 == null) goto L17;
        n<? extends FeedItem> r0 = r7.getShowRoomFeedback();
        FeedItem r1 = (FeedItem) r0.getValue();
        if (r1 == null) goto L13;
        Aq(r1);
    L13:
        RxUtilKt.c(r0.a().subscribe(new com.bytedance.android.livesdk.feedback.light.a(this), h.a), this.c);
        RxUtilKt.c(r7.getOnJsCloseEvent().subscribe(new com.bytedance.android.livesdk.feedback.light.b(this)), this.c);
        if (v4.a.getValue().a() == false) goto L16;
        RxUtilKt.c(r7.getOnJsCloseClickEvent().subscribe(new c(this)), this.c);
    L16:
        RxUtilKt.c(r7.getOnJsAutoCloseEvent().a().subscribe(new d(this)), this.c);
        RxUtilKt.c(r7.getOnShowStartEvent().subscribe(new e(r7, this), i.a), this.c);
        RxUtilKt.c(r7.getOnHideEndEvent().subscribe(new f(this), g.a), this.c);
    L17:
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L20;
        r8.observe("DATA_IS_HIDE_INTERACTION", this);
    L20:
        runWithRoomEntered(new b(this));
    }

    public static final void wq(LiveLightFeedbackWidget r0, FeedbackCard.FeedbackStatus r1) {
        com.bytedance.android.livesdk.feedback.light.context.a r2 = r0.a;
        if (r2 == null) goto L14;
        n<? extends FeedItem> r3 = r2.getShowRoomFeedback();
        if (r3 == null) goto L15;
        FeedItem r4 = (FeedItem) r3.getValue();
        if (r4 == null) goto L16;
        Room r5 = r4.getRoom();
        if (r5 == null) goto L17;
        FeedbackCard r6 = r5.mFeedbackCard;
        if (r6 == null) goto L18;
        r6.updateFeedbackStatus(r1);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }
}
