package com.larksuite.component.ui.button;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUISwitchButton extends CompoundButton {
    public static final int[] W = null;
    public static final int[] k0 = null;
    public boolean A;
    public boolean B;
    public ObjectAnimator C;
    public float D;
    public RectF E;
    public float F;
    public float G;
    public float H;
    public int I;
    public int J;
    public Paint K;
    public CharSequence L;
    public CharSequence M;
    public TextPaint N;
    public Layout O;
    public Layout P;
    public float Q;
    public float R;
    public float S;
    public boolean T;
    public boolean U;
    public CompoundButton.OnCheckedChangeListener V;
    public Drawable a;
    public Drawable b;
    public ColorStateList c;
    public ColorStateList d;
    public float e;
    public float f;
    public RectF g;
    public float h;
    public long i;
    public boolean j;
    public int k;
    public PointF l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public Drawable r;
    public Drawable s;
    public RectF t;
    public RectF u;
    public RectF v;
    public RectF w;
    public RectF x;
    public Paint y;
    public boolean z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public CharSequence a;
        public CharSequence b;

        public class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r2) {
                return new SavedState(r2);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r1) {
                return new SavedState[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r2) {
            super(r2);
            this.a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r2);
            this.b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r2);
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            TextUtils.writeToParcel(this.a, r2, r3);
            TextUtils.writeToParcel(this.b, r2, r3);
        }
    }

    static {
        W = new int[]{R.attr.state_checked, R.attr.state_enabled, R.attr.state_pressed};
        k0 = new int[]{-16842912, R.attr.state_enabled, R.attr.state_pressed};
    }

    public PointF getBackSizeF() {
        return new PointF(this.u.width(), this.u.height());
    }

    public float getThumbHeight() {
        return this.l.y;
    }

    public float getThumbWidth() {
        return this.l.x;
    }

    private boolean getStatusBasedOnPos() {
        if (getProcess() <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b() {
        float r2 = 0.0f;
        float r0 = getPaddingTop() + Math.max(0.0f, this.g.top);
        float r1 = getPaddingLeft() + Math.max(0.0f, this.g.left);
        if (this.O == null) goto L10;
        if (this.P == null) goto L10;
        RectF r3 = this.g;
        if ((r3.top + r3.bottom) <= 0.0f) goto L10;
        float r4 = ((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.l.y;
        RectF r5 = this.g;
        r0 = r0 + (((r4 - r5.top) - r5.bottom) / 2.0f);
    L10:
        if (this.z == false) goto L12;
        PointF r6 = this.l;
        r6.x = Math.max(r6.x, this.a.getMinimumWidth());
        PointF r7 = this.l;
        r7.y = Math.max(r7.y, this.a.getMinimumHeight());
    L12:
        RectF r8 = this.t;
        PointF r9 = this.l;
        r8.set(r1, r0, r9.x + r1, r9.y + r0);
        float r10 = this.t.left - this.g.left;
        float r11 = this.l.x;
        float r12 = Math.min(0.0f, ((Math.max(this.h * r11, r11 + this.Q) - this.t.width()) - this.Q) / 2.0f);
        float r13 = this.t.height();
        RectF r14 = this.g;
        float r15 = Math.min(0.0f, (((r13 + r14.top) + r14.bottom) - this.R) / 2.0f);
        RectF r16 = this.u;
        float r17 = r10 + r12;
        float r19 = this.t.top;
        RectF r20 = this.g;
        float r21 = (r19 - r20.top) + r15;
        float r22 = r10 + r20.left;
        float r23 = this.l.x;
        float r24 = r22 + Math.max(this.h * r23, r23 + this.Q);
        RectF r25 = this.g;
        r16.set(r17, r21, (r24 + r25.right) - r12, (this.t.bottom + r25.bottom) - r15);
        RectF r26 = this.v;
        RectF r27 = this.t;
        r26.set(r27.left, 0.0f, (this.u.right - this.g.right) - r27.width(), 0.0f);
        this.f = Math.min(Math.min(this.u.width(), this.u.height()) / 2.0f, this.f);
        Drawable r29 = this.b;
        if (r29 == null) goto L16;
        RectF r30 = this.u;
        r29.setBounds((int) r30.left, (int) r30.top, (int) Math.ceil(r30.right), (int) Math.ceil(this.u.bottom));
    L16:
        if (this.O == null) goto L28;
        RectF r31 = this.u;
        float r32 = r31.left + ((((r31.width() - this.t.width()) - this.g.right) - this.O.getWidth()) / 2.0f);
        float r33 = this.g.left;
        if (r33 >= 0.0f) goto L20;
        float r34 = r33 * (-0.5f);
    L21:
        float r35 = r32 + r34;
        if (this.A == false) goto L24;
    L26:
        RectF r36 = this.u;
        float r37 = r36.top + ((r36.height() - this.O.getHeight()) / 2.0f);
        this.w.set(r35, r37, this.O.getWidth() + r35, this.O.getHeight() + r37);
        goto L28
    L24:
        if (this.T == false) goto L26;
        r35 = r35 + (this.f / 4.0f);
        goto L26
    L20:
        r34 = 0.0f;
    L28:
        if (this.P == null) goto L39;
        RectF r38 = this.u;
        float r39 = (r38.right - ((((r38.width() - this.t.width()) - this.g.left) - this.P.getWidth()) / 2.0f)) - this.P.getWidth();
        float r40 = this.g.right;
        if (r40 >= 0.0f) goto L32;
        r2 = 0.5f * r40;
    L32:
        float r41 = r39 + r2;
        if (this.A == false) goto L35;
    L37:
        RectF r42 = this.u;
        float r43 = r42.top + ((r42.height() - this.P.getHeight()) / 2.0f);
        this.x.set(r41, r43, this.P.getWidth() + r41, this.P.getHeight() + r43);
        return;
    L35:
        if (this.T == false) goto L37;
        r41 = r41 - (this.f / 4.0f);
        goto L37
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.z == true) goto L7;
        ColorStateList r0 = this.d;
        if (r0 == null) goto L7;
        this.m = r0.getColorForState(getDrawableState(), this.m);
    L8:
        boolean r1 = isChecked();
        int[] r2 = k0;
        int[] r3 = W;
        if (r1 == false) goto L11;
        int[] r4 = r2;
    L12:
        ColorStateList r5 = getTextColors();
        if (r5 == null) goto L16;
        int r6 = r5.getDefaultColor();
        this.p = r5.getColorForState(r3, r6);
        this.q = r5.getColorForState(r2, r6);
    L16:
        if (this.A == true) goto L20;
        ColorStateList r7 = this.c;
        if (r7 == null) goto L20;
        int r8 = r7.getColorForState(getDrawableState(), this.n);
        this.n = r8;
        this.o = this.c.getColorForState(r4, r8);
        return;
    L20:
        Drawable r9 = this.b;
        if ((r9 instanceof StateListDrawable) == true) goto L23;
    L25:
        this.s = null;
    L26:
        setDrawableState(this.b);
        Drawable r10 = this.b;
        if (r10 == null) goto L31;
        this.r = r10.getCurrent().mutate();
        return;
    L31:
        return;
    L23:
        if (this.j == false) goto L25;
        r9.setState(r4);
        this.s = this.b.getCurrent().mutate();
        goto L26
    L11:
        r4 = r3;
    L7:
        setDrawableState(this.a);
        goto L8
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.a = this.L;
        r1.b = this.M;
        return r1;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public final boolean performClick() {
        return super.performClick();
    }

    public long getAnimationDuration() {
        return this.i;
    }

    public ColorStateList getBackColor() {
        return this.c;
    }

    public Drawable getBackDrawable() {
        return this.b;
    }

    public float getBackMeasureRatio() {
        return this.h;
    }

    public float getBackRadius() {
        return this.f;
    }

    public final float getProcess() {
        return this.D;
    }

    public ColorStateList getThumbColor() {
        return this.d;
    }

    public Drawable getThumbDrawable() {
        return this.a;
    }

    public RectF getThumbMargin() {
        return this.g;
    }

    public float getThumbRadius() {
        return this.e;
    }

    public PointF getThumbSizeF() {
        return this.l;
    }

    public int getTintColor() {
        return this.k;
    }

    public LKUISwitchButton(Context r3) {
        this(r3, null, 0);
    }

    private void setDrawableState(Drawable r2) {
        if (r2 == null) goto L5;
        r2.setState(getDrawableState());
        invalidate();
        return;
    }

    public final void a(boolean r5) {
        ObjectAnimator r0 = this.C;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isRunning() == false) goto L8;
        this.C.cancel();
    L8:
        this.C.setDuration(this.i);
        if (r5 == false) goto L11;
        this.C.setFloatValues(new float[]{this.D, 1.0f});
    L12:
        this.C.start();
        return;
    L11:
        this.C.setFloatValues(new float[]{this.D, 0.0f});
        goto L12
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r14) {
        super.onDraw(r14);
        if (this.A == false) goto L21;
        if (this.j == true) goto L7;
    L19:
        this.b.setAlpha(255);
        this.b.draw(r14);
    L33:
        if (getProcess() <= 0.5d) goto L35;
        Layout r0 = this.O;
    L37:
        if (getProcess() <= 0.5d) goto L39;
        RectF r3 = this.w;
    L41:
        if (r0 == null) goto L55;
        if (r3 == null) goto L55;
        if (getProcess() < 0.75d) goto L47;
        float r7 = (getProcess() * 4.0f) - 3.0f;
    L50:
        int r1 = (int) (r7 * 255.0f);
        if (getProcess() <= 0.5d) goto L53;
        int r8 = this.p;
    L54:
        r0.getPaint().setARGB((Color.alpha(r8) * r1) / 255, Color.red(r8), Color.green(r8), Color.blue(r8));
        r14.save();
        r14.translate(r3.left, r3.top);
        r0.draw(r14);
        r14.restore();
        goto L55
    L53:
        r8 = this.q;
        goto L54
    L47:
        if (getProcess() >= 0.25d) goto L49;
        r7 = 1.0f - (getProcess() * 4.0f);
        goto L50
    L49:
        r7 = 0.0f;
    L55:
        this.E.set(this.t);
        this.E.offset(this.D * this.v.width(), 0.0f);
        if (this.z == false) goto L58;
        Drawable r2 = this.a;
        RectF r4 = this.E;
        r2.setBounds((int) r4.left, (int) r4.top, (int) Math.ceil(r4.right), (int) Math.ceil(this.E.bottom));
        this.a.draw(r14);
    L60:
        if (this.B == false) goto L67;
        this.K.setColor(ColorProtector.parseColor("#AA0000"));
        r14.drawRect(this.u, this.K);
        this.K.setColor(ColorProtector.parseColor("#0000FF"));
        r14.drawRect(this.E, this.K);
        this.K.setColor(ColorProtector.parseColor("#00CC00"));
        if (getProcess() <= 0.5d) goto L64;
        RectF r5 = this.w;
    L65:
        r14.drawRect(r5, this.K);
        return;
    L64:
        r5 = this.x;
        goto L65
    L67:
        return;
    L58:
        this.y.setColor(this.m);
        RectF r6 = this.E;
        float r9 = this.e;
        r14.drawRoundRect(r6, r9, r9, this.y);
        goto L60
    L39:
        r3 = this.x;
        goto L41
    L35:
        r0 = this.P;
        goto L37
    L7:
        if (this.r == null) goto L19;
        if (this.s == null) goto L19;
        if (isChecked() == false) goto L13;
        Drawable r10 = this.r;
    L15:
        if (isChecked() == false) goto L17;
        Drawable r11 = this.s;
    L18:
        int r12 = (int) (getProcess() * 255.0f);
        r10.setAlpha(r12);
        r10.draw(r14);
        r11.setAlpha(255 - r12);
        r11.draw(r14);
        goto L33
    L17:
        r11 = this.r;
        goto L18
    L13:
        r10 = this.s;
        goto L15
    L21:
        if (this.j == true) goto L23;
        this.y.setColor(this.n);
        RectF r13 = this.u;
        float r15 = this.f;
        r14.drawRoundRect(r13, r15, r15, this.y);
        goto L33
    L23:
        if (isChecked() == false) goto L25;
        int r16 = this.n;
    L27:
        if (isChecked() == false) goto L29;
        int r17 = this.o;
    L30:
        int r19 = (int) (getProcess() * 255.0f);
        this.y.setARGB((Color.alpha(r16) * r19) / 255, Color.red(r16), Color.green(r16), Color.blue(r16));
        RectF r20 = this.u;
        float r21 = this.f;
        r14.drawRoundRect(r20, r21, r21, this.y);
        this.y.setARGB((Color.alpha(r17) * (255 - r19)) / 255, Color.red(r17), Color.green(r17), Color.blue(r17));
        RectF r22 = this.u;
        float r23 = this.f;
        r14.drawRoundRect(r22, r23, r23, this.y);
        this.y.setAlpha(255);
        goto L33
    L29:
        r17 = this.n;
        goto L30
    L25:
        r16 = this.o;
        goto L27
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable r3) {
        SavedState r4 = (SavedState) r3;
        CharSequence r0 = r4.a;
        CharSequence r1 = r4.b;
        this.L = r0;
        this.M = r1;
        this.O = null;
        this.P = null;
        requestLayout();
        invalidate();
        this.U = true;
        super.onRestoreInstanceState(r4.getSuperState());
        this.U = false;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        if (isEnabled() == true) goto L5;
    L37:
        return false;
    L5:
        if (isClickable() == false) goto L37;
        if (isFocusable() == false) goto L37;
        int r0 = r10.getAction();
        float r2 = r10.getX() - this.F;
        float r3 = r10.getY() - this.G;
        if (r0 == 0) goto L32;
        if (r0 != 1) goto L13;
    L18:
        setPressed(false);
        boolean r1 = getStatusBasedOnPos();
        long r5 = r10.getEventTime() - r10.getDownTime();
        if (r5 <= 0) goto L36;
        int r11 = this.I;
        if (r2 >= r11) goto L29;
        if (r3 >= r11) goto L29;
        if (r5 >= this.J) goto L29;
        performClick();
    L29:
        if (r1 == isChecked()) goto L31;
        playSoundEffect(0);
        setChecked(r1);
        goto L36
    L31:
        a(r1);
    L36:
        return true;
    L13:
        if (r0 != 2) goto L15;
        float r12 = r10.getX();
        setProcess(getProcess() + ((r12 - this.H) / this.v.width()));
        this.H = r12;
        goto L36
    L15:
        if (r0 == 3) goto L18;
    L32:
        ViewParent r4 = getParent();
        if (r4 == null) goto L35;
        r4.requestDisallowInterceptTouchEvent(true);
    L35:
        this.F = r10.getX();
        this.G = r10.getY();
        this.H = this.F;
        setPressed(true);
        goto L36
    }

    public void setAnimationDuration(long r1) {
        this.i = r1;
    }

    public void setBackColor(ColorStateList r1) {
        this.c = r1;
        if (r1 == null) goto L5;
        setBackDrawable(null);
    L5:
        invalidate();
    }

    public void setBackColorRes(int r2) {
        setBackColor(ContextCompat.getColorStateList(getContext(), r2));
    }

    public void setBackDrawable(Drawable r1) {
        this.b = r1;
        if (r1 == null) goto L5;
        boolean r2 = true;
    L6:
        this.A = r2;
        b();
        refreshDrawableState();
        requestLayout();
        invalidate();
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void setBackDrawableRes(int r2) {
        setBackDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public void setBackMeasureRatio(float r1) {
        this.h = r1;
        requestLayout();
    }

    public void setBackRadius(float r1) {
        this.f = r1;
        if (this.A == true) goto L6;
        invalidate();
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r2) {
        if (isChecked() == r2) goto L6;
        a(r2);
    L6:
        if (this.U == false) goto L8;
        setCheckedImmediatelyNoEvent(r2);
        return;
    L8:
        super.setChecked(r2);
    }

    public void setCheckedImmediately(boolean r2) {
        super.setChecked(r2);
        ObjectAnimator r0 = this.C;
        if (r0 != null) goto L5;
    L7:
        if (r2 == false) goto L9;
        float r3 = 1.0f;
    L10:
        setProcess(r3);
        invalidate();
        return;
    L9:
        r3 = 0.0f;
        goto L10
    L5:
        if (r0.isRunning() == false) goto L7;
        this.C.cancel();
        goto L7
    }

    public void setCheckedImmediatelyNoEvent(boolean r2) {
        if (this.V != null) goto L5;
        setCheckedImmediately(r2);
        return;
    L5:
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(r2);
        super.setOnCheckedChangeListener(this.V);
    }

    public void setCheckedNoEvent(boolean r2) {
        if (this.V != null) goto L5;
        setChecked(r2);
        return;
    L5:
        super.setOnCheckedChangeListener(null);
        setChecked(r2);
        super.setOnCheckedChangeListener(this.V);
    }

    public void setDrawDebugRect(boolean r1) {
        this.B = r1;
        invalidate();
    }

    public void setFadeBack(boolean r1) {
        this.j = r1;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r1) {
        super.setOnCheckedChangeListener(r1);
        this.V = r1;
    }

    public final void setProcess(float r3) {
        if (r3 <= 1.0f) goto L6;
        r3 = 1.0f;
    L8:
        this.D = r3;
        invalidate();
        return;
    L6:
        if (r3 >= 0.0f) goto L8;
        r3 = 0.0f;
        goto L8
    }

    public void setThumbColor(ColorStateList r1) {
        this.d = r1;
        if (r1 == null) goto L6;
        setThumbDrawable(null);
        return;
    }

    public void setThumbColorRes(int r2) {
        setThumbColor(ContextCompat.getColorStateList(getContext(), r2));
    }

    public void setThumbDrawable(Drawable r1) {
        this.a = r1;
        if (r1 == null) goto L5;
        boolean r2 = true;
    L6:
        this.z = r2;
        b();
        refreshDrawableState();
        requestLayout();
        invalidate();
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void setThumbDrawableRes(int r2) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public void setThumbMargin(RectF r5) {
        if (r5 != null) goto L4;
        this.g.set(0.0f, 0.0f, 0.0f, 0.0f);
        requestLayout();
        return;
    L4:
        float r0 = r5.left;
        float r1 = r5.top;
        float r2 = r5.right;
        float r6 = r5.bottom;
        this.g.set(r0, r1, r2, r6);
        requestLayout();
    }

    public void setThumbRadius(float r1) {
        this.e = r1;
        if (this.z == true) goto L6;
        invalidate();
        return;
    }

    public void setThumbSize(PointF r3) {
        if (r3 != null) goto L4;
        Resources r4 = getResources();
        float r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density * 20.0f;
        this.l.set(r5, r5);
        b();
        requestLayout();
        return;
    L4:
        float r0 = r3.x;
        float r6 = r3.y;
        this.l.set(r0, r6);
        b();
        requestLayout();
    }

    public void setTintColor(int r1) {
        this.k = r1;
        this.d = a.b(r1);
        this.c = a.a(this.k);
        this.A = false;
        this.z = false;
        refreshDrawableState();
        invalidate();
    }

    public LKUISwitchButton(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r10, int r11) {
        if (this.O != null) goto L8;
        CharSequence r2 = this.L;
        if (r2 == null) goto L8;
        TextPaint r3 = this.N;
        this.O = new StaticLayout(r2, r3, (int) Math.ceil(Layout.getDesiredWidth(r2, r3)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    L8:
        if (this.P != null) goto L12;
        CharSequence r4 = this.M;
        if (r4 == null) goto L12;
        TextPaint r5 = this.N;
        this.P = new StaticLayout(r4, r5, (int) Math.ceil(Layout.getDesiredWidth(r4, r5)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    L12:
        int r0 = View.MeasureSpec.getSize(r10);
        int r12 = View.MeasureSpec.getMode(r10);
        int r1 = (int) Math.ceil(this.l.x * this.h);
        if (this.A == false) goto L15;
        r1 = Math.max(r1, this.b.getMinimumWidth());
    L15:
        Layout r6 = this.O;
        if (r6 == null) goto L18;
        float r7 = r6.getWidth();
    L19:
        Layout r8 = this.P;
        if (r8 == null) goto L22;
        float r9 = r8.getWidth();
    L24:
        if (r7 == 0.0f) goto L26;
    L29:
        float r13 = Math.max(r7, r9) + (this.S * 2.0f);
        this.Q = r13;
        float r14 = r1;
        float r15 = r14 - this.l.x;
        if (r15 >= r13) goto L32;
        r1 = (int) (r14 + (r13 - r15));
    L32:
        RectF r16 = this.g;
        int r17 = Math.max(r1, (int) Math.ceil((r1 + r16.left) + r16.right));
        int r19 = Math.max(Math.max(r17, (getPaddingLeft() + r17) + getPaddingRight()), getSuggestedMinimumWidth());
        if (r12 != 1073741824) goto L35;
        r19 = Math.max(r19, r0);
    L37:
        int r110 = View.MeasureSpec.getMode(r11);
        int r111 = View.MeasureSpec.getSize(r11);
        float r20 = this.l.y;
        RectF r21 = this.g;
        int r22 = (int) Math.ceil(Math.max(r20, (r21.top + r20) + r21.right));
        Layout r23 = this.O;
        if (r23 == null) goto L40;
        float r24 = r23.getHeight();
    L41:
        Layout r25 = this.P;
        if (r25 == null) goto L44;
        float r26 = r25.getHeight();
    L46:
        if (r24 == 0.0f) goto L48;
    L51:
        float r27 = Math.max(r24, r26);
        this.R = r27;
        r22 = (int) Math.ceil(Math.max(r22, r27));
    L52:
        int r29 = Math.max(r22, getSuggestedMinimumHeight());
        int r30 = Math.max(r29, (getPaddingTop() + r29) + getPaddingBottom());
        if (r110 != 1073741824) goto L55;
        r30 = Math.max(r30, r111);
    L57:
        setMeasuredDimension(r19, r30);
        return;
    L55:
        if (r110 != Integer.MIN_VALUE) goto L57;
        r30 = Math.min(r30, r111);
        goto L57
    L48:
        if (r26 != 0.0f) goto L51;
        this.R = 0.0f;
        goto L52
    L44:
        r26 = 0.0f;
        goto L46
    L40:
        r24 = 0.0f;
        goto L41
    L35:
        if (r12 != Integer.MIN_VALUE) goto L37;
        r19 = Math.min(r19, r0);
        goto L37
    L26:
        if (r9 != 0.0f) goto L29;
        this.Q = 0.0f;
        goto L32
    L22:
        r9 = 0.0f;
        goto L24
    L18:
        r7 = 0.0f;
        goto L19
    }

    public LKUISwitchButton(Context r29, AttributeSet r30, int r31) {
        super(r29, r30, r31, 2131952417);
        this.B = false;
        this.T = true;
        this.U = false;
        this.I = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.J = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.y = new Paint(1);
        Paint r6 = new Paint(1);
        this.K = r6;
        r6.setStyle(Paint.Style.STROKE);
        Paint r7 = this.K;
        Resources r8 = getResources();
        r7.setStrokeWidth(WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density);
        this.N = getPaint();
        this.t = new RectF();
        this.u = new RectF();
        this.v = new RectF();
        this.l = new PointF();
        this.g = new RectF();
        this.w = new RectF();
        this.x = new RectF();
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this, "process", new float[]{0.0f, 0.0f}).setDuration(250);
        this.C = r9;
        r9.setInterpolator(new AccelerateDecelerateInterpolator());
        this.E = new RectF();
        Resources r10 = getResources();
        float r11 = WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).density;
        float r12 = r11 * 2.0f;
        float r13 = r11 * 20.0f;
        float r14 = r13 / 2.0f;
        if (r30 != null) goto L5;
        TypedArray r2 = null;
    L6:
        if (r2 == null) goto L8;
        Drawable r15 = r2.getDrawable(11);
        ColorStateList r16 = r2.getColorStateList(10);
        float r17 = r2.getDimension(13, r12);
        float r19 = r2.getDimension(15, r17);
        float r110 = r2.getDimension(16, r17);
        float r5 = r2.getDimension(17, r17);
        float r3 = r2.getDimension(14, r17);
        float r111 = r2.getDimension(19, r13);
        float r20 = r2.getDimension(12, r13);
        float r4 = r2.getDimension(18, Math.min(r111, r20) / 2.0f);
        float r21 = r2.getDimension(5, r4 + r12);
        Drawable r112 = r2.getDrawable(3);
        ColorStateList r22 = r2.getColorStateList(2);
        float r23 = r2.getFloat(4, 1.8f);
        int r24 = r2.getInteger(0, 250);
        boolean r25 = r2.getBoolean(6, true);
        int r26 = r2.getColor(20, 0);
        String r27 = r2.getString(9);
        String r32 = r2.getString(8);
        float r33 = r2.getDimension(7, Math.max(r12, r21 / 2.0f));
        boolean r113 = r2.getBoolean(1, true);
        r2.recycle();
        String r34 = r27;
        String r35 = r32;
        float r36 = r5;
        ColorStateList r37 = r22;
        float r210 = r4;
        float r114 = r21;
        float r38 = r19;
        float r115 = r33;
        int r116 = r24;
        Drawable r39 = r112;
        Drawable r117 = r15;
        float r118 = r20;
        boolean r40 = r113;
        float r211 = r23;
        boolean r119 = r25;
        float r212 = r3;
    L9:
        if (r30 != null) goto L11;
        TypedArray r1 = null;
    L12:
        if (r1 == null) goto L14;
        boolean r120 = r1.getBoolean(0, true);
        boolean r41 = r1.getBoolean(1, r120);
        setFocusable(r120);
        setClickable(r41);
        r1.recycle();
    L15:
        this.L = r34;
        this.M = r35;
        this.S = r115;
        this.T = r40;
        this.a = r117;
        this.d = r16;
        if (r117 == null) goto L18;
        boolean r42 = true;
    L19:
        this.z = r42;
        this.k = r26;
        if (r26 != 0) goto L25;
        TypedValue r43 = new TypedValue();
        boolean r44 = true;
        if (getContext().getTheme().resolveAttribute(2130969561, r43, true) == false) goto L24;
        this.k = r43.data;
    L27:
        if (this.z == true) goto L32;
        if (this.d != null) goto L32;
        ColorStateList r45 = a.b(this.k);
        this.d = r45;
        this.m = r45.getDefaultColor();
    L32:
        if (this.z == false) goto L34;
        r111 = Math.max(r111, this.a.getMinimumWidth());
        r118 = Math.max(r118, this.a.getMinimumHeight());
    L34:
        this.l.set(r111, r118);
        this.b = r39;
        this.c = r37;
        if (r39 != null) goto L38;
        r44 = false;
    L38:
        this.A = r44;
        if (r44 == true) goto L42;
        if (r37 != null) goto L42;
        ColorStateList r46 = a.a(this.k);
        this.c = r46;
        int r47 = r46.getDefaultColor();
        this.n = r47;
        this.o = this.c.getColorForState(W, r47);
    L42:
        this.g.set(r38, r36, r110, r212);
        float r48 = r211;
        if (this.g.width() < 0.0f) goto L45;
        float r121 = Math.max(r48, 1.0f);
    L46:
        this.h = r121;
        this.e = r210;
        this.f = r114;
        long r49 = r116;
        this.i = r49;
        this.j = r119;
        this.C.setDuration(r49);
        if (isChecked() == false) goto L50;
        setProcess(1.0f);
        return;
    L50:
        return;
    L45:
        r121 = r48;
        goto L46
    L24:
        this.k = 3309506;
        goto L27
    L25:
        r44 = true;
        goto L27
    L18:
        r42 = false;
        goto L19
    L14:
        setFocusable(true);
        setClickable(true);
        goto L15
    L11:
        r1 = getContext().obtainStyledAttributes(r30, new int[]{R.attr.focusable, R.attr.clickable});
        goto L12
    L8:
        r111 = r13;
        r115 = r12;
        r114 = r14;
        r210 = r114;
        r35 = null;
        r34 = null;
        r26 = 0;
        r37 = null;
        r39 = null;
        r38 = 0.0f;
        r36 = 0.0f;
        r117 = null;
        r110 = 0.0f;
        r16 = null;
        r119 = true;
        r116 = 250;
        r211 = 1.8f;
        r212 = 0.0f;
        r118 = r111;
        r40 = true;
        goto L9
    L5:
        r2 = getContext().obtainStyledAttributes(r30, new int[]{2130970451, 2130970452, 2130970453, 2130970454, 2130970455, 2130970456, 2130970457, 2130970458, 2130970459, 2130970460, 2130970461, 2130970462, 2130970463, 2130970464, 2130970465, 2130970466, 2130970467, 2130970468, 2130970469, 2130970470, 2130970471}, r31, 2131952417);
        goto L6
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 != r3) goto L5;
        if (r2 != r4) goto L5;
        return;
    L5:
        b();
    }
}
