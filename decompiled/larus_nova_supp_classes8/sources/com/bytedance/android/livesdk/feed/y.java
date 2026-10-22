package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.live.HorFollowLiveFeedViewHolder;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y implements b90.a {
    public static final y a = null;

    static {
        a = new y();
    }

    public y() {
    }

    public final BaseViewHolder<Object> a(ViewGroup r4, Object[] r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        if (r5.length != 0) goto L5;
        boolean r0 = true;
    L7:
        if ((!r0) == false) goto L14;
        Object r6 = r5[0];
        if ((r6 instanceof mv1.l) == false) goto L14;
        if (r6 == null) goto L13;
        BannerSwipeRefreshLayout.a r7 = ((mv1.l) r6).b();
    L15:
        View r8 = LayoutInflater.from(r4.getContext()).inflate(2131566266, r4, false);
        Integer r1 = (Integer) LiveFeedSettings.DOUYIN_LIVE_FEED_TOP_HINT.getValue();
        if (r1 == null) goto L22;
        if (r1.intValue() != 0) goto L22;
        r8.findViewById(2131389854).setVisibility(8);
    L22:
        return new HorFollowLiveFeedViewHolder(r8, r7);
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.adapter.IPayloadProvider");
    L14:
        r7 = null;
        goto L15
    L5:
        r0 = false;
        goto L7
    }
}
