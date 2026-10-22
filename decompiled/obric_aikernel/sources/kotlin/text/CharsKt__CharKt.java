package kotlin.text;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nChar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Char.kt\nkotlin/text/CharsKt__CharKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,344:1\n1#2:345\n*E\n"})
class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public CharsKt__CharKt() {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char digitToChar(int r10) {
        if (new IntRange(0, 9).contains(r10) == false) goto L7;
        return (char) (r10 + 48);
    L7:
        throw new IllegalArgumentException("Int " + r10 + " is not a decimal digit");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char digitToChar(int r10, int r11) {
        if (new IntRange(2, 36).contains(r11) == false) goto L15;
        if (r10 < 0) goto L13;
        if (r10 >= r11) goto L13;
        if (r10 >= 10) goto L9;
        int r12 = r10 + 48;
    L11:
        return (char) r12;
    L9:
        r12 = ((char) (r10 + 65)) - '\n';
    L13:
        throw new IllegalArgumentException("Digit " + r10 + " does not represent a valid digit in radix " + r11);
    L15:
        throw new IllegalArgumentException("Invalid radix: " + r11 + ". Valid radix values are in range 2..36");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final int digitToInt(char r10) {
        int r11 = CharsKt__CharJVMKt.digitOf(r10, 10);
        if (r11 < 0) goto L6;
        return r11;
    L6:
        throw new IllegalArgumentException("Char " + r10 + " is not a decimal digit");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final int digitToInt(char r10, int r11) {
        Integer r12 = digitToIntOrNull(r10, r11);
        if (r12 == null) goto L7;
        return r12.intValue();
    L7:
        throw new IllegalArgumentException("Char " + r10 + " is not a digit in the given radix=" + r11);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Integer digitToIntOrNull(char r10) {
        Integer r11 = Integer.valueOf(CharsKt__CharJVMKt.digitOf(r10, 10));
        if (r11.intValue() < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L10;
        return null;
    L10:
        return r11;
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Integer digitToIntOrNull(char r10, int r11) {
        CharsKt.checkRadix(r11);
        Integer r12 = Integer.valueOf(CharsKt__CharJVMKt.digitOf(r10, r11));
        if (r12.intValue() < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L10;
        return null;
    L10:
        return r12;
    L5:
        r13 = false;
        goto L6
    }

    public static final boolean equals(char r10, char r11, boolean r12) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if (r12 == true) goto L8;
        return false;
    L8:
        char r13 = Character.toUpperCase(r10);
        char r14 = Character.toUpperCase(r11);
        if (r13 != r14) goto L11;
        return true;
    L11:
        if (Character.toLowerCase(r13) != Character.toLowerCase(r14)) goto L14;
        return true;
    L14:
        return false;
    }

    public static /* synthetic */ boolean equals$default(char r10, char r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return equals(r10, r11, r12);
    }

    public static final boolean isSurrogate(char r10) {
        return new CharRange(55296, 57343).contains(r10);
    }

    @InlineOnly
    private static final String plus(char r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        return r10 + r11;
    }

    @SinceKotlin(version = "1.5")
    public static final String titlecase(char r10) {
        return _OneToManyTitlecaseMappingsKt.titlecaseImpl(r10);
    }
}
