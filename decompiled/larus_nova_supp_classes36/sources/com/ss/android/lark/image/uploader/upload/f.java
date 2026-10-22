package com.ss.android.lark.image.uploader.upload;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f<T, R> implements Function {
    public final /* synthetic */ e a;

    public f(e r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        com.ss.android.lark.image.uploader.entity.b r4 = (com.ss.android.lark.image.uploader.entity.b) r3;
        Intrinsics.checkNotNullParameter(r4, "uploadImage");
        int r1 = h.a;
        e r2 = this.a;
        Intrinsics.checkNotNullParameter(r4, "uploadImage");
        Intrinsics.checkNotNullParameter(r2, "uploader");
        return Observable.create(new ImageUploadManager$wrapUploader$1(r4, r2));
    }
}
