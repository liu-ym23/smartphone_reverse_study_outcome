package com.bytedance.android.btm.bridge.method;

import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(XCoreBridgeMethod r10, XBridgeMethod.Callback r11, String r12) {
        XCoreBridgeMethod.onFailure$default(r10, r11, 0, r12, null, 8, null);
    }

    public static void b(XCoreBridgeMethod r10, XBridgeMethod.Callback r11, Map r12) {
        Lazy r0 = HybridContainerContextManager.a;
        g66.c r1 = r10.getContextProviderFactory();
        String r13 = "unkown";
        if (r1 == null) goto L12;
        int r14 = ((List) HybridContainerContextManager.a.getValue()).size();
        int r15 = 0;
        String r16 = "unkown";
    L5:
        if (r15 >= r14) goto L10;
        r16 = ((com.bytedance.android.btm.bridge.b) ListProtector.get((List) HybridContainerContextManager.a.getValue(), r15)).getHybridContainerType(r1);
        if ((!Intrinsics.areEqual(r16, "unkown")) == true) goto L10;
        r15 = r15 + 1;
    L10:
        r13 = r16;
    L12:
        if (Intrinsics.areEqual(r13, "live") == false) goto L14;
    L17:
        LinkedHashMap r17 = new LinkedHashMap();
        r17.put("data", r12);
        Map r18 = r17;
    L18:
        XCoreBridgeMethod.onSuccess$default(r10, r11, r18, null, 4, null);
        return;
    L14:
        if (Intrinsics.areEqual(r13, "anniex_live") == true) goto L17;
        r18 = r12;
        goto L18
    }
}
