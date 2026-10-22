package com.bytedance.android.ec.core.imagex;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y<T> implements ObservableOnSubscribe {
    public final /* synthetic */ List a;
    public final /* synthetic */ r b;

    public y(List r1, u r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void subscribe(ObservableEmitter<File> r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        ImageExtensionsKt.b(this.a, 0, this.b, r10);
    }
}
