package j64;

import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import java.lang.reflect.Proxy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final <T extends IBdpService> T a(Class<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "service");
        T r2 = (T) BdpManager.getInst().getService(r1);
        if (r2 != null) goto L5;
        return r2;
    L5:
        if (Proxy.isProxyClass(r2.getClass()) == false) goto L9;
        return null;
    L9:
        return r2;
    }
}
