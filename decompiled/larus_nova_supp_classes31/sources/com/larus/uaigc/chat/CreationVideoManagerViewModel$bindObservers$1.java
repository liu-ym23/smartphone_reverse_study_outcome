package com.larus.uaigc.chat;

import com.larus.uaigc.helper.i0;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.CreationVideoManagerViewModel$bindObservers$1", f = "CreationVideoManagerViewModel.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
final class CreationVideoManagerViewModel$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationVideoManagerViewModel this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.chat.CreationVideoManagerViewModel$bindObservers$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public final /* synthetic */ CreationVideoManagerViewModel a;

        public AnonymousClass1(CreationVideoManagerViewModel r1) {
            this.a = r1;
        }

        public final Object a(Unit r6, Continuation<? super Unit> r7) {
            if ((r7 instanceof CreationVideoManagerViewModel$bindObservers$1$1$emit$1) == false) goto L7;
            CreationVideoManagerViewModel$bindObservers$1$1$emit$1 r8 = (CreationVideoManagerViewModel$bindObservers$1$1$emit$1) r7;
            int r0 = r8.label;
            if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
            r8.label = r0 - Integer.MIN_VALUE;
        L8:
            Object r9 = r8.result;
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r8.label;
            if (r2 == 0) goto L16;
            if (r2 != 1) goto L15;
            String r3 = (String) r8.L$1;
            CreationVideoManagerViewModel r10 = (CreationVideoManagerViewModel) r8.L$0;
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L27
        L25:
            r10.d = r3;     // Catch: Throwable -> L27
            Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
        L29:
            Throwable r12 = Result.exceptionOrNull-impl(r11);
            if (r12 == null) goto L33;
            FLogger.a.e("CreationVideoManagerVM", "bindObservers: select auto play video failed", r12);
        L33:
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r9);
            CreationVideoManagerViewModel r13 = this.a;
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L27
            HashMap r5 = new HashMap(r13.b);     // Catch: Throwable -> L27
            if (r5.isEmpty() == false) goto L21;
            FLogger.a.i("CreationVideoManagerVM", "bindObservers collect: curBindMdVideoView 为空，跳过");     // Catch: Throwable -> L27
            return Unit.INSTANCE;
        L21:
            String r14 = CreationVideoManagerViewModel.k(r13, r5);     // Catch: Throwable -> L27
            MutableSharedFlow r15 = (MutableSharedFlow) r13.e.getValue();     // Catch: Throwable -> L27
            r8.L$0 = r13;     // Catch: Throwable -> L27
            r8.L$1 = r14;     // Catch: Throwable -> L27
            r8.label = 1;     // Catch: Throwable -> L27
            if (r15.emit(r14, r8) != r1) goto L24;
            return r1;
        L24:
            r10 = r13;
            r3 = r14;
        L27:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
        L7:
            r8 = new CreationVideoManagerViewModel$bindObservers$1$1$emit$1(this, r7);
            goto L8
        }

        public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return a((Unit) r1, r2);
        }
    }

    public CreationVideoManagerViewModel$bindObservers$1(CreationVideoManagerViewModel r1, Continuation<? super CreationVideoManagerViewModel$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationVideoManagerViewModel$bindObservers$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MutableSharedFlow<Unit> r6 = this.this$0.g;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        FlowKt__EmittersKt$onStart$.inlined.unsafeFlow.1 r7 = new i0(r6).d;
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
