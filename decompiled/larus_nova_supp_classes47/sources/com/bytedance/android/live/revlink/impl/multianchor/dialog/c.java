package com.bytedance.android.live.revlink.impl.multianchor.dialog;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.utils.b0;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.kmp.util.e;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        long r0 = (e.b() - ((Long) r10).longValue()) / ((long) WebcastRedirectException.UNKNOWN);
        b r12 = this.a;
        com.bytedance.android.live.revlink.impl.global.c r2 = r12.h;
        if (r2 == null) goto L5;
        b0 r3 = r2.Tj();
    L6:
        boolean r4 = true;
        if (r3 == null) goto L12;
        PkBaseStateMachine.c r5 = r3.e();
        if (r5 == null) goto L12;
        if ((r5 instanceof PkBaseStateMachine.c.d) != true) goto L12;
    L24:
        if (r4 == false) goto L31;
        Long r6 = (Long) this.a.c.getValue();
        if (r6 == null) goto L31;
        if (r6.longValue() != (-1)) goto L31;
        jy0.b.c("ttlive_anchor_link_timer", "intercept linkRecordTime update to " + r0 + "s， since current is in penalty", null, 4);
        return;
    L31:
        NextLiveData<Long> r7 = this.a.c;
        if (r0 < 0) goto L34;
        long r8 = Long.valueOf(r0);
    L35:
        r7.setValue(r8);
        jy0.b.c("ttlive_anchor_link_timer", "linkRecordTime update to " + r0 + "s, scene=" + this.a.j, null, 4);
        this.a.a("linkTimeChanged");
        return;
    L34:
        r8 = 0L;
    L12:
        com.bytedance.android.live.revlink.impl.global.c r13 = r12.h;
        if (r13 == null) goto L15;
        q r14 = r13.getPkUtils();
    L16:
        if (r14 == null) goto L18;
        q11.b r15 = r14.a();
    L20:
        if (Intrinsics.areEqual(r15, q11.b.c.b) == true) goto L24;
        r4 = false;
        goto L24
    L18:
        r15 = null;
        goto L20
    L15:
        r14 = null;
        goto L16
    L5:
        r3 = null;
        goto L6
    }
}
