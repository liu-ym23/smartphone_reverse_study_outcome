package ju1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class n {
    public final Object a;
    public final boolean b;

    public final boolean a() {
        Object r0 = c();
        if ((r0 instanceof Boolean) == true) goto L5;
        r0 = null;
    L5:
        Boolean r1 = (Boolean) r0;
        if (r1 != null) goto L10;
        return false;
    L10:
        return r1.booleanValue();
    }

    public Object c() {
        return this.a;
    }

    public final int b(int r3) {
        Object r0 = c();
        if ((r0 instanceof Number) == true) goto L5;
        r0 = null;
    L5:
        Number r1 = (Number) r0;
        if (r1 != null) goto L8;
        return r3;
    L8:
        return r1.intValue();
    }

    public final String d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "default");
        Object r0 = c();
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 != null) goto L9;
        return r3;
    L9:
        return r1;
    }

    public n(Object r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        this.a = r2;
        this.b = r3;
    }
}
