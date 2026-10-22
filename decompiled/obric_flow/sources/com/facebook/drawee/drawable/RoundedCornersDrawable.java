package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class RoundedCornersDrawable extends ForwardingDrawable implements Rounded {
    public final Type d;
    public final RectF e;
    public final float[] f;
    public final float[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f7862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f7864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7865k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7866l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f7867m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Path f7868n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Path f7869o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RectF f7870p;

    public static final enum Type extends Enum<Type> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Type f7871a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Type[] f7872b = null;

        static {
            Type r5 = new Type("OVERLAY_COLOR", 0);
            f7871a = r5;
            f7872b = new Type[]{r5, new Type("CLIPPING", 1)};
        }

        public Type(String r5, int r10) {
            super(r5, r10);
        }

        public static Type valueOf(String r5) {
            return (Type) Enum.valueOf(Type.class, r5);
        }

        public static Type[] values() {
            return (Type[]) f7872b.clone();
        }
    }

    public RoundedCornersDrawable(Drawable r5) {
        r5.getClass();
        super(r5);
        this.d = Type.f7871a;
        this.e = new RectF();
        this.f = new float[8];
        this.g = new float[8];
        this.f7862h = new Paint(1);
        this.f7863i = false;
        this.f7864j = 0.0f;
        this.f7865k = 0;
        this.f7866l = 0;
        this.f7867m = 0.0f;
        this.f7868n = new Path();
        this.f7869o = new Path();
        this.f7870p = new RectF();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void a(boolean r5) {
        this.f7863i = r5;
        e();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void b() {
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void d() {
        e();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r11) {
        this.e.set(getBounds());
        int r5 = this.d.ordinal();
        if (r5 != 0) goto L5;
        Drawable r10 = this.f7847a;
        if (r10 == null) goto L14;
        r10.draw(r11);
    L14:
        this.f7862h.setStyle(Paint.Style.FILL);
        this.f7862h.setColor(this.f7866l);
        this.f7862h.setStrokeWidth(0.0f);
        this.f7862h.setFilterBitmap(false);
        this.f7868n.setFillType(Path.FillType.EVEN_ODD);
        r11.drawPath(this.f7868n, this.f7862h);
        if (this.f7863i == false) goto L23;
        float r12 = ((this.e.width() - this.e.height()) + this.f7864j) / 2.0f;
        float r13 = ((this.e.height() - this.e.width()) + this.f7864j) / 2.0f;
        if (r12 <= 0.0f) goto L20;
        RectF r14 = this.e;
        float r15 = r14.left;
        r11.drawRect(r15, r14.top, r15 + r12, r14.bottom, this.f7862h);
        RectF r16 = this.e;
        float r17 = r16.right;
        r11.drawRect(r17 - r12, r16.top, r17, r16.bottom, this.f7862h);
    L20:
        if (r13 <= 0.0f) goto L23;
        RectF r18 = this.e;
        float r19 = r18.left;
        float r20 = r18.top;
        r11.drawRect(r19, r20, r18.right, r20 + r13, this.f7862h);
        RectF r21 = this.e;
        float r22 = r21.left;
        float r23 = r21.bottom;
        r11.drawRect(r22, r23 - r13, r21.right, r23, this.f7862h);
    L23:
        if (this.f7865k == 0) goto L26;
        this.f7862h.setStyle(Paint.Style.STROKE);
        this.f7862h.setColor(this.f7865k);
        this.f7862h.setStrokeWidth(this.f7864j);
        this.f7868n.setFillType(Path.FillType.EVEN_ODD);
        r11.drawPath(this.f7869o, this.f7862h);
        return;
    L26:
        return;
    L5:
        if (r5 != 1) goto L23;
        int r24 = r11.save();
        r11.clipPath(this.f7868n);
        Drawable r25 = this.f7847a;
        if (r25 == null) goto L10;
        r25.draw(r11);
    L10:
        r11.restoreToCount(r24);
        goto L23
    }

    public final void e() {
        this.f7868n.reset();
        this.f7869o.reset();
        this.f7870p.set(getBounds());
        RectF r5 = this.f7870p;
        float r10 = this.f7867m;
        r5.inset(r10, r10);
        if (this.d != Type.f7871a) goto L6;
        this.f7868n.addRect(this.f7870p, Path.Direction.CW);
    L6:
        if (this.f7863i == false) goto L8;
        this.f7868n.addCircle(this.f7870p.centerX(), this.f7870p.centerY(), Math.min(this.f7870p.width(), this.f7870p.height()) / 2.0f, Path.Direction.CW);
    L9:
        RectF r11 = this.f7870p;
        float r12 = -this.f7867m;
        r11.inset(r12, r12);
        RectF r13 = this.f7870p;
        float r14 = this.f7864j / 2.0f;
        r13.inset(r14, r14);
        if (this.f7863i == false) goto L12;
        float r15 = Math.min(this.f7870p.width(), this.f7870p.height()) / 2.0f;
        this.f7869o.addCircle(this.f7870p.centerX(), this.f7870p.centerY(), r15, Path.Direction.CW);
    L17:
        RectF r16 = this.f7870p;
        float r17 = (-this.f7864j) / 2.0f;
        r16.inset(r17, r17);
        return;
    L12:
        int r18 = 0;
    L13:
        float[] r19 = this.g;
        if (r18 >= r19.length) goto L16;
        r19[r18] = (this.f[r18] + this.f7867m) - (this.f7864j / 2.0f);
        r18 = r18 + 1;
        goto L13
    L16:
        this.f7869o.addRoundRect(this.f7870p, r19, Path.Direction.CW);
        goto L17
    L8:
        this.f7868n.addRoundRect(this.f7870p, this.f, Path.Direction.CW);
        goto L9
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r5) {
        Drawable r10 = this.f7847a;
        if (r10 == null) goto L5;
        r10.setBounds(r5);
    L5:
        e();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void a() {
        Arrays.fill(this.f, 0.0f);
        e();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void a(float[] r5) {
        if (r5 != null) goto L5;
        Arrays.fill(this.f, 0.0f);
    L10:
        e();
        invalidateSelf();
        return;
    L5:
        if (r5.length != 8) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == false) goto L13;
        System.arraycopy(r5, 0, this.f, 0, 8);
        goto L10
    L13:
        throw new IllegalArgumentException("radii should have exactly 8 values");
    L7:
        r10 = false;
        goto L8
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void a(int r5, float r10) {
        this.f7865k = r5;
        this.f7864j = r10;
        e();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void a(float r5) {
        this.f7867m = r5;
        e();
        invalidateSelf();
    }
}
