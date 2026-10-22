package cb8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x1 {
    public static final <T> int a(List<? extends jc8.a> r3, jc8.a r4, Class<T> r5) {
        Intrinsics.checkNotNullParameter(r4, "blockBizModel");
        Intrinsics.checkNotNullParameter(r5, "clazz");
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        T r1 = r6.next();
        if (r5.isInstance((jc8.a) r1) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        Iterator r7 = r0.iterator();
        int r8 = 0;
    L10:
        if (r7.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((jc8.a) r7.next()).h(), r4.h()) == true) goto L17;
        r8 = r8 + 1;
    L17:
        return r8 + 1;
    L15:
        r8 = -1;
        goto L17
    }

    public static final <T> int b(jc8.k r1, jc8.a r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        Intrinsics.checkNotNullParameter(r3, "clazz");
        if (r1 == null) goto L7;
        List<jc8.a> r4 = r1.b();
        if (r4 == null) goto L7;
        return a(r4, r2, r3);
    L7:
        return 1;
    }
}
