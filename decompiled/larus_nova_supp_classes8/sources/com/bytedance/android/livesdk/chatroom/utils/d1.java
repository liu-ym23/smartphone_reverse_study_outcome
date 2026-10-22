package com.bytedance.android.livesdk.chatroom.utils;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.message.DistributionStatusMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d1<V> implements Callable {
    public final /* synthetic */ DistributionStatusMessage a;

    public d1(DistributionStatusMessage r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        Map r0 = this.a.extra;
        if (r0 == null) goto L5;
        String r1 = (String) r0.get("event_src");
    L7:
        if (TextUtils.equals(r1, "subscribe_resp") == false) goto L9;
        String r2 = "3";
    L10:
        HashMap r3 = new HashMap();
        r3.put("room_id", String.valueOf(this.a.roomId));
        r3.put("anchor_id", String.valueOf(this.a.anchorUid));
        r3.put("source", String.valueOf(this.a.distributionStatus));
        r3.put("live_status", String.valueOf(this.a.liveStatus));
        r3.put("notify_type", String.valueOf(this.a.notifyType));
        r3.put("messageType", r2);
        long r4 = System.currentTimeMillis();
        Long r5 = this.a.eventTimeMs;
        if (r5 == null) goto L13;
        long r6 = r5.longValue();
    L14:
        r3.put("event_delay_ms", String.valueOf(r4 - r6));
        r3.put("enter_from_merge", "inner_feed");
        r3.put("enter_method", "inner_feed");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_serve_status_result", r3, new Object[0]);
        return;
    L13:
        r6 = 0;
        goto L14
    L9:
        r2 = "4";
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
