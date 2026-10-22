package d50;

import android.os.Message;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends c {
    @Override // d50.c
    public final void h(c50.c r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Message r0 = a(r4);
        if (r0 == null) goto L8;
        this.c.a(this.b, r4);
        this.e = r4.hashCode();
        this.a.sendMessageDelayed(r0, this.f);
        return;
    }

    public d(c50.a r1, HashMap r2, f50.a r3, long r4) {
        super(r1, r2, r3, r4);
    }
}
