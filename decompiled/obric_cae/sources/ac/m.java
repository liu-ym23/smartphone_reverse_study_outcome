package ac;

import android.R;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends DrawableWrapper implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f330b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RectF f331m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f332n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DisplayMetrics f333o;

    public m(Drawable r8, DisplayMetrics r10) {
        he.i.f(r10, "displayMetrics");
        super(r8);
        Paint r11 = new Paint(1);
        this.f329a = r11;
        this.f332n = 16.0f;
        r11.setStyle(Paint.Style.FILL);
        r11.setAntiAlias(true);
        this.f333o = r10;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void draw(Canvas r8) {
        he.i.f(r8, "canvas");
        RectF r10 = this.f331m;
        Paint r11 = this.f329a;
        int r12 = r8.saveLayer(r10, r11);
        super.draw(r8);
        Bitmap r13 = this.f330b;
        if (r13 == null) goto L5;
        r11.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r8.drawBitmap(r13, 0.0f, 0.0f, r11);
        r11.setXfermode(null);
    L5:
        r8.restoreToCount(r12);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void inflate(Resources r8, XmlPullParser r10, AttributeSet r11, Resources.Theme r12) {
        he.i.f(r8, "r");
        he.i.f(r10, "parser");
        he.i.f(r11, "attrs");
        super.inflate(r8, r10, r11, r12);
        int r13 = r10.getDepth();
        this.f333o = r8.getDisplayMetrics();
        Drawable r14 = null;
    L3:
        int r15 = r10.next();
        if (r15 == 1) goto L19;
        if (r15 != 3) goto L10;
        if (r10.getDepth() <= r13) goto L19;
    L10:
        if (r15 != 2) goto L3;
        if (he.i.a(r10.getName(), "corners") == true) goto L13;
        r14 = DrawableWrapper.createFromXmlInner(r8, r10, r11, r12);
        goto L3
    L13:
        int[] r16 = {R.attr.radius};
        if (r12 != null) goto L16;
        TypedArray r17 = r8.obtainAttributes(r11, r16);
    L17:
        this.f332n = r17.getDimensionPixelSize(0, (int) this.f332n);
        goto L3
    L16:
        r17 = r12.obtainStyledAttributes(r11, r16, 0, 0);
    L19:
        if (r14 == null) goto L31;
        setDrawable(r14);
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable r8 = getDrawable();
        if ((r8 instanceof AnimationDrawable) == true) goto L5;
        return false;
    L5:
        return ((AnimationDrawable) r8).isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r8, int r10, int r11, int r12) {
        super.setBounds(r8, r10, r11, r12);
        RectF r13 = new RectF(r8, r10, r11, r12);
        if ((!he.i.a(r13, this.f331m)) == false) goto L9;
        Bitmap r14 = this.f330b;
        if (r14 == null) goto L7;
        r14.recycle();
    L7:
        Bitmap r15 = Bitmap.createBitmap(this.f333o, r11 - r8, r12 - r10, Bitmap.Config.ARGB_8888);
        Canvas r16 = new Canvas(r15);
        float r17 = this.f332n;
        r16.drawRoundRect(r13, r17, r17, this.f329a);
        this.f331m = r13;
        this.f330b = r15;
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable r8 = getDrawable();
        if ((r8 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r8).start();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable r8 = getDrawable();
        if ((r8 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r8).stop();
        return;
    }
}
