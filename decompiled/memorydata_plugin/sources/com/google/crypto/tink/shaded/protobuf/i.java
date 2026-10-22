package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes2.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<SoftReference<byte[]>> f5020a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?> f5021b = null;
    private static final long c = 0;

    static {
        f5020a = new ThreadLocal();
        Class<?> r0 = a("java.io.FileOutputStream");
        f5021b = r0;
        c = a(r0);
    }

    private static long a(Class<?> r2) {
        if (r2 != null) goto L10;
        return -1;
    L10:
        if (bx.a() == false) goto L12;
        return bx.a(r2.getDeclaredField("channel"));
    L12:
        return -1;
    L13:
        return -1;
    }

    private static Class<?> a(String r1) {
        return ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin");
    L4:
        return null;
    }

    static void a(ByteBuffer r4, OutputStream r5) {
        int r0 = r4.position();
    L15:
        th = move-exception;
        ad.b(r4, r0);
        throw th;
    L4:
        if (r4.hasArray() == false) goto L7;
        r5.write(r4.array(), r4.arrayOffset() + r4.position(), r4.remaining());     // Catch: Throwable -> L15
    L13:
        ad.b(r4, r0);
        return;
    L7:
        if (b(r4, r5) == true) goto L13;
        byte[] r1 = a(r4.remaining());     // Catch: Throwable -> L15
    L10:
        if (r4.hasRemaining() == false) goto L13;
        int r2 = Math.min(r4.remaining(), r1.length);     // Catch: Throwable -> L15
        r4.get(r1, 0, r2);     // Catch: Throwable -> L15
        r5.write(r1, 0, r2);     // Catch: Throwable -> L15
        goto L10
    }

    private static void a(byte[] r2) {
        f5020a.set(new SoftReference(r2));
    }

    private static boolean a(int r1, int r2) {
        if (r2 < r1) goto L4;
    L6:
        return false;
    L4:
        if (r2 >= (r1 * 0.5f)) goto L6;
        return true;
    }

    private static byte[] a() {
        SoftReference r0 = (SoftReference) ZeusTransformUtils.preCheckCast(f5020a.get(), SoftReference.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return null;
    L6:
        return (byte[]) ZeusTransformUtils.preCheckCast(r0.get(), byte[].class, "com.obric.memorydata.plugin");
    }

    private static byte[] a(int r2) {
        int r3 = Math.max(r2, 1024);
        byte[] r0 = a();
        if (r0 != null) goto L5;
    L6:
        r0 = new byte[r3];
        if (r3 > 16384) goto L9;
        a(r0);
    L9:
        return r0;
    L5:
        if (a(r3, r0.length) == false) goto L9;
        goto L6
    }

    private static boolean b(ByteBuffer r4, OutputStream r5) {
        long r0 = c;
        if (r0 >= 0) goto L5;
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(f5021b, r5) == false) goto L17;
        WritableByteChannel r2 = null;
        r2 = (WritableByteChannel) ZeusTransformUtils.preCheckCast(bx.f(r5, r0), WritableByteChannel.class, "com.obric.memorydata.plugin");     // Catch: ClassCastException -> L14
    L9:
        if (r2 == null) goto L18;
        r2.write(r4);
        return true;
    L18:
        return false;
    L17:
        return false;
    }
}
