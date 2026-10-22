package a30;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ j a;
    public final /* synthetic */ String b;

    public l(j r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        this.a.j("watchdog timeout, " + this.b);
    }
}
