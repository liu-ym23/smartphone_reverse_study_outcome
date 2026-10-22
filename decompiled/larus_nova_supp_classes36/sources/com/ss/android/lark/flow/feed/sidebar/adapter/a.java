package com.ss.android.lark.flow.feed.sidebar.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.feed.shared.page.experiment.FeedCallbackExecutor;
import com.ss.android.lark.feed.shared.page.s;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements FeedListAdapter.c {
    public final /* synthetic */ FeedSidebarAdapterWrapper a;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.feed.sidebar.adapter.a$a, reason: collision with other inner class name */
    public static final class RunnableC0051a implements Runnable {
        public final /* synthetic */ FeedSidebarAdapterWrapper a;
        public final /* synthetic */ s b;

        public RunnableC0051a(FeedSidebarAdapterWrapper r1, s r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            FeedSidebarAdapterWrapper r0 = this.a;
            b r1 = r0.s;
            if (r1 == null) goto L20;
            StableLinearLayoutManager r2 = r1.d;
            if (r2 == null) goto L22;
            RecyclerView r3 = r0.m;
            if (r3 != null) goto L10;
        L12:
            boolean r4 = false;
        L13:
            if (r4 == false) goto L21;
            s r5 = this.b;
            int r6 = r2.findLastVisibleItemPosition();
            FeedSidebarAdapterWrapper r7 = this.a;
            List r8 = xeb.a.b((AtomicInteger) ((Pair) r7.n.getValue()).getFirst(), (AtomicInteger) ((Pair) r7.n.getValue()).getSecond(), r2, r7.b());
            if (r8 == null) goto L17;
            List r9 = CollectionsKt.take(r8, 12);
        L18:
            r5.onItemsShowed(r6, r9, false);
            return;
        L17:
            r9 = null;
            goto L18
        L21:
            return;
        L10:
            if (r3.getScrollState() != 0) goto L12;
            r4 = true;
            goto L13
        L22:
            return;
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

    public final void a(UpdateRecord r2) {
        Intrinsics.checkNotNullParameter(r2, "updateRecord");
    }

    public a(FeedSidebarAdapterWrapper r1) {
        this.a = r1;
    }

    public final void b(UpdateRecord r4) {
        Intrinsics.checkNotNullParameter(r4, "updateRecord");
        FeedSidebarAdapterWrapper r5 = this.a;
        int r0 = FeedSidebarAdapterWrapper.y;
        s r6 = r5.c().get();
        if (r6 != null) goto L5;
        return;
    L5:
        FeedCallbackExecutor r1 = FeedCallbackExecutor.a;
        RunnableC0051a r2 = new RunnableC0051a(this.a, r6);
        r1.getClass();
        FeedCallbackExecutor.c(r2);
    }
}
