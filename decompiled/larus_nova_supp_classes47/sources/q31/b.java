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
public final class b implements e {
    public final m31.b a;
    public final float b;
    public final float c;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.transfer.e
    public final boolean a() {
        return false;
    }

    public b() {
        this.a = new m31.b();
        com.bytedance.android.live.revlink.impl.settings.live.a r0 = com.bytedance.android.live.revlink.impl.settings.live.a.j;
        this.b = r0.a();
        r0.getClass();
        this.c = ((Number) com.bytedance.android.live.revlink.impl.settings.live.a.e.getValue(r0, com.bytedance.android.live.revlink.impl.settings.live.a.a[3])).floatValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.transfer.e
    public final k31.c b(l31.a r7, boolean r8, Boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r7, "param");
        if (r8 == true) goto L5;
    L10:
        int r12 = r7.b;
        Integer r13 = o.a(r12, r7.a());
        if (r13 == null) goto L47;
        int r14 = r13.intValue();
        if (r7.k == false) goto L15;
        float r1 = this.c;
    L16:
        float r2 = r12;
        int r3 = ((int) (r1 * ((int) (r2 / 0.5625f)))) + l.a(r7.h, r7.d);
        k31.a r4 = r7.i;
        int r5 = 0;
        if (r4 == null) goto L19;
        int r6 = k31.b.a(r4);
    L20:
        int r15 = r3 + r6;
        if (r7.j != UILayout.FULL.ordinal()) goto L39;
        r14 = r7.c;
        f r0 = r7.f;
        if (r0 == null) goto L29;
        p0 r16 = r0.b;
        if (r16 == null) goto L29;
        q0 r17 = r16.getCanvas();
        if (r17 == null) goto L29;
        r12 = (r17.b() * r14) / r17.a();
    L29:
        int r18 = r7.b - r12;
        if (r10 == false) goto L46;
        b03.a r19 = b03.a.a;
        if (r12 >= s1.y()) goto L46;
        r12 = r7.b;
        Integer r20 = o.a(r12, r7.a());
        if (r20 == null) goto L36;
        r14 = r20.intValue();
    L37:
        r15 = (r7.c - r14) / 2;
    L44:
        r5 = r15;
        r18 = 0;
        goto L46
    L36:
        r14 = 0;
    L46:
        return new k31.c(r12, r14, r5, r18);
    L39:
        if (r7.j != UILayout.FULL_RECORD.ordinal()) goto L44;
        Float r22 = r7.a();
        if (r22 == null) goto L43;
        r14 = (int) (r2 / r22.floatValue());
        goto L44
    L43:
        return null;
    L19:
        r6 = 0;
        goto L20
    L15:
        r1 = this.b;
        goto L16
    L47:
        return null;
    L5:
        if (Intrinsics.areEqual(r9, Boolean.FALSE) == false) goto L10;
        if (r7.b <= r7.c) goto L10;
        this.a.getClass();
        return m31.b.a(r7);
    }
}
