package kotlin.text;

import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u000b\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a2\u0010\u0012\u001a\u00020\u0002*\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\n2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\r2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\u00102\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"hexToUByte", "Lkotlin/UByte;", "", "format", "Lkotlin/text/HexFormat;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)B", "hexToUByteArray", "Lkotlin/UByteArray;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)[B", "hexToUInt", "Lkotlin/UInt;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)I", "hexToULong", "Lkotlin/ULong;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)J", "hexToUShort", "Lkotlin/UShort;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)S", "toHexString", "toHexString-ZQbaR00", "(BLkotlin/text/HexFormat;)Ljava/lang/String;", "startIndex", "", "endIndex", "toHexString-lZCiFrA", "([BIILkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-zHuV2wU", "([BLkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-8M7LxHw", "(ILkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-8UJCm-I", "(JLkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-r3ox_E0", "(SLkotlin/text/HexFormat;)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UHexExtensionsKt {
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final byte hexToUByte(String r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return UByte.m142constructorimpl(HexExtensionsKt.hexToByte(r5, r10));
    }

    public static /* synthetic */ byte hexToUByte$default(String r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return UByte.m142constructorimpl(HexExtensionsKt.hexToByte(r5, r10));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] hexToUByteArray(String r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return UByteArray.m195constructorimpl(HexExtensionsKt.hexToByteArray(r5, r10));
    }

    public static /* synthetic */ byte[] hexToUByteArray$default(String r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return UByteArray.m195constructorimpl(HexExtensionsKt.hexToByteArray(r5, r10));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final int hexToUInt(String r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return UInt.m219constructorimpl(HexExtensionsKt.hexToInt(r5, r10));
    }

    public static /* synthetic */ int hexToUInt$default(String r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return UInt.m219constructorimpl(HexExtensionsKt.hexToInt(r5, r10));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final long hexToULong(String r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return ULong.m298constructorimpl(HexExtensionsKt.hexToLong(r5, r10));
    }

    public static /* synthetic */ long hexToULong$default(String r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return ULong.m298constructorimpl(HexExtensionsKt.hexToLong(r5, r10));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final short hexToUShort(String r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return UShort.m405constructorimpl(HexExtensionsKt.hexToShort(r5, r10));
    }

    public static /* synthetic */ short hexToUShort$default(String r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return UShort.m405constructorimpl(HexExtensionsKt.hexToShort(r5, r10));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    /* JADX INFO: renamed from: toHexString-8M7LxHw, reason: not valid java name */
    private static final String m1437toHexString8M7LxHw(int r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r10, "format");
        return HexExtensionsKt.toHexString(r5, r10);
    }

    /* JADX INFO: renamed from: toHexString-8M7LxHw$default, reason: not valid java name */
    public static /* synthetic */ String m1438toHexString8M7LxHw$default(int r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r10, "format");
        return HexExtensionsKt.toHexString(r5, r10);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    /* JADX INFO: renamed from: toHexString-8UJCm-I, reason: not valid java name */
    private static final String m1439toHexString8UJCmI(long r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r10, "format");
        return HexExtensionsKt.toHexString(r5, r10);
    }

    /* JADX INFO: renamed from: toHexString-8UJCm-I$default, reason: not valid java name */
    public static /* synthetic */ String m1440toHexString8UJCmI$default(long r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r10, "format");
        return HexExtensionsKt.toHexString(r5, r10);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    /* JADX INFO: renamed from: toHexString-ZQbaR00, reason: not valid java name */
    private static final String m1441toHexStringZQbaR00(byte r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r10, "format");
        return HexExtensionsKt.toHexString(r5, r10);
    }

    /* JADX INFO: renamed from: toHexString-ZQbaR00$default, reason: not valid java name */
    public static /* synthetic */ String m1442toHexStringZQbaR00$default(byte r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r10, "format");
        return HexExtensionsKt.toHexString(r5, r10);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: toHexString-lZCiFrA, reason: not valid java name */
    private static final String m1443toHexStringlZCiFrA(byte[] r5, int r10, int r11, HexFormat r12) {
        Intrinsics.checkNotNullParameter(r5, "$this$toHexString");
        Intrinsics.checkNotNullParameter(r12, "format");
        return HexExtensionsKt.toHexString(r5, r10, r11, r12);
    }

    /* JADX INFO: renamed from: toHexString-lZCiFrA$default, reason: not valid java name */
    public static /* synthetic */ String m1444toHexStringlZCiFrA$default(byte[] r5, int r10, int r11, HexFormat r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = UByteArray.m201getSizeimpl(r5);
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = HexFormat.Companion.getDefault();
    L11:
        Intrinsics.checkNotNullParameter(r5, "$this$toHexString");
        Intrinsics.checkNotNullParameter(r12, "format");
        return HexExtensionsKt.toHexString(r5, r10, r11, r12);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    /* JADX INFO: renamed from: toHexString-r3ox_E0, reason: not valid java name */
    private static final String m1445toHexStringr3ox_E0(short r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r10, "format");
        return HexExtensionsKt.toHexString(r5, r10);
    }

    /* JADX INFO: renamed from: toHexString-r3ox_E0$default, reason: not valid java name */
    public static /* synthetic */ String m1446toHexStringr3ox_E0$default(short r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r10, "format");
        return HexExtensionsKt.toHexString(r5, r10);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: toHexString-zHuV2wU, reason: not valid java name */
    private static final String m1447toHexStringzHuV2wU(byte[] r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$toHexString");
        Intrinsics.checkNotNullParameter(r10, "format");
        return HexExtensionsKt.toHexString(r5, r10);
    }

    /* JADX INFO: renamed from: toHexString-zHuV2wU$default, reason: not valid java name */
    public static /* synthetic */ String m1448toHexStringzHuV2wU$default(byte[] r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r5, "$this$toHexString");
        Intrinsics.checkNotNullParameter(r10, "format");
        return HexExtensionsKt.toHexString(r5, r10);
    }
}
