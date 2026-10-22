package com.obric.oui.segmentedtab;

import android.R;
import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.obric.oui.layout.OUIFrameLayout;
import ge.q;
import he.i;
import he.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class OBottomNavActionBar extends OUIFrameLayout implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    public static final /* synthetic */ int N = 0;
    public boolean A;
    public int B;
    public float C;
    public float D;
    public float E;
    public int F;
    public int G;
    public db.d H;
    public db.d I;
    public final float J;
    public final float K;
    public final float L;
    public List<View> M;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Context f6511q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LinearLayout f6512r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6513s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Rect f6514t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f6515u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f6516v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6517w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f6518x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f6519y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f6520z;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f6521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f6522b;

        public a() {
        }

        public final String toString() {
            return "(left = " + this.f6521a + ", right = " + this.f6522b + ')';
        }
    }

    public final class b implements TypeEvaluator<a> {
        public b(OBottomNavActionBar r8) {
        }

        @Override // android.animation.TypeEvaluator
        public final a evaluate(float r8, a r10, a r11) {
            a r12 = r10;
            a r13 = r11;
            i.f(r12, "startValue");
            i.f(r13, "endValue");
            float r14 = r12.f6521a;
            float r15 = defpackage.a.a(r13.f6521a, r14, r8, r14);
            float r16 = r12.f6522b;
            float r17 = defpackage.a.a(r13.f6522b, r16, r8, r16);
            a r18 = new a();
            r18.f6521a = r15;
            r18.f6522b = r17;
            return r18;
        }
    }

    public interface c {
    }

    public interface d {
    }

    public static final class e extends j implements q<String, Object, Object, xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OBottomNavActionBar f6523a;

        public e(OBottomNavActionBar r8) {
            this.f6523a = r8;
            super(3);
        }

        @Override // ge.q
        public final xd.j invoke(String r8, Object r10, Object r11) {
            String r12 = r8;
            i.f(r12, "property");
            i.f(r10, "currentValue");
            i.f(r11, "velocity");
            hb.a r13 = hb.a.f8015b;
            if (i.a(r12, "scaleX") == false) goto L6;
            int r14 = OBottomNavActionBar.N;
            this.f6523a.getClass();
            ((Float) r10).floatValue();
        L6:
            return xd.j.f13877a;
        }
    }

    public static final class f extends j implements q<String, Object, Object, xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OBottomNavActionBar f6524a;

        public f(OBottomNavActionBar r8) {
            this.f6524a = r8;
            super(3);
        }

        @Override // ge.q
        public final xd.j invoke(String r8, Object r10, Object r11) {
            String r12 = r8;
            i.f(r12, "property");
            i.f(r10, "currentValue");
            i.f(r11, "velocity");
            hb.a r13 = hb.a.f8015b;
            if (i.a(r12, "scaleX") == false) goto L6;
            int r14 = OBottomNavActionBar.N;
            this.f6524a.getClass();
            ((Float) r10).floatValue();
        L6:
            return xd.j.f13877a;
        }
    }

    public OBottomNavActionBar(Context r10, AttributeSet r11) {
        i.f(r10, "context");
        super(r10, r11, 0, 8);
        this.f6514t = new Rect();
        new Rect();
        new Paint();
        new Paint(1);
        this.f6520z = 350;
        this.A = true;
        new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        new Paint(1).setStyle(Paint.Style.FILL);
        xd.j r8 = xd.j.f13877a;
        new Paint(1).setStyle(Paint.Style.STROKE);
        new RectF();
        new RectF();
        this.J = 0.988f;
        this.K = 0.01f;
        this.L = 1.0f;
        this.M = new ArrayList();
        new Paint(1);
        new SparseArray();
        a r12 = new a();
        a r13 = new a();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f6511q = r10;
        this.f6512r = new LinearLayout(r10);
        OUIFrameLayout r14 = new OUIFrameLayout(r10, null, 0, 14);
        Resources r15 = Resources.getSystem();
        i.e(r15, "Resources.getSystem()");
        r14.setRadius(l6.a.I0(TypedValue.applyDimension(1, 99, r15.getDisplayMetrics())));
        addView(r14);
        i.c(r11);
        String r16 = r11.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (r16 == null) goto L16;
        int r17 = r16.hashCode();
        if (r17 == 1444) goto L14;
        if (r17 != 1445) goto L16;
        if (r16.equals("-2") == false) goto L16;
    L17:
        ValueAnimator r18 = ValueAnimator.ofObject(new b(this), new Object[]{r13, r12});
        i.e(r18, "ValueAnimator.ofObject(P…tor(), mLastP, mCurrentP)");
        r18.addUpdateListener(this);
        r18.addListener(this);
        return;
    L14:
        if (r16.equals("-1") == true) goto L17;
    L16:
        TypedArray r19 = r10.obtainStyledAttributes(r11, new int[]{R.attr.layout_height});
        i.e(r19, "context.obtainStyledAttributes(attrs, systemAttrs)");
        r19.getDimensionPixelSize(0, -2);
        r19.recycle();
        goto L17
    }

    private final void setFragments(int r8) {
    }

    public final void b(boolean r8) {
        db.d r10 = this.H;
        if (r10 == null) goto L5;
        db.d.a(r10);
    L5:
        db.d r11 = this.I;
        if (r11 == null) goto L8;
        db.d.a(r11);
    L8:
        float r12 = this.K;
        if (r8 == false) goto L11;
        za.a.C0206a r13 = defpackage.c.p(this);
        hb.a r14 = hb.a.f8015b;
        Float r15 = Float.valueOf(getScaleX());
        hb.e[] r16 = hb.e.f8026a;
        hb.f[] r17 = hb.f.f8027a;
        gb.b r18 = l6.a.N0();
        r18.f7789b = r12;
        xd.j r19 = xd.j.f13877a;
        float r20 = this.J;
        za.a.C0206a.b(r13, r14, r15, r20, r18);
        hb.a r21 = hb.a.f8016m;
        Float r22 = Float.valueOf(getScaleY());
        gb.b r23 = l6.a.N0();
        r23.f7789b = r12;
        za.a.C0206a.b(r13, r21, r22, r20, r23);
        r13.f14326d = new e(this);
        this.H = za.a.a(r13.a());
        return;
    L11:
        za.a.C0206a r24 = defpackage.c.p(this);
        hb.a r25 = hb.a.f8015b;
        Float r26 = Float.valueOf(getScaleX());
        hb.e[] r27 = hb.e.f8026a;
        hb.f[] r28 = hb.f.f8027a;
        gb.b r29 = l6.a.N0();
        r29.f7789b = r12;
        xd.j r30 = xd.j.f13877a;
        float r31 = this.L;
        za.a.C0206a.b(r24, r25, r26, r31, r29);
        hb.a r32 = hb.a.f8016m;
        Float r33 = Float.valueOf(getScaleY());
        gb.b r34 = l6.a.N0();
        r34.f7789b = r12;
        za.a.C0206a.b(r24, r32, r33, r31, r34);
        r24.f14326d = new f(this);
        this.I = za.a.a(r24.a());
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        i.f(r8, "event");
        int r10 = r8.getAction();
        if (r10 == 0) goto L9;
        if (r10 != 1) goto L6;
    L8:
        b(false);
    L11:
        return super.dispatchTouchEvent(r8);
    L6:
        if (r10 == 3) goto L8;
    L9:
        b(true);
        goto L11
    }

    public final Fragment getCurrentFragment() {
        return null;
    }

    public final int getCurrentTab() {
        return this.f6513s;
    }

    public final int getDividerColor() {
        return this.B;
    }

    public final float getDividerPadding() {
        return this.D;
    }

    public final float getDividerWidth() {
        return this.C;
    }

    public final long getIndicatorAnimDuration() {
        return this.f6520z;
    }

    public final int getIndicatorColor() {
        return this.f6517w;
    }

    public final float getIndicatorCornerRadius() {
        return this.f6519y;
    }

    public final float getIndicatorHeight() {
        return this.f6518x;
    }

    public final int getIndicatorSpacing() {
        return 0;
    }

    public final int getTabCount() {
        return 0;
    }

    public final List<View> getTabList() {
        return this.M;
    }

    public final float getTabPadding() {
        return this.f6515u;
    }

    public final float getTabWidth() {
        return this.f6516v;
    }

    public final int getTextSelectColor() {
        return this.F;
    }

    public final float getTextSize() {
        return this.E;
    }

    public final int getTextUnselectColor() {
        return this.G;
    }

    public final int h(float r8) {
        Resources r10 = this.f6511q.getResources();
        i.e(r10, "mContext.resources");
        return (int) ((r8 * r10.getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r8) {
        i.f(r8, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        i.f(r8, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r8) {
        i.f(r8, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r8) {
        i.f(r8, "animation");
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r8) {
        i.f(r8, "animation");
        Object r10 = r8.getAnimatedValue();
        if (r10 == null) goto L7;
        a r11 = (a) r10;
        int r12 = (int) r11.f6521a;
        Rect r13 = this.f6514t;
        r13.left = r12;
        r13.right = (int) r11.f6522b;
        r8.getAnimatedFraction();
        h(2.0f);
        invalidate();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.segmentedtab.OBottomNavActionBar.IndicatorPoint");
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        i.f(r8, "canvas");
        super.onDraw(r8);
        isInEditMode();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        i.f(r8, "state");
        if ((r8 instanceof Bundle) == false) goto L7;
        Bundle r10 = (Bundle) r8;
        this.f6513s = r10.getInt("mCurrentTab");
        r8 = r10.getParcelable("instanceState");
        if (this.f6513s == 0) goto L7;
        this.f6512r.getChildCount();
    L7:
        super.onRestoreInstanceState(r8);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r8 = new Bundle();
        r8.putParcelable("instanceState", super.onSaveInstanceState());
        r8.putInt("mCurrentTab", this.f6513s);
        return r8;
    }

    public final void setCurrentTab(int r8) {
        if (r8 != this.f6513s) goto L5;
        return;
    L5:
        this.f6513s = r8;
        setFragments(r8);
        if (this.A == true) goto L9;
        invalidate();
        return;
    L9:
        i.c(null);
        throw null;
    }

    public final void setDividerColor(int r8) {
        this.B = r8;
        invalidate();
    }

    public final void setDividerPadding(float r8) {
        this.D = h(r8);
        invalidate();
    }

    public final void setDividerWidth(float r8) {
        this.C = h(r8);
        invalidate();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r8) {
        super.setEnabled(r8);
        Iterator<View> r10 = this.M.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().setEnabled(r8);
        goto L4
    }

    public final void setIndicatorAnimDuration(long r8) {
        this.f6520z = r8;
    }

    public final void setIndicatorAnimEnable(boolean r8) {
        this.A = r8;
    }

    public final void setIndicatorBounceEnable(boolean r8) {
    }

    public final void setIndicatorColor(int r8) {
        this.f6517w = r8;
        invalidate();
    }

    public final void setIndicatorCornerRadius(float r8) {
        this.f6519y = h(r8);
        invalidate();
    }

    public final void setIndicatorHeight(float r8) {
        this.f6518x = h(r8);
        invalidate();
    }

    public final void setOnTabSelectAnimListener(c r8) {
    }

    public final void setOnTabSelectListener(d r8) {
    }

    public final void setTabList(List<View> r8) {
        i.f(r8, "<set-?>");
        this.M = r8;
    }

    public final void setTabPadding(float r8) {
        this.f6515u = h(r8);
    }

    public final void setTabSpaceEqual(boolean r8) {
    }

    public final void setTabWidth(float r8) {
        this.f6516v = h(r8);
    }

    public final void setTextAllCaps(boolean r8) {
    }

    public final void setTextSelectColor(int r8) {
        this.F = r8;
    }

    public final void setTextSize(float r8) {
        Resources r10 = this.f6511q.getResources();
        i.e(r10, "mContext.resources");
        this.E = (int) ((r8 * r10.getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public final void setTextUnselectColor(int r8) {
        this.G = r8;
    }
}
