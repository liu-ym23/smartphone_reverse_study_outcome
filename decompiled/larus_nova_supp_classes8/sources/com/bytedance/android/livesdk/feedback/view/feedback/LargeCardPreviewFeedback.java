package com.bytedance.android.livesdk.feedback.view.feedback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.feedback.Option;
import com.bytedance.android.live.base.model.feedback.Question;
import com.bytedance.android.live.base.model.feedback.RoomCardStruct;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.j5;
import com.bytedance.android.livesdk.feedback.FeedbackContext;
import com.bytedance.android.livesdk.feedback.api.IFeedbackApi;
import com.bytedance.android.livesdk.feedback.view.preview.LargeCardReplaceViewGroup;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LargeCardPreviewFeedback implements dx1.a {
    public LargeCardReplaceViewGroup a;
    public SimpleDraweeView b;
    public SimpleDraweeView c;
    public SimpleMediaView d;
    public GridLayout e;
    public TextView f;
    public ViewGroup g;
    public TextView h;
    public ViewGroup i;
    public TextView j;
    public FeedbackCard k;
    public Question l;
    public Disposable m;
    public final Lazy n;
    public final b o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Context s;
    public final FeedbackContext t;
    public final Function0<Unit> u;

    public static final class a {
    }

    public static final class b implements kx1.d {
        public final /* synthetic */ LargeCardPreviewFeedback a;

        public b(LargeCardPreviewFeedback r1) {
            this.a = r1;
        }

        @Override // kx1.d
        public final void a(Option r21) {
            Intrinsics.checkNotNullParameter(r21, "option");
            LargeCardPreviewFeedback r2 = this.a;
            r2.getClass();
            StringBuilder r3 = new StringBuilder();
            Question r4 = r2.l;
            String r5 = "";
            if (r4 == null) goto L6;
            String r6 = r4.questionKey;
            if (r6 == null) goto L6;
        L7:
            r3.append(r6);
            r3.append('-');
            r3.append(r21.key);
            String r11 = r3.toString();
            IFeedbackApi r7 = (IFeedbackApi) com.bytedance.android.live.network.c.b().e(IFeedbackApi.class);
            FeedbackCard r8 = r2.k;
            long r9 = 0;
            if (r8 == null) goto L12;
            Long r10 = r8.feedbackId;
            if (r10 == null) goto L12;
            long r12 = r10.longValue();
        L13:
            LargeCardReplaceViewGroup r13 = r2.a;
            if (r13 == null) goto L20;
            RoomCardStruct r14 = r13.getCurRoom();
            if (r14 == null) goto L20;
            Room r15 = r14.room;
            if (r15 == null) goto L20;
            r9 = r15.id;
        L20:
            long r16 = r9;
            String r17 = r2.t.getReqId();
            if (r17 != null) goto L23;
            String r18 = "";
        L24:
            String r19 = r2.t.getEnterFromMerge();
            if (r19 != null) goto L27;
            String r110 = "";
        L28:
            String r20 = r2.t.getEnterMethod();
            if (r20 != null) goto L31;
            String r111 = "";
        L32:
            String r22 = r2.t.getReqId();
            if (r22 != null) goto L35;
            String r112 = "";
        L36:
            ILiveFeedbackService r23 = (ILiveFeedbackService) r2.r.getValue();
            if (r23 == null) goto L42;
            String r24 = r23.getRecentRoomIds();
            if (r24 == null) goto L42;
            String r113 = r24;
        L43:
            r2.m = IFeedbackApi.CC.feedbackRequest$default(r7, r12, r16, r11, r18, r110, r111, r112, null, r113, 128, null).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(c.a, d.a);
            LargeCardPreviewFeedback r25 = this.a;
            if (Intrinsics.areEqual(r21.negative, Boolean.TRUE) == false) goto L46;
            String r26 = "dislike";
        L47:
            r25.getClass();
            LinkedHashMap r27 = new LinkedHashMap();
            FeedbackContext.a r28 = FeedbackContext.Companion;
            int r29 = r25.hashCode();
            r28.getClass();
            FeedbackContext r30 = FeedbackContext.a.a(r29);
            if (r30 == null) goto L51;
            String r31 = r30.getEnterFromMerge();
            if (r31 == null) goto L51;
        L52:
            r27.put("enter_from_merge", r31);
            FeedbackContext r32 = FeedbackContext.a.a(r25.hashCode());
            if (r32 == null) goto L56;
            String r33 = r32.getEnterMethod();
            if (r33 == null) goto L56;
        L57:
            r27.put("enter_method", r33);
            FeedbackCard r34 = r25.k;
            if (r34 == null) goto L63;
            Room r35 = r34.room;
            if (r35 == null) goto L63;
            String r36 = String.valueOf(r35.id);
            if (r36 == null) goto L63;
        L64:
            r27.put("room_id", r36);
            FeedbackCard r37 = r25.k;
            if (r37 == null) goto L72;
            Room r38 = r37.room;
            if (r38 == null) goto L72;
            User r39 = r38.getOwner();
            if (r39 == null) goto L72;
            String r40 = r39.getIdString();
            if (r40 == null) goto L72;
        L73:
            r27.put("anchor_id", r40);
            FeedbackContext r41 = FeedbackContext.a.a(r25.hashCode());
            if (r41 == null) goto L77;
            String r42 = r41.getReqId();
            if (r42 == null) goto L77;
        L78:
            r27.put("request_id", r42);
            FeedbackCard r43 = r25.k;
            if (r43 == null) goto L84;
            Long r44 = r43.feedbackId;
            if (r44 == null) goto L84;
            String r45 = String.valueOf(r44.longValue());
            if (r45 == null) goto L84;
        L85:
            r27.put("feedback_id", r45);
            FeedbackCard r46 = r25.k;
            if (r46 == null) goto L91;
            Integer r47 = r46.getIndex();
            if (r47 == null) goto L91;
            String r48 = String.valueOf(r47.intValue());
            if (r48 == null) goto L91;
        L92:
            r27.put("draw_order", r48);
            r27.put("flow_type", "internal_flow");
            FeedbackCard r49 = r25.k;
            if (r49 == null) goto L98;
            String r50 = r49.getLogInfo();
            if (r50 == null) goto L98;
            r5 = r50;
        L98:
            r27.put("question_text", r5);
            r27.put("card_type", "big_card");
            r27.put("question_type", "multiple");
            r27.put("button_type", r26);
            u.l().sendLog("livesdk_live_feedback_card_click", r27, new Object[0]);
            LargeCardReplaceViewGroup r51 = this.a.a;
            if (r51 == null) goto L110;
            com.bytedance.android.livesdk.feedback.view.preview.j r52 = r51.c();
            if (r52 != null) goto L104;
            return;
        L104:
            if (Intrinsics.areEqual(r52, com.bytedance.android.livesdk.feedback.view.preview.j.a.a) == false) goto L111;
            this.a.u.invoke();
            String r1 = r21.toastText;
            if (r1 != null) goto L108;
            r1 = s1.B(2131919107);
        L108:
            f2.c(r1, 0);
            return;
        L111:
            return;
        L110:
            return;
        L91:
            r48 = "";
        L84:
            r45 = "";
        L77:
            r42 = "";
        L72:
            r40 = "";
        L63:
            r36 = "";
        L56:
            r33 = "";
        L51:
            r31 = "";
            goto L52
        L46:
            r26 = "like";
        L42:
            r113 = "";
            goto L43
        L35:
            r112 = r22;
            goto L36
        L31:
            r111 = r20;
            goto L32
        L27:
            r110 = r19;
            goto L28
        L23:
            r18 = r17;
        L12:
            r12 = 0;
        L6:
            r6 = "";
            goto L7
        }
    }

    static {
    }

    @Override // dx1.a
    public final /* synthetic */ void b() {
    }

    @Override // dx1.a
    public final /* synthetic */ void onSlide() {
    }

    @Override // dx1.a
    public final void onDestroy() {
        Disposable r0 = this.m;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // dx1.a
    public final void startRoom() {
        LargeCardReplaceViewGroup r0 = this.a;
        if (r0 == null) goto L26;
        com.bytedance.android.livesdk.feedback.view.preview.b r1 = r0.b;
        if (r1 == null) goto L7;
        r1.startPreview();
    L7:
        com.bytedance.android.livesdk.feedback.view.preview.b r2 = r0.c;
        if (r2 == null) goto L26;
        r2.startPreview();
    L26:
        SimpleMediaView r3 = this.d;     // Catch: Exception -> L24
        if (r3 != null) goto L13;
        return;
    L13:
        if (r3.h() == false) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == true) goto L21;
        r3 = null;
    L21:
        if (r3 == null) goto L29;
        r3.setPlayEntity((tic.a) this.n.getValue());     // Catch: Exception -> L24
        r3.k();     // Catch: Exception -> L24
        r3.setLoop(true);     // Catch: Exception -> L24
        return;
    L29:
        return;
    L15:
        if (((tic.a) this.n.getValue()) == null) goto L17;
        r4 = true;
    L24:
        ALogger.d("FeedbackMediaPlayError", "LargePreviewQuestion");
    }

    @Override // dx1.a
    public final void stopRoom() {
        LargeCardReplaceViewGroup r0 = this.a;
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.feedback.view.preview.b r1 = r0.b;
        if (r1 == null) goto L7;
        r1.stopPreview();
    L7:
        com.bytedance.android.livesdk.feedback.view.preview.b r2 = r0.c;
        if (r2 == null) goto L10;
        r2.stopPreview();
    L10:
        SimpleMediaView r3 = this.d;
        if (r3 == null) goto L14;
        r3.m();
        return;
    }

    @Override // dx1.a
    public final void c(FeedbackCard r4) {
        this.k = r4;
        List<Option> r0 = null;
        if (r4 == null) goto L7;
        List r1 = r4.question;
        if (r1 == null) goto L7;
        Question r2 = (Question) ListProtector.get(r1, 0);
    L8:
        this.l = r2;
        TextView r3 = this.h;
        if (r3 == null) goto L16;
        if (r2 == null) goto L14;
        String r5 = r2.questionText;
        if (r5 == null) goto L14;
    L15:
        r3.setText(r5);
    L14:
        r5 = "";
    L16:
        TextView r6 = this.f;
        if (r6 == null) goto L24;
        if (r4 == null) goto L22;
        String r7 = r4.title;
        if (r7 == null) goto L22;
    L23:
        r6.setText(r7);
    L22:
        r7 = s1.B(2131919102);
    L24:
        LargeCardReplaceViewGroup r8 = this.a;
        if (r8 == null) goto L31;
        Question r9 = this.l;
        if (r9 == null) goto L29;
        List<RoomCardStruct> r10 = r9.rooms;
    L30:
        r8.b(r10, this.t);
        goto L31
    L29:
        r10 = null;
    L31:
        GridLayout r11 = this.e;
        if (r11 == null) goto L34;
        r11.removeAllViews();
    L34:
        lx1.d r12 = (lx1.d) this.p.getValue();
        Question r13 = this.l;
        if (r13 == null) goto L37;
        r0 = r13.options;
    L37:
        List<kx1.g> r14 = r12.a(r0);
        if (r14 == null) goto L45;
        Iterator<T> r15 = r14.iterator();
    L41:
        if (r15.hasNext() == false) goto L45;
        kx1.g r16 = (kx1.g) r15.next();
        GridLayout r17 = this.e;
        if (r17 == null) goto L41;
        r17.addView(r16);
    L45:
        SimpleDraweeView r18 = this.b;
        if (r18 == null) goto L48;
        r18.setController(Fresco.newDraweeControllerBuilder().setUri(FeedbackContext.FEEDBACK_FRAGMENT_BG).setAutoPlayAnimations(true).build());
    L48:
        SimpleDraweeView r19 = this.c;
        if (r19 == null) goto L57;
        r19.setController(Fresco.newDraweeControllerBuilder().setUri(FeedbackContext.FEEDBACK_FRAGMENT_SLIDE_PATH).setAutoPlayAnimations(true).build());
        return;
    L57:
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // dx1.a
    public final void onViewCreated(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        this.a = (LargeCardReplaceViewGroup) r6.findViewById(2131382908);
        this.b = r6.findViewById(2131364117);
        this.c = r6.findViewById(2131374136);
        this.d = r6.findViewById(2131379806);
        this.e = (GridLayout) r6.findViewById(2131381607);
        this.i = (ViewGroup) r6.findViewById(2131382896);
        this.h = (TextView) r6.findViewById(2131383539);
        this.f = (TextView) r6.findViewById(2131372318);
        this.g = (ViewGroup) r6.findViewById(2131383538);
        this.j = (TextView) r6.findViewById(2131386885);
        Pair<Float, Float> r7 = com.bytedance.android.livesdk.feedback.c.a(0.57391304f, UtilityKotlinExtentionsKt.h(316), UtilityKotlinExtentionsKt.h(100));
        ViewGroup r0 = this.i;
        Integer r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L6:
        if (r2 == null) goto L10;
        r2.width = (int) ((Number) r7.getFirst()).floatValue();
        r2.height = (int) ((Number) r7.getSecond()).floatValue();
        ViewGroup r8 = this.i;
        if (r8 == null) goto L10;
        r8.setLayoutParams(r2);
    L10:
        TextView r9 = this.j;
        int r3 = 8;
        if (r9 == null) goto L23;
        j5 r4 = (j5) this.q.getValue();
        if (r4 == null) goto L15;
        Integer r5 = r4.guideVisible;
    L16:
        if (r5 != null) goto L19;
    L21:
        int r10 = 8;
    L22:
        r9.setVisibility(r10);
        goto L23
    L19:
        if (r5.intValue() != 1) goto L21;
        r10 = 0;
        goto L22
    L15:
        r5 = null;
    L23:
        ViewGroup r11 = this.g;
        if (r11 == null) goto L35;
        j5 r12 = (j5) this.q.getValue();
        if (r12 == null) goto L28;
        r1 = r12.titleVisible;
    L28:
        if (r1 != null) goto L31;
    L33:
        r11.setVisibility(r3);
        return;
    L31:
        if (r1.intValue() != 1) goto L33;
        r3 = 0;
        goto L33
    L35:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // dx1.a
    public final View a(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        return r3.inflate(2131566758, r4, false);
    }

    public LargeCardPreviewFeedback(Context r2, FeedbackContext r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "feedbackContext");
        Intrinsics.checkNotNullParameter(r4, "onSubmit");
        this.s = r2;
        this.t = r3;
        this.u = r4;
        this.n = LazyKt.lazy(new LargeCardPreviewFeedback$musicEntity$2(this));
        this.o = new b(this);
        this.p = LazyKt.lazy(new LargeCardPreviewFeedback$optionFactory$2(this));
        this.q = LazyKt.lazy(LargeCardPreviewFeedback$mFeedbackConfig$2.INSTANCE);
        this.r = LazyKt.lazy(LargeCardPreviewFeedback$feedbackService$2.INSTANCE);
    }
}
