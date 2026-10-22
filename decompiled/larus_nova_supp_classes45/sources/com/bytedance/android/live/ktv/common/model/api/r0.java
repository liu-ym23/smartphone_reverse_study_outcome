package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0010¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/r0;", "", "", "rank", "Ljava/lang/Long;", "f", "()Ljava/lang/Long;", "Lcom/bytedance/android/live/ktv/common/model/api/s0;", "userInfo", "Lcom/bytedance/android/live/ktv/common/model/api/s0;", "g", "()Lcom/bytedance/android/live/ktv/common/model/api/s0;", "", "is_high_score_singing", "Ljava/lang/Boolean;", "h", "()Ljava/lang/Boolean;", "", "high_score_song_threshold", "Ljava/lang/Double;", "c", "()Ljava/lang/Double;", "", "high_score_feedback_text", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "not_high_score_feedback_text", "e", "component_high_score_ending_text", "getComponent_high_score_ending_text", "component_not_high_score_ending_text", "a", "if_sing_for_enough_time", "d", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class r0 implements vh7.h {

    @SerializedName("component_high_score_ending_text")
    protected String component_high_score_ending_text;

    @SerializedName("component_not_high_score_ending_text")
    protected String component_not_high_score_ending_text;

    @SerializedName("high_score_feedback_text")
    protected String high_score_feedback_text;

    @SerializedName("high_score_song_threshold")
    protected Double high_score_song_threshold;

    @SerializedName("if_sing_for_enough_time")
    protected Boolean if_sing_for_enough_time;

    @SerializedName("is_high_score_singing")
    protected Boolean is_high_score_singing;

    @SerializedName("not_high_score_feedback_text")
    protected String not_high_score_feedback_text;

    @SerializedName("rank_percent")
    protected Long rank;

    @SerializedName("SingerUserInfo")
    protected s0 userInfo;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof r0) == false) goto L24;
        r0 r4 = (r0) r3;
        if (Intrinsics.areEqual(this.rank, r4.rank) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userInfo, r4.userInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.is_high_score_singing, r4.is_high_score_singing) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.high_score_song_threshold, r4.high_score_song_threshold) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.high_score_feedback_text, r4.high_score_feedback_text) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.not_high_score_feedback_text, r4.not_high_score_feedback_text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.component_high_score_ending_text, r4.component_high_score_ending_text) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.component_not_high_score_ending_text, r4.component_not_high_score_ending_text) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.if_sing_for_enough_time, r4.if_sing_for_enough_time) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.rank;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        s0 r4 = this.userInfo;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.is_high_score_singing;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Double r11 = this.high_score_song_threshold;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        String r14 = this.high_score_feedback_text;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.not_high_score_feedback_text;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        String r21 = this.component_high_score_ending_text;
        if (r21 == null) goto L29;
        int r22 = r21.hashCode();
    L30:
        int r23 = (r19 + r22) * 31;
        String r24 = this.component_not_high_score_ending_text;
        if (r24 == null) goto L33;
        int r25 = r24.hashCode();
    L34:
        int r26 = (r23 + r25) * 31;
        Boolean r27 = this.if_sing_for_enough_time;
        if (r27 == null) goto L38;
        r1 = r27.hashCode();
    L38:
        return r26 + r1;
    L33:
        r25 = 0;
        goto L34
    L29:
        r22 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
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
        return "ReportMidiScoreResponse(rank=" + this.rank + ", userInfo=" + this.userInfo + ", is_high_score_singing=" + this.is_high_score_singing + ", high_score_song_threshold=" + this.high_score_song_threshold + ", high_score_feedback_text=" + this.high_score_feedback_text + ", not_high_score_feedback_text=" + this.not_high_score_feedback_text + ", component_high_score_ending_text=" + this.component_high_score_ending_text + ", component_not_high_score_ending_text=" + this.component_not_high_score_ending_text + ", if_sing_for_enough_time=" + this.if_sing_for_enough_time + ")";
    }

    public r0() {
        this.rank = null;
        this.userInfo = null;
        this.is_high_score_singing = null;
        this.high_score_song_threshold = null;
        this.high_score_feedback_text = null;
        this.not_high_score_feedback_text = null;
        this.component_high_score_ending_text = null;
        this.component_not_high_score_ending_text = null;
        this.if_sing_for_enough_time = null;
    }

    public final String a() {
        return this.component_not_high_score_ending_text;
    }

    public final String b() {
        return this.high_score_feedback_text;
    }

    public final Double c() {
        return this.high_score_song_threshold;
    }

    public final Boolean d() {
        return this.if_sing_for_enough_time;
    }

    public final String e() {
        return this.not_high_score_feedback_text;
    }

    public final Long f() {
        return this.rank;
    }

    public final s0 g() {
        return this.userInfo;
    }

    public final Boolean h() {
        return this.is_high_score_singing;
    }

    public r0(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L16;
        switch(r2) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.if_sing_for_enough_time = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L8:
        this.component_not_high_score_ending_text = am3.h.c(r5);
        goto L3
    L9:
        this.component_high_score_ending_text = am3.h.c(r5);
        goto L3
    L10:
        this.not_high_score_feedback_text = am3.h.c(r5);
        goto L3
    L11:
        this.high_score_feedback_text = am3.h.c(r5);
        goto L3
    L12:
        this.high_score_song_threshold = Double.valueOf(Double.longBitsToDouble(r5.h()));
        goto L3
    L13:
        this.is_high_score_singing = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L14:
        this.userInfo = new s0(r5);
        goto L3
    L15:
        this.rank = Long.valueOf(r5.j());
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L16:
        r5.d(r0);
        if (this.rank != null) goto L20;
        this.rank = null;
    L20:
        if (this.userInfo != null) goto L23;
        this.userInfo = null;
    L23:
        if (this.is_high_score_singing != null) goto L26;
        this.is_high_score_singing = null;
    L26:
        if (this.high_score_song_threshold != null) goto L29;
        this.high_score_song_threshold = null;
    L29:
        if (this.high_score_feedback_text != null) goto L32;
        this.high_score_feedback_text = null;
    L32:
        if (this.not_high_score_feedback_text != null) goto L35;
        this.not_high_score_feedback_text = null;
    L35:
        if (this.component_high_score_ending_text != null) goto L38;
        this.component_high_score_ending_text = null;
    L38:
        if (this.component_not_high_score_ending_text != null) goto L41;
        this.component_not_high_score_ending_text = null;
    L41:
        if (this.if_sing_for_enough_time != null) goto L66;
        this.if_sing_for_enough_time = null;
        return;
    }
}
