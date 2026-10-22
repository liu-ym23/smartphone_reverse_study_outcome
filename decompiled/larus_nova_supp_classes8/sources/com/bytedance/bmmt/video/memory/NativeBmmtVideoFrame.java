package com.bytedance.bmmt.video.memory;

import com.bytedance.bmmt.video.ColorSpace;
import com.bytedance.bmmt.video.PixelFormat;
import com.bytedance.bmmt.video.VideoFrameHelperInterface;
import com.bytedance.bmmt.video.VideoRotation;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class NativeBmmtVideoFrame implements BmmtVideoFrameInterface {
    private long nativeHandle;
    RefObject refCounted;

    public static /* synthetic */ void a(NativeBmmtVideoFrame r0) {
        r0.lambda$new$0();
    }

    private static native long nativeCreateVideoFrameFromByteMemory(long r0, int r2, int r3, PixelFormat r4, ByteBuffer[] r5, int[] r6, long r7, ByteBuffer r9, ColorSpace r10, VideoRotation r11);

    private static native long nativeCreateVideoFrameFromOpenGLMemory(long r0, long r2, long r4, ByteBuffer r6, ColorSpace r7, VideoRotation r8);

    private static native ColorSpace nativeGetColorSpace(long r0);

    private static native BmmtVideoMemoryInterface nativeGetFrameMemory(long r0);

    private static native int nativeGetHeight(long r0);

    private static native VideoRotation nativeGetRotation(long r0);

    private static native ByteBuffer nativeGetSupplementData(long r0);

    private static native long nativeGetTimestampNs(long r0);

    private static native long nativeGetTimestampUs(long r0);

    private static native int nativeGetWidth(long r0);

    private static native void nativeReleaseVideoFrame(long r0);

    private static native void nativeSetRotation(long r0, VideoRotation r2);

    private static native void nativeSetTimestampNs(long r0, long r2);

    private static native void nativeSetTimestampUs(long r0, long r2);

    private static native NativeBmmtVideoFrame nativeToI420(long r0);

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface, com.bytedance.bmmt.base.RefCounted
    public synchronized void release() {
        monitor-enter(this);
        this.refCounted.release();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface, com.bytedance.bmmt.base.RefCounted
    public synchronized void retain() {
        monitor-enter(this);
        this.refCounted.retain();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$0() {
        long r0 = this.nativeHandle;
        if (r0 == 0) goto L6;
        nativeReleaseVideoFrame(r0);
        this.nativeHandle = 0;
        return;
    }

    public boolean isNullPointer() {
        if (this.nativeHandle != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public BmmtVideoMemoryInterface getAndRetainVideoFrameMemory() {
        if (isNullPointer() == false) goto L7;
        return null;
    L7:
        return nativeGetFrameMemory(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public ColorSpace getColorSpace() {
        if (isNullPointer() == false) goto L7;
        return ColorSpace.kUnknown;
    L7:
        return nativeGetColorSpace(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public int getHeight() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetHeight(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public int getRotatedHeight() {
        if (isNullPointer() == false) goto L6;
        return 0;
    L6:
        int r0 = nativeGetWidth(this.nativeHandle);
        int r1 = nativeGetHeight(this.nativeHandle);
        if ((getRotation().value() % 180) != 0) goto L9;
        return r1;
    L9:
        return r0;
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public int getRotatedWidth() {
        if (isNullPointer() == false) goto L6;
        return 0;
    L6:
        int r0 = nativeGetWidth(this.nativeHandle);
        int r1 = nativeGetHeight(this.nativeHandle);
        if ((getRotation().value() % 180) != 0) goto L9;
        return r0;
    L9:
        return r1;
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public VideoRotation getRotation() {
        if (isNullPointer() == false) goto L7;
        return VideoRotation.VIDEO_ROTATION_0;
    L7:
        return nativeGetRotation(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public ByteBuffer getSupplementData() {
        if (isNullPointer() == false) goto L7;
        return null;
    L7:
        return nativeGetSupplementData(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public long getTimestampNs() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetTimestampNs(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public long getTimestampUs() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetTimestampUs(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public int getWidth() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetWidth(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public BmmtVideoFrameInterface toI420() {
        if (isNullPointer() == false) goto L7;
        return null;
    L7:
        return nativeToI420(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public long getNativeHandle() {
        return this.nativeHandle;
    }

    private NativeBmmtVideoFrame(long r1) {
        this.nativeHandle = r1;
        this.refCounted = new RefObject(new b(this));
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public void setRotation(VideoRotation r3) {
        if (isNullPointer() == false) goto L5;
        return;
    L5:
        nativeSetRotation(this.nativeHandle, r3);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public void setTimestampNs(long r3) {
        if (isNullPointer() == false) goto L5;
        return;
    L5:
        nativeSetTimestampNs(this.nativeHandle, r3);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public void setTimestampUs(long r3) {
        if (isNullPointer() == false) goto L5;
        return;
    L5:
        nativeSetTimestampUs(this.nativeHandle, r3);
    }

    public static NativeBmmtVideoFrame createVideoFrame(NativeBmmtByteMemory r12, long r13, ByteBuffer r15, ColorSpace r16, VideoRotation r17) {
        return new NativeBmmtVideoFrame(nativeCreateVideoFrameFromByteMemory(r12.getNativeHandle(), r12.getWidth(), r12.getHeight(), r12.getPixelFormat(), r12.getPlaneDataArray(), r12.getPlaneLineSizeArray(), r13, r15, r16, r17));
    }

    public static NativeBmmtVideoFrame createVideoFrame(NativeBmmtOpenGLMemory r11, VideoFrameHelperInterface r12, long r13, ByteBuffer r15, ColorSpace r16) {
        if (r12 == null) goto L4;
        long r0 = r12.getNativeHandle();
    L5:
        long r2 = r11.getNativeHandle();
        return new NativeBmmtVideoFrame(nativeCreateVideoFrameFromOpenGLMemory(r2, r0, r13, r15, r16, r11.getRotation()));
    L4:
        r0 = 0;
        goto L5
    }
}
