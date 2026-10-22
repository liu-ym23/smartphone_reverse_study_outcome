package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewFragment", f = "BotEditAvatarPreviewFragment.kt", i = {}, l = {501}, m = "saveAvatarBitmap", n = {}, s = {})
public final class BotEditAvatarPreviewFragment$saveAvatarBitmap$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BotEditAvatarPreviewFragment this$0;

    public BotEditAvatarPreviewFragment$saveAvatarBitmap$1(BotEditAvatarPreviewFragment r1, Continuation<? super BotEditAvatarPreviewFragment$saveAvatarBitmap$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        BotEditAvatarPreviewFragment r3 = this.this$0;
        int r0 = BotEditAvatarPreviewFragment.p;
        return r3.Z90(null, this);
    }
}
