package com.bytedance.ies.argus.api.params;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/argus/api/params/WebLoadPageType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum WebLoadPageType extends Enum<WebLoadPageType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WebLoadPageType f4970a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ WebLoadPageType[] f4971b = null;

    static {
        WebLoadPageType r5 = new WebLoadPageType("WHITE_INNER", 0);
        f4970a = r5;
        f4971b = new WebLoadPageType[]{r5, new WebLoadPageType("GREY_SEC_LINK", 1)};
    }

    public WebLoadPageType(String r5, int r10) {
        super(r5, r10);
    }

    public static WebLoadPageType valueOf(String r5) {
        return (WebLoadPageType) Enum.valueOf(WebLoadPageType.class, r5);
    }

    public static WebLoadPageType[] values() {
        return (WebLoadPageType[]) f4971b.clone();
    }
}
