package r41;

import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final boolean a = false;
    public static final int b = 0;
    public static final boolean c = false;

    static {
        y41.f r0 = y41.f.N;
        r0.getClass();
        ReadOnlyProperty r1 = y41.f.q;
        KProperty[] r2 = y41.f.a;
        boolean r4 = ((Boolean) r1.getValue(r0, r2[15])).booleanValue();
        a = r4;
        if (r4 == false) goto L5;
        int r5 = 9;
    L6:
        b = r5;
        if (((Boolean) r1.getValue(r0, r2[15])).booleanValue() == true) goto L9;
    L11:
        boolean r3 = false;
    L12:
        c = r3;
        return;
    L9:
        if (((Boolean) y41.f.r.getValue(r0, r2[16])).booleanValue() == false) goto L11;
        r3 = true;
        goto L12
    L5:
        r5 = 4;
        goto L6
    }
}
