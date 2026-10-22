package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.feed.viewmodel.LiveFeedViewModel;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R4\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/config/o6;", "", "", "", "style", "Ljava/util/Map;", "getStyle", "()Ljava/util/Map;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o6 {

    @SerializedName("style")
    private final Map<String, Map<String, String>> style;

    public o6() {
        this.style = MapsKt.mapOf(new Pair[]{TuplesKt.to("1", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "popup"), TuplesKt.to("gravity", "bottom"), TuplesKt.to("height", "5000"), TuplesKt.to("status_bar_color", "black"), TuplesKt.to("trans_status_bar", "1"), TuplesKt.to("hide_status_bar", "0")})), TuplesKt.to("2", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "fullscreen"), TuplesKt.to("trans_status_bar", "1"), TuplesKt.to("gravity", "bottom"), TuplesKt.to("status_bar_color", "black"), TuplesKt.to("hide_status_bar", "0"), TuplesKt.to("hide_nav_bar", "1"), TuplesKt.to("web_bg_color", "#FFFFFFFF"), TuplesKt.to("height_percent", "100"), TuplesKt.to("enable_preload", "main")})), TuplesKt.to(LiveFeedViewModel.DOUBLE_FEED_WITH_BANNER, MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "popup"), TuplesKt.to("gravity", "bottom"), TuplesKt.to("rate_height", "593"), TuplesKt.to("radius", "12"), TuplesKt.to("disable_input_scroll", "1")}))});
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof o6) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.style, ((o6) r2).style) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, Map<String, String>> r0 = this.style;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "GameMountContainerConfig(style=" + this.style + ")";
    }
}
