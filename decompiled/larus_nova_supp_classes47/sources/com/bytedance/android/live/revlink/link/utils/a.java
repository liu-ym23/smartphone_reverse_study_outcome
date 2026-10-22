package com.bytedance.android.live.revlink.link.utils;

import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.scope.l;
import com.bytedance.android.scope.m;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import o51.c;
import v51.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final c a(b r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$coreScope");
        m.e.getClass();
        v51.a r2 = (v51.a) m.b(r1).a(Reflection.getOrCreateKotlinClass(v51.a.class));
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.a;
    }

    public static final AnchorUILayoutManager b(b r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$uiLayoutManager");
        c r2 = a(r1);
        if (r2 == null) goto L5;
        Intrinsics.checkNotNullParameter(r2, "$this$uiLayoutManager");
        m.e.getClass();
        return (AnchorUILayoutManager) m.b(r2).a(Reflection.getOrCreateKotlinClass(AnchorUILayoutManager.class));
    L5:
        return null;
    }

    public static final void c(o11.a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$leaveSafe");
        if (l.b(r1) == false) goto L6;
        l.c(r1);
        return;
    }
}
