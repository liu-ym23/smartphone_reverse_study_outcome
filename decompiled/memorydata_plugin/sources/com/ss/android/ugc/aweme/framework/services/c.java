package com.ss.android.ugc.aweme.framework.services;

import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Double f15743a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Float f15744b = null;

    static {
        f15743a = Double.valueOf(0.0d);
        f15744b = Float.valueOf(0.0f);
    }

    public static <T> T a(Class<T> r2) {
        a(r2);
        if (r2 != Boolean.TYPE) goto L7;
        return (T) Boolean.FALSE;
    L7:
        if (r2 != Character.TYPE) goto L11;
        return (T) (char) 0;
    L11:
        if (r2 != Byte.TYPE) goto L15;
        return (T) (byte) 0;
    L15:
        if (r2 != Short.TYPE) goto L19;
        return (T) (short) 0;
    L19:
        if (r2 != Integer.TYPE) goto L23;
        return (T) 0;
    L23:
        if (r2 != Long.TYPE) goto L27;
        return (T) 0L;
    L27:
        if (r2 != Float.TYPE) goto L31;
        return (T) f15744b;
    L31:
        if (r2 == Double.TYPE) goto L33;
        return null;
    L33:
        return (T) f15743a;
    }

    public static <T> T a(T r0) {
        Objects.requireNonNull(r0);
        return r0;
    }
}
