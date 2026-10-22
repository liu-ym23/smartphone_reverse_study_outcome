package com.bytedance.ug.cloud;

import com.ss.android.common.lib.AppLogNewUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class e implements j {
    e() {
    }

    @Override // com.bytedance.ug.cloud.j
    public void a(String r1, JSONObject r2) {
        AppLogNewUtils.onEventV3(r1, r2);
    }
}
