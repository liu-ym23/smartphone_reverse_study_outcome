package org.slf4j.helpers;

/* JADX INFO: loaded from: classes8.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f20277a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f20278b = false;

    /* JADX INFO: renamed from: org.slf4j.helpers.l$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a extends SecurityManager {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        @Override // java.lang.SecurityManager
        public Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    static {
    }

    private l() {
    }

    public static Class<?> a() {
        a r0 = b();
        if (r0 != null) goto L6;
        return null;
    L6:
        Class<?>[] r1 = r0.getClassContext();
        String r2 = l.class.getName();
        int r3 = 0;
    L8:
        if (r3 >= r1.length) goto L14;
        if (r2.equals(r1[r3].getName()) == true) goto L14;
        r3 = r3 + 1;
    L14:
        if (r3 >= r1.length) goto L20;
        int r4 = r3 + 2;
        if (r4 >= r1.length) goto L20;
        return r1[r4];
    L20:
        throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
    }

    public static String a(String r1) {
        if (r1 == null) goto L7;
        return System.getProperty(r1);
    L11:
        return null;
    L7:
        throw new IllegalArgumentException("null input");
    }

    public static final void a(String r1, Throwable r2) {
        System.err.println(r1);
        System.err.println("Reported exception:");
        r2.printStackTrace();
    }

    private static a b() {
        a r0 = f20277a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (f20278b == false) goto L9;
        return null;
    L9:
        a r1 = c();
        f20277a = r1;
        f20278b = true;
        return r1;
    }

    public static boolean b(String r1) {
        String r2 = a(r1);
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.equalsIgnoreCase("true");
    }

    private static a c() {
        return new a(null);
    L5:
        return null;
    }

    public static final void c(String r3) {
        System.err.println("SLF4J: " + r3);
    }
}
