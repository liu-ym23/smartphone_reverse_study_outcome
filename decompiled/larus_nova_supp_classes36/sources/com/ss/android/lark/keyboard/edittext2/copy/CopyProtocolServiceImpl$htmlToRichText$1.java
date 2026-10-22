package com.ss.android.lark.keyboard.edittext2.copy;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext2.copy.CopyProtocolServiceImpl", f = "CopyProtocolServiceImpl.kt", i = {}, l = {30}, m = "htmlToRichText-gIAlu-s", n = {}, s = {})
public final class CopyProtocolServiceImpl$htmlToRichText$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CopyProtocolServiceImpl this$0;

    public CopyProtocolServiceImpl$htmlToRichText$1(CopyProtocolServiceImpl r1, Continuation<? super CopyProtocolServiceImpl$htmlToRichText$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        Object r3 = this.this$0.a(null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
