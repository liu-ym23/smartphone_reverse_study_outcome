package x3;

/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Class<?>[] f13505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Object[] f13506b = null;

    static {
        f13505a = new Class[0];
        f13506b = new Object[0];
    }

    static boolean a(Object[] r10, Object[] r11) {
        if (r10 != null) goto L6;
        if (r11 == null) goto L6;
        if (r11.length <= 0) goto L6;
        return false;
    L6:
        if (r11 != null) goto L10;
        if (r10 == null) goto L10;
        if (r10.length <= 0) goto L10;
        return false;
    L10:
        if (r10 == null) goto L16;
        if (r11 != null) goto L13;
        return true;
    L13:
        if (r10.length == r11.length) goto L21;
        return false;
    L21:
        return true;
    L16:
        return true;
    }

    static Object[] b(Object[] r10) {
        if (r10 == null) goto L7;
        if (r10.length <= 0) goto L7;
        return r10;
    L7:
        return f13506b;
    }

    static Class<?>[] c(Object... r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.length == 0) goto L8;
        Class<?>[] r11 = new Class[r10.length];
        int r12 = 0;
    L11:
        if (r12 >= r10.length) goto L17;
        if (r10[r12] != null) goto L15;
        Class<?> r13 = null;
    L16:
        r11[r12] = r13;
        r12 = r12 + 1;
        goto L11
    L15:
        r13 = r10[r12].getClass();
        goto L16
    L17:
        return r11;
    L8:
        return f13505a;
    }
}
