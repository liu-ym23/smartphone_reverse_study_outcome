package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.util.SparseArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g0 {
    public static final SparseArray<b0> a = null;

    static {
        a = new SparseArray();
    }

    public static boolean a(s r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        b0 r0 = a.get(r2.a);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a(r2);
    }
}
