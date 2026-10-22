package de;

import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7074a = null;

    static {
        Object r8 = fe.a.class.newInstance();     // Catch: ClassNotFoundException -> L12
        i.e(r8, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L12
        a r10 = (a) r8;     // Catch: ClassCastException -> L6 ClassNotFoundException -> L12
    L40:
        f7074a = r10;
        return;
    L6:
        e = move-exception;
        ClassLoader r11 = r8.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L12
        ClassLoader r12 = a.class.getClassLoader();     // Catch: ClassNotFoundException -> L12
        if (i.a(r11, r12) == false) goto L10;
        throw e;     // Catch: ClassNotFoundException -> L12
    L10:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r11 + ", base type classloader: " + r12, e);     // Catch: ClassNotFoundException -> L12
    L21:
        Object r13 = ee.a.class.newInstance();     // Catch: ClassNotFoundException -> L30
        i.e(r13, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L30
        r10 = (a) r13;     // Catch: ClassCastException -> L24 ClassNotFoundException -> L30
    L24:
        e = move-exception;
        ClassLoader r14 = r13.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L30
        ClassLoader r15 = a.class.getClassLoader();     // Catch: ClassNotFoundException -> L30
        if (i.a(r14, r15) == false) goto L28;
        throw e;     // Catch: ClassNotFoundException -> L30
    L28:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r14 + ", base type classloader: " + r15, e);     // Catch: ClassNotFoundException -> L30
    L30:
        Object r16 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();     // Catch: ClassNotFoundException -> L39
        i.e(r16, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L39
        r10 = (a) r16;     // Catch: ClassCastException -> L33 ClassNotFoundException -> L39
    L33:
        e = move-exception;
        ClassLoader r17 = r16.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L39
        ClassLoader r18 = a.class.getClassLoader();     // Catch: ClassNotFoundException -> L39
        if (i.a(r17, r18) == false) goto L37;
        throw e;     // Catch: ClassNotFoundException -> L39
    L37:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r17 + ", base type classloader: " + r18, e);     // Catch: ClassNotFoundException -> L39
    L39:
        r10 = new a();
    L12:
        Object r19 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();     // Catch: ClassNotFoundException -> L21
        i.e(r19, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L21
        r10 = (a) r19;     // Catch: ClassCastException -> L15 ClassNotFoundException -> L21
    L15:
        e = move-exception;
        ClassLoader r20 = r19.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L21
        ClassLoader r21 = a.class.getClassLoader();     // Catch: ClassNotFoundException -> L21
        if (i.a(r20, r21) == false) goto L19;
        throw e;     // Catch: ClassNotFoundException -> L21
    L19:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r20 + ", base type classloader: " + r21, e);     // Catch: ClassNotFoundException -> L21
    }
}
