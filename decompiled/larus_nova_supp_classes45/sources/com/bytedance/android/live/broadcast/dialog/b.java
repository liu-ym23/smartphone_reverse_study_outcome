package com.bytedance.android.live.broadcast.dialog;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ PosterGenerateDialog a;

    public b(PosterGenerateDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if (((Boolean) r2).booleanValue() == false) goto L5;
        this.a.g = false;
        f2.c(s1.B(2131915037), 0);
        return;
    L5:
        this.a.g = false;
        f2.c(s1.B(2131915035), 0);
    }
}
