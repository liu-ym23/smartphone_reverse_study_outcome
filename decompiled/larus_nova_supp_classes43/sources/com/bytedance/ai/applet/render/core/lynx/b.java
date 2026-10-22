package com.bytedance.ai.applet.render.core.lynx;

import android.content.Context;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class b extends h8a.a {
    public final Context a;

    public static final class a {
    }

    static {
    }

    public abstract void d(String r1, e8a.a<h8a.b> r10);

    public b(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.a = r10;
    }

    public static LynxResourceResponse c(Throwable r1) {
        Intrinsics.checkNotNullParameter(r1, IHostStyleUIDepend.TOAST_TYPE_ERROR);
        LynxResourceResponse r10 = LynxResourceResponse.a(r1);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<com.lynx.tasm.resourceprovider.template.TemplateProviderResult?>");
        return r10;
    }

    public final void a(LynxResourceRequest r10, LynxTemplateRender.j r11) {
        LynxResourceResponse r12 = LynxResourceResponse.a(new UnsupportedOperationException("SSRData is not supported"));
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.ByteArray?>");
        r11.onResponse(r12);
    }

    public final void b(LynxResourceRequest r10, e8a.a<h8a.b> r11) {
        String r12 = r10.a;
        if (r12 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        String r13 = null;
        if (r1 == false) goto L13;
        com.bytedance.ai.applet.base.log.a.b("BuiltinAssetTemplateResourceFetcher", "fetchTemplate: requestUrl is empty", null);
        r11.onResponse(c(new IllegalArgumentException("template url is empty")));
        return;
    L13:
        com.bytedance.ai.applet.base.log.b r14 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("BuiltinAssetTemplateResourceFetcher", "fetchTemplate: requestUrl = " + r12);
        Map<String, String> r15 = c.a;
        if (r12 == null) goto L16;
        r13 = c.a.get(r12);
    L16:
        if (r13 != null) goto L24;
        com.bytedance.ai.applet.base.log.a.c("BuiltinAssetTemplateResourceFetcher", "fetchTemplate: requestUrl = " + r12 + ", assetPath = null");
        d(r12, r11);
        return;
    L24:
        com.bytedance.ai.applet.base.log.a.c("BuiltinAssetTemplateResourceFetcher", "fetchTemplate: assetPath = ".concat(r13));     // Catch: Throwable -> L19
        long r16 = System.currentTimeMillis();     // Catch: Throwable -> L19
        TemplateBundle r17 = c.a(this.a, r13);     // Catch: Throwable -> L19
        com.bytedance.ai.applet.base.log.a.c("BuiltinAssetTemplateResourceFetcher", "fetchTemplate: assetPath = " + r13 + ", cost = " + (System.currentTimeMillis() - r16) + "ms");     // Catch: Throwable -> L19
        h8a.b r18 = new h8a.b();     // Catch: Throwable -> L19
        r18.b = r17;     // Catch: Throwable -> L19
        r11.onResponse(LynxResourceResponse.b(r18));     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        com.bytedance.ai.applet.base.log.b r19 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("BuiltinAssetTemplateResourceFetcher", "fetchTemplate: assetPath = ".concat(r13), th);
        r11.onResponse(c(th));
        return;
    L5:
        if (r12.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
