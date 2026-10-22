package o6a;

import android.graphics.PointF;
import android.view.View;
import m6a.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements j {
    public PointF a;
    public j b;
    public boolean c;

    public d() {
        this.c = true;
    }

    public final boolean a(View r3) {
        j r0 = this.b;
        if (r0 == null) goto L7;
        return ((d) r0).a(r3);
    L7:
        return r6a.b.a(r3, this.a, this.c);
    }

    public final boolean b(View r2) {
        j r0 = this.b;
        if (r0 == null) goto L7;
        return ((d) r0).b(r2);
    L7:
        return r6a.b.b(r2, this.a);
    }
}
