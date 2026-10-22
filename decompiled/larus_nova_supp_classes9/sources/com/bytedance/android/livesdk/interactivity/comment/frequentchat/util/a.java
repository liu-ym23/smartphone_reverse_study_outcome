package com.bytedance.android.livesdk.interactivity.comment.frequentchat.util;

import am2.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r3, Boolean r4, Map r5) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 == null) goto L5;
        boolean r6 = r4.booleanValue();
    L6:
        if (r6 == false) goto L8;
        String r7 = "anchor";
    L9:
        r0.put("role", r7);
        if (r5 == null) goto L12;
        r0.putAll(r5);
    L12:
        j0.l().sendLog(r3, r0, new Object[]{IRoom.class, x.class});
        return;
    L8:
        r7 = "admin";
        goto L9
    L5:
        r6 = false;
        goto L6
    }
}
