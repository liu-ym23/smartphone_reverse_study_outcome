package t69;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.util.t0;
import h49.b;
import h49.h;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o extends t0 {
    public o() {
    }

    public final void onDoraLinkStateChanged(DoraDevice r10, int r11, int r12) {
        super.onDoraLinkStateChanged(r10, r11, r12);
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator<T> r13 = p.a.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        ((h) r13.next()).c(new b(r10.name, r10.battery, r10.charge, r10.model, r10.getSerialNumber(), Integer.valueOf(r10.productId)), r12);
        goto L7
    }
}
