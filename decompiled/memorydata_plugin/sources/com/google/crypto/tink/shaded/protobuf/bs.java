package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final class bs {

    private interface a {
        byte a(int r1);

        int a();
    }

    static String a(final ByteString r1) {
        return a(new AnonymousClass1(r1));
    }

    static String a(a r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder(r6.a());
        int r1 = 0;
    L4:
        if (r1 >= r6.a()) goto L32;
        int r2 = r6.a(r1);
        if (r2 != 34) goto L8;
        String r3 = "\\\"";
    L26:
        r0.append(r3);
    L30:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r2 != 39) goto L10;
        r3 = "\\'";
        goto L26
    L10:
        if (r2 == 92) goto L27;
        switch(r2) {
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
        r3 = "\\r";
        goto L26
    L20:
        r3 = "\\f";
        goto L26
    L21:
        r3 = "\\v";
        goto L26
    L22:
        r3 = "\\n";
        goto L26
    L23:
        r3 = "\\t";
        goto L26
    L24:
        r3 = "\\b";
        goto L26
    L25:
        r3 = "\\a";
        goto L26
    L13:
        if (r2 >= 32) goto L15;
    L17:
        r0.append('\\');
        r0.append((char) (((r2 >>> 6) & 3) + 48));
        r0.append((char) (((r2 >>> 3) & 7) + 48));
        r2 = (r2 & 7) + 48;
    L18:
        r0.append((char) r2);
        goto L30
    L15:
        if (r2 > 126) goto L17;
    L27:
        r3 = "\\\\";
        goto L26
    L32:
        return r0.toString();
    }

    static String a(String r0) {
        return a(ByteString.copyFromUtf8(r0));
    }
}
