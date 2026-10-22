package com.bytedance.android.live.revlink.impl.intercomment;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.livesdk.log.filter.v;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q implements v {
    public final Map<String, com.bytedance.android.livesdk.log.filter.m> a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    public static final class a {
    }

    static {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    public q(LinkFakeGlobalService r3) {
        this.b = r3;
        this.a = com.bytedance.revenue.platform.api.core.d.a(new Pair[]{TuplesKt.to("RevLinkCommonLogFilter", new p(r3))});
    }

    public final void L9(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        switch(r3.hashCode()) {
            case -1122536402: goto L27;
            case -1103263308: goto L24;
            case -804282046: goto L21;
            case 21313630: goto L18;
            case 516631638: goto L15;
            case 1059589542: goto L12;
            case 1060883835: goto L9;
            case 2041791848: goto L6;
            default: goto L29;
        };
    L29:
        List r5 = com.bytedance.revenue.platform.api.core.c.a(new String[0]);
    L30:
        Iterator r6 = r5.iterator();
    L32:
        if (r6.hasNext() == false) goto L36;
        String r0 = (String) r6.next();
        com.bytedance.android.livesdk.log.filter.m r1 = (com.bytedance.android.livesdk.log.filter.m) ((LinkedHashMap) this.a).get(r0);
        if (r1 == null) goto L32;
        r1.a(r4);
        goto L32
    L36:
        return;
    L6:
        if (r3.equals("livesdk_like") == false) goto L29;
    L28:
        r5 = com.bytedance.revenue.platform.api.core.c.a(new String[]{"RevLinkCommonLogFilter"});
        goto L30
    L9:
        if (r3.equals("livesdk_gift_show") == false) goto L29;
    L12:
        if (r3.equals("livesdk_live_user_report") == false) goto L29;
    L15:
        if (r3.equals("livesdk_send_gift") == false) goto L29;
    L18:
        if (r3.equals("livesdk_audience_live_message") == false) goto L29;
    L21:
        if (r3.equals("livesdk_follow") == false) goto L29;
    L24:
        if (r3.equals("livesdk_dislike") == false) goto L29;
    L27:
        if (r3.equals("livesdk_share") == false) goto L29;
        goto L28
    }
}
