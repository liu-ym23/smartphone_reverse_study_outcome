package io.reactivex.internal.functions;

import java.util.Objects;
import zb.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: io.reactivex.internal.functions.a$a, reason: collision with other inner class name */
    static final class C0201a implements d<Object, Object> {
        C0201a() {
        }

        @Override // zb.d
        public boolean a(Object r10, Object r11) {
            return a.c(r10, r11);
        }
    }

    static {
        new C0201a();
    }

    public static int a(int r10, int r11) {
        if (r10 >= r11) goto L4;
        return -1;
    L4:
        if (r10 <= r11) goto L6;
        return 1;
    L6:
        return 0;
    }

    public static int b(long r10, long r11) {
        if (r10 >= r11) goto L5;
        return -1;
    L5:
        if (r10 <= r11) goto L7;
        return 1;
    L7:
        return 0;
    }

    public static boolean c(Object r10, Object r11) {
        if (r10 == r11) goto L8;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals(r11) == false) goto L7;
    L8:
        return true;
    }

    public static <T> T d(T r10, String r11) {
        Objects.requireNonNull(r10, r11);
        return r10;
    }

    public static int e(int r10, String r11) {
        if (r10 <= 0) goto L5;
        return r10;
    L5:
        throw new IllegalArgumentException(r11 + " > 0 required but it was " + r10);
    }

    public static long f(long r10, String r11) {
        if (r10 <= 0) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException(r11 + " > 0 required but it was " + r10);
    }
}
