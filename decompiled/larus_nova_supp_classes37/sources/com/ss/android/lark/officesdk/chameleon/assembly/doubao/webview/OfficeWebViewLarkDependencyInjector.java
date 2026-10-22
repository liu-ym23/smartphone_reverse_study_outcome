package com.ss.android.lark.officesdk.chameleon.assembly.doubao.webview;

import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.di.core.DependencyContextUniqueId;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeWebViewLarkDependencyInjector {
    public static final AtomicBoolean a = null;

    static {
        a = new AtomicBoolean(false);
    }

    public static void a() {
        AtomicBoolean r0 = a;
        if (r0.get() == false) goto L5;
        return;
    L5:
        DependencyContainer.a.b(DependencyContextUniqueId.OfficeWebView, OfficeWebViewLarkDependencyInjector$inject$1.INSTANCE);
        r0.set(true);
    }
}
