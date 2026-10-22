package com.bytedance.android.anniex.monitor.salamander;

import android.webkit.WebView;
import b36.j;
import com.bytedance.anniex.bd.foundation.impl.u;
import com.bytedance.rts.foundation.q;
import com.bytedance.rts.foundation.r;
import com.bytedance.salamander.anniex.a7;
import com.bytedance.salamander.anniex.x7;
import com.bytedance.salamander.anniex.z5;
import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends j {
    public boolean a;
    public Boolean b;
    public String c;

    public f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onProgressChanged(WebView r10, int r11) {
        super/*android.webkit.WebChromeClient*/.onProgressChanged(r10, r11);
        if (com.bytedance.android.monitorV2.util.h.d() == true) goto L5;
        return;
    L5:
        boolean r0 = false;
        if (r10 == null) goto L13;
        String r12 = r10.getUrl();
        if (r12 == null) goto L13;
        if (Intrinsics.areEqual(this.c, r12) == true) goto L13;
        this.c = r12;
        this.b = null;
        this.a = false;
    L13:
        if (this.a == false) goto L15;
        return;
    L15:
        if (r11 < 15) goto L78;
        if (r10 != null) goto L19;
        return;
    L19:
        if (r10.getUrl() != null) goto L21;
    L23:
        boolean r13 = false;
    L24:
        if (r13 == true) goto L27;
        r10 = null;
    L27:
        if (r10 == null) goto L76;
        String r14 = r10.getUrl();
        String r15 = "";
        if (r14 == null) goto L61;
        if (this.b != null) goto L48;
        x7.a.getClass();
        Intrinsics.checkNotNullParameter(r14, "urlString");
        int r16 = a7.a;
        int r17 = u.c;     // Catch: Throwable -> L69
        u r18 = u.a.a(r14);     // Catch: Throwable -> L69
        if (r18 == null) goto L46;
        String r19 = r18.b();     // Catch: Throwable -> L69
        if (r19 == null) goto L46;
        z5.a.getClass();     // Catch: Throwable -> L69
        Set r20 = z5.a.a().e;     // Catch: Throwable -> L69
        ArrayList r110 = r.f(r19, ".", -1);     // Catch: Throwable -> L69
        int r21 = 0;
    L41:
        if (r21 > (com.bytedance.rts.foundation.j.d(r110) - 1)) goto L46;
        if (q.a(r20, com.bytedance.rts.foundation.j.g(com.bytedance.rts.foundation.j.l(r110, r21, com.bytedance.rts.foundation.j.d(r110)), ".")) == true) goto L44;
        r21 = r21 + 1;
        goto L41
    L44:
        boolean r111 = true;
    L47:
        this.b = Boolean.valueOf(r111);
    L46:
        r111 = false;
    L48:
        Boolean r112 = this.b;
        if (r112 != null) goto L51;
    L56:
        String r113 = null;
    L57:
        if (r113 == null) goto L61;
        r15 = r113;
        goto L61
    L51:
        if (r112.booleanValue() == true) goto L54;
        r112 = null;
    L54:
        if (r112 == null) goto L56;
        r112.booleanValue();
        r113 = zz2.b.a(r10.getContext(), "", "SlardarHybrid('config',{sendCommonParams:{},monitors:{StaticErrorMonitor:{ignore:[]},StaticPerformanceMonitor:{slowSession:8000,sampleRate:0.1},FPSMonitor:{interval:3000},MemoryMonitor:{interval:3000},PerformanceMonitor:{interval:100,checkPoint:['DOMContentLoaded','load']}}});", true);
    L61:
        if (r15.length() <= 0) goto L63;
        r0 = true;
    L63:
        if (r0 == true) goto L65;
        return;
    L65:
        if (r10.getSettings().getJavaScriptEnabled() == true) goto L67;
        r10.getSettings().setJavaScriptEnabled(true);
    L67:
        r10.evaluateJavascript(r15, null);
        this.a = true;
        return;
    L76:
        return;
    L21:
        if (r10.getContext() == null) goto L23;
        r13 = true;
        goto L24
    }
}
