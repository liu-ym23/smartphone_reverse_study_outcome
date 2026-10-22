package com.bytedance.android.anniex.lite.container;

import android.view.View;
import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ AnnieXFlowPopupContainer b;

    public h(View r1, AnnieXFlowPopupContainer r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void a() {
        com.bytedance.android.anniex.container.ui.h r1 = null;
        if (((WebView) this.a).canGoBack() == false) goto L9;
        com.bytedance.android.anniex.container.ui.h r0 = this.b.m;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
    L8:
        r1.f(this.b.s(), 0);
        return;
    L7:
        r1 = r0;
        goto L8
    L9:
        com.bytedance.android.anniex.container.ui.h r10 = this.b.m;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
    L13:
        r1.f(this.b.s(), 8);
        return;
    L12:
        r1 = r10;
        goto L13
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
