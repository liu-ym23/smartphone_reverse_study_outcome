package com.bytedance.android.livesdk.feedback.relax;

import am2.x;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.v4;
import com.bytedance.android.livesdk.feedback.light.context.FeedbackPublicScreenContext;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.relax.relaxframework.RelaxPage;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/relax/LiveLightFeedbackRelaxWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LiveLightFeedbackRelaxWidget extends RoomRecyclableWidget implements Observer<KVData> {
    public static final /* synthetic */ int f = 0;
    public com.bytedance.android.livesdk.feedback.light.context.a a;
    public d03.b<p> b;
    public final CompositeDisposable c;
    public ViewGroup d;
    public long e;

    public static final class a {
    }

    public static final class b<T> implements h80.a {
        public final /* synthetic */ LiveLightFeedbackRelaxWidget a;

        public b(LiveLightFeedbackRelaxWidget r1) {
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

    public void onChanged(KVData r1) {
    }

    public void xq(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
    }

    public abstract FeedbackPublicScreenContext yq();

    public void Aq() {
        int r0 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r1 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveLightFeedbackRelaxWidget", "page");
        r1.a = "LiveLightFeedbackRelaxWidget";
        r1.c("initRelaxContainer");
        Pair[] r2 = new Pair[1];
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L7;
        Room r4 = z.o(r3);
        if (r4 == null) goto L7;
        String r5 = r4.getIdStr();
    L8:
        r2[0] = TuplesKt.to("roomId", r5);
        r1.b(r2);
        r1.d();
        return;
    L7:
        r5 = null;
        goto L8
    }

    public final void Bq() {
        if (this.b != null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.feedback.light.context.a r0 = this.a;
        if (r0 == null) goto L95;
        com.bytedance.live.datacontext.n<? extends FeedItem> r1 = r0.getShowRoomFeedback();
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
        com.bytedance.android.livesdk.log.filter.o r8 = u.l().c(x.class);
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
        d03.b<p> r4 = this.b;
        if (r4 == null) goto L18;
        RelaxPage r5 = r4.a;
        if (r5 == null) goto L17;
        r5.a();
    L17:
        r4.b = null;
        Logger.d("relax container", "destroy");
    L18:
        this.b = null;
        this.e = -1;
        com.bytedance.android.livesdk.feedback.light.context.a r6 = this.a;
        if (r6 == null) goto L21;
        r6.updateFeedbackCardShowingStatus(false);
        ((ix1.a) r6.getFeedbackConfigService().getValue()).f();
    L21:
        this.d = null;
    }

    public LiveLightFeedbackRelaxWidget() {
        this.c = new CompositeDisposable();
        this.e = -1;
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
        FeedbackPublicScreenContext r6 = yq();
        this.a = r6;
        if (r6 == null) goto L8;
        r6.initFeedbackConfig(((Widget) this).dataCenter);
    L8:
        com.bytedance.android.livesdk.feedback.light.context.a r7 = this.a;
        if (r7 == null) goto L17;
        com.bytedance.live.datacontext.n<? extends FeedItem> r0 = r7.getShowRoomFeedback();
        FeedItem r1 = (FeedItem) r0.getValue();
        if (r1 == null) goto L13;
        zq(r1);
    L13:
        RxUtilKt.c(r0.a().subscribe(new com.bytedance.android.livesdk.feedback.relax.b(this), i.a), this.c);
        RxUtilKt.c(r7.getOnJsCloseEvent().subscribe(new c(this)), this.c);
        if (v4.a.getValue().a() == false) goto L16;
        RxUtilKt.c(r7.getOnJsCloseClickEvent().subscribe(new d(this)), this.c);
    L16:
        RxUtilKt.c(r7.getOnJsAutoCloseEvent().a().subscribe(new e(this)), this.c);
        RxUtilKt.c(r7.getOnShowStartEvent().subscribe(new f(r7, this), j.a), this.c);
        RxUtilKt.c(r7.getOnHideEndEvent().subscribe(new g(this), h.a), this.c);
    L17:
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L20;
        r8.observe("DATA_IS_HIDE_INTERACTION", this);
    L20:
        runWithRoomEntered(new b(this));
    }

    public final void zq(FeedItem r9) {
        int r0 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r1 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveLightFeedbackRelaxWidget", "page");
        r1.a = "LiveLightFeedbackRelaxWidget";
        r1.c("initRelaxAndShowFeedback");
        Pair[] r2 = new Pair[2];
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L7;
        Room r4 = z.o(r3);
        if (r4 == null) goto L7;
        String r5 = r4.getIdStr();
    L8:
        boolean r6 = false;
        r2[0] = TuplesKt.to("roomId", r5);
        Room r7 = r9.getRoom();
        if (r7 == null) goto L11;
        Long r8 = Long.valueOf(r7.id);
    L12:
        r2[1] = TuplesKt.to("feedbackCard roomId", r8);
        r1.b(r2);
        r1.d();
        if (r9.getRoom().id != z.o(((Widget) this).dataCenter).id) goto L15;
        r6 = true;
    L15:
        if (r6 == true) goto L18;
        r9 = null;
    L18:
        if (r9 == null) goto L21;
        Aq();
        return;
    L21:
        return;
    L11:
        r8 = null;
    L7:
        r5 = null;
        goto L8
    }

    public static final void wq(LiveLightFeedbackRelaxWidget r0, FeedbackCard.FeedbackStatus r1) {
        com.bytedance.android.livesdk.feedback.light.context.a r2 = r0.a;
        if (r2 == null) goto L14;
        com.bytedance.live.datacontext.n<? extends FeedItem> r3 = r2.getShowRoomFeedback();
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
