package androidx.core.util;

import ai.j0;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean r5) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static float checkArgumentFinite(float r5, @NonNull String r10) {
        if (Float.isNaN(r5) == true) goto L10;
        if (Float.isInfinite(r5) == true) goto L8;
        return r5;
    L8:
        throw new IllegalArgumentException(j0.j(r10, " must not be infinite"));
    L10:
        throw new IllegalArgumentException(j0.j(r10, " must not be NaN"));
    }

    public static int checkArgumentInRange(int r5, int r10, int r11, @NonNull String r12) {
        if (r5 < r10) goto L8;
        if (r5 > r11) goto L6;
        return r5;
    L6:
        Locale r13 = Locale.US;
        throw new IllegalArgumentException(r12 + " is out of range of [" + r10 + ", " + r11 + "] (too high)");
    L8:
        Locale r14 = Locale.US;
        throw new IllegalArgumentException(r12 + " is out of range of [" + r10 + ", " + r11 + "] (too low)");
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int r5, @Nullable String r10) {
        if (r5 < 0) goto L5;
        return r5;
    L5:
        throw new IllegalArgumentException(r10);
    }

    public static int checkFlagsArgument(int r5, int r10) {
        if ((r5 & r10) != r5) goto L6;
        return r5;
    L6:
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(r5) + ", but only 0x" + Integer.toHexString(r10) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T r5) {
        r5.getClass();
        return r5;
    }

    public static void checkState(boolean r5, @Nullable String r10) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(r10);
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T r5) {
        if (TextUtils.isEmpty(r5) == true) goto L6;
        return r5;
    L6:
        throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean r5, @NonNull Object r10) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r10));
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int r5) {
        if (r5 < 0) goto L5;
        return r5;
    L5:
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T r5, @NonNull Object r10) {
        if (r5 == null) goto L5;
        return r5;
    L5:
        throw new NullPointerException(String.valueOf(r10));
    }

    public static void checkState(boolean r5) {
        checkState(r5, null);
    }

    public static void checkArgument(boolean r5, @NonNull String r10, @NonNull Object... r11) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r10, r11));
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T r5, @NonNull Object r10) {
        if (TextUtils.isEmpty(r5) == true) goto L6;
        return r5;
    L6:
        throw new IllegalArgumentException(String.valueOf(r10));
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T r5, @NonNull String r10, @NonNull Object... r11) {
        if (TextUtils.isEmpty(r5) == true) goto L6;
        return r5;
    L6:
        throw new IllegalArgumentException(String.format(r10, r11));
    }

    public static long checkArgumentInRange(long r5, long r10, long r11, @NonNull String r12) {
        if (r5 >= r10) goto L5;
        Locale r13 = Locale.US;
        StringBuilder r14 = new StringBuilder();
        r14.append(r12);
        r14.append(" is out of range of [");
        r14.append(r10);
        r14.append(", ");
        throw new IllegalArgumentException(j0.o(r14, r11, "] (too low)"));
    L5:
        if (r5 > r11) goto L7;
        return r5;
    L7:
        Locale r15 = Locale.US;
        StringBuilder r16 = new StringBuilder();
        r16.append(r12);
        r16.append(" is out of range of [");
        r16.append(r10);
        r16.append(", ");
        throw new IllegalArgumentException(j0.o(r16, r11, "] (too high)"));
    }

    public static float checkArgumentInRange(float r5, float r10, float r11, @NonNull String r12) {
        if (r5 < r10) goto L10;
        if (r5 > r11) goto L8;
        return r5;
    L8:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{r12, Float.valueOf(r10), Float.valueOf(r11)}));
    L10:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{r12, Float.valueOf(r10), Float.valueOf(r11)}));
    }

    public static double checkArgumentInRange(double r5, double r10, double r11, @NonNull String r12) {
        if (r5 < r10) goto L10;
        if (r5 > r11) goto L8;
        return r5;
    L8:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{r12, Double.valueOf(r10), Double.valueOf(r11)}));
    L10:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{r12, Double.valueOf(r10), Double.valueOf(r11)}));
    }
}
