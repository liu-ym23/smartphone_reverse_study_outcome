package kotlin.text;

import ai.j0;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0001\u001a\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0011\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0018\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u001a\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u001b\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\n\u0010\u001c\u001a\u00020\u000f*\u00020\u0002\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010!\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010\"\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010#\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010$\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010%\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010&\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010'\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0014\u0010'\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010(\u001a\u00020\u0002*\u00020\u0002H\u0087\b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006)"}, d2 = {"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", "", "radix", "digitOf", "char", "isDefined", "", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "lowercase", "", "locale", "Ljava/util/Locale;", "lowercaseChar", "titlecase", "titlecaseChar", "toLowerCase", "toTitleCase", "toUpperCase", "uppercase", "uppercaseChar", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/CharsKt")
class CharsKt__CharJVMKt {
    public CharsKt__CharJVMKt() {
    }

    @PublishedApi
    public static int checkRadix(int r5) {
        if (2 <= r5) goto L5;
    L7:
        StringBuilder r10 = j0.s(r5, "radix ", " was not in valid range ");
        r10.append(new IntRange(2, 36));
        throw new IllegalArgumentException(r10.toString());
    L5:
        if (r5 >= 37) goto L7;
        return r5;
    }

    public static final int digitOf(char r5, int r10) {
        return Character.digit(r5, r10);
    }

    public static final CharCategory getCategory(char r5) {
        return CharCategory.Companion.valueOf(Character.getType(r5));
    }

    public static final CharDirectionality getDirectionality(char r5) {
        return CharDirectionality.Companion.valueOf(Character.getDirectionality(r5));
    }

    @InlineOnly
    private static final boolean isDefined(char r5) {
        return Character.isDefined(r5);
    }

    @InlineOnly
    private static final boolean isDigit(char r5) {
        return Character.isDigit(r5);
    }

    @InlineOnly
    private static final boolean isHighSurrogate(char r5) {
        return Character.isHighSurrogate(r5);
    }

    @InlineOnly
    private static final boolean isISOControl(char r5) {
        return Character.isISOControl(r5);
    }

    @InlineOnly
    private static final boolean isIdentifierIgnorable(char r5) {
        return Character.isIdentifierIgnorable(r5);
    }

    @InlineOnly
    private static final boolean isJavaIdentifierPart(char r5) {
        return Character.isJavaIdentifierPart(r5);
    }

    @InlineOnly
    private static final boolean isJavaIdentifierStart(char r5) {
        return Character.isJavaIdentifierStart(r5);
    }

    @InlineOnly
    private static final boolean isLetter(char r5) {
        return Character.isLetter(r5);
    }

    @InlineOnly
    private static final boolean isLetterOrDigit(char r5) {
        return Character.isLetterOrDigit(r5);
    }

    @InlineOnly
    private static final boolean isLowSurrogate(char r5) {
        return Character.isLowSurrogate(r5);
    }

    @InlineOnly
    private static final boolean isLowerCase(char r5) {
        return Character.isLowerCase(r5);
    }

    @InlineOnly
    private static final boolean isTitleCase(char r5) {
        return Character.isTitleCase(r5);
    }

    @InlineOnly
    private static final boolean isUpperCase(char r5) {
        return Character.isUpperCase(r5);
    }

    public static boolean isWhitespace(char r5) {
        if (Character.isWhitespace(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (Character.isSpaceChar(r5) == true) goto L8;
        return false;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String lowercase(char r5) {
        String r10 = String.valueOf(r5);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.String");
        return r10.toLowerCase(Locale.ROOT);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char lowercaseChar(char r5) {
        return Character.toLowerCase(r5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String titlecase(char r5, Locale r10) {
        Intrinsics.checkNotNullParameter(r10, "locale");
        String r11 = uppercase(r5, r10);
        if (r11.length() > 1) goto L5;
        String r12 = String.valueOf(r5);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.String");
        if (Intrinsics.areEqual(r11, r12.toUpperCase(Locale.ROOT)) == true) goto L13;
        return r11;
    L13:
        return String.valueOf(Character.toTitleCase(r5));
    L5:
        if (r5 == 329) goto L14;
        char r13 = r11.charAt(0);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.String");
        String r14 = r11.substring(1);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type java.lang.String");
        return r13 + r14.toLowerCase(Locale.ROOT);
    L14:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char titlecaseChar(char r5) {
        return Character.toTitleCase(r5);
    }

    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final char toLowerCase(char r5) {
        return Character.toLowerCase(r5);
    }

    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final char toTitleCase(char r5) {
        return Character.toTitleCase(r5);
    }

    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final char toUpperCase(char r5) {
        return Character.toUpperCase(r5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String uppercase(char r5) {
        String r10 = String.valueOf(r5);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.String");
        return r10.toUpperCase(Locale.ROOT);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char uppercaseChar(char r5) {
        return Character.toUpperCase(r5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String lowercase(char r5, Locale r10) {
        Intrinsics.checkNotNullParameter(r10, "locale");
        String r11 = String.valueOf(r5);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.String");
        return r11.toLowerCase(r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String uppercase(char r5, Locale r10) {
        Intrinsics.checkNotNullParameter(r10, "locale");
        String r11 = String.valueOf(r5);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.String");
        return r11.toUpperCase(r10);
    }
}
