package com.obric.assistant.view;

import com.obric.assistant.common.ui.progressbar.CustomUpdateCircleProgressBar;
import com.obric.assistant.impl.databinding.ObricUpdateBannerBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.view.ObricUpdateBannerPopupWindow$obricUpdateListener$1$onProgress$1", f = "ObricUpdateBannerPopupWindow.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricUpdateBannerPopupWindow$obricUpdateListener$1$onProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $progress;
    int label;
    final /* synthetic */ ObricUpdateBannerPopupWindow this$0;

    public ObricUpdateBannerPopupWindow$obricUpdateListener$1$onProgress$1(ObricUpdateBannerPopupWindow r1, int r2, Continuation<? super ObricUpdateBannerPopupWindow$obricUpdateListener$1$onProgress$1> r3) {
        this.this$0 = r1;
        this.$progress = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricUpdateBannerPopupWindow$obricUpdateListener$1$onProgress$1(this.this$0, this.$progress, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        ObricUpdateBannerBinding r4 = this.this$0.g;
        if (r4 == null) goto L10;
        CustomUpdateCircleProgressBar r5 = r4.f;
        if (r5 == null) goto L10;
        r5.setProgress(this.$progress);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
