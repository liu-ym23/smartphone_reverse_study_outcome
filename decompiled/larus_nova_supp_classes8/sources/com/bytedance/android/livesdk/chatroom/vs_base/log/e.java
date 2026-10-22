package com.bytedance.android.livesdk.chatroom.vs_base.log;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(boolean r2, DataCenter r3, String r4, String r5) {
        if (r3 == null) goto L9;
        d r6 = d.a(r3);
        Pair[] r0 = new Pair[3];
        if (r2 == false) goto L6;
        String r7 = "1";
    L7:
        r0[0] = TuplesKt.to("success", r7);
        r0[1] = TuplesKt.to("old_resolution", String.valueOf(r4));
        r0[2] = TuplesKt.to("playback_resolution", String.valueOf(r5));
        r6.e("livesdk_replay_switch_resolution", MapsKt.mutableMapOf(r0), new Object[0]);
        return;
    L6:
        r7 = "0";
        goto L7
    }
}
