package com.bytedance.android.annie.service.network;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/annie/service/network/RequestMethod;", "", "GET", "POST", "PUT", "DELETE", "DOWNLOAD", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum RequestMethod extends Enum<RequestMethod> {
    public static final RequestMethod DELETE = null;
    public static final RequestMethod DOWNLOAD = null;
    public static final RequestMethod GET = null;
    public static final RequestMethod POST = null;
    public static final RequestMethod PUT = null;
    public static final /* synthetic */ RequestMethod[] a = null;

    public static RequestMethod valueOf(String r1) {
        return (RequestMethod) r27.a.a(RequestMethod.class, r1);
    }

    public static RequestMethod[] values() {
        return (RequestMethod[]) a.clone();
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
        RequestMethod r12 = new RequestMethod("DOWNLOAD", 4);
        DOWNLOAD = r12;
        a = new RequestMethod[]{r0, r1, r10, r11, r12};
    }

    public RequestMethod(String r1, int r10) {
        super(r1, r10);
    }
}
