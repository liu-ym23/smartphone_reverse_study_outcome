package o0c;

import com.bytedance.supervisor.token.Token;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class p implements ObservableTransformer<Object, n0c.a> {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ Token b;
    public final /* synthetic */ c c;

    public final ObservableSource<n0c.a> apply(final Observable<Object> r4) {
        Observable r0 = Observable.fromIterable(c.b(this.c, this.a));
        final Token r1 = this.b;
        return r0.concatMap(new l(this, r4, r1)).toList().toObservable().flatMapIterable(new m());
    }

    public p(c r1, String[] r2, Token r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
