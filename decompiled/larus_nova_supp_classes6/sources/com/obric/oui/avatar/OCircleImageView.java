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
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class OCircleImageView extends AppCompatImageView {
    public static final ImageView.ScaleType v = null;
    public static final Bitmap.Config w = null;
    public final RectF a;
    public final RectF b;
    public final Matrix c;
    public final Paint d;
    public final Paint e;
    public final Paint f;
    public int g;
    public int h;
    public int i;
    public int j;
    public Bitmap k;
    public Canvas l;
    public float m;
    public float n;
    public ColorFilter o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;

    /* JADX WARN: Multi-variable type inference failed */
    public final void init() {
        this.p = true;
        super/*android.widget.ImageView*/.setScaleType(v);
        this.d.setAntiAlias(true);
        this.d.setDither(true);
        this.d.setFilterBitmap(true);
        this.d.setAlpha(this.j);
        this.d.setColorFilter(this.o);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setAntiAlias(true);
        this.e.setColor(this.g);
        this.e.setStrokeWidth(this.h);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setAntiAlias(true);
        this.f.setColor(this.i);
        setOutlineProvider(new a(this));
    }

    static {
        v = ImageView.ScaleType.CENTER_CROP;
        w = Bitmap.Config.ARGB_8888;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l() {
        RectF r0 = this.b;
        int r1 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r3 = Math.min(r1, r2);
        float r4 = getPaddingLeft() + ((r1 - r3) / 2.0f);
        float r5 = getPaddingTop() + ((r2 - r3) / 2.0f);
        float r6 = r3;
        r0.set(new RectF(r4, r5, r4 + r6, r6 + r5));
        this.n = Math.min((this.b.height() - this.h) / 2.0f, (this.b.width() - this.h) / 2.0f);
        RectF r7 = this.a;
        int r8 = getWidth() - (this.u * 2);
        int r9 = getHeight() - (this.u * 2);
        int r10 = Math.min(r9, r8);
        float r11 = this.u;
        float r12 = ((r8 - r10) / 2.0f) + r11;
        float r13 = r11 + ((r9 - r10) / 2.0f);
        float r14 = r10;
        r7.set(new RectF(r12, r13, r12 + r14, r14 + r13));
        if (this.s == true) goto L7;
        int r15 = this.h;
        if (r15 <= 0) goto L7;
        this.a.inset(r15 - 1.0f, r15 - 1.0f);
    L7:
        this.m = Math.min(this.a.height() / 2.0f, this.a.width() / 2.0f);
        m();
    }

    public final void m() {
        if (this.k != null) goto L5;
        return;
    L5:
        this.c.set(null);
        int r0 = this.k.getHeight();
        float r1 = this.k.getWidth();
        float r2 = r0;
        float r4 = 0.0f;
        if ((this.a.height() * r1) <= (this.a.width() * r2)) goto L8;
        float r3 = this.a.height() / r2;
        r4 = (this.a.width() - (r1 * r3)) * 0.5f;
        float r5 = 0.0f;
    L9:
        this.c.setScale(r3, r3);
        Matrix r6 = this.c;
        RectF r7 = this.a;
        r6.postTranslate(((int) (r4 + 0.5f)) + r7.left, ((int) (r5 + 0.5f)) + r7.top);
        this.q = true;
        return;
    L8:
        r3 = this.a.width() / r1;
        r5 = (this.a.height() - (r2 * r3)) * 0.5f;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j() {
        Drawable r0 = getDrawable();
        if (r0 != null) goto L6;
    L4:
        Bitmap r1 = null;
    L16:
        this.k = r1;
        if (r1 != null) goto L19;
    L21:
        this.l = null;
    L23:
        if (this.p == true) goto L26;
        return;
    L26:
        if (this.k == null) goto L28;
        m();
        return;
    L28:
        this.d.setShader(null);
        return;
    L19:
        if (r1.isMutable() == false) goto L21;
        this.l = new Canvas(this.k);
        goto L23
    L6:
        if ((r0 instanceof BitmapDrawable) == false) goto L30;
        r1 = ((BitmapDrawable) r0).getBitmap();
        goto L16
    L30:
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L9:
        if ((r0 instanceof ColorDrawable) == false) goto L11;
        Bitmap r2 = Bitmap.createBitmap(2, 2, w);     // Catch: Exception -> L14
    L12:
        Canvas r3 = new Canvas(r2);     // Catch: Exception -> L14
        r0.setBounds(0, 0, r3.getWidth(), r3.getHeight());     // Catch: Exception -> L14
        r0.draw(r3);     // Catch: Exception -> L14
        r1 = r2;
        goto L16
    L11:
        r2 = Bitmap.createBitmap(r0.getIntrinsicWidth(), r0.getIntrinsicHeight(), w);     // Catch: Exception -> L14
        goto L12
    }

    public int getBorderColor() {
        return this.g;
    }

    public int getBorderWidth() {
        return this.h;
    }

    public int getCircleBackgroundColor() {
        return this.i;
    }

    public ColorFilter getColorFilter() {
        return this.o;
    }

    public int getImageAlpha() {
        return this.j;
    }

    public OCircleImageView(Context r1) {
        super(r1);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new Paint();
        this.g = -16777216;
        this.h = 0;
        this.i = 0;
        this.j = 255;
        init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invalidateDrawable(Drawable r1) {
        this.r = true;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r5) {
        if (this.t == false) goto L7;
        super/*android.widget.ImageView*/.onDraw(r5);
        return;
    L7:
        if (this.i == 0) goto L10;
        r5.drawCircle(this.b.centerX(), this.b.centerY(), this.n, this.f);
    L10:
        if (this.k == null) goto L21;
        if (this.r == false) goto L17;
        if (this.l == null) goto L17;
        this.r = false;
        Drawable r0 = getDrawable();
        r0.setBounds(0, 0, this.l.getWidth(), this.l.getHeight());
        r0.draw(this.l);
    L17:
        if (this.q == false) goto L19;
        this.q = false;
        Bitmap r1 = this.k;
        Shader.TileMode r2 = Shader.TileMode.CLAMP;
        BitmapShader r3 = new BitmapShader(r1, r2, r2);
        r3.setLocalMatrix(this.c);
        this.d.setShader(r3);
    L19:
        r5.drawCircle(this.a.centerX(), this.a.centerY(), this.m, this.d);
    L21:
        if (this.h <= 0) goto L24;
        r5.drawCircle(this.b.centerX(), this.b.centerY(), this.n, this.e);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r10) {
        if (this.t == true) goto L5;
        float r0 = r10.getX();
        float r1 = r10.getY();
        if (this.b.isEmpty() == false) goto L10;
    L11:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L15;
        return false;
    L15:
        if (super/*android.widget.ImageView*/.onTouchEvent(r10) == false) goto L19;
        return true;
    L19:
        return false;
    L10:
        if ((Math.pow(r0 - this.b.centerX(), 2.0d) + Math.pow(r1 - this.b.centerY(), 2.0d)) <= Math.pow(this.n, 2.0d)) goto L11;
        r2 = false;
        goto L13
    L5:
        return super/*android.widget.ImageView*/.onTouchEvent(r10);
    }

    public void setAdjustViewBounds(boolean r2) {
        if (r2 == true) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("adjustViewBounds not supported.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBorderColor(int r2) {
        if (r2 != this.g) goto L5;
        return;
    L5:
        this.g = r2;
        this.e.setColor(r2);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBorderOverlay(boolean r2) {
        if (r2 != this.s) goto L5;
        return;
    L5:
        this.s = r2;
        l();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBorderWidth(int r2) {
        if (r2 != this.h) goto L5;
        return;
    L5:
        this.h = r2;
        this.e.setStrokeWidth(r2);
        l();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCircleBackgroundColor(int r2) {
        if (r2 != this.i) goto L5;
        return;
    L5:
        this.i = r2;
        this.f.setColor(r2);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCircleBackgroundColorResource(int r2) {
        setCircleBackgroundColor(getContext().getResources().getColor(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setColorFilter(ColorFilter r2) {
        if (r2 != this.o) goto L5;
        return;
    L5:
        this.o = r2;
        if (this.p == false) goto L9;
        this.d.setColorFilter(r2);
        invalidate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setContentPadding(int r1) {
        this.u = r1;
        l();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setDisableCircularTransformation(boolean r2) {
        if (r2 != this.t) goto L5;
        return;
    L5:
        this.t = r2;
        if (r2 == false) goto L8;
        this.k = null;
        this.l = null;
        this.d.setShader(null);
    L9:
        invalidate();
        return;
    L8:
        j();
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageAlpha(int r2) {
        int r3 = r2 & 255;
        if (r3 != this.j) goto L5;
        return;
    L5:
        this.j = r3;
        if (this.p == false) goto L9;
        this.d.setAlpha(r3);
        invalidate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageBitmap(Bitmap r1) {
        super.setImageBitmap(r1);
        j();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageDrawable(Drawable r1) {
        super.setImageDrawable(r1);
        j();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageResource(int r1) {
        super.setImageResource(r1);
        j();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageURI(Uri r1) {
        super.setImageURI(r1);
        j();
        invalidate();
    }

    public void setScaleType(ImageView.ScaleType r4) {
        if (r4 != v) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{r4}));
    }

    public OCircleImageView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public OCircleImageView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new Paint();
        this.g = -16777216;
        this.h = 0;
        this.i = 0;
        this.j = 255;
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130972869, 2130972870, 2130972871, 2130972872}, r6, 0);
        this.h = r7.getDimensionPixelSize(2, 0);
        this.g = r7.getColor(0, -16777216);
        this.s = r7.getBoolean(1, false);
        this.i = r7.getColor(3, 0);
        r7.recycle();
        init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.ImageView*/.onSizeChanged(r1, r2, r3, r4);
        l();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPadding(int r1, int r2, int r3, int r4) {
        super/*android.widget.ImageView*/.setPadding(r1, r2, r3, r4);
        l();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPaddingRelative(int r1, int r2, int r3, int r4) {
        super/*android.widget.ImageView*/.setPaddingRelative(r1, r2, r3, r4);
        l();
        invalidate();
    }
}
