package com.bytedance.apm.battery.d;

import android.content.Context;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile boolean f1159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f1160b;
    private final String c;
    private final boolean d;

    b(String r3) {
        this.c = r3;
        this.d = com.bytedance.apm.b.f();
        this.f1159a = ActivityLifeObserver.getInstance().isForeground();
        this.f1160b = com.bytedance.apm.battery.e.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(boolean r2) {
        b(this.f1159a, r2);
        this.f1159a = false;
    }

    void a(boolean r11, long r12, String r14) {
        if (r12 < 0) goto L5;
        com.bytedance.apm.battery.c.a.a().a(new com.bytedance.apm.c.a(r11, System.currentTimeMillis(), this.c, this.f1160b, r12, r14));
        return;
    L5:
        if (com.bytedance.apm.b.k() == false) goto L7;
        com.bytedance.apm.e.e.c(com.bytedance.apm.e.b.f1308b, new String[]{"AbsBatteryValueStats value error: " + r12 + " type:" + this.c});
    L7:
        com.bytedance.apm.e.a.b("APM-Battery", "AbsBatteryValueStats value error: " + r12 + " type:" + this.c);
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(boolean r2, boolean r3) {
        b(this.f1159a, r3);
        this.f1160b = r2;
    }

    public boolean a() {
        return this.d;
    }

    @Override // com.bytedance.apm.battery.d.l
    public void b(boolean r2) {
        b(this.f1159a, r2);
        this.f1159a = true;
    }

    public abstract void b(boolean r1, boolean r2);

    @Override // com.bytedance.apm.battery.d.l
    public void c(boolean r2) {
        b(this.f1159a, r2);
    }
}
