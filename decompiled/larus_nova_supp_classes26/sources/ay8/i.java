package ay8;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public final List<e> a;

    public i() {
        this.a = new ArrayList();
    }

    public final void a(Function1<? super e, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "block");
        List<e> r0 = this.a;
        e r1 = new e();
        r4.invoke(r1);
        if (r1.e != (-1)) goto L5;
        r1.e = r1.a;
    L5:
        ((ArrayList) r0).add(r1);
    }
}
