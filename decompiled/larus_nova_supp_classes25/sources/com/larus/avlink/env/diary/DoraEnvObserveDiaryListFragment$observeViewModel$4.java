package com.larus.avlink.env.diary;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.env.diary.DoraEnvObserveDiaryListFragment$observeViewModel$4", f = "DoraEnvObserveDiaryListFragment.kt", i = {}, l = {267}, m = "invokeSuspend", n = {}, s = {})
final class DoraEnvObserveDiaryListFragment$observeViewModel$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraEnvObserveDiaryListFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DoraEnvObserveDiaryListFragment a;

        public a(DoraEnvObserveDiaryListFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r13, Continuation r14) {
            List r15 = (List) r13;
            FLogger.a.i(this.a.i, "deletedIds changed: " + CollectionsKt.joinToString$default(r15, ",", null, null, 0, null, null, 62, null));
            if (r15.isEmpty() == true) goto L25;
            DoraEnvObserveDiaryAdapter r16 = this.a.h;
            DoraEnvObserveDiaryAdapter r0 = null;
            if (r16 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            r16 = null;
        L8:
            List r17 = r16.getCurrentList();
            ArrayList r2 = new ArrayList();
            Iterator<T> r18 = r17.iterator();
        L10:
            if (r18.hasNext() == false) goto L14;
            T r3 = r18.next();
            if ((!CollectionsKt.contains(r15, ((l98.a) r3).e())) == false) goto L10;
            r2.add(r3);
            goto L10
        L14:
            DoraEnvObserveDiaryAdapter r19 = this.a.h;
            if (r19 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        L18:
            r0.submitList(r2);
            this.a.W90(r2);
            return Unit.INSTANCE;
        L17:
            r0 = r19;
            goto L18
        L25:
            return Unit.INSTANCE;
        }
    }

    public DoraEnvObserveDiaryListFragment$observeViewModel$4(DoraEnvObserveDiaryListFragment r1, Continuation<? super DoraEnvObserveDiaryListFragment$observeViewModel$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraEnvObserveDiaryListFragment$observeViewModel$4(this.this$0, r3);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        DoraEnvObserveDiaryListFragment r6 = this.this$0;
        int r2 = DoraEnvObserveDiaryListFragment.k;
        d1<List<String>> r7 = r6.V90().getDeletedIds();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
