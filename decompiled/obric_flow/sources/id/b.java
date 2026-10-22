package id;

import b3.m;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends m {
    public final long f(List r12) {
        Intrinsics.checkNotNullParameter(r12, "stageList");
        Iterator r13 = r12.iterator();
        long r5 = 0;
    L4:
        if (r13.hasNext() == false) goto L14;
        Pair r10 = (Pair) r13.next();
        long r11 = d((String) r10.getFirst());
        long r14 = d((String) r10.getSecond());
        if (r11 != (-1)) goto L8;
    L11:
        long r15 = 0;
    L12:
        r5 = r5 + r15;
        goto L4
    L8:
        if (r14 == (-1)) goto L11;
        r15 = r14 - r11;
        goto L12
    L14:
        return r5 / ((long) DurationKt.NANOS_IN_MILLIS);
    }
}
