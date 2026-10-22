package com.obric.miniapp.view;

import com.bytedance.ai.view.input.FloatingSpeakerView;
import com.larus.utils.logger.FLogger;
import com.obric.miniapp.databinding.MiniAppFragmentBinding;
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
@DebugMetadata(c = "com.obric.miniapp.view.MiniAppFragment$floatingSpeakerController$1$updateInputOffset$1", f = "MiniAppFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MiniAppFragment$floatingSpeakerController$1$updateInputOffset$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $offset;
    int label;
    final /* synthetic */ MiniAppFragment$floatingSpeakerController$1 this$0;
    final /* synthetic */ MiniAppFragment this$1;

    public MiniAppFragment$floatingSpeakerController$1$updateInputOffset$1(int r1, MiniAppFragment$floatingSpeakerController$1 r2, MiniAppFragment r3, Continuation<? super MiniAppFragment$floatingSpeakerController$1$updateInputOffset$1> r4) {
        this.$offset = r1;
        this.this$0 = r2;
        this.this$1 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MiniAppFragment$floatingSpeakerController$1$updateInputOffset$1(this.$offset, this.this$0, this.this$1, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r4);
        FLogger.a.d("FloatingSpeaker", "updateInputOffset " + this.$offset);
        final MiniAppFragment$floatingSpeakerController$1 r5 = this.this$0;
        if (r5.d <= 0) goto L7;
        final MiniAppFragment r0 = this.this$1;
        final int r1 = this.$offset;
        r5.g = new e0(r0, r5, r1);
    L13:
        return Unit.INSTANCE;
    L7:
        MiniAppFragmentBinding r2 = this.this$1.f;
        if (r2 == null) goto L13;
        FloatingSpeakerView r3 = r2.c;
        if (r3 == null) goto L13;
        r3.setMarginBottom(this.$offset);
        r5.c = r3.getBottom() - r3.getMarginBottom();
        goto L13
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
