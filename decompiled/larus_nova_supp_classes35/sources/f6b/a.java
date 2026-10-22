package f6b;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import t3b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements e<b> {
    public final AtomicInteger a;

    public a() {
        this.a = new AtomicInteger(0);
    }

    @Override // t3b.e
    public final String a(u3b.a r2) {
        b r3 = (b) r2;
        Intrinsics.checkNotNullParameter(r3, "task");
        return r3.a() + '_' + this.a.get();
    }

    @Override // t3b.e
    public final String b(u3b.a r2) {
        b r3 = (b) r2;
        Intrinsics.checkNotNullParameter(r3, "task");
        return r3.a() + '_' + this.a.incrementAndGet();
    }
}
