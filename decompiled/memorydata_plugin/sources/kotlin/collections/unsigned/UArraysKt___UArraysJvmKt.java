package kotlin.collections.unsigned;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u00020\u0002*\u00020\u00032\u0006\u0010 \u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b!\u0010\"\u001a\u001c\u0010\u001f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010 \u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b#\u0010$\u001a\u001c\u0010\u001f\u001a\u00020\n*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b'\u0010(\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007¢\u0006\u0004\b*\u0010+\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0007¢\u0006\u0004\b,\u0010-\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0007¢\u0006\u0004\b.\u0010/\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0007¢\u0006\u0004\b0\u00101\u001a=\u00102\u001a\u0004\u0018\u00010\u0002\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a=\u00102\u001a\u0004\u0018\u00010\u0006\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a=\u00102\u001a\u0004\u0018\u00010\n\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a=\u00102\u001a\u0004\u0018\u00010\u000e\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a1\u0010?\u001a\u0004\u0018\u00010\u0002*\u00020\u00032\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00020Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`BH\u0007¢\u0006\u0004\bC\u0010D\u001a1\u0010?\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00060Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0006`BH\u0007¢\u0006\u0004\bE\u0010F\u001a1\u0010?\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\n0Aj\n\u0012\u0006\b\u0000\u0012\u00020\n`BH\u0007¢\u0006\u0004\bG\u0010H\u001a1\u0010?\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000e0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000e`BH\u0007¢\u0006\u0004\bI\u0010J\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007¢\u0006\u0004\bL\u0010+\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0007¢\u0006\u0004\bM\u0010-\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0007¢\u0006\u0004\bN\u0010/\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0007¢\u0006\u0004\bO\u00101\u001a=\u0010P\u001a\u0004\u0018\u00010\u0002\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bQ\u00108\u001a=\u0010P\u001a\u0004\u0018\u00010\u0006\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bR\u0010:\u001a=\u0010P\u001a\u0004\u0018\u00010\n\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bS\u0010<\u001a=\u0010P\u001a\u0004\u0018\u00010\u000e\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bT\u0010>\u001a1\u0010U\u001a\u0004\u0018\u00010\u0002*\u00020\u00032\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00020Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`BH\u0007¢\u0006\u0004\bV\u0010D\u001a1\u0010U\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00060Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0006`BH\u0007¢\u0006\u0004\bW\u0010F\u001a1\u0010U\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\n0Aj\n\u0012\u0006\b\u0000\u0012\u00020\n`BH\u0007¢\u0006\u0004\bX\u0010H\u001a1\u0010U\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000e0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000e`BH\u0007¢\u0006\u0004\bY\u0010J\u001a+\u0010Z\u001a\u00020[*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a+\u0010Z\u001a\u00020^*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020^06H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010`\u001a+\u0010Z\u001a\u00020[*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010a\u001a+\u0010Z\u001a\u00020^*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020^06H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010b\u001a+\u0010Z\u001a\u00020[*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010c\u001a+\u0010Z\u001a\u00020^*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020^06H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010d\u001a+\u0010Z\u001a\u00020[*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010e\u001a+\u0010Z\u001a\u00020^*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020^06H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006g"}, d2 = {"asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "max", "max-GBYM_sE", "([B)Lkotlin/UByte;", "max--ajY-9A", "([I)Lkotlin/UInt;", "max-QwZRm1k", "([J)Lkotlin/ULong;", "max-rL5Bavg", "([S)Lkotlin/UShort;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "maxBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "maxBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "maxBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "maxBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min-GBYM_sE", "min--ajY-9A", "min-QwZRm1k", "min-rL5Bavg", "minBy", "minBy-JOV_ifY", "minBy-jgv0xPQ", "minBy-MShoTSo", "minBy-xTcfx_M", "minWith", "minWith-XMRcp5o", "minWith-YmdZ_VM", "minWith-zrEWJaI", "minWith-eOHTfZs", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, pn = "kotlin.collections", xi = 49, xs = "kotlin/collections/unsigned/UArraysKt")
class UArraysKt___UArraysJvmKt {
    public UArraysKt___UArraysJvmKt() {
    }

    /* JADX INFO: renamed from: asList--ajY-9A, reason: not valid java name */
    public static final List<UInt> m1889asListajY9A(int[] r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$asList");
        return (List) ZeusTransformUtils.preCheckCast(new UArraysKt___UArraysJvmKt$asList$1(r2), List.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: asList-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m1890asListGBYM_sE(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$asList");
        return (List) ZeusTransformUtils.preCheckCast(new UArraysKt___UArraysJvmKt$asList$3(r2), List.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: asList-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m1891asListQwZRm1k(long[] r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$asList");
        return (List) ZeusTransformUtils.preCheckCast(new UArraysKt___UArraysJvmKt$asList$2(r2), List.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: asList-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m1892asListrL5Bavg(short[] r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$asList");
        return (List) ZeusTransformUtils.preCheckCast(new UArraysKt___UArraysJvmKt$asList$4(r2), List.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: binarySearch-2fe2U9s, reason: not valid java name */
    public static final int m1893binarySearch2fe2U9s(int[] r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r4, r5, UIntArray.m1577getSizeimpl(r2));
        int r6 = r5 - 1;
    L3:
        if (r4 > r6) goto L11;
        int r0 = (r4 + r6) >>> 1;
        int r1 = UnsignedKt.uintCompare(r2[r0], r3);
        if (r1 < 0) goto L6;
        if (r1 <= 0) goto L9;
        r6 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r4 = r0 + 1;
        goto L3
    L11:
        return -(r4 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ int m1894binarySearch2fe2U9s$default(int[] r0, int r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = UIntArray.m1577getSizeimpl(r0);
    L9:
        return UArraysKt.m1893binarySearch2fe2U9s(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: binarySearch-EtDCXyQ, reason: not valid java name */
    public static final int m1895binarySearchEtDCXyQ(short[] r2, short r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r4, r5, UShortArray.m1761getSizeimpl(r2));
        int r6 = r3 & UShort.MAX_VALUE;
        int r7 = r5 - 1;
    L3:
        if (r4 > r7) goto L11;
        int r0 = (r4 + r7) >>> 1;
        int r1 = UnsignedKt.uintCompare(r2[r0], r6);
        if (r1 < 0) goto L6;
        if (r1 <= 0) goto L9;
        r7 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r4 = r0 + 1;
        goto L3
    L11:
        return -(r4 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ int m1896binarySearchEtDCXyQ$default(short[] r0, short r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = UShortArray.m1761getSizeimpl(r0);
    L9:
        return UArraysKt.m1895binarySearchEtDCXyQ(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: binarySearch-K6DWlUc, reason: not valid java name */
    public static final int m1897binarySearchK6DWlUc(long[] r3, long r4, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r3, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r6, r7, ULongArray.m1656getSizeimpl(r3));
        int r8 = r7 - 1;
    L3:
        if (r6 > r8) goto L11;
        int r0 = (r6 + r8) >>> 1;
        int r1 = UnsignedKt.ulongCompare(r3[r0], r4);
        if (r1 < 0) goto L6;
        if (r1 <= 0) goto L9;
        r8 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r6 = r0 + 1;
        goto L3
    L11:
        return -(r6 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ int m1898binarySearchK6DWlUc$default(long[] r0, long r1, int r3, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = ULongArray.m1656getSizeimpl(r0);
    L9:
        return UArraysKt.m1897binarySearchK6DWlUc(r0, r1, r3, r4);
    }

    /* JADX INFO: renamed from: binarySearch-WpHrYlw, reason: not valid java name */
    public static final int m1899binarySearchWpHrYlw(byte[] r2, byte r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r4, r5, UByteArray.m1498getSizeimpl(r2));
        int r6 = r3 & 255;
        int r7 = r5 - 1;
    L3:
        if (r4 > r7) goto L11;
        int r0 = (r4 + r7) >>> 1;
        int r1 = UnsignedKt.uintCompare(r2[r0], r6);
        if (r1 < 0) goto L6;
        if (r1 <= 0) goto L9;
        r7 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r4 = r0 + 1;
        goto L3
    L11:
        return -(r4 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ int m1900binarySearchWpHrYlw$default(byte[] r0, byte r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = UByteArray.m1498getSizeimpl(r0);
    L9:
        return UArraysKt.m1899binarySearchWpHrYlw(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: elementAt-PpDY95g, reason: not valid java name */
    private static final byte m1901elementAtPpDY95g(byte[] r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$elementAt");
        return UByteArray.m1497getw2LRezQ(r1, r2);
    }

    /* JADX INFO: renamed from: elementAt-nggk6HY, reason: not valid java name */
    private static final short m1902elementAtnggk6HY(short[] r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$elementAt");
        return UShortArray.m1760getMh2AYeg(r1, r2);
    }

    /* JADX INFO: renamed from: elementAt-qFRl0hI, reason: not valid java name */
    private static final int m1903elementAtqFRl0hI(int[] r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$elementAt");
        return UIntArray.m1576getpVg5ArA(r1, r2);
    }

    /* JADX INFO: renamed from: elementAt-r7IrZao, reason: not valid java name */
    private static final long m1904elementAtr7IrZao(long[] r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$elementAt");
        return ULongArray.m1655getsVKNKU(r1, r2);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ UInt m1905maxajY9A(int[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$max");
        return UArraysKt.m2273maxOrNullajY9A(r1);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ UByte m1906maxGBYM_sE(byte[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$max");
        return UArraysKt.m2274maxOrNullGBYM_sE(r1);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ ULong m1907maxQwZRm1k(long[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$max");
        return UArraysKt.m2275maxOrNullQwZRm1k(r1);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ UShort m1908maxrL5Bavg(short[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$max");
        return UArraysKt.m2276maxOrNullrL5Bavg(r1);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m1909maxByJOV_ifY(byte[] r8, Function1<? super UByte, ? extends R> r9) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r10, "selector");
        if (UByteArray.m1500isEmptyimpl(r8) == false) goto L5;
        return null;
    L5:
        byte r0 = UByteArray.m1497getw2LRezQ(r8, 0);
        int r2 = ArraysKt.getLastIndex(r8);
        if (r2 == 0) goto L17;
        Comparable r3 = (Comparable) ZeusTransformUtils.preCheckCast(r10.invoke(UByte.m1433boximpl(r0)), Comparable.class, "com.obric.memorydata.plugin");
        int r4 = 1;
        if (1 > r2) goto L17;
    L10:
        byte r5 = UByteArray.m1497getw2LRezQ(r8, r4);
        Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(r10.invoke(UByte.m1433boximpl(r5)), Comparable.class, "com.obric.memorydata.plugin");
        if (r3.compareTo(r6) >= 0) goto L13;
        r0 = r5;
        r3 = r6;
    L13:
        if (r4 == r2) goto L17;
        r4 = r4 + 1;
    L17:
        return UByte.m1433boximpl(r0);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m1910maxByMShoTSo(long[] r10, Function1<? super ULong, ? extends R> r11) {
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (ULongArray.m1658isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        long r2 = ULongArray.m1655getsVKNKU(r10, 0);
        int r0 = ArraysKt.getLastIndex(r10);
        if (r0 == 0) goto L17;
        Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(r12.invoke(ULong.m1589boximpl(r2)), Comparable.class, "com.obric.memorydata.plugin");
        int r5 = 1;
        if (1 > r0) goto L17;
    L10:
        long r6 = ULongArray.m1655getsVKNKU(r10, r5);
        Comparable r8 = (Comparable) ZeusTransformUtils.preCheckCast(r12.invoke(ULong.m1589boximpl(r6)), Comparable.class, "com.obric.memorydata.plugin");
        if (r4.compareTo(r8) >= 0) goto L13;
        r2 = r6;
        r4 = r8;
    L13:
        if (r5 == r0) goto L17;
        r5 = r5 + 1;
    L17:
        return ULong.m1589boximpl(r2);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m1911maxByjgv0xPQ(int[] r8, Function1<? super UInt, ? extends R> r9) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r10, "selector");
        if (UIntArray.m1579isEmptyimpl(r8) == false) goto L5;
        return null;
    L5:
        int r0 = UIntArray.m1576getpVg5ArA(r8, 0);
        int r2 = ArraysKt.getLastIndex(r8);
        if (r2 == 0) goto L17;
        Comparable r3 = (Comparable) ZeusTransformUtils.preCheckCast(r10.invoke(UInt.m1510boximpl(r0)), Comparable.class, "com.obric.memorydata.plugin");
        int r4 = 1;
        if (1 > r2) goto L17;
    L10:
        int r5 = UIntArray.m1576getpVg5ArA(r8, r4);
        Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(r10.invoke(UInt.m1510boximpl(r5)), Comparable.class, "com.obric.memorydata.plugin");
        if (r3.compareTo(r6) >= 0) goto L13;
        r0 = r5;
        r3 = r6;
    L13:
        if (r4 == r2) goto L17;
        r4 = r4 + 1;
    L17:
        return UInt.m1510boximpl(r0);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m1912maxByxTcfx_M(short[] r8, Function1<? super UShort, ? extends R> r9) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r10, "selector");
        if (UShortArray.m1763isEmptyimpl(r8) == false) goto L5;
        return null;
    L5:
        short r0 = UShortArray.m1760getMh2AYeg(r8, 0);
        int r2 = ArraysKt.getLastIndex(r8);
        if (r2 == 0) goto L17;
        Comparable r3 = (Comparable) ZeusTransformUtils.preCheckCast(r10.invoke(UShort.m1696boximpl(r0)), Comparable.class, "com.obric.memorydata.plugin");
        int r4 = 1;
        if (1 > r2) goto L17;
    L10:
        short r5 = UShortArray.m1760getMh2AYeg(r8, r4);
        Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(r10.invoke(UShort.m1696boximpl(r5)), Comparable.class, "com.obric.memorydata.plugin");
        if (r3.compareTo(r6) >= 0) goto L13;
        r0 = r5;
        r3 = r6;
    L13:
        if (r4 == r2) goto L17;
        r4 = r4 + 1;
    L17:
        return UShort.m1696boximpl(r0);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ UByte m1913maxWithXMRcp5o(byte[] r2, Comparator r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        return UArraysKt.m2281maxWithOrNullXMRcp5o(r2, r4);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ UInt m1914maxWithYmdZ_VM(int[] r2, Comparator r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        return UArraysKt.m2282maxWithOrNullYmdZ_VM(r2, r4);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ UShort m1915maxWitheOHTfZs(short[] r2, Comparator r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        return UArraysKt.m2283maxWithOrNulleOHTfZs(r2, r4);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ ULong m1916maxWithzrEWJaI(long[] r2, Comparator r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        return UArraysKt.m2284maxWithOrNullzrEWJaI(r2, r4);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ UInt m1917minajY9A(int[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$min");
        return UArraysKt.m2329minOrNullajY9A(r1);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ UByte m1918minGBYM_sE(byte[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$min");
        return UArraysKt.m2330minOrNullGBYM_sE(r1);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ ULong m1919minQwZRm1k(long[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$min");
        return UArraysKt.m2331minOrNullQwZRm1k(r1);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ UShort m1920minrL5Bavg(short[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$min");
        return UArraysKt.m2332minOrNullrL5Bavg(r1);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m1921minByJOV_ifY(byte[] r8, Function1<? super UByte, ? extends R> r9) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "$this$minBy");
        Intrinsics.checkNotNullParameter(r10, "selector");
        if (UByteArray.m1500isEmptyimpl(r8) == false) goto L5;
        return null;
    L5:
        byte r0 = UByteArray.m1497getw2LRezQ(r8, 0);
        int r2 = ArraysKt.getLastIndex(r8);
        if (r2 == 0) goto L17;
        Comparable r3 = (Comparable) ZeusTransformUtils.preCheckCast(r10.invoke(UByte.m1433boximpl(r0)), Comparable.class, "com.obric.memorydata.plugin");
        int r4 = 1;
        if (1 > r2) goto L17;
    L10:
        byte r5 = UByteArray.m1497getw2LRezQ(r8, r4);
        Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(r10.invoke(UByte.m1433boximpl(r5)), Comparable.class, "com.obric.memorydata.plugin");
        if (r3.compareTo(r6) <= 0) goto L13;
        r0 = r5;
        r3 = r6;
    L13:
        if (r4 == r2) goto L17;
        r4 = r4 + 1;
    L17:
        return UByte.m1433boximpl(r0);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m1922minByMShoTSo(long[] r10, Function1<? super ULong, ? extends R> r11) {
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "$this$minBy");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (ULongArray.m1658isEmptyimpl(r10) == false) goto L5;
        return null;
    L5:
        long r2 = ULongArray.m1655getsVKNKU(r10, 0);
        int r0 = ArraysKt.getLastIndex(r10);
        if (r0 == 0) goto L17;
        Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(r12.invoke(ULong.m1589boximpl(r2)), Comparable.class, "com.obric.memorydata.plugin");
        int r5 = 1;
        if (1 > r0) goto L17;
    L10:
        long r6 = ULongArray.m1655getsVKNKU(r10, r5);
        Comparable r8 = (Comparable) ZeusTransformUtils.preCheckCast(r12.invoke(ULong.m1589boximpl(r6)), Comparable.class, "com.obric.memorydata.plugin");
        if (r4.compareTo(r8) <= 0) goto L13;
        r2 = r6;
        r4 = r8;
    L13:
        if (r5 == r0) goto L17;
        r5 = r5 + 1;
    L17:
        return ULong.m1589boximpl(r2);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m1923minByjgv0xPQ(int[] r8, Function1<? super UInt, ? extends R> r9) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "$this$minBy");
        Intrinsics.checkNotNullParameter(r10, "selector");
        if (UIntArray.m1579isEmptyimpl(r8) == false) goto L5;
        return null;
    L5:
        int r0 = UIntArray.m1576getpVg5ArA(r8, 0);
        int r2 = ArraysKt.getLastIndex(r8);
        if (r2 == 0) goto L17;
        Comparable r3 = (Comparable) ZeusTransformUtils.preCheckCast(r10.invoke(UInt.m1510boximpl(r0)), Comparable.class, "com.obric.memorydata.plugin");
        int r4 = 1;
        if (1 > r2) goto L17;
    L10:
        int r5 = UIntArray.m1576getpVg5ArA(r8, r4);
        Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(r10.invoke(UInt.m1510boximpl(r5)), Comparable.class, "com.obric.memorydata.plugin");
        if (r3.compareTo(r6) <= 0) goto L13;
        r0 = r5;
        r3 = r6;
    L13:
        if (r4 == r2) goto L17;
        r4 = r4 + 1;
    L17:
        return UInt.m1510boximpl(r0);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m1924minByxTcfx_M(short[] r8, Function1<? super UShort, ? extends R> r9) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "$this$minBy");
        Intrinsics.checkNotNullParameter(r10, "selector");
        if (UShortArray.m1763isEmptyimpl(r8) == false) goto L5;
        return null;
    L5:
        short r0 = UShortArray.m1760getMh2AYeg(r8, 0);
        int r2 = ArraysKt.getLastIndex(r8);
        if (r2 == 0) goto L17;
        Comparable r3 = (Comparable) ZeusTransformUtils.preCheckCast(r10.invoke(UShort.m1696boximpl(r0)), Comparable.class, "com.obric.memorydata.plugin");
        int r4 = 1;
        if (1 > r2) goto L17;
    L10:
        short r5 = UShortArray.m1760getMh2AYeg(r8, r4);
        Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(r10.invoke(UShort.m1696boximpl(r5)), Comparable.class, "com.obric.memorydata.plugin");
        if (r3.compareTo(r6) <= 0) goto L13;
        r0 = r5;
        r3 = r6;
    L13:
        if (r4 == r2) goto L17;
        r4 = r4 + 1;
    L17:
        return UShort.m1696boximpl(r0);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ UByte m1925minWithXMRcp5o(byte[] r2, Comparator r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "$this$minWith");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        return UArraysKt.m2337minWithOrNullXMRcp5o(r2, r4);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ UInt m1926minWithYmdZ_VM(int[] r2, Comparator r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "$this$minWith");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        return UArraysKt.m2338minWithOrNullYmdZ_VM(r2, r4);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ UShort m1927minWitheOHTfZs(short[] r2, Comparator r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "$this$minWith");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        return UArraysKt.m2339minWithOrNulleOHTfZs(r2, r4);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ ULong m1928minWithzrEWJaI(long[] r2, Comparator r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "$this$minWith");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        return UArraysKt.m2340minWithOrNullzrEWJaI(r2, r4);
    }

    private static final BigDecimal sumOfBigDecimal(byte[] r6, Function1<? super UByte, ? extends BigDecimal> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r8, "selector");
        BigDecimal r0 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r2 = UByteArray.m1498getSizeimpl(r6);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r0 = r0.add((BigDecimal) ZeusTransformUtils.preCheckCast(r8.invoke(UByte.m1433boximpl(UByteArray.m1497getw2LRezQ(r6, r3))), BigDecimal.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final BigDecimal sumOfBigDecimal(int[] r6, Function1<? super UInt, ? extends BigDecimal> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r8, "selector");
        BigDecimal r0 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r2 = UIntArray.m1577getSizeimpl(r6);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r0 = r0.add((BigDecimal) ZeusTransformUtils.preCheckCast(r8.invoke(UInt.m1510boximpl(UIntArray.m1576getpVg5ArA(r6, r3))), BigDecimal.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final BigDecimal sumOfBigDecimal(long[] r6, Function1<? super ULong, ? extends BigDecimal> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r8, "selector");
        BigDecimal r0 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r2 = ULongArray.m1656getSizeimpl(r6);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r0 = r0.add((BigDecimal) ZeusTransformUtils.preCheckCast(r8.invoke(ULong.m1589boximpl(ULongArray.m1655getsVKNKU(r6, r3))), BigDecimal.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final BigDecimal sumOfBigDecimal(short[] r6, Function1<? super UShort, ? extends BigDecimal> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r8, "selector");
        BigDecimal r0 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r2 = UShortArray.m1761getSizeimpl(r6);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r0 = r0.add((BigDecimal) ZeusTransformUtils.preCheckCast(r8.invoke(UShort.m1696boximpl(UShortArray.m1760getMh2AYeg(r6, r3))), BigDecimal.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final BigInteger sumOfBigInteger(byte[] r6, Function1<? super UByte, ? extends BigInteger> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r8, "selector");
        BigInteger r0 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r2 = UByteArray.m1498getSizeimpl(r6);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r0 = r0.add((BigInteger) ZeusTransformUtils.preCheckCast(r8.invoke(UByte.m1433boximpl(UByteArray.m1497getw2LRezQ(r6, r3))), BigInteger.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final BigInteger sumOfBigInteger(int[] r6, Function1<? super UInt, ? extends BigInteger> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r8, "selector");
        BigInteger r0 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r2 = UIntArray.m1577getSizeimpl(r6);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r0 = r0.add((BigInteger) ZeusTransformUtils.preCheckCast(r8.invoke(UInt.m1510boximpl(UIntArray.m1576getpVg5ArA(r6, r3))), BigInteger.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final BigInteger sumOfBigInteger(long[] r6, Function1<? super ULong, ? extends BigInteger> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r8, "selector");
        BigInteger r0 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r2 = ULongArray.m1656getSizeimpl(r6);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r0 = r0.add((BigInteger) ZeusTransformUtils.preCheckCast(r8.invoke(ULong.m1589boximpl(ULongArray.m1655getsVKNKU(r6, r3))), BigInteger.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final BigInteger sumOfBigInteger(short[] r6, Function1<? super UShort, ? extends BigInteger> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r8, "selector");
        BigInteger r0 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r2 = UShortArray.m1761getSizeimpl(r6);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r0 = r0.add((BigInteger) ZeusTransformUtils.preCheckCast(r8.invoke(UShort.m1696boximpl(UShortArray.m1760getMh2AYeg(r6, r3))), BigInteger.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }
}
