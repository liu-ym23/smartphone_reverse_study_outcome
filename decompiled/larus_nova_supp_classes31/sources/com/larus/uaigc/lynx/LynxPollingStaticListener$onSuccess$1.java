package com.larus.uaigc.lynx;

import com.larus.platform.api.IXBridgeEventSender;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.lynx.LynxPollingStaticListener$onSuccess$1", f = "LynxPollingStaticListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LynxPollingStaticListener$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ s09.a $result;
    private /* synthetic */ Object L$0;
    int label;

    public LynxPollingStaticListener$onSuccess$1(s09.a r1, Continuation<? super LynxPollingStaticListener$onSuccess$1> r2) {
        this.$result = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        LynxPollingStaticListener$onSuccess$1 r0 = new LynxPollingStaticListener$onSuccess$1(this.$result, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        s09.a r10 = this.$result;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L32
        Map r1 = r10.a;     // Catch: Throwable -> L32
        if (r1 == null) goto L9;
        Map r2 = MapsKt.toMap(r1);     // Catch: Throwable -> L32
        if (r2 == null) goto L9;
    L10:
        Long r11 = r10.b;     // Catch: Throwable -> L32
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L32
        boolean r4 = true;
        if (r11 != null) goto L14;
        long r5 = 0;
        boolean r12 = true;
    L40:
        Object r6 = Result.constructor-impl(LynxPollingStaticListener.b.toJson(r2));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r6) == false) goto L22;
        r6 = "{}";
    L22:
        Pair[] r7 = new Pair[3];     // Catch: Throwable -> L32
        r7[0] = TuplesKt.to("data", (String) r6);     // Catch: Throwable -> L32
        r7[1] = TuplesKt.to("serverTimestampOffset", Boxing.boxLong(r5));     // Catch: Throwable -> L32
        if (r12 == true) goto L26;
        r4 = false;
    L26:
        r7[2] = TuplesKt.to("serverTimeEmpty", Boxing.boxBoolean(r4));     // Catch: Throwable -> L32
        Map r13 = MapsKt.mapOf(r7);     // Catch: Throwable -> L32
        IXBridgeEventSender r14 = (IXBridgeEventSender) ServiceManager.get().getService(IXBridgeEventSender.class);     // Catch: Throwable -> L32
        if (r14 == null) goto L29;
        r14.sendEvent("onPollingConfigChange", r13);     // Catch: Throwable -> L32
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L32
    L30:
        Result.constructor-impl(r15);     // Catch: Throwable -> L32
    L35:
        return Unit.INSTANCE;
    L29:
        r15 = null;
    L17:
        th = move-exception;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L32
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L32
        goto L20
    L14:
        r5 = r3 - r11.longValue();
        r12 = false;
    L9:
        r2 = MapsKt.emptyMap();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
