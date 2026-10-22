package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.ec.adapter.api.handler.viewinterface.ECExternalViewGroupAction;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.ExternalViewGroupAction;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements Function3<IExternalViewGroup, IExternalView, ExternalViewGroupAction, Unit> {
    public final /* synthetic */ Function3 a;

    public e(Function3 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10, Object r11, Object r12) {
        IExternalViewGroup r13 = (IExternalViewGroup) r10;
        IExternalView r14 = (IExternalView) r11;
        ExternalViewGroupAction r15 = (ExternalViewGroupAction) r12;
        Intrinsics.checkNotNullParameter(r13, "p1");
        Intrinsics.checkNotNullParameter(r14, "p2");
        Intrinsics.checkNotNullParameter(r15, "p3");
        Function3 r0 = this.a;
        Intrinsics.checkNotNullParameter(r13, "$this$convert2EC");
        wd.f r16 = j.b.a(r13);
        Intrinsics.checkNotNullParameter(r14, "$this$convert2EC");
        wd.e r17 = c.C0114c.b.d(r14);
        int r18 = d.a[r15.ordinal()];
        if (r18 != 1) goto L5;
        ECExternalViewGroupAction r19 = ECExternalViewGroupAction.Add;
    L10:
        r0.invoke(r16, r17, r19);
        return Unit.INSTANCE;
    L5:
        if (r18 != 2) goto L8;
        r19 = ECExternalViewGroupAction.Remove;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
