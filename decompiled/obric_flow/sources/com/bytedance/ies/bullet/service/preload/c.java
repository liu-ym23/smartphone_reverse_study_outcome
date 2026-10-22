package com.bytedance.ies.bullet.service.preload;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.SystemClock;
import android.webkit.WebView;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.lynx.tasm.utils.k;
import com.obric.launcher.widget.R$id;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends tc.a {
    public final WebView d(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.webkit.c.class, "clazz");
        tc.c r5 = tc.c.f22119c;
        com.bytedance.ies.bullet.service.webkit.c r11 = (com.bytedance.ies.bullet.service.webkit.c) tc.c.f22119c.a(com.bytedance.ies.bullet.service.webkit.c.class, this.f22117a);
        if (r11 == null) goto L5;
        Intrinsics.checkNotNullParameter(r10, "application");
        r11.d(r10, r11.d);
    L5:
        z4.a r12 = k.f11181a;
        if (r12 == null) goto L35;
        SystemClock.uptimeMillis();
        al.b r13 = (al.b) ((HashMap) r12.f23391c).get("webx_bullet");
        if (r13 == null) goto L35;
        if (r13.f315a.isEmpty() == true) goto L29;
        Object r14 = r12.f23389a;
        monitor-enter(r14);
        WebView r15 = (WebView) ((SoftReference) r13.f315a.remove(0)).get();     // Catch: Throwable -> L20
        if (r15 == null) goto L23;
        if (r10 == null) goto L23;
        Context r16 = r15.getContext();     // Catch: Throwable -> L20
        if ((r16 instanceof MutableContextWrapper) == false) goto L23;
        ((MutableContextWrapper) r16).setBaseContext(r10);     // Catch: Throwable -> L20
    L23:
        if (r13.f315a.size() >= r13.f317c) goto L25;
        r12.d(r13);     // Catch: Throwable -> L20
    L25:
        monitor-exit(r14);     // Catch: Throwable -> L20
        return r15;
    L20:
        th = move-exception;
        throw th;
    L29:
        SSWebView r17 = r13.f316b.a(new MutableContextWrapper(r10));
        if (r17 == null) goto L33;
        r17.setTag(R$id.webx_precreate_is_precreate, Boolean.FALSE);
    L33:
        r12.b(r13.f317c);
        return r17;
    L35:
        return null;
    }
}
