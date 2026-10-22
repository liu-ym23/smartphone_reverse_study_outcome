package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ Runnable a;

    public h(g r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if (((ICardLifecycle.State) r2) != ICardLifecycle.State.Hidden) goto L6;
        this.a.run();
        return;
    }
}
