package com.obric.oui.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f12571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12573c;
    public final s d;
    public DependencyNode$Type e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f12575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f12577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f12578l;

    public g(s r5) {
        this.f12571a = null;
        this.f12572b = false;
        this.f12573c = false;
        this.e = DependencyNode$Type.UNKNOWN;
        this.f12574h = 1;
        this.f12575i = null;
        this.f12576j = false;
        this.f12577k = new ArrayList();
        this.f12578l = new ArrayList();
        this.d = r5;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.e
    public final void a(e r10) {
        ArrayList r11 = this.f12578l;
        Iterator r5 = r11.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        if (((g) r5.next()).f12576j == true) goto L4;
        return;
    L8:
        this.f12573c = true;
        s r12 = this.f12571a;
        if (r12 == null) goto L12;
        r12.a(this);
    L12:
        if (this.f12572b == false) goto L15;
        this.d.a(this);
        return;
    L15:
        Iterator r13 = r11.iterator();
        g r14 = null;
        int r15 = 0;
    L17:
        if (r13.hasNext() == false) goto L22;
        g r16 = (g) r13.next();
        if ((r16 instanceof h) == true) goto L17;
        r15 = r15 + 1;
        r14 = r16;
        goto L17
    L22:
        if (r14 == null) goto L33;
        if (r15 != 1) goto L33;
        if (r14.f12576j == false) goto L33;
        h r17 = this.f12575i;
        if (r17 != null) goto L29;
    L32:
        d(r14.g + this.f);
        goto L33
    L29:
        if (r17.f12576j == false) goto L31;
        this.f = this.f12574h * r17.g;
        goto L32
    L31:
        return;
    L33:
        s r18 = this.f12571a;
        if (r18 == null) goto L45;
        r18.a(this);
        return;
    }

    public final void b(s r5) {
        this.f12577k.add(r5);
        if (this.f12576j == false) goto L6;
        r5.a(r5);
        return;
    }

    public final void c() {
        this.f12578l.clear();
        this.f12577k.clear();
        this.f12576j = false;
        this.g = 0;
        this.f12573c = false;
        this.f12572b = false;
    }

    public void d(int r5) {
        if (this.f12576j == false) goto L5;
        return;
    L5:
        this.f12576j = true;
        this.g = r5;
        Iterator r10 = this.f12577k.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        e r11 = (e) r10.next();
        r11.a(r11);
        goto L7
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.d.f12593b.f17409k0);
        r5.append(":");
        r5.append(this.e);
        r5.append("(");
        if (this.f12576j == false) goto L5;
        Object r10 = Integer.valueOf(this.g);
    L6:
        r5.append(r10);
        r5.append(") <t=");
        r5.append(this.f12578l.size());
        r5.append(":d=");
        r5.append(this.f12577k.size());
        r5.append(">");
        return r5.toString();
    L5:
        r10 = "unresolved";
        goto L6
    }
}
