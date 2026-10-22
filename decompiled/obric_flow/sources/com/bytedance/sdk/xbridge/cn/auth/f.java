package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {
    public static final IDLXBridgeMethod.Access a(String r5) {
        switch(r5.hashCode()) {
            case -977423767: goto L26;
            case -906273929: goto L21;
            case -608539730: goto L16;
            case -314497661: goto L11;
            case -309012785: goto L6;
            default: goto L28;
        };
    L6:
        if (r5.equals("protect") == false) goto L28;
        return IDLXBridgeMethod.Access.f7465c;
    L11:
        if (r5.equals("private") == false) goto L28;
        return IDLXBridgeMethod.Access.d;
    L16:
        if (r5.equals("protected") == false) goto L28;
        return IDLXBridgeMethod.Access.f7465c;
    L21:
        if (r5.equals("secure") == false) goto L28;
        return IDLXBridgeMethod.Access.e;
    L26:
        if (r5.equals("public") == false) goto L28;
        return IDLXBridgeMethod.Access.f7464b;
    L28:
        return IDLXBridgeMethod.Access.f7464b;
    }
}
