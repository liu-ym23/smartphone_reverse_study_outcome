package com.larus.bmhome.view.actionbar.gaokao.network;

import com.larus.network.bean.BizResponse;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PreloadGaokaoProvinceConfHelper {
    public static final PreloadGaokaoProvinceConfHelper a = null;
    public static BizResponse<GaokaoProvinceConfResponse> b;

    static {
        a = new PreloadGaokaoProvinceConfHelper();
    }

    public PreloadGaokaoProvinceConfHelper() {
    }

    public static void a(CoroutineScope r7) {
        Intrinsics.checkNotNullParameter(r7, "scope");
        b = null;
        BuildersKt.launch$default(r7, Dispatchers.getIO(), null, new PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1(null), 2, null);
    }

    public static Object b(Continuation r3) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PreloadGaokaoProvinceConfHelper$requestGaokaoProvinceConf$2(null), r3);
    }
}
