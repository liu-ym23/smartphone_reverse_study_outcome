package com.bytedance.android.live.effect.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/effect/api/GetInteractStickerInfoResponse;", "", "()V", "effectID", "", "getEffectID", "()Ljava/lang/String;", "setEffectID", "(Ljava/lang/String;)V", "resultJson", "getResultJson", "setResultJson", "liveeffect-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetInteractStickerInfoResponse {

    @SerializedName("effect_id")
    private String effectID;

    @SerializedName("result")
    private String resultJson;

    public GetInteractStickerInfoResponse() {
        this.resultJson = "";
        this.effectID = "";
    }

    public final String getEffectID() {
        return this.effectID;
    }

    public final String getResultJson() {
        return this.resultJson;
    }

    public final void setEffectID(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.effectID = r2;
    }

    public final void setResultJson(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.resultJson = r2;
    }
}
