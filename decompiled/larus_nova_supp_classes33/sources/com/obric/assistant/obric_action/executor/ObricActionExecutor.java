package com.obric.assistant.obric_action.executor;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.h;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricActionExecutor {
    public static final /* synthetic */ int b = 0;
    public final Map<String, IObricActionHandler<?, ?>> a;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricActionExecutor(Map<String, ? extends IObricActionHandler<?, ?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "handlerMap");
        this.a = r2;
    }

    public final Object a(Context r3, efa.a r4, Continuation<? super h<? extends Object>> r5) {
        String r0 = r4.a;
        IObricActionHandler<?, ?> r1 = this.a.get(r0);
        if (r1 != null) goto L6;
        FLogger.a.w("ObricActionExecutor", "execute: host " + r0 + " not support");
        return h.a.a(h.d, "host " + r0 + " not support", 2);
    L6:
        String r6 = r4.b;
        if (r6 != null) goto L10;
        r6 = "";
    L10:
        return b(r3, r1, r6, r5);
    }

    public final Object b(Context r7, IObricActionHandler<?, ?> r8, String r9, Continuation<? super h<? extends Object>> r10) {
        if ((r10 instanceof ObricActionExecutor$executeHandler$1) == false) goto L7;
        ObricActionExecutor$executeHandler$1 r1 = (ObricActionExecutor$executeHandler$1) r10;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r11 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r5 = true;
        if (r4 == 0) goto L15;
        if (r4 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L21
    L19:
        FLogger.a.i("ObricActionExecutor", "executeHandler result: " + ((h) r11));     // Catch: Throwable -> L21
        Object r12 = Result.constructor-impl((h) r11);     // Catch: Throwable -> L21
    L23:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L26;
        FLogger.a.e("ObricActionExecutor", "execute action failed. " + r13.getMessage(), r13);
    L26:
        Throwable r14 = Result.exceptionOrNull-impl(r12);
        if (r14 == null) goto L42;
        h.a r15 = h.d;
        String r16 = r14.getMessage();
        if (r16 != null) goto L33;
        r16 = "";
    L33:
        if (r16.length() == 0) goto L36;
        r5 = false;
    L36:
        if (r5 == false) goto L39;
        r16 = "execute action failed";
    L39:
        return h.a.a(r15, r16, 2);
    L42:
        return r12;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.obric.assistant.obric_action.IObricActionHandler<kotlin.Any?, kotlin.Any?>");     // Catch: Throwable -> L21
        Object r18 = r8.a(r7, r9);     // Catch: Throwable -> L21
        r1.label = 1;     // Catch: Throwable -> L21
        r11 = r8.d(r7, r18, r1);     // Catch: Throwable -> L21
        if (r11 != r3) goto L19;
        return r3;
    L21:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r1 = new ObricActionExecutor$executeHandler$1(this, r10);
        goto L8
    }
}
