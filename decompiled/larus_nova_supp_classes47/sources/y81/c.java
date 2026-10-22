package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.message.x0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class c extends y81.b {
    public static final /* synthetic */ int M = 0;
    public TextSwitcher A;
    public TextSwitcher B;
    public TextSwitcher C;
    public TextSwitcher D;
    public TextSwitcher E;
    public TextSwitcher F;
    public TextView G;
    public TextSwitcher H;
    public String I;
    public List<TextSwitcher> J;
    public Disposable K;
    public final CompositeDisposable L;
    public final int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public ViewGroup p;
    public ViewGroup q;
    public ViewGroup r;
    public ViewGroup s;
    public HSImageView t;
    public RelativeLayout u;
    public View v;
    public LottieAnimationView w;
    public ValueAnimator x;
    public ValueAnimator y;
    public ValueAnimator z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            c r4 = (c) r3;
            List<TextSwitcher> r5 = this.a.J;
            if (r5 == null) goto L18;
            Iterator<T> r6 = r5.iterator();
        L6:
            if (r6.hasNext() == false) goto L18;
            TextSwitcher r0 = (TextSwitcher) r6.next();
            if (r0 == null) goto L10;
            View r1 = r0.getCurrentView();
        L12:
            if ((r1 instanceof TextView) == false) goto L6;
            View r2 = r0.getCurrentView();
            if (r2 == null) goto L17;
            ((TextView) r2).setTextColor(s1.h(2131107305));
            goto L6
        L17:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        L10:
            r1 = null;
        L18:
            TextView r7 = this.a.G;
            if (r7 == null) goto L28;
            r7.setTextColor(s1.h(2131108314));
            return;
        }
    }

    /* JADX INFO: renamed from: y81.c$c, reason: collision with other inner class name */
    public static final class C0350c<T> implements Consumer {
        public final /* synthetic */ c a;

        public C0350c(c r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            c r4 = (c) r3;
            c r5 = this.a;
            if (r5.l != 2) goto L22;
            ViewGroup r6 = r5.s;
            if (r6 != null) goto L7;
        L11:
            TextSwitcher r7 = this.a.H;
            if (r7 != null) goto L14;
        L18:
            TextSwitcher r8 = this.a.H;
            if (r8 == null) goto L23;
            r8.setCurrentText(s1.B(2131916256));
            return;
        L23:
            return;
        L14:
            if (r7.getVisibility() != 8) goto L18;
            TextSwitcher r9 = this.a.H;
            if (r9 == null) goto L18;
            r9.setVisibility(0);
            goto L18
        L7:
            if (r6.getVisibility() != 0) goto L11;
            ViewGroup r10 = this.a.s;
            if (r10 == null) goto L11;
            r10.setVisibility(8);
            goto L11
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ c a;

        public d(c r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            c r9 = (c) r8;
            c r10 = this.a;
            if (r10.l == 2) goto L5;
        L35:
            this.a.i(0);
            return;
        L5:
            if (r10.c == false) goto L35;
            if (r10.g.getVisibility() != 0) goto L35;
            c r12 = this.a;
            ValueAnimator r0 = r12.x;
            if (r0 == null) goto L11;
            r0.cancel();
        L11:
            ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            r12.x = r1;
            if (r1 == null) goto L14;
            r1.addListener(new y81.d(r12));
            r1.addUpdateListener(new y81.e(r1, r12));
            r1.setStartDelay(200);
            r1.setDuration(500);
        L14:
            ValueAnimator r2 = r12.x;
            if (r2 == null) goto L17;
            r2.start();
        L17:
            ValueAnimator r3 = r12.z;
            if (r3 == null) goto L20;
            r3.cancel();
        L20:
            ValueAnimator r4 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#80000000")), Integer.valueOf(ColorProtector.parseColor("#26000000"))});
            r12.z = r4;
            if (r4 == null) goto L23;
            r4.addListener(new y81.f(r12));
            r4.addUpdateListener(new y81.g(r4, r12));
            r4.setStartDelay(200);
            r4.setDuration(300);
        L23:
            ValueAnimator r5 = r12.z;
            if (r5 == null) goto L26;
            r5.start();
        L26:
            ValueAnimator r6 = r12.y;
            if (r6 == null) goto L29;
            r6.cancel();
        L29:
            ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            r12.y = r7;
            if (r7 == null) goto L32;
            r7.addListener(new y81.h(r12));
            r7.addUpdateListener(new y81.i(r7, r12));
            r7.setDuration(200);
        L32:
            ValueAnimator r13 = r12.y;
            if (r13 == null) goto L37;
            r13.start();
            return;
        }
    }

    public static final class e extends AnimatorListenerAdapter {
        public final /* synthetic */ c a;

        public e(c r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            ViewGroup r4 = this.a.q;
            if (r4 == null) goto L6;
            ViewGroup.LayoutParams r0 = r4.getLayoutParams();
            r0.width = (int) UtilityKotlinExtentionsKt.h(52);
            r4.setLayoutParams(r0);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            ViewGroup r5 = this.a.q;
            if (r5 == null) goto L5;
            r5.setVisibility(0);
        L5:
            this.a.j();
            c r6 = this.a;
            if (r6.l != 1) goto L12;
            TextSwitcher r7 = r6.H;
            if (r7 == null) goto L10;
            r7.setCurrentText(s1.B(2131916257));
        L10:
            c r8 = this.a;
            r8.r(r8.r, 0.0f);
            c r9 = this.a;
            c.k(r9, r9.q, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#26000000"));
            return;
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ c b;

        public f(ValueAnimator r1, c r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "<anonymous parameter 0>");
            Object r5 = this.a.getAnimatedValue();
            if (r5 == null) goto L9;
            float r6 = ((Float) r5).floatValue();
            ViewGroup r0 = this.b.q;
            if (r0 == null) goto L10;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            r1.width = (int) (UtilityKotlinExtentionsKt.h(52) * r6);
            r0.setLayoutParams(r1);
            return;
        L10:
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ c a;

        public g(c r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            c r7 = this.a;
            tlc.d r0 = r7.e;
            String r2 = null;
            if ((r0 instanceof x0) == true) goto L5;
            r0 = null;
        L5:
            x0 r1 = (x0) r0;
            HashMap r3 = new HashMap();
            r3.put("biz_type", "4");
            int r4 = x81.c.a;
            DataCenter r8 = r7.f;
            if (r1 == null) goto L8;
            r2 = r1.getExtra();
        L8:
            x81.c.a("livesdk_new_anchor_support_plan_click", r8, r2, r3);
        }
    }

    public static final class h extends AnimatorListenerAdapter {
        public final /* synthetic */ c a;

        public h(c r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            c r5 = this.a;
            c.k(r5, r5.q, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#80ff356f"));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            c r5 = this.a;
            c.k(r5, r5.q, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#26000000"));
        }
    }

    public static final class i implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ c b;

        public i(ValueAnimator r1, c r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Object r5 = this.a.getAnimatedValue();
            if (r5 == null) goto L7;
            int r6 = ((Integer) r5).intValue();
            c r0 = this.b;
            c.k(r0, r0.q, ColorProtector.parseColor("#26000000"), r6);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class j extends AnimatorListenerAdapter {
        public final /* synthetic */ c a;

        public j(c r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            c r4 = this.a;
            r4.r(r4.r, 1.0f);
            c r5 = this.a;
            r5.o = false;
            r5.k = 1;
            r5.h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r7) {
            Intrinsics.checkNotNullParameter(r7, "animation");
            c r8 = this.a;
            r8.o = false;
            r8.k = 1;
            LottieAnimationView r2 = r8.w;
            if (r2 == null) goto L5;
            r2.setVisibility(0);
        L5:
            LottieAnimationView r3 = r8.w;
            if (r3 == null) goto L8;
            r3.addAnimatorListener(new y81.j(r3, r8));
            r3.setAnimation("rank_indicator_sweep.json");
            r3.setImageAssetsFolder("rank_indicator/");
            r3.loop(false);
        L8:
            r8.K = ((ObservableSubscribeProxy) du2.a.b(0, 1, TimeUnit.MINUTES).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r8.g))).subscribe(new y81.k(r8), RxUtil.getNoOpThrowable());
            c r9 = this.a;
            if (r9.l != 1) goto L16;
            TextSwitcher r10 = r9.H;
            if (r10 == null) goto L13;
            r10.setCurrentText(s1.B(2131916257));
        L13:
            c r12 = this.a;
            int r0 = r12.m;
            if (r0 <= 0) goto L16;
            r12.o(r0);
        L16:
            this.a.h();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ViewGroup r4 = this.a.r;
            if (r4 == null) goto L5;
            r4.setVisibility(0);
        L5:
            c r5 = this.a;
            r5.r(r5.r, 0.0f);
        }
    }

    public static final class k implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ c b;

        public k(ValueAnimator r1, c r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            Object r4 = this.a.getAnimatedValue();
            if (r4 == null) goto L7;
            float r5 = ((Float) r4).floatValue();
            c r0 = this.b;
            r0.r(r0.r, r5);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
    }

    public final void l() {
        i(1);
        Disposable r0 = this.K;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.L.clear();
        LottieAnimationView r1 = this.w;
        if (r1 == null) goto L8;
        r1.cancelAnimation();
    L8:
        LottieAnimationView r2 = this.w;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        CompositeDisposable r3 = this.L;
        Observable r4 = Observable.just(this);
        TimeUnit r5 = TimeUnit.MILLISECONDS;
        r3.add(r4.delay(300, r5).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), RxUtil.getNoOpThrowable()));
        this.L.add(Observable.just(this).delay(5000, r5).compose(RxUtil.rxSchedulerHelper()).subscribe(new C0350c(this), RxUtil.getNoOpThrowable()));
        this.L.add(Observable.just(this).delay(9000, r5).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this), RxUtil.getNoOpThrowable()));
    }

    public final void m() {
        this.o = true;
        ValueAnimator r0 = this.z;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        ValueAnimator r1 = this.x;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.L.clear();
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.x = r2;
        if (r2 == null) goto L14;
        r2.addListener(new e(this));
        r2.addUpdateListener(new f(r2, this));
        if (this.c == true) goto L13;
        r2.setDuration(0);
        goto L14
    L13:
        r2.setDuration(500);
    L14:
        ValueAnimator r3 = this.x;
        if (r3 == null) goto L17;
        r3.start();
    L17:
        p();
    }

    public final void q() {
        this.n = -1;
        this.m = 0;
        this.I = null;
        ValueAnimator r2 = this.z;
        if (r2 == null) goto L5;
        r2.cancel();
    L5:
        ValueAnimator r3 = this.x;
        if (r3 == null) goto L8;
        r3.cancel();
    L8:
        this.l = 1;
        this.k = 0;
        TextSwitcher r4 = this.H;
        if (r4 == null) goto L11;
        r4.setCurrentText("");
    L11:
        ViewGroup r5 = this.q;
        if (r5 == null) goto L14;
        r5.setVisibility(8);
    L14:
        j();
        Disposable r6 = this.K;
        if (r6 == null) goto L17;
        r6.dispose();
    L17:
        this.L.clear();
        LottieAnimationView r7 = this.w;
        if (r7 == null) goto L20;
        r7.setVisibility(8);
    L20:
        List<TextSwitcher> r8 = this.J;
        if (r8 == null) goto L36;
        Iterator<T> r9 = r8.iterator();
    L24:
        if (r9.hasNext() == false) goto L36;
        TextSwitcher r10 = (TextSwitcher) r9.next();
        if (r10 == null) goto L28;
        View r12 = r10.getCurrentView();
    L30:
        if ((r12 instanceof TextView) == false) goto L24;
        View r13 = r10.getCurrentView();
        if (r13 == null) goto L35;
        ((TextView) r13).setTextColor(s1.h(2131101254));
        goto L24
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L28:
        r12 = null;
    L36:
        TextView r1 = this.G;
        if (r1 == null) goto L39;
        r1.setTextColor(s1.h(2131101254));
    L39:
        ViewGroup r14 = this.s;
        if (r14 != null) goto L42;
    L46:
        TextSwitcher r15 = this.H;
        if (r15 != null) goto L49;
        return;
    L49:
        if (r15.getVisibility() != 8) goto L61;
        TextSwitcher r16 = this.H;
        if (r16 == null) goto L62;
        r16.setVisibility(0);
        return;
    L62:
        return;
    L61:
        return;
    L42:
        if (r14.getVisibility() != 0) goto L46;
        ViewGroup r17 = this.s;
        if (r17 == null) goto L46;
        r17.setVisibility(8);
        goto L46
    }

    @Override // u81.d
    public final com.bytedance.android.live.room.incentiveinfo.c c() {
        return new com.bytedance.android.live.room.incentiveinfo.c();
    }

    @Override // u81.d
    public final v81.b e() {
        return new v81.b();
    }

    @Override // u81.d
    public final void onInit() {
        View r0 = this.h;
        TextView r1 = null;
        if (r0 == null) goto L5;
        ViewGroup r2 = (ViewGroup) r0.findViewById(2131381482);
    L6:
        this.p = r2;
        View r3 = this.h;
        if (r3 == null) goto L9;
        ViewGroup r4 = (ViewGroup) r3.findViewById(2131370089);
    L10:
        this.q = r4;
        View r5 = this.g;
        if (r5 == null) goto L13;
        ViewGroup r6 = (ViewGroup) r5.findViewById(2131362539);
    L14:
        this.r = r6;
        View r7 = this.g;
        if (r7 == null) goto L17;
        ViewGroup r8 = (ViewGroup) r7.findViewById(2131368530);
    L18:
        this.s = r8;
        View r9 = this.h;
        if (r9 == null) goto L21;
        LottieAnimationView r10 = (LottieAnimationView) r9.findViewById(2131387807);
    L22:
        this.w = r10;
        View r12 = this.g;
        if (r12 == null) goto L25;
        HSImageView r13 = (HSImageView) r12.findViewById(2131375233);
    L26:
        this.t = r13;
        View r14 = this.g;
        if (r14 == null) goto L29;
        View r15 = r14.findViewById(2131375231);
    L30:
        this.v = r15;
        View r16 = this.h;
        if (r16 == null) goto L33;
        RelativeLayout r17 = (RelativeLayout) r16.findViewById(2131381481);
    L34:
        this.u = r17;
        View r18 = this.h;
        if (r18 == null) goto L37;
        StrokeTextView r19 = r18.findViewById(2131381480);
    L37:
        View r20 = this.g;
        if (r20 == null) goto L40;
        TextSwitcher r22 = (TextSwitcher) r20.findViewById(2131382495);
    L41:
        this.F = r22;
        View r23 = this.g;
        if (r23 == null) goto L44;
        TextSwitcher r24 = (TextSwitcher) r23.findViewById(2131364256);
    L45:
        this.B = r24;
        View r25 = this.g;
        if (r25 == null) goto L48;
        TextSwitcher r26 = (TextSwitcher) r25.findViewById(2131368623);
    L49:
        this.C = r26;
        View r27 = this.g;
        if (r27 == null) goto L52;
        TextSwitcher r28 = (TextSwitcher) r27.findViewById(2131374633);
    L53:
        this.D = r28;
        View r29 = this.g;
        if (r29 == null) goto L56;
        TextSwitcher r30 = (TextSwitcher) r29.findViewById(2131388580);
    L57:
        this.E = r30;
        View r32 = this.g;
        if (r32 == null) goto L60;
        TextSwitcher r33 = (TextSwitcher) r32.findViewById(2131391875);
    L61:
        this.A = r33;
        View r34 = this.g;
        if (r34 == null) goto L64;
        TextSwitcher r35 = (TextSwitcher) r34.findViewById(2131375285);
    L65:
        this.H = r35;
        View r36 = this.g;
        if (r36 == null) goto L68;
        r1 = (TextView) r36.findViewById(2131382745);
    L68:
        this.G = r1;
        this.J = CollectionsKt.mutableListOf(new TextSwitcher[]{this.A, this.B, this.C, this.D, this.E, this.F});
        q();
        ViewGroup r37 = this.r;
        if (r37 == null) goto L72;
        r37.setOnClickListener(new g(this));
        return;
    L72:
        return;
    L64:
        r35 = null;
        goto L65
    L60:
        r33 = null;
        goto L61
    L56:
        r30 = null;
        goto L57
    L52:
        r28 = null;
        goto L53
    L48:
        r26 = null;
        goto L49
    L44:
        r24 = null;
        goto L45
    L40:
        r22 = null;
        goto L41
    L33:
        r17 = null;
        goto L34
    L29:
        r15 = null;
        goto L30
    L25:
        r13 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void p() {
        ValueAnimator r0 = this.z;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.L.clear();
        ValueAnimator r1 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#26000000")), Integer.valueOf(ColorProtector.parseColor("#80ff356f"))});
        this.z = r1;
        if (r1 == null) goto L11;
        r1.addListener(new h(this));
        r1.addUpdateListener(new i(r1, this));
        if (this.c == true) goto L10;
        r1.setStartDelay(0);
        r1.setDuration(0);
        goto L11
    L10:
        r1.setStartDelay(200);
        r1.setDuration(300);
    L11:
        ValueAnimator r2 = this.z;
        if (r2 == null) goto L14;
        r2.start();
    L14:
        List<TextSwitcher> r3 = this.J;
        if (r3 == null) goto L30;
        Iterator<T> r4 = r3.iterator();
    L18:
        if (r4.hasNext() == false) goto L30;
        TextSwitcher r5 = (TextSwitcher) r4.next();
        if (r5 == null) goto L22;
        View r6 = r5.getCurrentView();
    L24:
        if ((r6 instanceof TextView) == false) goto L18;
        View r7 = r5.getCurrentView();
        if (r7 == null) goto L29;
        ((TextView) r7).setTextColor(s1.h(2131101254));
        goto L18
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L22:
        r6 = null;
    L30:
        TextView r8 = this.G;
        if (r8 == null) goto L33;
        r8.setTextColor(s1.h(2131101254));
    L33:
        ValueAnimator r9 = this.y;
        if (r9 == null) goto L36;
        r9.cancel();
    L36:
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.y = r10;
        if (r10 == null) goto L39;
        r10.addListener(new j(this));
        r10.addUpdateListener(new k(r10, this));
        r10.setStartDelay(500);
        r10.setDuration(200);
    L39:
        ValueAnimator r12 = this.y;
        if (r12 == null) goto L49;
        r12.start();
        return;
    }

    @Override // y81.b, u81.d
    public final void onDestroy() {
        super.onDestroy();
        this.L.clear();
        Disposable r0 = this.K;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        LottieAnimationView r1 = this.w;
        if (r1 == null) goto L8;
        r1.cancelAnimation();
    L8:
        ValueAnimator r2 = this.x;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        ValueAnimator r3 = this.y;
        if (r3 == null) goto L14;
        r3.cancel();
    L14:
        ValueAnimator r4 = this.z;
        if (r4 == null) goto L17;
        r4.cancel();
    L17:
        q();
    }

    @Override // u81.d
    public final int getItemType() {
        return this.j;
    }

    @Override // u81.d
    public final void f(String r2) {
        this.d = r2;
        if (r2 == null) goto L6;
        ImageLoader.bindImage(this.t, r2);
        return;
    }

    @Override // u81.d
    public void g(w81.a r7) {
        Long r0 = null;
        if (r7 == null) goto L5;
        tlc.d r1 = r7.a;
    L6:
        this.e = r1;
        if (r7 == null) goto L9;
        tlc.d r2 = r7.a;
    L11:
        if ((r2 instanceof x0) == true) goto L13;
        r2 = null;
    L13:
        x0 r3 = (x0) r2;
        StringBuilder r4 = new StringBuilder("process holder binding, status: ");
        if (r3 == null) goto L16;
        r0 = r3.getStatus();
    L16:
        r4.append(r0);
        r4.append(", curStatus: ");
        r4.append(this.l);
        r4.append(", showStatus: ");
        r4.append(this.k);
        ALogger.d("CommonIncentiveHolder", r4.toString());
        if (r3 != null) goto L19;
        return;
    L19:
        Boolean r8 = r7.b;
        if (r8 == null) goto L22;
        boolean r9 = r8.booleanValue();
    L23:
        this.c = r9;
        Long r10 = r3.getStatus();
        if (r10 != null) goto L26;
    L36:
        Long r12 = r3.getStatus();
        if (r12 != null) goto L39;
    L48:
        Long r13 = r3.getStatus();
        int r5 = 0;
        if (r13 != null) goto L51;
    L64:
        i(0);
        return;
    L51:
        if (((int) r13.longValue()) != 1) goto L64;
        if (this.k != 1) goto L64;
        Long r14 = r3.getNumber();
        if (r14 == null) goto L58;
        this.m = (int) r14.longValue();
    L58:
        if (this.l != 2) goto L60;
        this.l = 1;
        p();
    L60:
        Long r15 = r3.getNumber();
        if (r15 == null) goto L63;
        r5 = (int) r15.longValue();
    L63:
        n(r5);
        this.l = 1;
        return;
    L39:
        if (((int) r12.longValue()) != 2) goto L48;
        if (this.k != 1) goto L48;
        this.l = 2;
        Long r16 = r3.getNumber();
        if (r16 == null) goto L47;
        int r17 = (int) r16.longValue();
        if (r17 <= this.m) goto L47;
        this.m = r17;
    L47:
        n(this.m);
        l();
        return;
    L26:
        if (((int) r10.longValue()) != 1) goto L36;
        if (this.k != 0) goto L36;
        if (this.o == true) goto L36;
        this.l = 1;
        m();
        Long r18 = r3.getNumber();
        if (r18 == null) goto L66;
        int r19 = (int) r18.longValue();
        if (r19 <= 0) goto L67;
        this.m = r19;
        return;
    L67:
        return;
    L66:
        return;
    L22:
        r9 = true;
        goto L23
    L9:
        r2 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public final void n(int r3) {
        if (r3 <= 0) goto L4;
        o(r3);
        return;
    L4:
        String r4 = s1.B(2131916257);
        ViewGroup r0 = this.s;
        if (r0 != null) goto L7;
    L11:
        TextSwitcher r1 = this.H;
        if (r1 != null) goto L14;
    L18:
        TextSwitcher r2 = this.H;
        if (r2 == null) goto L23;
        r2.setCurrentText(r4);
        return;
    L23:
        return;
    L14:
        if (r1.getVisibility() != 8) goto L18;
        TextSwitcher r5 = this.H;
        if (r5 == null) goto L18;
        r5.setVisibility(0);
        goto L18
    L7:
        if (r0.getVisibility() != 0) goto L11;
        ViewGroup r6 = this.s;
        if (r6 == null) goto L11;
        r6.setVisibility(8);
        goto L11
    }

    public final void o(int r7) {
        ViewGroup r0 = this.s;
        if (r0 != null) goto L5;
    L9:
        TextSwitcher r1 = this.H;
        if (r1 == null) goto L20;
        if (r1.getVisibility() != 0) goto L20;
        TextSwitcher r2 = this.H;
        if (r2 == null) goto L16;
        r2.setVisibility(8);
    L16:
        TextSwitcher r3 = this.H;
        if (r3 == null) goto L20;
        r3.setCurrentText("");
    L20:
        if (TextUtils.equals("+", this.I) == true) goto L26;
        TextSwitcher r4 = this.F;
        if (r4 == null) goto L24;
        r4.setText("+");
    L24:
        this.I = "+";
    L26:
        if (r7 < 10000) goto L56;
        TextView r5 = this.G;
        if (r5 == null) goto L30;
        r5.setVisibility(0);
    L30:
        TextSwitcher r6 = this.A;
        if (r6 != null) goto L33;
    L37:
        TextSwitcher r8 = this.A;
        if (r8 == null) goto L41;
        r8.setText("万");
    L41:
        if (r7 < 10000000) goto L43;
        r7 = 9999000;
    L43:
        if (r7 < 100000) goto L53;
        Integer r9 = (Integer) com.bytedance.android.live.core.setting.k0.a.getValue();
        if (r9 == null) goto L53;
        if (r9.intValue() != 1) goto L53;
        TextSwitcher r10 = this.A;
        if (r10 == null) goto L52;
        r10.setText("万+");
    L52:
        r7 = 100000;
    L53:
        int r12 = r7 / WebcastRedirectException.UNKNOWN;
        if ((r7 % WebcastRedirectException.UNKNOWN) < 500) goto L66;
        r12 = r12 + 1;
    L66:
        if (r7 < 100000) goto L78;
        Integer r13 = (Integer) com.bytedance.android.live.core.setting.k0.a.getValue();
        if (r13 == null) goto L78;
        if (r13.intValue() != 1) goto L78;
        TextView r14 = this.G;
        if (r14 == null) goto L75;
        r14.setVisibility(8);
    L75:
        TextSwitcher r15 = this.B;
        if (r15 == null) goto L79;
        r15.setVisibility(8);
    L79:
        s(this.C, r12, 10);
        s(this.D, r12, 100);
        s(this.E, r12, WebcastRedirectException.UNKNOWN);
        this.n = r12;
        return;
    L78:
        s(this.B, r12, 1);
        goto L79
    L33:
        if (r6.getVisibility() != 8) goto L37;
        TextSwitcher r16 = this.A;
        if (r16 == null) goto L37;
        r16.setVisibility(0);
        goto L37
    L56:
        TextView r17 = this.G;
        if (r17 == null) goto L59;
        r17.setVisibility(8);
    L59:
        TextSwitcher r18 = this.A;
        if (r18 == null) goto L62;
        r18.setText("");
    L62:
        TextSwitcher r19 = this.A;
        if (r19 == null) goto L65;
        r19.setVisibility(8);
    L65:
        r12 = r7;
        goto L66
    L5:
        if (r0.getVisibility() != 8) goto L9;
        ViewGroup r20 = this.s;
        if (r20 == null) goto L9;
        r20.setVisibility(0);
        goto L9
    }

    public final void r(View r4, float r5) {
        if ((r4 instanceof ViewGroup) == false) goto L8;
        ViewGroup r6 = (ViewGroup) r4;
        int r0 = r6.getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        r(r6.getChildAt(r1), r5);
        r1 = r1 + 1;
        goto L5
    L13:
        return;
    L8:
        if ((r4 instanceof View) == false) goto L12;
        r4.setAlpha(r5);
        return;
    }

    public final void s(TextSwitcher r4, int r5, int r6) {
        if (r4 == null) goto L19;
        int r0 = this.n;
        if (r0 == (-1)) goto L7;
        r0 = (r0 / r6) % 10;
    L7:
        int r1 = (r5 / r6) % 10;
        if (r1 != 0) goto L14;
        if (r5 >= (r6 * 10)) goto L14;
        r4.setText("");
        r4.setVisibility(8);
        return;
    L14:
        if (r4.getVisibility() != 8) goto L16;
        r4.setVisibility(0);
    L16:
        if (r1 == r0) goto L21;
        r4.setText(String.valueOf(r1));
        return;
    L21:
        return;
    }

    public c(DataCenter r2, View r3, int r4, View r5) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r5, "parentView");
        super(r2, r3, r5);
        this.j = r4;
        this.l = 1;
        this.n = -1;
        this.L = new CompositeDisposable();
    }

    public static final void k(c r1, ViewGroup r2, int r3, int r4) {
        r1.getClass();
        Drawable r5 = null;
        if (r2 == null) goto L5;
        Drawable r0 = r2.getBackground();
    L7:
        if ((r0 instanceof GradientDrawable) == false) goto L14;
        if (r2 == null) goto L10;
        r5 = r2.getBackground();
    L10:
        GradientDrawable r6 = (GradientDrawable) r5;
        if (r6 == null) goto L15;
        r6.setColors(new int[]{r3, r4});
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r0 = null;
        goto L7
    }
}
