package com.bytedance.ai.applet.render.core.lynx;

import android.content.Context;
import com.lynx.tasm.TemplateBundle;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final Map<String, String> a = null;
    public static final ConcurrentHashMap<String, TemplateBundle> b = null;

    static {
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to("/doubao-apps-framework.template.js", "apps_sdk/doubao-apps-framework.template.js"), TuplesKt.to("/doubao-apps-react.template.js", "apps_sdk/doubao-apps-react.template.js"), TuplesKt.to("/doubao-apps-react-dev.template.js", "apps_sdk/doubao-apps-react-dev.template.js"), TuplesKt.to("/doubao-apps-api.template.js", "apps_sdk/doubao-apps-api.template.js")});
        b = new ConcurrentHashMap();
    }

    public static TemplateBundle a(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "assetPath");
        ConcurrentHashMap<String, TemplateBundle> r0 = b;
        TemplateBundle r1 = r0.get(r11);
        if (r1 != null) goto L25;
        InputStream r12 = r10.getAssets().open(r11);
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L19
        byte[] r13 = ByteStreamsKt.readBytes(r12);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r12, null);
        r1 = TemplateBundle.b(r13);
        if (r1 == null) goto L11;
        boolean r14 = true;
        if (r1.i() != true) goto L11;
    L12:
        if (r14 == false) goto L18;
        TemplateBundle r15 = r0.putIfAbsent(r11, r1);
        if (r15 == null) goto L25;
        r1 = r15;
        goto L25
    L18:
        throw new IllegalStateException("invalid builtin lynx template: ".concat(r11));
    L11:
        r14 = false;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L25:
        return r1;
    }
}
