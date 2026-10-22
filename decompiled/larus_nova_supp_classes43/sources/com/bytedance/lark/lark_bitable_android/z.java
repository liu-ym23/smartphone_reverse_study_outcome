package com.bytedance.lark.lark_bitable_android;

import com.squareup.wire.ProtoAdapter;
import com.sun.jna.Pointer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import lark_bitable.proto.FuncParamsX1fe2d26feb43d1a7;
import lark_bitable.proto.FuncParamsXe4bcc2963797d943;
import lark_bitable.proto.FuncReturnX46884442da1f878f;
import lark_bitable.proto.MoltenFfiInstanceMsg;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z extends v0 {
    @Override // com.bytedance.lark.lark_bitable_android.v0
    public final void b() {
        s r0 = s.a;
        NativeLib.Companion.getClass();
        BufferCallStatus.ByValue r1 = NativeLib.Companion.a().molten_ffi_lark_bitable_free(NativeLib.Companion.b(), this.a, 8163606513177329664L);
        int r10 = r1.code;
        if (r10 != 0) goto L6;
        return;
    L6:
        if (r10 == 1) goto L28;
        if (r10 != 2) goto L25;
        RustBuffer.ByValue r11 = r1.data;
        int r12 = r11.len;
        if (r12 > 0) goto L29;
        UnhandledException r13 = new UnhandledException("Rust panic");
        Intrinsics.checkNotNullParameter(r13, "e");
        throw r13;
    L29:
        Pointer r14 = r11.data;     // Catch: Throwable -> L20
        String r15 = null;
        if (r14 == null) goto L14;
        byte[] r16 = r14.getByteArray(0, r12);     // Catch: Throwable -> L20
    L15:
        if (r16 == null) goto L17;
        r15 = new String(r16, Charsets.UTF_8);     // Catch: Throwable -> L20
    L17:
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L20
        RustBuffer.a r17 = RustBuffer.Companion;
        RustBuffer.ByValue r18 = r1.data;
        r17.getClass();
        RustBuffer.a.c(r18);
        UnhandledException r19 = new UnhandledException(r15);
        Intrinsics.checkNotNullParameter(r19, "e");
        throw r19;
    L14:
        r16 = null;
    L20:
        th = move-exception;
        RustBuffer.a r20 = RustBuffer.Companion;
        RustBuffer.ByValue r21 = r1.data;
        r20.getClass();
        RustBuffer.a.c(r21);
        throw th;
    L25:
        UnhandledException r22 = new UnhandledException("Unknown rust call status: " + r1 + ".code");
        Intrinsics.checkNotNullParameter(r22, "e");
        throw r22;
    L28:
        throw ((Throwable) r0.a(r1.data));
    }

    public z(long r13, x r15) {
        Intrinsics.checkNotNullParameter(r15, "callback");
        s r1 = s.a;
        NativeLib.Companion r10 = NativeLib.Companion;
        String r11 = null;
        m0 r12 = new m0(null, "new");
        r10.getClass();
        Intrinsics.checkNotNullParameter(r12, "info");
        Long r14 = Long.valueOf(r13);
        Intrinsics.checkNotNullParameter(r15, "<this>");
        int r16 = y.b;
        Intrinsics.checkNotNullParameter(r15, "callback");
        FuncParamsXe4bcc2963797d943 r17 = new FuncParamsXe4bcc2963797d943(r14, new MoltenFfiInstanceMsg(-201118972098184106L, Long.valueOf(r.a.a(new y(r15)))), null);
        int r18 = FuncParamsXe4bcc2963797d943.ADAPTER.encodedSize(r17);
        if (r18 <= 0) goto L5;
        RustBuffer.Companion.getClass();
        RustBuffer.ByValue r19 = RustBuffer.a.a(r18);
        Pointer r110 = r19.data;
        Intrinsics.checkNotNull(r110);
        o0 r111 = new o0(r110);
        r17.encode(r111);
        r111.close();
    L6:
        BufferCallStatus.ByValue r112 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), new Pointer(0), -6508186168269574418L, r19);
        int r0 = r112.code;
        if (r0 != 0) goto L11;
        RustBuffer.ByValue r113 = r112.data;
        ProtoAdapter r114 = FuncReturnX46884442da1f878f.ADAPTER;
        RustBuffer.Companion.getClass();
        Long r115 = ((FuncReturnX46884442da1f878f) r114.decode(RustBuffer.a.b(r113))).ret;
        Intrinsics.checkNotNull(r115);
        Pointer r116 = new Pointer(r115.longValue());
        Intrinsics.checkNotNullParameter(r116, "pointer");
        super(r116);
        return;
    L11:
        if (r0 == 1) goto L33;
        if (r0 != 2) goto L30;
        RustBuffer.ByValue r20 = r112.data;
        int r21 = r20.len;
        if (r21 > 0) goto L34;
        UnhandledException r117 = new UnhandledException("Rust panic");
        Intrinsics.checkNotNullParameter(r117, "e");
        throw r117;
    L34:
        Pointer r22 = r20.data;     // Catch: Throwable -> L25
        if (r22 == null) goto L19;
        byte[] r118 = r22.getByteArray(0, r21);     // Catch: Throwable -> L25
    L20:
        if (r118 == null) goto L22;
        r11 = new String(r118, Charsets.UTF_8);     // Catch: Throwable -> L25
    L22:
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L25
        RustBuffer.a r119 = RustBuffer.Companion;
        RustBuffer.ByValue r120 = r112.data;
        r119.getClass();
        RustBuffer.a.c(r120);
        UnhandledException r121 = new UnhandledException(r11);
        Intrinsics.checkNotNullParameter(r121, "e");
        throw r121;
    L19:
        r118 = null;
    L25:
        th = move-exception;
        RustBuffer.a r122 = RustBuffer.Companion;
        RustBuffer.ByValue r123 = r112.data;
        r122.getClass();
        RustBuffer.a.c(r123);
        throw th;
    L30:
        UnhandledException r124 = new UnhandledException("Unknown rust call status: " + r112 + ".code");
        Intrinsics.checkNotNullParameter(r124, "e");
        throw r124;
    L33:
        throw ((Throwable) r1.a(r112.data));
    L5:
        RustBuffer.Companion.getClass();
        r19 = RustBuffer.a.a(0);
        goto L6
    }

    public final void delete(String r12, int r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "docToken");
    L3:
        long r0 = this.c.get();
        if (r0 == 0) goto L52;
        if (r0 == Long.MAX_VALUE) goto L50;
        if (this.c.compareAndSet(r0, 1 + r0) == false) goto L3;
        Pointer r10 = this.a;     // Catch: Throwable -> L12
        s r1 = s.a;     // Catch: Throwable -> L12
        NativeLib.Companion r11 = NativeLib.Companion;     // Catch: Throwable -> L12
        m0 r15 = new m0(Long.valueOf(Pointer.nativeValue(r10)), "delete");     // Catch: Throwable -> L12
        r11.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r15, "info");     // Catch: Throwable -> L12
        String r16 = null;
        FuncParamsX1fe2d26feb43d1a7 r17 = new FuncParamsX1fe2d26feb43d1a7(r12, Integer.valueOf(r13), Boolean.valueOf(r14), null);     // Catch: Throwable -> L12
        int r18 = FuncParamsX1fe2d26feb43d1a7.ADAPTER.encodedSize(r17);     // Catch: Throwable -> L12
        if (r18 <= 0) goto L14;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        RustBuffer.ByValue r19 = RustBuffer.a.a(r18);     // Catch: Throwable -> L12
        Pointer r110 = r19.data;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L12
        o0 r111 = new o0(r110);     // Catch: Throwable -> L12
        r17.encode(r111);     // Catch: Throwable -> L12
        r111.close();     // Catch: Throwable -> L12
    L15:
        BufferCallStatus.ByValue r112 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r10, 4590002856525481582L, r19);     // Catch: Throwable -> L12
        int r113 = r112.code;     // Catch: Throwable -> L12
        if (r113 != 0) goto L22;
        if (this.c.decrementAndGet() != 0) goto L59;
        b();
        return;
    L59:
        return;
    L22:
        if (r113 == 1) goto L44;
        if (r113 != 2) goto L41;
        RustBuffer.ByValue r114 = r112.data;     // Catch: Throwable -> L12
        int r115 = r114.len;     // Catch: Throwable -> L12
        if (r115 > 0) goto L54;
        UnhandledException r116 = new UnhandledException("Rust panic");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r116, "e");     // Catch: Throwable -> L12
        throw r116;     // Catch: Throwable -> L12
    L54:
        Pointer r117 = r114.data;     // Catch: Throwable -> L36
        if (r117 == null) goto L30;
        byte[] r118 = r117.getByteArray(0, r115);     // Catch: Throwable -> L36
    L31:
        if (r118 == null) goto L33;
        r16 = new String(r118, Charsets.UTF_8);     // Catch: Throwable -> L36
    L33:
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L36
        RustBuffer.a r119 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r120 = r112.data;     // Catch: Throwable -> L12
        r119.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r120);     // Catch: Throwable -> L12
        UnhandledException r121 = new UnhandledException(r16);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r121, "e");     // Catch: Throwable -> L12
        throw r121;     // Catch: Throwable -> L12
    L30:
        r118 = null;
    L36:
        th = move-exception;
        RustBuffer.a r122 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r123 = r112.data;     // Catch: Throwable -> L12
        r122.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r123);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L41:
        UnhandledException r124 = new UnhandledException("Unknown rust call status: " + r112 + ".code");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r124, "e");     // Catch: Throwable -> L12
        throw r124;     // Catch: Throwable -> L12
    L44:
        throw ((Throwable) r1.a(r112.data));     // Catch: Throwable -> L12
    L14:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        r19 = RustBuffer.a.a(0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.c.decrementAndGet() != 0) goto L48;
        b();
    L48:
        throw th;
    L50:
        throw new IllegalStateException(z.class.getSimpleName().concat(" call counter would overflow"));
    L52:
        throw new IllegalStateException(z.class.getSimpleName().concat(" object has already been destroyed"));
    }
}
