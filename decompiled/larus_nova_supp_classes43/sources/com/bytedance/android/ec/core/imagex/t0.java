package com.bytedance.android.ec.core.imagex;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class t0 extends BaseBitmapDataSubscriber {
    public final DataSource<CloseableReference<CloseableImage>> a;

    public abstract void a(Bitmap r1);

    public t0(DataSource<CloseableReference<CloseableImage>> r10) {
        Intrinsics.checkNotNullParameter(r10, "dataSource");
        this.a = r10;
    }

    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Boolean r1 = null;
        a(null);     // Catch: Throwable -> L7
        if (r10 == null) goto L5;
        r1 = Boolean.valueOf(r10.close());     // Catch: Throwable -> L7
    L5:
        Result.constructor-impl(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void onNewResultImpl(Bitmap r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        if (this.a.isFinished() == false) goto L6;
        if (r10 == null) goto L6;
        a(Bitmap.createBitmap(r10));     // Catch: Throwable -> L9
        Boolean r11 = Boolean.valueOf(this.a.close());     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r11);     // Catch: Throwable -> L9
        return;
    L6:
        a(null);     // Catch: Throwable -> L9
        r11 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
