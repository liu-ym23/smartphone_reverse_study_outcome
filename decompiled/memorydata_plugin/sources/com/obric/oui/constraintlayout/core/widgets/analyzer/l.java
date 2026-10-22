package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f13627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13628b;
    public boolean c;
    WidgetRun d;
    WidgetRun e;
    ArrayList<WidgetRun> f;
    int g;
    int h;

    l(WidgetRun r3, int r4) {
        this.f13628b = 0;
        this.c = false;
        this.d = null;
        this.e = null;
        this.f = new ArrayList();
        this.g = 0;
        int r0 = f13627a;
        this.g = r0;
        f13627a = r0 + 1;
        this.d = r3;
        this.e = r3;
        this.h = r4;
    }

    private long a(DependencyNode r9, long r10) {
        WidgetRun r0 = r9.d;
        if (ZeusTransformUtils.instanceOf(r0, j.class) == false) goto L5;
        return r10;
    L5:
        int r1 = r9.k.size();
        int r2 = 0;
        long r3 = r10;
    L6:
        if (r2 >= r1) goto L15;
        d r5 = (d) ZeusTransformUtils.preCheckCast(r9.k.get(r2), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, DependencyNode.class) == false) goto L13;
        DependencyNode r6 = (DependencyNode) ZeusTransformUtils.preCheckCast(r5, DependencyNode.class, "com.obric.memorydata.plugin");
        if (r6.d == r0) goto L13;
        r3 = Math.max(r3, a(r6, ((long) r6.f) + r10));
    L13:
        r2 = r2 + 1;
        goto L6
    L15:
        if (r9 != r0.j) goto L22;
        long r4 = r0.b();
        long r11 = r10 + r4;
        return Math.max(Math.max(r3, a(r0.k, r11)), r11 - ((long) r0.k.f));
    L22:
        return r3;
    }

    private long b(DependencyNode r9, long r10) {
        WidgetRun r0 = r9.d;
        if (ZeusTransformUtils.instanceOf(r0, j.class) == false) goto L5;
        return r10;
    L5:
        int r1 = r9.k.size();
        int r2 = 0;
        long r3 = r10;
    L6:
        if (r2 >= r1) goto L15;
        d r5 = (d) ZeusTransformUtils.preCheckCast(r9.k.get(r2), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, DependencyNode.class) == false) goto L13;
        DependencyNode r6 = (DependencyNode) ZeusTransformUtils.preCheckCast(r5, DependencyNode.class, "com.obric.memorydata.plugin");
        if (r6.d == r0) goto L13;
        r3 = Math.min(r3, b(r6, ((long) r6.f) + r10));
    L13:
        r2 = r2 + 1;
        goto L6
    L15:
        if (r9 != r0.k) goto L22;
        long r4 = r0.b();
        long r11 = r10 - r4;
        return Math.min(Math.min(r3, b(r0.j, r11)), r11 - ((long) r0.j.f));
    L22:
        return r3;
    }

    public long a(com.obric.oui.constraintlayout.core.widgets.d r12, int r13) {
        long r1 = 0;
        if (ZeusTransformUtils.instanceOf(this.d, c.class) == true) goto L5;
        WidgetRun r0 = this.d;
        if (r13 != 0) goto L13;
        if (ZeusTransformUtils.instanceOf(r0, k.class) == true) goto L15;
        return 0;
    L15:
        if (r13 != 0) goto L17;
        DependencyNode r2 = r12.f.j;
    L18:
        if (r13 != 0) goto L20;
        DependencyNode r14 = r12.f.k;
    L21:
        boolean r3 = this.d.j.l.contains(r2);
        boolean r15 = this.d.k.l.contains(r14);
        long r4 = this.d.b();
        if (r3 == false) goto L34;
        if (r15 == false) goto L34;
        long r5 = a(this.d.j, 0);
        long r7 = b(this.d.k, 0);
        long r6 = r5 - r4;
        if (r6 < (-this.d.k.f)) goto L27;
        r6 = r6 + ((long) this.d.k.f);
    L27:
        long r8 = ((-r7) - r4) - ((long) this.d.j.f);
        if (r8 < this.d.j.f) goto L30;
        r8 = r8 - ((long) this.d.j.f);
    L30:
        float r16 = this.d.d.n(r13);
        if (r16 <= 0.0f) goto L33;
        r1 = (long) ((r8 / r16) + (r6 / (1.0f - r16)));
    L33:
        float r17 = r1;
        long r18 = ((long) this.d.j.f) + ((((long) ((r17 * r16) + 0.5f)) + r4) + ((long) ((r17 * (1.0f - r16)) + 0.5f)));
    L40:
        return r18 - ((long) this.d.k.f);
    L34:
        if (r3 == true) goto L41;
        if (r15 == false) goto L38;
        long r19 = b(this.d.k, this.d.k.f);
        return Math.max(-r19, ((long) (-this.d.k.f)) + r4);
    L38:
        r18 = ((long) this.d.j.f) + this.d.b();
        goto L40
    L41:
        return Math.max(a(this.d.j, this.d.j.f), ((long) this.d.j.f) + r4);
    L20:
        r14 = r12.g.k;
        goto L21
    L17:
        r2 = r12.g.j;
        goto L18
    L13:
        if (ZeusTransformUtils.instanceOf(r0, m.class) == true) goto L15;
        return 0;
    L5:
        if (((c) ZeusTransformUtils.preCheckCast(this.d, c.class, "com.obric.memorydata.plugin")).h == r13) goto L15;
        return 0;
    }

    public void a(WidgetRun r2) {
        this.f.add(r2);
        this.e = r2;
    }
}
