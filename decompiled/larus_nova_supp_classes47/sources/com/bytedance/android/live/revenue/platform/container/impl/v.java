package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v {
    public final JsonObject a;
    public final View b;
    public final String c;
    public final String d;
    public final i57.a e;

    public v(JsonObject r2, View r3, String r4, String r5, i57.g r6) {
        Intrinsics.checkNotNullParameter(r2, "args");
        Intrinsics.checkNotNullParameter(r5, "channelId");
        Intrinsics.checkNotNullParameter(r6, "aioCallContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
