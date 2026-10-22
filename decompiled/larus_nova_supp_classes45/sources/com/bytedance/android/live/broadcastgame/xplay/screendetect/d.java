package com.bytedance.android.live.broadcastgame.xplay.screendetect;

import android.graphics.Bitmap;
import android.view.PixelCopy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements PixelCopy.OnPixelCopyFinishedListener {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Bitmap b;

    public d(Function1 r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r4) {
        if (r4 != 0) goto L7;
        e.f.getClass();
        Function1<? super String, Unit> r5 = e.e;
        if (r5 == null) goto L6;
        Unit r6 = (Unit) r5.invoke("PixelCopy success");
    L6:
        this.a.invoke(this.b);
        return;
    L7:
        e.f.getClass();
        Function1<? super String, Unit> r0 = e.e;
        if (r0 == null) goto L10;
        Unit r7 = (Unit) r0.invoke("PixelCopy failed, errcode: " + r4);
    L10:
        this.a.invoke(null);
    }
}
