package com.bytedance.android.live.livepkaudience.presenter;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Function1 c;

    public e(b r1, int r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r2) {
        com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
        ALogger.i(this.a.e, "update sort setting success");
        this.c.invoke(Integer.valueOf(this.b));
    }
}
