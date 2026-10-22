package com.bytedance.android.live.recharge.util;

import android.net.Uri;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static String a(String r4, Map<String, String> r5) {
        Uri.Builder r6 = UriProtector.parse(r4).buildUpon();
        HashMap r0 = new HashMap();
        k r1 = (k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);
        if (r1 == null) goto L11;
        IRoom r2 = r1.getRoom();
        r0.put("room_id", String.valueOf(r2.getId()));
        if (r2.getOwner() == null) goto L8;
        r0.put("anchor_id", String.valueOf(r2.getOwner().getIdString()));
    L8:
        l01.d r3 = (l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class);
        if (r3.isLogin() == false) goto L11;
        r0.put("user_id", r3.getCurrentUserId());
    L11:
        Iterator r7 = r0.entrySet().iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        Map.Entry r8 = (Map.Entry) r7.next();
        r6.appendQueryParameter((String) r8.getKey(), (String) r8.getValue());
        goto L13
    L15:
        Iterator r9 = ((HashMap) r5).entrySet().iterator();
    L17:
        if (r9.hasNext() == false) goto L20;
        Map.Entry r10 = (Map.Entry) r9.next();
        r6.appendQueryParameter((String) r10.getKey(), (String) r10.getValue());
        goto L17
    L20:
        return r6.toString();
    }

    public static Uri b(Uri r4, List<String> r5) {
        if (UriProtector.getQueryParameterNames(r4) != null) goto L5;
        return r4;
    L5:
        Set r0 = UriProtector.getQueryParameterNames(r4);
        Uri.Builder r1 = r4.buildUpon().clearQuery();
        Iterator r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        String r3 = (String) r2.next();
        if (((ArrayList) r5).contains(r3) == true) goto L7;
        r1.appendQueryParameter(r3, UriProtector.getQueryParameter(r4, r3));
        goto L7
    L13:
        return r1.build();
    }
}
