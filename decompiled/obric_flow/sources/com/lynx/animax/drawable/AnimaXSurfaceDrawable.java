package com.lynx.animax.drawable;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.lynx.animax.base.CalledByNative;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.base.h;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class AnimaXSurfaceDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Surface f9590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SurfaceTexture f9591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BitmapBufferGroup f9592c;
    public final DrawableType d;
    public int e;
    public int f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9593h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f9594i;

    public static final enum DrawableType extends Enum<DrawableType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DrawableType f9595a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final DrawableType f9596b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final DrawableType f9597c = null;
        public static final DrawableType d = null;
        public static final /* synthetic */ DrawableType[] e = null;

        static {
            DrawableType r5 = new DrawableType("Invalid", 0);
            f9595a = r5;
            DrawableType r10 = new DrawableType("TextureView", 1);
            f9596b = r10;
            DrawableType r11 = new DrawableType("SurfaceView", 2);
            f9597c = r11;
            DrawableType r12 = new DrawableType("BitmapBufferGroup", 3);
            d = r12;
            e = new DrawableType[]{r5, r10, r11, r12};
        }

        public DrawableType(String r5, int r10) {
            super(r5, r10);
        }

        public static DrawableType valueOf(String r5) {
            return (DrawableType) Enum.valueOf(DrawableType.class, r5);
        }

        public static DrawableType[] values() {
            return (DrawableType[]) e.clone();
        }
    }

    public AnimaXSurfaceDrawable(Surface r5, SurfaceTexture r10, BitmapBufferGroup r11, int r12, int r13) {
        int r14 = 0;
        this.g = false;
        this.f9593h = false;
        this.f9594i = false;
        this.f9590a = r5;
        this.f9591b = r10;
        this.f9592c = r11;
        if (r10 == null) goto L5;
        this.d = DrawableType.f9596b;
    L25:
        this.e = r12;
        this.f = r13;
        return;
    L5:
        if (r11 == null) goto L22;
        this.d = DrawableType.d;
        if (r12 <= 0) goto L25;
        if (r13 <= 0) goto L25;
    L10:
        ConcurrentLinkedQueue r15 = r11.f9605b;
        BitmapBuffer r16 = (BitmapBuffer) r15.poll();
        if (r16 == null) goto L13;
        r16.b();
        goto L10
    L13:
        BitmapBuffer r17 = (BitmapBuffer) r11.f9604a.getAndSet(null);
        if (r17 == null) goto L16;
        r17.b();
    L16:
        if (r12 <= 0) goto L25;
        if (r13 <= 0) goto L25;
    L20:
        if (r14 >= r11.f9606c) goto L25;
        r15.offer(BitmapBuffer.a(r12, r13, r11.e));
        r14 = r14 + 1;
        goto L20
    L22:
        if (r5 == null) goto L24;
        this.d = DrawableType.f9597c;
        goto L25
    L24:
        this.d = DrawableType.f9595a;
        goto L25
    }

    @CalledByNative
    private long getTypeIndex() {
        return this.d.ordinal();
    }

    public final boolean a(int r10, int r11) {
        int r5 = 0;
        if (Math.abs(this.e - r10) <= 1) goto L5;
    L8:
        this.e = r10;
        this.f = r11;
        BitmapBufferGroup r12 = this.f9592c;
        if (r12 == null) goto L25;
        if (r10 <= 0) goto L25;
        if (r11 <= 0) goto L25;
    L13:
        ConcurrentLinkedQueue r13 = r12.f9605b;
        BitmapBuffer r14 = (BitmapBuffer) r13.poll();
        if (r14 == null) goto L16;
        r14.b();
        goto L13
    L16:
        BitmapBuffer r15 = (BitmapBuffer) r12.f9604a.getAndSet(null);
        if (r15 == null) goto L19;
        r15.b();
    L19:
        if (r10 <= 0) goto L25;
        if (r11 <= 0) goto L25;
    L23:
        if (r5 >= r12.f9606c) goto L25;
        r13.offer(BitmapBuffer.a(r10, r11, r12.e));
        r5 = r5 + 1;
    L25:
        String r16 = h.b(r10, r11, "Update size success: ", " / ");
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXSurfaceDrawable", r16);
        return true;
    L5:
        if (Math.abs(this.f - r11) > 1) goto L8;
        String r17 = h.b(r10, r11, "Skip same size: ", " / ");
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXSurfaceDrawable", r17);
        return false;
    }

    @Nullable
    @CalledByNative
    public BitmapBufferGroup getBitmapBufferGroup() {
        return this.f9592c;
    }

    @CalledByNative
    public int getHeight() {
        return this.f;
    }

    @Nullable
    @CalledByNative
    public Surface getSurface() {
        return this.f9590a;
    }

    @Nullable
    @CalledByNative
    public SurfaceTexture getSurfaceTexture() {
        return this.f9591b;
    }

    @CalledByNative
    public int getWidth() {
        return this.e;
    }

    @CalledByNative
    public boolean isAntiAliasingEnabled() {
        return this.g;
    }

    @CalledByNative
    public boolean isAutoDestroyEGLContextEnabled() {
        return false;
    }

    @CalledByNative
    public boolean isPlatformSurfaceInitiallyInvalid() {
        return this.f9594i;
    }

    @CalledByNative
    public boolean isSoftwareRenderEnabled() {
        return this.f9593h;
    }

    @CalledByNative
    public boolean isTextureFirstFrameAware() {
        SurfaceTexture r5 = this.f9591b;
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5 instanceof FirstFrameAwareSurfaceTexture;
    }
}
