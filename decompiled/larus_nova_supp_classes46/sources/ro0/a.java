package ro0;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final ArrayList<b<?>> a;
    public final d b;

    public a(d r1) {
        this.b = r1;
        this.a = new ArrayList();
    }

    public final void a(b<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        d r0 = this.b;
        if (r0 == null) goto L5;
        r0.addMessageListener(r4.a().getIntType(), r4.a);
    L5:
        this.a.add(r4);
    }
}
