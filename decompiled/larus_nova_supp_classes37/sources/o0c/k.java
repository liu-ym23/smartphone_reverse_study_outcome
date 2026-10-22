package o0c;

import com.bytedance.supervisor.token.Token;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements ObservableTransformer<Object, n0c.a> {
    public final /* synthetic */ Token a;
    public final /* synthetic */ String[] b;
    public final /* synthetic */ c c;

    public final ObservableSource<n0c.a> apply(Observable<Object> r4) {
        return c.a(this.c, r4, this.a, this.b);
    }

    public k(c r1, Token r2, String[] r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
