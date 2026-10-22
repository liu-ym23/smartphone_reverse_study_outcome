package kotlin.text;

import ai.j0;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0001\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000eH\u0087\n\u001a\f\u0010\u000f\u001a\u00020\u000e*\u00020\u0001H\u0007¨\u0006\u0010"}, d2 = {"digitToChar", "", "", "radix", "digitToInt", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "equals", "", "other", "ignoreCase", "isSurrogate", "plus", "", "titlecase", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/CharsKt")
@SourceDebugExtension({"SMAP\nChar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Char.kt\nkotlin/text/CharsKt__CharKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,349:1\n1#2:350\n*E\n"})
class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public CharsKt__CharKt() {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char digitToChar(int r5) {
        if (r5 < 0) goto L8;
        if (r5 >= 10) goto L8;
        return (char) (r5 + 48);
    L8:
        throw new IllegalArgumentException(j0.h(r5, "Int ", " is not a decimal digit"));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final int digitToInt(char r5) {
        int r10 = CharsKt__CharJVMKt.digitOf(r5, 10);
        if (r10 < 0) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException("Char " + r5 + " is not a decimal digit");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Integer digitToIntOrNull(char r5) {
        Integer r10 = Integer.valueOf(CharsKt__CharJVMKt.digitOf(r5, 10));
        if (r10.intValue() >= 0) goto L7;
        return null;
    L7:
        return r10;
    }

    public static final boolean equals(char r5, char r10, boolean r11) {
        if (r5 != r10) goto L6;
        return true;
    L6:
        if (r11 == true) goto L8;
        return false;
    L8:
        char r12 = Character.toUpperCase(r5);
        char r13 = Character.toUpperCase(r10);
        if (r12 != r13) goto L11;
        return true;
    L11:
        if (Character.toLowerCase(r12) != Character.toLowerCase(r13)) goto L14;
        return true;
    L14:
        return false;
    }

    public static /* synthetic */ boolean equals$default(char r5, char r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        return equals(r5, r10, r11);
    }

    public static final boolean isSurrogate(char r5) {
        if (55296 <= r5) goto L5;
        return false;
    L5:
        if (r5 >= 57344) goto L9;
        return true;
    L9:
        return false;
    }

    @InlineOnly
    private static final String plus(char r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        return r5 + r10;
    }

    @SinceKotlin(version = "1.5")
    public static String titlecase(char r5) {
        return _OneToManyTitlecaseMappingsKt.titlecaseImpl(r5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Integer digitToIntOrNull(char r5, int r10) {
        CharsKt__CharJVMKt.checkRadix(r10);
        Integer r11 = Integer.valueOf(CharsKt__CharJVMKt.digitOf(r5, r10));
        if (r11.intValue() >= 0) goto L7;
        return null;
    L7:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final int digitToInt(char r5, int r10) {
        Integer r11 = digitToIntOrNull(r5, r10);
        if (r11 == null) goto L7;
        return r11.intValue();
    L7:
        throw new IllegalArgumentException("Char " + r5 + " is not a digit in the given radix=" + r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char digitToChar(int r5, int r10) {
        if (2 > r10) goto L17;
        if (r10 >= 37) goto L17;
        if (r5 < 0) goto L15;
        if (r5 >= r10) goto L15;
        if (r5 >= 10) goto L12;
        int r11 = r5 + 48;
    L13:
        return (char) r11;
    L12:
        r11 = ((char) (r5 + 65)) - '\n';
    L15:
        throw new IllegalArgumentException(j0.f(r5, r10, "Digit ", " does not represent a valid digit in radix "));
    L17:
        throw new IllegalArgumentException(j0.h(r10, "Invalid radix: ", ". Valid radix values are in range 2..36"));
    }
}
