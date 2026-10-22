package io.reactivex.internal.util;

import zb.i;

/* JADX INFO: loaded from: classes2.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f9685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object[] f9686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object[] f9687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f9688d;

    /* JADX INFO: renamed from: io.reactivex.internal.util.a$a, reason: collision with other inner class name */
    public interface InterfaceC0204a<T> extends i<T> {
        @Override // zb.i
        boolean test(T r10);
    }

    public a(int r10) {
        this.f9685a = r10;
        Object[] r11 = new Object[r10 + 1];
        this.f9686b = r11;
        this.f9687c = r11;
    }

    public void a(T r10) {
        int r11 = this.f9685a;
        int r12 = this.f9688d;
        if (r12 != r11) goto L5;
        Object[] r13 = new Object[r11 + 1];
        this.f9687c[r11] = r13;
        this.f9687c = r13;
        r12 = 0;
    L5:
        this.f9687c[r12] = r10;
        this.f9688d = r12 + 1;
    }

    public void b(InterfaceC0204a<? super T> r10) {
        Object[] r11 = this.f9686b;
        int r12 = this.f9685a;
    L3:
        if (r11 == null) goto L14;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L13;
        Object r14 = r11[r13];
        if (r14 == null) goto L13;
        if (r10.test(r14) == true) goto L11;
        r13 = r13 + 1;
        goto L5
    L11:
        return;
    L13:
        r11 = (Object[]) r11[r12];
        goto L3
    }
}
