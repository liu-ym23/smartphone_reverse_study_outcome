package io.reactivex.internal.functions;

import io.reactivex.b.d;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final d<Object, Object> f16718a = null;

    /* JADX INFO: renamed from: io.reactivex.internal.functions.a$a, reason: collision with other inner class name */
    static final class C0872a implements d<Object, Object> {
        C0872a() {
        }

        @Override // io.reactivex.b.d
        public boolean a(Object r1, Object r2) {
            return a.a(r1, r2);
        }
    }

    static {
        f16718a = new C0872a();
    }

    public static int a(int r0, int r1) {
        if (r0 >= r1) goto L4;
        return -1;
    L4:
        if (r0 <= r1) goto L6;
        return 1;
    L6:
        return 0;
    }

    public static int a(int r2, String r3) {
        if (r2 <= 0) goto L5;
        return r2;
    L5:
        throw new IllegalArgumentException(r3 + " > 0 required but it was " + r2);
    }

    public static int a(long r0, long r2) {
        if (r0 >= r2) goto L5;
        return -1;
    L5:
        if (r0 <= r2) goto L7;
        return 1;
    L7:
        return 0;
    }

    public static long a(long r2, String r4) {
        if (r2 <= 0) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException(r4 + " > 0 required but it was " + r2);
    }

    public static <T> T a(T r0, String r1) {
        Objects.requireNonNull(r0, r1);
        return r0;
    }

    public static boolean a(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }
}
