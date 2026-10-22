package wp8;

import aq8.c;
import aq8.f;
import com.larus.im.internal.delegate.c0;
import cq8.b0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements c {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final i1<b0> b() {
        c0.b.e("NoopInstructionCoreAbility", "[renderModelFlow] noop implementation");
        return j1.a(b0.d);
    }

    public final i1<b0> Jf(String r2) {
        Intrinsics.checkNotNullParameter(r2, "panelId");
        return b();
    }

    public final f ki(c r3) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        c0.b.e("NoopInstructionCoreAbility", "[handleIntent] noop implementation");
        return f.b.a;
    }

    public final void sl(aq8.d r3) {
        Intrinsics.checkNotNullParameter(r3, "dependency");
        c0.b.e("NoopInstructionCoreAbility", "[setupDependency] noop implementation");
    }
}
