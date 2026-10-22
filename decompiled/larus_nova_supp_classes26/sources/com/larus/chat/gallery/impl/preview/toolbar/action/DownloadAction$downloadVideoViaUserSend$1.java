package com.larus.chat.gallery.impl.preview.toolbar.action;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.DownloadAction", f = "DownloadAction.kt", i = {0, 0, 0, 0, 0}, l = {568}, m = "downloadVideoViaUserSend", n = {"ctx", "data", "videoPlayData", "messageId", "clickMethod"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class DownloadAction$downloadVideoViaUserSend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadAction this$0;

    public DownloadAction$downloadVideoViaUserSend$1(DownloadAction r1, Continuation<? super DownloadAction$downloadVideoViaUserSend$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DownloadAction r3 = this.this$0;
        int r0 = DownloadAction.c;
        return r3.c(null, null, null, this);
    }
}
