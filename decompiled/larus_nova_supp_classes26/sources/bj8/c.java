package bj8;

import com.larus.bmhome.chat.api.q0;
import kc8.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements b {
    public final kc8.b a;

    @Override // bj8.b
    public final boolean p() {
        kc8.b r0 = this.a;
        if (r0 == null) goto L9;
        y r1 = r0.a;
        if (r1 == null) goto L9;
        q0 r2 = r1.x;
        if (r2 == null) goto L9;
        Integer r3 = r2.I7();
    L10:
        if (r3 == null) goto L12;
        return true;
    L12:
        return false;
    L9:
        r3 = null;
        goto L10
    }

    public c(kc8.b r1) {
        this.a = r1;
    }
}
