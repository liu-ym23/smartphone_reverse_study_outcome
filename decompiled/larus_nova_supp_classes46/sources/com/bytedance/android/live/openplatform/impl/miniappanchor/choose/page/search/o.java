package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ SearchHistoryAdapter.ViewHolder a;
    public final /* synthetic */ String b;

    public o(SearchHistoryAdapter.ViewHolder r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        this.a.c.invoke(2, this.b);
    }
}
