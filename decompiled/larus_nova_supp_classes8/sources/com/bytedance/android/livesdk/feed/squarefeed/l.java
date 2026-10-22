package com.bytedance.android.livesdk.feed.squarefeed;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.r1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ OpenRankFragment a;

    public l(OpenRankFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.a.getRecyclerView() == null) goto L13;
        r1.a(this.a.getRecyclerView(), 0);
        RecyclerView r0 = this.a.getRecyclerView();
        if (r0 == null) goto L12;
        r0.scrollToPosition(r4.intValue());
        return;
    L12:
        return;
    }
}
