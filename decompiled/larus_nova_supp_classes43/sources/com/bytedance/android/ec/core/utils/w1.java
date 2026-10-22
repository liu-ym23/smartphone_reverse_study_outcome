package com.bytedance.android.ec.core.utils;

import android.graphics.Bitmap;
import com.bytedance.android.ec.model.ECUrlModel;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w1<T> implements ObservableOnSubscribe {
    public final /* synthetic */ ECUrlModel a;
    public final /* synthetic */ int b;

    public static final class a<T> implements y.c {
        public final /* synthetic */ w1 a;
        public final /* synthetic */ ObservableEmitter b;

        public a(w1 r1, ObservableEmitter r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // com.bytedance.android.ec.core.utils.y.c
        public final void accept(Object r10) {
            Bitmap r11 = (Bitmap) r10;
            if (this.b.isDisposed() == true) goto L8;
            if (r11 != null) goto L6;
            this.b.onError(new Throwable("load remote url fails"));
            return;
        L6:
            this.b.onNext(new m1(this.a.b, r11, null));
            this.b.onComplete();
            return;
        }
    }

    public w1(ECUrlModel r1, int r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void subscribe(ObservableEmitter<m1> r10) {
        Intrinsics.checkNotNullParameter(r10, "emitter");
        y.l(this.a, 0, 0, new a(this, r10));
    }
}
