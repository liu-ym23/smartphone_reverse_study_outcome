package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\n_StringsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,108:1\n1239#2,14:109\n1521#2,14:123\n*S KotlinDebug\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n*L\n45#1:109,14\n66#1:123,14\n*E\n"})
class StringsKt___StringsJvmKt extends StringsKt__StringsKt {
    public StringsKt___StringsJvmKt() {
    }

    @InlineOnly
    private static final char elementAt(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.charAt(r11);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character max(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return StringsKt___StringsKt.maxOrNull(r10);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character maxBy(CharSequence r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        char r13 = r10.charAt(0);
        int r14 = StringsKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Character.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        char r17 = r10.charAt(r16.nextInt());
        R r18 = r11.invoke(Character.valueOf(r17));
        if (r15.compareTo(r18) >= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return Character.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character maxWith(CharSequence r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return StringsKt___StringsKt.maxWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character min(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return StringsKt___StringsKt.minOrNull(r10);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character minBy(CharSequence r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        char r13 = r10.charAt(0);
        int r14 = StringsKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Character.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        char r17 = r10.charAt(r16.nextInt());
        R r18 = r11.invoke(Character.valueOf(r17));
        if (r15.compareTo(r18) <= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return Character.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character minWith(CharSequence r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return StringsKt___StringsKt.minWithOrNull(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(CharSequence r10, Function1<? super Character, ? extends BigDecimal> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigDecimal r12 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        r12 = r12.add(r11.invoke(Character.valueOf(r10.charAt(r13))));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r13 = r13 + 1;
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(CharSequence r10, Function1<? super Character, ? extends BigInteger> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigInteger r12 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        r12 = r12.add(r11.invoke(Character.valueOf(r10.charAt(r13))));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r13 = r13 + 1;
        goto L4
    L6:
        return r12;
    }

    public static final SortedSet<Character> toSortedSet(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (SortedSet) StringsKt___StringsKt.toCollection(r10, new TreeSet());
    }
}
