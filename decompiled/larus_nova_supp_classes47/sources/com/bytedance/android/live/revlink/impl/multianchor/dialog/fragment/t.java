package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ View a;

    public t(View r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Bitmap r4 = (Bitmap) r3;
        View r0 = this.a;
        if (r0 == null) goto L6;
        r0.setBackground(new BitmapDrawable(r4));
        return;
    }
}
