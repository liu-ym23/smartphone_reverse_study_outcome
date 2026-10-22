package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.config.ap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerOperationCardViewHolder;", "Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerLynxViewHolder;", "a", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerOperationCardViewHolder extends DrawerLynxViewHolder {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final float T3() {
        return 0.7619048f;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final String W3() {
        return "operation_card";
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final String a4() {
        return "DrawerOperationCardViewHolder";
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final int U3() {
        return ((this.g.getMeasuredWidth() - 3) / 2) - 5;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final Object V3() {
        FeedItem r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.operationCard;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final String X3() {
        String r0 = ap.a.getValue().getFallBackUri();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final String b4() {
        String r0 = ap.a.getValue().getUri();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final ViewGroup Z3() {
        return this.c;
    }

    public DrawerOperationCardViewHolder(ViewGroup r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r2, r3);
    }
}
