package com.lynx.clay.embedding.engine.loader;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import com.lynx.serval.svg.SVGRender;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SVGDom {
    private static SVGRender svgRender;
    private String content;

    public SVGDom(ByteBuffer r2) {
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (svgRender != null) goto L6;
        svgRender = new SVGRender();     // Catch: OutOfMemoryError -> L8 Exception -> L10
    L6:
        this.content = StandardCharsets.UTF_8.decode(r2).toString();     // Catch: OutOfMemoryError -> L8 Exception -> L10
    }

    public static SVGDom create(ByteBuffer r1) {
        return new SVGDom(r1);
    }

    public Bitmap render(int r5, int r6) {
        Picture r0 = svgRender.renderPicture(this.content, new Rect(0, 0, r5, r6));
        Bitmap r7 = Bitmap.createBitmap(r5, r6, Bitmap.Config.ARGB_8888);
        Canvas r8 = new Canvas(r7);
        r8.drawARGB(0, 0, 0, 0);
        r8.drawPicture(r0);
        return r7;
    }
}
