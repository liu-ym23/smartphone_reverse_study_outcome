package com.bytedance.bdlocation.trace;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface LocationTraceListener {
    void onTraceFinish(String r8, JSONObject r10, JSONObject r11, JSONObject r12);
}
