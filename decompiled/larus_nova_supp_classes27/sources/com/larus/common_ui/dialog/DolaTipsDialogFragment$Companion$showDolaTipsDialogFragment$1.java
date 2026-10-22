package com.larus.common_ui.dialog;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common_ui.dialog.DolaTipsDialogFragment$Companion", f = "DolaTipsDialogFragment.kt", i = {}, l = {99}, m = "showDolaTipsDialogFragment", n = {}, s = {})
public final class DolaTipsDialogFragment$Companion$showDolaTipsDialogFragment$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DolaTipsDialogFragment.Companion this$0;

    public DolaTipsDialogFragment$Companion$showDolaTipsDialogFragment$1(DolaTipsDialogFragment.Companion r1, Continuation<? super DolaTipsDialogFragment$Companion$showDolaTipsDialogFragment$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
