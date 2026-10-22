package com.obric.oui.avatar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes2.dex */
public class OCircleImageView extends AppCompatImageView {
    public static final ImageView.ScaleType I = null;
    public static final Bitmap.Config J = null;
    public float A;
    public ColorFilter B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public int H;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f6168n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RectF f6169o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Matrix f6170p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Paint f6171q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Paint f6172r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f6173s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6174t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6175u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6176v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6177w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Bitmap f6178x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Canvas f6179y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f6180z;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OCircleImageView f6181a;

        public a(OCircleImageView r8) {
            this.f6181a = r8;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r8, Outline r10) {
            OCircleImageView r11 = this.f6181a;
            if (r11.G == false) goto L5;
            ViewOutlineProvider.BACKGROUND.getOutline(r8, r10);
            return;
        L5:
            Rect r12 = new Rect();
            r11.f6169o.roundOut(r12);
            r10.setRoundRect(r12, r12.width() / 2.0f);
        }
    }

    static {
        I = ImageView.ScaleType.CENTER_CROP;
        J = Bitmap.Config.ARGB_8888;
    }

    public OCircleImageView(Context r8, AttributeSet r10) {
        super(r8, r10, 0);
        this.f6168n = new RectF();
        this.f6169o = new RectF();
        this.f6170p = new Matrix();
        Paint r11 = new Paint();
        this.f6171q = r11;
        Paint r12 = new Paint();
        this.f6172r = r12;
        Paint r13 = new Paint();
        this.f6173s = r13;
        this.f6174t = -16777216;
        this.f6175u = 0;
        this.f6176v = 0;
        this.f6177w = 255;
        TypedArray r14 = r8.obtainStyledAttributes(r10, nb.a.f9494h, 0, 0);
        this.f6175u = r14.getDimensionPixelSize(2, 0);
        this.f6174t = r14.getColor(0, -16777216);
        this.F = r14.getBoolean(1, false);
        this.f6176v = r14.getColor(3, 0);
        r14.recycle();
        this.C = true;
        super.setScaleType(I);
        r11.setAntiAlias(true);
        r11.setDither(true);
        r11.setFilterBitmap(true);
        r11.setAlpha(this.f6177w);
        r11.setColorFilter(this.B);
        r12.setStyle(Paint.Style.STROKE);
        r12.setAntiAlias(true);
        r12.setColor(this.f6174t);
        r12.setStrokeWidth(this.f6175u);
        r13.setStyle(Paint.Style.FILL);
        r13.setAntiAlias(true);
        r13.setColor(this.f6176v);
        setOutlineProvider(new a(this));
    }

    public int getBorderColor() {
        return this.f6174t;
    }

    public int getBorderWidth() {
        return this.f6175u;
    }

    public int getCircleBackgroundColor() {
        return this.f6176v;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.B;
    }

    @Override // android.widget.ImageView
    public int getImageAlpha() {
        return this.f6177w;
    }

    public final void h() {
        Drawable r8 = getDrawable();
        if (r8 != null) goto L6;
    L4:
        Bitmap r10 = null;
    L18:
        this.f6178x = r10;
        if (r10 != null) goto L21;
    L23:
        this.f6179y = null;
    L25:
        if (this.C == true) goto L28;
        return;
    L28:
        if (this.f6178x == null) goto L30;
        j();
        return;
    L30:
        this.f6171q.setShader(null);
        return;
    L21:
        if (r10.isMutable() == false) goto L23;
        this.f6179y = new Canvas(this.f6178x);
        goto L25
    L6:
        if ((r8 instanceof BitmapDrawable) == false) goto L32;
        r10 = ((BitmapDrawable) r8).getBitmap();
        goto L18
    L32:
        boolean r11 = r8 instanceof ColorDrawable;     // Catch: Exception -> L16
        Bitmap.Config r12 = J;
        if (r11 == true) goto L12;
        Bitmap r13 = Bitmap.createBitmap(r8.getIntrinsicWidth(), r8.getIntrinsicHeight(), r12);     // Catch: Exception -> L16
    L14:
        Canvas r14 = new Canvas(r13);     // Catch: Exception -> L16
        r8.setBounds(0, 0, r14.getWidth(), r14.getHeight());     // Catch: Exception -> L16
        r8.draw(r14);     // Catch: Exception -> L16
        r10 = r13;
        goto L18
    L12:
        r13 = Bitmap.createBitmap(2, 2, r12);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }

    public final void i() {
        int r8 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r10 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r11 = Math.min(r8, r10);
        float r12 = ((r8 - r11) / 2.0f) + getPaddingLeft();
        float r13 = ((r10 - r11) / 2.0f) + getPaddingTop();
        float r14 = r11;
        RectF r15 = new RectF(r12, r13, r12 + r14, r14 + r13);
        RectF r16 = this.f6169o;
        r16.set(r15);
        this.A = Math.min((r16.height() - this.f6175u) / 2.0f, (r16.width() - this.f6175u) / 2.0f);
        int r17 = getWidth() - (this.H * 2);
        int r18 = getHeight() - (this.H * 2);
        int r19 = Math.min(r18, r17);
        float r20 = this.H;
        float r21 = ((r17 - r19) / 2.0f) + r20;
        float r22 = ((r18 - r19) / 2.0f) + r20;
        float r23 = r19;
        RectF r24 = new RectF(r21, r22, r21 + r23, r23 + r22);
        RectF r25 = this.f6168n;
        r25.set(r24);
        if (this.F == true) goto L7;
        int r26 = this.f6175u;
        if (r26 <= 0) goto L7;
        r25.inset(r26 - 1.0f, r26 - 1.0f);
    L7:
        this.f6180z = Math.min(r25.height() / 2.0f, r25.width() / 2.0f);
        j();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r8) {
        this.E = true;
        invalidate();
    }

    public final void j() {
        if (this.f6178x != null) goto L5;
        return;
    L5:
        Matrix r8 = this.f6170p;
        r8.set(null);
        int r10 = this.f6178x.getHeight();
        float r11 = this.f6178x.getWidth();
        RectF r12 = this.f6168n;
        float r13 = r10;
        float r14 = 0.0f;
        if ((r12.height() * r11) <= (r12.width() * r13)) goto L8;
        float r15 = r12.height() / r13;
        float r16 = (r12.width() - (r11 * r15)) * 0.5f;
        float r17 = 0.0f;
        r14 = r16;
    L9:
        r8.setScale(r15, r15);
        r8.postTranslate(((int) (r14 + 0.5f)) + r12.left, ((int) (r17 + 0.5f)) + r12.top);
        this.D = true;
        return;
    L8:
        r15 = r12.width() / r11;
        r17 = (r12.height() - (r13 * r15)) * 0.5f;
        goto L9
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"CanvasSize"})
    public final void onDraw(Canvas r8) {
        if (this.G == false) goto L6;
        super.onDraw(r8);
        return;
    L6:
        int r10 = this.f6176v;
        RectF r11 = this.f6169o;
        if (r10 == 0) goto L10;
        r8.drawCircle(r11.centerX(), r11.centerY(), this.A, this.f6173s);
    L10:
        if (this.f6178x == null) goto L21;
        if (this.E == true) goto L14;
    L16:
        boolean r12 = this.D;
        Paint r13 = this.f6171q;
        if (r12 == false) goto L19;
        this.D = false;
        Bitmap r14 = this.f6178x;
        Shader.TileMode r15 = Shader.TileMode.CLAMP;
        BitmapShader r16 = new BitmapShader(r14, r15, r15);
        r16.setLocalMatrix(this.f6170p);
        r13.setShader(r16);
    L19:
        RectF r17 = this.f6168n;
        r8.drawCircle(r17.centerX(), r17.centerY(), this.f6180z, r13);
        goto L21
    L14:
        if (this.f6179y == null) goto L16;
        this.E = false;
        Drawable r18 = getDrawable();
        r18.setBounds(0, 0, this.f6179y.getWidth(), this.f6179y.getHeight());
        r18.draw(this.f6179y);
    L21:
        if (this.f6175u <= 0) goto L24;
        r8.drawCircle(r11.centerX(), r11.centerY(), this.A, this.f6172r);
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r8, int r10, int r11, int r12) {
        super.onSizeChanged(r8, r10, r11, r12);
        i();
        invalidate();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent r11) {
        if (this.G == true) goto L5;
        float r8 = r11.getX();
        float r10 = r11.getY();
        RectF r12 = this.f6169o;
        if (r12.isEmpty() == false) goto L10;
    L11:
        boolean r13 = true;
    L13:
        if (r13 == true) goto L15;
        return false;
    L15:
        if (super.onTouchEvent(r11) == true) goto L17;
        return false;
    L17:
        return true;
    L10:
        if ((Math.pow(r10 - r12.centerY(), 2.0d) + Math.pow(r8 - r12.centerX(), 2.0d)) <= Math.pow(this.A, 2.0d)) goto L11;
        r13 = false;
        goto L13
    L5:
        return super.onTouchEvent(r11);
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean r8) {
        if (r8 == true) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("adjustViewBounds not supported.");
    }

    public void setBorderColor(int r8) {
        if (r8 != this.f6174t) goto L5;
        return;
    L5:
        this.f6174t = r8;
        this.f6172r.setColor(r8);
        invalidate();
    }

    public void setBorderOverlay(boolean r8) {
        if (r8 != this.F) goto L5;
        return;
    L5:
        this.F = r8;
        i();
        invalidate();
    }

    public void setBorderWidth(int r8) {
        if (r8 != this.f6175u) goto L5;
        return;
    L5:
        this.f6175u = r8;
        this.f6172r.setStrokeWidth(r8);
        i();
        invalidate();
    }

    public void setCircleBackgroundColor(int r8) {
        if (r8 != this.f6176v) goto L5;
        return;
    L5:
        this.f6176v = r8;
        this.f6173s.setColor(r8);
        invalidate();
    }

    @Deprecated
    public void setCircleBackgroundColorResource(int r8) {
        setCircleBackgroundColor(getContext().getResources().getColor(r8));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter r8) {
        if (r8 != this.B) goto L5;
        return;
    L5:
        this.B = r8;
        if (this.C == false) goto L9;
        this.f6171q.setColorFilter(r8);
        invalidate();
        return;
    }

    public void setContentPadding(int r8) {
        this.H = r8;
        i();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean r8) {
        if (r8 != this.G) goto L5;
        return;
    L5:
        this.G = r8;
        if (r8 == false) goto L8;
        this.f6178x = null;
        this.f6179y = null;
        this.f6171q.setShader(null);
    L9:
        invalidate();
        return;
    L8:
        h();
        goto L9
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int r8) {
        int r10 = r8 & 255;
        if (r10 != this.f6177w) goto L5;
        return;
    L5:
        this.f6177w = r10;
        if (this.C == false) goto L9;
        this.f6171q.setAlpha(r10);
        invalidate();
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r8) {
        super.setImageBitmap(r8);
        h();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r8) {
        super.setImageDrawable(r8);
        h();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r8) {
        super.setImageResource(r8);
        h();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri r8) {
        super.setImageURI(r8);
        h();
        invalidate();
    }

    @Override // android.view.View
    public final void setPadding(int r8, int r10, int r11, int r12) {
        super.setPadding(r8, r10, r11, r12);
        i();
        invalidate();
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r8, int r10, int r11, int r12) {
        super.setPaddingRelative(r8, r10, r11, r12);
        i();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r8) {
        if (r8 != I) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{r8}));
    }
}
