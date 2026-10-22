package com.bytedance.android.live.recharge.panel.aio;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vw0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/recharge/panel/aio/RechargeCommonParamsSerializableObjectImpl;", "Lvw0/g;", "", "chargeScene", "Ljava/lang/String;", "getChargeScene", "()Ljava/lang/String;", "n8", "(Ljava/lang/String;)V", "chargeReason", "getChargeReason", "U6", "bioType", "getBioType", "Z7", "cjSdkVersion", "getCjSdkVersion", "F6", "roomType", "getRoomType", "N4", "payScene", "getPayScene", "T6", "liveType", "getLiveType", "setLiveType", "<init>", "()V", "Adapter", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeCommonParamsSerializableObjectImpl implements g {

    @SerializedName("bio_type")
    private String bioType;

    @SerializedName("charge_reason")
    private String chargeReason;

    @SerializedName("charge_scene")
    private String chargeScene;

    @SerializedName("cj_sdk_version")
    private String cjSdkVersion;

    @SerializedName("live_type")
    private String liveType;

    @SerializedName("pay_scene")
    private String payScene;

    @SerializedName("room_type")
    private String roomType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/panel/aio/RechargeCommonParamsSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RechargeCommonParamsSerializableObjectImpl.class);
        }
    }

    public RechargeCommonParamsSerializableObjectImpl() {
        this.chargeScene = "";
        this.chargeReason = "";
        this.bioType = "";
        this.cjSdkVersion = "";
        this.roomType = "";
        this.payScene = "";
        this.liveType = "";
    }

    @Override // vw0.g
    public final void F6(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cjSdkVersion = r2;
    }

    @Override // vw0.g
    public final void N4(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.roomType = r2;
    }

    @Override // vw0.g
    public final void T6(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.payScene = r2;
    }

    @Override // vw0.g
    public final void U6(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.chargeReason = r2;
    }

    @Override // vw0.g
    public final void Z7(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.bioType = r2;
    }

    @Override // vw0.g
    public final void n8(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.chargeScene = r2;
    }

    @Override // vw0.g
    public final void setLiveType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.liveType = r2;
    }
}
