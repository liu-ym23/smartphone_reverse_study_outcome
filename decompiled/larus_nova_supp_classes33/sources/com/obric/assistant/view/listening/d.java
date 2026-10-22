package com.obric.assistant.view.listening;

import java.util.ArrayList;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Job;
import laa.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ float b;
    public final /* synthetic */ n c;

    public /* synthetic */ d(f r1, float r2, n r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r0 = this.a;
        float r1 = this.b;
        n r2 = this.c;
        Job r3 = r0.h;
        if (r3 == null) goto L5;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L5:
        double r4 = RangesKt.coerceIn(r1, 0.0f, 1.0f);
        b r5 = r0.d(r2);
        if (r5 != null) goto L9;
        r5 = r0.d(r0.e);
    L9:
        if (r0.e(r5, r4) == true) goto L16;
        f.b r6 = r0.c;
        ArrayList<Double> r7 = new ArrayList(45);
        int r8 = 0;
    L11:
        if (r8 >= 45) goto L13;
        r7.add(Double.valueOf(r4));
        r8 = r8 + 1;
        goto L11
    L13:
        r6.b(r7);
        return;
    }
}
