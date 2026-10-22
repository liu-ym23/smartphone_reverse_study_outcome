package kotlin.text;

import androidx.room.jarjarred.org.antlr.runtime.a;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0010\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0012\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007\u001a\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u0014\u001a\u00020\u0007*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0015\u001a\u0019\u0010\u0014\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0001H\u0007\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u0018\u001a\u00020\n*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u0018\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001a\u001a\u000e\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0007\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\r*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u001d\u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001e\u001a\u000e\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u0001H\u0007\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006 "}, d2 = {"toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUByteOrNull", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toUIntOrNull", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toULongOrNull", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUShortOrNull", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "UStringsKt")
public final class UStringsKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: toString-JSWoG40, reason: not valid java name */
    public static final String m1449toStringJSWoG40(long r5, int r10) {
        return UnsignedKt.ulongToString(r5, CharsKt__CharJVMKt.checkRadix(r10));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: toString-LxnNnR4, reason: not valid java name */
    public static final String m1450toStringLxnNnR4(byte r5, int r10) {
        return Integer.toString(r5 & UByte.MAX_VALUE, CharsKt__CharJVMKt.checkRadix(r10));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: toString-V7xB4Y4, reason: not valid java name */
    public static final String m1451toStringV7xB4Y4(int r5, int r10) {
        long r11 = ((long) r5) & 4294967295L;
        return UnsignedKt.ulongToString(r11, CharsKt__CharJVMKt.checkRadix(r10));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: toString-olVBNx4, reason: not valid java name */
    public static final String m1452toStringolVBNx4(short r5, int r10) {
        return Integer.toString(r5 & UShort.MAX_VALUE, CharsKt__CharJVMKt.checkRadix(r10));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte toUByte(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UByte r10 = toUByteOrNull(r5);
        if (r10 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r5);
        throw new KotlinNothingValueException();
    L5:
        return r10.m192unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UByte toUByteOrNull(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return toUByteOrNull(r5, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int toUInt(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UInt r10 = toUIntOrNull(r5);
        if (r10 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r5);
        throw new KotlinNothingValueException();
    L5:
        return r10.m271unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UInt toUIntOrNull(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return toUIntOrNull(r5, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long toULong(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ULong r10 = toULongOrNull(r5);
        if (r10 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r5);
        throw new KotlinNothingValueException();
    L5:
        return r10.m350unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULong toULongOrNull(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return toULongOrNull(r5, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short toUShort(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UShort r10 = toUShortOrNull(r5);
        if (r10 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r5);
        throw new KotlinNothingValueException();
    L5:
        return r10.m455unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UShort toUShortOrNull(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return toUShortOrNull(r5, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte toUByte(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UByte r11 = toUByteOrNull(r5, r10);
        if (r11 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r5);
        throw new KotlinNothingValueException();
    L5:
        return r11.m192unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UByte toUByteOrNull(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UInt r11 = toUIntOrNull(r5, r10);
        if (r11 == null) goto L9;
        int r12 = r11.m271unboximpl();
        if (Integer.compareUnsigned(r12, UInt.m219constructorimpl(255)) <= 0) goto L8;
        return null;
    L8:
        return UByte.m136boximpl(UByte.m142constructorimpl((byte) r12));
    L9:
        return null;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int toUInt(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UInt r11 = toUIntOrNull(r5, r10);
        if (r11 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r5);
        throw new KotlinNothingValueException();
    L5:
        return r11.m271unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UInt toUIntOrNull(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        CharsKt__CharJVMKt.checkRadix(r11);
        int r5 = r10.length();
        if (r5 != 0) goto L5;
        return null;
    L5:
        int r12 = 0;
        char r13 = r10.charAt(0);
        if (Intrinsics.compare(r13, 48) >= 0) goto L12;
        int r14 = 1;
        if (r5 != 1) goto L10;
    L11:
        return null;
    L10:
        if (r13 != '+') goto L11;
    L13:
        int r15 = UInt.m219constructorimpl(r11);
        int r16 = 119304647;
    L14:
        if (r14 >= r5) goto L29;
        int r17 = CharsKt__CharJVMKt.digitOf(r10.charAt(r14), r11);
        if (r17 < 0) goto L17;
        if (Integer.compareUnsigned(r12, r16) <= 0) goto L24;
        if (r16 != 119304647) goto L23;
        r16 = Integer.divideUnsigned(-1, r15);
        if (Integer.compareUnsigned(r12, r16) <= 0) goto L24;
    L23:
        return null;
    L24:
        int r18 = UInt.m219constructorimpl(r12 * r15);
        int r19 = a.b(r17, r18);
        if (Integer.compareUnsigned(r19, r18) < 0) goto L26;
        r14 = r14 + 1;
        r12 = r19;
        goto L14
    L26:
        return null;
    L17:
        return null;
    L29:
        return UInt.m213boximpl(r12);
    L12:
        r14 = 0;
        goto L13
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long toULong(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ULong r11 = toULongOrNull(r5, r10);
        if (r11 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r5);
        throw new KotlinNothingValueException();
    L5:
        return r11.m350unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULong toULongOrNull(String r17, int r18) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        CharsKt__CharJVMKt.checkRadix(r18);
        int r5 = r17.length();
        if (r5 != 0) goto L5;
        return null;
    L5:
        int r10 = 0;
        char r11 = r17.charAt(0);
        if (Intrinsics.compare(r11, 48) >= 0) goto L12;
        r10 = 1;
        if (r5 != 1) goto L10;
    L11:
        return null;
    L10:
        if (r11 != '+') goto L11;
    L12:
        long r12 = ULong.m298constructorimpl(r18);
        long r13 = 0;
        long r14 = 512409557603043100L;
    L13:
        if (r10 >= r5) goto L29;
        int r15 = CharsKt__CharJVMKt.digitOf(r17.charAt(r10), r18);
        if (r15 < 0) goto L16;
        if (Long.compareUnsigned(r13, r14) > 0) goto L20;
    L24:
        long r16 = ULong.m298constructorimpl(r13 * r12);
        long r19 = ULong.m298constructorimpl(ULong.m298constructorimpl(((long) UInt.m219constructorimpl(r15)) & 4294967295L) + r16);
        if (Long.compareUnsigned(r19, r16) < 0) goto L26;
        r10 = r10 + 1;
        r13 = r19;
        goto L13
    L26:
        return null;
    L20:
        if (r14 != 512409557603043100L) goto L23;
        r14 = Long.divideUnsigned(-1, r12);
        if (Long.compareUnsigned(r13, r14) <= 0) goto L24;
    L23:
        return null;
    L16:
        return null;
    L29:
        return ULong.m292boximpl(r13);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short toUShort(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UShort r11 = toUShortOrNull(r5, r10);
        if (r11 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r5);
        throw new KotlinNothingValueException();
    L5:
        return r11.m455unboximpl();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UShort toUShortOrNull(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UInt r11 = toUIntOrNull(r5, r10);
        if (r11 == null) goto L9;
        int r12 = r11.m271unboximpl();
        if (Integer.compareUnsigned(r12, UInt.m219constructorimpl(65535)) <= 0) goto L8;
        return null;
    L8:
        return UShort.m399boximpl(UShort.m405constructorimpl((short) r12));
    L9:
        return null;
    }
}
