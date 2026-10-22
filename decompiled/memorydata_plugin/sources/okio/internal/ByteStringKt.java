package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Base64;
import okio.ByteString;
import okio.Platform;
import okio.Util;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0017\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\tH\u0000\u001a\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0001H\u0000\u001a\f\u0010\u0012\u001a\u00020\u0011*\u00020\u0001H\u0000\u001a\u0014\u0010\u0013\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0000\u001a\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u0001*\u00020\u0011H\u0000\u001a\f\u0010\u0016\u001a\u00020\u0001*\u00020\u0011H\u0000\u001a\f\u0010\u0017\u001a\u00020\u0001*\u00020\u0011H\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\tH\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u001b\u001a\u00020\u0019*\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u001cH\u0000\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0007H\u0000\u001a\f\u0010 \u001a\u00020\u0007*\u00020\u0001H\u0000\u001a\f\u0010!\u001a\u00020\u0007*\u00020\u0001H\u0000\u001a\f\u0010\"\u001a\u00020\u0011*\u00020\u0001H\u0000\u001a\u001c\u0010#\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0007H\u0000\u001a\f\u0010%\u001a\u00020\t*\u00020\u0001H\u0000\u001a\u001c\u0010&\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0007H\u0000\u001a,\u0010'\u001a\u00020\u0019*\u00020\u00012\u0006\u0010(\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0000\u001a,\u0010'\u001a\u00020\u0019*\u00020\u00012\u0006\u0010(\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0000\u001a\u0014\u0010+\u001a\u00020\u0019*\u00020\u00012\u0006\u0010,\u001a\u00020\tH\u0000\u001a\u0014\u0010+\u001a\u00020\u0019*\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0000\u001a\u001c\u0010-\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0000\u001a\f\u00100\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u00101\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u00102\u001a\u00020\t*\u00020\u0001H\u0000\u001a\f\u00103\u001a\u00020\u0011*\u00020\u0001H\u0000\u001a\f\u00104\u001a\u00020\u0011*\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"COMMON_EMPTY", "Lokio/ByteString;", "getCOMMON_EMPTY", "()Lokio/ByteString;", "HEX_DIGITS", "", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", TypedValues.CycleType.S_WAVE_OFFSET, "otherOffset", "byteCount", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToString", "commonUtf8", "jvm"}, k = 2, mv = {1, 1, 11})
public final class ByteStringKt {
    private static final ByteString COMMON_EMPTY = null;
    private static final char[] HEX_DIGITS = null;

    static {
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        COMMON_EMPTY = ByteString.Companion.of(new byte[0]);
    }

    private static final int codePointIndexToCharIndex(byte[] r19, int r20) {
        int r2 = r19.length;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r4 >= r2) goto L220;
        byte r7 = r19[r4];
        if (r7 >= 0) goto L6;
        if ((r7 >> 5) != (-2)) goto L90;
        int r3 = r4 + 1;
        if (r2 <= r3) goto L52;
        byte r8 = r19[r4];
        byte r9 = r19[r3];
        if ((r9 & MessagePack.Code.NIL) != 128) goto L58;
        boolean r15 = true;
    L59:
        if (r15 == false) goto L60;
        int r10 = (r9 ^ 3968) ^ (r8 << 6);
        if (r10 < 128) goto L65;
        int r11 = r6 + 1;
        if (r6 == r20) goto L70;
        if (r10 == 10) goto L81;
        if (r10 == 13) goto L81;
        if (r10 < 0) goto L75;
        if (31 < r10) goto L75;
    L78:
        boolean r12 = true;
    L80:
        if (r12 == false) goto L81;
    L82:
        return -1;
    L75:
        if (127 > r10) goto L79;
        if (159 >= r10) goto L78;
    L79:
        r12 = false;
    L81:
        if (r10 == 65533) goto L82;
        if (r10 >= 65536) goto L86;
        int r16 = 1;
    L87:
        r5 = r5 + r16;
        r4 = r4 + 2;
    L88:
        r6 = r11;
        goto L3
    L86:
        r16 = 2;
        goto L87
    L70:
        return r5;
    L65:
        if (r6 != r20) goto L67;
        return r5;
    L67:
        return -1;
    L60:
        if (r6 != r20) goto L62;
        return r5;
    L62:
        return -1;
    L58:
        r15 = false;
        goto L59
    L52:
        if (r6 != r20) goto L54;
        return r5;
    L54:
        return -1;
    L90:
        if ((r7 >> 4) != (-2)) goto L147;
        int r13 = r4 + 2;
        if (r2 <= r13) goto L93;
        byte r14 = r19[r4];
        byte r17 = r19[r4 + 1];
        if ((r17 & MessagePack.Code.NIL) != 128) goto L99;
        boolean r18 = true;
    L100:
        if (r18 == false) goto L101;
        byte r21 = r19[r13];
        if ((r21 & MessagePack.Code.NIL) != 128) goto L107;
        boolean r22 = true;
    L108:
        if (r22 == false) goto L109;
        int r23 = ((r21 ^ (-123008)) ^ (r17 << 6)) ^ (r14 << 12);
        if (r23 < 2048) goto L114;
        if (55296 > r23) goto L123;
        if (57343 < r23) goto L123;
        if (r6 != r20) goto L122;
        return r5;
    L122:
        return -1;
    L123:
        r11 = r6 + 1;
        if (r6 == r20) goto L125;
        if (r23 == 10) goto L139;
        if (r23 == 13) goto L139;
        if (r23 < 0) goto L131;
        if (31 < r23) goto L131;
    L135:
        boolean r24 = true;
    L137:
        if (r24 == false) goto L139;
    L140:
        return -1;
    L131:
        if (127 <= r23) goto L134;
    L136:
        r24 = false;
        goto L137
    L134:
        if (159 < r23) goto L136;
    L139:
        if (r23 == 65533) goto L140;
        if (r23 >= 65536) goto L144;
        int r110 = 1;
    L145:
        r5 = r5 + r110;
        r4 = r4 + 3;
        goto L88
    L144:
        r110 = 2;
        goto L145
    L125:
        return r5;
    L114:
        if (r6 != r20) goto L116;
        return r5;
    L116:
        return -1;
    L109:
        if (r6 != r20) goto L111;
        return r5;
    L111:
        return -1;
    L107:
        r22 = false;
        goto L108
    L101:
        if (r6 != r20) goto L103;
        return r5;
    L103:
        return -1;
    L99:
        r18 = false;
        goto L100
    L93:
        if (r6 != r20) goto L95;
        return r5;
    L95:
        return -1;
    L147:
        if ((r7 >> 3) != (-2)) goto L217;
        int r25 = r4 + 3;
        if (r2 <= r25) goto L150;
        byte r26 = r19[r4];
        byte r27 = r19[r4 + 1];
        if ((r27 & MessagePack.Code.NIL) != 128) goto L156;
        boolean r111 = true;
    L157:
        if (r111 == false) goto L158;
        byte r112 = r19[r4 + 2];
        if ((r112 & MessagePack.Code.NIL) != 128) goto L164;
        boolean r113 = true;
    L165:
        if (r113 == false) goto L166;
        byte r28 = r19[r25];
        if ((r28 & MessagePack.Code.NIL) != 128) goto L172;
        boolean r114 = true;
    L173:
        if (r114 == false) goto L174;
        int r29 = (((r28 ^ 3678080) ^ (r112 << 6)) ^ (r27 << 12)) ^ (r26 << 18);
        if (r29 > 1114111) goto L179;
        if (55296 > r29) goto L189;
        if (57343 < r29) goto L189;
        if (r6 != r20) goto L187;
        return r5;
    L187:
        return -1;
    L189:
        if (r29 < 65536) goto L190;
        r11 = r6 + 1;
        if (r6 == r20) goto L195;
        if (r29 == 10) goto L210;
        if (r29 == 13) goto L210;
        if (r29 < 0) goto L202;
        if (31 < r29) goto L202;
    L206:
        boolean r30 = true;
    L208:
        if (r30 == false) goto L210;
    L211:
        return -1;
    L202:
        if (127 <= r29) goto L205;
    L207:
        r30 = false;
        goto L208
    L205:
        if (159 < r29) goto L207;
    L210:
        if (r29 == 65533) goto L211;
        if (r29 >= 65536) goto L215;
        int r115 = 1;
    L216:
        r5 = r5 + r115;
        r4 = r4 + 4;
        goto L88
    L215:
        r115 = 2;
        goto L216
    L195:
        return r5;
    L190:
        if (r6 != r20) goto L192;
        return r5;
    L192:
        return -1;
    L179:
        if (r6 != r20) goto L181;
        return r5;
    L181:
        return -1;
    L174:
        if (r6 != r20) goto L176;
        return r5;
    L176:
        return -1;
    L172:
        r114 = false;
        goto L173
    L166:
        if (r6 != r20) goto L168;
        return r5;
    L168:
        return -1;
    L164:
        r113 = false;
        goto L165
    L158:
        if (r6 != r20) goto L160;
        return r5;
    L160:
        return -1;
    L156:
        r111 = false;
        goto L157
    L150:
        if (r6 != r20) goto L152;
        return r5;
    L152:
        return -1;
    L217:
        if (r6 != r20) goto L219;
        return r5;
    L219:
        return -1;
    L6:
        int r116 = r6 + 1;
        if (r6 == r20) goto L8;
        if (r7 == 10) goto L19;
        if (r7 == 13) goto L19;
        if (r7 < 0) goto L13;
        if (31 < r7) goto L13;
    L16:
        boolean r31 = true;
    L18:
        if (r31 == false) goto L19;
    L20:
        return -1;
    L13:
        if (127 > r7) goto L17;
        if (159 >= r7) goto L16;
    L17:
        r31 = false;
    L19:
        if (r7 == 65533) goto L20;
        if (r7 >= 65536) goto L23;
        int r32 = 1;
    L24:
        r5 = r5 + r32;
        r4 = r4 + 1;
    L25:
        r6 = r116;
        if (r4 >= r2) goto L3;
        if (r19[r4] < 0) goto L3;
        int r33 = r4 + 1;
        byte r34 = r19[r4];
        r116 = r6 + 1;
        if (r6 == r20) goto L31;
        if (r34 == 10) goto L42;
        if (r34 == 13) goto L42;
        if (r34 < 0) goto L36;
        if (31 < r34) goto L36;
    L39:
        boolean r35 = true;
    L41:
        if (r35 == false) goto L42;
    L43:
        return -1;
    L36:
        if (127 > r34) goto L40;
        if (159 >= r34) goto L39;
    L40:
        r35 = false;
    L42:
        if (r34 == 65533) goto L43;
        if (r34 >= 65536) goto L46;
        int r36 = 1;
    L47:
        r5 = r5 + r36;
        r4 = r33;
        goto L25
    L46:
        r36 = 2;
        goto L47
    L31:
        return r5;
    L23:
        r32 = 2;
        goto L24
    L8:
        return r5;
    L220:
        return r5;
    }

    public static final String commonBase64(ByteString r2) {
        Intrinsics.checkParameterIsNotNull(r2, "$receiver");
        return Base64.encodeBase64$default(r2.getData$jvm(), null, 1, null);
    }

    public static final String commonBase64Url(ByteString r1) {
        Intrinsics.checkParameterIsNotNull(r1, "$receiver");
        return Base64.encodeBase64(r1.getData$jvm(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(ByteString r9, ByteString r10) {
        Intrinsics.checkParameterIsNotNull(r9, "$receiver");
        Intrinsics.checkParameterIsNotNull(r10, "other");
        int r0 = r9.size();
        int r1 = r10.size();
        int r2 = Math.min(r0, r1);
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L12;
        int r7 = r9.getByte(r4) & 255;
        int r8 = r10.getByte(r4) & 255;
        if (r7 != r8) goto L8;
        r4 = r4 + 1;
        goto L4
    L8:
        if (r7 >= r8) goto L11;
        return -1;
    L11:
        return 1;
    L12:
        if (r0 != r1) goto L14;
        return 0;
    L14:
        if (r0 >= r1) goto L17;
        return -1;
    L17:
        return 1;
    }

    public static final ByteString commonDecodeBase64(String r1) {
        Intrinsics.checkParameterIsNotNull(r1, "$receiver");
        byte[] r2 = Base64.decodeBase64ToArray(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new ByteString(r2);
    }

    public static final ByteString commonDecodeHex(String r6) {
        Intrinsics.checkParameterIsNotNull(r6, "$receiver");
        int r1 = 0;
        if ((r6.length() % 2) != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        int r2 = r6.length() / 2;
        byte[] r3 = new byte[r2];
    L8:
        if (r1 >= r2) goto L11;
        int r4 = r1 * 2;
        r3[r1] = (byte) ((decodeHexDigit(r6.charAt(r4)) << 4) + decodeHexDigit(r6.charAt(r4 + 1)));
        r1 = r1 + 1;
        goto L8
    L11:
        return new ByteString(r3);
    L13:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("Unexpected hex string: " + r6).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L6
    }

    public static final ByteString commonEncodeUtf8(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "$receiver");
        ByteString r0 = new ByteString(Platform.asUtf8ToByteArray(r2));
        r0.setUtf8$jvm(r2);
        return r0;
    }

    public static final boolean commonEndsWith(ByteString r3, ByteString r4) {
        Intrinsics.checkParameterIsNotNull(r3, "$receiver");
        Intrinsics.checkParameterIsNotNull(r4, "suffix");
        return r3.rangeEquals(r3.size() - r4.size(), r4, 0, r4.size());
    }

    public static final boolean commonEndsWith(ByteString r3, byte[] r4) {
        Intrinsics.checkParameterIsNotNull(r3, "$receiver");
        Intrinsics.checkParameterIsNotNull(r4, "suffix");
        return r3.rangeEquals(r3.size() - r4.length, r4, 0, r4.length);
    }

    public static final boolean commonEquals(ByteString r5, Object r6) {
        Intrinsics.checkParameterIsNotNull(r5, "$receiver");
        if (r6 != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, ByteString.class) == false) goto L13;
        if (((ByteString) ZeusTransformUtils.preCheckCast(r6, ByteString.class, "com.obric.memorydata.plugin")).size() != r5.getData$jvm().length) goto L13;
        if (((ByteString) ZeusTransformUtils.preCheckCast(r6, ByteString.class, "com.obric.memorydata.plugin")).rangeEquals(0, r5.getData$jvm(), 0, r5.getData$jvm().length) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static final byte commonGetByte(ByteString r1, int r2) {
        Intrinsics.checkParameterIsNotNull(r1, "$receiver");
        return r1.getData$jvm()[r2];
    }

    public static final int commonGetSize(ByteString r1) {
        Intrinsics.checkParameterIsNotNull(r1, "$receiver");
        return r1.getData$jvm().length;
    }

    public static final int commonHashCode(ByteString r1) {
        Intrinsics.checkParameterIsNotNull(r1, "$receiver");
        int r0 = r1.getHashCode$jvm();
        if (r0 == 0) goto L5;
        return r0;
    L5:
        r1.setHashCode$jvm(Arrays.hashCode(r1.getData$jvm()));
        return r1.getHashCode$jvm();
    }

    public static final String commonHex(ByteString r8) {
        Intrinsics.checkParameterIsNotNull(r8, "$receiver");
        char[] r0 = new char[r8.getData$jvm().length * 2];
        byte[] r9 = r8.getData$jvm();
        int r1 = r9.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L6;
        byte r4 = r9[r2];
        int r5 = r3 + 1;
        char[] r6 = HEX_DIGITS;
        r0[r3] = r6[(r4 >> 4) & 15];
        r3 = r5 + 1;
        r0[r5] = r6[r4 & 15];
        r2 = r2 + 1;
        goto L3
    L6:
        return new String(r0);
    }

    public static final int commonIndexOf(ByteString r4, byte[] r5, int r6) {
        Intrinsics.checkParameterIsNotNull(r4, "$receiver");
        Intrinsics.checkParameterIsNotNull(r5, "other");
        int r0 = r4.getData$jvm().length - r5.length;
        int r7 = Math.max(r6, 0);
        if (r7 <= r0) goto L5;
        return -1;
    L5:
        if (Util.arrayRangeEquals(r4.getData$jvm(), r7, r5, 0, r5.length) == true) goto L6;
        if (r7 == r0) goto L13;
        r7 = r7 + 1;
        goto L5
    L13:
        return -1;
    L6:
        return r7;
    }

    public static final byte[] commonInternalArray(ByteString r1) {
        Intrinsics.checkParameterIsNotNull(r1, "$receiver");
        return r1.getData$jvm();
    }

    public static final int commonLastIndexOf(ByteString r3, byte[] r4, int r5) {
        Intrinsics.checkParameterIsNotNull(r3, "$receiver");
        Intrinsics.checkParameterIsNotNull(r4, "other");
        int r6 = Math.min(r5, r3.getData$jvm().length - r4.length);
    L3:
        if (r6 < 0) goto L8;
        if (Util.arrayRangeEquals(r3.getData$jvm(), r6, r4, 0, r4.length) == true) goto L6;
        r6 = r6 - 1;
        goto L3
    L6:
        return r6;
    L8:
        return -1;
    }

    public static final ByteString commonOf(byte[] r2) {
        Intrinsics.checkParameterIsNotNull(r2, "data");
        byte[] r3 = Arrays.copyOf(r2, r2.length);
        Intrinsics.checkExpressionValueIsNotNull(r3, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(r3);
    }

    public static final boolean commonRangeEquals(ByteString r1, int r2, ByteString r3, int r4, int r5) {
        Intrinsics.checkParameterIsNotNull(r1, "$receiver");
        Intrinsics.checkParameterIsNotNull(r3, "other");
        return r3.rangeEquals(r4, r1.getData$jvm(), r2, r5);
    }

    public static final boolean commonRangeEquals(ByteString r1, int r2, byte[] r3, int r4, int r5) {
        Intrinsics.checkParameterIsNotNull(r1, "$receiver");
        Intrinsics.checkParameterIsNotNull(r3, "other");
        if (r2 >= 0) goto L5;
    L12:
        return false;
    L5:
        if (r2 > (r1.getData$jvm().length - r5)) goto L12;
        if (r4 < 0) goto L12;
        if (r4 > (r3.length - r5)) goto L12;
        if (Util.arrayRangeEquals(r1.getData$jvm(), r2, r3, r4, r5) == false) goto L12;
        return true;
    }

    public static final boolean commonStartsWith(ByteString r2, ByteString r3) {
        Intrinsics.checkParameterIsNotNull(r2, "$receiver");
        Intrinsics.checkParameterIsNotNull(r3, "prefix");
        return r2.rangeEquals(0, r3, 0, r3.size());
    }

    public static final boolean commonStartsWith(ByteString r2, byte[] r3) {
        Intrinsics.checkParameterIsNotNull(r2, "$receiver");
        Intrinsics.checkParameterIsNotNull(r3, "prefix");
        return r2.rangeEquals(0, r3, 0, r3.length);
    }

    public static final ByteString commonSubstring(ByteString r4, int r5, int r6) {
        Intrinsics.checkParameterIsNotNull(r4, "$receiver");
        boolean r0 = true;
        if (r5 < 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L29;
        if (r6 > r4.getData$jvm().length) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L27;
        int r7 = r6 - r5;
        if (r7 >= 0) goto L17;
        r0 = false;
    L17:
        if (r0 == false) goto L25;
        if (r5 == 0) goto L20;
    L22:
        byte[] r8 = new byte[r7];
        Platform.arraycopy(r4.getData$jvm(), r5, r8, 0, r7);
        return new ByteString(r8);
    L20:
        if (r6 != r4.getData$jvm().length) goto L22;
        return r4;
    L25:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("endIndex < beginIndex".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L27:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("endIndex > length(" + r4.getData$jvm().length + ')').toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L11:
        r3 = false;
        goto L12
    L29:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("beginIndex < 0".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r2 = false;
        goto L7
    }

    public static final ByteString commonToAsciiLowercase(ByteString r5) {
        Intrinsics.checkParameterIsNotNull(r5, "$receiver");
        int r0 = 0;
    L4:
        if (r0 >= r5.getData$jvm().length) goto L22;
        byte r1 = r5.getData$jvm()[r0];
        byte r2 = (byte) 65;
        if (r1 < r2) goto L21;
        byte r3 = (byte) 90;
        if (r1 > r3) goto L21;
        byte[] r6 = r5.getData$jvm();
        byte[] r7 = Arrays.copyOf(r6, r6.length);
        Intrinsics.checkExpressionValueIsNotNull(r7, "java.util.Arrays.copyOf(this, size)");
        int r4 = r0 + 1;
        r7[r0] = (byte) (r1 + 32);
    L12:
        if (r4 >= r7.length) goto L20;
        byte r8 = r7[r4];
        if (r8 < r2) goto L18;
        if (r8 > r3) goto L18;
        r7[r4] = (byte) (r8 + 32);
    L18:
        r4 = r4 + 1;
        goto L12
    L20:
        return new ByteString(r7);
    L21:
        r0 = r0 + 1;
        goto L4
    L22:
        return r5;
    }

    public static final ByteString commonToAsciiUppercase(ByteString r5) {
        Intrinsics.checkParameterIsNotNull(r5, "$receiver");
        int r0 = 0;
    L4:
        if (r0 >= r5.getData$jvm().length) goto L22;
        byte r1 = r5.getData$jvm()[r0];
        byte r2 = (byte) 97;
        if (r1 < r2) goto L21;
        byte r3 = (byte) 122;
        if (r1 > r3) goto L21;
        byte[] r6 = r5.getData$jvm();
        byte[] r7 = Arrays.copyOf(r6, r6.length);
        Intrinsics.checkExpressionValueIsNotNull(r7, "java.util.Arrays.copyOf(this, size)");
        int r4 = r0 + 1;
        r7[r0] = (byte) (r1 + MessagePack.Code.NEGFIXINT_PREFIX);
    L12:
        if (r4 >= r7.length) goto L20;
        byte r8 = r7[r4];
        if (r8 < r2) goto L18;
        if (r8 > r3) goto L18;
        r7[r4] = (byte) (r8 + MessagePack.Code.NEGFIXINT_PREFIX);
    L18:
        r4 = r4 + 1;
        goto L12
    L20:
        return new ByteString(r7);
    L21:
        r0 = r0 + 1;
        goto L4
    L22:
        return r5;
    }

    public static final byte[] commonToByteArray(ByteString r1) {
        Intrinsics.checkParameterIsNotNull(r1, "$receiver");
        byte[] r2 = r1.getData$jvm();
        byte[] r3 = Arrays.copyOf(r2, r2.length);
        Intrinsics.checkExpressionValueIsNotNull(r3, "java.util.Arrays.copyOf(this, size)");
        return r3;
    }

    public static final String commonToString(ByteString r20) {
        Intrinsics.checkParameterIsNotNull(r20, "$receiver");
        if (r20.getData$jvm().length != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return "[size=0]";
    L9:
        int r2 = codePointIndexToCharIndex(r20.getData$jvm(), 64);
        if (r2 == (-1)) goto L12;
        String r3 = r20.utf8();
        if (r3 == null) goto L26;
        String r8 = r3.substring(0, r2);
        Intrinsics.checkExpressionValueIsNotNull(r8, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String r4 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r8, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r2 >= r3.length()) goto L22;
        StringBuilder r0 = new StringBuilder().append("[size=").append(r20.getData$jvm().length).append(" text=").append(r4).append("…]");
    L24:
        return r0.toString();
    L22:
        r0 = new StringBuilder().append("[text=").append(r4).append(']');
        goto L24
    L26:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L12:
        if (r20.getData$jvm().length > 64) goto L14;
        StringBuilder r5 = new StringBuilder().append("[hex=").append(r20.hex()).append(']');
    L16:
        return r5.toString();
    L14:
        r5 = new StringBuilder().append("[size=").append(r20.getData$jvm().length).append(" hex=").append(commonSubstring(r20, 0, 64).hex()).append("…]");
        goto L16
    L5:
        r1 = false;
        goto L6
    }

    public static final String commonUtf8(ByteString r1) {
        Intrinsics.checkParameterIsNotNull(r1, "$receiver");
        String r0 = r1.getUtf8$jvm();
        if (r0 != null) goto L6;
        String r2 = Platform.toUtf8String(r1.internalArray$jvm());
        r1.setUtf8$jvm(r2);
        return r2;
    L6:
        return r0;
    }

    private static final int decodeHexDigit(char r3) {
        if ('0' <= r3) goto L6;
    L8:
        char r1 = 'a';
        if ('a' > r3) goto L13;
        if ('f' < r3) goto L13;
    L20:
        return (r3 - r1) + 10;
    L13:
        r1 = 'A';
        if ('A' > r3) goto L19;
        if ('F' >= r3) goto L20;
    L19:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Unexpected hex digit: " + r3), Throwable.class, "com.obric.memorydata.plugin"));
    L6:
        if ('9' < r3) goto L8;
        return r3 - '0';
    }

    public static final ByteString getCOMMON_EMPTY() {
        return COMMON_EMPTY;
    }
}
