package com.bytedance.ai.settings.provider;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.obric.feature.miniapp.widget.MiniAppConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0005\u0010\u0012R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\n\u0010\u0012R\u001a\u0010\u001b\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u00048\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0015\u0010\bR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ai/settings/provider/ResourcesManagerConfig;", "", "<init>", "()V", "", "a", "I", "f", "()I", "packageDownloadType", "b", "d", "geckoHostVersion", "", "", "c", "Ljava/util/List;", "g", "()Ljava/util/List;", "requestWhiteList", "customDownloadPackageList", "e", "firstAppPackageList", "", "J", "h", "()J", "updateInterval", "offlineFileVersion", "forceUpdateChannel", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ResourcesManagerConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("package_download_type")
    private final int f2784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("gecko_host_version")
    private final int f2785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("request_white_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> f2786c;

    @SerializedName("custom_download_package_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> d;

    @SerializedName("first_application_package_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> e;

    @SerializedName("update_interval")
    private final long f;

    @SerializedName("offline_file_version")
    private final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("force_update_channel")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> f2787h;

    public ResourcesManagerConfig() {
        this.f2786c = CollectionsKt.listOf(new String[]{"https://api.coze.cn/open_api/v2/chat", "https://api.coze.cn/v3/chat", "https://api.coze.cn/v1/workflow/run", "https://api.coze.cn/v1/workflow/stream_run", "https://www.coze.cn/api/card_builder/agent/api_trigger", "https://www.coze.cn/api/card_builder/agent/coze_api_trigger", "https://bot-open-api.bytedance.net/v1/workflow/run", "https://bots.bytedance.net/api/card_builder/agent/api_trigger"});
        this.d = CollectionsKt.listOf(new String[]{MiniAppConstants.APPLET_ID_CALENDAR, "com.flow.remind.o", "com.obric.map", "com.obric.news", "com.obric.exchange", "com.doubao.react-lynx-template"});
        this.e = CollectionsKt.listOf(new String[]{MiniAppConstants.APPLET_ID_CALENDAR, "com.flow.remind.o", "com.obric.map", "com.obric.news", "com.obric.exchange"});
        this.f = 300000;
        this.g = 1;
        this.f2787h = CollectionsKt.listOf(new String[]{"com_flow_music_auth", "com_flow_podcast", "com_flow_music", "com_flow_news", "com_flow_news_knowledge_graph", "com_flow_locallife", "com_flow_locallife_home", "com_flow_remind", "com_flow_note", "com_flow_shorthand", "com_flow_lotus"});
    }

    public final List a() {
        return this.d;
    }

    public final List b() {
        return this.e;
    }

    public final List c() {
        return this.f2787h;
    }

    public final int d() {
        return this.f2785b;
    }

    public final int e() {
        return this.g;
    }

    public final int f() {
        return this.f2784a;
    }

    public final List g() {
        return this.f2786c;
    }

    public final long h() {
        return this.f;
    }
}
