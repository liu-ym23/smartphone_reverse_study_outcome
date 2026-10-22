package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ SearchHistoryAdapter.ViewHolder a;
    public final /* synthetic */ String b;

    public n(SearchHistoryAdapter.ViewHolder r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        this.a.c.invoke(1, this.b);
    }
}
