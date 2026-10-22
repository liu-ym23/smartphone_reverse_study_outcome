package com.obric.assistant.component.clicktalk;

import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class m implements Function1 {
    public final /* synthetic */ boolean a;

    public /* synthetic */ m(ChatClickTalkComponent r1, boolean r2) {
        this.a = r2;
    }

    public final Object invoke(Object r5) {
        boolean r0 = this.a;
        long r1 = ((Long) r5).longValue();
        int r6 = ChatClickTalkComponent.L0;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        BuildersKt.runBlocking$default(null, new ChatClickTalkComponent$operateDoraVUI$1$1$1(r0, r1, null), 1, null);     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L11;
        FLogger.a.w("ChatClickTalkComponent", "operateDoraVUI failed", r9);
    L11:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
