package tw0;

import com.bytedance.android.live.recharge.order.aio.BuyDiamondRequestSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(BuyDiamondRequestSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Ltw0/g;", "Lvh7/j;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.order.BuyDiamondRequest")
public interface g extends vh7.j<g> {

    @JsonAdapter(BuyDiamondRequestSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "deal_id")
    long B8();

    @FieldName(name = "no_password_order_option")
    j Z2();

    @FieldName(name = "one_step_pay_option")
    k b9();

    @FieldName(name = "recharge_coupon_option")
    l c5();

    @FieldName(name = "custom_price")
    long getCustomPrice();

    @FieldName(name = "deal")
    com.bytedance.android.live.recharge.deal.aio.b o();

    @FieldName(name = "common_order_option")
    i v6();
}
