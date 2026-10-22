package com.bytedance.android.live.base.model.shopping;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u0004\u0018\u00010\u0004J\b\u0010+\u001a\u0004\u0018\u00010\u0004J\b\u0010,\u001a\u0004\u0018\u00010\u0004J\b\u0010-\u001a\u0004\u0018\u00010\u0004J\u0006\u0010.\u001a\u00020\u0013J\b\u0010/\u001a\u0004\u0018\u00010\u0004J\b\u00100\u001a\u0004\u0018\u00010\u0004J\b\u00101\u001a\u0004\u0018\u00010\u0004J\b\u00102\u001a\u0004\u0018\u00010\u0004J\b\u00103\u001a\u0004\u0018\u00010\u0004J\b\u00104\u001a\u0004\u0018\u00010\u0004J\u0010\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0004J\u0010\u00108\u001a\u0002062\b\u00109\u001a\u0004\u0018\u00010\u0004J\u0010\u0010:\u001a\u0002062\b\u0010;\u001a\u0004\u0018\u00010\u0004J\u0010\u0010<\u001a\u0002062\b\u0010=\u001a\u0004\u0018\u00010\u0004J\u000e\u0010>\u001a\u0002062\u0006\u0010?\u001a\u00020\u0013J\u0010\u0010@\u001a\u0002062\b\u0010A\u001a\u0004\u0018\u00010\u0004J\u0010\u0010B\u001a\u0002062\b\u0010C\u001a\u0004\u0018\u00010\u0004J\u0010\u0010D\u001a\u0002062\b\u0010E\u001a\u0004\u0018\u00010\u0004J\u0010\u0010F\u001a\u0002062\b\u0010G\u001a\u0004\u0018\u00010\u0004J\u0010\u0010H\u001a\u0002062\b\u0010I\u001a\u0004\u0018\u00010\u0004J\u0010\u0010J\u001a\u0002062\b\u0010K\u001a\u0004\u0018\u00010\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\b¨\u0006L"}, d2 = {"Lcom/bytedance/android/live/base/model/shopping/UpdatedCampaignInfo;", "", "()V", "_campaignId", "", "get_campaignId", "()Ljava/lang/String;", "set_campaignId", "(Ljava/lang/String;)V", "_endLabel", "get_endLabel", "set_endLabel", "_endTime", "get_endTime", "set_endTime", "_isPreheat", "get_isPreheat", "set_isPreheat", "_isValid", "", "get_isValid", "()Z", "set_isValid", "(Z)V", "_label", "get_label", "set_label", "_pic", "get_pic", "set_pic", "_price", "get_price", "set_price", "_startLabel", "get_startLabel", "set_startLabel", "_startTime", "get_startTime", "set_startTime", "_userLimit", "get_userLimit", "set_userLimit", "getCampaignId", "getEndLabel", "getEndTime", "getIsPreheat", "getIsValid", "getLabel", "getPic", "getPrice", "getStartLabel", "getStartTime", "getUserLimit", "setCampaignId", "", "campaignId", "setEndLabel", "endLabel", "setEndTime", "endTime", "setIsPreheat", "isPreheat", "setIsValid", "isValid", "setLabel", "label", "setPic", "pic", "setPrice", "price", "setStartLabel", "startLabel", "setStartTime", "startTime", "setUserLimit", "userLimit", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdatedCampaignInfo {

    @SerializedName("campaign_id")
    private String _campaignId;

    @SerializedName("time_end_label")
    private String _endLabel;

    @SerializedName("end_time")
    private String _endTime;

    @SerializedName("is_preheat")
    private String _isPreheat;

    @SerializedName("is_valid")
    private boolean _isValid;

    @SerializedName("label")
    private String _label;

    @SerializedName("pic")
    private String _pic;

    @SerializedName("price")
    private String _price;

    @SerializedName("time_start_label")
    private String _startLabel;

    @SerializedName("start_time")
    private String _startTime;

    @SerializedName("user_limit")
    private String _userLimit;

    public UpdatedCampaignInfo() {
    }

    public final String getCampaignId() {
        return this._campaignId;
    }

    public final String getEndLabel() {
        return this._endLabel;
    }

    public final String getEndTime() {
        return this._endTime;
    }

    public final String getIsPreheat() {
        return this._isPreheat;
    }

    public final boolean getIsValid() {
        return this._isValid;
    }

    public final String getLabel() {
        return this._label;
    }

    public final String getPic() {
        return this._pic;
    }

    public final String getPrice() {
        return this._price;
    }

    public final String getStartLabel() {
        return this._startLabel;
    }

    public final String getStartTime() {
        return this._startTime;
    }

    public final String getUserLimit() {
        return this._userLimit;
    }

    public final String get_campaignId() {
        return this._campaignId;
    }

    public final String get_endLabel() {
        return this._endLabel;
    }

    public final String get_endTime() {
        return this._endTime;
    }

    public final String get_isPreheat() {
        return this._isPreheat;
    }

    public final boolean get_isValid() {
        return this._isValid;
    }

    public final String get_label() {
        return this._label;
    }

    public final String get_pic() {
        return this._pic;
    }

    public final String get_price() {
        return this._price;
    }

    public final String get_startLabel() {
        return this._startLabel;
    }

    public final String get_startTime() {
        return this._startTime;
    }

    public final String get_userLimit() {
        return this._userLimit;
    }

    public final void setCampaignId(String r1) {
        this._campaignId = r1;
    }

    public final void setEndLabel(String r1) {
        this._endLabel = r1;
    }

    public final void setEndTime(String r1) {
        this._endTime = r1;
    }

    public final void setIsPreheat(String r1) {
        this._isPreheat = r1;
    }

    public final void setIsValid(boolean r1) {
        this._isValid = r1;
    }

    public final void setLabel(String r1) {
        this._label = r1;
    }

    public final void setPic(String r1) {
        this._pic = r1;
    }

    public final void setPrice(String r1) {
        this._price = r1;
    }

    public final void setStartLabel(String r1) {
        this._startLabel = r1;
    }

    public final void setStartTime(String r1) {
        this._startTime = r1;
    }

    public final void setUserLimit(String r1) {
        this._userLimit = r1;
    }

    public final void set_campaignId(String r1) {
        this._campaignId = r1;
    }

    public final void set_endLabel(String r1) {
        this._endLabel = r1;
    }

    public final void set_endTime(String r1) {
        this._endTime = r1;
    }

    public final void set_isPreheat(String r1) {
        this._isPreheat = r1;
    }

    public final void set_isValid(boolean r1) {
        this._isValid = r1;
    }

    public final void set_label(String r1) {
        this._label = r1;
    }

    public final void set_pic(String r1) {
        this._pic = r1;
    }

    public final void set_price(String r1) {
        this._price = r1;
    }

    public final void set_startLabel(String r1) {
        this._startLabel = r1;
    }

    public final void set_startTime(String r1) {
        this._startTime = r1;
    }

    public final void set_userLimit(String r1) {
        this._userLimit = r1;
    }
}
