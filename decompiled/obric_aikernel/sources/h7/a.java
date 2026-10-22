package h7;

import com.obric.aee.ExecutionEngine;
import com.obric.aikernel.isolate.api.IIsolateApi;
import com.obric.aikernel.middleware.api.log.AIKLog;
import k7.b;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9194a = null;

    static {
        f9194a = new a();
    }

    private a() {
    }

    public final void a() {
        IIsolateApi r10 = b.a();
        boolean r11 = true;
        if (r10 != null) goto L5;
    L7:
        r11 = false;
    L8:
        if (r11 == false) goto L16;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L11
        ExecutionEngine.f4305a.c(false);     // Catch: Throwable -> L11
        AIKLog.INSTANCE.d("DebugExtension", "disable so sig check.");     // Catch: Throwable -> L11
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        return;
    L16:
        return;
    L5:
        if (r10.isSysAikernelSwitchEnabled("debug_feature_enable", false) != true) goto L7;
        goto L7
    }

    public final boolean b() {
        IIsolateApi r10 = b.a();
        if (r10 == null) goto L8;
        if (r10.isSysAikernelSwitchEnabled("skip_quota_check", false) != true) goto L8;
        return true;
    L8:
        return false;
    }
}
