package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ TextView a;

    public q(TextView r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        this.a.setBackground(new BitmapDrawable((Bitmap) r3));
    }
}
