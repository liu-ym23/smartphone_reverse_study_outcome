package com.obric.assistant.util;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.n4;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class x0 implements n4 {
    public final /* synthetic */ Function0<Unit> a;
    public final /* synthetic */ Function0<Unit> b;
    public final /* synthetic */ Function0<Unit> c;

    public final void onAuthenticationCancelled() {
        FLogger.a.i("DeviceCredentialAuthHelper", "onAuthenticationCancelled");
        Function0<Unit> r0 = this.b;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public final void onAuthenticationFailed() {
        FLogger.a.i("DeviceCredentialAuthHelper", "onAuthenticationFailed");
        Function0<Unit> r0 = this.b;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public final void onAuthenticationNotAvailable() {
        FLogger.a.i("DeviceCredentialAuthHelper", "onAuthenticationNotAvailable");
        Function0<Unit> r0 = this.c;
        if (r0 == null) goto L5;
    L4:
        r0.invoke();
        return;
    L5:
        r0 = this.b;
        if (r0 != null) goto L4;
    }

    public final void onAuthenticationPass() {
        FLogger.a.i("DeviceCredentialAuthHelper", "onAuthenticationPass");
        this.a.invoke();
    }

    public final void onAuthenticationTimeout() {
        FLogger.a.i("DeviceCredentialAuthHelper", "onAuthenticationTimeout");
        Function0<Unit> r0 = this.b;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public x0(Function0<Unit> r1, Function0<Unit> r2, Function0<Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
