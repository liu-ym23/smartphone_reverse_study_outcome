package com.ss.android.lark.feed.shared.page;

import android.text.TextUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.data.utils.FeedValueHelper;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.feed.shared.page.experiment.FeedCallbackExecutor;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements FeedListAdapter.c {
    public final /* synthetic */ FeedItemsFragment a;

    public static final class a implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ FeedItemsFragment b;
        public final /* synthetic */ UpdateRecord c;

        public a(boolean r1, FeedItemsFragment r2, UpdateRecord r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            boolean r1 = true;
            if (((Boolean) FeedValueHelper.c.getValue()).booleanValue() == true) goto L5;
            FeedItemsFragment r0 = this.b;
            cfb.a r3 = FeedItemsFragment.Q;
            RecyclerView r2 = r0.V90().b;
            if (r2 != null) goto L10;
        L12:
            boolean r4 = false;
        L13:
            if (r4 == false) goto L15;
            s r5 = this.b.W90();
            int r6 = this.b.V90().h.findLastVisibleItemPosition();
            FeedItemsFragment r7 = this.b;
            r5.onItemsShowed(r6, FeedItemsFragment.T90(r7, r7.V90().h), false);
        L15:
            bfb.a r8 = this.b.y;
            if (r8 == null) goto L23;
            UpdateRecord r9 = this.c;
            Intrinsics.checkNotNullParameter(r9, "record");
            Integer r10 = r8.b.get(Long.valueOf(r9.a));
            if (r10 == null) goto L23;
            if (r10.intValue() != 0) goto L23;
            r8.a.scrollToPosition(0);
            Log.d("FeedScrollStateRecorder", "move to first position");
        L23:
            FeedItemsFragment r11 = this.b;
            FeedFolder r12 = r11.s;
            if (r12 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("feedFilter");
            r12 = null;
        L26:
            Intrinsics.checkNotNullParameter(r12, "feedFilter");
            rdb.a r13 = r11.e;
            if (r13 != null) goto L29;
            return;
        L29:
            if (r13.a <= 0) goto L31;
        L34:
            boolean r14 = true;
        L35:
            if (r14 == false) goto L48;
            FeedRecyclerView r15 = r11.X90();
            if (r15 == null) goto L48;
            Intrinsics.checkNotNullParameter(r15, "<this>");
            Intrinsics.checkNotNullParameter(r12, "feedFilter");
            Intrinsics.checkNotNullParameter(r13, "state");
            if (r13.a <= 0) goto L41;
        L44:
            if (r1 == false) goto L48;
            if ((r15.getLayoutManager() instanceof LinearLayoutManager) == false) goto L48;
            LinearLayoutManager r16 = r15.getLayoutManager();
            Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            Log.i("FeedModule_recoverState", "filter: " + r12.label() + " recover to position " + r13.a + ", offset: " + r13.b);
            r16.scrollToPositionWithOffset(r13.a, r13.b);
            goto L48
        L41:
            if (r13.b > 0) goto L44;
            r1 = false;
        L48:
            r11.e = null;
            return;
        L31:
            if (r13.b > 0) goto L34;
            r14 = false;
            goto L35
        L10:
            if (r2.getScrollState() != 0) goto L12;
            r4 = true;
            goto L13
        L5:
            if (this.a == false) goto L15;
            s r17 = this.b.W90();
            int r18 = this.b.V90().h.findLastVisibleItemPosition();
            FeedItemsFragment r19 = this.b;
            r17.onItemsShowed(r18, FeedItemsFragment.T90(r19, r19.V90().h), false);
            goto L15
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

    public static final class b implements Runnable {
        public final /* synthetic */ FeedItemsFragment a;
        public final /* synthetic */ UpdateRecord b;

        public b(FeedItemsFragment r1, UpdateRecord r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            bfb.a r0 = this.a.y;     // Catch: Throwable -> L9
            if (r0 == null) goto L14;
            UpdateRecord r1 = this.b;     // Catch: Throwable -> L9
            Intrinsics.checkNotNullParameter(r1, "record");     // Catch: Throwable -> L9
            if (r0.c == false) goto L7;
            r0.a.post(new bfb.b(r0, r1));     // Catch: Throwable -> L9
            goto L14
        L7:
            r0.a(r1);     // Catch: Throwable -> L9
        L14:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public d(FeedItemsFragment r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter.c
    public final void a(UpdateRecord r3) {
        Intrinsics.checkNotNullParameter(r3, "updateRecord");
        UICallbackExecutor.execute(new b(this.a, r3));
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter.c
    public final void b(UpdateRecord r5) {
        Intrinsics.checkNotNullParameter(r5, "updateRecord");
        UpdateRecord r0 = this.a.H;
        if (r0 != null) goto L5;
    L7:
        UpdateRecord r1 = this.a.H;
        if (r1 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        FeedItemsFragment r3 = this.a;
        r3.H = r5;
        FeedCallbackExecutor r4 = FeedCallbackExecutor.a;
        a r6 = new a(r2, r3, r5);
        r4.getClass();
        FeedCallbackExecutor.c(r6);
        return;
    L10:
        if (Intrinsics.areEqual(r1.g, r5.g) == true) goto L12;
        r2 = true;
        goto L13
    L5:
        if (TextUtils.equals(r0.e, r5.e) == true) goto L7;
    }
}
