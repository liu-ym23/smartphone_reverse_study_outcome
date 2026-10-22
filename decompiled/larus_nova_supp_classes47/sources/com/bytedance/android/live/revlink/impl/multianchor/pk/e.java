package com.bytedance.android.live.revlink.impl.multianchor.pk;

import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.g7;
import com.bytedance.android.livesdk.link.model.k0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final e a = null;

    public e() {
    }

    static {
        a = new e();
    }

    public static Map a(Map r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        HashMap r0 = new HashMap();
        Iterator r8 = r7.values().iterator();
    L7:
        if (r8.hasNext() == false) goto L16;
        IBattleUserInfo r1 = (IBattleUserInfo) r8.next();
        if (r1.getMultiPkTeamId() == 0) goto L7;
        k0 r2 = r1.getUserInfo();
        if (r2 == null) goto L7;
        String r3 = r2.getUserId();
        if (r3 == null) goto L7;
        r0.put(r3, Long.valueOf(r1.getMultiPkTeamId()));
        goto L7
    L16:
        return r0;
    }

    public static Map b(Map r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        HashMap r0 = new HashMap();
        Iterator r7 = r6.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) r7.next();
        long r2 = ((Number) r1.getKey()).longValue();
        List r3 = ((g7) r1.getValue()).getAnchorUidList();
        if (r3 == null) goto L7;
        Iterator r4 = CollectionsKt.toList(r3).iterator();
    L13:
        if (r4.hasNext() == false) goto L7;
        r0.put((String) r4.next(), Long.valueOf(r2));
        goto L13
    L15:
        return r0;
    }
}
