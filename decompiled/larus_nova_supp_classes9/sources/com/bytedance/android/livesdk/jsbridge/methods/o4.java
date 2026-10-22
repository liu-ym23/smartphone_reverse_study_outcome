package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "syncReplayStatus")
public final class o4 extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    public static final class a {

        @SerializedName("replay")
        int replay;

        public a() {
        }
    }

    public final void onTerminate() {
    }

    public o4() {
    }

    public final void invoke(Object r5, CallContext r6) throws Exception {
        a r7 = (a) r5;
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.L0;
        boolean r2 = true;
        if (r7.replay != 1) goto L5;
        boolean r1 = true;
    L6:
        Boolean r3 = Boolean.valueOf(r1);
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r3);
        HashMap r4 = new HashMap();
        if (r7.replay != 1) goto L9;
        boolean r8 = true;
    L10:
        if (r8 == false) goto L12;
        String r9 = "open";
    L13:
        r4.put("is_open", r9);
        r4.put("request_page", "live_end");
        Context r10 = r6.getContext();
        if (r10 != null) goto L16;
    L18:
        r2 = false;
    L19:
        if (r2 == false) goto L21;
        String r11 = "0";
    L22:
        r4.put("room_orientation", r11);
        r4.put("live_type", com.bytedance.android.livesdk.utils.j.a(null));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_record_status", r4, new Object[0]);
        return;
    L21:
        r11 = "1";
        goto L22
    L16:
        if (r10.getResources().getConfiguration().orientation != 1) goto L18;
    L12:
        r9 = "close";
        goto L13
    L9:
        r8 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }
}
