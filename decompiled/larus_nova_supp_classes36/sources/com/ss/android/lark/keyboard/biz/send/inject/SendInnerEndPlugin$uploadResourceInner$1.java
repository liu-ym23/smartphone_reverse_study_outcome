package com.ss.android.lark.keyboard.biz.send.inject;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.send.inject.SendInnerEndPlugin", f = "SendInnerEndPlugin.kt", i = {0, 0}, l = {231}, m = "uploadResourceInner", n = {"uploadId", "entity"}, s = {"L$0", "L$1"})
public final class SendInnerEndPlugin$uploadResourceInner$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SendInnerEndPlugin this$0;

    public SendInnerEndPlugin$uploadResourceInner$1(SendInnerEndPlugin r1, Continuation<? super SendInnerEndPlugin$uploadResourceInner$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Target.SIZE_ORIGINAL;
        SendInnerEndPlugin r0 = this.this$0;
        SendInnerEndPlugin.a r9 = SendInnerEndPlugin.q;
        return r0.m(null, null, null, null, null, this);
    }
}
