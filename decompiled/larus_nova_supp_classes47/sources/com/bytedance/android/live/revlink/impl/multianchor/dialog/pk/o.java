package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ View a;

    public o(View r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        this.a.setBackground(new BitmapDrawable((Bitmap) r3));
    }
}
