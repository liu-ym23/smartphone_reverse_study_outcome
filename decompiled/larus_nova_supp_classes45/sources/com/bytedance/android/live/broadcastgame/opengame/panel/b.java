package com.bytedance.android.live.broadcastgame.opengame.panel;

import com.bytedance.android.live.broadcastgame.opengame.q;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Ref.ObjectRef c;

    public b(int r1, Function1 r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        Pair r4 = (Pair) r3;
        int r0 = ((Number) r4.component1()).intValue();
        FullScreenOpenPanel r5 = (FullScreenOpenPanel) r4.component2();
        if (this.a != r0) goto L7;
        this.b.invoke(r5);
        Disposable r6 = (Disposable) this.c.element;
        if (r6 == null) goto L9;
        r6.dispose();
        return;
    L9:
        return;
    L7:
        int r7 = q.a;
        q.g("attach want:" + this.a + " create：" + r0, "FullScreenOpenPanel");
    }
}
