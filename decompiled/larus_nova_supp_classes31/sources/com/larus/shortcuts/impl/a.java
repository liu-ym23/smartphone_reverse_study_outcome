package com.larus.shortcuts.impl;

import android.graphics.Bitmap;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements Function1<Bitmap, Unit> {
    public final /* synthetic */ i<Bitmap> a;

    public a(j r1) {
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
