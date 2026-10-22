package com.bytedance.android.live.broadcastgame.channel;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ ContinuousTimeTicker a;

    public b(ContinuousTimeTicker r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ALogger.e("AAM.ContinuousTimeTicker", "[" + this.a.f + "]@{" + this.a.hashCode() + "} sender error: " + ((Throwable) r3));
    }
}
