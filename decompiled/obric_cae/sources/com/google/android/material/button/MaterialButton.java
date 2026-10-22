package com.google.android.material.button;

import aa.j;
import aa.n;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.e;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.l;
import com.google.android.material.internal.q;
import j0.h0;
import j0.w;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import x9.c;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends e implements Checkable, n {
    public static final int[] B = null;
    public static final int[] C = null;
    public int A;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.material.button.a f4448n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinkedHashSet<a> f4449o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f4450p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f4451q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ColorStateList f4452r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Drawable f4453s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f4454t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4455u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f4456v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4457w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f4458x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f4459y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f4460z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f4461m;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r8) {
                return new SavedState(r8, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r8) {
                return new SavedState[r8];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r8, ClassLoader r10) {
                return new SavedState(r8, r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r8, ClassLoader r10) {
            super(r8, r10);
            if (r10 != null) goto L5;
            getClass().getClassLoader();
        L5:
            boolean r11 = true;
            if (r8.readInt() == 1) goto L9;
            r11 = false;
        L9:
            this.f4461m = r11;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeParcelable(this.f1731a, r10);
            r8.writeInt(this.f4461m ? 1 : 0);
        }
    }

    public interface a {
        void a();
    }

    public interface b {
    }

    static {
        B = new int[]{R.attr.state_checkable};
        C = new int[]{R.attr.state_checked};
    }

    public MaterialButton(Context r10, AttributeSet r11) {
        super(ea.a.a(r10, r11, com.obric.cae.R.attr.materialButtonStyle, com.obric.cae.R.style.Widget_MaterialComponents_Button), r11, com.obric.cae.R.attr.materialButtonStyle);
        this.f4449o = new LinkedHashSet();
        boolean r12 = false;
        this.f4459y = false;
        this.f4460z = false;
        Context r8 = getContext();
        TypedArray r13 = l.d(r8, r11, g9.a.f7770k, com.obric.cae.R.attr.materialButtonStyle, com.obric.cae.R.style.Widget_MaterialComponents_Button, new int[0]);
        this.f4458x = r13.getDimensionPixelSize(12, 0);
        this.f4451q = q.b(r13.getInt(15, -1), PorterDuff.Mode.SRC_IN);
        this.f4452r = c.a(getContext(), r13, 14);
        this.f4453s = c.c(getContext(), r13, 10);
        this.A = r13.getInteger(11, 1);
        this.f4455u = r13.getDimensionPixelSize(13, 0);
        com.google.android.material.button.a r14 = new com.google.android.material.button.a(this, new j(j.b(r8, r11, com.obric.cae.R.attr.materialButtonStyle, com.obric.cae.R.style.Widget_MaterialComponents_Button)));
        this.f4448n = r14;
        r14.f4483c = r13.getDimensionPixelOffset(1, 0);
        r14.f4484d = r13.getDimensionPixelOffset(2, 0);
        r14.f4485e = r13.getDimensionPixelOffset(3, 0);
        r14.f4486f = r13.getDimensionPixelOffset(4, 0);
        if (r13.hasValue(8) == false) goto L5;
        int r15 = r13.getDimensionPixelSize(8, -1);
        r14.f4487g = r15;
        j r16 = r14.f4482b;
        float r17 = r15;
        r16.getClass();
        j.a r18 = new j.a(r16);
        r18.e(r17);
        r18.f(r17);
        r18.d(r17);
        r18.c(r17);
        r14.c(new j(r18));
        r14.f4496p = true;
    L5:
        r14.f4488h = r13.getDimensionPixelSize(20, 0);
        r14.f4489i = q.b(r13.getInt(7, -1), PorterDuff.Mode.SRC_IN);
        r14.f4490j = c.a(getContext(), r13, 6);
        r14.f4491k = c.a(getContext(), r13, 19);
        r14.f4492l = c.a(getContext(), r13, 16);
        r14.f4497q = r13.getBoolean(5, false);
        r14.f4500t = r13.getDimensionPixelSize(9, 0);
        r14.f4498r = r13.getBoolean(21, true);
        WeakHashMap<View, h0> r19 = w.f8437a;
        int r20 = w.e.f(this);
        int r21 = getPaddingTop();
        int r22 = w.e.e(this);
        int r23 = getPaddingBottom();
        if (r13.hasValue(0) == false) goto L8;
        r14.f4495o = true;
        setSupportBackgroundTintList(r14.f4490j);
        setSupportBackgroundTintMode(r14.f4489i);
    L9:
        w.e.k(this, r20 + r14.f4483c, r21 + r14.f4485e, r22 + r14.f4484d, r23 + r14.f4486f);
        r13.recycle();
        setCompoundDrawablePadding(this.f4458x);
        if (this.f4453s == null) goto L12;
        r12 = true;
    L12:
        c(r12);
        return;
    L8:
        r14.e();
        goto L9
    }

    private Layout.Alignment getActualTextAlignment() {
        int r8 = getTextAlignment();
        if (r8 == 1) goto L17;
        if (r8 == 6) goto L15;
        if (r8 == 3) goto L15;
        if (r8 == 4) goto L13;
        return Layout.Alignment.ALIGN_NORMAL;
    L13:
        return Layout.Alignment.ALIGN_CENTER;
    L15:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L17:
        return getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int r8 = getGravity() & 8388615;
        if (r8 == 1) goto L13;
        if (r8 == 5) goto L11;
        if (r8 == 8388613) goto L11;
        return Layout.Alignment.ALIGN_NORMAL;
    L11:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L13:
        return Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) goto L5;
        TextPaint r8 = getPaint();
        String r10 = getText().toString();
        if (getTransformationMethod() == null) goto L9;
        r10 = getTransformationMethod().getTransformation(r10, this).toString();
    L9:
        Rect r11 = new Rect();
        r8.getTextBounds(r10, 0, r10.length(), r11);
        return Math.min(r11.height(), getLayout().getHeight());
    L5:
        return getLayout().getHeight();
    }

    private int getTextLayoutWidth() {
        int r8 = getLineCount();
        float r10 = 0.0f;
        int r11 = 0;
    L3:
        if (r11 >= r8) goto L6;
        r10 = Math.max(r10, getLayout().getLineWidth(r11));
        r11 = r11 + 1;
        goto L3
    L6:
        return (int) Math.ceil(r10);
    }

    public final boolean a() {
        com.google.android.material.button.a r8 = this.f4448n;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.f4495o == true) goto L7;
        return true;
    }

    public final void b() {
        int r8 = this.A;
        boolean r10 = false;
        if (r8 != 1) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (r11 == false) goto L13;
        androidx.core.widget.l.e(this, this.f4453s, null, null, null);
        return;
    L13:
        if (r8 != 3) goto L15;
    L18:
        boolean r12 = true;
    L19:
        if (r12 == false) goto L22;
        androidx.core.widget.l.e(this, null, null, this.f4453s, null);
        return;
    L22:
        if (r8 != 16) goto L24;
    L25:
        r10 = true;
    L26:
        if (r10 == false) goto L31;
        androidx.core.widget.l.e(this, null, this.f4453s, null, null);
        return;
    L31:
        return;
    L24:
        if (r8 != 32) goto L26;
    L15:
        if (r8 == 4) goto L18;
        r12 = false;
        goto L19
    L5:
        if (r8 == 2) goto L8;
        r11 = false;
        goto L10
    }

    public final void c(boolean r8) {
        Drawable r10 = this.f4453s;
        boolean r11 = true;
        if (r10 == null) goto L16;
        Drawable r12 = r10.mutate();
        this.f4453s = r12;
        b0.a.b.h(r12, this.f4452r);
        PorterDuff.Mode r13 = this.f4451q;
        if (r13 == null) goto L7;
        b0.a.b.i(this.f4453s, r13);
    L7:
        int r14 = this.f4455u;
        if (r14 != 0) goto L11;
        r14 = this.f4453s.getIntrinsicWidth();
    L11:
        int r15 = this.f4455u;
        if (r15 != 0) goto L15;
        r15 = this.f4453s.getIntrinsicHeight();
    L15:
        Drawable r16 = this.f4453s;
        int r17 = this.f4456v;
        int r18 = this.f4457w;
        r16.setBounds(r17, r18, r14 + r17, r15 + r18);
        this.f4453s.setVisible(true, r8);
    L16:
        if (r8 == false) goto L19;
        b();
        return;
    L19:
        Drawable[] r19 = androidx.core.widget.l.a(this);
        Drawable r20 = r19[0];
        Drawable r21 = r19[1];
        Drawable r22 = r19[2];
        int r23 = this.A;
        if (r23 == 1) goto L24;
        if (r23 == 2) goto L24;
        boolean r24 = false;
    L25:
        if (r24 == false) goto L29;
        if (r20 == this.f4453s) goto L29;
    L50:
        if (r11 == false) goto L53;
        b();
        return;
    L53:
        return;
    L29:
        if (r23 != 3) goto L31;
    L34:
        boolean r25 = true;
    L35:
        if (r25 == false) goto L39;
        if (r22 != this.f4453s) goto L50;
    L39:
        if (r23 != 16) goto L41;
    L44:
        boolean r26 = true;
    L45:
        if (r26 == true) goto L47;
    L49:
        r11 = false;
        goto L50
    L47:
        if (r21 == this.f4453s) goto L49;
    L41:
        if (r23 == 32) goto L44;
        r26 = false;
        goto L45
    L31:
        if (r23 == 4) goto L34;
        r25 = false;
    L24:
        r24 = true;
        goto L25
    }

    public final void d(int r8, int r10) {
        if (this.f4453s != null) goto L5;
        return;
    L5:
        if (getLayout() == null) goto L76;
        int r11 = this.A;
        boolean r12 = true;
        if (r11 == 1) goto L12;
        if (r11 == 2) goto L12;
        boolean r13 = false;
    L14:
        if (r13 == true) goto L38;
        if (r11 == 3) goto L19;
        if (r11 == 4) goto L19;
        boolean r14 = false;
    L20:
        if (r14 == true) goto L38;
        if (r11 != 16) goto L25;
    L28:
        if (r12 == false) goto L72;
        this.f4456v = 0;
        if (r11 != 16) goto L32;
        this.f4457w = 0;
    L70:
        c(false);
        return;
    L32:
        int r15 = this.f4455u;
        if (r15 != 0) goto L35;
        r15 = this.f4453s.getIntrinsicHeight();
    L35:
        int r16 = Math.max(0, (((((r10 - getTextHeight()) - getPaddingTop()) - r15) - this.f4458x) - getPaddingBottom()) / 2);
        if (this.f4457w == r16) goto L73;
        this.f4457w = r16;
    L67:
        c(false);
        return;
    L73:
        return;
    L72:
        return;
    L25:
        if (r11 == 32) goto L28;
        r12 = false;
    L19:
        r14 = true;
    L38:
        this.f4457w = 0;
        Layout.Alignment r17 = getActualTextAlignment();
        int r18 = this.A;
        if (r18 == 1) goto L69;
        if (r18 == 3) goto L69;
        if (r18 == 2) goto L43;
    L44:
        if (r18 == 4) goto L46;
    L48:
        int r19 = this.f4455u;
        if (r19 != 0) goto L51;
        r19 = this.f4453s.getIntrinsicWidth();
    L51:
        int r20 = r8 - getTextLayoutWidth();
        WeakHashMap<View, h0> r21 = w.f8437a;
        int r22 = (((r20 - w.e.e(this)) - r19) - this.f4458x) - w.e.f(this);
        if (r17 != Layout.Alignment.ALIGN_CENTER) goto L55;
        r22 = r22 / 2;
    L55:
        if (w.e.d(this) != 1) goto L57;
        boolean r23 = true;
    L59:
        if (this.A == 4) goto L62;
        r12 = false;
    L62:
        if (r23 == r12) goto L65;
        r22 = -r22;
    L65:
        if (this.f4456v == r22) goto L74;
        this.f4456v = r22;
        goto L67
    L74:
        return;
    L57:
        r23 = false;
        goto L59
    L46:
        if (r17 != Layout.Alignment.ALIGN_OPPOSITE) goto L48;
    L43:
        if (r17 != Layout.Alignment.ALIGN_NORMAL) goto L44;
    L69:
        this.f4456v = 0;
    L12:
        r13 = true;
        goto L14
    }

    public String getA11yClassName() {
        if (TextUtils.isEmpty(this.f4454t) == false) goto L5;
        com.google.android.material.button.a r8 = this.f4448n;
        if (r8 != null) goto L9;
    L11:
        boolean r10 = false;
    L12:
        if (r10 == false) goto L14;
        Class r11 = CompoundButton.class;
    L16:
        return r11.getName();
    L14:
        r11 = Button.class;
        goto L16
    L9:
        if (r8.f4497q == false) goto L11;
        r10 = true;
        goto L12
    L5:
        return this.f4454t;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (a() == true) goto L7;
        return 0;
    L7:
        return this.f4448n.f4487g;
    }

    public Drawable getIcon() {
        return this.f4453s;
    }

    public int getIconGravity() {
        return this.A;
    }

    public int getIconPadding() {
        return this.f4458x;
    }

    public int getIconSize() {
        return this.f4455u;
    }

    public ColorStateList getIconTint() {
        return this.f4452r;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f4451q;
    }

    public int getInsetBottom() {
        return this.f4448n.f4486f;
    }

    public int getInsetTop() {
        return this.f4448n.f4485e;
    }

    public ColorStateList getRippleColor() {
        if (a() == true) goto L7;
        return null;
    L7:
        return this.f4448n.f4492l;
    }

    public j getShapeAppearanceModel() {
        if (a() == false) goto L7;
        return this.f4448n.f4482b;
    L7:
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (a() == true) goto L7;
        return null;
    L7:
        return this.f4448n.f4491k;
    }

    public int getStrokeWidth() {
        if (a() == true) goto L7;
        return 0;
    L7:
        return this.f4448n.f4488h;
    }

    @Override // androidx.appcompat.widget.e
    public ColorStateList getSupportBackgroundTintList() {
        if (a() == false) goto L7;
        return this.f4448n.f4490j;
    L7:
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.e
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (a() == false) goto L7;
        return this.f4448n.f4489i;
    L7:
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f4459y;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (a() == false) goto L6;
        defpackage.c.i0(this, this.f4448n.b(false));
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int r8) {
        int[] r10 = super.onCreateDrawableState(r8 + 2);
        com.google.android.material.button.a r11 = this.f4448n;
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L11;
        Button.mergeDrawableStates(r10, B);
    L11:
        if (isChecked() == false) goto L13;
        Button.mergeDrawableStates(r10, C);
    L13:
        return r10;
    L5:
        if (r11.f4497q == false) goto L7;
        r12 = true;
        goto L8
    }

    @Override // androidx.appcompat.widget.e, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r8) {
        super.onInitializeAccessibilityEvent(r8);
        r8.setClassName(getA11yClassName());
        r8.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.e, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r8) {
        super.onInitializeAccessibilityNodeInfo(r8);
        r8.setClassName(getA11yClassName());
        com.google.android.material.button.a r10 = this.f4448n;
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        r8.setCheckable(r11);
        r8.setChecked(isChecked());
        r8.setClickable(isClickable());
        return;
    L5:
        if (r10.f4497q == false) goto L7;
        r11 = true;
        goto L8
    }

    @Override // androidx.appcompat.widget.e, android.widget.TextView, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        if ((r8 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r8);
        return;
    L6:
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.f1731a);
        setChecked(r10.f4461m);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState(super.onSaveInstanceState());
        r8.f4461m = this.f4459y;
        return r8;
    }

    @Override // androidx.appcompat.widget.e, android.widget.TextView
    public final void onTextChanged(CharSequence r8, int r10, int r11, int r12) {
        super.onTextChanged(r8, r10, r11, r12);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (this.f4448n.f4498r == false) goto L6;
        toggle();
    L6:
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f4453s == null) goto L8;
        int[] r8 = getDrawableState();
        if (this.f4453s.setState(r8) == false) goto L9;
        invalidate();
        return;
    L9:
        return;
    }

    public void setA11yClassName(String r8) {
        this.f4454t = r8;
    }

    @Override // android.view.View
    public void setBackground(Drawable r8) {
        setBackgroundDrawable(r8);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r8) {
        if (a() == false) goto L7;
        com.google.android.material.button.a r10 = this.f4448n;
        if (r10.b(false) == null) goto L9;
        r10.b(false).setTint(r8);
        return;
    L9:
        return;
    L7:
        super.setBackgroundColor(r8);
    }

    @Override // androidx.appcompat.widget.e, android.view.View
    public void setBackgroundDrawable(Drawable r8) {
        if (a() == true) goto L5;
    L8:
        super.setBackgroundDrawable(r8);
        return;
    L5:
        if (r8 == getBackground()) goto L7;
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        com.google.android.material.button.a r10 = this.f4448n;
        r10.f4495o = true;
        ColorStateList r11 = r10.f4490j;
        MaterialButton r12 = r10.f4481a;
        r12.setSupportBackgroundTintList(r11);
        r12.setSupportBackgroundTintMode(r10.f4489i);
        goto L8
    L7:
        getBackground().setState(r8.getState());
    }

    @Override // androidx.appcompat.widget.e, android.view.View
    public void setBackgroundResource(int r8) {
        if (r8 == 0) goto L4;
        Drawable r10 = d.a.a(getContext(), r8);
    L5:
        setBackgroundDrawable(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList r8) {
        setSupportBackgroundTintList(r8);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode r8) {
        setSupportBackgroundTintMode(r8);
    }

    public void setCheckable(boolean r8) {
        if (a() == false) goto L6;
        this.f4448n.f4497q = r8;
        return;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r8) {
        com.google.android.material.button.a r10 = this.f4448n;
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == true) goto L10;
        return;
    L10:
        if (isEnabled() == true) goto L12;
        return;
    L12:
        if (this.f4459y == r8) goto L31;
        this.f4459y = r8;
        refreshDrawableState();
        if ((getParent() instanceof MaterialButtonToggleGroup) == false) goto L20;
        MaterialButtonToggleGroup r12 = (MaterialButtonToggleGroup) getParent();
        boolean r13 = this.f4459y;
        if (r12.f4468p == true) goto L20;
        r12.b(getId(), r13);
    L20:
        if (this.f4460z == false) goto L22;
        return;
    L22:
        this.f4460z = true;
        Iterator<a> r14 = this.f4449o.iterator();
    L24:
        if (r14.hasNext() == false) goto L26;
        r14.next().a();
        goto L24
    L26:
        this.f4460z = false;
        return;
    L31:
        return;
    L5:
        if (r10.f4497q == false) goto L7;
        r11 = true;
        goto L8
    }

    public void setCornerRadius(int r8) {
        if (a() == false) goto L10;
        com.google.android.material.button.a r10 = this.f4448n;
        if (r10.f4496p == true) goto L7;
    L8:
        r10.f4487g = r8;
        r10.f4496p = true;
        j r11 = r10.f4482b;
        float r12 = r8;
        r11.getClass();
        j.a r13 = new j.a(r11);
        r13.e(r12);
        r13.f(r12);
        r13.d(r12);
        r13.c(r12);
        r10.c(new j(r13));
        return;
    L7:
        if (r10.f4487g != r8) goto L8;
        return;
    }

    public void setCornerRadiusResource(int r8) {
        if (a() == false) goto L6;
        setCornerRadius(getResources().getDimensionPixelSize(r8));
        return;
    }

    @Override // android.view.View
    public void setElevation(float r8) {
        super.setElevation(r8);
        if (a() == false) goto L6;
        this.f4448n.b(false).j(r8);
        return;
    }

    public void setIcon(Drawable r8) {
        if (this.f4453s == r8) goto L6;
        this.f4453s = r8;
        c(true);
        d(getMeasuredWidth(), getMeasuredHeight());
        return;
    }

    public void setIconGravity(int r8) {
        if (this.A == r8) goto L6;
        this.A = r8;
        d(getMeasuredWidth(), getMeasuredHeight());
        return;
    }

    public void setIconPadding(int r8) {
        if (this.f4458x == r8) goto L6;
        this.f4458x = r8;
        setCompoundDrawablePadding(r8);
        return;
    }

    public void setIconResource(int r8) {
        if (r8 == 0) goto L4;
        Drawable r10 = d.a.a(getContext(), r8);
    L5:
        setIcon(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setIconSize(int r8) {
        if (r8 < 0) goto L8;
        if (this.f4455u == r8) goto L9;
        this.f4455u = r8;
        c(true);
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(ColorStateList r8) {
        if (this.f4452r == r8) goto L6;
        this.f4452r = r8;
        c(false);
        return;
    }

    public void setIconTintMode(PorterDuff.Mode r8) {
        if (this.f4451q == r8) goto L6;
        this.f4451q = r8;
        c(false);
        return;
    }

    public void setIconTintResource(int r8) {
        setIconTint(androidx.core.content.a.b(getContext(), r8));
    }

    public void setInsetBottom(int r8) {
        com.google.android.material.button.a r10 = this.f4448n;
        r10.d(r10.f4485e, r8);
    }

    public void setInsetTop(int r8) {
        com.google.android.material.button.a r10 = this.f4448n;
        r10.d(r8, r10.f4486f);
    }

    public void setInternalBackground(Drawable r8) {
        super.setBackgroundDrawable(r8);
    }

    public void setOnPressedChangeListenerInternal(b r8) {
        this.f4450p = r8;
    }

    @Override // android.view.View
    public void setPressed(boolean r8) {
        b r10 = this.f4450p;
        if (r10 == null) goto L5;
        ((MaterialButtonToggleGroup.e) r10).f4480a.invalidate();
    L5:
        super.setPressed(r8);
    }

    public void setRippleColor(ColorStateList r8) {
        if (a() == false) goto L14;
        com.google.android.material.button.a r10 = this.f4448n;
        if (r10.f4492l == r8) goto L15;
        r10.f4492l = r8;
        MaterialButton r11 = r10.f4481a;
        if ((r11.getBackground() instanceof RippleDrawable) == false) goto L16;
        RippleDrawable r12 = (RippleDrawable) r11.getBackground();
        if (r8 != null) goto L12;
        r8 = ColorStateList.valueOf(0);
    L12:
        r12.setColor(r8);
        return;
    L16:
        return;
    L15:
        return;
    }

    public void setRippleColorResource(int r8) {
        if (a() == false) goto L6;
        setRippleColor(androidx.core.content.a.b(getContext(), r8));
        return;
    }

    @Override // aa.n
    public void setShapeAppearanceModel(j r8) {
        if (a() == false) goto L7;
        this.f4448n.c(r8);
        return;
    L7:
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean r8) {
        if (a() == false) goto L6;
        com.google.android.material.button.a r10 = this.f4448n;
        r10.f4494n = r8;
        r10.f();
        return;
    }

    public void setStrokeColor(ColorStateList r8) {
        if (a() == false) goto L8;
        com.google.android.material.button.a r10 = this.f4448n;
        if (r10.f4491k == r8) goto L9;
        r10.f4491k = r8;
        r10.f();
        return;
    L9:
        return;
    }

    public void setStrokeColorResource(int r8) {
        if (a() == false) goto L6;
        setStrokeColor(androidx.core.content.a.b(getContext(), r8));
        return;
    }

    public void setStrokeWidth(int r8) {
        if (a() == false) goto L8;
        com.google.android.material.button.a r10 = this.f4448n;
        if (r10.f4488h == r8) goto L9;
        r10.f4488h = r8;
        r10.f();
        return;
    L9:
        return;
    }

    public void setStrokeWidthResource(int r8) {
        if (a() == false) goto L6;
        setStrokeWidth(getResources().getDimensionPixelSize(r8));
        return;
    }

    @Override // androidx.appcompat.widget.e
    public void setSupportBackgroundTintList(ColorStateList r8) {
        if (a() == false) goto L9;
        com.google.android.material.button.a r10 = this.f4448n;
        if (r10.f4490j == r8) goto L11;
        r10.f4490j = r8;
        if (r10.b(false) == null) goto L12;
        b0.a.b.h(r10.b(false), r10.f4490j);
        return;
    L12:
        return;
    L11:
        return;
    L9:
        super.setSupportBackgroundTintList(r8);
    }

    @Override // androidx.appcompat.widget.e
    public void setSupportBackgroundTintMode(PorterDuff.Mode r8) {
        if (a() == false) goto L11;
        com.google.android.material.button.a r10 = this.f4448n;
        if (r10.f4489i == r8) goto L13;
        r10.f4489i = r8;
        if (r10.b(false) != null) goto L9;
        return;
    L9:
        if (r10.f4489i == null) goto L15;
        b0.a.b.i(r10.b(false), r10.f4489i);
        return;
    L15:
        return;
    L13:
        return;
    L11:
        super.setSupportBackgroundTintMode(r8);
    }

    @Override // android.view.View
    public void setTextAlignment(int r8) {
        super.setTextAlignment(r8);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean r8) {
        this.f4448n.f4498r = r8;
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f4459y);
    }
}
