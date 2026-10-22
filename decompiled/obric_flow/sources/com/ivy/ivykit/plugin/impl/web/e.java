package com.ivy.ivykit.plugin.impl.web;

import android.view.MotionEvent;
import android.webkit.WebView;
import com.bytedance.ies.bullet.service.base.YieldError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements com.bytedance.ies.bullet.kit.web.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f9539a;

    public e(h r5) {
        this.f9539a = r5;
    }

    public final void a(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        ol.e r10 = this.f9539a.d;
        if (r10 == null) goto L18;
        Intrinsics.checkNotNullParameter(r5, "event");
        int r11 = r5.getAction();
        j1.e r12 = ((j1.b) r10).f18221a;
        if (r11 == 0) goto L15;
        if (r11 != 1) goto L8;
        WebView r13 = r12.e;
        if (r13 == null) goto L18;
        r13.requestDisallowInterceptTouchEvent(false);
        goto L18
    L8:
        if (r11 != 2) goto L18;
        WebView r14 = r12.e;
        if (r14 == null) goto L18;
        r14.requestDisallowInterceptTouchEvent(!r12.f);
        goto L18
    L15:
        r12.f = false;
        WebView r15 = r12.e;
        if (r15 == null) goto L18;
        r15.requestDisallowInterceptTouchEvent(true);
    L18:
        Intrinsics.checkNotNullParameter(r5, "event");
        throw new YieldError();
    }
}
