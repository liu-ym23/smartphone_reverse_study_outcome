package com.bytedance.android.ec.core.monitor;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q {
    public final String a;
    public final JSONObject b;

    public q(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sceneNameStr");
        this.a = r10;
        this.b = null;
    }

    public q(MonitorScenes r10, String r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        if (r11 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        String r13 = r10.getSceneName();
    L12:
        this.a = r13;
        this.b = r12;
        return;
    L11:
        r13 = r10.getSceneName() + "_" + r11;
        goto L12
    L5:
        if (StringsKt.isBlank(r11) == true) goto L8;
        r0 = false;
        goto L9
    }
}
