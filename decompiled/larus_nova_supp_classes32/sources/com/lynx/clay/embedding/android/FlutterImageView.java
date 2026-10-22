package com.lynx.clay.embedding.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlutterImageView extends View implements s5a.c {
    public ImageReader a;
    public Image b;
    public Bitmap c;
    public FlutterRenderer d;
    public final SurfaceKind e;
    public boolean f;

    public static final enum SurfaceKind extends Enum<SurfaceKind> {
        public static final /* synthetic */ SurfaceKind[] a = null;
        public static final SurfaceKind background = null;
        public static final SurfaceKind overlay = null;

        static {
            SurfaceKind r0 = new SurfaceKind("background", 0);
            background = r0;
            SurfaceKind r1 = new SurfaceKind("overlay", 1);
            overlay = r1;
            a = new SurfaceKind[]{r0, r1};
        }

        public static SurfaceKind[] values() {
            return (SurfaceKind[]) a.clone();
        }

        public static SurfaceKind valueOf(String r1) {
            return (SurfaceKind) r27.a.a(SurfaceKind.class, r1);
        }

        public SurfaceKind(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SurfaceKind.values().length];
            a = r0;
            r0[SurfaceKind.background.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[SurfaceKind.overlay.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    @Override // s5a.c
    public final void pause() {
    }

    @Override // s5a.c
    public final void b() {
        if (this.f == true) goto L5;
        return;
    L5:
        setAlpha(0.0f);
        c(true);
        this.c = null;
        Image r1 = this.b;
        if (r1 == null) goto L8;
        r1.close();
        this.b = null;
    L8:
        invalidate();
        this.f = false;
    }

    public Surface getSurface() {
        return this.a.getSurface();
    }

    @Override // s5a.c
    public FlutterRenderer getAttachedRenderer() {
        return this.d;
    }

    public ImageReader getImageReader() {
        return this.a;
    }

    public FlutterImageView(Context r3) {
        this(r3, 1, 1, SurfaceKind.background);
    }

    @Override // s5a.c
    public final void a(FlutterRenderer r4) {
        if (a.a[this.e.ordinal()] != 1) goto L6;
        Surface r0 = this.a.getSurface();
        r4.b = r0;
        r4.a.onSurfaceWindowChanged(r0);
    L6:
        setAlpha(1.0f);
        this.d = r4;
        this.f = true;
    }

    public final boolean c(boolean r3) {
        if (this.f == true) goto L5;
        return false;
    L5:
        if (r3 == false) goto L7;
        Image r4 = this.a.acquireLatestImage();
    L8:
        if (r4 == null) goto L13;
        Image r0 = this.b;
        if (r0 == null) goto L12;
        r0.close();
        this.b = null;
    L12:
        this.b = r4;
        invalidate();
    L13:
        if (r4 == null) goto L16;
        return true;
    L16:
        return false;
    L7:
        r4 = this.a.acquireNextImage();
        goto L8
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        super.onDraw(r5);
        Image r0 = this.b;
        if (r0 != null) goto L5;
    L18:
        Bitmap r1 = this.c;
        if (r1 == null) goto L22;
        r5.drawBitmap(r1, 0.0f, 0.0f, null);
        return;
    L22:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L7;
        HardwareBuffer r2 = r0.getHardwareBuffer();
        this.c = Bitmap.wrapHardwareBuffer(r2, ColorSpace.get(ColorSpace.Named.SRGB));
        r2.close();
        goto L18
    L7:
        Image.Plane[] r3 = r0.getPlanes();
        if (r3.length != 1) goto L18;
        Image.Plane r4 = r3[0];
        int r6 = r4.getRowStride() / r4.getPixelStride();
        int r7 = this.b.getHeight();
        Bitmap r8 = this.c;
        if (r8 != null) goto L13;
    L16:
        this.c = Bitmap.createBitmap(r6, r7, Bitmap.Config.ARGB_8888);
    L17:
        ByteBuffer r9 = r4.getBuffer();
        r9.rewind();
        this.c.copyPixelsFromBuffer(r9);
        goto L18
    L13:
        if (r8.getWidth() != r6) goto L16;
        if (this.c.getHeight() == r7) goto L17;
        goto L16
    }

    public FlutterImageView(Context r2, AttributeSet r3) {
        this(r2, 1, 1, SurfaceKind.background);
    }

    public static ImageReader d(int r10, int r11) {
        if (r10 > 0) goto L5;
        c5a.c.d(5, "FlutterImageView", String.format(Locale.US, "ImageReader width must be greater than 0, but given width=%d, set width=1", new Object[]{Integer.valueOf(r10)}));
        int r4 = 1;
    L6:
        if (r11 > 0) goto L8;
        c5a.c.d(5, "FlutterImageView", String.format(Locale.US, "ImageReader height must be greater than 0, but given height=%d, set height=1", new Object[]{Integer.valueOf(r11)}));
        int r5 = 1;
    L10:
        if (Build.VERSION.SDK_INT < 29) goto L14;
        return ImageReader.newInstance(r4, r5, 1, 3, 768);
    L14:
        return ImageReader.newInstance(r4, r5, 1, 3);
    L8:
        r5 = r11;
        goto L10
    L5:
        r4 = r10;
        goto L6
    }

    public final void e(int r2, int r3) {
        if (this.d != null) goto L6;
        return;
    L6:
        if (r2 == this.a.getWidth()) goto L8;
    L10:
        Image r0 = this.b;
        if (r0 == null) goto L13;
        r0.close();
        this.b = null;
    L13:
        this.a.close();
        this.a = d(r2, r3);
        return;
    L8:
        if (r3 != this.a.getHeight()) goto L10;
    }

    public FlutterImageView(Context r1, int r2, int r3, SurfaceKind r4) {
        ImageReader r5 = d(r2, r3);
        super(r1, null);
        this.f = false;
        this.a = r5;
        this.e = r4;
        setAlpha(0.0f);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        if (r1 != this.a.getWidth()) goto L8;
        if (r2 != this.a.getHeight()) goto L8;
        return;
    L8:
        if (this.e == SurfaceKind.background) goto L10;
        return;
    L10:
        if (this.f == false) goto L14;
        e(r1, r2);
        FlutterRenderer r5 = this.d;
        Surface r6 = this.a.getSurface();
        r5.b = r6;
        r5.a.onSurfaceWindowChanged(r6);
        return;
    }
}
