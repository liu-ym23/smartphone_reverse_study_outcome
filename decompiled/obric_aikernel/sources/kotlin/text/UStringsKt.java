package kotlin.text;

import androidx.core.internal.view.SupportMenu;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.KotlinNothingValueException;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "UStringsKt")
public final class UStringsKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: toString-JSWoG40, reason: not valid java name */
    public static final String m1370toStringJSWoG40(long r10, int r11) {
        return UnsignedKt.ulongToString(r10, CharsKt.checkRadix(r11));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: toString-LxnNnR4, reason: not valid java name */
    public static final String m1371toStringLxnNnR4(byte r10, int r11) {
        String r12 = Integer.toString(r10 & 255, CharsKt.checkRadix(r11));
        Intrinsics.checkNotNullExpressionValue(r12, "toString(this, checkRadix(radix))");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: toString-V7xB4Y4, reason: not valid java name */
    public static final String m1372toStringV7xB4Y4(int r10, int r11) {
        String r12 = Long.toString(((long) r10) & 4294967295L, CharsKt.checkRadix(r11));
        Intrinsics.checkNotNullExpressionValue(r12, "toString(this, checkRadix(radix))");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: toString-olVBNx4, reason: not valid java name */
    public static final String m1373toStringolVBNx4(short r10, int r11) {
        String r12 = Integer.toString(r10 & UShort.MAX_VALUE, CharsKt.checkRadix(r11));
        Intrinsics.checkNotNullExpressionValue(r12, "toString(this, checkRadix(radix))");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte toUByte(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UByte r11 = toUByteOrNull(r10);
        if (r11 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r10);
        throw new KotlinNothingValueException();
    L5:
        return r11.m100unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte toUByte(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UByte r12 = toUByteOrNull(r10, r11);
        if (r12 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r10);
        throw new KotlinNothingValueException();
    L5:
        return r12.m100unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UByte toUByteOrNull(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return toUByteOrNull(r10, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UByte toUByteOrNull(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UInt r12 = toUIntOrNull(r10, r11);
        if (r12 == null) goto L9;
        int r13 = r12.m179unboximpl();
        if (Integer.compareUnsigned(r13, UInt.m127constructorimpl(255)) <= 0) goto L8;
        return null;
    L8:
        return UByte.m44boximpl(UByte.m50constructorimpl((byte) r13));
    L9:
        return null;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int toUInt(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UInt r11 = toUIntOrNull(r10);
        if (r11 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r10);
        throw new KotlinNothingValueException();
    L5:
        return r11.m179unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int toUInt(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UInt r12 = toUIntOrNull(r10, r11);
        if (r12 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r10);
        throw new KotlinNothingValueException();
    L5:
        return r12.m179unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UInt toUIntOrNull(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return toUIntOrNull(r10, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UInt toUIntOrNull(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        CharsKt.checkRadix(r11);
        int r12 = r10.length();
        if (r12 != 0) goto L5;
        return null;
    L5:
        int r13 = 0;
        char r14 = r10.charAt(0);
        int r15 = 1;
        if (Intrinsics.compare(r14, 48) >= 0) goto L11;
        if (r12 != 1) goto L9;
    L10:
        return null;
    L9:
        if (r14 != '+') goto L10;
    L12:
        int r16 = UInt.m127constructorimpl(r11);
        int r17 = 119304647;
    L13:
        if (r15 >= r12) goto L28;
        int r18 = CharsKt__CharJVMKt.digitOf(r10.charAt(r15), r11);
        if (r18 < 0) goto L16;
        if (Integer.compareUnsigned(r13, r17) <= 0) goto L23;
        if (r17 != 119304647) goto L22;
        r17 = Integer.divideUnsigned(-1, r16);
        if (Integer.compareUnsigned(r13, r17) <= 0) goto L23;
    L22:
        return null;
    L23:
        int r19 = UInt.m127constructorimpl(r13 * r16);
        int r20 = UInt.m127constructorimpl(UInt.m127constructorimpl(r18) + r19);
        if (Integer.compareUnsigned(r20, r19) < 0) goto L25;
        r15 = r15 + 1;
        r13 = r20;
        goto L13
    L25:
        return null;
    L16:
        return null;
    L28:
        return UInt.m121boximpl(r13);
    L11:
        r15 = 0;
        goto L12
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long toULong(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ULong r11 = toULongOrNull(r10);
        if (r11 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r10);
        throw new KotlinNothingValueException();
    L5:
        return r11.m258unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long toULong(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ULong r12 = toULongOrNull(r10, r11);
        if (r12 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r10);
        throw new KotlinNothingValueException();
    L5:
        return r12.m258unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULong toULongOrNull(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return toULongOrNull(r10, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULong toULongOrNull(String r19, int r20) {
        Intrinsics.checkNotNullParameter(r19, "<this>");
        CharsKt.checkRadix(r20);
        int r10 = r19.length();
        if (r10 != 0) goto L5;
        return null;
    L5:
        long r11 = -1;
        int r12 = 0;
        char r13 = r19.charAt(0);
        if (Intrinsics.compare(r13, 48) >= 0) goto L13;
        if (r10 != 1) goto L9;
    L12:
        return null;
    L9:
        if (r13 != '+') goto L12;
        r12 = 1;
    L13:
        long r14 = ULong.m206constructorimpl(r20);
        long r15 = 0;
        long r16 = 512409557603043100L;
    L14:
        if (r12 >= r10) goto L30;
        int r17 = CharsKt__CharJVMKt.digitOf(r19.charAt(r12), r20);
        if (r17 < 0) goto L17;
        if (Long.compareUnsigned(r15, r16) > 0) goto L21;
    L25:
        long r18 = ULong.m206constructorimpl(r15 * r14);
        long r21 = ULong.m206constructorimpl(ULong.m206constructorimpl(((long) UInt.m127constructorimpl(r17)) & 4294967295L) + r18);
        if (Long.compareUnsigned(r21, r18) < 0) goto L27;
        r12 = r12 + 1;
        r15 = r21;
        r11 = -1;
        goto L14
    L27:
        return null;
    L21:
        if (r16 != 512409557603043100L) goto L24;
        r16 = Long.divideUnsigned(r11, r14);
        if (Long.compareUnsigned(r15, r16) <= 0) goto L25;
    L24:
        return null;
    L17:
        return null;
    L30:
        return ULong.m200boximpl(r15);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short toUShort(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UShort r11 = toUShortOrNull(r10);
        if (r11 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r10);
        throw new KotlinNothingValueException();
    L5:
        return r11.m363unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short toUShort(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UShort r12 = toUShortOrNull(r10, r11);
        if (r12 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r10);
        throw new KotlinNothingValueException();
    L5:
        return r12.m363unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UShort toUShortOrNull(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return toUShortOrNull(r10, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UShort toUShortOrNull(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UInt r12 = toUIntOrNull(r10, r11);
        if (r12 == null) goto L9;
        int r13 = r12.m179unboximpl();
        if (Integer.compareUnsigned(r13, UInt.m127constructorimpl(SupportMenu.USER_MASK)) <= 0) goto L8;
        return null;
    L8:
        return UShort.m307boximpl(UShort.m313constructorimpl((short) r13));
    L9:
        return null;
    }
}
