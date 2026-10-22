package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b4\u00105R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b/\u00101\"\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/x;", "", "", "challengeId", "J", "a", "()J", "setChallengeId", "(J)V", "switchStatus", "e", "setSwitchStatus", "", "isInSingingChallenge", "Z", "h", "()Z", "setInSingingChallenge", "(Z)V", "countdownSecond", "c", "setCountdownSecond", "currentScore", "d", "setCurrentScore", "targetDurationSecond", "f", "setTargetDurationSecond", "targetScore", "g", "setTargetScore", "current_gift_type", "Ljava/lang/Long;", "getCurrent_gift_type", "()Ljava/lang/Long;", "setCurrent_gift_type", "(Ljava/lang/Long;)V", "emoji_location", "getEmoji_location", "setEmoji_location", "", "challengeType", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setChallengeType", "(Ljava/lang/Integer;)V", "isSuccess", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setSuccess", "(Ljava/lang/Boolean;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class x implements vh7.h {

    @SerializedName("challenge_id")
    protected long challengeId;

    @SerializedName("ktv_challenge_type")
    protected Integer challengeType;

    @SerializedName("countdown_second")
    protected long countdownSecond;

    @SerializedName("current_score")
    protected long currentScore;

    @SerializedName("gift_type")
    protected Long current_gift_type;

    @SerializedName("emoji_location")
    protected Long emoji_location;

    @SerializedName("is_in_singing_challenge")
    protected boolean isInSingingChallenge;

    @SerializedName("is_success")
    protected Boolean isSuccess;

    @SerializedName("switch_status")
    protected long switchStatus;

    @SerializedName("target_duration_second")
    protected long targetDurationSecond;

    @SerializedName("target_score")
    protected long targetScore;

    public x() {
    }

    public final String toString() {
        return "challenge_id=" + this.challengeId + ", switch_status=" + this.switchStatus + ", is_in_singing_challenge=" + this.isInSingingChallenge + ", countdown_second=" + this.countdownSecond + ", current_score=" + this.currentScore + ", target_duration_second=" + this.targetDurationSecond + ", target_score=" + this.targetScore;
    }

    public final long a() {
        return this.challengeId;
    }

    public final Integer b() {
        return this.challengeType;
    }

    public final long c() {
        return this.countdownSecond;
    }

    public final long d() {
        return this.currentScore;
    }

    public final long e() {
        return this.switchStatus;
    }

    public final long f() {
        return this.targetDurationSecond;
    }

    public final long g() {
        return this.targetScore;
    }

    public final boolean h() {
        return this.isInSingingChallenge;
    }

    public x(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        switch(r2) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L6;
        };
    L7:
        this.isSuccess = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L8:
        this.challengeType = Integer.valueOf(r5.i());
        goto L3
    L9:
        this.emoji_location = Long.valueOf(r5.i());
        goto L3
    L10:
        this.current_gift_type = Long.valueOf(r5.i());
        goto L3
    L11:
        this.targetScore = r5.j();
        goto L3
    L12:
        this.targetDurationSecond = r5.j();
        goto L3
    L13:
        this.currentScore = r5.j();
        goto L3
    L14:
        this.countdownSecond = r5.j();
        goto L3
    L15:
        this.isInSingingChallenge = am3.h.a(r5);
        goto L3
    L16:
        this.challengeId = r5.j();
        goto L3
    L17:
        this.switchStatus = r5.j();
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
    }
}
