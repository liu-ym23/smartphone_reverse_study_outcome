package com.ss.android.lark.flow.feed.page;

import android.text.TextUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.page.FeedRecyclerView;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.feed.shared.page.experiment.FeedCallbackExecutor;
import com.ss.android.lark.feed.shared.page.k;
import com.ss.android.lark.feed.shared.page.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements FeedListAdapter.c {
    public final /* synthetic */ FlowMixedFeedFragment a;
    public final /* synthetic */ FeedRecyclerView b;

    public static final class a implements Runnable {
        public final /* synthetic */ FlowMixedFeedFragment a;
        public final /* synthetic */ FeedRecyclerView b;
        public final /* synthetic */ s c;

        public a(FlowMixedFeedFragment r1, FeedRecyclerView r2, s r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k r0 = this.a.l;     // Catch: Throwable -> L11
            if (r0 == null) goto L14;
            LinearLayoutManager r1 = r0.h;     // Catch: Throwable -> L11
            if (r1 != null) goto L8;
            return;
        L8:
            if (this.b.getScrollState() != 0) goto L19;
            this.c.onItemsShowed(r1.findLastVisibleItemPosition(), this.a.T90(r1), false);     // Catch: Throwable -> L11
            return;
        L19:
            return;
        L14:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public final void a(UpdateRecord r2) {
        Intrinsics.checkNotNullParameter(r2, "updateRecord");
        FlowMixedFeedFragment r3 = this.a;
        k r0 = r3.l;
        if (r0 == null) goto L5;
        StableLinearLayoutManager r1 = r0.h;
    L6:
        if (r1 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        r3.r = r4;
        return;
    L8:
        if (r1.findFirstCompletelyVisibleItemPosition() > 0) goto L10;
        r4 = true;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public final void b(UpdateRecord r5) {
        Intrinsics.checkNotNullParameter(r5, "updateRecord");
        if (this.a.r == true) goto L5;
    L7:
        UpdateRecord r0 = this.a.q;
        if (r0 != null) goto L10;
    L12:
        FlowMixedFeedFragment r1 = this.a;
        r1.q = r5;
        s r6 = r1.Y90().get();
        if (r6 != null) goto L15;
        return;
    L15:
        FeedCallbackExecutor r2 = FeedCallbackExecutor.a;
        a r3 = new a(this.a, this.b, r6);
        r2.getClass();
        FeedCallbackExecutor.c(r3);
        return;
    L10:
        if (TextUtils.equals(r0.e, r5.e) == true) goto L12;
        return;
    L5:
        if (this.b.getScrollState() != 0) goto L7;
        this.b.scrollToPosition(0);
        goto L7
    }

    public c(FlowMixedFeedFragment r1, FeedRecyclerView r2) {
        this.a = r1;
        this.b = r2;
    }
}
