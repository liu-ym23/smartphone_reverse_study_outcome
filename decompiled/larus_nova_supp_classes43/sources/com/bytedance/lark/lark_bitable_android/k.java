package com.bytedance.lark.lark_bitable_android;

import com.byted.mgl.merge.service.api.share.BdpShareBaseInfo;
import com.squareup.wire.ProtoAdapter;
import com.sun.jna.Pointer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import lark_bitable.proto.FuncParamsX22d4957386f22642;
import lark_bitable.proto.FuncParamsX91480d6c2b131397;
import lark_bitable.proto.FuncReturnX50eab1b92d182188;
import lark_bitable.proto.FuncReturnXd9acd5f1550ef3dc;
import lark_bitable.proto.PushBitableLoaderResource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k extends v0 {
    @Override // com.bytedance.lark.lark_bitable_android.v0
    public final void b() {
        s r0 = s.a;
        NativeLib.Companion.getClass();
        BufferCallStatus.ByValue r1 = NativeLib.Companion.a().molten_ffi_lark_bitable_free(NativeLib.Companion.b(), this.a, 5208941301570994176L);
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

    public k(long r12) {
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
        BufferCallStatus.ByValue r18 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), new Pointer(0), -4900181192575547900L, r15);
        int r19 = r18.code;
        if (r19 != 0) goto L11;
        RustBuffer.ByValue r110 = r18.data;
        ProtoAdapter r111 = FuncReturnXd9acd5f1550ef3dc.ADAPTER;
        RustBuffer.Companion.getClass();
        Long r112 = ((FuncReturnXd9acd5f1550ef3dc) r111.decode(RustBuffer.a.b(r110))).ret;
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

    public final r0 c(String r19, BitableDocumentType r20, String r21) {
        Intrinsics.checkNotNullParameter(r19, BdpShareBaseInfo.CHANNEL_TOKEN);
        Intrinsics.checkNotNullParameter(r20, "documentType");
        Intrinsics.checkNotNullParameter(r21, com.bytedance.android.ec.core.event.a.KEY_URL);
    L3:
        long r10 = this.c.get();
        if (r10 == 0) goto L53;
        if (r10 == Long.MAX_VALUE) goto L51;
        if (this.c.compareAndSet(r10, 1 + r10) == false) goto L3;
        Pointer r11 = this.a;     // Catch: Throwable -> L12
        s r12 = s.a;     // Catch: Throwable -> L12
        NativeLib.Companion r13 = NativeLib.Companion;     // Catch: Throwable -> L12
        m0 r14 = new m0(Long.valueOf(Pointer.nativeValue(r11)), "getCacheResource");     // Catch: Throwable -> L12
        r13.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r14, "info");     // Catch: Throwable -> L12
        String r15 = null;
        FuncParamsX22d4957386f22642 r16 = new FuncParamsX22d4957386f22642(r19, r20.into(), r21, null);     // Catch: Throwable -> L12
        int r0 = FuncParamsX22d4957386f22642.ADAPTER.encodedSize(r16);     // Catch: Throwable -> L12
        if (r0 <= 0) goto L14;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        RustBuffer.ByValue r1 = RustBuffer.a.a(r0);     // Catch: Throwable -> L12
        Pointer r17 = r1.data;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L12
        o0 r18 = new o0(r17);     // Catch: Throwable -> L12
        r16.encode(r18);     // Catch: Throwable -> L12
        r18.close();     // Catch: Throwable -> L12
    L15:
        BufferCallStatus.ByValue r22 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r11, -5313389778878578230L, r1);     // Catch: Throwable -> L12
        int r23 = r22.code;     // Catch: Throwable -> L12
        if (r23 != 0) goto L23;
        RustBuffer.ByValue r24 = r22.data;     // Catch: Throwable -> L12
        ProtoAdapter r25 = FuncReturnX50eab1b92d182188.ADAPTER;     // Catch: Throwable -> L12
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        PushBitableLoaderResource r26 = ((FuncReturnX50eab1b92d182188) r25.decode(RustBuffer.a.b(r24))).ret;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r26);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r26, "<this>");     // Catch: Throwable -> L12
        r0 r27 = new r0(r26.container_id, r26.block_id, r26.view_id, r26.clientvars, r26.main_page, r26.block_type, r26.record_data, r26.add_record_page);     // Catch: Throwable -> L12
        if (this.c.decrementAndGet() != 0) goto L21;
        b();
    L21:
        return r27;
    L23:
        if (r23 == 1) goto L45;
        if (r23 != 2) goto L42;
        RustBuffer.ByValue r28 = r22.data;     // Catch: Throwable -> L12
        int r29 = r28.len;     // Catch: Throwable -> L12
        if (r29 > 0) goto L54;
        UnhandledException r30 = new UnhandledException("Rust panic");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r30, "e");     // Catch: Throwable -> L12
        throw r30;     // Catch: Throwable -> L12
    L54:
        Pointer r31 = r28.data;     // Catch: Throwable -> L37
        if (r31 == null) goto L31;
        byte[] r32 = r31.getByteArray(0, r29);     // Catch: Throwable -> L37
    L32:
        if (r32 == null) goto L34;
        r15 = new String(r32, Charsets.UTF_8);     // Catch: Throwable -> L37
    L34:
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L37
        RustBuffer.a r33 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r34 = r22.data;     // Catch: Throwable -> L12
        r33.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r34);     // Catch: Throwable -> L12
        UnhandledException r35 = new UnhandledException(r15);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r35, "e");     // Catch: Throwable -> L12
        throw r35;     // Catch: Throwable -> L12
    L31:
        r32 = null;
    L37:
        th = move-exception;
        RustBuffer.a r36 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r37 = r22.data;     // Catch: Throwable -> L12
        r36.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r37);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L42:
        UnhandledException r38 = new UnhandledException("Unknown rust call status: " + r22 + ".code");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r38, "e");     // Catch: Throwable -> L12
        throw r38;     // Catch: Throwable -> L12
    L45:
        throw ((Throwable) r12.a(r22.data));     // Catch: Throwable -> L12
    L14:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        r1 = RustBuffer.a.a(0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.c.decrementAndGet() != 0) goto L49;
        b();
    L49:
        throw th;
    L51:
        throw new IllegalStateException(k.class.getSimpleName().concat(" call counter would overflow"));
    L53:
        throw new IllegalStateException(k.class.getSimpleName().concat(" object has already been destroyed"));
    }
}
