package com.lynx.clay.embedding.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k extends View {
    public Bitmap a;
    public Runnable b;

    public k(Context r1) {
        super(r1);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        super.onDraw(r6);
        Bitmap r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRecycled() == true) goto L13;
        r6.drawBitmap(this.a, null, new Rect(0, 0, getWidth(), getHeight()), null);
        Runnable r7 = this.b;
        if (r7 == null) goto L12;
        this.b = null;
        r7.run();
        return;
    L12:
        return;
    }
}
