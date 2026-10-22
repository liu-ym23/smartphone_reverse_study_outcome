package gt8;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x implements o.b {
    public final /* synthetic */ o a;

    @Override // gt8.o.b
    public final void b() {
        o.b(this.a);
    }

    public x(o r1) {
        this.a = r1;
    }

    @Override // gt8.o.b
    public final void c(RectF r2) {
        Intrinsics.checkNotNullParameter(r2, "end");
        o.a(this.a, r2);
    }

    @Override // gt8.o.b
    public final void a(float r8, float r9) {
        o r0 = this.a;
        boolean r2 = true;
        boolean r3 = false;
        if (r0.B == false) goto L8;
        RectF r10 = r0.q;
        float r1 = r10.left;
        if ((r8 - r1) <= o.G) goto L7;
        r10.right = r8;
        r10.top = r10.bottom - (r0.C * (r8 - r1));
    L15:
        if (r2 == false) goto L18;
        r0.i();
        return;
    L18:
        return;
    L7:
        r2 = false;
        goto L15
    L8:
        RectF r4 = r0.q;
        float r5 = r8 - r4.left;
        int r6 = o.G;
        if (r5 <= r6) goto L12;
        r4.right = r8;
        r3 = true;
    L12:
        if ((r4.bottom - r9) <= r6) goto L14;
        r4.top = r9;
        goto L15
    L14:
        r2 = r3;
        goto L15
    }
}
