package ad2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ t a;

    public v(t r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        t r0 = this.a;
        r0.finishWithFailure((Throwable) r2);
    }
}
