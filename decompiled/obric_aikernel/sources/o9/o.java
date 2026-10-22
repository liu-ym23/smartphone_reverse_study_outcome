package o9;

import android.R;
import android.content.res.Resources;
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
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
public final class o extends DrawableWrapper implements Animatable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f11598c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bitmap f11599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RectF f11600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f11601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private DisplayMetrics f11602j;

    public o(Drawable r10) {
        Intrinsics.checkNotNullParameter(r10, "bg");
        super(r10);
        Paint r11 = new Paint(1);
        this.f11598c = r11;
        this.f11601i = 16.0f;
        r11.setStyle(Paint.Style.FILL);
        r11.setAntiAlias(true);
    }

    public o(Drawable r10, DisplayMetrics r11) {
        Intrinsics.checkNotNullParameter(r10, "bg");
        Intrinsics.checkNotNullParameter(r11, "displayMetrics");
        this(r10);
        this.f11602j = r11;
    }

    public final void a(float r10) {
        this.f11601i = r10;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        int r11 = r10.saveLayer(this.f11600h, this.f11598c);
        super.draw(r10);
        Bitmap r12 = this.f11599g;
        if (r12 == null) goto L5;
        this.f11598c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r10.drawBitmap(r12, 0.0f, 0.0f, this.f11598c);
        this.f11598c.setXfermode(null);
    L5:
        r10.restoreToCount(r11);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void inflate(Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
        Intrinsics.checkNotNullParameter(r10, "r");
        Intrinsics.checkNotNullParameter(r11, "parser");
        Intrinsics.checkNotNullParameter(r12, "attrs");
        super.inflate(r10, r11, r12, r13);
        int r14 = r11.getDepth();
        this.f11602j = r10.getDisplayMetrics();
        Drawable r15 = null;
    L3:
        int r16 = r11.next();
        if (r16 == 1) goto L15;
        if (r16 != 3) goto L10;
        if (r11.getDepth() <= r14) goto L15;
    L10:
        if (r16 != 2) goto L3;
        if (Intrinsics.areEqual(r11.getName(), "corners") == true) goto L13;
        r15 = DrawableWrapper.createFromXmlInner(r10, r11, r12, r13);
        goto L3
    L13:
        this.f11601i = l.d(r10, r13, r12, new int[]{R.attr.radius}).getDimensionPixelSize(0, (int) this.f11601i);
    L15:
        if (r15 == null) goto L27;
        setDrawable(r15);
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable r10 = getDrawable();
        if ((r10 instanceof AnimationDrawable) == true) goto L5;
        return false;
    L5:
        return ((AnimationDrawable) r10).isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int r10, int r11, int r12, int r13) {
        super.setBounds(r10, r11, r12, r13);
        RectF r14 = new RectF(r10, r11, r12, r13);
        if ((!Intrinsics.areEqual(r14, this.f11600h)) == false) goto L9;
        Bitmap r15 = this.f11599g;
        if (r15 == null) goto L7;
        r15.recycle();
    L7:
        Bitmap r16 = Bitmap.createBitmap(this.f11602j, r12 - r10, r13 - r11, Bitmap.Config.ARGB_8888);
        Canvas r17 = new Canvas(r16);
        float r18 = this.f11601i;
        r17.drawRoundRect(r14, r18, r18, this.f11598c);
        this.f11600h = r14;
        this.f11599g = r16;
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable r10 = getDrawable();
        if ((r10 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r10).start();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable r10 = getDrawable();
        if ((r10 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r10).stop();
        return;
    }
}
