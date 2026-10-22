package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.logging.FLog;
import com.facebook.imageutils.BitmapUtil;

/* JADX INFO: loaded from: classes2.dex */
public class BitmapPoolBackend extends LruBucketsPoolBackend<Bitmap> {
    public BitmapPoolBackend() {
    }

    public final void b(Object r5) {
        Bitmap r10 = (Bitmap) r5;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.isRecycled() == false) goto L10;
        FLog.a("BitmapPoolBackend", "Cannot reuse a recycled bitmap: %s", new Object[]{r10});
        return;
    L10:
        if (r10.isMutable() == true) goto L13;
        FLog.a("BitmapPoolBackend", "Cannot reuse an immutable bitmap: %s", new Object[]{r10});
        return;
    L13:
        monitor-enter(this);
        boolean r11 = this.f8225a.add(r10);     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        if (r11 == false) goto L24;
        this.f8226b.a(BitmapUtil.a(r10), r10);
        return;
    L24:
        return;
    L19:
        th = move-exception;
        throw th;
    }
}
