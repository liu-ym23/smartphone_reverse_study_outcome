package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ hk6.b.a a;

    public f(hk6.d r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        this.a.a(r4.getMessage(), r4);
    }
}
