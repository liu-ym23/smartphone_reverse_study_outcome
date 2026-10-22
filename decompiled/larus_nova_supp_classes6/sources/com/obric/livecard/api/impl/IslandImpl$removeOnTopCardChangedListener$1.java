package com.obric.livecard.api.impl;

import com.obric.livecard.api.IIslandService;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$removeOnTopCardChangedListener$1", f = "IslandImpl.kt", i = {0}, l = {133}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
public final class IslandImpl$removeOnTopCardChangedListener$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ OnTopCardChangedListener $callback;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ IslandImpl this$0;

    public IslandImpl$removeOnTopCardChangedListener$1(IslandImpl r1, OnTopCardChangedListener r2, Continuation<? super IslandImpl$removeOnTopCardChangedListener$1> r3) {
        this.this$0 = r1;
        this.$callback = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new IslandImpl$removeOnTopCardChangedListener$1(this.this$0, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        TopSessionChangedCallbackImpl r2 = (TopSessionChangedCallbackImpl) this.L$1;
        IslandImpl r3 = (IslandImpl) this.L$0;
        ResultKt.throwOnFailure(r6);
    L21:
        IIslandService r7 = (IIslandService) r6;
        if (r7 == null) goto L24;
        r7.removeOnTopCardChangedListener(r2);
    L24:
        IslandImpl.access$getLiveCardServiceDiedListeners$p(r3).remove(r2);
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CopyOnWriteArrayList r8 = IslandImpl.access$getLiveCardServiceDiedListeners$p(this.this$0);
        OnTopCardChangedListener r4 = this.$callback;
        Iterator r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L14;
        Object r5 = r9.next();
        if (Intrinsics.areEqual(((TopSessionChangedCallbackImpl) r5).getDelegate(), r4) == false) goto L10;
    L15:
        TopSessionChangedCallbackImpl r10 = (TopSessionChangedCallbackImpl) r5;
        if (r10 == null) goto L26;
        r3 = this.this$0;
        this.L$0 = r3;
        this.L$1 = r10;
        this.label = 1;
        Object r11 = r3.getService(this);
        if (r11 != r0) goto L20;
        return r0;
    L20:
        r2 = r10;
        r6 = r11;
        goto L21
    L14:
        r5 = null;
        goto L15
    }
}
