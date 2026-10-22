package com.larus.bmhome.chat.component.trace;

import android.content.Context;
import com.larus.bmhome.chat.screenshot.c;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f implements Function0 {
    public final /* synthetic */ ChatScreenRecordTraceComponent a;
    public final /* synthetic */ Context b;

    public /* synthetic */ f(ChatScreenRecordTraceComponent r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        ChatScreenRecordTraceComponent r0 = this.a;
        Context r1 = this.b;
        if (AppHost.a.a().isAppBackground() == true) goto L5;
        FLogger.a.i(r0.m, "do register ScreenShot");
        c r2 = com.larus.bmhome.chat.screenshot.i.a;
        com.larus.bmhome.chat.screenshot.i.a(r1, r0.o);
    L7:
        return Unit.INSTANCE;
    L5:
        FLogger.a.i(r0.m, "prepare registerScreenShot but already background");
        goto L7
    }
}
