package com.bytedance.android.live.broadcastgame.channel;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ ContinuousTimeTicker a;

    public a(ContinuousTimeTicker r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        ALogger.d("AAM.ContinuousTimeTicker", "[" + this.a.f + "]@{" + this.a.hashCode() + "} Tick " + r5);
        this.a.c = System.currentTimeMillis();
        Function1<? super Long, Unit> r0 = this.a.a;
        if (r0 == null) goto L6;
        Unit r6 = (Unit) r0.invoke(r5);
        return;
    }
}
