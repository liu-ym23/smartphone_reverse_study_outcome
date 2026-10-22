package com.larus.bmhome.chat.layout.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c1 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ ScrollToRecyclerView a;

    public c1(ScrollToRecyclerView r1) {
        this.a = r1;
    }

    public final void onScrolled(RecyclerView r3, int r4, int r5) {
        ScrollToRecyclerView r0 = this.a;
        r0.k += r4;
        r0.l += r5;
        super.onScrolled(r3, r4, r5);
        ScrollToRecyclerView r6 = this.a;
        ScrollToRecyclerView.a r7 = r6.m;
        if (r7 == null) goto L6;
        r7.a(r6.k);
        return;
    }
}
