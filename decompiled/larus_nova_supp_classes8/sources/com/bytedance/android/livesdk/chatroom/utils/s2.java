package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s2<T> implements Consumer {
    public final /* synthetic */ a4 a;
    public final /* synthetic */ View b;

    public s2(SkinLoader$loopLoadImg$2 r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Bitmap r5 = (Bitmap) r4;
        if (r5 != null) goto L5;
    L11:
        a4 r6 = this.a;
        if (r6 == null) goto L16;
        r6.b(SkinLoadResultType.ERROR, "bitmap is null");
        return;
    L16:
        return;
    L5:
        if (r5.isRecycled() == true) goto L11;
        a4 r0 = this.a;
        if (r0 == null) goto L10;
        r0.b(SkinLoadResultType.SUCCESS, "");
    L10:
        this.b.setBackground(new BitmapDrawable(r5));
    }
}
