package com.bytedance.ai.settings.provider;

import androidx.constraintlayout.motion.widget.a;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import k5.d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\b\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/settings/provider/WidgetSettingsConfig;", "", "", "a", "I", "getPreloadCount", "()I", "preloadCount", "b", "getChatCacheCount", "chatCacheCount", "c", "getGlobalCachePoolSize", "globalCachePoolSize", "", "Lcom/bytedance/ai/settings/provider/WidgetCacheLimit;", "d", "Ljava/util/List;", "()Ljava/util/List;", "chatCacheLimit", "Lcom/bytedance/ai/settings/provider/LynxThreadStrategy;", "e", "lynxThreadStrategy", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetSettingsConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("preload_count")
    private final int f2791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("chat_cache_count")
    private final int f2792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("global_cache_pool_size")
    private final int f2793c;

    @SerializedName("chat_widget_cache_limit")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<WidgetCacheLimit> d;

    @SerializedName("lynx_thread_strategy")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<LynxThreadStrategy> e;

    public WidgetSettingsConfig() {
        this(0);
    }

    public final List a() {
        return this.d;
    }

    public final List b() {
        return this.e;
    }

    public final int c() {
        return RangesKt.coerceIn(this.f2793c, 0, 20);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetSettingsConfig) == true) goto L8;
        return false;
    L8:
        WidgetSettingsConfig r10 = (WidgetSettingsConfig) r5;
        if (this.f2791a == r10.f2791a) goto L12;
        return false;
    L12:
        if (this.f2792b == r10.f2792b) goto L15;
        return false;
    L15:
        if (this.f2793c == r10.f2793c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = d.a(this.f2793c, d.a(this.f2792b, Integer.hashCode(this.f2791a) * 31));
        List<WidgetCacheLimit> r10 = this.d;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        List<LynxThreadStrategy> r14 = this.e;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("WidgetSettingsConfig(preloadCount=");
        r5.append(this.f2791a);
        r5.append(", chatCacheCount=");
        r5.append(this.f2792b);
        r5.append(", globalCachePoolSize=");
        r5.append(this.f2793c);
        r5.append(", chatCacheLimit=");
        r5.append(this.d);
        r5.append(", lynxThreadStrategy=");
        return a.v(r5, this.e, ')');
    }

    public WidgetSettingsConfig(int r19) {
        List<WidgetCacheLimit> r5 = CollectionsKt.listOf(new WidgetCacheLimit[]{new WidgetCacheLimit("route_card", "com.flow.locallife", 8), new WidgetCacheLimit("route_card", "com.flow.locallife_m3", 8), new WidgetCacheLimit("route_card", "com.flow.locallife_sd", 8), new WidgetCacheLimit("route_card", "com.flow.locallife_stream", 8), new WidgetCacheLimit("route_card", "com.flow.locallife_stream_v2", 8), new WidgetCacheLimit("route_card", "com.flow.locallife_douyin", 8), new WidgetCacheLimit("route_plan", "com.obric.map", 8)});
        List<LynxThreadStrategy> r10 = CollectionsKt.listOf(new LynxThreadStrategy(1, 1, CollectionsKt.listOf(new String[]{"com.flow.events@widget__main-place-entrance", "com.flow.events@widget__schedule-list", "com.flow.events@widget__medal-list", "com.flow.events@widget__key-score-against", "com.flow.events@widget__key-athletes-entrance", "com.flow.news@widget__hot-news", "com.flow.news@widget__news_preference_card", "com.flow.locallife@ll_poi_card_widget", "com.flow.locallife@ll_product_card_0624", "com.flow.music.auth@widget__playlist", "com.flow.music.auth@widget__single_music", "com.flow.music.auth@widget__artist_musics", "com.flow.music.auth@widget__album", "com.flow.music.auth@widget__collect_mix", "com.flow.music.auth@widget__collected_music"})));
        this.f2791a = 0;
        this.f2792b = 0;
        this.f2793c = 5;
        this.d = r5;
        this.e = r10;
    }
}
