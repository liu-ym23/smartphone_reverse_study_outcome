package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewFragment", f = "BotEditAvatarPreviewFragment.kt", i = {0, 1}, l = {485, 487}, m = "getAndSaveAvatarBitmap", n = {"$this$getAndSaveAvatarBitmap_u24lambda_u2435_u24lambda_u2433", "$this$getAndSaveAvatarBitmap_u24lambda_u2435_u24lambda_u2433"}, s = {"L$0", "L$0"})
final class BotEditAvatarPreviewFragment$getAndSaveAvatarBitmap$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BotEditAvatarPreviewFragment this$0;

    public BotEditAvatarPreviewFragment$getAndSaveAvatarBitmap$1(BotEditAvatarPreviewFragment r1, Continuation<? super BotEditAvatarPreviewFragment$getAndSaveAvatarBitmap$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return BotEditAvatarPreviewFragment.U90(this.this$0, null, this);
    }
}
