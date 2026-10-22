package e4a;

import android.content.Context;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final Context getContext(IBDXBridgeContext r1) {
        return (Context) a(r1, Context.class);
    }

    @JvmStatic
    public static final a36.c getIdentifier(IBDXBridgeContext r1) {
        return (a36.c) a(r1, a36.c.class);
    }

    @JvmStatic
    public static final <T> T a(IBDXBridgeContext r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "service");
        if (r2 == null) goto L5;
        m16.b r1 = (m16.b) r2.getService(m16.b.class);
    L6:
        if (r1 == null) goto L11;
        T r4 = (T) r1.c(r3);
        if (r4 == null) goto L11;
        return r4;
    L11:
        if (r2 != null) goto L13;
        return null;
    L13:
        return (T) r2.getService(r3);
    L5:
        r1 = null;
        goto L6
    }
}
