package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T, R> implements Function {
    public final /* synthetic */ k a;

    public j(k r1) {
        this.a = r1;
    }

    public final Object apply(Object r6) {
        Throwable r7 = (Throwable) r6;
        Intrinsics.checkNotNullParameter(r7, "error");
        int r0 = this.a.a.incrementAndGet();
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("ChatChannelEmojiManager retry " + r0 + " times");
        if (r0 <= 3) goto L6;
        return Observable.error(r7);
    L6:
        return Observable.timer(((long) r0) * 2, TimeUnit.SECONDS);
    }
}
