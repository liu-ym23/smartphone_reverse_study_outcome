package com.bytedance.lark.lark_bitable_android;

import com.squareup.wire.ProtoAdapter;
import com.sun.jna.Pointer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import lark_bitable.proto.FuncParamsX39dfcc67fa2c43ee;
import lark_bitable.proto.FuncReturnXa0cc096a9ab9364f;
import lark_bitable.proto.MoltenContextExtra;
import lark_bitable.proto.MoltenFfiInstanceMsg;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v extends v0 {
    @Override // com.bytedance.lark.lark_bitable_android.v0
    public final void b() {
        s r0 = s.a;
        NativeLib.Companion.getClass();
        BufferCallStatus.ByValue r1 = NativeLib.Companion.a().molten_ffi_lark_bitable_free(NativeLib.Companion.b(), this.a, -8923766972395552768L);
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

    public final void c() {
    L2:
        long r0 = this.c.get();
        if (r0 == 0) goto L51;
        if (r0 == Long.MAX_VALUE) goto L49;
        if (this.c.compareAndSet(r0, 1 + r0) == false) goto L2;
        Pointer r10 = this.a;     // Catch: Throwable -> L11
        s r1 = s.a;     // Catch: Throwable -> L11
        NativeLib.Companion r11 = NativeLib.Companion;     // Catch: Throwable -> L11
        m0 r12 = new m0(Long.valueOf(Pointer.nativeValue(r10)), "destroyContainer");     // Catch: Throwable -> L11
        r11.getClass();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r12, "info");     // Catch: Throwable -> L11
        String r13 = null;
        MoltenContextExtra r14 = new MoltenContextExtra(null);     // Catch: Throwable -> L11
        int r15 = MoltenContextExtra.ADAPTER.encodedSize(r14);     // Catch: Throwable -> L11
        if (r15 <= 0) goto L13;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L11
        RustBuffer.ByValue r16 = RustBuffer.a.a(r15);     // Catch: Throwable -> L11
        Pointer r17 = r16.data;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L11
        o0 r18 = new o0(r17);     // Catch: Throwable -> L11
        r14.encode(r18);     // Catch: Throwable -> L11
        r18.close();     // Catch: Throwable -> L11
        RustBuffer.ByValue r19 = r16;
    L14:
        BufferCallStatus.ByValue r20 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r10, -622524208554070407L, r19);     // Catch: Throwable -> L11
        int r21 = r20.code;     // Catch: Throwable -> L11
        if (r21 != 0) goto L21;
        if (this.c.decrementAndGet() != 0) goto L58;
        b();
        return;
    L58:
        return;
    L21:
        if (r21 == 1) goto L43;
        if (r21 != 2) goto L40;
        RustBuffer.ByValue r22 = r20.data;     // Catch: Throwable -> L11
        int r23 = r22.len;     // Catch: Throwable -> L11
        if (r23 > 0) goto L53;
        UnhandledException r24 = new UnhandledException("Rust panic");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r24, "e");     // Catch: Throwable -> L11
        throw r24;     // Catch: Throwable -> L11
    L53:
        Pointer r25 = r22.data;     // Catch: Throwable -> L35
        if (r25 == null) goto L29;
        byte[] r26 = r25.getByteArray(0, r23);     // Catch: Throwable -> L35
    L30:
        if (r26 == null) goto L32;
        r13 = new String(r26, Charsets.UTF_8);     // Catch: Throwable -> L35
    L32:
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L35
        RustBuffer.a r27 = RustBuffer.Companion;     // Catch: Throwable -> L11
        RustBuffer.ByValue r28 = r20.data;     // Catch: Throwable -> L11
        r27.getClass();     // Catch: Throwable -> L11
        RustBuffer.a.c(r28);     // Catch: Throwable -> L11
        UnhandledException r29 = new UnhandledException(r13);     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r29, "e");     // Catch: Throwable -> L11
        throw r29;     // Catch: Throwable -> L11
    L29:
        r26 = null;
    L35:
        th = move-exception;
        RustBuffer.a r30 = RustBuffer.Companion;     // Catch: Throwable -> L11
        RustBuffer.ByValue r31 = r20.data;     // Catch: Throwable -> L11
        r30.getClass();     // Catch: Throwable -> L11
        RustBuffer.a.c(r31);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L40:
        UnhandledException r32 = new UnhandledException("Unknown rust call status: " + r20 + ".code");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r32, "e");     // Catch: Throwable -> L11
        throw r32;     // Catch: Throwable -> L11
    L43:
        throw ((Throwable) r1.a(r20.data));     // Catch: Throwable -> L11
    L13:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L11
        r19 = RustBuffer.a.a(0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (this.c.decrementAndGet() != 0) goto L47;
        b();
    L47:
        throw th;
    L49:
        throw new IllegalStateException(v.class.getSimpleName().concat(" call counter would overflow"));
    L51:
        throw new IllegalStateException(v.class.getSimpleName().concat(" object has already been destroyed"));
    }

    public final void d() {
    L2:
        long r0 = this.c.get();
        if (r0 == 0) goto L51;
        if (r0 == Long.MAX_VALUE) goto L49;
        if (this.c.compareAndSet(r0, 1 + r0) == false) goto L2;
        Pointer r10 = this.a;     // Catch: Throwable -> L11
        s r1 = s.a;     // Catch: Throwable -> L11
        NativeLib.Companion r11 = NativeLib.Companion;     // Catch: Throwable -> L11
        m0 r12 = new m0(Long.valueOf(Pointer.nativeValue(r10)), "onEnterFeedTab");     // Catch: Throwable -> L11
        r11.getClass();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r12, "info");     // Catch: Throwable -> L11
        String r13 = null;
        MoltenContextExtra r14 = new MoltenContextExtra(null);     // Catch: Throwable -> L11
        int r15 = MoltenContextExtra.ADAPTER.encodedSize(r14);     // Catch: Throwable -> L11
        if (r15 <= 0) goto L13;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L11
        RustBuffer.ByValue r16 = RustBuffer.a.a(r15);     // Catch: Throwable -> L11
        Pointer r17 = r16.data;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L11
        o0 r18 = new o0(r17);     // Catch: Throwable -> L11
        r14.encode(r18);     // Catch: Throwable -> L11
        r18.close();     // Catch: Throwable -> L11
        RustBuffer.ByValue r19 = r16;
    L14:
        BufferCallStatus.ByValue r20 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r10, 5776272039309323897L, r19);     // Catch: Throwable -> L11
        int r21 = r20.code;     // Catch: Throwable -> L11
        if (r21 != 0) goto L21;
        if (this.c.decrementAndGet() != 0) goto L58;
        b();
        return;
    L58:
        return;
    L21:
        if (r21 == 1) goto L43;
        if (r21 != 2) goto L40;
        RustBuffer.ByValue r22 = r20.data;     // Catch: Throwable -> L11
        int r23 = r22.len;     // Catch: Throwable -> L11
        if (r23 > 0) goto L53;
        UnhandledException r24 = new UnhandledException("Rust panic");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r24, "e");     // Catch: Throwable -> L11
        throw r24;     // Catch: Throwable -> L11
    L53:
        Pointer r25 = r22.data;     // Catch: Throwable -> L35
        if (r25 == null) goto L29;
        byte[] r26 = r25.getByteArray(0, r23);     // Catch: Throwable -> L35
    L30:
        if (r26 == null) goto L32;
        r13 = new String(r26, Charsets.UTF_8);     // Catch: Throwable -> L35
    L32:
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L35
        RustBuffer.a r27 = RustBuffer.Companion;     // Catch: Throwable -> L11
        RustBuffer.ByValue r28 = r20.data;     // Catch: Throwable -> L11
        r27.getClass();     // Catch: Throwable -> L11
        RustBuffer.a.c(r28);     // Catch: Throwable -> L11
        UnhandledException r29 = new UnhandledException(r13);     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r29, "e");     // Catch: Throwable -> L11
        throw r29;     // Catch: Throwable -> L11
    L29:
        r26 = null;
    L35:
        th = move-exception;
        RustBuffer.a r30 = RustBuffer.Companion;     // Catch: Throwable -> L11
        RustBuffer.ByValue r31 = r20.data;     // Catch: Throwable -> L11
        r30.getClass();     // Catch: Throwable -> L11
        RustBuffer.a.c(r31);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L40:
        UnhandledException r32 = new UnhandledException("Unknown rust call status: " + r20 + ".code");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r32, "e");     // Catch: Throwable -> L11
        throw r32;     // Catch: Throwable -> L11
    L43:
        throw ((Throwable) r1.a(r20.data));     // Catch: Throwable -> L11
    L13:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L11
        r19 = RustBuffer.a.a(0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (this.c.decrementAndGet() != 0) goto L47;
        b();
    L47:
        throw th;
    L49:
        throw new IllegalStateException(v.class.getSimpleName().concat(" call counter would overflow"));
    L51:
        throw new IllegalStateException(v.class.getSimpleName().concat(" object has already been destroyed"));
    }

    public final void e() {
    L2:
        long r0 = this.c.get();
        if (r0 == 0) goto L51;
        if (r0 == Long.MAX_VALUE) goto L49;
        if (this.c.compareAndSet(r0, 1 + r0) == false) goto L2;
        Pointer r10 = this.a;     // Catch: Throwable -> L11
        s r1 = s.a;     // Catch: Throwable -> L11
        NativeLib.Companion r11 = NativeLib.Companion;     // Catch: Throwable -> L11
        m0 r12 = new m0(Long.valueOf(Pointer.nativeValue(r10)), "onEnterHomepageTab");     // Catch: Throwable -> L11
        r11.getClass();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r12, "info");     // Catch: Throwable -> L11
        String r13 = null;
        MoltenContextExtra r14 = new MoltenContextExtra(null);     // Catch: Throwable -> L11
        int r15 = MoltenContextExtra.ADAPTER.encodedSize(r14);     // Catch: Throwable -> L11
        if (r15 <= 0) goto L13;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L11
        RustBuffer.ByValue r16 = RustBuffer.a.a(r15);     // Catch: Throwable -> L11
        Pointer r17 = r16.data;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L11
        o0 r18 = new o0(r17);     // Catch: Throwable -> L11
        r14.encode(r18);     // Catch: Throwable -> L11
        r18.close();     // Catch: Throwable -> L11
        RustBuffer.ByValue r19 = r16;
    L14:
        BufferCallStatus.ByValue r20 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r10, 2096753555163426425L, r19);     // Catch: Throwable -> L11
        int r21 = r20.code;     // Catch: Throwable -> L11
        if (r21 != 0) goto L21;
        if (this.c.decrementAndGet() != 0) goto L58;
        b();
        return;
    L58:
        return;
    L21:
        if (r21 == 1) goto L43;
        if (r21 != 2) goto L40;
        RustBuffer.ByValue r22 = r20.data;     // Catch: Throwable -> L11
        int r23 = r22.len;     // Catch: Throwable -> L11
        if (r23 > 0) goto L53;
        UnhandledException r24 = new UnhandledException("Rust panic");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r24, "e");     // Catch: Throwable -> L11
        throw r24;     // Catch: Throwable -> L11
    L53:
        Pointer r25 = r22.data;     // Catch: Throwable -> L35
        if (r25 == null) goto L29;
        byte[] r26 = r25.getByteArray(0, r23);     // Catch: Throwable -> L35
    L30:
        if (r26 == null) goto L32;
        r13 = new String(r26, Charsets.UTF_8);     // Catch: Throwable -> L35
    L32:
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L35
        RustBuffer.a r27 = RustBuffer.Companion;     // Catch: Throwable -> L11
        RustBuffer.ByValue r28 = r20.data;     // Catch: Throwable -> L11
        r27.getClass();     // Catch: Throwable -> L11
        RustBuffer.a.c(r28);     // Catch: Throwable -> L11
        UnhandledException r29 = new UnhandledException(r13);     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r29, "e");     // Catch: Throwable -> L11
        throw r29;     // Catch: Throwable -> L11
    L29:
        r26 = null;
    L35:
        th = move-exception;
        RustBuffer.a r30 = RustBuffer.Companion;     // Catch: Throwable -> L11
        RustBuffer.ByValue r31 = r20.data;     // Catch: Throwable -> L11
        r30.getClass();     // Catch: Throwable -> L11
        RustBuffer.a.c(r31);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L40:
        UnhandledException r32 = new UnhandledException("Unknown rust call status: " + r20 + ".code");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r32, "e");     // Catch: Throwable -> L11
        throw r32;     // Catch: Throwable -> L11
    L43:
        throw ((Throwable) r1.a(r20.data));     // Catch: Throwable -> L11
    L13:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L11
        r19 = RustBuffer.a.a(0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (this.c.decrementAndGet() != 0) goto L47;
        b();
    L47:
        throw th;
    L49:
        throw new IllegalStateException(v.class.getSimpleName().concat(" call counter would overflow"));
    L51:
        throw new IllegalStateException(v.class.getSimpleName().concat(" object has already been destroyed"));
    }

    public final void f() {
    L2:
        long r0 = this.c.get();
        if (r0 == 0) goto L51;
        if (r0 == Long.MAX_VALUE) goto L49;
        if (this.c.compareAndSet(r0, 1 + r0) == false) goto L2;
        Pointer r10 = this.a;     // Catch: Throwable -> L11
        s r1 = s.a;     // Catch: Throwable -> L11
        NativeLib.Companion r11 = NativeLib.Companion;     // Catch: Throwable -> L11
        m0 r12 = new m0(Long.valueOf(Pointer.nativeValue(r10)), "onLeaveFeedTab");     // Catch: Throwable -> L11
        r11.getClass();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r12, "info");     // Catch: Throwable -> L11
        String r13 = null;
        MoltenContextExtra r14 = new MoltenContextExtra(null);     // Catch: Throwable -> L11
        int r15 = MoltenContextExtra.ADAPTER.encodedSize(r14);     // Catch: Throwable -> L11
        if (r15 <= 0) goto L13;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L11
        RustBuffer.ByValue r16 = RustBuffer.a.a(r15);     // Catch: Throwable -> L11
        Pointer r17 = r16.data;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L11
        o0 r18 = new o0(r17);     // Catch: Throwable -> L11
        r14.encode(r18);     // Catch: Throwable -> L11
        r18.close();     // Catch: Throwable -> L11
        RustBuffer.ByValue r19 = r16;
    L14:
        BufferCallStatus.ByValue r20 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r10, 1483839779036311161L, r19);     // Catch: Throwable -> L11
        int r21 = r20.code;     // Catch: Throwable -> L11
        if (r21 != 0) goto L21;
        if (this.c.decrementAndGet() != 0) goto L58;
        b();
        return;
    L58:
        return;
    L21:
        if (r21 == 1) goto L43;
        if (r21 != 2) goto L40;
        RustBuffer.ByValue r22 = r20.data;     // Catch: Throwable -> L11
        int r23 = r22.len;     // Catch: Throwable -> L11
        if (r23 > 0) goto L53;
        UnhandledException r24 = new UnhandledException("Rust panic");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r24, "e");     // Catch: Throwable -> L11
        throw r24;     // Catch: Throwable -> L11
    L53:
        Pointer r25 = r22.data;     // Catch: Throwable -> L35
        if (r25 == null) goto L29;
        byte[] r26 = r25.getByteArray(0, r23);     // Catch: Throwable -> L35
    L30:
        if (r26 == null) goto L32;
        r13 = new String(r26, Charsets.UTF_8);     // Catch: Throwable -> L35
    L32:
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L35
        RustBuffer.a r27 = RustBuffer.Companion;     // Catch: Throwable -> L11
        RustBuffer.ByValue r28 = r20.data;     // Catch: Throwable -> L11
        r27.getClass();     // Catch: Throwable -> L11
        RustBuffer.a.c(r28);     // Catch: Throwable -> L11
        UnhandledException r29 = new UnhandledException(r13);     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r29, "e");     // Catch: Throwable -> L11
        throw r29;     // Catch: Throwable -> L11
    L29:
        r26 = null;
    L35:
        th = move-exception;
        RustBuffer.a r30 = RustBuffer.Companion;     // Catch: Throwable -> L11
        RustBuffer.ByValue r31 = r20.data;     // Catch: Throwable -> L11
        r30.getClass();     // Catch: Throwable -> L11
        RustBuffer.a.c(r31);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L40:
        UnhandledException r32 = new UnhandledException("Unknown rust call status: " + r20 + ".code");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r32, "e");     // Catch: Throwable -> L11
        throw r32;     // Catch: Throwable -> L11
    L43:
        throw ((Throwable) r1.a(r20.data));     // Catch: Throwable -> L11
    L13:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L11
        r19 = RustBuffer.a.a(0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (this.c.decrementAndGet() != 0) goto L47;
        b();
    L47:
        throw th;
    L49:
        throw new IllegalStateException(v.class.getSimpleName().concat(" call counter would overflow"));
    L51:
        throw new IllegalStateException(v.class.getSimpleName().concat(" object has already been destroyed"));
    }

    public final void g() {
    L2:
        long r0 = this.c.get();
        if (r0 == 0) goto L51;
        if (r0 == Long.MAX_VALUE) goto L49;
        if (this.c.compareAndSet(r0, 1 + r0) == false) goto L2;
        Pointer r10 = this.a;     // Catch: Throwable -> L11
        s r1 = s.a;     // Catch: Throwable -> L11
        NativeLib.Companion r11 = NativeLib.Companion;     // Catch: Throwable -> L11
        m0 r12 = new m0(Long.valueOf(Pointer.nativeValue(r10)), "onLeaveHomepageTab");     // Catch: Throwable -> L11
        r11.getClass();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r12, "info");     // Catch: Throwable -> L11
        String r13 = null;
        MoltenContextExtra r14 = new MoltenContextExtra(null);     // Catch: Throwable -> L11
        int r15 = MoltenContextExtra.ADAPTER.encodedSize(r14);     // Catch: Throwable -> L11
        if (r15 <= 0) goto L13;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L11
        RustBuffer.ByValue r16 = RustBuffer.a.a(r15);     // Catch: Throwable -> L11
        Pointer r17 = r16.data;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L11
        o0 r18 = new o0(r17);     // Catch: Throwable -> L11
        r14.encode(r18);     // Catch: Throwable -> L11
        r18.close();     // Catch: Throwable -> L11
        RustBuffer.ByValue r19 = r16;
    L14:
        BufferCallStatus.ByValue r20 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r10, -5850092839122391431L, r19);     // Catch: Throwable -> L11
        int r21 = r20.code;     // Catch: Throwable -> L11
        if (r21 != 0) goto L21;
        if (this.c.decrementAndGet() != 0) goto L58;
        b();
        return;
    L58:
        return;
    L21:
        if (r21 == 1) goto L43;
        if (r21 != 2) goto L40;
        RustBuffer.ByValue r22 = r20.data;     // Catch: Throwable -> L11
        int r23 = r22.len;     // Catch: Throwable -> L11
        if (r23 > 0) goto L53;
        UnhandledException r24 = new UnhandledException("Rust panic");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r24, "e");     // Catch: Throwable -> L11
        throw r24;     // Catch: Throwable -> L11
    L53:
        Pointer r25 = r22.data;     // Catch: Throwable -> L35
        if (r25 == null) goto L29;
        byte[] r26 = r25.getByteArray(0, r23);     // Catch: Throwable -> L35
    L30:
        if (r26 == null) goto L32;
        r13 = new String(r26, Charsets.UTF_8);     // Catch: Throwable -> L35
    L32:
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L35
        RustBuffer.a r27 = RustBuffer.Companion;     // Catch: Throwable -> L11
        RustBuffer.ByValue r28 = r20.data;     // Catch: Throwable -> L11
        r27.getClass();     // Catch: Throwable -> L11
        RustBuffer.a.c(r28);     // Catch: Throwable -> L11
        UnhandledException r29 = new UnhandledException(r13);     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r29, "e");     // Catch: Throwable -> L11
        throw r29;     // Catch: Throwable -> L11
    L29:
        r26 = null;
    L35:
        th = move-exception;
        RustBuffer.a r30 = RustBuffer.Companion;     // Catch: Throwable -> L11
        RustBuffer.ByValue r31 = r20.data;     // Catch: Throwable -> L11
        r30.getClass();     // Catch: Throwable -> L11
        RustBuffer.a.c(r31);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L40:
        UnhandledException r32 = new UnhandledException("Unknown rust call status: " + r20 + ".code");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r32, "e");     // Catch: Throwable -> L11
        throw r32;     // Catch: Throwable -> L11
    L43:
        throw ((Throwable) r1.a(r20.data));     // Catch: Throwable -> L11
    L13:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L11
        r19 = RustBuffer.a.a(0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (this.c.decrementAndGet() != 0) goto L47;
        b();
    L47:
        throw th;
    L49:
        throw new IllegalStateException(v.class.getSimpleName().concat(" call counter would overflow"));
    L51:
        throw new IllegalStateException(v.class.getSimpleName().concat(" object has already been destroyed"));
    }

    public v(long r13, com.bytedance.ee.bear.bitable.homepage.badge.b.c r15) {
        Intrinsics.checkNotNullParameter(r15, "callback");
        s r1 = s.a;
        NativeLib.Companion r10 = NativeLib.Companion;
        String r11 = null;
        m0 r12 = new m0(null, "new");
        r10.getClass();
        Intrinsics.checkNotNullParameter(r12, "info");
        Long r14 = Long.valueOf(r13);
        Intrinsics.checkNotNullParameter(r15, "<this>");
        int r16 = u.b;
        Intrinsics.checkNotNullParameter(r15, "callback");
        FuncParamsX39dfcc67fa2c43ee r17 = new FuncParamsX39dfcc67fa2c43ee(r14, new MoltenFfiInstanceMsg(3797523550375550627L, Long.valueOf(r.a.a(new u(r15)))), null);
        int r18 = FuncParamsX39dfcc67fa2c43ee.ADAPTER.encodedSize(r17);
        if (r18 <= 0) goto L5;
        RustBuffer.Companion.getClass();
        RustBuffer.ByValue r19 = RustBuffer.a.a(r18);
        Pointer r110 = r19.data;
        Intrinsics.checkNotNull(r110);
        o0 r111 = new o0(r110);
        r17.encode(r111);
        r111.close();
    L6:
        BufferCallStatus.ByValue r112 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), new Pointer(0), -6933451633591626204L, r19);
        int r0 = r112.code;
        if (r0 != 0) goto L11;
        RustBuffer.ByValue r113 = r112.data;
        ProtoAdapter r114 = FuncReturnXa0cc096a9ab9364f.ADAPTER;
        RustBuffer.Companion.getClass();
        Long r115 = ((FuncReturnXa0cc096a9ab9364f) r114.decode(RustBuffer.a.b(r113))).ret;
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
}
