package com.bytedance.android.live.broadcast.model;

import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR \u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010%\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001d¨\u0006("}, d2 = {"Lcom/bytedance/android/live/broadcast/model/RoomCreateBlockExtra;", "Lcom/bytedance/android/live/base/model/Extra;", "()V", "blockDialogInfo", "", "getBlockDialogInfo", "()Ljava/lang/String;", "setBlockDialogInfo", "(Ljava/lang/String;)V", "createBlockDetail", "getCreateBlockDetail", "setCreateBlockDetail", "isPhoneBinded", "", "()Ljava/lang/Boolean;", "setPhoneBinded", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "liveAgreement", "getLiveAgreement", "setLiveAgreement", "liveAnswer", "getLiveAnswer", "setLiveAnswer", "realNameVerify", "", "getRealNameVerify", "()Ljava/lang/Integer;", "setRealNameVerify", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ticket", "getTicket", "setTicket", "uniqueId", "getUniqueId", "setUniqueId", "verifyRiskLevel", "getVerifyRiskLevel", "setVerifyRiskLevel", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomCreateBlockExtra extends Extra {

    @SerializedName("block_dialog_info")
    private String blockDialogInfo;

    @SerializedName("create_block_detail")
    private String createBlockDetail;

    @SerializedName("is_phone_binded")
    private Boolean isPhoneBinded;

    @SerializedName("live_agreement")
    private Boolean liveAgreement;

    @SerializedName("live_answer")
    private Boolean liveAnswer;

    @SerializedName("realname_verify")
    private Integer realNameVerify;

    @SerializedName("ticket")
    private String ticket;

    @SerializedName("unique_id")
    private String uniqueId;

    @SerializedName("verify_risklevel")
    private Integer verifyRiskLevel;

    public RoomCreateBlockExtra() {
        this.blockDialogInfo = "";
        this.createBlockDetail = "";
        this.realNameVerify = 0;
        Boolean r2 = Boolean.FALSE;
        this.isPhoneBinded = r2;
        this.liveAgreement = r2;
        this.liveAnswer = Boolean.TRUE;
        this.uniqueId = "";
        this.ticket = "";
        this.verifyRiskLevel = 0;
    }

    public final String getBlockDialogInfo() {
        return this.blockDialogInfo;
    }

    public final String getCreateBlockDetail() {
        return this.createBlockDetail;
    }

    public final Boolean getLiveAgreement() {
        return this.liveAgreement;
    }

    public final Boolean getLiveAnswer() {
        return this.liveAnswer;
    }

    public final Integer getRealNameVerify() {
        return this.realNameVerify;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final Integer getVerifyRiskLevel() {
        return this.verifyRiskLevel;
    }

    public final Boolean isPhoneBinded() {
        return this.isPhoneBinded;
    }

    public final void setBlockDialogInfo(String r1) {
        this.blockDialogInfo = r1;
    }

    public final void setCreateBlockDetail(String r1) {
        this.createBlockDetail = r1;
    }

    public final void setLiveAgreement(Boolean r1) {
        this.liveAgreement = r1;
    }

    public final void setLiveAnswer(Boolean r1) {
        this.liveAnswer = r1;
    }

    public final void setPhoneBinded(Boolean r1) {
        this.isPhoneBinded = r1;
    }

    public final void setRealNameVerify(Integer r1) {
        this.realNameVerify = r1;
    }

    public final void setTicket(String r1) {
        this.ticket = r1;
    }

    public final void setUniqueId(String r1) {
        this.uniqueId = r1;
    }

    public final void setVerifyRiskLevel(Integer r1) {
        this.verifyRiskLevel = r1;
    }
}
