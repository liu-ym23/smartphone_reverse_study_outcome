package com.bytedance.bmmt.video;

import android.graphics.Matrix;
import android.graphics.Point;
import android.opengl.GLES20;
import com.bytedance.bmmt.video.memory.BmmtVideoByteMemoryInterface;
import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;
import com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface;
import com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface;
import com.bytedance.bmmt.video.memory.NativeBmmtByteMemory;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class VideoFrameDrawer {
    static final float[] srcPoints = null;
    private int dstHeight;
    private final float[] dstPoints;
    private int dstWidth;
    private BmmtVideoFrameInterface lastI420Frame;
    private int renderHeight;
    private final Matrix renderMatrix;
    private final Point renderSize;
    private int renderWidth;
    private final YuvUploader yuvUploader;

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.VideoFrameDrawer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmmt$video$PixelFormat = null;

        static {
            int[] r0 = new int[PixelFormat.values().length];
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat = r0;
            r0[PixelFormat.kTextureOES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kTexture2D.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class YuvUploader {
        private ByteBuffer copyBuffer;
        private int[] yuvTextures;

        private YuvUploader() {
        }

        public /* synthetic */ YuvUploader(int r1) {
            this();
        }

        public void release() {
            this.copyBuffer = null;
            int[] r1 = this.yuvTextures;
            if (r1 == null) goto L6;
            GLES20.glDeleteTextures(3, r1, 0);
            this.yuvTextures = null;
            return;
        }

        public int[] getYuvTextures() {
            return this.yuvTextures;
        }

        public int[] uploadFromBuffer(BmmtVideoByteMemoryInterface r7) {
            if (r7.getPixelFormat() == PixelFormat.kI420) goto L7;
            return null;
        L7:
            return uploadYuvData(r7.getWidth(), r7.getHeight(), new int[]{r7.getPlaneLineSize(0), r7.getPlaneLineSize(1), r7.getPlaneLineSize(2)}, new ByteBuffer[]{r7.getPlaneData(0), r7.getPlaneData(1), r7.getPlaneData(2)});
        }

        public int[] uploadYuvData(int r19, int r20, int[] r21, ByteBuffer[] r22) {
            int r3 = 0;
            int r5 = r19 / 2;
            int[] r2 = {r19, r5, r5};
            int r7 = r20 / 2;
            int[] r6 = {r20, r7, r7};
            int r4 = 0;
            int r8 = 0;
        L3:
            if (r4 >= 3) goto L8;
            int r9 = r21[r4];
            int r10 = r2[r4];
            if (r9 <= r10) goto L7;
            r8 = Math.max(r8, r10 * r6[r4]);
        L7:
            r4 = r4 + 1;
            goto L3
        L8:
            if (r8 <= 0) goto L15;
            ByteBuffer r11 = this.copyBuffer;
            if (r11 != null) goto L12;
        L13:
            this.copyBuffer = ByteBuffer.allocateDirect(r8);
            goto L15
        L12:
            if (r11.capacity() < r8) goto L13;
        L15:
            if (this.yuvTextures != null) goto L19;
            this.yuvTextures = new int[3];
            int r12 = 0;
        L17:
            if (r12 >= 3) goto L19;
            this.yuvTextures[r12] = GlUtil.generateTexture(3553);
            r12 = r12 + 1;
        L19:
            if (r3 >= 3) goto L26;
            GLES20.glPixelStorei(3317, 1);
            GLES20.glActiveTexture(33984 + r3);
            GLES20.glBindTexture(3553, this.yuvTextures[r3]);
            int r13 = r21[r3];
            int r14 = r2[r3];
            if (r13 != r14) goto L23;
            ByteBuffer r15 = r22[r3];
        L24:
            GLES20.glTexImage2D(3553, 0, 6409, r2[r3], r6[r3], 0, 6409, 5121, r15);
            GLES20.glPixelStorei(3317, 4);
            r3 = r3 + 1;
            goto L19
        L23:
            YuvHelper.copyPlane(r22[r3], r13, this.copyBuffer, r14, r14, r6[r3]);
            r15 = this.copyBuffer;
            goto L24
        L26:
            return this.yuvTextures;
        }
    }

    static {
        srcPoints = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    }

    public void release() {
        this.yuvUploader.release();
        this.lastI420Frame = null;
    }

    public VideoFrameDrawer() {
        this.dstPoints = new float[6];
        this.renderSize = new Point();
        this.dstWidth = 0;
        this.dstHeight = 0;
        this.yuvUploader = new YuvUploader(0);
        this.renderMatrix = new Matrix();
    }

    public void drawFrame(BmmtVideoFrameInterface r2, RendererCommon.GlDrawer r3) {
        drawFrame(r2, r3, null);
    }

    private void calculateTransformedRenderSize(int r8, int r9, Matrix r10) {
        if (r10 != null) goto L5;
        this.renderWidth = r8;
        this.renderHeight = r9;
        return;
    L5:
        r10.mapPoints(this.dstPoints, srcPoints);
        int r0 = 0;
    L7:
        if (r0 >= 3) goto L9;
        float[] r1 = this.dstPoints;
        int r3 = r0 * 2;
        int r4 = r3 + 0;
        r1[r4] = r1[r4] * r8;
        int r5 = r3 + 1;
        r1[r5] = r1[r5] * r9;
        r0 = r0 + 1;
        goto L7
    L9:
        float[] r11 = this.dstPoints;
        this.renderWidth = distance(r11[0], r11[1], r11[2], r11[3]);
        float[] r12 = this.dstPoints;
        this.renderHeight = distance(r12[0], r12[1], r12[4], r12[5]);
    }

    public void drawFrame(BmmtVideoFrameInterface r9, RendererCommon.GlDrawer r10, Matrix r11) {
        drawFrame(r9, r10, r11, 0, 0, r9.getRotatedWidth(), r9.getRotatedHeight());
    }

    private static int distance(float r2, float r3, float r4, float r5) {
        return (int) Math.round(Math.hypot(r4 - r2, r5 - r3));
    }

    public void drawFrame(BmmtVideoFrameInterface r19, RendererCommon.GlDrawer r20, Matrix r21, int r22, int r23, int r24, int r25) {
        if (r19 != null) goto L5;
        return;
    L5:
        BmmtVideoMemoryInterface r3 = r19.getAndRetainVideoFrameMemory();
        if (r3 != null) goto L53;
        return;
    L53:
        calculateTransformedRenderSize(r19.getRotatedWidth(), r19.getRotatedHeight(), r21);     // Catch: Throwable -> L47 Exception -> L52
        if (r3.getMemoryType() != BmmtVideoMemoryType.kOPENGL_TEXTURE) goto L11;
        boolean r4 = true;
    L12:
        this.renderMatrix.reset();     // Catch: Throwable -> L47 Exception -> L52
        this.renderMatrix.preTranslate(0.5f, 0.5f);     // Catch: Throwable -> L47 Exception -> L52
        if (r4 == true) goto L15;
        this.renderMatrix.preScale(1.0f, -1.0f);     // Catch: Throwable -> L47 Exception -> L52
    L15:
        this.renderMatrix.preRotate(r19.getRotation().value());     // Catch: Throwable -> L47 Exception -> L52
        this.renderMatrix.preTranslate(-0.5f, -0.5f);     // Catch: Throwable -> L47 Exception -> L52
        if (r21 == null) goto L18;
        this.renderMatrix.preConcat(r21);     // Catch: Throwable -> L47 Exception -> L52
    L18:
        if (r4 == false) goto L34;
        if (this.renderWidth <= 0) goto L34;
        BmmtVideoOpenGLMemoryInterface r5 = (BmmtVideoOpenGLMemoryInterface) r3;     // Catch: Throwable -> L47 Exception -> L52
        VideoScaleFilter r0 = r5.getScaleFilter();     // Catch: Throwable -> L47 Exception -> L52
        if (r0 != null) goto L25;
        r0 = VideoScaleFilter.kOpenGLOrigin;     // Catch: Throwable -> L47 Exception -> L52
    L25:
        FilterType r13 = FilterType.fromValue(r0.value());     // Catch: Throwable -> L47 Exception -> L52
        int r14 = r5.getUnScaledWidth();     // Catch: Throwable -> L47 Exception -> L52
        int r15 = r5.getUnScaledHeight();     // Catch: Throwable -> L47 Exception -> L52
        this.lastI420Frame = null;     // Catch: Throwable -> L47 Exception -> L52
        if (r13 != null) goto L28;
    L32:
        drawTexture(r20, r5, this.renderMatrix, this.renderWidth, this.renderHeight, r22, r23, r24, r25, FilterType.Origin, 0, 0, this.dstWidth, this.dstHeight);     // Catch: Throwable -> L47 Exception -> L52
        goto L50
    L28:
        if (r13 == FilterType.Origin) goto L32;
        if (r14 == 0) goto L32;
        if (r15 == 0) goto L32;
        drawTexture(r20, r5, this.renderMatrix, this.renderWidth, this.renderHeight, r22, r23, r24, r25, r13, r14, r15, this.dstWidth, this.dstHeight);     // Catch: Throwable -> L47 Exception -> L52
    L34:
        if (r19 == this.lastI420Frame) goto L45;
        this.lastI420Frame = r19;     // Catch: Throwable -> L47 Exception -> L52
        BmmtVideoFrameInterface r1 = r19.toI420();     // Catch: Throwable -> L47 Exception -> L52
        if (r1 != null) goto L39;
        r3.release();
        return;
    L39:
        BmmtVideoMemoryInterface r2 = r1.getAndRetainVideoFrameMemory();     // Catch: Throwable -> L47 Exception -> L52
        if ((r2 instanceof NativeBmmtByteMemory) == true) goto L44;
        r1.release();     // Catch: Throwable -> L47 Exception -> L52
        r3.release();
        return;
    L44:
        this.yuvUploader.uploadFromBuffer((BmmtVideoByteMemoryInterface) r2);     // Catch: Throwable -> L47 Exception -> L52
        r2.release();     // Catch: Throwable -> L47 Exception -> L52
        r1.release();     // Catch: Throwable -> L47 Exception -> L52
    L45:
        r20.drawYuv(this.yuvUploader.getYuvTextures(), RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.renderMatrix), this.renderWidth, this.renderHeight, r22, r23, r24, r25, FilterType.Origin, 0, 0, this.dstWidth, this.dstHeight);     // Catch: Throwable -> L47 Exception -> L52
        goto L50
    L11:
        r4 = false;
    L47:
        th = move-exception;
        r3.release();
        throw th;
    L50:
        r3.release();
    }

    public void drawFrame(BmmtVideoFrameInterface r1, RendererCommon.GlDrawer r2, Matrix r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        this.dstWidth = r8;
        this.dstHeight = r9;
        drawFrame(r1, r2, r3, r4, r5, r6, r7);
    }

    public static void drawTexture(RendererCommon.GlDrawer r13, BmmtVideoOpenGLMemoryInterface r14, Matrix r15, int r16, int r17, int r18, int r19, int r20, int r21, FilterType r22, int r23, int r24) {
        Matrix r0 = new Matrix(r14.getAndroidTextureMatrix());
        r0.preConcat(r15);
        float[] r3 = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(r0);
        int r1 = AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$PixelFormat[r14.getTextureTarget().ordinal()];
        if (r1 != 1) goto L5;
        r13.drawOes(r14.getTextureId(), r3, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        return;
    L5:
        if (r1 != 2) goto L8;
        r13.drawRgb(r14.getTextureId(), r3, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        return;
    L8:
        throw new RuntimeException("Unknown texture type.");
    }

    public static void drawTexture(RendererCommon.GlDrawer r15, BmmtVideoOpenGLMemoryInterface r16, Matrix r17, int r18, int r19, int r20, int r21, int r22, int r23, FilterType r24, int r25, int r26, int r27, int r28) {
        Matrix r0 = new Matrix(r16.getAndroidTextureMatrix());
        r0.preConcat(r17);
        float[] r3 = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(r0);
        int r1 = AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$PixelFormat[r16.getTextureTarget().ordinal()];
        if (r1 != 1) goto L5;
        r15.drawOes(r16.getTextureId(), r3, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        return;
    L5:
        if (r1 != 2) goto L8;
        r15.drawRgb(r16.getTextureId(), r3, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        return;
    L8:
        throw new RuntimeException("Unknown texture type.");
    }
}
