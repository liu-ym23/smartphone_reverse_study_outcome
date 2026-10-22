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
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.oui.constraintlayout.widget.R$styleable;
import kr.b;
import kr.c;

/* JADX INFO: loaded from: classes3.dex */
public class ImageFilterView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f12930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f12932c;
    public Drawable d;
    public float e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Path f12933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewOutlineProvider f12934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f12935j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Drawable[] f12936k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LayerDrawable f12937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f12938m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f12939n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f12940o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f12941p;

    public ImageFilterView(Context r5) {
        super(r5);
        this.f12930a = new c();
        this.f12931b = true;
        this.f12932c = null;
        this.d = null;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = Float.NaN;
        this.f12936k = new Drawable[2];
        this.f12938m = Float.NaN;
        this.f12939n = Float.NaN;
        this.f12940o = Float.NaN;
        this.f12941p = Float.NaN;
    }

    private void setOverlay(boolean r5) {
        this.f12931b = r5;
    }

    public final void e(Context r10, AttributeSet r11) {
        if (r11 == null) goto L67;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.ImageFilterView);
        int r13 = r12.getIndexCount();
        this.f12932c = r12.getDrawable(R$styleable.ImageFilterView_altSrc);
        int r5 = 0;
    L4:
        if (r5 >= r13) goto L42;
        int r14 = r12.getIndex(r5);
        if (r14 != R$styleable.ImageFilterView_crossfade) goto L9;
        this.e = r12.getFloat(r14, 0.0f);
    L41:
        r5 = r5 + 1;
        goto L4
    L9:
        if (r14 != R$styleable.ImageFilterView_warmth) goto L12;
        setWarmth(r12.getFloat(r14, 0.0f));
        goto L41
    L12:
        if (r14 != R$styleable.ImageFilterView_saturation) goto L15;
        setSaturation(r12.getFloat(r14, 0.0f));
        goto L41
    L15:
        if (r14 != R$styleable.ImageFilterView_contrast) goto L18;
        setContrast(r12.getFloat(r14, 0.0f));
        goto L41
    L18:
        if (r14 != R$styleable.ImageFilterView_brightness) goto L21;
        setBrightness(r12.getFloat(r14, 0.0f));
        goto L41
    L21:
        if (r14 != R$styleable.ImageFilterView_round) goto L24;
        setRound(r12.getDimension(r14, 0.0f));
        goto L41
    L24:
        if (r14 != R$styleable.ImageFilterView_roundPercent) goto L27;
        setRoundPercent(r12.getFloat(r14, 0.0f));
        goto L41
    L27:
        if (r14 != R$styleable.ImageFilterView_overlay) goto L30;
        setOverlay(r12.getBoolean(r14, this.f12931b));
        goto L41
    L30:
        if (r14 != R$styleable.ImageFilterView_imagePanX) goto L33;
        setImagePanX(r12.getFloat(r14, this.f12938m));
        goto L41
    L33:
        if (r14 != R$styleable.ImageFilterView_imagePanY) goto L36;
        setImagePanY(r12.getFloat(r14, this.f12939n));
        goto L41
    L36:
        if (r14 != R$styleable.ImageFilterView_imageRotate) goto L39;
        setImageRotate(r12.getFloat(r14, this.f12941p));
        goto L41
    L39:
        if (r14 != R$styleable.ImageFilterView_imageZoom) goto L41;
        setImageZoom(r12.getFloat(r14, this.f12940o));
        goto L41
    L42:
        r12.recycle();
        Drawable r15 = getDrawable();
        this.d = r15;
        Drawable r16 = this.f12932c;
        Drawable[] r17 = this.f12936k;
        if (r16 == null) goto L49;
        if (r15 == null) goto L49;
        Drawable r18 = getDrawable().mutate();
        this.d = r18;
        r17[0] = r18;
        r17[1] = this.f12932c.mutate();
        LayerDrawable r19 = new LayerDrawable(r17);
        this.f12937l = r19;
        r19.getDrawable(1).setAlpha((int) (this.e * 255.0f));
        if (this.f12931b == true) goto L48;
        this.f12937l.getDrawable(0).setAlpha((int) ((1.0f - this.e) * 255.0f));
    L48:
        super.setImageDrawable(this.f12937l);
        return;
    L49:
        Drawable r20 = getDrawable();
        this.d = r20;
        if (r20 == null) goto L69;
        Drawable r21 = r20.mutate();
        this.d = r21;
        r17[0] = r21;
        return;
    L69:
        return;
    }

    public float getBrightness() {
        return this.f12930a.d;
    }

    public float getContrast() {
        return this.f12930a.f;
    }

    public float getCrossfade() {
        return this.e;
    }

    public float getImagePanX() {
        return this.f12938m;
    }

    public float getImagePanY() {
        return this.f12939n;
    }

    public float getImageRotate() {
        return this.f12941p;
    }

    public float getImageZoom() {
        return this.f12940o;
    }

    public float getRound() {
        return this.g;
    }

    public float getRoundPercent() {
        return this.f;
    }

    public float getSaturation() {
        return this.f12930a.e;
    }

    public float getWarmth() {
        return this.f12930a.g;
    }

    @Override // android.view.View
    public final void layout(int r5, int r10, int r11, int r12) {
        super.layout(r5, r10, r11, r12);
        n();
    }

    public final void n() {
        if (Float.isNaN(this.f12938m) == true) goto L5;
    L11:
        float r5 = 0.0f;
        if (Float.isNaN(this.f12938m) == false) goto L14;
        float r10 = 0.0f;
    L16:
        if (Float.isNaN(this.f12939n) == false) goto L18;
        float r11 = 0.0f;
    L20:
        if (Float.isNaN(this.f12940o) == false) goto L22;
        float r12 = 1.0f;
    L24:
        if (Float.isNaN(this.f12941p) == true) goto L27;
        r5 = this.f12941p;
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
        r12 = this.f12940o;
        goto L24
    L18:
        r11 = this.f12939n;
        goto L20
    L14:
        r10 = this.f12938m;
        goto L16
    L5:
        if (Float.isNaN(this.f12939n) == false) goto L11;
        if (Float.isNaN(this.f12940o) == false) goto L11;
        if (Float.isNaN(this.f12941p) == false) goto L11;
    }

    public final void o() {
        if (Float.isNaN(this.f12938m) == true) goto L5;
    L12:
        n();
        return;
    L5:
        if (Float.isNaN(this.f12939n) == false) goto L12;
        if (Float.isNaN(this.f12940o) == false) goto L12;
        if (Float.isNaN(this.f12941p) == false) goto L12;
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public void setAltImageDrawable(Drawable r5) {
        Drawable r10 = r5.mutate();
        this.f12932c = r10;
        Drawable r11 = this.d;
        Drawable[] r12 = this.f12936k;
        r12[0] = r11;
        r12[1] = r10;
        LayerDrawable r13 = new LayerDrawable(r12);
        this.f12937l = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.e);
    }

    public void setAltImageResource(int r5) {
        Drawable r10 = AppCompatResources.getDrawable(getContext(), r5);
        this.f12932c = r10;
        setAltImageDrawable(r10);
    }

    public void setBrightness(float r5) {
        c r10 = this.f12930a;
        r10.d = r5;
        r10.a(this);
    }

    public void setContrast(float r5) {
        c r10 = this.f12930a;
        r10.f = r5;
        r10.a(this);
    }

    public void setCrossfade(float r5) {
        this.e = r5;
        if (this.f12936k != null) goto L5;
        return;
    L5:
        if (this.f12931b == true) goto L7;
        this.f12937l.getDrawable(0).setAlpha((int) ((1.0f - this.e) * 255.0f));
    L7:
        this.f12937l.getDrawable(1).setAlpha((int) (this.e * 255.0f));
        super.setImageDrawable(this.f12937l);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r5) {
        if (this.f12932c == null) goto L6;
        if (r5 == null) goto L6;
        Drawable r10 = r5.mutate();
        this.d = r10;
        Drawable[] r11 = this.f12936k;
        r11[0] = r10;
        r11[1] = this.f12932c;
        LayerDrawable r12 = new LayerDrawable(r11);
        this.f12937l = r12;
        super.setImageDrawable(r12);
        setCrossfade(this.e);
        return;
    L6:
        super.setImageDrawable(r5);
    }

    public void setImagePanX(float r5) {
        this.f12938m = r5;
        o();
    }

    public void setImagePanY(float r5) {
        this.f12939n = r5;
        o();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r5) {
        if (this.f12932c == null) goto L5;
        Drawable r10 = AppCompatResources.getDrawable(getContext(), r5).mutate();
        this.d = r10;
        Drawable[] r11 = this.f12936k;
        r11[0] = r10;
        r11[1] = this.f12932c;
        LayerDrawable r12 = new LayerDrawable(r11);
        this.f12937l = r12;
        super.setImageDrawable(r12);
        setCrossfade(this.e);
        return;
    L5:
        super.setImageResource(r5);
    }

    public void setImageRotate(float r5) {
        this.f12941p = r5;
        o();
    }

    public void setImageZoom(float r5) {
        this.f12940o = r5;
        o();
    }

    public void setRound(float r5) {
        if (Float.isNaN(r5) == false) goto L7;
        this.g = r5;
        float r10 = this.f;
        this.f = -1.0f;
        setRoundPercent(r10);
        return;
    L7:
        if (this.g == r5) goto L9;
        boolean r11 = true;
    L10:
        this.g = r5;
        if (r5 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r11 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.f12933h != null) goto L16;
        this.f12933h = new Path();
    L16:
        if (this.f12935j != null) goto L19;
        this.f12935j = new RectF();
    L19:
        if (this.f12934i != null) goto L21;
        b r12 = new b(this, 1);
        this.f12934i = r12;
        setOutlineProvider(r12);
    L21:
        setClipToOutline(true);
        this.f12935j.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f12933h.reset();
        Path r13 = this.f12933h;
        RectF r14 = this.f12935j;
        float r15 = this.g;
        r13.addRoundRect(r14, r15, r15, Path.Direction.CW);
        goto L23
    L9:
        r11 = false;
        goto L10
    }

    public void setRoundPercent(float r10) {
        if (this.f == r10) goto L5;
        boolean r5 = true;
    L6:
        this.f = r10;
        if (r10 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r5 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.f12933h != null) goto L12;
        this.f12933h = new Path();
    L12:
        if (this.f12935j != null) goto L15;
        this.f12935j = new RectF();
    L15:
        if (this.f12934i != null) goto L17;
        b r11 = new b(this, 0);
        this.f12934i = r11;
        setOutlineProvider(r11);
    L17:
        setClipToOutline(true);
        int r12 = getWidth();
        int r13 = getHeight();
        float r14 = (Math.min(r12, r13) * this.f) / 2.0f;
        this.f12935j.set(0.0f, 0.0f, r12, r13);
        this.f12933h.reset();
        this.f12933h.addRoundRect(this.f12935j, r14, r14, Path.Direction.CW);
        goto L19
    L5:
        r5 = false;
        goto L6
    }

    public void setSaturation(float r5) {
        c r10 = this.f12930a;
        r10.e = r5;
        r10.a(this);
    }

    public void setWarmth(float r5) {
        c r10 = this.f12930a;
        r10.g = r5;
        r10.a(this);
    }

    public ImageFilterView(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f12930a = new c();
        this.f12931b = true;
        this.f12932c = null;
        this.d = null;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = Float.NaN;
        this.f12936k = new Drawable[2];
        this.f12938m = Float.NaN;
        this.f12939n = Float.NaN;
        this.f12940o = Float.NaN;
        this.f12941p = Float.NaN;
        e(r5, r10);
    }

    public ImageFilterView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f12930a = new c();
        this.f12931b = true;
        this.f12932c = null;
        this.d = null;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = Float.NaN;
        this.f12936k = new Drawable[2];
        this.f12938m = Float.NaN;
        this.f12939n = Float.NaN;
        this.f12940o = Float.NaN;
        this.f12941p = Float.NaN;
        e(r5, r10);
    }
}
