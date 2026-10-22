package com.larus.uaigc.chat.block.widget.video;

import com.larus.common_ui.video.VideoPlayView;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationSingleVideoBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.widget.video.LocalVideoSuccessViewBinder$bindObservers$2", f = "LocalVideoSuccessViewBinder.kt", i = {}, l = {465}, m = "invokeSuspend", n = {}, s = {})
final class LocalVideoSuccessViewBinder$bindObservers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ nr9.g $videoPlayData;
    int label;
    final /* synthetic */ LocalVideoSuccessViewBinder this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ nr9.g a;
        public final /* synthetic */ LocalVideoSuccessViewBinder b;

        public a(nr9.g r1, LocalVideoSuccessViewBinder r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r3, Continuation r4) {
            Pair r5 = (Pair) r3;
            String r6 = this.a.a;
            if (r6 == null) goto L28;
            LocalVideoSuccessViewBinder r0 = this.b;
            int r1 = LocalVideoSuccessViewBinder.l;
            kh8.a r2 = r0.d();
            if (r2 == null) goto L8;
            String r7 = r2.b();
        L10:
            if (Intrinsics.areEqual(r7, r6) == true) goto L13;
            return Unit.INSTANCE;
        L13:
            if (Intrinsics.areEqual(r5.getFirst(), this.a.a) == false) goto L27;
            this.b.b = !((Boolean) r5.getSecond()).booleanValue();
            LocalVideoSuccessViewBinder r8 = this.b;
            if (r8.b == false) goto L21;
            LarusWidgetMarkdownCreationSingleVideoBinding r9 = r8.d0();
            if (r9 == null) goto L27;
            VideoPlayView r10 = r9.i;
            if (r10 == null) goto L27;
            VideoPlayView.z(r10, 0, 2);
            goto L27
        L21:
            LarusWidgetMarkdownCreationSingleVideoBinding r11 = r8.d0();
            if (r11 == null) goto L27;
            VideoPlayView r12 = r11.i;
            if (r12 == null) goto L27;
            VideoPlayView.H(r12, 0, 2);
        L27:
            return Unit.INSTANCE;
        L8:
            r7 = null;
            goto L10
        L28:
            return Unit.INSTANCE;
        }
    }

    public LocalVideoSuccessViewBinder$bindObservers$2(LocalVideoSuccessViewBinder r1, nr9.g r2, Continuation<? super LocalVideoSuccessViewBinder$bindObservers$2> r3) {
        this.this$0 = r1;
        this.$videoPlayData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LocalVideoSuccessViewBinder$bindObservers$2(this.this$0, this.$videoPlayData, r4);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        LocalVideoSuccessViewBinder r7 = this.this$0;
        int r2 = LocalVideoSuccessViewBinder.l;
        kh8.a r8 = r7.d();
        if (r8 == null) goto L18;
        MutableSharedFlow r9 = r8.i();
        if (r9 == null) goto L18;
        a r3 = new a(this.$videoPlayData, this.this$0);
        this.label = 1;
        if (r9.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
