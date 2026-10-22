package com.bytedance.android.live.revenue.platform.settings.impl;

import com.bytedance.android.scope.o;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements b01.e, o {
    public e() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // b01.e
    public final <T> T f0(String r2, T r3, Type r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r4, "type");
        return (T) f.a(r2, r3, r4, r5);
    }
}
