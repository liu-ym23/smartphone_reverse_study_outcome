package hda;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t1 {
    public static final List<j0> a(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "contentTime");
        j0[] r0 = new j0[2];
        j0 r3 = null;
        if ((!StringsKt.isBlank(r5)) == true) goto L6;
        r5 = null;
    L6:
        if (r5 == null) goto L8;
        j0 r1 = new j0("内容时间", r5);
    L9:
        r0[0] = r1;
        if (r6 != null) goto L12;
    L17:
        r0[1] = r3;
        return CollectionsKt.listOfNotNull(r0);
    L12:
        if ((!StringsKt.isBlank(r6)) == true) goto L15;
        r6 = null;
    L15:
        if (r6 == null) goto L17;
        r3 = new j0("来源", r6);
        goto L17
    L8:
        r1 = null;
        goto L9
    }
}
