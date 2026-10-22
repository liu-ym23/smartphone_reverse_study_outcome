package com.ss.android.lark.passport.flow.mfa;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o {
    public static final ConcurrentHashMap<String, FlowMfaFlowSession> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static FlowMfaFlowSession a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "flowId");
        return a.get(r1);
    }
}
