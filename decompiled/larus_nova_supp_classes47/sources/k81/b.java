package k81;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public b(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Function1 r0 = this.a;
        r0.invoke((Throwable) r2);
    }
}
