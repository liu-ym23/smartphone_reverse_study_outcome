package com.larus.dora.impl.feedback;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isReady", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraFeedbackImageGroup$setupStateLogging$1", f = "DoraGFeedbackViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraFeedbackImageGroup$setupStateLogging$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ h this$0;

    public DoraFeedbackImageGroup$setupStateLogging$1(h r1, Continuation<? super DoraFeedbackImageGroup$setupStateLogging$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DoraFeedbackImageGroup$setupStateLogging$1 r0 = new DoraFeedbackImageGroup$setupStateLogging$1(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r7);
        boolean r8 = this.Z$0;
        List r0 = (List) this.this$0.b.getValue();
        pk4.j.a("DoraGFeedbackViewModel", "Image group readiness changed - Ready: " + r8);
        StringBuilder r9 = new StringBuilder("Current image count: ");
        r9.append(r0.size());
        r9.append(", Ready images: ");
        this.this$0.getClass();
        List r1 = r0;
        int r3 = 0;
        if ((r1 instanceof Collection) == true) goto L7;
    L9:
        Iterator r2 = r1.iterator();
        int r4 = 0;
    L11:
        if (r2.hasNext() == false) goto L20;
        if (((g) r2.next()).e.getValue() != ImageState.READY) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L11;
        r4 = r4 + 1;
        if (r4 >= 0) goto L11;
        CollectionsKt.throwCountOverflow();
        goto L11
    L15:
        r5 = false;
        goto L16
    L20:
        r3 = r4;
    L21:
        r9.append(r3);
        pk4.j.a("DoraGFeedbackViewModel", r9.toString());
        return Unit.INSTANCE;
    L7:
        if (r1.isEmpty() == false) goto L9;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
