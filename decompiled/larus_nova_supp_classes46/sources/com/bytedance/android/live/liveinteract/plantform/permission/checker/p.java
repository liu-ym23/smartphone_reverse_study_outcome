package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p implements qh0.a<rh0.a> {
    public final qh0.b a;

    public p(qh0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "createConfig");
        this.a = r2;
    }

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r11) {
        Intrinsics.checkNotNullParameter(r11, "consumer");
        if (tb1.c.c == true) goto L5;
    L7:
        qh0.d.a.a(r11);
        return;
    L5:
        if (vm2.g.b() == true) goto L7;
        f2.b(2131918784, 0);
        r11.b(new BaseCheckException(this.a.getLinkType(), this.a.getOperateType(), BaseCheckException.CheckType.AndroidPermission, "dylite not support link", null, 16, null));
    }
}
