package com.bytedance.android.live.browser.container;

import com.bytedance.android.anniex.assemble.a;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class HybridContainerManager {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.NONE, HybridContainerManager$containerMap$2.INSTANCE);
    }

    public static boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "containerId");
        WeakReference r0 = (WeakReference) ((HashMap) a.getValue()).get(r2);
        if (r0 == null) goto L8;
        ILiveHybridContainer r1 = (ILiveHybridContainer) r0.get();
        if (r1 == null) goto L8;
        r1.close();
        return true;
    L8:
        a r3 = a.a;
        if (a.a(r2) == false) goto L11;
        return true;
    L11:
        return false;
    }
}
