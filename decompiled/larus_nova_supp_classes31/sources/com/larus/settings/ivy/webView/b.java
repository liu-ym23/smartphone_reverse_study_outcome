package com.larus.settings.ivy.webView;

import com.google.gson.annotations.SerializedName;
import com.larus.settings.ivy.e;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/larus/settings/ivy/webView/FlowWebViewSettingConfig;", "", "<init>", "()V", "enableWebViewScc", "", "getEnableWebViewScc", "()Z", "defaultAllowHost", "", "", "getDefaultAllowHost", "()Ljava/util/List;", "enableWebViewSeclink", "getEnableWebViewSeclink", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class b {

    @SerializedName("webview_scc_host_white_list")
    private final List<String> defaultAllowHost;

    @SerializedName("enable_webview_scc")
    private final boolean enableWebViewScc;

    @SerializedName("enable_webview_seclink")
    private final boolean enableWebViewSeclink;

    public b() {
        ArrayList r0 = new ArrayList();
        ArrayList<String> r1 = e.a;
        r0.addAll(e.a);
        this.defaultAllowHost = r0;
    }

    public final List<String> a() {
        return this.defaultAllowHost;
    }

    public final boolean b() {
        return this.enableWebViewScc;
    }

    public final boolean c() {
        return this.enableWebViewSeclink;
    }
}
