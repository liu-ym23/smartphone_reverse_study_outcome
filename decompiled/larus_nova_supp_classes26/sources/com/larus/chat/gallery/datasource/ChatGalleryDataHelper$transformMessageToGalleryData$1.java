package com.larus.chat.gallery.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.datasource.ChatGalleryDataHelper", f = "ChatGalleryDataHelper.kt", i = {0, 0, 0, 0}, l = {48}, m = "transformMessageToGalleryData", n = {"galleryContext", "message", "$this$transformMessageToGalleryData_u24lambda_u2411", "list"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class ChatGalleryDataHelper$transformMessageToGalleryData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatGalleryDataHelper this$0;

    public ChatGalleryDataHelper$transformMessageToGalleryData$1(ChatGalleryDataHelper r1, Continuation<? super ChatGalleryDataHelper$transformMessageToGalleryData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}
