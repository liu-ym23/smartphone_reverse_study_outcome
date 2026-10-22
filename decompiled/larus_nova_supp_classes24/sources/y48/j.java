package y48;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class j {
    public final i a;
    public final boolean b;
    public int c;
    public Function2<? super y, ? super Boolean, Boolean> d;
    public Function2<? super Context, ? super y, ? extends o> e;
    public Function1<? super k, ? extends s> f;
    public m g;
    public n h;
    public c0 i;

    public final i a() {
        return new i(this.a.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public j(i r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        this.a = r2;
        this.b = r2.b;
        this.c = r2.c;
        this.d = r2.d;
        this.e = r2.e;
        this.f = r2.f;
        this.g = r2.g;
        this.h = r2.h;
        this.i = r2.i;
    }
}
