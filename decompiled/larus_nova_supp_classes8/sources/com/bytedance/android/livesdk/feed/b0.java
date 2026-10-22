package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.live.LiveRankViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b0 implements b90.a {
    public static final b0 a = null;

    static {
        a = new b0();
    }

    public b0() {
    }

    public final BaseViewHolder<Object> a(ViewGroup r3, Object[] r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new LiveRankViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131567662, r3, false));
    }
}
