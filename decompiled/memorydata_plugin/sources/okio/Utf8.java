package okio;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0080\b\u001a1\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u001a1\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u001a1\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u001a1\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u001a1\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u001a1\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "jvm"}, k = 2, mv = {1, 1, 11})
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int r2) {
        if (r2 < 0) goto L6;
        if (31 < r2) goto L6;
    L9:
        return true;
    L6:
        if (127 > r2) goto L10;
        if (159 >= r2) goto L9;
    L10:
        return false;
    }

    public static final boolean isUtf8Continuation(byte r1) {
        if ((r1 & MessagePack.Code.NIL) != 128) goto L5;
        return true;
    L5:
        return false;
    }

    public static final int process2Utf8Bytes(byte[] r3, int r4, int r5, Function1<? super Integer, Unit> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "$receiver");
        Intrinsics.checkParameterIsNotNull(r7, "yield");
        int r0 = r4 + 1;
        Integer r1 = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (r5 > r0) goto L6;
        r7.invoke(r1);
        return 1;
    L6:
        byte r8 = r3[r4];
        byte r9 = r3[r0];
        if ((r9 & MessagePack.Code.NIL) != 128) goto L9;
        boolean r10 = true;
    L10:
        if (r10 == true) goto L13;
        r7.invoke(r1);
        return 1;
    L13:
        int r11 = (r9 ^ 3968) ^ (r8 << 6);
        if (r11 >= 128) goto L16;
        r7.invoke(r1);
        return 2;
    L16:
        r7.invoke(Integer.valueOf(r11));
        return 2;
    L9:
        r10 = false;
        goto L10
    }

    public static final int process3Utf8Bytes(byte[] r7, int r8, int r9, Function1<? super Integer, Unit> r10) {
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r7, "$receiver");
        Intrinsics.checkParameterIsNotNull(r11, "yield");
        int r0 = r8 + 2;
        boolean r1 = false;
        Integer r4 = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (r9 > r0) goto L13;
        r11.invoke(r4);
        int r12 = r8 + 1;
        if (r9 > r12) goto L7;
    L12:
        return 1;
    L7:
        if ((r7[r12] & MessagePack.Code.NIL) != 128) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L12;
        return 2;
    L13:
        byte r13 = r7[r8];
        byte r14 = r7[r8 + 1];
        if ((r14 & MessagePack.Code.NIL) != 128) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == true) goto L20;
        r11.invoke(r4);
        return 1;
    L20:
        byte r15 = r7[r0];
        if ((r15 & MessagePack.Code.NIL) != 128) goto L23;
        r1 = true;
    L23:
        if (r1 == true) goto L26;
        r11.invoke(r4);
        return 2;
    L26:
        int r16 = ((r15 ^ (-123008)) ^ (r14 << 6)) ^ (r13 << 12);
        if (r16 >= 2048) goto L30;
    L28:
        r11.invoke(r4);
        return 3;
    L30:
        if (55296 > r16) goto L34;
        if (57343 >= r16) goto L28;
    L34:
        r11.invoke(Integer.valueOf(r16));
        return 3;
    L16:
        r6 = false;
        goto L17
    }

    public static final int process4Utf8Bytes(byte[] r9, int r10, int r11, Function1<? super Integer, Unit> r12) {
        Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r9, "$receiver");
        Intrinsics.checkParameterIsNotNull(r13, "yield");
        int r0 = r10 + 3;
        boolean r3 = false;
        Integer r5 = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (r11 > r0) goto L22;
        r13.invoke(r5);
        int r14 = r10 + 1;
        if (r11 > r14) goto L7;
    L21:
        return 1;
    L7:
        if ((r9[r14] & MessagePack.Code.NIL) != 128) goto L9;
        boolean r15 = true;
    L10:
        if (r15 == false) goto L21;
        int r16 = r10 + 2;
        if (r11 > r16) goto L15;
    L20:
        return 2;
    L15:
        if ((r9[r16] & MessagePack.Code.NIL) != 128) goto L17;
        r3 = true;
    L17:
        if (r3 == false) goto L20;
        return 3;
    L9:
        r15 = false;
        goto L10
    L22:
        byte r17 = r9[r10];
        byte r7 = r9[r10 + 1];
        if ((r7 & MessagePack.Code.NIL) != 128) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == true) goto L29;
        r13.invoke(r5);
        return 1;
    L29:
        byte r18 = r9[r10 + 2];
        if ((r18 & MessagePack.Code.NIL) != 128) goto L32;
        boolean r19 = true;
    L33:
        if (r19 == true) goto L36;
        r13.invoke(r5);
        return 2;
    L36:
        byte r20 = r9[r0];
        if ((r20 & MessagePack.Code.NIL) != 128) goto L39;
        r3 = true;
    L39:
        if (r3 == true) goto L42;
        r13.invoke(r5);
        return 3;
    L42:
        int r21 = (((r20 ^ 3678080) ^ (r18 << 6)) ^ (r7 << 12)) ^ (r17 << 18);
        if (r21 <= 1114111) goto L46;
    L44:
        r13.invoke(r5);
        return 4;
    L46:
        if (55296 > r21) goto L51;
        if (57343 >= r21) goto L44;
    L51:
        if (r21 < 65536) goto L44;
        r13.invoke(Integer.valueOf(r21));
        return 4;
    L32:
        r19 = false;
        goto L33
    L25:
        r8 = false;
        goto L26
    }

    public static final void processUtf16Chars(byte[] r16, int r17, int r18, Function1<? super Character, Unit> r19) {
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r16, "$receiver");
        Intrinsics.checkParameterIsNotNull(r2, "yield");
        int r3 = r17;
    L3:
        if (r3 >= r18) goto L112;
        byte r4 = r16[r3];
        if (r4 >= 0) goto L6;
        boolean r8 = false;
        if ((r4 >> 5) == (-2)) goto L13;
        if ((r4 >> 4) == (-2)) goto L31;
        if ((r4 >> 3) == (-2)) goto L63;
        r2.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
        r3 = r3 + 1;
        goto L3
    L63:
        int r5 = r3 + 3;
        if (r18 > r5) goto L80;
        r2.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
        int r6 = r3 + 1;
        if (r18 > r6) goto L68;
    L16:
        int r7 = 1;
    L28:
        r3 = r3 + r7;
        goto L3
    L68:
        if ((r16[r6] & MessagePack.Code.NIL) != 128) goto L70;
        boolean r9 = true;
    L71:
        if (r9 == false) goto L16;
        int r10 = r3 + 2;
        if (r18 > r10) goto L76;
    L27:
        r7 = 2;
        goto L28
    L76:
        if ((r16[r10] & MessagePack.Code.NIL) != 128) goto L78;
        r8 = true;
    L78:
        if (r8 == false) goto L27;
    L60:
        r7 = 3;
        goto L28
    L70:
        r9 = false;
        goto L71
    L80:
        byte r11 = r16[r3];
        byte r12 = r16[r3 + 1];
        if ((r12 & MessagePack.Code.NIL) != 128) goto L83;
        boolean r15 = true;
    L84:
        if (r15 == true) goto L86;
        r2.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
        goto L16
    L86:
        byte r110 = r16[r3 + 2];
        if ((r110 & MessagePack.Code.NIL) != 128) goto L89;
        boolean r13 = true;
    L90:
        if (r13 == true) goto L92;
        r2.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
        goto L27
    L92:
        byte r14 = r16[r5];
        if ((r14 & MessagePack.Code.NIL) != 128) goto L95;
        r8 = true;
    L95:
        if (r8 == true) goto L97;
        r2.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
        goto L60
    L97:
        int r20 = (((r14 ^ 3678080) ^ (r110 << 6)) ^ (r12 << 12)) ^ (r11 << 18);
        if (r20 <= 1114111) goto L101;
    L99:
        Character r21 = Character.valueOf(REPLACEMENT_CHARACTER);
    L100:
        r2.invoke(r21);
        r7 = 4;
        goto L28
    L101:
        if (55296 > r20) goto L106;
        if (57343 >= r20) goto L99;
    L106:
        if (r20 < 65536) goto L99;
        if (r20 == 65533) goto L99;
        r2.invoke(Character.valueOf((char) ((r20 >>> 10) + HIGH_SURROGATE_HEADER)));
        r21 = Character.valueOf((char) ((r20 & 1023) + LOG_SURROGATE_HEADER));
        goto L100
    L89:
        r13 = false;
        goto L90
    L83:
        r15 = false;
        goto L84
    L31:
        int r22 = r3 + 2;
        if (r18 > r22) goto L40;
        r2.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
        int r23 = r3 + 1;
        if (r18 <= r23) goto L16;
        if ((r16[r23] & MessagePack.Code.NIL) != 128) goto L38;
        r8 = true;
    L38:
        if (r8 == true) goto L27;
    L40:
        byte r24 = r16[r3];
        byte r25 = r16[r3 + 1];
        if ((r25 & MessagePack.Code.NIL) != 128) goto L43;
        boolean r111 = true;
    L44:
        if (r111 == true) goto L46;
        r2.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
        goto L16
    L46:
        byte r26 = r16[r22];
        if ((r26 & MessagePack.Code.NIL) != 128) goto L49;
        r8 = true;
    L49:
        if (r8 == true) goto L51;
        r2.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
        goto L27
    L51:
        int r27 = ((r26 ^ (-123008)) ^ (r25 << 6)) ^ (r24 << 12);
        if (r27 >= 2048) goto L55;
    L53:
        char r28 = (char) REPLACEMENT_CODE_POINT;
    L54:
        r2.invoke(Character.valueOf(r28));
        goto L60
    L55:
        if (55296 > r27) goto L59;
        if (57343 >= r27) goto L53;
    L59:
        r28 = (char) r27;
        goto L54
    L43:
        r111 = false;
        goto L44
    L13:
        int r29 = r3 + 1;
        if (r18 > r29) goto L17;
    L15:
        r2.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
        goto L16
    L17:
        byte r30 = r16[r3];
        byte r31 = r16[r29];
        if ((r31 & MessagePack.Code.NIL) != 128) goto L20;
        r8 = true;
    L20:
        if (r8 == false) goto L15;
        int r32 = (r31 ^ 3968) ^ (r30 << 6);
        if (r32 >= 128) goto L25;
        char r33 = (char) REPLACEMENT_CODE_POINT;
    L26:
        r2.invoke(Character.valueOf(r33));
        goto L27
    L25:
        r33 = (char) r32;
        goto L26
    L6:
        r2.invoke(Character.valueOf((char) r4));
        r3 = r3 + 1;
    L7:
        if (r3 >= r18) goto L3;
        if (r16[r3] < 0) goto L3;
        r2.invoke(Character.valueOf((char) r16[r3]));
        r3 = r3 + 1;
        goto L7
    }

    public static final void processUtf8Bytes(String r7, int r8, int r9, Function1<? super Byte, Unit> r10) {
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r7, "$receiver");
        Intrinsics.checkParameterIsNotNull(r11, "yield");
    L3:
        if (r8 >= r9) goto L32;
        char r0 = r7.charAt(r8);
        if (r0 < 128) goto L6;
        if (r0 < 2048) goto L13;
        if (55296 > r0) goto L31;
        if (57343 < r0) goto L31;
        if (r0 > 56319) goto L30;
        int r4 = r8 + 1;
        if (r9 <= r4) goto L30;
        char r6 = r7.charAt(r4);
        if (56320 > r6) goto L30;
        if (57343 < r6) goto L30;
        int r1 = ((r0 << '\n') + r7.charAt(r4)) - 56613888;
        r11.invoke(Byte.valueOf((byte) ((r1 >> 18) | 240)));
        r11.invoke(Byte.valueOf((byte) (((r1 >> 12) & 63) | 128)));
        r11.invoke(Byte.valueOf((byte) (((r1 >> 6) & 63) | 128)));
        r11.invoke(Byte.valueOf((byte) ((r1 & 63) | 128)));
        r8 = r8 + 2;
    L30:
        Byte r2 = Byte.valueOf(REPLACEMENT_BYTE);
    L15:
        r11.invoke(r2);
        r8 = r8 + 1;
    L31:
        r11.invoke(Byte.valueOf((byte) ((r0 >> '\f') | 224)));
        int r3 = ((r0 >> 6) & 63) | 128;
    L14:
        r11.invoke(Byte.valueOf((byte) r3));
        r2 = Byte.valueOf((byte) ((r0 & '?') | 128));
        goto L15
    L13:
        r3 = (r0 >> 6) | 192;
        goto L14
    L6:
        r11.invoke(Byte.valueOf((byte) r0));
        r8 = r8 + 1;
    L7:
        if (r8 >= r9) goto L3;
        if (r7.charAt(r8) >= 128) goto L3;
        r11.invoke(Byte.valueOf((byte) r7.charAt(r8)));
        r8 = r8 + 1;
        goto L7
    }

    public static final void processUtf8CodePoints(byte[] r16, int r17, int r18, Function1<? super Integer, Unit> r19) {
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r16, "$receiver");
        Intrinsics.checkParameterIsNotNull(r2, "yield");
        int r3 = r17;
    L3:
        if (r3 >= r18) goto L111;
        byte r4 = r16[r3];
        if (r4 >= 0) goto L6;
        boolean r8 = false;
        if ((r4 >> 5) == (-2)) goto L13;
        if ((r4 >> 4) == (-2)) goto L31;
        if ((r4 >> 3) == (-2)) goto L63;
        r2.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        r3 = r3 + 1;
        goto L3
    L63:
        int r5 = r3 + 3;
        if (r18 > r5) goto L80;
        r2.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        int r6 = r3 + 1;
        if (r18 > r6) goto L68;
    L16:
        int r7 = 1;
    L28:
        r3 = r3 + r7;
        goto L3
    L68:
        if ((r16[r6] & MessagePack.Code.NIL) != 128) goto L70;
        boolean r9 = true;
    L71:
        if (r9 == false) goto L16;
        int r10 = r3 + 2;
        if (r18 > r10) goto L76;
    L27:
        r7 = 2;
        goto L28
    L76:
        if ((r16[r10] & MessagePack.Code.NIL) != 128) goto L78;
        r8 = true;
    L78:
        if (r8 == false) goto L27;
    L60:
        r7 = 3;
        goto L28
    L70:
        r9 = false;
        goto L71
    L80:
        byte r11 = r16[r3];
        byte r12 = r16[r3 + 1];
        if ((r12 & MessagePack.Code.NIL) != 128) goto L83;
        boolean r15 = true;
    L84:
        if (r15 == true) goto L86;
        r2.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        goto L16
    L86:
        byte r110 = r16[r3 + 2];
        if ((r110 & MessagePack.Code.NIL) != 128) goto L89;
        boolean r13 = true;
    L90:
        if (r13 == true) goto L92;
        r2.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        goto L27
    L92:
        byte r14 = r16[r5];
        if ((r14 & MessagePack.Code.NIL) != 128) goto L95;
        r8 = true;
    L95:
        if (r8 == true) goto L97;
        r2.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        goto L60
    L97:
        int r20 = (((r14 ^ 3678080) ^ (r110 << 6)) ^ (r12 << 12)) ^ (r11 << 18);
        if (r20 <= 1114111) goto L101;
    L99:
        Integer r21 = Integer.valueOf(REPLACEMENT_CODE_POINT);
    L100:
        r2.invoke(r21);
        r7 = 4;
        goto L28
    L101:
        if (55296 > r20) goto L106;
        if (57343 >= r20) goto L99;
    L106:
        if (r20 < 65536) goto L99;
        r21 = Integer.valueOf(r20);
        goto L100
    L89:
        r13 = false;
        goto L90
    L83:
        r15 = false;
        goto L84
    L31:
        int r22 = r3 + 2;
        if (r18 > r22) goto L40;
        r2.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        int r23 = r3 + 1;
        if (r18 <= r23) goto L16;
        if ((r16[r23] & MessagePack.Code.NIL) != 128) goto L38;
        r8 = true;
    L38:
        if (r8 == true) goto L27;
    L40:
        byte r24 = r16[r3];
        byte r25 = r16[r3 + 1];
        if ((r25 & MessagePack.Code.NIL) != 128) goto L43;
        boolean r111 = true;
    L44:
        if (r111 == true) goto L46;
        r2.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        goto L16
    L46:
        byte r26 = r16[r22];
        if ((r26 & MessagePack.Code.NIL) != 128) goto L49;
        r8 = true;
    L49:
        if (r8 == true) goto L51;
        r2.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        goto L27
    L51:
        int r27 = ((r26 ^ (-123008)) ^ (r25 << 6)) ^ (r24 << 12);
        if (r27 >= 2048) goto L55;
    L53:
        Integer r28 = Integer.valueOf(REPLACEMENT_CODE_POINT);
    L54:
        r2.invoke(r28);
        goto L60
    L55:
        if (55296 > r27) goto L59;
        if (57343 >= r27) goto L53;
    L59:
        r28 = Integer.valueOf(r27);
        goto L54
    L43:
        r111 = false;
        goto L44
    L13:
        int r29 = r3 + 1;
        if (r18 > r29) goto L17;
    L15:
        r2.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
        goto L16
    L17:
        byte r30 = r16[r3];
        byte r31 = r16[r29];
        if ((r31 & MessagePack.Code.NIL) != 128) goto L20;
        r8 = true;
    L20:
        if (r8 == false) goto L15;
        int r32 = (r31 ^ 3968) ^ (r30 << 6);
        if (r32 >= 128) goto L25;
        Integer r33 = Integer.valueOf(REPLACEMENT_CODE_POINT);
    L26:
        r2.invoke(r33);
        goto L27
    L25:
        r33 = Integer.valueOf(r32);
        goto L26
    L6:
        r2.invoke(Integer.valueOf(r4));
        r3 = r3 + 1;
    L7:
        if (r3 >= r18) goto L3;
        if (r16[r3] < 0) goto L3;
        r2.invoke(Integer.valueOf(r16[r3]));
        r3 = r3 + 1;
        goto L7
    }

    public static final long size(String r3) {
        return size$default(r3, 0, 0, 3, null);
    }

    public static final long size(String r3, int r4) {
        return size$default(r3, r4, 0, 2, null);
    }

    public static final long size(String r10, int r11, int r12) {
        Intrinsics.checkParameterIsNotNull(r10, "$receiver");
        boolean r1 = true;
        if (r11 < 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L51;
        if (r12 < r11) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L49;
        if (r12 <= r10.length()) goto L16;
        r1 = false;
    L16:
        if (r1 == false) goto L47;
        long r4 = 0;
    L18:
        if (r11 >= r12) goto L45;
        char r5 = r10.charAt(r11);
        if (r5 < 128) goto L21;
        if (r5 < 2048) goto L25;
        if (r5 < 55296) goto L44;
        if (r5 > 57343) goto L44;
        int r7 = r11 + 1;
        if (r7 >= r12) goto L35;
        char r8 = r10.charAt(r7);
    L37:
        if (r5 > 56319) goto L43;
        if (r8 < 56320) goto L43;
        if (r8 > 57343) goto L43;
        r4 = r4 + ((long) 4);
        r11 = r11 + 2;
    L43:
        r4 = r4 + 1;
        r11 = r7;
        goto L18
    L35:
        r8 = 0;
    L44:
        int r6 = 3;
    L26:
        r4 = r4 + ((long) r6);
    L22:
        r11 = r11 + 1;
        goto L18
    L25:
        r6 = 2;
        goto L26
    L21:
        r4 = r4 + 1;
        goto L22
    L45:
        return r4;
    L47:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("endIndex > string.length: " + r12 + " > " + r10.length()).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L49:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("endIndex < beginIndex: " + r12 + " < " + r11).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L10:
        r3 = false;
        goto L11
    L51:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("beginIndex < 0: " + r11).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r2 = false;
        goto L7
    }

    public static /* synthetic */ long size$default(String r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        return size(r0, r1, r2);
    }
}
