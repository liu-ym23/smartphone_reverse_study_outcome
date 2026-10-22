package kotlin.text;

import kotlin.KotlinNothingValueException;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0010\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0012\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007\u001a\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u0014\u001a\u00020\u0007*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0015\u001a\u0019\u0010\u0014\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0001H\u0007\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u0018\u001a\u00020\n*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u0018\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001a\u001a\u000e\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0007\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\r*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u001d\u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001e\u001a\u000e\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u0001H\u0007\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006 "}, d2 = {"toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUByteOrNull", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toUIntOrNull", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toULongOrNull", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUShortOrNull", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UStringsKt {
    public static final byte toUByte(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UByte r0 = toUByteOrNull(r1);
        if (r0 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r0.m104unboximpl();
    }

    public static final UByte toUByteOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return toUByteOrNull(r1, 10);
    }

    public static final int toUInt(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UInt r0 = toUIntOrNull(r1);
        if (r0 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r0.m181unboximpl();
    }

    public static final UInt toUIntOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return toUIntOrNull(r1, 10);
    }

    public static final long toULong(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ULong r0 = toULongOrNull(r2);
        if (r0 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r2);
        throw new KotlinNothingValueException();
    L5:
        return r0.m258unboximpl();
    }

    public static final ULong toULongOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return toULongOrNull(r1, 10);
    }

    public static final short toUShort(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UShort r0 = toUShortOrNull(r1);
        if (r0 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r0.m333unboximpl();
    }

    public static final UShort toUShortOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return toUShortOrNull(r1, 10);
    }

    /* JADX INFO: renamed from: toString-JSWoG40, reason: not valid java name */
    public static final String m388toStringJSWoG40(long r0, int r2) {
        return UnsignedKt.ulongToString(r0, CharsKt.checkRadix(r2));
    }

    /* JADX INFO: renamed from: toString-LxnNnR4, reason: not valid java name */
    public static final String m389toStringLxnNnR4(byte r0, int r1) {
        return Integer.toString(r0 & UByte.MAX_VALUE, CharsKt.checkRadix(r1));
    }

    /* JADX INFO: renamed from: toString-V7xB4Y4, reason: not valid java name */
    public static final String m390toStringV7xB4Y4(int r4, int r5) {
        long r0 = ((long) r4) & 4294967295L;
        return UnsignedKt.ulongToString(r0, CharsKt.checkRadix(r5));
    }

    /* JADX INFO: renamed from: toString-olVBNx4, reason: not valid java name */
    public static final String m391toStringolVBNx4(short r1, int r2) {
        return Integer.toString(r1 & UShort.MAX_VALUE, CharsKt.checkRadix(r2));
    }

    public static final byte toUByte(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UByte r3 = toUByteOrNull(r1, r2);
        if (r3 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r3.m104unboximpl();
    }

    public static final UByte toUByteOrNull(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        UInt r5 = toUIntOrNull(r3, r4);
        if (r5 == null) goto L9;
        int r6 = r5.m181unboximpl();
        int r0 = UInt.m129constructorimpl(KotlinVersion.MAX_COMPONENT_VALUE);
        if (Integer.compare(r6 ^ IntCompanionObject.MIN_VALUE, r0 ^ IntCompanionObject.MIN_VALUE) <= 0) goto L8;
        return null;
    L8:
        return UByte.m48boximpl(UByte.m54constructorimpl((byte) r6));
    L9:
        return null;
    }

    public static final int toUInt(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UInt r3 = toUIntOrNull(r1, r2);
        if (r3 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r3.m181unboximpl();
    }

    public static final UInt toUIntOrNull(String r16, int r17) {
        Intrinsics.checkNotNullParameter(r16, "<this>");
        CharsKt.checkRadix(r17);
        int r1 = r16.length();
        if (r1 != 0) goto L5;
        return null;
    L5:
        int r3 = 0;
        char r4 = r16.charAt(0);
        if (Intrinsics.compare(r4, 48) >= 0) goto L12;
        int r5 = 1;
        if (r1 != 1) goto L10;
    L11:
        return null;
    L10:
        if (r4 != '+') goto L11;
    L13:
        int r6 = UInt.m129constructorimpl(r17);
        int r7 = 119304647;
        int r8 = 119304647;
    L14:
        if (r5 >= r1) goto L29;
        int r9 = CharsKt__CharJVMKt.digitOf(r16.charAt(r5), r17);
        if (r9 < 0) goto L17;
        int r11 = r3 ^ IntCompanionObject.MIN_VALUE;
        if (Integer.compare(r11, r8 ^ IntCompanionObject.MIN_VALUE) <= 0) goto L24;
        if (r8 != r7) goto L23;
        r8 = (int) ((((long) (-1)) & 4294967295L) / (((long) r6) & 4294967295L));
        if (Integer.compare(r11, r8 ^ IntCompanionObject.MIN_VALUE) <= 0) goto L24;
    L23:
        return null;
    L24:
        int r10 = UInt.m129constructorimpl(r3 * r6);
        int r12 = UInt.m129constructorimpl(UInt.m129constructorimpl(r9) + r10);
        if (Integer.compare(r12 ^ IntCompanionObject.MIN_VALUE, r10 ^ IntCompanionObject.MIN_VALUE) < 0) goto L26;
        r5 = r5 + 1;
        r3 = r12;
        r7 = 119304647;
        goto L14
    L26:
        return null;
    L17:
        return null;
    L29:
        return UInt.m123boximpl(r3);
    L12:
        r5 = 0;
        goto L13
    }

    public static final long toULong(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ULong r3 = toULongOrNull(r1, r2);
        if (r3 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r3.m258unboximpl();
    }

    public static final ULong toULongOrNull(String r26, int r27) {
        Intrinsics.checkNotNullParameter(r26, "<this>");
        CharsKt.checkRadix(r27);
        int r2 = r26.length();
        if (r2 != 0) goto L5;
        return null;
    L5:
        char r5 = r26.charAt(0);
        if (Intrinsics.compare(r5, 48) >= 0) goto L13;
        if (r2 != 1) goto L9;
    L12:
        return null;
    L9:
        if (r5 != '+') goto L12;
        int r6 = 1;
    L14:
        long r8 = ULong.m206constructorimpl(r27);
        long r10 = 0;
        long r14 = 0;
        long r16 = 512409557603043100L;
    L15:
        if (r6 >= r2) goto L43;
        int r7 = CharsKt__CharJVMKt.digitOf(r26.charAt(r6), r27);
        if (r7 < 0) goto L18;
        int r20 = r6;
        long r4 = r14 ^ Long.MIN_VALUE;
        long r22 = r8;
        if (Long.compare(r4, r16 ^ Long.MIN_VALUE) > 0) goto L22;
    L38:
        long r9 = ULong.m206constructorimpl(r14 * r22);
        r14 = ULong.m206constructorimpl(ULong.m206constructorimpl(((long) UInt.m129constructorimpl(r7)) & 4294967295L) + r9);
        if (Long.compare(r14 ^ Long.MIN_VALUE, r9 ^ Long.MIN_VALUE) < 0) goto L40;
        r6 = r20 + 1;
        r8 = r22;
        r10 = 0;
        goto L15
    L40:
        return null;
    L22:
        if (r16 != 512409557603043100L) goto L37;
        if (r22 < r10) goto L26;
        int r11 = 1;
        long r12 = (LongCompanionObject.MAX_VALUE / r22) << 1;
        if ((((-1) - (r12 * r22)) ^ Long.MIN_VALUE) >= (r22 ^ Long.MIN_VALUE)) goto L34;
        r11 = 0;
    L34:
        long r13 = r12 + ((long) r11);
    L29:
        r16 = r13;
    L36:
        if (Long.compare(r4, r16 ^ Long.MIN_VALUE) <= 0) goto L38;
    L26:
        if (LongCompanionObject.MAX_VALUE >= (r22 ^ Long.MIN_VALUE)) goto L28;
        r16 = r10;
        goto L36
    L28:
        r13 = 1;
    L37:
        return null;
    L18:
        return null;
    L43:
        return ULong.m200boximpl(r14);
    L13:
        r6 = 0;
        goto L14
    }

    public static final short toUShort(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UShort r3 = toUShortOrNull(r1, r2);
        if (r3 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r1);
        throw new KotlinNothingValueException();
    L5:
        return r3.m333unboximpl();
    }

    public static final UShort toUShortOrNull(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        UInt r5 = toUIntOrNull(r3, r4);
        if (r5 == null) goto L9;
        int r6 = r5.m181unboximpl();
        int r0 = UInt.m129constructorimpl(65535);
        if (Integer.compare(r6 ^ IntCompanionObject.MIN_VALUE, r0 ^ IntCompanionObject.MIN_VALUE) <= 0) goto L8;
        return null;
    L8:
        return UShort.m277boximpl(UShort.m283constructorimpl((short) r6));
    L9:
        return null;
    }
}
