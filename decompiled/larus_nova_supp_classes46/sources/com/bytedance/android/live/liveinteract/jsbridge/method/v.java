package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public final DataCenter a;

    public v(DataCenter r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2, CallContext r3) throws Exception {
        JSONObject r4 = (JSONObject) r2;
        String r5 = r4.optString("sec_target_uid");
        String r6 = r4.optString("target_uid");
        IBaseUser r0 = vh7.f.c(IBaseUser.class);
        r0.setIdString(r6);
        r0.setCastSecUid(r5);
        DataCenter r7 = this.a;
        if (r7 == null) goto L7;
        r7.put("cmd_interact_audience_invite", r0);
        return null;
    L7:
        return null;
    }
}
