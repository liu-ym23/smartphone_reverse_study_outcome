package com.bytedance.android.live.core.feature;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/core/feature/VqscoreEffectItem;", "", "()V", "scale", "", "getScale", "()Ljava/lang/Double;", "Ljava/lang/Double;", "score", "getScore", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VqscoreEffectItem {

    @SerializedName("scale")
    private final Double scale;

    @SerializedName("score")
    private final Double score;

    public VqscoreEffectItem() {
    }

    public final Double getScale() {
        return this.scale;
    }

    public final Double getScore() {
        return this.score;
    }
}
