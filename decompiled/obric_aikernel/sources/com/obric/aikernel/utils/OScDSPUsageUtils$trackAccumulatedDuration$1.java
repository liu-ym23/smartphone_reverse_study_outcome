package com.obric.aikernel.utils;

import android.os.SystemClock;
import android.util.Log;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import java.util.Arrays;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.utils.OScDSPUsageUtils$trackAccumulatedDuration$1", f = "OScDSPUsageUtils.kt", i = {0, 0}, l = {78}, m = "invokeSuspend", n = {"windowStartTime", "cdspStart"}, s = {"J$0", "J$1"})
final class OScDSPUsageUtils$trackAccumulatedDuration$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    long J$0;
    long J$1;
    int label;

    OScDSPUsageUtils$trackAccumulatedDuration$1(Continuation<? super OScDSPUsageUtils$trackAccumulatedDuration$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new OScDSPUsageUtils$trackAccumulatedDuration$1(r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((OScDSPUsageUtils$trackAccumulatedDuration$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        long r12 = this.J$1;
        long r13 = this.J$0;
        ResultKt.throwOnFailure(r15);
    L12:
        long r14 = SystemClock.elapsedRealtime();
        long r16 = OScDSPUsageUtils.c(OScDSPUsageUtils.f5582a);
        long r17 = r14 - r13;
        long r18 = r16 - r12;
        if (r12 > 0) goto L15;
    L27:
        Log.w("OScDSPUsageUtils", "Invalid diff:cdspStart=" + r12 + " osDiff=" + r17 + ", cdspDiff=" + r18);
    L26:
        return Unit.INSTANCE;
    L15:
        if (r17 <= 0) goto L27;
        if (r18 < 0) goto L27;
        float r19 = (r18 * 100) / r17;
        StringCompanionObject r20 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L22
        String r21 = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Boxing.boxFloat(r19)}, 1));     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r21, "format(locale, format, *args)");     // Catch: Exception -> L22
        float r22 = Float.parseFloat(r21);     // Catch: Exception -> L22
    L24:
        JSONObject r23 = new JSONObject();
        r23.put("cdsp_start", r12);
        r23.put("cdsp_end", r16);
        r23.put("cdsp_diff", r18);
        r23.put("os_diff", r17);
        r23.put("percent", Boxing.boxFloat(r22));
        TrackerApi.INSTANCE.onEvent("cdsp_usage_track", r23);
        Log.d("OScDSPUsageUtils", "cdsp sleep time: " + r18 + " ms, os elapsed time" + r17 + " ms, percent: " + r22 + '%');
    L22:
        e = move-exception;
        Log.w("OScDSPUsageUtils", "Format percent failed: " + r19, e);
        r22 = 0.0f;
        goto L24
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        r13 = SystemClock.elapsedRealtime();
        long r24 = OScDSPUsageUtils.c(OScDSPUsageUtils.f5582a);
        this.J$0 = r13;
        this.J$1 = r24;
        this.label = 1;
        if (DelayKt.b(5000, this) != r10) goto L11;
        return r10;
    L11:
        r12 = r24;
        goto L12
    }
}
