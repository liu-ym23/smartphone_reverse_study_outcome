package com.bytedance.android.anniex.monitor;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mn.h;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Lambda f3334b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(int r5, Function0 r10) {
        this.f3333a = r5;
        switch(r5) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        this.f3334b = (Lambda) r10;
        return;
    L6:
        Intrinsics.checkNotNullParameter(r10, "function");
        this.f3334b = (Lambda) r10;
        return;
    L8:
        this.f3334b = (Lambda) r10;
        return;
    L10:
        Intrinsics.checkNotNullParameter(r10, "function");
        this.f3334b = (Lambda) r10;
        return;
    L12:
        this.f3334b = (Lambda) r10;
        return;
    L14:
        this.f3334b = (Lambda) r10;
        return;
    L16:
        this.f3334b = (Lambda) r10;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // java.lang.Runnable
    public final void run() {
        ?? r5 = this.f3334b;
        switch(this.f3333a) {
            case 0: goto L25;
            case 1: goto L27;
            case 2: goto L29;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L6;
            default: goto L4;
        };
    L4:
        r5.invoke();
        return;
    L6:
        r5.invoke();
        return;
    L8:
        r5.invoke();
        return;
    L10:
        r5.invoke();
        return;
    L25:
        r5.invoke();
        return;
    L27:
        r5.invoke();     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        h.g("default_handle", e);
        return;
    L29:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L14
        r5.invoke();     // Catch: Throwable -> L14
        Object r11 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L31;
        h.g("default_handle", r12);
        return;
    L31:
        return;
    L14:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L16
    }
}
