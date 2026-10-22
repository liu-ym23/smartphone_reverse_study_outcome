package com.bytedance.android.live.profit.vote.ui;

import android.widget.TextView;
import com.bytedance.android.live.revenue.common.TimeFormatters;
import com.bytedance.android.live.revenue.common.t0;
import com.bytedance.android.live.revenue.common.u0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ VoteIconModel a;

    public b(VoteIconModel r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        VoteIconModel.c r0 = this.a.h;
        long r1 = ((Long) r9).longValue();
        VoteIconModel.b r10 = r0.a.g;
        if (r10 == null) goto L5;
        TextView r12 = r10.f;
        u0 r5 = u0.f;
        u0 r6 = u0.a.a(r1);
        TimeFormatters r7 = TimeFormatters.MM_SS;
        u0 r8 = t0.a;
        Intrinsics.checkNotNullParameter(r6, "$this$format");
        Intrinsics.checkNotNullParameter(r7, "formatter");
        r12.setText(r7.invoke(r6));
    L5:
        VoteIconModel.d r13 = r0.a.f;
        if (r13 == null) goto L9;
        xr2.b r14 = r13.a;
        u0 r2 = u0.f;
        u0 r3 = u0.a.a(r1);
        TimeFormatters r4 = TimeFormatters.MM_SS;
        u0 r15 = t0.a;
        Intrinsics.checkNotNullParameter(r3, "$this$format");
        Intrinsics.checkNotNullParameter(r4, "formatter");
        r14.setLabel(r4.invoke(r3));
        return;
    }
}
