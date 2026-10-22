package com.bytedance.android.ec.core.monitor;

import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h<V> implements Callable {
    public final /* synthetic */ ECMonitorService a;
    public final /* synthetic */ String b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ JSONObject d;
    public final /* synthetic */ JSONObject e;

    public h(ECMonitorService r1, String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        com.bytedance.android.ec.sdk.helper.g r0 = com.bytedance.android.ec.sdk.helper.g.a;     // Catch: Throwable -> L22
        String r1 = this.b;     // Catch: Throwable -> L22
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L22
        ECMonitorService r11 = this.a;     // Catch: Throwable -> L22
        List r12 = CollectionsKt.listOf(new JSONObject[]{this.c, this.d, this.e});     // Catch: Throwable -> L22
        int r13 = ECMonitorService.b;     // Catch: Throwable -> L22
        r11.getClass();     // Catch: Throwable -> L22
        Iterator r14 = r12.iterator();     // Catch: Throwable -> L22
    L4:
        if (r14.hasNext() == false) goto L20;
        JSONObject r15 = (JSONObject) r14.next();     // Catch: Throwable -> L22
        if (r15 == null) goto L4;
        Iterator<String> r16 = r15.keys();     // Catch: Throwable -> L22
        if (r16 == null) goto L4;
    L10:
        if (r16.hasNext() == false) goto L4;
        String r17 = r16.next();     // Catch: Throwable -> L22
        String r18 = r15.optString(r17);     // Catch: Throwable -> L22
        if (r18.length() <= 0) goto L14;
        boolean r19 = true;
    L15:
        if (r19 == true) goto L18;
        r18 = null;
    L18:
        if (r18 == null) goto L10;
        r10.put(r17, r18);     // Catch: Throwable -> L22
        goto L10
    L14:
        r19 = false;
        goto L15
    L20:
        r10.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);     // Catch: Throwable -> L22
        r10.put("EVENT_FUNCTION_FEATURE", "TEMAI_MONITOR");     // Catch: Throwable -> L22
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L22
        r0.logV3(r1, r10);     // Catch: Throwable -> L22
        return Unit.INSTANCE;
    L22:
        th = move-exception;
        return Integer.valueOf(Log.w("ECMonitorService", "post event failed: " + this.b, th));
    }
}
