package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusWebViewAspect;", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusWebViewAspect extends Enum<ArgusWebViewAspect> implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArgusWebViewAspect f5101b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusWebViewAspect f5102c = null;
    public static final /* synthetic */ ArgusWebViewAspect[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5103a;

    static {
        ArgusWebViewAspect r5 = new ArgusWebViewAspect("LOAD_URL", 0, "web_load_url");
        ArgusWebViewAspect r10 = new ArgusWebViewAspect("WEB_REDIRECT", 1, "web_redirect");
        f5101b = r10;
        ArgusWebViewAspect r11 = new ArgusWebViewAspect("SHOULD_INTERCEPT_REQUEST", 2, "should_intercept_request");
        ArgusWebViewAspect r12 = new ArgusWebViewAspect("ON_WEBVIEW_CREATED", 3, "on_webview_created");
        f5102c = r12;
        d = new ArgusWebViewAspect[]{r5, r10, r11, r12};
    }

    public ArgusWebViewAspect(String r5, int r10, String r11) {
        super(r5, r10);
        this.f5103a = r11;
    }

    public static ArgusWebViewAspect valueOf(String r5) {
        return (ArgusWebViewAspect) Enum.valueOf(ArgusWebViewAspect.class, r5);
    }

    public static ArgusWebViewAspect[] values() {
        return (ArgusWebViewAspect[]) d.clone();
    }

    @Override // com.bytedance.ies.argus.bean.c
    public final String a() {
        return this.f5103a;
    }
}
