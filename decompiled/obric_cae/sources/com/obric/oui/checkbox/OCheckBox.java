package com.obric.oui.checkbox;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.c;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public class OCheckBox extends AppCompatImageView implements Checkable {
    public static final int[] A = null;
    public static final int[] B = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f6253n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6254o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f6255p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6256q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6257r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6258s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ColorMatrixColorFilter f6259t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public PorterDuffColorFilter f6260u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public a f6261v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6262w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6263x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6264y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f6265z;

    public interface a {
        void b(OCheckBox r8, boolean r10);
    }

    public interface b {
    }

    static {
        A = new int[]{R.attr.state_checked};
        B = new int[]{com.obric.cae.R.attr.oui_state_indeterminate};
    }

    public OCheckBox(Context r8) {
        i.f(r8, "context");
        super(r8, null);
        this.f6255p = android.aimedia.a.a("Resources.getSystem()", 1, 18);
        this.f6262w = -1;
        this.f6263x = -1;
        this.f6264y = -1;
        this.f6265z = true;
        i(r8, null, com.obric.cae.R.attr.OCheckBoxStyle);
    }

    public static /* synthetic */ void getCheckedState$annotations() {
    }

    public final int getCheckedState() {
        return this.f6256q;
    }

    public final void h() {
        int r8 = this.f6263x;
        if (r8 == (-1)) goto L6;
        this.f6259t = new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(r8), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(r8), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(r8), 0.0f, 0.0f, 0.0f, (Color.alpha(r8) * 1.0f) / 255, 0.0f});
    L6:
        if (this.f6264y == (-1)) goto L9;
        this.f6260u = new PorterDuffColorFilter(this.f6264y, PorterDuff.Mode.SRC_IN);
        return;
    }

    public final void i(Context r8, AttributeSet r10, int r11) {
        TypedArray r12 = r8.obtainStyledAttributes(r10, nb.a.f9493g, r11, 0);
        i.e(r12, "context.obtainStyledAttr…heckBox, defStyleAttr, 0)");
        this.f6254o = r12.getInt(4, 0);
        this.f6265z = r12.getBoolean(0, true);
        this.f6262w = r12.getColor(5, -1);
        this.f6263x = r12.getColor(3, -1);
        this.f6264y = r12.getColor(6, -1);
        Drawable r13 = r12.getDrawable(2);
        if (r13 != null) goto L6;
        r13 = null;
    L6:
        this.f6253n = r13;
        this.f6258s = r12.getBoolean(1, false);
        if (r12.hasValue(7) == false) goto L9;
        setCheckedState(r12.getInt(7, 0));
    L9:
        r12.recycle();
        h();
        Drawable r14 = this.f6253n;
        if (r14 != null) goto L12;
        k();
    L13:
        setBackground(null);
        j();
        setClickable(true);
        return;
    L12:
        setImageDrawable(r14);
        goto L13
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        if (this.f6256q == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void j() {
        Drawable r8 = getDrawable();
        if (r8 == null) goto L5;
        r8.clearColorFilter();
    L5:
        h();
        Drawable r10 = getDrawable();
        if (r10 != null) goto L8;
        return;
    L8:
        if (isChecked() == false) goto L10;
        ColorFilter r11 = this.f6259t;
    L11:
        r10.setColorFilter(r11);
        return;
    L10:
        r11 = this.f6260u;
        goto L11
    }

    public final void k() {
        boolean r8 = this.f6258s;
        if (r8 == false) goto L5;
        Resources r10 = getResources();
        int r11 = com.obric.cae.R.drawable.o_checkbox_circle_always_light;
    L11:
        Drawable r12 = r10.getDrawable(r11, null);
        this.f6253n = r12;
        int r13 = this.f6262w;
        if (r13 != (-1)) goto L14;
    L35:
        setImageDrawable(this.f6253n);
        return;
    L14:
        if ((r12 instanceof StateListDrawable) == false) goto L35;
        if (r12 == null) goto L34;
        StateListDrawable r14 = (StateListDrawable) r12;
        int r15 = r14.getStateCount();
        int r16 = 0;
    L17:
        if (r16 >= r15) goto L35;
        Drawable r17 = r14.getStateDrawable(r16);
        if ((r17 instanceof VectorDrawable) == false) goto L26;
        VectorDrawable r18 = (VectorDrawable) r17;
        yc.a.a(r18, r13);     // Catch: Exception -> L23
        r18.invalidateSelf();     // Catch: Exception -> L23
    L32:
        r16 = r16 + 1;
    L23:
        e = move-exception;
        Log.e("VectorBreaker", "Color injection failed", e);
        goto L32
    L26:
        if ((r17 instanceof AnimatedVectorDrawable) == false) goto L32;
        AnimatedVectorDrawable r19 = (AnimatedVectorDrawable) r17;
        yc.a.b(r19, r13);     // Catch: Exception -> L30
        r19.invalidateSelf();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        Log.e("VectorBreaker", "setPathColor2, Color injection failed", e);
        goto L32
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.StateListDrawable");
    L5:
        if (r8 == false) goto L7;
    L10:
        r10 = getResources();
        r11 = com.obric.cae.R.drawable.o_checkbox_circle;
        goto L11
    L7:
        if (this.f6254o != 1) goto L10;
        r10 = getResources();
        r11 = com.obric.cae.R.drawable.o_checkbox_circle_on_image;
        goto L11
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6265z == false) goto L6;
        Resources r8 = Resources.getSystem();
        i.e(r8, "Resources.getSystem()");
        int r10 = l6.a.I0(TypedValue.applyDimension(1, 44, r8.getDisplayMetrics()));
        bc.a.a(this, r10, r10, false);
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int r8) {
        int[] r10 = super.onCreateDrawableState(r8 + 2);
        if (this.f6256q != 2) goto L6;
        ImageView.mergeDrawableStates(r10, B);
    L6:
        if (isChecked() == false) goto L8;
        View.mergeDrawableStates(r10, A);
    L8:
        return r10;
    }

    @Override // android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r8, int r10) {
        int r11 = View.MeasureSpec.makeMeasureSpec(this.f6255p, 1073741824);
        super.onMeasure(r11, r11);
    }

    @Override // android.view.View
    public final boolean performClick() {
        toggle();
        boolean r8 = super.performClick();
        if (r8 == true) goto L6;
        playSoundEffect(0);
    L6:
        if (isChecked() == false) goto L8;
        c.o0(getContext(), 1);
    L8:
        return r8;
    }

    public final void setAlwaysLight(boolean r8) {
        this.f6258s = r8;
        k();
        invalidate();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r8) {
        setCheckedState(r8 ? 1 : 0);
    }

    public final void setCheckedState(int r8) {
        if (this.f6256q == r8) goto L14;
        this.f6256q = r8;
        j();
        refreshDrawableState();
        if (this.f6257r == false) goto L7;
        return;
    L7:
        this.f6257r = true;
        if (this.f6256q == 2) goto L12;
        a r10 = this.f6261v;
        if (r10 == null) goto L12;
        r10.b(this, isChecked());
    L12:
        this.f6257r = false;
        return;
    }

    public final void setOnCheckedChangeListener(a r8) {
        this.f6261v = r8;
    }

    public final void setOnCheckedStateChangedListener(b r8) {
    }

    public final void setPrimaryColor(int r8) {
        this.f6262w = r8;
        k();
        invalidate();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    public OCheckBox(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        i.f(r10, "attrs");
        super(r8, r10);
        this.f6255p = android.aimedia.a.a("Resources.getSystem()", 1, 18);
        this.f6262w = -1;
        this.f6263x = -1;
        this.f6264y = -1;
        this.f6265z = true;
        i(r8, r10, com.obric.cae.R.attr.OCheckBoxStyle);
    }

    public OCheckBox(Context r8, AttributeSet r10, int r11) {
        i.f(r8, "context");
        i.f(r10, "attrs");
        super(r8, r10, r11);
        this.f6255p = android.aimedia.a.a("Resources.getSystem()", 1, 18);
        this.f6262w = -1;
        this.f6263x = -1;
        this.f6264y = -1;
        this.f6265z = true;
        i(r8, r10, r11);
    }
}
