package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g5 implements n56.c {
    public g5() {
    }

    public void call(n56.f r3, JSONObject r4) throws Exception {
        int r1 = 0;
        if ("follow".equals(JSONObjectProtectorUtils.getString(r3.d, "type")) == false) goto L17;
        JSONObject r5 = JSONObjectProtectorUtils.getJSONObject(r3.d, "args");
        if (r5 == null) goto L17;
        FollowPair r6 = (FollowPair) JsonUtil.parse(r5.toString(), FollowPair.class);     // Catch: Exception -> L13
        if (r6 == null) goto L10;
        r6.setType(IFollowPair.Type.FromWeb);     // Catch: Exception -> L13
        jc1.k.f(IUserService.class).user().z(r6);     // Catch: Exception -> L13
    L10:
        r1 = 1;
    L17:
        r4.put("code", r1);     // Catch: JSONException -> L14
        return;
    }
}
