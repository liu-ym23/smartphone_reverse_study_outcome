package com.bytedance.ai.bridge.method.net.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/core/RequestMethod;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum RequestMethod extends Enum<RequestMethod> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RequestMethod f1873a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RequestMethod f1874b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RequestMethod f1875c = null;
    public static final RequestMethod d = null;
    public static final /* synthetic */ RequestMethod[] e = null;

    static {
        RequestMethod r5 = new RequestMethod("GET", 0);
        f1873a = r5;
        RequestMethod r10 = new RequestMethod("POST", 1);
        f1874b = r10;
        RequestMethod r11 = new RequestMethod("PUT", 2);
        f1875c = r11;
        RequestMethod r12 = new RequestMethod("DELETE", 3);
        d = r12;
        RequestMethod[] r13 = {r5, r10, r11, r12};
        e = r13;
        EnumEntriesKt.enumEntries(r13);
    }

    public RequestMethod(String r5, int r10) {
        super(r5, r10);
    }

    public static RequestMethod valueOf(String r5) {
        return (RequestMethod) Enum.valueOf(RequestMethod.class, r5);
    }

    public static RequestMethod[] values() {
        return (RequestMethod[]) e.clone();
    }
}
