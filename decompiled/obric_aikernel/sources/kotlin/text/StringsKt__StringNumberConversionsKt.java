package kotlin.text;

import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public StringsKt__StringNumberConversionsKt() {
    }

    public static final Void numberFormatError(String r10) {
        Intrinsics.checkNotNullParameter(r10, "input");
        throw new NumberFormatException("Invalid number format: '" + r10 + '\'');
    }

    @SinceKotlin(version = "1.1")
    public static final Byte toByteOrNull(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return toByteOrNull(r10, 10);
    }

    @SinceKotlin(version = "1.1")
    public static final Byte toByteOrNull(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Integer r12 = toIntOrNull(r10, r11);
        if (r12 == null) goto L11;
        int r13 = r12.intValue();
        if (r13 < (-128)) goto L11;
        if (r13 > 127) goto L11;
        return Byte.valueOf((byte) r13);
    L11:
        return null;
    }

    @SinceKotlin(version = "1.1")
    public static Integer toIntOrNull(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return toIntOrNull(r10, 10);
    }

    @SinceKotlin(version = "1.1")
    public static final Integer toIntOrNull(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        CharsKt.checkRadix(r11);
        int r12 = r10.length();
        if (r12 != 0) goto L5;
        return null;
    L5:
        int r13 = 0;
        char r14 = r10.charAt(0);
        int r15 = -2147483647;
        int r16 = 1;
        if (Intrinsics.compare(r14, 48) >= 0) goto L16;
        if (r12 != 1) goto L10;
        return null;
    L10:
        if (r14 != '-') goto L13;
        r15 = Integer.MIN_VALUE;
        boolean r17 = true;
    L17:
        int r18 = -59652323;
    L18:
        if (r16 >= r12) goto L31;
        int r19 = CharsKt__CharJVMKt.digitOf(r10.charAt(r16), r11);
        if (r19 < 0) goto L21;
        if (r13 >= r18) goto L27;
        if (r18 != (-59652323)) goto L26;
        r18 = r15 / r11;
        if (r13 >= r18) goto L27;
    L26:
        return null;
    L27:
        int r20 = r13 * r11;
        if (r20 < (r15 + r19)) goto L29;
        r13 = r20 - r19;
        r16 = r16 + 1;
        goto L18
    L29:
        return null;
    L21:
        return null;
    L31:
        if (r17 == false) goto L34;
        return Integer.valueOf(r13);
    L34:
        return Integer.valueOf(-r13);
    L13:
        if (r14 != '+') goto L15;
        r17 = false;
        goto L17
    L15:
        return null;
    L16:
        r17 = false;
        r16 = 0;
        goto L17
    }

    @SinceKotlin(version = "1.1")
    public static Long toLongOrNull(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return toLongOrNull(r10, 10);
    }

    @SinceKotlin(version = "1.1")
    public static final Long toLongOrNull(String r19, int r20) {
        Intrinsics.checkNotNullParameter(r19, "<this>");
        CharsKt.checkRadix(r20);
        int r10 = r19.length();
        if (r10 != 0) goto L5;
        return null;
    L5:
        int r11 = 0;
        char r12 = r19.charAt(0);
        long r13 = -9223372036854775807L;
        boolean r14 = true;
        if (Intrinsics.compare(r12, 48) >= 0) goto L16;
        if (r10 != 1) goto L10;
        return null;
    L10:
        if (r12 != '-') goto L13;
        r13 = Long.MIN_VALUE;
        r11 = 1;
    L17:
        long r15 = -256204778801521550L;
        long r16 = 0;
        long r17 = -256204778801521550L;
    L18:
        if (r11 >= r10) goto L33;
        int r18 = CharsKt__CharJVMKt.digitOf(r19.charAt(r11), r20);
        if (r18 < 0) goto L21;
        if (r16 < r17) goto L25;
    L29:
        long r110 = r16 * ((long) r20);
        long r21 = r18;
        if (r110 < (r13 + r21)) goto L31;
        r16 = r110 - r21;
        r11 = r11 + 1;
        r15 = -256204778801521550L;
        goto L18
    L31:
        return null;
    L25:
        if (r17 != r15) goto L28;
        r17 = r13 / ((long) r20);
        if (r16 >= r17) goto L29;
    L28:
        return null;
    L21:
        return null;
    L33:
        if (r14 == false) goto L36;
        return Long.valueOf(r16);
    L36:
        return Long.valueOf(-r16);
    L13:
        if (r12 != '+') goto L15;
        r14 = false;
        r11 = 1;
        goto L17
    L15:
        return null;
    L16:
        r14 = false;
        goto L17
    }

    @SinceKotlin(version = "1.1")
    public static final Short toShortOrNull(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return toShortOrNull(r10, 10);
    }

    @SinceKotlin(version = "1.1")
    public static final Short toShortOrNull(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Integer r12 = toIntOrNull(r10, r11);
        if (r12 == null) goto L11;
        int r13 = r12.intValue();
        if (r13 < (-32768)) goto L11;
        if (r13 > 32767) goto L11;
        return Short.valueOf((short) r13);
    L11:
        return null;
    }
}
