package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.android.livesdk.model.n0;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
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
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$canvasWHRadioForScreenRecord$2 extends FunctionReferenceImpl implements Function0<Float> {
    public RevSeiFrame$canvasWHRadioForScreenRecord$2(RevSeiFrame r8) {
        super(0, r8, RevSeiFrame.class, "parseCanvasWHRatioForScreenRecord", "parseCanvasWHRatioForScreenRecord()F", 0);
    }

    public final float invoke() {
        RevSeiFrame r0 = (RevSeiFrame) ((CallableReference) this).receiver;
        Lazy r1 = RevSeiFrame.D;
        r0.getClass();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L39
        n0 r3 = r0.g();     // Catch: Throwable -> L39
        if (r3 != null) goto L8;
        Pair r4 = (Pair) r0.q.getValue();     // Catch: Throwable -> L39
        if (r4 != null) goto L9;
        r4 = TuplesKt.to(1, 1);     // Catch: Throwable -> L39
    L9:
        int r5 = ((Number) r4.component1()).intValue();     // Catch: Throwable -> L39
        int r6 = ((Number) r4.component2()).intValue();     // Catch: Throwable -> L39
        JSONObject r7 = r0.d();     // Catch: Throwable -> L39
        String r8 = "";
        if (r7 == null) goto L16;
        Object r9 = r7.get("game_clip");     // Catch: Throwable -> L39
        if (r9 == null) goto L16;
        String r10 = r9.toString();     // Catch: Throwable -> L39
        if (r10 == null) goto L16;
    L17:
        Object r12 = new JSONObject(r10).get("w");     // Catch: Throwable -> L39
        if (r12 == null) goto L22;
        String r13 = r12.toString();     // Catch: Throwable -> L39
        if (r13 == null) goto L22;
        float r14 = CastFloatProtector.parseFloat(r13);     // Catch: Throwable -> L39
    L23:
        JSONObject r15 = r0.d();     // Catch: Throwable -> L39
        if (r15 == null) goto L31;
        Object r16 = r15.get("game_clip");     // Catch: Throwable -> L39
        if (r16 == null) goto L31;
        String r17 = r16.toString();     // Catch: Throwable -> L39
        if (r17 == null) goto L31;
        r8 = r17;
    L31:
        Object r18 = new JSONObject(r8).get("h");     // Catch: Throwable -> L39
        if (r18 == null) goto L37;
        String r19 = r18.toString();     // Catch: Throwable -> L39
        if (r19 == null) goto L37;
        float r20 = CastFloatProtector.parseFloat(r19);     // Catch: Throwable -> L39
    L47:
        return ((r5 * r14) * 1.0f) / (r6 * r20);
    L37:
        r20 = 1.0f;
    L22:
        r14 = 1.0f;
    L16:
        r10 = "";
        goto L17
    L8:
        r4 = TuplesKt.to(Integer.valueOf(r3.f()), Integer.valueOf(r3.e()));     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Object r23 = Result.constructor-impl(ResultKt.createFailure(th));
        Float r24 = Float.valueOf(1.0f);
        if (Result.isFailure-impl(r23) == false) goto L44;
        r23 = r24;
    L44:
        return ((Number) r23).floatValue();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m372invoke() {
        return Float.valueOf(invoke());
    }
}
