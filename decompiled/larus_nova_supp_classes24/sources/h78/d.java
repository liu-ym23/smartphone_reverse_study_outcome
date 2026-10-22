package h78;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements b {
    public final List<String> a;

    public d(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "prefixCodeList");
        this.a = r2;
    }

    @Override // h78.b
    public final boolean a(String r7) {
        List<String> r0 = this.a;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (StringsKt.startsWith$default(r7, (String) r1.next(), false, 2, null) == false) goto L9;
        boolean r8 = true;
    L14:
        if (r8 == true) goto L21;
        return false;
    L21:
        return true;
    L13:
        r8 = false;
        goto L14
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }
}
