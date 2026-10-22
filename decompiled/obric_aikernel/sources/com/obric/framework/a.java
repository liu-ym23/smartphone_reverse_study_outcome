package com.obric.framework;

import com.obric.aikernel.runtime.utils.i;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5794a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<Integer> f5795b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Class<byte[]> f5796c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile Class<?> f5797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile Object f5798e;

    static {
        f5794a = new a();
        Class<Integer> r10 = Integer.TYPE;
        Intrinsics.checkNotNull(r10);
        f5795b = r10;
        f5796c = byte[].class;
    }

    private a() {
    }

    private final Object a() {
        Method r10 = c().getMethod("getInstance", new Class[0]);
        Intrinsics.checkNotNullExpressionValue(r10, "getEncryptClass().getMethod(\"getInstance\")");
        Object r11 = r10.invoke(null, new Object[0]);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalArgumentException("FileEncrypt.getInstance() returned null".toString());
    }

    private final Class<?> c() {
        Class<?> r10 = f5797d;
        if (r10 == null) goto L5;
        return r10;
    L5:
        monitor-enter(this);
        Class<?> r11 = f5797d;     // Catch: Throwable -> L12
        if (r11 != null) goto L9;
        r11 = Class.forName(i.e());     // Catch: Throwable -> L12
        f5797d = r11;     // Catch: Throwable -> L12
    L9:
        monitor-exit(this);
        Intrinsics.checkNotNullExpressionValue(r11, "synchronized(this) {\n   …t\n            }\n        }");
        return r11;
    L12:
        th = move-exception;
        throw th;
    }

    private final Object d() {
        Object r10 = f5798e;
        if (r10 == null) goto L5;
        return r10;
    L5:
        monitor-enter(this);
        Object r11 = f5798e;     // Catch: Throwable -> L11
        if (r11 != null) goto L9;
        r11 = f5794a.a();     // Catch: Throwable -> L11
        f5798e = r11;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return r11;
    L11:
        th = move-exception;
        throw th;
    }

    private final Object f(String r10, Class<?>[] r11, Object[] r12) {
        return c().getMethod(r10, (Class[]) Arrays.copyOf(r11, r11.length)).invoke(d(), Arrays.copyOf(r12, r12.length));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final byte[] b(String r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "password");
        Intrinsics.checkNotNullParameter(r11, "salt");
        Object r12 = f("genSecret", new Class[]{String.class, f5796c}, new Object[]{r10, r11});
        if ((r12 instanceof byte[]) == false) goto L5;
        byte[] r13 = (byte[]) r12;
    L6:
        if (r13 == null) goto L9;
        return r13;
    L9:
        throw new IllegalStateException("FileEncrypt#genSecret returned null or non-ByteArray".toString());
    L5:
        r13 = null;
        goto L6
    }

    public final String e(int r10, int r11) {
        Class<Integer> r12 = f5795b;
        Object r13 = f("getStorageDirWithId", new Class[]{r12, r12}, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)});
        if ((r13 instanceof String) == true) goto L7;
        return null;
    L7:
        return (String) r13;
    }

    public final void g(int r10, int r11) {
        Class<Integer> r12 = f5795b;
        f("serviceKeyDeleteWithId", new Class[]{r12, r12}, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(int r10, byte[] r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "secret");
        Class<Integer> r13 = f5795b;
        f("serviceKeyInitWithId", new Class[]{r13, f5796c, r13}, new Object[]{Integer.valueOf(r10), r11, Integer.valueOf(r12)});
    }
}
