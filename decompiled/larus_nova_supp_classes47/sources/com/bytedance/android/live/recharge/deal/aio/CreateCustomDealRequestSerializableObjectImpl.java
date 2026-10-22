package com.bytedance.android.live.recharge.deal.aio;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/recharge/deal/aio/CreateCustomDealRequestSerializableObjectImpl;", "Lcom/bytedance/android/live/recharge/deal/aio/f;", "", "customPrice", "J", "getCustomPrice", "()J", "setCustomPrice", "(J)V", "", "isUserCustomized", "Ljava/lang/Boolean;", "s2", "()Ljava/lang/Boolean;", "setUserCustomized", "(Ljava/lang/Boolean;)V", "isDisablePriceLimit", "j4", "setDisablePriceLimit", "<init>", "()V", "Adapter", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CreateCustomDealRequestSerializableObjectImpl implements f {

    @SerializedName("custom_price")
    private long customPrice;

    @SerializedName("is_disable_price_limit")
    private Boolean isDisablePriceLimit;

    @SerializedName("is_user_customized")
    private Boolean isUserCustomized;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/deal/aio/CreateCustomDealRequestSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(CreateCustomDealRequestSerializableObjectImpl.class);
        }
    }

    public CreateCustomDealRequestSerializableObjectImpl() {
    }

    @Override // com.bytedance.android.live.recharge.deal.aio.f
    public final long getCustomPrice() {
        return this.customPrice;
    }

    @Override // com.bytedance.android.live.recharge.deal.aio.f
    public final Boolean j4() {
        return this.isDisablePriceLimit;
    }

    @Override // com.bytedance.android.live.recharge.deal.aio.f
    public final Boolean s2() {
        return this.isUserCustomized;
    }
}
