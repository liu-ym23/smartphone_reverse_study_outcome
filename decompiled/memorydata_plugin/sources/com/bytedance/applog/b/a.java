package com.bytedance.applog.b;

import com.bytedance.applog.EventType;
import com.bytedance.applog.filter.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1528b;
    private boolean c;
    private boolean d;
    private final List<EventType> e;
    private boolean f;
    private boolean g;
    private final long h;
    private final c i;
    private final g j;

    public a(c r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        this.f1527a = 0;
        this.f1528b = 0;
        this.c = false;
        this.d = false;
        this.e = new ArrayList(2);
        this.f = false;
        this.g = true;
        this.h = System.currentTimeMillis();
        this.j = new g();
        this.i = r5;
    }

    public void a(ArrayList<com.bytedance.applog.n.a> r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Iterator<com.bytedance.applog.n.a> r0 = r7.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        this.f1527a += ((com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r0.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin")).j();
        goto L6
    L8:
        this.f1528b += (long) r7.size();
    }

    public boolean a() {
        if (this.f1528b < e.k) goto L5;
    L8:
        return true;
    L5:
        if (this.f1527a >= e.l) goto L8;
        return false;
    }

    public void b() {
        this.f1528b = 0;
        this.f1527a = 0;
    }

    public boolean c() {
        if (this.c == true) goto L5;
    L7:
        return false;
    L5:
        if (d() == false) goto L7;
        return true;
    }

    public boolean d() {
        if (this.g == false) goto L8;
        if ((System.currentTimeMillis() - this.h) <= 10000) goto L8;
        this.g = false;
    L8:
        return this.g;
    }

    public boolean e() {
        if (this.d == true) goto L5;
    L7:
        return false;
    L5:
        if (d() == false) goto L7;
        return true;
    }

    public List<EventType> f() {
        return this.e;
    }

    public g g() {
        return this.j;
    }
}
