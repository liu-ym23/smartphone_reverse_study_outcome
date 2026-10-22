package kotlin.text;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0010\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0012\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007\u001a\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u0014\u001a\u00020\u0007*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0015\u001a\u0019\u0010\u0014\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0001H\u0007\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u0018\u001a\u00020\n*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u0018\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001a\u001a\u000e\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0007\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\r*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u001d\u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001e\u001a\u000e\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u0001H\u0007\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006 "}, d2 = {"toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUByteOrNull", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toUIntOrNull", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toULongOrNull", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUShortOrNull", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UStringsKt {
    /* JADX INFO: renamed from: toString-JSWoG40, reason: not valid java name */
    public static final String m2733toStringJSWoG40(long r0, int r2) {
        return UnsignedKt.ulongToString(r0, CharsKt.checkRadix(r2));
    }

    /* JADX INFO: renamed from: toString-LxnNnR4, reason: not valid java name */
    public static final String m2734toStringLxnNnR4(byte r0, int r1) {
        String r2 = Integer.toString(r0 & 255, CharsKt.checkRadix(r1));
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        return r2;
    }

    /* JADX INFO: renamed from: toString-V7xB4Y4, reason: not valid java name */
    public static final String m2735toStringV7xB4Y4(int r4, int r5) {
        long r0 = ((long) r4) & 4294967295L;
        return UnsignedKt.ulongToString(r0, CharsKt.checkRadix(r5));
    }

    /* JADX INFO: renamed from: toString-olVBNx4, reason: not valid java name */
    public static final String m2736toStringolVBNx4(short r1, int r2) {
        String r3 = Integer.toString(r1 & UShort.MAX_VALUE, CharsKt.checkRadix(r2));
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        return r3;
    }

    public static final byte toUByte(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UByte r0 = toUByteOrNull(r1);
        if (r0 != null) goto L5;
        StringsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r0.m1489unboximpl();
    }

    public static final byte toUByte(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UByte r3 = toUByteOrNull(r1, r2);
        if (r3 != null) goto L5;
        StringsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r3.m1489unboximpl();
    }

    public static final UByte toUByteOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return toUByteOrNull(r1, 10);
    }

    public static final UByte toUByteOrNull(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UInt r3 = toUIntOrNull(r1, r2);
        if (r3 == null) goto L9;
        int r4 = r3.m1568unboximpl();
        if (Integer.compareUnsigned(r4, UInt.m1516constructorimpl(255)) <= 0) goto L8;
        return null;
    L8:
        return UByte.m1433boximpl(UByte.m1439constructorimpl((byte) r4));
    L9:
        return null;
    }

    public static final int toUInt(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UInt r0 = toUIntOrNull(r1);
        if (r0 != null) goto L5;
        StringsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r0.m1568unboximpl();
    }

    public static final int toUInt(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UInt r3 = toUIntOrNull(r1, r2);
        if (r3 != null) goto L5;
        StringsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r3.m1568unboximpl();
    }

    public static final UInt toUIntOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return toUIntOrNull(r1, 10);
    }

    public static final UInt toUIntOrNull(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        CharsKt.checkRadix(r11);
        int r0 = r10.length();
        if (r0 != 0) goto L5;
        return null;
    L5:
        int r3 = 0;
        char r4 = r10.charAt(0);
        int r6 = 1;
        if (Intrinsics.compare(r4, 48) >= 0) goto L11;
        if (r0 != 1) goto L9;
    L10:
        return null;
    L9:
        if (r4 != '+') goto L10;
    L12:
        int r5 = UInt.m1516constructorimpl(r11);
        int r7 = 119304647;
    L13:
        if (r6 >= r0) goto L28;
        int r8 = CharsKt.digitOf(r10.charAt(r6), r11);
        if (r8 < 0) goto L16;
        if (Integer.compareUnsigned(r3, r7) <= 0) goto L23;
        if (r7 != 119304647) goto L22;
        r7 = Integer.divideUnsigned(-1, r5);
        if (Integer.compareUnsigned(r3, r7) <= 0) goto L23;
    L22:
        return null;
    L23:
        int r9 = UInt.m1516constructorimpl(r3 * r5);
        int r12 = UInt.m1516constructorimpl(UInt.m1516constructorimpl(r8) + r9);
        if (Integer.compareUnsigned(r12, r9) < 0) goto L25;
        r6 = r6 + 1;
        r3 = r12;
        goto L13
    L25:
        return null;
    L16:
        return null;
    L28:
        return UInt.m1510boximpl(r3);
    L11:
        r6 = 0;
        goto L12
    }

    public static final long toULong(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ULong r0 = toULongOrNull(r2);
        if (r0 != null) goto L5;
        StringsKt.numberFormatError(r2);
        throw new KotlinNothingValueException();
    L5:
        return r0.m1647unboximpl();
    }

    public static final long toULong(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ULong r3 = toULongOrNull(r1, r2);
        if (r3 != null) goto L5;
        StringsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r3.m1647unboximpl();
    }

    public static final ULong toULongOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return toULongOrNull(r1, 10);
    }

    public static final ULong toULongOrNull(String r19, int r20) {
        Intrinsics.checkNotNullParameter(r19, "<this>");
        CharsKt.checkRadix(r20);
        int r2 = r19.length();
        if (r2 != 0) goto L5;
        return null;
    L5:
        long r4 = -1;
        int r6 = 0;
        char r7 = r19.charAt(0);
        if (Intrinsics.compare(r7, 48) >= 0) goto L13;
        if (r2 != 1) goto L9;
    L12:
        return null;
    L9:
        if (r7 != '+') goto L12;
        r6 = 1;
    L13:
        long r9 = ULong.m1595constructorimpl(r20);
        long r11 = 0;
        long r13 = 512409557603043100L;
    L14:
        if (r6 >= r2) goto L30;
        int r15 = CharsKt.digitOf(r19.charAt(r6), r20);
        if (r15 < 0) goto L17;
        if (Long.compareUnsigned(r11, r13) > 0) goto L21;
    L25:
        long r12 = ULong.m1595constructorimpl(r11 * r9);
        long r5 = ULong.m1595constructorimpl(ULong.m1595constructorimpl(((long) UInt.m1516constructorimpl(r15)) & 4294967295L) + r12);
        if (Long.compareUnsigned(r5, r12) < 0) goto L27;
        r6 = r6 + 1;
        r11 = r5;
        r4 = -1;
        goto L14
    L27:
        return null;
    L21:
        if (r13 != 512409557603043100L) goto L24;
        r13 = Long.divideUnsigned(r4, r9);
        if (Long.compareUnsigned(r11, r13) <= 0) goto L25;
    L24:
        return null;
    L17:
        return null;
    L30:
        return ULong.m1589boximpl(r11);
    }

    public static final short toUShort(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UShort r0 = toUShortOrNull(r1);
        if (r0 != null) goto L5;
        StringsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r0.m1752unboximpl();
    }

    public static final short toUShort(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UShort r3 = toUShortOrNull(r1, r2);
        if (r3 != null) goto L5;
        StringsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r3.m1752unboximpl();
    }

    public static final UShort toUShortOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return toUShortOrNull(r1, 10);
    }

    public static final UShort toUShortOrNull(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UInt r3 = toUIntOrNull(r1, r2);
        if (r3 == null) goto L9;
        int r4 = r3.m1568unboximpl();
        if (Integer.compareUnsigned(r4, UInt.m1516constructorimpl(65535)) <= 0) goto L8;
        return null;
    L8:
        return UShort.m1696boximpl(UShort.m1702constructorimpl((short) r4));
    L9:
        return null;
    }
}
