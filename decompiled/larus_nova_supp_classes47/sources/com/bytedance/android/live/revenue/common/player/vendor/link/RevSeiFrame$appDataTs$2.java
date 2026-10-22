package com.bytedance.android.live.revenue.common.player.vendor.link;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$appDataTs$2 extends FunctionReferenceImpl implements Function0<Long> {
    public RevSeiFrame$appDataTs$2(RevSeiFrame r8) {
        super(0, r8, RevSeiFrame.class, "parseAppdataTimestamp", "parseAppdataTimestamp()Ljava/lang/Long;", 0);
    }

    public final Long invoke() {
        RevSeiFrame r0 = (RevSeiFrame) ((CallableReference) this).receiver;
        Lazy r1 = RevSeiFrame.D;
        r0.getClass();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        int r4 = r0.c();     // Catch: Throwable -> L8
        if (r4 >= 0) goto L6;
        long r3 = -1L;     // Catch: Throwable -> L8
    L14:
        return r3;
    L6:
        int r5 = StringsKt.indexOf$default(r0.C, "timestamp", r4, false, 4, null);     // Catch: Throwable -> L8
        r3 = RevSeiFrame.q(r0.C, r5);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Object r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == false) goto L17;
        r7 = null;
    L17:
        return (Long) r7;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m370invoke() {
        return invoke();
    }
}
