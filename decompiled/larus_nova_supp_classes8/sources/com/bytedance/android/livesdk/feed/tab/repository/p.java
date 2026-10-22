package com.bytedance.android.livesdk.feed.tab.repository;

import com.bytedance.android.live.core.setting.l3;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.feed.tab.api.FeedTabApi;
import com.bytedance.android.livesdk.feed.tab.repository.newtab.NewTabRepository;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p extends l {
    public static l d;
    public static final boolean e = false;

    static {
        e = ((Boolean) l3.a.getValue()).booleanValue();
    }

    public static l f() {
        if (d != null) goto L9;
        if (e == true) goto L7;
        d = new p(new s(new xw1.a(), new xw1.d(), LiveFeedContext.appContext().getApplicationContext(), new com.bytedance.android.livesdk.feed.n()), new t((FeedTabApi) com.bytedance.android.live.network.c.b().e(FeedTabApi.class)));
        goto L9
    L7:
        d = (NewTabRepository) NewTabRepository.d.getValue();
    L9:
        return d;
    }

    public p(s r1, t r2) {
        super(r1, r2);
    }
}
