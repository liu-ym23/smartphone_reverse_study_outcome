package com.larus.platform.service;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.layout.item.u4;
import com.larus.platform.api.e4;
import com.larus.platform.api.f4;
import com.larus.platform.api.u2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c1 implements u2 {
    public static final c1 a = null;
    public static final Lazy b = null;

    public c1() {
    }

    static {
        a = new c1();
        b = LazyKt.lazy(new b1());
    }

    public static u2 h() {
        return (u2) b.getValue();
    }

    @Override // com.larus.platform.api.u2
    public final void f() {
        FLogger.a.i("BackgroundLazyInit", "event=component_init_request, component=IvyKit, trigger=direct_use");
        u2 r0 = h();
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    @Override // com.larus.platform.api.u2
    public final List<Object> a() {
        u2 r0 = h();
        if (r0 == null) goto L7;
        List<Object> r1 = r0.a();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.platform.api.u2
    public final boolean d() {
        u2 r0 = h();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.d();
    }

    @Override // com.larus.platform.api.u2
    public final String b(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "channel");
        u2 r0 = h();
        if (r0 == null) goto L6;
        String r5 = r0.b(r2, r3, r4);
        if (r5 == null) goto L6;
        return r5;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.u2
    public final View c(Context r2, String r3, com.larus.bmhome.chat.layout.widget.handler.h r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "headerTransform");
        u2 r0 = h();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c(r2, r3, r4);
    }

    @Override // com.larus.platform.api.u2
    public final void e(String r2, String r3, u4 r4) {
        Intrinsics.checkNotNullParameter(r2, "bundleOrUrl");
        Intrinsics.checkNotNullParameter(r3, "channel");
        Intrinsics.checkNotNullParameter(r4, "onFinish");
        u2 r0 = h();
        if (r0 == null) goto L6;
        r0.e(r2, r3, r4);
        return;
    }

    @Override // com.larus.platform.api.u2
    public final e4 g(Context r2, String r3, String r4, f4 r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "templateUrl");
        u2 r0 = h();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g(r2, r3, r4, r5);
    }
}
