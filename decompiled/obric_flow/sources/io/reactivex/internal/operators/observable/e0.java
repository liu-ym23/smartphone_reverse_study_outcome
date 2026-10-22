package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 extends mt.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.s[] f17764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Iterable f17765c;
    public final pt.o d;
    public final int e;
    public final boolean f;

    public /* synthetic */ e0(mt.s[] r5, Iterable r10, pt.o r11, int r12, boolean r13, int r14) {
        this.f17763a = r14;
        this.f17764b = r5;
        this.f17765c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        switch(this.f17763a) {
            case 0: goto L18;
            default: goto L4;
        };
    L4:
        mt.s[] r5 = this.f17764b;
        if (r5 != null) goto L13;
        r5 = new mt.n[8];
        Iterator r11 = this.f17765c.iterator();
        int r12 = 0;
    L8:
        if (r11.hasNext() == false) goto L14;
        mt.s r13 = (mt.s) r11.next();
        if (r12 != r5.length) goto L12;
        mt.s[] r14 = new mt.s[(r12 >> 2) + r12];
        System.arraycopy(r5, 0, r14, 0, r12);
        r5 = r14;
    L12:
        r5[r12] = r13;
        r12 = r12 + 1;
    L14:
        if (r12 != 0) goto L16;
        EmptyDisposable.complete(r10);
        return;
    L16:
        new ObservableZip$ZipCoordinator(r10, this.d, r12, this.f).subscribe(r5, this.e);
        return;
    L13:
        r12 = r5.length;
        goto L14
    L18:
        mt.s[] r15 = this.f17764b;
        if (r15 != null) goto L28;
        r15 = new mt.n[8];
        Iterator r16 = this.f17765c.iterator();
        int r17 = 0;
    L22:
        if (r16.hasNext() == false) goto L27;
        mt.s r18 = (mt.s) r16.next();
        if (r17 != r15.length) goto L26;
        mt.s[] r19 = new mt.s[(r17 >> 2) + r17];
        System.arraycopy(r15, 0, r19, 0, r17);
        r15 = r19;
    L26:
        r15[r17] = r18;
        r17 = r17 + 1;
    L27:
        int r20 = r17;
        if (r20 != 0) goto L31;
        EmptyDisposable.complete(r10);
        return;
    L31:
        new ObservableCombineLatest$LatestCoordinator(r10, this.d, r20, this.e, this.f).subscribe(r15);
        return;
    L28:
        r17 = r15.length;
        goto L27
    }
}
