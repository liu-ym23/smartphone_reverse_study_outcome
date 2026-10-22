package t69;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.util.r0;
import h49.b;
import h49.h;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n extends r0 {
    public n() {
    }

    public final void D(DoraDevice r11, int[] r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        Iterator<h> r0 = p.a.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().a(new b(r11.name, r11.battery, r12, r11.model, r11.getSerialNumber(), Integer.valueOf(r11.productId)));
        goto L6
    }

    public final void b0(DoraDevice r11, int[] r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        Iterator<h> r0 = p.a.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().b(new b(r11.name, r12, r11.charge, r11.model, r11.getSerialNumber(), Integer.valueOf(r11.productId)));
        goto L6
    }
}
