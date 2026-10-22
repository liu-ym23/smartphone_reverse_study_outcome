package k5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements m5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<List<Long>> f10062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<List<Long>> f10063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f10064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f10066e;

    public a() {
        this.f10062a = new ArrayList();
        this.f10063b = new ArrayList();
        this.f10064c = 0;
        this.f10065d = 0;
        this.f10066e = 0;
    }

    public void a(m5.b r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        long r11 = e() - ((a) r10).e();
        this.f10065d = r11;
        if (this.f10066e != 0) goto L8;
        this.f10066e = r11;
        return;
    }

    public void b(m5.b r12) {
        if (r12 != null) goto L5;
        this.f10063b.addAll(this.f10062a);
        return;
    L5:
        List<List<Long>> r13 = ((a) r12).c();
        if (r13.isEmpty() == false) goto L8;
        return;
    L8:
        int r10 = this.f10062a.size();
        if (r10 == r13.size()) goto L12;
        n5.b.g("calculate cpu idle time delta size error1");
        return;
    L12:
        this.f10063b.clear();
        int r11 = 0;
    L13:
        if (r11 >= r10) goto L32;
        List<Long> r14 = this.f10062a.get(r11);
        List<Long> r15 = r13.get(r11);
        ArrayList r16 = new ArrayList();
        if (r14 == null) goto L25;
        if (r15 == null) goto L25;
        if (r14.size() != r15.size()) goto L25;
        int r17 = 0;
    L22:
        if (r17 >= r14.size()) goto L24;
        r16.add(Long.valueOf(r14.get(r17).longValue() - r15.get(r17).longValue()));
        r17 = r17 + 1;
        goto L22
    L24:
        this.f10063b.add(r16);
        r11 = r11 + 1;
    L25:
        n5.b.g("calculate cpu idle time delta size error2");
        return;
    }

    public List<List<Long>> c() {
        return this.f10062a;
    }

    public long d() {
        return this.f10065d;
    }

    public long e() {
        if (this.f10064c != 0) goto L14;
        if (this.f10062a.isEmpty() == true) goto L14;
        Iterator<List<Long>> r10 = this.f10062a.iterator();
    L8:
        if (r10.hasNext() == false) goto L14;
        Iterator<Long> r11 = r10.next().iterator();
    L11:
        if (r11.hasNext() == false) goto L8;
        this.f10064c += r11.next().longValue();
    L14:
        return this.f10064c;
    }

    public void f(List<Long> r10) {
        if (r10 == null) goto L5;
        this.f10062a.add(r10);
        return;
    }

    public void g() {
        this.f10062a.clear();
        this.f10063b.clear();
        this.f10064c = 0;
        this.f10065d = 0;
        this.f10066e = 0;
    }

    public String toString() {
        return "CpuIdleTimeStatInfo{stateTimeLists=" + this.f10062a + ", stateDeltaTimeLists=" + this.f10063b + ", totalCpuIdleTime=" + this.f10064c + ", deltaCpuIdleTime=" + this.f10065d + ", mergedDeltaCpuIdleTime=" + this.f10066e + '}';
    }
}
