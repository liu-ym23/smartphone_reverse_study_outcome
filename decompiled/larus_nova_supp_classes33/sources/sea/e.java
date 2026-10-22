package sea;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    public static final AtomicBoolean a = null;
    public static final AtomicBoolean b = null;
    public static final AtomicReference<String> c = null;
    public static final AtomicReference<String> d = null;
    public static final AtomicLong e = null;

    static {
        a = new AtomicBoolean(false);
        b = new AtomicBoolean(false);
        c = new AtomicReference(null);
        d = new AtomicReference(null);
        e = new AtomicLong(0);
    }

    public static String b() {
        return c.get();
    }

    public static void a(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        c.set(null);
        d.set(null);
        return;
    L12:
        AtomicReference<String> r1 = c;
        if (Intrinsics.areEqual(r1.get(), r3) == false) goto L16;
        r1.set(null);
        d.set(null);
        return;
    L16:
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L9
    }

    public static void c(boolean r1) {
        a.set(r1);
    }

    public static void d(boolean r1) {
        b.set(r1);
    }

    public static void e(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        if (r1 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        a(null);
        return;
    L12:
        c.set(r1);
        d.set(r2);
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}
