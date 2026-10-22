package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class w extends ProtoAdapter<String> {
    @Override // com.lark.wire.ProtoAdapter
    public final String b(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        return r2.e();
    }

    @Override // com.lark.wire.ProtoAdapter
    public final String c(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        return r2.i();
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(String r13) {
        String r14 = r13;
        Intrinsics.checkNotNullParameter(r14, "value");
        int r0 = r14.length();
        Intrinsics.checkNotNullParameter(r14, "<this>");
        boolean r2 = true;
        if (r0 < 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L45;
        if (r0 <= r14.length()) goto L11;
        r2 = false;
    L11:
        if (r2 == false) goto L43;
        long r4 = 0;
        int r5 = 0;
    L13:
        if (r5 >= r0) goto L41;
        char r6 = r14.charAt(r5);
        if (r6 < 128) goto L16;
        if (r6 < 2048) goto L19;
        if (r6 < 55296) goto L37;
        if (r6 > 57343) goto L37;
        int r9 = r5 + 1;
        if (r9 >= r0) goto L28;
        char r10 = r14.charAt(r9);
    L30:
        if (r6 > 56319) goto L36;
        if (r10 < 56320) goto L36;
        if (r10 > 57343) goto L36;
        r4 = r4 + ((long) 4);
        r5 = r5 + 2;
    L36:
        r4 = r4 + 1;
        r5 = r9;
        goto L13
    L28:
        r10 = 0;
    L37:
        int r7 = 3;
    L38:
        r4 = r4 + ((long) r7);
    L39:
        r5 = r5 + 1;
        goto L13
    L19:
        r7 = 2;
        goto L38
    L16:
        r4 = r4 + 1;
        goto L39
    L41:
        return (int) r4;
    L43:
        throw new IllegalArgumentException(("endIndex > string.length: " + r0 + " > " + r14.length()).toString());
    L45:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r0 + " < 0").toString());
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r2, String r3) {
        String r4 = r3;
        Intrinsics.checkNotNullParameter(r2, "writer");
        Intrinsics.checkNotNullParameter(r4, "value");
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "value");
        r2.a.writeUtf8(r4);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r10, String r11) {
        String r12 = r11;
        Intrinsics.checkNotNullParameter(r10, "writer");
        Intrinsics.checkNotNullParameter(r12, "value");
        r10.getClass();
        Intrinsics.checkNotNullParameter(r12, "value");
        int r0 = r12.length() - 1;
    L3:
        if (r0 < 0) goto L37;
        int r2 = r0 - 1;
        char r1 = r12.charAt(r0);
        if (r1 >= 128) goto L13;
        r10.c(1);
        int r5 = r10.e;
        byte[] r6 = r10.d;
        int r7 = r5 - 1;
        r6[r7] = (byte) r1;
        int r3 = Math.max(-1, r2 - r7);
    L7:
        if (r2 <= r3) goto L11;
        char r4 = r12.charAt(r2);
        if (r4 >= 128) goto L11;
        r2 = r2 - 1;
        r7 = r7 - 1;
        r6[r7] = (byte) r4;
    L11:
        r10.e = r7;
    L36:
        r0 = r2;
        goto L3
    L13:
        if (r1 >= 2048) goto L16;
        r10.c(2);
        byte[] r8 = r10.d;
        int r9 = r10.e - 1;
        r8[r9] = (byte) (128 | (r1 & '?'));
        int r13 = r9 - 1;
        r10.e = r13;
        r8[r13] = (byte) ((r1 >> 6) | 192);
        goto L36
    L16:
        if (r1 >= 55296) goto L18;
    L35:
        r10.c(3);
        byte[] r14 = r10.d;
        int r15 = r10.e - 1;
        r14[r15] = (byte) ((r1 & '?') | 128);
        int r16 = r15 - 1;
        r14[r16] = (byte) (128 | (63 & (r1 >> 6)));
        int r17 = r16 - 1;
        r10.e = r17;
        r14[r17] = (byte) ((r1 >> '\f') | 224);
        goto L36
    L18:
        if (r1 > 57343) goto L35;
        if (r2 < 0) goto L22;
        char r19 = r12.charAt(r2);
    L24:
        if (r19 <= 56319) goto L26;
    L34:
        r10.c(1);
        byte[] r20 = r10.d;
        int r21 = r10.e - 1;
        r10.e = r21;
        r20[r21] = 63;
        goto L36
    L26:
        if (56320 <= r1) goto L28;
    L30:
        boolean r22 = false;
    L31:
        if (r22 == false) goto L34;
        r2 = r2 - 1;
        int r23 = ((r1 & 1023) | ((r19 & 1023) << 10)) + 65536;
        r10.c(4);
        byte[] r24 = r10.d;
        int r25 = r10.e - 1;
        r24[r25] = (byte) ((r23 & 63) | 128);
        int r26 = r25 - 1;
        r24[r26] = (byte) (((r23 >> 6) & 63) | 128);
        int r27 = r26 - 1;
        r24[r27] = (byte) (128 | (63 & (r23 >> 12)));
        int r29 = r27 - 1;
        r10.e = r29;
        r24[r29] = (byte) ((r23 >> 18) | 240);
        goto L36
    L28:
        if (r1 >= 57344) goto L30;
        r22 = true;
        goto L31
    L22:
        r19 = 65535;
        goto L24
    }

    public w(FieldEncoding r8, KClass<String> r9, Syntax r10) {
        super(r8, r9, null, r10, "", 32);
    }
}
