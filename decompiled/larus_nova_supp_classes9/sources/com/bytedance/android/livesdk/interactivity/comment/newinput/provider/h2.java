package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h2<T> implements Consumer {
    public final /* synthetic */ t1.c a;

    public h2(t1.c r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        MainThreadPostUtils.e(new g2(this));
    }
}
