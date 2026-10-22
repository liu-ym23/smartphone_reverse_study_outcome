package com.ss.android.lark.flow.feed.sidebar.human;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.shared.page.s;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Runnable {
    public final /* synthetic */ OfficeSidebarHumanFeedController a;

    public a(OfficeSidebarHumanFeedController r1) {
        this.a = r1;
    }

    public final void a() {
        OfficeSidebarHumanFeedController r0 = this.a;
        Object r1 = r0.j;
        monitor-enter(r1);
        List r2 = CollectionsKt.toList(r0.k.values());     // Catch: Throwable -> L14
        r0.k.clear();     // Catch: Throwable -> L14
        monitor-exit(r1);
        if (r2.isEmpty() == false) goto L9;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "flushHumanListShows skipped: no pending card");
        return;
    L9:
        s r3 = r0.n.get();
        if (r3 != null) goto L12;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "flushHumanListShows skipped: viewModel not ready");
        return;
    L12:
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "flushHumanListShows size=" + r2.size());
        r3.onItemsShowed(0, r2, true);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
