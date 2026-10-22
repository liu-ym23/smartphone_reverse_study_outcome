package com.larus.dora.impl.core;

import com.bytedance.dora.vision.DoraDataFrame;
import qk4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class z0 implements h {
    public z0() {
    }

    public final void a(DoraDataFrame r1) {
    }

    public abstract void c(int r1, int r2, int r3, byte[] r4, int r5, byte[] r6, boolean r7);

    public final void b(DoraDataFrame r10) {
        int r1 = r10.id;
        int r2 = r10.scene;
        int r3 = r10.type;
        byte[] r0 = r10.data;
        if (r0 != null) goto L5;
        r0 = new byte[0];
    L5:
        byte[] r5 = r0;
        int r6 = r10.assId;
        byte[] r4 = r10.assData;
        if (r4 != null) goto L8;
        r4 = new byte[0];
    L8:
        byte[] r7 = r4;
        boolean r8 = true;
        if (r10.seq != (r10.count - 1)) goto L12;
        r8 = false;
    L12:
        c(r1, r2, r3, r5, r6, r7, r8);
    }
}
