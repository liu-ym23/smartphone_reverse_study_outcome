package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageButton;
import com.obric.oui.constraintlayout.widget.R$styleable;
import kr.a;
import kr.c;

/* JADX INFO: loaded from: classes3.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f12918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f12919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f12920c;
    public float d;
    public Path e;
    public ViewOutlineProvider f;
    public RectF g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable[] f12921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LayerDrawable f12922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f12924k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f12925l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f12926m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f12927n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f12928o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f12929p;

    public ImageFilterButton(Context r5) {
        super(r5);
        this.f12918a = new c();
        this.f12919b = 0.0f;
        this.f12920c = 0.0f;
        this.d = Float.NaN;
        this.f12921h = new Drawable[2];
        this.f12923j = true;
        this.f12924k = null;
        this.f12925l = null;
        this.f12926m = Float.NaN;
        this.f12927n = Float.NaN;
        this.f12928o = Float.NaN;
        this.f12929p = Float.NaN;
        setPadding(0, 0, 0, 0);
    }

    private void setOverlay(boolean r5) {
        this.f12923j = r5;
    }

    public final void a(Context r10, AttributeSet r11) {
        setPadding(0, 0, 0, 0);
        if (r11 == null) goto L64;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.ImageFilterView);
        int r13 = r12.getIndexCount();
        this.f12924k = r12.getDrawable(R$styleable.ImageFilterView_altSrc);
        int r5 = 0;
    L5:
        if (r5 >= r13) goto L40;
        int r14 = r12.getIndex(r5);
        if (r14 != R$styleable.ImageFilterView_crossfade) goto L10;
        this.f12919b = r12.getFloat(r14, 0.0f);
    L39:
        r5 = r5 + 1;
        goto L5
    L10:
        if (r14 != R$styleable.ImageFilterView_warmth) goto L13;
        setWarmth(r12.getFloat(r14, 0.0f));
        goto L39
    L13:
        if (r14 != R$styleable.ImageFilterView_saturation) goto L16;
        setSaturation(r12.getFloat(r14, 0.0f));
        goto L39
    L16:
        if (r14 != R$styleable.ImageFilterView_contrast) goto L19;
        setContrast(r12.getFloat(r14, 0.0f));
        goto L39
    L19:
        if (r14 != R$styleable.ImageFilterView_round) goto L22;
        setRound(r12.getDimension(r14, 0.0f));
        goto L39
    L22:
        if (r14 != R$styleable.ImageFilterView_roundPercent) goto L25;
        setRoundPercent(r12.getFloat(r14, 0.0f));
        goto L39
    L25:
        if (r14 != R$styleable.ImageFilterView_overlay) goto L28;
        setOverlay(r12.getBoolean(r14, this.f12923j));
        goto L39
    L28:
        if (r14 != R$styleable.ImageFilterView_imagePanX) goto L31;
        setImagePanX(r12.getFloat(r14, this.f12926m));
        goto L39
    L31:
        if (r14 != R$styleable.ImageFilterView_imagePanY) goto L34;
        setImagePanY(r12.getFloat(r14, this.f12927n));
        goto L39
    L34:
        if (r14 != R$styleable.ImageFilterView_imageRotate) goto L37;
        setImageRotate(r12.getFloat(r14, this.f12929p));
        goto L39
    L37:
        if (r14 != R$styleable.ImageFilterView_imageZoom) goto L39;
        setImageZoom(r12.getFloat(r14, this.f12928o));
        goto L39
    L40:
        r12.recycle();
        Drawable r15 = getDrawable();
        this.f12925l = r15;
        Drawable r16 = this.f12924k;
        Drawable[] r17 = this.f12921h;
        if (r16 == null) goto L47;
        if (r15 == null) goto L47;
        Drawable r18 = getDrawable().mutate();
        this.f12925l = r18;
        r17[0] = r18;
        r17[1] = this.f12924k.mutate();
        LayerDrawable r19 = new LayerDrawable(r17);
        this.f12922i = r19;
        r19.getDrawable(1).setAlpha((int) (this.f12919b * 255.0f));
        if (this.f12923j == true) goto L46;
        this.f12922i.getDrawable(0).setAlpha((int) ((1.0f - this.f12919b) * 255.0f));
    L46:
        super.setImageDrawable(this.f12922i);
        return;
    L47:
        Drawable r20 = getDrawable();
        this.f12925l = r20;
        if (r20 == null) goto L66;
        Drawable r21 = r20.mutate();
        this.f12925l = r21;
        r17[0] = r21;
        return;
    L66:
        return;
    }

    public final void b() {
        if (Float.isNaN(this.f12926m) == true) goto L5;
    L11:
        float r5 = 0.0f;
        if (Float.isNaN(this.f12926m) == false) goto L14;
        float r10 = 0.0f;
    L16:
        if (Float.isNaN(this.f12927n) == false) goto L18;
        float r11 = 0.0f;
    L20:
        if (Float.isNaN(this.f12928o) == false) goto L22;
        float r12 = 1.0f;
    L24:
        if (Float.isNaN(this.f12929p) == true) goto L27;
        r5 = this.f12929p;
    L27:
        Matrix r13 = new Matrix();
        r13.reset();
        float r14 = getDrawable().getIntrinsicWidth();
        float r15 = getDrawable().getIntrinsicHeight();
        float r16 = getWidth();
        float r17 = getHeight();
        if ((r14 * r17) >= (r15 * r16)) goto L30;
        float r18 = r16 / r14;
    L31:
        float r19 = r12 * r18;
        r13.postScale(r19, r19);
        float r20 = r14 * r19;
        float r21 = r19 * r15;
        r13.postTranslate(((((r16 - r20) * r10) + r16) - r20) * 0.5f, ((((r17 - r21) * r11) + r17) - r21) * 0.5f);
        r13.postRotate(r5, r16 / 2.0f, r17 / 2.0f);
        setImageMatrix(r13);
        setScaleType(ImageView.ScaleType.MATRIX);
        return;
    L30:
        r18 = r17 / r15;
        goto L31
    L22:
        r12 = this.f12928o;
        goto L24
    L18:
        r11 = this.f12927n;
        goto L20
    L14:
        r10 = this.f12926m;
        goto L16
    L5:
        if (Float.isNaN(this.f12927n) == false) goto L11;
        if (Float.isNaN(this.f12928o) == false) goto L11;
        if (Float.isNaN(this.f12929p) == false) goto L11;
    }

    public final void c() {
        if (Float.isNaN(this.f12926m) == true) goto L5;
    L12:
        b();
        return;
    L5:
        if (Float.isNaN(this.f12927n) == false) goto L12;
        if (Float.isNaN(this.f12928o) == false) goto L12;
        if (Float.isNaN(this.f12929p) == false) goto L12;
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public float getContrast() {
        return this.f12918a.f;
    }

    public float getCrossfade() {
        return this.f12919b;
    }

    public float getImagePanX() {
        return this.f12926m;
    }

    public float getImagePanY() {
        return this.f12927n;
    }

    public float getImageRotate() {
        return this.f12929p;
    }

    public float getImageZoom() {
        return this.f12928o;
    }

    public float getRound() {
        return this.d;
    }

    public float getRoundPercent() {
        return this.f12920c;
    }

    public float getSaturation() {
        return this.f12918a.e;
    }

    public float getWarmth() {
        return this.f12918a.g;
    }

    @Override // android.view.View
    public final void layout(int r5, int r10, int r11, int r12) {
        super.layout(r5, r10, r11, r12);
        b();
    }

    public void setAltImageResource(int r5) {
        Drawable r10 = AppCompatResources.getDrawable(getContext(), r5).mutate();
        this.f12924k = r10;
        Drawable r11 = this.f12925l;
        Drawable[] r12 = this.f12921h;
        r12[0] = r11;
        r12[1] = r10;
        LayerDrawable r13 = new LayerDrawable(r12);
        this.f12922i = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.f12919b);
    }

    public void setBrightness(float r5) {
        c r10 = this.f12918a;
        r10.d = r5;
        r10.a(this);
    }

    public void setContrast(float r5) {
        c r10 = this.f12918a;
        r10.f = r5;
        r10.a(this);
    }

    public void setCrossfade(float r5) {
        this.f12919b = r5;
        if (this.f12921h != null) goto L5;
        return;
    L5:
        if (this.f12923j == true) goto L7;
        this.f12922i.getDrawable(0).setAlpha((int) ((1.0f - this.f12919b) * 255.0f));
    L7:
        this.f12922i.getDrawable(1).setAlpha((int) (this.f12919b * 255.0f));
        super.setImageDrawable(this.f12922i);
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable r5) {
        if (this.f12924k == null) goto L6;
        if (r5 == null) goto L6;
        Drawable r10 = r5.mutate();
        this.f12925l = r10;
        Drawable[] r11 = this.f12921h;
        r11[0] = r10;
        r11[1] = this.f12924k;
        LayerDrawable r12 = new LayerDrawable(r11);
        this.f12922i = r12;
        super.setImageDrawable(r12);
        setCrossfade(this.f12919b);
        return;
    L6:
        super.setImageDrawable(r5);
    }

    public void setImagePanX(float r5) {
        this.f12926m = r5;
        c();
    }

    public void setImagePanY(float r5) {
        this.f12927n = r5;
        c();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int r5) {
        if (this.f12924k == null) goto L5;
        Drawable r10 = AppCompatResources.getDrawable(getContext(), r5).mutate();
        this.f12925l = r10;
        Drawable[] r11 = this.f12921h;
        r11[0] = r10;
        r11[1] = this.f12924k;
        LayerDrawable r12 = new LayerDrawable(r11);
        this.f12922i = r12;
        super.setImageDrawable(r12);
        setCrossfade(this.f12919b);
        return;
    L5:
        super.setImageResource(r5);
    }

    public void setImageRotate(float r5) {
        this.f12929p = r5;
        c();
    }

    public void setImageZoom(float r5) {
        this.f12928o = r5;
        c();
    }

    public void setRound(float r5) {
        if (Float.isNaN(r5) == false) goto L7;
        this.d = r5;
        float r10 = this.f12920c;
        this.f12920c = -1.0f;
        setRoundPercent(r10);
        return;
    L7:
        if (this.d == r5) goto L9;
        boolean r11 = true;
    L10:
        this.d = r5;
        if (r5 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r11 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.e != null) goto L16;
        this.e = new Path();
    L16:
        if (this.g != null) goto L19;
        this.g = new RectF();
    L19:
        if (this.f != null) goto L21;
        a r12 = new a(this, 1);
        this.f = r12;
        setOutlineProvider(r12);
    L21:
        setClipToOutline(true);
        this.g.set(0.0f, 0.0f, getWidth(), getHeight());
        this.e.reset();
        Path r13 = this.e;
        RectF r14 = this.g;
        float r15 = this.d;
        r13.addRoundRect(r14, r15, r15, Path.Direction.CW);
        goto L23
    L9:
        r11 = false;
        goto L10
    }

    public void setRoundPercent(float r10) {
        if (this.f12920c == r10) goto L5;
        boolean r5 = true;
    L6:
        this.f12920c = r10;
        if (r10 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r5 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.e != null) goto L12;
        this.e = new Path();
    L12:
        if (this.g != null) goto L15;
        this.g = new RectF();
    L15:
        if (this.f != null) goto L17;
        a r11 = new a(this, 0);
        this.f = r11;
        setOutlineProvider(r11);
    L17:
        setClipToOutline(true);
        int r12 = getWidth();
        int r13 = getHeight();
        float r14 = (Math.min(r12, r13) * this.f12920c) / 2.0f;
        this.g.set(0.0f, 0.0f, r12, r13);
        this.e.reset();
        this.e.addRoundRect(this.g, r14, r14, Path.Direction.CW);
        goto L19
    L5:
        r5 = false;
        goto L6
    }

    public void setSaturation(float r5) {
        c r10 = this.f12918a;
        r10.e = r5;
        r10.a(this);
    }

    public void setWarmth(float r5) {
        c r10 = this.f12918a;
        r10.g = r5;
        r10.a(this);
    }

    public ImageFilterButton(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f12918a = new c();
        this.f12919b = 0.0f;
        this.f12920c = 0.0f;
        this.d = Float.NaN;
        this.f12921h = new Drawable[2];
        this.f12923j = true;
        this.f12924k = null;
        this.f12925l = null;
        this.f12926m = Float.NaN;
        this.f12927n = Float.NaN;
        this.f12928o = Float.NaN;
        this.f12929p = Float.NaN;
        a(r5, r10);
    }

    public ImageFilterButton(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f12918a = new c();
        this.f12919b = 0.0f;
        this.f12920c = 0.0f;
        this.d = Float.NaN;
        this.f12921h = new Drawable[2];
        this.f12923j = true;
        this.f12924k = null;
        this.f12925l = null;
        this.f12926m = Float.NaN;
        this.f12927n = Float.NaN;
        this.f12928o = Float.NaN;
        this.f12929p = Float.NaN;
        a(r5, r10);
    }
}
