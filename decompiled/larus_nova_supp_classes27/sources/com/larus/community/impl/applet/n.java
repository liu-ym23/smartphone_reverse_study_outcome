package com.larus.community.impl.applet;

import com.bytedance.ai.applet.app.AppletApplication;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class n implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ AppletApplication b;

    public /* synthetic */ n(int r1, AppletApplication r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        int r0 = this.a;
        AppletApplication r1 = this.b;
        AICreationAppletNavigator r2 = AICreationAppletNavigator.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        int r4 = RangesKt.coerceAtLeast(r0, 1);     // Catch: Throwable -> L8
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L6;
        r1.h().d().m(1);     // Catch: Throwable -> L8
        r5 = r5 + 1;     // Catch: Throwable -> L8
        goto L4
    L6:
        r2.getClass();     // Catch: Throwable -> L8
        AICreationAppletNavigator.m(r0);     // Catch: Throwable -> L8
        Object r6 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L8
    L10:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L15;
        FLogger.a.e("AICreationAppletNavigator", "navigateBack failed", r7);
        r6 = Boolean.FALSE;
    L15:
        return Boolean.valueOf(((Boolean) r6).booleanValue());
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
