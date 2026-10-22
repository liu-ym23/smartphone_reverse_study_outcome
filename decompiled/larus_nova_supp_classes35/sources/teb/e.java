package teb;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import java.util.HashSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements Runnable {
    public final /* synthetic */ HashSet a;
    public final /* synthetic */ f b;

    public final void a() {
        FeedListAdapter r0 = this.b.b.get();
        HashSet r1 = this.a;
        RecyclerView r2 = r0.a;
        if (r2 == null) goto L19;
        LinearLayoutManager r3 = r2.getLayoutManager();
        int r4 = r3.findFirstVisibleItemPosition() - 2;
        int r5 = r3.findLastVisibleItemPosition() + 3;
        if (r4 >= 0) goto L9;
        r4 = 0;
    L9:
        if (r5 <= r0.getItemCount()) goto L11;
        r5 = r0.getItemCount();
    L11:
        if (r4 >= r5) goto L25;
        UIFeedCard r6 = (UIFeedCard) r0.getItem(r4);
        if (r6 == null) goto L18;
        if (r1.contains(r6.getId()) == false) goto L18;
        r0.notifyItemChanged(r4);
    L18:
        r4 = r4 + 1;
        goto L11
    L25:
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

    public e(f r1, HashSet r2) {
        this.b = r1;
        this.a = r2;
    }
}
