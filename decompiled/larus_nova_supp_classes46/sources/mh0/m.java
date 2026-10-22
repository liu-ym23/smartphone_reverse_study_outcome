package mh0;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ p a;

    public m(p r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        List<? extends tf0.e> r3 = (List) r2;
        this.a.k(r3);
        this.a.l(r3);
        this.a.j(r3);
    }
}
