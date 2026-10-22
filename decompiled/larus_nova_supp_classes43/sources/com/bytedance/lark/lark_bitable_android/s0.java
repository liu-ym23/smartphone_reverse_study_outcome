package com.bytedance.lark.lark_bitable_android;

import com.byted.mgl.merge.service.api.share.BdpShareBaseInfo;
import com.squareup.wire.ProtoAdapter;
import com.sun.jna.Pointer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import lark_bitable.proto.ForegroundUserContainerScope;
import lark_bitable.proto.FuncParamsX0aae7bf6900be3c2;
import lark_bitable.proto.FuncParamsX4567d0cab517d6e9;
import lark_bitable.proto.FuncReturnXf2b5d7aa56b099c1;
import lark_bitable.proto.MoltenFfiInstanceMsg;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s0 extends v0 {
    @Override // com.bytedance.lark.lark_bitable_android.v0
    public final void b() {
        s r0 = s.a;
        NativeLib.Companion.getClass();
        BufferCallStatus.ByValue r1 = NativeLib.Companion.a().molten_ffi_lark_bitable_free(NativeLib.Companion.b(), this.a, -2866632052919238656L);
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

    public s0(w r13, long r14) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter("", "containerId");
        p0 r0 = p0.a;
        NativeLib.Companion r10 = NativeLib.Companion;
        String r11 = null;
        m0 r12 = new m0(null, "new");
        r10.getClass();
        Intrinsics.checkNotNullParameter(r12, "info");
        FuncParamsX0aae7bf6900be3c2 r15 = new FuncParamsX0aae7bf6900be3c2(new ForegroundUserContainerScope(Long.valueOf(r13.a)), "", Long.valueOf(r14), null);
        int r16 = FuncParamsX0aae7bf6900be3c2.ADAPTER.encodedSize(r15);
        if (r16 <= 0) goto L5;
        RustBuffer.Companion.getClass();
        RustBuffer.ByValue r17 = RustBuffer.a.a(r16);
        Pointer r18 = r17.data;
        Intrinsics.checkNotNull(r18);
        o0 r19 = new o0(r18);
        r15.encode(r19);
        r19.close();
    L6:
        BufferCallStatus.ByValue r110 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), new Pointer(0), -9015146718729507917L, r17);
        int r1 = r110.code;
        if (r1 != 0) goto L11;
        RustBuffer.ByValue r111 = r110.data;
        ProtoAdapter r112 = FuncReturnXf2b5d7aa56b099c1.ADAPTER;
        RustBuffer.Companion.getClass();
        Long r113 = ((FuncReturnXf2b5d7aa56b099c1) r112.decode(RustBuffer.a.b(r111))).ret;
        Intrinsics.checkNotNull(r113);
        Pointer r114 = new Pointer(r113.longValue());
        Intrinsics.checkNotNullParameter(r114, "pointer");
        super(r114);
        return;
    L11:
        if (r1 == 1) goto L33;
        if (r1 != 2) goto L30;
        RustBuffer.ByValue r20 = r110.data;
        int r21 = r20.len;
        if (r21 > 0) goto L34;
        s r115 = s.a;
        UnhandledException r116 = new UnhandledException("Rust panic");
        Intrinsics.checkNotNullParameter(r116, "e");
        throw r116;
    L34:
        Pointer r22 = r20.data;     // Catch: Throwable -> L25
        if (r22 == null) goto L19;
        byte[] r117 = r22.getByteArray(0, r21);     // Catch: Throwable -> L25
    L20:
        if (r117 == null) goto L22;
        r11 = new String(r117, Charsets.UTF_8);     // Catch: Throwable -> L25
    L22:
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L25
        RustBuffer.a r118 = RustBuffer.Companion;
        RustBuffer.ByValue r119 = r110.data;
        r118.getClass();
        RustBuffer.a.c(r119);
        s r120 = s.a;
        UnhandledException r121 = new UnhandledException(r11);
        Intrinsics.checkNotNullParameter(r121, "e");
        throw r121;
    L19:
        r117 = null;
    L25:
        th = move-exception;
        RustBuffer.a r122 = RustBuffer.Companion;
        RustBuffer.ByValue r123 = r110.data;
        r122.getClass();
        RustBuffer.a.c(r123);
        throw th;
    L30:
        s r124 = s.a;
        UnhandledException r125 = new UnhandledException("Unknown rust call status: " + r110 + ".code");
        Intrinsics.checkNotNullParameter(r125, "e");
        throw r125;
    L33:
        throw ((Throwable) r0.a(r110.data));
    L5:
        RustBuffer.Companion.getClass();
        r17 = RustBuffer.a.a(0);
        goto L6
    }

    public final void c(String r12, RecordPermission r13, yo4.a r14) {
        Intrinsics.checkNotNullParameter(r12, BdpShareBaseInfo.CHANNEL_TOKEN);
        Intrinsics.checkNotNullParameter(r14, "callback");
    L3:
        long r1 = this.c.get();
        if (r1 == 0) goto L56;
        if (r1 == Long.MAX_VALUE) goto L54;
        if (this.c.compareAndSet(r1, 1 + r1) == false) goto L3;
        Pointer r10 = this.a;     // Catch: Throwable -> L16
        s r11 = s.a;     // Catch: Throwable -> L16
        NativeLib.Companion r15 = NativeLib.Companion;     // Catch: Throwable -> L16
        m0 r16 = new m0(Long.valueOf(Pointer.nativeValue(r10)), "getRecordModelDataWithCallback");     // Catch: Throwable -> L16
        r15.getClass();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r16, "info");     // Catch: Throwable -> L16
        String r17 = null;
        if (r13 == null) goto L12;
        lark_bitable.proto.RecordPermission r18 = r13.into();     // Catch: Throwable -> L16
    L13:
        Intrinsics.checkNotNullParameter(r14, "<this>");     // Catch: Throwable -> L16
        int r19 = u0.b;     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r14, "callback");     // Catch: Throwable -> L16
        FuncParamsX4567d0cab517d6e9 r0 = new FuncParamsX4567d0cab517d6e9(r12, r18, new MoltenFfiInstanceMsg(-2069928020615666640L, Long.valueOf(r.a.a(new u0(r14)))), null);     // Catch: Throwable -> L16
        int r110 = FuncParamsX4567d0cab517d6e9.ADAPTER.encodedSize(r0);     // Catch: Throwable -> L16
        if (r110 <= 0) goto L18;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L16
        RustBuffer.ByValue r111 = RustBuffer.a.a(r110);     // Catch: Throwable -> L16
        Pointer r112 = r111.data;     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L16
        o0 r113 = new o0(r112);     // Catch: Throwable -> L16
        r0.encode(r113);     // Catch: Throwable -> L16
        r113.close();     // Catch: Throwable -> L16
    L19:
        BufferCallStatus.ByValue r114 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r10, 541606738920736698L, r111);     // Catch: Throwable -> L16
        int r115 = r114.code;     // Catch: Throwable -> L16
        if (r115 != 0) goto L26;
        if (this.c.decrementAndGet() != 0) goto L63;
        b();
        return;
    L63:
        return;
    L26:
        if (r115 == 1) goto L48;
        if (r115 != 2) goto L45;
        RustBuffer.ByValue r116 = r114.data;     // Catch: Throwable -> L16
        int r117 = r116.len;     // Catch: Throwable -> L16
        if (r117 > 0) goto L57;
        UnhandledException r118 = new UnhandledException("Rust panic");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r118, "e");     // Catch: Throwable -> L16
        throw r118;     // Catch: Throwable -> L16
    L57:
        Pointer r119 = r116.data;     // Catch: Throwable -> L40
        if (r119 == null) goto L34;
        byte[] r120 = r119.getByteArray(0, r117);     // Catch: Throwable -> L40
    L35:
        if (r120 == null) goto L37;
        r17 = new String(r120, Charsets.UTF_8);     // Catch: Throwable -> L40
    L37:
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L40
        RustBuffer.a r121 = RustBuffer.Companion;     // Catch: Throwable -> L16
        RustBuffer.ByValue r122 = r114.data;     // Catch: Throwable -> L16
        r121.getClass();     // Catch: Throwable -> L16
        RustBuffer.a.c(r122);     // Catch: Throwable -> L16
        UnhandledException r123 = new UnhandledException(r17);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r123, "e");     // Catch: Throwable -> L16
        throw r123;     // Catch: Throwable -> L16
    L34:
        r120 = null;
    L40:
        th = move-exception;
        RustBuffer.a r124 = RustBuffer.Companion;     // Catch: Throwable -> L16
        RustBuffer.ByValue r125 = r114.data;     // Catch: Throwable -> L16
        r124.getClass();     // Catch: Throwable -> L16
        RustBuffer.a.c(r125);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L45:
        UnhandledException r126 = new UnhandledException("Unknown rust call status: " + r114 + ".code");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r126, "e");     // Catch: Throwable -> L16
        throw r126;     // Catch: Throwable -> L16
    L48:
        throw ((Throwable) r11.a(r114.data));     // Catch: Throwable -> L16
    L18:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L16
        r111 = RustBuffer.a.a(0);     // Catch: Throwable -> L16
        goto L19
    L12:
        r18 = null;
    L16:
        th = move-exception;
        if (this.c.decrementAndGet() != 0) goto L52;
        b();
    L52:
        throw th;
    L54:
        throw new IllegalStateException(s0.class.getSimpleName().concat(" call counter would overflow"));
    L56:
        throw new IllegalStateException(s0.class.getSimpleName().concat(" object has already been destroyed"));
    }
}
