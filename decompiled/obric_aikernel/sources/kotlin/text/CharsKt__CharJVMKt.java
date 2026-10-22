package kotlin.text;

import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
class CharsKt__CharJVMKt {
    public CharsKt__CharJVMKt() {
    }

    @PublishedApi
    public static int checkRadix(int r10) {
        if (new IntRange(2, 36).contains(r10) == false) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException("radix " + r10 + " was not in valid range " + new IntRange(2, 36));
    }

    public static final int digitOf(char r10, int r11) {
        return Character.digit(r10, r11);
    }

    public static final CharCategory getCategory(char r10) {
        return CharCategory.Companion.valueOf(Character.getType(r10));
    }

    public static final CharDirectionality getDirectionality(char r10) {
        return CharDirectionality.Companion.valueOf(Character.getDirectionality(r10));
    }

    @InlineOnly
    private static final boolean isDefined(char r10) {
        return Character.isDefined(r10);
    }

    @InlineOnly
    private static final boolean isDigit(char r10) {
        return Character.isDigit(r10);
    }

    @InlineOnly
    private static final boolean isHighSurrogate(char r10) {
        return Character.isHighSurrogate(r10);
    }

    @InlineOnly
    private static final boolean isISOControl(char r10) {
        return Character.isISOControl(r10);
    }

    @InlineOnly
    private static final boolean isIdentifierIgnorable(char r10) {
        return Character.isIdentifierIgnorable(r10);
    }

    @InlineOnly
    private static final boolean isJavaIdentifierPart(char r10) {
        return Character.isJavaIdentifierPart(r10);
    }

    @InlineOnly
    private static final boolean isJavaIdentifierStart(char r10) {
        return Character.isJavaIdentifierStart(r10);
    }

    @InlineOnly
    private static final boolean isLetter(char r10) {
        return Character.isLetter(r10);
    }

    @InlineOnly
    private static final boolean isLetterOrDigit(char r10) {
        return Character.isLetterOrDigit(r10);
    }

    @InlineOnly
    private static final boolean isLowSurrogate(char r10) {
        return Character.isLowSurrogate(r10);
    }

    @InlineOnly
    private static final boolean isLowerCase(char r10) {
        return Character.isLowerCase(r10);
    }

    @InlineOnly
    private static final boolean isTitleCase(char r10) {
        return Character.isTitleCase(r10);
    }

    @InlineOnly
    private static final boolean isUpperCase(char r10) {
        return Character.isUpperCase(r10);
    }

    public static boolean isWhitespace(char r10) {
        if (Character.isWhitespace(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (Character.isSpaceChar(r10) == true) goto L8;
        return false;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String lowercase(char r10) {
        String r11 = String.valueOf(r10);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.String");
        String r12 = r11.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String lowercase(char r10, Locale r11) {
        Intrinsics.checkNotNullParameter(r11, "locale");
        String r12 = String.valueOf(r10);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.String");
        String r13 = r12.toLowerCase(r11);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toLowerCase(locale)");
        return r13;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char lowercaseChar(char r10) {
        return Character.toLowerCase(r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String titlecase(char r10, Locale r11) {
        Intrinsics.checkNotNullParameter(r11, "locale");
        String r12 = uppercase(r10, r11);
        if (r12.length() > 1) goto L5;
        String r13 = String.valueOf(r10);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type java.lang.String");
        String r14 = r13.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (Intrinsics.areEqual(r12, r14) == true) goto L13;
        return r12;
    L13:
        return String.valueOf(Character.toTitleCase(r10));
    L5:
        if (r10 == 329) goto L14;
        char r15 = r12.charAt(0);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.String");
        String r16 = r12.substring(1);
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).substring(startIndex)");
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type java.lang.String");
        String r17 = r16.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return r15 + r17;
    L14:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char titlecaseChar(char r10) {
        return Character.toTitleCase(r10);
    }

    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final char toLowerCase(char r10) {
        return Character.toLowerCase(r10);
    }

    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final char toTitleCase(char r10) {
        return Character.toTitleCase(r10);
    }

    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final char toUpperCase(char r10) {
        return Character.toUpperCase(r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String uppercase(char r10) {
        String r11 = String.valueOf(r10);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.String");
        String r12 = r11.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String uppercase(char r10, Locale r11) {
        Intrinsics.checkNotNullParameter(r11, "locale");
        String r12 = String.valueOf(r10);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.String");
        String r13 = r12.toUpperCase(r11);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toUpperCase(locale)");
        return r13;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char uppercaseChar(char r10) {
        return Character.toUpperCase(r10);
    }
}
