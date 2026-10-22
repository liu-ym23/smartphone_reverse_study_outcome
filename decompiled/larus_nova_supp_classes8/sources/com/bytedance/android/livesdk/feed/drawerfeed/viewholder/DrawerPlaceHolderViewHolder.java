package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.PlaceHolder;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerPlaceHolderViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerPlaceHolderViewHolder extends BaseViewHolder<FeedItem> {
    public final TextView a;
    public final TextView b;
    public final View c;
    public final TextView d;
    public final LinearLayout e;
    public final TextView f;
    public final com.bytedance.android.livesdk.feed.j g;

    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
    }

    public DrawerPlaceHolderViewHolder(View r2, com.bytedance.android.livesdk.feed.j r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.g = r3;
        this.a = (TextView) r2.findViewById(2131370242);
        this.b = (TextView) r2.findViewById(2131370232);
        this.c = r2.findViewById(2131370234);
        this.d = (TextView) r2.findViewById(2131370233);
        this.e = (LinearLayout) r2.findViewById(2131368548);
        this.f = (TextView) r2.findViewById(2131368541);
    }

    public final void bind(Object r4, int r5) {
        FeedItem r6 = (FeedItem) r4;
        if (r6 == null) goto L20;
        PlaceHolder r7 = r6.placeHolder;
        if (r7 == null) goto L21;
        int r8 = r7.getType();
        if (r8 != 1) goto L9;
        this.e.setVisibility(8);
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(0);
        this.d.setText(r7.getMsg());
        return;
    L9:
        if (r8 != 2) goto L11;
        this.e.setVisibility(8);
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.a.setText(r7.getMsg());
        return;
    L11:
        if (r8 != 3) goto L13;
        this.e.setVisibility(8);
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        this.c.setVisibility(8);
        this.b.setText(r7.getMsg());
        return;
    L13:
        if (r8 != 4) goto L25;
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.e.setVisibility(0);
        this.f.setText(r7.getMsg());
        return;
    L25:
        return;
    L21:
        return;
    }
}
