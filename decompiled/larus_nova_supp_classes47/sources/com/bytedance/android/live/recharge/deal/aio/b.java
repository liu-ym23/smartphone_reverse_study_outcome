package com.bytedance.android.live.recharge.deal.aio;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(AioDealSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/recharge/deal/aio/b;", "Lix0/d;", "Lcom/bytedance/android/live/recharge/deal/f;", "Lvh7/j;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.deal.Deal")
public interface b extends ix0.d<com.bytedance.android.live.recharge.deal.f>, j<b> {

    @JsonAdapter(AioDealSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "giving_count#setter")
    void C1(int r1);

    @FieldName(name = "exchange_price#setter")
    void J5(int r1);

    @FieldName(name = "price#setter")
    void O8(int r1);

    @FieldName(name = "deal_id#setter")
    void a7(long r1);

    @FieldName(name = "description#setter")
    void setDescription(String r1);

    @FieldName(name = "diamond_count#setter")
    void setDiamondCount(int r1);

    @FieldName(name = "discount_price#setter")
    void v1(int r1);

    @FieldName(name = "describe_type#setter")
    void x6(int r1);
}
