package com.larus.bmhome.view.actionbar.segment;

import com.larus.bmhome.view.actionbar.segment.vm.CommentBotState;
import com.larus.bmhome.view.actionbar.segment.vm.CommentOutViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.segment.CommentBotSegmentHolder$bind$1", f = "CommentBotSegment.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
final class CommentBotSegmentHolder$bind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CommentOutViewModel $vm;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CommentBotSegmentHolder this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CoroutineScope a;
        public final /* synthetic */ CommentOutViewModel b;
        public final /* synthetic */ CommentBotSegmentHolder c;

        public a(CoroutineScope r1, CommentOutViewModel r2, CommentBotSegmentHolder r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object emit(Object r8, Continuation r9) {
            CommentBotState r10 = (CommentBotState) r8;
            FLogger r11 = FLogger.a;
            r11.i("ComponentViewModel", "collect comment state by flow vm " + this.a + "@CommentOutViewModel");
            CommentBotState r0 = this.b.realTimeState();
            if (Intrinsics.areEqual(r0.getBotId(), r10.getBotId()) == false) goto L10;
            if (r0.getCommentCount() == r10.getCommentCount()) goto L10;
            r11.i("ComponentViewModel", "collect comment state by flow vm " + this.a + "@CommentOutViewModel change");
            this.b.updateCommentCount(r10.getCommentCount(), false);
            this.c.getClass();
            throw null;
        L10:
            return Unit.INSTANCE;
        }
    }

    public CommentBotSegmentHolder$bind$1(CommentOutViewModel r1, CommentBotSegmentHolder r2, Continuation<? super CommentBotSegmentHolder$bind$1> r3) {
        this.$vm = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CommentBotSegmentHolder$bind$1 r0 = new CommentBotSegmentHolder$bind$1(this.$vm, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r7);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        CommentOutViewModel.Companion.getClass();
        MutableSharedFlow r2 = CommentOutViewModel.access$getFlowForUpdateComment$cp();
        a r3 = new a(r8, this.$vm, this.this$0);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
