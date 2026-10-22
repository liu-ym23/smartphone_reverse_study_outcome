package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ObjectsCompat {
    private ObjectsCompat() {
    }

    public static boolean equals(@Nullable Object r5, @Nullable Object r10) {
        return Objects.equals(r5, r10);
    }

    public static int hash(@Nullable Object... r5) {
        return Objects.hash(r5);
    }

    public static int hashCode(@Nullable Object r5) {
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.hashCode();
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T r5) {
        r5.getClass();
        return r5;
    }

    @Nullable
    public static String toString(@Nullable Object r5, @Nullable String r10) {
        if (r5 != null) goto L4;
        return r10;
    L4:
        return r5.toString();
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T r5, @NonNull String r10) {
        if (r5 == null) goto L5;
        return r5;
    L5:
        throw new NullPointerException(r10);
    }
}
