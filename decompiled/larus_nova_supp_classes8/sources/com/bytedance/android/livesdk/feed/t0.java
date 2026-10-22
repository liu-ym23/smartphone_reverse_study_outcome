package com.bytedance.android.livesdk.feed;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t0<T> implements Observer {
    public static final t0 a = null;

    static {
        a = new t0();
    }

    public t0() {
    }

    public final void onChanged(Object r3) {
        if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L6;
        xs2.b.a().post(new uv1.e(0));
        return;
    }
}
