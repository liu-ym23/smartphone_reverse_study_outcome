package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.live.LiveGapViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a0 implements b90.a {
    public static final a0 a = null;

    static {
        a = new a0();
    }

    public a0() {
    }

    public final BaseViewHolder<Object> a(ViewGroup r3, Object[] r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new LiveGapViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131567661, r3, false));
    }
}
