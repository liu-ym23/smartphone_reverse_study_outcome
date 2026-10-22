package com.bytedance.librarian.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class d extends c.b {
    private final f j;

    public d(boolean r4, f r5) {
        this.f2807a = r4;
        this.j = r5;
        ByteBuffer r0 = ByteBuffer.allocate(4);
        if (r4 == false) goto L5;
        ByteOrder r6 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r6);
        this.f2808b = r5.d(r0, 16);
        this.c = r5.c(r0, 28);
        this.d = r5.c(r0, 32);
        this.e = r5.d(r0, 42);
        this.f = r5.d(r0, 44);
        this.g = r5.d(r0, 46);
        this.h = r5.d(r0, 48);
        this.i = r5.d(r0, 50);
        return;
    L5:
        r6 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // com.bytedance.librarian.a.c.b
    public c.a a(long r8, int r10) {
        return new a(this.j, this, r8, r10);
    }

    @Override // com.bytedance.librarian.a.c.b
    public c.AbstractC0143c a(long r3) {
        return new g(this.j, this, r3);
    }

    @Override // com.bytedance.librarian.a.c.b
    public c.d a(int r3) {
        return new i(this.j, this, r3);
    }
}
