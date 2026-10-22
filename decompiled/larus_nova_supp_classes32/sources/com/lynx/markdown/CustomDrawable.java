package com.lynx.markdown;

import android.graphics.Canvas;
import com.lynx.textra.BBufferInputStream;
import com.lynx.textra.TTTextDefinition;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CustomDrawable {
    public CustomDrawable() {
    }

    public static native void align(long r0, float r2, float r3);

    public static native long measure(long r0, float r2, int r3, float r4, int r5);

    private static native byte[] nativeDrawCustomDrawable(long r0);

    public static void a(long r0, Canvas r2, h r3) {
        byte[] r1 = nativeDrawCustomDrawable(r0);
        f r4 = new f(r2, r3);
        BBufferInputStream r5 = new BBufferInputStream(r1);
    L13:
        if (r5.available() <= 0) goto L21;
        byte r6 = r5.readByte();     // Catch: IOException -> L10
        if (r6 == (-1)) goto L7;
        r4.drawOp(TTTextDefinition.GetCanvasOp(r6), r5);     // Catch: IOException -> L10
        goto L13
    L7:
        r4.b(r5);     // Catch: IOException -> L10
        goto L13
    L21:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }
}
