package com.loc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class bz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<db> f5391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private da f5392b;
    private ArrayList<db> c;

    public bz() {
        this.f5391a = new ArrayList();
        this.c = new ArrayList();
    }

    private static List<db> a(List<db> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        HashMap r2 = new HashMap();
        int r3 = 0;
    L4:
        if (r3 >= r7.size()) goto L6;
        db r4 = (db) ZeusTransformUtils.preCheckCast(r7.get(r3), db.class, "com.obric.memorydata.plugin");
        r2.put(Integer.valueOf(r4.c), r4);
        r3 = r3 + 1;
        goto L4
    L6:
        r0.addAll(r2.values());
        return r0;
    }

    private boolean a(da r4) {
        float r1 = 10.0f;
        if (r4.g <= 10.0f) goto L6;
        r1 = 200.0f;
    L9:
        if (r4.a(this.f5392b) <= r1) goto L12;
        return true;
    L12:
        return false;
    L6:
        if (r4.g <= 2.0f) goto L9;
        r1 = 50.0f;
        goto L9
    }

    private static boolean a(da r2, long r3, long r5) {
        if (r2.g < 10.0f) goto L5;
        int r4 = 2000;
    L7:
        if (r3 > 0) goto L9;
        return false;
    L9:
        if ((r5 - r3) < r4) goto L11;
        return false;
    L11:
        return true;
    L5:
        r4 = 3500;
        goto L7
    }

    private static boolean a(List<db> r9, List<db> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L23;
        if (r12 == null) goto L23;
        int r2 = r11.size();
        int r3 = r12.size();
        int r4 = r2 + r3;
        if (r2 > r3) goto L10;
        r12 = r11;
        r11 = r12;
    L10:
        HashMap r5 = new HashMap(r11.size());
        Iterator r13 = r11.iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        r5.put(Long.valueOf(((db) ZeusTransformUtils.preCheckCast(r13.next(), db.class, "com.obric.memorydata.plugin")).f5428a), 1);
        goto L12
    L14:
        Iterator r14 = r12.iterator();
        int r15 = 0;
    L16:
        if (r14.hasNext() == false) goto L21;
        if (((Integer) ZeusTransformUtils.preCheckCast(r5.get(Long.valueOf(((db) ZeusTransformUtils.preCheckCast(r14.next(), db.class, "com.obric.memorydata.plugin")).f5428a)), Integer.class, "com.obric.memorydata.plugin")) == null) goto L16;
        r15 = r15 + 1;
        goto L16
    L21:
        if ((((double) r15) * 2.0d) < (((double) r4) * 0.5d)) goto L23;
        return true;
    L23:
        return false;
    }

    private List<db> b(List<db> r3) {
        List<db> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Collections.sort(r4, new AnonymousClass1(this));
        return r4;
    }

    private void b(List<db> r3, List<db> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        r5.clear();
        if (r6 == null) goto L10;
        List<db> r2 = b(a(r6));
        int r7 = r2.size();
        if (r7 <= 40) goto L7;
        r7 = 40;
    L7:
        int r0 = 0;
    L8:
        if (r0 >= r7) goto L12;
        r5.add(r2.get(r0));
        r0 = r0 + 1;
        goto L8
    L12:
        return;
    }

    private boolean b(da r3, List<db> r4, boolean r5, long r6, long r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 == true) goto L6;
        return false;
    L6:
        if (a(r3, r6, r8) == false) goto L17;
        if (r7 != null) goto L9;
        return false;
    L9:
        if (r7.size() > 0) goto L11;
        return false;
    L11:
        if (this.f5392b == null) goto L16;
        boolean r0 = a(r3);
        if (r0 == false) goto L21;
        return r0;
    L21:
        return !a(r7, this.f5391a);
    L16:
        return true;
    L17:
        return false;
    }

    final List<db> a(da r9, List<db> r10, boolean r11, long r12, long r14) {
        List<db> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if (b(r9, r13, r11, r12, r14) == false) goto L6;
        b(this.c, r13);
        this.f5391a.clear();
        this.f5391a.addAll(r13);
        this.f5392b = r9;
        return this.c;
    L6:
        return null;
    }
}
