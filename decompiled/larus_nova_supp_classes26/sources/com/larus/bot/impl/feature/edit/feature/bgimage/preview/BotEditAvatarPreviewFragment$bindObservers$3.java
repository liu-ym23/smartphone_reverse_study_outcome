package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewFragment$bindObservers$3", f = "BotEditAvatarPreviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BotEditAvatarPreviewFragment$bindObservers$3 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BotEditAvatarPreviewFragment this$0;

    public BotEditAvatarPreviewFragment$bindObservers$3(BotEditAvatarPreviewFragment r1, Continuation<? super BotEditAvatarPreviewFragment$bindObservers$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotEditAvatarPreviewFragment$bindObservers$3(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Unit) r1, (Continuation) r2);
    }

    public final Object invoke(Unit r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        FragmentActivity r3 = this.this$0.getActivity();
        if (r3 == null) goto L8;
        r3.finish();
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
