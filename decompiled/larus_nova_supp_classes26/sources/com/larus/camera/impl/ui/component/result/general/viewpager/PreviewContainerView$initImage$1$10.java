package com.larus.camera.impl.ui.component.result.general.viewpager;

import android.view.View;
import com.larus.camera.impl.databinding.LarusLayoutPreviewContainerBinding;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.PreviewContainerView$initImage$1$10", f = "PreviewContainerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PreviewContainerView$initImage$1$10 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ PreviewContainerView this$0;

    public PreviewContainerView$initImage$1$10(PreviewContainerView r1, Continuation<? super PreviewContainerView$initImage$1$10> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        PreviewContainerView$initImage$1$10 r0 = new PreviewContainerView$initImage$1$10(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r2);
        if (this.Z$0 == false) goto L11;
        LarusLayoutPreviewContainerBinding r3 = this.this$0.d;
        if (r3 == null) goto L17;
        View r4 = r3.a;
        if (r4 == null) goto L17;
        e1.o(r4);
    L17:
        return Unit.INSTANCE;
    L11:
        LarusLayoutPreviewContainerBinding r5 = this.this$0.d;
        if (r5 == null) goto L17;
        View r6 = r5.a;
        if (r6 == null) goto L17;
        e1.x(r6);
        goto L17
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
