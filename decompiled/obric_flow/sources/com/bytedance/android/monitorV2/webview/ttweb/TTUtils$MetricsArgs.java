package com.bytedance.android.monitorV2.webview.ttweb;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/monitorV2/webview/ttweb/TTUtils$MetricsArgs", "", "Lcom/bytedance/android/monitorV2/webview/ttweb/TTUtils$MetricsArgs;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum TTUtils$MetricsArgs extends Enum<TTUtils$MetricsArgs> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TTUtils$MetricsArgs f3823b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TTUtils$MetricsArgs f3824c = null;
    public static final /* synthetic */ TTUtils$MetricsArgs[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3825a;

    static {
        TTUtils$MetricsArgs r5 = new TTUtils$MetricsArgs("Metrics", 0, "{\"loading\":{}}");
        f3823b = r5;
        TTUtils$MetricsArgs r10 = new TTUtils$MetricsArgs("Errors", 1, "{\"webview_error\":{}}");
        f3824c = r10;
        d = new TTUtils$MetricsArgs[]{r5, r10};
    }

    public TTUtils$MetricsArgs(String r5, int r10, String r11) {
        super(r5, r10);
        this.f3825a = r11;
    }

    public static TTUtils$MetricsArgs valueOf(String r5) {
        return (TTUtils$MetricsArgs) Enum.valueOf(TTUtils$MetricsArgs.class, r5);
    }

    public static TTUtils$MetricsArgs[] values() {
        return (TTUtils$MetricsArgs[]) d.clone();
    }
}
