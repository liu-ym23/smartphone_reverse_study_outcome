package com.bytedance.reparo.core;

import android.app.Application;
import d97.b;
import d97.d;
import e97.a;
import e97.f;
import e97.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e extends WandTrick.a {
    public final a c;
    public final /* synthetic */ List d;
    public final /* synthetic */ ArrayList e;
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ Map g;
    public final /* synthetic */ List h;
    public final /* synthetic */ List i;
    public final /* synthetic */ b j;
    public final /* synthetic */ ArrayList k;
    public final /* synthetic */ f l;

    @Override // com.bytedance.reparo.core.WandTrick.a
    public final boolean b(int r1) {
        if (r1 != 0) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.bytedance.reparo.core.WandTrick.a
    public final int a() throws Exception {
        ArrayList r4 = new ArrayList();
        r4.addAll(this.d);
        r4.addAll(this.e);
        r4.addAll(this.f);
        int r0 = this.l.c(this.g, this.h, this.i, r4, this.j);
        if (r0 == 0) goto L9;
        a r1 = this.c;
        if (a.g == true) goto L7;
        r1.getClass();
    L8:
        return r0;
    L7:
        r1.a();
        goto L8
    L9:
        this.j.b("replaceSuper");
        ArrayList r2 = this.k;
        ((HashMap) PatchInvokeSuperHelper.a).clear();
        Iterator r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        Class r5 = (Class) r3.next();
        if (r5 == null) goto L11;
        ((HashMap) PatchInvokeSuperHelper.a).put(r5.getName(), r5);
        goto L11
    L15:
        Iterator r6 = this.k.iterator();
    L17:
        if (r6.hasNext() == false) goto L19;
        PatchInvokeSuperHelper.a((Class) r6.next(), null);
        goto L17
    L19:
        this.j.a("replaceSuper");
        this.j.b("replaceMethodNative");
        String[] r7 = new String[10];
        f r8 = this.l;
        Object[] r9 = this.e.toArray();
        Object[] r10 = this.f.toArray();
        f r11 = this.l;
        Object[] r12 = this.f.toArray();
        r11.getClass();
        int[] r13 = WandTrick.g(r12);
        String[] r14 = new String[100];
        this.j.e.add(r14);
        long[] r15 = new long[100];
        this.j.f.add(r15);
        int r16 = r8.replaceMethodNative(r9, r10, r13, r7, r14, r15);
        k.d("replace", r7);
        this.j.a("replaceMethodNative");
        if (r16 != (-9)) goto L26;
        a r17 = this.c;
        if (a.g == true) goto L24;
        r17.getClass();
    L25:
        return -9;
    L24:
        r17.a();
        goto L25
    L26:
        if (r16 != 0) goto L41;
        a r18 = this.c;
        if (a.g == true) goto L30;
        r18.getClass();
    L39:
        return 0;
    L30:
        if (r18.f.c.l == false) goto L39;
        if (r18.c() < ((i) r18).b) goto L34;
        boolean r19 = true;
    L35:
        if (r19 == true) goto L39;
        r18.b();
        goto L39
    L34:
        r19 = false;
        goto L35
    L41:
        throw new Exception("Failure in replacement, ret:." + r16);
    }

    public e(f r1, d r2, List r3, ArrayList r4, ArrayList r5, Application r6, boolean r7, Map r8, List r9, List r10, b r11, ArrayList r12) {
        this.l = r1;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.c = new a(r2, f.b(r1.c));
    }
}
