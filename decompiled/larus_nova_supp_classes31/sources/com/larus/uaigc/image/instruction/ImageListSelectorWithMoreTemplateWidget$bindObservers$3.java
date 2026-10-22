package com.larus.uaigc.image.instruction;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.larus.bmhome.creative.utils.ImageTemplateChooseViewModel;
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
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.image.instruction.ImageListSelectorWithMoreTemplateWidget$bindObservers$3", f = "ImageListSelectorWithMoreTemplateWidget.kt", i = {}, l = {363}, m = "invokeSuspend", n = {}, s = {})
final class ImageListSelectorWithMoreTemplateWidget$bindObservers$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ImageListSelectorWithMoreTemplateWidget this$0;

    public ImageListSelectorWithMoreTemplateWidget$bindObservers$3(ImageListSelectorWithMoreTemplateWidget r1, Continuation<? super ImageListSelectorWithMoreTemplateWidget$bindObservers$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageListSelectorWithMoreTemplateWidget$bindObservers$3(this.this$0, r3);
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
        if (r1 != 1) goto L7;
        FragmentActivity r2 = (FragmentActivity) this.L$0;
        ResultKt.throwOnFailure(r7);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        ImageListSelectorWithMoreTemplateWidget r8 = this.this$0;
        int r3 = ImageListSelectorWithMoreTemplateWidget.o;
        Fragment r9 = r8.getFragment();
        if (r9 == null) goto L16;
        FragmentActivity r10 = r9.getActivity();
        if (r10 == null) goto L16;
        ImageListSelectorWithMoreTemplateWidget r4 = this.this$0;
        i1 r5 = new ViewModelProvider(r10).get(ImageTemplateChooseViewModel.class).getImageTemplateChooseStatus();
        ImageListSelectorWithMoreTemplateWidget$bindObservers$3$1$1 r6 = new ImageListSelectorWithMoreTemplateWidget$bindObservers$3$1$1(r4, null);
        this.L$0 = r10;
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r5, r6, this) != r0) goto L16;
        return r0;
    }
}
