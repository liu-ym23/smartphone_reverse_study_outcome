package kotlin.text;

import com.bytedance.crash.entity.EventBody;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0001\u001a\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0011\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0018\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u001a\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u001b\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\n\u0010\u001c\u001a\u00020\u000f*\u00020\u0002\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010!\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010\"\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010#\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010$\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010%\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010&\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010'\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0014\u0010'\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010(\u001a\u00020\u0002*\u00020\u0002H\u0087\b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006)"}, d2 = {EventBody.KEY_CATEGORY, "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", "", "radix", "digitOf", "char", "isDefined", "", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "lowercase", "", "locale", "Ljava/util/Locale;", "lowercaseChar", "titlecase", "titlecaseChar", "toLowerCase", "toTitleCase", "toUpperCase", "uppercase", "uppercaseChar", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/CharsKt")
class CharsKt__CharJVMKt {
    public CharsKt__CharJVMKt() {
    }

    public static final int checkRadix(int r4) {
        boolean r0 = false;
        if (2 <= r4) goto L5;
    L7:
        if (r0 == false) goto L10;
        return r4;
    L10:
        throw new IllegalArgumentException("radix " + r4 + " was not in valid range " + new IntRange(2, 36));
    L5:
        if (r4 >= 37) goto L7;
        r0 = true;
        goto L7
    }

    public static final int digitOf(char r0, int r1) {
        return Character.digit(r0, r1);
    }

    public static final CharCategory getCategory(char r1) {
        return CharCategory.Companion.valueOf(Character.getType(r1));
    }

    public static final CharDirectionality getDirectionality(char r1) {
        return CharDirectionality.Companion.valueOf(Character.getDirectionality(r1));
    }

    private static final boolean isDefined(char r0) {
        return Character.isDefined(r0);
    }

    private static final boolean isDigit(char r0) {
        return Character.isDigit(r0);
    }

    private static final boolean isHighSurrogate(char r0) {
        return Character.isHighSurrogate(r0);
    }

    private static final boolean isISOControl(char r0) {
        return Character.isISOControl(r0);
    }

    private static final boolean isIdentifierIgnorable(char r0) {
        return Character.isIdentifierIgnorable(r0);
    }

    private static final boolean isJavaIdentifierPart(char r0) {
        return Character.isJavaIdentifierPart(r0);
    }

    private static final boolean isJavaIdentifierStart(char r0) {
        return Character.isJavaIdentifierStart(r0);
    }

    private static final boolean isLetter(char r0) {
        return Character.isLetter(r0);
    }

    private static final boolean isLetterOrDigit(char r0) {
        return Character.isLetterOrDigit(r0);
    }

    private static final boolean isLowSurrogate(char r0) {
        return Character.isLowSurrogate(r0);
    }

    private static final boolean isLowerCase(char r0) {
        return Character.isLowerCase(r0);
    }

    private static final boolean isTitleCase(char r0) {
        return Character.isTitleCase(r0);
    }

    private static final boolean isUpperCase(char r0) {
        return Character.isUpperCase(r0);
    }

    public static final boolean isWhitespace(char r1) {
        if (Character.isWhitespace(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (Character.isSpaceChar(r1) == true) goto L8;
        return false;
    }

    private static final String lowercase(char r1) {
        String r2 = String.valueOf(r1);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.String");
        String r3 = r2.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r3, "toLowerCase(...)");
        return r3;
    }

    public static final String lowercase(char r1, Locale r2) {
        Intrinsics.checkNotNullParameter(r2, "locale");
        String r3 = String.valueOf(r1);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.lang.String");
        String r4 = r3.toLowerCase(r2);
        Intrinsics.checkNotNullExpressionValue(r4, "toLowerCase(...)");
        return r4;
    }

    private static final char lowercaseChar(char r0) {
        return Character.toLowerCase(r0);
    }

    public static final String titlecase(char r3, Locale r4) {
        Intrinsics.checkNotNullParameter(r4, "locale");
        String r5 = CharsKt.uppercase(r3, r4);
        if (r5.length() > 1) goto L5;
        String r0 = String.valueOf(r3);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.lang.String");
        String r1 = r0.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r1, "toUpperCase(...)");
        if (Intrinsics.areEqual(r5, r1) == true) goto L13;
        return r5;
    L13:
        return String.valueOf(Character.toTitleCase(r3));
    L5:
        if (r3 == 329) goto L14;
        char r6 = r5.charAt(0);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.String");
        String r7 = r5.substring(1);
        Intrinsics.checkNotNullExpressionValue(r7, "substring(...)");
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.lang.String");
        String r8 = r7.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r8, "toLowerCase(...)");
        return r6 + r8;
    L14:
        return r5;
    }

    private static final char titlecaseChar(char r0) {
        return Character.toTitleCase(r0);
    }

    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toLowerCase(char r0) {
        return Character.toLowerCase(r0);
    }

    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toTitleCase(char r0) {
        return Character.toTitleCase(r0);
    }

    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toUpperCase(char r0) {
        return Character.toUpperCase(r0);
    }

    private static final String uppercase(char r1) {
        String r2 = String.valueOf(r1);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.String");
        String r3 = r2.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r3, "toUpperCase(...)");
        return r3;
    }

    public static final String uppercase(char r1, Locale r2) {
        Intrinsics.checkNotNullParameter(r2, "locale");
        String r3 = String.valueOf(r1);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.lang.String");
        String r4 = r3.toUpperCase(r2);
        Intrinsics.checkNotNullExpressionValue(r4, "toUpperCase(...)");
        return r4;
    }

    private static final char uppercaseChar(char r0) {
        return Character.toUpperCase(r0);
    }
}
