package com.bytedance.android.ec.core.utils;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f0 extends BaseBitmapDataSubscriber {
    public final /* synthetic */ DataSource a;
    public final /* synthetic */ o b;

    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r10) {
        if (r10 == null) goto L4;
        r10.close();
    L4:
        this.b.accept(null);
    }

    public final void onNewResultImpl(Bitmap r10) {
        if (this.a.isFinished() == false) goto L6;
        if (r10 == null) goto L6;
        Bitmap r11 = Bitmap.createBitmap(r10);
        this.b.accept(r11);
        this.a.close();
        return;
    L6:
        this.b.accept(null);
    }

    public f0(DataSource r1, o r10) {
        this.a = r1;
        this.b = r10;
    }
}
