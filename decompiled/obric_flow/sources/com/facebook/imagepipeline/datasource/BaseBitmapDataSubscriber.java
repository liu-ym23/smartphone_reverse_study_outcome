package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseBitmapDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    public BaseBitmapDataSubscriber() {
    }

    public abstract void a(Bitmap r5);

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void e(DataSource r5) {
        AbstractDataSource r10 = (AbstractDataSource) r5;
        if (r10.f() == false) goto L30;
        CloseableReference r11 = (CloseableReference) r10.getResult();
        if (r11 == null) goto L16;
        monitor-enter(r11);
        Object r12 = r11.f7671b.d();     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        if ((r12 instanceof CloseableBitmap) == false) goto L16;
        Bitmap r13 = ((CloseableStaticBitmap) ((CloseableBitmap) r11.c())).g;
    L25:
        a(r13);     // Catch: Throwable -> L21
        if (r11 == null) goto L29;
        r11.close();
        return;
    L29:
        return;
    L21:
        th = move-exception;
        if (r11 == null) goto L24;
        r11.close();
    L24:
        throw th;
    L13:
        th = move-exception;
        throw th;
    L16:
        r13 = null;
        goto L25
    }
}
