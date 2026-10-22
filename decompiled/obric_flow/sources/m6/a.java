package m6;

import ai.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f20012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20013c;
    public boolean d;
    public String e;
    public final long f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f20014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f20015i;

    public a(boolean r5, long r10, String r11, boolean r12, long r13, String r14) {
        this.f20011a = r5;
        this.f20012b = r10;
        this.f20013c = r11;
        this.d = r12;
        this.f = r13;
        this.e = r14;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("BatteryLogEntity{id=0, front=");
        r5.append(this.f20011a);
        r5.append(", time=");
        r5.append(this.f20012b);
        r5.append(", type='");
        r5.append(this.f20013c);
        r5.append("', status=");
        r5.append(this.d);
        r5.append(", scene='");
        r5.append(this.e);
        r5.append("', accumulation=");
        r5.append(this.f);
        r5.append(", source='");
        r5.append(null);
        r5.append("', versionId=0, processName='");
        r5.append(this.g);
        r5.append("', mainProcess=");
        r5.append(this.f20014h);
        r5.append(", startUuid='");
        return j0.q(r5, this.f20015i, "', deleteFlag=false}");
    }
}
