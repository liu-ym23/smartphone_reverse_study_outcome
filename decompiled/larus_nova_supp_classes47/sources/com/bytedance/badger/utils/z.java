package com.bytedance.badger.utils;

import com.bytedance.bd_sec_tee.core.TeeProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z implements TeeProvider.b {
    public z() {
    }

    public final void onEvent(JSONObject r2) {
        com.bytedance.badger.e.d("tee_result_monitor", r2);
    }
}
