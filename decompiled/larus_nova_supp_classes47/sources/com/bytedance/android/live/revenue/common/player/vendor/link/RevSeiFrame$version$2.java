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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$version$2 extends FunctionReferenceImpl implements Function0<Integer> {
    public RevSeiFrame$version$2(RevSeiFrame r8) {
        super(0, r8, RevSeiFrame.class, "parseVersionByString", "parseVersionByString()Ljava/lang/Integer;", 0);
    }

    public final Integer invoke() {
        RevSeiFrame r0 = (RevSeiFrame) ((CallableReference) this).receiver;
        Lazy r1 = RevSeiFrame.D;
        r0.getClass();
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        int r5 = r0.c();     // Catch: Throwable -> L13
        if (r5 < 0) goto L22;
        int r4 = StringsKt.indexOf$default(r0.C, "ver", r5, false, 4, null);     // Catch: Throwable -> L13
        if (r4 < 0) goto L23;
        Long r6 = RevSeiFrame.q(r0.C, r4);     // Catch: Throwable -> L13
        if (r6 == null) goto L24;
        return Integer.valueOf((int) r6.longValue());
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L13:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Object r8 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r8) == true) goto L19;
        r2 = r8;
    L19:
        return (Integer) r2;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m392invoke() {
        return invoke();
    }
}
