package com.ss.android.lark.keyboard.edittext;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext.FunctionEditTextCopyCoordinator", f = "FunctionEditTextCopyCoordinator.kt", i = {0}, l = {157}, m = "withPasteStrategy", n = {"atEditor"}, s = {"L$0"})
final class FunctionEditTextCopyCoordinator$withPasteStrategy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public FunctionEditTextCopyCoordinator$withPasteStrategy$1(b r1, Continuation<? super FunctionEditTextCopyCoordinator$withPasteStrategy$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        return b.a(this.this$0, null, this);
    }
}
