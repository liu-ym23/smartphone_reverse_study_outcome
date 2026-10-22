package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements Runnable {
    public final /* synthetic */ Function0<Unit> a;

    public b(Function0<Unit> r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MinutesForegroundService.Companion r0 = MinutesForegroundService.h;     // Catch: Throwable -> L4
        MinutesForegroundService.Companion.e(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
