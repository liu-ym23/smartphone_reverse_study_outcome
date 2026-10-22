package q31;

import com.bytedance.android.live.revlink.impl.multianchor.transfer.e;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.livesdk.model.m0;
import com.bytedance.android.livesdk.model.p0;
import k31.f;
import k31.l;
import k31.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements e {
    public final m31.b a;
    public final float b;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.transfer.e
    public final boolean a() {
        return false;
    }

    public a() {
        this.a = new m31.b();
        this.b = com.bytedance.android.live.revlink.impl.settings.live.a.j.a();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.transfer.e
    public final k31.c b(l31.a r6, boolean r7, Boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "param");
        if (r7 == true) goto L5;
    L13:
        int r10 = (int) ((r6.c * 9.0f) / 16.0f);
        Integer r12 = o.a(r10, r6.a());
        if (r12 == null) goto L34;
        int r13 = r12.intValue();
        f r0 = r6.f;
        int r1 = 0;
        if (r0 == null) goto L22;
        p0 r2 = r0.b;
        if (r2 == null) goto L22;
        m0 r3 = r2.f();
        if (r3 == null) goto L22;
        int r4 = r3.c();
    L24:
        if (((ay0.e) ay0.f.b.getValue(null, ay0.f.a[0])).b4() == true) goto L26;
    L28:
        int r14 = ((int) (this.b * ((int) (r10 / 0.5625f)))) + l.a(r6.h, r6.d);
        k31.a r5 = r6.i;
        if (r5 == null) goto L31;
        r1 = k31.b.a(r5);
    L31:
        r1 = r1 + r14;
    L33:
        return new k31.c(r10, r13, r1, (int) ((r6.b - r10) / 2.0f));
    L26:
        if (r4 != UILayout.FULL.ordinal()) goto L28;
    L22:
        r4 = 0;
        goto L24
    L34:
        return null;
    L5:
        if (Intrinsics.areEqual(r8, Boolean.FALSE) == false) goto L13;
        Integer r15 = o.b(r6.c, r6.a());
        if (r15 != null) goto L9;
        return null;
    L9:
        if (r15.intValue() >= r6.b) goto L13;
        this.a.getClass();
        return m31.b.a(r6);
    }
}
