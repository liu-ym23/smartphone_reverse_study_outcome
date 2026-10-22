package com.larus.showcase.view;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.showcase.impl.databinding.LarusFragmentCaseListBinding;
import com.larus.showcase.impl.databinding.LarusPageCaseErrorBinding;
import com.larus.showcase.impl.databinding.LarusPageCaseLoadingSkeletonBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.larus.showcase.view.CaseListFragment$observeData$1", f = "CaseListFragment.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
final class CaseListFragment$observeData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CaseListFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CaseListFragment a;

        public a(CaseListFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            final g r6 = (g) r4;
            int r7 = r6.a;
            if (r7 != 1) goto L5;
            FLogger.a.i(this.a.d, "[observeData], query list FAIL");
            LarusFragmentCaseListBinding r8 = this.a.e;
            if (r8 == null) goto L62;
            LarusPageCaseLoadingSkeletonBinding r9 = r8.e;
            if (r9 == null) goto L62;
            ConstraintLayout r10 = r9.a;
            if (r10 == null) goto L62;
            e1.o(r10);
        L62:
            LarusFragmentCaseListBinding r11 = this.a.e;
            if (r11 == null) goto L67;
            RecyclerView r12 = r11.d;
            if (r12 == null) goto L67;
            e1.o(r12);
        L67:
            LarusFragmentCaseListBinding r13 = this.a.e;
            if (r13 == null) goto L74;
            LarusPageCaseErrorBinding r14 = r13.c;
            if (r14 == null) goto L74;
            ConstraintLayout r15 = r14.a;
            if (r15 == null) goto L74;
            e1.x(r15);
        L74:
            final CaseListFragment r16 = this.a;
            LarusFragmentCaseListBinding r17 = r16.e;
            if (r17 == null) goto L82;
            LarusPageCaseErrorBinding r18 = r17.c;
            if (r18 == null) goto L82;
            ConstraintLayout r19 = r18.a;
            if (r19 == null) goto L82;
            r19.setOnClickListener(new d(r16));
        L82:
            return Unit.INSTANCE;
        L5:
            if (r7 != 3) goto L7;
            FLogger r20 = FLogger.a;
            r20.i(this.a.d, "[observeData], query list SUCCESS");
            CaseListFragment r0 = this.a;
            r0.getClass();
            r20.i(r0.d, "resetReloadStatue");
            LarusFragmentCaseListBinding r1 = this.a.e;
            if (r1 == null) goto L30;
            LarusPageCaseLoadingSkeletonBinding r2 = r1.e;
            if (r2 == null) goto L30;
            ConstraintLayout r3 = r2.a;
            if (r3 == null) goto L30;
            e1.o(r3);
        L30:
            LarusFragmentCaseListBinding r21 = this.a.e;
            if (r21 == null) goto L38;
            LarusPageCaseErrorBinding r22 = r21.c;
            if (r22 == null) goto L38;
            ConstraintLayout r23 = r22.a;
            if (r23 == null) goto L38;
            e1.o(r23);
        L38:
            if (r6.b.isEmpty() == false) goto L47;
            r20.i(this.a.d, "[observeData], collection list is empty");
            CaseListAdapter r24 = this.a.S90();
            if (r24 == null) goto L42;
            r24.submitList(CollectionsKt.emptyList());
        L42:
            LarusFragmentCaseListBinding r25 = this.a.e;
            if (r25 == null) goto L82;
            RecyclerView r26 = r25.d;
            if (r26 == null) goto L82;
            e1.o(r26);
            goto L82
        L47:
            r20.i(this.a.d, "[observeData], collection list size is " + r6.b.size());
            LarusFragmentCaseListBinding r27 = this.a.e;
            if (r27 == null) goto L52;
            RecyclerView r28 = r27.d;
            if (r28 == null) goto L52;
            e1.x(r28);
        L52:
            CaseListAdapter r29 = this.a.S90();
            if (r29 == null) goto L82;
            List r30 = CollectionsKt.toMutableList(r6.b);
            final CaseListFragment r31 = this.a;
            r29.submitList(r30, new e(r6, r31));
            goto L82
        L7:
            if (r7 != 4) goto L82;
            FLogger.a.i(this.a.d, "[observeData], query list LOADING");
            LarusFragmentCaseListBinding r32 = this.a.e;
            if (r32 == null) goto L16;
            LarusPageCaseLoadingSkeletonBinding r33 = r32.e;
            if (r33 == null) goto L16;
            ConstraintLayout r34 = r33.a;
            if (r34 == null) goto L16;
            e1.x(r34);
        L16:
            LarusFragmentCaseListBinding r35 = this.a.e;
            if (r35 == null) goto L82;
            LarusPageCaseErrorBinding r36 = r35.c;
            if (r36 == null) goto L82;
            ConstraintLayout r37 = r36.a;
            if (r37 == null) goto L82;
            e1.o(r37);
            goto L82
        }
    }

    public CaseListFragment$observeData$1(CaseListFragment r1, Continuation<? super CaseListFragment$observeData$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CaseListFragment$observeData$1(this.this$0, r3);
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
        MutableSharedFlow<g> r7 = r6.getCaseListLiveData();
        if (r7 == null) goto L18;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
