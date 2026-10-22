package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n3 implements com.bytedance.android.scope.o {
    public boolean a;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f b;
    public final PropListService c;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void a() {
        if (this.a == false) goto L5;
        boolean r0 = false;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        ToastUtil.a(2131919790, 0);
        mz0.n r1 = new mz0.n();
        mz0.m r2 = new mz0.m();
        r2.b(LogCommon.ROOM);
        r2.b(LogCommon.PAGE_SOURCE_LOG);
        List r3 = r1.b;
        ArrayList r4 = (ArrayList) r3;
        r4.addAll(r2.a);
        cy0.e.a.getClass();
        cy0.j r5 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r6 = com.bytedance.android.scope.m.b(r5).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r6);
        ((f80.a) r6).w3("livesdk_property_overdue_remind_toast_show", r1.a, r1.b);
        return;
    L5:
        this.a = true;
        r0 = this.c.g(PropListService.ExpirePropShowType.TOAST);
        goto L6
    }

    public n3(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r2, PropListService r3) {
        Intrinsics.checkNotNullParameter(r2, "receiverService");
        Intrinsics.checkNotNullParameter(r3, "propListService");
        this.b = r2;
        this.c = r3;
    }
}
