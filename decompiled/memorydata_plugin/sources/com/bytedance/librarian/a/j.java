package com.bytedance.librarian.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class j extends c.d {
    public j(f r4, c.b r5, int r6) {
        ByteBuffer r0 = ByteBuffer.allocate(8);
        if (r5.f2807a == false) goto L5;
        ByteOrder r1 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r1);
        this.f2811a = r4.c(r0, (r5.d + ((long) (r6 * r5.g))) + 44);
        return;
    L5:
        r1 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
