package com.bytedance.android.livesdk.feedback.view.feedback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.feedback.Question;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.config.j5;
import com.bytedance.android.livesdk.config.u4;
import com.bytedance.android.livesdk.feedback.FeedbackContext;
import com.bytedance.android.livesdk.feedback.api.IFeedbackApi;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class GlobalQuestionFeedback implements dx1.a {
    public ViewGroup a;
    public ViewGroup b;
    public ViewGroup c;
    public SimpleDraweeView d;
    public SimpleDraweeView e;
    public SimpleMediaView f;
    public TextView g;
    public TextView h;
    public FeedbackCard i;
    public List<Question> j;
    public nx1.a k;
    public nx1.a l;
    public boolean m;
    public boolean n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final b s;
    public final Context t;
    public final FeedbackContext u;
    public final Function0<Unit> v;

    public static final class a implements Runnable {
        public final /* synthetic */ GlobalQuestionFeedback a;

        public a(GlobalQuestionFeedback r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GlobalQuestionFeedback r0 = this.a;     // Catch: Throwable -> L14
            ViewGroup r1 = r0.c;     // Catch: Throwable -> L14
            float r2 = 0.0f;
            if (r1 == null) goto L8;
            if (r1 == null) goto L6;
            float r3 = r0.e() - r1.getY();     // Catch: Throwable -> L14
        L7:
            r1.setTranslationY(r3);     // Catch: Throwable -> L14
            goto L8
        L6:
            r3 = 0.0f;
        L8:
            GlobalQuestionFeedback r4 = this.a;     // Catch: Throwable -> L14
            ViewGroup r5 = r4.a;     // Catch: Throwable -> L14
            if (r5 == null) goto L17;
            if (r5 == null) goto L12;
            r2 = ((r4.e() * 2) + UtilityKotlinExtentionsKt.h(24)) - r5.getY();     // Catch: Throwable -> L14
        L12:
            r5.setTranslationY(r2);     // Catch: Throwable -> L14
            return;
        L17:
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ GlobalQuestionFeedback a;

        public static final class a<T> implements Consumer {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Response r2 = (Response) r1;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.feedback.view.feedback.GlobalQuestionFeedback$b$b, reason: collision with other inner class name */
        public static final class C0348b<T> implements Consumer {
            public static final C0348b a = null;

            static {
                a = new C0348b();
            }

            public C0348b() {
            }

            public final void accept(Object r2) {
                Throwable r3 = (Throwable) r2;
                ALogger.d("FeedbackSubmitError", "GlobalQuestion");
            }
        }

        public b(GlobalQuestionFeedback r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r25) {
            ArrayList r1 = new ArrayList();
            nx1.a r2 = this.a.k;
            if (r2 == null) goto L5;
            r1.add(r2.getSelectResult());
        L5:
            nx1.a r3 = this.a.l;
            if (r3 == null) goto L8;
            r1.add(r3.getSelectResult());
        L8:
            String r15 = CollectionsKt.joinToString$default(r1, ",", null, null, 0, null, null, 62, null);
            IFeedbackApi r10 = (IFeedbackApi) com.bytedance.android.live.network.c.b().e(IFeedbackApi.class);
            FeedbackCard r4 = this.a.i;
            if (r4 == null) goto L13;
            Long r5 = r4.feedbackId;
            if (r5 == null) goto L13;
            long r11 = r5.longValue();
        L14:
            FeedbackCard r6 = this.a.i;
            if (r6 == null) goto L19;
            Long r7 = r6.roomId;
            if (r7 == null) goto L19;
            long r13 = r7.longValue();
        L20:
            String r8 = this.a.u.getReqId();
            if (r8 != null) goto L23;
            String r16 = "";
        L24:
            String r9 = this.a.u.getEnterFromMerge();
            if (r9 != null) goto L27;
            String r17 = "";
        L28:
            String r12 = this.a.u.getEnterMethod();
            if (r12 != null) goto L31;
            String r18 = "";
        L32:
            String r14 = this.a.u.getReqId();
            if (r14 != null) goto L35;
            String r20 = "";
        L36:
            ILiveFeedbackService r19 = (ILiveFeedbackService) this.a.r.getValue();
            if (r19 == null) goto L42;
            String r21 = r19.getRecentRoomIds();
            if (r21 == null) goto L42;
            String r22 = r21;
        L43:
            IFeedbackApi.CC.feedbackRequest$default(r10, r11, r13, r15, r16, r17, r18, null, r20, r22, 64, null).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(a.a, C0348b.a);
            this.a.v.invoke();
            GlobalQuestionFeedback r23 = this.a;
            nx1.a r24 = r23.l;
            if (r24 != null) goto L46;
            r24 = r23.k;
        L46:
            if (r24 == null) goto L49;
            String r26 = r24.getSelectToast();
            if (r26 == null) goto L49;
        L50:
            f2.c(r26, 0);
            return;
        L49:
            r26 = s1.B(2131919107);
        L42:
            r22 = "";
            goto L43
        L35:
            r20 = r14;
            goto L36
        L31:
            r18 = r12;
            goto L32
        L27:
            r17 = r9;
            goto L28
        L23:
            r16 = r8;
        L19:
            r13 = 0;
        L13:
            r11 = 0;
            goto L14
        }
    }

    @Override // dx1.a
    public final /* synthetic */ void b() {
    }

    @Override // dx1.a
    public final /* synthetic */ void onDestroy() {
    }

    public final boolean d() {
        Integer r0 = u4.a.getValue().disableSubmitButton;
        if (r0 != null) goto L6;
    L12:
        return false;
    L6:
        if (r0.intValue() != 1) goto L12;
        List<Question> r1 = this.j;
        if (r1 == null) goto L12;
        if (r1.size() != 1) goto L12;
        return true;
    }

    public final void f() {
        if (this.k != null) goto L5;
    L11:
        boolean r0 = false;
    L12:
        if (r0 == false) goto L22;
        TextView r1 = this.h;
        if (r1 == null) goto L16;
        r1.setClickable(true);
    L16:
        TextView r2 = this.h;
        if (r2 == null) goto L19;
        r2.setTextColor(s1.h(2131107481));
    L19:
        TextView r3 = this.h;
        if (r3 == null) goto L32;
        r3.setBackgroundResource(2131249132);
        return;
    L32:
        return;
    L22:
        TextView r4 = this.h;
        if (r4 == null) goto L25;
        r4.setClickable(false);
    L25:
        TextView r5 = this.h;
        if (r5 == null) goto L28;
        r5.setTextColor(s1.h(2131107482));
    L28:
        TextView r6 = this.h;
        if (r6 == null) goto L34;
        r6.setBackgroundResource(2131249131);
        return;
    L34:
        return;
    L5:
        if (this.m == false) goto L11;
        if (this.l != null) goto L9;
    L10:
        r0 = true;
        goto L12
    L9:
        if (this.n == false) goto L11;
        goto L10
    }

    @Override // dx1.a
    public final void onSlide() {
        nx1.a r0 = this.k;
        if (r0 == null) goto L5;
        r0.reset();
    L5:
        this.m = false;
        nx1.a r1 = this.l;
        if (r1 == null) goto L8;
        r1.reset();
    L8:
        this.n = false;
        f();
    }

    @Override // dx1.a
    public final void startRoom() {
        if (((tic.a) this.o.getValue()) != null) goto L21;
        return;
    L21:
        SimpleMediaView r0 = this.f;     // Catch: Exception -> L19
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.h() == false) goto L10;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == true) goto L16;
        r0 = null;
    L16:
        if (r0 == null) goto L24;
        r0.setPlayEntity((tic.a) this.o.getValue());     // Catch: Exception -> L19
        r0.k();     // Catch: Exception -> L19
        r0.setLoop(true);     // Catch: Exception -> L19
        return;
    L24:
        return;
    L10:
        if (((tic.a) this.o.getValue()) == null) goto L12;
        r1 = true;
    L19:
        ALogger.d("FeedbackMediaPlayError", "GlobalQuestion");
    }

    @Override // dx1.a
    public final void stopRoom() {
        SimpleMediaView r0 = this.f;
        if (r0 == null) goto L6;
        r0.m();
        return;
    }

    public final int e() {
        int r0 = s1.w() - UtilityKotlinExtentionsKt.i(104);
        ViewGroup r1 = this.a;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.getHeight();
    L6:
        int r4 = r0 - r3;
        ViewGroup r5 = this.b;
        if (r5 == null) goto L10;
        r2 = r5.getHeight();
    L10:
        return (r4 - r2) / 5;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // dx1.a
    public final void c(FeedbackCard r7) {
        if (r7 == null) goto L60;
        List r0 = r7.question;
        if (r0 == null) goto L61;
        nx1.a r3 = null;
        if ((!r0.isEmpty()) == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L62;
        Question r1 = (Question) ListProtector.get(r0, 0);
        if (r1 == null) goto L63;
        TextView r4 = this.g;
        if (r4 == null) goto L20;
        String r5 = r7.title;
        if (r5 != null) goto L19;
        r5 = s1.B(2131919102);
    L19:
        r4.setText(r5);
    L20:
        this.i = r7;
        this.j = r7.question;
        SimpleDraweeView r8 = this.d;
        if (r8 == null) goto L23;
        r8.setController(Fresco.newDraweeControllerBuilder().setUri(FeedbackContext.FEEDBACK_FRAGMENT_BG).setAutoPlayAnimations(true).build());
    L23:
        SimpleDraweeView r9 = this.e;
        if (r9 == null) goto L26;
        r9.setController(Fresco.newDraweeControllerBuilder().setUri(FeedbackContext.FEEDBACK_FRAGMENT_SLIDE_PATH).setAutoPlayAnimations(true).build());
    L26:
        List<Question> r10 = this.j;
        if (r10 != null) goto L29;
    L31:
        boolean r11 = false;
    L32:
        if (r11 == false) goto L44;
        g(true);
        nx1.a r12 = com.bytedance.android.livesdk.feedback.c.b(r1, this.t, (mx1.b) this.q.getValue(), false);
        this.k = r12;
        if ((r12 instanceof View) == false) goto L37;
        r3 = r12;
    L37:
        if (r3 == null) goto L55;
        ViewGroup r13 = this.a;
        if (r13 == null) goto L41;
        r13.removeAllViews();
    L41:
        ViewGroup r14 = this.a;
        if (r14 == null) goto L55;
        r14.addView(r3);
    L55:
        ViewGroup r15 = this.a;
        if (r15 == null) goto L58;
        r15.post(new a(this));
    L58:
        f();
        return;
    L44:
        g(false);
        nx1.a r16 = com.bytedance.android.livesdk.feedback.c.b(r1, this.t, (mx1.b) this.q.getValue(), true);
        this.k = r16;
        if ((r16 instanceof View) == false) goto L48;
        r3 = r16;
    L48:
        if (r3 == null) goto L55;
        ViewGroup r17 = this.a;
        if (r17 == null) goto L52;
        r17.removeAllViews();
    L52:
        ViewGroup r18 = this.a;
        if (r18 == null) goto L55;
        r18.addView(r3);
        goto L55
    L29:
        if (r10.size() != 1) goto L31;
        r11 = true;
        goto L32
    L63:
        return;
    L62:
        return;
    L61:
        return;
    }

    public final void g(boolean r3) {
        int r1 = 4;
        if (d() == false) goto L8;
        TextView r4 = this.h;
        if (r4 == null) goto L14;
        r4.setVisibility(4);
        return;
    L14:
        return;
    L8:
        TextView r0 = this.h;
        if (r0 == null) goto L15;
        if (r3 == false) goto L12;
        r1 = 0;
    L12:
        r0.setVisibility(r1);
        return;
    }

    @Override // dx1.a
    public final void onViewCreated(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.h = (TextView) r5.findViewById(2131387573);
        this.a = (ViewGroup) r5.findViewById(2131383534);
        this.b = (ViewGroup) r5.findViewById(2131383535);
        this.c = (ViewGroup) r5.findViewById(2131383538);
        this.d = r5.findViewById(2131364117);
        this.e = r5.findViewById(2131374136);
        this.f = r5.findViewById(2131379806);
        this.g = (TextView) r5.findViewById(2131372318);
        TextView r0 = this.h;
        if (r0 == null) goto L5;
        r0.setOnClickListener(this.s);
    L5:
        TextView r6 = (TextView) r5.findViewById(2131386885);
        int r1 = 0;
        Integer r2 = null;
        if (r6 == null) goto L18;
        j5 r3 = (j5) this.p.getValue();
        if (r3 == null) goto L10;
        Integer r4 = r3.guideVisible;
    L11:
        if (r4 != null) goto L14;
    L16:
        int r7 = 8;
    L17:
        r6.setVisibility(r7);
        goto L18
    L14:
        if (r4.intValue() != 1) goto L16;
        r7 = 0;
        goto L17
    L10:
        r4 = null;
    L18:
        ViewGroup r8 = this.c;
        if (r8 == null) goto L31;
        j5 r9 = (j5) this.p.getValue();
        if (r9 == null) goto L23;
        r2 = r9.titleVisible;
    L23:
        if (r2 != null) goto L26;
    L28:
        r1 = 4;
    L29:
        r8.setVisibility(r1);
        return;
    L26:
        if (r2.intValue() != 1) goto L28;
    }

    @Override // dx1.a
    public final View a(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        return r3.inflate(2131566658, r4, false);
    }

    public GlobalQuestionFeedback(Context r2, FeedbackContext r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "feedbackContext");
        Intrinsics.checkNotNullParameter(r4, "onSubmit");
        this.t = r2;
        this.u = r3;
        this.v = r4;
        this.o = LazyKt.lazy(new GlobalQuestionFeedback$musicEntity$2(this));
        this.p = LazyKt.lazy(GlobalQuestionFeedback$mFeedbackConfig$2.INSTANCE);
        this.q = LazyKt.lazy(new GlobalQuestionFeedback$questionSelectListener$2(this));
        this.r = LazyKt.lazy(GlobalQuestionFeedback$feedbackService$2.INSTANCE);
        this.s = new b(this);
    }
}
