package com.ss.android.lark.conditional.access.network.model.response;

import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/conditional/access/network/model/response/GetDeviceInfoData;", "Ljava/io/Serializable;", "<init>", "()V", "exist", BuildConfig.FLAVOR, "getExist", "()Z", "setExist", "(Z)V", "ownership", BuildConfig.FLAVOR, "getOwnership", "()I", "setOwnership", "(I)V", "applyStatus", "getApplyStatus", "setApplyStatus", "rejectReason", BuildConfig.FLAVOR, "getRejectReason", "()Ljava/lang/String;", "setRejectReason", "(Ljava/lang/String;)V", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetDeviceInfoData implements Serializable {

    @SerializedName("apply_status")
    private int applyStatus;

    @SerializedName("exist")
    private boolean exist;

    @SerializedName("ownership")
    private int ownership;

    @SerializedName("reject_reason")
    private String rejectReason;

    public GetDeviceInfoData() {
    }

    public final int getApplyStatus() {
        return this.applyStatus;
    }

    public final boolean getExist() {
        return this.exist;
    }

    public final int getOwnership() {
        return this.ownership;
    }

    public final String getRejectReason() {
        return this.rejectReason;
    }

    public final void setApplyStatus(int r1) {
        this.applyStatus = r1;
    }

    public final void setExist(boolean r1) {
        this.exist = r1;
    }

    public final void setOwnership(int r1) {
        this.ownership = r1;
    }

    public final void setRejectReason(String r1) {
        this.rejectReason = r1;
    }
}
