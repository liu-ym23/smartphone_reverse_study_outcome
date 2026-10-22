package nuc;

import java.lang.annotation.Annotation;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i0 {
    public static final h0 b(String r1, Enum[] r2) {
        Intrinsics.checkNotNullParameter(r1, "serialName");
        Intrinsics.checkNotNullParameter(r2, "values");
        return new h0(r1, r2);
    }

    public static final h0 a(String r9, Enum[] r10, String[] r11, Annotation[][] r12) {
        Intrinsics.checkNotNullParameter(r9, "serialName");
        Intrinsics.checkNotNullParameter(r10, "values");
        Intrinsics.checkNotNullParameter(r11, "names");
        Intrinsics.checkNotNullParameter(r12, "entryAnnotations");
        f0 r0 = new f0(r9, r10.length);
        int r1 = r10.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r1) goto L14;
        Enum r5 = r10[r3];
        int r6 = r4 + 1;
        String r7 = (String) ArraysKt.getOrNull(r11, r4);
        if (r7 != null) goto L7;
        r7 = r5.name();
    L7:
        r0.j(r7, false);
        Annotation[] r8 = (Annotation[]) ArraysKt.getOrNull(r12, r4);
        if (r8 == null) goto L12;
        int r13 = r8.length;
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L12;
        r0.k(r8[r14]);
        r14 = r14 + 1;
    L12:
        r3 = r3 + 1;
        r4 = r6;
        goto L3
    L14:
        return new h0(r9, r10, r0);
    }
}
