package com.bytedance.ai.settings.provider;

import androidx.constraintlayout.motion.widget.a;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/settings/provider/LynxViewReusedConfig;", "", "", "Lcom/bytedance/ai/settings/provider/WidgetReusedSettings;", "a", "Ljava/util/List;", "()Ljava/util/List;", "widgetWhitelist", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LynxViewReusedConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("widgetWhitelist")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<WidgetReusedSettings> f2779a;

    public LynxViewReusedConfig() {
        this(0);
    }

    public final List a() {
        return this.f2779a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LynxViewReusedConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f2779a, ((LynxViewReusedConfig) r5).f2779a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<WidgetReusedSettings> r5 = this.f2779a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.hashCode();
    }

    public final String toString() {
        return a.v(new StringBuilder("LynxViewReusedConfig(widgetWhitelist="), this.f2779a, ')');
    }

    public LynxViewReusedConfig(int r14) {
        this.f2779a = CollectionsKt.listOf(new WidgetReusedSettings[]{new WidgetReusedSettings("com.flow.locallife", "route_card", 2), new WidgetReusedSettings("com.ruyi.card", "weather", 2), new WidgetReusedSettings("com.ruyi.card", "exchange_rate", 2), new WidgetReusedSettings("com.ruyi.card", "stock", 2), new WidgetReusedSettings("com.ruyi.card", "hanzi", 2), new WidgetReusedSettings("com.ruyi.card", "calendar", 2), new WidgetReusedSettings("com.ruyi.card", "dict", 2), new WidgetReusedSettings("com.ruyi.card", "fund", 2), new WidgetReusedSettings("com.ruyi.card", "gold_trend", 2), new WidgetReusedSettings("com.ruyi.card", "futures", 2), new WidgetReusedSettings("com.ruyi.card", "forex_trend", 2)});
    }
}
