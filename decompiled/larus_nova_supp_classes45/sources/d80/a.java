package d80;

import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(LinkedHashMap r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$getNextKeyAfterKey");
        Iterator r4 = r2.keySet().iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L11;
        Object r1 = r4.next();
        if (r0 == true) goto L7;
        if (Intrinsics.areEqual(r1, r3) == false) goto L4;
        r0 = true;
        goto L4
    L7:
        return r1;
    L11:
        return null;
    }
}
