package com.bytedance.android.live.broadcastgame.opengame.behavior;

import com.bytedance.android.live.broadcastgame.opengame.message.f0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ g a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function1 c;

    public m(g r1, Function0 r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r2) {
        f0 r3 = (f0) r2;
        this.a.getClass();
        if (tb1.c.a == false) goto L8;
        if (r3 == null) goto L8;
        if (r3.x == true) goto L8;
        this.b.invoke();
        return;
    L8:
        this.c.invoke("preload not support");
    }
}
