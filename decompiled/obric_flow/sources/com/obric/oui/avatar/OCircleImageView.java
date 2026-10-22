package com.obric.oui.avatar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import br.c;
import com.obric.common.oui.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public class OCircleImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ImageView.ScaleType f11956v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Bitmap.Config f11957w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f11958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f11959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f11960c;
    public final Paint d;
    public final Paint e;
    public final Paint f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11961h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11962i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f11963j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Bitmap f11964k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Canvas f11965l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f11966m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f11967n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ColorFilter f11968o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f11969p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f11970q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f11971r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f11972t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f11973u;

    static {
        f11956v = ImageView.ScaleType.CENTER_CROP;
        f11957w = Bitmap.Config.ARGB_8888;
    }

    public OCircleImageView(Context r5) {
        super(r5);
        this.f11958a = new RectF();
        this.f11959b = new RectF();
        this.f11960c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new Paint();
        this.g = ViewCompat.MEASURED_STATE_MASK;
        this.f11961h = 0;
        this.f11962i = 0;
        this.f11963j = 255;
        e();
    }

    public final void e() {
        this.f11969p = true;
        super.setScaleType(f11956v);
        Paint r5 = this.d;
        r5.setAntiAlias(true);
        r5.setDither(true);
        r5.setFilterBitmap(true);
        r5.setAlpha(this.f11963j);
        r5.setColorFilter(this.f11968o);
        Paint.Style r10 = Paint.Style.STROKE;
        Paint r11 = this.e;
        r11.setStyle(r10);
        r11.setAntiAlias(true);
        r11.setColor(this.g);
        r11.setStrokeWidth(this.f11961h);
        Paint.Style r12 = Paint.Style.FILL;
        Paint r13 = this.f;
        r13.setStyle(r12);
        r13.setAntiAlias(true);
        r13.setColor(this.f11962i);
        setOutlineProvider(new c(this, 9));
    }

    public int getBorderColor() {
        return this.g;
    }

    public int getBorderWidth() {
        return this.f11961h;
    }

    public int getCircleBackgroundColor() {
        return this.f11962i;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.f11968o;
    }

    @Override // android.widget.ImageView
    public int getImageAlpha() {
        return this.f11963j;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r5) {
        this.f11971r = true;
        invalidate();
    }

    public final void n() {
        Drawable r5 = getDrawable();
        if (r5 != null) goto L6;
    L4:
        Bitmap r10 = null;
    L19:
        this.f11964k = r10;
        if (r10 != null) goto L22;
    L24:
        this.f11965l = null;
    L26:
        if (this.f11969p == true) goto L29;
        return;
    L29:
        if (this.f11964k == null) goto L31;
        p();
        return;
    L31:
        this.d.setShader(null);
        return;
    L22:
        if (r10.isMutable() == false) goto L24;
        this.f11965l = new Canvas(this.f11964k);
        goto L26
    L6:
        if ((r5 instanceof BitmapDrawable) == false) goto L33;
        r10 = ((BitmapDrawable) r5).getBitmap();
        goto L19
    L33:
        boolean r11 = r5 instanceof ColorDrawable;     // Catch: Exception -> L13
        Bitmap.Config r12 = f11957w;
        if (r11 == true) goto L12;
        Bitmap r13 = Bitmap.createBitmap(r5.getIntrinsicWidth(), r5.getIntrinsicHeight(), r12);     // Catch: Exception -> L13
    L16:
        Canvas r14 = new Canvas(r13);     // Catch: Exception -> L13
        r5.setBounds(0, 0, r14.getWidth(), r14.getHeight());     // Catch: Exception -> L13
        r5.draw(r14);     // Catch: Exception -> L13
        r10 = r13;
        goto L19
    L12:
        r13 = Bitmap.createBitmap(2, 2, r12);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }

    public final void o() {
        int r5 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r10 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r11 = Math.min(r5, r10);
        float r12 = ((r5 - r11) / 2.0f) + getPaddingLeft();
        float r13 = ((r10 - r11) / 2.0f) + getPaddingTop();
        float r14 = r11;
        RectF r15 = new RectF(r12, r13, r12 + r14, r14 + r13);
        RectF r16 = this.f11959b;
        r16.set(r15);
        this.f11967n = Math.min((r16.height() - this.f11961h) / 2.0f, (r16.width() - this.f11961h) / 2.0f);
        int r17 = getWidth() - (this.f11973u * 2);
        int r18 = getHeight() - (this.f11973u * 2);
        int r19 = Math.min(r18, r17);
        float r20 = this.f11973u;
        float r21 = ((r17 - r19) / 2.0f) + r20;
        float r22 = ((r18 - r19) / 2.0f) + r20;
        float r23 = r19;
        RectF r24 = new RectF(r21, r22, r21 + r23, r23 + r22);
        RectF r25 = this.f11958a;
        r25.set(r24);
        if (this.s == true) goto L7;
        int r26 = this.f11961h;
        if (r26 <= 0) goto L7;
        r25.inset(r26 - 1.0f, r26 - 1.0f);
    L7:
        this.f11966m = Math.min(r25.height() / 2.0f, r25.width() / 2.0f);
        p();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r10) {
        if (this.f11972t == false) goto L6;
        super.onDraw(r10);
        return;
    L6:
        int r5 = this.f11962i;
        RectF r11 = this.f11959b;
        if (r5 == 0) goto L10;
        r10.drawCircle(r11.centerX(), r11.centerY(), this.f11967n, this.f);
    L10:
        if (this.f11964k == null) goto L21;
        if (this.f11971r == true) goto L14;
    L16:
        boolean r12 = this.f11970q;
        Paint r13 = this.d;
        if (r12 == false) goto L19;
        this.f11970q = false;
        Bitmap r14 = this.f11964k;
        Shader.TileMode r15 = Shader.TileMode.CLAMP;
        BitmapShader r16 = new BitmapShader(r14, r15, r15);
        r16.setLocalMatrix(this.f11960c);
        r13.setShader(r16);
    L19:
        RectF r17 = this.f11958a;
        r10.drawCircle(r17.centerX(), r17.centerY(), this.f11966m, r13);
        goto L21
    L14:
        if (this.f11965l == null) goto L16;
        this.f11971r = false;
        Drawable r18 = getDrawable();
        r18.setBounds(0, 0, this.f11965l.getWidth(), this.f11965l.getHeight());
        r18.draw(this.f11965l);
    L21:
        if (this.f11961h <= 0) goto L24;
        r10.drawCircle(r11.centerX(), r11.centerY(), this.f11967n, this.e);
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        o();
        invalidate();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        if (this.f11972t == true) goto L5;
        float r5 = r10.getX();
        float r11 = r10.getY();
        RectF r12 = this.f11959b;
        if (r12.isEmpty() == true) goto L12;
        if ((Math.pow(r11 - r12.centerY(), 2.0d) + Math.pow(r5 - r12.centerX(), 2.0d)) <= Math.pow(this.f11967n, 2.0d)) goto L12;
    L14:
        return false;
    L12:
        if (super.onTouchEvent(r10) == false) goto L14;
        return true;
    L5:
        return super.onTouchEvent(r10);
    }

    public final void p() {
        if (this.f11964k != null) goto L5;
        return;
    L5:
        Matrix r5 = this.f11960c;
        r5.set(null);
        int r10 = this.f11964k.getHeight();
        float r11 = this.f11964k.getWidth();
        RectF r12 = this.f11958a;
        float r13 = r10;
        float r14 = 0.0f;
        if ((r12.height() * r11) <= (r12.width() * r13)) goto L8;
        float r15 = r12.height() / r13;
        float r16 = (r12.width() - (r11 * r15)) * 0.5f;
        float r17 = 0.0f;
        r14 = r16;
    L9:
        r5.setScale(r15, r15);
        r5.postTranslate(((int) (r14 + 0.5f)) + r12.left, ((int) (r17 + 0.5f)) + r12.top);
        this.f11970q = true;
        return;
    L8:
        r15 = r12.width() / r11;
        r17 = (r12.height() - (r13 * r15)) * 0.5f;
        goto L9
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean r5) {
        if (r5 == true) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("adjustViewBounds not supported.");
    }

    public void setBorderColor(@ColorInt int r5) {
        if (r5 != this.g) goto L5;
        return;
    L5:
        this.g = r5;
        this.e.setColor(r5);
        invalidate();
    }

    public void setBorderOverlay(boolean r5) {
        if (r5 != this.s) goto L5;
        return;
    L5:
        this.s = r5;
        o();
        invalidate();
    }

    public void setBorderWidth(int r5) {
        if (r5 != this.f11961h) goto L5;
        return;
    L5:
        this.f11961h = r5;
        this.e.setStrokeWidth(r5);
        o();
        invalidate();
    }

    public void setCircleBackgroundColor(@ColorInt int r5) {
        if (r5 != this.f11962i) goto L5;
        return;
    L5:
        this.f11962i = r5;
        this.f.setColor(r5);
        invalidate();
    }

    @Deprecated
    public void setCircleBackgroundColorResource(@ColorRes int r5) {
        setCircleBackgroundColor(getContext().getResources().getColor(r5));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter r5) {
        if (r5 != this.f11968o) goto L5;
        return;
    L5:
        this.f11968o = r5;
        if (this.f11969p == false) goto L9;
        this.d.setColorFilter(r5);
        invalidate();
        return;
    }

    public void setContentPadding(int r5) {
        this.f11973u = r5;
        o();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean r5) {
        if (r5 != this.f11972t) goto L5;
        return;
    L5:
        this.f11972t = r5;
        if (r5 == false) goto L8;
        this.f11964k = null;
        this.f11965l = null;
        this.d.setShader(null);
    L9:
        invalidate();
        return;
    L8:
        n();
        goto L9
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int r5) {
        int r10 = r5 & 255;
        if (r10 != this.f11963j) goto L5;
        return;
    L5:
        this.f11963j = r10;
        if (this.f11969p == false) goto L9;
        this.d.setAlpha(r10);
        invalidate();
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r5) {
        super.setImageBitmap(r5);
        n();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r5) {
        super.setImageDrawable(r5);
        n();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int r5) {
        super.setImageResource(r5);
        n();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri r5) {
        super.setImageURI(r5);
        n();
        invalidate();
    }

    @Override // android.view.View
    public final void setPadding(int r5, int r10, int r11, int r12) {
        super.setPadding(r5, r10, r11, r12);
        o();
        invalidate();
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r5, int r10, int r11, int r12) {
        super.setPaddingRelative(r5, r10, r11, r12);
        o();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r5) {
        if (r5 != f11956v) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ScaleType " + r5 + " not supported.");
    }

    public OCircleImageView(Context r5, AttributeSet r10) {
        this(r5, r10, 0);
    }

    public OCircleImageView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f11958a = new RectF();
        this.f11959b = new RectF();
        this.f11960c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new Paint();
        this.g = ViewCompat.MEASURED_STATE_MASK;
        this.f11961h = 0;
        this.f11962i = 0;
        this.f11963j = 255;
        TypedArray r12 = r5.obtainStyledAttributes(r10, R$styleable.OCircleImageView, r11, 0);
        this.f11961h = r12.getDimensionPixelSize(R$styleable.OCircleImageView_o_civ_border_width, 0);
        this.g = r12.getColor(R$styleable.OCircleImageView_o_civ_border_color, ViewCompat.MEASURED_STATE_MASK);
        this.s = r12.getBoolean(R$styleable.OCircleImageView_o_civ_border_overlay, false);
        this.f11962i = r12.getColor(R$styleable.OCircleImageView_o_civ_circle_background_color, 0);
        r12.recycle();
        e();
    }
}
