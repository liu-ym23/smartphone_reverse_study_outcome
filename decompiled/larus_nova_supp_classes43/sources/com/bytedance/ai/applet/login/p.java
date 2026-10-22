package com.bytedance.ai.applet.login;

import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p {
    public static final p a = null;
    public static final Map<String, b> b = null;
    public static WeakReference<f> c;
    public static final CoroutineScope d = null;

    public p() {
    }

    static {
        a = new p();
        b = new LinkedHashMap();
        c = new WeakReference(null);
        d = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static void b(String r10) {
        if (f2.k.b() != null) goto L6;
        com.bytedance.ai.utils.g.a.e("McpLoginManager", "Top activity is null");
        return;
    L6:
        b r11 = (b) ((LinkedHashMap) b).get(r10);
        com.bytedance.ai.utils.g.a.e("McpLoginManager", "loadAddShowWidget: renderContext is null");
    }

    public static final void a(p r10, String r11, o r12) {
        r10.getClass();
        LinkedHashMap r13 = (LinkedHashMap) b;
        if (((b) r13.get(r11)) != null) goto L5;
        com.bytedance.ai.utils.g.a.e("McpLoginManager", "transitionTo: Can not find loginContext: " + r11);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        r0.i("McpLoginManager", "Applet [" + r11 + "] transitioned to " + r12);
        if ((r12 instanceof o.d) == false) goto L9;
        b(r11);
        return;
    L9:
        if ((r12 instanceof o.c) == false) goto L12;
        b(r11);
        return;
    L12:
        if ((r12 instanceof o.a) == false) goto L15;
        b(r11);
        return;
    L15:
        if ((r12 instanceof o.b) == false) goto L22;
        r0.i("McpLoginManager", "finishLoginProcessing reason: " + ((o.b) r12).a.getDescription());
        b r14 = (b) r13.get(r11);
        r0.e("McpLoginManager", "finishLoginProcessing: messageId is null");
        return;
    }
}
