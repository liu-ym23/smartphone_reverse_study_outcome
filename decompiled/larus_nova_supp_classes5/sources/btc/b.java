package btc;

import android.text.Spanned;
import android.text.method.MovementMethod;
import android.widget.TextView;
import ctc.d;
import lsc.j;
import lsc.r;
import msc.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b extends lsc.a {
    public final MovementMethod a;

    public b(d r1) {
        this.a = r1;
    }

    @Override // lsc.a, lsc.j
    public final void j(j.a r2) {
        ((o) ((r) r2).c(o.class)).b = true;
    }

    @Override // lsc.a, lsc.j
    public final void f(TextView r2, Spanned r3) {
        MovementMethod r4 = r2.getMovementMethod();
        MovementMethod r0 = this.a;
        if (r4 == r0) goto L6;
        r2.setMovementMethod(r0);
        return;
    }
}
