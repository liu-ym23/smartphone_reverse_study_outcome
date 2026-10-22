package com.obric.assistant;

import com.google.gson.JsonObject;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class p2 implements Function0 {
    public final /* synthetic */ ObricSettingsServiceImpl a;

    public /* synthetic */ p2(ObricSettingsServiceImpl r1) {
        this.a = r1;
    }

    public final Object invoke() {
        JsonObject r0 = this.a.c.getObricAppIntentScreenshotCacheConfig();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new JsonObject();
    }
}
