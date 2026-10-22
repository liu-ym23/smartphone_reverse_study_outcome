package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/GiftRequestSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/d2;", BuildConfig.FLAVOR, "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", BuildConfig.FLAVOR, "giftId", "J", "getGiftId", "()J", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftRequestSerializableObjectImpl implements d2 {

    @SerializedName("gift_id")
    private final long giftId;

    @SerializedName("type")
    private final String type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/GiftRequestSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftRequestSerializableObjectImpl.class);
        }
    }

    public GiftRequestSerializableObjectImpl() {
        this.type = BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.d2
    public final String getType() {
        return this.type;
    }
}
