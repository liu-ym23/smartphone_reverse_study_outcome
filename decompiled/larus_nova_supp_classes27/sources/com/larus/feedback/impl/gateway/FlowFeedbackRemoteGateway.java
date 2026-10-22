package com.larus.feedback.impl.gateway;

import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import q99.c;
import q99.j;
import q99.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class FlowFeedbackRemoteGateway implements n99.a {
    public final CoroutineScope a;

    public static final class a {
    }

    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public final void handleException(CoroutineContext r1, Throwable r2) {
        }

        public b(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }
    }

    static {
    }

    public FlowFeedbackRemoteGateway() {
        this.a = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new b(CoroutineExceptionHandler.Key)));
    }

    @Override // n99.a
    public final void c(j r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        BuildersKt.launch$default(this.a, null, null, new FlowFeedbackRemoteGateway$markNotificationShown$1(r8, null), 3, null);
    }

    @Override // n99.a
    public final void a(c r8, p99.a r9) {
        Intrinsics.checkNotNullParameter(r8, "request");
        Intrinsics.checkNotNullParameter(r9, "callback");
        BuildersKt.launch$default(this.a, null, null, new FlowFeedbackRemoteGateway$queryFeedbackContent$1(r8, r9, null), 3, null);
    }

    @Override // n99.a
    public final void b(k r8, Function1<? super dm9.a<Unit>, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "request");
        BuildersKt.launch$default(this.a, null, null, new FlowFeedbackRemoteGateway$submitFeedback$1(r8, r9, null), 3, null);
    }
}
