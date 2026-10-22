package com.bytedance.cypressencoder;

import android.hardware.HardwareBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class CypressEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2234a;

    static {
        System.loadLibrary("bytevc1enc");     // Catch: UnsatisfiedLinkError -> L4
        System.loadLibrary("ttheif_enc");     // Catch: UnsatisfiedLinkError -> L4
        System.loadLibrary("cypressencoder_jni");     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private CypressEncoder() {
        this.f2234a = native_create_encoder();
    }

    public static CypressEncoder a() {
        return new CypressEncoder();
    }

    private static native void native_close_encoder(long r0);

    private static native long native_create_encoder();

    private static native int native_encode_hardware_buffer(long r0, HardwareBuffer r2, String r3, String r4, int r5, int r6, int r7, boolean r8, boolean r9);

    public int a(HardwareBuffer r11, String r12, String r13, int r14, int r15, int r16, boolean r17, boolean r18) {
        return native_encode_hardware_buffer(this.f2234a, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public void b() {
        long r0 = this.f2234a;
        if (r0 == 0) goto L6;
        native_close_encoder(r0);
        this.f2234a = 0;
        return;
    }

    public void finalize() {
        b();     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }
}
