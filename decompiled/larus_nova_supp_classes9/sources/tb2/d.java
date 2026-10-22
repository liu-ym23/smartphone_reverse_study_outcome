package tb2;

import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public List<c> a;
    public yb2.a b;
    public b5 c;

    public d() {
        this.a = new ArrayList();
    }

    public final d a(Function1<? super d, d> r2) {
        Intrinsics.checkNotNullParameter(r2, "f");
        return (d) r2.invoke(this);
    }

    public final void b(List r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.a.addAll(r2);
    }

    public final void c(c r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.a.add(r2);
    }

    public final void d(List r3) {
        this.a.addAll(0, r3);
    }

    public final void e(c r3) {
        ListProtector.add(this.a, 0, r3);
    }
}
