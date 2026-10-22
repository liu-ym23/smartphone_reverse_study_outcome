package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class ax<T> implements bl<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final at f4968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bt<?, ?> f4969b;
    private final boolean c;
    private final r<?> d;

    private ax(bt<?, ?> r3, r<?> r4, at r5) {
        at r6 = (at) ZeusTransformUtils.wrapperContextForParams(r5, at.class, "com.obric.memorydata.plugin");
        this.f4969b = r3;
        this.c = r4.a(r6);
        this.d = r4;
        this.f4968a = r6;
    }

    private <UT, UB> int a(bt<UT, UB> r1, T r2) {
        return r1.e(r1.b(r2));
    }

    static <T> ax<T> a(bt<?, ?> r2, r<?> r3, at r4) {
        return new ax(r2, r3, (at) ZeusTransformUtils.wrapperContextForParams(r4, at.class, "com.obric.memorydata.plugin"));
    }

    private <UT, UB, ET extends w.a<ET>> void a(bt<UT, UB> r10, r<ET> r11, T r12, bk r13, q r14) {
        bk r15 = (bk) ZeusTransformUtils.wrapperContextForParams(r13, bk.class, "com.obric.memorydata.plugin");
        UB r7 = r10.c(r12);
        w<ET> r8 = r11.b(r12);
    L17:
    L14:
        th = move-exception;
        r10.b(r12, r7);
        throw th;
    L5:
        if (r15.a() == Integer.MAX_VALUE) goto L6;
        if (a(r15, r14, r11, r8, r10, r7) == true) goto L17;
        r10.b(r12, r7);
        return;
    L6:
        r10.b(r12, r7);
    }

    private <UT, UB> void a(bt<UT, UB> r2, T r3, Writer r4) {
        Writer r1 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        r2.b(r2.b(r3), r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends w.a<ET>> boolean a(bk r7, q r8, r<ET> r9, w<ET> r10, bt<UT, UB> r11, UB r12) {
        bk r13 = (bk) ZeusTransformUtils.wrapperContextForParams(r7, bk.class, "com.obric.memorydata.plugin");
        int r0 = r13.b();
        if (r0 != WireFormat.f4931a) goto L5;
        int r1 = 0;
        Object r2 = null;
        ByteString r3 = null;
    L16:
        if (r13.a() == Integer.MAX_VALUE) goto L29;
        int r4 = r13.b();
        if (r4 == WireFormat.c) goto L20;
        if (r4 == WireFormat.d) goto L23;
        if (r13.c() == true) goto L16;
    L23:
        if (r2 != null) goto L24;
        r3 = r13.n();
        goto L16
    L24:
        r9.a(r13, r2, r8, r10);
        goto L16
    L20:
        r1 = r13.o();
        r2 = r9.a(r8, this.f4968a, r1);
    L29:
        if (r13.b() != WireFormat.f4932b) goto L36;
        if (r3 == null) goto L34;
        if (r2 == null) goto L33;
        r9.a(r3, r2, r8, r10);
        goto L34
    L33:
        r11.a(r12, r1, r3);
    L34:
        return true;
    L36:
        throw InvalidProtocolBufferException.invalidEndTag();
    L5:
        if (WireFormat.a(r0) != 2) goto L13;
        Object r6 = r9.a(r8, this.f4968a, WireFormat.b(r0));
        if (r6 == null) goto L11;
        r9.a(r13, r6, r8, r10);
        return true;
    L11:
        return r11.a(r12, r13);
    L13:
        return r13.c();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public int a(T r3) {
        int r0 = this.f4969b.b(r3).hashCode();
        if (this.c == true) goto L5;
        return r0;
    L5:
        return (r0 * 53) + this.d.a(r3).hashCode();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public T a() {
        boolean r0 = ZeusTransformUtils.instanceOf(this.f4968a, GeneratedMessageLite.class);
        at r2 = this.f4968a;
        if (r0 == false) goto L7;
        return (T) ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).newMutableInstance();
    L7:
        return (T) r2.newBuilderForType().b();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public void a(T r7, Writer r8) {
        Writer r9 = (Writer) ZeusTransformUtils.wrapperContextForParams(r8, Writer.class, "com.obric.memorydata.plugin");
        Iterator r0 = this.d.a(r7).g();
    L4:
        if (r0.hasNext() == false) goto L18;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        w.a r3 = (w.a) ZeusTransformUtils.preCheckCast(r2.getKey(), w.a.class, "com.obric.memorydata.plugin");
        if (r3.c() != WireFormat.JavaType.MESSAGE) goto L17;
        if (r3.d() == true) goto L17;
        if (r3.e() == true) goto L17;
        boolean r4 = ZeusTransformUtils.instanceOf(r2, ae.a.class);
        int r5 = r3.a();
        if (r4 == false) goto L14;
        Object r6 = ((ae.a) ZeusTransformUtils.preCheckCast(r2, ae.a.class, "com.obric.memorydata.plugin")).a().c();
    L15:
        r9.a(r5, r6);
        goto L4
    L14:
        r6 = r2.getValue();
    L17:
        throw new IllegalStateException("Found invalid MessageSet item.");
    L18:
        a(this.f4969b, r7, r9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public void a(T r7, bk r8, q r9) {
        bk r4 = (bk) ZeusTransformUtils.wrapperContextForParams(r8, bk.class, "com.obric.memorydata.plugin");
        a(this.f4969b, this.d, r7, r4, r9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public void a(T r17, byte[] r18, int r19, int r20, g.a r21) {
        bu r2 = ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r17, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).unknownFields;
        if (r2 != bu.a()) goto L5;
        r2 = bu.b();
        ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r17, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).unknownFields = r2;
    L5:
        bu r11 = r2;
        w<GeneratedMessageLite.d> r12 = ((GeneratedMessageLite.c) ZeusTransformUtils.preCheckCast(r17, GeneratedMessageLite.c.class, "com.obric.memorydata.plugin")).a();
        int r1 = r19;
        GeneratedMessageLite.e r3 = null;
    L6:
        if (r1 >= r20) goto L37;
        int r4 = g.a(r18, r1, r21);
        int r5 = r21.f5016a;
        if (r5 != WireFormat.f4931a) goto L10;
        int r6 = 0;
        ByteString r7 = null;
    L18:
        if (r4 >= r20) goto L34;
        r4 = g.a(r18, r4, r21);
        int r8 = r21.f5016a;
        int r14 = WireFormat.b(r8);
        int r15 = WireFormat.a(r8);
        if (r14 != 2) goto L22;
        if (r15 != 0) goto L31;
        r4 = g.a(r18, r4, r21);
        r6 = r21.f5016a;
        r3 = (GeneratedMessageLite.e) ZeusTransformUtils.preCheckCast(this.d.a(r21.d, this.f4968a, r6), GeneratedMessageLite.e.class, "com.obric.memorydata.plugin");
    L31:
        if (r8 == WireFormat.f4932b) goto L34;
        r4 = g.a(r8, r18, r4, r20, r21);
        goto L18
    L22:
        if (r14 != 3) goto L31;
        if (r3 != null) goto L25;
        if (r15 != 2) goto L31;
        r4 = g.e(r18, r4, r21);
        r7 = (ByteString) ZeusTransformUtils.preCheckCast(r21.c, ByteString.class, "com.obric.memorydata.plugin");
        goto L18
    L25:
        r4 = g.a(bg.a().a(r3.c().getClass()), r18, r4, r20, r21);
        r12.a(r3.d, r21.c);
    L34:
        if (r7 == null) goto L36;
        r11.a(WireFormat.a(r6, 2), r7);
    L36:
        r1 = r4;
        goto L6
    L10:
        if (WireFormat.a(r5) == 2) goto L11;
        r1 = g.a(r5, r18, r4, r20, r21);
        goto L6
    L11:
        GeneratedMessageLite.e r16 = (GeneratedMessageLite.e) ZeusTransformUtils.preCheckCast(this.d.a(r21.d, this.f4968a, WireFormat.b(r5)), GeneratedMessageLite.e.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L14;
        r1 = g.a(bg.a().a(r16.c().getClass()), r18, r4, r20, r21);
        r12.a(r16.d, r21.c);
    L15:
        r3 = r16;
        goto L6
    L14:
        r1 = g.a(r5, r18, r4, r20, r11, r21);
        goto L15
    L37:
        if (r1 != r20) goto L40;
        return;
    L40:
        throw InvalidProtocolBufferException.parseFailure();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public boolean a(T r3, T r4) {
        if (this.f4969b.b(r3).equals(this.f4969b.b(r4)) == true) goto L7;
        return false;
    L7:
        if (this.c == true) goto L9;
        return true;
    L9:
        return this.d.a(r3).equals(this.d.a(r4));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public int b(T r3) {
        int r0 = a(this.f4969b, r3) + 0;
        if (this.c == true) goto L5;
        return r0;
    L5:
        return r0 + this.d.a(r3).k();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public void b(T r2, T r3) {
        bn.a(this.f4969b, r2, r3);
        if (this.c == false) goto L6;
        bn.a(this.d, r2, r3);
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public void d(T r2) {
        this.f4969b.d(r2);
        this.d.c(r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public final boolean e(T r1) {
        return this.d.a(r1).i();
    }
}
