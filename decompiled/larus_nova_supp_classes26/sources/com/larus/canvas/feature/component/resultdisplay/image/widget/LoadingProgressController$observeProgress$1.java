package com.larus.canvas.feature.component.resultdisplay.image.widget;

import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.canvas.feature.component.logic.loading.CanvasProgressState;
import com.larus.utils.logger.FLogger;
import java.util.Map;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.resultdisplay.image.widget.LoadingProgressController$observeProgress$1", f = "LoadingProgressController.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
final class LoadingProgressController$observeProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ s this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ s a;

        public a(s r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            int r5 = ((Number) r3).intValue();
            FLogger.a.d("CanvasLoadingProgressController", "id: " + this.a.e + ", progress is " + r5);
            ((ISketchLoadingController) this.a.c.getValue()).setProgress(r5);
            return Unit.INSTANCE;
        }
    }

    public LoadingProgressController$observeProgress$1(s r1, String r2, Continuation<? super LoadingProgressController$observeProgress$1> r3) {
        this.this$0 = r1;
        this.$id = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LoadingProgressController$observeProgress$1(this.this$0, this.$id, r4);
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
    L18:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        FLogger.a.d("CanvasLoadingProgressController", "observeProgress, id: " + this.this$0.e);
        CanvasProgressState r6 = (CanvasProgressState) this.this$0.b.invoke();
        if (r6 == null) goto L20;
        Map<String, i1<Integer>> r7 = r6.flowMap;
        if (r7 == null) goto L20;
        i1<Integer> r8 = r7.get(this.$id);
        if (r8 == null) goto L20;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r2, this) != r0) goto L18;
        return r0;
    L20:
        return Unit.INSTANCE;
    }
}
