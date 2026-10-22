package com.bytedance.android.live.profit.redpacket.jsbridge;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@XBridgeMethod(biz = "webcast", name = "sendRedEnvelopSuccess")
public class SendRedEnvelopSuccessMethod extends g<Params, Object> {
    private static final String TAG = "SendRedEnvelopSuccessMe";

    public static final class Params {

        @SerializedName("delay_time")
        String delayTime;

        @SerializedName("envelope_diamond")
        String envelopeDiamond;

        @SerializedName("envelope_id")
        String envelopeId;

        @SerializedName("envelope_type")
        String envelopeType;

        @SerializedName("left_diamond")
        String leftDiamond;

        public Params() {
        }
    }

    public SendRedEnvelopSuccessMethod() {
    }

    public Object invoke(Params r3, CallContext r4) throws Exception {
        ((IRechargeService) k.f(IRechargeService.class)).rechargeCenter().setAvailableDiamonds(CastIntegerProtector.parseInt(r3.leftDiamond));     // Catch: Exception -> L4
    L6:
        com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).markAsOutOfDate(true);
        return null;
    L4:
        e = move-exception;
        ALogger.e(TAG, e);
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, CallContext r2) throws Exception {
        return invoke((Params) r1, r2);
    }
}
