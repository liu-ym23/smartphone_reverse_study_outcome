package qa2;

import com.bytedance.android.live.base.model.message.g3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements a {
    public final /* synthetic */ k a;

    public j(k r1) {
        this.a = r1;
    }

    @Override // qa2.a
    public final void a(f52.j<g3> r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        k r0 = this.a;
        r0.c = r4;
        r0.h = r4.m.getTriggerTimestamp();
    }

    @Override // qa2.a
    public final void b(f52.j<g3> r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a.c = null;
    }
}
