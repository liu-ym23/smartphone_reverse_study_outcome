package com.ss.android.lark.keyboard.biz.send.inject;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.send.inject.SendInnerEndPlugin", f = "SendInnerEndPlugin.kt", i = {0, 0, 0}, l = {196, 210}, m = "uploadResource", n = {"chatId", "uploadId", "entity"}, s = {"L$0", "L$1", "L$2"})
final class SendInnerEndPlugin$uploadResource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SendInnerEndPlugin this$0;

    public SendInnerEndPlugin$uploadResource$1(SendInnerEndPlugin r1, Continuation<? super SendInnerEndPlugin$uploadResource$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Target.SIZE_ORIGINAL;
        return SendInnerEndPlugin.j(this.this$0, null, null, null, null, this);
    }
}
