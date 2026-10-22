package hd0;

import com.bytedance.android.live.livelink.multilink.pipeline.LinkPipelineManager;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.scope.o;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends a implements o {
    public final HashMap<d<Integer>, Observer<Integer>> a;
    public final bn0.b b;

    @Override // hd0.b
    public final int getLinkMode() {
        return c.f().g;
    }

    @Override // hd0.b
    public final int getState() {
        return ((Integer) ((ge1.a) c.f()).b).intValue();
    }

    public f(bn0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "myScope");
        this.b = r2;
        this.a = new HashMap();
    }

    @Override // hd0.b
    public final void O2(long r2) {
        c.f().f = r2;
    }

    @Override // hd0.b
    public final void V7(int r2) {
        c.f().k(Integer.valueOf(r2));
    }

    @Override // hd0.b
    public final void rh(LinkPipelineManager.c r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        Observer<Integer> r0 = this.a.get(r3);
        c.f().e(r0);
        this.a.remove(r3);
    }

    @Override // hd0.b
    public final void setLinkMode(int r2) {
        c.f().g = r2;
    }

    @Override // hd0.b
    public final void y8(LinkPipelineManager.c r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        e r0 = new e(r3);
        this.a.put(r3, r0);
        c.f().c(r0);
    }
}
