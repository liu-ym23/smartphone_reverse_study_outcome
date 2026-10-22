package com.bytedance.android.live.core.utils;

import android.graphics.Bitmap;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n2<T> implements ObservableOnSubscribe {
    public final /* synthetic */ DataSource a;
    public final /* synthetic */ py.k b;

    public static final class a extends BaseBitmapDataSubscriber {
        public final /* synthetic */ n2 a;
        public final /* synthetic */ ObservableEmitter b;

        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r2) {
            Intrinsics.checkNotNullParameter(r2, "dataSource");
            if (this.b.isDisposed() == true) goto L6;
            ObservableEmitter r0 = this.b;
            Throwable r3 = r2.getFailureCause();
            Intrinsics.checkNotNull(r3);
            r0.onError(r3);
            return;
        }

        public final void onNewResultImpl(Bitmap r4) {
            if (this.b.isDisposed() == true) goto L9;
            if (r4 != null) goto L7;
            this.b.onError(new IllegalStateException("No bitmap loaded for imageModel: " + this.a.b));
            return;
        L7:
            this.b.onNext(r4);
            this.b.onComplete();
            return;
        }

        public a(n2 r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public n2(DataSource r1, py.k r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<Bitmap> r3) {
        Intrinsics.checkNotNullParameter(r3, "subscriber");
        a r0 = new a(this, r3);
        this.a.subscribe(r0, TTExecutors.getNormalExecutor());
    }
}
