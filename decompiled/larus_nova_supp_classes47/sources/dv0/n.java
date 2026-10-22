package dv0;

import io.reactivex.subjects.SingleSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class n {
    public final SingleSubject<Long> a;
    public final SingleSubject b;
    public final String c;
    public final long d;

    public n(String r1, long r2) {
        this.c = r1;
        this.d = r2;
        SingleSubject<Long> r3 = SingleSubject.create();
        this.a = r3;
        this.b = r3;
    }
}
