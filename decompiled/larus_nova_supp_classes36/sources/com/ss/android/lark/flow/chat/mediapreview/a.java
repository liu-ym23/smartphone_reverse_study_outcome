package com.ss.android.lark.flow.chat.mediapreview;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.log.Log;
import kotlin.Result;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends SimpleTarget<Bitmap> {
    public final /* synthetic */ long a;
    public final /* synthetic */ i<Bitmap> b;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r2) {
        if (this.b.isActive() == false) goto L6;
        this.b.resumeWith(Result.constructor-impl(null));
        return;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r5) {
        Bitmap r6 = (Bitmap) r5;
        Log.i("FlowPreviewImageView", "get preview resource success, costTime: " + (System.currentTimeMillis() - this.a));
        if (this.b.isActive() == false) goto L6;
        this.b.resumeWith(Result.constructor-impl(r6));
        return;
    }

    public a(long r1, j r3) {
        this.a = r1;
        this.b = r3;
    }
}
