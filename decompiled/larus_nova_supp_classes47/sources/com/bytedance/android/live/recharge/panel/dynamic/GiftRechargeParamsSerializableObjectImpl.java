package com.bytedance.android.live.recharge.panel.dynamic;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR.\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/recharge/panel/dynamic/GiftRechargeParamsSerializableObjectImpl;", "Lcom/bytedance/android/live/recharge/panel/dynamic/c;", "", "giftId", "J", "getGiftId", "()J", "setGiftId", "(J)V", "", "giftName", "Ljava/lang/String;", "getGiftName", "()Ljava/lang/String;", "setGiftName", "(Ljava/lang/String;)V", "giftPrice", "getGiftPrice", "p2", "giftPayMoney", "getGiftPayMoney", "f0", "giftSendType", "getGiftSendType", "r3", "giftRequestId", "getGiftRequestId", "m1", "", "extraParams", "Ljava/util/Map;", "getExtraParams", "()Ljava/util/Map;", "S0", "(Ljava/util/Map;)V", "<init>", "()V", "Adapter", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftRechargeParamsSerializableObjectImpl implements c {

    @SerializedName("extra_params")
    private Map<String, String> extraParams;

    @SerializedName("gift_id")
    private long giftId;

    @SerializedName("gift_name")
    private String giftName;

    @SerializedName("gift_pay_money")
    private long giftPayMoney;

    @SerializedName("gift_price")
    private long giftPrice;

    @SerializedName("gift_request_id")
    private String giftRequestId;

    @SerializedName("gift_send_type")
    private String giftSendType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/panel/dynamic/GiftRechargeParamsSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftRechargeParamsSerializableObjectImpl.class);
        }
    }

    public GiftRechargeParamsSerializableObjectImpl() {
        this.giftName = "";
        this.giftSendType = "";
        this.giftRequestId = "";
        this.extraParams = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.live.recharge.panel.dynamic.c
    public final void S0(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.extraParams = r2;
    }

    @Override // com.bytedance.android.live.recharge.panel.dynamic.c
    public final void f0(long r1) {
        this.giftPayMoney = r1;
    }

    @Override // com.bytedance.android.live.recharge.panel.dynamic.c
    public final void m1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.giftRequestId = r2;
    }

    @Override // com.bytedance.android.live.recharge.panel.dynamic.c
    public final void p2(long r1) {
        this.giftPrice = r1;
    }

    @Override // com.bytedance.android.live.recharge.panel.dynamic.c
    public final void r3(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.giftSendType = r2;
    }

    @Override // com.bytedance.android.live.recharge.panel.dynamic.c
    public final void setGiftId(long r1) {
        this.giftId = r1;
    }

    @Override // com.bytedance.android.live.recharge.panel.dynamic.c
    public final void setGiftName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.giftName = r2;
    }
}
