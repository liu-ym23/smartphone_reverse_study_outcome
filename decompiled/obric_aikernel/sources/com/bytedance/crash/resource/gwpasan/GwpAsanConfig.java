package com.bytedance.crash.resource.gwpasan;

import android.util.Log;
import com.bytedance.crash.resource.ResourceMonitorConfig;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class GwpAsanConfig extends ResourceMonitorConfig {
    private static final String LOG_TAG = "XASAN";
    private String mConfigStr;
    private final String[] xasan_cfg_name;

    public GwpAsanConfig(JSONArray r12) {
        int r10 = 0;
        super(21, 33, 0);
        this.mConfigStr = null;
        this.xasan_cfg_name = new String[]{"enableXasan", "debug", "maxSimultaneousAlloc", "sampleRate", "monitorAllocSize", "monitorType", "monitorBugType", "soName"};
        if (r12 != null) goto L5;
    L15:
        Log.e(LOG_TAG, "Config Init fail");
        return;
    L5:
        if (r12.length() >= 10) goto L15;
        StringBuilder r11 = new StringBuilder();
    L9:
        if (r10 >= r12.length()) goto L13;
        String[] r13 = this.xasan_cfg_name;
        if (r10 >= r13.length) goto L13;
        r11.append(r13[r10]);
        r11.append("=");
        r11.append(r12.optString(r10));
        r11.append("\n");
        r10 = r10 + 1;
    L13:
        this.mConfigStr = r11.toString();
        Log.d(LOG_TAG, "Config Init:" + this.mConfigStr);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorConfig
    public String toString() {
        return this.mConfigStr;
    }
}
