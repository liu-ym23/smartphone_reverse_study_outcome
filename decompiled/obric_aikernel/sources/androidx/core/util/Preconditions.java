package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean r10, @NonNull Object r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r11));
    }

    public static void checkArgument(boolean r10, @NonNull String r11, @NonNull Object... r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r11, r12));
    }

    public static float checkArgumentFinite(float r10, @NonNull String r11) {
        if (Float.isNaN(r10) == true) goto L10;
        if (Float.isInfinite(r10) == true) goto L8;
        return r10;
    L8:
        throw new IllegalArgumentException(r11 + " must not be infinite");
    L10:
        throw new IllegalArgumentException(r11 + " must not be NaN");
    }

    public static double checkArgumentInRange(double r10, double r11, double r12, @NonNull String r13) {
        if (r10 < r11) goto L10;
        if (r10 > r12) goto L8;
        return r10;
    L8:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{r13, Double.valueOf(r11), Double.valueOf(r12)}));
    L10:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{r13, Double.valueOf(r11), Double.valueOf(r12)}));
    }

    public static float checkArgumentInRange(float r10, float r11, float r12, @NonNull String r13) {
        if (r10 < r11) goto L10;
        if (r10 > r12) goto L8;
        return r10;
    L8:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{r13, Float.valueOf(r11), Float.valueOf(r12)}));
    L10:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{r13, Float.valueOf(r11), Float.valueOf(r12)}));
    }

    public static int checkArgumentInRange(int r10, int r11, int r12, @NonNull String r13) {
        if (r10 < r11) goto L9;
        if (r10 > r12) goto L7;
        return r10;
    L7:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{r13, Integer.valueOf(r11), Integer.valueOf(r12)}));
    L9:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{r13, Integer.valueOf(r11), Integer.valueOf(r12)}));
    }

    public static long checkArgumentInRange(long r10, long r11, long r12, @NonNull String r13) {
        if (r10 < r11) goto L10;
        if (r10 > r12) goto L8;
        return r10;
    L8:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{r13, Long.valueOf(r11), Long.valueOf(r12)}));
    L10:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{r13, Long.valueOf(r11), Long.valueOf(r12)}));
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int r10) {
        if (r10 < 0) goto L5;
        return r10;
    L5:
        throw new IllegalArgumentException();
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int r10, @Nullable String r11) {
        if (r10 < 0) goto L5;
        return r10;
    L5:
        throw new IllegalArgumentException(r11);
    }

    public static int checkFlagsArgument(int r10, int r11) {
        if ((r10 & r11) != r10) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(r10) + ", but only 0x" + Integer.toHexString(r11) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T r10) {
        Objects.requireNonNull(r10);
        return r10;
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T r10, @NonNull Object r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(String.valueOf(r11));
    }

    public static void checkState(boolean r10) {
        checkState(r10, null);
    }

    public static void checkState(boolean r10, @Nullable String r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(r11);
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T r10) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T r10, @NonNull Object r11) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException(String.valueOf(r11));
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T r10, @NonNull String r11, @NonNull Object... r12) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException(String.format(r11, r12));
    }
}
