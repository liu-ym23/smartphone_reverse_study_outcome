package com.bytedance.android.live.recharge.panel.context;

import com.bytedance.revenue.platform.api.core.rx.h;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final void a(final Disposable r1, CompositeDisposable r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$bind");
        if (r2 == null) goto L6;
        int r0 = h.a;
        r2.add(h.a(new CommonRechargePanelPropertiesProviderKt$bind$1(r1)));
        return;
    }
}
