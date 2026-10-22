package aw1;

import bw1.e;
import com.bytedance.android.live.ui.CenterScrollLayoutManager;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.SingleDrawFeedAdapter;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.SingleListDrawFragment;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.TabListModel;
import com.bytedance.android.livesdk.viewmodel.j;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ SingleListDrawFragment a;

    public b(SingleListDrawFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        j r7 = (j) r6;
        SingleDrawFeedAdapter r0 = this.a.B;
        int r1 = 0;
        if (r0 == null) goto L15;
        if (r7 == null) goto L6;
        List r2 = r7.a;
    L7:
        if (r7 == null) goto L9;
        boolean r8 = r7.b;
    L10:
        if (r2 == null) goto L15;
        if (r8 == false) goto L14;
        r0.a.clear();
        r0.a.addAll(r2);
        r0.notifyDataSetChanged();
        goto L15
    L14:
        int r9 = r0.a.size();
        r0.a.addAll(r2);
        r0.notifyItemRangeInserted(r9, r2.size());
        goto L15
    L9:
        r8 = false;
        goto L10
    L6:
        r2 = null;
    L15:
        DoubleBallSwipeRefreshLayout r10 = this.a.j;
        if (r10 == null) goto L18;
        r10.setRefreshing(false);
    L18:
        SingleListDrawFragment r11 = this.a;
        CenterScrollLayoutManager r3 = r11.s;
        if (r3 == null) goto L33;
        TabListModel r12 = r11.f;
        if (r12 == null) goto L25;
        e r13 = r12.getCurrentTabModel();
        if (r13 == null) goto L25;
        int r14 = r13.d;
    L26:
        TabListModel r4 = this.a.f;
        if (r4 == null) goto L31;
        e r5 = r4.getCurrentTabModel();
        if (r5 == null) goto L31;
        r1 = r5.e;
    L31:
        r3.scrollToPositionWithOffset(r14, r1);
        return;
    L25:
        r14 = 0;
        goto L26
    }
}
