package com.larus.uaigc.chat;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.canvas.service.ICanvasService;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.CreationComponent$bindObservers$2", f = "CreationComponent.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
final class CreationComponent$bindObservers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationComponent a;

        public a(CreationComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            ny8.a r4 = (ny8.a) r2;
            CreationComponent r5 = this.a;
            int r6 = CreationComponent.n;
            y r7 = (y) r5.k.getValue();
            if (r7 == null) goto L9;
            e r8 = r7.h();
            if (r8 == null) goto L9;
            if (ic8.n.v(r8) != true) goto L9;
            boolean r9 = true;
        L10:
            if (r9 == false) goto L15;
            u7 r10 = (u7) r5.j.getValue();
            if (r10 == null) goto L15;
            r10.TP(true);
        L15:
            return Unit.INSTANCE;
        L9:
            r9 = false;
            goto L10
        }
    }

    public CreationComponent$bindObservers$2(CreationComponent r1, Continuation<? super CreationComponent$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationComponent$bindObservers$2(this.this$0, r3);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        Flow r6 = ICanvasService.a.c();
        if (r6 == null) goto L14;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L14;
        return r0;
    }
}
