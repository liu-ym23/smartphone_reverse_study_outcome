package t70;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements Consumer {
    public final /* synthetic */ Function1 a;

    public f(Function1 r1) {
        this.a = r1;
    }

    public final /* synthetic */ void accept(Object r2) {
        this.a.invoke(r2);
    }
}
