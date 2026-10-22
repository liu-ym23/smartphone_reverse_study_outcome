package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/BreathWakeupDataTrackerConfig;", NameKeys.UnloadStrategy_No_Strategy, "enable", NameKeys.UnloadStrategy_No_Strategy, "desc", NameKeys.UnloadStrategy_No_Strategy, "time", "maxCacheSize", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(ZLjava/lang/String;Ljava/lang/String;I)V", "getEnable", "()Z", "getDesc", "()Ljava/lang/String;", "getTime", "getMaxCacheSize", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BreathWakeupDataTrackerConfig {

    @SerializedName("breath-tracker-desc")
    private final String desc;

    @SerializedName("breath-tracker-enable")
    private final boolean enable;

    @SerializedName("max-cache-size")
    private final int maxCacheSize;

    @SerializedName("breath-tracker-time")
    private final String time;

    public BreathWakeupDataTrackerConfig() {
        this(false, null, null, 0, 15, null);
    }

    public static /* synthetic */ BreathWakeupDataTrackerConfig copy$default(BreathWakeupDataTrackerConfig r0, boolean r1, String r2, String r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.desc;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.time;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.maxCacheSize;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final String component2() {
        return this.desc;
    }

    public final String component3() {
        return this.time;
    }

    public final int component4() {
        return this.maxCacheSize;
    }

    public final BreathWakeupDataTrackerConfig copy(boolean r2, String r3, String r4, int r5) {
        return new BreathWakeupDataTrackerConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BreathWakeupDataTrackerConfig) == true) goto L8;
        return false;
    L8:
        BreathWakeupDataTrackerConfig r6 = (BreathWakeupDataTrackerConfig) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r6.desc) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.time, r6.time) == true) goto L18;
        return false;
    L18:
        if (this.maxCacheSize == r6.maxCacheSize) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        String r2 = this.desc;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        String r6 = this.time;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return ((r5 + r3) * 31) + this.maxCacheSize;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "BreathWakeupDataTrackerConfig(enable=" + this.enable + ", desc=" + this.desc + ", time=" + this.time + ", maxCacheSize=" + this.maxCacheSize + ')';
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getMaxCacheSize() {
        return this.maxCacheSize;
    }

    public final String getTime() {
        return this.time;
    }

    public BreathWakeupDataTrackerConfig(boolean r1, String r2, String r3, int r4) {
        this.enable = r1;
        this.desc = r2;
        this.time = r3;
        this.maxCacheSize = r4;
    }

    public /* synthetic */ BreathWakeupDataTrackerConfig(boolean r2, String r3, String r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 10;
    L14:
        this(r2, r3, r4, r5);
    }
}
