package com.bytedance.android.live.recharge.panel.dynamic;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(GiftRechargeParamsSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/recharge/panel/dynamic/c;", "Lvh7/j;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.GiftRechargeParams")
public interface c extends j<c> {

    @JsonAdapter(GiftRechargeParamsSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "extra_params#setter")
    void S0(Map<String, String> r1);

    @FieldName(name = "gift_pay_money#setter")
    void f0(long r1);

    @FieldName(name = "gift_request_id#setter")
    void m1(String r1);

    @FieldName(name = "gift_price#setter")
    void p2(long r1);

    @FieldName(name = "gift_send_type#setter")
    void r3(String r1);

    @FieldName(name = "gift_id#setter")
    void setGiftId(long r1);

    @FieldName(name = "gift_name#setter")
    void setGiftName(String r1);
}
