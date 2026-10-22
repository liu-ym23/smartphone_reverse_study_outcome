package com.bytedance.ies.argus.api.params;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/argus/api/params/WebLoadRiskTag;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum WebLoadRiskTag extends Enum<WebLoadRiskTag> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WebLoadRiskTag f4972b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WebLoadRiskTag f4973c = null;
    public static final WebLoadRiskTag d = null;
    public static final WebLoadRiskTag e = null;
    public static final /* synthetic */ WebLoadRiskTag[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4974a;

    static {
        WebLoadRiskTag r5 = new WebLoadRiskTag("Default", 0, "default");
        f4972b = r5;
        WebLoadRiskTag r10 = new WebLoadRiskTag("PassInnerDomain", 1, "white_inner_list");
        f4973c = r10;
        WebLoadRiskTag r11 = new WebLoadRiskTag("PassPluginVerify", 2, "risk_white_plugin");
        WebLoadRiskTag r12 = new WebLoadRiskTag("ShowRiskUnknown", 3, "risk_unknown");
        d = r12;
        WebLoadRiskTag r13 = new WebLoadRiskTag("ShowRiskGrey", 4, "risk_grey");
        WebLoadRiskTag r14 = new WebLoadRiskTag("ShowRiskBlack", 5, "risk_black");
        e = r14;
        f = new WebLoadRiskTag[]{r5, r10, r11, r12, r13, r14};
    }

    public WebLoadRiskTag(String r5, int r10, String r11) {
        super(r5, r10);
        this.f4974a = r11;
    }

    public static WebLoadRiskTag valueOf(String r5) {
        return (WebLoadRiskTag) Enum.valueOf(WebLoadRiskTag.class, r5);
    }

    public static WebLoadRiskTag[] values() {
        return (WebLoadRiskTag[]) f.clone();
    }
}
