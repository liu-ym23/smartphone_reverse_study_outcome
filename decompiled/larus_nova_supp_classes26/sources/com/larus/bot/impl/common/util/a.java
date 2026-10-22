package com.larus.bot.impl.common.util;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends BaseBitmapDataSubscriber {
    public final /* synthetic */ kotlinx.coroutines.i<Bitmap> a;

    public a(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r2) {
        Intrinsics.checkNotNullParameter(r2, "dataSource");
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(null));
        return;
    }

    public final void onNewResultImpl(Bitmap r2) {
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r2));
        return;
    }
}
