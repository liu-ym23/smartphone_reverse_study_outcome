package fx0;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@XBridgeMethod(biz = "webcast", name = "openLiveRecharge")
public final class j extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final void onTerminate() {
    }

    public j() {
    }

    public final void invoke(Object r26, CallContext r27) throws Exception {
        JSONObject r0 = (JSONObject) r26;
        if (r0 != null) goto L5;
        String r7 = "H5";
        String r8 = r7;
        int r6 = 1;
    L12:
        String r14 = "H5";
        String r1 = "";
        String r2 = r1;
        String r16 = r2;
        int r12 = r6;
        String r13 = r7;
        String r15 = r8;
        long r3 = 0;
        long r4 = 0;
        long r9 = 0;
        long r10 = 0;
        int r17 = 0;
    L13:
        String r18 = r1;
        ((ObservableSubscribeProxy) ((IRechargeService) jc1.k.f(IRechargeService.class)).rechargeCenter().observeWallet().compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(ContextUtil.contextToFragmentActivity(r27.getContext())))).subscribe(new i(r27), RxUtil.getNoOpThrowable());
        x2 r5 = new x2(r12, r13, r15, r14, 0);
        if (r4 <= 0) goto L17;
        r5.g = r4;
    L17:
        if (r3 <= 0) goto L20;
        r5.h = r3;
    L20:
        if (r9 <= 0) goto L23;
        r5.i = r9;
    L23:
        if (r10 <= 0) goto L26;
        r5.k = r10;
    L26:
        if (TextUtils.isEmpty(r2) == true) goto L29;
        r5.l = r2;
    L29:
        if (TextUtils.isEmpty(r16) == true) goto L31;
        r5.o = r16;
    L31:
        if (r17 <= 0) goto L34;
        r5.f = r17;
    L34:
        if (TextUtils.isEmpty(r18) == true) goto L37;
        r5.p = r18;
    L37:
        if (getCallContext() != null) goto L39;
    L41:
        r5.r = "OpenLiveRechargeMethod";
        xs2.b.a().post(r5);
        JSONObject r19 = new JSONObject();
        r19.put(Constants.OperatorKey.CODE, 1);
        finishWithResult(r19);
        return;
    L39:
        if (TextUtils.isEmpty(getCallContext().b) == true) goto L41;
        r5.s = UriProtector.parse(getCallContext().b).getPath();
        goto L41
    L5:
        if (TextUtils.equals("new_page", r0.optString("type", "")) == false) goto L7;
        r6 = 2;
    L8:
        r7 = r0.optString("enter_from", "H5");
        r8 = r0.optString("click_type", "H5");
        JSONObject r20 = r0.optJSONObject("args");
        if (r20 == null) goto L12;
        String r22 = r20.optString("charge_reason", "H5");
        r20.optInt("charge_type");
        int r23 = r20.optInt("business_scene");
        long r110 = r20.optLong("previous_gift_id", 0);
        long r111 = r20.optLong("previous_gift_money", 0);
        long r112 = r20.optLong("previous_pay_money", 0);
        long r113 = r20.optLong("money_diff", 0);
        r2 = r20.optString("previous_gift_type", "");
        String r24 = r20.optString("request_page", "");
        r1 = r20.optString("promotion_source", "");
        r16 = r24;
        r17 = r23;
        r3 = r110;
        r12 = r6;
        r14 = r22;
        r4 = r113;
        r13 = r7;
        r15 = r8;
        r9 = r111;
        r10 = r112;
        goto L13
    L7:
        r6 = 1;
        goto L8
    }
}
