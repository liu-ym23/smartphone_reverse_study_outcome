package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
final class TextFormatEscaper {

    public interface ByteSequence {
        byte byteAt(int r8);

        int size();
    }

    private TextFormatEscaper() {
    }

    public static String escapeBytes(final ByteString r8) {
        return escapeBytes(new AnonymousClass1(r8));
    }

    public static String escapeDoubleQuotesAndBackslashes(String r8) {
        return r8.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    public static String escapeText(String r8) {
        return escapeBytes(ByteString.copyFromUtf8(r8));
    }

    public static String escapeBytes(ByteSequence r8) {
        StringBuilder r10 = new StringBuilder(r8.size());
        int r11 = 0;
    L4:
        if (r11 >= r8.size()) goto L32;
        int r12 = r8.byteAt(r11);
        if (r12 != 34) goto L8;
        String r13 = "\\\"";
    L26:
        r10.append(r13);
    L30:
        r11 = r11 + 1;
        goto L4
    L8:
        if (r12 != 39) goto L10;
        r13 = "\\'";
        goto L26
    L10:
        if (r12 == 92) goto L27;
        switch(r12) {
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            default: goto L13;
        };
    L19:
        r13 = "\\r";
        goto L26
    L20:
        r13 = "\\f";
        goto L26
    L21:
        r13 = "\\v";
        goto L26
    L22:
        r13 = "\\n";
        goto L26
    L23:
        r13 = "\\t";
        goto L26
    L24:
        r13 = "\\b";
        goto L26
    L25:
        r13 = "\\a";
        goto L26
    L13:
        if (r12 >= 32) goto L15;
    L17:
        r10.append('\\');
        r10.append((char) (((r12 >>> 6) & 3) + 48));
        r10.append((char) (((r12 >>> 3) & 7) + 48));
        r12 = (r12 & 7) + 48;
    L18:
        r10.append((char) r12);
        goto L30
    L15:
        if (r12 > 126) goto L17;
    L27:
        r13 = "\\\\";
        goto L26
    L32:
        return r10.toString();
    }

    public static String escapeBytes(final byte[] r8) {
        return escapeBytes(new AnonymousClass2(r8));
    }
}
