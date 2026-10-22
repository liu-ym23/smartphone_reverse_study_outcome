package com.bytedance.android.livesdk.chatroom.ui.framework.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.livesdk.chatroom.ui.framework.LoadState;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(j70.f r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return "[" + r2.b + ':' + r2.a + ']';
    }

    @JvmStatic
    public static final void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "info");
        ALogger.i("InteractionFrameworkTracer", r1);
    }

    @JvmStatic
    public static final void c(LiveWidget r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        b("component load success, elementType is " + a(r2.getElementType()) + ", class is " + r2.getClass().getSimpleName());
    }

    @JvmStatic
    public static final void d(LiveWidget r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        b("component unload, elementType is " + a(r2.getElementType()));
    }

    public static void e(LoadState r2, LoadState r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "currentState");
        Intrinsics.checkNotNullParameter(r3, "updateState");
        StringBuilder r0 = new StringBuilder("load state changed: ");
        r0.append(r2);
        r0.append(" -> ");
        r0.append(r3);
        r0.append(", change ");
        if (r4 == false) goto L5;
        String r5 = "success";
    L6:
        r0.append(r5);
        b(r0.toString());
        return;
    L5:
        r5 = "failed";
        goto L6
    }
}
