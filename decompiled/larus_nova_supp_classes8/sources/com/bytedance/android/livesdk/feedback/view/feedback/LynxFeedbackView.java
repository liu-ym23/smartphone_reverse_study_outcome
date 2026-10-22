package com.bytedance.android.livesdk.feedback.view.feedback;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.feedback.FeedbackContext;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feedback.IFeedbackCallback;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackService;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackView;
import com.bytedance.android.livesdkapi.jsb.IExternalBrowserService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LynxFeedbackView implements dx1.a {
    public final b a;
    public final Lazy b;
    public final Context c;
    public final FeedbackContext d;
    public final Function0<Unit> e;

    public static final class a {
    }

    public static final class b implements IFeedbackCallback {
        public final /* synthetic */ LynxFeedbackView a;

        public final void onLoadSucceed() {
        }

        public final void onUIUpdate() {
        }

        public final void onClose() {
            this.a.e.invoke();
        }

        public b(LynxFeedbackView r1) {
            this.a = r1;
        }

        public final void onFallback(int r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "errorMessage");
            this.a.e.invoke();
        }

        public final void onSubmit(boolean r1, String r2) {
            this.a.e.invoke();
        }
    }

    static {
    }

    @Override // dx1.a
    public final /* synthetic */ void onDestroy() {
    }

    @Override // dx1.a
    public final /* synthetic */ void onSlide() {
    }

    @Override // dx1.a
    public final void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    @Override // dx1.a
    public final void b() {
        ILiveFeedbackView r0 = (ILiveFeedbackView) this.b.getValue();
        if (r0 == null) goto L5;
        View r1 = r0.getView();
    L7:
        if ((r1 instanceof AnnieCard) == true) goto L9;
        r1 = null;
    L9:
        AnnieCard r2 = (AnnieCard) r1;
        if (r2 == null) goto L19;
        View r3 = r2.getHybridView();
        if ((r3 instanceof WebView) == true) goto L14;
        r3 = null;
    L14:
        WebView r4 = (WebView) r3;
        if (r4 == null) goto L17;
        r4.getSettings().setCacheMode(2);
    L17:
        a7.a.a(r2, null, null, 3);
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // dx1.a
    public final void startRoom() {
        jc1.k.n(IExternalBrowserService.class).enqueueEvent("webcast.feedback.play", new JSONObject());
    }

    @Override // dx1.a
    public final void stopRoom() {
        jc1.k.n(IExternalBrowserService.class).enqueueEvent("webcast.feedback.pause", new JSONObject());
    }

    @Override // dx1.a
    public final void c(FeedbackCard r6) {
        if (r6 != null) goto L5;
        this.e.invoke();
        return;
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("feedbackData", GsonProtectorUtils.toJson(l.d().c(), r6));
        Long r1 = r6.roomId;
        if (r1 == null) goto L8;
        long r2 = r1.longValue();
    L9:
        r0.put("room_id", String.valueOf(r2));
        String r3 = this.d.getEnterFromMerge();
        String r4 = "";
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        r0.put("enter_from_merge", r3);
        String r5 = this.d.getEnterMethod();
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        r0.put("enter_method", r5);
        String r7 = this.d.getReqId();
        if (r7 != null) goto L18;
        r7 = "";
    L18:
        r0.put("request_id", r7);
        Room r8 = r6.room;
        if (r8 == null) goto L24;
        User r9 = r8.getOwner();
        if (r9 == null) goto L24;
        String r10 = r9.getIdString();
        if (r10 == null) goto L24;
    L25:
        r0.put("anchor_id", r10);
        r0.put("flow_type", "internal_flow");
        String r11 = r6.getLogInfo();
        if (r11 != null) goto L28;
        r11 = "";
    L28:
        r0.put("question_text", r11);
        Integer r12 = r6.feedbackType;
        if (r12 != null) goto L32;
    L34:
        if (r12 != null) goto L37;
    L39:
        if (r12 != null) goto L42;
    L44:
        if (r12 != null) goto L47;
    L49:
        String r13 = "";
    L50:
        r0.put("card_type", r13);
        Integer r14 = r6.getIndex();
        if (r14 == null) goto L53;
        int r15 = r14.intValue();
    L54:
        r0.put("draw_order", Integer.valueOf(r15));
        o r16 = u.l().c(x.class);
        if (r16 == null) goto L60;
        Map r17 = r16.getMap();
        if (r17 == null) goto L60;
        String r18 = (String) r17.get("action_type");
        if (r18 == null) goto L60;
    L61:
        r0.put("action_type", r18);
        ILiveFeedbackService r19 = jc1.k.f(ILiveFeedbackService.class);
        if (r19 == null) goto L67;
        String r20 = r19.getRecentRoomIds();
        if (r20 == null) goto L67;
        r4 = r20;
    L67:
        r0.put("recent_room_ids", r4);
        ILiveFeedbackView r21 = (ILiveFeedbackView) this.b.getValue();
        if (r21 == null) goto L71;
        r21.loadView(r0);
        return;
    L71:
        return;
    L60:
        r18 = "";
        goto L61
    L53:
        r15 = -1;
        goto L54
    L47:
        if (r12.intValue() != 1) goto L49;
    L48:
        r13 = "questionnaire";
        goto L50
    L42:
        if (r12.intValue() != 2) goto L44;
    L37:
        if (r12.intValue() != 3) goto L39;
        r13 = "small_card";
        goto L50
    L32:
        if (r12.intValue() != 4) goto L34;
        r13 = "big_card";
    L24:
        r10 = "";
        goto L25
    L8:
        r2 = 0;
        goto L9
    }

    @Override // dx1.a
    public final View a(LayoutInflater r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        ILiveFeedbackView r3 = (ILiveFeedbackView) this.b.getValue();
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getView();
    }

    public LynxFeedbackView(Context r2, FeedbackContext r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "feedbackContext");
        Intrinsics.checkNotNullParameter(r4, "onSubmit");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = new b(this);
        this.b = LazyKt.lazy(new LynxFeedbackView$mLynxView$2(this));
    }
}
