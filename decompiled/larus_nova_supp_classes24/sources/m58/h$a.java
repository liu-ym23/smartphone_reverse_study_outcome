package m58;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h$a {
    public final AtomicBoolean a;
    public volatile Function0<Unit> b;

    public final void a() {
        if (this.a.compareAndSet(false, true) == false) goto L8;
        Function0<Unit> r0 = this.b;
        if (r0 == null) goto L9;
        r0.invoke();
        return;
    L9:
        return;
    }

    public h$a() {
        this.a = new AtomicBoolean(false);
    }
}
