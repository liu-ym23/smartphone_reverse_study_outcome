package com.bytedance.android.live.liveinteract.wrds;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r3, long r4, long r6, String r8, long r9, TalkRoomBusinessFullLinkMonitor.WrdsStatusType r11) {
        Intrinsics.checkNotNullParameter(r3, "apiName");
        Intrinsics.checkNotNullParameter(r8, "uid");
        Intrinsics.checkNotNullParameter(r11, "wrdsStatusType");
        long r1 = System.currentTimeMillis() - r4;
        JSONObject r5 = new JSONObject();
        r5.put("status", r11.getCode());
        r5.put("api_name", r3);
        JSONObject r7 = new JSONObject();
        r7.put("duration", r1);
        JSONObject r10 = new JSONObject();
        r10.put("version", r6);
        r10.put("room_id", r9);
        r10.put("uid", r8);
        LiveTracingMonitor.f("ttlive_wrds_request_duration", LiveTracingMonitor.EventModule.WRDS, r5, r7, r10);
    }
}
