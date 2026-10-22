package zka;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class q {
    public final Context a;
    public final m b;
    public final g c;
    public final a d;
    public final n e;
    public final p f;

    public final g a() {
        if (this.e.c(this.a) == true) goto L7;
        return null;
    L7:
        return this.c;
    }

    public final Context getContext() {
        return this.a;
    }

    public q(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = new m();
        this.c = new g();
        this.d = new a();
        this.e = new n();
        this.f = new p();
    }
}
