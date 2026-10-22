package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profit.privilege.model.danmu.PrivilegeBarrageResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T, R> implements Function {
    public final /* synthetic */ d a;

    public m(d r1) {
        this.a = r1;
    }

    public final Object apply(Object r13) {
        ExtraResponse r14 = (ExtraResponse) r13;
        Intrinsics.checkNotNullParameter(r14, "it");
        d r0 = this.a;
        com.bytedance.android.live.profit.privilege.model.danmu.c r15 = (com.bytedance.android.live.profit.privilege.model.danmu.c) r14.data;
        r0.getClass();
        return new PrivilegeBarrageResponse(r15.getUser(), r15.getOrderId(), r15.getLeftDiamond(), r15.getMsgId(), r15.getToast(), (int) r15.getSkin(), r15.getShowIdentity(), r15.getIdentityLabel());
    }
}
