package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.net.Uri;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w {
    public static Uri a(Uri r5, DataCenter r6) {
        if (r6 != null) goto L4;
        return r5;
    L4:
        Uri.Builder r0 = r5.buildUpon();
        Episode r1 = (Episode) r6.get("data_vs_episode_data", null);
        if (r1 == null) goto L20;
        if (r1.isReplay() == false) goto L20;
        HashMap r2 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r3 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r6).c(am2.a0.class);
        com.bytedance.android.livesdk.log.filter.o r4 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r6).c(am2.b0.class);
        if (r3 == null) goto L11;
        r3.a(r2);
    L11:
        if (r4 == null) goto L13;
        r4.a(r2);
    L13:
        Iterator r7 = r2.entrySet().iterator();
    L15:
        if (r7.hasNext() == false) goto L20;
        Map.Entry r8 = (Map.Entry) r7.next();
        if (UriProtector.getQueryParameter(r5, (String) r8.getKey()) != null) goto L15;
        r0.appendQueryParameter((String) r8.getKey(), (String) r8.getValue());
    L20:
        if (UriProtector.getQueryParameter(r5, "is_vs") != null) goto L23;
        r0.appendQueryParameter("is_vs", "1");
    L23:
        if (UriProtector.getQueryParameter(r5, "vs_screen_type") != null) goto L29;
        if (((Boolean) r6.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L27;
        r0.appendQueryParameter("vs_screen_type", "portrait");
        r0.appendQueryParameter("is_hor", "0");
        goto L29
    L27:
        r0.appendQueryParameter("vs_screen_type", "landscape");
        r0.appendQueryParameter("is_hor", "1");
    L29:
        return r0.build();
    }
}
