package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR0\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/config/g31;", "", "", "", "", "config", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "setConfig", "(Ljava/util/Map;)V", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g31 {

    @SerializedName("config")
    private Map<String, Float> config;

    public g31() {
        Float r1 = Float.valueOf(0.5f);
        this.config = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("GRL-AL10", r1), TuplesKt.to("SM-F9680", r1)});
    }

    public final Map<String, Float> a() {
        return this.config;
    }
}
