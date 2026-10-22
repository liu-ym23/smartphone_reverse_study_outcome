package wlb;

import androidx.fragment.app.FragmentActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements d {
    public final pcb.a a;
    public final Map<d.a, ocb.a> b;

    @Override // wlb.d
    public final int c() {
        pcb.a r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getVisibleKeyboardHeight();
    }

    @Override // wlb.d
    public final boolean isKeyboardShowing() {
        pcb.a r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isKeyboardShowing();
    }

    public j(FragmentActivity r1) {
        this.a = pcb.a.a.b(r1);
        this.b = new LinkedHashMap();
    }

    @Override // wlb.d
    public final void a(d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "onKeyboardHeightChangeListener");
        ocb.a r3 = this.b.remove(r2);
        if (r3 == null) goto L8;
        pcb.a r0 = this.a;
        if (r0 == null) goto L9;
        r0.a(r3);
        return;
    L9:
        return;
    }

    @Override // wlb.d
    public final void b(d.a r4) {
        Intrinsics.checkNotNullParameter(r4, "onKeyboardHeightChangeListener");
        pcb.a r0 = this.a;
        if (r0 == null) goto L9;
        LinkedHashMap r1 = (LinkedHashMap) this.b;
        Object r2 = r1.get(r4);
        if (r2 != null) goto L7;
        r2 = new i(r4);
        r1.put(r4, r2);
    L7:
        r0.c((ocb.a) r2);
        return;
    }
}
