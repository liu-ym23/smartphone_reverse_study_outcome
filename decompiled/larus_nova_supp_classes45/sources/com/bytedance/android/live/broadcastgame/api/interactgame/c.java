package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/interactgame/c;", "", "", "gameId", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "showDuration", "d", "showTime", "e", "", "guideText", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "", "supportLiveMode", "Ljava/util/List;", "g", "()Ljava/util/List;", "supportLiveEntrance", "J", "f", "()J", "guideType", "I", "c", "()I", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("game_id")
    private final Long gameId;

    @SerializedName("guide_text")
    private final String guideText;

    @SerializedName("guide_type")
    private final int guideType;

    @SerializedName("show_duration")
    private final Long showDuration;

    @SerializedName("show_time")
    private final Long showTime;

    @SerializedName("support_live_entrance")
    private final long supportLiveEntrance;

    @SerializedName("support_live_mode")
    private final List<Integer> supportLiveMode;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L20;
        c r7 = (c) r6;
        if (Intrinsics.areEqual(this.gameId, r7.gameId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showDuration, r7.showDuration) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.showTime, r7.showTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.guideText, r7.guideText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.supportLiveMode, r7.supportLiveMode) == true) goto L16;
        return false;
    L16:
        if (this.supportLiveEntrance == r7.supportLiveEntrance) goto L18;
        return false;
    L18:
        if (this.guideType == r7.guideType) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.gameId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.showDuration;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.showTime;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r11 = this.guideText;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        List<Integer> r14 = this.supportLiveMode;
        if (r14 == null) goto L21;
        r1 = r14.hashCode();
    L21:
        int r15 = (r13 + r1) * 31;
        long r16 = this.supportLiveEntrance;
        return ((r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31) + this.guideType;
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
        return "GameGuideExtra(gameId=" + this.gameId + ", showDuration=" + this.showDuration + ", showTime=" + this.showTime + ", guideText=" + this.guideText + ", supportLiveMode=" + this.supportLiveMode + ", supportLiveEntrance=" + this.supportLiveEntrance + ", guideType=" + this.guideType + ")";
    }

    public final Long a() {
        return this.gameId;
    }

    public final String b() {
        return this.guideText;
    }

    public final int c() {
        return this.guideType;
    }

    public final Long d() {
        return this.showDuration;
    }

    public final Long e() {
        return this.showTime;
    }

    public final long f() {
        return this.supportLiveEntrance;
    }

    public final List<Integer> g() {
        return this.supportLiveMode;
    }
}
