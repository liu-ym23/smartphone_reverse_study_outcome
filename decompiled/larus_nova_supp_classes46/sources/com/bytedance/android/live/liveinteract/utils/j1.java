package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.c7;
import com.bytedance.android.live.core.setting.d6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j1 {
    public static String a() {
        JSONObject r0 = new JSONObject();
        int r1 = c7.a;
        JSONObject r3 = new JSONObject(v60.a.c());     // Catch: Exception -> L5
    L8:
        if (r3 == null) goto L18;
        Iterator<String> r4 = r3.keys();
        if (r4 == null) goto L18;
    L12:
        if (r4.hasNext() == false) goto L18;
        String r7 = r4.next();
        if (r7 == null) goto L12;
        if (StringsKt.startsWith$default(r7, "rtc_ab", false, 2, null) != true) goto L12;
        r0.put(r7, c7.d(r7));
    L18:
        com.bytedance.live.datacontext.m r5 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r5 == null) goto L36;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L36;
        Map r8 = r6.getAnchorABMap();
        if (r8 == null) goto L36;
        Iterator r9 = r8.keySet().iterator();
    L26:
        if (r9.hasNext() == false) goto L36;
        String r10 = (String) r9.next();
        if (r10 == null) goto L26;
        if (StringsKt.startsWith$default(r10, "rtc_anchor_ab", false, 2, null) != true) goto L26;
        r0.put(r10, new JSONObject((String) r8.get(r10)));     // Catch: JSONException -> L33
    L33:
        e = move-exception;
        ALogger.e("rtc_ab", e);
    L36:
        return r0.toString();
    L5:
        e = move-exception;
        d6.a("SettingCache#getABTest", e);
        r3 = null;
        goto L8
    }

    static {
    }
}
