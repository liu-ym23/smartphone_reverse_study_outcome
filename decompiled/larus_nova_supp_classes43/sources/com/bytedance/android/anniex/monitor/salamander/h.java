package com.bytedance.android.anniex.monitor.salamander;

import android.os.Build;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import b36.l;
import b36.q;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.salamander.anniex.i7;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h extends q {
    public final String a;

    public h(String r1) {
        this.a = r1;
    }

    public final boolean a(WebView r10, l r11) {
        SLMonitorCompat r0 = SLMonitorCompat.a;
        r0.getClass();
        if (SLMonitorCompat.b == true) goto L5;
        super.a(r10, r11);
        throw null;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L18;
        String r1 = this.a;
        if (r1 == null) goto L18;
        i7 r12 = new i7();
        r12.a = -1;
        if (r11 == null) goto L13;
        boolean r13 = true;
        if (r11.a() != true) goto L13;
    L14:
        if (r13 == false) goto L16;
        String r14 = PageInfo.SCENE_CRASH;
    L17:
        String r15 = "cause by ".concat(r14);
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r12.b = r15;
        String r16 = SLMonitorCompat.NativeErrorScene.WebProcessTerminate.getValue();
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r12.c = r16;
        Unit r17 = Unit.INSTANCE;
        r0.getClass();
        SLMonitorCompat.o(r1, r12);
        goto L18
    L16:
        r14 = "system";
    L13:
        r13 = false;
    L18:
        super.a(r10, r11);
        throw null;
    }

    public final void onReceivedError(WebView r10, WebResourceRequest r11, WebResourceError r12) {
        super.onReceivedError(r10, r11, r12);
        SLMonitorCompat r13 = SLMonitorCompat.a;
        r13.getClass();
        if (SLMonitorCompat.b == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L20;
        if (r11 == null) goto L11;
        boolean r0 = true;
        if (r11.isForMainFrame() != true) goto L11;
    L12:
        if (r0 == false) goto L21;
        String r14 = this.a;
        if (r14 == null) goto L22;
        i7 r1 = new i7();
        if (r12 == null) goto L18;
        r1.a = r12.getErrorCode();
        String r15 = r12.getDescription().toString();
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r1.b = r15;
        String r16 = SLMonitorCompat.NativeErrorScene.WebError.getValue();
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r1.c = r16;
    L18:
        Unit r17 = Unit.INSTANCE;
        r13.getClass();
        SLMonitorCompat.o(r14, r1);
        return;
    L22:
        return;
    L21:
        return;
    L11:
        r0 = false;
        goto L12
    }

    public final void onReceivedHttpError(WebView r10, WebResourceRequest r11, WebResourceResponse r12) {
        super.onReceivedHttpError(r10, r11, r12);
        SLMonitorCompat r13 = SLMonitorCompat.a;
        r13.getClass();
        if (SLMonitorCompat.b == true) goto L5;
        return;
    L5:
        int r0 = 0;
        if (r11 == null) goto L10;
        boolean r1 = true;
        if (r11.isForMainFrame() != true) goto L10;
    L11:
        if (r1 == false) goto L25;
        String r14 = this.a;
        if (r14 == null) goto L26;
        i7 r15 = new i7();
        if (r12 == null) goto L17;
        r0 = r12.getStatusCode();
    L17:
        r15.a = r0;
        if (r12 == null) goto L20;
        String r16 = r12.getReasonPhrase();
    L21:
        if (r16 != null) goto L23;
        r16 = "";
    L23:
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r15.b = r16;
        String r17 = SLMonitorCompat.NativeErrorScene.WebError.getValue();
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r15.c = r17;
        Unit r18 = Unit.INSTANCE;
        r13.getClass();
        SLMonitorCompat.o(r14, r15);
        return;
    L20:
        r16 = null;
        goto L21
    L26:
        return;
    L25:
        return;
    L10:
        r1 = false;
        goto L11
    }
}
