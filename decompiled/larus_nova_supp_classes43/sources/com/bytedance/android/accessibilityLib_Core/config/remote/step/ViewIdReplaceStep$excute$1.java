package com.bytedance.android.accessibilityLib_Core.config.remote.step;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0002H\u0096@"}, d2 = {"", "args", "Lkotlin/coroutines/Continuation;", "", "Lcom/bytedance/android/accessibilityLib_Core/config/remote/dsl/f;", "continuation", "", "excute"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.config.remote.step.ViewIdReplaceStep", f = "ViewIdReplaceStep.kt", i = {0}, l = {69, 70}, m = "excute", n = {"this"}, s = {"L$0"})
public final class ViewIdReplaceStep$excute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ViewIdReplaceStep this$0;

    public ViewIdReplaceStep$excute$1(ViewIdReplaceStep r1, Continuation r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
