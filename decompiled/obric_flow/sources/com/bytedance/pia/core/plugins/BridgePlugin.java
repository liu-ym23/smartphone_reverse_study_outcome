package com.bytedance.pia.core.plugins;

import a2.b;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.pia.core.bridge.channel.WebViewPort$JSInterface;
import com.bytedance.pia.core.utils.a;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.utils.m;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import l9.l;
import nh.c;
import nh.d;

/* JADX INFO: loaded from: classes2.dex */
public class BridgePlugin extends c {
    public BridgePlugin(d r5) {
        super(r5);
    }

    @Override // nh.c
    public final String c() {
        return "pia_bridge";
    }

    @Override // nh.c
    public final void d(View r5) {
        if ((r5 instanceof WebView) == false) goto L6;
        WeakHashMap r10 = WebViewPort$JSInterface.f6958c;
        m.a(new hh.c((WebView) r5, 1));
        return;
    }

    @Override // nh.c
    public final void g() {
        d r10 = this.f20236b;
        View r5 = r10.c();
        if ((r5 instanceof WebView) == false) goto L23;
        WebView r11 = (WebView) r5;
        if (r11 == null) goto L18;
        WebViewPort$JSInterface r12 = (WebViewPort$JSInterface) WebViewPort$JSInterface.f6958c.get(r11);
        if (r12 == null) goto L18;
        AtomicReference r13 = r12.f6959a;
        a r14 = new a();
    L12:
        if (r13.compareAndSet(null, r14) == true) goto L13;
        if (r13.get() == null) goto L12;
        a r15 = (a) r13.getAndSet(null);
    L17:
        if (r15 == null) goto L18;
        l r16 = new l(r11, r15);
    L20:
        if (r16 == null) goto L23;
        gh.c r17 = r10.f20250v;
        r17.getClass();
        m.b(new b(21, r17, r16));
        m.a(new b(25, r16, r10.g));
        Intrinsics.checkNotNullParameter("[Bridge] start render bridge success.", "message");
        j.y("[Bridge] start render bridge success.", null);
        return;
    L13:
        r15 = (a) r13.get();
    L18:
        r16 = null;
    L23:
        Intrinsics.checkNotNullParameter("[Bridge] start render bridge failed!", "message");
        j.x("[Bridge] start render bridge failed!", null);
    }
}
