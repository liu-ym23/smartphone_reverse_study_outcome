package com.bytedance.android.live.lynx.ui;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends BaseBitmapDataSubscriber {
    public final /* synthetic */ LynxLottieView.a a;
    public final /* synthetic */ CountDownLatch b;
    public final /* synthetic */ DataSource c;

    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r2) {
        this.a.onFailed();
        if (r2 == null) goto L5;
        r2.close();
    L5:
        this.b.countDown();
    }

    public final void onNewResultImpl(Bitmap r2) {
        if (this.c.isFinished() == false) goto L8;
        if (r2 == null) goto L8;
        this.a.onSuccess(r2);
        DataSource r3 = this.c;
        if (r3 == null) goto L8;
        r3.close();
    L8:
        this.b.countDown();
    }

    public l(LynxLottieView.c r1, CountDownLatch r2, DataSource r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
