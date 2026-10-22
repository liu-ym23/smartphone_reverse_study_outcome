package com.bytedance.android.livesdk.drawer.drawerlynx;

import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        f2.b(2131915628, 0);
        this.a.finishWithFailure();
    }
}
