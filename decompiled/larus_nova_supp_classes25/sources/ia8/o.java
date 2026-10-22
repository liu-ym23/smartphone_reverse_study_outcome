package ia8;

import com.google.gson.Gson;
import com.larus.avlink.n1;
import com.larus.avlink.plugins.c0;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o {
    public static boolean a;

    static {
        a = true;
    }

    public static boolean a() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        if (r1.M() != true) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L20;
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r3 != null) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L21;
        return true;
    L21:
        return false;
    L14:
        if (r3.T() != true) goto L16;
        r4 = true;
        goto L17
    L20:
        return false;
    L9:
        r2 = false;
        goto L10
    }

    public static List b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "jsonStr");
        c0.a[] r0 = (c0.a[]) new Gson().fromJson(r3, c0.a[].class);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L5
        return ArraysKt.toList(r0);
    L5:
        e = move-exception;
        n1.c("DoraUtils", "parseCommandListDirect: Failed to parse JSON: " + r3, e);
        return null;
    }
}
