package w20;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c1 {
    public static final List<String> a(j9 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$dataEx");
        List<String> r2 = r1.getData();
        if (r2 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.toList(r2);
    }
}
