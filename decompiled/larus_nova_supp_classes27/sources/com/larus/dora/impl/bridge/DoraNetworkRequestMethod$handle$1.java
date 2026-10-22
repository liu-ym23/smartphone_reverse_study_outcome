package com.larus.dora.impl.bridge;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.bridge.DoraNetworkRequestMethod$handle$1", f = "DoraNetworkRequestMethod.kt", i = {}, l = {67, 83}, m = "invokeSuspend", n = {}, s = {})
final class DoraNetworkRequestMethod$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletionBlock<r.d> $callback;
    final /* synthetic */ String $method;
    final /* synthetic */ r.c $params;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ r this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.bridge.DoraNetworkRequestMethod$handle$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.bridge.DoraNetworkRequestMethod$handle$1$1", f = "DoraNetworkRequestMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ r.a $bridgeResult;
        final /* synthetic */ CompletionBlock<r.d> $callback;
        int label;

        public AnonymousClass1(r.a r1, CompletionBlock<r.d> r2, Continuation<? super AnonymousClass1> r3) {
            this.$bridgeResult = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$bridgeResult, this.$callback, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r4);
            r.a r5 = this.$bridgeResult;
            if (r5.a == false) goto L7;
            CompletionBlock.DefaultImpls.onSuccess$default(this.$callback, r5.b, null, 2, null);
        L12:
            return Unit.INSTANCE;
        L7:
            CompletionBlock<r.d> r0 = this.$callback;
            String r1 = r5.c;
            if (r1 != null) goto L10;
            r1 = "unknown error";
        L10:
            r0.onFailure(0, r1, r5.b);
            goto L12
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DoraNetworkRequestMethod$handle$1(r r1, String r2, String r3, r.c r4, CompletionBlock<r.d> r5, Continuation<? super DoraNetworkRequestMethod$handle$1> r6) {
        this.this$0 = r1;
        this.$url = r2;
        this.$method = r3;
        this.$params = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        DoraNetworkRequestMethod$handle$1 r7 = new DoraNetworkRequestMethod$handle$1(this.this$0, this.$url, this.$method, this.$params, this.$callback, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L41:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L24
    L22:
        Object r15 = Result.constructor-impl((r.a) r14);     // Catch: Throwable -> L24
    L26:
        r r2 = this.this$0;
        Throwable r4 = Result.exceptionOrNull-impl(r15);
        if (r4 == null) goto L37;
        FLogger.a.e("DoraNetworkRequestMethod", "dora.base.networkRequest request failed", r4);
        int r16 = r.a.d;
        String r17 = r4.getMessage();
        String r5 = "unknown error";
        if (r17 != null) goto L32;
        r17 = "unknown error";
    L32:
        String r6 = r4.getMessage();
        if (r6 == null) goto L36;
        r5 = r6;
    L36:
        r15 = r.a.C0029a.a(r17, r.c(r2, r5));
    L37:
        MainCoroutineDispatcher r3 = Dispatchers.getMain();
        AnonymousClass1 r7 = new AnonymousClass1((r.a) r15, this.$callback, null);
        this.label = 2;
        if (BuildersKt.withContext(r3, r7, this) != r0) goto L41;
        return r0;
    L11:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        r r8 = this.this$0;
        String r9 = this.$url;
        String r10 = this.$method;
        r.c r110 = this.$params;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L24
        Map<String, Object> r12 = r110.getParams();     // Catch: Throwable -> L24
        Map<String, String> r13 = r110.getHeaders();     // Catch: Throwable -> L24
        if (r13 != null) goto L15;
        r13 = MapsKt.emptyMap();     // Catch: Throwable -> L24
    L15:
        Map<String, String> r20 = r13;
        boolean r111 = Intrinsics.areEqual(r110.getRequireSignature(), Boxing.boxBoolean(true));     // Catch: Throwable -> L24
        Number r112 = r110.getTimeoutMs();     // Catch: Throwable -> L24
        if (r112 == null) goto L18;
        Long r113 = Boxing.boxLong(r112.longValue());     // Catch: Throwable -> L24
    L19:
        this.label = 1;     // Catch: Throwable -> L24
        r14 = r.a(r8, r9, r10, r12, r20, r111, r113, this);     // Catch: Throwable -> L24
        if (r14 != r0) goto L22;
        return r0;
    L18:
        r113 = null;
    L24:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }
}
