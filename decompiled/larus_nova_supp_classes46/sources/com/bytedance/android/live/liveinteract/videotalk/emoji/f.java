package com.bytedance.android.live.liveinteract.videotalk.emoji;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ d a;

    public f(d r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        Intrinsics.checkNotNullParameter(r3, "throwable");
        r3.printStackTrace();
        d.a r0 = (d.a) ((q46.b) this.a).a;
        if (r0 == null) goto L6;
        r0.G3(r3);
        return;
    }
}
