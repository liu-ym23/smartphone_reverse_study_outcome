package com.bytedance.android.livesdk.interactivity.like;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ DiggWidget.c a;

    public m(DiggWidget.c r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.a = (Bitmap) r2;
    }
}
