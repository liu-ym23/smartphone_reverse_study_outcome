package com.bytedance.android.live.base.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/base/model/MinorExtra;", "Lcom/bytedance/android/live/base/model/Extra;", "()V", "flow", "", "getFlow", "()Ljava/lang/String;", "setFlow", "(Ljava/lang/String;)V", "scene", "getScene", "setScene", "ticket", "getTicket", "setTicket", "twoFactorAuthInfo", "getTwoFactorAuthInfo", "setTwoFactorAuthInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MinorExtra extends Extra {

    @SerializedName("flow")
    private String flow;

    @SerializedName("scene")
    private String scene;

    @SerializedName("ticket")
    private String ticket;

    @SerializedName("two_factory_auth_info")
    private String twoFactorAuthInfo;

    public MinorExtra() {
    }

    public final String getFlow() {
        return this.flow;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final String getTwoFactorAuthInfo() {
        return this.twoFactorAuthInfo;
    }

    public final void setFlow(String r1) {
        this.flow = r1;
    }

    public final void setScene(String r1) {
        this.scene = r1;
    }

    public final void setTicket(String r1) {
        this.ticket = r1;
    }

    public final void setTwoFactorAuthInfo(String r1) {
        this.twoFactorAuthInfo = r1;
    }
}
