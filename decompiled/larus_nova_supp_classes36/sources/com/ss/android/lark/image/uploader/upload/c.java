package com.ss.android.lark.image.uploader.upload;

import com.ss.android.lark.image.entity.LoadParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class c implements e {
    public c() {
    }

    @Override // com.ss.android.lark.image.uploader.upload.e
    public final void a(com.ss.android.lark.image.uploader.entity.b r2, ImageUploadManager$wrapUploader$1.AnonymousClass1 r3) {
        Intrinsics.checkNotNullParameter(r2, LoadParams.ImageFormat.IMAGE);
        Intrinsics.checkNotNullParameter(r3, "callback");
    }

    @Override // com.ss.android.lark.image.uploader.upload.e
    public final boolean b() {
        return true;
    }
}
