package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ k a;

    public j(k r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Bitmap r5 = (Bitmap) r4;
        View r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.setBackground(new BitmapDrawable(this.a.getContext().getResources(), r5));
        return;
    }
}
