package com.ss.android.lark.forwardv3;

import com.bytedance.i18n.claymore.PluginServiceLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForwardModuleV3 {
    public static tib.g a;
    public static final Lazy b = null;

    static {
        b = LazyKt.lazy(ForwardModuleV3$forwardImDependency$2.INSTANCE);
    }

    public static tib.g a() {
        if (a != null) goto L6;
        a = (tib.g) PluginServiceLoader.loadFirstOrNull(tib.g.class);
    L6:
        if (a != null) goto L8;
        a = new c();
    L8:
        tib.g r0 = a;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.forwardv3.dependency.IForwardNewDependency");
        return r0;
    }
}
