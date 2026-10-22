package hda;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w1 extends ImageView {
    public final Matrix a;
    public final ScaleGestureDetector b;
    public final x c;
    public float d;
    public float e;
    public boolean f;

    public final class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public final /* synthetic */ w1 a;

        public a(w1 r1) {
            this.a = r1;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r5) {
            Intrinsics.checkNotNullParameter(r5, "detector");
            float r0 = this.a.e * r5.getScaleFactor();
            float r1 = this.a.d;
            float r2 = RangesKt.coerceIn(r0, r1, 4.0f * r1);
            w1 r3 = this.a;
            float r4 = r2 / r3.e;
            r3.a.postScale(r4, r4, r5.getFocusX(), r5.getFocusY());
            w1 r6 = this.a;
            r6.e = r2;
            r6.b();
            w1 r7 = this.a;
            r7.setImageMatrix(r7.a);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector r2) {
            Intrinsics.checkNotNullParameter(r2, "detector");
            this.a.c.a = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector r2) {
            Intrinsics.checkNotNullParameter(r2, "detector");
            this.a.c.a = false;
        }
    }

    public final void a() {
        Drawable r0 = getDrawable();
        if (r0 != null) goto L6;
        return;
    L6:
        if (getWidth() > 0) goto L8;
        return;
    L8:
        if (getHeight() > 0) goto L10;
        return;
    L10:
        if (r0.getIntrinsicWidth() > 0) goto L12;
        return;
    L12:
        if (r0.getIntrinsicHeight() > 0) goto L14;
        return;
    L14:
        if (this.f == true) goto L22;
        float r1 = getWidth() / r0.getIntrinsicWidth();
        float r2 = (getWidth() - (r0.getIntrinsicWidth() * r1)) / 2.0f;
        float r4 = (getHeight() - (r0.getIntrinsicHeight() * r1)) / 2.0f;
        this.a.reset();
        this.a.postScale(r1, r1);
        this.a.postTranslate(r2, r4);
        b();
        setImageMatrix(this.a);
        this.d = r1;
        this.e = r1;
        this.f = true;
        return;
    }

    public final void b() {
        Drawable r0 = getDrawable();
        if (r0 != null) goto L6;
        return;
    L6:
        if (getWidth() > 0) goto L8;
        return;
    L8:
        if (getHeight() > 0) goto L10;
        return;
    L10:
        if (r0.getIntrinsicWidth() > 0) goto L12;
        return;
    L12:
        if (r0.getIntrinsicHeight() <= 0) goto L27;
        float[] r1 = new float[9];
        this.a.getValues(r1);
        float r2 = r1[0];
        float r3 = r1[4];
        float r4 = r0.getIntrinsicWidth() * r2;
        float r5 = r0.getIntrinsicHeight() * r3;
        float r6 = r1[2];
        float r7 = getWidth();
        float r8 = r7 - r4;
        if (r4 > r7) goto L17;
        float r9 = r8 / 2.0f;
    L18:
        float r10 = r1[5];
        float r11 = getHeight();
        float r12 = r11 - r5;
        if (r5 > r11) goto L21;
        float r13 = r12 / 2.0f;
    L22:
        this.a.postTranslate(r9 - r1[2], r13 - r1[5]);
        return;
    L21:
        r13 = RangesKt.coerceIn(r10, r12, 0.0f);
        goto L22
    L17:
        r9 = RangesKt.coerceIn(r6, r8, 0.0f);
        goto L18
    }

    public w1(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = new Matrix();
        this.b = new ScaleGestureDetector(r3, new a(this));
        this.c = new x();
        this.d = 1.0f;
        this.e = 1.0f;
        setScaleType(ImageView.ScaleType.MATRIX);
        setBackgroundColor(-16777216);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        this.b.onTouchEvent(r7);
        int r0 = r7.getActionMasked();
        if (r0 != 0) goto L5;
        x r1 = this.c;
        float r2 = r7.getX();
        float r8 = r7.getY();
        r1.b = r2;
        r1.c = r8;
        r1.a = true;
    L29:
        return true;
    L5:
        if (r0 != 1) goto L7;
    L27:
        this.c.a = false;
        goto L29
    L7:
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L27;
        if (r0 != 5) goto L13;
    L15:
        this.c.a = false;
        goto L29
    L13:
        if (r0 == 6) goto L15;
    L17:
        if (this.b.isInProgress() == false) goto L19;
    L26:
        this.c.a = false;
        goto L29
    L19:
        if (r7.getPointerCount() != 1) goto L26;
        x r3 = this.c;
        float r4 = r7.getX();
        float r9 = r7.getY();
        if (r3.a == true) goto L23;
        r3.b = r4;
        r3.c = r9;
        r3.a = true;
        w r10 = null;
    L24:
        if (r10 == null) goto L29;
        this.a.postTranslate(r10.a, r10.b);
        b();
        setImageMatrix(this.a);
        goto L29
    L23:
        w r5 = new w(r4 - r3.b, r9 - r3.c);
        r3.b = r4;
        r3.c = r9;
        r10 = r5;
        goto L24
    }

    @Override // android.widget.ImageView
    public final void setImageBitmap(Bitmap r1) {
        super.setImageBitmap(r1);
        this.f = false;
        post(new v1(this));
    }

    @Override // android.widget.ImageView
    public final void setImageURI(Uri r1) {
        super.setImageURI(r1);
        this.f = false;
        post(new v1(this));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.f = false;
        a();
    }
}
