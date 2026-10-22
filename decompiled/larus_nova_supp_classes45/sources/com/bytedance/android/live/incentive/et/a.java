package com.bytedance.android.live.incentive.et;

import com.bytedance.android.scope.o;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements o, c {
    public a() {
    }

    public final void onStop() {
    }

    public final void onStart() {
        mz0.d.a(d.class, d.a);
    }

    @Override // com.bytedance.android.live.incentive.et.c
    public final void j(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "eventProperties");
        d.a.getClass();
        d.a(r2, r3);
    }
}
