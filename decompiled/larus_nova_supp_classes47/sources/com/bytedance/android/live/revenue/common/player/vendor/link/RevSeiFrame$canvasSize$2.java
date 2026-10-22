package com.bytedance.android.live.revenue.common.player.vendor.link;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$canvasSize$2 extends FunctionReferenceImpl implements Function0<Pair<? extends Integer, ? extends Integer>> {
    public RevSeiFrame$canvasSize$2(RevSeiFrame r8) {
        super(0, r8, RevSeiFrame.class, "parseCanvasSize", "parseCanvasSize()Lkotlin/Pair;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final Pair<Integer, Integer> m371invoke() {
        RevSeiFrame r0 = (RevSeiFrame) ((CallableReference) this).receiver;
        Lazy r1 = RevSeiFrame.D;
        r0.getClass();
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r4 = r0.d();     // Catch: Throwable -> L9
        if (r4 == null) goto L18;
        String r5 = r4.optString("canvas");     // Catch: Throwable -> L9
        if (r5 == null) goto L19;
        JSONObject r6 = new JSONObject(r5);     // Catch: Throwable -> L9
        return TuplesKt.to(Integer.valueOf(r6.optInt("width")), Integer.valueOf(r6.optInt("height")));
    L19:
        return null;
    L18:
        return null;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Object r8 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r8) == true) goto L15;
        r2 = r8;
    L15:
        return (Pair) r2;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m371invoke();
    }
}
