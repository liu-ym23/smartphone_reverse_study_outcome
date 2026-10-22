package com.bytedance.android.live.core.feature;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/core/feature/VqscoreOnline;", "", "()V", "stages", "", "Lcom/bytedance/android/live/core/feature/VqscoreOnlineStage;", "getStages", "()Ljava/util/List;", "timestamp", "", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VqscoreOnline {

    @SerializedName("stages")
    private final List<VqscoreOnlineStage> stages;

    @SerializedName("ts")
    private final Long timestamp;

    public VqscoreOnline() {
    }

    public final List<VqscoreOnlineStage> getStages() {
        return this.stages;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }
}
