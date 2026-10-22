package b31;

import com.bytedance.android.live.revlink.impl.multianchor.constants.GravityDef;
import com.bytedance.android.live.revlink.impl.multianchor.ui.f;
import com.bytedance.android.live.revlink.impl.multianchor.ui.s;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public d() {
    }

    public static a a(s r10, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "barLayouts");
        int r0 = r10.a;
        if (r0 == (-100)) goto L5;
        Integer r15 = Integer.valueOf(r0);
    L6:
        if (r15 == null) goto L21;
        int r4 = r15.intValue();
        int r5 = r10.b;
        GravityDef r9 = GravityDef.CENTER_HORIZONTAL;
        if (r10.c == false) goto L19;
        com.bytedance.android.live.revlink.impl.multianchor.ui.d r16 = r10.e;
        if ((r16 instanceof com.bytedance.android.live.revlink.impl.multianchor.ui.e) == false) goto L13;
        com.bytedance.android.live.revlink.impl.multianchor.ui.e r17 = (com.bytedance.android.live.revlink.impl.multianchor.ui.e) r16;
        int r2 = (int) ((r12 + r17.c) - ((r17.a - r17.b) / 2.0f));
    L15:
        int r6 = r2;
    L18:
        return new a(r4, r5, r6, 0, 0, r9);
    L13:
        if ((r16 instanceof f) == false) goto L16;
        r2 = r12 + ((f) r16).a;
        goto L15
    L16:
        r6 = 0;
        goto L18
    L19:
        com.bytedance.android.live.revlink.impl.multianchor.ui.c r18 = r10.d;
        int r1 = r18.b;
        return new a(r4, r5, (int) ((r12 - r1) - ((r18.a - r1) / 2.0f)), 0, 0, r9);
    L21:
        return null;
    L5:
        r15 = Integer.valueOf(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r13 - (r10.f * 2), 0), RangesKt.coerceAtLeast(r14 - (r10.g * 2), 0)));
        goto L6
    }
}
