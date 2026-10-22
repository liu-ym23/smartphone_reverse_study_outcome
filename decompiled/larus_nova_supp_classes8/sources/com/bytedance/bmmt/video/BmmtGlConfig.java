package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class BmmtGlConfig {
    private static volatile int texture2DGlFormat = 6408;

    private BmmtGlConfig() {
    }

    public static int getTexture2DGlFormat() {
        int r0 = texture2DGlFormat;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("texture2DGlFormat not set");
    }

    public static void setTexture2DGlFormat(int r3) {
        if (r3 != 6408) goto L5;
    L11:
        texture2DGlFormat = r3;
        return;
    L5:
        if (r3 == 6407) goto L11;
        if (r3 == 6409) goto L11;
        throw new IllegalArgumentException("Unsupported glFormat: " + r3);
    }
}
