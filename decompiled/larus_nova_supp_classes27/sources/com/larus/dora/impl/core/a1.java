package com.larus.dora.impl.core;

import com.bytedance.dora.vision.DoraDataFrame;
import com.larus.dora.api.model.FlowDoraConnectReason;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import qk4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class a1 implements h {
    public a1() {
    }

    public final void b(DoraDataFrame r1) {
    }

    public final void a(DoraDataFrame r14) {
        int r1 = r14.id;
        int r2 = r14.scene;
        int r3 = r14.type;
        byte[] r0 = r14.data;
        if (r0 != null) goto L5;
        r0 = new byte[0];
    L5:
        byte[] r4 = r0;
        int r5 = r14.assId;
        byte[] r6 = r14.assData;
        if (r6 != null) goto L8;
        r6 = new byte[0];
    L8:
        byte[] r7 = r6;
        boolean r15 = r14.frameLoss;
        q0 r8 = (q0) this;
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r7, "assData");
        int r9 = r8.a;
        if (r1 != r9) goto L18;
        s0.c(r9, r8.e, r8.f, FlowDoraConnectReason.SUCCESS);
        v39.a r10 = new v39.a(r1, r2, r3, r4, r5, r7);
        if (r15 == false) goto L13;
        Object r16 = new v39.b.C0145b(r10);
    L14:
        ((CopyOnWriteArraySet) r8.b.e).remove(r8);
        if (r8.c.compareAndSet(false, true) == false) goto L19;
        s0.c(r8.a, r8.e, r8.f, "success, resp=" + r16);
        r8.d.resumeWith(Result.constructor-impl(r16));
        return;
    L19:
        return;
    L13:
        r16 = new v39.b.f(r10);
        goto L14
    }
}
