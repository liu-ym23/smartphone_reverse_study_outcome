package com.larus.voicecall.api.bean;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/larus/voicecall/api/bean/TtsParams;", NameKeys.UnloadStrategy_No_Strategy, "modelName", NameKeys.UnloadStrategy_No_Strategy, "styleId", "audioMetrics", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getModelName", "()Ljava/lang/String;", "getStyleId", "getAudioMetrics", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsParams {

    @SerializedName("audio_metrics")
    private final String audioMetrics;

    @SerializedName("model_name")
    private final String modelName;

    @SerializedName("style_id")
    private final String styleId;

    public TtsParams() {
        this(null, null, null, 7, null);
    }

    public final String getAudioMetrics() {
        return this.audioMetrics;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final String getStyleId() {
        return this.styleId;
    }

    public TtsParams(String r1, String r2, String r3) {
        this.modelName = r1;
        this.styleId = r2;
        this.audioMetrics = r3;
    }

    public /* synthetic */ TtsParams(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
