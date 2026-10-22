package com.ss.android.lark.integrator.todo.dependency;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements g7c.s {
    public k() {
    }

    public final void sendEvent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
    }

    public final void sendEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
    }
}
