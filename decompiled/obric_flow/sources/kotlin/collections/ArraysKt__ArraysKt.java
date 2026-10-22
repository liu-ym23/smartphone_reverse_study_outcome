package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\t\u0010\n\u001a?\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003¢\u0006\u0002\u0010\u0016\u001aH\u0010\u0017\u001a\u0002H\u0018\"\u0010\b\u0000\u0010\u0019*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0018\"\u0004\b\u0001\u0010\u0018*\u0002H\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0002\u0010\u001e\u001aG\u0010\u001f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00150 \"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00180 0\u0003¢\u0006\u0002\u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"contentDeepEqualsImpl", "", ExifInterface.GPS_DIRECTION_TRUE, "", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "flatten", "", "([[Ljava/lang/Object;)Ljava/util/List;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "unzip", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lkotlin/Pair;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
@SourceDebugExtension({"SMAP\nArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Arrays.kt\nkotlin/collections/ArraysKt__ArraysKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,165:1\n1#2:166\n*E\n"})
class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    public ArraysKt__ArraysKt() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepEquals")
    public static <T> boolean contentDeepEquals(T[] r10, T[] r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if (r10 == 0) goto L116;
        if (r11 == 0) goto L116;
        if (r10.length != r11.length) goto L116;
        int r5 = r10.length;
        int r12 = 0;
    L12:
        if (r12 >= r5) goto L115;
        Object[] r13 = r10[r12];
        Object[] r14 = r11[r12];
        if (r13 == r14) goto L113;
        if (r13 == 0) goto L114;
        if (r14 == 0) goto L114;
        if ((r13 instanceof Object[]) == false) goto L27;
        if ((r14 instanceof Object[]) == false) goto L27;
        if (contentDeepEquals(r13, r14) == true) goto L113;
        return false;
    L27:
        if ((r13 instanceof byte[]) == false) goto L34;
        if ((r14 instanceof byte[]) == false) goto L34;
        if (Arrays.equals((byte[]) r13, (byte[]) r14) == true) goto L113;
        return false;
    L34:
        if ((r13 instanceof short[]) == false) goto L41;
        if ((r14 instanceof short[]) == false) goto L41;
        if (Arrays.equals((short[]) r13, (short[]) r14) == true) goto L113;
        return false;
    L41:
        if ((r13 instanceof int[]) == false) goto L48;
        if ((r14 instanceof int[]) == false) goto L48;
        if (Arrays.equals((int[]) r13, (int[]) r14) == true) goto L113;
        return false;
    L48:
        if ((r13 instanceof long[]) == false) goto L55;
        if ((r14 instanceof long[]) == false) goto L55;
        if (Arrays.equals((long[]) r13, (long[]) r14) == true) goto L113;
        return false;
    L55:
        if ((r13 instanceof float[]) == false) goto L62;
        if ((r14 instanceof float[]) == false) goto L62;
        if (Arrays.equals((float[]) r13, (float[]) r14) == true) goto L113;
        return false;
    L62:
        if ((r13 instanceof double[]) == false) goto L69;
        if ((r14 instanceof double[]) == false) goto L69;
        if (Arrays.equals((double[]) r13, (double[]) r14) == true) goto L113;
        return false;
    L69:
        if ((r13 instanceof char[]) == false) goto L76;
        if ((r14 instanceof char[]) == false) goto L76;
        if (Arrays.equals((char[]) r13, (char[]) r14) == true) goto L113;
        return false;
    L76:
        if ((r13 instanceof boolean[]) == false) goto L83;
        if ((r14 instanceof boolean[]) == false) goto L83;
        if (Arrays.equals((boolean[]) r13, (boolean[]) r14) == true) goto L113;
        return false;
    L83:
        if ((r13 instanceof UByteArray) == false) goto L90;
        if ((r14 instanceof UByteArray) == false) goto L90;
        if (UArraysKt.m694contentEqualskV0jMPg(((UByteArray) r13).m209unboximpl(), ((UByteArray) r14).m209unboximpl()) == true) goto L113;
        return false;
    L90:
        if ((r13 instanceof UShortArray) == false) goto L97;
        if ((r14 instanceof UShortArray) == false) goto L97;
        if (UArraysKt.m692contentEqualsFGO6Aew(((UShortArray) r13).m472unboximpl(), ((UShortArray) r14).m472unboximpl()) == true) goto L113;
        return false;
    L97:
        if ((r13 instanceof UIntArray) == false) goto L104;
        if ((r14 instanceof UIntArray) == false) goto L104;
        if (UArraysKt.m693contentEqualsKJPZfPQ(((UIntArray) r13).m288unboximpl(), ((UIntArray) r14).m288unboximpl()) == true) goto L113;
        return false;
    L104:
        if ((r13 instanceof ULongArray) == false) goto L111;
        if ((r14 instanceof ULongArray) == false) goto L111;
        if (UArraysKt.m695contentEqualslec5QzE(((ULongArray) r13).m367unboximpl(), ((ULongArray) r14).m367unboximpl()) == true) goto L113;
        return false;
    L111:
        if (Intrinsics.areEqual(r13, r14) == true) goto L113;
        return false;
    L114:
        return false;
    L113:
        r12 = r12 + 1;
        goto L12
    L115:
        return true;
    L116:
        return false;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepToString")
    public static final <T> String contentDeepToString(T[] r5) {
        if (r5 != null) goto L5;
        return "null";
    L5:
        StringBuilder r10 = new StringBuilder((RangesKt.coerceAtMost(r5.length, 429496729) * 5) + 2);
        contentDeepToStringInternal$ArraysKt__ArraysKt(r5, r10, new ArrayList());
        return r10.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(T[] r5, StringBuilder r10, List<Object[]> r11) {
        if (r11.contains(r5) == false) goto L6;
        r10.append("[...]");
        return;
    L6:
        r11.add(r5);
        r10.append('[');
        int r12 = r5.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L54;
        if (r13 == 0) goto L10;
        r10.append(", ");
    L10:
        Object[] r14 = r5[r13];
        if (r14 != 0) goto L14;
        r10.append("null");
    L53:
        r13 = r13 + 1;
        goto L7
    L14:
        if ((r14 instanceof Object[]) == false) goto L17;
        contentDeepToStringInternal$ArraysKt__ArraysKt(r14, r10, r11);
        goto L53
    L17:
        if ((r14 instanceof byte[]) == false) goto L20;
        r10.append(Arrays.toString((byte[]) r14));
        goto L53
    L20:
        if ((r14 instanceof short[]) == false) goto L23;
        r10.append(Arrays.toString((short[]) r14));
        goto L53
    L23:
        if ((r14 instanceof int[]) == false) goto L26;
        r10.append(Arrays.toString((int[]) r14));
        goto L53
    L26:
        if ((r14 instanceof long[]) == false) goto L29;
        r10.append(Arrays.toString((long[]) r14));
        goto L53
    L29:
        if ((r14 instanceof float[]) == false) goto L32;
        r10.append(Arrays.toString((float[]) r14));
        goto L53
    L32:
        if ((r14 instanceof double[]) == false) goto L35;
        r10.append(Arrays.toString((double[]) r14));
        goto L53
    L35:
        if ((r14 instanceof char[]) == false) goto L38;
        r10.append(Arrays.toString((char[]) r14));
        goto L53
    L38:
        if ((r14 instanceof boolean[]) == false) goto L41;
        r10.append(Arrays.toString((boolean[]) r14));
        goto L53
    L41:
        if ((r14 instanceof UByteArray) == false) goto L44;
        r10.append(UArraysKt.m700contentToString2csIQuQ(((UByteArray) r14).m209unboximpl()));
        goto L53
    L44:
        if ((r14 instanceof UShortArray) == false) goto L47;
        r10.append(UArraysKt.m702contentToStringd6D3K8(((UShortArray) r14).m472unboximpl()));
        goto L53
    L47:
        if ((r14 instanceof UIntArray) == false) goto L50;
        r10.append(UArraysKt.m701contentToStringXUkPCBk(((UIntArray) r14).m288unboximpl()));
        goto L53
    L50:
        if ((r14 instanceof ULongArray) == false) goto L52;
        r10.append(UArraysKt.m703contentToStringuLth9ew(((ULongArray) r14).m367unboximpl()));
        goto L53
    L52:
        r10.append(r14.toString());
        goto L53
    L54:
        r10.append(']');
        r11.remove(CollectionsKt__CollectionsKt.getLastIndex(r11));
    }

    public static final <T> List<T> flatten(T[][] r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r10 = r5.length;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r13 = r13 + r5[r12].length;
        r12 = r12 + 1;
        goto L3
    L5:
        ArrayList r14 = new ArrayList(r13);
        int r15 = r5.length;
    L6:
        if (r11 >= r15) goto L8;
        CollectionsKt__MutableCollectionsKt.addAll(r14, r5[r11]);
        r11 = r11 + 1;
        goto L6
    L8:
        return r14;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final Object ifEmpty(Object[] r5, Function0 r10) {
        Intrinsics.checkNotNullParameter(r10, "defaultValue");
        if (r5.length == 0) goto L5;
        return r5;
    L5:
        return r10.invoke();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean isNullOrEmpty(Object[] r5) {
        if (r5 != null) goto L4;
    L7:
        return true;
    L4:
        if (r5.length == 0) goto L7;
        return false;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Pair<? extends T, ? extends R>[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArrayList r5 = new ArrayList(r10.length);
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        Pair<? extends T, ? extends R> r14 = r10[r13];
        r5.add(r14.getFirst());
        r11.add(r14.getSecond());
        r13 = r13 + 1;
        goto L3
    L6:
        return TuplesKt.to(r5, r11);
    }
}
