package com.larus.uaigc.chat.markdown.video.statemanager;

import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.creative.loading.CreationQueuingTaskUIState;
import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.video.statemanager.VideoQueuingState$observeQueuingUIStateChange$1", f = "VideoQueuingState.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
final class VideoQueuingState$observeQueuingUIStateChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VideoQueuingState this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ VideoQueuingState a;

        public a(VideoQueuingState r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            cp8.a r6 = (cp8.a) ((CreationQueuingTaskUIState) r4).taskQueuingUIStateMap.get(this.a.g);
            if (r6 == null) goto L9;
            VideoQueuingState r7 = this.a;
            FLogger.a.d("VideoQueuingState", "observedQueuingUIStateChange queueId " + r7.g + ", loadingText is " + r6.a);
            ISketchLoadingController r8 = r7.b;
            String r9 = r6.a;
            if (r9 != null) goto L7;
            r9 = "";
        L7:
            r8.c(r9);
        L9:
            return Unit.INSTANCE;
        }
    }

    public VideoQueuingState$observeQueuingUIStateChange$1(VideoQueuingState r1, Continuation<? super VideoQueuingState$observeQueuingUIStateChange$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VideoQueuingState$observeQueuingUIStateChange$1(this.this$0, r3);
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
    L14:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        i1 r6 = (i1) this.this$0.c.getValue();
        if (r6 == null) goto L16;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L14;
        return r0;
    L16:
        return Unit.INSTANCE;
    }
}
