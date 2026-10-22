package com.bytedance.ies.argus.aspect.eventCenter;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class BaseRuntimeContext$traceId$2 extends Lambda implements Function0<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f4986a;

    public BaseRuntimeContext$traceId$2(c r5) {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        c r5 = this.f4986a;
        Intrinsics.checkNotNullParameter(r5, "obj");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(String.valueOf(System.identityHashCode(r5)));     // Catch: Throwable -> L5
    L8:
        if (Result.m130isFailureimpl(r11) == false) goto L11;
        r11 = null;
    L11:
        return (String) r11;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
