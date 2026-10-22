package com.google.common.collect;

import java.util.Map;
import java.util.function.Function;

/* JADX INFO: renamed from: com.google.common.collect.-$$Lambda$Xht_Ljvt5R8DKx7cj_m0kty-8zw, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$Xht_Ljvt5R8DKx7cj_m0kty8zw implements Function {
    public static final /* synthetic */ $$Lambda$Xht_Ljvt5R8DKx7cj_m0kty8zw INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$Xht_Ljvt5R8DKx7cj_m0kty8zw();
    }

    private /* synthetic */ $$Lambda$Xht_Ljvt5R8DKx7cj_m0kty8zw() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return ((Map.Entry) r1).getKey();
    }
}
