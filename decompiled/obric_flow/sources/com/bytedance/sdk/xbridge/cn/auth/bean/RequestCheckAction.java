package com.bytedance.sdk.xbridge.cn.auth.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/RequestCheckAction;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum RequestCheckAction extends Enum<RequestCheckAction> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RequestCheckAction f7334b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RequestCheckAction f7335c = null;
    public static final RequestCheckAction d = null;
    public static final RequestCheckAction e = null;
    public static final /* synthetic */ RequestCheckAction[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7336a;

    static {
        RequestCheckAction r5 = new RequestCheckAction("DISABLE", 0, 0);
        f7334b = r5;
        RequestCheckAction r10 = new RequestCheckAction("REPORT_ONLY", 1, 1);
        f7335c = r10;
        RequestCheckAction r11 = new RequestCheckAction("CHECK", 2, 2);
        d = r11;
        RequestCheckAction r12 = new RequestCheckAction("TOGGLE_OFF", 3, 99);
        e = r12;
        f = new RequestCheckAction[]{r5, r10, r11, r12};
    }

    public RequestCheckAction(String r5, int r10, int r11) {
        super(r5, r10);
        this.f7336a = r11;
    }

    public static RequestCheckAction valueOf(String r5) {
        return (RequestCheckAction) Enum.valueOf(RequestCheckAction.class, r5);
    }

    public static RequestCheckAction[] values() {
        return (RequestCheckAction[]) f.clone();
    }
}
