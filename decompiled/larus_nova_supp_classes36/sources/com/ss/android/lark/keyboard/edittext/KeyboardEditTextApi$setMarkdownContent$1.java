package com.ss.android.lark.keyboard.edittext;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext.KeyboardEditTextApi", f = "KeyboardEditTextApi.kt", i = {}, l = {72}, m = "setMarkdownContent", n = {}, s = {})
final class KeyboardEditTextApi$setMarkdownContent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    public KeyboardEditTextApi$setMarkdownContent$1(c r1, Continuation<? super KeyboardEditTextApi$setMarkdownContent$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Target.SIZE_ORIGINAL;
        c r5 = this.this$0;
        r5.getClass();
        int r1 = this.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L5;
        this.label = r1 - Target.SIZE_ORIGINAL;
        KeyboardEditTextApi$setMarkdownContent$1 r0 = this;
    L6:
        Object r6 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 != 0) goto L9;
        ResultKt.throwOnFailure(r6);
        boolean r7 = false;
    L15:
        return Boxing.boxBoolean(r7);
    L9:
        if (r2 != 1) goto L12;
        ResultKt.throwOnFailure(r6);
        r7 = ((Boolean) r6).booleanValue();
        goto L15
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r0 = new KeyboardEditTextApi$setMarkdownContent$1(r5, this);
        goto L6
    }
}
