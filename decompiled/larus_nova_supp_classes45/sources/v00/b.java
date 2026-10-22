package v00;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public b(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        Function1 r0 = this.a;
        if (r4 != null) goto L5;
        r4 = new Throwable("auth error");
    L5:
        r0.invoke(r4);
    }
}
