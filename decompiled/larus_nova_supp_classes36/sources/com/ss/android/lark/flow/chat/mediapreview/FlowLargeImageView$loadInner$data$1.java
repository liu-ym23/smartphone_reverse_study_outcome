package com.ss.android.lark.flow.chat.mediapreview;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import nlb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/imagewidget/largeimage/LocalLoadInfo;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageView$loadInner$data$1", f = "FlowLargeImageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowLargeImageView$loadInner$data$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g>, Object> {
    final /* synthetic */ g $info;
    int label;
    final /* synthetic */ FlowLargeImageView this$0;

    public FlowLargeImageView$loadInner$data$1(FlowLargeImageView r1, g r2, Continuation<? super FlowLargeImageView$loadInner$data$1> r3) {
        this.this$0 = r1;
        this.$info = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowLargeImageView$loadInner$data$1(this.this$0, this.$info, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super g> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        FlowLargeImageView r4 = this.this$0;
        g r0 = this.$info;
        int r1 = FlowLargeImageView.o;
        r4.u(r0);
        return r0;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
