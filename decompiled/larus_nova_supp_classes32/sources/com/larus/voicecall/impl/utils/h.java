package com.larus.voicecall.impl.utils;

import android.graphics.Bitmap;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h implements Function1<Bitmap, Unit> {
    public final /* synthetic */ kotlinx.coroutines.i<Bitmap> a;

    public h(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Bitmap r4 = (Bitmap) r3;
        if (r4 != null) goto L5;
        FLogger.a.e("getBitmapFromUrl", "return null bitmap");
        if (this.a.isActive() == false) goto L11;
        this.a.resumeWith(Result.constructor-impl(null));
    L11:
        return Unit.INSTANCE;
    L5:
        if (this.a.isActive() == false) goto L11;
        this.a.resumeWith(Result.constructor-impl(r4));
        goto L11
    }
}
