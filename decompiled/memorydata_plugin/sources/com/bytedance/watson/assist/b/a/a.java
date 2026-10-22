package com.bytedance.watson.assist.b.a;

import android.os.SystemClock;
import com.bytedance.watson.assist.a.c;
import com.bytedance.watson.assist.d.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f3367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3368b;
    private long c;

    public a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.f3368b = false;
        this.f3367a = r4;
    }

    private void b() {
        long r0 = SystemClock.elapsedRealtime();
        long r2 = this.c;
        if (r2 != 0) goto L5;
    L6:
        this.c = r0;
        float r1 = this.f3367a.f();
        int r3 = this.f3367a.e();
        int r4 = this.f3367a.d();
        boolean r5 = false;
        if (r1 <= this.f3367a.a().b()) goto L9;
        boolean r6 = false;
    L11:
        if (r3 >= this.f3367a.a().c()) goto L13;
        r6 = false;
    L13:
        if (r4 == 1) goto L16;
        r5 = r6;
    L16:
        b.b("updateCpuSampleEnvironment:" + r5 + ", temp:" + r1 + ", level:" + r3 + ", powerSave:" + r4);
        this.f3368b = r5;
        return;
    L9:
        r6 = true;
        goto L11
    L5:
        if ((r0 - r2) >= 5000) goto L6;
    }

    public boolean a() {
        b();
        return this.f3368b;
    }

    public boolean a(float r10) {
        if (a() == true) goto L6;
        b.b("isAbnormalProcess false, cpuSpeed " + r10 + ", not sample environment");
        return false;
    L6:
        com.bytedance.watson.assist.a.a.C0169a r0 = this.f3367a.a().a();
        if (r0 != null) goto L11;
        StringBuilder r9 = new StringBuilder().append("isAbnormalProcess true, cpuSpeed ").append(r10).append(", configSpeed:null");
    L9:
        b.b(r9.toString());
        return true;
    L11:
        float r4 = r0.a();
        float r1 = r0.b();
        if (r10 >= r4) goto L14;
        return false;
    L14:
        if (r1 <= 0.0d) goto L21;
        c.b r11 = this.f3367a.h();
        if (r11 == null) goto L21;
        b.b("isAbnormalProcess true, cpuSpeed " + r10 + ", configSpeed:" + r4 + ", bigCorePercent:" + r11.o + ", config bigCorePercent:" + r1);
        if (r11.o > r1) goto L20;
        return false;
    L20:
        return true;
    L21:
        r9 = new StringBuilder().append("isAbnormalProcess true, cpuSpeed ").append(r10).append(", configSpeed:").append(r4);
        goto L9
    }
}
