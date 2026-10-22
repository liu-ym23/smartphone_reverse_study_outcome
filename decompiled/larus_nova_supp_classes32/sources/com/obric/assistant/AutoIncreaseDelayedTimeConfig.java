package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/AutoIncreaseDelayedTimeConfig;", NameKeys.UnloadStrategy_No_Strategy, "autoIncreaseDelayedTime", NameKeys.UnloadStrategy_No_Strategy, "autoIncreaseDelayedTimeSeed", "<init>", "(JJ)V", "getAutoIncreaseDelayedTime", "()J", "getAutoIncreaseDelayedTimeSeed", "component1", "component2", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoIncreaseDelayedTimeConfig {

    @SerializedName("auto_increase_delayed_time")
    private final long autoIncreaseDelayedTime;

    @SerializedName("auto_increase_delayed_time_seed")
    private final long autoIncreaseDelayedTimeSeed;

    public AutoIncreaseDelayedTimeConfig() {
        this(0, 0, 3, null);
    }

    public static /* synthetic */ AutoIncreaseDelayedTimeConfig copy$default(AutoIncreaseDelayedTimeConfig r0, long r1, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.autoIncreaseDelayedTime;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.autoIncreaseDelayedTimeSeed;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.autoIncreaseDelayedTime;
    }

    public final long component2() {
        return this.autoIncreaseDelayedTimeSeed;
    }

    public final AutoIncreaseDelayedTimeConfig copy(long r2, long r4) {
        return new AutoIncreaseDelayedTimeConfig(r2, r4);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof AutoIncreaseDelayedTimeConfig) == true) goto L8;
        return false;
    L8:
        AutoIncreaseDelayedTimeConfig r9 = (AutoIncreaseDelayedTimeConfig) r8;
        if (this.autoIncreaseDelayedTime == r9.autoIncreaseDelayedTime) goto L12;
        return false;
    L12:
        if (this.autoIncreaseDelayedTimeSeed == r9.autoIncreaseDelayedTimeSeed) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r0 = this.autoIncreaseDelayedTime;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.autoIncreaseDelayedTimeSeed;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public String toString() {
        return "AutoIncreaseDelayedTimeConfig(autoIncreaseDelayedTime=" + this.autoIncreaseDelayedTime + ", autoIncreaseDelayedTimeSeed=" + this.autoIncreaseDelayedTimeSeed + ')';
    }

    public final long getAutoIncreaseDelayedTime() {
        return this.autoIncreaseDelayedTime;
    }

    public final long getAutoIncreaseDelayedTimeSeed() {
        return this.autoIncreaseDelayedTimeSeed;
    }

    public AutoIncreaseDelayedTimeConfig(long r1, long r3) {
        this.autoIncreaseDelayedTime = r1;
        this.autoIncreaseDelayedTimeSeed = r3;
    }

    public /* synthetic */ AutoIncreaseDelayedTimeConfig(long r3, long r5, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = 1500;
    L6:
        if ((r7 & 2) == 0) goto L8;
        r5 = 1500;
    L8:
        this(r3, r5);
    }
}
