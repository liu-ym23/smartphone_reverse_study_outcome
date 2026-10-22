package com.cronutils.model.time;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<Integer> f3433a;

    public f(List<Integer> r3) {
        List<Integer> r4 = (List) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), "Values must not be empty"), List.class, "com.obric.memorydata.plugin");
        this.f3433a = r4;
        Collections.sort(r4);
    }

    int a(List<Integer> r3, int r4, AtomicInteger r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        com.cronutils.utils.a.a(r6, "List must not be empty");
        int r0 = r6.size();
        if (r4 >= 0) goto L6;
        r5.incrementAndGet();
        return a(r6, r4 + r0, r5);
    L6:
        if (r4 < r0) goto L10;
        int r7 = r4 - r6.size();
        r5.incrementAndGet();
        return a(r6, r7, r5);
    L10:
        return ((Integer) ZeusTransformUtils.preCheckCast(r6.get(r4), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public d a(int r1, int r2) {
        return b(r1, r2);
    }

    public List<Integer> a() {
        return Collections.unmodifiableList(this.f3433a);
    }

    d b(int r9, int r10) {
        List<Integer> r0 = new ArrayList(this.f3433a);
        int r2 = 0;
        AtomicInteger r1 = new AtomicInteger(0);
        if (r0.contains(Integer.valueOf(r9)) == true) goto L13;
        Iterator<Integer> r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(r3.next(), Integer.class, "com.obric.memorydata.plugin");
        if (r6.intValue() <= r9) goto L6;
        int r11 = r0.indexOf(r6);
        r10 = r10 - 1;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L14;
        r1.incrementAndGet();
    L14:
        int r5 = ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r11), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L15:
        if (r2 >= r10) goto L18;
        r5 = a(r0, r11 + 1, r1);
        r11 = r0.indexOf(Integer.valueOf(r5));
        r2 = r2 + 1;
        goto L15
    L18:
        return new d(r5, r1.get());
    L10:
        r11 = 0;
        r4 = false;
        goto L11
    L13:
        r11 = r0.indexOf(Integer.valueOf(r9));
        goto L14
    }
}
