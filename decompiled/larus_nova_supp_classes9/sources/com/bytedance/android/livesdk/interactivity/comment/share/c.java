package com.bytedance.android.livesdk.interactivity.comment.share;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        a.InterfaceC0145a r3 = (a.InterfaceC0145a) ((q46.b) this.a).a;
        if (r3 == null) goto L6;
        r3.y10();
        return;
    }
}
