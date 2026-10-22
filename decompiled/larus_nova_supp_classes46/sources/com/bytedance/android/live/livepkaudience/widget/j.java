package com.bytedance.android.live.livepkaudience.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ LinkPkInteractControlWidget a;

    public j(LinkPkInteractControlWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        int r0 = x8.a.a;
        String r1 = this.a.a;
        x8.a.c(r1, (Throwable) r3, false);
    }
}
