package ms.bd.c;

import android.content.Context;
import android.location.LocationManager;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class w1 {
    public static x1 a(Context r13, String r14) {
        LocationManager r15 = (LocationManager) r13.getSystemService((String) p2.a(16777217, 0, 0, "5184cb", new byte[]{40, 60, 72, 65, 72, 124, 57, 30}));     // Catch: Throwable -> L36
        if (r15 != null) goto L7;
        return new x1(-10, "", "", null);
    L7:
        Field[] r1 = r15.getClass().getDeclaredFields();
        if (r1 == null) goto L10;
        int r2 = r1.length;
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L30;
        Field r4 = r1[r3];
        r4.setAccessible(true);
        Object r5 = r4.get(r15);     // Catch: IllegalAccessException -> L28
        if (r5 == null) goto L27;
        if ((r5 instanceof String) == true) goto L27;
        Class<?>[] r6 = r5.getClass().getInterfaces();
        if (r6 == null) goto L27;
        if (r6.length == 0) goto L27;
        if (r14.equals(r6[0].getName()) == false) goto L27;
    L31:
        if (r5 != null) goto L35;
        return new x1(-22, "", "", null);
    L35:
        return new x1(r5 instanceof Proxy ? 1 : 0, r4.getName(), r5.getClass().getName(), null);
    L27:
        r3 = r3 + 1;
    L29:
        return new x1(-21, "", "", null);
    L30:
        r4 = null;
        r5 = null;
        goto L31
    L10:
        return new x1(-20, "", "", null);
    L37:
        return new x1(-11, "", "", null);
    }
}
