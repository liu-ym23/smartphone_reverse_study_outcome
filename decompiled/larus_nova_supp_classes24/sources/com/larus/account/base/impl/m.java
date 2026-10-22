package com.larus.account.base.impl;

import kotlin.Unit;
import n38.c0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m implements n38.y {
    public final /* synthetic */ n38.y a;
    public final /* synthetic */ long b;

    @Override // n38.y
    public final void b(c0 r6) {
        this.a.b(r6);
        com.larus.platform.service.o r7 = com.larus.platform.service.o.a;
        JSONObject r0 = new JSONObject();
        long r1 = this.b;
        r0.put("success", 1);
        r0.put("cost", System.currentTimeMillis() - r1);
        Unit r2 = Unit.INSTANCE;
        r7.reportEvent("get_carrier_result", r0);
    }

    public m(n38.y r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // n38.y
    public final void a(String r6, String r7) {
        this.a.a(r6, r7);
        com.larus.platform.service.o r8 = com.larus.platform.service.o.a;
        JSONObject r0 = new JSONObject();
        long r1 = this.b;
        r0.put("success", 0);
        r0.put("error_msg", r7);
        r0.put("cost", System.currentTimeMillis() - r1);
        Unit r9 = Unit.INSTANCE;
        r8.reportEvent("get_carrier_result", r0);
    }
}
