package com.bytedance.android.live.profit.scoreboard;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.revenue.service.ui.IRevFloatingBannerManager;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v implements com.bytedance.android.scope.o, i {
    public g a;
    public final yz0.k b;
    public final l c;
    public final IRevFloatingBannerManager d;
    public final com.bytedance.android.livesdk.revenue.service.broadcast.a e;

    public static final class a implements ScoreboardBannerView.c {
        public j80.d a;
        public final Rect b;
        public Pair<? extends RegionId, j80.d> c;
        public final d d;
        public final e<c> e;
        public final l f;

        @Override // com.bytedance.android.live.profit.scoreboard.ScoreboardBannerView.c
        public final void a() {
            this.f.d().a(Boolean.FALSE);
        }

        @Override // com.bytedance.android.live.profit.scoreboard.ScoreboardBannerView.c
        public final void onDragStart() {
            d r0 = this.d;
            if ((r0 instanceof f) == true) goto L5;
            r0 = null;
        L5:
            f r1 = (f) r0;
            if (r1 == null) goto L8;
            r1.c = j80.b.a(r1.e);
        L8:
            this.a = this.d.getPos();
            Iterator r2 = this.e.a.iterator();
        L10:
            if (r2.hasNext() == false) goto L12;
            c r3 = (c) r2.next();
            o1.b(r3.c, r3.a);
            goto L10
        L12:
            this.c = (Pair) this.f.x().a;
            this.f.d().a(Boolean.TRUE);
        }

        @Override // com.bytedance.android.live.profit.scoreboard.ScoreboardBannerView.c
        public final void b(j80.d r12) {
            Intrinsics.checkNotNullParameter(r12, "offset");
            this.a = j80.c.e(this.a, r12);
            this.d.b(this.b);
            Rect r13 = new Rect(this.b);
            j80.b.d(r13, j80.c.f(this.a));
            Rect r0 = this.b;
            Intrinsics.checkNotNullParameter(r0, "currentRect");
            Intrinsics.checkNotNullParameter(r13, "desiredRect");
            j80.e r1 = j80.c.c(j80.b.b(r13), j80.b.b(r0));
            float r2 = j80.c.d(j80.c.h(r1));
            e<c> r3 = this.e;
            r3.getClass();
            Intrinsics.checkNotNullParameter(r0, "rect");
            HashSet r4 = r3.a;
            ArrayList r5 = new ArrayList();
            Iterator r6 = r4.iterator();
        L4:
            if (r6.hasNext() == false) goto L8;
            Object r7 = r6.next();
            if (((e.a) r7).a().contains(r0) == false) goto L4;
            r5.add(r7);
            goto L4
        L8:
            Iterator r8 = r5.iterator();
            float r9 = Float.MIN_VALUE;
            Pair r10 = null;
        L10:
            if (r8.hasNext() == false) goto L17;
            c r14 = (c) r8.next();
            if (r14.a.contains(r13) == true) goto L13;
            Rect r15 = r14.b(r13);
            float r16 = j80.c.g(j80.c.c(j80.b.b(r15), j80.b.b(r0)), r1) / r2;
            if (r16 <= r9) goto L10;
            r10 = TuplesKt.to(r14, r15);
            r9 = r16;
            goto L10
        L13:
            r10 = TuplesKt.to(r14, new Rect(r13));
        L17:
            if (r10 != null) goto L37;
            j80.d r17 = j80.c.h(j80.b.b(r0));
            HashSet r18 = this.e.a;
            ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
            Iterator r20 = r18.iterator();
        L20:
            if (r20.hasNext() == false) goto L22;
            c r22 = (c) r20.next();
            r19.add(TuplesKt.to(r22, r22.b(r0)));
            goto L20
        L22:
            Iterator r23 = r19.iterator();
            if (r23.hasNext() == true) goto L25;
            Object r24 = null;
        L34:
            Pair r25 = (Pair) r24;
            if (r25 == null) goto L37;
            r10 = TuplesKt.to((c) r25.component1(), (Rect) r25.component2());
            goto L37
        L25:
            r24 = r23.next();
            if (r23.hasNext() == false) goto L34;
            float r26 = j80.c.a(r17, j80.c.h(j80.b.b((Rect) ((Pair) r24).component2())));
        L29:
            Object r27 = r23.next();
            float r28 = j80.c.a(r17, j80.c.h(j80.b.b((Rect) ((Pair) r27).component2())));
            if (Float.compare(r26, r28) <= 0) goto L33;
            r24 = r27;
            r26 = r28;
        L33:
            if (r23.hasNext() == true) goto L29;
        L37:
            if (r10 == null) goto L65;
            c r110 = (c) r10.component1();
            Rect r29 = (Rect) r10.component2();
            j80.d r30 = j80.c.h(j80.b.b(r29));
            r110.getClass();
            Intrinsics.checkNotNullParameter(r29, "objectRect");
            float r32 = r110.a.width() - r29.width();
            float r33 = r110.a.height() - r29.height();
            float r34 = 0.0f;
            if (r32 != 0.0f) goto L41;
            float r35 = 0.0f;
        L43:
            if (r33 == 0.0f) goto L46;
            r34 = (r29.top - r110.a.top) / r33;
        L46:
            j80.d r36 = new j80.d(r35, r34);
            this.d.a(r30);
            Pair r111 = TuplesKt.to(r110.b, r36);
            this.f.x().a(r111);
            Pair<? extends RegionId, j80.d> r37 = this.c;
            if (r37 == null) goto L49;
            this.f.j().onNext(TuplesKt.to(r37, r111));
        L49:
            this.c = null;
            return;
        L41:
            r35 = (r29.left - r110.a.left) / r32;
            goto L43
        }

        public a(d r2, e<c> r3, l r4) {
            Intrinsics.checkNotNullParameter(r2, "bannerView");
            Intrinsics.checkNotNullParameter(r3, "regionManager");
            Intrinsics.checkNotNullParameter(r4, "repository");
            this.d = r2;
            this.e = r3;
            this.f = r4;
            this.a = new j80.d(0.0f, 0.0f);
            this.b = new Rect();
        }
    }

    public static final class b {
    }

    public static final class c implements e.a {
        public final Rect a;
        public final RegionId b;
        public final View c;

        @Override // com.bytedance.android.live.profit.scoreboard.v.e.a
        public final Rect a() {
            return this.a;
        }

        public final Rect b(Rect r7) {
            Intrinsics.checkNotNullParameter(r7, "rect");
            Rect r0 = new Rect(r7);
            Rect r8 = this.a;
            int r1 = Math.max(0, r8.left - r0.left);
            int r3 = Math.min(0, r8.right - r0.right);
            r0.offset(r1 + r3, Math.max(0, r8.top - r0.top) + Math.min(0, r8.bottom - r0.bottom));
            return r0;
        }

        public c(RegionId r2, View r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "view");
            this.b = r2;
            this.c = r3;
            this.a = new Rect();
        }
    }

    public interface d {
        void a(j80.d r1);

        void b(Rect r1);

        j80.d getPos();
    }

    public static final class e<R extends a> {
        public final LinkedHashSet<R> a;

        public interface a {
            Rect a();
        }

        public e() {
            this.a = new LinkedHashSet();
        }
    }

    public static final class f implements d {
        public final float a;
        public final long b;
        public j80.d c;
        public a d;
        public final View e;

        public static final class a extends ValueAnimator {
            public j80.d a;
            public final View b;
            public final j80.d c;

            /* JADX INFO: renamed from: com.bytedance.android.live.profit.scoreboard.v$f$a$a, reason: collision with other inner class name */
            public static final class C0051a implements ValueAnimator.AnimatorUpdateListener {
                public final /* synthetic */ a a;

                public C0051a(a r1) {
                    this.a = r1;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator r6) {
                    Intrinsics.checkNotNullParameter(r6, "it");
                    a r7 = this.a;
                    j80.d r8 = j80.c.b(r7.a, r7.c);
                    a r0 = this.a;
                    View r1 = r0.b;
                    j80.d r2 = r0.c;
                    float r3 = r0.getAnimatedFraction();
                    Intrinsics.checkNotNullParameter(r8, "$this$times");
                    j80.b.e(r1, j80.c.e(r2, new j80.d(r8.a().floatValue() * r3, r8.b().floatValue() * r3)));
                }
            }

            public a(View r2, j80.d r3, long r4) {
                Intrinsics.checkNotNullParameter(r2, "view");
                Intrinsics.checkNotNullParameter(r3, "startPos");
                this.b = r2;
                this.c = r3;
                setFloatValues(new float[]{0.0f, 1.0f});
                setInterpolator(new AccelerateDecelerateInterpolator());
                setDuration(r4);
                addUpdateListener(new C0051a(this));
                this.a = new j80.d(0.0f, 0.0f);
            }
        }

        @Override // com.bytedance.android.live.profit.scoreboard.v.d
        public final j80.d getPos() {
            return this.c;
        }

        public f(ScoreboardBannerView r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            this.e = r3;
            this.a = com.bytedance.android.live.revenue.common.i.a(25);
            this.b = 200;
            this.c = j80.b.a(r3);
        }

        @Override // com.bytedance.android.live.profit.scoreboard.v.d
        public final void a(final j80.d r7) {
            Intrinsics.checkNotNullParameter(r7, "value");
            this.c = r7;
            float r0 = j80.c.a(j80.b.a(this.e), r7);
            a r1 = this.d;
            if (r1 == null) goto L6;
            Intrinsics.checkNotNullParameter(r7, "<set-?>");
            r1.a = r7;
            return;
        L6:
            if (r0 <= this.a) goto L8;
            View r2 = this.e;
            final a r3 = new a(r2, j80.b.a(r2), this.b);
            Intrinsics.checkNotNullParameter(r7, "<set-?>");
            r3.a = r7;
            com.bytedance.android.live.revenue.common.e.b(r3, new ScoreboardBannerController$SmoothBannerView$onPosChanged$$inlined$also$lambda$1(r3, this, r7));
            r3.start();
            Unit r8 = Unit.INSTANCE;
            this.d = r3;
            return;
        L8:
            j80.b.e(this.e, r7);
        }

        @Override // com.bytedance.android.live.profit.scoreboard.v.d
        public final void b(Rect r4) {
            Intrinsics.checkNotNullParameter(r4, "rect");
            int r0 = MathKt.roundToInt(this.c.a().floatValue());
            int r1 = MathKt.roundToInt(this.c.b().floatValue());
            o1.b(this.e, r4);
            r4.offsetTo(r0, r1);
        }
    }

    public static final class g {
        public final CompositeDisposable a;
        public final View b;
        public final ScoreboardBannerView c;
        public final d d;
        public final View e;
        public final e<c> f;

        public g(View r2, ScoreboardBannerView r3, f r4, View r5, e r6) {
            Intrinsics.checkNotNullParameter(r2, "root");
            Intrinsics.checkNotNullParameter(r3, "bannerView");
            Intrinsics.checkNotNullParameter(r4, "bannerInterface");
            Intrinsics.checkNotNullParameter(r5, "regionA");
            Intrinsics.checkNotNullParameter(r6, "regionManager");
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.a = new CompositeDisposable();
        }
    }

    static {
    }

    public final void onStart() {
    }

    @Override // com.bytedance.android.live.profit.scoreboard.i
    public final void c() {
        g r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.dispose();
        this.d.H1(r0.b);
        this.a = null;
        this.c.w().a(Boolean.FALSE);
    }

    @Override // com.bytedance.android.live.profit.scoreboard.i
    public final ViewGroup getContainer() {
        g r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.i
    public final void w() {
        g r0 = this.a;
        if (r0 == null) goto L7;
        ScoreboardBannerView r1 = r0.c;
        if (r1 == null) goto L7;
        r1.setVisibility(0);
    L7:
        this.c.w().a(Boolean.TRUE);
    }

    @Override // com.bytedance.android.live.profit.scoreboard.i
    public final boolean x() {
        if (this.a == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.live.profit.scoreboard.i
    public final void y() {
        if (x() == false) goto L5;
        return;
    L5:
        View r5 = LayoutInflater.from(this.b.getContext()).inflate(2131567407, null, false);
        View r8 = r5.findViewById(2131384160);
        View r0 = r5.findViewById(2131384161);
        View r1 = r5.findViewById(2131371716);
        ScoreboardBannerView r2 = (ScoreboardBannerView) r5.findViewById(2131363959);
        this.d.n0(r5);
        this.d.se(r5, r1, IRevFloatingBannerManager.Element.EntryAnim);
        e r9 = new e();
        c r3 = new c(RegionId.A, r8);
        Intrinsics.checkNotNullParameter(r3, "reg");
        r9.a.add(r3);
        c r4 = new c(RegionId.B, r0);
        Intrinsics.checkNotNullParameter(r4, "reg");
        r9.a.add(r4);
        View r6 = new View(r2.getContext());
        r6.setOnClickListener(new w(this));
        r2.addView(r6, -1, -1);
        g r7 = new g(r5, r2, new f(r2), r8, r9);
        this.a = r7;
        boolean r10 = this.b.isAnchor();
        jy0.b.d("ScoreboardBannerController", "isAnchor = " + r10);
        if (r10 == false) goto L8;
        r7.c.setDragCallback(new a(r7.d, r7.f, this.c));
        RxUtilKt.c(Disposables.fromAction(new z(r7)), r7.a);
        RxUtilKt.c(RxUtilKt.g(r7.c, true).subscribe(new a0(this, r7)), r7.a);
    L9:
        this.c.w().a(Boolean.FALSE);
        RxUtilKt.c(RxUtilKt.g(r2, true).map(new x(r2)).distinctUntilChanged().subscribe(new y(this)), r7.a);
        r7.c.setVisibility(8);
        return;
    L8:
        RxUtilKt.c(RxUtilKt.g(r7.c, true).switchMap(new b0(this)).subscribe(new c0(this, r7)), r7.a);
        goto L9
    }

    public final void onStop() {
        c();
    }

    public v(yz0.k r2, l r3, IRevFloatingBannerManager r4, com.bytedance.android.livesdk.revenue.service.broadcast.a r5) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "repository");
        Intrinsics.checkNotNullParameter(r4, "floatingBannerManager");
        Intrinsics.checkNotNullParameter(r5, "gameService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public static final j80.d a(v r2, e r3, ScoreboardBannerView r4, RegionId r5, j80.d r6) {
        r2.getClass();
        Iterator r7 = r3.a.iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        Object r8 = r7.next();
        if (((c) r8).b != r5) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L4;
    L12:
        c r9 = (c) r8;
        if (r9 == null) goto L22;
        o1.b(r9.c, r9.a);
        Rect r10 = new Rect();
        o1.b(r4, r10);
        Intrinsics.checkNotNullParameter(r10, "objectRect");
        Intrinsics.checkNotNullParameter(r6, "pos");
        r10.offsetTo(MathKt.roundToInt(r9.a.left + ((r9.a.width() - r10.width()) * r6.a().floatValue())), MathKt.roundToInt(r9.a.top + ((r9.a.height() - r10.height()) * r6.b().floatValue())));
        return j80.c.h(j80.b.b(r10));
    L22:
        return j80.b.a(r4);
    L8:
        r0 = false;
        goto L9
    L11:
        r8 = null;
        goto L12
    }
}
