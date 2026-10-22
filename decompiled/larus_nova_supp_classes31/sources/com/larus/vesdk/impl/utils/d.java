package com.larus.vesdk.impl.utils;

import com.ss.android.vesdk.algorithm.VEBachQRCodeResult;
import com.ss.android.vesdk.algorithm.VEScanResult;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements hic.c {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    public final void onResult(List<VEScanResult> r4) {
        pq9.a r0 = this.a.a;
        String r1 = null;
        if (r4 == null) goto L5;
        VEScanResult r5 = (VEScanResult) CollectionsKt.firstOrNull(r4);
    L7:
        if ((r5 instanceof VEBachQRCodeResult) == false) goto L9;
        VEBachQRCodeResult r6 = (VEBachQRCodeResult) r5;
    L10:
        if (r6 == null) goto L12;
        r1 = r6.getResult();
    L12:
        r0.onResult(r1);
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L7
    }
}
