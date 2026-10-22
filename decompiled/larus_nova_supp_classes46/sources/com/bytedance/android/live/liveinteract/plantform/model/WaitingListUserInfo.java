package com.bytedance.android.live.liveinteract.plantform.model;

import android.text.TextUtils;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class WaitingListUserInfo extends FlexModelBase<o0> implements o0 {
    private static final int HASH_CODE_37 = 37;

    @SerializedName("application_reason")
    public String applyReason;

    @SerializedName("apply_time_sec")
    public Long applyTimeSec;

    @SerializedName("fuzzy_fan_ticket_str")
    public String fuzzyFanTicketStr;

    @SerializedName("application_has_expired")
    public boolean hasExpired;

    @SerializedName("is_mutual_following")
    public boolean isMutualFollow;

    @SerializedName("last_7_days_gift_count_text")
    public String last7DaysGiftCountTxt;

    public WaitingListUserInfo() {
        super(o0.class);
    }

    public int hashCode() {
        int r0 = (((this.hasExpired ? 1 : 0) * 37) + (this.isMutualFollow ? 1 : 0)) * 37;
        String r1 = this.applyReason;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 37;
        String r5 = this.last7DaysGiftCountTxt;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 37;
        String r8 = this.fuzzyFanTicketStr;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 37;
        Long r11 = this.applyTimeSec;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public String getApplyReason() {
        return this.applyReason;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public Long getApplyTimeSec() {
        return this.applyTimeSec;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public String getFuzzyFanTicketStr() {
        return this.fuzzyFanTicketStr;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public String getLast7DaysGiftCountTxt() {
        return this.last7DaysGiftCountTxt;
    }

    public boolean hasExpired() {
        return this.hasExpired;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public boolean isHasExpired() {
        return this.hasExpired;
    }

    public boolean isIsMutualFollow() {
        return this.isMutualFollow;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public boolean isMutualFollow() {
        return this.isMutualFollow;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L25;
        WaitingListUserInfo r6 = (WaitingListUserInfo) r5;
        if (this.hasExpired == r6.hasExpired) goto L13;
    L23:
        return false;
    L13:
        if (this.isMutualFollow != r6.isMutualFollow) goto L23;
        if (TextUtils.equals(this.applyReason, r6.applyReason) == false) goto L23;
        if (TextUtils.equals(this.last7DaysGiftCountTxt, r6.last7DaysGiftCountTxt) == false) goto L23;
        if (TextUtils.equals(this.fuzzyFanTicketStr, r6.fuzzyFanTicketStr) == false) goto L23;
        if (Objects.equals(this.applyTimeSec, r6.applyTimeSec) == false) goto L23;
        return true;
    }

    public boolean isEqual(WaitingListUserInfo r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (this.hasExpired == r4.hasExpired) goto L8;
        return false;
    L8:
        if (this.isMutualFollow == r4.isMutualFollow) goto L10;
        return false;
    L10:
        if (TextUtils.equals(this.applyReason, r4.applyReason) == true) goto L12;
        return false;
    L12:
        if (TextUtils.equals(this.last7DaysGiftCountTxt, r4.last7DaysGiftCountTxt) == true) goto L14;
        return false;
    L14:
        if (TextUtils.equals(this.fuzzyFanTicketStr, r4.fuzzyFanTicketStr) == true) goto L16;
        return false;
    L16:
        if (Objects.equals(this.applyTimeSec, r4.applyTimeSec) == false) goto L24;
        return true;
    L24:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public void setApplyReason(String r1) {
        this.applyReason = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public void setApplyTimeSec(Long r1) {
        this.applyTimeSec = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public void setFuzzyFanTicketStr(String r1) {
        this.fuzzyFanTicketStr = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public void setHasExpired(boolean r1) {
        this.hasExpired = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public void setLast7DaysGiftCountTxt(String r1) {
        this.last7DaysGiftCountTxt = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public void setMutualFollow(boolean r1) {
        this.isMutualFollow = r1;
    }
}
