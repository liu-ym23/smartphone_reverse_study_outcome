package com.bytedance.lark.lark_bitable_android;

import com.squareup.wire.ProtoAdapter;
import com.sun.jna.Pointer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import lark_bitable.proto.BitableAppInfo;
import lark_bitable.proto.FuncParamsX0919def174cd15cf;
import lark_bitable.proto.FuncParamsX735c0b6edd8b4c21;
import lark_bitable.proto.FuncParamsX91480d6c2b131397;
import lark_bitable.proto.FuncParamsXd8dd816b01b0dcf8;
import lark_bitable.proto.FuncReturnX02b10f3fefdb0630;
import lark_bitable.proto.FuncReturnX3ee2f825fb43f301;
import lark_bitable.proto.MoltenFfiInstanceMsg;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends v0 {
    @Override // com.bytedance.lark.lark_bitable_android.v0
    public final void b() {
        s r0 = s.a;
        NativeLib.Companion.getClass();
        BufferCallStatus.ByValue r1 = NativeLib.Companion.a().molten_ffi_lark_bitable_free(NativeLib.Companion.b(), this.a, -2046112081828118528L);
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

    public c(long r12) {
        s r0 = s.a;
        NativeLib.Companion r1 = NativeLib.Companion;
        String r10 = null;
        m0 r11 = new m0(null, "new");
        r1.getClass();
        Intrinsics.checkNotNullParameter(r11, "info");
        FuncParamsX91480d6c2b131397 r13 = new FuncParamsX91480d6c2b131397(Long.valueOf(r12), null);
        int r14 = FuncParamsX91480d6c2b131397.ADAPTER.encodedSize(r13);
        if (r14 <= 0) goto L5;
        RustBuffer.Companion.getClass();
        RustBuffer.ByValue r15 = RustBuffer.a.a(r14);
        Pointer r16 = r15.data;
        Intrinsics.checkNotNull(r16);
        o0 r17 = new o0(r16);
        r13.encode(r17);
        r17.close();
    L6:
        BufferCallStatus.ByValue r18 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), new Pointer(0), -1135566063453815344L, r15);
        int r19 = r18.code;
        if (r19 != 0) goto L11;
        RustBuffer.ByValue r110 = r18.data;
        ProtoAdapter r111 = FuncReturnX02b10f3fefdb0630.ADAPTER;
        RustBuffer.Companion.getClass();
        Long r112 = ((FuncReturnX02b10f3fefdb0630) r111.decode(RustBuffer.a.b(r110))).ret;
        Intrinsics.checkNotNull(r112);
        Pointer r113 = new Pointer(r112.longValue());
        Intrinsics.checkNotNullParameter(r113, "pointer");
        super(r113);
        return;
    L11:
        if (r19 == 1) goto L33;
        if (r19 != 2) goto L30;
        RustBuffer.ByValue r20 = r18.data;
        int r21 = r20.len;
        if (r21 > 0) goto L34;
        UnhandledException r114 = new UnhandledException("Rust panic");
        Intrinsics.checkNotNullParameter(r114, "e");
        throw r114;
    L34:
        Pointer r22 = r20.data;     // Catch: Throwable -> L25
        if (r22 == null) goto L19;
        byte[] r115 = r22.getByteArray(0, r21);     // Catch: Throwable -> L25
    L20:
        if (r115 == null) goto L22;
        r10 = new String(r115, Charsets.UTF_8);     // Catch: Throwable -> L25
    L22:
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L25
        RustBuffer.a r116 = RustBuffer.Companion;
        RustBuffer.ByValue r117 = r18.data;
        r116.getClass();
        RustBuffer.a.c(r117);
        UnhandledException r118 = new UnhandledException(r10);
        Intrinsics.checkNotNullParameter(r118, "e");
        throw r118;
    L19:
        r115 = null;
    L25:
        th = move-exception;
        RustBuffer.a r119 = RustBuffer.Companion;
        RustBuffer.ByValue r23 = r18.data;
        r119.getClass();
        RustBuffer.a.c(r23);
        throw th;
    L30:
        UnhandledException r120 = new UnhandledException("Unknown rust call status: " + r18 + ".code");
        Intrinsics.checkNotNullParameter(r120, "e");
        throw r120;
    L33:
        throw ((Throwable) r0.a(r18.data));
    L5:
        RustBuffer.Companion.getClass();
        r15 = RustBuffer.a.a(0);
        goto L6
    }

    public final f e(String r12) {
        Intrinsics.checkNotNullParameter(r12, "objToken");
    L3:
        long r0 = this.c.get();
        if (r0 == 0) goto L55;
        if (r0 == Long.MAX_VALUE) goto L53;
        if (this.c.compareAndSet(r0, 1 + r0) == false) goto L3;
        Pointer r10 = this.a;     // Catch: Throwable -> L12
        s r1 = s.a;     // Catch: Throwable -> L12
        NativeLib.Companion r11 = NativeLib.Companion;     // Catch: Throwable -> L12
        m0 r13 = new m0(Long.valueOf(Pointer.nativeValue(r10)), "syncGetBitableFileAppInfo");     // Catch: Throwable -> L12
        r11.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r13, "info");     // Catch: Throwable -> L12
        String r14 = null;
        f r15 = null;
        FuncParamsX735c0b6edd8b4c21 r16 = new FuncParamsX735c0b6edd8b4c21(r12, null);     // Catch: Throwable -> L12
        int r17 = FuncParamsX735c0b6edd8b4c21.ADAPTER.encodedSize(r16);     // Catch: Throwable -> L12
        if (r17 <= 0) goto L14;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        RustBuffer.ByValue r18 = RustBuffer.a.a(r17);     // Catch: Throwable -> L12
        Pointer r19 = r18.data;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r19);     // Catch: Throwable -> L12
        o0 r20 = new o0(r19);     // Catch: Throwable -> L12
        r16.encode(r20);     // Catch: Throwable -> L12
        r20.close();     // Catch: Throwable -> L12
    L15:
        BufferCallStatus.ByValue r110 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r10, -1579823007477585050L, r18);     // Catch: Throwable -> L12
        int r21 = r110.code;     // Catch: Throwable -> L12
        if (r21 != 0) goto L25;
        RustBuffer.ByValue r111 = r110.data;     // Catch: Throwable -> L12
        ProtoAdapter r22 = FuncReturnX3ee2f825fb43f301.ADAPTER;     // Catch: Throwable -> L12
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        BitableAppInfo r112 = ((FuncReturnX3ee2f825fb43f301) r22.decode(RustBuffer.a.b(r111))).ret;     // Catch: Throwable -> L12
        if (r112 == null) goto L21;
        Intrinsics.checkNotNullParameter(r112, "<this>");     // Catch: Throwable -> L12
        r15 = new f(r112.biz_type.intValue());     // Catch: Throwable -> L12
    L21:
        if (this.c.decrementAndGet() != 0) goto L23;
        b();
    L23:
        return r15;
    L25:
        if (r21 == 1) goto L47;
        if (r21 != 2) goto L44;
        RustBuffer.ByValue r23 = r110.data;     // Catch: Throwable -> L12
        int r24 = r23.len;     // Catch: Throwable -> L12
        if (r24 > 0) goto L56;
        UnhandledException r113 = new UnhandledException("Rust panic");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r113, "e");     // Catch: Throwable -> L12
        throw r113;     // Catch: Throwable -> L12
    L56:
        Pointer r25 = r23.data;     // Catch: Throwable -> L39
        if (r25 == null) goto L33;
        byte[] r26 = r25.getByteArray(0, r24);     // Catch: Throwable -> L39
    L34:
        if (r26 == null) goto L36;
        r14 = new String(r26, Charsets.UTF_8);     // Catch: Throwable -> L39
    L36:
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L39
        RustBuffer.a r27 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r114 = r110.data;     // Catch: Throwable -> L12
        r27.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r114);     // Catch: Throwable -> L12
        UnhandledException r115 = new UnhandledException(r14);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r115, "e");     // Catch: Throwable -> L12
        throw r115;     // Catch: Throwable -> L12
    L33:
        r26 = null;
    L39:
        th = move-exception;
        RustBuffer.a r28 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r116 = r110.data;     // Catch: Throwable -> L12
        r28.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r116);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L44:
        UnhandledException r29 = new UnhandledException("Unknown rust call status: " + r110 + ".code");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r29, "e");     // Catch: Throwable -> L12
        throw r29;     // Catch: Throwable -> L12
    L47:
        throw ((Throwable) r1.a(r110.data));     // Catch: Throwable -> L12
    L14:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        r18 = RustBuffer.a.a(0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.c.decrementAndGet() != 0) goto L51;
        b();
    L51:
        throw th;
    L53:
        throw new IllegalStateException(c.class.getSimpleName().concat(" call counter would overflow"));
    L55:
        throw new IllegalStateException(c.class.getSimpleName().concat(" object has already been destroyed"));
    }

    public final void c(String r12, d r13) {
        Intrinsics.checkNotNullParameter(r12, "objToken");
        Intrinsics.checkNotNullParameter(r13, "callback");
    L3:
        long r1 = this.c.get();
        if (r1 == 0) goto L52;
        if (r1 == Long.MAX_VALUE) goto L50;
        if (this.c.compareAndSet(r1, 1 + r1) == false) goto L3;
        Pointer r10 = this.a;     // Catch: Throwable -> L12
        s r11 = s.a;     // Catch: Throwable -> L12
        NativeLib.Companion r14 = NativeLib.Companion;     // Catch: Throwable -> L12
        m0 r15 = new m0(Long.valueOf(Pointer.nativeValue(r10)), "getBitableFileAppInfo");     // Catch: Throwable -> L12
        r14.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r15, "info");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r13, "<this>");     // Catch: Throwable -> L12
        int r16 = e.b;     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r13, "callback");     // Catch: Throwable -> L12
        MoltenFfiInstanceMsg r17 = new MoltenFfiInstanceMsg(-876549123528342152L, Long.valueOf(r.a.a(new e(r13))));     // Catch: Throwable -> L12
        String r0 = null;
        FuncParamsXd8dd816b01b0dcf8 r18 = new FuncParamsXd8dd816b01b0dcf8(r12, r17, null);     // Catch: Throwable -> L12
        int r19 = FuncParamsXd8dd816b01b0dcf8.ADAPTER.encodedSize(r18);     // Catch: Throwable -> L12
        if (r19 <= 0) goto L14;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        RustBuffer.ByValue r110 = RustBuffer.a.a(r19);     // Catch: Throwable -> L12
        Pointer r20 = r110.data;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r20);     // Catch: Throwable -> L12
        o0 r111 = new o0(r20);     // Catch: Throwable -> L12
        r18.encode(r111);     // Catch: Throwable -> L12
        r111.close();     // Catch: Throwable -> L12
    L15:
        BufferCallStatus.ByValue r112 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r10, -2172562417879262885L, r110);     // Catch: Throwable -> L12
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
        int r21 = r114.len;     // Catch: Throwable -> L12
        if (r21 > 0) goto L54;
        UnhandledException r115 = new UnhandledException("Rust panic");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r115, "e");     // Catch: Throwable -> L12
        throw r115;     // Catch: Throwable -> L12
    L54:
        Pointer r116 = r114.data;     // Catch: Throwable -> L36
        if (r116 == null) goto L30;
        byte[] r117 = r116.getByteArray(0, r21);     // Catch: Throwable -> L36
    L31:
        if (r117 == null) goto L33;
        r0 = new String(r117, Charsets.UTF_8);     // Catch: Throwable -> L36
    L33:
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L36
        RustBuffer.a r118 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r119 = r112.data;     // Catch: Throwable -> L12
        r118.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r119);     // Catch: Throwable -> L12
        UnhandledException r120 = new UnhandledException(r0);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r120, "e");     // Catch: Throwable -> L12
        throw r120;     // Catch: Throwable -> L12
    L30:
        r117 = null;
    L36:
        th = move-exception;
        RustBuffer.a r22 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r121 = r112.data;     // Catch: Throwable -> L12
        r22.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r121);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L41:
        UnhandledException r122 = new UnhandledException("Unknown rust call status: " + r112 + ".code");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r122, "e");     // Catch: Throwable -> L12
        throw r122;     // Catch: Throwable -> L12
    L44:
        throw ((Throwable) r11.a(r112.data));     // Catch: Throwable -> L12
    L14:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        r110 = RustBuffer.a.a(0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.c.decrementAndGet() != 0) goto L48;
        b();
    L48:
        throw th;
    L50:
        throw new IllegalStateException(c.class.getSimpleName().concat(" call counter would overflow"));
    L52:
        throw new IllegalStateException(c.class.getSimpleName().concat(" object has already been destroyed"));
    }

    public final void d(Map r12, us4.p r13) {
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
    L3:
        long r1 = this.c.get();
        if (r1 == 0) goto L52;
        if (r1 == Long.MAX_VALUE) goto L50;
        if (this.c.compareAndSet(r1, 1 + r1) == false) goto L3;
        Pointer r10 = this.a;     // Catch: Throwable -> L12
        s r11 = s.a;     // Catch: Throwable -> L12
        NativeLib.Companion r14 = NativeLib.Companion;     // Catch: Throwable -> L12
        m0 r15 = new m0(Long.valueOf(Pointer.nativeValue(r10)), "installMarketplace");     // Catch: Throwable -> L12
        r14.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r15, "info");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r13, "<this>");     // Catch: Throwable -> L12
        int r16 = h.b;     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r13, "callback");     // Catch: Throwable -> L12
        MoltenFfiInstanceMsg r17 = new MoltenFfiInstanceMsg(8963129345433976530L, Long.valueOf(r.a.a(new h(r13))));     // Catch: Throwable -> L12
        String r0 = null;
        FuncParamsX0919def174cd15cf r18 = new FuncParamsX0919def174cd15cf(r12, r17, null);     // Catch: Throwable -> L12
        int r19 = FuncParamsX0919def174cd15cf.ADAPTER.encodedSize(r18);     // Catch: Throwable -> L12
        if (r19 <= 0) goto L14;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        RustBuffer.ByValue r110 = RustBuffer.a.a(r19);     // Catch: Throwable -> L12
        Pointer r20 = r110.data;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r20);     // Catch: Throwable -> L12
        o0 r111 = new o0(r20);     // Catch: Throwable -> L12
        r18.encode(r111);     // Catch: Throwable -> L12
        r111.close();     // Catch: Throwable -> L12
    L15:
        BufferCallStatus.ByValue r112 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r10, -5857373161027489064L, r110);     // Catch: Throwable -> L12
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
        int r21 = r114.len;     // Catch: Throwable -> L12
        if (r21 > 0) goto L54;
        UnhandledException r115 = new UnhandledException("Rust panic");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r115, "e");     // Catch: Throwable -> L12
        throw r115;     // Catch: Throwable -> L12
    L54:
        Pointer r116 = r114.data;     // Catch: Throwable -> L36
        if (r116 == null) goto L30;
        byte[] r117 = r116.getByteArray(0, r21);     // Catch: Throwable -> L36
    L31:
        if (r117 == null) goto L33;
        r0 = new String(r117, Charsets.UTF_8);     // Catch: Throwable -> L36
    L33:
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L36
        RustBuffer.a r118 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r119 = r112.data;     // Catch: Throwable -> L12
        r118.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r119);     // Catch: Throwable -> L12
        UnhandledException r120 = new UnhandledException(r0);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r120, "e");     // Catch: Throwable -> L12
        throw r120;     // Catch: Throwable -> L12
    L30:
        r117 = null;
    L36:
        th = move-exception;
        RustBuffer.a r22 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r121 = r112.data;     // Catch: Throwable -> L12
        r22.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r121);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L41:
        UnhandledException r122 = new UnhandledException("Unknown rust call status: " + r112 + ".code");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r122, "e");     // Catch: Throwable -> L12
        throw r122;     // Catch: Throwable -> L12
    L44:
        throw ((Throwable) r11.a(r112.data));     // Catch: Throwable -> L12
    L14:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        r110 = RustBuffer.a.a(0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.c.decrementAndGet() != 0) goto L48;
        b();
    L48:
        throw th;
    L50:
        throw new IllegalStateException(c.class.getSimpleName().concat(" call counter would overflow"));
    L52:
        throw new IllegalStateException(c.class.getSimpleName().concat(" object has already been destroyed"));
    }
}
