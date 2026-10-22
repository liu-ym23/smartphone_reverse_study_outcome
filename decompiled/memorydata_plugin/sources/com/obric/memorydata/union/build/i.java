package com.obric.memorydata.union.build;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"resolveSemanticProductType", "", "existing", "incoming", "fallback", "(Ljava/lang/Integer;Ljava/lang/Integer;I)I", "memory_build_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class i {
    public static final int a(Integer r1, Integer r2, int r3) {
        if (r1 != null) goto L6;
    L7:
        if (r2 != null) goto L10;
        return r3;
    L10:
        if (r2.intValue() == 1003) goto L12;
        return r3;
    L12:
        return 1003;
    L6:
        if (r1.intValue() == 1003) goto L12;
        goto L7
    }

    public static /* synthetic */ int a(Integer r0, Integer r1, int r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L10;
        if (r0 == null) goto L6;
        r2 = r0.intValue();
        goto L10
    L6:
        if (r1 == null) goto L8;
        r2 = r1.intValue();
        goto L10
    L8:
        r2 = 0;
    L10:
        return a(r0, r1, r2);
    }
}
