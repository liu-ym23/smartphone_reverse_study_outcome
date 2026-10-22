package x61;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements c {
    public final /* synthetic */ Function1 b;

    public f(Function1 r1) {
        this.b = r1;
    }

    @Override // x61.h
    public final View a(c.a r2) {
        c.a r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "params");
        return (View) this.b.invoke(r3);
    }
}
