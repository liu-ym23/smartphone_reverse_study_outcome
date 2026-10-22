package com.larus.e_commerce.impl;

import com.larus.e_commerce.api.ECNotifyBinderDialogType;
import com.larus.login.api.NotifyBinderDialogType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class s implements Function3 {
    public final /* synthetic */ Function3 a;

    public /* synthetic */ s(Function3 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4, Object r5) {
        Function3 r0 = this.a;
        String r6 = (String) r3;
        String r7 = (String) r4;
        NotifyBinderDialogType r8 = (NotifyBinderDialogType) r5;
        int r1 = ECommerceServiceImpl.d;
        Intrinsics.checkNotNullParameter(r6, "page");
        Intrinsics.checkNotNullParameter(r7, "source");
        Intrinsics.checkNotNullParameter(r8, "dialogType");
        if (r0 == null) goto L14;
        int r9 = w.a[r8.ordinal()];
        if (r9 != 1) goto L7;
        ECNotifyBinderDialogType r10 = ECNotifyBinderDialogType.CheckNeedBinder;
    L12:
        r0.invoke(r6, r7, r10);
        goto L14
    L7:
        if (r9 != 2) goto L10;
        r10 = ECNotifyBinderDialogType.NotifyBinder;
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    L14:
        return Unit.INSTANCE;
    }
}
