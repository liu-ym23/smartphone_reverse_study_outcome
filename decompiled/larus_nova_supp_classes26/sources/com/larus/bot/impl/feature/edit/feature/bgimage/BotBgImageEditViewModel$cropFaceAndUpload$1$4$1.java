package com.larus.bot.impl.feature.edit.feature.bgimage;

import com.larus.bmhome.bot.bean.ImageUploadResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.BotBgImageEditViewModel$cropFaceAndUpload$1$4$1", f = "BotBgImageEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BotBgImageEditViewModel$cropFaceAndUpload$1$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageUploadResult $it;
    int label;
    final /* synthetic */ BotBgImageEditViewModel this$0;

    public BotBgImageEditViewModel$cropFaceAndUpload$1$4$1(BotBgImageEditViewModel r1, ImageUploadResult r2, Continuation<? super BotBgImageEditViewModel$cropFaceAndUpload$1$4$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BotBgImageEditViewModel$cropFaceAndUpload$1$4$1(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        BotBgImageEditViewModel r5 = this.this$0;
        String r0 = this.$it.getUploadUrl();
        String r1 = "";
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        String r2 = this.$it.getUploadUri();
        if (r2 == null) goto L11;
        r1 = r2;
    L11:
        r5.k(r0, r1);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
