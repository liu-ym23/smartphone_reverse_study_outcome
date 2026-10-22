package ly;

import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t {
    public final com.bytedance.android.live.anchormodelink.handlers.d a;
    public final com.bytedance.android.live.anchormodelink.handlers.a b;
    public boolean c;
    public final ih0.c d;
    public final int e;

    public final void a() {
        ih0.c r0 = this.d;
        if (r0 == null) goto L5;
        r0.J();
    L5:
        ih0.c r1 = this.d;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        com.bytedance.android.live.anchormodelink.handlers.d r2 = this.a;
        if (r2 == null) goto L12;
        r2.j = null;
        ((LinkedHashMap) r2.a).clear();
        r2.f = null;
        r2.c = null;
        r2.h = false;
        r2.e.clear();
        r2.d = 0;
        r2.b.clear();
        r2.b.dispose();
        return;
    }

    public t(com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r2, int r3) {
        this.d = r2;
        this.e = r3;
        boolean r4 = ky.a.a;
        List r5 = vm2.d.c0().getSeiCacheKeys();
        if (r5 != null) goto L5;
        r5 = CollectionsKt.listOf(new String[]{"app_data", "source"});
    L5:
        this.a = new com.bytedance.android.live.anchormodelink.handlers.d(r5);
        this.b = new com.bytedance.android.live.anchormodelink.handlers.a();
    }
}
