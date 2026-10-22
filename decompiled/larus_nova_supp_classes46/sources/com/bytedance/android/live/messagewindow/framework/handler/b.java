package com.bytedance.android.live.messagewindow.framework.handler;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import com.bytedance.android.livesdk.message.model.m1;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ BottomRightCommonCardHandler a;
    public final /* synthetic */ m1 b;
    public final /* synthetic */ Pair c;

    public b(BottomRightCommonCardHandler r1, m1 r2, Pair r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        if (((ICardLifecycle.State) r3) != ICardLifecycle.State.Destroyed) goto L10;
        BottomRightCommonCardHandler r4 = this.a;
        m1 r0 = this.b;
        Pair r1 = this.c;
        if (r1 == null) goto L7;
        v61.a r2 = (v61.a) r1.getFirst();
    L8:
        r4.k(r0, r2);
        return;
    L7:
        r2 = null;
        goto L8
    }
}
