package com.bytedance.ies.bullet.service.webkit;

import android.webkit.WebView;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.obric.launcher.widget.R$id;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public rb.b f6153b;

    public final void a(WebView r5) {
        Intrinsics.checkNotNullParameter(r5, "webView");
        if (this.f6152a != null) goto L5;
        return;
    L5:
        Object r10 = r5.getTag(R$id.key_js_object_global_props);
        if (r10 != null) goto L20;
        rb.b r11 = this.f6153b;
        if (r11 == null) goto L10;
        InjectData r12 = (InjectData) r11.a(InjectData.class);
    L11:
        if (r12 == null) goto L16;
        String r13 = this.f6152a;
        if (r13 != null) goto L15;
        r13 = "{}";
    L15:
        Intrinsics.checkNotNullParameter(r13, "globalProps");
        r12.f6150a = r13;
    L17:
        r5.getSettings().setJavaScriptEnabled(true);
        r5.addJavascriptInterface(r12, "__globalprops");
        r5.setTag(R$id.key_js_object_global_props, r12);
        boolean r14 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("injectGlobalProps:successfully set", LogLevel.f5953a, "XWebKit");
        return;
    L16:
        String r15 = this.f6152a;
        r12 = new InjectData();
        r12.f6150a = r15;
        goto L17
    L10:
        r12 = null;
        goto L11
    L20:
        if ((r10 instanceof InjectData) == true) goto L23;
        boolean r16 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("injectGlobalProps:type mismatch, current type is " + r10.getClass(), LogLevel.d, "XWebKit");
        return;
    L23:
        boolean r17 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("injectGlobalProps:already set", LogLevel.f5953a, "XWebKit");
        String r18 = this.f6152a;
        Intrinsics.checkNotNull(r18);
        Intrinsics.checkNotNullParameter(r18, "globalProps");
        ((InjectData) r10).f6150a = r18;
    }
}
