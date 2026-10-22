package com.ss.android.lark.myai.chat.keyboardtop;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.myai.chat.quickactions.QuickActionsTemplateFormatter;
import com.ss.android.lark.myai.chat.quickactions.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/text/SpannableStringBuilder;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.myai.chat.keyboardtop.QuickActionsInputState$isValidQuickActionsTemplate$newSpanned$1", f = "QuickActionsInputState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class QuickActionsInputState$isValidQuickActionsTemplate$newSpanned$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SpannableStringBuilder>, Object> {
    int label;
    final /* synthetic */ a this$0;

    public QuickActionsInputState$isValidQuickActionsTemplate$newSpanned$1(a r1, Continuation<? super QuickActionsInputState$isValidQuickActionsTemplate$newSpanned$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new QuickActionsInputState$isValidQuickActionsTemplate$newSpanned$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super SpannableStringBuilder> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L5;
        ResultKt.throwOnFailure(r2);
        int r3 = b.a;
        a r4 = this.this$0;
        Intrinsics.checkNotNullParameter(r4, "quickActionsInputState");
        System.nanoTime();
        new SpannableStringBuilder();
        new QuickActionsTemplateFormatter();
        r4.getClass();
        new ArrayList();
        throw null;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
