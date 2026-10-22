package com.bytedance.watson.assist.b.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.bytedance.watson.assist.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<List<Long>> f3371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<List<Long>> f3372b;
    private long c;
    private long d;
    private long e;

    public a() {
        this.f3371a = new ArrayList();
        this.f3372b = new ArrayList();
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    public long a() {
        return this.d;
    }

    public void a(com.bytedance.watson.assist.c.b r7) {
        com.bytedance.watson.assist.c.b r8 = (com.bytedance.watson.assist.c.b) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.watson.assist.c.b.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        long r2 = b() - ((a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.memorydata.plugin")).b();
        this.d = r2;
        if (this.e != 0) goto L9;
        this.e = r2;
        return;
    }

    public void a(List<Long> r3) {
        List<Long> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.f3371a.add(r4);
        return;
    }

    public long b() {
        if (this.c != 0) goto L14;
        if (this.f3371a.isEmpty() == true) goto L14;
        Iterator<List<Long>> r0 = this.f3371a.iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        Iterator r1 = ((List) ZeusTransformUtils.preCheckCast(r0.next(), List.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        this.c += ((Long) ZeusTransformUtils.preCheckCast(r1.next(), Long.class, "com.obric.memorydata.plugin")).longValue();
    L14:
        return this.c;
    }

    public void b(com.bytedance.watson.assist.c.b r13) {
        com.bytedance.watson.assist.c.b r14 = (com.bytedance.watson.assist.c.b) ZeusTransformUtils.wrapperContextForParams(r13, com.bytedance.watson.assist.c.b.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L6;
        this.f3372b.addAll(this.f3371a);
        return;
    L6:
        List<List<Long>> r15 = ((a) ZeusTransformUtils.preCheckCast(r14, a.class, "com.obric.memorydata.plugin")).c();
        if (r15.isEmpty() == false) goto L9;
        return;
    L9:
        int r0 = this.f3371a.size();
        if (r0 == r15.size()) goto L13;
        com.bytedance.watson.assist.d.b.c("calculate cpu idle time delta size error1");
        return;
    L13:
        this.f3372b.clear();
        int r3 = 0;
    L14:
        if (r3 >= r0) goto L33;
        List r4 = (List) ZeusTransformUtils.preCheckCast(this.f3371a.get(r3), List.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.preCheckCast(r15.get(r3), List.class, "com.obric.memorydata.plugin");
        ArrayList r6 = new ArrayList();
        if (r4 == null) goto L26;
        if (r5 == null) goto L26;
        if (r4.size() != r5.size()) goto L26;
        int r7 = 0;
    L23:
        if (r7 >= r4.size()) goto L25;
        r6.add(Long.valueOf(((Long) ZeusTransformUtils.preCheckCast(r4.get(r7), Long.class, "com.obric.memorydata.plugin")).longValue() - ((Long) ZeusTransformUtils.preCheckCast(r5.get(r7), Long.class, "com.obric.memorydata.plugin")).longValue()));
        r7 = r7 + 1;
        goto L23
    L25:
        this.f3372b.add(r6);
        r3 = r3 + 1;
    L26:
        com.bytedance.watson.assist.d.b.c("calculate cpu idle time delta size error2");
        return;
    }

    public List<List<Long>> c() {
        return this.f3371a;
    }

    public void d() {
        this.f3371a.clear();
        this.f3372b.clear();
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    public String toString() {
        return "CpuIdleTimeStatInfo{stateTimeLists=" + this.f3371a + ", stateDeltaTimeLists=" + this.f3372b + ", totalCpuIdleTime=" + this.c + ", deltaCpuIdleTime=" + this.d + ", mergedDeltaCpuIdleTime=" + this.e + '}';
    }
}
