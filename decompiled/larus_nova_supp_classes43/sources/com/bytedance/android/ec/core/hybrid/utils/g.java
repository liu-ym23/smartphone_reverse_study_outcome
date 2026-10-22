package com.bytedance.android.ec.core.hybrid.utils;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements pd.h {
    public final /* synthetic */ ti.k a;

    @Override // pd.h
    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        ti.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public g(ti.k r1) {
        this.a = r1;
    }

    @Override // pd.h
    public final void onFirstScreen(View r10) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        ti.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFirstScreen(r10);
        return;
    }

    @Override // pd.h
    public final void onLoadSuccess(View r10) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        ti.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.onLoadSuccess(r10);
        return;
    }

    @Override // pd.h
    public final void onRuntimeReady(View r10) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        ti.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.onRuntimeReady(r10);
        return;
    }

    @Override // pd.h
    public final void onLoadFailed(View r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        ti.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.onLoadFailed(r10, r11);
        return;
    }

    @Override // pd.h
    public final void onPageStart(View r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        ti.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.onPageStart(r10, r11);
        return;
    }

    @Override // pd.h
    public final void onReceivedError(View r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        ti.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.s(r10, r11, "");
        return;
    }
}
