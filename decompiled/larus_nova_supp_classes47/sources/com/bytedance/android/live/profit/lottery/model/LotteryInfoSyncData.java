package com.bytedance.android.live.profit.lottery.model;

import am3.g;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\f\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u001b\u0010\u000f\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u001b\u0010\u0012\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u001b\u0010\u0015\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u001b\u0010\u0018\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\bR\u001b\u0010\u001b\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\bR\u001b\u0010\u001e\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\bR\u001b\u0010!\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\bR\u001b\u0010%\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010)R\u001b\u0010-\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0006\u001a\u0004\b,\u0010\bR\u001b\u00100\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0006\u001a\u0004\b/\u0010\b¨\u00063"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/model/LotteryInfoSyncData;", "", "", "toString", "", "lotteryId$delegate", "Ljava/lang/Object;", "getLotteryId", "()J", "lotteryId", "lotteryType$delegate", "getLotteryType", "lotteryType", "luckyCount$delegate", "getLuckyCount", "luckyCount", "prizeCount$delegate", "getPrizeCount", "prizeCount", "candidateTotalCount$delegate", "getCandidateTotalCount", "candidateTotalCount", "lastSurgeTimeStamp$delegate", "getLastSurgeTimeStamp", "lastSurgeTimeStamp", "startTime$delegate", "getStartTime", "startTime", "drawTime$delegate", "getDrawTime", "drawTime", "enabledDilatation$delegate", "getEnabledDilatation", "enabledDilatation", "dilatationConfigDetail$delegate", "getDilatationConfigDetail", "()Ljava/lang/String;", "dilatationConfigDetail", "", "dilatationNow$delegate", "getDilatationNow", "()Z", "dilatationNow", "prizeCountBeforeDilatation$delegate", "getPrizeCountBeforeDilatation", "prizeCountBeforeDilatation", "luckyCountBeforeDilatation$delegate", "getLuckyCountBeforeDilatation", "luckyCountBeforeDilatation", "<init>", "()V", "liveprofit-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LotteryInfoSyncData implements h {

    @SerializedName("candidate_total_count")
    protected long _$$candidateTotalCount;

    @SerializedName("dilatation_config_detail")
    protected String _$$dilatationConfigDetail;

    @SerializedName("dilatation_now")
    protected boolean _$$dilatationNow;

    @SerializedName("draw_time")
    protected long _$$drawTime;

    @SerializedName("enabled_dilatation")
    protected long _$$enabledDilatation;

    @SerializedName("last_candidate_total_count_surge_timestamp")
    protected long _$$lastSurgeTimeStamp;

    @SerializedName("lottery_id")
    protected long _$$lotteryId;

    @SerializedName("lottery_type")
    protected long _$$lotteryType;

    @SerializedName("lucky_count")
    protected long _$$luckyCount;

    @SerializedName("lucky_count_before_dilatation")
    protected long _$$luckyCountBeforeDilatation;

    @SerializedName("prize_count")
    protected long _$$prizeCount;

    @SerializedName("prize_count_before_dilatation")
    protected long _$$prizeCountBeforeDilatation;

    @SerializedName("start_time")
    protected long _$$startTime;

    public LotteryInfoSyncData() {
        this._$$lotteryId = 0;
        this._$$lotteryType = 0;
        this._$$luckyCount = 0;
        this._$$prizeCount = 0;
        this._$$candidateTotalCount = 0;
        this._$$lastSurgeTimeStamp = 0;
        this._$$startTime = 0;
        this._$$drawTime = 0;
        this._$$enabledDilatation = 0;
        this._$$dilatationConfigDetail = "";
        this._$$dilatationNow = false;
        this._$$prizeCountBeforeDilatation = 0;
        this._$$luckyCountBeforeDilatation = 0;
    }

    public String toString() {
        return "{lottery_id=" + getLotteryId() + ", lottery_type=" + getLotteryType() + ", lucky_count=" + getLuckyCount() + ", prize_count=" + getPrizeCount() + ", candidate_total_count=" + getCandidateTotalCount() + ", last_candidate_total_count_surge_timestamp=" + getLastSurgeTimeStamp() + ", start_time=" + getStartTime() + ", draw_time=" + getDrawTime() + ", enabled_dilatation=" + getEnabledDilatation() + ", dilatation_config_detail=" + getDilatationConfigDetail() + ", dilatation_now=" + getDilatationNow() + ", prize_count_before_dilatation=" + getPrizeCountBeforeDilatation() + ", lucky_count_before_dilatation=" + getLuckyCountBeforeDilatation() + '}';
    }

    public final long getCandidateTotalCount() {
        return this._$$candidateTotalCount;
    }

    public final String getDilatationConfigDetail() {
        return this._$$dilatationConfigDetail;
    }

    public final boolean getDilatationNow() {
        return this._$$dilatationNow;
    }

    public final long getDrawTime() {
        return this._$$drawTime;
    }

    public final long getEnabledDilatation() {
        return this._$$enabledDilatation;
    }

    public final long getLastSurgeTimeStamp() {
        return this._$$lastSurgeTimeStamp;
    }

    public final long getLotteryId() {
        return this._$$lotteryId;
    }

    public final long getLotteryType() {
        return this._$$lotteryType;
    }

    public final long getLuckyCount() {
        return this._$$luckyCount;
    }

    public final long getLuckyCountBeforeDilatation() {
        return this._$$luckyCountBeforeDilatation;
    }

    public final long getPrizeCount() {
        return this._$$prizeCount;
    }

    public final long getPrizeCountBeforeDilatation() {
        return this._$$prizeCountBeforeDilatation;
    }

    public final long getStartTime() {
        return this._$$startTime;
    }

    public LotteryInfoSyncData(g r7) {
        long r0 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L20;
        switch(r4) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            default: goto L6;
        };
    L7:
        this._$$luckyCountBeforeDilatation = r7.j();
        r3 = r3 | 2048;
        goto L3
    L8:
        this._$$prizeCountBeforeDilatation = r7.j();
        r3 = r3 | 1024;
        goto L3
    L9:
        this._$$dilatationNow = am3.h.a(r7);
        r3 = r3 | 512;
        goto L3
    L10:
        this._$$dilatationConfigDetail = am3.h.c(r7);
        goto L3
    L11:
        this._$$enabledDilatation = r7.j();
        r3 = r3 | DefaultConfig.MAX_CACHE_ENTRIES;
        goto L3
    L12:
        this._$$drawTime = r7.j();
        r3 = r3 | 128;
        goto L3
    L13:
        this._$$startTime = r7.j();
        r3 = r3 | 64;
        goto L3
    L14:
        this._$$prizeCount = r7.j();
        r3 = r3 | 8;
        goto L3
    L15:
        this._$$lotteryType = r7.j();
        r3 = r3 | 2;
        goto L3
    L16:
        this._$$lastSurgeTimeStamp = r7.j();
        r3 = r3 | 32;
        goto L3
    L17:
        this._$$candidateTotalCount = r7.j();
        r3 = r3 | 16;
        goto L3
    L18:
        this._$$luckyCount = r7.j();
        r3 = r3 | 4;
        goto L3
    L19:
        this._$$lotteryId = r7.j();
        r3 = r3 | 1;
        goto L3
    L6:
        am3.h.e(r7);
        goto L3
    L20:
        r7.d(r0);
        if ((r3 & 1) != 0) goto L24;
        this._$$lotteryId = 0;
    L24:
        if ((r3 & 2) != 0) goto L27;
        this._$$lotteryType = 0;
    L27:
        if ((r3 & 4) != 0) goto L30;
        this._$$luckyCount = 0;
    L30:
        if ((r3 & 8) != 0) goto L33;
        this._$$prizeCount = 0;
    L33:
        if ((r3 & 16) != 0) goto L36;
        this._$$candidateTotalCount = 0;
    L36:
        if ((r3 & 32) != 0) goto L39;
        this._$$lastSurgeTimeStamp = 0;
    L39:
        if ((r3 & 64) != 0) goto L42;
        this._$$startTime = 0;
    L42:
        if ((r3 & 128) != 0) goto L45;
        this._$$drawTime = 0;
    L45:
        if ((r3 & DefaultConfig.MAX_CACHE_ENTRIES) != 0) goto L48;
        this._$$enabledDilatation = 0;
    L48:
        if (this._$$dilatationConfigDetail != null) goto L51;
        this._$$dilatationConfigDetail = "";
    L51:
        if ((r3 & 512) != 0) goto L54;
        this._$$dilatationNow = false;
    L54:
        if ((r3 & 1024) != 0) goto L57;
        this._$$prizeCountBeforeDilatation = 0;
    L57:
        if ((r3 & 2048) != 0) goto L90;
        this._$$luckyCountBeforeDilatation = 0;
        return;
    }
}
