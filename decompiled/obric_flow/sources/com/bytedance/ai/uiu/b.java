package com.bytedance.ai.uiu;

import android.webkit.ValueCallback;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.SafeContinuation;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SafeContinuation f2826b;

    public /* synthetic */ b(SafeContinuation r5, int r10) {
        this.f2825a = r10;
        this.f2826b = r5;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r5) {
        SafeContinuation r10 = this.f2826b;
        switch(this.f2825a) {
            case 0: goto L14;
            default: goto L4;
        };
    L4:
        String r11 = (String) r5;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L7
        Object r13 = Result.m124constructorimpl(Boolean.valueOf(Boolean.parseBoolean(r11)));     // Catch: Throwable -> L7
    L9:
        Boolean r14 = Boolean.FALSE;
        if (Result.m130isFailureimpl(r13) == false) goto L12;
        r13 = r14;
    L12:
        r10.resumeWith(Result.m124constructorimpl(r13));
        return;
    L7:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L9
    L14:
        r10.resumeWith(Result.m124constructorimpl((String) r5));
    }
}
