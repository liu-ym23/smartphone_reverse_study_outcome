package com.larus.bmhome.view.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z0;
import gt8.d;
import gt8.e;
import gt8.l;
import gt8.o;
import gt8.z;
import ht8.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 E2\u00020\u0001:\u0002EFB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007J\b\u0010%\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\u0014\u0010'\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\tJ\b\u0010)\u001a\u0004\u0018\u00010*J\b\u0010+\u001a\u00020\"H\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\tH\u0016J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u000203H\u0014J\b\u00104\u001a\u00020\rH\u0002J\u0018\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\u0006\u0010:\u001a\u00020\"J\u000e\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u0018J\u000e\u0010=\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020 J(\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u0002092\u0006\u0010B\u001a\u0002092\u0006\u0010C\u001a\u0002092\u0006\u0010D\u001a\u000209H\u0014R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/larus/bmhome/view/crop/ImageCropView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mOriginBmp", "Landroid/graphics/Bitmap;", "mPhotoClipRect", "Lcom/larus/bmhome/view/crop/helper/ImageClipRect;", "clipImitationRect", "Landroid/graphics/RectF;", "mActionHelper", "Lcom/larus/bmhome/view/crop/helper/ActionHelper;", "mDrawHelper", "Lcom/larus/bmhome/view/crop/helper/DrawHelper;", "screenShowRegion", "mStartClipRect", "mImageRect", "mMatrixValues", "", "mIsInited", "", "mImageShowLocationHelper", "Lcom/larus/bmhome/view/crop/helper/ImageShowLocationHelper;", "mIsAnimating", "ifFixClipRatio", "customClipRatio", "", "clipRegionChangedListener", "Lcom/larus/bmhome/view/crop/ImageCropView$ClipRegionChangedListener;", "prepare", "", "runAfterPrepare", "Ljava/lang/Runnable;", "ensureOriginBmpSize", "initScreenShowRect", "getResultBitmapFromEditResult", MusicAppletPage.KEY_SOURCE, "getCropEditOperation", "Lcom/larus/bmhome/view/crop/CropEditOperation;", "restart", "setImageBitmap", "bm", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "initImageRect", "getMatrixValue", "matrix", "Landroid/graphics/Matrix;", "whichValue", "", "rotate", "setIfFixClipRatio", "isFixClipRatio", "setCustomClipRatio", "setClipRegionChangedListener", "listener", "setFrame", "l", "t", "r", "b", "Companion", "ClipRegionChangedListener", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageCropView extends AppCompatImageView {
    public static final float p = 0.0f;
    public static final int q = 0;
    public static final int r = 0;
    public Bitmap a;
    public o b;
    public RectF c;
    public d d;
    public l e;
    public final RectF f;
    public RectF g;
    public RectF h;
    public final float[] i;
    public boolean j;
    public z k;
    public boolean l;
    public boolean m;
    public float n;
    public a o;

    public interface a {
        void a();

        void b();

        void c();
    }

    public static final class b {
    }

    static {
        p = c7.b(90);
        q = c7.b(3);
        r = c7.b(3);
    }

    public final ft8.a getCropEditOperation() {
        Bitmap r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isRecycled() == false) goto L7;
        return null;
    L7:
        RectF r4 = new RectF(this.c);
        z r2 = this.k;
        if (r2 == null) goto L20;
        RectF r5 = new RectF(r2.a());
        z r1 = this.k;
        if (r1 == null) goto L12;
        int r6 = r1.b;
    L14:
        if (((Math.abs(r6) / 90) % 2) != 1) goto L16;
        float r3 = r0.getHeight();
        float r7 = r5.width();
    L17:
        float r8 = r3 / r7;
        ht8.a.d(r4, r8);
        ht8.a.d(r5, r8);
        return new ft8.a(r4, r5, r6, r0.getWidth(), r0.getHeight());
    L16:
        r3 = r0.getWidth();
        r7 = r5.width();
        goto L17
    L12:
        r6 = 0;
        goto L14
    L20:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RectF l() {
        RectF r0 = new RectF();
        float r1 = getDrawable().getIntrinsicWidth();
        float r2 = getDrawable().getIntrinsicHeight();
        float r3 = getWidth();
        float r4 = getHeight();
        FLogger.a.d("PhotoClipView", "imageRect imageWidth:viewWidth " + r1 + ':' + r3);
        Matrix r5 = getImageMatrix();
        Intrinsics.checkNotNull(r5);
        r5.getValues(this.i);
        float[] r6 = this.i;
        float r7 = r6[0];
        r5.getValues(r6);
        int r8 = (int) (r2 * this.i[4]);
        float r9 = (int) (r1 * r7);
        if (Math.abs(r9 - r3) >= 3.0f) goto L5;
        float r10 = r8;
        float r11 = (r4 - r10) / 2;
        r0.set(0.0f, (int) r11, (int) r3, (int) (r11 + r10));
    L6:
        float r12 = r0.centerX();
        float r13 = r0.centerY();
        float r14 = RangesKt.coerceAtMost((r0.height() - (r * 2)) / r0.height(), (r0.width() - (q * 2)) / r0.width());
        r0.left = ((r0.left - r12) * r14) + r12;
        r0.right = ((r0.right - r12) * r14) + r12;
        r0.top = ((r0.top - r13) * r14) + r13;
        r0.bottom = ((r0.bottom - r13) * r14) + r13;
        return r0;
    L5:
        float r15 = (r3 - r9) / 2;
        r0.set((int) r15, 0.0f, (int) (r15 + r9), (int) r4);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m() {
        if (this.e != null) goto L5;
        return;
    L5:
        Bitmap r0 = this.a;
        if (r0 == null) goto L9;
        Bitmap r1 = Bitmap.createBitmap(r0);
        Bitmap r2 = r1.copy(z0.b(r1.getConfig()), true);
        new Canvas(r2).drawBitmap(r0, 0.0f, 0.0f, null);
        Intrinsics.checkNotNull(r2);
        setImageBitmap(r2);
        l r3 = this.e;
        Intrinsics.checkNotNull(r3);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r3.a = r2;
        int r4 = c.a;
        Runnable r5 = new ft8.b(this);
        Intrinsics.checkNotNullParameter(this, "anchor");
        Intrinsics.checkNotNullParameter(r5, "task");
        getViewTreeObserver().addOnPreDrawListener(new ht8.b(this, r5));
        invalidate();
        return;
    }

    public final Bitmap j(Bitmap r20) {
        if (r20 != null) goto L5;
        Bitmap r1 = this.a;
    L7:
        if (r1 != null) goto L9;
    L53:
        return null;
    L9:
        if (r1.isRecycled() == false) goto L11;
        return null;
    L11:
        RectF r3 = new RectF(this.c);
        z r4 = this.k;
        if (r4 == null) goto L53;
        RectF r5 = new RectF(r4.a());
        z r6 = this.k;
        if (r6 == null) goto L16;
        int r7 = r6.b;
    L18:
        if (((Math.abs(r7) / 90) % 2) != 1) goto L20;
        float r8 = r1.getHeight();
        float r10 = r5.width();
    L21:
        float r9 = r8 / r10;
        ht8.a.d(r3, r9);
        ht8.a.d(r5, r9);
        if (((Math.abs(r7) / 90) % 2) != 1) goto L24;
        float r11 = r3.height();
    L25:
        int r12 = (int) r11;
        if (((Math.abs(r7) / 90) % 2) != 1) goto L28;
        float r13 = r3.width();
    L29:
        Bitmap r14 = Bitmap.createBitmap(RangesKt.coerceAtLeast(r12, 1), RangesKt.coerceAtLeast((int) r13, 1), Bitmap.Config.ARGB_8888);
        Canvas r15 = new Canvas(r14);
        Matrix r16 = new Matrix();
        int r17 = (Math.abs(r7) / 90) % 4;
        if (r17 == 0) goto L38;
        if (r17 == 1) goto L37;
        if (r17 == 2) goto L36;
        if (r17 == 3) goto L35;
        Number r18 = 0;
    L39:
        int r19 = (Math.abs(r7) / 90) % 4;
        if (r19 == 0) goto L48;
        if (r19 == 1) goto L47;
        if (r19 == 2) goto L46;
        if (r19 == 3) goto L45;
        Number r21 = 0;
    L49:
        r16.postTranslate(r18.floatValue(), r21.floatValue());
        r15.drawBitmap(r1, r16, null);
        if (r7 == 0) goto L54;
        r16.reset();
        r16.postRotate(r7);
        Bitmap r110 = Bitmap.createBitmap(r14, 0, 0, r14.getWidth(), r14.getHeight(), r16, true);
        r16.reset();
        return r110;
    L54:
        return r14;
    L45:
        r21 = Float.valueOf(r3.right - r5.right);
        goto L49
    L46:
        r21 = Float.valueOf(r3.bottom - r5.bottom);
        goto L49
    L47:
        r21 = Float.valueOf(r5.left - r3.left);
        goto L49
    L48:
        r21 = Float.valueOf(r5.top - r3.top);
        goto L49
    L35:
        r18 = Float.valueOf(r5.top - r3.top);
        goto L39
    L36:
        r18 = Float.valueOf(r3.right - r5.right);
        goto L39
    L37:
        r18 = Float.valueOf(r3.bottom - r5.bottom);
        goto L39
    L38:
        r18 = Float.valueOf(r5.left - r3.left);
        goto L39
    L28:
        r13 = r3.height();
        goto L29
    L24:
        r11 = r3.width();
        goto L25
    L20:
        r8 = r1.getWidth();
        r10 = r5.width();
        goto L21
    L16:
        r7 = 0;
        goto L18
    L5:
        r1 = r20;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super/*android.widget.ImageView*/.onDraw(r4);     // Catch: Exception -> L15
        if (this.j == true) goto L6;
        return;
    L6:
        l r0 = this.e;     // Catch: Exception -> L15
        if (r0 == null) goto L11;
        r4.drawColor(-16777216);     // Catch: Exception -> L15
        if (r0.a.isRecycled() == true) goto L11;
        r4.drawBitmap(r0.a, r0.a(), null);     // Catch: Exception -> L15
    L11:
        o r1 = this.b;     // Catch: Exception -> L15
        if (r1 == null) goto L20;
        r1.c(r4);     // Catch: Exception -> L15
        return;
    L20:
        return;
    L15:
        e = move-exception;
        FLogger.a.e("PhotoClipView", "onDraw error: " + e);
    }

    public final boolean onTouchEvent(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        if (this.j == true) goto L5;
    L58:
        return true;
    L5:
        if (this.l == true) goto L58;
        d r1 = this.d;
        if (r1 == null) goto L58;
        Intrinsics.checkNotNullParameter(r9, "event");
        if (r1.k == false) goto L58;
        d.b r0 = r1.j;
        boolean r3 = false;
        d.b r5 = null;
        if (r0 != null) goto L26;
        if (r9.getPointerCount() != 1) goto L20;
        if (r1.f.a(r9) == false) goto L18;
        r5 = r1.q;
    L22:
        r1.j = r5;
        if (r5 == null) goto L53;
        r5.a(r9);
    L53:
        if (r9.getAction() != 3) goto L55;
    L57:
        r1.n = r3;
        goto L58
    L55:
        if (r9.getAction() == 1) goto L57;
        r3 = true;
        goto L57
    L18:
        r5 = r1.p;
        goto L22
    L20:
        if (r9.getPointerCount() != 2) goto L22;
        r5 = r1.o;
        goto L22
    L26:
        if (r0.getType() != 1) goto L28;
        boolean r2 = true;
    L29:
        if (r2 == true) goto L31;
    L38:
        d.b r4 = r1.j;
        if (r4 == null) goto L42;
        r4.a(r9);
    L42:
        if (r9.getAction() != 1) goto L53;
        d.b r6 = r1.j;
        if (r6 != null) goto L46;
    L48:
        boolean r7 = false;
    L49:
        if (r7 == false) goto L51;
        r1.d.a();
    L51:
        r1.j = null;
        goto L53
    L46:
        if (r6.getType() != 2) goto L48;
        r7 = true;
        goto L49
    L31:
        if (r9.getPointerCount() != 2) goto L38;
        MotionEvent r8 = MotionEvent.obtain(r9);
        r8.setAction(3);
        d.b r10 = r1.j;
        if (r10 == null) goto L35;
        Intrinsics.checkNotNull(r8);
        r10.a(r8);
    L35:
        r8.recycle();
        e r11 = r1.o;
        r1.j = r11;
        if (r11 == null) goto L42;
        r11.a(r9);
        goto L42
    L28:
        r2 = false;
        goto L29
    }

    public final void setClipRegionChangedListener(a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.o = r2;
    }

    public final void setCustomClipRatio(float r1) {
        this.n = r1;
    }

    public final void setIfFixClipRatio(boolean r1) {
        this.m = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageBitmap(Bitmap r3) {
        Intrinsics.checkNotNullParameter(r3, "bm");
        super.setImageBitmap(r3);
        this.a = r3;
        int r4 = c.a;
        com.larus.bmhome.view.crop.a r5 = new com.larus.bmhome.view.crop.a(this, null);
        Intrinsics.checkNotNullParameter(this, "anchor");
        Intrinsics.checkNotNullParameter(r5, "task");
        getViewTreeObserver().addOnPreDrawListener(new ht8.b(this, r5));
        invalidate();
    }

    public ImageCropView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.c = new RectF();
        this.f = new RectF();
        this.g = new RectF();
        this.h = new RectF();
        this.i = new float[9];
        this.n = -1.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean setFrame(int r2, int r3, int r4, int r5) {
        boolean r6 = super/*android.widget.ImageView*/.setFrame(r2, r3, r4, r5);
        if (r6 == true) goto L9;
    L8:
        return r6;
    L9:
        m();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        FLogger.a.e("PhotoClipView", "restart error: " + e);
        goto L8
    }
}
