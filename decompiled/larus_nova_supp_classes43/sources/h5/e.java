package h5;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final int a(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "otherVersion");
        List r13 = StringsKt.split$default(r11, new String[]{"."}, false, 0, 6, null);
        List r14 = StringsKt.split$default(r12, new String[]{"."}, false, 0, 6, null);
        int r0 = Math.max(r13.size(), r14.size());
        int r10 = 0;
    L3:
        if (r10 >= r0) goto L20;
        String r15 = (String) CollectionsKt.getOrNull(r13, r10);
        if (r15 == null) goto L9;
        Integer r16 = StringsKt.toIntOrNull(r15);
        if (r16 == null) goto L9;
        int r17 = r16.intValue();
    L10:
        String r18 = (String) CollectionsKt.getOrNull(r14, r10);
        if (r18 == null) goto L15;
        Integer r19 = StringsKt.toIntOrNull(r18);
        if (r19 == null) goto L15;
        int r20 = r19.intValue();
    L16:
        if (r17 != r20) goto L18;
        r10 = r10 + 1;
        goto L3
    L18:
        return Intrinsics.compare(r17, r20);
    L15:
        r20 = 0;
    L9:
        r17 = 0;
        goto L10
    L20:
        return 0;
    }
}
