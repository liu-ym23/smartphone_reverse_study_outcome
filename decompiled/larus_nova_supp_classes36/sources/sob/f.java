package sob;

import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Method a(Class r8, Object[] r9) {
        Iterator r0 = ArrayIteratorKt.iterator(r8.getDeclaredMethods());
    L4:
        if (r0.hasNext() == false) goto L28;
        Method r1 = (Method) r0.next();
        if (Intrinsics.areEqual(r1.getName(), "forceToEnd") == false) goto L4;
        Class<?>[] r2 = r1.getParameterTypes();
        boolean r3 = false;
        if (r2 == null) goto L24;
        if (r2.length == 0) goto L24;
        if (r2.length != r9.length) goto L26;
        int r4 = r2.length;
        int r5 = 0;
    L16:
        if (r5 >= r4) goto L25;
        Object r6 = r9[r5];
        if (r6 == null) goto L22;
        if (r2[r5].isAssignableFrom(r6.getClass()) == false) goto L26;
    L22:
        r5 = r5 + 1;
    L25:
        r3 = true;
    L26:
        if (r3 == false) goto L4;
        return r1;
    L24:
        if (r9.length != 0) goto L26;
    L28:
        Class r10 = r8.getSuperclass();
        if (r10 != null) goto L43;
        return null;
    L43:
        return a(r10, r9);
    }
}
