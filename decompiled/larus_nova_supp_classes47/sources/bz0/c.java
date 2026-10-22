package bz0;

import com.bytedance.android.live.revenue.platform.container.impl.core.NativeHostServiceImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends d implements yy0.b {
    public final List<com.lynx.jsbridge.f> e;
    public final List<com.lynx.tasm.behavior.a> f;

    public c() {
        this.e = new ArrayList();
        this.f = new ArrayList();
    }

    @Override // yy0.b
    public final void f(com.lynx.tasm.behavior.a r2) {
        Intrinsics.checkNotNullParameter(r2, "behavior");
        ((ArrayList) this.f).add(r2);
    }

    @Override // yy0.b
    public final void c(Class r3, NativeHostServiceImpl.a r4) {
        Intrinsics.checkNotNullParameter("aiolink-message", "name");
        Intrinsics.checkNotNullParameter(r3, "clz");
        List<com.lynx.jsbridge.f> r0 = this.e;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new b(r3, r4));
    }
}
