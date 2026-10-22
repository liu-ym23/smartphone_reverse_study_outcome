package com.larus.dora.impl.guide.strategy;

import com.larus.dora.impl.util.b0;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public final String a;
    public final long b;

    public final Object a() {
        b0.a.getClass();     // Catch: Exception -> L5
        long r3 = b0.j().getLong(this.a, -1);     // Catch: Exception -> L5
    L7:
        boolean r5 = true;
        if (r3 == (-1)) goto L10;
        long r1 = System.currentTimeMillis();
        if ((r1 - r3) >= this.b) goto L15;
        r5 = false;
    L15:
        g49.d.d("FrequencyStrategy", "frequency check: key=" + this.a + ", last=" + r3 + ", now=" + r1 + ", interval=" + this.b + ", passed=" + r5);
        return Boxing.boxBoolean(r5);
    L10:
        return Boxing.boxBoolean(true);
    L5:
        e = move-exception;
        g49.d.c("FrequencyStrategy", "read lastShowTime failed for key=" + this.a + ", error=" + e.getMessage(), e);
        r3 = -1;
        goto L7
    }

    public final void b() {
        long r2 = System.currentTimeMillis();
        b0.a.getClass();     // Catch: Exception -> L5
        b0.j().storeLong(this.a, r2);     // Catch: Exception -> L5
        g49.d.d("FrequencyStrategy", "refresh lastShowTime for key=" + this.a + " at ts=" + r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        g49.d.c("FrequencyStrategy", "store refresh lastShowTime failed for key=" + this.a + ", error=" + e.getMessage(), e);
    }

    public c(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "kevaKey");
        this.a = r2;
        this.b = r3;
    }
}
