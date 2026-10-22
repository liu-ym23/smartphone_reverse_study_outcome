package jd8;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.chat.component.bottom.core.follow.InputSwipePanelHost$2;
import com.larus.bmhome.clarification.x1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l extends FrameLayout {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public boolean B;
    public boolean C;
    public final ze8.a a;
    public final g b;
    public final Function0<Boolean> c;
    public final ViewGroup d;
    public final Function0<Boolean> e;
    public final ViewPager2 f;
    public final b g;
    public final Lazy h;
    public final int[] i;
    public final int[] j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public int o;
    public int p;
    public boolean q;
    public final List<a> r;
    public final int[] s;
    public final Lazy t;
    public final Path u;
    public final Lazy v;
    public float w;
    public final int x;
    public float y;
    public float z;

    public static final class a {
        public final ViewGroup a;
        public final boolean b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            int r2 = 1231;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.c == true) goto L11;
            r2 = 1237;
        L11:
            return r3 + r2;
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "ClippingParentState(parent=" + this.a + ", clipChildren=" + this.b + ", clipToPadding=" + this.c + ')';
        }

        public a(ViewGroup r2, boolean r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public final class b extends RecyclerView.Adapter<c> {
        public final /* synthetic */ l a;

        public final int getItemCount() {
            return this.a.a.getPageCount();
        }

        public b(l r1) {
            this.a = r1;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            c r5 = (c) r3;
            Intrinsics.checkNotNullParameter(r5, "holder");
            this.a.a.a(((RecyclerView.ViewHolder) r5).itemView, r4);
            ((RecyclerView.ViewHolder) r5).itemView.setTranslationY(this.a.j[r4]);
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            x1.a r4 = this.a.a.b(r2);
            r4.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
            return new c(r4);
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "page");
            super(r2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.p = -1;
        this.q = false;
        g();
        h();
        super.onDetachedFromWindow();
    }

    private final int getBasePageStrokeAlpha() {
        return ((Number) this.v.getValue()).intValue();
    }

    private final View getMeasurePage() {
        return (View) this.h.getValue();
    }

    private final Paint getPageStrokePaint() {
        return (Paint) this.t.getValue();
    }

    public final void c() {
        if (this.w >= 0.0f) goto L5;
        return;
    L5:
        this.w = -1.0f;
        getPageStrokePaint().setAlpha(getBasePageStrokeAlpha());
        invalidate();
    }

    public final boolean d() {
        if (this.n == true) goto L15;
        g r0 = this.b;
        if (r0.i == null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L16;
        return false;
    L16:
        return true;
    L7:
        if (r0.x != null) goto L10;
        r1 = false;
        goto L11
    L15:
        return true;
    }

    public final void g() {
        int r1 = 0;
        ArraysKt.fill$default(this.j, 0, 0, 0, 6, null);
        RecyclerView r0 = this.f.getChildAt(0);
        if ((r0 instanceof RecyclerView) == false) goto L5;
        RecyclerView r2 = r0;
    L6:
        if (r2 == null) goto L10;
        int r3 = r2.getChildCount();
    L8:
        if (r1 >= r3) goto L10;
        r2.getChildAt(r1).setTranslationY(0.0f);
        r1 = r1 + 1;
    L10:
        invalidate();
        if (this.n == true) goto L15;
        b(i(this.l));
        return;
    L15:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void h() {
        Iterator<T> r0 = this.r.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a r1 = (a) r0.next();
        r1.a.setClipChildren(r1.b);
        r1.a.setClipToPadding(r1.c);
        goto L4
    L6:
        ((ArrayList) this.r).clear();
    }

    public static int a(l r0) {
        return Color.alpha(r0.getPageStrokePaint().getColor());
    }

    public final void b(int r3) {
        if (r3 > 0) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r0 = this.f.getLayoutParams();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.height == r3) goto L11;
        r0.height = r3;
        this.f.setLayoutParams(r0);
        return;
    L11:
        if (this.f.getHeight() == r3) goto L15;
        this.f.requestLayout();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        super.dispatchDraw(r13);
        boolean r0 = this.n;
        int r2 = 0;
        if (r0 == false) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r0 == true) goto L11;
        if (r3 == true) goto L11;
        return;
    L11:
        Paint r1 = getPageStrokePaint();
        if (r3 == false) goto L14;
        int r4 = RangesKt.coerceIn(MathKt.roundToInt(getBasePageStrokeAlpha() * this.w), 0, 255);
    L15:
        r1.setAlpha(r4);
        RecyclerView r5 = this.f.getChildAt(0);
        if ((r5 instanceof RecyclerView) == false) goto L18;
        RecyclerView r6 = r5;
    L19:
        if (r6 != null) goto L21;
        return;
    L21:
        Resources r7 = getResources();
        float r8 = (int) TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()));
        float r9 = getPageStrokePaint().getStrokeWidth() / 2.0f;
        int r10 = r6.getChildCount();
    L22:
        if (r2 >= r10) goto L29;
        View r11 = r6.getChildAt(r2);
        int r12 = r6.getChildAdapterPosition(r11);
        if (r12 == (-1)) goto L28;
        int r14 = e(r12);
        if (r14 <= 0) goto L28;
        float r15 = ((this.f.getX() + r6.getX()) + r11.getX()) + r9;
        float r16 = (((this.f.getX() + r6.getX()) + r11.getX()) + r11.getWidth()) - r9;
        float r17 = ((this.f.getY() + r6.getY()) + r11.getY()) + r11.getHeight();
        float r18 = (r17 - r14) + r9;
        this.u.reset();
        this.u.moveTo(r15, r17);
        float r19 = r18 + r8;
        this.u.lineTo(r15, r19);
        this.u.quadTo(r15, r18, r15 + r8, r18);
        this.u.lineTo(r16 - r8, r18);
        this.u.quadTo(r16, r18, r16, r19);
        this.u.lineTo(r16, r17);
        r13.drawPath(this.u, getPageStrokePaint());
    L28:
        r2 = r2 + 1;
        goto L22
    L29:
        return;
    L18:
        r6 = null;
        goto L19
    L14:
        r4 = getBasePageStrokeAlpha();
        goto L15
    L5:
        if (this.w < 0.0f) goto L7;
        r3 = true;
        goto L8
    }

    public final int e(int r10) {
        int r0 = getWidth();
        if (r0 > 0) goto L6;
        return 0;
    L6:
        if (this.k == r0) goto L8;
        ArraysKt.fill$default(this.i, -1, 0, 0, 6, null);
        this.k = r0;
    L8:
        int r2 = this.i[r10];
        if (r2 <= 0) goto L11;
        return r2;
    L11:
        this.a.a(getMeasurePage(), r10);
        getMeasurePage().measure(View.MeasureSpec.makeMeasureSpec(r0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r1 = getMeasurePage().getMeasuredHeight();
        int r3 = this.m;
        if (r3 > 0) goto L15;
        Resources r4 = getResources();
        r3 = (int) (WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).heightPixels * 0.6f);
    L15:
        int r5 = RangesKt.coerceAtMost(r1, r3);
        this.i[r10] = r5;
        return r5;
    }

    public final int f(ze8.d r5) {
        int r0 = this.a.getPageCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (Intrinsics.areEqual(this.a.c(r1).a, r5.a) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    public final int i(int r4) {
        int[] r0 = this.j;
        if (r4 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        int r1 = r0[r4];
    L12:
        return e(r4) + RangesKt.coerceAtLeast(-r1, 0);
    L10:
        r1 = 0;
        goto L12
    L5:
        if (r4 >= r0.length) goto L7;
        r2 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        Function0<Boolean> r0 = this.c;
        if (r0 == null) goto L5;
        int r1 = r6.getActionMasked();
        if (r1 != 0) goto L9;
        this.y = r6.getX();
        this.z = r6.getY();
        this.A = false;
        this.B = false;
    L25:
        return super.onInterceptTouchEvent(r6);
    L9:
        if (r1 != 2) goto L25;
        if (this.A == true) goto L25;
        float r2 = r6.getX() - this.y;
        float r3 = r6.getY() - this.z;
        if (Math.abs(r2) <= this.x) goto L16;
    L17:
        this.A = true;
        if (Math.abs(r2) <= Math.abs(r3)) goto L25;
        if (((Boolean) r0.invoke()).booleanValue() == false) goto L25;
        this.B = true;
        return true;
    L16:
        if (Math.abs(r3) <= this.x) goto L25;
    L5:
        return super.onInterceptTouchEvent(r6);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.B == false) goto L7;
        return true;
    L7:
        return super.onTouchEvent(r2);
    }

    public final void setSettleBorderFraction(float r3) {
        this.w = RangesKt.coerceIn(r3, 0.0f, 1.0f);
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        if (this.p < 0) goto L6;
        setMeasuredDimension(getMeasuredWidth(), this.p);
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r2, int r3, int r4, int r5) {
        super.onSizeChanged(r2, r3, r4, r5);
        if (this.q == false) goto L6;
        if (r3 == r5) goto L6;
        this.q = false;
        h();
    L6:
        if (r2 <= 0) goto L10;
        if (r2 == r4) goto L11;
        b(i(this.l));
        return;
    L11:
        return;
    }

    public l(final Context r2, x1 r3, g r4, int r5, n r6, ViewGroup r7, m r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "panelAdapter");
        Intrinsics.checkNotNullParameter(r4, "follow");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = new ViewPager2(r2);
        this.g = new b(this);
        this.h = LazyKt.lazy(new i(this));
        int r9 = r3.getPageCount();
        int[] r10 = new int[r9];
        int r11 = 0;
    L4:
        if (r11 >= r9) goto L6;
        r10[r11] = -1;
        r11 = r11 + 1;
        goto L4
    L6:
        this.i = r10;
        this.j = new int[this.a.getPageCount()];
        this.m = r5;
        this.p = -1;
        this.r = new ArrayList();
        this.s = new int[2];
        this.t = LazyKt.lazy(new j(r2));
        this.u = new Path();
        this.v = LazyKt.lazy(new k(this));
        this.w = -1.0f;
        this.x = ViewConfiguration.get(r2).getScaledTouchSlop();
        setClipChildren(false);
        this.f.setClipChildren(false);
        this.f.setClipToPadding(false);
        this.f.setOrientation(0);
        this.f.setOffscreenPageLimit(RangesKt.coerceAtLeast(this.a.getPageCount(), 1));
        this.f.setAdapter(this.g);
        ViewPager2 r12 = this.f;
        Resources r13 = getResources();
        r12.setPageTransformer(new MarginPageTransformer((int) TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics()))));
        RecyclerView r14 = this.f.getChildAt(0);
        if ((r14 instanceof RecyclerView) == false) goto L9;
        RecyclerView r15 = r14;
    L10:
        if (r15 == null) goto L12;
        r15.setClipChildren(false);
        r15.setClipToPadding(false);
    L12:
        addView(this.f, new FrameLayout.LayoutParams(-1, -2, 80));
        this.f.registerOnPageChangeCallback(new InputSwipePanelHost$2(this));
        return;
    L9:
        r15 = null;
        goto L10
    }
}
