package com.bytedance.android.anniex.detect.detection;

import android.graphics.Bitmap;
import android.view.PixelCopy;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements PixelCopy.OnPixelCopyFinishedListener {
    public final /* synthetic */ StringBuilder a;
    public final /* synthetic */ Continuation<Bitmap> b;
    public final /* synthetic */ Bitmap c;

    public a(StringBuilder r1, SafeContinuation r10, Bitmap r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r10) {
        if (r10 != 0) goto L5;
        StringBuilder r11 = this.a;
        r11.append("PixelCopy SUCCESS and scaled at draw time");
        r11.append('\n');
        Continuation<Bitmap> r12 = this.b;
        Result.Companion r0 = Result.Companion;
        r12.resumeWith(Result.constructor-impl(this.c));
        return;
    L5:
        StringBuilder r1 = this.a;
        r1.append("PixelCopy FAILED: " + r10);
        r1.append('\n');
        this.b.resumeWith(Result.constructor-impl(null));
    }
}
