package he;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public i() {
    }

    public static boolean a(Object r8, Object r10) {
        if (r8 != null) goto L7;
        if (r10 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r8.equals(r10);
    }

    public static void b(Object r8, String r10) {
        if (r8 == null) goto L4;
        return;
    L4:
        IllegalStateException r11 = new IllegalStateException(r10.concat(" must not be null"));
        i(i.class.getName(), r11);
        throw r11;
    }

    public static void c(Object r8) {
        if (r8 == null) goto L4;
        return;
    L4:
        NullPointerException r10 = new NullPointerException();
        i(i.class.getName(), r10);
        throw r10;
    }

    public static void d(Object r8, String r10) {
        if (r8 == null) goto L4;
        return;
    L4:
        NullPointerException r11 = new NullPointerException(r10);
        i(i.class.getName(), r11);
        throw r11;
    }

    public static void e(Object r8, String r10) {
        if (r8 == null) goto L4;
        return;
    L4:
        NullPointerException r11 = new NullPointerException(r10.concat(" must not be null"));
        i(i.class.getName(), r11);
        throw r11;
    }

    public static void f(Object r8, String r10) {
        if (r8 == null) goto L4;
        return;
    L4:
        NullPointerException r11 = new NullPointerException(h(r10));
        i(i.class.getName(), r11);
        throw r11;
    }

    public static void g(Object r8, String r10) {
        if (r8 == null) goto L4;
        return;
    L4:
        IllegalArgumentException r11 = new IllegalArgumentException(h(r10));
        i(i.class.getName(), r11);
        throw r11;
    }

    public static String h(String r8) {
        StackTraceElement[] r10 = Thread.currentThread().getStackTrace();
        String r11 = i.class.getName();
        int r12 = 0;
    L4:
        if (r10[r12].getClassName().equals(r11) == true) goto L7;
        r12 = r12 + 1;
    L7:
        if (r10[r12].getClassName().equals(r11) == false) goto L9;
        r12 = r12 + 1;
        goto L7
    L9:
        StackTraceElement r13 = r10[r12];
        StringBuilder r14 = defpackage.b.i("Parameter specified as non-null is null: method ", r13.getClassName(), ".", r13.getMethodName(), ", parameter ");
        r14.append(r8);
        return r14.toString();
    }

    public static void i(String r8, RuntimeException r10) {
        StackTraceElement[] r11 = r10.getStackTrace();
        int r12 = r11.length;
        int r13 = -1;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L8;
        if (r8.equals(r11[r14].getClassName()) == false) goto L7;
        r13 = r14;
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        r10.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(r11, r13 + 1, r12));
    }

    public static void j(String r8) {
        xd.i r10 = new xd.i(defpackage.b.d("lateinit property ", r8, " has not been initialized"));
        i(i.class.getName(), r10);
        throw r10;
    }
}
