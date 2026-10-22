package com.larus.contextwindow.impl.routing;

import com.larus.contextwindow.api.ContextWindowEntryRequest;
import com.larus.contextwindow.api.ContextWindowHiddenReason;
import com.larus.contextwindow.api.ContextWindowSnapshot;
import com.larus.contextwindow.api.a$b;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.contextwindow.impl.routing.ContextWindowUsageHostActivity$handleIntent$1", f = "ContextWindowUsageHostActivity.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
public final class ContextWindowUsageHostActivity$handleIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ContextWindowSnapshot $prefetchedSnapshot;
    final /* synthetic */ ContextWindowEntryRequest $request;
    int label;
    final /* synthetic */ ContextWindowUsageHostActivity this$0;

    public ContextWindowUsageHostActivity$handleIntent$1(ContextWindowSnapshot r1, ContextWindowUsageHostActivity r2, ContextWindowEntryRequest r3, Continuation<? super ContextWindowUsageHostActivity$handleIntent$1> r4) {
        this.$prefetchedSnapshot = r1;
        this.this$0 = r2;
        this.$request = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ContextWindowUsageHostActivity$handleIntent$1(this.$prefetchedSnapshot, this.this$0, this.$request, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r7v4, types: [android.app.Activity, com.larus.contextwindow.impl.routing.ContextWindowUsageHostActivity] */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L14:
        com.larus.contextwindow.api.a.a r2 = (com.larus.contextwindow.api.a) r7;
    L15:
        ?? r8 = this.this$0;
        r8.i = false;
        if (r8.isFinishing() == true) goto L33;
        if (this.this$0.isDestroyed() == true) goto L33;
        if ((r2 instanceof a$b) == false) goto L26;
        ContextWindowUsageHostActivity r9 = this.this$0;
        com.larus.contextwindow.impl.service.a r3 = com.larus.contextwindow.impl.service.a.a;
        ContextWindowEntryRequest r4 = this.$request;
        ContextWindowSnapshot r5 = ((a$b) r2).a;
        r3.getClass();
        r9.j = com.larus.contextwindow.impl.service.a.d(r9, r4, r5);
        ContextWindowUsageHostActivity r10 = this.this$0;
        if (r10.j == true) goto L29;
        r10.N1(ContextWindowHiddenReason.SERVICE_UNAVAILABLE, this.$request.d);
    L29:
        return Unit.INSTANCE;
    L26:
        if ((r2 instanceof com.larus.contextwindow.api.a.a) == false) goto L31;
        this.this$0.N1(r2.a, this.$request.d);
        goto L29
    L31:
        throw new NoWhenBranchMatchedException();
    L33:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        ContextWindowSnapshot r11 = this.$prefetchedSnapshot;
        if (r11 == null) goto L11;
        r2 = new a$b(r11);
        goto L15
    L11:
        CoroutineDispatcher r12 = Dispatchers.getIO();
        ContextWindowUsageHostActivity$handleIntent$1$decision$2 r6 = new ContextWindowUsageHostActivity$handleIntent$1$decision$2(this.this$0, this.$request, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r12, r6, this);
        if (r7 != r0) goto L14;
        return r0;
    }
}
