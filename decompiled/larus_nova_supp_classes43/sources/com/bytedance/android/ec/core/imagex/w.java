package com.bytedance.android.ec.core.imagex;

import android.graphics.Bitmap;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w<T> implements ObservableOnSubscribe {
    public final /* synthetic */ List a;
    public final /* synthetic */ r b;

    public w(List r1, u r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void subscribe(ObservableEmitter<Bitmap> r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        ImageExtensionsKt.a(this.a, 0, this.b, r10);
    }
}
