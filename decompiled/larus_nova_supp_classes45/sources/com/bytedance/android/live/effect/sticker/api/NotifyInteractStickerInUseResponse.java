package com.bytedance.android.live.effect.sticker.api;

import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/api/NotifyInteractStickerInUseResponse;", "", "()V", "effectID", "", "getEffectID", "()Ljava/lang/String;", "setEffectID", "(Ljava/lang/String;)V", "queryGapTime", "", "kotlin.jvm.PlatformType", "getQueryGapTime", "()Ljava/lang/Long;", "setQueryGapTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NotifyInteractStickerInUseResponse {

    @SerializedName("effect_id")
    private String effectID;

    @SerializedName("query_gap_time")
    private Long queryGapTime;

    public NotifyInteractStickerInUseResponse() {
        this.effectID = "";
        this.queryGapTime = LiveEffectSettings.LIVE_EFFECT_POLLING_INTERACT_INFO_INTERVAL.getValue();
    }

    public final String getEffectID() {
        return this.effectID;
    }

    public final Long getQueryGapTime() {
        return this.queryGapTime;
    }

    public final void setEffectID(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.effectID = r2;
    }

    public final void setQueryGapTime(Long r1) {
        this.queryGapTime = r1;
    }
}
