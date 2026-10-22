package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.android.livesdk.model.n0;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$canvasWHRatio$2 extends FunctionReferenceImpl implements Function0<Float> {
    public RevSeiFrame$canvasWHRatio$2(RevSeiFrame r8) {
        super(0, r8, RevSeiFrame.class, "parseCanvasWHRatio", "parseCanvasWHRatio()F", 0);
    }

    public final float invoke() {
        RevSeiFrame r0 = (RevSeiFrame) ((CallableReference) this).receiver;
        Lazy r1 = RevSeiFrame.D;
        r0.getClass();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        n0 r3 = r0.g();     // Catch: Throwable -> L11
        if (r3 != null) goto L8;
        Pair r4 = (Pair) r0.q.getValue();     // Catch: Throwable -> L11
        if (r4 != null) goto L9;
        r4 = TuplesKt.to(1, 1);     // Catch: Throwable -> L11
    L9:
        return (((Number) r4.component1()).intValue() * 1.0f) / ((Number) r4.component2()).intValue();
    L8:
        r4 = TuplesKt.to(Integer.valueOf(r3.f()), Integer.valueOf(r3.e()));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        Float r7 = Float.valueOf(1.0f);
        if (Result.isFailure-impl(r6) == false) goto L16;
        r6 = r7;
    L16:
        return ((Number) r6).floatValue();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m373invoke() {
        return Float.valueOf(invoke());
    }
}
