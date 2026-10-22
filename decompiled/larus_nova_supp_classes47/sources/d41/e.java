package d41;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ f a;
    public final /* synthetic */ Runnable b;

    public e(f r1, f.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.b.run();
        this.a.a = null;
    }
}
