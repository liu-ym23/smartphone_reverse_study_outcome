package com.bytedance.apm.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
public class v<E extends Comparable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PriorityQueue<E> f1502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1503b;

    public v(int r3) {
        if (r3 <= 0) goto L7;
        this.f1503b = r3;
        this.f1502a = new PriorityQueue(r3, new AnonymousClass1(this));
        return;
    L7:
        throw new IllegalStateException();
    }

    public List<E> a() {
        ArrayList r0 = new ArrayList(this.f1502a);
        Collections.sort(r0);
        return r0;
    }

    public void a(E r4) {
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        if (this.f1502a.size() >= this.f1503b) goto L6;
    L4:
        this.f1502a.add((E) r5);
        return;
    L6:
        if (r5.compareTo((Comparable) ZeusTransformUtils.preCheckCast(this.f1502a.peek(), Comparable.class, "com.obric.memorydata.plugin")) <= 0) goto L9;
        this.f1502a.poll();
        goto L4
    }

    public int b() {
        return this.f1502a.size();
    }

    public void c() {
        this.f1502a.clear();
    }
}
