package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
final class TextFormatEscaper {

    private interface ByteSequence {
        byte byteAt(int r10);

        int size();
    }

    private TextFormatEscaper() {
    }

    static String escapeBytes(final ByteString r10) {
        return escapeBytes(new AnonymousClass1(r10));
    }

    static String escapeBytes(ByteSequence r10) {
        StringBuilder r11 = new StringBuilder(r10.size());
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L32;
        int r13 = r10.byteAt(r12);
        if (r13 != 34) goto L8;
        String r14 = "\\\"";
    L26:
        r11.append(r14);
    L30:
        r12 = r12 + 1;
        goto L4
    L8:
        if (r13 != 39) goto L10;
        r14 = "\\'";
        goto L26
    L10:
        if (r13 == 92) goto L27;
        switch(r13) {
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
        r14 = "\\r";
        goto L26
    L20:
        r14 = "\\f";
        goto L26
    L21:
        r14 = "\\v";
        goto L26
    L22:
        r14 = "\\n";
        goto L26
    L23:
        r14 = "\\t";
        goto L26
    L24:
        r14 = "\\b";
        goto L26
    L25:
        r14 = "\\a";
        goto L26
    L13:
        if (r13 >= 32) goto L15;
    L17:
        r11.append('\\');
        r11.append((char) (((r13 >>> 6) & 3) + 48));
        r11.append((char) (((r13 >>> 3) & 7) + 48));
        r13 = (r13 & 7) + 48;
    L18:
        r11.append((char) r13);
        goto L30
    L15:
        if (r13 > 126) goto L17;
    L27:
        r14 = "\\\\";
        goto L26
    L32:
        return r11.toString();
    }

    static String escapeBytes(final byte[] r10) {
        return escapeBytes(new AnonymousClass2(r10));
    }

    static String escapeDoubleQuotesAndBackslashes(String r10) {
        return r10.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    static String escapeText(String r10) {
        return escapeBytes(ByteString.copyFromUtf8(r10));
    }
}
