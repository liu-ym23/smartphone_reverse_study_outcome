package com.bytedance.android.live.multilink.voicechat.impl.widget;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u<T> implements Observer {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        com.bytedance.android.live.liveinteract.plantform.base.g r0 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r3);
        r0.Lp(!r3.booleanValue());
        return;
    }
}
