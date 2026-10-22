package com.bytedance.bdinstall.callback.event;

import android.text.TextUtils;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class Monitor {
    public Monitor() {
    }

    protected abstract JSONObject getEventParam();

    public void onEvent(InstallOptions r10, String r11) {
        JSONObject r12 = getEventParam();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getEventDepend() == null) goto L14;
        r10.getEventDepend().onEvent(r11, r12);
        if (TextUtils.isEmpty(r11) == true) goto L9;
        DrLog.d("EventTracking# " + r11 + r10.getAid() + ", " + r12);
    L9:
        reset();
        if (TextUtils.isEmpty(r11) == true) goto L15;
        DrLog.d("EventTracking# " + r11 + r10.getAid() + " reset.");
        return;
    L15:
        return;
    }

    protected abstract void reset();
}
