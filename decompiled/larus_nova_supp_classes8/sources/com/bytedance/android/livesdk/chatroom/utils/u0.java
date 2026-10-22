package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import io.reactivex.ObservableEmitter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u0 extends BaseBitmapDataSubscriber {
    public final /* synthetic */ ObservableEmitter a;
    public final /* synthetic */ py.k b;

    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r2) {
        if (this.a.isDisposed() == true) goto L6;
        this.a.onError(r2.getFailureCause());
        return;
    }

    public final void onNewResultImpl(Bitmap r4) {
        if (this.a.isDisposed() == true) goto L12;
        if (r4 != null) goto L7;
        this.a.onError(new IllegalStateException("No bitmap loaded for imageModel: " + this.b.toString()));
        return;
    L7:
        Bitmap.Config r0 = r4.getConfig();
        if (r0 != null) goto L10;
        r0 = Bitmap.Config.ARGB_8888;
    L10:
        this.a.onNext(r4.copy(r0, false));
        this.a.onComplete();
        return;
    }

    public u0(ObservableEmitter r1, py.k r2) {
        this.a = r1;
        this.b = r2;
    }
}
