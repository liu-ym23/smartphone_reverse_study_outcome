package com.google.zxing.common.reedsolomon;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f5076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<b> f5077b;

    public c(a r5) {
        this.f5076a = r5;
        ArrayList r0 = new ArrayList();
        this.f5077b = r0;
        r0.add(new b(r5, new int[]{1}));
    }

    private b a(int r10) {
        if (r10 < this.f5077b.size()) goto L8;
        List<b> r0 = this.f5077b;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0.get(r0.size() - 1), b.class, "com.obric.memorydata.plugin");
        int r2 = this.f5077b.size();
    L5:
        if (r2 > r10) goto L8;
        a r5 = this.f5076a;
        r1 = r1.b(new b(r5, new int[]{1, r5.a((r2 - 1) + r5.b())}));
        this.f5077b.add(r1);
        r2 = r2 + 1;
    L8:
        return (b) ZeusTransformUtils.preCheckCast(this.f5077b.get(r10), b.class, "com.obric.memorydata.plugin");
    }

    public void a(int[] r6, int r7) {
        if (r7 == 0) goto L13;
        int r0 = r6.length - r7;
        if (r0 <= 0) goto L11;
        b r1 = a(r7);
        int[] r2 = new int[r0];
        System.arraycopy(r6, 0, r2, 0, r0);
        int[] r5 = new b(this.f5076a, r2).a(r7, 1).c(r1)[1].a();
        int r8 = r7 - r5.length;
        int r3 = 0;
    L6:
        if (r3 >= r8) goto L8;
        r6[r0 + r3] = 0;
        r3 = r3 + 1;
        goto L6
    L8:
        System.arraycopy(r5, 0, r6, r0 + r8, r5.length);
        return;
    L11:
        throw new IllegalArgumentException("No data bytes provided");
    L13:
        throw new IllegalArgumentException("No error correction bytes");
    }
}
