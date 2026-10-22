package com.bytedance.android.livesdk.gecko;

import android.text.TextUtils;
import com.ss.android.common.lib.AppLogNewUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements az5.a {
    public m() {
    }

    public final void a(String r2, JSONObject r3) {
        if (TextUtils.isEmpty(r2) == true) goto L7;
        if (r3 == null) goto L8;
        AppLogNewUtils.onEventV3(r2, r3);
        return;
    L8:
        return;
    }
}
