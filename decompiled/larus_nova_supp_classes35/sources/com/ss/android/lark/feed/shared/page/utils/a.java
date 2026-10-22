package com.ss.android.lark.feed.shared.page.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.shared.page.FeedRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Runnable {
    public final /* synthetic */ RecyclerView a;

    @Override // java.lang.Runnable
    public final void run() {
        b.a(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(FeedRecyclerView r1) {
        this.a = r1;
    }
}
