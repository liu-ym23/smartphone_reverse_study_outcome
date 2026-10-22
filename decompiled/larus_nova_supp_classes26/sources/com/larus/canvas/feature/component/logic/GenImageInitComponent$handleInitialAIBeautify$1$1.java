package com.larus.canvas.feature.component.logic;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.larus.canvas.feature.redirect.ImageRemoveDialogResultReceiverViewModel;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImageInitComponent$handleInitialAIBeautify$1$1", f = "GenImageInitComponent.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
final class GenImageInitComponent$handleInitialAIBeautify$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GenImageInitComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ GenImageInitComponent a;

        public a(GenImageInitComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            ImageEditDataWithMask r3 = (ImageEditDataWithMask) r1;
            com.larus.canvas.feature.component.input.b0 r4 = (com.larus.canvas.feature.component.input.b0) this.a.t.getValue();
            if (r4 == null) goto L6;
            r4.Ss(r3);
        L6:
            return Unit.INSTANCE;
        }
    }

    public GenImageInitComponent$handleInitialAIBeautify$1$1(GenImageInitComponent r1, Continuation<? super GenImageInitComponent$handleInitialAIBeautify$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GenImageInitComponent$handleInitialAIBeautify$1$1(this.this$0, r3);
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
    L20:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        FragmentActivity r6 = s1a.a.c(this.this$0).getActivity();
        if (r6 == null) goto L11;
        ImageRemoveDialogResultReceiverViewModel r7 = (ImageRemoveDialogResultReceiverViewModel) new ViewModelProvider(r6).get(ImageRemoveDialogResultReceiverViewModel.class);
        if (r7 == null) goto L22;
        kotlinx.coroutines.flow.d1<ImageEditDataWithMask> r8 = r7.getImageRemoveResultFlow();
        if (r8 == null) goto L22;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r2, this) != r0) goto L20;
        return r0;
    L22:
        return Unit.INSTANCE;
    L11:
        return Unit.INSTANCE;
    }
}
