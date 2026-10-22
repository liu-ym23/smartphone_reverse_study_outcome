package com.ss.android.lark.feed.shared.data.utils;

import com.bytedance.lark.pb.basic.v1.Urgent;
import com.ss.android.lark.biz.im.api.UrgentInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public static List<UrgentInfo> a(List<Urgent> r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList(r7.size());
        Iterator<Urgent> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L26;
        Urgent r2 = r8.next();
        if (r2 != null) goto L11;
        UrgentInfo r3 = null;
    L23:
        if (r3 == null) goto L7;
        r1.add(r3);
        goto L7
    L11:
        r3 = new UrgentInfo();
        r3.setId(r2.id);
        r3.setMessageId(r2.message_id);
        r3.setSendTime(r2.send_time.longValue());
        Boolean r4 = r2.is_closed;
        boolean r5 = false;
        if (r4 != null) goto L14;
    L16:
        boolean r6 = false;
    L17:
        r3.setClosed(r6);
        Boolean r9 = r2.is_muted;
        if (r9 != null) goto L20;
    L22:
        r3.setMuted(r5);
        goto L23
    L20:
        if (r9.booleanValue() == false) goto L22;
        r5 = true;
        goto L22
    L14:
        if (r4.booleanValue() == false) goto L16;
        r6 = true;
        goto L17
    L26:
        return r1;
    }
}
