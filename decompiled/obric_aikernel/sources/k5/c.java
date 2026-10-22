package k5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c implements m5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<LinkedHashMap<Long, Long>> f10081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<LinkedHashMap<Long, Long>> f10082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f10083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10084d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f10085e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f10086f;

    public c() {
        this.f10081a = new ArrayList();
        this.f10082b = new ArrayList();
        this.f10083c = 0;
        this.f10084d = 0;
        this.f10085e = 0;
        this.f10086f = 0.0d;
    }

    public void a(m5.b r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        long r11 = e() - ((c) r10).e();
        this.f10084d = r11;
        if (this.f10085e != 0) goto L8;
        this.f10085e = r11;
        return;
    }

    public void b(m5.b r12) {
        if (r12 != null) goto L5;
        this.f10082b.addAll(this.f10081a);
        return;
    L5:
        List<LinkedHashMap<Long, Long>> r13 = ((c) r12).d();
        if (r13.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.f10081a.size() == r13.size()) goto L12;
        n5.b.g("calculate cpu freqTime delta size error");
        return;
    L12:
        this.f10082b.clear();
        int r10 = 0;
    L14:
        if (r10 >= this.f10081a.size()) goto L23;
        LinkedHashMap<Long, Long> r11 = this.f10081a.get(r10);
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
        n5.b.c("calculate cpu freqTime delta not found " + r18);
        goto L17
    L20:
        r15.put(r18, Long.valueOf(r19.longValue() - r20.longValue()));
        goto L17
    L22:
        this.f10082b.add(r15);
        r10 = r10 + 1;
        goto L14
    }

    public long c() {
        return this.f10084d;
    }

    public List<LinkedHashMap<Long, Long>> d() {
        return this.f10081a;
    }

    public long e() {
        if (this.f10083c != 0) goto L14;
        if (this.f10081a.isEmpty() == true) goto L14;
        Iterator<LinkedHashMap<Long, Long>> r10 = this.f10081a.iterator();
    L8:
        if (r10.hasNext() == false) goto L14;
        Iterator<Map.Entry<Long, Long>> r11 = r10.next().entrySet().iterator();
    L11:
        if (r11.hasNext() == false) goto L8;
        this.f10083c += r11.next().getValue().longValue();
    L14:
        return this.f10083c;
    }

    public void f(LinkedHashMap<Long, Long> r10) {
        this.f10081a.add(r10);
    }

    public void g() {
        this.f10081a.clear();
        this.f10082b.clear();
        this.f10083c = 0;
        this.f10084d = 0;
        this.f10085e = 0;
        this.f10086f = 0.0d;
    }

    public void h(long r10) {
        if (this.f10084d >= 0) goto L5;
        return;
    L5:
        if (this.f10083c <= 0) goto L9;
        this.f10086f = 1.0d - (r10 / c());
        return;
    }

    public String toString() {
        return "cputime:{deltaTime:" + c() + " usage:" + this.f10086f + " totaltime:" + e() + "}";
    }
}
