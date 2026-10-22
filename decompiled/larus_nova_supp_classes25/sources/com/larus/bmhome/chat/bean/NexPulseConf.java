package com.larus.bmhome.chat.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\u000eR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/larus/bmhome/chat/bean/NexPulseConf;", "", "expireTime", "", "wcbTitle", "", "wcbTitleStyle", "", "freqControlInterval", "freqReqInterval", "throughToken", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getExpireTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWcbTitle", "()Ljava/lang/String;", "getWcbTitleStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFreqControlInterval", "getFreqReqInterval", "getThroughToken", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/larus/bmhome/chat/bean/NexPulseConf;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class NexPulseConf {

    @SerializedName("expire_time")
    private final Long expireTime;

    @SerializedName("freq_control_interval")
    private final Long freqControlInterval;

    @SerializedName("freq_req_interval")
    private final Long freqReqInterval;

    @SerializedName("through_token")
    private final String throughToken;

    @SerializedName("wcb_title")
    private final String wcbTitle;

    @SerializedName("wcb_title_style")
    private final Integer wcbTitleStyle;

    public NexPulseConf() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ NexPulseConf copy$default(NexPulseConf r4, Long r5, String r6, Integer r7, Long r8, Long r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.expireTime;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.wcbTitle;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.wcbTitleStyle;
    L11:
        Integer r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.freqControlInterval;
    L14:
        Long r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.freqReqInterval;
    L17:
        Long r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.throughToken;
    L20:
        Long r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Long component1() {
        return this.expireTime;
    }

    public final String component2() {
        return this.wcbTitle;
    }

    public final Integer component3() {
        return this.wcbTitleStyle;
    }

    public final Long component4() {
        return this.freqControlInterval;
    }

    public final Long component5() {
        return this.freqReqInterval;
    }

    public final String component6() {
        return this.throughToken;
    }

    public final NexPulseConf copy(Long r9, String r10, Integer r11, Long r12, Long r13, String r14) {
        return new NexPulseConf(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NexPulseConf) == true) goto L8;
        return false;
    L8:
        NexPulseConf r6 = (NexPulseConf) r5;
        if (Intrinsics.areEqual(this.expireTime, r6.expireTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.wcbTitle, r6.wcbTitle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.wcbTitleStyle, r6.wcbTitleStyle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.freqControlInterval, r6.freqControlInterval) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.freqReqInterval, r6.freqReqInterval) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.throughToken, r6.throughToken) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Long r0 = this.expireTime;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.wcbTitle;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.wcbTitleStyle;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.freqControlInterval;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.freqReqInterval;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.throughToken;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "NexPulseConf(expireTime=" + this.expireTime + ", wcbTitle=" + this.wcbTitle + ", wcbTitleStyle=" + this.wcbTitleStyle + ", freqControlInterval=" + this.freqControlInterval + ", freqReqInterval=" + this.freqReqInterval + ", throughToken=" + this.throughToken + ')';
    }

    public final Long getExpireTime() {
        return this.expireTime;
    }

    public final Long getFreqControlInterval() {
        return this.freqControlInterval;
    }

    public final Long getFreqReqInterval() {
        return this.freqReqInterval;
    }

    public final String getThroughToken() {
        return this.throughToken;
    }

    public final String getWcbTitle() {
        return this.wcbTitle;
    }

    public final Integer getWcbTitleStyle() {
        return this.wcbTitleStyle;
    }

    public NexPulseConf(Long r1, String r2, Integer r3, Long r4, Long r5, String r6) {
        this.expireTime = r1;
        this.wcbTitle = r2;
        this.wcbTitleStyle = r3;
        this.freqControlInterval = r4;
        this.freqReqInterval = r5;
        this.throughToken = r6;
    }

    public /* synthetic */ NexPulseConf(Long r6, String r7, Integer r8, Long r9, Long r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        Long r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        Integer r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        Long r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        Long r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        String r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
