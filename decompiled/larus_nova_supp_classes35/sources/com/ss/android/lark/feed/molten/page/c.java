package com.ss.android.lark.feed.molten.page;

import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.f;
import java.util.HashMap;
import java.util.Map;
import leb.d;
import leb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final Map<FeedCard.Type, leb.b> a;
    public final reb.a<f> b;

    public c() {
        d r0 = new d();
        leb.c r1 = new leb.c();
        e r2 = new e();
        HashMap r3 = new HashMap();
        this.a = r3;
        r3.put(FeedCard.Type.CHAT, r1);
        r3.put(FeedCard.Type.DOC, r0);
        r3.put(FeedCard.Type.THREAD, r2);
        r3.put(FeedCard.Type.TOPIC, r2);
        r3.put(FeedCard.Type.MSG_THREAD, r2);
        int r4 = com.ss.android.lark.feed.shared.data.utils.c.a;
        Map r5 = com.ss.android.lark.im.base.d.a;
        this.b = new reb.a(com.ss.android.lark.im.base.d.c(ImExtensionType.FEED_CARD_FACTORY, com.ss.android.lark.feed.export.feedcard.e.class), new b());
    }

    public final UIFeedCard a(FeedPreviewInfo r4) {
        com.ss.android.lark.biz.im.api.c r0 = r4.N2;
        if (r0 == null) goto L5;
        AppFeedCardType r1 = r0.a;
    L6:
        FeedCard.Type r2 = r4.d;
        if (r2 != null) goto L9;
        r2 = FeedCard.Type.UNKNOWN;
    L9:
        f r3 = this.b.a(r2, r1);
        if (r3 != null) goto L12;
        leb.b r5 = (leb.b) ((HashMap) this.a).get(r4.d);
        if (r5 != null) goto L16;
        geb.c.a("PartialPackerFactory", "packFeedItem is empty, feedPreviewInfo type = " + r4.d);
        return null;
    L16:
        return (UIFeedCard) r5.e(r4);
    L12:
        return r3.b(r4);
    L5:
        r1 = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
        goto L6
    }
}
