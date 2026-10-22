package com.ss.ugc.effectplatform.bridge.network;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/ugc/effectplatform/bridge/network/HTTPMethod;", "", "(Ljava/lang/String;I)V", "GET", "POST", "effect_bridge_release"}, k = 1, mv = {1, 1, 16})
public final enum HTTPMethod extends Enum<HTTPMethod> {
    private static final /* synthetic */ HTTPMethod[] $VALUES = null;
    public static final HTTPMethod GET = null;
    public static final HTTPMethod POST = null;

    static {
        HTTPMethod r1 = new HTTPMethod("GET", 0);
        GET = r1;
        HTTPMethod r2 = new HTTPMethod("POST", 1);
        POST = r2;
        $VALUES = new HTTPMethod[]{r1, r2};
    }

    public static HTTPMethod valueOf(String r1) {
        return (HTTPMethod) a.a(HTTPMethod.class, r1);
    }

    public static HTTPMethod[] values() {
        return (HTTPMethod[]) $VALUES.clone();
    }

    private HTTPMethod(String r1, int r2) {
        super(r1, r2);
    }
}
