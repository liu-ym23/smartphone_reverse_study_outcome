package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.obric.cae.libs.useraware.ApWakeEvent;
import j0.h0;
import j0.w;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements j0.o, j0.l {
    public static final float K = 0.0f;
    public static final a L = null;
    public static final int[] M = null;
    public int A;
    public int B;
    public final int[] C;
    public final int[] D;
    public int E;
    public int F;
    public SavedState G;
    public final j0.p H;
    public final j0.m I;
    public float J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f1687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1688b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f1689m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OverScroller f1690n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final EdgeEffect f1691o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final EdgeEffect f1692p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1693q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1694r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1695s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f1696t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1697u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public VelocityTracker f1698v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1699w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1700x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1701y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1702z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1703a;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r8) {
                return new SavedState(r8);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r8) {
                return new SavedState[r8];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r8) {
            super(r8);
            this.f1703a = r8.readInt();
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder("HorizontalScrollView.SavedState{");
            r8.append(Integer.toHexString(System.identityHashCode(this)));
            r8.append(" scrollPosition=");
            return android.aimedia.a.h(r8, this.f1703a, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            super.writeToParcel(r8, r10);
            r8.writeInt(this.f1703a);
        }
    }

    public static class a extends j0.a {
        @Override // j0.a
        public final void c(View r8, AccessibilityEvent r10) {
            super.c(r8, r10);
            NestedScrollView r11 = (NestedScrollView) r8;
            r10.setClassName(ScrollView.class.getName());
            if (r11.getScrollRange() <= 0) goto L5;
            boolean r12 = true;
        L6:
            r10.setScrollable(r12);
            r10.setScrollX(r11.getScrollX());
            r10.setScrollY(r11.getScrollY());
            k0.h.c(r10, r11.getScrollX());
            k0.h.d(r10, r11.getScrollRange());
            return;
        L5:
            r12 = false;
            goto L6
        }

        @Override // j0.a
        public final void d(View r8, k0.f r10) {
            AccessibilityNodeInfo r11 = r10.f8890a;
            this.f8370a.onInitializeAccessibilityNodeInfo(r8, r11);
            NestedScrollView r12 = (NestedScrollView) r8;
            r10.f(ScrollView.class.getName());
            if (r12.isEnabled() == false) goto L13;
            int r13 = r12.getScrollRange();
            if (r13 <= 0) goto L14;
            r10.j(true);
            if (r12.getScrollY() <= 0) goto L10;
            r10.b(k0.f.a.f8895g);
            r10.b(k0.f.a.f8899k);
        L10:
            if (r12.getScrollY() >= r13) goto L15;
            r10.b(k0.f.a.f8894f);
            r10.b(k0.f.a.f8900l);
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // j0.a
        public final boolean g(View r8, int r10, Bundle r11) {
            if (super.g(r8, r10, r11) == false) goto L5;
            return true;
        L5:
            NestedScrollView r12 = (NestedScrollView) r8;
            if (r12.isEnabled() == true) goto L8;
            return false;
        L8:
            int r13 = r12.getHeight();
            Rect r14 = new Rect();
            if (r12.getMatrix().isIdentity() == false) goto L14;
            if (r12.getGlobalVisibleRect(r14) == false) goto L14;
            r13 = r14.height();
        L14:
            if (r10 != 4096) goto L16;
        L27:
            int r15 = (r13 - r12.getPaddingBottom()) - r12.getPaddingTop();
            int r16 = Math.min(r12.getScrollY() + r15, r12.getScrollRange());
            if (r16 == r12.getScrollY()) goto L31;
            r12.v(0 - r12.getScrollX(), true, r16 - r12.getScrollY());
            return true;
        L31:
            return false;
        L16:
            if (r10 != 8192) goto L18;
        L22:
            int r17 = (r13 - r12.getPaddingBottom()) - r12.getPaddingTop();
            int r18 = Math.max(r12.getScrollY() - r17, 0);
            if (r18 == r12.getScrollY()) goto L26;
            r12.v(0 - r12.getScrollX(), true, r18 - r12.getScrollY());
            return true;
        L26:
            return false;
        L18:
            if (r10 == 16908344) goto L22;
            if (r10 == 16908346) goto L27;
            return false;
        }
    }

    public static class b {
        public static boolean a(ViewGroup r8) {
            return r8.getClipToPadding();
        }
    }

    public interface c {
    }

    static {
        K = (float) (Math.log(0.78d) / Math.log(0.9d));
        L = new a();
        M = new int[]{R.attr.fillViewport};
    }

    public NestedScrollView(Context r8, AttributeSet r10) {
        this(r8, r10, com.obric.cae.R.attr.nestedScrollViewStyle);
    }

    private float getVerticalScrollFactorCompat() {
        if (this.J != 0.0f) goto L10;
        TypedValue r8 = new TypedValue();
        Context r10 = getContext();
        if (r10.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, r8, true) == false) goto L8;
        this.J = r8.getDimension(r10.getResources().getDisplayMetrics());
        goto L10
    L8:
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
    L10:
        return this.J;
    }

    public static boolean l(View r8, View r10) {
        if (r8 != r10) goto L5;
        return true;
    L5:
        Object r11 = r8.getParent();
        if ((r11 instanceof ViewGroup) == true) goto L8;
    L10:
        return false;
    L8:
        if (l((View) r11, r10) == false) goto L10;
        return true;
    }

    public final boolean a(int r8) {
        View r10 = findFocus();
        if (r10 != this) goto L5;
        r10 = null;
    L5:
        View r11 = FocusFinder.getInstance().findNextFocus(this, r10, r8);
        int r12 = getMaxScrollAmount();
        if (r11 == null) goto L11;
        if (p(r11, r12, getHeight()) == false) goto L11;
        Rect r13 = this.f1689m;
        r11.getDrawingRect(r13);
        offsetDescendantRectToMyCoords(r11, r13);
        d(b(r13));
        r11.requestFocus(r8);
    L26:
        if (r10 != null) goto L28;
    L32:
        return true;
    L28:
        if (r10.isFocused() == false) goto L32;
        if ((!p(r10, 0, getHeight())) == false) goto L32;
        int r14 = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(r14);
    L11:
        if (r8 == 33) goto L13;
    L15:
        if (r8 == 130) goto L17;
    L19:
        if (r12 != 0) goto L21;
        return false;
    L21:
        if (r8 == 130) goto L24;
        r12 = -r12;
    L24:
        d(r12);
        goto L26
    L17:
        if (getChildCount() <= 0) goto L19;
        View r15 = getChildAt(0);
        r12 = Math.min((r15.getBottom() + ((FrameLayout.LayoutParams) r15.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), r12);
        goto L19
    L13:
        if (getScrollY() >= r12) goto L15;
        r12 = getScrollY();
        goto L19
    }

    @Override // android.view.ViewGroup
    public final void addView(View r8) {
        if (getChildCount() > 0) goto L7;
        super.addView(r8);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public final int b(Rect r11) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        int r8 = getHeight();
        int r10 = getScrollY();
        int r12 = r10 + r8;
        int r13 = getVerticalFadingEdgeLength();
        if (r11.top <= 0) goto L8;
        r10 = r10 + r13;
    L8:
        View r14 = getChildAt(0);
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14.getLayoutParams();
        if (r11.bottom >= ((r14.getHeight() + r15.topMargin) + r15.bottomMargin)) goto L11;
        int r16 = r12 - r13;
    L12:
        int r17 = r11.bottom;
        if (r17 <= r16) goto L22;
        if (r11.top <= r10) goto L22;
        if (r11.height() <= r8) goto L19;
        int r18 = r11.top - r10;
    L30:
        return Math.min(r18 + 0, (r14.getBottom() + r15.bottomMargin) - r12);
    L19:
        r18 = r11.bottom - r16;
    L22:
        if (r11.top >= r10) goto L31;
        if (r17 < r16) goto L25;
        return 0;
    L25:
        if (r11.height() <= r8) goto L27;
        int r19 = 0 - (r16 - r11.bottom);
    L29:
        return Math.max(r19, -getScrollY());
    L27:
        r19 = 0 - (r10 - r11.top);
        goto L29
    L31:
        return 0;
    L11:
        r16 = r12;
        goto L12
    }

    public final boolean c(int r8, int r10, int[] r11, int[] r12, int r13) {
        return this.I.c(r8, r10, r11, r12, r13);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f1690n.isFinished() == false) goto L5;
        return;
    L5:
        this.f1690n.computeScrollOffset();
        int r8 = this.f1690n.getCurrY();
        int r10 = r8 - this.F;
        int r11 = getHeight();
        EdgeEffect r12 = this.f1692p;
        EdgeEffect r13 = this.f1691o;
        if (r10 > 0) goto L8;
    L12:
        if (r10 < 0) goto L14;
    L19:
        this.F = r8;
        int[] r14 = this.D;
        boolean r15 = false;
        r14[1] = 0;
        c(0, r10, r14, null, 1);
        int r16 = r10 - r14[1];
        int r17 = getScrollRange();
        if (r16 == 0) goto L22;
        int r18 = getScrollY();
        s(r16, getScrollX(), r18, r17);
        int r19 = getScrollY() - r18;
        int r20 = r16 - r19;
        r14[1] = 0;
        this.I.e(0, r19, 0, r20, this.C, 1, r14);
        r16 = r20 - r14[1];
    L22:
        if (r16 == 0) goto L38;
        int r21 = getOverScrollMode();
        if (r21 == 0) goto L27;
        if (r21 != 1) goto L28;
        if (r17 > 0) goto L27;
    L28:
        if (r15 == false) goto L36;
        if (r16 >= 0) goto L34;
        if (r13.isFinished() == false) goto L36;
        r13.onAbsorb((int) this.f1690n.getCurrVelocity());
        goto L36
    L34:
        if (r12.isFinished() == false) goto L36;
        r12.onAbsorb((int) this.f1690n.getCurrVelocity());
    L36:
        this.f1690n.abortAnimation();
        y(1);
    L27:
        r15 = true;
    L38:
        if (this.f1690n.isFinished() == true) goto L40;
        WeakHashMap<View, h0> r22 = w.f8437a;
        w.d.k(this);
        return;
    L40:
        y(1);
        return;
    L14:
        if (e.b(r12) == 0.0f) goto L19;
        float r23 = r11;
        int r24 = Math.round(e.c(r12, (r10 * 4.0f) / r23, 0.5f) * (r23 / 4.0f));
        if (r24 == r10) goto L18;
        r12.finish();
    L18:
        r10 = r10 - r24;
        goto L19
    L8:
        if (e.b(r13) == 0.0f) goto L12;
        r24 = Math.round(e.c(r13, ((-r10) * 4.0f) / r11, 0.5f) * ((-r11) / 4.0f));
        if (r24 == r10) goto L18;
        r13.finish();
        goto L18
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int r8 = getChildCount();
        int r10 = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (r8 != 0) goto L5;
        return r10;
    L5:
        View r11 = getChildAt(0);
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r11.getLayoutParams();
        int r13 = r11.getBottom() + r12.bottomMargin;
        int r14 = getScrollY();
        int r15 = Math.max(0, r13 - r10);
        if (r14 < 0) goto L11;
        if (r14 > r15) goto L10;
        return r13;
    L10:
        return r13 + (r14 - r15);
    L11:
        return r13 - r14;
    }

    public final void d(int r8) {
        if (r8 != 0) goto L4;
        return;
    L4:
        if (this.f1700x == false) goto L6;
        v(0, false, r8);
        return;
    L6:
        scrollBy(0, r8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r8) {
        if (super.dispatchKeyEvent(r8) == false) goto L5;
    L8:
        return true;
    L5:
        if (f(r8) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float r8, float r10, boolean r11) {
        return this.I.a(r8, r10, r11);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float r8, float r10) {
        return this.I.b(r8, r10);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int r8, int r10, int[] r11, int[] r12) {
        return c(r8, r10, r11, r12, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14) {
        return this.I.e(r10, r11, r12, r13, r14, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas r11) {
        super.draw(r11);
        int r8 = getScrollY();
        EdgeEffect r10 = this.f1691o;
        int r12 = 0;
        if (r10.isFinished() == true) goto L15;
        int r13 = r11.save();
        int r14 = getWidth();
        int r15 = getHeight();
        int r16 = Math.min(0, r8);
        if (b.a(this) == false) goto L7;
        r14 = r14 - (getPaddingRight() + getPaddingLeft());
        int r17 = getPaddingLeft() + 0;
    L9:
        if (b.a(this) == false) goto L11;
        r15 = r15 - (getPaddingBottom() + getPaddingTop());
        r16 = r16 + getPaddingTop();
    L11:
        r11.translate(r17, r16);
        r10.setSize(r14, r15);
        if (r10.draw(r11) == false) goto L14;
        WeakHashMap<View, h0> r18 = w.f8437a;
        w.d.k(this);
    L14:
        r11.restoreToCount(r13);
        goto L15
    L7:
        r17 = 0;
    L15:
        EdgeEffect r19 = this.f1692p;
        if (r19.isFinished() == true) goto L28;
        int r20 = r11.save();
        int r21 = getWidth();
        int r22 = getHeight();
        int r23 = Math.max(getScrollRange(), r8) + r22;
        if (b.a(this) == false) goto L21;
        r21 = r21 - (getPaddingRight() + getPaddingLeft());
        r12 = 0 + getPaddingLeft();
    L21:
        if (b.a(this) == false) goto L23;
        r22 = r22 - (getPaddingBottom() + getPaddingTop());
        r23 = r23 - getPaddingBottom();
    L23:
        r11.translate(r12 - r21, r23);
        r11.rotate(180.0f, r21, 0.0f);
        r19.setSize(r21, r22);
        if (r19.draw(r11) == false) goto L26;
        WeakHashMap<View, h0> r24 = w.f8437a;
        w.d.k(this);
    L26:
        r11.restoreToCount(r20);
        return;
    }

    public final void e() {
        this.f1697u = false;
        VelocityTracker r8 = this.f1698v;
        if (r8 == null) goto L5;
        r8.recycle();
        this.f1698v = null;
    L5:
        y(0);
        this.f1691o.onRelease();
        this.f1692p.onRelease();
    }

    public final boolean f(KeyEvent r8) {
        Rect r10 = this.f1689m;
        r10.setEmpty();
        if (getChildCount() <= 0) goto L7;
        View r11 = getChildAt(0);
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r11.getLayoutParams();
        if (((r11.getHeight() + r12.topMargin) + r12.bottomMargin) <= ((getHeight() - getPaddingTop()) - getPaddingBottom())) goto L7;
        boolean r13 = true;
    L9:
        if (r13 == true) goto L27;
        if (isFocused() == true) goto L13;
    L25:
        return false;
    L13:
        if (r8.getKeyCode() == 4) goto L25;
        View r14 = findFocus();
        if (r14 != this) goto L17;
        r14 = null;
    L17:
        View r15 = FocusFinder.getInstance().findNextFocus(this, r14, ApWakeEvent.ACCELERATING_START);
        if (r15 == null) goto L24;
        if (r15 == this) goto L24;
        if (r15.requestFocus(ApWakeEvent.ACCELERATING_START) == false) goto L24;
        return true;
    L24:
        return false;
    L27:
        if (r8.getAction() != 0) goto L63;
        int r16 = r8.getKeyCode();
        int r17 = 33;
        if (r16 == 19) goto L58;
        if (r16 == 20) goto L54;
        if (r16 == 62) goto L36;
        return false;
    L36:
        if (r8.isShiftPressed() == true) goto L39;
        r17 = 130;
    L39:
        if (r17 != 130) goto L41;
        boolean r18 = true;
    L42:
        int r19 = getHeight();
        if (r18 == false) goto L49;
        r10.top = getScrollY() + r19;
        int r20 = getChildCount();
        if (r20 <= 0) goto L52;
        View r21 = getChildAt(r20 - 1);
        int r22 = getPaddingBottom() + (r21.getBottom() + ((FrameLayout.LayoutParams) r21.getLayoutParams()).bottomMargin);
        if ((r10.top + r19) <= r22) goto L52;
        r10.top = r22 - r19;
    L52:
        int r23 = r10.top;
        int r24 = r19 + r23;
        r10.bottom = r24;
        t(r17, r23, r24);
        return false;
    L49:
        int r25 = getScrollY() - r19;
        r10.top = r25;
        if (r25 >= 0) goto L52;
        r10.top = 0;
        goto L52
    L41:
        r18 = false;
        goto L42
    L54:
        if (r8.isAltPressed() == true) goto L66;
        return a(ApWakeEvent.ACCELERATING_START);
    L66:
        return h(ApWakeEvent.ACCELERATING_START);
    L58:
        if (r8.isAltPressed() == true) goto L61;
        return a(33);
    L61:
        return h(33);
    L63:
        return false;
    L7:
        r13 = false;
        goto L9
    }

    public final void g(int r13) {
        if (getChildCount() <= 0) goto L6;
        this.f1690n.fling(getScrollX(), getScrollY(), 0, r13, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        w(2, 1);
        this.F = getScrollY();
        WeakHashMap<View, h0> r14 = w.f8437a;
        w.d.k(this);
        return;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() != 0) goto L6;
        return 0.0f;
    L6:
        View r8 = getChildAt(0);
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r8.getLayoutParams();
        int r11 = getVerticalFadingEdgeLength();
        int r12 = ((r8.getBottom() + r10.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (r12 < r11) goto L9;
        return 1.0f;
    L9:
        return r12 / r11;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        j0.p r8 = this.H;
        int r10 = r8.f8432a;
        return r8.f8433b | r10;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) goto L6;
        View r8 = getChildAt(0);
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r8.getLayoutParams();
        return Math.max(0, ((r8.getHeight() + r10.topMargin) + r10.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    L6:
        return 0;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() != 0) goto L6;
        return 0.0f;
    L6:
        int r8 = getVerticalFadingEdgeLength();
        int r10 = getScrollY();
        if (r10 < r8) goto L9;
        return 1.0f;
    L9:
        return r10 / r8;
    }

    public final boolean h(int r8) {
        if (r8 != 130) goto L5;
        boolean r10 = true;
    L6:
        int r11 = getHeight();
        Rect r12 = this.f1689m;
        r12.top = 0;
        r12.bottom = r11;
        if (r10 == false) goto L12;
        int r13 = getChildCount();
        if (r13 <= 0) goto L12;
        View r14 = getChildAt(r13 - 1);
        r12.bottom = getPaddingBottom() + (r14.getBottom() + ((FrameLayout.LayoutParams) r14.getLayoutParams()).bottomMargin);
        r12.top = r12.bottom - r11;
    L12:
        return t(r8, r12.top, r12.bottom);
    L5:
        r10 = false;
        goto L6
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        if (this.I.f(0) == null) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // j0.n
    public final void i(View r8, View r10, int r11, int r12) {
        j0.p r13 = this.H;
        if (r12 != 1) goto L5;
        r13.f8433b = r11;
    L6:
        w(2, r12);
        return;
    L5:
        r13.f8432a = r11;
        goto L6
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.I.f8406d;
    }

    @Override // j0.n
    public final void j(View r8, int r10) {
        j0.p r11 = this.H;
        if (r10 != 1) goto L5;
        r11.f8433b = 0;
    L6:
        y(r10);
        return;
    L5:
        r11.f8432a = 0;
        goto L6
    }

    @Override // j0.n
    public final void k(View r8, int r10, int r11, int[] r12, int r13) {
        c(r10, r11, r12, null, r13);
    }

    @Override // j0.o
    public final void m(View r8, int r10, int r11, int r12, int r13, int r14, int[] r15) {
        q(r13, r14, r15);
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View r8, int r10, int r11) {
        ViewGroup.LayoutParams r12 = r8.getLayoutParams();
        int r13 = getPaddingLeft();
        r8.measure(FrameLayout.getChildMeasureSpec(r10, getPaddingRight() + r13, r12.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View r8, int r10, int r11, int r12, int r13) {
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
        int r15 = getPaddingLeft();
        r8.measure(FrameLayout.getChildMeasureSpec(r10, (((getPaddingRight() + r15) + r14.leftMargin) + r14.rightMargin) + r11, r14.width), View.MeasureSpec.makeMeasureSpec(r14.topMargin + r14.bottomMargin, 0));
    }

    @Override // j0.n
    public final void n(View r8, int r10, int r11, int r12, int r13, int r14) {
        q(r13, r14, null);
    }

    @Override // j0.n
    public final boolean o(View r8, View r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1695s = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent r10) {
        int r8 = 0;
        if (r10.getAction() == 8) goto L5;
    L56:
        return false;
    L5:
        if (this.f1697u == true) goto L56;
        if (t2.b.I(r10, 2) == false) goto L10;
        int r11 = 9;
    L12:
        float r12 = r10.getAxisValue(r11);
    L15:
        if (r12 == 0.0f) goto L56;
        int r13 = (int) (r12 * getVerticalScrollFactorCompat());
        int r14 = getScrollRange();
        int r15 = getScrollY();
        int r16 = r15 - r13;
        if (r16 >= 0) goto L34;
        int r17 = getOverScrollMode();
        if (r17 == 0) goto L25;
        if (r17 == 1) goto L22;
    L24:
        boolean r18 = false;
    L26:
        if (r18 == true) goto L28;
    L30:
        boolean r19 = false;
    L31:
        if (r19 == false) goto L33;
        float r20 = (-r16) / getHeight();
        EdgeEffect r21 = this.f1691o;
        e.c(r21, r20, 0.5f);
        r21.onRelease();
        invalidate();
        boolean r22 = 1;
    L52:
        if (r8 == r15) goto L55;
        super.scrollTo(getScrollX(), r8);
        return true;
    L55:
        return r22;
    L33:
        r22 = 0;
        goto L52
    L28:
        if (t2.b.I(r10, 8194) == true) goto L30;
        r19 = true;
        goto L31
    L22:
        if (getScrollRange() <= 0) goto L24;
    L25:
        r18 = true;
        goto L26
    L34:
        if (r16 <= r14) goto L51;
        int r23 = getOverScrollMode();
        if (r23 == 0) goto L42;
        if (r23 == 1) goto L39;
    L41:
        boolean r24 = false;
    L43:
        if (r24 == true) goto L45;
    L47:
        boolean r25 = false;
    L48:
        if (r25 == false) goto L50;
        float r26 = (r16 - r14) / getHeight();
        EdgeEffect r27 = this.f1692p;
        e.c(r27, r26, 0.5f);
        r27.onRelease();
        invalidate();
        r8 = 1;
    L50:
        r22 = r8;
        r8 = r14;
        goto L52
    L45:
        if (t2.b.I(r10, 8194) == true) goto L47;
        r25 = true;
        goto L48
    L39:
        if (getScrollRange() <= 0) goto L41;
    L42:
        r24 = true;
        goto L43
    L51:
        r22 = 0;
        r8 = r16;
        goto L52
    L10:
        if (t2.b.I(r10, 4194304) == false) goto L13;
        r11 = 26;
        goto L12
    L13:
        r12 = 0.0f;
        goto L15
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r13) {
        int r8 = r13.getAction();
        boolean r10 = true;
        if (r8 == 2) goto L5;
    L7:
        int r11 = r8 & 255;
        if (r11 != 0) goto L10;
        int r12 = (int) r13.getY();
        int r14 = (int) r13.getX();
        if (getChildCount() <= 0) goto L52;
        int r15 = getScrollY();
        View r16 = getChildAt(0);
        if (r12 < (r16.getTop() - r15)) goto L52;
        if (r12 >= (r16.getBottom() - r15)) goto L52;
        if (r14 < r16.getLeft()) goto L52;
        if (r14 >= r16.getRight()) goto L52;
        boolean r17 = true;
    L53:
        if (r17 == false) goto L55;
        this.f1693q = r12;
        this.B = r13.getPointerId(0);
        VelocityTracker r18 = this.f1698v;
        if (r18 != null) goto L66;
        this.f1698v = VelocityTracker.obtain();
    L67:
        this.f1698v.addMovement(r13);
        this.f1690n.computeScrollOffset();
        if (x(r13) == false) goto L70;
    L73:
        this.f1697u = r10;
        w(2, 0);
    L75:
        return this.f1697u;
    L70:
        if (this.f1690n.isFinished() == false) goto L73;
        r10 = false;
        goto L73
    L66:
        r18.clear();
        goto L67
    L55:
        if (x(r13) == false) goto L57;
    L60:
        this.f1697u = r10;
        VelocityTracker r19 = this.f1698v;
        if (r19 == null) goto L75;
        r19.recycle();
        this.f1698v = null;
        goto L75
    L57:
        if (this.f1690n.isFinished() == false) goto L60;
        r10 = false;
    L52:
        r17 = false;
        goto L53
    L10:
        if (r11 == 1) goto L34;
        if (r11 != 2) goto L13;
        int r20 = this.B;
        if (r20 == (-1)) goto L75;
        int r21 = r13.findPointerIndex(r20);
        if (r21 != (-1)) goto L24;
        Log.e("NestedScrollView", "Invalid pointerId=" + r20 + " in onInterceptTouchEvent");
        goto L75
    L24:
        int r22 = (int) r13.getY(r21);
        if (Math.abs(r22 - this.f1693q) <= this.f1701y) goto L75;
        if ((2 & getNestedScrollAxes()) != 0) goto L75;
        this.f1697u = true;
        this.f1693q = r22;
        if (this.f1698v != null) goto L31;
        this.f1698v = VelocityTracker.obtain();
    L31:
        this.f1698v.addMovement(r13);
        this.E = 0;
        ViewParent r110 = getParent();
        if (r110 == null) goto L75;
        r110.requestDisallowInterceptTouchEvent(true);
        goto L75
    L13:
        if (r11 == 3) goto L34;
        if (r11 != 6) goto L75;
        r(r13);
    L34:
        this.f1697u = false;
        this.B = -1;
        VelocityTracker r111 = this.f1698v;
        if (r111 == null) goto L38;
        r111.recycle();
        this.f1698v = null;
    L38:
        if (this.f1690n.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L40;
        WeakHashMap<View, h0> r112 = w.f8437a;
        w.d.k(this);
    L40:
        y(0);
        goto L75
    L5:
        if (this.f1697u == false) goto L7;
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        int r14 = 0;
        this.f1694r = false;
        View r15 = this.f1696t;
        if (r15 != null) goto L5;
    L9:
        this.f1696t = null;
        if (this.f1695s == false) goto L12;
    L28:
        scrollTo(getScrollX(), getScrollY());
        this.f1695s = true;
        return;
    L12:
        if (this.G == null) goto L15;
        scrollTo(getScrollX(), this.G.f1703a);
        this.G = null;
    L15:
        if (getChildCount() <= 0) goto L17;
        View r16 = getChildAt(0);
        FrameLayout.LayoutParams r17 = (FrameLayout.LayoutParams) r16.getLayoutParams();
        int r18 = (r16.getMeasuredHeight() + r17.topMargin) + r17.bottomMargin;
    L18:
        int r19 = ((r13 - r11) - getPaddingTop()) - getPaddingBottom();
        int r20 = getScrollY();
        if (r19 >= r18) goto L26;
        if (r20 < 0) goto L26;
        if ((r19 + r20) <= r18) goto L25;
        r14 = r18 - r19;
        goto L26
    L25:
        r14 = r20;
    L26:
        if (r14 == r20) goto L28;
        scrollTo(getScrollX(), r14);
        goto L28
    L17:
        r18 = 0;
        goto L18
    L5:
        if (l(r15, this) == false) goto L9;
        View r21 = this.f1696t;
        Rect r22 = this.f1689m;
        r21.getDrawingRect(r22);
        offsetDescendantRectToMyCoords(r21, r22);
        int r23 = b(r22);
        if (r23 == 0) goto L9;
        scrollBy(0, r23);
        goto L9
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
        if (this.f1699w == true) goto L6;
        return;
    L6:
        if (View.MeasureSpec.getMode(r10) != 0) goto L9;
        return;
    L9:
        if (getChildCount() <= 0) goto L14;
        View r11 = getChildAt(0);
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r11.getLayoutParams();
        int r13 = r11.getMeasuredHeight();
        int r14 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - r12.topMargin) - r12.bottomMargin;
        if (r13 >= r14) goto L15;
        int r15 = getPaddingLeft();
        r11.measure(FrameLayout.getChildMeasureSpec(r8, ((getPaddingRight() + r15) + r12.leftMargin) + r12.rightMargin, r12.width), View.MeasureSpec.makeMeasureSpec(r14, 1073741824));
        return;
    L15:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r8, float r10, float r11, boolean r12) {
        if (r12 == true) goto L5;
        dispatchNestedFling(0.0f, r11, true);
        g((int) r11);
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r8, float r10, float r11) {
        return dispatchNestedPreFling(r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r8, int r10, int r11, int[] r12) {
        k(r8, r10, r11, r12, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View r8, int r10, int r11, int r12, int r13) {
        q(r13, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View r8, View r10, int r11) {
        i(r8, r10, r11, 0);
    }

    @Override // android.view.View
    public final void onOverScrolled(int r8, int r10, boolean r11, boolean r12) {
        super.scrollTo(r8, r10);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int r8, Rect r10) {
        if (r8 != 2) goto L5;
        r8 = ApWakeEvent.ACCELERATING_START;
    L7:
        FocusFinder r11 = FocusFinder.getInstance();
        if (r10 != null) goto L10;
        View r12 = r11.findNextFocus(this, null, r8);
    L12:
        if (r12 != null) goto L15;
        return false;
    L15:
        if ((!p(r12, 0, getHeight())) == false) goto L18;
        return false;
    L18:
        return r12.requestFocus(r8, r10);
    L10:
        r12 = r11.findNextFocusFromRect(this, r10, r8);
        goto L12
    L5:
        if (r8 != 1) goto L7;
        r8 = 33;
        goto L7
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        if ((r8 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r8);
        return;
    L6:
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.getSuperState());
        this.G = r10;
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState(super.onSaveInstanceState());
        r8.f1703a = getScrollY();
        return r8;
    }

    @Override // android.view.View
    public final void onScrollChanged(int r8, int r10, int r11, int r12) {
        super.onScrollChanged(r8, r10, r11, r12);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r8, int r10, int r11, int r12) {
        super.onSizeChanged(r8, r10, r11, r12);
        View r13 = findFocus();
        if (r13 == null) goto L10;
        if (this != r13) goto L7;
        return;
    L7:
        if (p(r13, 0, r12) == false) goto L11;
        Rect r14 = this.f1689m;
        r13.getDrawingRect(r14);
        offsetDescendantRectToMyCoords(r13, r14);
        d(b(r14));
        return;
    L11:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r8, View r10, int r11) {
        return o(r8, r10, r11, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r8) {
        j(r8, 0);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r26) {
        if (this.f1698v != null) goto L5;
        this.f1698v = VelocityTracker.obtain();
    L5:
        int r8 = r26.getActionMasked();
        if (r8 != 0) goto L8;
        this.E = 0;
    L8:
        MotionEvent r10 = MotionEvent.obtain(r26);
        float r11 = 0.0f;
        r10.offsetLocation(0.0f, this.E);
        if (r8 == 0) goto L123;
        EdgeEffect r12 = this.f1692p;
        EdgeEffect r13 = this.f1691o;
        if (r8 == 1) goto L98;
        if (r8 != 2) goto L14;
        int r14 = r26.findPointerIndex(this.B);
        if (r14 != (-1)) goto L32;
        Log.e("NestedScrollView", "Invalid pointerId=" + this.B + " in onTouchEvent");
    L135:
        VelocityTracker r15 = this.f1698v;
        if (r15 == null) goto L138;
        r15.addMovement(r10);
    L138:
        r10.recycle();
        return true;
    L32:
        int r16 = (int) r26.getY(r14);
        int r17 = this.f1693q - r16;
        float r18 = r26.getX(r14) / getWidth();
        float r19 = r17 / getHeight();
        if (e.b(r13) == 0.0f) goto L39;
        float r20 = -e.c(r13, -r19, r18);
        if (e.b(r13) != 0.0f) goto L37;
        EdgeEffect r21 = r13;
    L43:
        r21.onRelease();
    L37:
        r11 = r20;
    L44:
        int r22 = Math.round(r11 * getHeight());
        if (r22 == 0) goto L47;
        invalidate();
    L47:
        int r23 = r17 - r22;
        if (this.f1697u == false) goto L50;
    L58:
        int r110 = r23;
        if (this.f1697u == false) goto L135;
        boolean r24 = c(0, r110, this.D, this.C, 0);
        int[] r25 = this.D;
        int[] r27 = this.C;
        if (r24 == false) goto L63;
        r110 = r110 - r25[1];
        this.E += r27[1];
    L63:
        int r28 = r110;
        this.f1693q = r16 - r27[1];
        int r29 = getScrollY();
        int r30 = getScrollRange();
        int r31 = getOverScrollMode();
        if (r31 == 0) goto L69;
        if (r31 != 1) goto L68;
        if (r30 > 0) goto L69;
    L68:
        boolean r32 = false;
    L71:
        if (s(r28, 0, getScrollY(), r30) == true) goto L73;
    L78:
        boolean r111 = false;
    L79:
        int r112 = getScrollY() - r29;
        r25[1] = 0;
        int[] r33 = this.C;
        this.I.e(0, r112, 0, r28 - r112, r33, 0, r25);
        int r34 = this.f1693q;
        int r35 = r27[1];
        this.f1693q = r34 - r35;
        this.E += r35;
        if (r32 == false) goto L95;
        int r36 = r28 - r25[1];
        int r37 = r29 + r36;
        if (r37 >= 0) goto L86;
        e.c(r13, (-r36) / getHeight(), r26.getX(r14) / getWidth());
        if (r12.isFinished() == true) goto L91;
        r12.onRelease();
    L91:
        if (r13.isFinished() == true) goto L93;
    L94:
        WeakHashMap<View, h0> r38 = w.f8437a;
        w.d.k(this);
        boolean r39 = false;
    L96:
        if (r39 == false) goto L135;
        this.f1698v.clear();
        goto L135
    L93:
        if (r12.isFinished() == true) goto L95;
    L86:
        if (r37 <= r30) goto L91;
        e.c(r12, r36 / getHeight(), 1.0f - (r26.getX(r14) / getWidth()));
        if (r13.isFinished() == true) goto L91;
        r13.onRelease();
    L95:
        r39 = r111;
        goto L96
    L73:
        if (this.I.f(0) == null) goto L75;
        boolean r113 = true;
    L76:
        if (r113 == true) goto L78;
        r111 = true;
        goto L79
    L75:
        r113 = false;
    L69:
        r32 = true;
        goto L71
    L50:
        if (Math.abs(r23) <= this.f1701y) goto L58;
        ViewParent r40 = getParent();
        if (r40 == null) goto L54;
        r40.requestDisallowInterceptTouchEvent(true);
    L54:
        this.f1697u = true;
        int r41 = this.f1701y;
        if (r23 <= 0) goto L57;
        r23 = r23 - r41;
        goto L58
    L57:
        r23 = r23 + r41;
        goto L58
    L39:
        if (e.b(r12) == 0.0f) goto L44;
        r20 = e.c(r12, r19, 1.0f - r18);
        if (e.b(r12) != 0.0f) goto L37;
        r21 = r12;
        goto L43
    L14:
        if (r8 == 3) goto L23;
        if (r8 != 5) goto L18;
        int r42 = r26.getActionIndex();
        this.f1693q = (int) r26.getY(r42);
        this.B = r26.getPointerId(r42);
        goto L135
    L18:
        if (r8 != 6) goto L135;
        r(r26);
        this.f1693q = (int) r26.getY(r26.findPointerIndex(this.B));
        goto L135
    L23:
        if (this.f1697u == true) goto L25;
    L121:
        this.B = -1;
        e();
        goto L135
    L25:
        if (getChildCount() <= 0) goto L121;
        if (this.f1690n.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L121;
    L120:
        WeakHashMap<View, h0> r43 = w.f8437a;
        w.d.k(this);
        goto L121
    L98:
        VelocityTracker r44 = this.f1698v;
        r44.computeCurrentVelocity(1000, this.A);
        int r45 = (int) r44.getYVelocity(this.B);
        if (Math.abs(r45) < this.f1702z) goto L119;
        if (e.b(r13) == 0.0f) goto L107;
        if (u(r13, r45) == false) goto L105;
        int r46 = r45;
        r12 = r13;
    L110:
        r12.onAbsorb(r46);
    L112:
        boolean r47 = true;
    L114:
        if (r47 == true) goto L121;
        int r48 = -r45;
        float r49 = r48;
        if (dispatchNestedPreFling(0.0f, r49) == true) goto L121;
        dispatchNestedFling(0.0f, r49, true);
        g(r48);
        goto L121
    L105:
        r46 = -r45;
    L111:
        g(r46);
        goto L112
    L107:
        if (e.b(r12) == 0.0f) goto L113;
        r46 = -r45;
        if (u(r12, r46) == false) goto L111;
    L113:
        r47 = false;
        goto L114
    L119:
        if (this.f1690n.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L121;
    L123:
        if (getChildCount() != 0) goto L127;
        return false;
    L127:
        if (this.f1697u == false) goto L132;
        ViewParent r50 = getParent();
        if (r50 == null) goto L132;
        r50.requestDisallowInterceptTouchEvent(true);
    L132:
        if (this.f1690n.isFinished() == true) goto L134;
        this.f1690n.abortAnimation();
        y(1);
    L134:
        this.f1693q = (int) r26.getY();
        this.B = r26.getPointerId(0);
        w(2, 0);
        goto L135
    }

    public final boolean p(View r8, int r10, int r11) {
        Rect r12 = this.f1689m;
        r8.getDrawingRect(r12);
        offsetDescendantRectToMyCoords(r8, r12);
        if ((r12.bottom + r10) >= getScrollY()) goto L5;
    L7:
        return false;
    L5:
        if ((r12.top - r10) > (getScrollY() + r11)) goto L7;
        return true;
    }

    public final void q(int r8, int r10, int[] r11) {
        int r12 = getScrollY();
        scrollBy(0, r8);
        int r13 = getScrollY() - r12;
        if (r11 == null) goto L5;
        r11[1] = r11[1] + r13;
    L5:
        j0.m r14 = this.I;
        r14.d(r13, r8 - r13, r10, r11);
    }

    public final void r(MotionEvent r8) {
        int r10 = r8.getActionIndex();
        if (r8.getPointerId(r10) != this.B) goto L11;
        if (r10 != 0) goto L6;
        int r11 = 1;
    L7:
        this.f1693q = (int) r8.getY(r11);
        this.B = r8.getPointerId(r11);
        VelocityTracker r12 = this.f1698v;
        if (r12 == null) goto L12;
        r12.clear();
        return;
    L12:
        return;
    L6:
        r11 = 0;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View r8, View r10) {
        if (this.f1694r == true) goto L7;
        Rect r11 = this.f1689m;
        r10.getDrawingRect(r11);
        offsetDescendantRectToMyCoords(r10, r11);
        int r12 = b(r11);
        if (r12 == 0) goto L8;
        scrollBy(0, r12);
    L8:
        super.requestChildFocus(r8, r10);
        return;
    L7:
        this.f1696t = r10;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View r8, Rect r10, boolean r11) {
        r10.offset(r8.getLeft() - r8.getScrollX(), r8.getTop() - r8.getScrollY());
        int r12 = b(r10);
        if (r12 == 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L10;
        if (r11 == false) goto L9;
        scrollBy(0, r12);
        goto L10
    L9:
        v(0, false, r12);
    L10:
        return r13;
    L5:
        r13 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r8) {
        if (r8 == false) goto L6;
        VelocityTracker r10 = this.f1698v;
        if (r10 == null) goto L6;
        r10.recycle();
        this.f1698v = null;
    L6:
        super.requestDisallowInterceptTouchEvent(r8);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f1694r = true;
        super.requestLayout();
    }

    public final boolean s(int r10, int r11, int r12, int r13) {
        getOverScrollMode();
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int r14 = r11 + 0;
        int r15 = r12 + r10;
        int r16 = r13 + 0;
        if (r14 <= 0) goto L5;
    L4:
        r14 = 0;
        boolean r17 = true;
    L8:
        if (r15 <= r16) goto L11;
        r15 = r16;
    L10:
        boolean r18 = true;
    L14:
        if (r18 == true) goto L16;
    L21:
        onOverScrolled(r14, r15, r17, r18);
        if (r17 == true) goto L27;
        if (r18 == false) goto L26;
        return true;
    L26:
        return false;
    L27:
        return true;
    L16:
        if (this.I.f(1) == null) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == true) goto L21;
        this.f1690n.springBack(r14, r15, 0, 0, 0, getScrollRange());
        goto L21
    L18:
        r8 = false;
        goto L19
    L11:
        if (r15 >= 0) goto L13;
        r15 = 0;
        goto L10
    L13:
        r18 = false;
        goto L14
    L5:
        if (r14 < 0) goto L4;
        r17 = false;
        goto L8
    }

    @Override // android.view.View
    public final void scrollTo(int r8, int r10) {
        if (getChildCount() <= 0) goto L25;
        View r11 = getChildAt(0);
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r11.getLayoutParams();
        int r13 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r14 = (r11.getWidth() + r12.leftMargin) + r12.rightMargin;
        int r15 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r16 = (r11.getHeight() + r12.topMargin) + r12.bottomMargin;
        if (r13 >= r14) goto L11;
        if (r8 < 0) goto L11;
        if ((r13 + r8) <= r14) goto L12;
        r8 = r14 - r13;
    L12:
        if (r15 >= r16) goto L18;
        if (r10 < 0) goto L18;
        if ((r15 + r10) <= r16) goto L20;
        r10 = r16 - r15;
    L20:
        if (r8 == getScrollX()) goto L22;
    L23:
        super.scrollTo(r8, r10);
        return;
    L22:
        if (r10 != getScrollY()) goto L23;
        return;
    L18:
        r10 = 0;
    L11:
        r8 = 0;
        goto L12
    }

    public void setFillViewport(boolean r8) {
        if (r8 == this.f1699w) goto L6;
        this.f1699w = r8;
        requestLayout();
        return;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r8) {
        j0.m r10 = this.I;
        if (r10.f8406d == false) goto L5;
        WeakHashMap<View, h0> r11 = w.f8437a;
        w.i.z(r10.f8405c);
    L5:
        r10.f8406d = r8;
    }

    public void setOnScrollChangeListener(c r8) {
    }

    public void setSmoothScrollingEnabled(boolean r8) {
        this.f1700x = r8;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int r8) {
        return w(r8, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        y(0);
    }

    public final boolean t(int r18, int r19, int r20) {
        int r8 = getHeight();
        int r10 = getScrollY();
        int r11 = r8 + r10;
        if (r18 != 33) goto L5;
        boolean r12 = true;
    L6:
        ArrayList r13 = getFocusables(2);
        int r14 = r13.size();
        View r15 = null;
        int r16 = 0;
        boolean r17 = false;
    L7:
        if (r16 >= r14) goto L34;
        View r110 = (View) r13.get(r16);
        int r111 = r110.getTop();
        int r21 = r110.getBottom();
        if (r19 >= r21) goto L33;
        if (r111 >= r20) goto L33;
        if (r19 >= r111) goto L14;
        if (r21 >= r20) goto L14;
        boolean r112 = true;
    L15:
        if (r15 != null) goto L17;
        r15 = r110;
        r17 = r112;
        goto L33
    L17:
        if (r12 == true) goto L19;
    L20:
        if (r12 == false) goto L22;
    L24:
        boolean r22 = false;
    L25:
        if (r17 == false) goto L29;
        if (r112 == false) goto L33;
        if (r22 == false) goto L33;
    L32:
        r15 = r110;
        goto L33
    L29:
        if (r112 == false) goto L31;
        r15 = r110;
        r17 = true;
        goto L33
    L31:
        if (r22 == false) goto L33;
    L22:
        if (r21 <= r15.getBottom()) goto L24;
    L23:
        r22 = true;
        goto L25
    L19:
        if (r111 < r15.getTop()) goto L23;
    L14:
        r112 = false;
    L33:
        r16 = r16 + 1;
        goto L7
    L34:
        if (r15 != null) goto L36;
        r15 = this;
    L36:
        if (r19 < r10) goto L39;
        if (r20 > r11) goto L39;
        boolean r23 = false;
    L44:
        if (r15 == findFocus()) goto L46;
        r15.requestFocus(r18);
    L46:
        return r23;
    L39:
        if (r12 == false) goto L41;
        int r24 = r19 - r10;
    L42:
        d(r24);
        r23 = true;
        goto L44
    L41:
        r24 = r20 - r11;
        goto L42
    L5:
        r12 = false;
        goto L6
    }

    public final boolean u(EdgeEffect r10, int r11) {
        if (r11 <= 0) goto L5;
        return true;
    L5:
        float r12 = e.b(r10) * getHeight();
        float r13 = Math.abs(-r11) * 0.35f;
        float r14 = this.f1687a * 0.015f;
        double r8 = Math.log(r13 / r14);
        double r15 = K;
        if (((float) (Math.exp((r15 / (r15 - 1.0d)) * r8) * ((double) r14))) < r12) goto L10;
        return false;
    L10:
        return true;
    }

    public final void v(int r8, boolean r10, int r11) {
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if ((AnimationUtils.currentAnimationTimeMillis() - this.f1688b) <= 250) goto L13;
        View r12 = getChildAt(0);
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12.getLayoutParams();
        int r14 = (r12.getHeight() + r13.topMargin) + r13.bottomMargin;
        int r15 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r16 = getScrollY();
        int r17 = r11 + r16;
        int r18 = Math.max(0, Math.min(r17, Math.max(0, r14 - r15))) - r16;
        this.f1690n.startScroll(getScrollX(), r16, 0, r18, 250);
        if (r10 == false) goto L10;
        w(2, 1);
    L11:
        this.F = getScrollY();
        WeakHashMap<View, h0> r19 = w.f8437a;
        w.d.k(this);
    L16:
        this.f1688b = AnimationUtils.currentAnimationTimeMillis();
        return;
    L10:
        y(1);
        goto L11
    L13:
        if (this.f1690n.isFinished() == true) goto L15;
        this.f1690n.abortAnimation();
        y(1);
    L15:
        scrollBy(r8, r11);
        goto L16
    }

    public final boolean w(int r8, int r10) {
        return this.I.g(r8, r10);
    }

    public final boolean x(MotionEvent r8) {
        EdgeEffect r10 = this.f1691o;
        if (e.b(r10) == 0.0f) goto L5;
        e.c(r10, 0.0f, r8.getX() / getWidth());
        boolean r11 = true;
    L6:
        EdgeEffect r12 = this.f1692p;
        if (e.b(r12) == 0.0f) goto L10;
        e.c(r12, 0.0f, 1.0f - (r8.getX() / getWidth()));
        return true;
    L10:
        return r11;
    L5:
        r11 = false;
        goto L6
    }

    public final void y(int r8) {
        this.I.h(r8);
    }

    public NestedScrollView(Context r8, AttributeSet r10, int r11) {
        super(r8, r10, r11);
        this.f1689m = new Rect();
        this.f1694r = true;
        this.f1695s = false;
        this.f1696t = null;
        this.f1697u = false;
        this.f1700x = true;
        this.B = -1;
        this.C = new int[2];
        this.D = new int[2];
        this.f1691o = e.a(r8, r10);
        this.f1692p = e.a(r8, r10);
        this.f1687a = ((r8.getResources().getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;
        this.f1690n = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration r12 = ViewConfiguration.get(getContext());
        this.f1701y = r12.getScaledTouchSlop();
        this.f1702z = r12.getScaledMinimumFlingVelocity();
        this.A = r12.getScaledMaximumFlingVelocity();
        TypedArray r13 = r8.obtainStyledAttributes(r10, M, r11, 0);
        setFillViewport(r13.getBoolean(0, false));
        r13.recycle();
        this.H = new j0.p();
        this.I = new j0.m(this);
        setNestedScrollingEnabled(true);
        w.m(this, L);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r8, int r10) {
        if (getChildCount() > 0) goto L7;
        super.addView(r8, r10);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public final void addView(View r8, int r10, ViewGroup.LayoutParams r11) {
        if (getChildCount() > 0) goto L7;
        super.addView(r8, r10, r11);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r8, ViewGroup.LayoutParams r10) {
        if (getChildCount() > 0) goto L7;
        super.addView(r8, r10);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
