package com.bytedance.android.live.broadcastgame.opengame.performance;

import com.bytedance.android.live.broadcastgame.opengame.network.j0;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Function2 b;

    public d(Function1 r1, Function2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
        Object r0 = ((ExtraResponse) r6).data;
        if (r0 != null) goto L5;
        this.a.invoke(1);
        return;
    L5:
        j0 r1 = (j0) r0;
        if (r1.canStop == false) goto L8;
        this.a.invoke(Integer.valueOf(r1.status));
        return;
    L8:
        this.b.invoke(Integer.valueOf(r1.status), Long.valueOf(((j0) ((ExtraResponse) r6).data).minRunMinute));
    }
}
