package com.bytedance.apm.battery.d;

import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class e extends b {
    private final BatteryManager c;
    private boolean d;
    private int e;

    public e() {
        super("battery_consume");
        this.d = false;
        this.e = -1;
        this.c = (BatteryManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("batterymanager"), BatteryManager.class, "com.obric.memorydata.plugin");
    }

    private void c(boolean r4, boolean r5) {
        if (Build.VERSION.SDK_INT < 21) goto L12;
        int r0 = this.c.getIntProperty(1);
        if (r5 == true) goto L10;
        if (r4 == false) goto L10;
        if (this.d == false) goto L10;
        a(true, Math.abs(r0 - this.e), com.bytedance.apm.battery.a.a().h());
    L10:
        this.e = r0;
        this.d = true;
        return;
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(com.bytedance.apm.battery.c.b r5, com.bytedance.apm.c.a r6) {
        r5.s(r6.d() / 1000);
    }

    @Override // com.bytedance.apm.battery.d.b
    public void b(boolean r4, boolean r5) {
        if (a() == true) goto L6;
        return;
    L6:
        if (r4 == true) goto L21;
    L13:
        boolean r6 = true;
    L14:
        c(r5, r6);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        if (com.bytedance.apm.b.k() == false) goto L19;
        com.bytedance.apm.e.e.c(com.bytedance.apm.e.b.f1308b, new String[]{"BatteryConsumeStatsImpl error: " + th.getCause()});
    L19:
        com.bytedance.services.apm.api.a.a("BatteryConsumeStatsImpl");
        return;
    L21:
        if (this.f1160b == true) goto L13;
        r6 = false;
        goto L14
    }
}
