package com.larus.uaigc.service;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ h(Bundle r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r5) {
        Bundle r0 = this.a;
        boolean r1 = this.b;
        Context r6 = (Context) r5;
        Intrinsics.checkNotNullParameter(r6, "routeContext");
        r0.putBoolean("route_native_below_ai_creation_applet", true);
        if (r1 == false) goto L5;
        String r2 = "//flow/chat_page_double_tab";
    L6:
        com.bytedance.router.i r7 = SmartRouter.buildRoute(r6, r2);
        r7.c.putExtras(r0);
        r7.d = 2130772399;
        r7.e = 2130772399;
        r7.d();
        return Unit.INSTANCE;
    L5:
        r2 = "//flow/chat_page";
        goto L6
    }
}
