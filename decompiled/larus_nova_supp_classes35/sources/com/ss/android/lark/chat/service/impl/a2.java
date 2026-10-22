package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a2 {
    public static final Map<String, Integer> b = null;
    public final a a;

    public interface a {
    }

    static {
        b = new ConcurrentHashMap();
    }

    public a2(i.a r1) {
        this.a = r1;
    }

    public final void a(SubscribeChatEventRequest.SubscriptionKey r7) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((ConcurrentHashMap) b).entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) r2.next();
        if (r3 == null) goto L4;
        String r4 = (String) r3.getKey();
        if (r4 == null) goto L4;
        if (r3.getValue() == null) goto L17;
        if (((Integer) r3.getValue()).intValue() <= 0) goto L17;
        r0.add(r4);
    L17:
        r1.add(r4);
        r2.remove();
        goto L4
    L18:
        ((i.a) this.a).a.u2(r0, r1, r7);
    }
}
