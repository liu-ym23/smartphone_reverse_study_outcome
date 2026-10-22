package pw0;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ f a;

    public e(f r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        f r0 = this.a;
        r0.finishWithFailure((Throwable) r2);
    }
}
