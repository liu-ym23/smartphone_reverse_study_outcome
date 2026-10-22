package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Arrays.kt\nkotlin/collections/ArraysKt__ArraysKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    public ArraysKt__ArraysKt() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepEquals")
    public static final <T> boolean contentDeepEquals(T[] r10, T[] r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if (r10 == 0) goto L116;
        if (r11 == 0) goto L116;
        if (r10.length != r11.length) goto L116;
        int r12 = r10.length;
        int r13 = 0;
    L12:
        if (r13 >= r12) goto L115;
        Object[] r14 = r10[r13];
        Object[] r15 = r11[r13];
        if (r14 == r15) goto L113;
        if (r14 == 0) goto L114;
        if (r15 == 0) goto L114;
        if ((r14 instanceof Object[]) == false) goto L27;
        if ((r15 instanceof Object[]) == false) goto L27;
        if (contentDeepEquals(r14, r15) == true) goto L113;
        return false;
    L27:
        if ((r14 instanceof byte[]) == false) goto L34;
        if ((r15 instanceof byte[]) == false) goto L34;
        if (Arrays.equals((byte[]) r14, (byte[]) r15) == true) goto L113;
        return false;
    L34:
        if ((r14 instanceof short[]) == false) goto L41;
        if ((r15 instanceof short[]) == false) goto L41;
        if (Arrays.equals((short[]) r14, (short[]) r15) == true) goto L113;
        return false;
    L41:
        if ((r14 instanceof int[]) == false) goto L48;
        if ((r15 instanceof int[]) == false) goto L48;
        if (Arrays.equals((int[]) r14, (int[]) r15) == true) goto L113;
        return false;
    L48:
        if ((r14 instanceof long[]) == false) goto L55;
        if ((r15 instanceof long[]) == false) goto L55;
        if (Arrays.equals((long[]) r14, (long[]) r15) == true) goto L113;
        return false;
    L55:
        if ((r14 instanceof float[]) == false) goto L62;
        if ((r15 instanceof float[]) == false) goto L62;
        if (Arrays.equals((float[]) r14, (float[]) r15) == true) goto L113;
        return false;
    L62:
        if ((r14 instanceof double[]) == false) goto L69;
        if ((r15 instanceof double[]) == false) goto L69;
        if (Arrays.equals((double[]) r14, (double[]) r15) == true) goto L113;
        return false;
    L69:
        if ((r14 instanceof char[]) == false) goto L76;
        if ((r15 instanceof char[]) == false) goto L76;
        if (Arrays.equals((char[]) r14, (char[]) r15) == true) goto L113;
        return false;
    L76:
        if ((r14 instanceof boolean[]) == false) goto L83;
        if ((r15 instanceof boolean[]) == false) goto L83;
        if (Arrays.equals((boolean[]) r14, (boolean[]) r15) == true) goto L113;
        return false;
    L83:
        if ((r14 instanceof UByteArray) == false) goto L90;
        if ((r15 instanceof UByteArray) == false) goto L90;
        if (UArraysKt.m501contentEqualskV0jMPg(((UByteArray) r14).m117unboximpl(), ((UByteArray) r15).m117unboximpl()) == true) goto L113;
        return false;
    L90:
        if ((r14 instanceof UShortArray) == false) goto L97;
        if ((r15 instanceof UShortArray) == false) goto L97;
        if (UArraysKt.m499contentEqualsFGO6Aew(((UShortArray) r14).m380unboximpl(), ((UShortArray) r15).m380unboximpl()) == true) goto L113;
        return false;
    L97:
        if ((r14 instanceof UIntArray) == false) goto L104;
        if ((r15 instanceof UIntArray) == false) goto L104;
        if (UArraysKt.m500contentEqualsKJPZfPQ(((UIntArray) r14).m196unboximpl(), ((UIntArray) r15).m196unboximpl()) == true) goto L113;
        return false;
    L104:
        if ((r14 instanceof ULongArray) == false) goto L111;
        if ((r15 instanceof ULongArray) == false) goto L111;
        if (UArraysKt.m502contentEqualslec5QzE(((ULongArray) r14).m275unboximpl(), ((ULongArray) r15).m275unboximpl()) == true) goto L113;
        return false;
    L111:
        if (Intrinsics.areEqual(r14, r15) == true) goto L113;
        return false;
    L114:
        return false;
    L113:
        r13 = r13 + 1;
        goto L12
    L115:
        return true;
    L116:
        return false;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepToString")
    public static final <T> String contentDeepToString(T[] r10) {
        if (r10 != null) goto L5;
        return "null";
    L5:
        StringBuilder r11 = new StringBuilder((RangesKt.coerceAtMost(r10.length, 429496729) * 5) + 2);
        contentDeepToStringInternal$ArraysKt__ArraysKt(r10, r11, new ArrayList());
        String r12 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "StringBuilder(capacity).…builderAction).toString()");
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(T[] r10, StringBuilder r11, List<Object[]> r12) {
        if (r12.contains(r10) == false) goto L6;
        r11.append("[...]");
        return;
    L6:
        r12.add(r10);
        r11.append('[');
        int r13 = 0;
        int r14 = r10.length;
    L7:
        if (r13 >= r14) goto L56;
        if (r13 == 0) goto L10;
        r11.append(", ");
    L10:
        Object[] r15 = r10[r13];
        if (r15 != 0) goto L15;
        String r16 = "null";
    L13:
        r11.append(r16);
    L55:
        r13 = r13 + 1;
        goto L7
    L15:
        if ((r15 instanceof Object[]) == false) goto L18;
        contentDeepToStringInternal$ArraysKt__ArraysKt(r15, r11, r12);
        goto L55
    L18:
        if ((r15 instanceof byte[]) == false) goto L22;
        r16 = Arrays.toString((byte[]) r15);
    L20:
        Intrinsics.checkNotNullExpressionValue(r16, "toString(this)");
        goto L13
    L22:
        if ((r15 instanceof short[]) == false) goto L25;
        r16 = Arrays.toString((short[]) r15);
        goto L20
    L25:
        if ((r15 instanceof int[]) == false) goto L28;
        r16 = Arrays.toString((int[]) r15);
        goto L20
    L28:
        if ((r15 instanceof long[]) == false) goto L31;
        r16 = Arrays.toString((long[]) r15);
        goto L20
    L31:
        if ((r15 instanceof float[]) == false) goto L34;
        r16 = Arrays.toString((float[]) r15);
        goto L20
    L34:
        if ((r15 instanceof double[]) == false) goto L37;
        r16 = Arrays.toString((double[]) r15);
        goto L20
    L37:
        if ((r15 instanceof char[]) == false) goto L40;
        r16 = Arrays.toString((char[]) r15);
        goto L20
    L40:
        if ((r15 instanceof boolean[]) == false) goto L43;
        r16 = Arrays.toString((boolean[]) r15);
        goto L20
    L43:
        if ((r15 instanceof UByteArray) == false) goto L46;
        r16 = UArraysKt.m503contentToString2csIQuQ(((UByteArray) r15).m117unboximpl());
        goto L13
    L46:
        if ((r15 instanceof UShortArray) == false) goto L49;
        r16 = UArraysKt.m505contentToStringd6D3K8(((UShortArray) r15).m380unboximpl());
        goto L13
    L49:
        if ((r15 instanceof UIntArray) == false) goto L52;
        r16 = UArraysKt.m504contentToStringXUkPCBk(((UIntArray) r15).m196unboximpl());
        goto L13
    L52:
        if ((r15 instanceof ULongArray) == false) goto L54;
        r16 = UArraysKt.m506contentToStringuLth9ew(((ULongArray) r15).m275unboximpl());
        goto L13
    L54:
        r16 = r15.toString();
        goto L13
    L56:
        r11.append(']');
        r12.remove(CollectionsKt.getLastIndex(r12));
    }

    public static final <T> List<T> flatten(T[][] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r14 = r14 + r10[r13].length;
        r13 = r13 + 1;
        goto L3
    L5:
        ArrayList r15 = new ArrayList(r14);
        int r16 = r10.length;
    L6:
        if (r12 >= r16) goto L8;
        CollectionsKt.addAll(r15, r10[r12]);
        r12 = r12 + 1;
        goto L6
    L8:
        return r15;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final Object ifEmpty(Object[] r10, Function0 r11) {
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L8;
        return r10;
    L8:
        return r11.invoke();
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean isNullOrEmpty(Object[] r10) {
        if (r10 == null) goto L10;
        if (r10.length != 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == true) goto L10;
        return false;
    L7:
        r11 = false;
    L10:
        return true;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Pair<? extends T, ? extends R>[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArrayList r11 = new ArrayList(r10.length);
        ArrayList r12 = new ArrayList(r10.length);
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L6;
        Pair<? extends T, ? extends R> r15 = r10[r14];
        r11.add(r15.getFirst());
        r12.add(r15.getSecond());
        r14 = r14 + 1;
        goto L3
    L6:
        return TuplesKt.to(r11, r12);
    }
}
