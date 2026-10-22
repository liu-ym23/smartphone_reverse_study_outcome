package com.bytedance.android.livesdk.feed.openui.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ HorizontalLiveListView a;

    public c(HorizontalLiveListView r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Integer r2 = (Integer) r1;
        this.a.refresh();
    }
}
