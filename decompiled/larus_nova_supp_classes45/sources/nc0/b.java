package nc0;

import androidx.lifecycle.LiveData;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements ey.g {
    public final Map<ey.j, com.bytedance.android.live.revenuelink.connect.m> b;
    public final Map<ey.h, com.bytedance.android.live.revenuelink.connect.i> c;
    public final com.bytedance.android.live.revenuelink.connect.f d;

    public final LiveData<ey.f> c() {
        return this.d.connectState();
    }

    public b(com.bytedance.android.live.revenuelink.connect.f r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.d = r2;
        this.b = new HashMap();
        this.c = new HashMap();
    }

    @Override // ey.g
    public final void a(int r2, ey.j r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        com.bytedance.android.live.revenuelink.connect.m r4 = (com.bytedance.android.live.revenuelink.connect.m) ((HashMap) this.b).remove(r3);
        if (r4 == null) goto L6;
        this.d.removeLinkOutListener(r2, r4);
        return;
    }

    public final void b(int r3, ey.j r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        i r0 = new i(r4);
        this.d.addLinkOutListener(r3, r0);
        ((HashMap) this.b).put(r4, r0);
    }
}
