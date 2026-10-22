package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18951a = 0;

    static {
        Exception r5 = new Exception();
        String r10 = a.a.class.getSimpleName();
        StackTraceElement r11 = r5.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(r10), "_", r11.getFileName(), r11.getLineNumber());
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
        Object r13 = Result.m124constructorimpl(BaseContinuationImpl.class.getCanonicalName());     // Catch: Throwable -> L5
    L8:
        if (Result.m127exceptionOrNullimpl(r13) == null) goto L11;
        r13 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    L11:
        String r14 = (String) r13;
        Object r15 = Result.m124constructorimpl(t.class.getCanonicalName());     // Catch: Throwable -> L14
    L17:
        if (Result.m127exceptionOrNullimpl(r15) == null) goto L20;
        r15 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    L20:
        String r16 = (String) r15;
        return;
    L14:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
