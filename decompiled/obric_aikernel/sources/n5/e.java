package n5;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f11255a;

    static {
        Method[] r10 = Class.forName("android.os.SystemProperties").getMethods();     // Catch: ClassNotFoundException -> L15
        int r11 = r10.length;     // Catch: ClassNotFoundException -> L15
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L25;
        Method r13 = r10[r12];     // Catch: ClassNotFoundException -> L15
        String r14 = r13.getName();     // Catch: ClassNotFoundException -> L15
        if (r14.equals("get") == false) goto L8;
        f11255a = r13;     // Catch: ClassNotFoundException -> L15
    L14:
        r12 = r12 + 1;
        goto L3
    L8:
        if (r14.equals("set") == true) goto L14;
        if (r14.equals("getLong") == true) goto L14;
        r14.equals("getInt");     // Catch: ClassNotFoundException -> L15
        goto L14
    L25:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    public static String a(String r10, String r11) {
        Method r12 = f11255a;
        if (r12 != null) goto L15;
        return r11;
    L15:
        return (String) r12.invoke(null, new Object[]{r10, r11});
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        return r11;
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
