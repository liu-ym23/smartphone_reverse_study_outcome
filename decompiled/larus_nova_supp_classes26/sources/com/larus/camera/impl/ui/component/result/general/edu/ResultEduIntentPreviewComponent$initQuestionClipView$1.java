package com.larus.camera.impl.ui.component.result.general.edu;

import com.larus.camera.impl.ui.component.result.general.n;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/camera/impl/ui/component/result/general/ResultDetectStatus;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.edu.ResultEduIntentPreviewComponent$initQuestionClipView$1", f = "ResultEduIntentPreviewComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultEduIntentPreviewComponent$initQuestionClipView$1 extends SuspendLambda implements Function2<n, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ResultEduIntentPreviewComponent this$0;

    public ResultEduIntentPreviewComponent$initQuestionClipView$1(ResultEduIntentPreviewComponent r1, Continuation<? super ResultEduIntentPreviewComponent$initQuestionClipView$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ResultEduIntentPreviewComponent$initQuestionClipView$1(this.this$0, r3);
    }

    public final Object invoke(n r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((n) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        FLogger.a.i("ResultEduIntentPreviewComponent", "[initQuestionClipView] resultDetectionStatus changed");
        ResultEduIntentPreviewComponent r4 = this.this$0;
        int r0 = ResultEduIntentPreviewComponent.s;
        r4.r();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
