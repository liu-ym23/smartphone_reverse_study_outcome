package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.profit.privilege.model.danmu.DanmakuTabList;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.q0;
import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ d a;

    public j(d r1) {
        this.a = r1;
    }

    public final void accept(Object r18) {
        ApiServerException r1 = (Throwable) r18;
        Intrinsics.checkNotNullParameter(r1, "t");
        com.bytedance.android.live.profit.privilege.e r2 = com.bytedance.android.live.profit.privilege.e.a;
        String r3 = this.a.f();
        long r4 = this.a.d();
        String r6 = q0.a(r1);
        String r7 = "";
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        int r8 = r0.a(r1);
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r6, Constants.Keys.ERROR);
        com.bytedance.android.live.profit.privilege.e.p("ttlive_privilege_danmaku_tab_status_all", com.bytedance.android.live.profit.privilege.e.k(false, r6, Integer.valueOf(r8)), com.bytedance.android.live.profit.privilege.e.n(null), com.bytedance.android.live.profit.privilege.e.m(r2, Long.valueOf(r4), 4));
        if ((r1 instanceof ApiServerException) == false) goto L13;
        int r5 = ToastUtil.a;
        ApiServerException r9 = r1;
        ToastUtil.b(r9.getPrompt(), 0);
        if (r9.getErrorCode() != 4024008) goto L13;
        String r10 = r9.getPrompt();
        if (r10 != null) goto L12;
        r10 = "等级不足";
    L12:
        r7 = r10;
    L13:
        this.a.b.setValue(new DanmakuTabList(null, false, false, 0, 0, r7, 29, null));
    }
}
