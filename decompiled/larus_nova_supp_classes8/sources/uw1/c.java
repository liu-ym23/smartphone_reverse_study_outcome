package uw1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.squarefeed.viewholder.SimpleRankViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements b90.a {
    public final /* synthetic */ e a;

    public c(e r1) {
        this.a = r1;
    }

    public final BaseViewHolder<Object> a(ViewGroup r4, Object[] r5) {
        View r6 = LayoutInflater.from(r4.getContext()).inflate(2131565987, r4, false);
        e r0 = this.a;
        FeedDataKey r1 = r0.c;
        return new SimpleRankViewHolder(r6, r0.d, r0.b, r0.e);
    }
}
