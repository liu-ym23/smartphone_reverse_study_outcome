package i5;

import android.os.SystemClock;
import g5.c;
import n5.b;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f9377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f9378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9379c;

    public a(c r10) {
        this.f9378b = false;
        this.f9377a = r10;
    }

    private void c() {
        long r10 = SystemClock.elapsedRealtime();
        long r11 = this.f9379c;
        if (r11 != 0) goto L5;
    L6:
        this.f9379c = r10;
        float r12 = this.f9377a.b();
        int r13 = this.f9377a.e();
        int r14 = this.f9377a.d();
        boolean r15 = false;
        if (r12 <= this.f9377a.getConfig().c()) goto L9;
        boolean r16 = false;
    L11:
        if (r13 >= this.f9377a.getConfig().b()) goto L13;
        r16 = false;
    L13:
        if (r14 == 1) goto L16;
        r15 = r16;
    L16:
        b.e("updateCpuSampleEnvironment:" + r15 + ", temp:" + r12 + ", level:" + r13 + ", powerSave:" + r14);
        this.f9378b = r15;
        return;
    L9:
        r16 = true;
        goto L11
    L5:
        if ((r10 - r11) >= 5000) goto L6;
    }

    public boolean a(float r10) {
        if (b() == true) goto L6;
        b.e("isAbnormalProcess false, cpuSpeed " + r10 + ", not sample environment");
        return false;
    L6:
        g5.a.C0173a r11 = this.f9377a.getConfig().a();
        if (r11 != null) goto L11;
        StringBuilder r12 = new StringBuilder();
        r12.append("isAbnormalProcess true, cpuSpeed ");
        r12.append(r10);
        r12.append(", configSpeed:null");
    L9:
        b.e(r12.toString());
        return true;
    L11:
        float r13 = r11.b();
        float r14 = r11.a();
        if (r10 >= r13) goto L14;
        return false;
    L14:
        if (r14 <= 0.0d) goto L21;
        c.b r15 = this.f9377a.c();
        if (r15 == null) goto L21;
        b.e("isAbnormalProcess true, cpuSpeed " + r10 + ", configSpeed:" + r13 + ", bigCorePercent:" + r15.f8997o + ", config bigCorePercent:" + r14);
        if (r15.f8997o > r14) goto L20;
        return false;
    L20:
        return true;
    L21:
        r12 = new StringBuilder();
        r12.append("isAbnormalProcess true, cpuSpeed ");
        r12.append(r10);
        r12.append(", configSpeed:");
        r12.append(r13);
        goto L9
    }

    public boolean b() {
        c();
        return this.f9378b;
    }
}
