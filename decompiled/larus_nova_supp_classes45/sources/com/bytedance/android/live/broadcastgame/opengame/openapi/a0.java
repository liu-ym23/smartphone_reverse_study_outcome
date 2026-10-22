package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.LogLevel;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.ArrayList;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0 extends BaseOpenMethod<JSONObject> {
    public static final Map<String, LogLevel> i = null;
    public final com.bytedance.android.live.broadcastgame.opengame.j h;

    public static final class a {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "log";
    }

    static {
        LogLevel[] r0 = LogLevel.values();
        ArrayList r1 = new ArrayList(r0.length);
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        LogLevel r4 = r0[r3];
        r1.add(TuplesKt.to(r4.name(), r4));
        r3 = r3 + 1;
        goto L3
    L5:
        i = MapsKt.toMap(r1);
    }

    public a0(PluginContext r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        com.bytedance.android.live.broadcastgame.opengame.i r0 = null;
        super(r3, null);
        com.bytedance.android.live.broadcastgame.opengame.i r4 = r3.j;
        if ((r4 instanceof com.bytedance.android.live.broadcastgame.opengame.j) == false) goto L6;
        r0 = r4;
    L6:
        this.h = (com.bytedance.android.live.broadcastgame.opengame.j) r0;
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r3, CallContext r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r5 = r3.optString("log");
        LogLevel r6 = i.get(r3.optString("level"));
        if (r6 != null) goto L5;
        r6 = LogLevel.DEBUG;
    L5:
        com.bytedance.android.live.broadcastgame.opengame.j r0 = this.h;
        if (r0 == null) goto L8;
        r0.c(r5, r6);
    L8:
        r(null);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }
}
