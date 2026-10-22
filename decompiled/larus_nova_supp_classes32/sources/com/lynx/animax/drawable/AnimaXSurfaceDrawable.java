package com.lynx.animax.drawable;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.lynx.animax.util.AnimaXLog;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXSurfaceDrawable {
    public final Surface a;
    public final SurfaceTexture b;
    public final BitmapBufferGroup c;
    public final DrawableType d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;

    public static final enum DrawableType extends Enum<DrawableType> {
        public static final DrawableType BitmapBufferGroup = null;
        public static final DrawableType Invalid = null;
        public static final DrawableType SurfaceView = null;
        public static final DrawableType TextureView = null;
        public static final /* synthetic */ DrawableType[] a = null;

        static {
            DrawableType r0 = new DrawableType("Invalid", 0);
            Invalid = r0;
            DrawableType r1 = new DrawableType("TextureView", 1);
            TextureView = r1;
            DrawableType r3 = new DrawableType("SurfaceView", 2);
            SurfaceView = r3;
            DrawableType r5 = new DrawableType("BitmapBufferGroup", 3);
            BitmapBufferGroup = r5;
            a = new DrawableType[]{r0, r1, r3, r5};
        }

        public static DrawableType[] values() {
            return (DrawableType[]) a.clone();
        }

        public static DrawableType valueOf(String r1) {
            return (DrawableType) a.a(DrawableType.class, r1);
        }

        public DrawableType(String r1, int r2) {
            super(r1, r2);
        }
    }

    private long getTypeIndex() {
        return this.d.ordinal();
    }

    public boolean isTextureFirstFrameAware() {
        SurfaceTexture r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0 instanceof FirstFrameAwareSurfaceTexture;
    }

    public BitmapBufferGroup getBitmapBufferGroup() {
        return this.c;
    }

    public int getHeight() {
        return this.f;
    }

    public Surface getSurface() {
        return this.a;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.b;
    }

    public DrawableType getType() {
        return this.d;
    }

    public int getWidth() {
        return this.e;
    }

    public boolean isAntiAliasingEnabled() {
        return this.g;
    }

    public boolean isAutoDestroyEGLContextEnabled() {
        return this.j;
    }

    public boolean isPlatformSurfaceInitiallyInvalid() {
        return this.i;
    }

    public boolean isSoftwareRenderEnabled() {
        return this.h;
    }

    public final boolean a(int r6, int r7) {
        if (Math.abs(this.e - r6) <= 1) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == false) goto L12;
        AnimaXLog.b("AnimaXSurfaceDrawable", "Skip same size: " + r6 + " / " + r7);
        return false;
    L12:
        this.e = r6;
        this.f = r7;
        BitmapBufferGroup r1 = this.c;
        if (r1 == null) goto L15;
        r1.b(r6, r7);
    L15:
        AnimaXLog.b("AnimaXSurfaceDrawable", "Update size success: " + r6 + " / " + r7);
        return true;
    L5:
        if (Math.abs(this.f - r7) > 1) goto L7;
        r0 = true;
        goto L9
    }

    public AnimaXSurfaceDrawable(Surface r2, SurfaceTexture r3, BitmapBufferGroup r4, int r5, int r6) {
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        if (r3 == null) goto L5;
        this.d = DrawableType.TextureView;
    L10:
        this.e = r5;
        this.f = r6;
        return;
    L5:
        if (r4 == null) goto L7;
        this.d = DrawableType.BitmapBufferGroup;
        r4.b(r5, r6);
        goto L10
    L7:
        if (r2 == null) goto L9;
        this.d = DrawableType.SurfaceView;
        goto L10
    L9:
        this.d = DrawableType.Invalid;
        goto L10
    }
}
