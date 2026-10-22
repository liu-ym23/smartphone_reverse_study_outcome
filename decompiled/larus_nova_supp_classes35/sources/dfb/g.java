package dfb;

import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.thread.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.feed.shared.page.binder2.BaseFeedSwipeableViewHolder;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends cw7.e {
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> b;
    public final RecyclerView.ViewHolder c;
    public final UIFeedCard d;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ g a;

        public b(g r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b.notifyDataSetChanged();     // Catch: Throwable -> L4
            Log.i("SwipeRightRemoveAction", "onSlideAnimationEnd notifyDataSetChanged");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void b() {
        BaseFeedSwipeableViewHolder r0 = this.c;
        if ((r0 instanceof BaseFeedSwipeableViewHolder) == false) goto L5;
        r0.U3(this.d);
        this.c.l = false;
        return;
    L5:
        Log.e("SwipeRightRemoveAction", "SwipeRightRemoveAction not onPerformAction, viewHolder:" + this.c + " card:" + this.d);
    }

    public final void c() {
        ThreadUtils.runOnUIThread(new b(this), 100);
    }

    public g(RecyclerView.Adapter<RecyclerView.ViewHolder> r1, RecyclerView.ViewHolder r2, UIFeedCard r3, FeedListAdapter.h r4) {
        Intrinsics.checkNotNullParameter(r1, "adapter");
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        Intrinsics.checkNotNullParameter(r3, BrowserDependency.UrlClickType.CARD);
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
