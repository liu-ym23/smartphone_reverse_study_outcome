package com.bytedance.librarian.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class h extends c.AbstractC0143c {
    public h(f r6, c.b r7, long r8) {
        ByteBuffer r0 = ByteBuffer.allocate(8);
        if (r7.f2807a == false) goto L5;
        ByteOrder r1 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r1);
        long r2 = r7.c + (r8 * ((long) r7.e));
        this.f2809a = r6.c(r0, r2);
        this.f2810b = r6.b(r0, 8 + r2);
        this.c = r6.b(r0, 16 + r2);
        this.d = r6.b(r0, r2 + 40);
        return;
    L5:
        r1 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
