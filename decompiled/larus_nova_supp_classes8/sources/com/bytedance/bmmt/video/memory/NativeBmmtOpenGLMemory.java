package com.bytedance.bmmt.video.memory;

import android.graphics.Matrix;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import com.bytedance.bmmt.video.BmmtGlConfig;
import com.bytedance.bmmt.video.BmmtVideoMemoryType;
import com.bytedance.bmmt.video.MediaCodecTextureBufferHelper;
import com.bytedance.bmmt.video.PixelFormat;
import com.bytedance.bmmt.video.RendererCommon;
import com.bytedance.bmmt.video.VideoRotation;
import com.bytedance.bmmt.video.VideoScaleFilter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class NativeBmmtOpenGLMemory extends BmmtVideoMemory implements BmmtVideoOpenGLMemoryInterface {
    private static native long nativeCreateOpenGLMemory(int r0, int r1, int r2, int r3, int r4, int r5, PixelFormat r6, float[] r7, EGLContext r8, VideoScaleFilter r9, VideoRotation r10, Runnable r11);

    private static native long nativeGetGLSync(long r0);

    private static native int nativeGetHeight(long r0);

    private static native EGLContext nativeGetJavaEGLContext(long r0);

    private static native long nativeGetNativeEGLContext(long r0);

    private static native VideoRotation nativeGetRotation(long r0);

    private static native VideoScaleFilter nativeGetScaleFilter(long r0);

    private static native int nativeGetTextureId(long r0);

    private static native float[] nativeGetTextureMatrix(long r0);

    private static native PixelFormat nativeGetTextureTarget(long r0);

    private static native int nativeGetUnscaledHeight(long r0);

    private static native int nativeGetUnscaledWidth(long r0);

    private static native BmmtVideoMemoryType nativeGetVideoMemoryType(long r0);

    private static native int nativeGetWidth(long r0);

    private static native void nativeReleaseTextureVideoMemory(long r0);

    private static native void nativeSetRenderHelper(long r0, MediaCodecTextureBufferHelper r2);

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface
    public int getHeight() {
        return nativeGetHeight(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public VideoScaleFilter getScaleFilter() {
        return nativeGetScaleFilter(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public int getUnScaledHeight() {
        return nativeGetUnscaledHeight(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public int getUnScaledWidth() {
        return nativeGetUnscaledWidth(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface
    public int getWidth() {
        return nativeGetWidth(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public Matrix getAndroidTextureMatrix() {
        if (isNullPointer() == false) goto L7;
        return new Matrix();
    L7:
        return RendererCommon.convertMatrixToAndroidGraphicsMatrix(nativeGetTextureMatrix(this.nativeHandle));
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public EGLContext getEGLContext() {
        if (isNullPointer() == false) goto L7;
        return EGL14.EGL_NO_CONTEXT;
    L7:
        return nativeGetJavaEGLContext(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public long getGLSync() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetGLSync(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface
    public BmmtVideoMemoryType getMemoryType() {
        if (isNullPointer() == false) goto L7;
        return null;
    L7:
        return nativeGetVideoMemoryType(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public long getNativeEGLContext() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetNativeEGLContext(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface
    public PixelFormat getPixelFormat() {
        return getTextureTarget();
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public VideoRotation getRotation() {
        if (isNullPointer() == false) goto L7;
        return null;
    L7:
        return nativeGetRotation(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public int getTextureId() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetTextureId(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public float[] getTextureMatrix() {
        if (isNullPointer() == false) goto L7;
        float[] r0 = new float[16];
        r0[0] = 1.0f;
        r0[5] = 1.0f;
        r0[10] = 1.0f;
        r0[15] = 1.0f;
        return r0;
    L7:
        return nativeGetTextureMatrix(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public PixelFormat getTextureTarget() {
        if (isNullPointer() == false) goto L7;
        return PixelFormat.kUnknown;
    L7:
        return nativeGetTextureTarget(this.nativeHandle);
    }

    public NativeBmmtOpenGLMemory(long r1) {
        super(r1);
    }

    private static void release(Runnable r0) {
        if (r0 == null) goto L5;
        r0.run();
        return;
    }

    public void setRenderHelper(MediaCodecTextureBufferHelper r3) {
        nativeSetRenderHelper(this.nativeHandle, r3);
    }

    public static NativeBmmtOpenGLMemory createOpenGLMemory(int r12, int r13, int r14, int r15, int r16, PixelFormat r17, float[] r18, EGLContext r19, VideoScaleFilter r20, VideoRotation r21, Runnable r22) {
        return new NativeBmmtOpenGLMemory(nativeCreateOpenGLMemory(r12, r13, r14, r15, r16, BmmtGlConfig.getTexture2DGlFormat(), r17, r18, r19, r20, r21, r22));
    }
}
