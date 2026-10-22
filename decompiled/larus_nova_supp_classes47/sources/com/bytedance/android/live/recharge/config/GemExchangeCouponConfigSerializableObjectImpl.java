package com.bytedance.android.live.recharge.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/recharge/config/GemExchangeCouponConfigSerializableObjectImpl;", "Lcom/bytedance/android/live/recharge/config/GemExchangeCouponConfig;", "", "scheme", "Ljava/lang/String;", "getScheme", "()Ljava/lang/String;", "M4", "(Ljava/lang/String;)V", "title", "getTitle", "v", "<init>", "()V", "Adapter", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GemExchangeCouponConfigSerializableObjectImpl implements GemExchangeCouponConfig {

    @SerializedName("scheme")
    private String scheme;

    @SerializedName("title")
    private String title;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/config/GemExchangeCouponConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GemExchangeCouponConfigSerializableObjectImpl.class);
        }
    }

    @Override // com.bytedance.android.live.recharge.config.GemExchangeCouponConfig
    public final void M4() {
        Intrinsics.checkNotNullParameter("sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Frevenue_exchange_douyin%2Fpages%2Fgemstone_coupon_list%2Ftemplate.js&type=popup&gravity=bottom&width_percent=100&height=463&show_dim=1", "<set-?>");
        this.scheme = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Frevenue_exchange_douyin%2Fpages%2Fgemstone_coupon_list%2Ftemplate.js&type=popup&gravity=bottom&width_percent=100&height=463&show_dim=1";
    }

    @Override // com.bytedance.android.live.recharge.config.GemExchangeCouponConfig
    public final void v() {
        Intrinsics.checkNotNullParameter("优惠券", "<set-?>");
        this.title = "优惠券";
    }

    public GemExchangeCouponConfigSerializableObjectImpl() {
        this.scheme = "";
        this.title = "";
    }

    @Override // com.bytedance.android.live.recharge.config.GemExchangeCouponConfig
    public final String getScheme() {
        return this.scheme;
    }

    @Override // com.bytedance.android.live.recharge.config.GemExchangeCouponConfig
    public final String getTitle() {
        return this.title;
    }
}
