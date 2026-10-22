package com.bytedance.android.livesdk.interactivity.interactive;

import android.text.TextUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g0 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
    public final /* synthetic */ LiveInteractiveHelper a;

    public g0(LiveInteractiveHelper r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, CallContext r4) {
        JSONObject r5 = (JSONObject) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r6 = r5.optString("key");
        String r0 = null;
        if (TextUtils.isEmpty(r6) == true) goto L8;
        com.bytedance.android.livesdk.chatroom.x<String, String> r7 = this.a.e;
        if (r7 == null) goto L7;
        r0 = (String) r7.get(this.a.j() + r6);
    L7:
        int r8 = 1;
    L9:
        JSONObject r9 = new JSONObject();
        r9.put("code", r8);
        r9.put("value", r0);
        return r9;
    L8:
        r8 = 0;
        goto L9
    }
}
