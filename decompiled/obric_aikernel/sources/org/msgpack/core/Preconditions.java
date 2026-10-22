package org.msgpack.core;

import java.util.Objects;
import org.msgpack.core.annotations.Nullable;
import org.msgpack.core.annotations.VisibleForTesting;

/* JADX INFO: loaded from: classes3.dex */
public final class Preconditions {
    private Preconditions() {
    }

    private static String badElementIndex(int r10, int r11, String r12) {
        if (r10 < 0) goto L5;
        if (r11 < 0) goto L10;
        return format("%s (%s) must be less than size (%s)", new Object[]{r12, Integer.valueOf(r10), Integer.valueOf(r11)});
    L10:
        throw new IllegalArgumentException("negative size: " + r11);
    L5:
        return format("%s (%s) must not be negative", new Object[]{r12, Integer.valueOf(r10)});
    }

    private static String badPositionIndex(int r10, int r11, String r12) {
        if (r10 < 0) goto L5;
        if (r11 < 0) goto L10;
        return format("%s (%s) must not be greater than size (%s)", new Object[]{r12, Integer.valueOf(r10), Integer.valueOf(r11)});
    L10:
        throw new IllegalArgumentException("negative size: " + r11);
    L5:
        return format("%s (%s) must not be negative", new Object[]{r12, Integer.valueOf(r10)});
    }

    private static String badPositionIndexes(int r10, int r11, int r12) {
        if (r10 < 0) goto L13;
        if (r10 > r12) goto L13;
        if (r11 < 0) goto L11;
        if (r11 > r12) goto L11;
        return format("end index (%s) must not be less than start index (%s)", new Object[]{Integer.valueOf(r11), Integer.valueOf(r10)});
    L11:
        return badPositionIndex(r11, r12, "end index");
    L13:
        return badPositionIndex(r10, r12, "start index");
    }

    public static void checkArgument(boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean r10, @Nullable Object r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r11));
    }

    public static void checkArgument(boolean r10, @Nullable String r11, @Nullable Object... r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(format(r11, r12));
    }

    public static int checkElementIndex(int r10, int r11) {
        return checkElementIndex(r10, r11, "index");
    }

    public static int checkElementIndex(int r10, int r11, @Nullable String r12) {
        if (r10 < 0) goto L6;
        if (r10 >= r11) goto L6;
        return r10;
    L6:
        throw new IndexOutOfBoundsException(badElementIndex(r10, r11, r12));
    }

    public static <T> T checkNotNull(T r10) {
        Objects.requireNonNull(r10);
        return r10;
    }

    public static <T> T checkNotNull(T r10, @Nullable Object r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(String.valueOf(r11));
    }

    public static <T> T checkNotNull(T r10, @Nullable String r11, @Nullable Object... r12) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(format(r11, r12));
    }

    public static int checkPositionIndex(int r10, int r11) {
        return checkPositionIndex(r10, r11, "index");
    }

    public static int checkPositionIndex(int r10, int r11, @Nullable String r12) {
        if (r10 < 0) goto L6;
        if (r10 > r11) goto L6;
        return r10;
    L6:
        throw new IndexOutOfBoundsException(badPositionIndex(r10, r11, r12));
    }

    public static void checkPositionIndexes(int r10, int r11, int r12) {
        if (r10 < 0) goto L7;
        if (r11 < r10) goto L7;
        if (r11 > r12) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(badPositionIndexes(r10, r11, r12));
    }

    public static void checkState(boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException();
    }

    public static void checkState(boolean r10, @Nullable Object r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.valueOf(r11));
    }

    public static void checkState(boolean r10, @Nullable String r11, @Nullable Object... r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(format(r11, r12));
    }

    @VisibleForTesting
    static String format(String r10, @Nullable Object... r11) {
        String r12 = String.valueOf(r10);
        StringBuilder r13 = new StringBuilder(r12.length() + (r11.length * 16));
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r14 >= r11.length) goto L9;
        int r16 = r12.indexOf("%s", r15);
        if (r16 == (-1)) goto L9;
        r13.append(r12.substring(r15, r16));
        r13.append(r11[r14]);
        r15 = r16 + 2;
        r14 = r14 + 1;
    L9:
        r13.append(r12.substring(r15));
        if (r14 >= r11.length) goto L17;
        r13.append(" [");
        int r17 = r14 + 1;
        r13.append(r11[r14]);
    L13:
        if (r17 >= r11.length) goto L15;
        r13.append(", ");
        r13.append(r11[r17]);
        r17 = r17 + 1;
        goto L13
    L15:
        r13.append(']');
    L17:
        return r13.toString();
    }
}
