package com.tom_roush.pdfbox.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;

/* JADX INFO: loaded from: classes6.dex */
public class d implements Comparator<c> {
    public d() {
    }

    public int a(c r8, c r9) {
        int r7 = Float.compare(r8.b(), r9.b());
        if (r7 == 0) goto L5;
        return r7;
    L5:
        float r10 = r8.d();
        float r0 = r9.d();
        float r1 = r8.f();
        float r2 = r9.f();
        float r11 = r1 - r8.j();
        float r12 = r2 - r9.j();
        if (Math.abs(r1 - r2) < 0.1d) goto L23;
        if (r2 < r11) goto L12;
        if (r2 <= r1) goto L23;
    L12:
        if (r1 < r12) goto L17;
        if (r1 <= r2) goto L23;
    L17:
        if (r1 >= r2) goto L20;
        return -1;
    L20:
        return 1;
    L23:
        return Float.compare(r10, r0);
    }

    @Override // java.util.Comparator
    public /* synthetic */ int compare(c r3, c r4) {
        return a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin"));
    }
}
