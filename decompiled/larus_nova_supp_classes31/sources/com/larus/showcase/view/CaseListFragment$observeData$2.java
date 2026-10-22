package com.larus.showcase.view;

import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.utils.LoadMoreManager;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.showcase.view.CaseListFragment$observeData$2", f = "CaseListFragment.kt", i = {}, l = {294}, m = "invokeSuspend", n = {}, s = {})
final class CaseListFragment$observeData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CaseListFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CaseListFragment a;

        public a(CaseListFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            int r4 = ((Number) r2).intValue();
            if (this.a.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L5;
            FLogger.a.e(this.a.d, "[observeData], return with lifecycle scope");
            return Unit.INSTANCE;
        L5:
            if (r4 != 0) goto L7;
            FLogger.a.i(this.a.d, "[observeData], loadMoreState=HAS_MORE");
            LoadMoreManager r5 = this.a.f;
            if (r5 == null) goto L21;
            r5.c();
        L21:
            return Unit.INSTANCE;
        L7:
            if (r4 != 1) goto L9;
            FLogger.a.i(this.a.d, "[observeData], loadMoreState=FAIL");
            LoadMoreManager r6 = this.a.f;
            if (r6 == null) goto L21;
            r6.b();
            goto L21
        L9:
            if (r4 != 2) goto L21;
            FLogger.a.i(this.a.d, "[observeData], loadMoreState=END");
            LoadMoreManager r7 = this.a.f;
            if (r7 == null) goto L21;
            r7.a();
            goto L21
        }
    }

    public CaseListFragment$observeData$2(CaseListFragment r1, Continuation<? super CaseListFragment$observeData$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CaseListFragment$observeData$2(this.this$0, r3);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CaseViewModel r6 = this.this$0.g;
        if (r6 == null) goto L18;
        MutableSharedFlow<Integer> r7 = r6.getLoadMoreState();
        if (r7 == null) goto L18;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
