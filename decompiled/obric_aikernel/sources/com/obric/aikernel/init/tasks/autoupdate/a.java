package com.obric.aikernel.init.tasks.autoupdate;

import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f4483a = 0;

    static {
        f4483a = TimeUnit.HOURS.toMillis(4);
    }

    public static final /* synthetic */ void a(String r10, String r11) {
        c(r10, r11);
    }

    public static final long b() {
        return f4483a;
    }

    private static final void c(String r10, String r11) {
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L4
        AIKLog.INSTANCE.i(r10, r11);     // Catch: Throwable -> L4
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
    }
}
