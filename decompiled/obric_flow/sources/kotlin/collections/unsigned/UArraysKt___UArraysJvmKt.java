package kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
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
import kotlin.collections.a;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u00020\u0002*\u00020\u00032\u0006\u0010 \u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b!\u0010\"\u001a\u001c\u0010\u001f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010 \u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b#\u0010$\u001a\u001c\u0010\u001f\u001a\u00020\n*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b'\u0010(\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007¢\u0006\u0004\b*\u0010+\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0007¢\u0006\u0004\b,\u0010-\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0007¢\u0006\u0004\b.\u0010/\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0007¢\u0006\u0004\b0\u00101\u001a=\u00102\u001a\u0004\u0018\u00010\u0002\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a=\u00102\u001a\u0004\u0018\u00010\u0006\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a=\u00102\u001a\u0004\u0018\u00010\n\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a=\u00102\u001a\u0004\u0018\u00010\u000e\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a1\u0010?\u001a\u0004\u0018\u00010\u0002*\u00020\u00032\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00020Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`BH\u0007¢\u0006\u0004\bC\u0010D\u001a1\u0010?\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00060Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0006`BH\u0007¢\u0006\u0004\bE\u0010F\u001a1\u0010?\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\n0Aj\n\u0012\u0006\b\u0000\u0012\u00020\n`BH\u0007¢\u0006\u0004\bG\u0010H\u001a1\u0010?\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000e0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000e`BH\u0007¢\u0006\u0004\bI\u0010J\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007¢\u0006\u0004\bL\u0010+\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0007¢\u0006\u0004\bM\u0010-\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0007¢\u0006\u0004\bN\u0010/\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0007¢\u0006\u0004\bO\u00101\u001a=\u0010P\u001a\u0004\u0018\u00010\u0002\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bQ\u00108\u001a=\u0010P\u001a\u0004\u0018\u00010\u0006\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bR\u0010:\u001a=\u0010P\u001a\u0004\u0018\u00010\n\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bS\u0010<\u001a=\u0010P\u001a\u0004\u0018\u00010\u000e\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bT\u0010>\u001a1\u0010U\u001a\u0004\u0018\u00010\u0002*\u00020\u00032\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00020Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`BH\u0007¢\u0006\u0004\bV\u0010D\u001a1\u0010U\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00060Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0006`BH\u0007¢\u0006\u0004\bW\u0010F\u001a1\u0010U\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\n0Aj\n\u0012\u0006\b\u0000\u0012\u00020\n`BH\u0007¢\u0006\u0004\bX\u0010H\u001a1\u0010U\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000e0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000e`BH\u0007¢\u0006\u0004\bY\u0010J\u001a+\u0010Z\u001a\u00020[*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a+\u0010Z\u001a\u00020^*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020^06H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010`\u001a+\u0010Z\u001a\u00020[*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010a\u001a+\u0010Z\u001a\u00020^*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020^06H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010b\u001a+\u0010Z\u001a\u00020[*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010c\u001a+\u0010Z\u001a\u00020^*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020^06H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010d\u001a+\u0010Z\u001a\u00020[*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010e\u001a+\u0010Z\u001a\u00020^*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020^06H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006g"}, d2 = {"asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "max", "max-GBYM_sE", "([B)Lkotlin/UByte;", "max--ajY-9A", "([I)Lkotlin/UInt;", "max-QwZRm1k", "([J)Lkotlin/ULong;", "max-rL5Bavg", "([S)Lkotlin/UShort;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "maxBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "maxBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "maxBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "maxBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min-GBYM_sE", "min--ajY-9A", "min-QwZRm1k", "min-rL5Bavg", "minBy", "minBy-JOV_ifY", "minBy-jgv0xPQ", "minBy-MShoTSo", "minBy-xTcfx_M", "minWith", "minWith-XMRcp5o", "minWith-YmdZ_VM", "minWith-zrEWJaI", "minWith-eOHTfZs", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, pn = "kotlin.collections", xi = 49, xs = "kotlin/collections/unsigned/UArraysKt")
class UArraysKt___UArraysJvmKt {
    public UArraysKt___UArraysJvmKt() {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: asList--ajY-9A, reason: not valid java name */
    public static final List<UInt> m592asListajY9A(int[] r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$1(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: asList-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m593asListGBYM_sE(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$3(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: asList-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m594asListQwZRm1k(long[] r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$2(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: asList-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m595asListrL5Bavg(short[] r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$4(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: binarySearch-2fe2U9s, reason: not valid java name */
    public static final int m596binarySearch2fe2U9s(int[] r5, int r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r11, r12, UIntArray.m280getSizeimpl(r5));
        int r13 = r12 - 1;
    L3:
        if (r11 > r13) goto L11;
        int r14 = (r11 + r13) >>> 1;
        int r15 = UnsignedKt.uintCompare(r5[r14], r10);
        if (r15 < 0) goto L6;
        if (r15 <= 0) goto L9;
        r13 = r14 - 1;
        goto L3
    L9:
        return r14;
    L6:
        r11 = r14 + 1;
        goto L3
    L11:
        return -(r11 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ int m597binarySearch2fe2U9s$default(int[] r5, int r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = UIntArray.m280getSizeimpl(r5);
    L9:
        return m596binarySearch2fe2U9s(r5, r10, r11, r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: binarySearch-EtDCXyQ, reason: not valid java name */
    public static final int m598binarySearchEtDCXyQ(short[] r5, short r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r11, r12, UShortArray.m464getSizeimpl(r5));
        int r13 = r10 & UShort.MAX_VALUE;
        int r14 = r12 - 1;
    L3:
        if (r11 > r14) goto L11;
        int r15 = (r11 + r14) >>> 1;
        int r16 = UnsignedKt.uintCompare(r5[r15], r13);
        if (r16 < 0) goto L6;
        if (r16 <= 0) goto L9;
        r14 = r15 - 1;
        goto L3
    L9:
        return r15;
    L6:
        r11 = r15 + 1;
        goto L3
    L11:
        return -(r11 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ int m599binarySearchEtDCXyQ$default(short[] r5, short r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = UShortArray.m464getSizeimpl(r5);
    L9:
        return m598binarySearchEtDCXyQ(r5, r10, r11, r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: binarySearch-K6DWlUc, reason: not valid java name */
    public static final int m600binarySearchK6DWlUc(long[] r5, long r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r11, r12, ULongArray.m359getSizeimpl(r5));
        int r13 = r12 - 1;
    L3:
        if (r11 > r13) goto L11;
        int r14 = (r11 + r13) >>> 1;
        int r15 = UnsignedKt.ulongCompare(r5[r14], r10);
        if (r15 < 0) goto L6;
        if (r15 <= 0) goto L9;
        r13 = r14 - 1;
        goto L3
    L9:
        return r14;
    L6:
        r11 = r14 + 1;
        goto L3
    L11:
        return -(r11 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ int m601binarySearchK6DWlUc$default(long[] r5, long r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = ULongArray.m359getSizeimpl(r5);
    L9:
        return m600binarySearchK6DWlUc(r5, r10, r11, r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: binarySearch-WpHrYlw, reason: not valid java name */
    public static final int m602binarySearchWpHrYlw(byte[] r5, byte r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r11, r12, UByteArray.m201getSizeimpl(r5));
        int r13 = r10 & UByte.MAX_VALUE;
        int r14 = r12 - 1;
    L3:
        if (r11 > r14) goto L11;
        int r15 = (r11 + r14) >>> 1;
        int r16 = UnsignedKt.uintCompare(r5[r15], r13);
        if (r16 < 0) goto L6;
        if (r16 <= 0) goto L9;
        r14 = r15 - 1;
        goto L3
    L9:
        return r15;
    L6:
        r11 = r15 + 1;
        goto L3
    L11:
        return -(r11 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ int m603binarySearchWpHrYlw$default(byte[] r5, byte r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = UByteArray.m201getSizeimpl(r5);
    L9:
        return m602binarySearchWpHrYlw(r5, r10, r11, r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAt-PpDY95g, reason: not valid java name */
    private static final byte m604elementAtPpDY95g(byte[] r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$elementAt");
        return UByteArray.m200getw2LRezQ(r5, r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAt-nggk6HY, reason: not valid java name */
    private static final short m605elementAtnggk6HY(short[] r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$elementAt");
        return UShortArray.m463getMh2AYeg(r5, r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAt-qFRl0hI, reason: not valid java name */
    private static final int m606elementAtqFRl0hI(int[] r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$elementAt");
        return UIntArray.m279getpVg5ArA(r5, r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAt-r7IrZao, reason: not valid java name */
    private static final long m607elementAtr7IrZao(long[] r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$elementAt");
        return ULongArray.m358getsVKNKU(r5, r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ UInt m608maxajY9A(int[] r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$max");
        return UArraysKt___UArraysKt.m976maxOrNullajY9A(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ UByte m609maxGBYM_sE(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$max");
        return UArraysKt___UArraysKt.m977maxOrNullGBYM_sE(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ ULong m610maxQwZRm1k(long[] r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$max");
        return UArraysKt___UArraysKt.m978maxOrNullQwZRm1k(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ UShort m611maxrL5Bavg(short[] r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$max");
        return UArraysKt___UArraysKt.m979maxOrNullrL5Bavg(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m612maxByJOV_ifY(byte[] r10, Function1<? super UByte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m203isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        byte r5 = UByteArray.m200getw2LRezQ(r10, 0);
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 == 0) goto L17;
        R r13 = r11.invoke(UByte.m136boximpl(r5));
        int r14 = 1;
        if (1 > r12) goto L17;
    L10:
        byte r15 = UByteArray.m200getw2LRezQ(r10, r14);
        R r16 = r11.invoke(UByte.m136boximpl(r15));
        if (r13.compareTo(r16) >= 0) goto L13;
        r5 = r15;
        r13 = r16;
    L13:
        if (r14 == r12) goto L17;
        r14 = r14 + 1;
    L17:
        return UByte.m136boximpl(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m613maxByMShoTSo(long[] r10, Function1<? super ULong, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m361isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        long r5 = ULongArray.m358getsVKNKU(r10, 0);
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 == 0) goto L17;
        R r13 = r11.invoke(ULong.m292boximpl(r5));
        int r14 = 1;
        if (1 > r12) goto L17;
    L10:
        long r15 = ULongArray.m358getsVKNKU(r10, r14);
        R r16 = r11.invoke(ULong.m292boximpl(r15));
        if (r13.compareTo(r16) >= 0) goto L13;
        r5 = r15;
        r13 = r16;
    L13:
        if (r14 == r12) goto L17;
        r14 = r14 + 1;
    L17:
        return ULong.m292boximpl(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m614maxByjgv0xPQ(int[] r10, Function1<? super UInt, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m282isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        int r5 = UIntArray.m279getpVg5ArA(r10, 0);
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 == 0) goto L17;
        R r13 = r11.invoke(UInt.m213boximpl(r5));
        int r14 = 1;
        if (1 > r12) goto L17;
    L10:
        int r15 = UIntArray.m279getpVg5ArA(r10, r14);
        R r16 = r11.invoke(UInt.m213boximpl(r15));
        if (r13.compareTo(r16) >= 0) goto L13;
        r5 = r15;
        r13 = r16;
    L13:
        if (r14 == r12) goto L17;
        r14 = r14 + 1;
    L17:
        return UInt.m213boximpl(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m615maxByxTcfx_M(short[] r10, Function1<? super UShort, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m466isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        short r5 = UShortArray.m463getMh2AYeg(r10, 0);
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 == 0) goto L17;
        R r13 = r11.invoke(UShort.m399boximpl(r5));
        int r14 = 1;
        if (1 > r12) goto L17;
    L10:
        short r15 = UShortArray.m463getMh2AYeg(r10, r14);
        R r16 = r11.invoke(UShort.m399boximpl(r15));
        if (r13.compareTo(r16) >= 0) goto L13;
        r5 = r15;
        r13 = r16;
    L13:
        if (r14 == r12) goto L17;
        r14 = r14 + 1;
    L17:
        return UShort.m399boximpl(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ UByte m616maxWithXMRcp5o(byte[] r5, Comparator r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r10, "comparator");
        return UArraysKt___UArraysKt.m984maxWithOrNullXMRcp5o(r5, r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ UInt m617maxWithYmdZ_VM(int[] r5, Comparator r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r10, "comparator");
        return UArraysKt___UArraysKt.m985maxWithOrNullYmdZ_VM(r5, r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ UShort m618maxWitheOHTfZs(short[] r5, Comparator r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r10, "comparator");
        return UArraysKt___UArraysKt.m986maxWithOrNulleOHTfZs(r5, r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ ULong m619maxWithzrEWJaI(long[] r5, Comparator r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r10, "comparator");
        return UArraysKt___UArraysKt.m987maxWithOrNullzrEWJaI(r5, r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ UInt m620minajY9A(int[] r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$min");
        return UArraysKt___UArraysKt.m1032minOrNullajY9A(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ UByte m621minGBYM_sE(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$min");
        return UArraysKt___UArraysKt.m1033minOrNullGBYM_sE(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ ULong m622minQwZRm1k(long[] r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$min");
        return UArraysKt___UArraysKt.m1034minOrNullQwZRm1k(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ UShort m623minrL5Bavg(short[] r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$min");
        return UArraysKt___UArraysKt.m1035minOrNullrL5Bavg(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m624minByJOV_ifY(byte[] r10, Function1<? super UByte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m203isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        byte r5 = UByteArray.m200getw2LRezQ(r10, 0);
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 == 0) goto L17;
        R r13 = r11.invoke(UByte.m136boximpl(r5));
        int r14 = 1;
        if (1 > r12) goto L17;
    L10:
        byte r15 = UByteArray.m200getw2LRezQ(r10, r14);
        R r16 = r11.invoke(UByte.m136boximpl(r15));
        if (r13.compareTo(r16) <= 0) goto L13;
        r5 = r15;
        r13 = r16;
    L13:
        if (r14 == r12) goto L17;
        r14 = r14 + 1;
    L17:
        return UByte.m136boximpl(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m625minByMShoTSo(long[] r10, Function1<? super ULong, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m361isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        long r5 = ULongArray.m358getsVKNKU(r10, 0);
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 == 0) goto L17;
        R r13 = r11.invoke(ULong.m292boximpl(r5));
        int r14 = 1;
        if (1 > r12) goto L17;
    L10:
        long r15 = ULongArray.m358getsVKNKU(r10, r14);
        R r16 = r11.invoke(ULong.m292boximpl(r15));
        if (r13.compareTo(r16) <= 0) goto L13;
        r5 = r15;
        r13 = r16;
    L13:
        if (r14 == r12) goto L17;
        r14 = r14 + 1;
    L17:
        return ULong.m292boximpl(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m626minByjgv0xPQ(int[] r10, Function1<? super UInt, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m282isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        int r5 = UIntArray.m279getpVg5ArA(r10, 0);
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 == 0) goto L17;
        R r13 = r11.invoke(UInt.m213boximpl(r5));
        int r14 = 1;
        if (1 > r12) goto L17;
    L10:
        int r15 = UIntArray.m279getpVg5ArA(r10, r14);
        R r16 = r11.invoke(UInt.m213boximpl(r15));
        if (r13.compareTo(r16) <= 0) goto L13;
        r5 = r15;
        r13 = r16;
    L13:
        if (r14 == r12) goto L17;
        r14 = r14 + 1;
    L17:
        return UInt.m213boximpl(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m627minByxTcfx_M(short[] r10, Function1<? super UShort, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m466isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        short r5 = UShortArray.m463getMh2AYeg(r10, 0);
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 == 0) goto L17;
        R r13 = r11.invoke(UShort.m399boximpl(r5));
        int r14 = 1;
        if (1 > r12) goto L17;
    L10:
        short r15 = UShortArray.m463getMh2AYeg(r10, r14);
        R r16 = r11.invoke(UShort.m399boximpl(r15));
        if (r13.compareTo(r16) <= 0) goto L13;
        r5 = r15;
        r13 = r16;
    L13:
        if (r14 == r12) goto L17;
        r14 = r14 + 1;
    L17:
        return UShort.m399boximpl(r5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ UByte m628minWithXMRcp5o(byte[] r5, Comparator r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$minWith");
        Intrinsics.checkNotNullParameter(r10, "comparator");
        return UArraysKt___UArraysKt.m1040minWithOrNullXMRcp5o(r5, r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ UInt m629minWithYmdZ_VM(int[] r5, Comparator r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$minWith");
        Intrinsics.checkNotNullParameter(r10, "comparator");
        return UArraysKt___UArraysKt.m1041minWithOrNullYmdZ_VM(r5, r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ UShort m630minWitheOHTfZs(short[] r5, Comparator r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$minWith");
        Intrinsics.checkNotNullParameter(r10, "comparator");
        return UArraysKt___UArraysKt.m1042minWithOrNulleOHTfZs(r5, r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ ULong m631minWithzrEWJaI(long[] r5, Comparator r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$minWith");
        Intrinsics.checkNotNullParameter(r10, "comparator");
        return UArraysKt___UArraysKt.m1043minWithOrNullzrEWJaI(r5, r10);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(int[] r5, Function1<? super UInt, ? extends BigDecimal> r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r10, "selector");
        BigDecimal r11 = BigDecimal.valueOf(0);
        int r12 = UIntArray.m280getSizeimpl(r5);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11 = r11.add((BigDecimal) a.d(r5, r13, r10));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(int[] r5, Function1<? super UInt, ? extends BigInteger> r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r10, "selector");
        BigInteger r11 = BigInteger.valueOf(0);
        int r12 = UIntArray.m280getSizeimpl(r5);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11 = r11.add((BigInteger) a.d(r5, r13, r10));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(long[] r5, Function1<? super ULong, ? extends BigDecimal> r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r10, "selector");
        BigDecimal r11 = BigDecimal.valueOf(0);
        int r12 = ULongArray.m359getSizeimpl(r5);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11 = r11.add((BigDecimal) a.e(r5, r13, r10));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(long[] r5, Function1<? super ULong, ? extends BigInteger> r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r10, "selector");
        BigInteger r11 = BigInteger.valueOf(0);
        int r12 = ULongArray.m359getSizeimpl(r5);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11 = r11.add((BigInteger) a.e(r5, r13, r10));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(byte[] r5, Function1<? super UByte, ? extends BigDecimal> r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r10, "selector");
        BigDecimal r11 = BigDecimal.valueOf(0);
        int r12 = UByteArray.m201getSizeimpl(r5);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11 = r11.add((BigDecimal) a.c(r5, r13, r10));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(byte[] r5, Function1<? super UByte, ? extends BigInteger> r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r10, "selector");
        BigInteger r11 = BigInteger.valueOf(0);
        int r12 = UByteArray.m201getSizeimpl(r5);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11 = r11.add((BigInteger) a.c(r5, r13, r10));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(short[] r5, Function1<? super UShort, ? extends BigDecimal> r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r10, "selector");
        BigDecimal r11 = BigDecimal.valueOf(0);
        int r12 = UShortArray.m464getSizeimpl(r5);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11 = r11.add((BigDecimal) a.f(r5, r13, r10));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(short[] r5, Function1<? super UShort, ? extends BigInteger> r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r10, "selector");
        BigInteger r11 = BigInteger.valueOf(0);
        int r12 = UShortArray.m464getSizeimpl(r5);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11 = r11.add((BigInteger) a.f(r5, r13, r10));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }
}
