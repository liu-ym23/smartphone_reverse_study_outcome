package kotlin.io.encoding;

import kotlin.SinceKotlin;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nBase64.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Base64.kt\nkotlin/io/encoding/Base64Kt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,649:1\n13384#2,3:650\n13384#2,3:653\n*S KotlinDebug\n*F\n+ 1 Base64.kt\nkotlin/io/encoding/Base64Kt\n*L\n584#1:650,3\n603#1:653,3\n*E\n"})
public final class Base64Kt {
    private static final int[] base64DecodeMap = null;
    private static final byte[] base64EncodeMap = null;
    private static final int[] base64UrlDecodeMap = null;
    private static final byte[] base64UrlEncodeMap = null;

    static {
        byte[] r10 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        base64EncodeMap = r10;
        int[] r11 = new int[256];
        int r12 = 0;
        ArraysKt.fill$default(r11, -1, 0, 0, 6, null);
        r11[61] = -2;
        int r13 = r10.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r11[r10[r14]] = r15;
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        base64DecodeMap = r11;
        byte[] r16 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        base64UrlEncodeMap = r16;
        int[] r17 = new int[256];
        ArraysKt.fill$default(r17, -1, 0, 0, 6, null);
        r17[61] = -2;
        int r18 = r16.length;
        int r19 = 0;
    L6:
        if (r12 >= r18) goto L8;
        r17[r16[r12]] = r19;
        r12 = r12 + 1;
        r19 = r19 + 1;
        goto L6
    L8:
        base64UrlDecodeMap = r17;
    }

    public static final /* synthetic */ int[] access$getBase64DecodeMap$p() {
        return base64DecodeMap;
    }

    public static final /* synthetic */ byte[] access$getBase64EncodeMap$p() {
        return base64EncodeMap;
    }

    public static final /* synthetic */ int[] access$getBase64UrlDecodeMap$p() {
        return base64UrlDecodeMap;
    }

    public static final /* synthetic */ byte[] access$getBase64UrlEncodeMap$p() {
        return base64UrlEncodeMap;
    }

    @ExperimentalEncodingApi
    private static /* synthetic */ void getBase64DecodeMap$annotations() {
    }

    private static /* synthetic */ void getBase64EncodeMap$annotations() {
    }

    @ExperimentalEncodingApi
    private static /* synthetic */ void getBase64UrlDecodeMap$annotations() {
    }

    private static /* synthetic */ void getBase64UrlEncodeMap$annotations() {
    }

    @ExperimentalEncodingApi
    @SinceKotlin(version = "1.8")
    public static final boolean isInMimeAlphabet(int r10) {
        if (r10 >= 0) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L13;
        if (base64DecodeMap[r10] == (-1)) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r10 >= base64DecodeMap.length) goto L7;
        r11 = true;
        goto L8
    }
}
