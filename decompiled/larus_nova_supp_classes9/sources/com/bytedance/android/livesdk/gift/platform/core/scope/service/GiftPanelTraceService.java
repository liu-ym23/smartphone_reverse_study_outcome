package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftPanelTraceService implements com.bytedance.android.scope.o {
    public JSONArray a;
    public final CopyOnWriteArrayList<JSONObject> b;
    public JSONObject c;

    public final void onStart() {
    }

    public final void onStop() {
        com.bytedance.live.kmp.util.d.b(0, false, new AnonymousClass1(this), 7);
    }

    public GiftPanelTraceService() {
        this.a = new JSONArray();
        this.b = new CopyOnWriteArrayList();
        this.c = new JSONObject();
    }

    public final void c(final JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        com.bytedance.live.kmp.util.d.b(0, false, new GiftPanelTraceService$addStateTrace$1(this, r5), 7);
    }

    public final void d(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "traceInfo");
        com.bytedance.live.kmp.util.d.b(0, false, new GiftPanelTraceService$addTraceString$1(this, r5), 7);
    }

    public final void a(final String r4, final String r5) {
        Intrinsics.checkNotNullParameter(r4, "actionName");
        Intrinsics.checkNotNullParameter(r5, "actionInfo");
        com.bytedance.live.kmp.util.d.b(0, false, new GiftPanelTraceService$addActionTrace$1(this, r4, r5), 7);
    }
}
