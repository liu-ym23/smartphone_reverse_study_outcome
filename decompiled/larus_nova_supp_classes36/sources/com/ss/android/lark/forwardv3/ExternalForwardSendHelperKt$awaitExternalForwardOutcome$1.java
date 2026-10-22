package com.ss.android.lark.forwardv3;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.forwardv3.ExternalForwardSendHelperKt", f = "ExternalForwardSendHelper.kt", i = {}, l = {96}, m = "awaitExternalForwardOutcome", n = {}, s = {})
public final class ExternalForwardSendHelperKt$awaitExternalForwardOutcome$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public ExternalForwardSendHelperKt$awaitExternalForwardOutcome$1(Continuation<? super ExternalForwardSendHelperKt$awaitExternalForwardOutcome$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Target.SIZE_ORIGINAL;
        return ExternalForwardSendHelperKt.a(0, null, this);
    }
}
