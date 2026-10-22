package veb;

import androidx.recyclerview.widget.DiffUtil;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.feed.shared.page.diff.FeedDiffCallback;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public b a;
    public boolean b;
    public UpdateRecord c;
    public RunnableC0313a d;
    public final FeedListAdapter e;
    public final ExecutorService f;

    /* JADX INFO: renamed from: veb.a$a, reason: collision with other inner class name */
    public class RunnableC0313a implements Runnable {
        public final List<UIFeedCard> a;
        public final UpdateRecord b;
        public final /* synthetic */ a c;

        /* JADX INFO: renamed from: veb.a$a$a, reason: collision with other inner class name */
        public class RunnableC0314a implements Runnable {
            public final /* synthetic */ DiffUtil.DiffResult a;
            public final /* synthetic */ RunnableC0313a b;

            public final void a() {
                a r0 = this.b.c;
                if (r0.b == false) goto L5;
                r0.b = false;
            L8:
                a r1 = this.b.c;
                if (r1.c == null) goto L11;
                Log.i("FeedSharedModule_DiffHelper", "[FeedItems] has pending updateItems, post runnable");
                ArrayList r2 = new ArrayList();
                new ArrayList();
                r2.addAll(this.b.c.e.getItems());
                a r3 = this.b.c;
                RunnableC0313a r4 = new RunnableC0313a(r3, r2, r3.c);
                r3.d = r4;
                r3.f.execute(r4);
                this.b.c.c = null;
                return;
            L11:
                r1.d = null;
                return;
            L5:
                if (r0.a == null) goto L8;
                Log.i("FeedSharedModule_DiffHelper", "real dispatch diff");
                RunnableC0313a r5 = this.b;
                r5.c.a.a(this.a, r5.b);
                goto L8
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

            public RunnableC0314a(RunnableC0313a r1, DiffUtil.DiffResult r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        public final void a() {
            Log.i("FeedSharedModule_DiffHelper", "[FeedItems] start diff, size =" + ((ArrayList) this.b.b).size());
            UICallbackExecutor.execute(new RunnableC0314a(this, DiffUtil.calculateDiff(new FeedDiffCallback(this.a, this.b.b), false)));
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

        public RunnableC0313a(a r1, List<UIFeedCard> r2, UpdateRecord r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public interface b {
        void a(DiffUtil.DiffResult r1, UpdateRecord r2);
    }

    public a(FeedListAdapter r2) {
        this.e = r2;
        this.f = CoreThreadPool.getDefault().getSingleScheduledThreadPool("feed_diff_thread");
    }
}
