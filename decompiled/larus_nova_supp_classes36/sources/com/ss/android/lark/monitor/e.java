package com.ss.android.lark.monitor;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class e extends d {
    protected boolean isAppFront;
    protected i mMetricsConfig;

    public abstract void pauseScene(String r1);

    public abstract void startScene(String r1);

    public abstract void stopScene(String r1, JSONObject r2);

    public e() {
    }

    public e(i r1) {
        this.mMetricsConfig = r1;
    }
}
