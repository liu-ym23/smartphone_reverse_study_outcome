package com.bytedance.android.livesdk.interactivity.like;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a1<T> implements Consumer {
    public final /* synthetic */ x0 a;

    public a1(x0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Set<Bitmap> r0 = this.a.i;
        r0.add((Bitmap) r2);
    }
}
