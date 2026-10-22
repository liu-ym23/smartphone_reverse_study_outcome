package com.larus.platform.service;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class r1 implements com.larus.platform.api.u0 {
    public static final r1 a = null;
    public static final Lazy b = null;

    public r1() {
    }

    static {
        a = new r1();
        b = LazyKt.lazy(new q1());
    }

    public static com.larus.platform.api.u0 e() {
        return (com.larus.platform.api.u0) b.getValue();
    }

    @Override // com.larus.platform.api.u0
    public final kotlinx.coroutines.flow.i1<Boolean> c() {
        com.larus.platform.api.u0 r0 = e();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    @Override // com.larus.platform.api.u0
    public final void onCreate() {
        com.larus.platform.api.u0 r0 = e();
        if (r0 == null) goto L6;
        r0.onCreate();
        return;
    }

    @Override // com.larus.platform.api.u0
    public final void onDestroy() {
        com.larus.platform.api.u0 r0 = e();
        if (r0 == null) goto L6;
        r0.onDestroy();
        return;
    }

    @Override // com.larus.platform.api.u0
    public final void attachBaseContext(Context r2) {
        com.larus.platform.api.u0 r0 = e();
        if (r0 == null) goto L6;
        r0.attachBaseContext(r2);
        return;
    }

    @Override // com.larus.platform.api.u0
    public final void a(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        com.larus.platform.api.u0 r0 = e();
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }

    @Override // com.larus.platform.api.u0
    public final void b(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "outState");
        com.larus.platform.api.u0 r0 = e();
        if (r0 == null) goto L6;
        r0.b(r2, r3);
        return;
    }

    @Override // com.larus.platform.api.u0
    public final void d(Activity r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        com.larus.platform.api.u0 r0 = e();
        if (r0 == null) goto L6;
        r0.d(r2, r3);
        return;
    }
}
