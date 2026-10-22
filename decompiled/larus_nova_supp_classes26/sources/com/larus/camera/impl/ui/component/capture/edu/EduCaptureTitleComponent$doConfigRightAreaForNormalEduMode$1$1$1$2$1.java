package com.larus.camera.impl.ui.component.capture.edu;

import com.larus.camera.impl.widget.title.TitleRightIconView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.edu.EduCaptureTitleComponent$doConfigRightAreaForNormalEduMode$1$1$1$2$1", f = "EduCaptureTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EduCaptureTitleComponent$doConfigRightAreaForNormalEduMode$1$1$1$2$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ TitleRightIconView $iconView;
    /* synthetic */ int I$0;
    int label;

    public EduCaptureTitleComponent$doConfigRightAreaForNormalEduMode$1$1$1$2$1(TitleRightIconView r1, Continuation<? super EduCaptureTitleComponent$doConfigRightAreaForNormalEduMode$1$1$1$2$1> r2) {
        this.$iconView = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        EduCaptureTitleComponent$doConfigRightAreaForNormalEduMode$1$1$1$2$1 r0 = new EduCaptureTitleComponent$doConfigRightAreaForNormalEduMode$1$1$1$2$1(this.$iconView, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        final int r4 = this.I$0;
        this.$iconView.setIcon(new j0(r4));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
