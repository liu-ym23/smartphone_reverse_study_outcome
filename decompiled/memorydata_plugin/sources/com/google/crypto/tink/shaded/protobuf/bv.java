package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class bv extends bt<bu, bu> {
    bv() {
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    bu a2(bu r1) {
        r1.c();
        return r1;
    }

    bu a(bu r1, bu r2) {
        if (bu.a().equals(r2) == false) goto L6;
        return r1;
    L6:
        if (bu.a().equals(r1) == false) goto L10;
        return bu.a(r1, r2);
    L10:
        return r1.a(r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ bu a() {
        return b();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ bu a(bu r3) {
        return a2((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    void a2(bu r1, int r2, int r3) {
        r1.a(WireFormat.a(r2, 5), Integer.valueOf(r3));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    void a2(bu r1, int r2, long r3) {
        r1.a(WireFormat.a(r2, 0), Long.valueOf(r3));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    void a2(bu r1, int r2, ByteString r3) {
        r1.a(WireFormat.a(r2, 2), r3);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    void a2(bu r1, int r2, bu r3) {
        r1.a(WireFormat.a(r2, 3), r3);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    void a2(bu r2, Writer r3) {
        r2.b((Writer) ZeusTransformUtils.wrapperContextForParams(r3, Writer.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ void a(bu r3, int r4, int r5) {
        a2((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ void a(bu r3, int r4, long r5) {
        a2((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ void a(bu r3, int r4, ByteString r5) {
        a2((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ void a(bu r3, int r4, bu r5) {
        a2((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.memorydata.plugin"), r4, (bu) ZeusTransformUtils.preCheckCast(r5, bu.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ void a(bu r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        a2((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.memorydata.plugin"), r5);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    void a2(Object r2, bu r3) {
        ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).unknownFields = r3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ void a(Object r3, bu r4) {
        a2(r3, (bu) ZeusTransformUtils.preCheckCast(r4, bu.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    boolean a(bk r2) {
        bk r1 = (bk) ZeusTransformUtils.wrapperContextForParams(r2, bk.class, "com.obric.memorydata.plugin");
        return false;
    }

    int b(bu r1) {
        return r1.f();
    }

    bu b() {
        return bu.b();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ bu b(Object r1) {
        return g(r1);
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    void b2(bu r1, int r2, long r3) {
        r1.a(WireFormat.a(r2, 1), Long.valueOf(r3));
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    void b2(bu r2, Writer r3) {
        r2.a((Writer) ZeusTransformUtils.wrapperContextForParams(r3, Writer.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ void b(bu r3, int r4, long r5) {
        b2((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ void b(bu r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        b2((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.memorydata.plugin"), r5);
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    void b2(Object r1, bu r2) {
        a2(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ void b(Object r3, bu r4) {
        b2(r3, (bu) ZeusTransformUtils.preCheckCast(r4, bu.class, "com.obric.memorydata.plugin"));
    }

    int c(bu r1) {
        return r1.e();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ bu c(Object r1) {
        return h(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ bu c(bu r3, bu r4) {
        return a((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.memorydata.plugin"), (bu) ZeusTransformUtils.preCheckCast(r4, bu.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    void d(Object r1) {
        g(r1).c();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ int e(bu r3) {
        return c((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bt
    /* synthetic */ int f(bu r3) {
        return b((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.memorydata.plugin"));
    }

    bu g(Object r2) {
        return ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).unknownFields;
    }

    bu h(Object r3) {
        bu r0 = g(r3);
        if (r0 != bu.a()) goto L6;
        bu r1 = bu.b();
        a2(r3, r1);
        return r1;
    L6:
        return r0;
    }
}
