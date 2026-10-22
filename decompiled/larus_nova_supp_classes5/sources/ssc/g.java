package ssc;

import android.graphics.drawable.Drawable;
import lsc.h;
import lsc.t;
import lsc.u;
import lsc.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g implements x {
    public final Drawable a;

    public g(Drawable r1) {
        this.a = r1;
    }

    @Override // lsc.x
    public final Object a(h r5, t r6) {
        u r7 = (u) r6;
        return new f(r5.a, this.a, ((Boolean) r7.b(e.a, Boolean.FALSE)).booleanValue());
    }
}
