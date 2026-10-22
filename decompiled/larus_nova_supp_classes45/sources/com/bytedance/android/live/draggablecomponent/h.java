package com.bytedance.android.live.draggablecomponent;

import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ TextView a;

    public h(TextView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.setText((CharSequence) sh6.c.b((sh6.b) r2));
    }
}
