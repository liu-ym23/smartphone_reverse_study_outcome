package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "jvm"}, k = 2, mv = {1, 1, 11})
public final class _Utf8Kt {
    public static final byte[] commonAsUtf8ToByteArray(String r12) {
        Intrinsics.checkParameterIsNotNull(r12, "$receiver");
        byte[] r0 = new byte[r12.length() * 4];
        int r1 = r12.length();
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L41;
        char r4 = r12.charAt(r2);
        if (r4 >= 128) goto L7;
        r0[r2] = (byte) r4;
        r2 = r2 + 1;
        goto L4
    L7:
        int r3 = r12.length();
        int r5 = r2;
    L8:
        if (r2 >= r3) goto L38;
        char r6 = r12.charAt(r2);
        if (r6 < 128) goto L11;
        if (r6 >= 2048) goto L23;
        int r8 = r5 + 1;
        r0[r5] = (byte) ((r6 >> 6) | 192);
        byte r7 = (byte) ((r6 & '?') | 128);
        int r9 = r8 + 1;
        r0[r8] = r7;
    L20:
        r2 = r2 + 1;
    L21:
        r5 = r9;
        goto L8
    L23:
        if (55296 <= r6) goto L25;
    L37:
        int r10 = r5 + 1;
        r0[r5] = (byte) ((r6 >> '\f') | 224);
        int r11 = r10 + 1;
        r0[r10] = (byte) (((r6 >> 6) & 63) | 128);
        byte r13 = (byte) ((r6 & '?') | 128);
        r9 = r11 + 1;
        r0[r11] = r13;
        goto L20
    L25:
        if (57343 < r6) goto L37;
        if (r6 > 56319) goto L36;
        int r14 = r2 + 1;
        if (r3 <= r14) goto L36;
        char r15 = r12.charAt(r14);
        if (56320 > r15) goto L36;
        if (57343 < r15) goto L36;
        int r16 = ((r6 << '\n') + r12.charAt(r14)) - 56613888;
        int r17 = r5 + 1;
        r0[r5] = (byte) ((r16 >> 18) | 240);
        int r18 = r17 + 1;
        r0[r17] = (byte) (((r16 >> 12) & 63) | 128);
        int r19 = r18 + 1;
        r0[r18] = (byte) (((r16 >> 6) & 63) | 128);
        byte r20 = (byte) ((r16 & 63) | 128);
        r9 = r19 + 1;
        r0[r19] = r20;
        r2 = r2 + 2;
    L36:
        r9 = r5 + 1;
        r0[r5] = Utf8.REPLACEMENT_BYTE;
        goto L20
    L11:
        int r21 = r5 + 1;
        r0[r5] = (byte) r6;
        r2 = r2 + 1;
    L12:
        if (r2 >= r3) goto L16;
        if (r12.charAt(r2) >= 128) goto L16;
        r0[r21] = (byte) r12.charAt(r2);
        r2 = r2 + 1;
        r21 = r21 + 1;
    L16:
        r5 = r21;
        goto L8
    L38:
        byte[] r110 = Arrays.copyOf(r0, r5);
        Intrinsics.checkExpressionValueIsNotNull(r110, "java.util.Arrays.copyOf(this, newSize)");
        return r110;
    L41:
        byte[] r111 = Arrays.copyOf(r0, r12.length());
        Intrinsics.checkExpressionValueIsNotNull(r111, "java.util.Arrays.copyOf(this, newSize)");
        return r111;
    }

    public static final String commonToUtf8String(byte[] r16) {
        Intrinsics.checkParameterIsNotNull(r16, "$receiver");
        char[] r1 = new char[r16.length];
        int r2 = r16.length;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r2) goto L122;
        byte r6 = r16[r4];
        if (r6 >= 0) goto L6;
        if ((r6 >> 5) == (-2)) goto L14;
        if ((r6 >> 4) == (-2)) goto L32;
        if ((r6 >> 3) != (-2)) goto L119;
        int r7 = r4 + 3;
        if (r2 > r7) goto L86;
        int r8 = r5 + 1;
        r1[r5] = Utf8.REPLACEMENT_CHARACTER;
        int r9 = r4 + 1;
        if (r2 > r9) goto L70;
    L85:
        int r10 = 1;
    L118:
        r4 = r4 + r10;
    L120:
        r5 = r8;
        goto L3
    L70:
        if ((r16[r9] & MessagePack.Code.NIL) != 128) goto L72;
        boolean r11 = true;
    L73:
        if (r11 == false) goto L85;
        int r12 = r4 + 2;
        if (r2 > r12) goto L78;
    L84:
        r10 = 2;
        goto L118
    L78:
        if ((r16[r12] & MessagePack.Code.NIL) != 128) goto L80;
        boolean r13 = true;
    L81:
        if (r13 == false) goto L84;
    L83:
        r10 = 3;
        goto L118
    L80:
        r13 = false;
        goto L81
    L72:
        r11 = false;
        goto L73
    L86:
        byte r14 = r16[r4];
        byte r15 = r16[r4 + 1];
        if ((r15 & MessagePack.Code.NIL) != 128) goto L89;
        boolean r17 = true;
    L90:
        if (r17 == true) goto L92;
        r8 = r5 + 1;
        r1[r5] = Utf8.REPLACEMENT_CHARACTER;
        goto L85
    L92:
        byte r18 = r16[r4 + 2];
        if ((r18 & MessagePack.Code.NIL) != 128) goto L95;
        boolean r19 = true;
    L96:
        if (r19 == true) goto L98;
        r8 = r5 + 1;
        r1[r5] = Utf8.REPLACEMENT_CHARACTER;
        goto L84
    L98:
        byte r20 = r16[r7];
        if ((r20 & MessagePack.Code.NIL) != 128) goto L101;
        boolean r110 = true;
    L102:
        if (r110 == true) goto L104;
        r8 = r5 + 1;
        r1[r5] = Utf8.REPLACEMENT_CHARACTER;
        goto L83
    L104:
        int r21 = (((r20 ^ 3678080) ^ (r18 << 6)) ^ (r15 << 12)) ^ (r14 << 18);
        if (r21 <= 1114111) goto L107;
        r8 = r5 + 1;
        r1[r5] = Utf8.REPLACEMENT_CHARACTER;
    L117:
        r10 = 4;
        goto L118
    L107:
        if (55296 > r21) goto L112;
        if (57343 < r21) goto L112;
        r8 = r5 + 1;
        r1[r5] = Utf8.REPLACEMENT_CHARACTER;
    L112:
        if (r21 >= 65536) goto L114;
        r8 = r5 + 1;
        r1[r5] = Utf8.REPLACEMENT_CHARACTER;
        goto L117
    L114:
        if (r21 == 65533) goto L116;
        int r22 = r5 + 1;
        r1[r5] = (char) ((r21 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        char r23 = (char) ((r21 & 1023) + Utf8.LOG_SURROGATE_HEADER);
        r8 = r22 + 1;
        r1[r22] = r23;
        goto L117
    L116:
        r8 = r5 + 1;
        r1[r5] = Utf8.REPLACEMENT_CHARACTER;
        goto L117
    L101:
        r110 = false;
        goto L102
    L95:
        r19 = false;
        goto L96
    L89:
        r17 = false;
        goto L90
    L119:
        r8 = r5 + 1;
        r1[r5] = Utf8.REPLACEMENT_CHARACTER;
        r4 = r4 + 1;
        goto L120
    L32:
        int r24 = r4 + 2;
        if (r2 > r24) goto L42;
        int r25 = r5 + 1;
        r1[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
        int r26 = r4 + 1;
        if (r2 > r26) goto L37;
    L17:
        int r27 = 1;
    L29:
        r4 = r4 + r27;
    L11:
        r5 = r25;
        goto L3
    L37:
        if ((r16[r26] & MessagePack.Code.NIL) != 128) goto L39;
        boolean r28 = true;
    L40:
        if (r28 == false) goto L17;
    L28:
        r27 = 2;
        goto L29
    L39:
        r28 = false;
        goto L40
    L42:
        byte r29 = r16[r4];
        byte r30 = r16[r4 + 1];
        if ((r30 & MessagePack.Code.NIL) != 128) goto L45;
        boolean r31 = true;
    L46:
        if (r31 == true) goto L48;
        r25 = r5 + 1;
        r1[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
        goto L17
    L48:
        byte r32 = r16[r24];
        if ((r32 & MessagePack.Code.NIL) != 128) goto L51;
        boolean r111 = true;
    L52:
        if (r111 == true) goto L54;
        r25 = r5 + 1;
        r1[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
        goto L28
    L54:
        int r33 = ((r32 ^ (-123008)) ^ (r30 << 6)) ^ (r29 << 12);
        if (r33 >= 2048) goto L57;
        r25 = r5 + 1;
        r1[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
    L62:
        r27 = 3;
        goto L29
    L57:
        if (55296 > r33) goto L61;
        if (57343 < r33) goto L61;
        r25 = r5 + 1;
        r1[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
    L61:
        r25 = r5 + 1;
        r1[r5] = (char) r33;
        goto L62
    L51:
        r111 = false;
        goto L52
    L45:
        r31 = false;
        goto L46
    L14:
        int r34 = r4 + 1;
        if (r2 > r34) goto L18;
        r25 = r5 + 1;
        r1[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
        goto L17
    L18:
        byte r35 = r16[r4];
        byte r36 = r16[r34];
        if ((r36 & MessagePack.Code.NIL) != 128) goto L21;
        boolean r37 = true;
    L22:
        if (r37 == true) goto L24;
        r25 = r5 + 1;
        r1[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
        goto L17
    L24:
        int r38 = (r36 ^ 3968) ^ (r35 << 6);
        if (r38 >= 128) goto L27;
        r25 = r5 + 1;
        r1[r5] = (char) Utf8.REPLACEMENT_CODE_POINT;
        goto L28
    L27:
        r25 = r5 + 1;
        r1[r5] = (char) r38;
        goto L28
    L21:
        r37 = false;
        goto L22
    L6:
        r25 = r5 + 1;
        r1[r5] = (char) r6;
        r4 = r4 + 1;
    L7:
        if (r4 >= r2) goto L11;
        if (r16[r4] < 0) goto L11;
        r1[r25] = (char) r16[r4];
        r4 = r4 + 1;
        r25 = r25 + 1;
        goto L7
    L122:
        return new String(r1, 0, r5);
    }
}
