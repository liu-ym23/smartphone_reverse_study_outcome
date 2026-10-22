package org.apache.logging.log4j.spi;

/* JADX INFO: loaded from: classes6.dex */
public interface f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f[] f17903b = null;

    static {
        f17903b = new f[0];
    }

    default c a(Class<?> r2) {
        String r0 = r2.getCanonicalName();
        if (r0 != null) goto L7;
        r0 = r2.getName();
    L7:
        return a(r0);
    }

    c a(String r1);
}
