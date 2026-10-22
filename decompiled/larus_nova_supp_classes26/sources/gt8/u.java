package gt8;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u implements o.b {
    public final /* synthetic */ o a;

    @Override // gt8.o.b
    public final void b() {
        o.b(this.a);
    }

    public u(o r1) {
        this.a = r1;
    }

    @Override // gt8.o.b
    public final void c(RectF r2) {
        Intrinsics.checkNotNullParameter(r2, "end");
        o.a(this.a, r2);
    }

    @Override // gt8.o.b
    public final void a(float r5, float r6) {
        o r7 = this.a;
        RectF r0 = r7.q;
        float r1 = r0.left;
        if ((r5 - r1) > o.G) goto L5;
        return;
    L5:
        if (r7.B == false) goto L7;
        r0.bottom = (r7.C * (r5 - r1)) + r0.top;
    L7:
        r0.right = r5;
        r7.i();
    }
}
