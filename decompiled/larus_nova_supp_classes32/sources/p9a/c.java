package p9a;

import com.obric.aiagent.assistant_card.provider_core.ICardProviderService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static final void a(i r1, ICardProviderService r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        if (r1.isActive() == false) goto L6;
        r1.resumeWith(Result.constructor-impl(r2));     // Catch: Throwable -> L8
    L6:
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L16;
        e r5 = b.a;
        b.c("ContinuationEx", "safeResume error: " + r4.getMessage(), r4);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
