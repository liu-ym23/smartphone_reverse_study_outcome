package com.bytedance.applog.j;

import com.bytedance.applog.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, CopyOnWriteArraySet<h>> f1609a;

    public a() {
        this.f1609a = new ConcurrentHashMap();
    }

    public void a(int r5, h r6) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r6, h.class, "com.obric.memorydata.plugin");
        if (a(r5) == false) goto L5;
        this.f1609a.put(Integer.valueOf(r5), new CopyOnWriteArraySet());
    L5:
        if (r7 == null) goto L10;
        CopyOnWriteArraySet r4 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(this.f1609a.get(Integer.valueOf(r5)), CopyOnWriteArraySet.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L11;
        r4.add(r7);
        return;
    L11:
        return;
    }

    public void a(int r3, String r4, String r5) {
        if (a(r3) == false) goto L5;
        return;
    L5:
        CopyOnWriteArraySet r2 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(this.f1609a.get(Integer.valueOf(r3)), CopyOnWriteArraySet.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L8;
        return;
    L8:
        Iterator r6 = r2.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        ((h) ZeusTransformUtils.preCheckCast(r6.next(), h.class, "com.obric.memorydata.plugin")).a(r4, r5);
        goto L10
    }

    public void a(int r13, String r14, String r15, String r16, long r17, long r19, String r21) {
        if (a(r13) == false) goto L5;
        return;
    L5:
        CopyOnWriteArraySet r0 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(this.f1609a.get(Integer.valueOf(r13)), CopyOnWriteArraySet.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        return;
    L8:
        Iterator r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        ((h) ZeusTransformUtils.preCheckCast(r1.next(), h.class, "com.obric.memorydata.plugin")).a(r14, r15, r16, r17, r19, r21);
        goto L10
    }

    public void a(h r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L12;
        Iterator<Map.Entry<Integer, CopyOnWriteArraySet<h>>> r3 = this.f1609a.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L20;
        CopyOnWriteArraySet r0 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), CopyOnWriteArraySet.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        if (r0.contains(r5) == false) goto L6;
        r0.remove(r5);
        goto L6
    L20:
        return;
    }

    public boolean a(int r1) {
        return !this.f1609a.containsKey(Integer.valueOf(r1));
    }

    public void b(int r3, String r4, String r5) {
        if (a(r3) == false) goto L5;
        return;
    L5:
        CopyOnWriteArraySet r2 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(this.f1609a.get(Integer.valueOf(r3)), CopyOnWriteArraySet.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L8;
        return;
    L8:
        Iterator r6 = r2.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        ((h) ZeusTransformUtils.preCheckCast(r6.next(), h.class, "com.obric.memorydata.plugin")).b(r4, r5);
        goto L10
    }
}
