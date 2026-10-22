package gt8;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p implements o.b {
    public final /* synthetic */ o a;

    @Override // gt8.o.b
    public final void b() {
        o.b(this.a);
    }

    public p(o r1) {
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
        float r1 = r0.top;
        if ((r6 - r1) > r7.D) goto L5;
        return;
    L5:
        if (r7.B == false) goto L9;
        float r2 = r0.right - ((r6 - r1) / r7.C);
        if (r2 < r7.b.a().left) goto L10;
        RectF r8 = this.a.q;
        r8.left = r2;
        r8.bottom = r6;
    L10:
        this.a.i();
        return;
    L9:
        r0.bottom = r6;
        goto L10
    }
}
