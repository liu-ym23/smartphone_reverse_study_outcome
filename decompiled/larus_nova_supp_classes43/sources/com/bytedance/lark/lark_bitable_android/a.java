package com.bytedance.lark.lark_bitable_android;

import com.byted.mgl.merge.service.api.share.BdpShareBaseInfo;
import com.squareup.wire.ProtoAdapter;
import com.sun.jna.Pointer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import lark_bitable.proto.BaseAppPreloadResource;
import lark_bitable.proto.FuncParamsX91480d6c2b131397;
import lark_bitable.proto.FuncParamsX9f8d1b152bb4e31a;
import lark_bitable.proto.FuncReturnX33a71d6df1fbb730;
import lark_bitable.proto.FuncReturnX3dc8b8542df1cbb1;
import lark_bitable.proto.FuncReturnX4902fca7340b87a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends v0 {
    @Override // com.bytedance.lark.lark_bitable_android.v0
    public final void b() {
        s r0 = s.a;
        NativeLib.Companion.getClass();
        BufferCallStatus.ByValue r1 = NativeLib.Companion.a().molten_ffi_lark_bitable_free(NativeLib.Companion.b(), this.a, -6991664015755706368L);
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

    public a(long r12) {
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
        BufferCallStatus.ByValue r18 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), new Pointer(0), 8046985455139338548L, r15);
        int r19 = r18.code;
        if (r19 != 0) goto L11;
        RustBuffer.ByValue r110 = r18.data;
        ProtoAdapter r111 = FuncReturnX4902fca7340b87a0.ADAPTER;
        RustBuffer.Companion.getClass();
        Long r112 = ((FuncReturnX4902fca7340b87a0) r111.decode(RustBuffer.a.b(r110))).ret;
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

    public final b c(String r12) {
        Intrinsics.checkNotNullParameter(r12, BdpShareBaseInfo.CHANNEL_TOKEN);
    L3:
        long r0 = this.c.get();
        if (r0 == 0) goto L53;
        if (r0 == Long.MAX_VALUE) goto L51;
        if (this.c.compareAndSet(r0, 1 + r0) == false) goto L3;
        Pointer r10 = this.a;     // Catch: Throwable -> L12
        s r1 = s.a;     // Catch: Throwable -> L12
        NativeLib.Companion r11 = NativeLib.Companion;     // Catch: Throwable -> L12
        m0 r13 = new m0(Long.valueOf(Pointer.nativeValue(r10)), "getClientVarsResource");     // Catch: Throwable -> L12
        r11.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r13, "info");     // Catch: Throwable -> L12
        String r14 = null;
        FuncParamsX9f8d1b152bb4e31a r15 = new FuncParamsX9f8d1b152bb4e31a(r12, null);     // Catch: Throwable -> L12
        int r16 = FuncParamsX9f8d1b152bb4e31a.ADAPTER.encodedSize(r15);     // Catch: Throwable -> L12
        if (r16 <= 0) goto L14;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        RustBuffer.ByValue r17 = RustBuffer.a.a(r16);     // Catch: Throwable -> L12
        Pointer r18 = r17.data;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L12
        o0 r19 = new o0(r18);     // Catch: Throwable -> L12
        r15.encode(r19);     // Catch: Throwable -> L12
        r19.close();     // Catch: Throwable -> L12
    L15:
        BufferCallStatus.ByValue r110 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r10, 5017490067820440923L, r17);     // Catch: Throwable -> L12
        int r20 = r110.code;     // Catch: Throwable -> L12
        if (r20 != 0) goto L23;
        RustBuffer.ByValue r111 = r110.data;     // Catch: Throwable -> L12
        ProtoAdapter r21 = FuncReturnX33a71d6df1fbb730.ADAPTER;     // Catch: Throwable -> L12
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        BaseAppPreloadResource r112 = ((FuncReturnX33a71d6df1fbb730) r21.decode(RustBuffer.a.b(r111))).ret;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L12
        b r113 = n0.a(r112);     // Catch: Throwable -> L12
        if (this.c.decrementAndGet() != 0) goto L21;
        b();
    L21:
        return r113;
    L23:
        if (r20 == 1) goto L45;
        if (r20 != 2) goto L42;
        RustBuffer.ByValue r22 = r110.data;     // Catch: Throwable -> L12
        int r23 = r22.len;     // Catch: Throwable -> L12
        if (r23 > 0) goto L55;
        UnhandledException r114 = new UnhandledException("Rust panic");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r114, "e");     // Catch: Throwable -> L12
        throw r114;     // Catch: Throwable -> L12
    L55:
        Pointer r24 = r22.data;     // Catch: Throwable -> L37
        if (r24 == null) goto L31;
        byte[] r25 = r24.getByteArray(0, r23);     // Catch: Throwable -> L37
    L32:
        if (r25 == null) goto L34;
        r14 = new String(r25, Charsets.UTF_8);     // Catch: Throwable -> L37
    L34:
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L37
        RustBuffer.a r26 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r115 = r110.data;     // Catch: Throwable -> L12
        r26.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r115);     // Catch: Throwable -> L12
        UnhandledException r116 = new UnhandledException(r14);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r116, "e");     // Catch: Throwable -> L12
        throw r116;     // Catch: Throwable -> L12
    L31:
        r25 = null;
    L37:
        th = move-exception;
        RustBuffer.a r27 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r117 = r110.data;     // Catch: Throwable -> L12
        r27.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r117);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L42:
        UnhandledException r28 = new UnhandledException("Unknown rust call status: " + r110 + ".code");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r28, "e");     // Catch: Throwable -> L12
        throw r28;     // Catch: Throwable -> L12
    L45:
        throw ((Throwable) r1.a(r110.data));     // Catch: Throwable -> L12
    L14:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        r17 = RustBuffer.a.a(0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.c.decrementAndGet() != 0) goto L49;
        b();
    L49:
        throw th;
    L51:
        throw new IllegalStateException(a.class.getSimpleName().concat(" call counter would overflow"));
    L53:
        throw new IllegalStateException(a.class.getSimpleName().concat(" object has already been destroyed"));
    }

    public final boolean d(String r12) {
        Intrinsics.checkNotNullParameter(r12, BdpShareBaseInfo.CHANNEL_TOKEN);
    L3:
        long r0 = this.c.get();
        if (r0 == 0) goto L54;
        if (r0 == Long.MAX_VALUE) goto L52;
        if (this.c.compareAndSet(r0, 1 + r0) == false) goto L3;
        Pointer r10 = this.a;     // Catch: Throwable -> L12
        s r1 = s.a;     // Catch: Throwable -> L12
        NativeLib.Companion r11 = NativeLib.Companion;     // Catch: Throwable -> L12
        m0 r13 = new m0(Long.valueOf(Pointer.nativeValue(r10)), "preloadClientVars");     // Catch: Throwable -> L12
        r11.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r13, "info");     // Catch: Throwable -> L12
        String r14 = null;
        FuncParamsX9f8d1b152bb4e31a r15 = new FuncParamsX9f8d1b152bb4e31a(r12, null);     // Catch: Throwable -> L12
        int r16 = FuncParamsX9f8d1b152bb4e31a.ADAPTER.encodedSize(r15);     // Catch: Throwable -> L12
        if (r16 <= 0) goto L14;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        RustBuffer.ByValue r17 = RustBuffer.a.a(r16);     // Catch: Throwable -> L12
        Pointer r18 = r17.data;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L12
        o0 r19 = new o0(r18);     // Catch: Throwable -> L12
        r15.encode(r19);     // Catch: Throwable -> L12
        r19.close();     // Catch: Throwable -> L12
    L15:
        BufferCallStatus.ByValue r110 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r10, 2955893678125293720L, r17);     // Catch: Throwable -> L12
        int r20 = r110.code;     // Catch: Throwable -> L12
        if (r20 != 0) goto L24;
        RustBuffer.ByValue r111 = r110.data;     // Catch: Throwable -> L12
        ProtoAdapter r21 = FuncReturnX3dc8b8542df1cbb1.ADAPTER;     // Catch: Throwable -> L12
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        Boolean r112 = ((FuncReturnX3dc8b8542df1cbb1) r21.decode(RustBuffer.a.b(r111))).ret;     // Catch: Throwable -> L12
        if (this.c.decrementAndGet() != 0) goto L22;
        b();
    L22:
        return r112.booleanValue();
    L24:
        if (r20 == 1) goto L46;
        if (r20 != 2) goto L43;
        RustBuffer.ByValue r22 = r110.data;     // Catch: Throwable -> L12
        int r23 = r22.len;     // Catch: Throwable -> L12
        if (r23 > 0) goto L56;
        UnhandledException r113 = new UnhandledException("Rust panic");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r113, "e");     // Catch: Throwable -> L12
        throw r113;     // Catch: Throwable -> L12
    L56:
        Pointer r24 = r22.data;     // Catch: Throwable -> L38
        if (r24 == null) goto L32;
        byte[] r25 = r24.getByteArray(0, r23);     // Catch: Throwable -> L38
    L33:
        if (r25 == null) goto L35;
        r14 = new String(r25, Charsets.UTF_8);     // Catch: Throwable -> L38
    L35:
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L38
        RustBuffer.a r26 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r114 = r110.data;     // Catch: Throwable -> L12
        r26.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r114);     // Catch: Throwable -> L12
        UnhandledException r115 = new UnhandledException(r14);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r115, "e");     // Catch: Throwable -> L12
        throw r115;     // Catch: Throwable -> L12
    L32:
        r25 = null;
    L38:
        th = move-exception;
        RustBuffer.a r27 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r116 = r110.data;     // Catch: Throwable -> L12
        r27.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r116);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L43:
        UnhandledException r28 = new UnhandledException("Unknown rust call status: " + r110 + ".code");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r28, "e");     // Catch: Throwable -> L12
        throw r28;     // Catch: Throwable -> L12
    L46:
        throw ((Throwable) r1.a(r110.data));     // Catch: Throwable -> L12
    L14:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        r17 = RustBuffer.a.a(0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.c.decrementAndGet() != 0) goto L50;
        b();
    L50:
        throw th;
    L52:
        throw new IllegalStateException(a.class.getSimpleName().concat(" call counter would overflow"));
    L54:
        throw new IllegalStateException(a.class.getSimpleName().concat(" object has already been destroyed"));
    }

    public final boolean e(String r12) {
        Intrinsics.checkNotNullParameter(r12, BdpShareBaseInfo.CHANNEL_TOKEN);
    L3:
        long r0 = this.c.get();
        if (r0 == 0) goto L54;
        if (r0 == Long.MAX_VALUE) goto L52;
        if (this.c.compareAndSet(r0, 1 + r0) == false) goto L3;
        Pointer r10 = this.a;     // Catch: Throwable -> L12
        s r1 = s.a;     // Catch: Throwable -> L12
        NativeLib.Companion r11 = NativeLib.Companion;     // Catch: Throwable -> L12
        m0 r13 = new m0(Long.valueOf(Pointer.nativeValue(r10)), "refreshClientVars");     // Catch: Throwable -> L12
        r11.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r13, "info");     // Catch: Throwable -> L12
        String r14 = null;
        FuncParamsX9f8d1b152bb4e31a r15 = new FuncParamsX9f8d1b152bb4e31a(r12, null);     // Catch: Throwable -> L12
        int r16 = FuncParamsX9f8d1b152bb4e31a.ADAPTER.encodedSize(r15);     // Catch: Throwable -> L12
        if (r16 <= 0) goto L14;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        RustBuffer.ByValue r17 = RustBuffer.a.a(r16);     // Catch: Throwable -> L12
        Pointer r18 = r17.data;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L12
        o0 r19 = new o0(r18);     // Catch: Throwable -> L12
        r15.encode(r19);     // Catch: Throwable -> L12
        r19.close();     // Catch: Throwable -> L12
    L15:
        BufferCallStatus.ByValue r110 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r10, 8668005963384168600L, r17);     // Catch: Throwable -> L12
        int r20 = r110.code;     // Catch: Throwable -> L12
        if (r20 != 0) goto L24;
        RustBuffer.ByValue r111 = r110.data;     // Catch: Throwable -> L12
        ProtoAdapter r21 = FuncReturnX3dc8b8542df1cbb1.ADAPTER;     // Catch: Throwable -> L12
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        Boolean r112 = ((FuncReturnX3dc8b8542df1cbb1) r21.decode(RustBuffer.a.b(r111))).ret;     // Catch: Throwable -> L12
        if (this.c.decrementAndGet() != 0) goto L22;
        b();
    L22:
        return r112.booleanValue();
    L24:
        if (r20 == 1) goto L46;
        if (r20 != 2) goto L43;
        RustBuffer.ByValue r22 = r110.data;     // Catch: Throwable -> L12
        int r23 = r22.len;     // Catch: Throwable -> L12
        if (r23 > 0) goto L56;
        UnhandledException r113 = new UnhandledException("Rust panic");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r113, "e");     // Catch: Throwable -> L12
        throw r113;     // Catch: Throwable -> L12
    L56:
        Pointer r24 = r22.data;     // Catch: Throwable -> L38
        if (r24 == null) goto L32;
        byte[] r25 = r24.getByteArray(0, r23);     // Catch: Throwable -> L38
    L33:
        if (r25 == null) goto L35;
        r14 = new String(r25, Charsets.UTF_8);     // Catch: Throwable -> L38
    L35:
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L38
        RustBuffer.a r26 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r114 = r110.data;     // Catch: Throwable -> L12
        r26.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r114);     // Catch: Throwable -> L12
        UnhandledException r115 = new UnhandledException(r14);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r115, "e");     // Catch: Throwable -> L12
        throw r115;     // Catch: Throwable -> L12
    L32:
        r25 = null;
    L38:
        th = move-exception;
        RustBuffer.a r27 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r116 = r110.data;     // Catch: Throwable -> L12
        r27.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r116);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L43:
        UnhandledException r28 = new UnhandledException("Unknown rust call status: " + r110 + ".code");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r28, "e");     // Catch: Throwable -> L12
        throw r28;     // Catch: Throwable -> L12
    L46:
        throw ((Throwable) r1.a(r110.data));     // Catch: Throwable -> L12
    L14:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        r17 = RustBuffer.a.a(0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.c.decrementAndGet() != 0) goto L50;
        b();
    L50:
        throw th;
    L52:
        throw new IllegalStateException(a.class.getSimpleName().concat(" call counter would overflow"));
    L54:
        throw new IllegalStateException(a.class.getSimpleName().concat(" object has already been destroyed"));
    }
}
