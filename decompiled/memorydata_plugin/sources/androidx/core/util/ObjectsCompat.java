package androidx.core.util;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ObjectsCompat {

    static class Api19Impl {
        private Api19Impl() {
        }

        static boolean equals(Object r0, Object r1) {
            return Objects.equals(r0, r1);
        }

        static int hash(Object... r0) {
            return Objects.hash(r0);
        }
    }

    private ObjectsCompat() {
    }

    public static boolean equals(Object r2, Object r3) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        if (r2 == r3) goto L12;
        if (r2 != null) goto L9;
    L11:
        return false;
    L9:
        if (r2.equals(r3) == false) goto L11;
    L12:
        return true;
    L5:
        return Api19Impl.equals(r2, r3);
    }

    public static int hash(Object... r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.hash(r2);
    L7:
        return Arrays.hashCode(r2);
    }

    public static int hashCode(Object r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public static <T> T requireNonNull(T r0) {
        Objects.requireNonNull(r0);
        return r0;
    }

    public static <T> T requireNonNull(T r0, String r1) {
        Objects.requireNonNull(r0, r1);
        return r0;
    }

    public static String toString(Object r0, String r1) {
        if (r0 != null) goto L4;
        return r1;
    L4:
        return r0.toString();
    }
}
