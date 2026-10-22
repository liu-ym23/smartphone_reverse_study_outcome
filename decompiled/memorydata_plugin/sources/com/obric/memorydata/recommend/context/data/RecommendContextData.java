package com.obric.memorydata.recommend.context.data;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J1\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u0013R\u001e\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u0013R\u001e\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u0013R\u001e\u0010&\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u0013¨\u00064"}, d2 = {"Lcom/obric/memorydata/recommend/context/data/RecommendContextData;", "", "currentTs", "", "zone", "", "appName", "dayType", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCurrentTs", "()J", "getZone", "()Ljava/lang/String;", "getAppName", "getDayType", "phoneState", "getPhoneState", "setPhoneState", "(Ljava/lang/String;)V", "location", "getLocation", "setLocation", "locationState", "getLocationState", "setLocationState", "movementState", "getMovementState", "setMovementState", "triggerReason", "getTriggerReason", "setTriggerReason", "memoryShortTerm", "getMemoryShortTerm", "setMemoryShortTerm", "memoryUserProfile", "getMemoryUserProfile", "setMemoryUserProfile", "profileHabits", "getProfileHabits", "setProfileHabits", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecommendContextData {
    private final String appName;
    private final long currentTs;
    private final String dayType;
    private String location;
    private String locationState;

    @SerializedName("memory_short_term")
    private String memoryShortTerm;

    @SerializedName("memory_user_profile")
    private String memoryUserProfile;
    private String movementState;
    private String phoneState;

    @SerializedName("profile_habits")
    private String profileHabits;
    private String triggerReason;
    private final String zone;

    public RecommendContextData(long r2, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "zone");
        Intrinsics.checkNotNullParameter(r5, "appName");
        Intrinsics.checkNotNullParameter(r6, "dayType");
        this.currentTs = r2;
        this.zone = r4;
        this.appName = r5;
        this.dayType = r6;
        this.phoneState = "";
        this.location = "";
        this.locationState = "";
        this.movementState = "";
        this.triggerReason = "";
        this.memoryShortTerm = "";
        this.memoryUserProfile = "";
        this.profileHabits = "";
    }

    public static /* synthetic */ RecommendContextData copy$default(RecommendContextData r6, long r7, String r9, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.currentTs;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.zone;
    L8:
        String r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        r10 = r6.appName;
    L11:
        String r4 = r10;
        if ((r12 & 8) == 0) goto L15;
        r11 = r6.dayType;
    L15:
        return r6.copy(r1, r3, r4, r11);
    }

    public final long component1() {
        return this.currentTs;
    }

    public final String component2() {
        return this.zone;
    }

    public final String component3() {
        return this.appName;
    }

    public final String component4() {
        return this.dayType;
    }

    public final RecommendContextData copy(long r7, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "zone");
        Intrinsics.checkNotNullParameter(r10, "appName");
        Intrinsics.checkNotNullParameter(r11, "dayType");
        return new RecommendContextData(r7, r9, r10, r11);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, RecommendContextData.class) == true) goto L8;
        return false;
    L8:
        RecommendContextData r10 = (RecommendContextData) ZeusTransformUtils.preCheckCast(r9, RecommendContextData.class, "com.obric.memorydata.plugin");
        if (this.currentTs == r10.currentTs) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.zone, r10.zone) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appName, r10.appName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.dayType, r10.dayType) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final long getCurrentTs() {
        return this.currentTs;
    }

    public final String getDayType() {
        return this.dayType;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getLocationState() {
        return this.locationState;
    }

    public final String getMemoryShortTerm() {
        return this.memoryShortTerm;
    }

    public final String getMemoryUserProfile() {
        return this.memoryUserProfile;
    }

    public final String getMovementState() {
        return this.movementState;
    }

    public final String getPhoneState() {
        return this.phoneState;
    }

    public final String getProfileHabits() {
        return this.profileHabits;
    }

    public final String getTriggerReason() {
        return this.triggerReason;
    }

    public final String getZone() {
        return this.zone;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.currentTs) * 31) + this.zone.hashCode()) * 31) + this.appName.hashCode()) * 31) + this.dayType.hashCode();
    }

    public final void setLocation(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.location = r2;
    }

    public final void setLocationState(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.locationState = r2;
    }

    public final void setMemoryShortTerm(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.memoryShortTerm = r2;
    }

    public final void setMemoryUserProfile(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.memoryUserProfile = r2;
    }

    public final void setMovementState(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.movementState = r2;
    }

    public final void setPhoneState(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.phoneState = r2;
    }

    public final void setProfileHabits(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.profileHabits = r2;
    }

    public final void setTriggerReason(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.triggerReason = r2;
    }

    public String toString() {
        return "RecommendContextData(currentTs=" + this.currentTs + ", zone=" + this.zone + ", appName=" + this.appName + ", dayType=" + this.dayType + ')';
    }
}
