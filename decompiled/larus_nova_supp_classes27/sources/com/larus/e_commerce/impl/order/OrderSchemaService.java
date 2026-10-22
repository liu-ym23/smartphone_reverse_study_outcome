package com.larus.e_commerce.impl.order;

import com.bytedance.keva.Keva;
import com.larus.dora.impl.ota.g2.j0;
import com.larus.network.http.AsyncLiveData;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import xg9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class OrderSchemaService {
    public static final AsyncLiveData<String> a = null;
    public static final AsyncLiveData b = null;
    public static final Keva c = null;

    static {
        AsyncLiveData<String> r0 = new AsyncLiveData();
        a = r0;
        b = r0;
        c = b.a();
    }

    public static boolean b() {
        long r0 = c.getLong("order_list_schema_timestamp", 0);
        if (r0 != 0) goto L6;
        return true;
    L6:
        if ((System.currentTimeMillis() - r0) > j0.G2_OTA_PARTIAL_TTL_MS) goto L10;
        return false;
    L10:
        return true;
    }

    public static void a(CoroutineScope r7) {
        Intrinsics.checkNotNullParameter(r7, "scope");
        BuildersKt.launch$default(r7, Dispatchers.getIO(), null, new OrderSchemaService$getOrderListSchema$1(null), 2, null);
    }
}
