package kotlin.text;

import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class UHexExtensionsKt {
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final byte hexToUByte(String r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return UByte.m50constructorimpl(HexExtensionsKt.hexToByte(r10, r11));
    }

    static /* synthetic */ byte hexToUByte$default(String r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return UByte.m50constructorimpl(HexExtensionsKt.hexToByte(r10, r11));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] hexToUByteArray(String r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return UByteArray.m103constructorimpl(HexExtensionsKt.hexToByteArray(r10, r11));
    }

    static /* synthetic */ byte[] hexToUByteArray$default(String r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return UByteArray.m103constructorimpl(HexExtensionsKt.hexToByteArray(r10, r11));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final int hexToUInt(String r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return UInt.m127constructorimpl(HexExtensionsKt.hexToInt(r10, r11));
    }

    static /* synthetic */ int hexToUInt$default(String r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return UInt.m127constructorimpl(HexExtensionsKt.hexToInt(r10, r11));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final long hexToULong(String r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return ULong.m206constructorimpl(HexExtensionsKt.hexToLong(r10, r11));
    }

    static /* synthetic */ long hexToULong$default(String r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return ULong.m206constructorimpl(HexExtensionsKt.hexToLong(r10, r11));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final short hexToUShort(String r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return UShort.m313constructorimpl(HexExtensionsKt.hexToShort(r10, r11));
    }

    static /* synthetic */ short hexToUShort$default(String r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return UShort.m313constructorimpl(HexExtensionsKt.hexToShort(r10, r11));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    /* JADX INFO: renamed from: toHexString-8M7LxHw, reason: not valid java name */
    private static final String m1358toHexString8M7LxHw(int r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r11, "format");
        return HexExtensionsKt.toHexString(r10, r11);
    }

    /* JADX INFO: renamed from: toHexString-8M7LxHw$default, reason: not valid java name */
    static /* synthetic */ String m1359toHexString8M7LxHw$default(int r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r11, "format");
        return HexExtensionsKt.toHexString(r10, r11);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    /* JADX INFO: renamed from: toHexString-8UJCm-I, reason: not valid java name */
    private static final String m1360toHexString8UJCmI(long r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r11, "format");
        return HexExtensionsKt.toHexString(r10, r11);
    }

    /* JADX INFO: renamed from: toHexString-8UJCm-I$default, reason: not valid java name */
    static /* synthetic */ String m1361toHexString8UJCmI$default(long r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r11, "format");
        return HexExtensionsKt.toHexString(r10, r11);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    /* JADX INFO: renamed from: toHexString-ZQbaR00, reason: not valid java name */
    private static final String m1362toHexStringZQbaR00(byte r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r11, "format");
        return HexExtensionsKt.toHexString(r10, r11);
    }

    /* JADX INFO: renamed from: toHexString-ZQbaR00$default, reason: not valid java name */
    static /* synthetic */ String m1363toHexStringZQbaR00$default(byte r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r11, "format");
        return HexExtensionsKt.toHexString(r10, r11);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: toHexString-lZCiFrA, reason: not valid java name */
    private static final String m1364toHexStringlZCiFrA(byte[] r10, int r11, int r12, HexFormat r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$toHexString");
        Intrinsics.checkNotNullParameter(r13, "format");
        return HexExtensionsKt.toHexString(r10, r11, r12, r13);
    }

    /* JADX INFO: renamed from: toHexString-lZCiFrA$default, reason: not valid java name */
    static /* synthetic */ String m1365toHexStringlZCiFrA$default(byte[] r10, int r11, int r12, HexFormat r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = UByteArray.m109getSizeimpl(r10);
    L9:
        if ((r14 & 4) == 0) goto L11;
        r13 = HexFormat.Companion.getDefault();
    L11:
        Intrinsics.checkNotNullParameter(r10, "$this$toHexString");
        Intrinsics.checkNotNullParameter(r13, "format");
        return HexExtensionsKt.toHexString(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    /* JADX INFO: renamed from: toHexString-r3ox_E0, reason: not valid java name */
    private static final String m1366toHexStringr3ox_E0(short r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r11, "format");
        return HexExtensionsKt.toHexString(r10, r11);
    }

    /* JADX INFO: renamed from: toHexString-r3ox_E0$default, reason: not valid java name */
    static /* synthetic */ String m1367toHexStringr3ox_E0$default(short r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r11, "format");
        return HexExtensionsKt.toHexString(r10, r11);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: toHexString-zHuV2wU, reason: not valid java name */
    private static final String m1368toHexStringzHuV2wU(byte[] r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$toHexString");
        Intrinsics.checkNotNullParameter(r11, "format");
        return HexExtensionsKt.toHexString(r10, r11);
    }

    /* JADX INFO: renamed from: toHexString-zHuV2wU$default, reason: not valid java name */
    static /* synthetic */ String m1369toHexStringzHuV2wU$default(byte[] r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r10, "$this$toHexString");
        Intrinsics.checkNotNullParameter(r11, "format");
        return HexExtensionsKt.toHexString(r10, r11);
    }
}
