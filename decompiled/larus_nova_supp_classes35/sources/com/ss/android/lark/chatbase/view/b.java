package com.ss.android.lark.chatbase.view;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends RecyclerView.OnScrollListener {
    public final /* synthetic */ ChatImageGroup a;

    public b(ChatImageGroup r1) {
        this.a = r1;
    }

    public final void onScrollStateChanged(RecyclerView r2, int r3) {
        super.onScrollStateChanged(r2, r3);
        ChatImageGroup r4 = this.a;
        if (r3 != 0) goto L5;
        boolean r5 = true;
    L6:
        int r0 = ChatImageGroup.k;
        r4.a(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    public final void onScrolled(RecyclerView r1, int r2, int r3) {
        super.onScrolled(r1, r2, r3);
    }
}
