package com.zte.miboard.cards.common.views;

import ai.j0;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.viewpager.widget.ViewPager;
import c.m;
import com.obric.oui.indicator.OBaseIndicator;
import com.obric.oui.indicator.OCarouselIndicator;
import com.zte.miboard.cards.R;

/* JADX INFO: loaded from: classes3.dex */
public class CardPagerContainer extends FrameLayout {
    private static int A = 400;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16249c;
    private int d;
    private OverScroller e;
    private int f;
    private ViewOutlineProvider g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f16250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private OCarouselIndicator f16251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ViewPager.OnPageChangeListener f16252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f16253k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f16254l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f16255m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f16256n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f16257o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f16258p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f16259q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f16260r;
    private boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f16261t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f16262u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f16263v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f16264w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f16265x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f16266y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private VelocityTracker f16267z;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CardPagerContainer f16268a;

        public a(CardPagerContainer r5) {
            this.f16268a = r5;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            int r5 = r10.getWidth();
            int r12 = r10.getHeight();
            Object r13 = r10.getTag(R.id.card_pager_container_child_outline_left_int_tag);
            Object r14 = r10.getTag(R.id.card_pager_container_child_outline_right_int_tag);
            Object r15 = r10.getTag(R.id.card_pager_container_child_outline_parent_anim_height_int_tag);
            if ((r10.getParent() instanceof ViewGroup) == false) goto L6;
            ((ViewGroup) r10.getParent()).getMeasuredHeight();
        L6:
            if ((r15 instanceof Integer) == false) goto L11;
            Integer r16 = (Integer) r15;
            if (r16.intValue() <= 0) goto L11;
            r12 = Math.min(r16.intValue(), r10.getHeight());
        L11:
            if ((r13 instanceof Integer) == false) goto L17;
            Integer r17 = (Integer) r13;
            if (r17.intValue() <= 0) goto L17;
            if (r17.intValue() >= r10.getWidth()) goto L17;
            int r18 = r17.intValue();
        L19:
            if ((r14 instanceof Integer) == false) goto L25;
            Integer r19 = (Integer) r14;
            if (r19.intValue() <= 0) goto L25;
            if (r19.intValue() >= r10.getWidth()) goto L25;
            r5 = r19.intValue();
        L25:
            r11.setRoundRect(new Rect(r18 - 1, -1, r5 - (-1), r12 - (-1)), CardPagerContainer.a(this.f16268a));
            return;
        L17:
            r18 = 0;
            goto L19
        }
    }

    public CardPagerContainer(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ int a(CardPagerContainer r5) {
        return r5.f;
    }

    private void b() {
        VelocityTracker r5 = this.f16267z;
        if (r5 == null) goto L6;
        r5.clear();
        this.f16267z.recycle();
        this.f16267z = null;
        return;
    }

    public void c() {
        a(0, true);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.e.computeScrollOffset() == true) goto L5;
        return;
    L5:
        if (this.e.getCurrX() == this.e.getFinalX()) goto L7;
    L9:
        scrollTo(this.e.getCurrX(), this.e.getCurrY());
        invalidate();
        return;
    L7:
        if (getScrollX() == this.e.getFinalX()) goto L9;
        this.e.forceFinished(true);
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        int r5 = getChildCount();
        if (r5 <= 1) goto L102;
        if (this.f16248b <= 0) goto L102;
        a(r10);
        if (r10.getAction() != 0) goto L14;
        this.f16253k = r10.getRawX();
        this.f16254l = r10.getRawX();
        this.f16255m = r10.getRawY();
        this.f16257o = 0.0f;
        this.f16256n = 0.0f;
        this.f16260r = false;
        this.f16264w = 0.0f;
        this.s = false;
        this.f16261t = false;
        this.f16262u = false;
        if (this.e.isFinished() == false) goto L12;
        this.f16263v = false;
    L93:
        if (this.s == false) goto L96;
        getParent().requestDisallowInterceptTouchEvent(false);
        return super.dispatchTouchEvent(r10);
    L96:
        getParent().requestDisallowInterceptTouchEvent(!this.s);
        if (this.f16263v == false) goto L100;
        return true;
    L100:
        return super.dispatchTouchEvent(r10);
    L12:
        this.f16263v = true;
        this.e.abortAnimation();
        goto L93
    L14:
        if (r10.getAction() != 2) goto L61;
        this.f16256n = Math.abs(r10.getRawX() - this.f16254l) + this.f16256n;
        float r11 = Math.abs(r10.getRawY() - this.f16255m) + this.f16257o;
        this.f16257o = r11;
        if (this.f16263v == false) goto L26;
        float r12 = (this.f16254l + this.f16264w) - r10.getRawX();
        if (Math.abs(r12) <= 1.0f) goto L24;
        int r13 = (int) r12;
        scrollBy(r13, 0);
        float r14 = Math.abs(r12 - r13);
        if (r12 > 0.0f) goto L23;
        r14 = -r14;
    L23:
        this.f16264w = r14;
    L59:
        this.f16254l = r10.getRawX();
        this.f16255m = r10.getRawY();
        goto L93
    L24:
        r14 = this.f16264w + r12;
        goto L23
    L26:
        if (this.f16260r == true) goto L59;
        if (this.f16256n <= this.f16258p) goto L30;
    L31:
        this.f16260r = true;
        a();
        if (this.f16256n >= this.f16257o) goto L34;
        boolean r15 = true;
    L35:
        this.f16261t = r15;
        if (getScrollX() >= ((r5 - 1) * this.f16248b)) goto L38;
    L42:
        boolean r16 = false;
    L43:
        this.f16262u = r16;
        if (this.f16261t == true) goto L48;
        if (r16 == true) goto L48;
        boolean r17 = false;
    L49:
        this.s = r17;
        if (r17 == true) goto L59;
        this.f16263v = true;
        float r18 = r10.getRawX() - this.f16253k;
        if (r18 <= 0.0f) goto L54;
        float r19 = r18 - this.f16258p;
    L55:
        int r20 = (int) r19;
        if (Math.abs(r18) >= this.f16258p) goto L58;
        r20 = 0;
    L58:
        scrollBy(-r20, 0);
        goto L59
    L54:
        r19 = this.f16258p + r18;
    L48:
        r17 = true;
        goto L49
    L38:
        if (this.f16256n <= this.f16257o) goto L42;
        if (r10.getRawX() >= this.f16253k) goto L42;
        r16 = true;
        goto L43
    L34:
        r15 = false;
        goto L35
    L30:
        if (r11 <= this.f16259q) goto L59;
    L61:
        if (r10.getAction() == 3) goto L65;
        if (r10.getAction() != 1) goto L93;
    L65:
        if (this.f16263v == false) goto L91;
        this.f16267z.computeCurrentVelocity(1000, this.f16265x);
        float r21 = r10.getRawX() - this.f16253k;
        int r22 = (int) this.f16267z.getXVelocity();
        if (Math.abs(r21) <= (getMeasuredWidth() * 0.18f)) goto L69;
        boolean r23 = true;
    L71:
        if (this.f16256n > this.f16258p) goto L73;
    L75:
        boolean r24 = false;
    L76:
        float r25 = (getScrollX() * 1.0f) / this.f16248b;
        int r26 = this.d;
        if (r23 == true) goto L87;
        if (r24 == true) goto L87;
        if (this.f16260r == true) goto L90;
        r26 = (int) r25;
        if (Math.abs(Math.round(r25) - r26) < 1) goto L90;
        r26 = Math.round(r25);
    L90:
        a(r26, false);
    L87:
        if (r21 <= 0.0f) goto L89;
    L88:
        r26 = (int) r25;
        goto L90
    L89:
        r25 = r25 + 1.0f;
        goto L88
    L73:
        if (Math.abs(r22) <= this.f16266y) goto L75;
        r24 = true;
        goto L76
    L69:
        r23 = false;
    L91:
        a(this);
        b();
    L102:
        return super.dispatchTouchEvent(r10);
    }

    public int getCurrentPageIndex() {
        return this.d;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        if (getChildCount() > 0) goto L6;
        super.onLayout(r5, r10, r11, r12, r13);
        return;
    L6:
        int r14 = getPaddingLeft();
        int r15 = getPaddingTop();
        int r16 = 0;
    L8:
        if (r16 >= getChildCount()) goto L10;
        View r17 = getChildAt(r16);
        Rect r18 = new Rect(r14, r15, r17.getMeasuredWidth() + r14, r17.getMeasuredHeight() + r15);
        r17.layout(r18.left, r18.top, r18.right, r18.bottom);
        r14 = r18.right + this.f16247a;
        r16 = r16 + 1;
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        if (this.f16249c > 0) goto L6;
        int r11 = View.MeasureSpec.getSize(r5);
        this.f16249c = r11;
        this.f16248b = r11 + this.f16247a;
    L6:
        if (getChildCount() > 0) goto L9;
        super.onMeasure(r5, r10);
        return;
    L9:
        int r12 = this.f16249c;
        int r13 = a(true, r10);
        if (r13 <= 0) goto L12;
        setMeasuredDimension(r12, r13);
        return;
    L12:
        super.onMeasure(r5, r10);
    }

    @Override // android.view.View
    public void onScrollChanged(int r5, int r10, int r11, int r12) {
        super.onScrollChanged(r5, r10, r11, r12);
        int r13 = this.f16248b;
        if (r13 > 0) goto L7;
        m.i("CardPagerContainer", "onScrollChanged getMeasuredWidth 0 return, l=" + r5 + " oldl=" + r11);
        return;
    L7:
        if ((r5 % r13) != 0) goto L18;
        int r14 = r5 / r13;
        StringBuilder r15 = j0.v("onScrollChanged l=", r5, r11, " oldl=", " curIndex=");
        r15.append(r14);
        r15.append(" mCurrentPageIndex=");
        r15.append(this.d);
        m.i("CardPagerContainer", r15.toString());
        if (this.d == r14) goto L33;
        this.d = r14;
        ViewPager.OnPageChangeListener r16 = this.f16252j;
        if (r16 == null) goto L14;
        r16.onPageSelected(r14);
        this.f16252j.onPageScrolled(this.d, 0.0f, 0);
    L14:
        if (this.f16251i != null) goto L16;
        return;
    L16:
        if (getChildCount() <= 1) goto L35;
        this.f16251i.setManualCurrentItem(r14);
        return;
    L35:
        return;
    L33:
        return;
    L18:
        int r17 = r5 / r13;
        int r18 = r5 - (r17 * r13);
        float r19 = (r18 * 1.0f) / r13;
        ViewPager.OnPageChangeListener r20 = this.f16252j;
        if (r20 == null) goto L22;
        r20.onPageScrolled(r17, r19, r18);
    L22:
        if (this.f16251i != null) goto L24;
        return;
    L24:
        if (getChildCount() <= 1) goto L38;
        int r21 = this.d;
        if (r21 == r17) goto L28;
        int r22 = r17;
    L29:
        if (r21 == r17) goto L31;
        r19 = 1.0f - r19;
    L31:
        this.f16251i.p(r19, r21, r22);
        return;
    L28:
        r22 = r21 + 1;
        goto L29
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r5) {
        super.onViewAdded(r5);
        r5.setTag(R.id.card_pager_container_child_outline_left_int_tag, null);
        r5.setTag(R.id.card_pager_container_child_outline_right_int_tag, null);
        r5.setTag(R.id.card_pager_container_child_outline_parent_anim_height_int_tag, null);
        r5.setOutlineProvider(this.g);
        r5.setClipToOutline(true);
        OCarouselIndicator r10 = this.f16251i;
        if (r10 == null) goto L6;
        r10.setManualPager(getChildCount());
        return;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r5) {
        super.onViewRemoved(r5);
        r5.setOutlineProvider(null);
        r5.setClipToOutline(false);
        if (this.f16251i != null) goto L5;
        return;
    L5:
        if (getChildCount() > 1) goto L7;
        OCarouselIndicator r10 = this.f16251i;
        int r11 = getChildCount();
        r10.getClass();
        OBaseIndicator.m(r10, r11, 0, 4);
        return;
    L7:
        if (getCurrentPageIndex() < getChildCount()) goto L9;
        OCarouselIndicator r12 = this.f16251i;
        int r13 = getChildCount();
        int r14 = getChildCount() - 1;
        r12.getClass();
        OBaseIndicator.m(r12, r13, r14, 4);
        return;
    L9:
        this.f16251i.setManualPager(getChildCount());
    }

    @Override // android.view.View
    public void scrollTo(int r10, int r11) {
        if (this.f16248b > 0) goto L5;
    L13:
        super.scrollTo(r10, r11);
        a(false, 0);
        return;
    L5:
        if (getChildCount() <= 1) goto L7;
        int r5 = (getChildCount() - 1) * this.f16248b;
    L9:
        if (r10 <= r5) goto L11;
        m.n("CardPagerContainer", "scrollTo x > max, x= " + r10 + " max= " + r5);
        r10 = r5;
    L11:
        if (r10 >= 0) goto L13;
        m.n("CardPagerContainer", "scrollTo x < min, x= " + r10 + " min= 0");
        r10 = 0;
        goto L13
    L7:
        r5 = 0;
        goto L9
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r5) {
        this.f16252j = r5;
    }

    public void setPageIndicator(OCarouselIndicator r5) {
        this.f16251i = r5;
    }

    public CardPagerContainer(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    private void a(MotionEvent r5) {
        if (this.f16267z != null) goto L5;
        this.f16267z = VelocityTracker.obtain();
    L5:
        this.f16267z.addMovement(r5);
    }

    public CardPagerContainer(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f16247a = getResources().getDimensionPixelOffset(R.dimen.card_pager_layout_container_middle_gap);
        this.f16248b = 0;
        this.f16249c = 0;
        this.d = 0;
        this.e = new OverScroller(getContext(), new PathInterpolator(0.33f, 1.0f, 0.68f, 1.0f));
        this.f = getResources().getDimensionPixelSize(R.dimen.miboard_card_bg_radius);
        this.g = new a(this);
        this.f16250h = -1;
        this.f16258p = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f16259q = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f16260r = false;
        this.f16261t = false;
        this.f16262u = false;
        this.f16263v = false;
        this.f16265x = ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity();
        this.f16266y = (int) (getResources().getDisplayMetrics().density * 500.0f);
    }

    private void a() {
        cancelLongPress();
        int r5 = 0;
    L4:
        if (r5 >= getChildCount()) goto L6;
        getChildAt(r5).cancelLongPress();
        r5 = r5 + 1;
        goto L4
    L6:
        a(this);
    }

    private void a(View r5) {
        if (this.f16260r == true) goto L5;
        return;
    L5:
        if (this != r5) goto L7;
        clearFocus();
    L7:
        int r10 = 0;
        if ((r5 instanceof ViewGroup) == false) goto L15;
        ViewGroup r11 = (ViewGroup) r5;
        if (r11.isPressed() == false) goto L13;
        r11.setPressed(false);
    L13:
        if (r10 >= r11.getChildCount()) goto L24;
        a(r11.getChildAt(r10));
        r10 = r10 + 1;
        goto L13
    L24:
        return;
    L15:
        if (r5 != null) goto L17;
        return;
    L17:
        if (r5.isPressed() == false) goto L23;
        r5.setPressed(false);
        return;
    }

    private int a(boolean r14, int r15) {
        if (this.f16249c > 0) goto L5;
    L85:
        return 0;
    L5:
        if (this.f16248b <= 0) goto L85;
        if (r14 == true) goto L12;
        if (getScrollX() != this.f16250h) goto L12;
        return 0;
    L12:
        if (getChildCount() > 0) goto L14;
        return 0;
    L14:
        this.f16250h = getScrollX();
        float r5 = (getScrollX() * 1.0f) / this.f16248b;
        int r10 = (int) r5;
        float r11 = r5 - r10;
        if (r10 >= 0) goto L17;
    L20:
        r11 = 0.0f;
        r10 = 0;
    L21:
        int r12 = View.MeasureSpec.makeMeasureSpec((this.f16249c - getPaddingLeft()) - getPaddingRight(), BasicMeasure.EXACTLY);
        if (Float.compare(r5, r10) != 0) goto L38;
        int r13 = 0;
        int r16 = 0;
        View r17 = null;
        View r18 = null;
    L25:
        if (r13 >= getChildCount()) goto L57;
        View r19 = getChildAt(r13);
        if (r14 == true) goto L29;
    L35:
        if (r10 != r13) goto L37;
        r16 = r19.getMeasuredHeight();
        r17 = r19;
        r18 = r17;
    L37:
        r13 = r13 + 1;
        goto L25
    L29:
        if (r19.getLayoutParams() != null) goto L31;
    L33:
        int r110 = r15;
    L34:
        r19.measure(r12, r110);
        goto L35
    L31:
        if (r19.getLayoutParams().height <= 0) goto L33;
        r110 = View.MeasureSpec.makeMeasureSpec(r19.getLayoutParams().height, BasicMeasure.EXACTLY);
    L57:
        if (r17 == null) goto L61;
        if (r18 == null) goto L61;
        if (r17 == r18) goto L61;
        int r111 = Math.round(this.f16248b * r11);
        int r20 = this.f16249c;
        int r21 = r20 - ((r20 - r111) + this.f16247a);
        int r112 = Math.min(r20, r111);
    L62:
        int r22 = 0;
    L64:
        if (r22 >= getChildCount()) goto L79;
        View r23 = getChildAt(r22);
        r23.setTag(R.id.card_pager_container_child_outline_left_int_tag, null);
        r23.setTag(R.id.card_pager_container_child_outline_right_int_tag, null);
        r23.setTag(R.id.card_pager_container_child_outline_parent_anim_height_int_tag, null);
        if (r23 != r17) goto L69;
        if (r23 != r18) goto L69;
    L68:
        int r24 = 0;
        int r25 = 0;
        int r113 = 0;
    L74:
        r23.setTag(R.id.card_pager_container_child_outline_left_int_tag, Integer.valueOf(r113));
        r23.setTag(R.id.card_pager_container_child_outline_right_int_tag, Integer.valueOf(r25));
        r23.setTag(R.id.card_pager_container_child_outline_parent_anim_height_int_tag, Integer.valueOf(r24));
        if (r23 == r17) goto L77;
        if (r23 == r18) goto L77;
    L78:
        r22 = r22 + 1;
    L77:
        r23.invalidateOutline();
    L69:
        if (r23 != r17) goto L72;
        r113 = r112;
        r25 = 0;
    L71:
        r24 = r16;
        goto L74
    L72:
        if (r23 != r18) goto L68;
        r113 = 0;
        r25 = r21;
        goto L71
    L79:
        if (r14 == true) goto L84;
        if (r16 <= 0) goto L84;
        if (getMeasuredHeight() == r16) goto L84;
        setLayoutParams(getLayoutParams());
    L84:
        return r16;
    L61:
        r112 = 0;
        r21 = 0;
        goto L62
    L38:
        int r26 = 0;
        int r27 = 0;
        int r114 = 0;
        r17 = null;
        r18 = null;
    L40:
        if (r26 >= getChildCount()) goto L56;
        View r115 = getChildAt(r26);
        if (r14 == true) goto L44;
    L50:
        if (r10 != r26) goto L53;
        r27 = r115.getMeasuredHeight();
        r17 = r115;
    L55:
        r26 = r26 + 1;
        goto L40
    L53:
        if ((r10 + 1) != r26) goto L55;
        r114 = r115.getMeasuredHeight();
        r18 = r115;
        goto L55
    L44:
        if (r115.getLayoutParams() != null) goto L46;
    L48:
        int r116 = r15;
    L49:
        r115.measure(r12, r116);
        goto L50
    L46:
        if (r115.getLayoutParams().height <= 0) goto L48;
        r116 = View.MeasureSpec.makeMeasureSpec(r115.getLayoutParams().height, BasicMeasure.EXACTLY);
        goto L49
    L56:
        r16 = r27 + Math.round((r114 - r27) * r11);
        goto L57
    L17:
        if (r10 >= getChildCount()) goto L20;
        if (Math.ceil(r5) < getChildCount()) goto L21;
        goto L20
    }

    public void a(int r13, boolean r14) {
        int r5 = 0;
        if (getChildCount() > 1) goto L6;
        scrollTo(0, 0);
        m.n("CardPagerContainer", "snapToPage child count <= 1, getChildCount=" + getChildCount() + " toIndex=" + r13 + " toX=0 getScrollX=" + getScrollX());
        this.e.startScroll(getScrollX(), 0, 0 - getScrollX(), 0, 0);
        invalidate();
        return;
    L6:
        if (r13 >= 0) goto L8;
    L19:
        StringBuilder r15 = j0.s(r13, "snapToPage toIndex error, toIndex=", " getChildCount=");
        r15.append(getChildCount());
        m.l("CardPagerContainer", r15.toString());
        return;
    L8:
        if (r13 >= getChildCount()) goto L19;
        int r10 = (getMeasuredWidth() + this.f16247a) * r13;
        if (r10 != getScrollX()) goto L14;
        StringBuilder r16 = j0.v("snapToPage ignore, toIndex=", r13, r10, " toX=", " getScrollX=");
        r16.append(getScrollX());
        m.n("CardPagerContainer", r16.toString());
        return;
    L14:
        if (r14 == false) goto L16;
    L15:
        int r11 = r5;
        StringBuilder r17 = j0.v("snapToPage toIndex=", r13, r10, " toX=", " getScrollX=");
        r17.append(getScrollX());
        m.i("CardPagerContainer", r17.toString());
        this.e.startScroll(getScrollX(), 0, r10 - getScrollX(), 0, r11);
        invalidate();
        return;
    L16:
        r5 = A;
        goto L15
    }
}
