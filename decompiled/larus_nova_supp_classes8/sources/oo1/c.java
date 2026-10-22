package oo1;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static void a(ByteBuffer r2, ByteBuffer r3) {
        float r4 = r2.getFloat();
        if (r4 >= (-1.0f)) goto L6;
        r4 = -1.0f;
    L8:
        r3.putShort((short) (r4 * 32767.0f));
        return;
    L6:
        if (r4 <= 1.0f) goto L8;
        r4 = 1.0f;
        goto L8
    }
}
