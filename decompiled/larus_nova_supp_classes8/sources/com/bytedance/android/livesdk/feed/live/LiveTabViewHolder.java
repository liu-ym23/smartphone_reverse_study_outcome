package com.bytedance.android.livesdk.feed.live;

import android.view.View;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.feed.h;
import com.bytedance.android.livesdk.feed.widget.LiveTabIndicator;
import java.util.HashMap;
import java.util.Iterator;
import jw1.f0;
import jw1.x;
import kw1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveTabViewHolder extends BaseViewHolder<FeedItem> implements x {
    public static final /* synthetic */ int d = 0;
    public final IFeedActionCallback a;
    public final LiveTabIndicator b;
    public h c;

    public final boolean fullSpan() {
        return true;
    }

    public final void T3(e r4) {
        HashMap r0 = new HashMap();
        r0.put("event_belong", "live");
        r0.put("event_page", "live");
        r0.put("event_type", "click");
        r0.put("event_module", "live_" + r4.e());
        c.d("subtab_click", r0);
        this.a.WS(IFeedActionCallback.FeedAction.TAB_CLICK, r4);
    }

    @Override // jw1.x
    public final void f0(int r8) {
        h r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.b == null) goto L19;
        Iterator<e> r1 = r0.a.iterator();
    L9:
        if (r1.hasNext() == false) goto L20;
        e r2 = r1.next();
        if (r2.f() != r8) goto L9;
        this.b.c(r2);
        T3(r2);
        goto L9
    L20:
        return;
    }

    public LiveTabViewHolder(View r2, IFeedActionCallback r3) {
        super(r2);
        this.b = (LiveTabIndicator) r2.findViewById(2131389783);
        this.a = r3;
        r3.WS(IFeedActionCallback.FeedAction.SET_SWITCH_TAB_LISTENER, this);
    }

    public final void bind(Object r3, int r4) {
        h r5 = (h) ((FeedItem) r3).getItem();
        this.c = r5;
        this.b.setTitles(r5.a);
        this.b.setOnTabClickListener(new f0(this));
        HashMap r6 = new HashMap();
        r6.put("event_belong", "live");
        r6.put("event_page", "live");
        r6.put("event_type", "show");
        Iterator<e> r7 = r5.a.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        e r0 = r7.next();
        if (r0.a == false) goto L4;
        this.b.c(r0);
        String r1 = r0.e();
        if (r1 == null) goto L4;
        r6.put("enter_from_merge", "live_".concat(r1));
        goto L4
    L10:
        c.d("subtab_show", r6);
    }
}
