package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class k extends m {
    public final long d;
    public final long e;

    public static final class a {
    }

    static {
    }

    public JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put(OpenPlatformBaseDebugger.APP_ID, this.a);
        r0.put("room_id", this.b);
        r0.put("conn_id", this.c);
        r0.put("seq", this.d);
        r0.put("time_stamp", System.currentTimeMillis());
        return r0;
    }

    public /* synthetic */ k(String r11, long r12, long r14, long r16) {
        this(r11, r12, r14, r16, 1);
    }

    public k(String r7, long r8, long r11, long r12, long r14) {
        Intrinsics.checkNotNullParameter(r7, "appId");
        super(r7, r8, r12);
        this.d = r11;
        this.e = r14;
    }
}
