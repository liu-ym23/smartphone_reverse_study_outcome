package androidx.core.util;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class d implements Predicate {
    public final /* synthetic */ Predicate a;
    public final /* synthetic */ Predicate b;

    public /* synthetic */ d(Predicate r1, Predicate r2) {
        this.a = r1;
        this.b = r2;
    }

    public final /* synthetic */ Predicate and(Predicate r1) {
        return Predicate.-CC.$default$and(this, r1);
    }

    public final /* synthetic */ Predicate negate() {
        return Predicate.-CC.$default$negate(this);
    }

    public final /* synthetic */ Predicate or(Predicate r1) {
        return Predicate.-CC.$default$or(this, r1);
    }

    public final boolean test(Object r3) {
        return Predicate.-CC.$private$lambda$and$0(this.a, this.b, r3);
    }
}
