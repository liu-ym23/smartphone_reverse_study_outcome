package d71;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ Function0 b;

    public a(b r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        Disposable r3 = this.a.c;
        if (r3 == null) goto L5;
        r3.dispose();
    L5:
        this.b.invoke();
    }
}
