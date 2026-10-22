package com.bytedance.bmmt.video;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class YuvHelper {
    public YuvHelper() {
    }

    private static native void nativeCopyPlane(ByteBuffer r0, int r1, ByteBuffer r2, int r3, int r4, int r5);

    private static native void nativeI420Copy(ByteBuffer r0, int r1, ByteBuffer r2, int r3, ByteBuffer r4, int r5, ByteBuffer r6, int r7, ByteBuffer r8, int r9, ByteBuffer r10, int r11, int r12, int r13);

    private static native void nativeI420Rotate(ByteBuffer r0, int r1, ByteBuffer r2, int r3, ByteBuffer r4, int r5, ByteBuffer r6, int r7, ByteBuffer r8, int r9, ByteBuffer r10, int r11, int r12, int r13, int r14);

    private static native void nativeI420ToNV12(ByteBuffer r0, int r1, ByteBuffer r2, int r3, ByteBuffer r4, int r5, ByteBuffer r6, int r7, ByteBuffer r8, int r9, int r10, int r11);

    private static native void nativeNV12Copy(ByteBuffer r0, int r1, ByteBuffer r2, int r3, ByteBuffer r4, int r5, ByteBuffer r6, int r7, int r8, int r9);

    public static void copyPlane(ByteBuffer r0, int r1, ByteBuffer r2, int r3, int r4, int r5) {
        nativeCopyPlane(r0, r1, r2, r3, r4, r5);
    }

    public static void NV12Copy(ByteBuffer r9, int r10, ByteBuffer r11, int r12, ByteBuffer r13, int r14, int r15) {
        NV12Copy(r9, r10, r11, r12, r13, r14, r15, r14, r15);
    }

    public static void I420Copy(ByteBuffer r11, int r12, ByteBuffer r13, int r14, ByteBuffer r15, int r16, ByteBuffer r17, int r18, int r19) {
        I420Copy(r11, r12, r13, r14, r15, r16, r17, r18, r19, r18, r19);
    }

    public static void I420ToNV12(ByteBuffer r11, int r12, ByteBuffer r13, int r14, ByteBuffer r15, int r16, ByteBuffer r17, int r18, int r19) {
        I420ToNV12(r11, r12, r13, r14, r15, r16, r17, r18, r19, r18, r19);
    }

    public static void NV12Copy(ByteBuffer r10, int r11, ByteBuffer r12, int r13, ByteBuffer r14, int r15, int r16, int r17, int r18) {
        int r1 = (r17 + 1) / 2;
        int r3 = r17 * r18;
        int r2 = ((((r18 + 1) / 2) * r1) * 2) + r3;
        if (r14.capacity() < r2) goto L7;
        r14.position(0);
        ByteBuffer r4 = r14.slice();
        r14.position(r3);
        nativeNV12Copy(r10, r11, r12, r13, r4, r17, r14.slice(), r1 * 2, r15, r16);
        return;
    L7:
        throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + r2 + " was " + r14.capacity());
    }

    public static void I420Rotate(ByteBuffer r15, int r16, ByteBuffer r17, int r18, ByteBuffer r19, int r20, ByteBuffer r21, int r22, int r23, int r24) {
        int r1 = r24 % 180;
        if (r1 != 0) goto L5;
        int r7 = r22;
    L6:
        if (r1 != 0) goto L8;
        int r2 = r23;
    L9:
        int r3 = (r2 + 1) / 2;
        int r11 = (r7 + 1) / 2;
        int r4 = r2 * r7;
        int r5 = r3 * r11;
        int r6 = (r5 * 2) + r4;
        if (r21.capacity() < r6) goto L14;
        r21.position(0);
        ByteBuffer r8 = r21.slice();
        r21.position(r4);
        ByteBuffer r9 = r21.slice();
        r21.position(r5 + r4);
        nativeI420Rotate(r15, r16, r17, r18, r19, r20, r8, r7, r9, r11, r21.slice(), r11, r22, r23, r24);
        return;
    L14:
        throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + r6 + " was " + r21.capacity());
    L8:
        r2 = r22;
        goto L9
    L5:
        r7 = r23;
        goto L6
    }

    public static void I420Copy(ByteBuffer r14, int r15, ByteBuffer r16, int r17, ByteBuffer r18, int r19, ByteBuffer r20, int r21, int r22, int r23, int r24) {
        if (r14 == null) goto L14;
        if (r16 == null) goto L15;
        if (r18 == null) goto L16;
        if (r20 == null) goto L17;
        int r11 = (r23 + 1) / 2;
        int r2 = r23 * r24;
        int r1 = ((r24 + 1) / 2) * r11;
        int r3 = (r1 * 2) + r2;
        if (r20.capacity() < r3) goto L13;
        r20.position(0);
        ByteBuffer r6 = r20.slice();
        r20.position(r2);
        ByteBuffer r8 = r20.slice();
        r20.position(r1 + r2);
        nativeI420Copy(r14, r15, r16, r17, r18, r19, r6, r23, r8, r11, r20.slice(), r11, r21, r22);
        return;
    L13:
        throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + r3 + " was " + r20.capacity());
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public static void I420ToNV12(ByteBuffer r12, int r13, ByteBuffer r14, int r15, ByteBuffer r16, int r17, ByteBuffer r18, int r19, int r20, int r21, int r22) {
        int r1 = (r21 + 1) / 2;
        int r3 = r21 * r22;
        int r2 = ((((r22 + 1) / 2) * r1) * 2) + r3;
        if (r18.capacity() < r2) goto L7;
        r18.position(0);
        ByteBuffer r6 = r18.slice();
        r18.position(r3);
        nativeI420ToNV12(r12, r13, r14, r15, r16, r17, r6, r21, r18.slice(), r1 * 2, r19, r20);
        return;
    L7:
        throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + r2 + " was " + r18.capacity());
    }

    public static void I420ToNV12(ByteBuffer r0, int r1, ByteBuffer r2, int r3, ByteBuffer r4, int r5, ByteBuffer r6, int r7, ByteBuffer r8, int r9, int r10, int r11) {
        nativeI420ToNV12(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static void I420Copy(ByteBuffer r0, int r1, ByteBuffer r2, int r3, ByteBuffer r4, int r5, ByteBuffer r6, int r7, ByteBuffer r8, int r9, ByteBuffer r10, int r11, int r12, int r13) {
        nativeI420Copy(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static void I420Rotate(ByteBuffer r0, int r1, ByteBuffer r2, int r3, ByteBuffer r4, int r5, ByteBuffer r6, int r7, ByteBuffer r8, int r9, ByteBuffer r10, int r11, int r12, int r13, int r14) {
        nativeI420Rotate(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }
}
