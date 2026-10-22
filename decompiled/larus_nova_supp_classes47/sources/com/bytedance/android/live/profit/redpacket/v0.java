package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v0<T> implements Consumer {
    public final /* synthetic */ r0.p a;
    public final /* synthetic */ RedPacketState b;

    public v0(r0.p r1, RedPacketState r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        ApiServerException r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "t");
        int r0 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.b("RedPacketRepository", "rush failed", r5);
        r0 r1 = this.a.a;
        n0 r2 = this.b.getInfo();
        Intrinsics.checkNotNullParameter(r1, "$this$monitorRedPacketRushedFail");
        Intrinsics.checkNotNullParameter(r2, "redPacketInfo");
        Intrinsics.checkNotNullParameter(r5, "throwable");
        JSONObject r3 = new JSONObject();
        q0.a(r1, r3);
        q0.b(r3, r2);
        q0.e("ttlive_redpacket_rushed_status", r5, r3);
        if ((r5 instanceof ApiServerException) == false) goto L11;
        ApiServerException r6 = r5;
        switch(r6.getErrorCode()) {
            case 4007022: goto L9;
            case 4007023: goto L8;
            case 4007024: goto L6;
            case 4007025: goto L6;
            case 4007026: goto L7;
            default: goto L6;
        };
    L6:
        int r7 = ToastUtil.a;
        ToastUtil.b(r6.getPrompt(), 0);
        goto L11
    L7:
        ToastUtil.a(2131922048, 0);
        goto L11
    L8:
        ToastUtil.a(2131922047, 0);
        goto L11
    L9:
        ToastUtil.a(2131922046, 0);
    L11:
        this.a.b.b(RedPacketAction.Ready.INSTANCE);
    }
}
