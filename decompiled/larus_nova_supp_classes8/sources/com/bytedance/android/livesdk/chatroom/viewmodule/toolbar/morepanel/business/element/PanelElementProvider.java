package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class PanelElementProvider implements kp1.c {
    public static final Lazy a = null;
    public static final PanelElementProvider b = null;

    public PanelElementProvider() {
    }

    static {
        b = new PanelElementProvider();
        a = LazyKt.lazy(PanelElementProvider$providers$2.INSTANCE);
    }

    @Override // kp1.c
    public final kp1.b<? extends lp1.b<Object>> a(kp1.a r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        kp1.c r0 = (kp1.c) ((Map) a.getValue()).get(r3.getType());
        if (r0 == null) goto L7;
        kp1.b<? extends lp1.b<Object>> r1 = r0.a(r3);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return w.b.a(r3);
    }
}
