package com.larus.bmhome.chat.adapter;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p0 implements j {
    public static final p0 a = null;
    public static final Lazy b = null;

    public p0() {
    }

    static {
        a = new p0();
        b = LazyKt.lazy(new o0());
    }

    public static long b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "cvsId");
        return ((Keva) b.getValue()).getLong("last_action_id_".concat(r3), 0);
    }

    public static String c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        return ((Keva) b.getValue()).getString("last_reply_id_".concat(r2), "");
    }

    @Override // com.larus.bmhome.chat.adapter.j
    public final void a(String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        ((Keva) b.getValue()).erase("last_action_id_" + r4);
        return;
    L4:
        if (r4.length() == 0) goto L7;
        r0 = false;
        goto L8
    }
}
