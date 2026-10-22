package com.bytedance.ies.argus.api.params;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/argus/api/params/WebLoadVerifySource;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum WebLoadVerifySource extends Enum<WebLoadVerifySource> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WebLoadVerifySource f4980b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WebLoadVerifySource f4981c = null;
    public static final /* synthetic */ WebLoadVerifySource[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4982a;

    static {
        WebLoadVerifySource r5 = new WebLoadVerifySource("Inner", 0, "inner");
        f4980b = r5;
        WebLoadVerifySource r10 = new WebLoadVerifySource("Extern", 1, "extern");
        f4981c = r10;
        d = new WebLoadVerifySource[]{r5, r10, new WebLoadVerifySource("SecLink", 2, "seclink"), new WebLoadVerifySource("scc", 3, "scc")};
    }

    public WebLoadVerifySource(String r5, int r10, String r11) {
        super(r5, r10);
        this.f4982a = r11;
    }

    public static WebLoadVerifySource valueOf(String r5) {
        return (WebLoadVerifySource) Enum.valueOf(WebLoadVerifySource.class, r5);
    }

    public static WebLoadVerifySource[] values() {
        return (WebLoadVerifySource[]) d.clone();
    }
}
