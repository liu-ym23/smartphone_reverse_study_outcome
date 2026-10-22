package com.bytedance.bdinstall.callback.event;

import android.text.TextUtils;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class Monitor {
    public Monitor() {
    }

    public abstract JSONObject getEventParam();

    public void onEvent(InstallOptions r5, String r6) {
        JSONObject r0 = getEventParam();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getEventDepend() == null) goto L14;
        r5.getEventDepend().onEvent(r6, r0);
        if (TextUtils.isEmpty(r6) == true) goto L9;
        DrLog.d("EventTracking# " + r6 + r5.getAid() + ", " + r0);
    L9:
        reset();
        if (TextUtils.isEmpty(r6) == true) goto L15;
        DrLog.d("EventTracking# " + r6 + r5.getAid() + " reset.");
        return;
    L15:
        return;
    }

    public abstract void reset();
}
