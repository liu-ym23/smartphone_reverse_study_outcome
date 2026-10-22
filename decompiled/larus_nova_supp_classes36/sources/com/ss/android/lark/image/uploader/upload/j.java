package com.ss.android.lark.image.uploader.upload;

import com.ss.android.lark.image.entity.LoadParams;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class j implements e {
    public j() {
    }

    @Override // com.ss.android.lark.image.uploader.upload.e
    public final boolean b() {
        return false;
    }

    @Override // com.ss.android.lark.image.uploader.upload.e
    public final void c(List r2, ImageUploadManager$batchUpload$1 r3) {
        Intrinsics.checkNotNullParameter(r2, LoadParams.ImageFormat.IMAGE);
        Intrinsics.checkNotNullParameter(r3, "callback");
    }
}
