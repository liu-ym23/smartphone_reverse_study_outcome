package d40;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a.b a;

    public b(a.b r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        a.b r9 = this.a;
        r9.a.a(r9.b, r9.c, "timer");
    }
}
