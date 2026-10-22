package com.larus.platform.service;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.platform.model.UserSubInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c2 implements com.larus.platform.api.c1 {
    public static final c2 a = null;
    public static final Lazy b = null;

    public c2() {
    }

    static {
        a = new c2();
        b = LazyKt.lazy(new b2());
    }

    @Override // com.larus.platform.api.c1
    public final boolean a() {
        com.larus.platform.api.c1 r0 = (com.larus.platform.api.c1) b.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    @Override // com.larus.platform.api.c1
    public final void d() {
        com.larus.platform.api.c1 r0 = (com.larus.platform.api.c1) b.getValue();
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.larus.platform.api.c1
    public final LiveData<UserSubInfo> e() {
        com.larus.platform.api.c1 r0 = (com.larus.platform.api.c1) b.getValue();
        if (r0 == null) goto L7;
        LiveData<UserSubInfo> r1 = r0.e();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new MutableLiveData();
    }

    @Override // com.larus.platform.api.c1
    public final void b(FragmentActivity r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        com.larus.platform.api.c1 r0 = (com.larus.platform.api.c1) b.getValue();
        if (r0 == null) goto L6;
        r0.b(r2, r3);
        return;
    }

    @Override // com.larus.platform.api.c1
    public final void c(FragmentActivity r2, String r3, by7.e r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter("setting", "enterMethod");
        Intrinsics.checkNotNullParameter(r4, "iTrackNode");
        com.larus.platform.api.c1 r5 = (com.larus.platform.api.c1) b.getValue();
        if (r5 == null) goto L6;
        r5.c(r2, "setting", r4);
        return;
    }
}
