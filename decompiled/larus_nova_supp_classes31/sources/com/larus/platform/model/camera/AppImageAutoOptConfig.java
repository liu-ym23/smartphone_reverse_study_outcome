package com.larus.platform.model.camera;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/platform/model/camera/AppImageAutoOptConfig;", "", "isPreHeatEnabled", "", "preHeatTargetCount", "", "preHeatThreshold", "<init>", "(ZII)V", "()Z", "getPreHeatTargetCount", "()I", "getPreHeatThreshold", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AppImageAutoOptConfig {

    @SerializedName("image_upload_preheat_enabled")
    private final boolean isPreHeatEnabled;

    @SerializedName("image_upload_preheat_target_count")
    private final int preHeatTargetCount;

    @SerializedName("image_upload_preheat_threshold")
    private final int preHeatThreshold;

    public AppImageAutoOptConfig() {
        this(false, 0, 0, 7, null);
    }

    public static /* synthetic */ AppImageAutoOptConfig copy$default(AppImageAutoOptConfig r0, boolean r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.isPreHeatEnabled;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.preHeatTargetCount;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.preHeatThreshold;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.isPreHeatEnabled;
    }

    public final int component2() {
        return this.preHeatTargetCount;
    }

    public final int component3() {
        return this.preHeatThreshold;
    }

    public final AppImageAutoOptConfig copy(boolean r2, int r3, int r4) {
        return new AppImageAutoOptConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AppImageAutoOptConfig) == true) goto L8;
        return false;
    L8:
        AppImageAutoOptConfig r6 = (AppImageAutoOptConfig) r5;
        if (this.isPreHeatEnabled == r6.isPreHeatEnabled) goto L12;
        return false;
    L12:
        if (this.preHeatTargetCount == r6.preHeatTargetCount) goto L15;
        return false;
    L15:
        if (this.preHeatThreshold == r6.preHeatThreshold) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.isPreHeatEnabled == false) goto L5;
        int r0 = 1231;
    L7:
        return (((r0 * 31) + this.preHeatTargetCount) * 31) + this.preHeatThreshold;
    L5:
        r0 = 1237;
        goto L7
    }

    public String toString() {
        return "AppImageAutoOptConfig(isPreHeatEnabled=" + this.isPreHeatEnabled + ", preHeatTargetCount=" + this.preHeatTargetCount + ", preHeatThreshold=" + this.preHeatThreshold + ')';
    }

    public final int getPreHeatTargetCount() {
        return this.preHeatTargetCount;
    }

    public final int getPreHeatThreshold() {
        return this.preHeatThreshold;
    }

    public final boolean isPreHeatEnabled() {
        return this.isPreHeatEnabled;
    }

    public AppImageAutoOptConfig(boolean r1, int r2, int r3) {
        this.isPreHeatEnabled = r1;
        this.preHeatTargetCount = r2;
        this.preHeatThreshold = r3;
    }

    public /* synthetic */ AppImageAutoOptConfig(boolean r1, int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 10;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = 4;
    L11:
        this(r1, r2, r3);
    }
}
