package com.bytedance.android.anniex.base.builder;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebViewClient;
import com.lynx.tasm.q1;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import w26.e;
import w26.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class UIComponentBuilder {
    public Context a;
    public String b;
    public final Bundle c;
    public final Lazy d;
    public final Map<String, Object> e;
    public com.bytedance.android.anniex.base.lifecycle.a f;
    public WebViewClient g;
    public q1 h;
    public boolean i;

    public UIComponentBuilder() {
        this.b = "default_bid";
        this.c = new Bundle();
        this.d = LazyKt.lazy(new UIComponentBuilder$contextProviderFactory$2(this));
        this.e = new LinkedHashMap();
    }

    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        this.b = r10;
        Map r0 = x26.a.a;
        g r1 = (g) x26.a.a(g.class);
        if (r1 == null) goto L9;
        e r11 = (e) r1.n0(e.class);
        if (r11 == null) goto L9;
        Boolean r12 = r11.G();
        if (r12 == null) goto L9;
        boolean r13 = r12.booleanValue();
    L10:
        if (r13 == false) goto L13;
        this.c.putString("bundle_annie_x_bid", r10);
        return;
    L13:
        return;
    L9:
        r13 = true;
        goto L10
    }

    public final void b(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "bundle");
        this.c.putAll(r10);
    }

    public final <T> void c(Class<T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        ((m16.b) this.d.getValue()).g(r10, r11);
    }
}
