package com.bytedance.android.live.recharge.deal.aio;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(CreateCustomDealRequestSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/recharge/deal/aio/f;", "Lvh7/j;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.deal.CreateCustomDealRequest")
public interface f extends j<f> {

    @JsonAdapter(CreateCustomDealRequestSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "custom_price")
    long getCustomPrice();

    @FieldName(name = "is_disable_price_limit")
    Boolean j4();

    @FieldName(name = "is_user_customized")
    Boolean s2();
}
