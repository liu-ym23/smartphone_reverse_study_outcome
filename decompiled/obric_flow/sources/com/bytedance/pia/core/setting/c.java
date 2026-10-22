package com.bytedance.pia.core.setting;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR8\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000e\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010%\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010\nR$\u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0006\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010\nR$\u00101\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0006\u001a\u0004\b/\u0010\b\"\u0004\b0\u0010\n¨\u00062"}, d2 = {"Lcom/bytedance/pia/core/setting/c;", "", "<init>", "()V", "", "a", "Ljava/lang/Boolean;", "getOpenOnlineMonitor", "()Ljava/lang/Boolean;", "setOpenOnlineMonitor", "(Ljava/lang/Boolean;)V", "openOnlineMonitor", "", "", "", "b", "Ljava/util/Map;", "getDisableFeatures", "()Ljava/util/Map;", "setDisableFeatures", "(Ljava/util/Map;)V", "disableFeatures", "", "c", "Ljava/lang/Integer;", "getOpenManifestCacheInt", "()Ljava/lang/Integer;", "setOpenManifestCacheInt", "(Ljava/lang/Integer;)V", "openManifestCacheInt", "", "d", "Ljava/util/List;", "getOpenManifestCachePages", "()Ljava/util/List;", "setOpenManifestCachePages", "(Ljava/util/List;)V", "openManifestCachePages", "e", "getOpenCancelUselessWarmup", "setOpenCancelUselessWarmup", "openCancelUselessWarmup", "f", "getOpenDefaultResourcePreload", "setOpenDefaultResourcePreload", "openDefaultResourcePreload", "g", "getOpenParseLink", "setOpenParseLink", "openParseLink", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("open_online_monitor")
    private Boolean f7085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("disable_features")
    private Map<String, String[]> f7086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("open_manifest_cache_int")
    private Integer f7087c;

    @SerializedName("open_manifest_cache_pages")
    private List<String> d;

    @SerializedName("open_cancel_useless_warmup")
    private Boolean e;

    @SerializedName("open_default_resource_preload")
    private Boolean f;

    @SerializedName("open_parse_link")
    private Boolean g;

    public c() {
        Boolean r5 = Boolean.TRUE;
        this.f7085a = r5;
        this.f7087c = 5000;
        this.d = CollectionsKt.listOf(new String[]{"lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/wallet/webcast/webview/caijing_h5_coupon/template/pages/list/index.html", "lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/wallet/h5/webcast/caijing_h5_point/template/home/index.html"});
        this.e = r5;
        this.f = r5;
        this.g = r5;
    }
}
