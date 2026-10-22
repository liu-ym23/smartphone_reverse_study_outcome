package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.widget.LiveTabIndicator;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class DrawerLiveTabViewHolder extends BaseViewHolder<FeedItem> {
    public static final /* synthetic */ int c = 0;
    public final IFeedActionCallback a;
    public final LiveTabIndicator b;

    public final boolean fullSpan() {
        return true;
    }

    public DrawerLiveTabViewHolder(View r2, IFeedActionCallback r3) {
        super(r2);
        this.b = (LiveTabIndicator) r2.findViewById(2131389783);
        this.a = r3;
    }

    public final void bind(Object r3, int r4) {
        com.bytedance.android.livesdk.feed.feed.h r5 = (com.bytedance.android.livesdk.feed.feed.h) ((FeedItem) r3).getItem();
        this.b.setTitles(r5.a);
        this.b.setOnTabClickListener(new u(this));
        HashMap r6 = new HashMap();
        r6.put("event_belong", "live");
        r6.put("event_page", "live");
        r6.put("event_type", "show");
        Iterator<com.bytedance.android.livesdk.feed.feed.e> r7 = r5.a.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.feed.feed.e r0 = r7.next();
        if (r0.a == false) goto L4;
        this.b.c(r0);
        String r1 = r0.e();
        if (r1 == null) goto L4;
        r6.put("enter_from_merge", "live_".concat(r1));
        goto L4
    L10:
        kw1.c.d("subtab_show", r6);
    }
}
