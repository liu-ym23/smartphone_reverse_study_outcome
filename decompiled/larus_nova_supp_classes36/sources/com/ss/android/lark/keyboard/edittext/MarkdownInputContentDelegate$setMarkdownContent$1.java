package com.ss.android.lark.keyboard.edittext;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext.MarkdownInputContentDelegate", f = "MarkdownInputContentDelegate.kt", i = {}, l = {17}, m = "setMarkdownContent", n = {}, s = {})
final class MarkdownInputContentDelegate$setMarkdownContent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ f this$0;

    public MarkdownInputContentDelegate$setMarkdownContent$1(f r1, Continuation<? super MarkdownInputContentDelegate$setMarkdownContent$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        return this.this$0.b(this);
    }
}
