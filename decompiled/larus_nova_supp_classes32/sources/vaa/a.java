package vaa;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.provider.hybrid.m;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n38.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements k {
    public final /* synthetic */ q38.b a;
    public final /* synthetic */ Function1<Boolean, Unit> b;

    public final void a(n38.b r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        FLogger.a.e("ObricAccountServiceImpl", "switchToPersonalAccount failed, code=" + r4.d + ", msg=" + r4.e);
        this.b.invoke(Boolean.FALSE);
    }

    public final void b(n38.b r5) {
        Intrinsics.checkNotNullParameter(r5, "result");
        FLogger.a.i("ObricAccountServiceImpl", "switchToPersonalAccount success, targetSecUserId: " + this.a.g());
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
        AppHost.a.a().finishAllActivities();     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L10;
        FLogger.a.w("ObricAccountServiceImpl", "finishAllActivities failed: " + r8.getMessage(), r8);
    L10:
        this.b.invoke(Boolean.TRUE);
        return;
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public a(q38.b r1, m r2) {
        this.a = r1;
        this.b = r2;
    }
}
