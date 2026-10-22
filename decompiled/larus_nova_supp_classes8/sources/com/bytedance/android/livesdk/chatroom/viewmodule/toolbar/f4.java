package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f4 {
    static {
    }

    @JvmStatic
    public static final Map<String, String> a(DataCenter r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        if (r3 != null) goto L6;
        r3 = new HashMap();
    L6:
        if (com.bytedance.android.live.core.utils.z.k(r2) == true) goto L8;
        return r3;
    L8:
        r3.put("live_type", "media");
        RoomContext.Companion.getClass();
        RoomContext r4 = RoomContext.a.a(r2, 0);
        if (r4 != null) goto L12;
        return r3;
    L12:
        if (((Number) r4.getMediaReviewStatus().getValue()).intValue() < 5) goto L14;
        String r5 = "1";
    L15:
        r3.put("live_status", r5);
        return r3;
    L14:
        r5 = "0";
        goto L15
    }
}
