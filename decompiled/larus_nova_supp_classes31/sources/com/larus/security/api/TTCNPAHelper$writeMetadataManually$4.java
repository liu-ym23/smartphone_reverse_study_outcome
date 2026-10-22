package com.larus.security.api;

import com.bytedance.ttcnpa.TTCNPA;
import com.bytedance.ttcnpa.TtCnpaManifest;
import com.bytedance.ttcnpa.TtCnpaResult;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/security/api/TtCnpaManualWriteResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.security.api.TTCNPAHelper$writeMetadataManually$4", f = "TTCNPAHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TTCNPAHelper$writeMetadataManually$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super n>, Object> {
    final /* synthetic */ m $params;
    private /* synthetic */ Object L$0;
    int label;

    public TTCNPAHelper$writeMetadataManually$4(m r1, Continuation<? super TTCNPAHelper$writeMetadataManually$4> r2) {
        this.$params = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        TTCNPAHelper$writeMetadataManually$4 r0 = new TTCNPAHelper$writeMetadataManually$4(this.$params, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super n> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r12);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        m r0 = this.$params;
        TtCnpaManifest r14 = new TtCnpaManifest(r0.c, r0.d, r0.e, r0.f, r0.g, r0.h, r0.i);
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("writeMetadataManually start inputPath=");
        r2.append(this.$params.a);
        r2.append(" outputPath=");
        r2.append(this.$params.b);
        r2.append(" requestManifest=");
        TTCNPAHelper r3 = TTCNPAHelper.a;
        r2.append(TTCNPAHelper.a(r3, TTCNPAHelper.b(r3, r14)));
        r1.i("TTCNPAHelper", r2.toString());
        m r4 = this.$params;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L7
        TTCNPA r6 = TTCNPA.a;     // Catch: Throwable -> L7
        String r7 = r4.a;     // Catch: Throwable -> L7
        String r8 = r4.b;     // Catch: Throwable -> L7
        r6.getClass();     // Catch: Throwable -> L7
        Object r15 = Result.constructor-impl(TTCNPA.f(r7, r8, r14));     // Catch: Throwable -> L7
    L9:
        Throwable r9 = Result.exceptionOrNull-impl(r15);
        if (r9 != null) goto L23;
        TtCnpaResult r16 = (TtCnpaResult) r15;
        TtCnpaManifest r10 = r16.getResultManifest();
        if (r10 == null) goto L14;
        l r11 = TTCNPAHelper.b(TTCNPAHelper.a, r10);
    L15:
        l r17 = r11;
        FLogger r18 = FLogger.a;
        StringBuilder r19 = new StringBuilder("writeMetadataManually result code=");
        r19.append(r16.getErrorCode());
        r19.append(" desc=");
        r19.append(r16.getErrorDesc());
        r19.append(" resultManifest=");
        TTCNPAHelper r20 = TTCNPAHelper.a;
        r19.append(TTCNPAHelper.a(r20, r17));
        r19.append(" rawJson=");
        r19.append(r16.getRawJsonManifest());
        r18.i("TTCNPAHelper", r19.toString());
        if (r16.getErrorCode() != 0) goto L19;
        r18.i("TTCNPAHelper", "writeMetadataManually success metadata=" + TTCNPAHelper.a(r20, r17) + " rawJson=" + r16.getRawJsonManifest());
    L19:
        if (r16.getErrorCode() != 0) goto L21;
        boolean r21 = true;
    L32:
        return new n(r21, r16.getErrorCode(), r16.getErrorDesc(), r17, r16.getRawJsonManifest());
    L21:
        r21 = false;
        goto L32
    L14:
        r11 = null;
        goto L15
    L23:
        FLogger.a.e("TTCNPAHelper", "writeMetadataManually failed", r9);
        String r22 = r9.getMessage();
        if (r22 != null) goto L27;
        r22 = "";
    L27:
        return new n(false, -2, r22, null, null);
    L7:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
