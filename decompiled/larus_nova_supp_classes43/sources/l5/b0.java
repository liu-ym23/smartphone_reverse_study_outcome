package l5;

import kotlin.jvm.internal.Intrinsics;
import m5.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b0 {
    public static final Long a(h1 r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "startKey");
        Intrinsics.checkNotNullParameter(r12, "endKey");
        Long r13 = Long.valueOf(r10.c(r12));
        boolean r14 = false;
        if (r13.longValue() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r13 = null;
    L10:
        if (r13 == null) goto L20;
        long r15 = r13.longValue();
        Long r16 = Long.valueOf(r10.c(r11));
        if (r16.longValue() <= 0) goto L14;
        r14 = true;
    L14:
        if (r14 == true) goto L17;
        r16 = null;
    L17:
        if (r16 == null) goto L20;
        return Long.valueOf(r15 - r16.longValue());
    L20:
        return null;
    L5:
        r0 = false;
        goto L7
    }
}
