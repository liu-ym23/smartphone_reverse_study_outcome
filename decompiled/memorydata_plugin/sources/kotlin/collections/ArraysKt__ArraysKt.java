package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\t\u0010\n\u001a?\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003¢\u0006\u0002\u0010\u0016\u001aH\u0010\u0017\u001a\u0002H\u0018\"\u0010\b\u0000\u0010\u0019*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0018\"\u0004\b\u0001\u0010\u0018*\u0002H\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0002\u0010\u001e\u001aG\u0010\u001f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00150 \"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00180 0\u0003¢\u0006\u0002\u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"contentDeepEqualsImpl", "", ExifInterface.GPS_DIRECTION_TRUE, "", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "flatten", "", "([[Ljava/lang/Object;)Ljava/util/List;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "unzip", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lkotlin/Pair;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    public ArraysKt__ArraysKt() {
    }

    public static final <T> boolean contentDeepEquals(T[] r16, T[] r17) {
        boolean r10 = true;
        if (r16 != r17) goto L5;
        return true;
    L5:
        if (r16 == null) goto L130;
        if (r17 != null) goto L8;
        return false;
    L8:
        if (r16.length != r17.length) goto L153;
        int r12 = r16.length;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L129;
        T r14 = r16[r13];
        T r15 = r17[r13];
        if (r14 == r15) goto L125;
        if (r14 == null) goto L126;
        if (r15 == null) goto L151;
        if ((r14 instanceof Object[]) == false) goto L27;
        if ((r15 instanceof Object[]) == false) goto L27;
        if (ArraysKt.contentDeepEquals((Object[]) ZeusTransformUtils.preCheckCast(r14, Object[].class, "com.obric.memorydata.plugin"), (Object[]) ZeusTransformUtils.preCheckCast(r15, Object[].class, "com.obric.memorydata.plugin")) == true) goto L125;
        return false;
    L27:
        if ((r14 instanceof byte[]) == false) goto L35;
        if ((r15 instanceof byte[]) == false) goto L35;
        if (Arrays.equals((byte[]) ZeusTransformUtils.preCheckCast(r14, byte[].class, "com.obric.memorydata.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(r15, byte[].class, "com.obric.memorydata.plugin")) == true) goto L125;
        return false;
    L35:
        if ((r14 instanceof short[]) == false) goto L43;
        if ((r15 instanceof short[]) == false) goto L43;
        if (Arrays.equals((short[]) ZeusTransformUtils.preCheckCast(r14, short[].class, "com.obric.memorydata.plugin"), (short[]) ZeusTransformUtils.preCheckCast(r15, short[].class, "com.obric.memorydata.plugin")) == true) goto L125;
        return false;
    L43:
        if ((r14 instanceof int[]) == false) goto L51;
        if ((r15 instanceof int[]) == false) goto L51;
        if (Arrays.equals((int[]) ZeusTransformUtils.preCheckCast(r14, int[].class, "com.obric.memorydata.plugin"), (int[]) ZeusTransformUtils.preCheckCast(r15, int[].class, "com.obric.memorydata.plugin")) == true) goto L125;
        return false;
    L51:
        if ((r14 instanceof long[]) == false) goto L59;
        if ((r15 instanceof long[]) == false) goto L59;
        if (Arrays.equals((long[]) ZeusTransformUtils.preCheckCast(r14, long[].class, "com.obric.memorydata.plugin"), (long[]) ZeusTransformUtils.preCheckCast(r15, long[].class, "com.obric.memorydata.plugin")) == true) goto L125;
        return false;
    L59:
        if ((r14 instanceof float[]) == false) goto L67;
        if ((r15 instanceof float[]) == false) goto L67;
        if (Arrays.equals((float[]) ZeusTransformUtils.preCheckCast(r14, float[].class, "com.obric.memorydata.plugin"), (float[]) ZeusTransformUtils.preCheckCast(r15, float[].class, "com.obric.memorydata.plugin")) == true) goto L125;
        return false;
    L67:
        if ((r14 instanceof double[]) == false) goto L75;
        if ((r15 instanceof double[]) == false) goto L75;
        if (Arrays.equals((double[]) ZeusTransformUtils.preCheckCast(r14, double[].class, "com.obric.memorydata.plugin"), (double[]) ZeusTransformUtils.preCheckCast(r15, double[].class, "com.obric.memorydata.plugin")) == true) goto L125;
        return false;
    L75:
        if ((r14 instanceof char[]) == false) goto L83;
        if ((r15 instanceof char[]) == false) goto L83;
        if (Arrays.equals((char[]) ZeusTransformUtils.preCheckCast(r14, char[].class, "com.obric.memorydata.plugin"), (char[]) ZeusTransformUtils.preCheckCast(r15, char[].class, "com.obric.memorydata.plugin")) == true) goto L125;
        return false;
    L83:
        if ((r14 instanceof boolean[]) == false) goto L91;
        if ((r15 instanceof boolean[]) == false) goto L91;
        if (Arrays.equals((boolean[]) ZeusTransformUtils.preCheckCast(r14, boolean[].class, "com.obric.memorydata.plugin"), (boolean[]) ZeusTransformUtils.preCheckCast(r15, boolean[].class, "com.obric.memorydata.plugin")) == true) goto L125;
        return false;
    L91:
        if (ZeusTransformUtils.instanceOf(r14, UByteArray.class) == false) goto L99;
        if (ZeusTransformUtils.instanceOf(r15, UByteArray.class) == false) goto L99;
        if (UArraysKt.m1991contentEqualskV0jMPg(((UByteArray) ZeusTransformUtils.preCheckCast(r14, UByteArray.class, "com.obric.memorydata.plugin")).m1506unboximpl(), ((UByteArray) ZeusTransformUtils.preCheckCast(r15, UByteArray.class, "com.obric.memorydata.plugin")).m1506unboximpl()) == true) goto L125;
        return false;
    L99:
        if (ZeusTransformUtils.instanceOf(r14, UShortArray.class) == false) goto L107;
        if (ZeusTransformUtils.instanceOf(r15, UShortArray.class) == false) goto L107;
        if (UArraysKt.m1989contentEqualsFGO6Aew(((UShortArray) ZeusTransformUtils.preCheckCast(r14, UShortArray.class, "com.obric.memorydata.plugin")).m1769unboximpl(), ((UShortArray) ZeusTransformUtils.preCheckCast(r15, UShortArray.class, "com.obric.memorydata.plugin")).m1769unboximpl()) == true) goto L125;
        return false;
    L107:
        if (ZeusTransformUtils.instanceOf(r14, UIntArray.class) == false) goto L115;
        if (ZeusTransformUtils.instanceOf(r15, UIntArray.class) == false) goto L115;
        if (UArraysKt.m1990contentEqualsKJPZfPQ(((UIntArray) ZeusTransformUtils.preCheckCast(r14, UIntArray.class, "com.obric.memorydata.plugin")).m1585unboximpl(), ((UIntArray) ZeusTransformUtils.preCheckCast(r15, UIntArray.class, "com.obric.memorydata.plugin")).m1585unboximpl()) == true) goto L125;
        return false;
    L115:
        if (ZeusTransformUtils.instanceOf(r14, ULongArray.class) == false) goto L123;
        if (ZeusTransformUtils.instanceOf(r15, ULongArray.class) == false) goto L123;
        if (UArraysKt.m1992contentEqualslec5QzE(((ULongArray) ZeusTransformUtils.preCheckCast(r14, ULongArray.class, "com.obric.memorydata.plugin")).m1664unboximpl(), ((ULongArray) ZeusTransformUtils.preCheckCast(r15, ULongArray.class, "com.obric.memorydata.plugin")).m1664unboximpl()) == true) goto L125;
        return false;
    L123:
        if (Intrinsics.areEqual(r14, r15) == true) goto L125;
        return false;
    L151:
        return false;
    L126:
        return false;
    L125:
        r13 = r13 + 1;
        r10 = true;
        goto L11
    L129:
        return r10;
    L153:
        return false;
    L130:
        return false;
    }

    public static final <T> String contentDeepToString(T[] r4) {
        if (r4 != null) goto L5;
        return "null";
    L5:
        StringBuilder r1 = new StringBuilder((RangesKt.coerceAtMost(r4.length, 429496729) * 5) + 2);
        contentDeepToStringInternal$ArraysKt__ArraysKt(r4, r1, (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        String r5 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        return r5;
    }

    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(T[] r6, StringBuilder r7, List<Object[]> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r9.contains(r6) == false) goto L6;
        r7.append("[...]");
        return;
    L6:
        r9.add(r6);
        r7.append('[');
        int r0 = 0;
        int r2 = r6.length;
    L7:
        if (r0 >= r2) goto L68;
        if (r0 == 0) goto L10;
        r7.append(", ");
    L10:
        T r3 = r6[r0];
        if (r3 != null) goto L15;
        String r4 = "null";
    L13:
        r7.append(r4);
    L67:
        r0 = r0 + 1;
        goto L7
    L15:
        if ((r3 instanceof Object[]) == false) goto L18;
        contentDeepToStringInternal$ArraysKt__ArraysKt((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.memorydata.plugin"), r7, r9);
        goto L67
    L18:
        if ((r3 instanceof byte[]) == false) goto L22;
        r4 = Arrays.toString((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"));
    L20:
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        goto L13
    L22:
        if ((r3 instanceof short[]) == false) goto L25;
        r4 = Arrays.toString((short[]) ZeusTransformUtils.preCheckCast(r3, short[].class, "com.obric.memorydata.plugin"));
        goto L20
    L25:
        if ((r3 instanceof int[]) == false) goto L28;
        r4 = Arrays.toString((int[]) ZeusTransformUtils.preCheckCast(r3, int[].class, "com.obric.memorydata.plugin"));
        goto L20
    L28:
        if ((r3 instanceof long[]) == false) goto L31;
        r4 = Arrays.toString((long[]) ZeusTransformUtils.preCheckCast(r3, long[].class, "com.obric.memorydata.plugin"));
        goto L20
    L31:
        if ((r3 instanceof float[]) == false) goto L34;
        r4 = Arrays.toString((float[]) ZeusTransformUtils.preCheckCast(r3, float[].class, "com.obric.memorydata.plugin"));
        goto L20
    L34:
        if ((r3 instanceof double[]) == false) goto L37;
        r4 = Arrays.toString((double[]) ZeusTransformUtils.preCheckCast(r3, double[].class, "com.obric.memorydata.plugin"));
        goto L20
    L37:
        if ((r3 instanceof char[]) == false) goto L40;
        r4 = Arrays.toString((char[]) ZeusTransformUtils.preCheckCast(r3, char[].class, "com.obric.memorydata.plugin"));
        goto L20
    L40:
        if ((r3 instanceof boolean[]) == false) goto L42;
        r4 = Arrays.toString((boolean[]) ZeusTransformUtils.preCheckCast(r3, boolean[].class, "com.obric.memorydata.plugin"));
        goto L20
    L42:
        long[] r5 = null;
        byte[] r10 = null;
        short[] r11 = null;
        int[] r12 = null;
        if (ZeusTransformUtils.instanceOf(r3, UByteArray.class) == false) goto L49;
        UByteArray r13 = (UByteArray) ZeusTransformUtils.preCheckCast(r3, UByteArray.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L47;
        r10 = r13.m1506unboximpl();
    L47:
        r4 = UArraysKt.m1997contentToString2csIQuQ(r10);
        goto L13
    L49:
        if (ZeusTransformUtils.instanceOf(r3, UShortArray.class) == false) goto L55;
        UShortArray r14 = (UShortArray) ZeusTransformUtils.preCheckCast(r3, UShortArray.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L53;
        r11 = r14.m1769unboximpl();
    L53:
        r4 = UArraysKt.m1999contentToStringd6D3K8(r11);
        goto L13
    L55:
        if (ZeusTransformUtils.instanceOf(r3, UIntArray.class) == false) goto L61;
        UIntArray r15 = (UIntArray) ZeusTransformUtils.preCheckCast(r3, UIntArray.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L59;
        r12 = r15.m1585unboximpl();
    L59:
        r4 = UArraysKt.m1998contentToStringXUkPCBk(r12);
        goto L13
    L61:
        if (ZeusTransformUtils.instanceOf(r3, ULongArray.class) == false) goto L66;
        ULongArray r16 = (ULongArray) ZeusTransformUtils.preCheckCast(r3, ULongArray.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L65;
        r5 = r16.m1664unboximpl();
    L65:
        r4 = UArraysKt.m2000contentToStringuLth9ew(r5);
        goto L13
    L66:
        r4 = r3.toString();
        goto L13
    L68:
        r7.append(']');
        r9.remove(CollectionsKt.getLastIndex(r9));
    }

    public static final <T> List<T> flatten(T[][] r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Object[] r0 = (Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin");
        int r2 = r0.length;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r5 = r5 + ((Object[]) ZeusTransformUtils.preCheckCast(r0[r4], Object[].class, "com.obric.memorydata.plugin")).length;
        r4 = r4 + 1;
        goto L3
    L5:
        ArrayList r1 = new ArrayList(r5);
        int r6 = ((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin")).length;
    L6:
        if (r3 >= r6) goto L9;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"), r8[r3]);
        r3 = r3 + 1;
        goto L6
    L9:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    private static final Object ifEmpty(Object[] r2, Function0 r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "defaultValue");
        if (r2.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return r2;
    L8:
        return r4.invoke();
    L5:
        r0 = false;
        goto L6
    }

    private static final boolean isNullOrEmpty(Object[] r2) {
        if (r2 == null) goto L10;
        if (r2.length != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L10;
        return false;
    L7:
        r3 = false;
    L10:
        return true;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Pair<? extends T, ? extends R>[] r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        ArrayList r0 = new ArrayList(r6.length);
        ArrayList r1 = new ArrayList(r6.length);
        int r2 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L6;
        Pair<? extends T, ? extends R> r4 = r6[r3];
        r0.add(r4.getFirst());
        r1.add(r4.getSecond());
        r3 = r3 + 1;
        goto L3
    L6:
        return TuplesKt.to(r0, r1);
    }
}
