package com.bytedance.android.ec.core.utils;

import android.graphics.Bitmap;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x1<T> implements ObservableOnSubscribe {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;

    public static final class a<T> implements o {
        public final /* synthetic */ x1 a;
        public final /* synthetic */ ObservableEmitter b;

        public a(x1 r1, ObservableEmitter r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // com.bytedance.android.ec.core.utils.o
        public final void accept(Object r10) {
            Bitmap r11 = (Bitmap) r10;
            if (this.b.isDisposed() == true) goto L8;
            if (r11 != null) goto L6;
            this.b.onError(new Throwable("load remote url fails: " + this.a.a));
            return;
        L6:
            ObservableEmitter r0 = this.b;
            x1 r12 = this.a;
            r0.onNext(new m1(r12.b, r11, r12.a));
            this.b.onComplete();
            return;
        }
    }

    public x1(String r1, int r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void subscribe(ObservableEmitter<m1> r10) {
        Intrinsics.checkNotNullParameter(r10, "emitter");
        ECLiveImageUtils.f(this.a, new a(this, r10));
    }
}
