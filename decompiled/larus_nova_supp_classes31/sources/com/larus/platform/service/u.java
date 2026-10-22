package com.larus.platform.service;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u implements com.larus.platform.api.d0 {
    public static final u a = null;
    public static final Lazy b = null;

    public u() {
    }

    static {
        a = new u();
        b = LazyKt.lazy(new t());
    }

    @Override // com.larus.platform.api.d0
    public final void d() {
        com.larus.platform.api.d0 r0 = (com.larus.platform.api.d0) b.getValue();
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.larus.platform.api.d0
    public final void c(Fragment r3, View r4, String r5, by7.e r6) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r5, "currentPage");
        com.larus.platform.api.d0 r0 = (com.larus.platform.api.d0) b.getValue();
        if (r0 != null) goto L12;
        if (r4 == null) goto L14;
        r4.setVisibility(8);
        return;
    L14:
        return;
    L12:
        r0.c(r3, r4, r5, r6);     // Catch: AbstractMethodError -> L9
        return;
    L9:
        if (r4 == null) goto L15;
        r4.setVisibility(8);
        return;
    }

    @Override // com.larus.platform.api.d0
    public final void b(Context r10, String r11, by7.e r12, String r13, String r14, String r15, String r16) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        com.larus.platform.api.d0 r1 = (com.larus.platform.api.d0) b.getValue();
        if (r1 == null) goto L6;
        r1.b(r10, r11, r12, r13, r14, r15, r16);
        return;
    }
}
