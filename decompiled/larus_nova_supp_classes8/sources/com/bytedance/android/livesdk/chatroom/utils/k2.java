package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livehostapi.business.IHostBusiness;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k2 implements com.bytedance.android.livesdk.log.filter.v {
    public static final k2 a = null;

    public k2() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        a = new k2();
    }

    public final void L9(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        switch(r2.hashCode()) {
            case -1772881225: goto L18;
            case -1115849514: goto L15;
            case 479193863: goto L12;
            case 1499179894: goto L9;
            case 1499265855: goto L6;
            default: goto L35;
        };
    L35:
        return;
    L6:
        if (r2.equals("livesdk_live_show") == false) goto L28;
    L26:
        IHostBusiness r4 = jc1.k.f(IHostBusiness.class);     // Catch: Throwable -> L25
        if (r4 != null) goto L22;
        return;
    L22:
        if (r4.hasPadContinus() != true) goto L34;
        r3.put("url_source", "app_continued");     // Catch: Throwable -> L25
        return;
    L34:
        return;
    L36:
        return;
    L28:
        return;
    L9:
        if (r2.equals("livesdk_live_play") == true) goto L26;
        return;
    L12:
        if (r2.equals("livesdk_rec_live_play") == true) goto L26;
        return;
    L15:
        if (r2.equals("livesdk_live_duration") == true) goto L26;
        return;
    L18:
        if (r2.equals("livesdk_live_duration_new") == true) goto L26;
    }
}
