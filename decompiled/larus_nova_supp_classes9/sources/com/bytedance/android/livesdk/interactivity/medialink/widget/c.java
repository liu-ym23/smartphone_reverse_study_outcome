package com.bytedance.android.livesdk.interactivity.medialink.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ MediaLinkControlPresenter a;

    public c(MediaLinkControlPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        if (r3 == null) goto L6;
        this.a.f0(r3);
        return;
    }
}
