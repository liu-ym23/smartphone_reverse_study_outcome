package com.bytedance.android.livesdk.dslservice.util;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements ComponentCallbacks2 {
    public static Consumer<Integer> a;
    public static final c b = null;

    public c() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
    }

    static {
        b = new c();
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        Consumer<Integer> r0 = a;
        if (r0 == null) goto L6;
        r0.accept(0);
        return;
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r2) {
        if (r2 != 10) goto L5;
    L7:
        Consumer<Integer> r0 = a;
        if (r0 == null) goto L11;
        r0.accept(Integer.valueOf(r2));
        return;
    L11:
        return;
    L5:
        if (r2 == 15) goto L7;
    }
}
