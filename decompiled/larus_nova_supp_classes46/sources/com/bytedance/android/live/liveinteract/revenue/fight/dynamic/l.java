package com.bytedance.android.live.liveinteract.revenue.fight.dynamic;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Consumer {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public final void accept(Object r3) {
        jd0.l r4 = (jd0.l) r3;
        String r0 = r4.a;
        JSONObject r5 = r4.b;     // Catch: Exception -> L19
        if (r5 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual("livesdk_audience_playmode_room_watch", r0) == false) goto L25;
        Object r6 = r5.get("start_time");     // Catch: Exception -> L19
        Long r1 = null;
        if ((r6 instanceof String) == true) goto L10;
        r6 = null;
    L10:
        String r7 = (String) r6;     // Catch: Exception -> L19
        if (r7 == null) goto L13;
        r1 = Long.valueOf(CastLongProtector.parseLong(r7));     // Catch: Exception -> L19
    L13:
        li0.b r8 = li0.b.b;     // Catch: Exception -> L19
        if (r1 == null) goto L16;
        long r2 = r1.longValue();     // Catch: Exception -> L19
    L17:
        li0.b.a = r2;     // Catch: Exception -> L19
        return;
    L16:
        r2 = 0;
        goto L17
    L25:
        return;
    L19:
        e = move-exception;
        ALogger.e("DynamicTeamFightWidget", "regiestDynamicDataChange, Exception: " + e);
    }
}
