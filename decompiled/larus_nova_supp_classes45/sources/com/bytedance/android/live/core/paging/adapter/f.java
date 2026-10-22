package com.bytedance.android.live.core.paging.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ PagingAdapter.f e;

    @Override // java.lang.Runnable
    public final void run() {
        ((RecyclerView.AdapterDataObserver) ListProtector.get(PagingAdapter.f.b(this.e), this.a)).onItemRangeChanged(this.b, this.c, this.d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(PagingAdapter.f r1, int r2, int r3, int r4) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = null;
    }
}
