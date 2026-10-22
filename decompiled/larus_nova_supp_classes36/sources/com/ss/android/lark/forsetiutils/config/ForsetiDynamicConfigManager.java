package com.ss.android.lark.forsetiutils.config;

import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForsetiDynamicConfigManager {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        a = LazyKt.lazy(ForsetiDynamicConfigManager$blacklistedModels$2.INSTANCE);
        b = LazyKt.lazy(ForsetiDynamicConfigManager$forsetiDynamicConfigDisabled$2.INSTANCE);
        c = LazyKt.lazy(ForsetiDynamicConfigManager$dynamicConfig$2.INSTANCE);
    }

    public static List a() {
        ForsetiDynamicConfig r0 = (ForsetiDynamicConfig) c.getValue();
        if (r0 == null) goto L8;
        List<String> r1 = r0.a();
        if (r1 == null) goto L8;
        List r2 = CollectionsKt.filterNotNull(r1);
        if (r2 == null) goto L8;
    L9:
        Log.i("ForsetiDynamicConfigManager", "getBlackList: value=" + r2);
        return r2;
    L8:
        r2 = (List) a.getValue();
        goto L9
    }

    public static int b() {
        ForsetiDynamicConfig r0 = (ForsetiDynamicConfig) c.getValue();
        if (r0 == null) goto L5;
        int r1 = r0.b();
    L6:
        Log.i("ForsetiDynamicConfigManager", "getLeftNavigationThreshold: value=" + r1);
        return r1;
    L5:
        r1 = 840;
        goto L6
    }
}
