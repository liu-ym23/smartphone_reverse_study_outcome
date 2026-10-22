package o29;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h implements c {
    public final /* synthetic */ Function2<j, Integer, Unit> a;

    public h(com.larus.community.impl.quickmenu.doSame.c r1) {
        this.a = r1;
    }

    @Override // o29.c
    public final void a(j r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        this.a.invoke(r2, Integer.valueOf(r3));
    }
}
