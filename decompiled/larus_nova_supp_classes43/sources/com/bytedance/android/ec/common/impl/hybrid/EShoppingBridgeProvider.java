package com.bytedance.android.ec.common.impl.hybrid;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import java.util.List;
import kotlin.jvm.functions.Function0;
import ti.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class EShoppingBridgeProvider implements i {
    public static final EShoppingBridgeProvider a = null;

    public EShoppingBridgeProvider() {
    }

    static {
        a = new EShoppingBridgeProvider();
    }

    public final Function0<List<ECBaseBridgeMethod>> b() {
        return EShoppingBridgeProvider$getHostBridgeProvider$1.INSTANCE;
    }

    public final Function0<List<ECBaseBridgeMethod>> c() {
        return EShoppingBridgeProvider$getLiveBridgeProvider$1.INSTANCE;
    }
}
