package com.obric.oui.tab;

import android.R;
import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.t;
import com.lynx.tasm.utils.a;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.bouncelayout.OHorizontalScrollView;
import com.obric.oui.common.style.o;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.d;
import com.obric.oui.material.n;
import gs.b;
import gs.c;
import gs.e;
import gs.f;
import gs.g;
import gs.i;
import gs.j;
import gs.k;
import gs.l;
import gs.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ym.h;
import zm.p;

/* JADX INFO: loaded from: classes3.dex */
@ViewPager.DecorView
public class OTabLayoutBase extends OHorizontalScrollView implements ValueAnimator.AnimatorUpdateListener, d {
    public static final FastOutSlowInInterpolator F0 = null;
    public static final Pools.SynchronizedPool G0 = null;
    public ColorStateList A;
    public final c A0;
    public float B;
    public final Pools.SimplePool B0;
    public final float C;
    public final int C0;
    public int D;
    public Typeface D0;
    public int E;
    public Typeface E0;
    public int F;
    public int G;
    public int H;
    public final int I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public e N;
    public final ArrayList O;
    public l P;
    public ValueAnimator Q;
    public ViewPager R;
    public PagerAdapter S;
    public f T;
    public TabLayoutOnPageChangeListener U;
    public b V;
    public boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final int f14646a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final int f14647b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final Drawable f14648c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f14649d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final float f14650e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f14651f0;
    public final Paint g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final Paint f14652h0;
    public final RectF i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final RectF f14653j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final RectF f14654k0;
    public final int l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f14655m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f14656m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public j f14657n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f14658n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j f14659o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final boolean f14660o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f14661p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final String f14662p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public WeakReference f14663q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final com.obric.oui.material.c[] f14664q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final i f14665r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final com.obric.oui.material.c[] f14666r0;
    public int s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final ArrayList f14667s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f14668t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f14669t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14670u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final Rect f14671u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f14672v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final Paint f14673v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f14674w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final m f14675w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f14676x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final ValueAnimator f14677x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14678y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final PathInterpolator f14679y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f14680z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final c f14681z0;

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f14682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14684c;
        public final int d;
        public final int e;
        public final ArgbEvaluator f;
        public final AccelerateInterpolator g;

        public TabLayoutOnPageChangeListener(OTabLayoutBase r5) {
            this.f = new ArgbEvaluator();
            this.g = new AccelerateInterpolator();
            new DecelerateInterpolator(1.6f);
            this.f14682a = new WeakReference(r5);
            this.e = r5.getTabTextColors().getColorForState(OTabLayoutBase.g(), 0);
            this.d = r5.getTabTextColors().getDefaultColor();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r5) {
            this.f14683b = this.f14684c;
            this.f14684c = r5;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r13, float r14, int r15) {
            OTabLayoutBase r16 = (OTabLayoutBase) this.f14682a.get();
            if (r16 == null) goto L42;
            int r5 = this.f14684c;
            if (r5 == 2) goto L7;
        L10:
            boolean r10 = true;
        L11:
            if (r5 == 2) goto L13;
        L16:
            boolean r11 = true;
        L17:
            r16.u(r13, r14, r10, r11);
            int r17 = this.f14684c;
            i r18 = r16.f14665r;
            if (r17 == 2) goto L20;
        L22:
            r18.f17194r = true;
            View r19 = r18.getChildAt(r18.f17186j);
            View r12 = r18.getChildAt(r18.f17186j + 1);
            if (r19 == null) goto L39;
            if (r12 == null) goto L39;
            View r20 = r19.findViewById(R$id.layout_tab_indicator);
            View r21 = r12.findViewById(R$id.layout_tab_indicator);
            if (r20 == null) goto L40;
            if (r21 == null) goto L40;
            float r110 = ((r19.getWidth() - r20.getWidth()) / 2) + r19.getLeft();
            float r22 = r20.getWidth() + r110;
            float r23 = ((r12.getWidth() - r21.getWidth()) / 2) + r12.getLeft();
            float r24 = r21.getWidth() + r23;
            ImageView r25 = (ImageView) r20.findViewById(R$id.tab_item_img);
            TextView r26 = (TextView) r20.findViewById(R$id.tab_item_text);
            ImageView r27 = (ImageView) r21.findViewById(R$id.tab_item_img);
            TextView r28 = (TextView) r21.findViewById(R$id.tab_item_text);
            ArgbEvaluator r29 = this.f;
            int r30 = this.e;
            Integer r31 = Integer.valueOf(r30);
            int r111 = this.d;
            int r32 = ((Integer) r29.evaluate(r14, r31, Integer.valueOf(r111))).intValue();
            if (r25 == null) goto L33;
            if (r26 == null) goto L33;
            r26.setTextColor(r32);
            r25.setImageAlpha(Color.alpha(r32));
        L33:
            int r33 = ((Integer) r29.evaluate(r14, Integer.valueOf(r111), Integer.valueOf(r30))).intValue();
            if (r27 == null) goto L38;
            if (r28 == null) goto L38;
            r28.setTextColor(r33);
            r27.setImageAlpha(Color.alpha(r33));
        L38:
            AccelerateInterpolator r112 = this.g;
            r18.f17192p = (r112.getInterpolation(r14) * (r23 - r110)) + r110;
            r18.f17193q = (r112.getInterpolation(r14) * (r24 - r22)) + r22;
        L40:
            ViewCompat.postInvalidateOnAnimation(r18);
            return;
        L39:
            FastOutSlowInInterpolator r113 = OTabLayoutBase.F0;
            goto L40
        L20:
            if (this.f14683b != 0) goto L22;
            r18.f17194r = false;
            goto L40
        L13:
            if (this.f14683b != 0) goto L16;
            r11 = false;
            goto L17
        L7:
            if (this.f14683b == 1) goto L10;
            r10 = false;
            goto L11
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r5) {
            OTabLayoutBase r10 = (OTabLayoutBase) this.f14682a.get();
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.getSelectedTabPosition() != r5) goto L7;
            return;
        L7:
            if (r5 >= r10.getTabCount()) goto L27;
            int r11 = this.f14684c;
            if (r11 != 0) goto L11;
        L16:
            boolean r12 = true;
        L17:
            if (r5 >= 0) goto L19;
        L22:
            j r13 = null;
        L23:
            r10.s(r13, r12);
            return;
        L19:
            if (r5 >= r10.getTabCount()) goto L22;
            r13 = (j) r10.f14655m.get(r5);
            goto L23
        L11:
            if (r11 == 2) goto L13;
        L15:
            r12 = false;
            goto L17
        L13:
            if (this.f14683b != 0) goto L15;
        }
    }

    public static class TabLayoutOnPageChangeListenerIndependent implements ViewPager.OnPageChangeListener {
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r5) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r5, float r10, int r11) {
            throw null;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r5) {
            throw null;
        }
    }

    static {
        F0 = new FastOutSlowInInterpolator();
        G0 = new Pools.SynchronizedPool(16);
    }

    public OTabLayoutBase(Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ int[] g() {
        return HorizontalScrollView.SELECTED_STATE_SET;
    }

    private int getDefaultHeight() {
        ArrayList r5 = this.f14655m;
        int r10 = r5.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L14;
        j r12 = (j) r5.get(r11);
        if (r12 == null) goto L13;
        if (r12.f17202a == null) goto L11;
        if (TextUtils.isEmpty(r12.f17203b) == true) goto L11;
        return 56;
    L11:
        if (r12.e == null) goto L13;
        return 56;
    L13:
        r11 = r11 + 1;
        goto L3
    L14:
        return 56;
    }

    private float getScrollPosition() {
        i r5 = this.f14665r;
        return r5.f17186j + r5.f17187k;
    }

    private int getTabMinWidth() {
        int r5 = this.G;
        if (r5 == (-1)) goto L6;
        return r5;
    L6:
        if (this.K == 0) goto L10;
        return 0;
    L10:
        return this.I;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f14665r.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int r10) {
        i r5 = this.f14665r;
        int r11 = r5.getChildCount();
        if (r10 >= r11) goto L11;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L15;
        View r13 = r5.getChildAt(r12);
        if (r12 != r10) goto L9;
        boolean r14 = true;
    L10:
        r13.setSelected(r14);
        r12 = r12 + 1;
        goto L5
    L9:
        r14 = false;
        goto L10
    L15:
        return;
    }

    @Override // com.obric.oui.material.d
    public final void a(int r5) {
        if (this.f14660o0 == false) goto L7;
        ArrayList r10 = this.f14655m;
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        ((j) r10.get(r12)).g.a(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r5) {
        i(r5);
    }

    @Override // com.obric.oui.bouncelayout.OHorizontalScrollView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r26) {
        float r5 = getBounceTranslation();
        float r10 = a.t(getContext(), 0.5f);
        if (r5 >= (-r10)) goto L5;
        boolean r11 = true;
    L7:
        if (r5 <= r10) goto L9;
        boolean r12 = true;
    L11:
        if (canScrollHorizontally(-1) == true) goto L15;
        if (r11 == true) goto L15;
        boolean r13 = false;
    L17:
        if (canScrollHorizontally(1) == true) goto L21;
        if (r12 == true) goto L21;
        boolean r14 = false;
    L22:
        int r15 = getWidth();
        int r16 = getHeight();
        m r17 = this.f14675w0;
        if (r17.e == true) goto L25;
    L91:
        n(r26);
        return;
    L25:
        if (r17.f <= 0.0f) goto L91;
        if (r15 <= 0) goto L91;
        if (r16 <= 0) goto L91;
        if (r13 == true) goto L30;
        if (r14 == false) goto L91;
    L30:
        float r18 = getScrollX();
        float r19 = getTabStripLeftPadding();
        float r110 = getTabStripRightPadding();
        int r20 = getWidth();
        int r21 = getHeight();
        RectF r22 = this.f14653j0;
        RectF r111 = this.f14654k0;
        i r23 = this.f14665r;
        Intrinsics.checkNotNullParameter(r23, "tabContainer");
        Intrinsics.checkNotNullParameter(r22, "outLayerBounds");
        Intrinsics.checkNotNullParameter(r111, "outOverlayBounds");
        int r24 = r23.getChildCount();
        int r25 = 0;
        int r112 = 0;
        int r113 = 0;
    L31:
        if (r25 >= r24) goto L50;
        int r114 = r25 + 1;
        KeyEvent.Callback r27 = r23.getChildAt(r25);
        if ((r27 instanceof com.obric.oui.common.style.b) == false) goto L38;
        List r28 = ((com.obric.oui.common.style.b) r27).getCurrentShadows();
        if (r28 == null) goto L38;
        Iterator r29 = r28.iterator();
        int r30 = r113;
    L41:
        if (r29.hasNext() == false) goto L49;
        Iterator r115 = r29;
        com.obric.oui.common.style.m r31 = (com.obric.oui.common.style.m) r29.next();
        if (r31 == null) goto L48;
        if (r31.e() == false) goto L48;
        r30 = Math.max(r30, (int) Math.ceil((Math.abs(r31.f12518c) + r31.f12517b) + r31.e));
        r112 = Math.max(r112, (int) Math.ceil((Math.abs(r31.d) + r31.f12517b) + r31.e));
    L48:
        r29 = r115;
        r24 = r24;
        r23 = r23;
        goto L41
    L49:
        r113 = r30;
    L38:
        r25 = r114;
        goto L31
    L50:
        if (r13 == false) goto L52;
        int r32 = 0;
    L53:
        float r33 = r18 - r32;
        float r34 = r20 + r18;
        if (r14 == false) goto L56;
        int r35 = 0;
    L57:
        float r36 = r112;
        r22.set(r33, -r36, r35 + r34, r21 + r36);
        if (r13 == false) goto L60;
        r18 = r22.left;
    L60:
        if (r14 == false) goto L62;
        r34 = r22.right;
    L62:
        r111.set(r18, r22.top, r34, r22.bottom);
        int r37 = r26.saveLayer(r22.left, r22.top, r22.right, r22.bottom, null);
        n(r26);
        float r38 = r111.left;
        if (r13 == true) goto L66;
        r19 = 0.0f;
    L66:
        float r39 = r38 + r19;
        float r40 = r111.top;
        float r41 = r111.right;
        if (r14 == true) goto L70;
        r110 = 0.0f;
    L70:
        float r116 = r41 - r110;
        float r117 = r111.bottom;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r26, "canvas");
        float r118 = Math.min(r17.f, ((int) (r116 - r39)) / 2.0f);
        if (r118 > 0.0f) goto L74;
    L89:
        r26.restoreToCount(r37);
        return;
    L74:
        if (r17.f17225i == r118) goto L77;
        r17.f17225i = r118;
        int[] r210 = {Color.argb(0, 0, 0, 0), Color.argb(255, 0, 0, 0)};
        float[] r42 = m.f17220j;
        Shader.TileMode r43 = Shader.TileMode.CLAMP;
        r17.g = new LinearGradient(0.0f, 0.0f, r118, 0.0f, r210, r42, r43);
        r17.f17224h = new LinearGradient(0.0f, 0.0f, r118, 0.0f, new int[]{Color.argb(255, 0, 0, 0), Color.argb(0, 0, 0, 0)}, r42, r43);
    L77:
        Paint r119 = r17.f17221a;
        r119.setXfermode(r17.f17222b);
        if (r13 == false) goto L83;
        LinearGradient r44 = r17.g;
        if (r44 == null) goto L82;
        Matrix r45 = r17.f17223c;
        r45.reset();
        r45.setTranslate(r39, 0.0f);
        r44.setLocalMatrix(r45);
        r119.setShader(r44);
    L82:
        r26.drawRect(r39, r40, r39 + r118, r117, r119);
    L83:
        if (r14 == false) goto L88;
        LinearGradient r46 = r17.f17224h;
        if (r46 == null) goto L87;
        Matrix r47 = r17.d;
        r47.reset();
        r47.setTranslate(r116 - r118, 0.0f);
        r46.setLocalMatrix(r47);
        r119.setShader(r46);
    L87:
        r26.drawRect(r116 - r118, r40, r116, r117, r119);
    L88:
        r119.setShader(null);
        r119.setXfermode(null);
        goto L89
    L56:
        r35 = r113;
        goto L57
    L52:
        r32 = r113;
    L21:
        r14 = true;
    L15:
        r13 = true;
        goto L17
    L9:
        r12 = false;
        goto L11
    L5:
        r11 = false;
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return generateDefaultLayoutParams();
    }

    public float getEdgeFadeLength() {
        return this.f14675w0.f;
    }

    public float getIndicatorCornerRadius() {
        return this.f14651f0;
    }

    public int getSelectedTabPosition() {
        j r5 = this.f14657n;
        if (r5 != null) goto L7;
        return -1;
    L7:
        return r5.d;
    }

    public ViewGroup getTabContainer() {
        return this.f14665r;
    }

    public int getTabCount() {
        return this.f14655m.size();
    }

    public int getTabGravity() {
        return this.J;
    }

    public int getTabMaxWidth() {
        return this.E;
    }

    public int getTabMode() {
        return this.K;
    }

    public int getTabStripLeftPadding() {
        return this.f14665r.getPaddingLeft();
    }

    public int getTabStripRightPadding() {
        return this.f14665r.getPaddingRight();
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.A;
    }

    public final void h(j r10, boolean r11) {
        ArrayList r5 = this.f14655m;
        int r12 = r5.size();
        if (r10.f != this) goto L16;
        r10.d = r12;
        r5.add(r12, r10);
        int r13 = r5.size();
        int r14 = r12 + 1;
    L5:
        if (r14 >= r13) goto L7;
        ((j) r5.get(r14)).d = r14;
        r14 = r14 + 1;
        goto L5
    L7:
        k r15 = r10.g;
        int r16 = r10.d;
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(-2, -1);
        w(r17);
        this.f14665r.addView(r15, r16, r17);
        r10.g.setOnTouchListener(new gs.a(this, r12));
        if (r11 == false) goto L14;
        OTabLayoutBase r18 = r10.f;
        if (r18 == null) goto L13;
        r18.s(r10, true);
        return;
    L13:
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
    L14:
        return;
    L16:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public final void i(View r10) {
        boolean r5 = r10 instanceof OTabItem;
        ArrayList r11 = this.f14655m;
        if (r5 == false) goto L18;
        OTabItem r12 = (OTabItem) r10;
        j r13 = q(0);
        CharSequence r14 = r12.f14643a;
        if (r14 == null) goto L7;
        r13.f17203b = r14;
        r13.a();
    L7:
        Drawable r15 = r12.f14644b;
        if (r15 == null) goto L10;
        r13.f17202a = r15;
        r13.a();
    L10:
        int r16 = r12.f14645c;
        if (r16 == 0) goto L14;
        r13.e = LayoutInflater.from(r13.g.getContext()).inflate(r16, r13.g, false);
        r13.a();
    L14:
        if (TextUtils.isEmpty(r12.getContentDescription()) == true) goto L16;
        r13.f17204c = r12.getContentDescription();
        r13.a();
    L16:
        h(r13, r11.isEmpty());
        return;
    L18:
        if ((r10 instanceof i) == false) goto L23;
        if (indexOfChild(r10) != (-1)) goto L33;
        super.addView(r10, 0, new FrameLayout.LayoutParams(-2, -1));
        return;
    L33:
        return;
    L23:
        if ((r10 instanceof OBottomTabItem) == false) goto L35;
        OBottomTabItem r17 = (OBottomTabItem) r10;
        OBottomTabItemCustomView r18 = new OBottomTabItemCustomView(getContext());
        j r19 = q(0);
        if (r17.getText() == null) goto L28;
        r18.getTitle().setText(r17.getText());
        r19.f17203b = r17.getText();
        r19.a();
    L28:
        if (r17.getIcon() == null) goto L30;
        r18.getIcon().setImageDrawable(r17.getIcon());
    L30:
        r18.setTextColor(this.A);
        r18.setSelectedBgColor(Integer.valueOf(ContextCompat.getColor(getContext(), R$color.oui_accent_bg_light)));
        r19.e = r18;
        r19.a();
        h(r19, r11.isEmpty());
        return;
    }

    public final void j(int r10) {
        if (r10 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L20:
        u(r10, 0.0f, true, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L20;
        i r5 = this.f14665r;
        int r11 = r5.getChildCount();
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L15;
        if (r5.getChildAt(r12).getWidth() <= 0) goto L20;
        r12 = r12 + 1;
        goto L10
    L15:
        int r13 = getScrollX();
        int r14 = l(r10, 0.0f);
        if (r13 == r14) goto L18;
        o();
        this.Q.setIntValues(new int[]{r13, r14});
        this.Q.start();
    L18:
        r5.e(r10, 200);
    }

    public final void k() {
        int r5 = this.K;
        i r10 = this.f14665r;
        if (r5 == 0) goto L7;
        if (r5 != 1) goto L8;
        r10.setGravity(1);
        setOverScrollMode(2);
    L8:
        x(true);
        return;
    L7:
        r10.setGravity(GravityCompat.START);
        setOverScrollMode(0);
        goto L8
    }

    public final int l(int r5, float r10) {
        int r11 = 0;
        if (this.K != 0) goto L21;
        i r12 = this.f14665r;
        View r13 = r12.getChildAt(r5);
        int r14 = r5 + 1;
        if (r14 >= r12.getChildCount()) goto L7;
        View r15 = r12.getChildAt(r14);
    L8:
        if (r13 == null) goto L10;
        int r16 = r13.getWidth();
    L11:
        if (r15 == null) goto L13;
        int r17 = r15.getWidth();
    L14:
        if (r13 == null) goto L16;
        r11 = r13.getLeft();
    L16:
        int r18 = ((r16 / 2) + r11) - (getWidth() / 2);
        int r19 = (int) ((((this.s * 4) + (r16 + r17)) * 0.5f) * r10);
        if (ViewCompat.getLayoutDirection(this) != 0) goto L20;
        return r18 + r19;
    L20:
        return r18 - r19;
    L13:
        r17 = 0;
        goto L14
    L10:
        r16 = 0;
        goto L11
    L7:
        r15 = null;
        goto L8
    L21:
        return 0;
    }

    public final int m(int r5) {
        return (int) ((getResources().getDisplayMetrics().density * r5) + 0.5f);
    }

    public final void n(Canvas r17) {
        if (isInEditMode() == false) goto L5;
    L44:
        super.dispatchDraw(r17);
        return;
    L5:
        if (getTabCount() <= 0) goto L44;
        float r10 = getBounceTranslation();
        int r5 = getHeight();
        int r11 = getPaddingLeft();
        int r12 = getPaddingTop();
        int r13 = getPaddingBottom();
        float r14 = this.f14649d0;
        float r15 = this.f14650e0;
        if (r14 >= 0.0f) goto L9;
        this.f14649d0 = r5 - (r15 * 2.0f);
    L9:
        float r16 = this.f14651f0;
        if (r16 >= 0.0f) goto L12;
    L13:
        this.f14651f0 = this.f14649d0;
    L14:
        float r18 = (r15 / 2.0f) + this.f14651f0;
        float r19 = getWidth() + r10;
        RectF r20 = this.i0;
        boolean r21 = this.f14661p;
        int r110 = this.l0;
        if (r21 == true) goto L18;
        if (r110 == 0) goto L18;
        Paint r22 = this.g0;
        r22.setColor(r110);
        r20.set(r10, r12, r19, r5 - r13);
        r17.drawRoundRect(r20, r18, r18, r22);
    L18:
        Paint r23 = this.f14652h0;
        if (r23.getColor() == 0) goto L21;
        r20.set(r10, r12, r19, r5 - r13);
        r17.drawRoundRect(r20, r18, r18, r23);
    L21:
        boolean r24 = this.f14656m0;
        Rect r25 = this.f14671u0;
        i r111 = this.f14665r;
        int r112 = 0;
        if (r24 == true) goto L24;
        View r26 = r111.getChildAt(getSelectedTabPosition());
        if (r26 == null) goto L31;
        r25.left = r26.getLeft();
        r25.right = r26.getRight();
    L31:
        Paint r113 = this.f14673v0;
        int r27 = this.f14646a0;
        if (r27 == 0) goto L34;
        r113.setColor(r27);
        float r28 = (r25.left + r11) + r10;
        float r29 = (r25.right + r11) + r10;
        float r30 = this.f14649d0;
        float r31 = this.f14650e0;
        o.d(r28, r31, r29, r31 + r30, this.f14651f0, r17, r113);
    L34:
        int r32 = this.f14647b0;
        if (r32 == 0) goto L44;
        if (r110 != 0) goto L44;
    L38:
        if (r112 >= getTabCount()) goto L44;
        if (r112 == getSelectedTabPosition()) goto L43;
        View r33 = r111.getChildAt(r112);
        r113.setColor(r32);
        o.d((r33.getLeft() + r11) + r10, this.f14650e0, (r33.getRight() + r11) + r10, r15 + this.f14649d0, this.f14651f0, r17, r113);
    L43:
        r112 = r112 + 1;
        r32 = r32;
        goto L38
    L24:
        if (this.f14669t0 == false) goto L31;
        this.f14669t0 = false;
        View r34 = r111.getChildAt(getSelectedTabPosition());
        if (r34 == null) goto L31;
        r25.left = r34.getLeft();
        r25.right = r34.getRight();
        goto L31
    L12:
        if (r16 <= (this.f14649d0 / 2.0f)) goto L14;
        goto L13
    }

    public final void o() {
        if (this.Q != null) goto L6;
        ValueAnimator r5 = new ValueAnimator();
        this.Q = r5;
        r5.setInterpolator(F0);
        this.Q.setDuration(200);
        this.Q.addUpdateListener(new t(this, 5));
        return;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        c r10 = (c) r5.getAnimatedValue();
        int r11 = (int) r10.f17177a;
        Rect r12 = this.f14671u0;
        r12.left = r11;
        r12.right = (int) r10.f17178b;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.R != null) goto L8;
        ViewParent r5 = getParent();
        if ((r5 instanceof ViewPager) == false) goto L9;
        v((ViewPager) r5, true);
        return;
    L9:
        return;
    }

    @Override // com.obric.oui.bouncelayout.OHorizontalScrollView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.W == false) goto L6;
        setupWithViewPager(null);
        this.W = false;
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        super.onDraw(r5);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        int r11 = m(getDefaultHeight());
        int r12 = getPaddingTop() + r11;
        int r13 = getPaddingBottom() + r12;
        int r14 = getMinimumHeight();
        if (r14 <= 0) goto L5;
        r13 = r14;
    L5:
        int r15 = View.MeasureSpec.getMode(r10);
        if (r15 == Integer.MIN_VALUE) goto L10;
        if (r15 == 0) goto L9;
        int r16 = View.MeasureSpec.makeMeasureSpec(Math.max(r13, View.MeasureSpec.getSize(r10)), BasicMeasure.EXACTLY);
    L11:
        int r17 = View.MeasureSpec.getSize(r5);
        if (View.MeasureSpec.getMode(r5) == 0) goto L18;
        int r18 = this.H;
        if (r18 > 0) goto L17;
        r18 = r17 - m(56);
    L17:
        this.E = r18;
    L18:
        super.onMeasure(r5, r16);
        if (getChildCount() != 1) goto L31;
        View r19 = getChildAt(0);
        int r20 = this.K;
        if (r20 == 0) goto L28;
        if (r20 == 1) goto L25;
        return;
    L25:
        if (r19.getMeasuredWidth() == getMeasuredWidth()) goto L32;
    L29:
        int r21 = getPaddingTop();
        int r22 = ViewGroup.getChildMeasureSpec(r16, getPaddingBottom() + r21, r19.getLayoutParams().height);
        r19.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY), r22);
        return;
    L32:
        return;
    L28:
        if (r19.getMeasuredWidth() < getMeasuredWidth()) goto L29;
        return;
    L31:
        return;
    L9:
        r16 = View.MeasureSpec.makeMeasureSpec(r13, BasicMeasure.EXACTLY);
        goto L11
    L10:
        r16 = View.MeasureSpec.makeMeasureSpec(Math.min(r13, View.MeasureSpec.getSize(r10)), BasicMeasure.EXACTLY);
        goto L11
    }

    public final boolean p() {
        int r5 = this.A.getDefaultColor();
        if (r5 != 0) goto L10;
        if ((getResources().getConfiguration().uiMode & 48) == 32) goto L11;
        return false;
    L11:
        return true;
    L10:
        return !h.j(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final j q(int r11) {
        j r5 = (j) G0.acquire();
        if (r5 != null) goto L5;
        r5 = new j();
        r5.d = -1;
    L5:
        r5.f = this;
        Pools.SimplePool r10 = this.B0;
        if (r10 == null) goto L8;
        k r12 = (k) r10.acquire();
    L9:
        boolean r13 = this.f14660o0;
        if (r12 != null) goto L20;
        Context r14 = getContext();
        com.obric.oui.material.c[] r15 = this.f14666r0;
        r12 = new k(this, r14, this.f14660o0, this.f14664q0, r15);
        WeakReference r16 = this.f14663q;
        if (r16 != null) goto L14;
    L16:
        Drawable r17 = this.f14648c0;
        if (r17 == null) goto L25;
        if (r13 == true) goto L25;
        r12.setBackground(r17.mutate());
        r12.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
    L25:
        r12.setFocusable(true);
        r5.g = r12;
        if (r11 > 0) goto L28;
        r12.setTab(r5);
    L32:
        return r5;
    L28:
        if (r5 == r12.f17205h) goto L30;
        r12.f17205h = r5;
    L30:
        r5.e = LayoutInflater.from(r12.getContext()).inflate(r11, r5.g, false);
        r5.a();
        goto L32
    L14:
        if (r16.get() == null) goto L16;
        r12.setBackdropTarget((View) this.f14663q.get());
        goto L16
    L20:
        r12.f17212o = r13;
        if (r13 == false) goto L23;
        r12.r(r12.isSelected());
    L24:
        com.obric.oui.material.c[] r18 = this.f14664q0;
        com.obric.oui.material.c[] r19 = this.f14666r0;
        r12.f17214q = r18;
        r12.f17215r = r19;
        r12.f17213p = r18;
        goto L25
    L23:
        r12.p();
        r12.n();
        r12.e(false);
        goto L24
    L8:
        r12 = null;
        goto L9
    }

    public final void r() {
        i r5 = this.f14665r;
        int r10 = r5.getChildCount() - 1;
    L3:
        j r11 = null;
        if (r10 < 0) goto L9;
        k r12 = (k) r5.getChildAt(r10);
        r5.removeViewAt(r10);
        if (r12 == null) goto L8;
        r12.setTab(null);
        r12.setSelected(false);
        this.B0.release(r12);
    L8:
        requestLayout();
        r10 = r10 - 1;
        goto L3
    L9:
        ArrayList r13 = this.f14655m;
        Iterator r14 = r13.iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        j r15 = (j) r14.next();
        r14.remove();
        r15.f = null;
        r15.g = null;
        r15.f17202a = null;
        r15.f17203b = null;
        r15.f17204c = null;
        r15.d = -1;
        r15.e = null;
        G0.release(r15);
        goto L11
    L13:
        this.f14657n = null;
        PagerAdapter r16 = this.S;
        if (r16 == null) goto L37;
        int r17 = r16.getCount();
        int r18 = 0;
    L16:
        if (r18 >= r17) goto L18;
        j r19 = q(this.L);
        r19.f17203b = this.S.getPageTitle(r18);
        r19.a();
        h(r19, false);
        r18 = r18 + 1;
        goto L16
    L18:
        ViewPager r20 = this.R;
        if (r20 == null) goto L38;
        if (r17 <= 0) goto L39;
        int r21 = r20.getCurrentItem();
        if (r21 != getSelectedTabPosition()) goto L24;
        return;
    L24:
        if (r21 >= getTabCount()) goto L41;
        if (r21 >= 0) goto L27;
    L30:
        s(r11, true);
        return;
    L27:
        if (r21 >= getTabCount()) goto L30;
        r11 = (j) r13.get(r21);
        goto L30
    L41:
        return;
    L39:
        return;
    L38:
        return;
    }

    public final void s(j r10, boolean r11) {
        j r5 = this.f14657n;
        ArrayList r12 = this.O;
        if (r5 != r10) goto L10;
        if (r5 == null) goto L47;
        int r13 = r12.size() - 1;
    L6:
        if (r13 < 0) goto L8;
        ((e) r12.get(r13)).getClass();
        r13 = r13 - 1;
        goto L6
    L8:
        j(r10.d);
        return;
    L47:
        return;
    L10:
        if (r10 == null) goto L12;
        int r14 = r10.d;
    L13:
        if (r11 == false) goto L22;
        if (r5 != null) goto L16;
    L17:
        if (r14 == (-1)) goto L19;
        u(r14, 0.0f, true, true);
    L20:
        if (r14 == (-1)) goto L22;
        setSelectedTabView(r14);
    L19:
        j(r14);
        goto L20
    L16:
        if (r5.d != (-1)) goto L19;
    L22:
        if (r5 == null) goto L26;
        int r15 = r12.size() - 1;
    L24:
        if (r15 < 0) goto L26;
        ((e) r12.get(r15)).getClass();
        r15 = r15 - 1;
    L26:
        j r16 = this.f14657n;
        if (r16 != null) goto L29;
        r16 = r10;
    L29:
        this.f14659o = r16;
        this.f14657n = r10;
        if (this.f14656m0 == false) goto L43;
        View r17 = this.f14665r.getChildAt(getSelectedTabPosition());
        if (r17 == null) goto L43;
        float r18 = r17.getLeft();
        c r19 = this.f14681z0;
        r19.f17177a = r18;
        r19.f17178b = r17.getRight();
        k r20 = this.f14659o.g;
        float r21 = r20.getLeft();
        c r22 = this.A0;
        r22.f17177a = r21;
        float r23 = r20.getRight();
        r22.f17178b = r23;
        if (r22.f17177a == r19.f17177a) goto L37;
    L39:
        ValueAnimator r24 = this.f14677x0;
        r24.setObjectValues(new Object[]{r22, r19});
        if (this.f14658n0 == false) goto L42;
        r24.setInterpolator(this.f14679y0);
    L42:
        r24.setDuration(350);
        r24.start();
        goto L43
    L37:
        if (r23 != r19.f17178b) goto L39;
        invalidate();
    L43:
        if (r10 == null) goto L52;
        int r25 = r12.size() - 1;
    L45:
        if (r25 < 0) goto L53;
        l r26 = (l) ((e) r12.get(r25));
        r26.getClass();
        r26.f17219a.setCurrentItem(r10.d);
        r25 = r25 - 1;
        goto L45
    L53:
        return;
    L52:
        return;
    L12:
        r14 = -1;
        goto L13
    }

    public void setAutoFillWhenScrollable(boolean r5) {
        this.M = r5;
    }

    @Override // com.obric.oui.material.d
    public void setBackdropTarget(@Nullable View r5) {
        if (r5 != null) goto L4;
        this.f14663q = new WeakReference(this);
    L5:
        View r10 = (View) this.f14663q.get();
        if (r10 == null) goto L15;
        if (r5 != null) goto L9;
        n.r(null, this);
    L11:
        if (this.f14660o0 == false) goto L17;
        ArrayList r11 = this.f14655m;
        int r12 = r11.size();
        int r13 = 0;
    L13:
        if (r13 >= r12) goto L18;
        ((j) r11.get(r13)).g.setBackdropTarget(r10);
        r13 = r13 + 1;
        goto L13
    L18:
        return;
    L17:
        return;
    L9:
        n.r(r10, this);
        goto L11
    L15:
        return;
    L4:
        this.f14663q = new WeakReference(r5);
        goto L5
    }

    public void setContentInsetStart(int r5) {
    }

    public void setCustomTabViewResId(int r5) {
        this.L = r5;
    }

    public void setEdgeFadeEnabled(boolean r5) {
        m r10 = this.f14675w0;
        if (r10.e == r5) goto L7;
        r10.e = r5;
        invalidate();
        return;
    }

    public void setEdgeFadeLength(float r5) {
        m r10 = this.f14675w0;
        r10.getClass();
        float r11 = RangesKt.coerceAtLeast(r5, 0.0f);
        if (r10.f == r11) goto L7;
        r10.f = r11;
        r10.f17225i = -1.0f;
        r10.g = null;
        r10.f17224h = null;
        invalidate();
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        this.f14665r.setEnabled(r5);
    }

    public void setIndicatorAnimEnable(boolean r5) {
        this.f14656m0 = r5;
        invalidate();
    }

    public void setIndicatorBounceEnable(boolean r5) {
        this.f14658n0 = r5;
    }

    public void setIndicatorCornerRadius(float r5) {
        this.f14651f0 = r5;
        invalidate();
    }

    public void setOnTabClickListener(gs.d r5) {
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable e r5) {
        e r10 = this.N;
        ArrayList r11 = this.O;
        if (r10 == null) goto L5;
        r11.remove(r10);
    L5:
        this.N = r5;
        if (r5 != null) goto L8;
        return;
    L8:
        if (r11.contains(r5) == true) goto L12;
        r11.add(r5);
        return;
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener r5) {
        o();
        this.Q.addListener(r5);
    }

    public void setSelectedTabHorizontalPadding(int r5) {
        this.f14665r.getClass();
    }

    public void setSelectedTabIndicatorColor(@ColorInt int r5) {
        i r10 = this.f14665r;
        Paint r11 = r10.f17185i;
        if (r11.getColor() == r5) goto L6;
        r11.setColor(r5);
        ViewCompat.postInvalidateOnAnimation(r10);
        return;
    }

    public void setSelectedTabIndicatorHeight(int r5) {
        i r10 = this.f14665r;
        if (r10.f17184h == r5) goto L6;
        r10.f17184h = r5;
        ViewCompat.postInvalidateOnAnimation(r10);
        return;
    }

    public void setShowSelectedIndicator(Boolean r5) {
        this.f14665r.f17196u = r5.booleanValue();
    }

    public void setShowTopLine(Boolean r5) {
        this.f14665r.n(r5.booleanValue());
    }

    public void setTabBackgroundResId(int r5) {
        this.D = r5;
    }

    public void setTabGravity(int r5) {
        if (this.J == r5) goto L6;
        this.J = r5;
        k();
        return;
    }

    public void setTabMargin(int r5) {
        this.s = m(r5);
        int r10 = 0;
    L4:
        if (r10 >= getTabCount()) goto L6;
        View r11 = this.f14665r.getChildAt(r10);
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
        r12.leftMargin = m(r5);
        r12.rightMargin = m(r5);
        r11.setLayoutParams(r12);
        r10 = r10 + 1;
        goto L4
    }

    public void setTabMaxWidth(int r5) {
        this.H = r5;
        this.F = r5;
    }

    public void setTabMinWidth(int r5) {
        this.G = r5;
    }

    public void setTabMode(int r5) {
        if (r5 == this.K) goto L6;
        this.K = r5;
        k();
        return;
    }

    public void setTabPaddingBottom(int r5) {
        this.f14680z = r5;
    }

    public void setTabPaddingEnd(int r5) {
        this.f14678y = r5;
    }

    public void setTabPaddingStart(int r5) {
        this.f14674w = r5;
    }

    public void setTabPaddingTop(int r5) {
        this.f14676x = r5;
    }

    @Deprecated
    public void setTabTextAppearance(int r5) {
    }

    public void setTabTextColors(@Nullable ColorStateList r5) {
        if (this.A == r5) goto L7;
        this.A = r5;
        ArrayList r10 = this.f14655m;
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        ((j) r10.get(r12)).a();
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setTabTextSize(float r5) {
        if (this.B == r5) goto L7;
        this.B = r5;
        ArrayList r10 = this.f14655m;
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        ((j) r10.get(r12)).a();
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter r5) {
        t(r5, false);
    }

    public void setupWithViewPager(@Nullable ViewPager r5) {
        v(r5, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void t(PagerAdapter r5, boolean r10) {
        PagerAdapter r11 = this.S;
        if (r11 == null) goto L7;
        f r12 = this.T;
        if (r12 == null) goto L7;
        r11.unregisterDataSetObserver(r12);
    L7:
        this.S = r5;
        if (r10 == false) goto L14;
        if (r5 == null) goto L14;
        if (this.T != null) goto L13;
        this.T = new f(this);
    L13:
        r5.registerDataSetObserver(this.T);
    L14:
        r();
    }

    public final void u(int r5, float r10, boolean r11, boolean r12) {
        int r13 = Math.round(r5 + r10);
        if (r13 < 0) goto L23;
        i r14 = this.f14665r;
        if (r13 >= r14.getChildCount()) goto L25;
        if (r12 == false) goto L14;
        ValueAnimator r15 = r14.f17190n;
        if (r15 != null) goto L11;
    L13:
        r14.f17186j = r5;
        r14.f17187k = r10;
        r14.o();
        goto L14
    L11:
        if (r15.isRunning() == false) goto L13;
        r14.f17190n.cancel();
    L14:
        ValueAnimator r16 = this.Q;
        if (r16 != null) goto L17;
    L19:
        scrollTo(l(r5, r10), 0);
        if (r11 == false) goto L24;
        setSelectedTabView(r13);
        return;
    L24:
        return;
    L17:
        if (r16.isRunning() == false) goto L19;
        this.Q.cancel();
        goto L19
    L25:
        return;
    }

    public final void v(ViewPager r5, boolean r10) {
        ViewPager r11 = this.R;
        if (r11 == null) goto L10;
        TabLayoutOnPageChangeListener r12 = this.U;
        if (r12 == null) goto L7;
        r11.removeOnPageChangeListener(r12);
    L7:
        b r13 = this.V;
        if (r13 == null) goto L10;
        this.R.removeOnAdapterChangeListener(r13);
    L10:
        l r14 = this.P;
        ArrayList r15 = this.O;
        if (r14 == null) goto L14;
        r15.remove(r14);
        this.P = null;
    L14:
        if (r5 == null) goto L28;
        this.R = r5;
        if (this.U != null) goto L18;
        this.U = new TabLayoutOnPageChangeListener(this);
    L18:
        TabLayoutOnPageChangeListener r16 = this.U;
        r16.f14683b = 0;
        r16.f14684c = 0;
        r5.addOnPageChangeListener(r16);
        l r17 = new l(r5);
        this.P = r17;
        if (r15.contains(r17) == true) goto L21;
        r15.add(r17);
    L21:
        PagerAdapter r18 = r5.getAdapter();
        if (r18 == null) goto L25;
        t(r18, true);
    L25:
        if (this.V != null) goto L27;
        this.V = new b(this);
    L27:
        b r19 = this.V;
        r19.f17175a = true;
        r5.addOnAdapterChangeListener(r19);
        u(r5.getCurrentItem(), 0.0f, true, true);
    L29:
        this.W = r10;
        return;
    L28:
        this.R = null;
        t(null, false);
        goto L29
    }

    public final void w(LinearLayout.LayoutParams r5) {
        if (this.K == 1) goto L5;
    L7:
        r5.width = -2;
        r5.weight = 0.0f;
    L8:
        int r10 = this.s;
        if (r10 == 0) goto L12;
        r5.leftMargin = r10;
        r5.rightMargin = r10;
        return;
    L12:
        return;
    L5:
        if (this.J != 0) goto L7;
        r5.width = 0;
        r5.weight = 1.0f;
        goto L8
    }

    public final void x(boolean r5) {
        int r10 = 0;
    L3:
        i r11 = this.f14665r;
        if (r10 >= r11.getChildCount()) goto L9;
        View r12 = r11.getChildAt(r10);
        w((LinearLayout.LayoutParams) r12.getLayoutParams());
        if (r5 == false) goto L8;
        r12.requestLayout();
    L8:
        r10 = r10 + 1;
        goto L3
    }

    public OTabLayoutBase(Context r5, AttributeSet r10) {
        this(r5, r10, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r5, int r10) {
        i(r5);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r5) {
        return generateDefaultLayoutParams();
    }

    public OTabLayoutBase(Context r20, AttributeSet r21, int r22) {
        super(r20, r21, r22);
        this.f14655m = new ArrayList();
        this.f14663q = null;
        this.f14668t = 0;
        this.f14670u = 0;
        this.E = Integer.MAX_VALUE;
        this.F = Integer.MAX_VALUE;
        this.O = new ArrayList();
        this.f14647b0 = 0;
        this.f14648c0 = null;
        this.f14649d0 = 0.0f;
        this.f14650e0 = 0.0f;
        this.f14651f0 = 0.0f;
        Paint r10 = new Paint(1);
        this.g0 = r10;
        new Paint(1);
        Paint r11 = new Paint(1);
        this.f14652h0 = r11;
        this.i0 = new RectF();
        new RectF();
        this.f14653j0 = new RectF();
        this.f14654k0 = new RectF();
        this.f14656m0 = true;
        this.f14658n0 = false;
        this.f14660o0 = false;
        this.f14662p0 = null;
        this.f14664q0 = null;
        this.f14666r0 = null;
        this.f14667s0 = null;
        this.f14669t0 = true;
        this.f14671u0 = new Rect();
        new Rect();
        this.f14673v0 = new Paint();
        m r12 = new m();
        this.f14675w0 = r12;
        this.f14679y0 = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        c r13 = new c();
        this.f14681z0 = r13;
        c r14 = new c();
        this.A0 = r14;
        this.B0 = new Pools.SimplePool(12);
        this.D0 = null;
        this.E0 = null;
        boolean r15 = p.t(r20.getResources().getConfiguration().fontScale);
        if (n.i(r20) == true) goto L5;
    L7:
        boolean r16 = false;
    L8:
        this.f14661p = r16;
        setHorizontalScrollBarEnabled(false);
        i r5 = new i(this, r20);
        this.f14665r = r5;
        r5.setDuplicateParentStateEnabled(true);
        setClipChildren(false);
        setClipToPadding(false);
        super.addView(r5, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r17 = r20.obtainStyledAttributes(r21, R$styleable.TabLayout, r22, R$style.OTabText);
        int r18 = r17.getDimensionPixelSize(R$styleable.TabLayout_tabIndicatorHeight, 0);
        if (r5.f17184h == r18) goto L11;
        r5.f17184h = r18;
        ViewCompat.postInvalidateOnAnimation(r5);
    L11:
        int r19 = r17.getColor(R$styleable.TabLayout_tabIndicatorColor, ContextCompat.getColor(getContext(), R$color.oui_accent_7));
        Paint r23 = r5.f17185i;
        if (r23.getColor() == r19) goto L14;
        r23.setColor(r19);
        ViewCompat.postInvalidateOnAnimation(r5);
    L14:
        this.f14672v = r17.getDimensionPixelSize(R$styleable.TabLayout_tabMinWidth, m(56));
        int r24 = r17.getDimensionPixelSize(R$styleable.TabLayout_tabPadding, 0);
        this.f14674w = r24;
        this.f14676x = r24;
        this.f14678y = r24;
        this.f14680z = r24;
        this.f14674w = r17.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingStart, r24);
        this.f14676x = r17.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingTop, this.f14676x);
        this.f14678y = r17.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingEnd, this.f14678y);
        this.f14680z = r17.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingBottom, this.f14680z);
        int r25 = r17.getResourceId(R$styleable.TabLayout_tabTextAppearance, R$style.TextAppearance_Design_Tab);
        int r26 = this.f14674w;
        if (r26 <= 0) goto L18;
        if (r15 == false) goto L18;
        this.f14674w = (r26 * 2) / 3;
    L18:
        int r27 = this.f14678y;
        if (r27 <= 0) goto L22;
        if (r15 == false) goto L22;
        this.f14678y = (r27 * 2) / 3;
    L22:
        TypedArray r28 = r20.obtainStyledAttributes(r25, R$styleable.TextAppearance);
        this.B = r28.getDimensionPixelSize(R$styleable.TextAppearance_android_textSize, 0);     // Catch: Throwable -> L120
        this.A = r28.getColorStateList(R$styleable.TextAppearance_android_textColor);     // Catch: Throwable -> L120
        r28.recycle();
        if (r17.hasValue(R$styleable.TabLayout_tabTextColor) == false) goto L27;
        this.A = r17.getColorStateList(R$styleable.TabLayout_tabTextColor);
    L27:
        boolean r29 = r17.hasValue(R$styleable.TabLayout_tabSelectedTextColor);
        if (r29 == false) goto L30;
        int r30 = r17.getColor(R$styleable.TabLayout_tabSelectedTextColor, 0);
    L31:
        this.G = r17.getDimensionPixelSize(R$styleable.TabLayout_tabMinWidth, -1);
        int r110 = r17.getDimensionPixelSize(R$styleable.TabLayout_tabMaxWidth, -1);
        this.H = r110;
        if (r110 <= 0) goto L34;
        this.F = r110;
    L34:
        this.D = r17.getResourceId(R$styleable.TabLayout_tabBackground, 0);
        r17.getDimensionPixelSize(R$styleable.TabLayout_tabContentStart, 0);
        this.K = r17.getInt(R$styleable.TabLayout_tabMode, 1);
        this.J = r17.getInt(R$styleable.TabLayout_tabGravity, 1);
        TypedArray r31 = r20.obtainStyledAttributes(r21, new int[]{R.attr.minHeight}, r22, 0);
        int r111 = r31.getDimensionPixelSize(0, 0);
        if (r111 <= 0) goto L37;
        setMinimumHeight(r111);
    L37:
        r31.recycle();
        TypedArray r32 = r20.obtainStyledAttributes(r21, R$styleable.OTabLayoutSupple);
        boolean r112 = r32.getBoolean(R$styleable.OTabLayoutSupple_oui_tabIndicatorFullWidth, true);     // Catch: Throwable -> L48
        if (r5.f17200y == r112) goto L41;
        r5.f17200y = r112;     // Catch: Throwable -> L48
        ViewCompat.postInvalidateOnAnimation(r5);     // Catch: Throwable -> L48
    L41:
        boolean r113 = r32.getBoolean(R$styleable.OTabLayoutSupple_oui_showBottomLine, false);     // Catch: Throwable -> L48
        r5.s = r113;     // Catch: Throwable -> L48
        if (r113 == false) goto L45;
        Paint r114 = new Paint();     // Catch: Throwable -> L48
        r5.f17197v = r114;     // Catch: Throwable -> L48
        r114.setColor(ContextCompat.getColor(r5.getContext(), R$color.oui_line_2));     // Catch: Throwable -> L48
        r5.f17197v.setStyle(Paint.Style.FILL);     // Catch: Throwable -> L48
    L45:
        r5.n(r32.getBoolean(R$styleable.OTabLayoutSupple_oui_showTopLine, false));     // Catch: Throwable -> L48
        r5.f17196u = r32.getBoolean(R$styleable.OTabLayoutSupple_oui_showSelectedIndicator, true);     // Catch: Throwable -> L48
        this.C = r32.getDimensionPixelSize(R$styleable.OTabLayoutSupple_oui_tabSelectedTextSize, 0);     // Catch: Throwable -> L48
        this.B = r32.getDimensionPixelSize(R$styleable.OTabLayoutSupple_oui_tabTextSize, (int) this.B);     // Catch: Throwable -> L48
        int r33 = r32.getResourceId(R$styleable.OTabLayoutSupple_oui_widgetShadow, R$style.OUIShadow_Oui_Shadow_Regular);     // Catch: Throwable -> L48
        if (r16 == false) goto L50;
        this.f14661p = r32.getBoolean(R$styleable.OTabLayoutSupple_oui_widgetEnableMaterial, true);     // Catch: Throwable -> L48
    L50:
        int r115 = r32.getInt(R$styleable.OTabLayoutSupple_oui_tab_spec, -1);     // Catch: Throwable -> L48
        if (r115 != 0) goto L53;
    L58:
        int r116 = m(4);     // Catch: Throwable -> L48
        r5.setPadding(r116, r116, r116, r116);     // Catch: Throwable -> L48
        m(4);     // Catch: Throwable -> L48
    L59:
        String r34 = r32.getString(R$styleable.OTabLayoutSupple_oui_widgetMaterial);     // Catch: Throwable -> L48
        if (r34 != null) goto L62;
        r34 = r20.getString(R$string.oui_material_bg_floating);     // Catch: Throwable -> L48
    L62:
        r32.recycle();
        this.I = getResources().getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
        a.t(r20, 1.5f);
        a.t(r20, 1.5f);
        this.C0 = getResources().getConfiguration().orientation;
        r17.recycle();
        TypedArray r35 = r20.obtainStyledAttributes(r21, R$styleable.OTabLayout);
        Drawable r36 = r35.getDrawable(R$styleable.OTabLayout_tab_divider);     // Catch: Throwable -> L66
        if (r36 == null) goto L68;
        r5.setDividerDrawable(r36);     // Catch: Throwable -> L66
        r5.setShowDividers(2);     // Catch: Throwable -> L66
    L68:
        this.f14646a0 = r35.getColor(R$styleable.OTabLayout_indicator_color, 0);     // Catch: Throwable -> L66
        this.f14647b0 = r35.getColor(R$styleable.OTabLayout_indicator_unselected_color, 0);     // Catch: Throwable -> L66
        Drawable r37 = r35.getDrawable(R$styleable.OTabLayout_indicator_background);     // Catch: Throwable -> L66
        this.f14648c0 = r37;     // Catch: Throwable -> L66
        this.f14649d0 = r35.getDimension(R$styleable.OTabLayout_indicator_height, -1.0f);     // Catch: Throwable -> L66
        float r38 = r35.getDimension(R$styleable.OTabLayout_indicator_corner_radius, -1.0f);     // Catch: Throwable -> L66
        this.f14651f0 = r38;     // Catch: Throwable -> L66
        if ((r37 instanceof GradientDrawable) == false) goto L71;
        ((GradientDrawable) r37).setCornerRadius(r38);     // Catch: Throwable -> L66
    L71:
        float r39 = r35.getDimension(R$styleable.OTabLayout_indicator_spacing, m(4));     // Catch: Throwable -> L66
        this.f14650e0 = r39;     // Catch: Throwable -> L66
        int r117 = r35.getColor(R$styleable.OTabLayout_bar_color, 0);     // Catch: Throwable -> L66
        this.l0 = r117;     // Catch: Throwable -> L66
        if (r117 != 0) goto L74;
        r5.setPadding(0, 0, 0, 0);     // Catch: Throwable -> L66
    L74:
        this.f14656m0 = r35.getBoolean(R$styleable.OTabLayout_indicator_anim_enable, false);     // Catch: Throwable -> L66
        this.f14658n0 = r35.getBoolean(R$styleable.OTabLayout_indicator_bounce_enable, true);     // Catch: Throwable -> L66
        boolean r118 = r35.getBoolean(R$styleable.OTabLayout_tab_edgeFadeEnabled, false);     // Catch: Throwable -> L66
        if (r12.e == r118) goto L78;
        r12.e = r118;     // Catch: Throwable -> L66
    L78:
        float r119 = RangesKt.coerceAtLeast(r35.getDimension(R$styleable.OTabLayout_tab_edgeFadeLength, (getResources().getDisplayMetrics().density * 20.0f) + 0.5f), 0.0f);     // Catch: Throwable -> L66
        if (r12.f == r119) goto L82;
        r12.f = r119;     // Catch: Throwable -> L66
        r12.f17225i = -1.0f;     // Catch: Throwable -> L66
        r12.g = null;     // Catch: Throwable -> L66
        r12.f17224h = null;     // Catch: Throwable -> L66
    L82:
        r35.getResourceId(R$styleable.OTabLayout_tab_textSelectedStyle, 0);     // Catch: Throwable -> L66
        r35.getResourceId(R$styleable.OTabLayout_tab_textStyle, 0);     // Catch: Throwable -> L66
        int r120 = r35.getColor(R$styleable.OTabLayout_tab_textPressedColor, 0);     // Catch: Throwable -> L66
        boolean r121 = r35.getBoolean(R$styleable.OTabLayout_tab_enableMaterial, false);     // Catch: Throwable -> L66
        this.f14660o0 = r121;     // Catch: Throwable -> L66
        if (r121 == false) goto L90;
        String r122 = r35.getString(R$styleable.OTabLayout_tab_material);     // Catch: Throwable -> L66
        this.f14662p0 = r122;     // Catch: Throwable -> L66
        String r123 = r35.getString(R$styleable.OTabLayout_tab_material_selected);     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r122) == false) goto L87;
        this.f14662p0 = r20.getString(R$string.oui_material_bg_floating);     // Catch: Throwable -> L66
    L87:
        this.f14664q0 = MaterialToken.parseSet(this.f14662p0, !p());     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r123) == true) goto L90;
        this.f14666r0 = MaterialToken.parseSet(r123, !p());     // Catch: Throwable -> L66
    L90:
        int r124 = r35.getResourceId(R$styleable.OTabLayout_shadow_pressed, 0);     // Catch: Throwable -> L66
        if (r124 == 0) goto L93;
        ArrayList r125 = com.obric.oui.common.style.i.o(r124, r20);     // Catch: Throwable -> L66
        ArrayList r126 = new ArrayList(2);     // Catch: Throwable -> L66
        this.f14667s0 = r126;     // Catch: Throwable -> L66
        r126.add((com.obric.oui.common.style.m) r125.get(0));     // Catch: Throwable -> L66
        r126.add((com.obric.oui.common.style.m) r125.get(1));     // Catch: Throwable -> L66
    L93:
        r35.recycle();
        if (r29 == false) goto L98;
        if (r120 == 0) goto L97;
        int r40 = this.A.getDefaultColor();
        int[] r41 = {R.attr.state_pressed, R.attr.state_selected};
        int r127 = ColorUtils.compositeColors(r120, r30);
        this.A = new ColorStateList(new int[][]{r41, new int[]{R.attr.state_pressed}, HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r127, ColorUtils.compositeColors(r120, r40), r30, r40});
        goto L98
    L97:
        this.A = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r30, this.A.getDefaultColor()});
    L98:
        ValueAnimator r42 = ValueAnimator.ofObject(new g(), new Object[]{r14, r13});
        this.f14677x0 = r42;
        r42.addUpdateListener(this);
        r10.setStyle(Paint.Style.FILL);
        r11.setStyle(Paint.Style.STROKE);
        r11.setColor(0);
        float r43 = (r39 / 2.0f) + this.f14651f0;
        if (this.f14661p == false) goto L111;
        this.f14663q = new WeakReference(this);
        com.obric.oui.material.c[] r44 = MaterialToken.parseSet(r34, !p());
        if (r44 == null) goto L111;
        n.t(this, 2, r44);
        GradientDrawable r45 = new GradientDrawable();
        r45.setShape(0);
        r45.setCornerRadius(r43);
        r45.setColor(0);
        setBackground(r45);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        if ((r37 instanceof GradientDrawable) == false) goto L106;
        ((GradientDrawable) r37).setColor(0);
    L106:
        if (Settings.Global.getInt(r20.getContentResolver(), "obric_current_effect_id", 2) != 1) goto L111;
        com.obric.oui.material.c r46 = r44[0];
        com.obric.oui.color.d r47 = r46.e;
        if (r47 == null) goto L111;
        r11.setColor(r47.f12424b);
        r11.setStrokeWidth(m((int) r46.e.f12423a));
    L111:
        if (this.f14656m0 == false) goto L113;
        r5.setShadowStyle(r33);
        r5.setShadowCornerRadius((int) this.f14651f0);
    L114:
        k();
        return;
    L113:
        r5.setShadowStyle(R$style.OUIShadow_None);
    L66:
        th = move-exception;
        r35.recycle();
        throw th;
    L53:
        if (r115 == 1) goto L58;
        if (r115 == 2) goto L57;
        r5.setPadding(m(16), m(4), m(16), m(12));     // Catch: Throwable -> L48
        goto L59
    L57:
        r5.setPadding(m(12), m(6), m(12), m(6));     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        r32.recycle();
        throw th;
    L30:
        r30 = 0;
    L120:
        th = move-exception;
        r28.recycle();
        throw th;
    L5:
        if (n.k() == false) goto L7;
        r16 = true;
        goto L8
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r5, ViewGroup.LayoutParams r10) {
        i(r5);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        i(r5);
    }

    public void setTabMode(String r5) {
        r5.getClass();
        if (r5.equals("scrollable") == true) goto L11;
        if (r5.equals("fixed") == true) goto L8;
        return;
    L8:
        if (this.K == 1) goto L14;
        this.K = 1;
        k();
        return;
    L14:
        return;
    L11:
        if (this.K == 0) goto L16;
        this.K = 0;
        k();
        return;
    }
}
