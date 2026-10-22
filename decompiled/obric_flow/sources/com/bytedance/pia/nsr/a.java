package com.bytedance.pia.nsr;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends yg.d {
    public final /* synthetic */ int d;
    public final Object e;

    public a() {
        this.d = 0;
        this.e = new LinkedHashMap();
    }

    @Override // yg.d
    public final void a() {
        Object r5 = this.e;
        JsonObject r10 = this.f23265a;
        switch(this.d) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        JsonObject r11 = new JsonObject();
        r11.add("timing", r10);
        com.bytedance.pia.core.utils.j.B("on page ready: " + r11);
        ((nh.d) ((p) r5).f23312b).f20250v.c("pia.onPageReady", r11);
        return;
    L6:
        Iterator<T> r12 = r10.entrySet().iterator();
    L8:
        if (r12.hasNext() == false) goto L18;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        JsonElement r15 = (JsonElement) r13.getValue();
        if (r15 == null) goto L8;
        if (r15.isJsonObject() == false) goto L8;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L16
        JsonObject r17 = r15.getAsJsonObject();     // Catch: Throwable -> L16
        long r18 = r17.get("s").getAsJsonPrimitive().getAsLong();     // Catch: Throwable -> L16
        Result.m124constructorimpl((Long) ((LinkedHashMap) r5).put(r14, Long.valueOf(r17.get("e").getAsJsonPrimitive().getAsLong() - r18)));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public a(p r5) {
        this.d = 1;
        this.e = r5;
    }
}
