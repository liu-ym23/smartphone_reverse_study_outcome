package com.obric.aiagent.plugin_api;

import android.text.TextUtils;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.ZeusPluginStateListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class PluginService$1 extends ZeusPluginStateListener {
    final /* synthetic */ PluginService$OnPluginInstallListener val$listener;

    public PluginService$1(PluginService$OnPluginInstallListener r1) {
        this.val$listener = r1;
    }

    public void onPluginStateChange(String r1, int r2, Object... r3) {
        if (TextUtils.equals(r1, BuildConfig.PLUGIN_PKG_NAME) == true) goto L5;
        return;
    L5:
        if (r2 != 6) goto L12;
        PluginService$OnPluginInstallListener r4 = this.val$listener;
        if (r4 == null) goto L9;
        r4.onInstallSuccess();
    L9:
        Zeus.unregisterPluginStateListener(this);
        return;
    }
}
