package q31;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.transfer.e;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.model.q0;
import k31.f;
import k31.l;
import k31.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements e {
    public final m31.b a;
    public final int b;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.transfer.e
    public final boolean a() {
        return false;
    }

    public d() {
        this.a = new m31.b();
        this.b = b03.c.b(134);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.transfer.e
    public final k31.c b(l31.a r4, boolean r5, Boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "param");
        if (r5 == true) goto L5;
    L10:
        int r8 = r4.b;
        Integer r9 = o.a(r8, r4.a());
        if (r9 == null) goto L29;
        int r10 = r9.intValue();
        int r12 = this.b + l.a(r4.h, r4.d);
        k31.a r0 = r4.i;
        int r1 = 0;
        if (r0 == null) goto L15;
        int r2 = k31.b.a(r0);
    L16:
        int r13 = r12 + r2;
        if (r4.j != UILayout.FULL.ordinal()) goto L26;
        b03.a r14 = b03.a.a;
        r10 = s1.w();
        f r15 = r4.f;
        if (r15 == null) goto L25;
        p0 r16 = r15.b;
        if (r16 == null) goto L25;
        q0 r17 = r16.getCanvas();
        if (r17 == null) goto L25;
        r8 = (r17.b() * r10) / r17.a();
    L25:
        int r18 = (r4.b - r8) / 2;
    L28:
        return new k31.c(r8, r10, r1, r18);
    L26:
        r1 = r13;
        r18 = 0;
        goto L28
    L15:
        r2 = 0;
        goto L16
    L29:
        return null;
    L5:
        if (Intrinsics.areEqual(r6, Boolean.FALSE) == false) goto L10;
        if (r4.b <= r4.c) goto L10;
        this.a.getClass();
        return m31.b.a(r4);
    }
}
