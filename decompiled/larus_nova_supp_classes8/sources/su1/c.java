package su1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements e {
    public final Object a;

    public c(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a = r2;
    }

    @Override // su1.e
    public final void a(qu1.a r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "environment");
        Intrinsics.checkNotNullParameter(r3, "context");
        Deque<Object> r4 = r2.a;
        LinkedList r5 = (LinkedList) r4;
        r5.push(this.a);
    }
}
