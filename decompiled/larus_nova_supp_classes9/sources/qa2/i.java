package qa2;

import com.bytedance.android.live.base.model.message.g3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements a {
    public final /* synthetic */ k a;

    public i(k r1) {
        this.a = r1;
    }

    @Override // qa2.a
    public final void a(f52.j<g3> r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a.b = r2;
    }

    @Override // qa2.a
    public final void b(f52.j<g3> r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        k r4 = this.a;
        r4.f = System.currentTimeMillis();
        this.a.b = null;
    }
}
