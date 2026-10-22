package com.obric.assistant.view.listening;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.view.listening.ObricListeningViewController$setAudioData$1$1", f = "ObricListeningViewController.kt", i = {}, l = {213}, m = "invokeSuspend", n = {}, s = {})
final class ObricListeningViewController$setAudioData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ b $target;
    int label;
    final /* synthetic */ f this$0;

    public ObricListeningViewController$setAudioData$1$1(byte[] r1, f r2, b r3, Continuation<? super ObricListeningViewController$setAudioData$1$1> r4) {
        this.$data = r1;
        this.this$0 = r2;
        this.$target = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricListeningViewController$setAudioData$1$1(this.$data, this.this$0, this.$target, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        ArrayList<Double> r7 = (ArrayList) r6;
        Iterator r2 = r7.iterator();
        if (r2.hasNext() == true) goto L14;
        Double r3 = null;
    L19:
        if (r3 == null) goto L21;
        double r4 = r3.doubleValue();
    L22:
        f r5 = this.this$0;
        b r8 = this.$target;
        AtomicLong r9 = f.l;
        if (r5.e(r8, r4) == true) goto L26;
        this.this$0.c.b(r7);
    L26:
        return Unit.INSTANCE;
    L21:
        r4 = 0.0d;
        goto L22
    L14:
        double r10 = Math.abs(((Number) r2.next()).doubleValue());
    L16:
        if (r2.hasNext() == false) goto L18;
        r10 = Math.max(r10, Math.abs(((Number) r2.next()).doubleValue()));
        goto L16
    L18:
        r3 = Boxing.boxDouble(r10);
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        int r11 = com.larus.common_ui.widget.input.a.a;
        byte[] r12 = this.$data;
        this.label = 1;
        r6 = com.larus.common_ui.widget.input.a.a(r12, 45, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
