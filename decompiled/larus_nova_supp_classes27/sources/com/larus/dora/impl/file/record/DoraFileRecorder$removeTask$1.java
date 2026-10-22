package com.larus.dora.impl.file.record;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.file.DoraFileFetchTask;
import com.larus.dora.impl.file.DoraFileTaskStatus;
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
@DebugMetadata(c = "com.larus.dora.impl.file.record.DoraFileRecorder$removeTask$1", f = "DoraFileRecorder.kt", i = {}, l = {46, 56}, m = "invokeSuspend", n = {}, s = {})
public final class DoraFileRecorder$removeTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraFileFetchTask $task;
    int label;

    public DoraFileRecorder$removeTask$1(DoraFileFetchTask r1, Continuation<? super DoraFileRecorder$removeTask$1> r2) {
        this.$task = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraFileRecorder$removeTask$1(this.$task, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r210) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r210);
    L26:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r210);
    L19:
        StateFlowImpl r3 = DoraFileRecorder.b;
        List r5 = CollectionsKt.toMutableList((Collection) r3.getValue());
        final DoraFileFetchTask r6 = this.$task;
        CollectionsKt.removeAll(r5, new c(r6));
        ListProtector.add(r5, 0, DoraFileFetchTask.copy$default(this.$task, null, null, null, null, null, DoraFileTaskStatus.DONE, null, null, null, null, null, null, null, null, null, null, null, 131039, null));
        if (r5.size() <= 50) goto L22;
        ListProtector.remove(r5, r5.size() - 1);
    L22:
        this.label = 2;
        r3.setValue(r5);
        if (Unit.INSTANCE != r1) goto L26;
        return r1;
    L10:
        ResultKt.throwOnFailure(r210);
        Iterable r4 = (Iterable) DoraFileRecorder.a.getValue();
        DoraFileFetchTask r7 = this.$task;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r4.iterator();
    L12:
        if (r9.hasNext() == false) goto L16;
        Object r10 = r9.next();
        if (Intrinsics.areEqual(((DoraFileFetchTask) r10).getFileName(), r7.getFileName()) == true) goto L12;
        r8.add(r10);
        goto L12
    L16:
        StateFlowImpl r11 = DoraFileRecorder.a;
        this.label = 1;
        r11.setValue(r8);
        if (Unit.INSTANCE != r1) goto L19;
        return r1;
    }
}
