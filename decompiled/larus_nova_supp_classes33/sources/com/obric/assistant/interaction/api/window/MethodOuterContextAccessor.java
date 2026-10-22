package com.obric.assistant.interaction.api.window;

import android.content.Context;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/assistant/interaction/api/window/MethodOuterContextAccessor;", "Lcom/obric/assistant/interaction/api/window/OuterContextAccessor;", "method", "Ljava/lang/reflect/Method;", "<init>", "(Ljava/lang/reflect/Method;)V", "getOuter", "Landroid/content/Context;", "ctx", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class MethodOuterContextAccessor implements OuterContextAccessor {
    private final Method method;

    public MethodOuterContextAccessor(Method r2) {
        Intrinsics.checkNotNullParameter(r2, "method");
        this.method = r2;
    }

    @Override // com.obric.assistant.interaction.api.window.OuterContextAccessor
    public Context getOuter(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "ctx");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Object r5 = this.method.invoke(r4, new Object[0]);     // Catch: Throwable -> L9
        if ((r5 instanceof Context) == false) goto L6;
        Context r6 = (Context) r5;     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r7) == true) goto L16;
        r0 = r7;
    L16:
        return (Context) r0;
    L6:
        r6 = null;
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
