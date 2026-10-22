package mc;

import android.R;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import android.widget.CompoundButton;
import androidx.appcompat.widget.b1;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.v0;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import defpackage.c;
import he.i;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"RestrictedApi"})
public class b extends CompoundButton {
    public static final a X = null;
    public static final int[] Y = null;
    public int A;
    public final int B;
    public float C;
    public float D;
    public final VelocityTracker E;
    public final int F;
    public float G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public final TextPaint P;
    public ObjectAnimator Q;
    public final Rect R;
    public int S;
    public int T;
    public boolean U;
    public final PathInterpolator V;
    public float W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f9335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f9336b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f9337m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f9338n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f9339o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f9340p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ColorStateList f9341q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public PorterDuff.Mode f9342r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f9343s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f9344t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f9345u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f9346v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f9347w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f9348x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CharSequence f9349y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f9350z;

    public static final class a extends Property<b, Float> {
        public a(Class r8) {
            super(r8, "thumbPos");
        }

        @Override // android.util.Property
        public final Float get(b r8) {
            b r10 = r8;
            i.f(r10, "object");
            return Float.valueOf(r10.getMThumbPosition());
        }

        @Override // android.util.Property
        public final void set(b r8, Float r10) {
            b r11 = r8;
            float r12 = r10.floatValue();
            i.f(r11, "object");
            r11.setThumbPosition(r12);
        }
    }

    static {
        X = new a(Float.TYPE);
        Y = new int[]{R.attr.state_checked};
    }

    public b(Context r8, AttributeSet r10) {
        this(r8, r10, com.obric.cae.R.attr.switchStyle);
    }

    private final boolean getTargetCheckedState() {
        if (this.W <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getThumbOffset() {
        if (b1.a(this) == false) goto L5;
        float r8 = 1 - this.G;
    L7:
        return (int) ((r8 * getThumbScrollRange()) + 0.5f);
    L5:
        r8 = this.G;
        goto L7
    }

    private final int getThumbScrollRange() {
        Drawable r8 = this.f9340p;
        if (r8 == null) goto L9;
        i.c(r8);
        Rect r10 = this.R;
        r8.getPadding(r10);
        Drawable r11 = this.f9335a;
        if (r11 == null) goto L7;
        Rect r12 = d0.a(r11);
    L11:
        return ((((((this.H - this.J) - r10.left) - r10.right) - r12.left) - r12.right) - this.T) - this.S;
    L7:
        r12 = d0.f1115a;
        i.e(r12, "DrawableUtils.INSETS_NONE");
        goto L11
    L9:
        return 0;
    }

    public final void a() {
        Drawable r8 = this.f9335a;
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.f9338n == false) goto L7;
    L8:
        i.c(r8);
        Drawable r10 = r8.mutate();
        this.f9335a = r10;
        if (this.f9338n == false) goto L12;
        i.c(r10);
        b0.a.b.h(r10, this.f9336b);
    L12:
        if (this.f9339o == false) goto L14;
        Drawable r11 = this.f9335a;
        i.c(r11);
        PorterDuff.Mode r12 = this.f9337m;
        i.c(r12);
        b0.a.b.i(r11, r12);
    L14:
        Drawable r13 = this.f9335a;
        i.c(r13);
        if (r13.isStateful() == false) goto L20;
        Drawable r14 = this.f9335a;
        i.c(r14);
        r14.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f9339o == true) goto L8;
    }

    public final void b() {
        Drawable r8 = this.f9340p;
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.f9343s == false) goto L7;
    L8:
        i.c(r8);
        Drawable r10 = r8.mutate();
        this.f9340p = r10;
        if (this.f9343s == false) goto L12;
        i.c(r10);
        b0.a.b.h(r10, this.f9341q);
    L12:
        if (this.f9344t == false) goto L14;
        Drawable r11 = this.f9340p;
        i.c(r11);
        PorterDuff.Mode r12 = this.f9342r;
        i.c(r12);
        b0.a.b.i(r11, r12);
    L14:
        Drawable r13 = this.f9340p;
        i.c(r13);
        if (r13.isStateful() == false) goto L20;
        Drawable r14 = this.f9340p;
        i.c(r14);
        r14.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f9344t == true) goto L8;
    }

    @Override // android.view.View
    public final void draw(Canvas r11) {
        i.f(r11, "c");
        int r8 = this.L;
        int r10 = this.M;
        int r12 = this.N;
        int r13 = this.O;
        int r14 = getThumbOffset() + r8;
        Drawable r15 = this.f9335a;
        if (r15 == null) goto L5;
        Rect r16 = d0.a(r15);
    L6:
        Drawable r17 = this.f9340p;
        Rect r18 = this.R;
        if (r17 == null) goto L26;
        i.c(r17);
        r17.getPadding(r18);
        int r19 = r18.left;
        r14 = r14 + r19;
        if (r16 == null) goto L23;
        int r20 = r16.left;
        if (r20 <= r19) goto L13;
        r8 = r8 + (r20 - r19);
    L13:
        int r21 = r16.top;
        int r22 = r18.top;
        if (r21 <= r22) goto L16;
        int r23 = (r21 - r22) + r10;
    L17:
        int r24 = r16.right;
        int r25 = r18.right;
        if (r24 <= r25) goto L20;
        r12 = r12 - (r24 - r25);
    L20:
        int r26 = r16.bottom;
        int r27 = r18.bottom;
        if (r26 <= r27) goto L24;
        int r28 = r13 - (r26 - r27);
    L25:
        Drawable r29 = this.f9340p;
        i.c(r29);
        r29.setBounds(r8, r23, r12, r28);
    L24:
        r28 = r13;
        goto L25
    L16:
        r23 = r10;
        goto L17
    L23:
        r23 = r10;
    L26:
        Drawable r30 = this.f9335a;
        if (r30 == null) goto L31;
        i.c(r30);
        r30.getPadding(r18);
        int r31 = r14 - r18.left;
        int r32 = this.S;
        int r33 = r31 + r32;
        int r34 = ((r14 + this.J) + r18.right) + r32;
        int r35 = ((r13 - r10) - this.K) / 2;
        Drawable r36 = this.f9335a;
        i.c(r36);
        r36.setBounds(r33, r35, r34, this.K + r35);
        Drawable r37 = getBackground();
        if (r37 == null) goto L31;
        b0.a.b.f(r37, r33, r10, r34, r13);
    L31:
        super.draw(r11);
        return;
    L5:
        r16 = d0.f1115a;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float r8, float r10) {
        super.drawableHotspotChanged(r8, r10);
        Drawable r11 = this.f9335a;
        if (r11 == null) goto L5;
        i.c(r11);
        b0.a.b.e(r11, r8, r10);
    L5:
        Drawable r12 = this.f9340p;
        if (r12 == null) goto L9;
        i.c(r12);
        b0.a.b.e(r12, r8, r10);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r8 = getDrawableState();
        Drawable r10 = this.f9335a;
        boolean r11 = false;
        if (r10 != null) goto L5;
    L7:
        Drawable r12 = this.f9340p;
        if (r12 != null) goto L10;
    L12:
        if (r11 == false) goto L15;
        invalidate();
        return;
    L15:
        return;
    L10:
        if (r12.isStateful() == false) goto L12;
        r11 = r11 | r12.setState(r8);
        goto L12
    L5:
        if (r10.isStateful() == false) goto L7;
        r11 = false | r10.setState(r8);
        goto L7
    }

    public final boolean getAutoCheck() {
        return this.U;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (b1.a(this) == false) goto L5;
        int r8 = super.getCompoundPaddingLeft() + this.H;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r8;
    L9:
        return r8 + this.f9347w;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (b1.a(this) == true) goto L5;
        int r8 = super.getCompoundPaddingRight() + this.H;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r8;
    L9:
        return r8 + this.f9347w;
    L5:
        return super.getCompoundPaddingRight();
    }

    public final ObjectAnimator getMPositionAnimator() {
        return this.Q;
    }

    public final float getMThumbPosition() {
        return this.G;
    }

    public final boolean getShowText() {
        return false;
    }

    public final boolean getSplitTrack() {
        return this.f9348x;
    }

    public final int getSwitchMinWidth() {
        return this.f9346v;
    }

    public final int getSwitchPadding() {
        return this.f9347w;
    }

    public final CharSequence getTextOff() {
        return this.f9350z;
    }

    public final CharSequence getTextOn() {
        return this.f9349y;
    }

    public final int getThumbConstraintLeft() {
        return this.S;
    }

    public final int getThumbConstraintRight() {
        return this.T;
    }

    public final Drawable getThumbDrawable() {
        return this.f9335a;
    }

    public final int getThumbTextPadding() {
        return this.f9345u;
    }

    public final ColorStateList getThumbTintList() {
        return this.f9336b;
    }

    public final PorterDuff.Mode getThumbTintMode() {
        return this.f9337m;
    }

    public final Drawable getTrackDrawable() {
        return this.f9340p;
    }

    public final ColorStateList getTrackTintList() {
        return this.f9341q;
    }

    public final PorterDuff.Mode getTrackTintMode() {
        return this.f9342r;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r8 = this.f9335a;
        if (r8 == null) goto L5;
        i.c(r8);
        r8.jumpToCurrentState();
    L5:
        Drawable r10 = this.f9340p;
        if (r10 == null) goto L8;
        i.c(r10);
        r10.jumpToCurrentState();
    L8:
        ObjectAnimator r11 = this.Q;
        if (r11 == null) goto L14;
        i.c(r11);
        if (r11.isStarted() == false) goto L15;
        ObjectAnimator r12 = this.Q;
        i.c(r12);
        r12.end();
        this.Q = null;
        return;
    L15:
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int r8) {
        int[] r10 = super.onCreateDrawableState(r8 + 1);
        if (isChecked() == false) goto L5;
        View.mergeDrawableStates(r10, Y);
    L5:
        i.e(r10, "drawableState");
        return r10;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r8) {
        i.f(r8, "canvas");
        super.onDraw(r8);
        Drawable r10 = this.f9340p;
        Rect r11 = this.R;
        if (r10 == null) goto L5;
        r10.getPadding(r11);
    L6:
        int r12 = r11.top;
        Drawable r13 = this.f9335a;
        if (r10 != null) goto L9;
    L13:
        int r14 = r8.save();
        if (r13 == null) goto L16;
        r13.draw(r8);
    L16:
        getTargetCheckedState();
        r8.restoreToCount(r14);
        return;
    L9:
        if (this.f9348x == false) goto L12;
        if (r13 == null) goto L12;
        Rect r15 = d0.a(r13);
        r13.copyBounds(r11);
        r11.left += r15.left;
        r11.right -= r15.right;
        int r16 = r8.save();
        r8.clipRect(r11, Region.Op.DIFFERENCE);
        r10.draw(r8);
        r8.restoreToCount(r16);
    L12:
        r10.draw(r8);
        goto L13
    L5:
        r11.setEmpty();
        goto L6
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r8) {
        i.f(r8, "event");
        super.onInitializeAccessibilityEvent(r8);
        r8.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r8) {
        i.f(r8, LocationMonitorConst.INFO);
        super.onInitializeAccessibilityNodeInfo(r8);
        r8.setClassName("android.widget.Switch");
        if (isChecked() == false) goto L5;
        CharSequence r10 = this.f9349y;
    L7:
        if (TextUtils.isEmpty(r10) == true) goto L13;
        CharSequence r11 = r8.getText();
        if (TextUtils.isEmpty(r11) == false) goto L11;
        r8.setText(r10);
        return;
    L11:
        StringBuilder r12 = new StringBuilder();
        r12.append(r11);
        r12.append(' ');
        r12.append(r10);
        r8.setText(r12);
        return;
    L13:
        return;
    L5:
        r10 = this.f9350z;
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        int r14 = 0;
        if (this.f9335a == null) goto L9;
        Drawable r15 = this.f9340p;
        Rect r16 = this.R;
        if (r15 == null) goto L7;
        i.c(r15);
        r15.getPadding(r16);
    L8:
        Rect r17 = d0.a(this.f9335a);
        int r18 = Math.max(0, r17.left - r16.left);
        r14 = Math.max(0, r17.right - r16.right);
    L11:
        if (b1.a(this) == false) goto L13;
        int r19 = getPaddingLeft() + r18;
        int r20 = ((this.H + r19) - r18) - r14;
    L14:
        int r21 = getGravity() & BWDLInnerConstant.LINK_RECOVERY;
        if (r21 != 16) goto L17;
        int r22 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
        int r23 = this.I;
        int r24 = r22 - (r23 / 2);
        int r25 = r23 + r24;
        int r26 = r24;
    L24:
        this.L = r19;
        this.M = r26;
        this.O = r25;
        this.N = r20;
        return;
    L17:
        if (r21 != 48) goto L19;
    L22:
        r26 = getPaddingTop();
        r25 = this.I + r26;
        goto L24
    L19:
        if (r21 != 80) goto L22;
        r25 = getHeight() - getPaddingBottom();
        r26 = r25 - this.I;
        goto L24
    L13:
        r20 = (getWidth() - getPaddingRight()) - r14;
        r19 = ((r20 - this.H) + r18) + r14;
        goto L14
    L7:
        r16.setEmpty();
        goto L8
    L9:
        r18 = 0;
        goto L11
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r8, int r10) {
        Drawable r11 = this.f9335a;
        int r12 = 0;
        Rect r13 = this.R;
        if (r11 == null) goto L5;
        i.c(r11);
        r11.getPadding(r13);
        Drawable r14 = this.f9335a;
        i.c(r14);
        int r15 = (r14.getIntrinsicWidth() - r13.left) - r13.right;
        Drawable r16 = this.f9335a;
        i.c(r16);
        int r17 = r16.getIntrinsicHeight();
    L6:
        this.J = Math.max(0, r15);
        this.K = r17;
        Drawable r18 = this.f9340p;
        if (r18 == null) goto L9;
        i.c(r18);
        r18.getPadding(r13);
        Drawable r19 = this.f9340p;
        i.c(r19);
        r12 = r19.getIntrinsicHeight();
    L10:
        int r20 = r13.left;
        int r21 = r13.right;
        Drawable r22 = this.f9335a;
        if (r22 == null) goto L13;
        Rect r23 = d0.a(r22);
        r20 = Math.max(r20, r23.left);
        r21 = Math.max(r21, r23.right);
    L13:
        int r24 = Math.max(this.f9346v, ((this.J * 2) + r20) + r21);
        int r25 = Math.max(r12, r17);
        Resources r26 = Resources.getSystem();
        i.e(r26, "Resources.getSystem()");
        this.H = r24 - l6.a.I0(TypedValue.applyDimension(1, 4, r26.getDisplayMetrics()));
        this.I = r25;
        super.onMeasure(r8, r10);
        if (getMeasuredHeight() >= r25) goto L17;
        setMeasuredDimension(getMeasuredWidthAndState(), r25);
        return;
    L17:
        return;
    L9:
        r13.setEmpty();
        goto L10
    L5:
        r15 = 0;
        r17 = 0;
        goto L6
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent r8) {
        i.f(r8, "event");
        super.onPopulateAccessibilityEvent(r8);
        if (isChecked() == false) goto L5;
        CharSequence r10 = this.f9349y;
    L6:
        if (r10 == null) goto L9;
        r8.getText().add(r10);
        return;
    L9:
        return;
    L5:
        r10 = this.f9350z;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r11) {
        i.f(r11, "ev");
        VelocityTracker r8 = this.E;
        r8.addMovement(r11);
        int r10 = r11.getActionMasked();
        int r12 = this.B;
        boolean r13 = false;
        if (r10 != 0) goto L5;
        float r14 = r11.getX();
        float r15 = r11.getY();
        if (isEnabled() == true) goto L71;
    L85:
        return super.onTouchEvent(r11);
    L71:
        if (this.f9335a == null) goto L82;
        int r16 = getThumbOffset();
        Drawable r17 = this.f9335a;
        i.c(r17);
        Rect r18 = this.R;
        r17.getPadding(r18);
        int r19 = this.M - r12;
        int r20 = (this.L + r16) - r12;
        int r21 = (((this.J + r20) + r18.left) + r18.right) + r12;
        int r22 = this.O + r12;
        if (r14 <= r20) goto L82;
        if (r14 >= r21) goto L82;
        if (r15 <= r19) goto L82;
        if (r15 >= r22) goto L82;
        r13 = true;
    L82:
        if (r13 == false) goto L85;
        this.A = 1;
        this.C = r14;
        this.D = r15;
        goto L85
    L5:
        if (r10 == 1) goto L41;
        if (r10 == 2) goto L9;
        if (r10 == 3) goto L41;
    L9:
        int r23 = this.A;
        if (r23 == 1) goto L34;
        if (r23 != 2) goto L85;
        float r110 = r11.getX();
        int r24 = getThumbScrollRange();
        float r25 = r110 - this.C;
        float r26 = 1.0f;
        if (r24 == 0) goto L17;
        float r27 = r25 / r24;
    L21:
        if (b1.a(this) == false) goto L23;
        r27 = -r27;
    L23:
        float r28 = this.W;
        float r29 = r27 + r28;
        if (r29 >= 0.0f) goto L27;
        r26 = 0.0f;
    L31:
        if (r26 == r28) goto L33;
        this.C = r110;
        this.W = r26;
    L33:
        return true;
    L27:
        if (r29 > 1.0f) goto L31;
        r26 = r29;
        goto L31
    L17:
        if (r25 <= 0) goto L19;
        r27 = 1.0f;
        goto L21
    L19:
        r27 = -1.0f;
        goto L21
    L34:
        float r30 = r11.getX();
        float r31 = r11.getY();
        if (Math.abs(r30 - this.C) <= r12) goto L37;
    L38:
        this.A = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.C = r30;
        this.D = r31;
        return true;
    L37:
        if (Math.abs(r31 - this.D) <= r12) goto L85;
    L41:
        if (this.A != 2) goto L67;
        this.A = 0;
        if (r11.getAction() == 1) goto L45;
    L47:
        boolean r32 = false;
    L48:
        boolean r33 = isChecked();
        if (r32 == false) goto L62;
        r8.computeCurrentVelocity(1000);
        float r34 = r8.getXVelocity();
        if (Math.abs(r34) > this.F) goto L53;
        boolean r35 = getTargetCheckedState();
    L63:
        if (r35 == r33) goto L65;
        playSoundEffect(0);
    L65:
        setChecked(r35);
        MotionEvent r36 = MotionEvent.obtain(r11);
        i.e(r36, "cancel");
        r36.setAction(3);
        super.onTouchEvent(r36);
        r36.recycle();
        super.onTouchEvent(r11);
        return true;
    L53:
        if (b1.a(this) == false) goto L58;
        if (r34 < 0) goto L59;
    L60:
        r35 = false;
    L59:
        r35 = true;
        goto L63
    L58:
        if (r34 <= 0) goto L60;
    L62:
        r35 = r33;
        goto L63
    L45:
        if (isEnabled() == false) goto L47;
        r32 = true;
        goto L48
    L67:
        this.A = 0;
        r8.clear();
        goto L85
    }

    @Override // android.widget.CompoundButton, android.view.View
    public final boolean performClick() {
        boolean r8 = super.performClick();
        if (isHapticFeedbackEnabled() == false) goto L9;
        boolean r10 = isChecked();
        Context r11 = getContext();
        if (r10 == false) goto L7;
        int r12 = 4;
    L8:
        c.o0(r11, r12);
        goto L9
    L7:
        r12 = 5;
    L9:
        return r8;
    }

    public final void setAutoCheck(boolean r8) {
        this.U = r8;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r8) {
        super.setChecked(r8);
        boolean r10 = isChecked();
        float r11 = 1.0f;
        if (getWindowToken() == null) goto L21;
        WeakHashMap<View, h0> r12 = w.f8437a;
        if (w.g.c(this) == false) goto L21;
        if (r10 == true) goto L9;
        r11 = 0;
    L9:
        ObjectAnimator r13 = ObjectAnimator.ofFloat(this, X, new float[]{r11});
        this.Q = r13;
        if (r13 == null) goto L12;
        r13.setDuration(443);
    L12:
        ObjectAnimator r14 = this.Q;
        if (r14 == null) goto L15;
        r14.setAutoCancel(true);
    L15:
        ObjectAnimator r15 = this.Q;
        if (r15 == null) goto L18;
        r15.setInterpolator(this.V);
    L18:
        ObjectAnimator r16 = this.Q;
        if (r16 == null) goto L29;
        r16.start();
        return;
    L29:
        return;
    L21:
        ObjectAnimator r17 = this.Q;
        if (r17 == null) goto L24;
        r17.cancel();
    L24:
        if (r10 == true) goto L27;
        r11 = 0;
    L27:
        setThumbPosition(r11);
    }

    public void setCheckedNoAnim(boolean r8) {
        super.setChecked(r8);
        ObjectAnimator r10 = this.Q;
        if (r10 == null) goto L6;
        r10.cancel();
    L6:
        if (isChecked() == false) goto L8;
        float r11 = 1.0f;
    L9:
        setThumbPosition(r11);
        return;
    L8:
        r11 = 0;
        goto L9
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r8) {
        i.f(r8, "actionModeCallback");
        super.setCustomSelectionActionModeCallback(r8);
    }

    public final void setMPositionAnimator(ObjectAnimator r8) {
        this.Q = r8;
    }

    public final void setMThumbPosition(float r8) {
        this.G = r8;
    }

    public final void setShowText(boolean r8) {
    }

    public final void setSplitTrack(boolean r8) {
        this.f9348x = r8;
        invalidate();
    }

    public final void setSwitchMinWidth(int r8) {
        this.f9346v = r8;
        requestLayout();
    }

    public final void setSwitchPadding(int r8) {
        this.f9347w = r8;
        requestLayout();
    }

    public final void setSwitchTypeface(Typeface r8) {
        TextPaint r10 = this.P;
        if (r10.getTypeface() == null) goto L7;
        if ((!i.a(r10.getTypeface(), r8)) == false) goto L7;
    L9:
        r10.setTypeface(r8);
        requestLayout();
        invalidate();
        return;
    L7:
        if (r10.getTypeface() != null) goto L11;
        if (r8 != null) goto L9;
        return;
    }

    public final void setTextOff(CharSequence r8) {
        this.f9350z = r8;
        requestLayout();
    }

    public final void setTextOn(CharSequence r8) {
        this.f9349y = r8;
        requestLayout();
    }

    public final void setThumbConstraintLeft(int r8) {
        this.S = r8;
    }

    public final void setThumbConstraintRight(int r8) {
        this.T = r8;
    }

    public final void setThumbDrawable(Drawable r8) {
        Drawable r10 = this.f9335a;
        if (r10 == null) goto L5;
        i.c(r10);
        r10.setCallback(null);
    L5:
        this.f9335a = r8;
        if (r8 == null) goto L8;
        r8.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setThumbPosition(float r8) {
        this.G = r8;
        invalidate();
    }

    public final void setThumbResource(int r8) {
        setThumbDrawable(d.a.a(getContext(), r8));
    }

    public final void setThumbTextPadding(int r8) {
        this.f9345u = r8;
        requestLayout();
    }

    public final void setThumbTintList(ColorStateList r8) {
        this.f9336b = r8;
        this.f9338n = true;
        a();
    }

    public final void setThumbTintMode(PorterDuff.Mode r8) {
        this.f9337m = r8;
        this.f9339o = true;
        a();
    }

    public final void setTrackDrawable(Drawable r8) {
        Drawable r10 = this.f9340p;
        if (r10 == null) goto L5;
        i.c(r10);
        r10.setCallback(null);
    L5:
        this.f9340p = r8;
        if (r8 == null) goto L8;
        r8.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setTrackResource(int r8) {
        setTrackDrawable(d.a.a(getContext(), r8));
    }

    public final void setTrackTintList(ColorStateList r8) {
        this.f9341q = r8;
        this.f9343s = true;
        b();
    }

    public final void setTrackTintMode(PorterDuff.Mode r8) {
        this.f9342r = r8;
        this.f9344t = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        if (this.U == false) goto L6;
        setChecked(!isChecked());
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable r8) {
        i.f(r8, "who");
        if (super.verifyDrawable(r8) == false) goto L5;
    L10:
        return true;
    L5:
        if (r8 == this.f9335a) goto L10;
        if (r8 == this.f9340p) goto L10;
        return false;
    }

    public b(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.E = VelocityTracker.obtain();
        this.R = new Rect();
        boolean r8 = true;
        this.U = true;
        this.V = new PathInterpolator(0.33f, 1.3f, 0.15f, 1.0f);
        TextPaint r13 = new TextPaint(1);
        this.P = r13;
        Resources r14 = getResources();
        i.e(r14, "res");
        r13.density = r14.getDisplayMetrics().density;
        v0 r15 = new v0(r10, r10.obtainStyledAttributes(r11, c.a.f3237w, r12, 0));
        Drawable r16 = r15.e(2);
        this.f9335a = r16;
        if (r16 == null) goto L5;
        r16.setCallback(this);
    L5:
        Drawable r17 = r15.e(11);
        this.f9340p = r17;
        if (r17 == null) goto L8;
        r17.setCallback(this);
    L8:
        this.f9349y = r15.k(0);
        this.f9350z = r15.k(1);
        this.f9345u = r15.d(8, 0);
        this.f9346v = r15.d(5, 0);
        this.f9347w = r15.d(6, 0);
        this.f9348x = r15.a(4, false);
        ColorStateList r18 = r15.b(9);
        if (r18 == null) goto L11;
        this.f9336b = r18;
        this.f9338n = true;
    L11:
        Typeface r19 = null;
        PorterDuff.Mode r110 = d0.b(r15.h(10, -1), null);
        if (this.f9337m == r110) goto L15;
        this.f9337m = r110;
        this.f9339o = true;
    L15:
        if (this.f9338n == false) goto L17;
    L18:
        a();
    L19:
        ColorStateList r111 = r15.b(12);
        if (r111 == null) goto L22;
        this.f9341q = r111;
        this.f9343s = true;
    L22:
        PorterDuff.Mode r112 = d0.b(r15.h(13, -1), null);
        if (this.f9342r == r112) goto L26;
        this.f9342r = r112;
        this.f9344t = true;
    L26:
        if (this.f9343s == false) goto L28;
    L29:
        b();
    L30:
        int r113 = r15.i(7, 0);
        if (r113 == 0) goto L71;
        v0 r20 = new v0(r10, r10.obtainStyledAttributes(r113, c.a.f3238x));
        if (r20.b(3) != null) goto L36;
        getTextColors();
    L36:
        int r21 = r20.d(0, 0);
        if (r21 == 0) goto L41;
        float r22 = r21;
        if (r22 == r13.getTextSize()) goto L41;
        r13.setTextSize(r22);
        requestLayout();
    L41:
        int r23 = r20.h(1, -1);
        int r24 = r20.h(2, -1);
        if (r23 == 1) goto L48;
        if (r23 == 2) goto L47;
        if (r23 != 3) goto L49;
        r19 = Typeface.MONOSPACE;
    L49:
        float r114 = 0.0f;
        if (r24 <= 0) goto L66;
        if (r19 != null) goto L53;
        Typeface r25 = Typeface.defaultFromStyle(r24);
    L54:
        setSwitchTypeface(r25);
        if (r25 == null) goto L57;
        int r26 = r25.getStyle();
    L58:
        int r27 = r24 & (~r26);
        if ((r27 & 1) != 0) goto L62;
        r8 = false;
    L62:
        r13.setFakeBoldText(r8);
        if ((2 & r27) == 0) goto L65;
        r114 = -0.25f;
    L65:
        r13.setTextSkewX(r114);
    L68:
        if (r20.a(14, false) == false) goto L70;
        new f.a(getContext());
    L70:
        r20.n();
        goto L71
    L57:
        r26 = 0;
        goto L58
    L53:
        r25 = Typeface.create(r19, r24);
        goto L54
    L66:
        r13.setFakeBoldText(false);
        r13.setTextSkewX(0.0f);
        setSwitchTypeface(r19);
        goto L68
    L47:
        r19 = Typeface.SERIF;
        goto L49
    L48:
        r19 = Typeface.SANS_SERIF;
    L71:
        r15.n();
        ViewConfiguration r115 = ViewConfiguration.get(r10);
        i.e(r115, "config");
        this.B = r115.getScaledTouchSlop();
        this.F = r115.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L28:
        if (this.f9344t == false) goto L30;
    L17:
        if (this.f9339o == false) goto L19;
        goto L18
    }
}
