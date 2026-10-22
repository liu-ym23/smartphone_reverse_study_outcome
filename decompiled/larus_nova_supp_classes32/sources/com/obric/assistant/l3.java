package com.obric.assistant;

import com.google.gson.JsonObject;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class l3 implements Function0 {
    public final /* synthetic */ ObricSettingsServiceImpl a;

    public /* synthetic */ l3(ObricSettingsServiceImpl r1) {
        this.a = r1;
    }

    public final Object invoke() {
        JsonObject r0 = this.a.c.getObricScreenshotUploadConfig();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new JsonObject();
    }
}
