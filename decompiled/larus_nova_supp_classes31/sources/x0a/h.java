package x0a;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h implements c {
    public final /* synthetic */ Function2<j, Integer, Unit> a;

    public h(com.larus.ugc.feed.impl.quickmenu.doSame.c r1) {
        this.a = r1;
    }

    @Override // x0a.c
    public final void a(j r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        this.a.invoke(r2, Integer.valueOf(r3));
    }
}
