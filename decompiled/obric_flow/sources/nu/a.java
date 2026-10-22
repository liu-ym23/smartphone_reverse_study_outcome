package nu;

import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f20312a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f20313b = null;

    static {
        ByteString.Companion.getClass();
        f20312a = m.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        f20313b = m.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final String a(byte[] r11, byte[] r12) {
        Intrinsics.checkNotNullParameter(r11, "$this$encodeBase64");
        Intrinsics.checkNotNullParameter(r12, "map");
        byte[] r5 = new byte[((r11.length + 2) / 3) * 4];
        int r10 = r11.length - (r11.length % 3);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r10) goto L5;
        byte r15 = r11[r13];
        int r16 = r13 + 2;
        byte r17 = r11[r13 + 1];
        r13 = r13 + 3;
        byte r18 = r11[r16];
        r5[r14] = r12[(r15 & UByte.MAX_VALUE) >> 2];
        r5[r14 + 1] = r12[((r15 & 3) << 4) | ((r17 & UByte.MAX_VALUE) >> 4)];
        int r19 = r14 + 3;
        r5[r14 + 2] = r12[((r17 & 15) << 2) | ((r18 & UByte.MAX_VALUE) >> 6)];
        r14 = r14 + 4;
        r5[r19] = r12[r18 & 63];
        goto L3
    L5:
        int r20 = r11.length - r10;
        if (r20 == 1) goto L10;
        if (r20 != 2) goto L11;
        int r21 = r13 + 1;
        byte r22 = r11[r13];
        byte r110 = r11[r21];
        r5[r14] = r12[(r22 & UByte.MAX_VALUE) >> 2];
        r5[r14 + 1] = r12[((r22 & 3) << 4) | ((r110 & UByte.MAX_VALUE) >> 4)];
        r5[r14 + 2] = r12[(r110 & 15) << 2];
        r5[r14 + 3] = (byte) 61;
    L11:
        Intrinsics.checkNotNullParameter(r5, "$this$toUtf8String");
        return new String(r5, Charsets.UTF_8);
    L10:
        byte r111 = r11[r13];
        r5[r14] = r12[(r111 & UByte.MAX_VALUE) >> 2];
        r5[r14 + 1] = r12[(r111 & 3) << 4];
        byte r112 = (byte) 61;
        r5[r14 + 2] = r112;
        r5[r14 + 3] = r112;
        goto L11
    }
}
