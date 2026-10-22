package k5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e implements m5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<LinkedHashMap<Long, Long>> f10094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<LinkedHashMap<Long, Long>> f10095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<LinkedHashMap<Long, Long>> f10096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f10097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Integer> f10098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f10099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f10100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f10101h;

    public e() {
        this.f10094a = new ArrayList();
        this.f10095b = new ArrayList();
        this.f10096c = new ArrayList();
        this.f10097d = false;
        this.f10099f = 0;
        this.f10100g = 0;
        this.f10101h = 0;
    }

    private long i(List<LinkedHashMap<Long, Long>> r10) {
        if (this.f10097d == true) goto L5;
        this.f10098e = n5.a.a();
        this.f10097d = true;
    L5:
        long r11 = 0;
        if (r10 != null) goto L8;
    L18:
        return r11;
    L8:
        if (r10.isEmpty() == true) goto L18;
        int r12 = r10.size();
        if (r12 != this.f10098e.size()) goto L18;
        int r13 = 0;
    L12:
        if (r13 >= r12) goto L18;
        Iterator<Map.Entry<Long, Long>> r14 = r10.get(r13).entrySet().iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        r11 = r11 + r14.next().getValue().longValue();
        goto L15
    L17:
        r13 = r13 + 1;
        goto L12
    }

    public void a(LinkedHashMap<Long, Long> r10) {
        if (r10 == null) goto L5;
        this.f10094a.add(r10);
        return;
    }

    public void b(m5.b r12) {
        if (r12 != null) goto L5;
        this.f10095b.addAll(this.f10094a);
        return;
    L5:
        List<LinkedHashMap<Long, Long>> r13 = ((e) r12).e();
        if (r13.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.f10094a.size() == r13.size()) goto L12;
        n5.b.g("calculate proc freqTime delta size error");
        return;
    L12:
        this.f10095b.clear();
        int r10 = 0;
    L14:
        if (r10 >= this.f10094a.size()) goto L23;
        LinkedHashMap<Long, Long> r11 = this.f10094a.get(r10);
        LinkedHashMap<Long, Long> r14 = r13.get(r10);
        LinkedHashMap<Long, Long> r15 = new LinkedHashMap();
        Iterator<Map.Entry<Long, Long>> r16 = r11.entrySet().iterator();
    L17:
        if (r16.hasNext() == false) goto L22;
        Map.Entry<Long, Long> r17 = r16.next();
        Long r18 = r17.getKey();
        Long r19 = r17.getValue();
        Long r20 = r14.get(r18);
        if (r20 != null) goto L20;
        n5.b.c("calculate proc freqTime delta not found " + r18);
        goto L17
    L20:
        r15.put(r18, Long.valueOf(r19.longValue() - r20.longValue()));
        goto L17
    L22:
        this.f10095b.add(r15);
        r10 = r10 + 1;
        goto L14
    }

    public List<LinkedHashMap<Long, Long>> c() {
        return this.f10095b;
    }

    public List<LinkedHashMap<Long, Long>> d() {
        return this.f10096c;
    }

    public List<LinkedHashMap<Long, Long>> e() {
        return this.f10094a;
    }

    public long f() {
        if (this.f10099f != 0) goto L6;
        this.f10099f = i(this.f10094a);
    L6:
        return this.f10099f;
    }

    public long g() {
        if (this.f10100g != 0) goto L6;
        this.f10100g = i(this.f10095b);
    L6:
        return this.f10100g;
    }

    public long h() {
        if (this.f10101h != 0) goto L6;
        this.f10101h = i(this.f10096c);
    L6:
        return this.f10101h;
    }

    public void j(m5.b r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        e r15 = (e) r14;
        List<LinkedHashMap<Long, Long>> r10 = r15.e();
        List<LinkedHashMap<Long, Long>> r16 = r15.c();
        if (r16.isEmpty() == true) goto L9;
        r10 = r16;
    L9:
        if (this.f10096c.isEmpty() == false) goto L12;
        this.f10096c.addAll(r10);
        return;
    L12:
        int r17 = this.f10096c.size();
        if (r17 == r10.size()) goto L16;
        n5.b.g("merge freqTime size error");
        return;
    L16:
        ArrayList r11 = new ArrayList();
        int r12 = 0;
    L17:
        if (r12 >= r17) goto L26;
        LinkedHashMap<Long, Long> r13 = this.f10096c.get(r12);
        LinkedHashMap<Long, Long> r18 = r10.get(r12);
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator<Map.Entry<Long, Long>> r20 = r13.entrySet().iterator();
    L20:
        if (r20.hasNext() == false) goto L25;
        Map.Entry<Long, Long> r21 = r20.next();
        Long r22 = r21.getKey();
        Long r23 = r21.getValue();
        Long r24 = r18.get(r22);
        if (r24 != null) goto L23;
        n5.b.g("merge freqTimeDetla freq not found " + r22);
        goto L20
    L23:
        r19.put(r22, Long.valueOf(r23.longValue() + r24.longValue()));
        goto L20
    L25:
        r11.add(r19);
        r12 = r12 + 1;
        goto L17
    L26:
        this.f10096c = r11;
    }

    public void k() {
        this.f10094a.clear();
        this.f10095b.clear();
        this.f10096c.clear();
        this.f10099f = 0;
        this.f10100g = 0;
        this.f10101h = 0;
    }

    public String toString() {
        return "ProcTimeInStateInfo{freqTimeMapList=" + this.f10094a + ", freqDeltaTimeMapList=" + this.f10095b + ", totalCpuTime=" + f() + ", totalDeltaCpuTime=" + g() + ", totalMergeCpuTime=" + h() + '}';
    }
}
