package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s implements Runnable {
    public final /* synthetic */ DrawerHistoryItemViewHolder a;
    public final /* synthetic */ Ref.IntRef b;

    public s(DrawerHistoryItemViewHolder r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c.notifyItemRangeRemoved(this.b.element, 1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
