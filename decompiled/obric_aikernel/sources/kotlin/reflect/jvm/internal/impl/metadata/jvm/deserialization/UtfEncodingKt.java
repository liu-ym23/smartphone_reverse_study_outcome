package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class UtfEncodingKt {
    public static final byte[] stringsToBytes(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "strings");
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r13 = r13 + r10[r12].length();
        r12 = r12 + 1;
        goto L3
    L5:
        byte[] r14 = new byte[r13];
        int r15 = r10.length;
        int r16 = 0;
        int r17 = 0;
    L6:
        if (r16 >= r15) goto L11;
        String r18 = r10[r16];
        int r19 = r18.length();
        int r20 = 0;
    L8:
        if (r20 >= r19) goto L10;
        r14[r17] = (byte) r18.charAt(r20);
        r20 = r20 + 1;
        r17 = r17 + 1;
        goto L8
    L10:
        r16 = r16 + 1;
        goto L6
    L11:
        return r14;
    }
}
