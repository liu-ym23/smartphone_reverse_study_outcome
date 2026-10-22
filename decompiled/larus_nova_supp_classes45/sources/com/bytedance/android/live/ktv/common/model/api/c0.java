package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdk.message.model.id;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/c0;", "", "", "", "scoreList", "Ljava/util/List;", "e", "()Ljava/util/List;", "durationSecondList", "getDurationSecondList", "defaultScore", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "defaultDurationSecond", "c", "Lcom/bytedance/android/livesdk/message/model/id;", "challengeTypeConfigList", "a", "defaultChallengeTypeConfig", "Lcom/bytedance/android/livesdk/message/model/id;", "b", "()Lcom/bytedance/android/livesdk/message/model/id;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c0 implements vh7.h {

    @SerializedName("ktv_challenge_type_config_list")
    protected List<id> challengeTypeConfigList;

    @SerializedName("default_ktv_challenge_type_config")
    protected id defaultChallengeTypeConfig;

    @SerializedName("default_duration_second")
    protected Long defaultDurationSecond;

    @SerializedName("default_score")
    protected Long defaultScore;

    @SerializedName("duration_second_list")
    protected List<Long> durationSecondList;

    @SerializedName("score_list")
    protected List<Long> scoreList;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c0) == false) goto L18;
        c0 r4 = (c0) r3;
        if (Intrinsics.areEqual(this.scoreList, r4.scoreList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.durationSecondList, r4.durationSecondList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.defaultScore, r4.defaultScore) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultDurationSecond, r4.defaultDurationSecond) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.challengeTypeConfigList, r4.challengeTypeConfigList) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.defaultChallengeTypeConfig, r4.defaultChallengeTypeConfig) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        List<Long> r0 = this.scoreList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<Long> r4 = this.durationSecondList;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.defaultScore;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r11 = this.defaultDurationSecond;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        List<id> r14 = this.challengeTypeConfigList;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        id r17 = this.defaultChallengeTypeConfig;
        if (r17 == null) goto L26;
        r1 = r17.hashCode();
    L26:
        return r16 + r1;
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvSingingChallengeOptionParamsResponse(scoreList=" + this.scoreList + ", durationSecondList=" + this.durationSecondList + ", defaultScore=" + this.defaultScore + ", defaultDurationSecond=" + this.defaultDurationSecond + ", challengeTypeConfigList=" + this.challengeTypeConfigList + ", defaultChallengeTypeConfig=" + this.defaultChallengeTypeConfig + ")";
    }

    public c0() {
        this.scoreList = null;
        this.durationSecondList = null;
        this.defaultScore = null;
        this.defaultDurationSecond = null;
        this.challengeTypeConfigList = null;
        this.defaultChallengeTypeConfig = null;
    }

    public final List<id> a() {
        return this.challengeTypeConfigList;
    }

    public final id b() {
        return this.defaultChallengeTypeConfig;
    }

    public final Long c() {
        return this.defaultDurationSecond;
    }

    public final Long d() {
        return this.defaultScore;
    }

    public final List<Long> e() {
        return this.scoreList;
    }

    public c0(am3.g r6) {
        this.scoreList = new ArrayList();
        this.durationSecondList = new ArrayList();
        this.challengeTypeConfigList = new ArrayList();
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        switch(r2) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.defaultChallengeTypeConfig = new id(r6);
        goto L3
    L8:
        List<id> r3 = this.challengeTypeConfigList;
        id r4 = new id(r6);
    L14:
        r3.add(r4);
        goto L3
    L9:
        this.defaultDurationSecond = Long.valueOf(r6.j());
        goto L3
    L10:
        this.defaultScore = Long.valueOf(r6.j());
        goto L3
    L11:
        r3 = this.durationSecondList;
    L13:
        r4 = Long.valueOf(r6.j());
        goto L14
    L12:
        r3 = this.scoreList;
        goto L13
    L6:
        am3.h.e(r6);
        goto L3
    L15:
        r6.d(r0);
        if (this.scoreList.isEmpty() == false) goto L19;
        this.scoreList = null;
    L19:
        if (this.durationSecondList.isEmpty() == false) goto L22;
        this.durationSecondList = null;
    L22:
        if (this.defaultScore != null) goto L25;
        this.defaultScore = null;
    L25:
        if (this.defaultDurationSecond != null) goto L28;
        this.defaultDurationSecond = null;
    L28:
        if (this.challengeTypeConfigList.isEmpty() == false) goto L31;
        this.challengeTypeConfigList = null;
    L31:
        if (this.defaultChallengeTypeConfig != null) goto L48;
        this.defaultChallengeTypeConfig = null;
        return;
    }
}
