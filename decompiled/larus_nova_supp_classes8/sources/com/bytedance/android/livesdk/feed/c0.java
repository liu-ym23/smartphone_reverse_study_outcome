package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerOperationBannerViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c0 implements b90.a {
    public static final c0 a = null;

    static {
        a = new c0();
    }

    public c0() {
    }

    public final BaseViewHolder<Object> a(ViewGroup r3, Object[] r4) {
        return new DrawerOperationBannerViewHolder(r3, LayoutInflater.from(r3.getContext()).inflate(2131565981, r3, false));
    }
}
