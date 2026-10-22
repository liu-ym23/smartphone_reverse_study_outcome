package com.larus.dora.impl.file.record;

import com.larus.dora.impl.file.DoraFileFetchTask;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.record.DoraFileRecorder$addOrUpdateTask$1", f = "DoraFileRecorder.kt", i = {}, l = {33, 37}, m = "invokeSuspend", n = {}, s = {})
public final class DoraFileRecorder$addOrUpdateTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraFileFetchTask $task;
    int label;

    public DoraFileRecorder$addOrUpdateTask$1(DoraFileFetchTask r1, Continuation<? super DoraFileRecorder$addOrUpdateTask$1> r2) {
        this.$task = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraFileRecorder$addOrUpdateTask$1(this.$task, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L37:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r9);
        List r10 = (List) DoraFileRecorder.a.getValue();
        List r2 = r10;
        DoraFileFetchTask r4 = this.$task;
        if ((r2 instanceof Collection) == true) goto L13;
    L15:
        Iterator r5 = r2.iterator();
    L17:
        if (r5.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(((DoraFileFetchTask) r5.next()).getId(), r4.getId()) == false) goto L17;
        boolean r6 = true;
    L22:
        if (r6 == false) goto L33;
        StateFlowImpl r11 = DoraFileRecorder.a;
        DoraFileFetchTask r3 = this.$task;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r8 = r2.iterator();
    L25:
        if (r8.hasNext() == false) goto L30;
        DoraFileFetchTask r12 = (DoraFileFetchTask) r8.next();
        if (Intrinsics.areEqual(r12.getId(), r3.getId()) == false) goto L29;
        r12 = r3;
    L29:
        r7.add(r12);
        goto L25
    L30:
        this.label = 1;
        r11.setValue(r7);
        if (Unit.INSTANCE != r0) goto L37;
        return r0;
    L33:
        StateFlowImpl r13 = DoraFileRecorder.a;
        List r14 = CollectionsKt.plus(r10, this.$task);
        this.label = 2;
        r13.setValue(r14);
        if (Unit.INSTANCE != r0) goto L37;
        return r0;
    L21:
        r6 = false;
        goto L22
    L13:
        if (r2.isEmpty() == false) goto L15;
        goto L15
    }
}
