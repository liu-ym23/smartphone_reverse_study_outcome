package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerHistoryItemViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t implements b90.a {
    public final /* synthetic */ e0 a;

    public t(e0 r1) {
        this.a = r1;
    }

    public final BaseViewHolder<Object> a(ViewGroup r3, Object[] r4) {
        return new DrawerHistoryItemViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131565968, r3, false), this.a.e.getLifecycle(), this.a.e.v);
    }
}
