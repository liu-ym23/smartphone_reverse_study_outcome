package kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
class UArraysKt___UArraysJvmKt {
    public UArraysKt___UArraysJvmKt() {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: asList--ajY-9A, reason: not valid java name */
    public static final List<UInt> m507asListajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$1(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: asList-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m508asListGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$3(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: asList-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m509asListQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$2(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: asList-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m510asListrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$4(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: binarySearch-2fe2U9s, reason: not valid java name */
    public static final int m511binarySearch2fe2U9s(int[] r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r12, r13, UIntArray.m188getSizeimpl(r10));
        int r14 = r13 - 1;
    L3:
        if (r12 > r14) goto L11;
        int r15 = (r12 + r14) >>> 1;
        int r16 = UnsignedKt.uintCompare(r10[r15], r11);
        if (r16 < 0) goto L6;
        if (r16 <= 0) goto L9;
        r14 = r15 - 1;
        goto L3
    L9:
        return r15;
    L6:
        r12 = r15 + 1;
        goto L3
    L11:
        return -(r12 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ int m512binarySearch2fe2U9s$default(int[] r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = UIntArray.m188getSizeimpl(r10);
    L9:
        return m511binarySearch2fe2U9s(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: binarySearch-EtDCXyQ, reason: not valid java name */
    public static final int m513binarySearchEtDCXyQ(short[] r10, short r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r12, r13, UShortArray.m372getSizeimpl(r10));
        int r14 = r11 & UShort.MAX_VALUE;
        int r15 = r13 - 1;
    L3:
        if (r12 > r15) goto L11;
        int r16 = (r12 + r15) >>> 1;
        int r17 = UnsignedKt.uintCompare(r10[r16], r14);
        if (r17 < 0) goto L6;
        if (r17 <= 0) goto L9;
        r15 = r16 - 1;
        goto L3
    L9:
        return r16;
    L6:
        r12 = r16 + 1;
        goto L3
    L11:
        return -(r12 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ int m514binarySearchEtDCXyQ$default(short[] r10, short r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = UShortArray.m372getSizeimpl(r10);
    L9:
        return m513binarySearchEtDCXyQ(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: binarySearch-K6DWlUc, reason: not valid java name */
    public static final int m515binarySearchK6DWlUc(long[] r10, long r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r12, r13, ULongArray.m267getSizeimpl(r10));
        int r14 = r13 - 1;
    L3:
        if (r12 > r14) goto L11;
        int r15 = (r12 + r14) >>> 1;
        int r16 = UnsignedKt.ulongCompare(r10[r15], r11);
        if (r16 < 0) goto L6;
        if (r16 <= 0) goto L9;
        r14 = r15 - 1;
        goto L3
    L9:
        return r15;
    L6:
        r12 = r15 + 1;
        goto L3
    L11:
        return -(r12 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ int m516binarySearchK6DWlUc$default(long[] r10, long r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = ULongArray.m267getSizeimpl(r10);
    L9:
        return m515binarySearchK6DWlUc(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: binarySearch-WpHrYlw, reason: not valid java name */
    public static final int m517binarySearchWpHrYlw(byte[] r10, byte r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r12, r13, UByteArray.m109getSizeimpl(r10));
        int r14 = r11 & 255;
        int r15 = r13 - 1;
    L3:
        if (r12 > r15) goto L11;
        int r16 = (r12 + r15) >>> 1;
        int r17 = UnsignedKt.uintCompare(r10[r16], r14);
        if (r17 < 0) goto L6;
        if (r17 <= 0) goto L9;
        r15 = r16 - 1;
        goto L3
    L9:
        return r16;
    L6:
        r12 = r16 + 1;
        goto L3
    L11:
        return -(r12 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ int m518binarySearchWpHrYlw$default(byte[] r10, byte r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = UByteArray.m109getSizeimpl(r10);
    L9:
        return m517binarySearchWpHrYlw(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAt-PpDY95g, reason: not valid java name */
    private static final byte m519elementAtPpDY95g(byte[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$elementAt");
        return UByteArray.m108getw2LRezQ(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAt-nggk6HY, reason: not valid java name */
    private static final short m520elementAtnggk6HY(short[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$elementAt");
        return UShortArray.m371getMh2AYeg(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAt-qFRl0hI, reason: not valid java name */
    private static final int m521elementAtqFRl0hI(int[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$elementAt");
        return UIntArray.m187getpVg5ArA(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAt-r7IrZao, reason: not valid java name */
    private static final long m522elementAtr7IrZao(long[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$elementAt");
        return ULongArray.m266getsVKNKU(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ UInt m523maxajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$max");
        return UArraysKt___UArraysKt.m891maxOrNullajY9A(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ UByte m524maxGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$max");
        return UArraysKt___UArraysKt.m892maxOrNullGBYM_sE(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ ULong m525maxQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$max");
        return UArraysKt___UArraysKt.m893maxOrNullQwZRm1k(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ UShort m526maxrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$max");
        return UArraysKt___UArraysKt.m894maxOrNullrL5Bavg(r10);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m527maxByJOV_ifY(byte[] r10, Function1<? super UByte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L20;
        R r14 = r11.invoke(UByte.m44boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L10:
        if (r15.hasNext() == false) goto L20;
        byte r16 = UByteArray.m108getw2LRezQ(r10, r15.nextInt());
        R r17 = r11.invoke(UByte.m44boximpl(r16));
        if (r14.compareTo(r17) >= 0) goto L10;
        r12 = r16;
        r14 = r17;
    L20:
        return UByte.m44boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m528maxByMShoTSo(long[] r10, Function1<? super ULong, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L20;
        R r14 = r11.invoke(ULong.m200boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L10:
        if (r15.hasNext() == false) goto L20;
        long r16 = ULongArray.m266getsVKNKU(r10, r15.nextInt());
        R r17 = r11.invoke(ULong.m200boximpl(r16));
        if (r14.compareTo(r17) >= 0) goto L10;
        r12 = r16;
        r14 = r17;
    L20:
        return ULong.m200boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m529maxByjgv0xPQ(int[] r10, Function1<? super UInt, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L20;
        R r14 = r11.invoke(UInt.m121boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L10:
        if (r15.hasNext() == false) goto L20;
        int r16 = UIntArray.m187getpVg5ArA(r10, r15.nextInt());
        R r17 = r11.invoke(UInt.m121boximpl(r16));
        if (r14.compareTo(r17) >= 0) goto L10;
        r12 = r16;
        r14 = r17;
    L20:
        return UInt.m121boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m530maxByxTcfx_M(short[] r10, Function1<? super UShort, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L20;
        R r14 = r11.invoke(UShort.m307boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L10:
        if (r15.hasNext() == false) goto L20;
        short r16 = UShortArray.m371getMh2AYeg(r10, r15.nextInt());
        R r17 = r11.invoke(UShort.m307boximpl(r16));
        if (r14.compareTo(r17) >= 0) goto L10;
        r12 = r16;
        r14 = r17;
    L20:
        return UShort.m307boximpl(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ UByte m531maxWithXMRcp5o(byte[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return UArraysKt___UArraysKt.m899maxWithOrNullXMRcp5o(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ UInt m532maxWithYmdZ_VM(int[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return UArraysKt___UArraysKt.m900maxWithOrNullYmdZ_VM(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ UShort m533maxWitheOHTfZs(short[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return UArraysKt___UArraysKt.m901maxWithOrNulleOHTfZs(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ ULong m534maxWithzrEWJaI(long[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return UArraysKt___UArraysKt.m902maxWithOrNullzrEWJaI(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ UInt m535minajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$min");
        return UArraysKt___UArraysKt.m947minOrNullajY9A(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ UByte m536minGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$min");
        return UArraysKt___UArraysKt.m948minOrNullGBYM_sE(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ ULong m537minQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$min");
        return UArraysKt___UArraysKt.m949minOrNullQwZRm1k(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ UShort m538minrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$min");
        return UArraysKt___UArraysKt.m950minOrNullrL5Bavg(r10);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m539minByJOV_ifY(byte[] r10, Function1<? super UByte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L20;
        R r14 = r11.invoke(UByte.m44boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L10:
        if (r15.hasNext() == false) goto L20;
        byte r16 = UByteArray.m108getw2LRezQ(r10, r15.nextInt());
        R r17 = r11.invoke(UByte.m44boximpl(r16));
        if (r14.compareTo(r17) <= 0) goto L10;
        r12 = r16;
        r14 = r17;
    L20:
        return UByte.m44boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m540minByMShoTSo(long[] r10, Function1<? super ULong, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L20;
        R r14 = r11.invoke(ULong.m200boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L10:
        if (r15.hasNext() == false) goto L20;
        long r16 = ULongArray.m266getsVKNKU(r10, r15.nextInt());
        R r17 = r11.invoke(ULong.m200boximpl(r16));
        if (r14.compareTo(r17) <= 0) goto L10;
        r12 = r16;
        r14 = r17;
    L20:
        return ULong.m200boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m541minByjgv0xPQ(int[] r10, Function1<? super UInt, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L20;
        R r14 = r11.invoke(UInt.m121boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L10:
        if (r15.hasNext() == false) goto L20;
        int r16 = UIntArray.m187getpVg5ArA(r10, r15.nextInt());
        R r17 = r11.invoke(UInt.m121boximpl(r16));
        if (r14.compareTo(r17) <= 0) goto L10;
        r12 = r16;
        r14 = r17;
    L20:
        return UInt.m121boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m542minByxTcfx_M(short[] r10, Function1<? super UShort, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L20;
        R r14 = r11.invoke(UShort.m307boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L10:
        if (r15.hasNext() == false) goto L20;
        short r16 = UShortArray.m371getMh2AYeg(r10, r15.nextInt());
        R r17 = r11.invoke(UShort.m307boximpl(r16));
        if (r14.compareTo(r17) <= 0) goto L10;
        r12 = r16;
        r14 = r17;
    L20:
        return UShort.m307boximpl(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ UByte m543minWithXMRcp5o(byte[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return UArraysKt___UArraysKt.m955minWithOrNullXMRcp5o(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ UInt m544minWithYmdZ_VM(int[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return UArraysKt___UArraysKt.m956minWithOrNullYmdZ_VM(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ UShort m545minWitheOHTfZs(short[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return UArraysKt___UArraysKt.m957minWithOrNulleOHTfZs(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ ULong m546minWithzrEWJaI(long[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return UArraysKt___UArraysKt.m958minWithOrNullzrEWJaI(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(byte[] r10, Function1<? super UByte, ? extends BigDecimal> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigDecimal r12 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(int[] r10, Function1<? super UInt, ? extends BigDecimal> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigDecimal r12 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(long[] r10, Function1<? super ULong, ? extends BigDecimal> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigDecimal r12 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(short[] r10, Function1<? super UShort, ? extends BigDecimal> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigDecimal r12 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(byte[] r10, Function1<? super UByte, ? extends BigInteger> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigInteger r12 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(int[] r10, Function1<? super UInt, ? extends BigInteger> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigInteger r12 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(long[] r10, Function1<? super ULong, ? extends BigInteger> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigInteger r12 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(short[] r10, Function1<? super UShort, ? extends BigInteger> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigInteger r12 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }
}
