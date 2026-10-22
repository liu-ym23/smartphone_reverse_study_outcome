package com.bytedance.android.monitorV2;

import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.bytedance.android.monitorV2.dataprocessor.a {
    @Override // com.bytedance.android.monitorV2.dataprocessor.a
    public final void a(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L10
        if ((r5 instanceof Pair) == false) goto L17;
        Object r11 = ((Pair) r5).getFirst();     // Catch: Throwable -> L10
        if ((r11 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L15;
        com.bytedance.android.monitorV2.dataprocessor.b r12 = c.f3517a;     // Catch: Throwable -> L10
        Object r13 = ((Pair) r5).getFirst();     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.android.monitorV2.event.CommonEvent");     // Catch: Throwable -> L10
        com.bytedance.android.monitorV2.event.a r14 = (com.bytedance.android.monitorV2.event.a) r13;     // Catch: Throwable -> L10
        Object r15 = ((Pair) r5).getSecond();     // Catch: Throwable -> L10
        if ((r15 instanceof com.bytedance.android.monitorV2.webview.a) == false) goto L12;
        com.bytedance.android.monitorV2.webview.a r16 = (com.bytedance.android.monitorV2.webview.a) r15;     // Catch: Throwable -> L10
    L13:
        c.a(r14, r16);     // Catch: Throwable -> L10
        goto L17
    L12:
        r16 = null;
        goto L13
    L15:
        if ((r11 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L17;
        com.bytedance.android.monitorV2.dataprocessor.b r17 = c.f3517a;     // Catch: Throwable -> L10
        Object r18 = ((Pair) r5).getFirst();     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.bytedance.android.monitorV2.event.CustomEvent");     // Catch: Throwable -> L10
        c.c((com.bytedance.android.monitorV2.event.b) r18);     // Catch: Throwable -> L10
    L17:
        Object r19 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L20:
        Throwable r20 = Result.m127exceptionOrNullimpl(r19);
        if (r20 == null) goto L26;
        mn.h.g("default_handle", r20);
        return;
    L26:
        return;
    L10:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L20
    }
}
