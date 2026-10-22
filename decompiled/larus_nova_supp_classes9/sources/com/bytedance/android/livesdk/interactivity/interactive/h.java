package com.bytedance.android.livesdk.interactivity.interactive;

import android.text.TextUtils;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
    public final /* synthetic */ LiveInteractiveAnnieXHelper a;

    public h(LiveInteractiveAnnieXHelper r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4, CallContext r5) {
        JSONObject r6 = (JSONObject) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        String r7 = r6.optString("key");
        String r8 = r6.optString("value", BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(r7) == true) goto L8;
        com.bytedance.android.livesdk.chatroom.x<String, String> r0 = this.a.g;
        if (r0 == null) goto L7;
        r0.put(this.a.j() + r7, r8);
    L7:
        int r9 = 1;
    L9:
        JSONObject r10 = new JSONObject();
        r10.put("code", r9);
        return r10;
    L8:
        r9 = 0;
        goto L9
    }
}
