package com.bytedance.android.live.revenue.platform.preference.impl;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements o, wz0.c {
    public final nr2.a a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public d(nr2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "service");
        this.a = r2;
    }

    @Override // wz0.c
    public final wz0.a getStorage(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Object r4 = this.a.G0(r3, Object.class);
        if (r4 != null) goto L7;
        return new wz0.a(null);
    L7:
        return new wz0.a(GsonProtectorUtils.toJson(GsonHelper.get(), r4).toString());
    }

    @Override // wz0.c
    public final void removeStorage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.a.G2(r2);
    }

    @Override // wz0.c
    public final void setStorage(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        this.a.Va(r3, r4, String.class);
    }
}
