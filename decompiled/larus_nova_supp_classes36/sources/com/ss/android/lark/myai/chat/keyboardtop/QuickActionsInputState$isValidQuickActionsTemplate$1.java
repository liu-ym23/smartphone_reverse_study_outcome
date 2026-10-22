package com.ss.android.lark.myai.chat.keyboardtop;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.myai.chat.keyboardtop.QuickActionsInputState", f = "QuickActionsInputState.kt", i = {}, l = {43}, m = "isValidQuickActionsTemplate", n = {}, s = {})
final class QuickActionsInputState$isValidQuickActionsTemplate$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public QuickActionsInputState$isValidQuickActionsTemplate$1(a r1, Continuation<? super QuickActionsInputState$isValidQuickActionsTemplate$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Target.SIZE_ORIGINAL;
        a r8 = this.this$0;
        r8.getClass();
        int r1 = this.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L5;
        this.label = r1 - Target.SIZE_ORIGINAL;
        QuickActionsInputState$isValidQuickActionsTemplate$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L12;
        if (r4 != 1) goto L11;
        ResultKt.throwOnFailure(r2);
    L15:
        ((SpannableStringBuilder) r2).toString();
        Intrinsics.throwUninitializedPropertyAccessException("quickActionSpannableString");
        throw null;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r2);
        CoroutineDispatcher r5 = Dispatchers.getDefault();
        QuickActionsInputState$isValidQuickActionsTemplate$newSpanned$1 r6 = new QuickActionsInputState$isValidQuickActionsTemplate$newSpanned$1(r8, null);
        r0.label = 1;
        r2 = BuildersKt.withContext(r5, r6, r0);
        if (r2 != r3) goto L15;
        return r3;
    L5:
        r0 = new QuickActionsInputState$isValidQuickActionsTemplate$1(r8, this);
        goto L6
    }
}
