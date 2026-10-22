package com.bytedance.ai.bridge.method.net.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/core/RequestMethod;", "", "<init>", "(Ljava/lang/String;I)V", "GET", "POST", "PUT", "DELETE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RequestMethod extends Enum<RequestMethod> {
    public static final RequestMethod DELETE = null;
    public static final RequestMethod GET = null;
    public static final RequestMethod POST = null;
    public static final RequestMethod PUT = null;
    public static final /* synthetic */ RequestMethod[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RequestMethod> getEntries() {
        return b;
    }

    static {
        RequestMethod r0 = new RequestMethod("GET", 0);
        GET = r0;
        RequestMethod r1 = new RequestMethod("POST", 1);
        POST = r1;
        RequestMethod r10 = new RequestMethod("PUT", 2);
        PUT = r10;
        RequestMethod r11 = new RequestMethod("DELETE", 3);
        DELETE = r11;
        RequestMethod[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static RequestMethod[] values() {
        return (RequestMethod[]) a.clone();
    }

    public static RequestMethod valueOf(String r1) {
        return (RequestMethod) a.a(RequestMethod.class, r1);
    }

    public RequestMethod(String r1, int r10) {
        super(r1, r10);
    }
}
