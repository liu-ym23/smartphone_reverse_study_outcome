package com.bytedance.android.livesdk.dsl.recyclerview;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import kotlin.jvm.internal.Intrinsics;
import yt1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements yt1.i {
    public final /* synthetic */ SingleDSLViewHolder.a a;

    public i(SingleDSLViewHolder.a r1) {
        this.a = r1;
    }

    @Override // yt1.i
    public final boolean a(IAction r6, View r7, j r8) {
        Intrinsics.checkNotNullParameter(r6, "action");
        Intrinsics.checkNotNullParameter(r7, "targetView");
        Intrinsics.checkNotNullParameter(r8, "curTemplateHolder");
        SingleDSLViewHolder.a r3 = this.a;
        c r4 = r3.a.e;
        b r5 = r3.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "action");
        Intrinsics.checkNotNullParameter(r7, "targetView");
        Intrinsics.checkNotNullParameter(r8, "curTemplateHolder");
        bu1.a r0 = r4.a.get(r6.getType());
        if (r0 == null) goto L5;
        r0.a(r5, r6, r7, r8);
        return true;
    L5:
        return false;
    }
}
