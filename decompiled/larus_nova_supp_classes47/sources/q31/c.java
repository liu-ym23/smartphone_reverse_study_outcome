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
public final class c implements e {
    public final m31.b a;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.transfer.e
    public final boolean a() {
        return true;
    }

    public c() {
        this.a = new m31.b();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.transfer.e
    public final k31.c b(l31.a r5, boolean r6, Boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "param");
        if (r6 == true) goto L5;
    L10:
        int r9 = r5.c;
        Integer r10 = o.b(r9, r5.a());
        if (r10 == null) goto L29;
        int r12 = r10.intValue();
        int r13 = l.a(r5.h, r5.d);
        k31.a r0 = r5.i;
        int r1 = 0;
        if (r0 == null) goto L15;
        int r2 = k31.b.a(r0);
    L16:
        int r14 = r13 + r2;
        int r3 = (int) ((r5.b - r12) / 2.0f);
        if (r5.j != UILayout.FULL.ordinal()) goto L26;
        b03.a r15 = b03.a.a;
        r9 = s1.w();
        f r16 = r5.f;
        if (r16 == null) goto L25;
        p0 r17 = r16.b;
        if (r17 == null) goto L25;
        q0 r18 = r17.getCanvas();
        if (r18 == null) goto L25;
        r12 = (r18.b() * r9) / r18.a();
    L25:
        r3 = (r5.b - r12) / 2;
    L28:
        return new k31.c(r12, r9, r1, r3);
    L26:
        r1 = r14;
        goto L28
    L15:
        r2 = 0;
        goto L16
    L29:
        return null;
    L5:
        if (Intrinsics.areEqual(r7, Boolean.FALSE) == false) goto L10;
        if (r5.b >= r5.c) goto L10;
        this.a.getClass();
        return m31.b.a(r5);
    }
}
