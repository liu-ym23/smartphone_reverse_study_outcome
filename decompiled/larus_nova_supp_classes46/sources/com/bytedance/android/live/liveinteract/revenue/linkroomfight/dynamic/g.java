package com.bytedance.android.live.liveinteract.revenue.linkroomfight.dynamic;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.functions.Consumer;
import jd0.l;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ DynamicLinkRoomFightWidget a;

    public g(DynamicLinkRoomFightWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        l r5 = (l) r4;
        String r0 = r5.a;
        JSONObject r6 = r5.b;     // Catch: Exception -> L19
        if (r6 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual("livesdk_audience_playmode_room_watch", r0) == false) goto L25;
        Object r7 = r6.get("start_time");     // Catch: Exception -> L19
        Long r1 = null;
        if ((r7 instanceof String) == true) goto L10;
        r7 = null;
    L10:
        String r8 = (String) r7;     // Catch: Exception -> L19
        if (r8 == null) goto L13;
        r1 = Long.valueOf(CastLongProtector.parseLong(r8));     // Catch: Exception -> L19
    L13:
        g2 r9 = zi0.d.b;     // Catch: Exception -> L19
        if (r1 == null) goto L16;
        long r2 = r1.longValue();     // Catch: Exception -> L19
    L17:
        zi0.d.a = r2;     // Catch: Exception -> L19
        return;
    L16:
        r2 = 0;
        goto L17
    L25:
        return;
    L19:
        e = move-exception;
        ALogger.e(this.a.a, "regiestDynamicDataChange, Exception: " + e);
    }
}
