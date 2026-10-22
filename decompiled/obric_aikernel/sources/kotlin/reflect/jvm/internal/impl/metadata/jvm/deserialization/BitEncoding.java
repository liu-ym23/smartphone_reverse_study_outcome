package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

/* JADX INFO: loaded from: classes3.dex */
public class BitEncoding {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean FORCE_8TO7_ENCODING = false;

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
        r12[1] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
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
        r12[0] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
    L21:
        r11 = 2;
    L11:
        r10 = "@NotNull method %s.%s must not return null";
        goto L13
    }

    static {
        String r10 = System.getProperty("kotlin.jvm.serialization.use8to7");     // Catch: SecurityException -> L4
    L5:
        FORCE_8TO7_ENCODING = "true".equals(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    private BitEncoding() {
    }

    private static void addModuloByte(byte[] r10, int r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        int r12 = 0;
        int r13 = r10.length;
    L5:
        if (r12 >= r13) goto L7;
        r10[r12] = (byte) ((r10[r12] + r11) & 127);
        r12 = r12 + 1;
        goto L5
    }

    private static byte[] combineStringArrayIntoBytes(String[] r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(11);
    L4:
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L5:
        if (r12 >= r11) goto L7;
        r13 = r13 + r10[r12].length();
        r12 = r12 + 1;
        goto L5
    L7:
        byte[] r14 = new byte[r13];
        int r15 = r10.length;
        int r16 = 0;
        int r17 = 0;
    L8:
        if (r16 >= r15) goto L13;
        String r18 = r10[r16];
        int r19 = r18.length();
        int r20 = 0;
    L10:
        if (r20 >= r19) goto L12;
        r14[r17] = (byte) r18.charAt(r20);
        r20 = r20 + 1;
        r17 = r17 + 1;
        goto L10
    L12:
        r16 = r16 + 1;
        goto L8
    L13:
        return r14;
    }

    private static byte[] decode7to8(byte[] r11) {
        if (r11 != null) goto L4;
        $$$reportNull$$$0(13);
    L4:
        int r10 = (r11.length * 7) / 8;
        byte[] r12 = new byte[r10];
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L5:
        if (r13 >= r10) goto L11;
        int r16 = (r11[r14] & 255) >>> r15;
        r14 = r14 + 1;
        int r17 = r15 + 1;
        r12[r13] = (byte) (r16 + ((r11[r14] & ((1 << r17) - 1)) << (7 - r15)));
        if (r15 != 6) goto L9;
        r14 = r14 + 1;
        r15 = 0;
    L10:
        r13 = r13 + 1;
        goto L5
    L9:
        r15 = r17;
        goto L10
    L11:
        return r12;
    }

    public static byte[] decodeBytes(String[] r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        if (r10.length > 0) goto L7;
    L17:
        byte[] r11 = combineStringArrayIntoBytes(r10);
        addModuloByte(r11, 127);
        return decode7to8(r11);
    L7:
        if (r10[0].isEmpty() == true) goto L17;
        char r12 = r10[0].charAt(0);
        if (r12 != 0) goto L15;
        byte[] r13 = UtfEncodingKt.stringsToBytes(dropMarker(r10));
        if (r13 != null) goto L13;
        $$$reportNull$$$0(8);
    L13:
        return r13;
    L15:
        if (r12 != 65535) goto L17;
        r10 = dropMarker(r10);
        goto L17
    }

    private static String[] dropMarker(String[] r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        String[] r11 = (String[]) r10.clone();
        r11[0] = r11[0].substring(1);
        return r11;
    }
}
