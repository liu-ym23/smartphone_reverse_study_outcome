package com.larus.platform.model.bot;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/model/bot/MultiBotsOfflineConfig;", "", "pointSwitches", "Lcom/larus/platform/model/bot/MultiBotsPointSwitches;", "<init>", "(Lcom/larus/platform/model/bot/MultiBotsPointSwitches;)V", "getPointSwitches", "()Lcom/larus/platform/model/bot/MultiBotsPointSwitches;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MultiBotsOfflineConfig {

    @SerializedName("point_switches")
    private final MultiBotsPointSwitches pointSwitches;

    public MultiBotsOfflineConfig() {
        MultiBotsPointSwitches r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ MultiBotsOfflineConfig copy$default(MultiBotsOfflineConfig r0, MultiBotsPointSwitches r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.pointSwitches;
    L6:
        return r0.copy(r1);
    }

    public final MultiBotsPointSwitches component1() {
        return this.pointSwitches;
    }

    public final MultiBotsOfflineConfig copy(MultiBotsPointSwitches r2) {
        return new MultiBotsOfflineConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MultiBotsOfflineConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.pointSwitches, ((MultiBotsOfflineConfig) r4).pointSwitches) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        MultiBotsPointSwitches r0 = this.pointSwitches;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "MultiBotsOfflineConfig(pointSwitches=" + this.pointSwitches + ')';
    }

    public final MultiBotsPointSwitches getPointSwitches() {
        return this.pointSwitches;
    }

    public MultiBotsOfflineConfig(MultiBotsPointSwitches r1) {
        this.pointSwitches = r1;
    }

    public /* synthetic */ MultiBotsOfflineConfig(MultiBotsPointSwitches r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
