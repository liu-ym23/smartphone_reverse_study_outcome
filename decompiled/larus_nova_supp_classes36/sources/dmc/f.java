package dmc;

import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements a {
    public boolean a;
    public b b;
    public final LinkedHashSet<e> c;
    public final com.ss.ugc.live.sdk.msg.c d;

    @Override // dmc.a
    public final void o(e r1) {
    }

    @Override // dmc.a
    public final void t() {
        boolean r0 = this.a;
        if (r0 == true) goto L5;
        return;
    L5:
        if (r0 == false) goto L7;
    L12:
        this.a = false;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.d, "end replay");
        return;
    L7:
        if (this.c.isEmpty() == false) goto L12;
        b r1 = this.b;
        if (r1 == null) goto L11;
        r1.a.clear();
    L11:
        this.b = null;
        goto L12
    }

    public f(com.ss.ugc.live.sdk.msg.c r2) {
        Intrinsics.checkNotNullParameter(r2, "messageContext");
        this.d = r2;
        this.c = new LinkedHashSet();
    }

    @Override // dmc.a
    public final void C(e r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.a == false) goto L8;
        this.c.add(r2);
        return;
    }

    @Override // dmc.a
    public final void s(c r2) {
        Intrinsics.checkNotNullParameter(r2, "replayBufferConfig");
        if (this.a == false) goto L5;
        return;
    L5:
        b r0 = this.b;
        if (r0 == null) goto L8;
        r0.a.clear();
    L8:
        this.c.clear();
        this.b = new b(r2);
        this.a = true;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.d, "start replay");
    }
}
