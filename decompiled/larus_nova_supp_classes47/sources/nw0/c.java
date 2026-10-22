package nw0;

import io.reactivex.functions.Consumer;
import yo2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        e r3 = this.a.a;
        if (r3 == null) goto L6;
        r3.d();
        return;
    }
}
