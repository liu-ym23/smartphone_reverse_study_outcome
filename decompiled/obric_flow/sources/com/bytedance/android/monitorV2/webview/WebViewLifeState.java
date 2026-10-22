package com.bytedance.android.monitorV2.webview;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/WebViewLifeState;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum WebViewLifeState extends Enum<WebViewLifeState> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WebViewLifeState f3743a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WebViewLifeState f3744b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WebViewLifeState f3745c = null;
    public static final WebViewLifeState d = null;
    public static final /* synthetic */ WebViewLifeState[] e = null;

    static {
        WebViewLifeState r5 = new WebViewLifeState("CREATED", 0);
        f3743a = r5;
        WebViewLifeState r10 = new WebViewLifeState("ATTACHED", 1);
        f3744b = r10;
        WebViewLifeState r11 = new WebViewLifeState("DETACHED", 2);
        f3745c = r11;
        WebViewLifeState r12 = new WebViewLifeState("DESTROYED", 3);
        d = r12;
        e = new WebViewLifeState[]{r5, r10, r11, r12, new WebViewLifeState("REPORTED", 4)};
    }

    public WebViewLifeState(String r5, int r10) {
        super(r5, r10);
    }

    public static WebViewLifeState valueOf(String r5) {
        return (WebViewLifeState) Enum.valueOf(WebViewLifeState.class, r5);
    }

    public static WebViewLifeState[] values() {
        return (WebViewLifeState[]) e.clone();
    }
}
