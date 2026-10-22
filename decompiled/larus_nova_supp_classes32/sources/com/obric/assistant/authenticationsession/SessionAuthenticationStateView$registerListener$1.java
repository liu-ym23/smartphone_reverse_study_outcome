package com.obric.assistant.authenticationsession;

import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.ISessionAuthenticationService;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.authenticationsession.SessionAuthenticationStateView$registerListener$1", f = "SessionAuthenticationStateView.kt", i = {}, l = {197, 197}, m = "invokeSuspend", n = {}, s = {})
final class SessionAuthenticationStateView$registerListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ SessionAuthenticationStateView this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ SessionAuthenticationStateView a;

        public a(SessionAuthenticationStateView r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            Pair r3 = (Pair) r1;
            SessionAuthenticationStateView r4 = this.a;
            int r5 = SessionAuthenticationStateView.t;
            r4.h();
            return Unit.INSTANCE;
        }
    }

    public SessionAuthenticationStateView$registerListener$1(SessionAuthenticationStateView r1, Continuation<? super SessionAuthenticationStateView$registerListener$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SessionAuthenticationStateView$registerListener$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L7;
        ResultKt.throwOnFailure(r8);
    L19:
        throw new KotlinNothingValueException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        SessionAuthenticationStateView r2 = (SessionAuthenticationStateView) this.L$0;
        ResultKt.throwOnFailure(r8);
    L15:
        a r3 = new a(r2);
        this.L$0 = null;
        this.label = 2;
        if (((i1) r8).collect(r3, this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        ISessionAuthenticationService r9 = SessionAuthenticationStateView.d(this.this$0);
        if (r9 == null) goto L21;
        r2 = this.this$0;
        final Flow[] r4 = {r9.o(), r9.k()};
        Flow<Pair<? extends Boolean, ? extends Boolean>> r10 = new SessionAuthenticationStateView$registerListener$1$invokeSuspend$lambda$1$$inlined$combine$1(r4);
        CoroutineScope r5 = r2.c;
        this.L$0 = r2;
        this.label = 1;
        r8 = kotlinx.coroutines.flow.e.E(r10, r5, this);
        if (r8 != r0) goto L15;
        return r0;
    L21:
        return Unit.INSTANCE;
    }
}
