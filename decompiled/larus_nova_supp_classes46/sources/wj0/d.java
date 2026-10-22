package wj0;

import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public c a;
    public final BehaviorSubject<c> b;

    public final b a() {
        c r0 = this.a;
        if ((r0 instanceof c.d) == false) goto L7;
        return ((c.d) r0).a;
    L7:
        if ((r0 instanceof c.C0288c) == false) goto L11;
        return ((c.C0288c) r0).a;
    L11:
        if ((r0 instanceof c.e) == false) goto L15;
        return ((c.e) r0).a;
    L15:
        if ((r0 instanceof c.a) == true) goto L17;
        return null;
    L17:
        return ((c.a) r0).a;
    }

    public d() {
        c.b r0 = new c.b();
        this.a = r0;
        this.b = BehaviorSubject.createDefault(r0);
    }

    public final void b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if ((r2 instanceof a.d) == false) goto L6;
        c.d r0 = new c.d(((a.d) r2).a);
        this.a = r0;
        this.b.onNext(r0);
        return;
    L6:
        if ((r2 instanceof a.b) == false) goto L9;
        c.C0288c r1 = new c.C0288c(((a.b) r2).a);
        this.a = r1;
        this.b.onNext(r1);
        return;
    L9:
        if ((r2 instanceof a.e) == false) goto L12;
        c.e r3 = new c.e(((a.e) r2).a);
        this.a = r3;
        this.b.onNext(r3);
        return;
    L12:
        if ((r2 instanceof a.C0287a) == false) goto L15;
        c.a r4 = new c.a(((a.C0287a) r2).a);
        this.a = r4;
        this.b.onNext(r4);
        return;
    L15:
        if ((r2 instanceof a.c) == false) goto L22;
        c.b r5 = new c.b();
        this.a = r5;
        this.b.onNext(r5);
        return;
    }
}
