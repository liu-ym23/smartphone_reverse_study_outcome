package org.bouncycastle.pqc.legacy.crypto.qtesla;

/* JADX INFO: loaded from: classes7.dex */
public class QTESLASecurityCategory {
    public static String getName(int r3) {
        if (r3 != 5) goto L5;
        return "qTESLA-p-I";
    L5:
        if (r3 != 6) goto L9;
        return "qTESLA-p-III";
    L9:
        throw new IllegalArgumentException("unknown security category: " + r3);
    }

    static int getPrivateSize(int r3) {
        if (r3 != 5) goto L5;
        return 5224;
    L5:
        if (r3 != 6) goto L9;
        return 12392;
    L9:
        throw new IllegalArgumentException("unknown security category: " + r3);
    }

    static int getPublicSize(int r3) {
        if (r3 != 5) goto L5;
        return 14880;
    L5:
        if (r3 != 6) goto L9;
        return 38432;
    L9:
        throw new IllegalArgumentException("unknown security category: " + r3);
    }
}
