package com.ss.android.lark.image.uploader.upload;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g extends com.ss.android.lark.utils.rxjava.d<com.ss.android.lark.image.uploader.entity.b> {
    public final /* synthetic */ ImageUploadTask a;

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onComplete() {
        int r0 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "Upload end");
        dlb.a r1 = this.a.f;
        if (r1 == null) goto L6;
        r1.h();
        return;
    }

    public g(ImageUploadTask r1) {
        this.a = r1;
    }

    public final void a(Throwable r4) {
        if ((r4 instanceof ErrorResult) == false) goto L7;
        dlb.a r0 = this.a.f;
        if (r0 == null) goto L11;
        ErrorResult r5 = (ErrorResult) r4;
        r0.i(r5.getCode(), r5.getDisplayMsg());
        return;
    L11:
        return;
    L7:
        int r1 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.b("ImageUploadManager", "pass upload error event, th:" + r4, null, false);
        dlb.a r6 = this.a.f;
        if (r6 == null) goto L13;
        r6.i(-10006, "");
        return;
    }

    public final void onNext(Object r3) {
        com.ss.android.lark.image.uploader.entity.b r4 = (com.ss.android.lark.image.uploader.entity.b) r3;
        Intrinsics.checkNotNullParameter(r4, "uploadImage");
        int r0 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "pass upload success event, image:" + r4);
        dlb.a r1 = this.a.f;
        if (r1 == null) goto L6;
        r1.k(r4, r4.l);
        return;
    }
}
