package o29;

import com.larus.community.impl.quickmenu.DismissReason;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g implements b {
    public final /* synthetic */ Function1<DismissReason, Unit> a;

    public g(com.larus.community.impl.quickmenu.doSame.d r1) {
        this.a = r1;
    }

    @Override // o29.b
    public final void a(DismissReason r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        this.a.invoke(r2);
    }
}
