package com.larus.platform.service;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class z1 implements com.larus.platform.api.b3 {
    public static final z1 a = null;
    public static final Lazy b = null;

    public z1() {
    }

    static {
        a = new z1();
        b = LazyKt.lazy(new y1());
    }

    public static com.larus.platform.api.b3 i() {
        return (com.larus.platform.api.b3) b.getValue();
    }

    @Override // com.larus.platform.api.b3
    public final boolean d() {
        com.larus.platform.api.b3 r0 = i();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.d() != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.b3
    public final void c(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "mainActivity");
        com.larus.platform.api.b3 r0 = i();
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    @Override // com.larus.platform.api.b3
    public final void b(Fragment r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter("chat", "previousPage");
        Intrinsics.checkNotNullParameter("lead_toast", "enterFrom");
        com.larus.platform.api.b3 r0 = i();
        if (r0 == null) goto L6;
        r0.b(r3, r4);
        return;
    }

    @Override // com.larus.platform.api.b3
    public final boolean e(Fragment r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        com.larus.platform.api.b3 r0 = i();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.e(r2, r3);
    }

    @Override // com.larus.platform.api.b3
    public final boolean f(Context r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "extras");
        com.larus.platform.api.b3 r0 = i();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.f(r2, r3);
    }

    @Override // com.larus.platform.api.b3
    public final boolean a(Bundle r2, Bundle r3, int r4) {
        com.larus.platform.api.b3 r0 = i();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a(r2, r3, r4);
    }

    @Override // com.larus.platform.api.b3
    public final void g(View r8, int r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "view");
        com.larus.platform.api.b3 r1 = i();
        if (r1 == null) goto L6;
        r1.g(r8, r9, r10, r11, r12);
        return;
    }

    @Override // com.larus.platform.api.b3
    public final void h(Fragment r10, String r11, String r12, String r13, String r14, String r15, boolean r16, String r17) {
        com.larus.platform.api.b3 r0 = i();
        if (r0 == null) goto L6;
        r0.h(r10, r11, r12, r13, r14, r15, r16, r17);
        return;
    }
}
