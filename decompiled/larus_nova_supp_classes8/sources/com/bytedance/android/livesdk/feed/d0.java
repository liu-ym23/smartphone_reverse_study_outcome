package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerOperationCardViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d0 implements b90.a {
    public static final d0 a = null;

    static {
        a = new d0();
    }

    public d0() {
    }

    public final BaseViewHolder<Object> a(ViewGroup r3, Object[] r4) {
        return new DrawerOperationCardViewHolder(r3, LayoutInflater.from(r3.getContext()).inflate(2131565980, r3, false));
    }
}
