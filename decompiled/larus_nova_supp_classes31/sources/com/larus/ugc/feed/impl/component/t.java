package com.larus.ugc.feed.impl.component;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class t implements Runnable {
    public final /* synthetic */ CreationFeedComponent a;

    public /* synthetic */ t(CreationFeedComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CreationFeedComponent r0 = this.a;
        RecyclerView r1 = r0.o.a();
        if (r1 == null) goto L7;
        r0.Q3(r1, false, false);
        return;
    }
}
