package com.bytedance.crash.resource.gwpasan;

import android.util.Log;
import com.bytedance.crash.resource.ResourceMonitorConfig;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class GwpAsanConfig extends ResourceMonitorConfig {
    private static final String LOG_TAG = "XASAN";
    private String mConfigStr;
    private final String[] xasan_cfg_name;

    public GwpAsanConfig(JSONArray r12) {
        int r2 = 0;
        super(21, 33, 0);
        this.mConfigStr = null;
        this.xasan_cfg_name = new String[]{"enableXasan", "debug", "maxSimultaneousAlloc", "sampleRate", "monitorAllocSize", "monitorType", "monitorBugType", "soName"};
        if (r12 != null) goto L5;
    L15:
        Log.e(LOG_TAG, "Config Init fail");
        return;
    L5:
        if (r12.length() >= 10) goto L15;
        StringBuilder r1 = new StringBuilder();
    L9:
        if (r2 >= r12.length()) goto L13;
        String[] r3 = this.xasan_cfg_name;
        if (r2 >= r3.length) goto L13;
        r1.append(r3[r2]);
        r1.append("=");
        r1.append(r12.optString(r2));
        r1.append("\n");
        r2 = r2 + 1;
    L13:
        this.mConfigStr = r1.toString();
        Log.d(LOG_TAG, "Config Init:" + this.mConfigStr);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorConfig
    public String toString() {
        return this.mConfigStr;
    }
}
