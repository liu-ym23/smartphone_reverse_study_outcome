package com.larus.uaigc.chat.markdown.video.statemanager;

import android.widget.ImageView;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationSingleVideoBinding;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.video.statemanager.VideoSuccessState$refreshStatus$1", f = "VideoSuccessState.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
final class VideoSuccessState$refreshStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ i this$0;

    public VideoSuccessState$refreshStatus$1(i r1, Continuation<? super VideoSuccessState$refreshStatus$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VideoSuccessState$refreshStatus$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        this.this$0.a().hide();
        LarusWidgetMarkdownCreationSingleVideoBinding r5 = this.this$0.d0();
        if (r5 == null) goto L16;
        VideoPlayView r6 = r5.i;
        if (r6 == null) goto L16;
        r6.setAlpha(1.0f);
    L16:
        LarusWidgetMarkdownCreationSingleVideoBinding r7 = this.this$0.d0();
        if (r7 == null) goto L21;
        ImageView r8 = r7.b;
        if (r8 == null) goto L21;
        r8.setAlpha(1.0f);
    L21:
        LarusWidgetMarkdownCreationSingleVideoBinding r9 = this.this$0.d0();
        if (r9 == null) goto L27;
        ImageView r10 = r9.d;
        if (r10 == null) goto L27;
        r10.setAlpha(1.0f);
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L11;
        return r0;
    }
}
