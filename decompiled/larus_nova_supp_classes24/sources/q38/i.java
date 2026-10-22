package q38;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i {
    public static final c a(h r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        p r2 = r1.c();
        if (r2 == null) goto L9;
        List<c> r3 = r2.a();
        if (r3 == null) goto L9;
        List r4 = CollectionsKt.filterNotNull(r3);
        if (r4 == null) goto L9;
        return (c) CollectionsKt.firstOrNull(r4);
    L9:
        return null;
    }
}
