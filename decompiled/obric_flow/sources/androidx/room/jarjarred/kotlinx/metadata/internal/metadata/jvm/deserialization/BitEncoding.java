package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization;

import java.util.ArrayList;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public class BitEncoding {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean FORCE_8TO7_ENCODING = false;
    private static final char _8TO7_MODE_MARKER = 65535;

    private static /* synthetic */ void $$$reportNull$$$0(int r19) {
        if (r19 == 1) goto L11;
        if (r19 == 3) goto L11;
        if (r19 == 6) goto L11;
        if (r19 == 8) goto L11;
        if (r19 == 10) goto L11;
        if (r19 == 12) goto L11;
        if (r19 == 14) goto L11;
        String r10 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L13:
        if (r19 == 1) goto L21;
        if (r19 == 3) goto L21;
        if (r19 == 6) goto L21;
        if (r19 == 8) goto L21;
        if (r19 == 10) goto L21;
        if (r19 == 12) goto L21;
        if (r19 == 14) goto L21;
        int r11 = 3;
    L22:
        Object[] r12 = new Object[r11];
        if (r19 == 1) goto L31;
        if (r19 == 3) goto L31;
        if (r19 == 6) goto L31;
        if (r19 == 8) goto L31;
        if (r19 == 10) goto L31;
        if (r19 == 12) goto L31;
        if (r19 == 14) goto L31;
        r12[0] = "data";
    L33:
        if (r19 == 1) goto L47;
        if (r19 == 3) goto L46;
        if (r19 == 6) goto L45;
        if (r19 == 8) goto L44;
        if (r19 == 10) goto L43;
        if (r19 == 12) goto L42;
        if (r19 == 14) goto L41;
        r12[1] = "androidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/BitEncoding";
    L48:
        switch(r19) {
            case 1: goto L57;
            case 2: goto L56;
            case 3: goto L57;
            case 4: goto L55;
            case 5: goto L54;
            case 6: goto L57;
            case 7: goto L53;
            case 8: goto L57;
            case 9: goto L52;
            case 10: goto L57;
            case 11: goto L51;
            case 12: goto L57;
            case 13: goto L50;
            case 14: goto L57;
            default: goto L49;
        };
    L49:
        r12[2] = "encodeBytes";
        goto L57
    L50:
        r12[2] = "decode7to8";
        goto L57
    L51:
        r12[2] = "combineStringArrayIntoBytes";
        goto L57
    L52:
        r12[2] = "dropMarker";
        goto L57
    L53:
        r12[2] = "decodeBytes";
        goto L57
    L54:
        r12[2] = "splitBytesToStringArray";
        goto L57
    L55:
        r12[2] = "addModuloByte";
        goto L57
    L56:
        r12[2] = "encode8to7";
    L57:
        String r13 = String.format(r10, r12);
        if (r19 == 1) goto L67;
        if (r19 == 3) goto L67;
        if (r19 == 6) goto L67;
        if (r19 == 8) goto L67;
        if (r19 == 10) goto L67;
        if (r19 == 12) goto L67;
        if (r19 == 14) goto L67;
        throw new IllegalArgumentException(r13);
    L67:
        throw new IllegalStateException(r13);
    L41:
        r12[1] = "decode7to8";
        goto L48
    L42:
        r12[1] = "combineStringArrayIntoBytes";
        goto L48
    L43:
        r12[1] = "dropMarker";
        goto L48
    L44:
        r12[1] = "decodeBytes";
        goto L48
    L45:
        r12[1] = "splitBytesToStringArray";
        goto L48
    L46:
        r12[1] = "encode8to7";
        goto L48
    L47:
        r12[1] = "encodeBytes";
    L31:
        r12[0] = "androidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/BitEncoding";
    L21:
        r11 = 2;
    L11:
        r10 = "@NotNull method %s.%s must not return null";
        goto L13
    }

    static {
        String r5 = System.getProperty("kotlin.jvm.serialization.use8to7");     // Catch: SecurityException -> L4
    L5:
        FORCE_8TO7_ENCODING = "true".equals(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    private BitEncoding() {
    }

    private static void addModuloByte(byte[] r5, int r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        int r11 = r5.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        r5[r12] = (byte) ((r5[r12] + r10) & 127);
        r12 = r12 + 1;
        goto L5
    }

    private static byte[] combineStringArrayIntoBytes(String[] r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(11);
    L4:
        int r5 = r10.length;
        int r11 = 0;
        int r12 = 0;
    L5:
        if (r11 >= r5) goto L7;
        r12 = r12 + r10[r11].length();
        r11 = r11 + 1;
        goto L5
    L7:
        byte[] r13 = new byte[r12];
        int r14 = r10.length;
        int r15 = 0;
        int r16 = 0;
    L8:
        if (r15 >= r14) goto L13;
        String r17 = r10[r15];
        int r18 = r17.length();
        int r19 = 0;
    L10:
        if (r19 >= r18) goto L12;
        r13[r16] = (byte) r17.charAt(r19);
        r19 = r19 + 1;
        r16 = r16 + 1;
        goto L10
    L12:
        r15 = r15 + 1;
        goto L8
    L13:
        return r13;
    }

    private static byte[] decode7to8(byte[] r12) {
        if (r12 != null) goto L4;
        $$$reportNull$$$0(13);
    L4:
        int r5 = (r12.length * 7) / 8;
        byte[] r10 = new byte[r5];
        int r11 = 0;
        int r13 = 0;
        int r14 = 0;
    L5:
        if (r11 >= r5) goto L11;
        int r15 = r13 + 1;
        int r16 = r14 + 1;
        r10[r11] = (byte) (((r12[r13] & UByte.MAX_VALUE) >>> r14) + ((r12[r15] & ((1 << r16) - 1)) << (7 - r14)));
        if (r14 != 6) goto L9;
        r13 = r13 + 2;
        r14 = 0;
    L10:
        r11 = r11 + 1;
        goto L5
    L9:
        r13 = r15;
        r14 = r16;
        goto L10
    L11:
        return r10;
    }

    public static byte[] decodeBytes(String[] r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        if (r5.length > 0) goto L7;
    L17:
        byte[] r10 = combineStringArrayIntoBytes(r5);
        addModuloByte(r10, 127);
        return decode7to8(r10);
    L7:
        if (r5[0].isEmpty() == true) goto L17;
        char r11 = r5[0].charAt(0);
        if (r11 != 0) goto L15;
        byte[] r12 = UtfEncodingKt.stringsToBytes(dropMarker(r5));
        if (r12 != null) goto L13;
        $$$reportNull$$$0(8);
    L13:
        return r12;
    L15:
        if (r11 != 65535) goto L17;
        r5 = dropMarker(r5);
        goto L17
    }

    private static String[] dropMarker(String[] r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        String[] r10 = (String[]) r5.clone();
        r10[0] = r10[0].substring(1);
        return r10;
    }

    private static byte[] encode8to7(byte[] r11) {
        if (r11 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        int r5 = ((r11.length * 8) + 6) / 7;
        byte[] r10 = new byte[r5];
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L5:
        int r15 = r5 - 1;
        if (r12 >= r15) goto L11;
        if (r13 != 0) goto L9;
        r10[r12] = (byte) (r11[r14] & ByteCompanionObject.MAX_VALUE);
        r13 = 7;
    L10:
        r12 = r12 + 1;
        goto L5
    L9:
        int r16 = (r11[r14] & UByte.MAX_VALUE) >>> r13;
        int r17 = (r13 + 7) & 7;
        r14 = r14 + 1;
        r10[r12] = (byte) (r16 + ((r11[r14] & ((1 << r17) - 1)) << (8 - r13)));
        r13 = r17;
        goto L10
    L11:
        if (r5 <= 0) goto L13;
        r10[r15] = (byte) ((r11[r14] & UByte.MAX_VALUE) >>> r13);
    L13:
        return r10;
    }

    public static String[] encodeBytes(byte[] r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        if (FORCE_8TO7_ENCODING == true) goto L10;
        String[] r10 = UtfEncodingKt.bytesToStrings(r5);
        if (r10 != null) goto L9;
        $$$reportNull$$$0(1);
    L9:
        return r10;
    L10:
        byte[] r11 = encode8to7(r5);
        addModuloByte(r11, 1);
        return splitBytesToStringArray(r11);
    }

    private static String[] splitBytesToStringArray(byte[] r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        ArrayList r5 = new ArrayList();
        int r11 = r10.length;
        int r12 = 2;
        int r13 = 0;
        int r14 = 0;
        boolean r15 = false;
    L5:
        if (r13 >= r11) goto L18;
        if (r12 < 65534) goto L14;
        String r16 = new String(r10, r14, r13 - r14);
        if (r15 == true) goto L11;
        r5.add("\uffff".concat(r16));
        r15 = true;
    L12:
        r12 = 0;
        r14 = r13;
        goto L14
    L11:
        r5.add(r16);
    L14:
        if (r10[r13] != 0) goto L16;
        r12 = r12 + 2;
    L17:
        r13 = r13 + 1;
        goto L5
    L16:
        r12 = r12 + 1;
        goto L17
    L18:
        if (r12 < 0) goto L20;
        r5.add(new String(r10, r14, r10.length - r14));
    L20:
        String[] r17 = (String[]) r5.toArray(new String[r5.size()]);
        if (r17 != null) goto L23;
        $$$reportNull$$$0(6);
    L23:
        return r17;
    }
}
