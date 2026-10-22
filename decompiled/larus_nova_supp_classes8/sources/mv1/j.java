package mv1;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j extends RecyclerView.OnScrollListener {
    public final /* synthetic */ k a;

    public j(k r1) {
        this.a = r1;
    }

    public final void onScrollStateChanged(RecyclerView r3, int r4) {
        super.onScrollStateChanged(r3, r4);
        if (r4 != 0) goto L11;
        BaseFeedAdapter r5 = this.a.a;
        r5.F2(r5.g);
        StaggeredGridLayoutManager r6 = r3.getLayoutManager();
        if ((r6 instanceof StaggeredGridLayoutManager) == false) goto L13;
        StaggeredGridLayoutManager r7 = r6;
        int r8 = r7.findFirstVisibleItemPositions(null)[0];
        if (r8 >= 0) goto L9;
        return;
    L9:
        if (r8 >= 3) goto L15;
        r7.invalidateSpanAssignments();
        return;
    L15:
        return;
    L13:
        return;
    L11:
        this.a.a.c.removeCallbacksAndMessages(null);
    }

    public final void onScrolled(RecyclerView r1, int r2, int r3) {
        super.onScrolled(r1, r2, r3);
        if (r2 > 0) goto L5;
        if (r3 > 0) goto L5;
        return;
    L5:
        this.a.a.c.removeCallbacksAndMessages(null);
    }
}
