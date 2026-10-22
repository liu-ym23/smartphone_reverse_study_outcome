package com.larus.disk.impl.handler;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.r;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k {
    public static final long b(PolarisFileWrapper r7) {
        Intrinsics.checkNotNullParameter(r7, "root");
        if (r7.exists() == true) goto L5;
        return 0;
    L5:
        Iterator r8 = SequencesKt.filter(FilesKt.walkTopDown(r7), new j()).iterator();
        long r3 = 0;
    L7:
        if (r8.hasNext() == false) goto L9;
        r3 = r3 + RangesKt.coerceAtLeast(r.r((File) r8.next()), 0);
        goto L7
    L9:
        return r3;
    }

    public static final void a(Function0<Long> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "getRemainingCleanableSize");
        Intrinsics.checkNotNullParameter(r7, "clearAction");
        long r0 = ((Number) r6.invoke()).longValue();
        r7.invoke();
        if (r0 > 0) goto L5;
        return;
    L5:
        long r1 = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
    L7:
        if (System.nanoTime() >= r1) goto L10;
        Thread.sleep(50);
        if (((Number) r6.invoke()).longValue() > 0) goto L7;
        return;
    }
}
