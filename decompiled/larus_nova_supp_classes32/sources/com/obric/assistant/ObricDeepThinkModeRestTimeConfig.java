package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/ObricDeepThinkModeRestTimeConfig;", NameKeys.UnloadStrategy_No_Strategy, "intervalTime", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/Long;)V", "getIntervalTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lcom/obric/assistant/ObricDeepThinkModeRestTimeConfig;", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDeepThinkModeRestTimeConfig {

    @SerializedName("interval_time")
    private final Long intervalTime;

    public ObricDeepThinkModeRestTimeConfig() {
        Long r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ ObricDeepThinkModeRestTimeConfig copy$default(ObricDeepThinkModeRestTimeConfig r0, Long r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.intervalTime;
    L6:
        return r0.copy(r1);
    }

    public final Long component1() {
        return this.intervalTime;
    }

    public final ObricDeepThinkModeRestTimeConfig copy(Long r2) {
        return new ObricDeepThinkModeRestTimeConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ObricDeepThinkModeRestTimeConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.intervalTime, ((ObricDeepThinkModeRestTimeConfig) r4).intervalTime) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Long r0 = this.intervalTime;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "ObricDeepThinkModeRestTimeConfig(intervalTime=" + this.intervalTime + ')';
    }

    public final Long getIntervalTime() {
        return this.intervalTime;
    }

    public ObricDeepThinkModeRestTimeConfig(Long r1) {
        this.intervalTime = r1;
    }

    public /* synthetic */ ObricDeepThinkModeRestTimeConfig(Long r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
