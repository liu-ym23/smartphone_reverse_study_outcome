package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
abstract class bt<T, B> {
    bt() {
    }

    abstract B a();

    abstract T a(B r1);

    abstract void a(B r1, int r2, int r3);

    abstract void a(B r1, int r2, long r3);

    abstract void a(B r1, int r2, ByteString r3);

    abstract void a(B r1, int r2, T r3);

    abstract void a(T r1, Writer r2);

    abstract void a(Object r1, T r2);

    abstract boolean a(bk r1);

    final boolean a(B r6, bk r7) {
        bk r8 = (bk) ZeusTransformUtils.wrapperContextForParams(r7, bk.class, "com.obric.memorydata.plugin");
        int r0 = r8.b();
        int r1 = WireFormat.b(r0);
        int r2 = WireFormat.a(r0);
        if (r2 == 0) goto L28;
        if (r2 != 1) goto L6;
        b(r6, r1, r8.i());
        return true;
    L6:
        if (r2 != 2) goto L8;
        a(r6, r1, r8.n());
        return true;
    L8:
        if (r2 == 3) goto L18;
        if (r2 != 4) goto L11;
        return false;
    L11:
        if (r2 != 5) goto L15;
        a(r6, r1, r8.j());
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L18:
        B r3 = a();
        int r4 = WireFormat.a(r1, 4);
        b(r3, r8);
        if (r4 != r8.b()) goto L23;
        a(r6, r1, a(r3));
        return true;
    L23:
        throw InvalidProtocolBufferException.invalidEndTag();
    L28:
        a(r6, r1, r8.g());
        return true;
    }

    abstract T b(Object r1);

    abstract void b(B r1, int r2, long r3);

    abstract void b(T r1, Writer r2);

    final void b(B r3, bk r4) {
        bk r5 = (bk) ZeusTransformUtils.wrapperContextForParams(r4, bk.class, "com.obric.memorydata.plugin");
    L4:
        if (r5.a() == Integer.MAX_VALUE) goto L7;
        if (a(r3, r5) == true) goto L4;
        return;
    }

    abstract void b(Object r1, B r2);

    abstract B c(Object r1);

    abstract T c(T r1, T r2);

    abstract void d(Object r1);

    abstract int e(T r1);

    abstract int f(T r1);
}
