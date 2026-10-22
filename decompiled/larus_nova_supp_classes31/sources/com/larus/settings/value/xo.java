package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class xo implements Function0 {
    public /* synthetic */ xo() {
    }

    public final Object invoke() {
        JsonObject r0 = ((INovaSetting) SettingsManager.obtain(INovaSetting.class)).customPreInstallUpdateConfig();
        if (r0 == null) goto L9;
        JsonElement r1 = r0.get("update_enable");
        if (r1 == null) goto L9;
        JsonPrimitive r2 = r1.getAsJsonPrimitive();
        if (r2 == null) goto L9;
        boolean r3 = r2.getAsBoolean();
    L11:
        return Boolean.valueOf(r3);
    L9:
        r3 = false;
        goto L11
    }
}
