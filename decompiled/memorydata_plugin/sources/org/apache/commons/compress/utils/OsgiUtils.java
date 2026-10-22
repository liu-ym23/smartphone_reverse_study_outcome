package org.apache.commons.compress.utils;

/* JADX INFO: loaded from: classes6.dex */
public class OsgiUtils {
    private static final boolean inOsgiEnvironment = false;

    static {
        inOsgiEnvironment = isBundleReference(OsgiUtils.class.getClassLoader().getClass());
    }

    public OsgiUtils() {
    }

    private static boolean isBundleReference(Class<?> r5) {
    L2:
        int r0 = 0;
        if (r5 == null) goto L14;
        if (r5.getName().equals("org.osgi.framework.BundleReference") == true) goto L6;
        Class<?>[] r1 = r5.getInterfaces();
        int r3 = r1.length;
    L8:
        if (r0 >= r3) goto L13;
        if (isBundleReference(r1[r0]) == true) goto L11;
        r0 = r0 + 1;
        goto L8
    L11:
        return true;
    L13:
        r5 = r5.getSuperclass();
        goto L2
    L6:
        return true;
    L14:
        return false;
    }

    public static boolean isRunningInOsgiEnvironment() {
        return inOsgiEnvironment;
    }
}
