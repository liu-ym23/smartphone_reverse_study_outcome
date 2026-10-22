package com.larus.uaigc.createpage.component.inspiration;

import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
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
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.inspiration.ImgInspirationListComponent$observeEvents$2", f = "ImgInspirationListComponent.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
final class ImgInspirationListComponent$observeEvents$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImgInspirationListComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ImgInspirationListComponent a;

        public a(ImgInspirationListComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            final ry9.j r5 = (ry9.j) r3;
            FLogger.a.d("ImgInspirationListComponent", "mediaSelectorStatus " + r5);
            final ImgInspirationListComponent r6 = this.a;
            t0.e(new s(r5, r6));
            return Unit.INSTANCE;
        }
    }

    public ImgInspirationListComponent$observeEvents$2(ImgInspirationListComponent r1, Continuation<? super ImgInspirationListComponent$observeEvents$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImgInspirationListComponent$observeEvents$2(this.this$0, r3);
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
        ry9.g r6 = (ry9.g) this.this$0.s.getValue();
        if (r6 == null) goto L18;
        i1<ry9.j> r7 = r6.D20();
        if (r7 == null) goto L18;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
