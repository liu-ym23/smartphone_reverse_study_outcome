package kotlin.text;

import androidx.room.jarjarred.org.antlr.runtime.a;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public StringsKt__StringNumberConversionsKt() {
    }

    public static final Void numberFormatError(String r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        throw new NumberFormatException(a.p("Invalid number format: '", '\'', r5));
    }

    @SinceKotlin(version = "1.1")
    public static final Byte toByteOrNull(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return toByteOrNull(r5, 10);
    }

    @SinceKotlin(version = "1.1")
    public static Integer toIntOrNull(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return toIntOrNull(r5, 10);
    }

    @SinceKotlin(version = "1.1")
    public static Long toLongOrNull(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return toLongOrNull(r5, 10);
    }

    @SinceKotlin(version = "1.1")
    public static final Short toShortOrNull(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return toShortOrNull(r5, 10);
    }

    @SinceKotlin(version = "1.1")
    public static final Byte toByteOrNull(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Integer r11 = toIntOrNull(r5, r10);
        if (r11 == null) goto L11;
        int r12 = r11.intValue();
        if (r12 < (-128)) goto L11;
        if (r12 > 127) goto L11;
        return Byte.valueOf((byte) r12);
    L11:
        return null;
    }

    @SinceKotlin(version = "1.1")
    public static final Integer toIntOrNull(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        CharsKt__CharJVMKt.checkRadix(r11);
        int r5 = r10.length();
        if (r5 != 0) goto L5;
        return null;
    L5:
        int r12 = 0;
        char r13 = r10.charAt(0);
        int r14 = -2147483647;
        if (Intrinsics.compare(r13, 48) >= 0) goto L17;
        int r15 = 1;
        if (r5 != 1) goto L11;
        return null;
    L11:
        if (r13 != '-') goto L14;
        r14 = Integer.MIN_VALUE;
        boolean r16 = true;
    L18:
        int r17 = -59652323;
    L19:
        if (r15 >= r5) goto L32;
        int r18 = CharsKt__CharJVMKt.digitOf(r10.charAt(r15), r11);
        if (r18 < 0) goto L22;
        if (r12 >= r17) goto L28;
        if (r17 != (-59652323)) goto L27;
        r17 = r14 / r11;
        if (r12 >= r17) goto L28;
    L27:
        return null;
    L28:
        int r19 = r12 * r11;
        if (r19 < (r14 + r18)) goto L30;
        r12 = r19 - r18;
        r15 = r15 + 1;
        goto L19
    L30:
        return null;
    L22:
        return null;
    L32:
        if (r16 == false) goto L35;
        return Integer.valueOf(r12);
    L35:
        return Integer.valueOf(-r12);
    L14:
        if (r13 != '+') goto L16;
        r16 = false;
        goto L18
    L16:
        return null;
    L17:
        r16 = false;
        r15 = 0;
        goto L18
    }

    @SinceKotlin(version = "1.1")
    public static final Long toLongOrNull(String r19, int r20) {
        Intrinsics.checkNotNullParameter(r19, "<this>");
        CharsKt__CharJVMKt.checkRadix(r20);
        int r5 = r19.length();
        if (r5 != 0) goto L5;
        return null;
    L5:
        int r10 = 0;
        char r11 = r19.charAt(0);
        long r12 = -9223372036854775807L;
        if (Intrinsics.compare(r11, 48) >= 0) goto L17;
        boolean r13 = true;
        if (r5 != 1) goto L11;
        return null;
    L11:
        if (r11 != '-') goto L14;
        r12 = Long.MIN_VALUE;
        r10 = 1;
    L18:
        long r14 = -256204778801521550L;
        long r15 = 0;
        long r16 = -256204778801521550L;
    L19:
        if (r10 >= r5) goto L34;
        int r17 = CharsKt__CharJVMKt.digitOf(r19.charAt(r10), r20);
        if (r17 < 0) goto L22;
        if (r15 < r16) goto L26;
    L30:
        long r18 = r15 * ((long) r20);
        long r21 = r17;
        if (r18 < (r12 + r21)) goto L32;
        r15 = r18 - r21;
        r10 = r10 + 1;
        r14 = -256204778801521550L;
        goto L19
    L32:
        return null;
    L26:
        if (r16 != r14) goto L29;
        r16 = r12 / ((long) r20);
        if (r15 >= r16) goto L30;
    L29:
        return null;
    L22:
        return null;
    L34:
        if (r13 == false) goto L37;
        return Long.valueOf(r15);
    L37:
        return Long.valueOf(-r15);
    L14:
        if (r11 != '+') goto L16;
        r13 = false;
        r10 = 1;
        goto L18
    L16:
        return null;
    L17:
        r13 = false;
        goto L18
    }

    @SinceKotlin(version = "1.1")
    public static final Short toShortOrNull(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Integer r11 = toIntOrNull(r5, r10);
        if (r11 == null) goto L11;
        int r12 = r11.intValue();
        if (r12 < (-32768)) goto L11;
        if (r12 > 32767) goto L11;
        return Short.valueOf((short) r12);
    L11:
        return null;
    }
}
