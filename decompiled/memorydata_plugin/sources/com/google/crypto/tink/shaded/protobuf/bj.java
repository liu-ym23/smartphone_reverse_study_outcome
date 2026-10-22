package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final class bj implements ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final at f4980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4981b;
    private final Object[] c;
    private final int d;

    bj(at r4, String r5, Object[] r6) {
        this.f4980a = (at) ZeusTransformUtils.wrapperContextForParams(r4, at.class, "com.obric.memorydata.plugin");
        this.f4981b = r5;
        this.c = r6;
        int r7 = r5.charAt(0);
        if (r7 >= 55296) goto L5;
    L4:
        this.d = r7;
        return;
    L5:
        int r8 = r7 & 8191;
        int r0 = 13;
        int r1 = 1;
    L6:
        int r2 = r1 + 1;
        char r3 = r5.charAt(r1);
        if (r3 < 55296) goto L9;
        r8 = r8 | ((r3 & 8191) << r0);
        r0 = r0 + 13;
        r1 = r2;
        goto L6
    L9:
        r7 = r8 | (r3 << r0);
        goto L4
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ar
    public ProtoSyntax a() {
        if ((this.d & 1) == 0) goto L7;
        return ProtoSyntax.PROTO2;
    L7:
        return ProtoSyntax.PROTO3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ar
    public boolean b() {
        if ((this.d & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ar
    public at c() {
        return this.f4980a;
    }

    String d() {
        return this.f4981b;
    }

    Object[] e() {
        return this.c;
    }
}
