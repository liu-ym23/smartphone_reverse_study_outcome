package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.cae.R;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o0 f901b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f902m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f903n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f904o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f905p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f906q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f907r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f908s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f909t;

    public ActionBarContainer(Context r8, AttributeSet r10) {
        super(r8, r10);
        b r11 = new b(this);
        WeakHashMap<View, j0.h0> r12 = j0.w.f8437a;
        j0.w.d.q(this, r11);
        TypedArray r13 = r8.obtainStyledAttributes(r10, c.a.f3215a);
        boolean r14 = false;
        this.f904o = r13.getDrawable(0);
        this.f905p = r13.getDrawable(2);
        this.f909t = r13.getDimensionPixelSize(13, -1);
        if (getId() != R.id.split_action_bar) goto L5;
        this.f907r = true;
        this.f906q = r13.getDrawable(1);
    L5:
        r13.recycle();
        if (this.f907r == false) goto L11;
        if (this.f906q != null) goto L15;
    L9:
        r14 = true;
    L15:
        setWillNotDraw(r14);
        return;
    L11:
        if (this.f904o != null) goto L15;
        if (this.f905p != null) goto L15;
        goto L15
    }

    public static int a(View r8) {
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r8.getLayoutParams();
        return (r8.getMeasuredHeight() + r10.topMargin) + r10.bottomMargin;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r8 = this.f904o;
        if (r8 != null) goto L5;
    L7:
        Drawable r10 = this.f905p;
        if (r10 != null) goto L10;
    L12:
        Drawable r11 = this.f906q;
        if (r11 != null) goto L15;
        return;
    L15:
        if (r11.isStateful() == false) goto L19;
        this.f906q.setState(getDrawableState());
        return;
    L19:
        return;
    L10:
        if (r10.isStateful() == false) goto L12;
        this.f905p.setState(getDrawableState());
        goto L12
    L5:
        if (r8.isStateful() == false) goto L7;
        this.f904o.setState(getDrawableState());
        goto L7
    }

    public View getTabContainer() {
        return this.f901b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r8 = this.f904o;
        if (r8 == null) goto L5;
        r8.jumpToCurrentState();
    L5:
        Drawable r10 = this.f905p;
        if (r10 == null) goto L8;
        r10.jumpToCurrentState();
    L8:
        Drawable r11 = this.f906q;
        if (r11 == null) goto L12;
        r11.jumpToCurrentState();
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f902m = findViewById(R.id.action_bar);
        this.f903n = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent r8) {
        super.onHoverEvent(r8);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        if (this.f900a == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onInterceptTouchEvent(r8) == true) goto L8;
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        o0 r14 = this.f901b;
        boolean r15 = true;
        boolean r16 = false;
        if (r14 != null) goto L5;
    L7:
        boolean r17 = false;
    L8:
        if (r14 == null) goto L13;
        if (r14.getVisibility() == 8) goto L13;
        int r18 = getMeasuredHeight();
        FrameLayout.LayoutParams r19 = (FrameLayout.LayoutParams) r14.getLayoutParams();
        int r20 = r18 - r14.getMeasuredHeight();
        int r21 = r19.bottomMargin;
        r14.layout(r10, r20 - r21, r12, r18 - r21);
    L13:
        if (this.f907r == false) goto L19;
        Drawable r22 = this.f906q;
        if (r22 == null) goto L17;
        r22.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L36:
        if (r15 == false) goto L39;
        invalidate();
        return;
    L39:
        return;
    L17:
        r15 = r16;
        goto L36
    L19:
        if (this.f904o != null) goto L21;
    L31:
        this.f908s = r17;
        if (r17 == false) goto L17;
        Drawable r23 = this.f905p;
        if (r23 == null) goto L17;
        r23.setBounds(r14.getLeft(), r14.getTop(), r14.getRight(), r14.getBottom());
        goto L36
    L21:
        if (this.f902m.getVisibility() != 0) goto L23;
        Drawable r24 = this.f904o;
        int r25 = this.f902m.getLeft();
        int r26 = this.f902m.getTop();
        int r27 = this.f902m.getRight();
        View r28 = this.f902m;
    L28:
        r24.setBounds(r25, r26, r27, r28.getBottom());
    L30:
        r16 = true;
        goto L31
    L23:
        View r29 = this.f903n;
        if (r29 != null) goto L26;
    L29:
        this.f904o.setBounds(0, 0, 0, 0);
        goto L30
    L26:
        if (r29.getVisibility() != 0) goto L29;
        r24 = this.f904o;
        r25 = this.f903n.getLeft();
        r26 = this.f903n.getTop();
        r27 = this.f903n.getRight();
        r28 = this.f903n;
        goto L28
    L5:
        if (r14.getVisibility() == 8) goto L7;
        r17 = true;
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        if (this.f902m == null) goto L5;
    L9:
        super.onMeasure(r8, r10);
        if (this.f902m != null) goto L12;
        return;
    L12:
        int r11 = View.MeasureSpec.getMode(r10);
        o0 r12 = this.f901b;
        if (r12 != null) goto L15;
        return;
    L15:
        if (r12.getVisibility() != 8) goto L17;
        return;
    L17:
        if (r11 == 1073741824) goto L47;
        View r13 = this.f902m;
        boolean r14 = true;
        int r15 = 0;
        if (r13 != null) goto L21;
    L26:
        boolean r16 = true;
    L27:
        if (r16 == true) goto L29;
        View r17 = this.f902m;
    L39:
        r15 = a(r17);
    L40:
        if (r11 != Integer.MIN_VALUE) goto L42;
        int r18 = View.MeasureSpec.getSize(r10);
    L43:
        setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.f901b) + r15, r18));
        return;
    L42:
        r18 = Integer.MAX_VALUE;
        goto L43
    L29:
        View r19 = this.f903n;
        if (r19 != null) goto L32;
    L37:
        if (r14 == true) goto L40;
        r17 = this.f903n;
        goto L39
    L32:
        if (r19.getVisibility() == 8) goto L37;
        if (r19.getMeasuredHeight() == 0) goto L37;
        r14 = false;
        goto L37
    L21:
        if (r13.getVisibility() == 8) goto L26;
        if (r13.getMeasuredHeight() == 0) goto L26;
        r16 = false;
        goto L27
    L47:
        return;
    L5:
        if (View.MeasureSpec.getMode(r10) != Integer.MIN_VALUE) goto L9;
        int r20 = this.f909t;
        if (r20 < 0) goto L9;
        r10 = View.MeasureSpec.makeMeasureSpec(Math.min(r20, View.MeasureSpec.getSize(r10)), Integer.MIN_VALUE);
        goto L9
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        super.onTouchEvent(r8);
        return true;
    }

    public void setPrimaryBackground(Drawable r8) {
        Drawable r10 = this.f904o;
        if (r10 == null) goto L5;
        r10.setCallback(null);
        unscheduleDrawable(this.f904o);
    L5:
        this.f904o = r8;
        if (r8 == null) goto L10;
        r8.setCallback(this);
        View r11 = this.f902m;
        if (r11 == null) goto L10;
        this.f904o.setBounds(r11.getLeft(), this.f902m.getTop(), this.f902m.getRight(), this.f902m.getBottom());
    L10:
        boolean r12 = true;
        if (this.f907r == false) goto L16;
        if (this.f906q == null) goto L21;
    L20:
        r12 = false;
    L21:
        setWillNotDraw(r12);
        invalidate();
        invalidateOutline();
        return;
    L16:
        if (this.f904o != null) goto L20;
        if (this.f905p != null) goto L20;
        goto L20
    }

    public void setSplitBackground(Drawable r8) {
        Drawable r10 = this.f906q;
        if (r10 == null) goto L5;
        r10.setCallback(null);
        unscheduleDrawable(this.f906q);
    L5:
        this.f906q = r8;
        boolean r11 = this.f907r;
        boolean r12 = false;
        if (r8 == null) goto L13;
        r8.setCallback(this);
        if (r11 == false) goto L13;
        Drawable r13 = this.f906q;
        if (r13 == null) goto L13;
        r13.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L13:
        if (r11 == false) goto L18;
        if (this.f906q != null) goto L22;
    L16:
        r12 = true;
    L22:
        setWillNotDraw(r12);
        invalidate();
        invalidateOutline();
        return;
    L18:
        if (this.f904o != null) goto L22;
        if (this.f905p != null) goto L22;
        goto L22
    }

    public void setStackedBackground(Drawable r8) {
        Drawable r10 = this.f905p;
        if (r10 == null) goto L5;
        r10.setCallback(null);
        unscheduleDrawable(this.f905p);
    L5:
        this.f905p = r8;
        if (r8 == null) goto L13;
        r8.setCallback(this);
        if (this.f908s == false) goto L13;
        Drawable r11 = this.f905p;
        if (r11 == null) goto L13;
        r11.setBounds(this.f901b.getLeft(), this.f901b.getTop(), this.f901b.getRight(), this.f901b.getBottom());
    L13:
        if (this.f907r == false) goto L18;
        if (this.f906q == null) goto L21;
    L22:
        boolean r12 = false;
    L23:
        setWillNotDraw(r12);
        invalidate();
        invalidateOutline();
        return;
    L21:
        r12 = true;
        goto L23
    L18:
        if (this.f904o != null) goto L22;
        if (this.f905p != null) goto L22;
        goto L21
    }

    public void setTabContainer(o0 r8) {
        o0 r10 = this.f901b;
        if (r10 == null) goto L5;
        removeView(r10);
    L5:
        this.f901b = r8;
        if (r8 == null) goto L9;
        addView(r8);
        ViewGroup.LayoutParams r11 = r8.getLayoutParams();
        r11.width = -1;
        r11.height = -2;
        r8.setAllowCollapse(false);
        return;
    }

    public void setTransitioning(boolean r8) {
        this.f900a = r8;
        if (r8 == false) goto L5;
        int r10 = 393216;
    L6:
        setDescendantFocusability(r10);
        return;
    L5:
        r10 = 262144;
        goto L6
    }

    @Override // android.view.View
    public void setVisibility(int r8) {
        super.setVisibility(r8);
        if (r8 != 0) goto L5;
        boolean r10 = true;
    L6:
        Drawable r11 = this.f904o;
        if (r11 == null) goto L9;
        r11.setVisible(r10, false);
    L9:
        Drawable r12 = this.f905p;
        if (r12 == null) goto L12;
        r12.setVisible(r10, false);
    L12:
        Drawable r13 = this.f906q;
        if (r13 == null) goto L16;
        r13.setVisible(r10, false);
        return;
    L16:
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View r8, ActionMode.Callback r10) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r8) {
        Drawable r10 = this.f904o;
        boolean r11 = this.f907r;
        if (r8 != r10) goto L6;
        if (r11 == true) goto L6;
    L14:
        return true;
    L6:
        if (r8 != this.f905p) goto L10;
        if (this.f908s == true) goto L14;
    L10:
        if (r8 != this.f906q) goto L13;
        if (r11 == true) goto L14;
    L13:
        if (super.verifyDrawable(r8) == true) goto L14;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View r8, ActionMode.Callback r10, int r11) {
        if (r11 != 0) goto L4;
        return null;
    L4:
        return super.startActionModeForChild(r8, r10, r11);
    }
}
