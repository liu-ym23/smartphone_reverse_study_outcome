package androidx.core.util;

import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ObjectsCompat {

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static boolean equals(Object r10, Object r11) {
            return Objects.equals(r10, r11);
        }

        @DoNotInline
        static int hash(Object... r10) {
            return Objects.hash(r10);
        }
    }

    private ObjectsCompat() {
    }

    public static boolean equals(@Nullable Object r10, @Nullable Object r11) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        if (r10 == r11) goto L12;
        if (r10 != null) goto L9;
    L11:
        return false;
    L9:
        if (r10.equals(r11) == false) goto L11;
    L12:
        return true;
    L5:
        return Api19Impl.equals(r10, r11);
    }

    public static int hash(@Nullable Object... r10) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.hash(r10);
    L7:
        return Arrays.hashCode(r10);
    }

    public static int hashCode(@Nullable Object r10) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T r10) {
        Objects.requireNonNull(r10);
        return r10;
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T r10, @NonNull String r11) {
        Objects.requireNonNull(r10, r11);
        return r10;
    }

    @Nullable
    public static String toString(@Nullable Object r10, @Nullable String r11) {
        if (r10 != null) goto L4;
        return r11;
    L4:
        return r10.toString();
    }
}
