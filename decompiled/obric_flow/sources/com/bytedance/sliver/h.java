package com.bytedance.sliver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f7521b;

    public h(int r5) {
        this.f7520a = r5;
    }

    public static void a(List r10) {
        int r5 = r10.size();
        int r11 = 0;
    L3:
        int r12 = 1;
    L4:
        if (r11 >= r5) goto L15;
        SliverAllThreadSupport.access$400();
        g r13 = (g) SliverAllThreadSupport.access$100().get(r12);
        Thread r14 = (Thread) r10.get(r11);
        monitor-enter(r13);
        r13.f7519c.add(r14);     // Catch: Throwable -> L12
        r13.g = true;     // Catch: Throwable -> L12
        monitor-exit(r13);
        r11 = r11 + 1;
        r12 = r12 + 1;
        if (r12 < SliverAllThreadSupport.access$100().size()) goto L4;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List r5 = SliverAllThreadSupport.access$200();
        if (this.f7521b != null) goto L5;
        a(r5);
    L41:
        this.f7521b = r5;
        Iterator r10 = SliverAllThreadSupport.access$100().iterator();
    L43:
        if (r10.hasNext() == false) goto L45;
        ((g) r10.next()).a();
        goto L43
    L45:
        SliverAllThreadSupport.access$300().postDelayed(this, this.f7520a);
        return;
    L5:
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        Iterator r13 = r5.iterator();
    L7:
        if (r13.hasNext() == false) goto L11;
        Thread r14 = (Thread) r13.next();
        if (this.f7521b.contains(r14) == true) goto L7;
        r11.add(r14);
        goto L7
    L11:
        Iterator r15 = this.f7521b.iterator();
    L13:
        if (r15.hasNext() == false) goto L17;
        Thread r16 = (Thread) r15.next();
        if (r5.contains(r16) == true) goto L13;
        r12.add(r16);
        goto L13
    L17:
        Iterator r17 = r12.iterator();
    L19:
        if (r17.hasNext() == false) goto L40;
        Thread r18 = (Thread) r17.next();
        int r19 = 1;
    L22:
        if (r19 >= SliverAllThreadSupport.access$100().size()) goto L19;
        g r20 = (g) SliverAllThreadSupport.access$100().get(r19);
        monitor-enter(r20);
    L34:
        th = move-exception;
        throw th;
    L26:
        if (r20.f7519c.isEmpty() == false) goto L30;
        monitor-exit(r20);
    L37:
        r19 = r19 + 1;
        goto L22
    L30:
        if (r20.f7519c.remove(r18) == true) goto L31;
        monitor-exit(r20);
        goto L37
    L31:
        r20.g = true;     // Catch: Throwable -> L34
        monitor-exit(r20);
        goto L19
    L40:
        a(r11);
        goto L41
    }
}
