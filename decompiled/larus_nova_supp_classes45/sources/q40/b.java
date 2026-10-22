package q40;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.RegionId;
import k40.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements c.a {
    public final Rect a;
    public final RegionId b;
    public final View c;

    @Override // q40.c.a
    public final Rect a() {
        return this.a;
    }

    public final Rect b(Rect r7) {
        Intrinsics.checkNotNullParameter(r7, "rect");
        Rect r0 = new Rect(r7);
        Rect r8 = this.a;
        int r1 = Math.max(0, r8.left - r0.left);
        int r3 = Math.min(0, r8.right - r0.right);
        r0.offset(r1 + r3, Math.max(0, r8.top - r0.top) + Math.min(0, r8.bottom - r0.bottom));
        return r0;
    }

    public final g c(Rect r6) {
        Intrinsics.checkNotNullParameter(r6, "objectRect");
        float r0 = this.a.width() - r6.width();
        float r1 = this.a.height() - r6.height();
        float r2 = 0.0f;
        if (r0 != 0.0f) goto L5;
        float r3 = 0.0f;
    L7:
        if (r1 == 0.0f) goto L11;
        r2 = (r6.top - this.a.top) / r1;
    L11:
        return new g(r3, r2);
    L5:
        r3 = (r6.left - this.a.left) / r0;
        goto L7
    }

    public b(RegionId r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "view");
        this.b = r2;
        this.c = r3;
        this.a = new Rect();
    }
}
