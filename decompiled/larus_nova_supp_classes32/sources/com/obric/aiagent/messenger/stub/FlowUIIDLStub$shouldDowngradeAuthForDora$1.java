package com.obric.aiagent.messenger.stub;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.DoraAuthTrustType;
import com.obric.assistant.IDoraAuthTrustService;
import com.obric.assistant.common.utils.FunctionsKt;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.FlowUIIDLStub$shouldDowngradeAuthForDora$1", f = "FlowUIIDLStub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowUIIDLStub$shouldDowngradeAuthForDora$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IDowngradeAuthForDoraCallbackIDL $callback;
    final /* synthetic */ IDoraAuthTrustService $doraAuthTrustService;
    final /* synthetic */ AtomicBoolean $isCallbackInvoked;
    final /* synthetic */ DoraAuthTrustType $originAuthType;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements com.obric.assistant.i {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ IDowngradeAuthForDoraCallbackIDL b;

        @Override // com.obric.assistant.i
        public final void onDowngradeToNoneAuth() {
            if (this.a.compareAndSet(false, true) == false) goto L6;
            FLogger.a.i("FlowUIIDLStub", "shouldDowngradeAuthForDora: onDowngradeToNone");
            final IDowngradeAuthForDoraCallbackIDL r0 = this.b;
            FunctionsKt.a(new f0(r0));
            return;
        }

        @Override // com.obric.assistant.i
        public final void onDowngradeToVoicePrint() {
            if (this.a.compareAndSet(false, true) == false) goto L6;
            FLogger.a.i("FlowUIIDLStub", "shouldDowngradeAuthForDora: onDowngradeToVoicePrint, callback = " + this.b);
            final IDowngradeAuthForDoraCallbackIDL r0 = this.b;
            FunctionsKt.a(new e0(r0));
            return;
        }

        @Override // com.obric.assistant.i
        public final void onNotDowngrade() {
            if (this.a.compareAndSet(false, true) == false) goto L6;
            FLogger.a.i("FlowUIIDLStub", "shouldDowngradeAuthForDora: onNotDowngrade, callback = " + this.b);
            final IDowngradeAuthForDoraCallbackIDL r0 = this.b;
            FunctionsKt.a(new d0(r0));
            return;
        }

        public a(AtomicBoolean r1, IDowngradeAuthForDoraCallbackIDL r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public FlowUIIDLStub$shouldDowngradeAuthForDora$1(IDoraAuthTrustService r1, DoraAuthTrustType r2, AtomicBoolean r3, IDowngradeAuthForDoraCallbackIDL r4, Continuation<? super FlowUIIDLStub$shouldDowngradeAuthForDora$1> r5) {
        this.$doraAuthTrustService = r1;
        this.$originAuthType = r2;
        this.$isCallbackInvoked = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        FlowUIIDLStub$shouldDowngradeAuthForDora$1 r6 = new FlowUIIDLStub$shouldDowngradeAuthForDora$1(this.$doraAuthTrustService, this.$originAuthType, this.$isCallbackInvoked, this.$callback, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        IDoraAuthTrustService r7 = this.$doraAuthTrustService;
        if (r7 == null) goto L7;
        r7.b(this.$originAuthType, new a(this.$isCallbackInvoked, this.$callback));
    L11:
        return Unit.INSTANCE;
    L7:
        AtomicBoolean r8 = this.$isCallbackInvoked;
        final IDowngradeAuthForDoraCallbackIDL r0 = this.$callback;
        if (r8.compareAndSet(false, true) == false) goto L11;
        FLogger.a.i("FlowUIIDLStub", "shouldDowngradeAuthForDora: service is null, invoke onNotDowngrade. callback = " + r0);
        FunctionsKt.a(new c0(r0));
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
