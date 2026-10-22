package bz0;

import android.content.DialogInterface;
import com.bytedance.android.live.revenue.platform.hybrid.impl.util.CompositeListenerUpTo6Args;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends g implements yy0.d {
    public final CompositeListenerUpTo6Args<Unit, Function1<DialogInterface, Unit>> e;
    public final CompositeListenerUpTo6Args<Unit, Function1<DialogInterface, Unit>> f;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> g;

    public e() {
        this.e = new CompositeListenerUpTo6Args();
        this.f = new CompositeListenerUpTo6Args();
        this.g = new CompositeListenerUpTo6Args();
    }

    @Override // yy0.d
    public final void b(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.g.a(r2);
    }
}
