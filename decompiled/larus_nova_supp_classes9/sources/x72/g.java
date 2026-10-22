package x72;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements Consumer<Integer> {
    public final /* synthetic */ b.a a;
    public final /* synthetic */ k32.a b;

    public final void accept(Object r2) throws Exception {
        Integer r3 = (Integer) r2;
        u72.a r4 = ((a) this.a).b;
        if (r4 == null) goto L6;
        v72.c r5 = (v72.c) r4;
        r5.a(this.b);
        return;
    }

    public g(b.a r1, k32.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
